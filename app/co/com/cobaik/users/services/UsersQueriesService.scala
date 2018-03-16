package co.com.cobaik.users.services

import co.com.cobaik.users.models.User
import co.com.cobaik.users.owners.models.Owner

import scala.concurrent.Future

trait UsersQueriesService {
  def getUser(id: Int): Future[User]
  def getOwner(id: Int): Future[Owner]
}
