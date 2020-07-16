package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VlanInterface is a POJO class extends AviRestResource that used for creating
 * VlanInterface.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VlanInterface  {
    @JsonProperty("dhcp_enabled")
    private Boolean dhcpEnabled = true;

    @JsonProperty("enabled")
    private Boolean enabled = true;

    @JsonProperty("if_name")
    private String ifName = null;

    @JsonProperty("ip6_autocfg_enabled")
    private Boolean ip6AutocfgEnabled = true;

    @JsonProperty("is_mgmt")
    private Boolean isMgmt = false;

    @JsonProperty("vlan_id")
    private Integer vlanId = 0;

    @JsonProperty("vnic_networks")
    private List<vNICNetwork> vnicNetworks = null;

    @JsonProperty("vrf_ref")
    private String vrfRef = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property dhcp_enabled of obj type vlaninterface field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return dhcpEnabled
   */
  public Boolean getDhcpEnabled() {
    return dhcpEnabled;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property dhcp_enabled of obj type vlaninterface field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param dhcpEnabled set the dhcpEnabled.
   */
  public void setDhcpEnabled(Boolean  dhcpEnabled) {
    this.dhcpEnabled = dhcpEnabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable the interface.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return enabled
   */
  public Boolean getEnabled() {
    return enabled;
  }

  /**
   * This is the setter method to the attribute.
   * Enable the interface.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param enabled set the enabled.
   */
  public void setEnabled(Boolean  enabled) {
    this.enabled = enabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property if_name of obj type vlaninterface field type str  type string.
   * @return ifName
   */
  public String getIfName() {
    return ifName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property if_name of obj type vlaninterface field type str  type string.
   * @param ifName set the ifName.
   */
  public void setIfName(String  ifName) {
    this.ifName = ifName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable ipv6 auto configuration.
   * Field introduced in 18.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return ip6AutocfgEnabled
   */
  public Boolean getIp6AutocfgEnabled() {
    return ip6AutocfgEnabled;
  }

  /**
   * This is the setter method to the attribute.
   * Enable ipv6 auto configuration.
   * Field introduced in 18.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param ip6AutocfgEnabled set the ip6AutocfgEnabled.
   */
  public void setIp6AutocfgEnabled(Boolean  ip6AutocfgEnabled) {
    this.ip6AutocfgEnabled = ip6AutocfgEnabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property is_mgmt of obj type vlaninterface field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return isMgmt
   */
  public Boolean getIsMgmt() {
    return isMgmt;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property is_mgmt of obj type vlaninterface field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param isMgmt set the isMgmt.
   */
  public void setIsMgmt(Boolean  isMgmt) {
    this.isMgmt = isMgmt;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Vlan id.
   * Allowed values are 0-4096.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return vlanId
   */
  public Integer getVlanId() {
    return vlanId;
  }

  /**
   * This is the setter method to the attribute.
   * Vlan id.
   * Allowed values are 0-4096.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param vlanId set the vlanId.
   */
  public void setVlanId(Integer  vlanId) {
    this.vlanId = vlanId;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vnic_networks of obj type vlaninterface field type str  type array.
   * @return vnicNetworks
   */
  public List<vNICNetwork> getVnicNetworks() {
    return vnicNetworks;
  }

  /**
   * This is the setter method. this will set the vnicNetworks
   * Placeholder for description of property vnic_networks of obj type vlaninterface field type str  type array.
   * @return vnicNetworks
   */
  public void setVnicNetworks(List<vNICNetwork>  vnicNetworks) {
    this.vnicNetworks = vnicNetworks;
  }

  /**
   * This is the setter method this will set the vnicNetworks
   * Placeholder for description of property vnic_networks of obj type vlaninterface field type str  type array.
   * @return vnicNetworks
   */
  public VlanInterface addVnicNetworksItem(vNICNetwork vnicNetworksItem) {
    if (this.vnicNetworks == null) {
      this.vnicNetworks = new ArrayList<vNICNetwork>();
    }
    this.vnicNetworks.add(vnicNetworksItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type vrfcontext.
   * @return vrfRef
   */
  public String getVrfRef() {
    return vrfRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type vrfcontext.
   * @param vrfRef set the vrfRef.
   */
  public void setVrfRef(String  vrfRef) {
    this.vrfRef = vrfRef;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VlanInterface objVlanInterface = (VlanInterface) o;
  return   Objects.equals(this.ip6AutocfgEnabled, objVlanInterface.ip6AutocfgEnabled)&&
  Objects.equals(this.enabled, objVlanInterface.enabled)&&
  Objects.equals(this.ifName, objVlanInterface.ifName)&&
  Objects.equals(this.dhcpEnabled, objVlanInterface.dhcpEnabled)&&
  Objects.equals(this.isMgmt, objVlanInterface.isMgmt)&&
  Objects.equals(this.vnicNetworks, objVlanInterface.vnicNetworks)&&
  Objects.equals(this.vrfRef, objVlanInterface.vrfRef)&&
  Objects.equals(this.vlanId, objVlanInterface.vlanId);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VlanInterface {\n");
      sb.append("    dhcpEnabled: ").append(toIndentedString(dhcpEnabled)).append("\n");
        sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
        sb.append("    ifName: ").append(toIndentedString(ifName)).append("\n");
        sb.append("    ip6AutocfgEnabled: ").append(toIndentedString(ip6AutocfgEnabled)).append("\n");
        sb.append("    isMgmt: ").append(toIndentedString(isMgmt)).append("\n");
        sb.append("    vlanId: ").append(toIndentedString(vlanId)).append("\n");
        sb.append("    vnicNetworks: ").append(toIndentedString(vnicNetworks)).append("\n");
        sb.append("    vrfRef: ").append(toIndentedString(vrfRef)).append("\n");
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

