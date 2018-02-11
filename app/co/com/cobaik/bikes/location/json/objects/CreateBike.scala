package co.com.cobaik.bikes.location.json.objects

import co.com.cobaik.bikes.location.models.CobaikLocation

case class CreateBike(cobaikLocation: CobaikLocation, ownerId: Int)
