package co.com.akku.users.models

import com.mohiva.play.silhouette.api.AuthInfo

case class CobaikOauth2Info[T<:AuthInfo](
                                             oAuth2Info: T,
                                             userId: Option[Int]) extends AuthInfo

object CobaikOauth2Info {
  def apply[T<:AuthInfo](oAuth2Info: T): CobaikOauth2Info[T] = CobaikOauth2Info(oAuth2Info, None)
  def apply[T<:AuthInfo](oAuth2Info: T, userId: Int): CobaikOauth2Info[T] = CobaikOauth2Info(oAuth2Info, Some(userId))
}
