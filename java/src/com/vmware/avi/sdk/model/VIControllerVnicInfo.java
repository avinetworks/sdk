package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VIControllerVnicInfo is a POJO class extends AviRestResource that used for creating
 * VIControllerVnicInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VIControllerVnicInfo  {
    @JsonProperty("portgroup")
    private String portgroup = null;

    @JsonProperty("vnic_ip")
    private List<VIGuestvNicIPAddr> vnicIp = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property portgroup of obj type vicontrollervnicinfo field type str  type string.
   * @return portgroup
   */
  public String getPortgroup() {
    return portgroup;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property portgroup of obj type vicontrollervnicinfo field type str  type string.
   * @param portgroup set the portgroup.
   */
  public void setPortgroup(String  portgroup) {
    this.portgroup = portgroup;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vnic_ip of obj type vicontrollervnicinfo field type str  type array.
   * @return vnicIp
   */
  public List<VIGuestvNicIPAddr> getVnicIp() {
    return vnicIp;
  }

  /**
   * This is the setter method. this will set the vnicIp
   * Placeholder for description of property vnic_ip of obj type vicontrollervnicinfo field type str  type array.
   * @return vnicIp
   */
  public void setVnicIp(List<VIGuestvNicIPAddr>  vnicIp) {
    this.vnicIp = vnicIp;
  }

  /**
   * This is the setter method this will set the vnicIp
   * Placeholder for description of property vnic_ip of obj type vicontrollervnicinfo field type str  type array.
   * @return vnicIp
   */
  public VIControllerVnicInfo addVnicIpItem(VIGuestvNicIPAddr vnicIpItem) {
    if (this.vnicIp == null) {
      this.vnicIp = new ArrayList<VIGuestvNicIPAddr>();
    }
    this.vnicIp.add(vnicIpItem);
    return this;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VIControllerVnicInfo objVIControllerVnicInfo = (VIControllerVnicInfo) o;
  return   Objects.equals(this.portgroup, objVIControllerVnicInfo.portgroup)&&
  Objects.equals(this.vnicIp, objVIControllerVnicInfo.vnicIp);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VIControllerVnicInfo {\n");
      sb.append("    portgroup: ").append(toIndentedString(portgroup)).append("\n");
        sb.append("    vnicIp: ").append(toIndentedString(vnicIp)).append("\n");
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

