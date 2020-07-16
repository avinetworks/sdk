package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VipSeAssigned is a POJO class extends AviRestResource that used for creating
 * VipSeAssigned.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VipSeAssigned  {
    @JsonProperty("admin_down_requested")
    private Boolean adminDownRequested = false;

    @JsonProperty("connected")
    private Boolean connected = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("oper_status")
    private OperationalStatus operStatus = null;

    @JsonProperty("primary")
    private Boolean primary = null;

    @JsonProperty("ref")
    private String ref = null;

    @JsonProperty("scalein_in_progress")
    private Boolean scaleinInProgress = false;

    @JsonProperty("snat_ip")
    private IpAddr snatIp = null;

    @JsonProperty("standby")
    private Boolean standby = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property admin_down_requested of obj type vipseassigned field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return adminDownRequested
   */
  public Boolean getAdminDownRequested() {
    return adminDownRequested;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property admin_down_requested of obj type vipseassigned field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param adminDownRequested set the adminDownRequested.
   */
  public void setAdminDownRequested(Boolean  adminDownRequested) {
    this.adminDownRequested = adminDownRequested;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property connected of obj type vipseassigned field type str  type boolean.
   * @return connected
   */
  public Boolean getConnected() {
    return connected;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property connected of obj type vipseassigned field type str  type boolean.
   * @param connected set the connected.
   */
  public void setConnected(Boolean  connected) {
    this.connected = connected;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the object.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the object.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property oper_status of obj type vipseassigned field type str  type ref.
   * @return operStatus
   */
  public OperationalStatus getOperStatus() {
    return operStatus;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property oper_status of obj type vipseassigned field type str  type ref.
   * @param operStatus set the operStatus.
   */
  public void setOperStatus(OperationalStatus operStatus) {
    this.operStatus = operStatus;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property primary of obj type vipseassigned field type str  type boolean.
   * @return primary
   */
  public Boolean getPrimary() {
    return primary;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property primary of obj type vipseassigned field type str  type boolean.
   * @param primary set the primary.
   */
  public void setPrimary(Boolean  primary) {
    this.primary = primary;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type serviceengine.
   * @return ref
   */
  public String getRef() {
    return ref;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type serviceengine.
   * @param ref set the ref.
   */
  public void setRef(String  ref) {
    this.ref = ref;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property scalein_in_progress of obj type vipseassigned field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return scaleinInProgress
   */
  public Boolean getScaleinInProgress() {
    return scaleinInProgress;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property scalein_in_progress of obj type vipseassigned field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param scaleinInProgress set the scaleinInProgress.
   */
  public void setScaleinInProgress(Boolean  scaleinInProgress) {
    this.scaleinInProgress = scaleinInProgress;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property snat_ip of obj type vipseassigned field type str  type ref.
   * @return snatIp
   */
  public IpAddr getSnatIp() {
    return snatIp;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property snat_ip of obj type vipseassigned field type str  type ref.
   * @param snatIp set the snatIp.
   */
  public void setSnatIp(IpAddr snatIp) {
    this.snatIp = snatIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property standby of obj type vipseassigned field type str  type boolean.
   * @return standby
   */
  public Boolean getStandby() {
    return standby;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property standby of obj type vipseassigned field type str  type boolean.
   * @param standby set the standby.
   */
  public void setStandby(Boolean  standby) {
    this.standby = standby;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VipSeAssigned objVipSeAssigned = (VipSeAssigned) o;
  return   Objects.equals(this.standby, objVipSeAssigned.standby)&&
  Objects.equals(this.adminDownRequested, objVipSeAssigned.adminDownRequested)&&
  Objects.equals(this.primary, objVipSeAssigned.primary)&&
  Objects.equals(this.operStatus, objVipSeAssigned.operStatus)&&
  Objects.equals(this.snatIp, objVipSeAssigned.snatIp)&&
  Objects.equals(this.connected, objVipSeAssigned.connected)&&
  Objects.equals(this.ref, objVipSeAssigned.ref)&&
  Objects.equals(this.scaleinInProgress, objVipSeAssigned.scaleinInProgress)&&
  Objects.equals(this.name, objVipSeAssigned.name);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VipSeAssigned {\n");
      sb.append("    adminDownRequested: ").append(toIndentedString(adminDownRequested)).append("\n");
        sb.append("    connected: ").append(toIndentedString(connected)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    operStatus: ").append(toIndentedString(operStatus)).append("\n");
        sb.append("    primary: ").append(toIndentedString(primary)).append("\n");
        sb.append("    ref: ").append(toIndentedString(ref)).append("\n");
        sb.append("    scaleinInProgress: ").append(toIndentedString(scaleinInProgress)).append("\n");
        sb.append("    snatIp: ").append(toIndentedString(snatIp)).append("\n");
        sb.append("    standby: ").append(toIndentedString(standby)).append("\n");
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

