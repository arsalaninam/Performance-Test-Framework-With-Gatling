package simulation

import request.UserRequest
import scenario.UserScenario

import io.gatling.core.Predef._
import scala.concurrent.duration._

class UserSimulation extends Simulation{

  val getAllUsersDataScenario = UserScenario.allUserDataScn
  val getSingleUserDataScenario = UserScenario.singleUserDataScn
  val getUserDataHttpReq = UserRequest.httpConf

  setUp(
    getAllUsersDataScenario.inject(
      atOnceUsers(50),
      constantUsersPerSec(10) during(5 seconds)
    ).protocols(getUserDataHttpReq),

    getSingleUserDataScenario.inject(
      atOnceUsers(20),
      constantUsersPerSec(5) during(3 seconds)
    ).protocols(getUserDataHttpReq)
  )

}
