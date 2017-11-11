package co.com.cobaik.commons.persistence

import com.github.tminglei.slickpg.{ExPostgresProfile, PgDateSupportJoda, PgHStoreSupport}
import org.joda.time.DateTime
import slick.jdbc.{H2Profile, JdbcProfile}
import slick.util.Logging

trait CobaikPGProfile extends ExPostgresProfile with PgHStoreSupport with PgDateSupportJoda{

  override val api = new API with HStoreImplicits with DateTimeImplicits {

    def getDateTimeFormatter(s: String)  = {
      if(s.matches(".*[\\+|\\-][0-9]+$")) if(s.indexOf(".") > 0 ) jodaTzDateTimeFormatter else jodaTzDateTimeFormatter_NoFraction
      else if(s.indexOf(".") > 0 ) jodaDateTimeFormatter else jodaDateTimeFormatter_NoFraction
    }
  }
}

object CobaikPGProfile extends CobaikPGProfile