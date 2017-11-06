package co.com.cobaik.bikes.calendar.services

import scala.concurrent.Future
import co.com.cobaik.bikes.calendar.models.{BikeAvailability, Slot}

trait CalendarCommandsService {
  def createBikeAvailability(bikeAvailability: List[Slot]): Future[Int]
  def getBikeAvailability(bikeId : Int): Future[List[Slot]]

}
