package co.com.akku.contact.services

import co.com.akku.contact.models.Contact

trait ContactCommandsServices {

  def sendContact(contact: Contact): String

}
