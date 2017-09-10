package co.com.akku.bikes

import co.com.akku.bikes.services.BikesQueriesServices
import app.co.com.akku.bikes.json.Formats._
import co.com.akku.bikes.models.Bike

import javax.inject._
import play.api.mvc._
import play.api.libs.json.{Json}
import scala.concurrent.ExecutionContext

@Singleton
class BikesController @Inject() (bikesService: BikesQueriesServices)(implicit executionContext: ExecutionContext) extends Controller {
  def bikes = Action.async {
    val bikes = bikesService.bikes()
    bikes.map(result => Ok(Json.toJson(result)))
  }

  def insertBike: Action[Bike] = Action.async(parse.json[Bike]) { req =>
    val bike: Bike = req.body
    bikesService.insertBike(bike).map(_ => Ok)
  }
}
