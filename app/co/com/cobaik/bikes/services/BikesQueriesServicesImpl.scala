package co.com.cobaik.bikes.services

import co.com.cobaik.bikes.models.Bike
import co.com.cobaik.bikes.dao.BikesDAO

import javax.inject._
import scala.concurrent.{Future}

@Singleton
class BikesQueriesServicesImpl @Inject() (bikesDao: BikesDAO) extends BikesQueriesServices {
  def bikes(): Future[Seq[Bike]] = {
    bikesDao.getBikes()
  }

  def insertBike(bike:Bike): Future[Unit] = {
    bikesDao.insertBike(bike)
  }
}
