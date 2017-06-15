package co.com.akku.users.silhouette

import javax.inject.Inject
import com.mohiva.play.silhouette.api._
import com.mohiva.play.silhouette.api.exceptions.ProviderException
import com.mohiva.play.silhouette.api.repositories.AuthInfoRepository
import com.mohiva.play.silhouette.impl.providers._
import play.api.i18n.{I18nSupport, Messages, MessagesApi}
import play.api.libs.concurrent.Execution.Implicits._
import play.api.libs.json.Json
import play.api.mvc._
import scala.concurrent.Future

import co.com.akku.users.models.{DefaultEnv, User, CobaikOauth2Info}
import co.com.akku.users.services.{UsersCommandsService, UsersQueriesService}

/**
  * The social auth controller.
  *
  * @param messagesApi The Play messages API.
  * @param silhouette The Silhouette stack.
  * //@param userService The user service implementation.
  * @param authInfoRepository The auth info service implementation.
  * @param socialProviderRegistry The social provider registry.
  * //@param webJarAssets The webjar assets implementation.
  */
class SocialAuthController @Inject() (
                                       val messagesApi: MessagesApi,
                                       silhouette: Silhouette[DefaultEnv],
                                       usersCommandsService: UsersCommandsService,
                                       usersQueriesService: UsersQueriesService,
                                       authInfoRepository: AuthInfoRepository,
                                       socialProviderRegistry: SocialProviderRegistry)
                                       //implicit val webJarAssets: WebJarAssets)
  extends Controller with I18nSupport with Logger {

  /**
    * Authenticates a user against a social provider.
    *
    * @param provider The ID of the provider to authenticate against.
    * @return The result to display.
    */
  def authenticate(provider: String): Action[AnyContent] = silhouette.UserAwareAction.async { implicit request =>
    (socialProviderRegistry.get[SocialProvider](provider) match {
      case Some(p: SocialProvider with CommonSocialProfileBuilder) =>
        println("entro a some de p")
        p.authenticate().flatMap {
          case Left(result) => {
            println("entro a left")
            Future.successful(result)
          }
          case Right(authInfo) =>
            println("entro a right")
            p.retrieveProfile(authInfo).flatMap { profile =>
              println(profile.email)
              println(profile.loginInfo)
              println(profile.avatarURL)
              println(profile.firstName)
              println(profile.fullName)
              println(profile.lastName)
              request.identity match {
                case None =>
                  if(profile.email.isEmpty) {
                    val jsonError = Json.obj("code" -> "01", "responseMessage" -> Messages("could.not.authenticate(user profile without email)"))
                    Future.successful( BadRequest(Json.toJson(jsonError)) )
                  }
                  else {
                    println("not profile.email.isEmpty")
                    for {
                      (loginInfo, user) <- insertOrUpdateUser(authInfo, profile)
                      tokenResult <- generateToken(loginInfo, user)
                    } yield tokenResult
                  }
                case Some(user) => {
                  println("Some(user)")
                  Future.successful(Unauthorized(Json.obj("code" -> "01", "message" -> Json.toJson(authInfo.toString))))
                }
              }
            }
            /*p.retrieveProfile(authInfo).flatMap { profile =>
              request.identity match {
                case None =>
                  if(profile.email.isEmpty) {
                    val jsonError = Json.obj("code" -> "01", "responseMessage" -> Messages("could.not.authenticate(user profile without email)"))
                    Future.successful( BadRequest(Json.toJson(jsonError)) )
                  } else {
                    for {
                      (loginInfo, user) <- insertOrUpdateUser(authInfo, profile)
                      tokenResult <- generateToken(loginInfo, user)
                    } yield tokenResult
                  }
                case Some(user) =>
                  val userProviders = usersQueriesService.getUserProviders(user.id)
                  val userAlreadyHasProvider = userProviders.exists( p => p.toString == provider )
                  for {
                    (loginInfo, user) <- if(userAlreadyHasProvider) insertOrUpdateUser(authInfo, profile) else linkUserIfPossible(authInfo, user.id, profile)
                    tokenResult <- generateToken(loginInfo, user)
                  } yield tokenResult
              }
            }*/

        }
      case _ => Future.failed(new ProviderException(s"Cannot authenticate with unexpected social provider $provider"))
    }).recover {
      case e: ProviderException =>
        logger.error("Unexpected provider error", e)
        Unauthorized(Json.obj("code" -> "01", "message" -> Messages("could.not.authenticate")))
    }
  }

  def insertOrUpdateUser[T<:AuthInfo](authInfo: T, profile: CommonSocialProfile): Future[(LoginInfo, User)] = {
    for {
      user <- usersCommandsService.insertOrUpdate(profile)
      authInfo <- authInfoRepository.save(profile.loginInfo, CobaikOauth2Info(authInfo))
    } yield (profile.loginInfo , user)
  }

  def generateToken(loginInfo: LoginInfo, user: User)(implicit request: RequestHeader): Future[Result] = {
    for {
      authenticator <- silhouette.env.authenticatorService.create(loginInfo)
      token <- silhouette.env.authenticatorService.init(authenticator)
    //} yield Ok(Json.obj("token" -> token, "user" -> Json.toJson(user)))
    } yield Ok(Json.obj("token" -> token))
  }
}
