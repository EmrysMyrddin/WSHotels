package controllers
import javax.inject.Inject
import play.api.mvc.{ Action, Controller }
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.libs.json._
import play.modules.reactivemongo.{MongoController, ReactiveMongoApi, ReactiveMongoComponents}
import reactivemongo.play.json._
import play.modules.reactivemongo.json.collection._
import models._
import models.JsonFormats._

class Application @Inject() (val reactiveMongoApi: ReactiveMongoApi)
  extends Controller with MongoController with ReactiveMongoComponents {

  def getHotels = Action.async {
    db.collection("hotels").find(Json.obj()).cursor[Hotel]().collect[List]()
      .map {hotels => Ok(Json.toJson(Map("hotels" -> hotels)))}
  }
}
