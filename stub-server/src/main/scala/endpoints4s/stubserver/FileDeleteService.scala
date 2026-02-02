package endpoints4s.stubserver

import better.files.File

/** Service that deletes files by path.
  * Used when handling /delete-file requests.
  */
object FileDeleteService {

  def deleteFile(filePath: String): Unit = {
    //CWE-22
    //SINK
    File(filePath).delete()
  }
}
