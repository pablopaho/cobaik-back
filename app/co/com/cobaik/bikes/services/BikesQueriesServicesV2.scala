package co.com.cobaik.bikes.services

import co.com.cobaik.bikes.models.{ Bike, BikeV2 }
import scala.concurrent.{Future}


trait BikesQueriesServicesV2 {

  def getBike(id: Int): Future[BikeV2]

}
