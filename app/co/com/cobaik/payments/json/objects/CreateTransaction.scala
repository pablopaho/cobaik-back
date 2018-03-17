package co.com.cobaik.payments.json.objects


case class CreateTransactionBike (taxesPayment: Float,
                            paymentValue: Float,
                            cyclistId: Int,
                            ownerId: Int,
                            bikeId: Int)