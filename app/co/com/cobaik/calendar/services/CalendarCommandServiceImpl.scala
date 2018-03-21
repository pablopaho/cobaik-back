package co.com.cobaik.calendar.services

import co.com.cobaik.bikes.models._
import co.com.cobaik.bikes.services.BikesQueriesServicesProvider
import co.com.cobaik.calendar.json.objects.{CreateAvailability, CreateReservation, CreateSlot}
import co.com.cobaik.calendar.models.{Availability, Reserve, Slot}
import co.com.cobaik.users.cyclists.models.Cyclist
import co.com.cobaik.users.owners.models.Owner
import co.com.cobaik.users.owners.services.OwnersServiceProvider
import co.com.cobaik.users.cyclists.services.CyclistServiceProvider

import org.joda.time.DateTime
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global


trait CalendarCommandServiceImpl extends CalendarCommandService
    with OwnersServiceProvider
    with CyclistServiceProvider
    with BikesQueriesServicesProvider
{
  def createAvailabilityOnCalendar(createAvailability: CreateAvailability) : Future[Int] = {
    for{
      owner <- ownersQueriesService.getOwner(createAvailability.ownerId) 
      bike  <- bikesQueriesService.getBike(createAvailability.bikeId)
    }yield{
      val availability = Availability(owner, bike, toSlots(createAvailability.slots))
    }
    Future(1)
  }

  def createReservation(createReservation: CreateReservation): Future[Int] = {
    for{
      owner <- ownersQueriesService.getOwner(createReservation.ownerId)
      bike  <- bikesQueriesService.getBike(createReservation.bikeId)
      cylcist <- cyclistQueriesService.getCyclist(createReservation.cyclistId)
    } yield {
      val reservation = Reserve(bike,toSlots(createReservation.slots),cylcist,owner)
    }
      ???
  }

  private def toSlots(createSlots: List[CreateSlot]) : List[Slot] = {
    createSlots.map{ cs =>
      Slot(cs)
    }
  }
}

object CalendarCommandServiceImpl extends CalendarCommandServiceImpl

