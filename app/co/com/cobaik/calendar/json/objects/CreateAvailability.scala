package co.com.cobaik.calendar.json.objects

case class CreateAvailability(ownerId: Int, bikeId: Int, slots: List[CreateSlot])


case class CreateReservation(ownerId: Int, cyclistId: Int, bikeId: Int, slots: List[CreateSlot])