package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The OpenStackIpChange is a POJO class extends AviRestResource that used for creating
 * OpenStackIpChange.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OpenStackIpChange  {
    @JsonProperty("error_string")
    private String errorString = null;

    @JsonProperty("ip")
    private IpAddr ip = null;

    @JsonProperty("mac_addr")
    private String macAddr = null;

    @JsonProperty("port_uuid")
    private String portUuid = null;

    @JsonProperty("se_vm_uuid")
    private String seVmUuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property error_string of obj type openstackipchange field type str  type string.
   * @return errorString
   */
  public String getErrorString() {
    return errorString;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property error_string of obj type openstackipchange field type str  type string.
   * @param errorString set the errorString.
   */
  public void setErrorString(String  errorString) {
    this.errorString = errorString;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ip of obj type openstackipchange field type str  type ref.
   * @return ip
   */
  public IpAddr getIp() {
    return ip;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ip of obj type openstackipchange field type str  type ref.
   * @param ip set the ip.
   */
  public void setIp(IpAddr ip) {
    this.ip = ip;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property mac_addr of obj type openstackipchange field type str  type string.
   * @return macAddr
   */
  public String getMacAddr() {
    return macAddr;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property mac_addr of obj type openstackipchange field type str  type string.
   * @param macAddr set the macAddr.
   */
  public void setMacAddr(String  macAddr) {
    this.macAddr = macAddr;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of port.
   * @return portUuid
   */
  public String getPortUuid() {
    return portUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of port.
   * @param portUuid set the portUuid.
   */
  public void setPortUuid(String  portUuid) {
    this.portUuid = portUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of se_vm.
   * @return seVmUuid
   */
  public String getSeVmUuid() {
    return seVmUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of se_vm.
   * @param seVmUuid set the seVmUuid.
   */
  public void setSeVmUuid(String  seVmUuid) {
    this.seVmUuid = seVmUuid;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  OpenStackIpChange objOpenStackIpChange = (OpenStackIpChange) o;
  return   Objects.equals(this.ip, objOpenStackIpChange.ip)&&
  Objects.equals(this.seVmUuid, objOpenStackIpChange.seVmUuid)&&
  Objects.equals(this.portUuid, objOpenStackIpChange.portUuid)&&
  Objects.equals(this.macAddr, objOpenStackIpChange.macAddr)&&
  Objects.equals(this.errorString, objOpenStackIpChange.errorString);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class OpenStackIpChange {\n");
      sb.append("    errorString: ").append(toIndentedString(errorString)).append("\n");
        sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
        sb.append("    macAddr: ").append(toIndentedString(macAddr)).append("\n");
        sb.append("    portUuid: ").append(toIndentedString(portUuid)).append("\n");
        sb.append("    seVmUuid: ").append(toIndentedString(seVmUuid)).append("\n");
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

