package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SeVipInterfaceList is a POJO class extends AviRestResource that used for creating
 * SeVipInterfaceList.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeVipInterfaceList  {
    @JsonProperty("is_portchannel")
    private Boolean isPortchannel = false;

    @JsonProperty("vip_intf_ip")
    private IpAddr vipIntfIp = null;

    @JsonProperty("vip_intf_ip6")
    private IpAddr vipIntfIp6 = null;

    @JsonProperty("vip_intf_mac")
    private String vipIntfMac = null;

    @JsonProperty("vlan_id")
    private Integer vlanId = 0;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property is_portchannel of obj type sevipinterfacelist field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return isPortchannel
   */
  public Boolean getIsPortchannel() {
    return isPortchannel;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property is_portchannel of obj type sevipinterfacelist field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param isPortchannel set the isPortchannel.
   */
  public void setIsPortchannel(Boolean  isPortchannel) {
    this.isPortchannel = isPortchannel;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vip_intf_ip of obj type sevipinterfacelist field type str  type ref.
   * @return vipIntfIp
   */
  public IpAddr getVipIntfIp() {
    return vipIntfIp;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vip_intf_ip of obj type sevipinterfacelist field type str  type ref.
   * @param vipIntfIp set the vipIntfIp.
   */
  public void setVipIntfIp(IpAddr vipIntfIp) {
    this.vipIntfIp = vipIntfIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vip_intf_ip6 of obj type sevipinterfacelist field type str  type ref.
   * @return vipIntfIp6
   */
  public IpAddr getVipIntfIp6() {
    return vipIntfIp6;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vip_intf_ip6 of obj type sevipinterfacelist field type str  type ref.
   * @param vipIntfIp6 set the vipIntfIp6.
   */
  public void setVipIntfIp6(IpAddr vipIntfIp6) {
    this.vipIntfIp6 = vipIntfIp6;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vip_intf_mac of obj type sevipinterfacelist field type str  type string.
   * @return vipIntfMac
   */
  public String getVipIntfMac() {
    return vipIntfMac;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vip_intf_mac of obj type sevipinterfacelist field type str  type string.
   * @param vipIntfMac set the vipIntfMac.
   */
  public void setVipIntfMac(String  vipIntfMac) {
    this.vipIntfMac = vipIntfMac;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vlan_id of obj type sevipinterfacelist field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return vlanId
   */
  public Integer getVlanId() {
    return vlanId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vlan_id of obj type sevipinterfacelist field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param vlanId set the vlanId.
   */
  public void setVlanId(Integer  vlanId) {
    this.vlanId = vlanId;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SeVipInterfaceList objSeVipInterfaceList = (SeVipInterfaceList) o;
  return   Objects.equals(this.vipIntfIp6, objSeVipInterfaceList.vipIntfIp6)&&
  Objects.equals(this.vipIntfIp, objSeVipInterfaceList.vipIntfIp)&&
  Objects.equals(this.vipIntfMac, objSeVipInterfaceList.vipIntfMac)&&
  Objects.equals(this.isPortchannel, objSeVipInterfaceList.isPortchannel)&&
  Objects.equals(this.vlanId, objSeVipInterfaceList.vlanId);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SeVipInterfaceList {\n");
      sb.append("    isPortchannel: ").append(toIndentedString(isPortchannel)).append("\n");
        sb.append("    vipIntfIp: ").append(toIndentedString(vipIntfIp)).append("\n");
        sb.append("    vipIntfIp6: ").append(toIndentedString(vipIntfIp6)).append("\n");
        sb.append("    vipIntfMac: ").append(toIndentedString(vipIntfMac)).append("\n");
        sb.append("    vlanId: ").append(toIndentedString(vlanId)).append("\n");
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

