package co.com.akku.contact.services

import co.com.akku.contact.models.Contact
import co.com.akku.communications.services.MailerService

import play.api.libs.mailer._
import javax.inject._

@Singleton
class ContactCommandsServicesImpl @Inject()(mailerService: MailerService) extends ContactCommandsServices {

  def sendContact(contact: Contact): String = {
    mailerService.sendContact(contact)
  }

}

