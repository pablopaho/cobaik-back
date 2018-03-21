package co.com.cobaik.users.owners.services


import co.com.cobaik.users.owners.models.Owner
import scala.concurrent.Future

trait OwnersQueriesService {
  def getOwner(id: Int): Future[Owner]
}
