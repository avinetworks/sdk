package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VsMigrateEventDetails is a POJO class extends AviRestResource that used for creating
 * VsMigrateEventDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VsMigrateEventDetails  {
    @JsonProperty("error_message")
    private String errorMessage = null;

    @JsonProperty("ip")
    private String ip = null;

    @JsonProperty("ip6")
    private String ip6 = null;

    @JsonProperty("rpc_status")
    private Integer rpcStatus = null;

    @JsonProperty("scale_status")
    private ScaleStatus scaleStatus = null;

    @JsonProperty("se_assigned")
    private List<VipSeAssigned> seAssigned = null;

    @JsonProperty("se_requested")
    private VirtualServiceResource seRequested = null;

    @JsonProperty("vs_uuid")
    private String vsUuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property error_message of obj type vsmigrateeventdetails field type str  type string.
   * @return errorMessage
   */
  public String getErrorMessage() {
    return errorMessage;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property error_message of obj type vsmigrateeventdetails field type str  type string.
   * @param errorMessage set the errorMessage.
   */
  public void setErrorMessage(String  errorMessage) {
    this.errorMessage = errorMessage;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ip of obj type vsmigrateeventdetails field type str  type string.
   * @return ip
   */
  public String getIp() {
    return ip;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ip of obj type vsmigrateeventdetails field type str  type string.
   * @param ip set the ip.
   */
  public void setIp(String  ip) {
    this.ip = ip;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ip6 of obj type vsmigrateeventdetails field type str  type string.
   * @return ip6
   */
  public String getIp6() {
    return ip6;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ip6 of obj type vsmigrateeventdetails field type str  type string.
   * @param ip6 set the ip6.
   */
  public void setIp6(String  ip6) {
    this.ip6 = ip6;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property rpc_status of obj type vsmigrateeventdetails field type str  type integer.
   * @return rpcStatus
   */
  public Integer getRpcStatus() {
    return rpcStatus;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property rpc_status of obj type vsmigrateeventdetails field type str  type integer.
   * @param rpcStatus set the rpcStatus.
   */
  public void setRpcStatus(Integer  rpcStatus) {
    this.rpcStatus = rpcStatus;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property scale_status of obj type vsmigrateeventdetails field type str  type ref.
   * @return scaleStatus
   */
  public ScaleStatus getScaleStatus() {
    return scaleStatus;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property scale_status of obj type vsmigrateeventdetails field type str  type ref.
   * @param scaleStatus set the scaleStatus.
   */
  public void setScaleStatus(ScaleStatus scaleStatus) {
    this.scaleStatus = scaleStatus;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_assigned of obj type vsmigrateeventdetails field type str  type array.
   * @return seAssigned
   */
  public List<VipSeAssigned> getSeAssigned() {
    return seAssigned;
  }

  /**
   * This is the setter method. this will set the seAssigned
   * Placeholder for description of property se_assigned of obj type vsmigrateeventdetails field type str  type array.
   * @return seAssigned
   */
  public void setSeAssigned(List<VipSeAssigned>  seAssigned) {
    this.seAssigned = seAssigned;
  }

  /**
   * This is the setter method this will set the seAssigned
   * Placeholder for description of property se_assigned of obj type vsmigrateeventdetails field type str  type array.
   * @return seAssigned
   */
  public VsMigrateEventDetails addSeAssignedItem(VipSeAssigned seAssignedItem) {
    if (this.seAssigned == null) {
      this.seAssigned = new ArrayList<VipSeAssigned>();
    }
    this.seAssigned.add(seAssignedItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_requested of obj type vsmigrateeventdetails field type str  type ref.
   * @return seRequested
   */
  public VirtualServiceResource getSeRequested() {
    return seRequested;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_requested of obj type vsmigrateeventdetails field type str  type ref.
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
  VsMigrateEventDetails objVsMigrateEventDetails = (VsMigrateEventDetails) o;
  return   Objects.equals(this.rpcStatus, objVsMigrateEventDetails.rpcStatus)&&
  Objects.equals(this.seRequested, objVsMigrateEventDetails.seRequested)&&
  Objects.equals(this.scaleStatus, objVsMigrateEventDetails.scaleStatus)&&
  Objects.equals(this.ip, objVsMigrateEventDetails.ip)&&
  Objects.equals(this.errorMessage, objVsMigrateEventDetails.errorMessage)&&
  Objects.equals(this.vsUuid, objVsMigrateEventDetails.vsUuid)&&
  Objects.equals(this.ip6, objVsMigrateEventDetails.ip6)&&
  Objects.equals(this.seAssigned, objVsMigrateEventDetails.seAssigned);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VsMigrateEventDetails {\n");
      sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
        sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
        sb.append("    ip6: ").append(toIndentedString(ip6)).append("\n");
        sb.append("    rpcStatus: ").append(toIndentedString(rpcStatus)).append("\n");
        sb.append("    scaleStatus: ").append(toIndentedString(scaleStatus)).append("\n");
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

