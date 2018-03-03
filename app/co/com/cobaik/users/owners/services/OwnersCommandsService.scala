package co.com.cobaik.users.owners.services

import play.api.libs.Files.TemporaryFile
import play.api.mvc.MultipartFormData.FilePart


import scala.concurrent.Future


trait OwnersCommandsService {
  def createOwner(userId: Int): Future[Int]

  def appendIndentificationToOwner(ownerId: Int, file: Option[FilePart[TemporaryFile]]): Future[Int]
}
