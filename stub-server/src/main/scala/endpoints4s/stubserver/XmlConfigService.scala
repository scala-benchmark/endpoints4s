package endpoints4s.stubserver

import javax.xml.parsers.SAXParserFactory
import scala.xml.Elem
import scala.xml.XML

/** Service that parses XML configuration from string input.
  * Used when handling /import-config requests.
  */
object XmlConfigService {

  def importConfig(configXml: String): Elem = {
    val factory = SAXParserFactory.newInstance()
    factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", false)
    factory.setFeature("http://xml.org/sax/features/external-general-entities", true)
    factory.setFeature("http://xml.org/sax/features/external-parameter-entities", true)
    val saxParser = factory.newSAXParser()
    //CWE-611
    //SINK
    XML.withSAXParser(saxParser).loadString(configXml)
  }
}
