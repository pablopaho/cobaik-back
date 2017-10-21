package co.com.cobaik.bikes.dao

import scala.concurrent.{Future}
import co.com.cobaik.bikes.models.Bike

trait BikesDAO {
  def getBikes(): Future[Seq[Bike]]
  def insertBike(bike: Bike): Future[Unit]
}
