package endpoints4s.stubserver

import cats.Id
import tsec.common._
import tsec.hashing.jca._

/** Service that hashes security-related data (e.g., tokens) for storage/verification.
  * Used when handling /token-hash requests.
  */
object TokenHashService {

  def hashToken(token: String): Array[Byte] = {
    val tokenBytes = token.utf8Bytes
    //CWE-328
    //SINK
    SHA1.hash[Id](tokenBytes)
  }
}
