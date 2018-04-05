package co.com.cobaik.payments.services

import co.com.cobaik.payments.json.objects.CreateTransactionBike

import scala.concurrent.Future

trait PaymentsCommandsService {

  def createPayment(createPayment: CreateTransactionBike): Future[Int]
  def createTransaction(createTransaction : CreateTransactionBike): Future[Int]
  
}
