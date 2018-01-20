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
      List(BikeSearchDetail(bikeId=1,
        brand="trek",
        reference="sl1200",
        categoryId = 1,
        price = 10,
        properties = bikeProperties,
        imageUrl = "https://i.pinimg.com/564x/e7/71/1b/e7711bc974f9fda8d7c231cfb58c1dc5.jpg"),
        BikeSearchDetail(bikeId=2,
          brand="trek",
          reference="sl1200",
          categoryId = 1,
          price = 10,
          properties = bikeProperties,
          imageUrl = "https://i.pinimg.com/564x/e7/71/1b/e7711bc974f9fda8d7c231cfb58c1dc5.jpg"),
        BikeSearchDetail(bikeId=3,
          brand="trek",
          reference="sl1200",
          categoryId = 1,
          price = 10,
          properties = bikeProperties,
          imageUrl = "https://i.pinimg.com/564x/e7/71/1b/e7711bc974f9fda8d7c231cfb58c1dc5.jpg"))
    }
    _availableBikesF.map(result => Ok(Json.toJson(result)))
  }

  def getBikeDetail(id: Int) = Action.async {
    val bikeProperties = Map("property1" -> "property1", "property2" -> "property2")
    val _bikeDetailF =
      Future {
        BikeDetail(bikeId=1,
          brand="trek",
          reference="sl1200",
          categoryId = 1,
          price = 10,
          properties = bikeProperties,
          imageUrl = "https://i.pinimg.com/564x/e7/71/1b/e7711bc974f9fda8d7c231cfb58c1dc5.jpg")
      }
    _bikeDetailF.map(result => Ok(Json.toJson(result)))
  }
}
