package co.com.cobaik.contact.services

import co.com.cobaik.contact.models.Contact
import co.com.cobaik.communications.services.MailerService

import javax.inject._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global //todo: definir contexto fijo, no el globla

@Singleton
class ContactCommandsServicesImpl @Inject()(mailerService: MailerService) extends ContactCommandsServices {

  def sendContact(contact: Contact): Future[String] = {
    Future {
      mailerService.sendContact(contact)
    }
  }

}

