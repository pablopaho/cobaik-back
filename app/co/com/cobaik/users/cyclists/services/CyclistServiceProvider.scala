package co.com.cobaik.users.cyclists.services

trait CyclistServiceProvider {
  def cyclistQueriesService: CyclistQueriesServices = CyclistQueriesServicesImpl
}
