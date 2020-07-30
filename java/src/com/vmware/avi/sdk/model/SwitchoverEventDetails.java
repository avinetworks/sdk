package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SwitchoverEventDetails is a POJO class extends AviRestResource that used for creating
 * SwitchoverEventDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SwitchoverEventDetails  {
    @JsonProperty("from_se_name")
    private String fromSeName = null;

    @JsonProperty("ip")
    private String ip = null;

    @JsonProperty("ip6")
    private String ip6 = null;

    @JsonProperty("to_se_name")
    private String toSeName = null;

    @JsonProperty("vs_name")
    private String vsName = null;

    @JsonProperty("vs_uuid")
    private String vsUuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property from_se_name of obj type switchovereventdetails field type str  type string.
   * @return fromSeName
   */
  public String getFromSeName() {
    return fromSeName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property from_se_name of obj type switchovereventdetails field type str  type string.
   * @param fromSeName set the fromSeName.
   */
  public void setFromSeName(String  fromSeName) {
    this.fromSeName = fromSeName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ip of obj type switchovereventdetails field type str  type string.
   * @return ip
   */
  public String getIp() {
    return ip;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ip of obj type switchovereventdetails field type str  type string.
   * @param ip set the ip.
   */
  public void setIp(String  ip) {
    this.ip = ip;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ip6 of obj type switchovereventdetails field type str  type string.
   * @return ip6
   */
  public String getIp6() {
    return ip6;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ip6 of obj type switchovereventdetails field type str  type string.
   * @param ip6 set the ip6.
   */
  public void setIp6(String  ip6) {
    this.ip6 = ip6;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property to_se_name of obj type switchovereventdetails field type str  type string.
   * @return toSeName
   */
  public String getToSeName() {
    return toSeName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property to_se_name of obj type switchovereventdetails field type str  type string.
   * @param toSeName set the toSeName.
   */
  public void setToSeName(String  toSeName) {
    this.toSeName = toSeName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vs_name of obj type switchovereventdetails field type str  type string.
   * @return vsName
   */
  public String getVsName() {
    return vsName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vs_name of obj type switchovereventdetails field type str  type string.
   * @param vsName set the vsName.
   */
  public void setVsName(String  vsName) {
    this.vsName = vsName;
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
  SwitchoverEventDetails objSwitchoverEventDetails = (SwitchoverEventDetails) o;
  return   Objects.equals(this.vsUuid, objSwitchoverEventDetails.vsUuid)&&
  Objects.equals(this.vsName, objSwitchoverEventDetails.vsName)&&
  Objects.equals(this.fromSeName, objSwitchoverEventDetails.fromSeName)&&
  Objects.equals(this.toSeName, objSwitchoverEventDetails.toSeName)&&
  Objects.equals(this.ip, objSwitchoverEventDetails.ip)&&
  Objects.equals(this.ip6, objSwitchoverEventDetails.ip6);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SwitchoverEventDetails {\n");
      sb.append("    fromSeName: ").append(toIndentedString(fromSeName)).append("\n");
        sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
        sb.append("    ip6: ").append(toIndentedString(ip6)).append("\n");
        sb.append("    toSeName: ").append(toIndentedString(toSeName)).append("\n");
        sb.append("    vsName: ").append(toIndentedString(vsName)).append("\n");
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

