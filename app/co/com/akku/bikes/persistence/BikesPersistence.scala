package co.com.akku.bikes.persistence
//https://github.com/playframework/play-slick/tree/master/samples/basic/conf

trait BikesPersistence {
  def getBikes(): Seq[String]
}
