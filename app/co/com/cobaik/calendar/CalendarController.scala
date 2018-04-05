package co.com.cobaik.calendar

import co.com.cobaik.calendar.json.objects.{CreateAvailability, CreateReservation}
import co.com.cobaik.calendar.services.CalendarProviderService
import co.com.cobaik.calendar.json.Formats._

import play.api.libs.json.Json
import play.api.mvc._
import javax.inject.Inject
import scala.concurrent.{ExecutionContext}


trait CalendarDependenciesController extends Controller with CalendarProviderService {
  val calendarCommandService = calendarService
}
class CalendarController @Inject()(implicit executionContext: ExecutionContext) extends CalendarDependenciesController{

  def createAvailabilityOnCalendar(): Action[CreateAvailability] = Action.async(parse.json[CreateAvailability]) { req =>
    val createAvailability = req.body
    val resultF = calendarCommandService.createAvailabilityOnCalendar(createAvailability)
    resultF.map(el => Ok(Json.toJson(el)))
  }

  def createReservationOnCalendar(): Action[CreateReservation] = Action.async(parse.json[CreateReservation]) { req =>
    val createReservation = req.body
    val resultF = calendarCommandService.createReservationOnCalendar(createReservation)
    resultF.map(el => Ok(Json.toJson(el)))
  }

}
