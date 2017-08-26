package co.com.akku.contact.services

import co.com.akku.contact.models.Contact

import play.api.libs.mailer._
import javax.inject._

@Singleton
class ContactCommandsServicesImpl @Inject()(mailerService: MailerService) extends ContactCommandsServices {

  def sendContact(contact: Contact): String = {
    println(s"si fue :$contact")
    mailerService.sendEmail
    "xyztest"
  }

}

