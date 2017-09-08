package co.com.akku.communications.services

import co.com.akku.contact.models.Contact

import play.api.libs.mailer._
import javax.inject.Inject

class MailerServiceImpl @Inject() (mailerClient: MailerClient) extends MailerService {

  private def sendEmail(email: Email): String = {
    mailerClient.send(email)
  }


  //todo: llevar html a la carpeta views
  def sendContact(contact: Contact) : String = {
    val cid = contact.fullname
    val email = Email(
      "Interesado",
      s"${contact.email} FROM <${contact.email}>",
      Seq("Miss TO <info@cobaik.com>"),
      // adds attachment
      attachments = Seq(),
      // sends text, HTML or both...
      bodyText = Some("A text message"),
      bodyHtml = Some(s"""<html>
                           <body>
                            <p>An <b>html</b> 
                             fullname: "${contact.fullname}"
                            </p>
                            <p>
                             residence_city: "${contact.residence_city}"
                            </p>
                            <p>
                             city_to_visit: "${contact.city_to_visit}"
                            </p>
                            <p>
                             message: "${contact.message}"         
                            </p>
                           </body>
                          </html>""")
    )
    sendEmail(email)
  }

}
