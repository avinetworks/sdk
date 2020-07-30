package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The RmModifyVnic is a POJO class extends AviRestResource that used for creating
 * RmModifyVnic.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RmModifyVnic  {
    @JsonProperty("mac_addr")
    private String macAddr = null;

    @JsonProperty("network_name")
    private String networkName = null;

    @JsonProperty("network_uuid")
    private String networkUuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property mac_addr of obj type rmmodifyvnic field type str  type string.
   * @return macAddr
   */
  public String getMacAddr() {
    return macAddr;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property mac_addr of obj type rmmodifyvnic field type str  type string.
   * @param macAddr set the macAddr.
   */
  public void setMacAddr(String  macAddr) {
    this.macAddr = macAddr;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property network_name of obj type rmmodifyvnic field type str  type string.
   * @return networkName
   */
  public String getNetworkName() {
    return networkName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property network_name of obj type rmmodifyvnic field type str  type string.
   * @param networkName set the networkName.
   */
  public void setNetworkName(String  networkName) {
    this.networkName = networkName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of network.
   * @return networkUuid
   */
  public String getNetworkUuid() {
    return networkUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of network.
   * @param networkUuid set the networkUuid.
   */
  public void setNetworkUuid(String  networkUuid) {
    this.networkUuid = networkUuid;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  RmModifyVnic objRmModifyVnic = (RmModifyVnic) o;
  return   Objects.equals(this.macAddr, objRmModifyVnic.macAddr)&&
  Objects.equals(this.networkUuid, objRmModifyVnic.networkUuid)&&
  Objects.equals(this.networkName, objRmModifyVnic.networkName);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class RmModifyVnic {\n");
      sb.append("    macAddr: ").append(toIndentedString(macAddr)).append("\n");
        sb.append("    networkName: ").append(toIndentedString(networkName)).append("\n");
        sb.append("    networkUuid: ").append(toIndentedString(networkUuid)).append("\n");
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

