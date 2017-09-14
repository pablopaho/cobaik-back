
import co.com.akku.bikes.services.{BikesQueriesServices,BikesQueriesServicesImpl}
import co.com.akku.contact.services.{ContactCommandsServices, ContactCommandsServicesImpl}
import co.com.akku.bikes.dao.{BikesDAO, BikesDAOImpl}
import co.com.akku.communications.services.{MailerService, MailerServiceImpl}

import services.{ApplicationTimer, AtomicCounter, Counter}

import com.google.inject.AbstractModule
import net.codingwell.scalaguice.ScalaModule
import java.time.Clock

/**
 * This class is a Guice module that tells Guice how to bind several
 * different types. This Guice module is created when the Play
 * application starts.

 * Play will automatically use any class called `Module` that is in
 * the root package. You can create modules in other locations by
 * adding `play.modules.enabled` settings to the `application.conf`
 * configuration file.
 */
class Module extends AbstractModule with ScalaModule {

  override def configure() = {

    bind(classOf[BikesQueriesServices]).to(classOf[BikesQueriesServicesImpl])
    bind(classOf[BikesDAO]).to(classOf[BikesDAOImpl])

    bind(classOf[ContactCommandsServices]).to(classOf[ContactCommandsServicesImpl])
    bind(classOf[MailerService]).to(classOf[MailerServiceImpl])

    // Use the system clock as the default implementation of Clock
    bind(classOf[Clock]).toInstance(Clock.systemDefaultZone)
    // Ask Guice to create an instance of ApplicationTimer when the
    // application starts.
    bind(classOf[ApplicationTimer]).asEagerSingleton()
    // Set AtomicCounter as the implementation for Counter.
    bind(classOf[Counter]).to(classOf[AtomicCounter])

   }
}
