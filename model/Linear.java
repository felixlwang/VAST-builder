package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
* @author <a href="https://github.com/felixlwang/VAST-builder">Felix Lei Wang</a>
*/

@XmlAccessorType(XmlAccessType.FIELD)
@lombok.NoArgsConstructor
@lombok.Data
public class Linear {
  @XmlElement(name = "Duration")
  private String duration;
  @XmlElement(name = "TrackingEvents")
  private TrackingEvents trackings;
  @XmlElement(name = "VideoClicks")
  private VideoClicks videoClicks;
  @XmlElement(name = "MediaFiles", required = true)
  private MediaFiles mediaFiles;
}
