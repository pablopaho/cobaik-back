package co.com.cobaik.bikes.location.json.objects

import co.com.cobaik.bikes.location.models.CobaikLocation

//todo: esto no huele como raro en esta ubicacion, un CreateBike, no debería estar en bikes?
case class CreateBike(cobaikLocation: CobaikLocation, ownerId: Int)
