package co.com.akku.users.services

import com.mohiva.play.silhouette.api.LoginInfo
import com.mohiva.play.silhouette.impl.providers.CommonSocialProfile
import scala.concurrent.Future

import co.com.akku.users.json.objects.GoogleContact
import co.com.akku.users.models.{Provider, User}

class UsersQueriesServiceImpl extends UsersQueriesService {

  override def findUserByProfile(profile: CommonSocialProfile): Future[Option[User]] = ???

  override def retrieve(loginInfo: LoginInfo): Future[Option[User]] = ???

  override def getUserProviders(id: Int): List[Provider.Value] = ???

  override def getGoogleContacts(userId: Int): Future[Vector[GoogleContact]] = ???
}
