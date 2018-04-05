package co.com.cobaik.payments.models

trait Transaction {
  def id : Int
  def taxesPayment: Float
  def paymentValue: Float
  def totalPayment : Float = taxesPayment + paymentValue
  def cyclistId: Int
  def ownerId: Int
  def bikeId: Int
}

case class TransactionBike (id: Int,
                            taxesPayment: Float,
                            paymentValue: Float,
                            cyclistId: Int,
                            ownerId: Int,
                            bikeId: Int) extends Transaction

object Transaction {

  def apply(id: Int,
            taxesPayment: Float,
            paymentValue: Float,
            cyclistId: Int,
            ownerId: Int,
            bikeId: Int) = {
    TransactionBike (id,
      taxesPayment,
      paymentValue,
      cyclistId,
      ownerId,
      bikeId)
  }
}
