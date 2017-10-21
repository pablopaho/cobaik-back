package app.co.com.akku.bikes.json

import play.api.libs.json.Json
import co.com.cobaik.bikes.models.Bike


object Formats {
  implicit val bikeFormat = Json.format[Bike]
}
