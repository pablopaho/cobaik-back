package co.com.cobaik.calendar.models

import co.com.cobaik.bikes.models.BikeV2
import co.com.cobaik.users.cyclists.models.Cyclist
import co.com.cobaik.users.owners.models.Owner

trait Reserve {
 def bike: BikeV2
 def slots: List[Slot]
 def cyclist: Cyclist
 def owner: Owner
}

case class BikeReserve(bike: BikeV2, slots: List[Slot], cyclist: Cyclist, owner: Owner)

object Reserve {
 def apply(bike: BikeV2, slots:List[Slot], cyclist: Cyclist, owner: Owner) = {
   BikeReserve(bike, slots, cyclist, owner)
 }
}
