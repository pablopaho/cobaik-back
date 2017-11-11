package co.com.cobaik.commons.persistence

import java.sql.{PreparedStatement, ResultSet}

import com.github.tminglei.slickpg.PgHStoreSupport
import slick.jdbc.PostgresProfile

import scala.reflect.ClassTag

trait CobaikPgHstoreSupport extends PgHStoreSupport { driver: PostgresProfile =>
  import driver.api._
  trait CobaikHStoreImplicits extends HStoreImplicits {

    val Equal = "=>"
    val Separator =  ";"

    def map2str(map: Map[String, String]): String = {
      map.foldLeft(new StringBuilder) { case (sb, (k, v)) => sb.append(s"$Separator$k$Equal$v")}.toString() match {
        case str if str.length > 0 => str.tail
        case str => str
      }
    }

    def str2map(str: String): Map[String,String] = {
      str.split(Separator).foldLeft(Map[String, String]()) { (map, s) =>
        val arr = s.split(Equal)
        if(arr.length == 2) {
          val k = arr(0)
          val v = arr(1)
          map + ((k, v))
        } else {
          map
        }
      }
    }

    class CustomHStoreMapper[T](sqlTypeName: String,
                                fnFromString: String => T,
                                fnToString: T => String = (r: T) => r.toString,
                                sqlType: Int = java.sql.Types.OTHER,
                                override val hasLiteralForm: Boolean = false)
                               (implicit classTag: ClassTag[T])
      extends GenericJdbcType[T](sqlTypeName, fnFromString, fnToString, sqlType, hasLiteralForm) {

      override def setValue(v: T, p: PreparedStatement, idx: Int): Unit = p.setString(idx, toStr(v))
      override def updateValue(v: T, r: ResultSet, idx: Int): Unit = r.updateString(idx, toStr(v))
      //noinspection ScalaStyle
      private def toStr(v: T): String = if(v == null) null else fnToString(v)

    }

    implicit override val simpleHStoreTypeMapper: GenericJdbcType[Map[String,String]] = new CustomHStoreMapper[Map[String, String]](
      "varchar",
      str2map,
      map2str,
      sqlType = java.sql.Types.VARCHAR,
      hasLiteralForm = false
    )
  }
}
