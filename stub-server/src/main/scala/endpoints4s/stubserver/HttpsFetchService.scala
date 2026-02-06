package endpoints4s.stubserver

import scalaj.http.{Http, HttpOptions}

/** Service that fetches HTTPS URLs with SSL certificate validation disabled.
  * Used when handling /https-fetch requests.
  */
object HttpsFetchService {

  def fetch(url: String): String = {
    //CWE-295
    //SINK
    Http(url).option(HttpOptions.allowUnsafeSSL).asString.body
  }
}
