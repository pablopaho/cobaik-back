package co.com.cobaik.calendar.json

import co.com.cobaik.calendar.json.objects.{CreateAvailability, CreateSlot}
import play.api.libs.json.Json

object Formats {
  implicit val createSlotFormat             = Json.format[CreateSlot]
  implicit val createAvailabilityFormat     = Json.format[CreateAvailability]
}
