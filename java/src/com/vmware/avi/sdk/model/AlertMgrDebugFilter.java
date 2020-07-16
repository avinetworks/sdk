package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The AlertMgrDebugFilter is a POJO class extends AviRestResource that used for creating
 * AlertMgrDebugFilter.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlertMgrDebugFilter  {
    @JsonProperty("alert_objid")
    private String alertObjid = null;

    @JsonProperty("alert_uuid")
    private String alertUuid = null;

    @JsonProperty("cfg_uuid")
    private String cfgUuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Filter debugs for entity uuid.
   * @return alertObjid
   */
  public String getAlertObjid() {
    return alertObjid;
  }

  /**
   * This is the setter method to the attribute.
   * Filter debugs for entity uuid.
   * @param alertObjid set the alertObjid.
   */
  public void setAlertObjid(String  alertObjid) {
    this.alertObjid = alertObjid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Filter debugs for an alert id.
   * @return alertUuid
   */
  public String getAlertUuid() {
    return alertUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Filter debugs for an alert id.
   * @param alertUuid set the alertUuid.
   */
  public void setAlertUuid(String  alertUuid) {
    this.alertUuid = alertUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Filter debugs for an alert config.
   * @return cfgUuid
   */
  public String getCfgUuid() {
    return cfgUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Filter debugs for an alert config.
   * @param cfgUuid set the cfgUuid.
   */
  public void setCfgUuid(String  cfgUuid) {
    this.cfgUuid = cfgUuid;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  AlertMgrDebugFilter objAlertMgrDebugFilter = (AlertMgrDebugFilter) o;
  return   Objects.equals(this.cfgUuid, objAlertMgrDebugFilter.cfgUuid)&&
  Objects.equals(this.alertUuid, objAlertMgrDebugFilter.alertUuid)&&
  Objects.equals(this.alertObjid, objAlertMgrDebugFilter.alertObjid);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class AlertMgrDebugFilter {\n");
      sb.append("    alertObjid: ").append(toIndentedString(alertObjid)).append("\n");
        sb.append("    alertUuid: ").append(toIndentedString(alertUuid)).append("\n");
        sb.append("    cfgUuid: ").append(toIndentedString(cfgUuid)).append("\n");
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

