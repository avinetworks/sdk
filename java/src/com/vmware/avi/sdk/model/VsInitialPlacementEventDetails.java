package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VsInitialPlacementEventDetails is a POJO class extends AviRestResource that used for creating
 * VsInitialPlacementEventDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VsInitialPlacementEventDetails  {
    @JsonProperty("error_message")
    private String errorMessage = null;

    @JsonProperty("ip")
    private String ip = null;

    @JsonProperty("rpc_status")
    private Integer rpcStatus = null;

    @JsonProperty("se_assigned")
    private List<VipSeAssigned> seAssigned = null;

    @JsonProperty("se_requested")
    private VirtualServiceResource seRequested = null;

    @JsonProperty("vs_uuid")
    private String vsUuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property error_message of obj type vsinitialplacementeventdetails field type str  type string.
   * @return errorMessage
   */
  public String getErrorMessage() {
    return errorMessage;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property error_message of obj type vsinitialplacementeventdetails field type str  type string.
   * @param errorMessage set the errorMessage.
   */
  public void setErrorMessage(String  errorMessage) {
    this.errorMessage = errorMessage;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ip of obj type vsinitialplacementeventdetails field type str  type string.
   * @return ip
   */
  public String getIp() {
    return ip;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ip of obj type vsinitialplacementeventdetails field type str  type string.
   * @param ip set the ip.
   */
  public void setIp(String  ip) {
    this.ip = ip;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property rpc_status of obj type vsinitialplacementeventdetails field type str  type integer.
   * @return rpcStatus
   */
  public Integer getRpcStatus() {
    return rpcStatus;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property rpc_status of obj type vsinitialplacementeventdetails field type str  type integer.
   * @param rpcStatus set the rpcStatus.
   */
  public void setRpcStatus(Integer  rpcStatus) {
    this.rpcStatus = rpcStatus;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_assigned of obj type vsinitialplacementeventdetails field type str  type array.
   * @return seAssigned
   */
  public List<VipSeAssigned> getSeAssigned() {
    return seAssigned;
  }

  /**
   * This is the setter method. this will set the seAssigned
   * Placeholder for description of property se_assigned of obj type vsinitialplacementeventdetails field type str  type array.
   * @return seAssigned
   */
  public void setSeAssigned(List<VipSeAssigned>  seAssigned) {
    this.seAssigned = seAssigned;
  }

  /**
   * This is the setter method this will set the seAssigned
   * Placeholder for description of property se_assigned of obj type vsinitialplacementeventdetails field type str  type array.
   * @return seAssigned
   */
  public VsInitialPlacementEventDetails addSeAssignedItem(VipSeAssigned seAssignedItem) {
    if (this.seAssigned == null) {
      this.seAssigned = new ArrayList<VipSeAssigned>();
    }
    this.seAssigned.add(seAssignedItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_requested of obj type vsinitialplacementeventdetails field type str  type ref.
   * @return seRequested
   */
  public VirtualServiceResource getSeRequested() {
    return seRequested;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_requested of obj type vsinitialplacementeventdetails field type str  type ref.
   * @param seRequested set the seRequested.
   */
  public void setSeRequested(VirtualServiceResource seRequested) {
    this.seRequested = seRequested;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of vs.
   * @return vsUuid
   */
  public String getVsUuid() {
    return vsUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of vs.
   * @param vsUuid set the vsUuid.
   */
  public void setVsUuid(String  vsUuid) {
    this.vsUuid = vsUuid;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VsInitialPlacementEventDetails objVsInitialPlacementEventDetails = (VsInitialPlacementEventDetails) o;
  return   Objects.equals(this.rpcStatus, objVsInitialPlacementEventDetails.rpcStatus)&&
  Objects.equals(this.seRequested, objVsInitialPlacementEventDetails.seRequested)&&
  Objects.equals(this.ip, objVsInitialPlacementEventDetails.ip)&&
  Objects.equals(this.errorMessage, objVsInitialPlacementEventDetails.errorMessage)&&
  Objects.equals(this.vsUuid, objVsInitialPlacementEventDetails.vsUuid)&&
  Objects.equals(this.seAssigned, objVsInitialPlacementEventDetails.seAssigned);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VsInitialPlacementEventDetails {\n");
      sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
        sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
        sb.append("    rpcStatus: ").append(toIndentedString(rpcStatus)).append("\n");
        sb.append("    seAssigned: ").append(toIndentedString(seAssigned)).append("\n");
        sb.append("    seRequested: ").append(toIndentedString(seRequested)).append("\n");
        sb.append("    vsUuid: ").append(toIndentedString(vsUuid)).append("\n");
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

