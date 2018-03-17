package co.com.cobaik.payments.services


trait PaymentsCommandsServiceProvider extends PaymentsCommandsServiceImpl {
  def paymentCommandsServiceImpl = PaymentsCommandsServiceImpl
}
