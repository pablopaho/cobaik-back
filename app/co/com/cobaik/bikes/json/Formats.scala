package app.co.com.akku.bikes.json

import co.com.cobaik.bikes.json.objects.{BikeDetail, BikeSearchDetail, BikesQuery}
import co.com.cobaik.bikes.models.Bike
import play.api.libs.json.{Json, OFormat}
import app.co.com.akku.bikes.location.json.Formats._


object Formats {
  implicit val bikeFormat = Json.format[Bike]
  implicit val bikeSearchDetailFormat = Json.format[BikeSearchDetail]
  implicit val bikeDetailFormat = Json.format[BikeDetail]
  implicit val bikesQueryFormat: OFormat[BikesQuery] = Json.format[BikesQuery]

}
