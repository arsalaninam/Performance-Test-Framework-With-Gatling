package simulation

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder
import org.json.JSONObject
import org.json.JSONArray
import util.{PropertiesReader, Constants, FileUtil}

import scala.util.Random

class CreateUserSimulation extends Simulation{

  private val httpProtocol: HttpProtocolBuilder = http
    .baseUrl(PropertiesReader.getProperty(Constants.BASE_URL))
    .acceptHeader(Constants.JSON_CONTENT_TYPE)

  val userCreateRequest: String = "User Create Request"
  var userCreateResponseJson = new JSONArray
  val nameFeeder = Iterator.continually(
    Map("name" -> Random.alphanumeric.filter(_.isLetter).take(5).mkString),
  )

  val createUserScenario: ScenarioBuilder = scenario(Constants.CREATE_USER_SCENARIO_NAME)
    .feed(nameFeeder)
    .exec(http(userCreateRequest)
      .post(Constants.CREATE_USER_URL)
      .check(status.in(201, 409))
      .check(jsonPath("$.id").saveAs("id"))
      .body(ElFileBody(Constants.CREATE_USER_REQUEST_BODY_PATH))
      .asJson
    ).exec(session => {
    var jsonObject = new JSONObject()
    jsonObject.put("id", session("id").as[String])
    userCreateResponseJson.put(jsonObject)
    session
  }).pause(4)

  setUp(
    createUserScenario.inject(
      constantUsersPerSec(Constants.USER_REQUESTS_PER_SECOND) during(3)
    )
  ).protocols(httpProtocol)

  after {
    FileUtil.writeUserData(userCreateResponseJson.toString)
  }

}
