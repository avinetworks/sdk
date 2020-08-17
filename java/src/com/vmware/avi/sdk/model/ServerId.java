package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ServerId is a POJO class extends AviRestResource that used for creating
 * ServerId.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServerId  {
    @JsonProperty("external_uuid")
    private String externalUuid = null;

    @JsonProperty("ip")
    private IpAddr ip = null;

    @JsonProperty("port")
    private Integer port = null;



  /**
   * This is the getter method this will return the attribute value.
   * This is the external cloud uuid of the pool server.
   * @return externalUuid
   */
  public String getExternalUuid() {
    return externalUuid;
  }

  /**
   * This is the setter method to the attribute.
   * This is the external cloud uuid of the pool server.
   * @param externalUuid set the externalUuid.
   */
  public void setExternalUuid(String  externalUuid) {
    this.externalUuid = externalUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ip of obj type serverid field type str  type ref.
   * @return ip
   */
  public IpAddr getIp() {
    return ip;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ip of obj type serverid field type str  type ref.
   * @param ip set the ip.
   */
  public void setIp(IpAddr ip) {
    this.ip = ip;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property port of obj type serverid field type str  type integer.
   * @return port
   */
  public Integer getPort() {
    return port;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property port of obj type serverid field type str  type integer.
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
  ServerId objServerId = (ServerId) o;
  return   Objects.equals(this.ip, objServerId.ip)&&
  Objects.equals(this.port, objServerId.port)&&
  Objects.equals(this.externalUuid, objServerId.externalUuid);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ServerId {\n");
      sb.append("    externalUuid: ").append(toIndentedString(externalUuid)).append("\n");
        sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
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

