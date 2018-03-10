package co.com.cobaik.calendar

import javax.inject.Inject

import co.com.cobaik.calendar.services.CalendarProviderService
import co.com.cobaik.users.owners.services.OwnersServiceProvider
import play.api.libs.json.Json
import play.api.mvc._
import play.api.libs.Files

import scala.concurrent.{ExecutionContext, Future}


trait CalendarDependenciesController extends Controller with CalendarProviderService {
  val calendarCommandService = calendarService
}

class CalendarController @Inject()(implicit executionContext: ExecutionContext) extends CalendarDependenciesController{
  def createAvailabilityOnCalendar() = Action.async {
    val userId = 1
    Future(1).map(el => Ok(Json.toJson(el)) )
    //val l: Future[Int] = calendarCommandService.createAvailabilityOnCalendar()
    //l.map(result => Ok(Json.toJson(result)))
    //???
  }
}
