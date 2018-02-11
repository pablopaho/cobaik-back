package co.com.cobaik.users.owners.services

import scala.concurrent.Future


trait OwnersCommandsService {
  def createOwner(userId: Int): Future[Int]
}
