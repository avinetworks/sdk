package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The CloudConnectorUserTestParams is a POJO class extends AviRestResource that used for creating
 * CloudConnectorUserTestParams.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CloudConnectorUserTestParams  {
    @JsonProperty("host")
    private String host = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property host of obj type cloudconnectorusertestparams field type str  type string.
   * @return host
   */
  public String getHost() {
    return host;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property host of obj type cloudconnectorusertestparams field type str  type string.
   * @param host set the host.
   */
  public void setHost(String  host) {
    this.host = host;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  CloudConnectorUserTestParams objCloudConnectorUserTestParams = (CloudConnectorUserTestParams) o;
  return   Objects.equals(this.host, objCloudConnectorUserTestParams.host);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class CloudConnectorUserTestParams {\n");
      sb.append("    host: ").append(toIndentedString(host)).append("\n");
      sb.append("}");
  return sb.toString();
}

/**
* Convert the given object to string with each line indented by 4 spaces
* (except the first line).
*/
private String toIndentedString(java.lang.Object o) {
  if (o == null) {
    return "null";
  }
  return o.toString().replace("\n", "\n    ");
}
}

