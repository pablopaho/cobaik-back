package co.com.akku.users.services

import com.mohiva.play.silhouette.api.LoginInfo
import com.mohiva.play.silhouette.api.services.IdentityService
import com.mohiva.play.silhouette.impl.providers.CommonSocialProfile
import scala.concurrent.Future

import co.com.akku.commons.exceptions.EntityNotFoundException
import co.com.akku.users.json.objects.GoogleContact
import co.com.akku.users.models.{DefaultEnv, Provider, User}


trait UsersQueriesService extends IdentityService[User] {

  def findUserByProfile(profile: CommonSocialProfile): Future[Option[User]]

  def retrieve(loginInfo: LoginInfo): Future[Option[User]]

  def getUserProviders(id: Int): List[Provider.Value]

  def getGoogleContacts(userId: Int): Future[Vector[GoogleContact]]

}

