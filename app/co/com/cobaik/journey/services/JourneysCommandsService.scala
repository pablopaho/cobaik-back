package co.com.cobaik.journey.services

import co.com.cobaik.journey.models.Journey

import scala.concurrent.Future

trait JourneysCommandsService {
  def createJourney(journey: Journey) : Future[Int]

  def getJourney(journeyId: Int) : Future[Journey]
}
