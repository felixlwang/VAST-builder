package utility;

import java.io.*;
import java.lang.reflect.Proxy;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import com.sun.xml.bind.marshaller.CharacterEscapeHandler;
import method.CDataHandler;

/**
* @author <a href="https://github.com/felixlwang/VAST-builder">Felix Lei Wang</a>
*/

public class XmlUtils {
    /**
   * 使用jaxb将对象转换为xml字符串
   * 
   * @param obj
   * @return
   */
  public static String objToXML(Object obj) throws JAXBException {
    try {
      JAXBContext jaxbContext = getJAXBContext(obj);
      StringWriter writer = new StringWriter();
      XMLStreamWriter streamWriter = XMLOutputFactory.newInstance()
          .createXMLStreamWriter(writer);
      // 使用动态代理模式, 对streamWriter功能进行干涉调整
      XMLStreamWriter cdataStreamWriter = (XMLStreamWriter) Proxy.newProxyInstance(
          streamWriter.getClass().getClassLoader(),
          streamWriter.getClass().getInterfaces(),
          new CDataHandler(streamWriter));

      Marshaller marshaller = jaxbContext.createMarshaller();
      // 设置编码格式
      marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
      // 设置否是格式化xml
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      // 是否省略头信息
      marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);

      // 不进行转义字符的处理
      marshaller.setProperty(CharacterEscapeHandler.class.getName(), new CharacterEscapeHandler() {
        public void escape(char[] ch, int start, int length, boolean isAttVal, Writer writer) throws IOException {
          writer.write(ch, start, length);
        }
      });

      marshaller.marshal(obj, cdataStreamWriter);

      return writer.toString();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }
}