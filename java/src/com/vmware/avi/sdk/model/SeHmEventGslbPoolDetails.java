package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SeHmEventGslbPoolDetails is a POJO class extends AviRestResource that used for creating
 * SeHmEventGslbPoolDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeHmEventGslbPoolDetails  {
    @JsonProperty("gsgroup")
    private String gsgroup = null;

    @JsonProperty("gslb_service")
    private String gslbService = null;

    @JsonProperty("gsmember")
    private SeHmEventGslbPoolMemberDetails gsmember = null;

    @JsonProperty("ha_reason")
    private String haReason = null;

    @JsonProperty("se_name")
    private String seName = null;

    @JsonProperty("src_uuid")
    private String srcUuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Gslbservice pool name.
   * @return gsgroup
   */
  public String getGsgroup() {
    return gsgroup;
  }

  /**
   * This is the setter method to the attribute.
   * Gslbservice pool name.
   * @param gsgroup set the gsgroup.
   */
  public void setGsgroup(String  gsgroup) {
    this.gsgroup = gsgroup;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Gslb service name.
   * It is a reference to an object of type gslbservice.
   * @return gslbService
   */
  public String getGslbService() {
    return gslbService;
  }

  /**
   * This is the setter method to the attribute.
   * Gslb service name.
   * It is a reference to an object of type gslbservice.
   * @param gslbService set the gslbService.
   */
  public void setGslbService(String  gslbService) {
    this.gslbService = gslbService;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Gslbservice member details.
   * @return gsmember
   */
  public SeHmEventGslbPoolMemberDetails getGsmember() {
    return gsmember;
  }

  /**
   * This is the setter method to the attribute.
   * Gslbservice member details.
   * @param gsmember set the gsmember.
   */
  public void setGsmember(SeHmEventGslbPoolMemberDetails gsmember) {
    this.gsmember = gsmember;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ha compromised reason.
   * @return haReason
   */
  public String getHaReason() {
    return haReason;
  }

  /**
   * This is the setter method to the attribute.
   * Ha compromised reason.
   * @param haReason set the haReason.
   */
  public void setHaReason(String  haReason) {
    this.haReason = haReason;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Service engine.
   * @return seName
   */
  public String getSeName() {
    return seName;
  }

  /**
   * This is the setter method to the attribute.
   * Service engine.
   * @param seName set the seName.
   */
  public void setSeName(String  seName) {
    this.seName = seName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Uuid of the event generator.
   * @return srcUuid
   */
  public String getSrcUuid() {
    return srcUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the event generator.
   * @param srcUuid set the srcUuid.
   */
  public void setSrcUuid(String  srcUuid) {
    this.srcUuid = srcUuid;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SeHmEventGslbPoolDetails objSeHmEventGslbPoolDetails = (SeHmEventGslbPoolDetails) o;
  return   Objects.equals(this.gslbService, objSeHmEventGslbPoolDetails.gslbService)&&
  Objects.equals(this.gsgroup, objSeHmEventGslbPoolDetails.gsgroup)&&
  Objects.equals(this.gsmember, objSeHmEventGslbPoolDetails.gsmember)&&
  Objects.equals(this.seName, objSeHmEventGslbPoolDetails.seName)&&
  Objects.equals(this.haReason, objSeHmEventGslbPoolDetails.haReason)&&
  Objects.equals(this.srcUuid, objSeHmEventGslbPoolDetails.srcUuid);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SeHmEventGslbPoolDetails {\n");
      sb.append("    gsgroup: ").append(toIndentedString(gsgroup)).append("\n");
        sb.append("    gslbService: ").append(toIndentedString(gslbService)).append("\n");
        sb.append("    gsmember: ").append(toIndentedString(gsmember)).append("\n");
        sb.append("    haReason: ").append(toIndentedString(haReason)).append("\n");
        sb.append("    seName: ").append(toIndentedString(seName)).append("\n");
        sb.append("    srcUuid: ").append(toIndentedString(srcUuid)).append("\n");
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

