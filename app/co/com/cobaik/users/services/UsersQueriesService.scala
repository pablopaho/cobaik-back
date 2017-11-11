package co.com.cobaik.users.services

import co.com.cobaik.users.models.User

import scala.concurrent.Future

trait UsersQueriesService {
  def getUser(id: Int): Future[User]
}
