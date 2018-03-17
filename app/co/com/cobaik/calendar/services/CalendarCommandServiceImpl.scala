package co.com.cobaik.calendar.services

import co.com.cobaik.bikes.models._

import co.com.cobaik.bikes.services.BikesQueriesServicesProvider
import co.com.cobaik.calendar.json.objects.{ CreateAvailability, CreateSlot, CreateReservation }
import co.com.cobaik.calendar.models.{ Availability, Slot }

import co.com.cobaik.users.owners.models.Owner
import co.com.cobaik.users.services.UsersServiceProvider
import org.joda.time.DateTime

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global


trait CalendarCommandServiceImpl extends CalendarCommandService
    with UsersServiceProvider
    with BikesQueriesServicesProvider
{
  def createAvailabilityOnCalendar(createAvailability: CreateAvailability) : Future[Int] = {
    for{
      owner <- usersQueriesService.getOwner(createAvailability.ownerId)
      bike  <- bikesQueriesService.getBike(createAvailability.bikeId)
    }yield{
      val availability = Availability(owner, bike, toSlots(createAvailability.slots))
    }
    Future(1)
  }


  def createReservation(createReservation: CreateReservation): Future[Int] = {
/*
    for{
      owner <- ???
      bike <- ???

    } */
      ???
  }

  private def toSlots(createSlots: List[CreateSlot]) : List[Slot] = {
    createSlots.map{ cs =>
      Slot(cs)
    }

  }
}

xxobject CalendarCommandServiceImpl extends CalendarCommandServiceImpl

