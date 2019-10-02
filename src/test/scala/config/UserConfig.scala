package config

import scala.concurrent.duration._

object UserConfig {

  val rampUpTimeSecs = 5
  val testTimeSecs = 20
  val noOfUsers = 10
  val minWaitMs = 1000 milliseconds
  val maxWaitMs = 3000 milliseconds

  val baseURL = "https://reqres.in"

  val allUsersBaseName = "Get All Users Data API"
  val singleUserBaseName = "Get Single User Data API"

  val getAllUsersPathURI = "/api/users?page=2"
  val getSingleUserPathURI = "/api/users/2"

}
