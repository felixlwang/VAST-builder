package method;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
* @author <a href="https://github.com/felixlwang/VAST-builder">Felix Lei Wang</a>
*/

public class CDataAdapter extends XmlAdapter<String, String> {

  @Override
  public String unmarshal(String v) throws Exception {
    return v;
  }

  @Override
  public String marshal(String v) throws Exception {
    if (v != null) {
      return new StringBuilder("<![CDATA[").append(v).append("]]>")
          .toString();
    }
    return null;
  }
}
