package co.com.cobaik.communications.services

import co.com.cobaik.contact.models.Contact

trait MailerService{

  def sendContact(contact: Contact) : String 

}
