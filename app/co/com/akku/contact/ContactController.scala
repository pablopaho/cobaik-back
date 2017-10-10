package co.com.akku.contact

import co.com.akku.contact.services.ContactCommandsServices
import app.co.com.akku.contact.json.Formats._
import co.com.akku.contact.models.Contact

import scala.concurrent.ExecutionContext
import javax.inject._
import play.api.mvc._


@Singleton
class ContactController @Inject() (contactCommandsServices: ContactCommandsServices)(implicit executionContext: ExecutionContext) extends Controller {

  def sendContact: Action[Contact] = Action.async(parse.json[Contact]) { req =>
    val contact: Contact = req.body
    contactCommandsServices.sendContact(contact).map(_ => Created)
  }

}
