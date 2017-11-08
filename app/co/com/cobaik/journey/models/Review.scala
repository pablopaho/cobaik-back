package co.com.cobaik.journey.models

/**
  * Permite encapsular informaciòn de una review dado por un dueño o un ciclista. Asociado a un momento (journey).
  * @param id
  * @param score
  * @param description
  * @param journeyId
  */
case class Review(id: Int, score: Int, description: String, journeyId: Int)
