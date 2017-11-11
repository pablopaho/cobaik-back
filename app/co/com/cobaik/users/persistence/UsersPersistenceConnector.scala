package co.com.cobaik.users.persistence

import co.com.cobaik.users.models.User

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

trait UsersPersistenceConnector extends UsersPersistence {


  def createUser(user: User): Future[Int] = {
    Future(1)
  }
  def getUser(id: Int): Future[User] = {
    ???
  }
}

object UsersPersistenceConnector extends UsersPersistenceConnector
