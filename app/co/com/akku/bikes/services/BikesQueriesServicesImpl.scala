package co.com.akku.bikes.services

import scala.concurrent.{Future}
import co.com.akku.bikes.models.Bike
import javax.inject._
import co.com.akku.bikes.dao.BikesDAO

@Singleton
class BikesQueriesServicesImpl @Inject() (bikesDao: BikesDAO) extends BikesQueriesServices {
  def bikes(): Future[Seq[Bike]] = {
    bikesDao.getBikes()
  }

  def insertBike(bike:Bike): Future[Unit] = {
    bikesDao.insertBike(bike)
  }
}
