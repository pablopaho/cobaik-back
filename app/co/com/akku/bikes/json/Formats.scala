package app.co.com.akku.bikes.json

import play.api.libs.json.Json
import co.com.akku.bikes.models.Bike


object Formats {
  implicit val bikeFormat = Json.format[Bike]
}
