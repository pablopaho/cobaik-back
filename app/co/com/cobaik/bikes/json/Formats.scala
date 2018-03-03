package app.co.com.akku.bikes.json

import co.com.cobaik.bikes.json.objects.{BikeDescription, BikeDetail, BikeSearchDetail, BikesQuery}
import co.com.cobaik.bikes.models.Bike
import play.api.libs.json.{Json, OFormat}
import app.co.com.akku.bikes.location.json.Formats._
import co.com.cobaik.bikes.location.json.objects.CreateBike


object Formats {
  implicit val bikeFormat = Json.format[Bike]
  implicit val bikeSearchDetailFormat = Json.format[BikeSearchDetail]
  implicit val bikeDetailFormat = Json.format[BikeDetail]
  implicit val bikesQueryFormat: OFormat[BikesQuery] = Json.format[BikesQuery]
  implicit val createBikeFormat = Json.format[CreateBike]
  implicit val bikeDescription = Json.format[BikeDescription]
}
