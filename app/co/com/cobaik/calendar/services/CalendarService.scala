package co.com.cobaik.calendar.services

import co.com.cobaik.calendar.models.Availability

import scala.concurrent.Future


trait CalendarService {
  def createAvailabilityOnCalendar(availability: Availability): Future[List[Int]]
}
