package co.com.akku.bikes.dao

import scala.concurrent.{ExecutionContext,Future}
import javax.inject.Inject

import co.com.akku.bikes.models.Bike
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile

/**
  * 
  * based on https://github.com/playframework/play-slick/tree/master/samples/basic/conf
  */

class BikesDAOImpl @Inject() (protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext) extends HasDatabaseConfigProvider[JdbcProfile] with BikesDAO {
  import profile.api._
  private val Bikes = TableQuery[BikesTable]

  def getBikes(): Future[Seq[Bike]] = db.run(Bikes.result)

  def insertBike(bike: Bike): Future[Unit] = db.run(Bikes += bike).map { _ => () }

  private class BikesTable(tag: Tag) extends Table[Bike](tag, "bikes") {
    def id = column[Int]("id", O.PrimaryKey)
    def name = column[String]("name")
    def reference = column[String]("reference")

    def * = (id, name, reference) <> (Bike.tupled, Bike.unapply)
  }
}
