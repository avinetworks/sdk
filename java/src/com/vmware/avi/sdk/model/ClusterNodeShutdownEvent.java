package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The ClusterNodeShutdownEvent is a POJO class extends AviRestResource that used for creating
 * ClusterNodeShutdownEvent.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClusterNodeShutdownEvent  {
    @JsonProperty("ip")
    private IpAddr ip = null;

    @JsonProperty("node_name")
    private String nodeName = null;

    @JsonProperty("reason")
    private String reason = null;



    /**
     * This is the getter method this will return the attribute value.
     * Ip address of the controller vm.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return ip
     */
    public IpAddr getIp() {
        return ip;
    }

    /**
     * This is the setter method to the attribute.
     * Ip address of the controller vm.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param ip set the ip.
     */
    public void setIp(IpAddr ip) {
        this.ip = ip;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Name of controller node.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return nodeName
     */
    public String getNodeName() {
        return nodeName;
    }

    /**
     * This is the setter method to the attribute.
     * Name of controller node.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param nodeName set the nodeName.
     */
    public void setNodeName(String  nodeName) {
        this.nodeName = nodeName;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Reason for controller node shutdown.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * This is the setter method to the attribute.
     * Reason for controller node shutdown.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param reason set the reason.
     */
    public void setReason(String  reason) {
        this.reason = reason;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      ClusterNodeShutdownEvent objClusterNodeShutdownEvent = (ClusterNodeShutdownEvent) o;
      return   Objects.equals(this.nodeName, objClusterNodeShutdownEvent.nodeName)&&
  Objects.equals(this.ip, objClusterNodeShutdownEvent.ip)&&
  Objects.equals(this.reason, objClusterNodeShutdownEvent.reason);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ClusterNodeShutdownEvent {\n");
                  sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
                        sb.append("    nodeName: ").append(toIndentedString(nodeName)).append("\n");
                        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
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
