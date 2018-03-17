package co.com.cobaik.payments

import javax.inject.Inject

import co.com.cobaik.payments.services.PaymentsCommandsServiceProvider
import play.api.libs.json.Json
import play.api.mvc._
import co.com.cobaik.payments.json.Formats._

import co.com.cobaik.payments.json.objects.CreateTransactionBike

import scala.concurrent.{ExecutionContext}


trait PaymentsDependenciesController extends Controller with PaymentsCommandsServiceProvider {
  val paymentsServiceProvider = paymentCommandsServiceImpl
}

class PaymentsController @Inject()(implicit executionContext: ExecutionContext) extends PaymentsDependenciesController{
  def createPayment: Action[CreateTransactionBike] = Action.async(parse.json[CreateTransactionBike]) { req =>
    val cratePayment: CreateTransactionBike = req.body
    val resultF = paymentsServiceProvider.createPayment(cratePayment)
    resultF.map(result => Ok(Json.toJson(result)))
  }
}
