package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VsError is a POJO class extends AviRestResource that used for creating
 * VsError.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VsError  {
    @JsonProperty("event_timestamp")
    private TimeStamp eventTimestamp = null;

    @JsonProperty("reason")
    private List<String> reason = null;

    @JsonProperty("se_group_ha_mode")
    private String seGroupHaMode = null;

    @JsonProperty("se_group_ref")
    private String seGroupRef = null;

    @JsonProperty("se_ref")
    private String seRef = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("traffic_status")
    private String trafficStatus = null;

    @JsonProperty("vip_id")
    private String vipId = null;

    @JsonProperty("vs_ref")
    private String vsRef = null;



  /**
   * This is the getter method this will return the attribute value.
   * The time at which the error occurred.
   * Field introduced in 18.2.10.
   * @return eventTimestamp
   */
  public TimeStamp getEventTimestamp() {
    return eventTimestamp;
  }

  /**
   * This is the setter method to the attribute.
   * The time at which the error occurred.
   * Field introduced in 18.2.10.
   * @param eventTimestamp set the eventTimestamp.
   */
  public void setEventTimestamp(TimeStamp eventTimestamp) {
    this.eventTimestamp = eventTimestamp;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property reason of obj type vserror field type str  type array.
   * @return reason
   */
  public List<String> getReason() {
    return reason;
  }

  /**
   * This is the setter method. this will set the reason
   * Placeholder for description of property reason of obj type vserror field type str  type array.
   * @return reason
   */
  public void setReason(List<String>  reason) {
    this.reason = reason;
  }

  /**
   * This is the setter method this will set the reason
   * Placeholder for description of property reason of obj type vserror field type str  type array.
   * @return reason
   */
  public VsError addReasonItem(String reasonItem) {
    if (this.reason == null) {
      this.reason = new ArrayList<String>();
    }
    this.reason.add(reasonItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - HA_MODE_SHARED_PAIR, HA_MODE_SHARED, HA_MODE_LEGACY_ACTIVE_STANDBY.
   * @return seGroupHaMode
   */
  public String getSeGroupHaMode() {
    return seGroupHaMode;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - HA_MODE_SHARED_PAIR, HA_MODE_SHARED, HA_MODE_LEGACY_ACTIVE_STANDBY.
   * @param seGroupHaMode set the seGroupHaMode.
   */
  public void setSeGroupHaMode(String  seGroupHaMode) {
    this.seGroupHaMode = seGroupHaMode;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type serviceenginegroup.
   * @return seGroupRef
   */
  public String getSeGroupRef() {
    return seGroupRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type serviceenginegroup.
   * @param seGroupRef set the seGroupRef.
   */
  public void setSeGroupRef(String  seGroupRef) {
    this.seGroupRef = seGroupRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The se on which the vs errored during scale-in/scale-out operations.
   * It is a reference to an object of type serviceengine.
   * Field introduced in 18.2.10.
   * @return seRef
   */
  public String getSeRef() {
    return seRef;
  }

  /**
   * This is the setter method to the attribute.
   * The se on which the vs errored during scale-in/scale-out operations.
   * It is a reference to an object of type serviceengine.
   * Field introduced in 18.2.10.
   * @param seRef set the seRef.
   */
  public void setSeRef(String  seRef) {
    this.seRef = seRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type tenant.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type tenant.
   * @param tenantRef set the tenantRef.
   */
  public void setTenantRef(String  tenantRef) {
    this.tenantRef = tenantRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - TRAFFIC_DISRUPTED, TRAFFIC_NOT_DISRUPTED.
   * @return trafficStatus
   */
  public String getTrafficStatus() {
    return trafficStatus;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - TRAFFIC_DISRUPTED, TRAFFIC_NOT_DISRUPTED.
   * @param trafficStatus set the trafficStatus.
   */
  public void setTrafficStatus(String  trafficStatus) {
    this.trafficStatus = trafficStatus;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vip_id of obj type vserror field type str  type string.
   * @return vipId
   */
  public String getVipId() {
    return vipId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vip_id of obj type vserror field type str  type string.
   * @param vipId set the vipId.
   */
  public void setVipId(String  vipId) {
    this.vipId = vipId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type virtualservice.
   * @return vsRef
   */
  public String getVsRef() {
    return vsRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type virtualservice.
   * @param vsRef set the vsRef.
   */
  public void setVsRef(String  vsRef) {
    this.vsRef = vsRef;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VsError objVsError = (VsError) o;
  return   Objects.equals(this.vipId, objVsError.vipId)&&
  Objects.equals(this.trafficStatus, objVsError.trafficStatus)&&
  Objects.equals(this.vsRef, objVsError.vsRef)&&
  Objects.equals(this.eventTimestamp, objVsError.eventTimestamp)&&
  Objects.equals(this.seGroupHaMode, objVsError.seGroupHaMode)&&
  Objects.equals(this.reason, objVsError.reason)&&
  Objects.equals(this.seRef, objVsError.seRef)&&
  Objects.equals(this.seGroupRef, objVsError.seGroupRef)&&
  Objects.equals(this.tenantRef, objVsError.tenantRef);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VsError {\n");
      sb.append("    eventTimestamp: ").append(toIndentedString(eventTimestamp)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    seGroupHaMode: ").append(toIndentedString(seGroupHaMode)).append("\n");
        sb.append("    seGroupRef: ").append(toIndentedString(seGroupRef)).append("\n");
        sb.append("    seRef: ").append(toIndentedString(seRef)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
        sb.append("    trafficStatus: ").append(toIndentedString(trafficStatus)).append("\n");
        sb.append("    vipId: ").append(toIndentedString(vipId)).append("\n");
        sb.append("    vsRef: ").append(toIndentedString(vsRef)).append("\n");
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

