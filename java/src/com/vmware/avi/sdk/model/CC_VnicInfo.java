package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The CC_VnicInfo is a POJO class extends AviRestResource that used for creating
 * CC_VnicInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CC_VnicInfo  {
    @JsonProperty("mac_address")
    private String macAddress = null;

    @JsonProperty("network_uuid")
    private String networkUuid = null;

    @JsonProperty("port_uuid")
    private String portUuid = null;

    @JsonProperty("status")
    private String status = "SYSERR_SUCCESS";

    @JsonProperty("status_string")
    private String statusString = null;

    @JsonProperty("subnet_uuid")
    private String subnetUuid = null;

    @JsonProperty("vrf_uuid")
    private String vrfUuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property mac_address of obj type cc_vnicinfo field type str  type string.
   * @return macAddress
   */
  public String getMacAddress() {
    return macAddress;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property mac_address of obj type cc_vnicinfo field type str  type string.
   * @param macAddress set the macAddress.
   */
  public void setMacAddress(String  macAddress) {
    this.macAddress = macAddress;
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
   * Enum options - SYSERR_SUCCESS, SYSERR_FAILURE, SYSERR_OUT_OF_MEMORY, SYSERR_NO_ENT, SYSERR_INVAL, SYSERR_ACCESS, SYSERR_FAULT, SYSERR_IO,
   * SYSERR_TIMEOUT, SYSERR_NOT_SUPPORTED, SYSERR_NOT_READY, SYSERR_UPGRADE_IN_PROGRESS, SYSERR_WARM_START_IN_PROGRESS, SYSERR_TRY_AGAIN,
   * SYSERR_NOT_UPGRADING, SYSERR_PENDING, SYSERR_EVENT_GEN_FAILURE, SYSERR_CONFIG_PARAM_MISSING, SYSERR_BAD_REQUEST, SYSERR_TEST1...
   * Default value when not specified in API or module is interpreted by Avi Controller as SYSERR_SUCCESS.
   * @return status
   */
  public String getStatus() {
    return status;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - SYSERR_SUCCESS, SYSERR_FAILURE, SYSERR_OUT_OF_MEMORY, SYSERR_NO_ENT, SYSERR_INVAL, SYSERR_ACCESS, SYSERR_FAULT, SYSERR_IO,
   * SYSERR_TIMEOUT, SYSERR_NOT_SUPPORTED, SYSERR_NOT_READY, SYSERR_UPGRADE_IN_PROGRESS, SYSERR_WARM_START_IN_PROGRESS, SYSERR_TRY_AGAIN,
   * SYSERR_NOT_UPGRADING, SYSERR_PENDING, SYSERR_EVENT_GEN_FAILURE, SYSERR_CONFIG_PARAM_MISSING, SYSERR_BAD_REQUEST, SYSERR_TEST1...
   * Default value when not specified in API or module is interpreted by Avi Controller as SYSERR_SUCCESS.
   * @param status set the status.
   */
  public void setStatus(String  status) {
    this.status = status;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property status_string of obj type cc_vnicinfo field type str  type string.
   * @return statusString
   */
  public String getStatusString() {
    return statusString;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property status_string of obj type cc_vnicinfo field type str  type string.
   * @param statusString set the statusString.
   */
  public void setStatusString(String  statusString) {
    this.statusString = statusString;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of subnet.
   * @return subnetUuid
   */
  public String getSubnetUuid() {
    return subnetUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of subnet.
   * @param subnetUuid set the subnetUuid.
   */
  public void setSubnetUuid(String  subnetUuid) {
    this.subnetUuid = subnetUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of vrf.
   * @return vrfUuid
   */
  public String getVrfUuid() {
    return vrfUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of vrf.
   * @param vrfUuid set the vrfUuid.
   */
  public void setVrfUuid(String  vrfUuid) {
    this.vrfUuid = vrfUuid;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  CC_VnicInfo objCC_VnicInfo = (CC_VnicInfo) o;
  return   Objects.equals(this.networkUuid, objCC_VnicInfo.networkUuid)&&
  Objects.equals(this.vrfUuid, objCC_VnicInfo.vrfUuid)&&
  Objects.equals(this.subnetUuid, objCC_VnicInfo.subnetUuid)&&
  Objects.equals(this.portUuid, objCC_VnicInfo.portUuid)&&
  Objects.equals(this.macAddress, objCC_VnicInfo.macAddress)&&
  Objects.equals(this.status, objCC_VnicInfo.status)&&
  Objects.equals(this.statusString, objCC_VnicInfo.statusString);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class CC_VnicInfo {\n");
      sb.append("    macAddress: ").append(toIndentedString(macAddress)).append("\n");
        sb.append("    networkUuid: ").append(toIndentedString(networkUuid)).append("\n");
        sb.append("    portUuid: ").append(toIndentedString(portUuid)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    statusString: ").append(toIndentedString(statusString)).append("\n");
        sb.append("    subnetUuid: ").append(toIndentedString(subnetUuid)).append("\n");
        sb.append("    vrfUuid: ").append(toIndentedString(vrfUuid)).append("\n");
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

