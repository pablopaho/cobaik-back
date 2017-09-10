package co.com.akku.communications.services

import co.com.akku.contact.models.Contact

trait MailerService{

  def sendContact(contact: Contact) : String 

}
