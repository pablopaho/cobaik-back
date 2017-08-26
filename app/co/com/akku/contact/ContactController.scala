package co.com.akku.contact

import javax.inject._

import play.api.mvc._
import play.api.libs.json.{Json}
import co.com.akku.contact.services.ContactCommandsServices
import app.co.com.akku.contact.json.Formats._
import scala.concurrent.ExecutionContext
import co.com.akku.contact.models.Contact

@Singleton
class ContactController @Inject() (contactCommandsServices: ContactCommandsServices)(implicit executionContext: ExecutionContext) extends Controller {

  def sendContact: Action[Contact] = Action(parse.json[Contact]) { req =>
    val contact: Contact = req.body
    println(s"contact:$contact")
    contactCommandsServices.sendContact(contact)
    Ok("Happy")

  }

}
