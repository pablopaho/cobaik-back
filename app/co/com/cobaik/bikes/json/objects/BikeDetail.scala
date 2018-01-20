package co.com.cobaik.bikes.json.objects

import co.com.cobaik.bikes.location.models.CobaikLocation
import org.joda.time.DateTime


case class BikeDetail(bikeId: Int, brand: String, reference: String, categoryId: Int, price: Int, properties: Map[String, String], imageUrl: String)
case class BikeSearchDetail(bikeId: Int, brand: String, reference: String, categoryId: Int, price: Int, properties: Map[String, String], imageUrl: String)
case class BikesQuery(location: CobaikLocation, start_date: Option[DateTime], end_date: Option[DateTime])

