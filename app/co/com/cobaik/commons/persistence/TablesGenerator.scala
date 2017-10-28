package co.com.cobaik.commons.persistence

import slick.jdbc.PostgresProfile
import scala.concurrent.ExecutionContext.Implicits.global

object TablesGenerator {
  def main(args: Array[String]): Unit = {

    val username = "ciudsegu"
    val password = "ciudsegu2017"
    val url = s"jdbc:postgresql://localhost:5432/ciudsegu-db?user=$username&password=$password"

    val DB = PostgresProfile.backend.Database.forURL(url,driver= "org.postgresql.Driver")
    val modelAction = PostgresProfile.createModel(Some(PostgresProfile.defaultTables))
    val modelFuture = DB.run(modelAction)
    val codegenFuture = modelFuture.map(model => new TablesSourceCodeGenerator(model))

    codegenFuture.onSuccess {
      case codegen => {
        codegen.writeToFile(
          "co.com.wesura.auth.persistence.WesuraPGProfile",
          "/home/felipe/Wesura/ciudades_seguras/app/",
          "co.com.wesura.auth.persistence.generated",
          "Tables",
          "Tables.scala"
        )
      }
    }

    codegenFuture.onFailure{
      case e => println(s"ERROR: $e")
    }
  }
}
