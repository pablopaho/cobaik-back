package co.com.akku.bikes

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json.Json
import co.com.akku.bikes.services.BikesQueriesServices
import  app.co.com.akku.bikes.json.Formats._


@Singleton
class BikesController @Inject() (bikesService: BikesQueriesServices) extends Controller {
  def bikes = Action {
    val bikes = bikesService.bikes()
    Ok(Json.toJson(bikes))
  }
}
