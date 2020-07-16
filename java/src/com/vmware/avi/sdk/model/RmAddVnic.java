package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The RmAddVnic is a POJO class extends AviRestResource that used for creating
 * RmAddVnic.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RmAddVnic  {
    @JsonProperty("network_name")
    private String networkName = null;

    @JsonProperty("network_uuid")
    private String networkUuid = null;

    @JsonProperty("subnet")
    private String subnet = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property network_name of obj type rmaddvnic field type str  type string.
   * @return networkName
   */
  public String getNetworkName() {
    return networkName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property network_name of obj type rmaddvnic field type str  type string.
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

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property subnet of obj type rmaddvnic field type str  type string.
   * @return subnet
   */
  public String getSubnet() {
    return subnet;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property subnet of obj type rmaddvnic field type str  type string.
   * @param subnet set the subnet.
   */
  public void setSubnet(String  subnet) {
    this.subnet = subnet;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  RmAddVnic objRmAddVnic = (RmAddVnic) o;
  return   Objects.equals(this.networkName, objRmAddVnic.networkName)&&
  Objects.equals(this.networkUuid, objRmAddVnic.networkUuid)&&
  Objects.equals(this.subnet, objRmAddVnic.subnet);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class RmAddVnic {\n");
      sb.append("    networkName: ").append(toIndentedString(networkName)).append("\n");
        sb.append("    networkUuid: ").append(toIndentedString(networkUuid)).append("\n");
        sb.append("    subnet: ").append(toIndentedString(subnet)).append("\n");
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

