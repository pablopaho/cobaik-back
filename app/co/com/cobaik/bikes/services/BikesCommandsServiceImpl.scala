package co.com.cobaik.bikes.services

import co.com.cobaik.bikes.categories.models.Category
import co.com.cobaik.bikes.dao.BikesDAO
import co.com.cobaik.bikes.location.models.CobaikLocation
import co.com.cobaik.bikes.models.Bike
import co.com.cobaik.bikes.json.objects.CreateAccesories

import play.api.libs.Files.TemporaryFile
import play.api.mvc.MultipartFormData.FilePart

import scala.concurrent.Future
import javax.inject.{Inject, Singleton}
import scala.concurrent.ExecutionContext.Implicits.global

@Singleton
class BikesCommandsServicesImpl @Inject() (bikesDao: BikesDAO) extends BikesCommandsServices {
  def insertBike(bike:Bike): Future[Unit] = {
    bikesDao.insertBike(bike)
  }

  def createBikeLocation(ownerId: Int, cobaikLocation: CobaikLocation): Future[Int] = {
    Future(1)//retorna el id de la creacion de la bici
  }

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
  def addBikeAccessories(bikeId: Int, createAccesories: CreateAccesories): Future[Int] = {
    Future {
      1 //retorna el id de la bici 
    }
  }

  /**
    *
    * @param bikeId
    * @param pictures
    * @return Retorna el id de la bicicleta.
    */
  def addBikePhotos(bikeId: Int, pictures: List[FilePart[TemporaryFile]]): Future[Int] = Future(1)

  /**
    *
    * @param bikeId
    * @param content
    * @return
    */
  def addBikeEngageInfo(bikeId: Int, content: String): Future[Int] = Future(1)
}
