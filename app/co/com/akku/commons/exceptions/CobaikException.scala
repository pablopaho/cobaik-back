package co.com.akku.commons.exceptions

class CobaikException (_msg: String, _cause: Throwable = null) extends Exception(_msg, _cause)

case class EntityNotFoundException(_msg :String) extends CobaikException(_msg)