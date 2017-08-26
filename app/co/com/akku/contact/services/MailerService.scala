package co.com.akku.contact.services

import play.api.libs.mailer._
import java.io.File
import org.apache.commons.mail.EmailAttachment
import javax.inject.Inject

class MailerService @Inject() (mailerClient: MailerClient) {

  def sendEmail = {
    val cid = "1234"
    val email = Email(
      "Simple email",
      "Mister FROM <pablopaho@gmail.com>",
      Seq("Miss TO <info@cobaik.com>"),
      // adds attachment
      attachments = Seq(),
      // sends text, HTML or both...
      bodyText = Some("A text message"),
      bodyHtml = Some(s"""<html><body><p>An <b>html</b> message with cid <img src="cid:$cid"></p></body></html>""")
    )
    mailerClient.send(email)
  }

}
