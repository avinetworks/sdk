package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SCServerStateInfo is a POJO class extends AviRestResource that used for creating
 * SCServerStateInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SCServerStateInfo  {
    @JsonProperty("oper_status")
    private OperationalStatus operStatus = null;

    @JsonProperty("server_ip")
    private IpAddr serverIp = null;

    @JsonProperty("server_port")
    private Integer serverPort = null;



  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.1.1.
   * @return operStatus
   */
  public OperationalStatus getOperStatus() {
    return operStatus;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.1.1.
   * @param operStatus set the operStatus.
   */
  public void setOperStatus(OperationalStatus operStatus) {
    this.operStatus = operStatus;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.1.1.
   * @return serverIp
   */
  public IpAddr getServerIp() {
    return serverIp;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.1.1.
   * @param serverIp set the serverIp.
   */
  public void setServerIp(IpAddr serverIp) {
    this.serverIp = serverIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Allowed values are 1-65535.
   * Field introduced in 17.1.1.
   * @return serverPort
   */
  public Integer getServerPort() {
    return serverPort;
  }

  /**
   * This is the setter method to the attribute.
   * Allowed values are 1-65535.
   * Field introduced in 17.1.1.
   * @param serverPort set the serverPort.
   */
  public void setServerPort(Integer  serverPort) {
    this.serverPort = serverPort;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SCServerStateInfo objSCServerStateInfo = (SCServerStateInfo) o;
  return   Objects.equals(this.serverIp, objSCServerStateInfo.serverIp)&&
  Objects.equals(this.serverPort, objSCServerStateInfo.serverPort)&&
  Objects.equals(this.operStatus, objSCServerStateInfo.operStatus);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SCServerStateInfo {\n");
      sb.append("    operStatus: ").append(toIndentedString(operStatus)).append("\n");
        sb.append("    serverIp: ").append(toIndentedString(serverIp)).append("\n");
        sb.append("    serverPort: ").append(toIndentedString(serverPort)).append("\n");
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

