package co.com.cobaik.calendar.services

import co.com.cobaik.bikes.models._
import co.com.cobaik.calendar.json.objects.CreateAvailability
import co.com.cobaik.calendar.models.{ Availability, Slot }
import co.com.cobaik.users.owners.models.Owner
import co.com.cobaik.users.services.UsersServiceProvider
import org.joda.time.DateTime

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global


trait CalendarCommandServiceImpl extends CalendarCommandService with UsersServiceProvider {
  def createAvailabilityOnCalendar(createAvailability: CreateAvailability) : Future[Int] = {
    //TODO - hidratar el objeto que vamos a guardar.
    for{
      owner <- usersQueriesService.getOwner(createAvailability.ownerId)
    }yield{
      val bike  = BikeV2(color = "black", wheels = Wheels(1, "27.5"), frame = Frame(1, "Carbon"),
                         group = Group(1, "shimano xtr"), bikeStyle = BikeStyle(1, "cross country"))
      val slot1 = Slot(id = 1, startDate = DateTime.now(), endDate = DateTime.now().plusYears(1))
      //TODO: no me cuadra el tema de que no tenemos id de availability
      val availability = Availability(owner, bike, List(slot1))
    }
    
    
    Future(1)
  }
}

object CalendarCommandServiceImpl extends CalendarCommandServiceImpl

