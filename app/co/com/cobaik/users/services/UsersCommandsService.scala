package co.com.cobaik.users.services

import co.com.cobaik.users.models.User

import scala.concurrent.Future

trait UsersCommandsService {
  def createUser(user: User): Future[Int]
}
