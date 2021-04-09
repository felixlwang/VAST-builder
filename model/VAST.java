package model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import method.CDataAdapter;

/**
* @author <a href="https://github.com/felixlwang/VAST-builder">Felix Lei Wang</a>
*/

@XmlRootElement(name = "VAST")
@XmlAccessorType(XmlAccessType.FIELD)
@lombok.NoArgsConstructor
@lombok.Data
public class VAST {
  @XmlElement(name = "Ad", required = true)
  private List<Ad> ads = new ArrayList<>();
  @XmlElement(name = "Error")
  @XmlJavaTypeAdapter(CDataAdapter.class)
  private String error;
  @XmlAttribute(name = "version")
  private String version = "4.2";
}
