package co.com.akku.users.services

import co.com.akku.users.models.User

import com.mohiva.play.silhouette.impl.providers.CommonSocialProfile
import scala.concurrent.Future


trait UsersCommandsService {

  def insertOrUpdate(profile: CommonSocialProfile): Future[User]

}
