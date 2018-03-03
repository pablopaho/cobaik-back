package co.com.cobaik.users.owners.services
import play.api.libs.Files.TemporaryFile
import play.api.mvc.MultipartFormData.FilePart

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global



trait OwnersCommandsServiceImpl extends OwnersCommandsService {

  override def createOwner(userId: Int): Future[Int] = Future(1)

  override def appendIndentificationToOwner(ownerId: Int, file: Option[FilePart[TemporaryFile]]): Future[Int] = Future(1)

}

object OwnersCommandsServiceImpl extends OwnersCommandsServiceImpl