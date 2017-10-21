package co.com.cobaik.contact.services

import co.com.cobaik.contact.models.Contact
import scala.concurrent.Future

trait ContactCommandsServices {

  def sendContact(contact: Contact): Future[String]

}
