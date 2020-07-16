package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SeHmEventGSDetails is a POJO class extends AviRestResource that used for creating
 * SeHmEventGSDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeHmEventGSDetails  {
    @JsonProperty("gslb_service")
    private String gslbService = null;

    @JsonProperty("ha_reason")
    private String haReason = null;

    @JsonProperty("reason")
    private String reason = null;

    @JsonProperty("se_name")
    private String seName = null;

    @JsonProperty("src_uuid")
    private String srcUuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Gslbservice name.
   * It is a reference to an object of type gslbservice.
   * @return gslbService
   */
  public String getGslbService() {
    return gslbService;
  }

  /**
   * This is the setter method to the attribute.
   * Gslbservice name.
   * It is a reference to an object of type gslbservice.
   * @param gslbService set the gslbService.
   */
  public void setGslbService(String  gslbService) {
    this.gslbService = gslbService;
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
   * Reason gslb service is down.
   * @return reason
   */
  public String getReason() {
    return reason;
  }

  /**
   * This is the setter method to the attribute.
   * Reason gslb service is down.
   * @param reason set the reason.
   */
  public void setReason(String  reason) {
    this.reason = reason;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Service engine name.
   * @return seName
   */
  public String getSeName() {
    return seName;
  }

  /**
   * This is the setter method to the attribute.
   * Service engine name.
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
  SeHmEventGSDetails objSeHmEventGSDetails = (SeHmEventGSDetails) o;
  return   Objects.equals(this.gslbService, objSeHmEventGSDetails.gslbService)&&
  Objects.equals(this.seName, objSeHmEventGSDetails.seName)&&
  Objects.equals(this.reason, objSeHmEventGSDetails.reason)&&
  Objects.equals(this.srcUuid, objSeHmEventGSDetails.srcUuid)&&
  Objects.equals(this.haReason, objSeHmEventGSDetails.haReason);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SeHmEventGSDetails {\n");
      sb.append("    gslbService: ").append(toIndentedString(gslbService)).append("\n");
        sb.append("    haReason: ").append(toIndentedString(haReason)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
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

