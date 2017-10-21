package app.co.com.akku.contact.json

import play.api.libs.json.Json
import co.com.cobaik.contact.models.Contact

object Formats {
  implicit val contactFormat = Json.format[Contact]
}
