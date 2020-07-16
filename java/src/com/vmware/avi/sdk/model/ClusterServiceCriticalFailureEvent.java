package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ClusterServiceCriticalFailureEvent is a POJO class extends AviRestResource that used for creating
 * ClusterServiceCriticalFailureEvent.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClusterServiceCriticalFailureEvent  {
    @JsonProperty("node_name")
    private String nodeName = null;

    @JsonProperty("service_name")
    private String serviceName = null;



  /**
   * This is the getter method this will return the attribute value.
   * Name of controller node.
   * @return nodeName
   */
  public String getNodeName() {
    return nodeName;
  }

  /**
   * This is the setter method to the attribute.
   * Name of controller node.
   * @param nodeName set the nodeName.
   */
  public void setNodeName(String  nodeName) {
    this.nodeName = nodeName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the controller service.
   * @return serviceName
   */
  public String getServiceName() {
    return serviceName;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the controller service.
   * @param serviceName set the serviceName.
   */
  public void setServiceName(String  serviceName) {
    this.serviceName = serviceName;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ClusterServiceCriticalFailureEvent objClusterServiceCriticalFailureEvent = (ClusterServiceCriticalFailureEvent) o;
  return   Objects.equals(this.serviceName, objClusterServiceCriticalFailureEvent.serviceName)&&
  Objects.equals(this.nodeName, objClusterServiceCriticalFailureEvent.nodeName);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ClusterServiceCriticalFailureEvent {\n");
      sb.append("    nodeName: ").append(toIndentedString(nodeName)).append("\n");
        sb.append("    serviceName: ").append(toIndentedString(serviceName)).append("\n");
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

