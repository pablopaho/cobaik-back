package co.com.cobaik.calendar.models

import co.com.cobaik.bikes.calendar.models.Slot
import co.com.cobaik.bikes.models.Bike
import co.com.cobaik.users.owners.models.Owner


trait Availability {
  def owner: Owner
  def bike: Bike
  def slots: List[Slot]
}

case class BikeAvailability(owner: Owner, bike: Bike, slots: List[Slot]) extends Availability

object Availability {
  def apply(owner: Owner, bike: Bike, slots: List[Slot]) = {
    BikeAvailability(owner, bike, slots)
  }
}