package co.com.cobaik.calendar.json

import co.com.cobaik.calendar.json.objects.{CreateAvailability, CreateSlot, CreateReservation}
import play.api.libs.json.Json

object Formats {
  implicit val createSlotFormat             = Json.format[CreateSlot]
  implicit val createAvailabilityFormat     = Json.format[CreateAvailability]
  implicit val createReservationFormat      = Json.format[CreateReservation]
}
