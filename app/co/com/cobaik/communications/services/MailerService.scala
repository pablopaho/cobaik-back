package co.com.cobaik.communications.services

import co.com.cobaik.communications.contact.models.Contact

trait MailerService{

  def sendContact(contact: Contact) : String 

}
