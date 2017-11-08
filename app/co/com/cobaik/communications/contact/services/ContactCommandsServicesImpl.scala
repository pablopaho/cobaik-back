package co.com.cobaik.communications.contact.services

import javax.inject._

import co.com.cobaik.communications.contact.models.Contact
import co.com.cobaik.communications.services.MailerService

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future //todo: definir contexto fijo, no el globla

@Singleton
class ContactCommandsServicesImpl @Inject()(mailerService: MailerService) extends ContactCommandsServices {

  def sendContact(contact: Contact): Future[String] = {
    Future {
      mailerService.sendContact(contact)
    }
  }

}

