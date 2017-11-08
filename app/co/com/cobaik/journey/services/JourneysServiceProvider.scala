package co.com.cobaik.journey.services

trait JourneysServiceProvider {
  def journeysCommandsService: JourneysCommandsService = JourneysCommandsServiceImpl
}
