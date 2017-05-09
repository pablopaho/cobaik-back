package co.com.akku.bikes.services

import co.com.akku.bikes.models.Bike
import javax.inject._

@Singleton
class BikesQueriesServicesImpl extends BikesQueriesServices {
  def bikes(): Seq[Bike] = {
    List(Bike("trek", "sl1200"))
  }
}
