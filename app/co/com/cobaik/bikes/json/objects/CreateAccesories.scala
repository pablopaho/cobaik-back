package co.com.cobaik.bikes.json.objects

import co.com.cobaik.bikes.models.{ BikeStyle, Frame, Group, Wheels }


case class CreateAccesories(wheels: Wheels, frame : Frame, group : Group, bikeStyle: BikeStyle)
