package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import method.CDataAdapter;

/**
* @author <a href="https://github.com/felixlwang/VAST-builder">Felix Lei Wang</a>
*/

@XmlAccessorType(XmlAccessType.FIELD)
@lombok.NoArgsConstructor
@lombok.Data
public class MediaFile {
  @XmlValue
  @XmlJavaTypeAdapter(CDataAdapter.class)
  private String value;
  @XmlAttribute(name = "id")
  private Integer id;
  @XmlAttribute(name = "type")
  private String type;
  @XmlAttribute(name = "width")
  private Integer width;
  @XmlAttribute(name = "height")
  private Integer height;
  @XmlAttribute(name = "delivery")
  private String delivery = "progressive";
}
