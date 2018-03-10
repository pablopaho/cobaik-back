package co.com.cobaik.bikes.location.json

import co.com.cobaik.bikes.location.models.CobaikLocation
import play.api.libs.json.{Json, OFormat}



object Formats {
  implicit val cobaikLocationFormat = Json.format[CobaikLocation]

}
