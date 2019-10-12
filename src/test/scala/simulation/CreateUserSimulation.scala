package simulation

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder
import org.json.JSONObject
import org.json.JSONArray
import util.{PropertiesReader, Constants, FileUtil}

import scala.util.Random

class CreateUserSimulation extends Simulation {

  /*
  Setting up Http Protocols (BaseUrl , Headers etc.)
   */
  private val httpProtocol: HttpProtocolBuilder = http
    .baseUrl(PropertiesReader.getProperty(Constants.BASE_URL))
    .acceptHeader(Constants.JSON_CONTENT_TYPE)

  // User Request Name
  val userCreateRequest: String = "User Create Request"

  // Create User API Response JSON declaration
  var userCreateResponseJson = new JSONArray

  /*
  generating random names for Create User Request Payload
   */
  val nameFeeder = Iterator.continually(
    Map("name" -> Random.alphanumeric.filter(_.isLetter).take(5).mkString),
  )

  /*
  Creating a Scenario for Create User API.
  It will execute post request to provided API Url,
  check the response status and response body,
  and save the id from response.
   */
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

  /*
  In setUp(), we will inject the desired load to our API
   */
  setUp(
    createUserScenario.inject(
      constantUsersPerSec(Constants.USER_REQUESTS_PER_SECOND) during (3)
    )
  ).protocols(httpProtocol)

  /*
  Id from each response will be saved in a new file in JSON format
   */
  after {
    FileUtil.writeUserData(userCreateResponseJson.toString)
  }

}
