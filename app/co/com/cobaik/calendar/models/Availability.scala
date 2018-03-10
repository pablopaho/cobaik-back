package co.com.cobaik.calendar.models

import co.com.cobaik.bikes.models.BikeV2
import co.com.cobaik.users.owners.models.Owner


trait Availability {
  def owner: Owner
  def bike: BikeV2
  def slots: List[Slot]
}

case class BikeAvailability(owner: Owner, bike: BikeV2, slots: List[Slot]) extends Availability

object Availability {
  def apply(owner: Owner, bike: BikeV2, slots: List[Slot]) = {
    BikeAvailability(owner, bike, slots)
  }
}