package co.com.cobaik.communications.contact.services

import co.com.cobaik.communications.contact.models.Contact

import scala.concurrent.Future

trait ContactCommandsServices {

  def sendContact(contact: Contact): Future[String]

}
