package co.com.cobaik.users.owners.services
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global



trait OwnersCommandsServiceImpl extends OwnersCommandsService {

  override def createOwner(userId: Int): Future[Int] = Future(1)
}

object OwnersCommandsServiceImpl extends OwnersCommandsServiceImpl