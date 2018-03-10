package co.com.cobaik.calendar.services

import co.com.cobaik.calendar.models.Availability

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global


trait CalendarCommandServiceImpl extends CalendarCommandService{
  def createAvailabilityOnCalendar(availability: Availability) : Future[List[Int]] = {
    Future(List(1,2,3))
  }
}

object CalendarCommandServiceImpl extends CalendarCommandServiceImpl

