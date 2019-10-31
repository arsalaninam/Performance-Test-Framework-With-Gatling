package util

import com.typesafe.config.ConfigFactory

object PropertiesReader {

  /*
  It will read the property from application.properties file
   */
  def getProperty(name: String): String = {

    var env = System.getProperty("environment")

    if (env != null) {
      env = "-" + env
    }
    else {
      env = ""
    }

    val config = ConfigFactory.load("application" + env + ".properties")
    config.getString(name)
  }

}