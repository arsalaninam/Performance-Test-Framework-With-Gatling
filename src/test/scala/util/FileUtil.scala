package util

import java.io.{BufferedWriter, File, FileWriter}

object FileUtil {

  /*
  This method will write down the desired response in a new file.
   */
  def writeUserData(lines: String): Unit = {
    var file = new File(Constants.SERVICE_JSON_BASE_PATH)
    if (!file.exists()) {
      file.mkdirs()
      file = new File(Constants.SERVICE_JSON_BASE_PATH + Constants.SERVICE_JSON_FILENAME)
      file.createNewFile()
    }
    val bw = new BufferedWriter(new FileWriter(file))
    bw.write(lines)
    bw.close()
  }

}
