package co.com.cobaik.calendar.services

import co.com.cobaik.bikes.models.{Bike, BikeV2}
import co.com.cobaik.calendar.json.objects.CreateAvailability
import co.com.cobaik.calendar.models.Availability
import co.com.cobaik.users.owners.models.Owner

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global


trait CalendarCommandServiceImpl extends CalendarCommandService{
  def createAvailabilityOnCalendar(createAvailability: CreateAvailability) : Future[Int] = {
    //TODO - hidratar el objeto que vamos a guardar.
    //Availability(Owner(id = 1,user_id = 1),BikeV2())
    Future(1)
  }
}

object CalendarCommandServiceImpl extends CalendarCommandServiceImpl

