package co.com.cobaik.bikes.categories.json

import co.com.cobaik.bikes.categories.models.Category
import play.api.libs.json.Json


object Formats {
  implicit val categoryFormat = Json.format[Category]
}
