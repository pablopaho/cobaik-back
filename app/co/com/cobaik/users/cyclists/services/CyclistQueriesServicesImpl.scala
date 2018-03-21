package co.com.cobaik.users.cyclists.services

import co.com.cobaik.users.cyclists.models.Cyclist

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

trait CyclistQueriesServicesImpl extends CyclistQueriesServices {

  def getCyclist(id: Int): Future[Cyclist] = {
    Future{
      Cyclist(id = 1, user_id = 1)
    }
  }

}

object CyclistQueriesServicesImpl extends CyclistQueriesServicesImpl
