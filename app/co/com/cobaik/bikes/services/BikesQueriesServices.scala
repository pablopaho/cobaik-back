package co.com.cobaik.bikes.services

import co.com.cobaik.bikes.models.{ Bike, BikeV2 }
import scala.concurrent.{Future}


trait BikesQueriesServices {

  def bikes(): Future[Seq[Bike]]
  def insertBike(bike:Bike): Future[Unit]
  def getBike(id: Int): Future[BikeV2]

}
