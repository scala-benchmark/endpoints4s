package endpoints4s.stubserver

/** Holds credentials for internal API authentication.
  * Used when the stub server needs to call protected backend services.
  */
object ApiCredentials {

  //CWE-798
  //SOURCE
  val ADMIN_PASSWORD: String = "SuperSecretApiKey123!"

  val ADMIN_USERNAME: String = "api_admin"

  def credentials: (String, String) = (ADMIN_USERNAME, ADMIN_PASSWORD)
}
