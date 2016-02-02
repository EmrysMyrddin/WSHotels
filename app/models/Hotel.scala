package models

/**
  * Created by valentin on 01/02/16.
  */
case class Hotel (id: Int, name: String, city: String, adress: String, price: Float)

object JsonFormats {
  import play.api.libs.json.Json
  implicit val hotelFormat = Json.format[Hotel]
}
