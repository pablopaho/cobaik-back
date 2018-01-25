package co.com.cobaik.bikes

import co.com.cobaik.bikes.services.BikesQueriesServices
import app.co.com.akku.bikes.location.json.Formats._

import app.co.com.akku.bikes.json.Formats._
import co.com.cobaik.bikes.models.Bike
import javax.inject._

import play.api.libs.json.Json
import co.com.cobaik.bikes.json.objects.{BikeDetail, BikeSearchDetail, BikesQuery}
import co.com.cobaik.bikes.location.models.CobaikLocation
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class BikesController @Inject() (bikesService: BikesQueriesServices)(implicit executionContext: ExecutionContext) extends Controller {
  def bikes = Action.async {
    val bikes: Future[Seq[Bike]] = bikesService.bikes()
    bikes.map(result => Ok(Json.toJson(result)))
  }

  def insertBike: Action[Bike] = Action.async(parse.json[Bike]) { req =>
    val bike: Bike = req.body
    bikesService.insertBike(bike).map(_ => Ok)
  }

  def availableBikes(): Action[CobaikLocation] = Action.async(parse.json[CobaikLocation]) { req =>
    val _availableBikesF = Future {
      val bikeProperties = Map("property1" -> "property1", "property2" -> "property2")
      List(BikeSearchDetail(bike_id=1,
        brand="trek",
        reference="sl1200",
        category_description = "Ruta",
        price = 15000,
        properties = bikeProperties,
        image_url = "https://i.pinimg.com/564x/e7/71/1b/e7711bc974f9fda8d7c231cfb58c1dc5.jpg",
        cobaik_location = CobaikLocation(latitude = 6.2530408F,longitude = -75.56457369999998F, city_description = "Medellin"),
        description = "Una cuca de bicicleta papa"),
        BikeSearchDetail(bike_id=2,
          brand="trek",
          reference="sl1200",
          category_description = "Montaña",
          price = 20000,
          properties = bikeProperties,
          image_url = "https://i.pinimg.com/564x/e7/71/1b/e7711bc974f9fda8d7c231cfb58c1dc5.jpg",
          cobaik_location = CobaikLocation(latitude = 4.710988599999999F,longitude = -74.072092F, city_description = "Bogota"),
          description = "Una cuca de bicicleta papa"),

        BikeSearchDetail(bike_id=3,
          brand="trek",
          reference="sl1200",
          category_description = "Urbana",
          price = 25000,
          properties = bikeProperties,
          image_url = "https://i.pinimg.com/564x/e7/71/1b/e7711bc974f9fda8d7c231cfb58c1dc5.jpg",
          cobaik_location = CobaikLocation(latitude = 3.4516467F,longitude = -76.5319854F, city_description = "Cali"),
          description = "Una cuca de bicicleta papa"))
    }
    _availableBikesF.map(result => Ok(Json.toJson(result)))
  }

  def getBikeDetail(id: Int) = Action.async {
    val bikeProperties = Map("property1" -> "property1", "property2" -> "property2")
    val _bikeDetailF =
      Future {
        BikeDetail(bike_id=3,
          brand="trek",
          reference="sl1200",
          category_description = "Urbana",
          price = 25000,
          properties = bikeProperties,
          image_url = "https://i.pinimg.com/564x/e7/71/1b/e7711bc974f9fda8d7c231cfb58c1dc5.jpg",
          cobaik_location = CobaikLocation(latitude = 3.4516467F,longitude = -76.5319854F, city_description = "Cali"),
          description = "Una cuca de bicicleta papa")
      }
    _bikeDetailF.map(result => Ok(Json.toJson(result)))
  }
}
