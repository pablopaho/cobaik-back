package co.com.cobaik.bikes.json.objects

import org.joda.time.DateTime


case class BikeDetail(bikeId: Int, brand: String, reference: String, categoryId: Int, price: Int, properties: Map[String, String], imageUrl: String)
case class BikeSearchDetail(bikeId: Int, brand: String, reference: String, categoryId: Int, price: Int, properties: Map[String, String], imageUrl: String)
case class BikesQuery(city_code: Int, start_date: Option[DateTime], end_date: Option[DateTime])

