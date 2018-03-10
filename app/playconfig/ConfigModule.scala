package playconfig

import java.util.concurrent.Executors

import com.typesafe.config.Config
import play.api.inject.{Binding, Module}
import play.api.{Configuration, Environment}

import scala.concurrent.ExecutionContext

/**
 * Config Module to provide a shim for Play 2.5.x
 */
class ConfigModule extends Module {

  //TODO: pendiente implementar
  lazy val httpExecutionContext = ExecutionContext.fromExecutor( Executors.newFixedThreadPool(15))

  override def bindings(environment: Environment, configuration: Configuration): Seq[Binding[_]] = Seq(
    bind[Config].toInstance(configuration.underlying)
  )

}
