package co.com.cobaik.calendar.services

import co.com.cobaik.calendar.json.objects.CreateAvailability
import co.com.cobaik.calendar.models.Availability

import scala.concurrent.Future


trait CalendarCommandService {
  def createAvailabilityOnCalendar(createAvailability: CreateAvailability): Future[Int]
}
