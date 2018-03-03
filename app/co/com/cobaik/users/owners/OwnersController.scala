package co.com.cobaik.users.owners

import javax.inject.Inject

import co.com.cobaik.users.owners.services.OwnersServiceProvider
import play.api.libs.json.Json
import play.api.mvc._
import play.api.libs.Files


import scala.concurrent.{ExecutionContext, Future}


trait OwnerDependenciesController extends Controller with OwnersServiceProvider {
  val ownersServiceProvider = ownersCommandsService
}

class OwnersController @Inject()(implicit executionContext: ExecutionContext) extends OwnerDependenciesController{
  def createOwner() = Action.async {
      val userId = 1
      val l: Future[Int] = ownersServiceProvider.createOwner(userId)
      l.map(result => Ok(Json.toJson(result)))
  }

  def addOwnerIdentificationPicture(id: Int): Action[MultipartFormData[Files.TemporaryFile]] = Action.async(parse.multipartFormData) { request =>
      val fotoOwnerIdentification = request.body.file("fotoOwnerIdentification")
      val responseF = ownersServiceProvider.appendIndentificationToOwner(id, fotoOwnerIdentification)
      responseF.map(response => Ok(Json.toJson(response)))
  }
}
