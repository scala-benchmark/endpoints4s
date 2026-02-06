package endpoints4s.stubserver

import play.api.http.SecretConfiguration
import play.api.libs.crypto.DefaultCookieSigner

/** Service that signs cookie values using HMAC-SHA1.
  * Used when handling /cookie-sign requests.
  */
object CryptoCookieService {

  private val secretConfig = SecretConfiguration(secret = "cookie-signing-secret-key")
  private val cookieSigner = new DefaultCookieSigner(secretConfig)

  def signCookie(message: String, key: Array[Byte]): String = {
    
    
    cookieSigner.sign(message, key)
  }
}
