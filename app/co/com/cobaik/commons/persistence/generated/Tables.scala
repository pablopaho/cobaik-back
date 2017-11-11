// scalastyle:off
package co.com.cobaik.commons.persistence.generated
    import org.joda.time.DateTime
    // AUTO-GENERATED Slick data model

    /** Stand-alone Slick data model for immediate use */
    object Tables extends {
      val profile = co.com.cobaik.commons.persistence.CobaikPGProfile
    } with Tables

    /** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
    trait Tables {
      val profile: co.com.cobaik.commons.persistence.CobaikPGProfile.type
      import profile.api._
      import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = BikesTable.schema ++ Play_evolutionsTable.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** GetResult implicit for fetching BikesRow objects using plain SQL queries */
  implicit def GetResultBikesRow(implicit e0: GR[Int], e1: GR[String]): GR[BikesRow] = GR{
    prs => import prs._
    BikesRow.tupled((<<[Int], <<[String], <<[String]))
  }
  /** Table description of table bikes. Objects of this class serve as prototypes for rows in queries. */
  class BikesTable(_tableTag: Tag) extends profile.api.Table[BikesRow](_tableTag, "bikes") {
    def * = (id, name, reference) <> (BikesRow.tupled, BikesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(name), Rep.Some(reference)).shaped.<>({r=>import r._; _1.map(_=> BikesRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(varchar) */
    val name: Rep[String] = column[String]("name")
    /** Database column reference SqlType(varchar) */
    val reference: Rep[String] = column[String]("reference")
  }
  /** Collection-like TableQuery object for table BikesTable */
  lazy val BikesTable = new TableQuery(tag => new BikesTable(tag))

  /** GetResult implicit for fetching Play_evolutionsRow objects using plain SQL queries */
  implicit def GetResultPlay_evolutionsRow(implicit e0: GR[Int], e1: GR[String], e2: GR[DateTime], e3: GR[Option[String]]): GR[Play_evolutionsRow] = GR{
    prs => import prs._
    Play_evolutionsRow.tupled((<<[Int], <<[String], <<[DateTime], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table play_evolutions. Objects of this class serve as prototypes for rows in queries. */
  class Play_evolutionsTable(_tableTag: Tag) extends profile.api.Table[Play_evolutionsRow](_tableTag, "play_evolutions") {
    def * = (id, hash, appliedAt, applyScript, revertScript, state, lastProblem) <> (Play_evolutionsRow.tupled, Play_evolutionsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(hash), Rep.Some(appliedAt), applyScript, revertScript, state, lastProblem).shaped.<>({r=>import r._; _1.map(_=> Play_evolutionsRow.tupled((_1.get, _2.get, _3.get, _4, _5, _6, _7)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(int4), PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.PrimaryKey)
    /** Database column hash SqlType(varchar), Length(255,true) */
    val hash: Rep[String] = column[String]("hash", O.Length(255,varying=true))
    /** Database column applied_at SqlType(timestamp) */
    val appliedAt: Rep[DateTime] = column[DateTime]("applied_at")
    /** Database column apply_script SqlType(text), Default(None) */
    val applyScript: Rep[Option[String]] = column[Option[String]]("apply_script", O.Default(None))
    /** Database column revert_script SqlType(text), Default(None) */
    val revertScript: Rep[Option[String]] = column[Option[String]]("revert_script", O.Default(None))
    /** Database column state SqlType(varchar), Length(255,true), Default(None) */
    val state: Rep[Option[String]] = column[Option[String]]("state", O.Length(255,varying=true), O.Default(None))
    /** Database column last_problem SqlType(text), Default(None) */
    val lastProblem: Rep[Option[String]] = column[Option[String]]("last_problem", O.Default(None))
  }
  /** Collection-like TableQuery object for table Play_evolutionsTable */
  lazy val Play_evolutionsTable = new TableQuery(tag => new Play_evolutionsTable(tag))
  }

  /** Entity class storing rows of table BikesTable
 *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
 *  @param name Database column name SqlType(varchar)
 *  @param reference Database column reference SqlType(varchar) */
final case class BikesRow(id: Int, name: String, reference: String)

/** Entity class storing rows of table Play_evolutionsTable
 *  @param id Database column id SqlType(int4), PrimaryKey
 *  @param hash Database column hash SqlType(varchar), Length(255,true)
 *  @param appliedAt Database column applied_at SqlType(timestamp)
 *  @param applyScript Database column apply_script SqlType(text), Default(None)
 *  @param revertScript Database column revert_script SqlType(text), Default(None)
 *  @param state Database column state SqlType(varchar), Length(255,true), Default(None)
 *  @param lastProblem Database column last_problem SqlType(text), Default(None) */
final case class Play_evolutionsRow(id: Int, hash: String, appliedAt: DateTime, applyScript: Option[String] = None, revertScript: Option[String] = None, state: Option[String] = None, lastProblem: Option[String] = None)
// scalastyle:on
