package util

object Constants {

  val BASE_URL = "BASE_URL"

  val CREATE_USER_URL = "/api/users"

  val CREATE_USER_SCENARIO_NAME = "Create User Scenario"

  val JSON_CONTENT_TYPE = "application/json"

  val CREATE_USER_REQUEST_BODY_PATH = "body/createUserRequest.json"

  val SERVICE_JSON_BASE_PATH = "build/reports/resource"

  val SERVICE_JSON_FILENAME = "/createUserData.json"

  var USER_REQUESTS_PER_SECOND: Double = 4

  var USER_DURATION: Integer = 5

  var RAMP_UP_TIME_SECONDS:Integer = Integer.getInteger(("rampUpUserSeconds"),1)

  if(System.getProperty("USER_REQUESTS_PER_SECOND") != null)
    USER_REQUESTS_PER_SECOND = Integer.parseInt(System.getProperty("USER_REQUESTS_PER_SECOND"))

  if(System.getProperty("USER_DURATION") != null)
    USER_DURATION = Integer.parseInt(System.getProperty("USER_DURATION"))

  if(System.getProperty("RAMP_UP_TIME_SECONDS") != null)
    RAMP_UP_TIME_SECONDS = Integer.parseInt(System.getProperty("RAMP_UP_TIME_SECONDS"))
}
