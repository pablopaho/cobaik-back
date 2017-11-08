package co.com.cobaik.bikes.services

import org.scalatestplus.play.{ OneAppPerSuite, PlaySpec }
import scala.concurrent.Await
import scala.concurrent.duration._

class BikesQueriesServicesTest extends PlaySpec with OneAppPerSuite {

  "BikeQueriesServiceTest" should {

    "Return all bikes" in {
      //arrange
      val bikesQueriesService = app.injector.instanceOf[BikesQueriesServices]

      //act
      val bikes = Await.result(bikesQueriesService.bikes(), 1 seconds)

      //assert
      assert(bikes.head.id === 1)
    }
  }

}
