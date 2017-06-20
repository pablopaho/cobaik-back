package co.com.akku.users.json.objects

import scalaz.Order
import scalaz.Order.orderMonoid
import scalaz.std.string.stringInstance
import scalaz.syntax.monoid._

case class GoogleContact(fullName: Option[String], emailAddress: String)

object GoogleContact {

  implicit val ordering = {
    val orderByFullName = Order.orderBy { gc: GoogleContact => gc.fullName.map(_.toLowerCase).getOrElse("zzzzzzzzzzzzzzzzzzzzzzzzz") /* Chambonada para que ponga de últimas los contactos que no tienen nombre */ }
    val orderByEmail = Order.orderBy { gc: GoogleContact => gc.emailAddress }
    val orderByNameAndThenByEmail = orderByFullName |+| orderByEmail
    orderByNameAndThenByEmail.toScalaOrdering
  }

}