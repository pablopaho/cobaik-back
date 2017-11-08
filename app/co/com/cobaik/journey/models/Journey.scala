package co.com.cobaik.journey.models

import co.com.cobaik.bikes.calendar.models.Slot
import co.com.cobaik.bikes.models.Bike

/**
  * Representa el viaje o el momento en cual se alquila una bicicleta de un owner a un ciclista, por un tiempo dado.
  * asociada a un ciclista y a un dueño. Ej. Yo puedo decir que quiero alquilar x bicicleta todos los lunes por un mes.
  * @param id
  * @param bike
  * @param reservations momento o momentos por los cuales reservo/rento la bici. Ej. Los lunes por un mes.
  */
case class Journey (id: Int, ownerId: Int, cyclistId: Int, bike: Bike, reservations: List[Slot])
