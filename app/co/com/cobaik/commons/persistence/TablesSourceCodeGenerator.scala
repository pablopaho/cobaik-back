package co.com.cobaik.commons.persistence

import slick.codegen.SourceCodeGenerator
import slick.model.Model

class TablesSourceCodeGenerator(m: Model) extends SourceCodeGenerator(m) {


  override def packageCode(profile: String, pkg: String, container: String="Tables", parentType: Option[String]) : String = {
    "// scalastyle:off\n" + // Para que esto no lo tenga en cuenta scalastyle
      s"""
    package ${pkg}
    import org.joda.time.DateTime
    // AUTO-GENERATED Slick data model

    /** Stand-alone Slick data model for immediate use */
    object ${container} extends {
      val profile = $profile
    } with ${container}

    /** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
    trait ${container} {
      val profile: ${profile}.type
      import profile.api._
      ${indent(code)}
  }

  ${tables.map(defTypeCode).mkString("\n\n")}
      """.trim()+ "\n" +
      "// scalastyle:on" // Para que esto no lo tenga en cuenta scalastyle
  }

  override def code = {
    super.code
  }

  def defTypeCode(table: Table) = table.EntityType.docWithCode

  override def entityName = dbTableName => {
    val name = dbTableName match {
      case _ => dbTableName.capitalize
    }
    s"${name}Row"
  }

  override def tableName = dbTableName => s"${dbTableName.capitalize}Table"

  override def Table = new WTableDef(_)

  class WTableDef(t: slick.model.Table) extends super.TableDef(t) {
    override def definitions = Seq[Def]( PlainSqlMapper, TableClass, TableValue )

    // override contained column generator
    override def Column = new Column(_){

      override def defaultCode = v => {
        rawType match {
          case "Float" => s"$v.toFloat" // fix para https://github.com/slick/slick/issues/1000
          case _ => super.defaultCode(v)
        }
      }

      // use the data model member of this column to change the Scala type, e.g. to a custom enum or anything else
      override def rawType = {
        model.tpe match {
          case "scala.math.BigDecimal"  => "Float"
          case "java.sql.Date"     => "DateTime"
          case "java.sql.Timestamp"     => "DateTime"
          case _ => super.rawType
        }
      }
    }
  }

}
