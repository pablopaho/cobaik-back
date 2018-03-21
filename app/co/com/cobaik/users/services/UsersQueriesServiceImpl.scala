package co.com.cobaik.users.services

import co.com.cobaik.users.models.User
import co.com.cobaik.users.owners.models.Owner
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

trait UsersQueriesServiceImpl extends UsersQueriesService {

  def getUser(id: Int): Future[User] = ???

}

object UsersQueriesServiceImpl extends UsersQueriesServiceImpl
