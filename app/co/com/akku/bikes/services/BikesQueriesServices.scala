package co.com.akku.bikes.services

import co.com.akku.bikes.models.Bike

trait BikesQueriesServices {
  def bikes(): Seq[Bike]
}
