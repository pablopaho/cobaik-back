package co.com.cobaik.users.owners.services
import co.com.cobaik.users.owners.models.Owner
import play.api.libs.Files.TemporaryFile
import play.api.mvc.MultipartFormData.FilePart

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global



trait OwnersCommandsServiceImpl extends OwnersCommandsService {

  override def createOwner(userId: Int): Future[Int] = Future(1)

  override def appendIndentificationToOwner(ownerId: Int, file: Option[FilePart[TemporaryFile]]): Future[Int] = Future(1)

  def getOwner(id: Int): Future[Owner] = {
    Future {
      Owner(id = 1, user_id = 1)
    }
  }

}

object OwnersCommandsServiceImpl extends OwnersCommandsServiceImpl
