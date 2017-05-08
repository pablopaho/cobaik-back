package co.com.akku.bikes

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json.Json

@Singleton
class BikesController @Inject() extends Controller {
  def bikes = Action {
    Ok(Json.obj("name" -> "trek 1200"))
  }
}
