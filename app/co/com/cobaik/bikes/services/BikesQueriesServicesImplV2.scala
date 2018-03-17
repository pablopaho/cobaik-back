package co.com.cobaik.bikes.services


import co.com.cobaik.bikes.models.{ Bike, BikeStyle, BikeV2, Frame, Group, Wheels }

import scala.concurrent.{Future}
import scala.concurrent.ExecutionContext.Implicits.global

trait BikesQueriesServicesImplV2 extends BikesQueriesServicesV2 {

  def getBike(id: Int): Future[BikeV2] = {
    Future{
      BikeV2(color = "black", wheels = Wheels(1, "27.5"), frame = Frame(1, "Carbon"),
             group = Group(1, "shimano xtr"), bikeStyle = BikeStyle(1, "cross country"))
    }
  }

}

object BikesQueriesServicesImplV2 extends BikesQueriesServicesImplV2
