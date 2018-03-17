package co.com.cobaik.payments.json

import co.com.cobaik.payments.json.objects.CreateTransactionBike
import play.api.libs.json.Json

object Formats {
  implicit val createPaymentFormat             = Json.format[CreateTransactionBike]
}
