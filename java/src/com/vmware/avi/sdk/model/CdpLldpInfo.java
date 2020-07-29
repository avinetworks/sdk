package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The CdpLldpInfo is a POJO class extends AviRestResource that used for creating
 * CdpLldpInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CdpLldpInfo  {
    @JsonProperty("chassis")
    private String chassis = null;

    @JsonProperty("device")
    private String device = null;

    @JsonProperty("mgmtaddr")
    private String mgmtaddr = null;

    @JsonProperty("port")
    private String port = null;

    @JsonProperty("switch_info_type")
    private String switchInfoType = null;

    @JsonProperty("system_name")
    private String systemName = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property chassis of obj type cdplldpinfo field type str  type string.
   * @return chassis
   */
  public String getChassis() {
    return chassis;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property chassis of obj type cdplldpinfo field type str  type string.
   * @param chassis set the chassis.
   */
  public void setChassis(String  chassis) {
    this.chassis = chassis;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property device of obj type cdplldpinfo field type str  type string.
   * @return device
   */
  public String getDevice() {
    return device;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property device of obj type cdplldpinfo field type str  type string.
   * @param device set the device.
   */
  public void setDevice(String  device) {
    this.device = device;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property mgmtaddr of obj type cdplldpinfo field type str  type string.
   * @return mgmtaddr
   */
  public String getMgmtaddr() {
    return mgmtaddr;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property mgmtaddr of obj type cdplldpinfo field type str  type string.
   * @param mgmtaddr set the mgmtaddr.
   */
  public void setMgmtaddr(String  mgmtaddr) {
    this.mgmtaddr = mgmtaddr;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property port of obj type cdplldpinfo field type str  type string.
   * @return port
   */
  public String getPort() {
    return port;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property port of obj type cdplldpinfo field type str  type string.
   * @param port set the port.
   */
  public void setPort(String  port) {
    this.port = port;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - CDP, LLDP, NOT_APPLICABLE.
   * @return switchInfoType
   */
  public String getSwitchInfoType() {
    return switchInfoType;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - CDP, LLDP, NOT_APPLICABLE.
   * @param switchInfoType set the switchInfoType.
   */
  public void setSwitchInfoType(String  switchInfoType) {
    this.switchInfoType = switchInfoType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property system_name of obj type cdplldpinfo field type str  type string.
   * @return systemName
   */
  public String getSystemName() {
    return systemName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property system_name of obj type cdplldpinfo field type str  type string.
   * @param systemName set the systemName.
   */
  public void setSystemName(String  systemName) {
    this.systemName = systemName;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  CdpLldpInfo objCdpLldpInfo = (CdpLldpInfo) o;
  return   Objects.equals(this.switchInfoType, objCdpLldpInfo.switchInfoType)&&
  Objects.equals(this.device, objCdpLldpInfo.device)&&
  Objects.equals(this.chassis, objCdpLldpInfo.chassis)&&
  Objects.equals(this.port, objCdpLldpInfo.port)&&
  Objects.equals(this.mgmtaddr, objCdpLldpInfo.mgmtaddr)&&
  Objects.equals(this.systemName, objCdpLldpInfo.systemName);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class CdpLldpInfo {\n");
      sb.append("    chassis: ").append(toIndentedString(chassis)).append("\n");
        sb.append("    device: ").append(toIndentedString(device)).append("\n");
        sb.append("    mgmtaddr: ").append(toIndentedString(mgmtaddr)).append("\n");
        sb.append("    port: ").append(toIndentedString(port)).append("\n");
        sb.append("    switchInfoType: ").append(toIndentedString(switchInfoType)).append("\n");
        sb.append("    systemName: ").append(toIndentedString(systemName)).append("\n");
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

