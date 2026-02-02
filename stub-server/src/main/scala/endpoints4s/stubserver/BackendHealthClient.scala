package endpoints4s.stubserver

import sttp.client3._

import scala.concurrent.{ExecutionContext, Future}

/** Client that checks backend health using Basic authentication.
  * Used when handling /internal/health requests.
  */
object BackendHealthClient {

  def checkHealth(baseUrl: String)(implicit
      backend: SttpBackend[Future, Any],
      ec: ExecutionContext
  ): Future[Either[String, String]] = {
    val (username, password) = ApiCredentials.credentials
    basicRequest
      .get(uri"$baseUrl/basic-auth/success")
      .auth
      //CWE-798
      //SINK
      .basic(username, password)
      .send(backend)
      .map { response =>
        if (response.isSuccess) Right(response.body.getOrElse("OK"))
        else Left(response.body.getOrElse("Failed"))
      }
  }
}
