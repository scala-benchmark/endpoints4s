package endpoints4s.stubserver

import org.apache.pekko.http.scaladsl.Http
import org.apache.pekko.http.scaladsl.model.{HttpRequest, HttpResponse}

import scala.concurrent.Future

/** Service that fetches a URL and returns the response.
  * Used for proxying requests to external URLs.
  */
object SsrfProxyService {

  def fetchUrl(url: String)(implicit
      system: org.apache.pekko.actor.ActorSystem
  ): Future[HttpResponse] = {
    //CWE-918
    //SINK
    Http().singleRequest(HttpRequest(uri = org.apache.pekko.http.scaladsl.model.Uri(url)))
  }
}
