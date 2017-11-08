package co.com.cobaik.journey.services

import co.com.cobaik.journey.models.Journey

import scala.concurrent.Future

trait JourneysCommandsServiceImpl extends JourneysCommandsService {
  def createJourney(journey: Journey) : Future[Int] = {
    ???
  }

  def getJourney(journeyId: Int) : Future[Journey] = {
    ???
  }
}

object JourneysCommandsServiceImpl extends JourneysCommandsServiceImpl