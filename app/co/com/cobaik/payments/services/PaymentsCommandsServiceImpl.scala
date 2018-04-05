package co.com.cobaik.payments.services

import co.com.cobaik.payments.json.objects.CreateTransactionBike
import co.com.cobaik.users.owners.services.OwnersServiceProvider
import co.com.cobaik.users.cyclists.services.CyclistServiceProvider
import co.com.cobaik.bikes.services.BikesQueriesServicesProvider
import co.com.cobaik.journey.models.BikeJourney
import co.com.cobaik.journey.services.JourneysServiceProvider
import co.com.cobaik.payments.models.TransactionBike

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global


trait PaymentsCommandsServiceImpl extends PaymentsCommandsService
    with OwnersServiceProvider
    with CyclistServiceProvider
    with BikesQueriesServicesProvider
    with JourneysServiceProvider
{
  def createPayment(createPayment: CreateTransactionBike): Future[Int] = {
    val journeyId = 1
    val transactionId = 1
    for {
      owner   <- ownersQueriesService.getOwner(createPayment.ownerId)
      cyclist <- cyclistQueriesService.getCyclist(createPayment.cyclistId)
      bike    <- bikesQueriesService.getBike(createPayment.bikeId)
      transactionId <- createTransaction(createPayment)
    }yield {
      createJourney(BikeJourney(journeyId, owner, cyclist, bike, createPayment.reservations, toTransaction(transactionId, createPayment)))
    }
    ???
  }

  def createTransaction(createTransaction : CreateTransactionBike): Future[Int] = {
    Future{1}
  }

  private def createJourney(bikeJourney: BikeJourney) : Future[Int] = {
    journeysCommandsService.createJourney(bikeJourney)
  }

  private def toTransaction(transactionId: Int, createTransaction : CreateTransactionBike): TransactionBike = {
    TransactionBike(transactionId, createTransaction.taxesPayment, createTransaction.paymentValue,
                    createTransaction.cyclistId, createTransaction.ownerId, createTransaction.bikeId)
  }

}
object PaymentsCommandsServiceImpl extends PaymentsCommandsServiceImpl
