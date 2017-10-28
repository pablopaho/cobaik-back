package co.com.cobaik.users.persistence

import co.com.cobaik.users.models.User

import scala.concurrent.Future

trait UsersPersistence {
  def createUser(user: User): Future[Int]
  def getUser(id: Int): Future[User]
}
