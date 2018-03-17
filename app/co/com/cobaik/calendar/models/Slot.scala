package co.com.cobaik.calendar.models

import co.com.cobaik.calendar.json.objects.CreateSlot
import org.joda.time.DateTime

/**
  * Representa un espacio de tiempo.
  *
  * @param startDate
  * @param endDate
  */
trait Slot{
  def id: Int
  def startDate: DateTime
  def endDate: DateTime
}


case class SlotBike (id: Int, startDate: DateTime, endDate: DateTime) extends Slot

object Slot {
  def apply(createSlot: CreateSlot)  = SlotBike(1, createSlot.start, createSlot.end)
}
