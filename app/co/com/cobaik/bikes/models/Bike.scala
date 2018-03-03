package co.com.cobaik.bikes.models

case class Bike(id: Int, name: String, reference: String)



case class BikeV2(color : String, wheels: Wheels, frame : Frame, group : Group, bikeStyle: BikeStyle )

final case class Wheels (id: Int, description: String)

final case class Frame (id: Int, description: String)

final case class Group (id: Int, description: String)

sealed trait BikeStyle {
  def style : String
}

final case class RoadBike() extends BikeStyle {
  def style = "road"
}

final case class MountainBike() extends BikeStyle {
  def style = "mountainBike"
}

final case class UrbanBike() extends BikeStyle {
  def style = "urbanBike"
}

