package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VIVmVnicInfo is a POJO class extends AviRestResource that used for creating
 * VIVmVnicInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VIVmVnicInfo  {
    @JsonProperty("mac_addr")
    private String macAddr = null;

    @JsonProperty("vcenter_portgroup")
    private String vcenterPortgroup = null;

    @JsonProperty("vcenter_vnic_nw")
    private String vcenterVnicNw = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property mac_addr of obj type vivmvnicinfo field type str  type string.
   * @return macAddr
   */
  public String getMacAddr() {
    return macAddr;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property mac_addr of obj type vivmvnicinfo field type str  type string.
   * @param macAddr set the macAddr.
   */
  public void setMacAddr(String  macAddr) {
    this.macAddr = macAddr;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vcenter_portgroup of obj type vivmvnicinfo field type str  type string.
   * @return vcenterPortgroup
   */
  public String getVcenterPortgroup() {
    return vcenterPortgroup;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vcenter_portgroup of obj type vivmvnicinfo field type str  type string.
   * @param vcenterPortgroup set the vcenterPortgroup.
   */
  public void setVcenterPortgroup(String  vcenterPortgroup) {
    this.vcenterPortgroup = vcenterPortgroup;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - VNIC_VSWITCH, VNIC_DVS.
   * @return vcenterVnicNw
   */
  public String getVcenterVnicNw() {
    return vcenterVnicNw;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - VNIC_VSWITCH, VNIC_DVS.
   * @param vcenterVnicNw set the vcenterVnicNw.
   */
  public void setVcenterVnicNw(String  vcenterVnicNw) {
    this.vcenterVnicNw = vcenterVnicNw;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VIVmVnicInfo objVIVmVnicInfo = (VIVmVnicInfo) o;
  return   Objects.equals(this.vcenterPortgroup, objVIVmVnicInfo.vcenterPortgroup)&&
  Objects.equals(this.macAddr, objVIVmVnicInfo.macAddr)&&
  Objects.equals(this.vcenterVnicNw, objVIVmVnicInfo.vcenterVnicNw);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VIVmVnicInfo {\n");
      sb.append("    macAddr: ").append(toIndentedString(macAddr)).append("\n");
        sb.append("    vcenterPortgroup: ").append(toIndentedString(vcenterPortgroup)).append("\n");
        sb.append("    vcenterVnicNw: ").append(toIndentedString(vcenterVnicNw)).append("\n");
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

