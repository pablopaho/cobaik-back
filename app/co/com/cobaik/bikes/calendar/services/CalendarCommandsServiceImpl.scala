package co.com.cobaik.bikes.calendar.services

import scala.concurrent.Future
import co.com.cobaik.bikes.calendar.models.{BikeAvailability, Slot}

trait CalendarCommandsServiceImpl extends CalendarCommandsService {
  /**
    * Método utilizado para crear la disponibilidad de una bicicleta.
    * @param bikeAvailability: Una lista de slots que representan la disponibilidad.
    * @return el id asociado a un conjunto de slots de disponibilidad. Sirve para mas
    *         adelante pensar en borrar la disponibilidad de una bicicleta
    *         fácilmente por parte del dueño.
    */
  def createBikeAvailability(bikeAvailability: List[Slot]): Future[Int] = {
    ???
  }

  /**
    * Método utilizado para ver disponibilidad de una bicicleta.
    * Se calculan los slots restando el total menos los reservados.
    * @param bikeId
    * @return una lista de disponibilidad de una bici.
    */
  def getBikeAvailability(bikeId : Int): Future[List[Slot]] = {
    ???
  }
}

object CalendarCommandsServiceImpl extends CalendarCommandsServiceImpl
