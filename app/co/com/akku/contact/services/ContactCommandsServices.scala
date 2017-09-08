package co.com.akku.contact.services

import co.com.akku.contact.models.Contact
import scala.concurrent.Future

trait ContactCommandsServices {

  def sendContact(contact: Contact): Future[String]

}
