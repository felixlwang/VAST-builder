package model;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import method.CDataAdapter;

/**
* @author <a href="https://github.com/felixlwang/VAST-builder">Felix Lei Wang</a>
*/

@XmlAccessorType(XmlAccessType.FIELD)
@lombok.NoArgsConstructor
@lombok.Data
public class InLine {
  @XmlElement(name = "AdSystem")
  private AdSystem adSystem = new AdSystem();
  @XmlElement(name = "AdTitle")
  @XmlJavaTypeAdapter(CDataAdapter.class)
  private String adTitle;
  @XmlElement(name = "Description")
  @XmlJavaTypeAdapter(CDataAdapter.class)
  private String description;
  @XmlElement(name = "Impression")
  @XmlJavaTypeAdapter(CDataAdapter.class)
  private List<String> impressions;
  @XmlElement(name = "Creatives", required = true)
  private Creatives creatives = new Creatives();
}
