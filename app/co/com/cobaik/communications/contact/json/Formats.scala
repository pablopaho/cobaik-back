package co.com.cobaik.communications.contact.json

import co.com.cobaik.communications.contact.models.Contact
import play.api.libs.json.Json

object Formats {
  implicit val contactFormat = Json.format[Contact]
}
