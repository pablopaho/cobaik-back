package co.com.cobaik.payments.json

import co.com.cobaik.payments.json.objects.CreateTransactionBike
import co.com.cobaik.calendar.json.objects.CreateSlot

import play.api.libs.json.Json

object Formats {
  implicit val createSlotFormat    = Json.format[CreateSlot]
  implicit val createPaymentFormat = Json.format[CreateTransactionBike]
}
