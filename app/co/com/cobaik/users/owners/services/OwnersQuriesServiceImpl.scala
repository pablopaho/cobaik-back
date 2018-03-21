package co.com.cobaik.users.owners.services


import co.com.cobaik.users.owners.models.Owner

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global


trait OwnersQueriesServiceImpl extends OwnersQueriesService {

  def getOwner(id: Int): Future[Owner] = {
    Future {
      Owner(id = 1, user_id = 1)
    }
  }

}

object OwnersQueriesServiceImpl extends OwnersQueriesServiceImpl
