package co.com.cobaik.bikes.services

import co.com.cobaik.bikes.categories.models.Category
import co.com.cobaik.bikes.location.models.CobaikLocation

import scala.concurrent.Future

trait BikesCommandsService {
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
  def addBikeAccessories(bikeId: Int, properties: Map[String, String], bikeCategory: Category): Future[Int]

  /**
    *
    * @param bikeId
    * @param pictures
    * @return Retorna el id de la bicicleta.
    */
  def addBikePhotos(bikeId: Int, pictures: List[Array[Byte]]): Future[Int]

  /**
    *
    * @param bikeId
    * @param pictures
    * @return
    */
  def addBikeEngageInfo(bikeId: Int, pictures: List[Array[Byte]]): Future[Int]
}
