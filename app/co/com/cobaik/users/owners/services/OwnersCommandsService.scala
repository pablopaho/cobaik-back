package co.com.cobaik.users.owners.services

import co.com.cobaik.bikes.location.models.CobaikLocation
import co.com.cobaik.bikes.models.Bike
import scala.concurrent.{ExecutionContext, Future}

import scala.concurrent.Future


trait OwnersCommandsService {
  def createOwner(userId: Int): Future[Int]
}
