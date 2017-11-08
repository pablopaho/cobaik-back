package co.com.cobaik.users.owners.models

import co.com.cobaik.bikes.calendar.models.Slot

/**
  * Representa la disponibilidad de una bicicleta dada por un dueño.
  *
  * @param ownerId
  * @param bikeId
  * @param availableSlots: Lista de slots o cajones de tiempo en los cuales se encuentra disponible la bici
  *                      a lo airbnb, cuando el dueño dice cuando esta disponible.
  */
case class BikeAvailability(id: Int, ownerId: Int, bikeId: Int, availableSlots: List[Slot])


