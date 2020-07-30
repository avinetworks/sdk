package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ClusterNodeDbFailedEvent is a POJO class extends AviRestResource that used for creating
 * ClusterNodeDbFailedEvent.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClusterNodeDbFailedEvent  {
    @JsonProperty("failure_count")
    private Integer failureCount = null;

    @JsonProperty("ip")
    private IpAddr ip = null;

    @JsonProperty("node_name")
    private String nodeName = null;



  /**
   * This is the getter method this will return the attribute value.
   * Number of failures.
   * @return failureCount
   */
  public Integer getFailureCount() {
    return failureCount;
  }

  /**
   * This is the setter method to the attribute.
   * Number of failures.
   * @param failureCount set the failureCount.
   */
  public void setFailureCount(Integer  failureCount) {
    this.failureCount = failureCount;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ip address of the controller vm.
   * @return ip
   */
  public IpAddr getIp() {
    return ip;
  }

  /**
   * This is the setter method to the attribute.
   * Ip address of the controller vm.
   * @param ip set the ip.
   */
  public void setIp(IpAddr ip) {
    this.ip = ip;
  }

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


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ClusterNodeDbFailedEvent objClusterNodeDbFailedEvent = (ClusterNodeDbFailedEvent) o;
  return   Objects.equals(this.nodeName, objClusterNodeDbFailedEvent.nodeName)&&
  Objects.equals(this.ip, objClusterNodeDbFailedEvent.ip)&&
  Objects.equals(this.failureCount, objClusterNodeDbFailedEvent.failureCount);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ClusterNodeDbFailedEvent {\n");
      sb.append("    failureCount: ").append(toIndentedString(failureCount)).append("\n");
        sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
        sb.append("    nodeName: ").append(toIndentedString(nodeName)).append("\n");
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

