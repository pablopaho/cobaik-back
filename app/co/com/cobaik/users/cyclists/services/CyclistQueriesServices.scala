package co.com.cobaik.users.cyclists.services

import co.com.cobaik.users.cyclists.models.Cyclist

import scala.concurrent.Future

trait CyclistQueriesServices {
  def getCyclist(id: Int): Future[Cyclist]
}
