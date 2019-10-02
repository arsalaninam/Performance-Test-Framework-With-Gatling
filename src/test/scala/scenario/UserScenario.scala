package scenario

import config.UserConfig

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object UserScenario {

  val allUserDataScn = scenario(UserConfig.allUsersBaseName)
    .during(UserConfig.testTimeSecs) {
      exec(
        http(UserConfig.allUsersBaseName)
          .get(UserConfig.getAllUsersPathURI)
          .check(status.is(200))
      ).pause(UserConfig.minWaitMs, UserConfig.maxWaitMs)
    }

  val singleUserDataScn = scenario(UserConfig.singleUserBaseName)
    .during(UserConfig.testTimeSecs) {
      exec(
        http(UserConfig.singleUserBaseName)
          .get(UserConfig.getSingleUserPathURI)
          .check(status.is(200))
      ).pause(UserConfig.minWaitMs, UserConfig.maxWaitMs)
    }


}
