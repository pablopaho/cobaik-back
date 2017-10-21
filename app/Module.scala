
import co.com.cobaik.bikes.services.{BikesQueriesServices,BikesQueriesServicesImpl}
import co.com.cobaik.contact.services.{ContactCommandsServices, ContactCommandsServicesImpl}
import co.com.cobaik.bikes.dao.{BikesDAO, BikesDAOImpl}
import co.com.cobaik.communications.services.{MailerService, MailerServiceImpl}

import com.google.inject.AbstractModule
import net.codingwell.scalaguice.ScalaModule


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

   }
}
