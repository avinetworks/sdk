package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The RmBindVsSeEventDetails is a POJO class extends AviRestResource that used for creating
 * RmBindVsSeEventDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RmBindVsSeEventDetails  {
    @JsonProperty("ip")
    private String ip = null;

    @JsonProperty("ip6")
    private String ip6 = null;

    @JsonProperty("primary")
    private Boolean primary = null;

    @JsonProperty("se_name")
    private String seName = null;

    @JsonProperty("standby")
    private Boolean standby = null;

    @JsonProperty("type")
    private String type = null;

    @JsonProperty("vip_vnics")
    private List<String> vipVnics = null;

    @JsonProperty("vs_name")
    private String vsName = null;

    @JsonProperty("vs_uuid")
    private String vsUuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ip of obj type rmbindvsseeventdetails field type str  type string.
   * @return ip
   */
  public String getIp() {
    return ip;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ip of obj type rmbindvsseeventdetails field type str  type string.
   * @param ip set the ip.
   */
  public void setIp(String  ip) {
    this.ip = ip;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ip6 of obj type rmbindvsseeventdetails field type str  type string.
   * @return ip6
   */
  public String getIp6() {
    return ip6;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ip6 of obj type rmbindvsseeventdetails field type str  type string.
   * @param ip6 set the ip6.
   */
  public void setIp6(String  ip6) {
    this.ip6 = ip6;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property primary of obj type rmbindvsseeventdetails field type str  type boolean.
   * @return primary
   */
  public Boolean getPrimary() {
    return primary;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property primary of obj type rmbindvsseeventdetails field type str  type boolean.
   * @param primary set the primary.
   */
  public void setPrimary(Boolean  primary) {
    this.primary = primary;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_name of obj type rmbindvsseeventdetails field type str  type string.
   * @return seName
   */
  public String getSeName() {
    return seName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_name of obj type rmbindvsseeventdetails field type str  type string.
   * @param seName set the seName.
   */
  public void setSeName(String  seName) {
    this.seName = seName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property standby of obj type rmbindvsseeventdetails field type str  type boolean.
   * @return standby
   */
  public Boolean getStandby() {
    return standby;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property standby of obj type rmbindvsseeventdetails field type str  type boolean.
   * @param standby set the standby.
   */
  public void setStandby(Boolean  standby) {
    this.standby = standby;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property type of obj type rmbindvsseeventdetails field type str  type string.
   * @return type
   */
  public String getType() {
    return type;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property type of obj type rmbindvsseeventdetails field type str  type string.
   * @param type set the type.
   */
  public void setType(String  type) {
    this.type = type;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vip_vnics of obj type rmbindvsseeventdetails field type str  type array.
   * @return vipVnics
   */
  public List<String> getVipVnics() {
    return vipVnics;
  }

  /**
   * This is the setter method. this will set the vipVnics
   * Placeholder for description of property vip_vnics of obj type rmbindvsseeventdetails field type str  type array.
   * @return vipVnics
   */
  public void setVipVnics(List<String>  vipVnics) {
    this.vipVnics = vipVnics;
  }

  /**
   * This is the setter method this will set the vipVnics
   * Placeholder for description of property vip_vnics of obj type rmbindvsseeventdetails field type str  type array.
   * @return vipVnics
   */
  public RmBindVsSeEventDetails addVipVnicsItem(String vipVnicsItem) {
    if (this.vipVnics == null) {
      this.vipVnics = new ArrayList<String>();
    }
    this.vipVnics.add(vipVnicsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vs_name of obj type rmbindvsseeventdetails field type str  type string.
   * @return vsName
   */
  public String getVsName() {
    return vsName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vs_name of obj type rmbindvsseeventdetails field type str  type string.
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
  RmBindVsSeEventDetails objRmBindVsSeEventDetails = (RmBindVsSeEventDetails) o;
  return   Objects.equals(this.vsUuid, objRmBindVsSeEventDetails.vsUuid)&&
  Objects.equals(this.vsName, objRmBindVsSeEventDetails.vsName)&&
  Objects.equals(this.seName, objRmBindVsSeEventDetails.seName)&&
  Objects.equals(this.primary, objRmBindVsSeEventDetails.primary)&&
  Objects.equals(this.standby, objRmBindVsSeEventDetails.standby)&&
  Objects.equals(this.type, objRmBindVsSeEventDetails.type)&&
  Objects.equals(this.vipVnics, objRmBindVsSeEventDetails.vipVnics)&&
  Objects.equals(this.ip, objRmBindVsSeEventDetails.ip)&&
  Objects.equals(this.ip6, objRmBindVsSeEventDetails.ip6);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class RmBindVsSeEventDetails {\n");
      sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
        sb.append("    ip6: ").append(toIndentedString(ip6)).append("\n");
        sb.append("    primary: ").append(toIndentedString(primary)).append("\n");
        sb.append("    seName: ").append(toIndentedString(seName)).append("\n");
        sb.append("    standby: ").append(toIndentedString(standby)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    vipVnics: ").append(toIndentedString(vipVnics)).append("\n");
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

