package app.co.com.akku.bikes.json

import co.com.cobaik.bikes.json.objects.{BikeDetail, BikeSearchDetail, BikesQuery}
import co.com.cobaik.bikes.models.Bike
import app.co.com.akku.bikes.location.json.Formats._
import co.com.cobaik.bikes.location.json.objects.CreateBike
import co.com.cobaik.bikes.json.objects.CreateAccesories
import co.com.cobaik.bikes.models.{ BikeStyle, Frame, Group, Wheels }

import play.api.libs.json.{Json, OFormat}

object Formats {
  implicit val bikeFormat             = Json.format[Bike]
  implicit val bikeSearchDetailFormat = Json.format[BikeSearchDetail]
  implicit val bikeDetailFormat       = Json.format[BikeDetail]
  implicit val bikesQueryFormat: OFormat[BikesQuery] = Json.format[BikesQuery]
  implicit val createBikeFormat       = Json.format[CreateBike]
  implicit val wheelsFormat           = Json.format[Wheels]
  implicit val frameFormat            = Json.format[Frame]
  implicit val groupFormat            = Json.format[Group]
  // implicit val roadBikeFormat         = Json.format[RoadBike]
  // implicit val mountainBikeFormat     = Json.format[MountainBike]
  // implicit val urbanBikeFormat        = Json.format[UrbanBike]
  implicit val bikeStyleFormat        = Json.format[BikeStyle]
  implicit val createAccesoriesFormat = Json.format[CreateAccesories]
}
