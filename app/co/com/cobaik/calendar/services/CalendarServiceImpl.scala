package co.com.cobaik.calendar.services

import co.com.cobaik.calendar.models.Availability

import scala.concurrent.{ExecutionContext, Future}
import scala.concurrent.ExecutionContext.Implicits.global


trait CalendarServiceImpl extends CalendarService{
  def createAvailabilityOnCalendar(availability: Availability) : Future[List[Int]] = {
    Future(List(1,2,3))
  }
}
