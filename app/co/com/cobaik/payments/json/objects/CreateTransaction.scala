package co.com.cobaik.payments.json.objects

import co.com.cobaik.calendar.models.Slot

case class CreateTransactionBike (cyclistId    : Int,
                                  ownerId      : Int,
                                  bikeId       : Int,
                                  paymentValue : Float,
                                  taxesPayment : Float,
                                  reservations : List[Slot])
