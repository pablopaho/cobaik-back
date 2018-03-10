package co.com.cobaik.bikes.services

import co.com.cobaik.bikes.categories.models.Category
import co.com.cobaik.bikes.location.models.CobaikLocation
import co.com.cobaik.bikes.json.objects.CreateAccesories

import play.api.libs.Files.TemporaryFile
import play.api.mvc.MultipartFormData.FilePart
import scala.concurrent.Future

trait BikesCommandsServices {
  def createBikeLocation(ownerId: Int, cobaikLocation: CobaikLocation): Future[Int]

  /**
    *
    * @param bikeId
    * @param bikeCategory
    * @return Retorna el id de la bike id
    */

  def addBikeCategory(bikeId: Int, bikeCategory: Category): Future[Int]

  /**
    *
    * @param bikeId
    * @param properties
    * @return Retorna el id de la bicicleta.
    */
  def addBikeAccessories(bikeId: Int, createAccesories: CreateAccesories): Future[Int]
  /**
    *
    * @param bikeId
    * @param pictures
    * @return Retorna el id de la bicicleta.
    */
  def addBikePhotos(bikeId: Int, pictures: List[FilePart[TemporaryFile]]): Future[Int]

  /**
    *
    * @param bikeId
    * @param content
    * @return
    */
  def addBikeEngageInfo(bikeId: Int, content: String): Future[Int]
}
