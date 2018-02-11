package co.com.cobaik.bikes.services

import javax.inject.{Inject, Singleton}

import co.com.cobaik.bikes.categories.models.Category
import co.com.cobaik.bikes.dao.BikesDAO
import co.com.cobaik.bikes.location.models.CobaikLocation
import co.com.cobaik.bikes.models.Bike

import scala.concurrent.Future

@Singleton
class BikesCommandsServicesImpl @Inject() (bikesDao: BikesDAO) extends BikesCommandsServices {
  def insertBike(bike:Bike): Future[Unit] = {
    bikesDao.insertBike(bike)
  }

  def createBikeLocation(ownerId: Int, cobaikLocation: CobaikLocation): Future[Int] = ???

  /**
    *
    * @param bikeId
    * @param bikeCategory
    * @return Retorna el id de la bike id
    */

  def addBikeCategory(bikeId: Int, bikeCategory: Category): Future[Int] = ???

  /**
    *
    * @param bikeId
    * @param properties
    * @return Retorna el id de la bicicleta.
    */
  def addBikeAccessories(bikeId: Int, properties: Map[String, String]): Future[Int] = ???

  /**
    *
    * @param bikeId
    * @param pictures
    * @return Retorna el id de la bicicleta.
    */
  def addBikePhotos(bikeId: Int, pictures: List[Array[Byte]]): Future[Int] = ???

  /**
    *
    * @param bikeId
    * @param content
    * @return
    */
  def addBikeEngageInfo(bikeId: Int, content: String): Future[Int] = ???
}
