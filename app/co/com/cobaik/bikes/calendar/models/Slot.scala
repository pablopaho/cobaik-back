package co.com.cobaik.bikes.calendar.models

import org.joda.time.DateTime

/**
  * Representa un espacio de tiempo.
  *
  * @param startDate
  * @param endDate
  */
case class Slot (id: Int, startDate: DateTime, endDate: DateTime)
