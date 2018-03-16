package co.com.cobaik.bikes.services

import co.com.cobaik.bikes.models.{ Bike, BikeStyle, BikeV2, Frame, Group, Wheels }
import co.com.cobaik.bikes.dao.BikesDAO

import javax.inject._
import scala.concurrent.{Future}
import scala.concurrent.ExecutionContext.Implicits.global

@Singleton
class BikesQueriesServicesImpl @Inject() (bikesDao: BikesDAO) extends BikesQueriesServices {
  def bikes(): Future[Seq[Bike]] = {
    bikesDao.getBikes()
  }

  def insertBike(bike:Bike): Future[Unit] = {
    bikesDao.insertBike(bike)
  }

  def getBike(id: Int): Future[BikeV2] = {
    Future{
      BikeV2(color = "black", wheels = Wheels(1, "27.5"), frame = Frame(1, "Carbon"),
             group = Group(1, "shimano xtr"), bikeStyle = BikeStyle(1, "cross country"))
    }
  }
}
