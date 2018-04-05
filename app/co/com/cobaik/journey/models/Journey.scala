package co.com.cobaik.journey.models

import co.com.cobaik.bikes.models.{Bike, BikeV2}
import co.com.cobaik.calendar.models.Slot
import co.com.cobaik.payments.models.Transaction
import co.com.cobaik.users.cyclists.models.Cyclist
import co.com.cobaik.users.owners.models.Owner

/**
  * RepresentaJourneysServiceProvider el viaje de a un ciclista, por un tiempo dado, asociada a un ciclista y a
  * un dueño. Ej. Yo puedo decir que quiero alquilar x bicicleta todos los lunes por un
  * mes.
   */

trait Journey {
  def id: Int
  def owner: Owner
  def cyclist: Cyclist
  def bike: BikeV2
  def reservations: List[Slot]
  def transaction: Transaction
}
case class BikeJourney(id: Int,
                       owner: Owner,
                       cyclist: Cyclist,
                       bike: BikeV2,
                       reservations: List[Slot],
                       transaction:Transaction) extends Journey
