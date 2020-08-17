package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ConnectionClearFilter is a POJO class extends AviRestResource that used for creating
 * ConnectionClearFilter.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConnectionClearFilter  {
    @JsonProperty("ip_addr")
    private String ipAddr = null;

    @JsonProperty("port")
    private Integer port = null;



  /**
   * This is the getter method this will return the attribute value.
   * Ip address in dotted decimal notation.
   * @return ipAddr
   */
  public String getIpAddr() {
    return ipAddr;
  }

  /**
   * This is the setter method to the attribute.
   * Ip address in dotted decimal notation.
   * @param ipAddr set the ipAddr.
   */
  public void setIpAddr(String  ipAddr) {
    this.ipAddr = ipAddr;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Port number.
   * @return port
   */
  public Integer getPort() {
    return port;
  }

  /**
   * This is the setter method to the attribute.
   * Port number.
   * @param port set the port.
   */
  public void setPort(Integer  port) {
    this.port = port;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ConnectionClearFilter objConnectionClearFilter = (ConnectionClearFilter) o;
  return   Objects.equals(this.ipAddr, objConnectionClearFilter.ipAddr)&&
  Objects.equals(this.port, objConnectionClearFilter.port);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ConnectionClearFilter {\n");
      sb.append("    ipAddr: ").append(toIndentedString(ipAddr)).append("\n");
        sb.append("    port: ").append(toIndentedString(port)).append("\n");
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

