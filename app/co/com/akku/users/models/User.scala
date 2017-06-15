package co.com.akku.users.models

import co.com.akku.locations.models.Location
import com.mohiva.play.silhouette.api.Identity
import org.joda.time.DateTime

case class User (
                  id: Int,
                  email: String,
                  fullname: Option[String],
                  firstname: Option[String],
                  lastname: Option[String],
                  avatarUrl: Option[String],
                  address: Option[String],
                  phone: Option[String],
                  location: Option[Location],
                  identificationType: Option[IdentificationType.Value],
                  identificationNumber: Option[String],
                  birthDate: Option[DateTime],
                  acceptTermsAndConditionsDate: Option[DateTime],
                  gender: Option[GenderType.Value],
                  personalInfoAllowed: Option[Boolean],
                  status: UserStatus.Value
                ) extends Identity {

}
