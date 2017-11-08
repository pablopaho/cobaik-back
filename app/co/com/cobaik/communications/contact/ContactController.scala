package co.com.cobaik.communications.contact

import javax.inject._

import co.com.cobaik.communications.contact.json.Formats._
import co.com.cobaik.communications.contact.models.Contact
import co.com.cobaik.communications.contact.services.ContactCommandsServices
import play.api.mvc._

import scala.concurrent.ExecutionContext


@Singleton
class ContactController @Inject() (contactCommandsServices: ContactCommandsServices)(implicit executionContext: ExecutionContext) extends Controller {

  def sendContact: Action[Contact] = Action.async(parse.json[Contact]) { req =>
    val contact: Contact = req.body
    contactCommandsServices.sendContact(contact).map(_ => Created)
  }

}
