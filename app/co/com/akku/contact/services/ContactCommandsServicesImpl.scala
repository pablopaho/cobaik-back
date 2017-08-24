package co.com.akku.contact.services

import co.com.akku.contact.models.Contact
import play.api.libs.mailer._

class ContactCommandsServicesImpl(mailerClient: MailerClient) extends ContactCommandsServices {

  def sendContact(): String = {
    println(s"si fue")
    "xyztest"
  }

  def sendContactv2(contact: Contact): String = {
    println(s"si fue")
    "xyztest"
  }

  def sendEmail = {
    val email = Email("Simple email", "Mister FROM <from@email.com>", Seq("Miss TO <to@email.com>"), bodyText = Some("A text message"))
    mailerClient.send(email)
  }

}

