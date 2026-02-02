package endpoints4s.stubserver

import scala.util.matching.Regex

/** Service that matches text against a regex pattern.
  * Used when handling /regex-match requests.
  */
object RegexMatchService {

  def findAllMatches(pattern: String, text: String): Iterator[String] = {
    val regex = new Regex(pattern)
    //CWE-1333
    //SINK
    regex.findAllIn(text)
  }
}
