package co.com.cobaik.bikes.json.objects

import co.com.cobaik.bikes.location.models.CobaikLocation
import org.joda.time.DateTime


case class BikeDetail(bike_id: Int, brand: String, reference: String, category_description: String,
                      price: Int, properties: Map[String, String], image_url: String, cobaik_location: CobaikLocation,
                      description: String)
case class BikeSearchDetail(id: Int, brand: String, reference: String, categoryDescription: String,
                            price: Int, properties: Map[String, String], imageUrl: String, cobaikLocation: CobaikLocation,
                            description: String)
case class BikesQuery(location: CobaikLocation, start_date: Option[DateTime], end_date: Option[DateTime])

case class BikeDescription(id: Int, description: String)