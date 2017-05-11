package co.com.akku.bikes.dao

import javax.inject._
import scala.concurrent.{ ExecutionContext, Future }
import javax.inject.Inject

import co.com.akku.bikes.models.Bike
import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfigProvider
import slick.jdbc.JdbcProfile


@Singleton
class BikesDAOImpl @Inject() extends BikesDAO {
  def getBikes(): Seq[String] = {
    ???
  }
}
