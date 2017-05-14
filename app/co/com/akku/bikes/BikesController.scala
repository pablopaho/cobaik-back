package co.com.akku.bikes

import javax.inject._

import play.api.mvc._
import play.api.libs.json.{Json}
import co.com.akku.bikes.services.BikesQueriesServices
import  app.co.com.akku.bikes.json.Formats._
import scala.concurrent.ExecutionContext
import co.com.akku.bikes.models.Bike

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
