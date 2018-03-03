package co.com.cobaik.bikes

import co.com.cobaik.bikes.services.{BikesCommandsServices, BikesQueriesServices}
import app.co.com.akku.bikes.location.json.Formats._
import app.co.com.akku.bikes.json.Formats._
import co.com.cobaik.bikes.models.Bike
import co.com.cobaik.bikes.json.objects.CreateAccesories
import co.com.cobaik.bikes.json.objects.{BikeDetail, BikeSearchDetail, BikesQuery}
import co.com.cobaik.bikes.location.json.objects.CreateBike
import co.com.cobaik.bikes.location.models.CobaikLocation

import play.api.libs.json.Json
import play.api.mvc._
import javax.inject._
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class BikesController @Inject()(bikesService: BikesQueriesServices, bikesCommandService: BikesCommandsServices)
                               (implicit executionContext: ExecutionContext) extends Controller {

  def bikes = Action.async {
    val bikes: Future[Seq[Bike]] = bikesService.bikes()
    bikes.map(result => Ok(Json.toJson(result)))
  }

  def insertBike: Action[Bike] = Action.async(parse.json[Bike]) { req =>
    val bike: Bike = req.body
    bikesService.insertBike(bike).map(_ => Ok)
  }

  //TODO: debe asumir para la busqueda de bicicletas, ademas de la ubicacion, se necesita fecha actual y fecha actual mas 1 dia
  def getAvailableBikes(): Action[CobaikLocation] = Action.async(parse.json[CobaikLocation]) { req =>
    val bikeProperties  = Map("property1" -> "property1", "property2" -> "property2")
    val availableBikesF = Future {
        List(BikeSearchDetail(id=1,
                              brand="trek",
                              reference="sl1200",
                              categoryDescription = "Ruta",
                              price = 15000,
                              properties = bikeProperties,
                              imageUrl = "https://i.pinimg.com/564x/e7/71/1b/e7711bc974f9fda8d7c231cfb58c1dc5.jpg",
                              cobaikLocation = CobaikLocation(latitude = 6.2530408F,longitude = -75.56457369999998F, cityDescription = "Medellin"),
                              description = "Una cuca de bicicleta papa"),
             BikeSearchDetail(id=2,
                              brand="Giant",
                              reference="sl1300",
                              categoryDescription = "Montaña",
                              price = 20000,
                              properties = bikeProperties,
                              imageUrl = "https://i.pinimg.com/564x/e7/71/1b/e7711bc974f9fda8d7c231cfb58c1dc5.jpg",
                              cobaikLocation = CobaikLocation(latitude = 4.710988599999999F,longitude = -74.072092F, cityDescription = "Bogota"),
                              description = "Una cuca de bicicleta papa"),
             BikeSearchDetail(id=3,
                              brand="Scott",
                              reference="sl1200",
                              categoryDescription = "Urbana",
                              price = 25000,
                              properties = bikeProperties,
                              imageUrl = "https://i.pinimg.com/564x/e7/71/1b/e7711bc974f9fda8d7c231cfb58c1dc5.jpg",
                              cobaikLocation = CobaikLocation(latitude = 3.4516467F,longitude = -76.5319854F, cityDescription = "Cali"),
                              description = "Una cuca de bicicleta papa")
        )
    }
    availableBikesF.map(result => Ok(Json.toJson(result)))
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
          cobaik_location = CobaikLocation(latitude = 3.4516467F,longitude = -76.5319854F, cityDescription = "Cali"),
          description = "Una cuca de bicicleta papa")
      }
    _bikeDetailF.map(result => Ok(Json.toJson(result)))
  }

  def createBike: Action[CreateBike] = Action.async(parse.json[CreateBike]) { req =>
    val bike: CreateBike = req.body
    //bikesCommandService.createBikeLocation()
    ???
  }

  def addBikeAccessories(bikeId: Int): Action[CreateAccesories] = Action.async(parse.json[CreateAccesories]) { req =>
    val createAccesories = req.body
    val bikeIdF = bikesCommandService.addBikeAccessories(bikeId, createAccesories)
    bikeIdF.map(bikeId => Ok(Json.toJson(bikeId)))
  }
}
