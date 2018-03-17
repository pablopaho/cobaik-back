package co.com.cobaik.payments.services

import co.com.cobaik.payments.json.objects.CreateTransactionBike

import scala.concurrent.Future


trait PaymentsCommandsServiceImpl extends PaymentsCommandsService {
  def createPayment(createPayment: CreateTransactionBike): Future[Int] = {
    ???
  }
}
object PaymentsCommandsServiceImpl extends PaymentsCommandsServiceImpl