package service;

import model.*;
import utility.*;

/**
* @author <a href="https://github.com/felixlwang/VAST-builder">Felix Lei Wang</a>
*/

public class VASTService {

  /**
  * @param   adConfig Ad config to build VAST response
  */
  public String BuildVASTModel(Object adConfig) throws Exception {
    VAST vast = new VAST();

    // Skip the implementation

    return XmlUtils.objToXML(vast);
  }

  public String BuildNoAdVASTModel() throws Exception {
    VAST vast = new VAST();
    vast.setError("http://adserver.com/noad.gif");

    return XmlUtils.objToXML(vast);
  }
}
