package co.com.cobaik.commons.persistence

import slick.dbio.DBIO
import slick.jdbc
import slick.jdbc.PostgresProfile
import slick.model.Model

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._

object TablesGenerator {
  def main(args: Array[String]): Unit = {

    val username = "test"
    val password = "test2017"
    val url = s"jdbc:postgresql://localhost:5432/test-db?user=$username&password=$password"

    val DB: jdbc.PostgresProfile.backend.DatabaseDef = PostgresProfile.backend.Database.forURL(url,driver= "org.postgresql.Driver")
    val modelAction: DBIO[Model] = PostgresProfile.createModel(Some(PostgresProfile.defaultTables))
    val modelFuture: Future[Model] = DB.run(modelAction)

    val codegenFuture: Future[TablesSourceCodeGenerator] = Await.ready(
      modelFuture.map(model => new TablesSourceCodeGenerator(model)), 20.seconds
    )

    val result = Await.ready(
      codegenFuture.map(_.writeToFile(
        "co.com.cobaik.commons.persistence.CobaikPGProfile",
        "/Users/juandiegoestradap/projects/share-bike-back/app/",
        "co.com.cobaik.commons.persistence.generated",
        "Tables",
        "Tables.scala"
      )),
      20.seconds
    )
  }
}
