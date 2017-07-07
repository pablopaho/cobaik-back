package co.com.akku.bikes.dao

import scala.concurrent.{Future}
import co.com.akku.bikes.models.Bike

trait BikesDAO {
  def getBikes(): Future[Seq[Bike]]
  def insertBike(bike: Bike): Future[Unit]
}
