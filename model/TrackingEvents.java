package model;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
* @author <a href="https://github.com/felixlwang/VAST-builder">Felix Lei Wang</a>
*/

@XmlAccessorType(XmlAccessType.FIELD)
@lombok.NoArgsConstructor
@lombok.Data
public class TrackingEvents {
  @XmlElement(name = "Tracking")
  private List<Tracking> trackings;
}
