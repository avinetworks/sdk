package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The RmDeleteSeEventDetails is a POJO class extends AviRestResource that used for creating
 * RmDeleteSeEventDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RmDeleteSeEventDetails  {
    @JsonProperty("cloud_name")
    private String cloudName = null;

    @JsonProperty("cloud_uuid")
    private String cloudUuid = null;

    @JsonProperty("host_name")
    private String hostName = null;

    @JsonProperty("host_uuid")
    private String hostUuid = null;

    @JsonProperty("reason")
    private String reason = null;

    @JsonProperty("se_cookie")
    private String seCookie = null;

    @JsonProperty("se_grp_name")
    private String seGrpName = null;

    @JsonProperty("se_grp_uuid")
    private String seGrpUuid = null;

    @JsonProperty("se_name")
    private String seName = null;

    @JsonProperty("se_uuid")
    private String seUuid = null;

    @JsonProperty("status_code")
    private Integer statusCode = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cloud_name of obj type rmdeleteseeventdetails field type str  type string.
   * @return cloudName
   */
  public String getCloudName() {
    return cloudName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cloud_name of obj type rmdeleteseeventdetails field type str  type string.
   * @param cloudName set the cloudName.
   */
  public void setCloudName(String  cloudName) {
    this.cloudName = cloudName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of cloud.
   * @return cloudUuid
   */
  public String getCloudUuid() {
    return cloudUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of cloud.
   * @param cloudUuid set the cloudUuid.
   */
  public void setCloudUuid(String  cloudUuid) {
    this.cloudUuid = cloudUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property host_name of obj type rmdeleteseeventdetails field type str  type string.
   * @return hostName
   */
  public String getHostName() {
    return hostName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property host_name of obj type rmdeleteseeventdetails field type str  type string.
   * @param hostName set the hostName.
   */
  public void setHostName(String  hostName) {
    this.hostName = hostName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of host.
   * @return hostUuid
   */
  public String getHostUuid() {
    return hostUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of host.
   * @param hostUuid set the hostUuid.
   */
  public void setHostUuid(String  hostUuid) {
    this.hostUuid = hostUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property reason of obj type rmdeleteseeventdetails field type str  type string.
   * @return reason
   */
  public String getReason() {
    return reason;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property reason of obj type rmdeleteseeventdetails field type str  type string.
   * @param reason set the reason.
   */
  public void setReason(String  reason) {
    this.reason = reason;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_cookie of obj type rmdeleteseeventdetails field type str  type string.
   * @return seCookie
   */
  public String getSeCookie() {
    return seCookie;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_cookie of obj type rmdeleteseeventdetails field type str  type string.
   * @param seCookie set the seCookie.
   */
  public void setSeCookie(String  seCookie) {
    this.seCookie = seCookie;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_grp_name of obj type rmdeleteseeventdetails field type str  type string.
   * @return seGrpName
   */
  public String getSeGrpName() {
    return seGrpName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_grp_name of obj type rmdeleteseeventdetails field type str  type string.
   * @param seGrpName set the seGrpName.
   */
  public void setSeGrpName(String  seGrpName) {
    this.seGrpName = seGrpName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of se_grp.
   * @return seGrpUuid
   */
  public String getSeGrpUuid() {
    return seGrpUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of se_grp.
   * @param seGrpUuid set the seGrpUuid.
   */
  public void setSeGrpUuid(String  seGrpUuid) {
    this.seGrpUuid = seGrpUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_name of obj type rmdeleteseeventdetails field type str  type string.
   * @return seName
   */
  public String getSeName() {
    return seName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_name of obj type rmdeleteseeventdetails field type str  type string.
   * @param seName set the seName.
   */
  public void setSeName(String  seName) {
    this.seName = seName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of se.
   * @return seUuid
   */
  public String getSeUuid() {
    return seUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of se.
   * @param seUuid set the seUuid.
   */
  public void setSeUuid(String  seUuid) {
    this.seUuid = seUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property status_code of obj type rmdeleteseeventdetails field type str  type integer.
   * @return statusCode
   */
  public Integer getStatusCode() {
    return statusCode;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property status_code of obj type rmdeleteseeventdetails field type str  type integer.
   * @param statusCode set the statusCode.
   */
  public void setStatusCode(Integer  statusCode) {
    this.statusCode = statusCode;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  RmDeleteSeEventDetails objRmDeleteSeEventDetails = (RmDeleteSeEventDetails) o;
  return   Objects.equals(this.seGrpUuid, objRmDeleteSeEventDetails.seGrpUuid)&&
  Objects.equals(this.cloudName, objRmDeleteSeEventDetails.cloudName)&&
  Objects.equals(this.seCookie, objRmDeleteSeEventDetails.seCookie)&&
  Objects.equals(this.statusCode, objRmDeleteSeEventDetails.statusCode)&&
  Objects.equals(this.cloudUuid, objRmDeleteSeEventDetails.cloudUuid)&&
  Objects.equals(this.seGrpName, objRmDeleteSeEventDetails.seGrpName)&&
  Objects.equals(this.reason, objRmDeleteSeEventDetails.reason)&&
  Objects.equals(this.hostName, objRmDeleteSeEventDetails.hostName)&&
  Objects.equals(this.seName, objRmDeleteSeEventDetails.seName)&&
  Objects.equals(this.hostUuid, objRmDeleteSeEventDetails.hostUuid)&&
  Objects.equals(this.seUuid, objRmDeleteSeEventDetails.seUuid);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class RmDeleteSeEventDetails {\n");
      sb.append("    cloudName: ").append(toIndentedString(cloudName)).append("\n");
        sb.append("    cloudUuid: ").append(toIndentedString(cloudUuid)).append("\n");
        sb.append("    hostName: ").append(toIndentedString(hostName)).append("\n");
        sb.append("    hostUuid: ").append(toIndentedString(hostUuid)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    seCookie: ").append(toIndentedString(seCookie)).append("\n");
        sb.append("    seGrpName: ").append(toIndentedString(seGrpName)).append("\n");
        sb.append("    seGrpUuid: ").append(toIndentedString(seGrpUuid)).append("\n");
        sb.append("    seName: ").append(toIndentedString(seName)).append("\n");
        sb.append("    seUuid: ").append(toIndentedString(seUuid)).append("\n");
        sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
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

