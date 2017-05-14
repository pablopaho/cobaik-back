package co.com.akku.bikes.services

import co.com.akku.bikes.models.Bike
import scala.concurrent.{Future}


trait BikesQueriesServices {
  def bikes(): Future[Seq[Bike]]
}
