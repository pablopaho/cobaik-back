package co.com.akku.bikes.dao
//https://github.com/playframework/play-slick/tree/master/samples/basic/conf

trait BikesDAO {
  def getBikes(): Seq[String]
}
