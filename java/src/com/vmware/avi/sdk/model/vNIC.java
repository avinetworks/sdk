package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The vNIC is a POJO class extends AviRestResource that used for creating
 * vNIC.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class vNIC  {
    @JsonProperty("adapter")
    private String adapter = null;

    @JsonProperty("aggregator_chgd")
    private Boolean aggregatorChgd = false;

    @JsonProperty("can_se_dp_takeover")
    private Boolean canSeDpTakeover = true;

    @JsonProperty("connected")
    private Boolean connected = null;

    @JsonProperty("del_pending")
    private Boolean delPending = false;

    @JsonProperty("delete_vnic")
    private Boolean deleteVnic = false;

    @JsonProperty("dhcp_enabled")
    private Boolean dhcpEnabled = true;

    @JsonProperty("dp_deletion_done")
    private Boolean dpDeletionDone = false;

    @JsonProperty("enabled")
    private Boolean enabled = true;

    @JsonProperty("if_name")
    private String ifName = null;

    @JsonProperty("ip6_autocfg_enabled")
    private Boolean ip6AutocfgEnabled = true;

    @JsonProperty("is_asm")
    private Boolean isAsm = false;

    @JsonProperty("is_avi_internal_network")
    private Boolean isAviInternalNetwork = false;

    @JsonProperty("is_hsm")
    private Boolean isHsm = false;

    @JsonProperty("is_mgmt")
    private Boolean isMgmt = false;

    @JsonProperty("is_portchannel")
    private Boolean isPortchannel = false;

    @JsonProperty("link_up")
    private Boolean linkUp = true;

    @JsonProperty("linux_name")
    private String linuxName = null;

    @JsonProperty("mac_address")
    private String macAddress = null;

    @JsonProperty("members")
    private List<MemberInterface> members = null;

    @JsonProperty("mtu")
    private Integer mtu = 1500;

    @JsonProperty("network_name")
    private String networkName = null;

    @JsonProperty("network_ref")
    private String networkRef = null;

    @JsonProperty("pci_id")
    private String pciId = null;

    @JsonProperty("port_uuid")
    private String portUuid = null;

    @JsonProperty("vlan_id")
    private Integer vlanId = 0;

    @JsonProperty("vlan_interfaces")
    private List<VlanInterface> vlanInterfaces = null;

    @JsonProperty("vnic_networks")
    private List<vNICNetwork> vnicNetworks = null;

    @JsonProperty("vrf_id")
    private Integer vrfId = 0;

    @JsonProperty("vrf_ref")
    private String vrfRef = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property adapter of obj type vnic field type str  type string.
   * @return adapter
   */
  public String getAdapter() {
    return adapter;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property adapter of obj type vnic field type str  type string.
   * @param adapter set the adapter.
   */
  public void setAdapter(String  adapter) {
    this.adapter = adapter;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.2.7.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return aggregatorChgd
   */
  public Boolean getAggregatorChgd() {
    return aggregatorChgd;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.2.7.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param aggregatorChgd set the aggregatorChgd.
   */
  public void setAggregatorChgd(Boolean  aggregatorChgd) {
    this.aggregatorChgd = aggregatorChgd;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property can_se_dp_takeover of obj type vnic field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return canSeDpTakeover
   */
  public Boolean getCanSeDpTakeover() {
    return canSeDpTakeover;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property can_se_dp_takeover of obj type vnic field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param canSeDpTakeover set the canSeDpTakeover.
   */
  public void setCanSeDpTakeover(Boolean  canSeDpTakeover) {
    this.canSeDpTakeover = canSeDpTakeover;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property connected of obj type vnic field type str  type boolean.
   * @return connected
   */
  public Boolean getConnected() {
    return connected;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property connected of obj type vnic field type str  type boolean.
   * @param connected set the connected.
   */
  public void setConnected(Boolean  connected) {
    this.connected = connected;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property del_pending of obj type vnic field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return delPending
   */
  public Boolean getDelPending() {
    return delPending;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property del_pending of obj type vnic field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param delPending set the delPending.
   */
  public void setDelPending(Boolean  delPending) {
    this.delPending = delPending;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Delete this vnic.
   * Please confirm dp_deletion_done before removing the vnic from the cloud.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return deleteVnic
   */
  public Boolean getDeleteVnic() {
    return deleteVnic;
  }

  /**
   * This is the setter method to the attribute.
   * Delete this vnic.
   * Please confirm dp_deletion_done before removing the vnic from the cloud.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param deleteVnic set the deleteVnic.
   */
  public void setDeleteVnic(Boolean  deleteVnic) {
    this.deleteVnic = deleteVnic;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property dhcp_enabled of obj type vnic field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return dhcpEnabled
   */
  public Boolean getDhcpEnabled() {
    return dhcpEnabled;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property dhcp_enabled of obj type vnic field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param dhcpEnabled set the dhcpEnabled.
   */
  public void setDhcpEnabled(Boolean  dhcpEnabled) {
    this.dhcpEnabled = dhcpEnabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The vnic has been cleaned up in the datapath.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return dpDeletionDone
   */
  public Boolean getDpDeletionDone() {
    return dpDeletionDone;
  }

  /**
   * This is the setter method to the attribute.
   * The vnic has been cleaned up in the datapath.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param dpDeletionDone set the dpDeletionDone.
   */
  public void setDpDeletionDone(Boolean  dpDeletionDone) {
    this.dpDeletionDone = dpDeletionDone;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property enabled of obj type vnic field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return enabled
   */
  public Boolean getEnabled() {
    return enabled;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property enabled of obj type vnic field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param enabled set the enabled.
   */
  public void setEnabled(Boolean  enabled) {
    this.enabled = enabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property if_name of obj type vnic field type str  type string.
   * @return ifName
   */
  public String getIfName() {
    return ifName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property if_name of obj type vnic field type str  type string.
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
   * Placeholder for description of property is_asm of obj type vnic field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return isAsm
   */
  public Boolean getIsAsm() {
    return isAsm;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property is_asm of obj type vnic field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param isAsm set the isAsm.
   */
  public void setIsAsm(Boolean  isAsm) {
    this.isAsm = isAsm;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property is_avi_internal_network of obj type vnic field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return isAviInternalNetwork
   */
  public Boolean getIsAviInternalNetwork() {
    return isAviInternalNetwork;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property is_avi_internal_network of obj type vnic field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param isAviInternalNetwork set the isAviInternalNetwork.
   */
  public void setIsAviInternalNetwork(Boolean  isAviInternalNetwork) {
    this.isAviInternalNetwork = isAviInternalNetwork;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property is_hsm of obj type vnic field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return isHsm
   */
  public Boolean getIsHsm() {
    return isHsm;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property is_hsm of obj type vnic field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param isHsm set the isHsm.
   */
  public void setIsHsm(Boolean  isHsm) {
    this.isHsm = isHsm;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property is_mgmt of obj type vnic field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return isMgmt
   */
  public Boolean getIsMgmt() {
    return isMgmt;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property is_mgmt of obj type vnic field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param isMgmt set the isMgmt.
   */
  public void setIsMgmt(Boolean  isMgmt) {
    this.isMgmt = isMgmt;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property is_portchannel of obj type vnic field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return isPortchannel
   */
  public Boolean getIsPortchannel() {
    return isPortchannel;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property is_portchannel of obj type vnic field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param isPortchannel set the isPortchannel.
   */
  public void setIsPortchannel(Boolean  isPortchannel) {
    this.isPortchannel = isPortchannel;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The link is operationally up.
   * Field introduced in 18.2.8, 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return linkUp
   */
  public Boolean getLinkUp() {
    return linkUp;
  }

  /**
   * This is the setter method to the attribute.
   * The link is operationally up.
   * Field introduced in 18.2.8, 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param linkUp set the linkUp.
   */
  public void setLinkUp(Boolean  linkUp) {
    this.linkUp = linkUp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property linux_name of obj type vnic field type str  type string.
   * @return linuxName
   */
  public String getLinuxName() {
    return linuxName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property linux_name of obj type vnic field type str  type string.
   * @param linuxName set the linuxName.
   */
  public void setLinuxName(String  linuxName) {
    this.linuxName = linuxName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property mac_address of obj type vnic field type str  type string.
   * @return macAddress
   */
  public String getMacAddress() {
    return macAddress;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property mac_address of obj type vnic field type str  type string.
   * @param macAddress set the macAddress.
   */
  public void setMacAddress(String  macAddress) {
    this.macAddress = macAddress;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property members of obj type vnic field type str  type array.
   * @return members
   */
  public List<MemberInterface> getMembers() {
    return members;
  }

  /**
   * This is the setter method. this will set the members
   * Placeholder for description of property members of obj type vnic field type str  type array.
   * @return members
   */
  public void setMembers(List<MemberInterface>  members) {
    this.members = members;
  }

  /**
   * This is the setter method this will set the members
   * Placeholder for description of property members of obj type vnic field type str  type array.
   * @return members
   */
  public vNIC addMembersItem(MemberInterface membersItem) {
    if (this.members == null) {
      this.members = new ArrayList<MemberInterface>();
    }
    this.members.add(membersItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property mtu of obj type vnic field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1500.
   * @return mtu
   */
  public Integer getMtu() {
    return mtu;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property mtu of obj type vnic field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1500.
   * @param mtu set the mtu.
   */
  public void setMtu(Integer  mtu) {
    this.mtu = mtu;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property network_name of obj type vnic field type str  type string.
   * @return networkName
   */
  public String getNetworkName() {
    return networkName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property network_name of obj type vnic field type str  type string.
   * @param networkName set the networkName.
   */
  public void setNetworkName(String  networkName) {
    this.networkName = networkName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type network.
   * @return networkRef
   */
  public String getNetworkRef() {
    return networkRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type network.
   * @param networkRef set the networkRef.
   */
  public void setNetworkRef(String  networkRef) {
    this.networkRef = networkRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property pci_id of obj type vnic field type str  type string.
   * @return pciId
   */
  public String getPciId() {
    return pciId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property pci_id of obj type vnic field type str  type string.
   * @param pciId set the pciId.
   */
  public void setPciId(String  pciId) {
    this.pciId = pciId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of port.
   * @return portUuid
   */
  public String getPortUuid() {
    return portUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of port.
   * @param portUuid set the portUuid.
   */
  public void setPortUuid(String  portUuid) {
    this.portUuid = portUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vlan_id of obj type vnic field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return vlanId
   */
  public Integer getVlanId() {
    return vlanId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vlan_id of obj type vnic field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param vlanId set the vlanId.
   */
  public void setVlanId(Integer  vlanId) {
    this.vlanId = vlanId;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vlan_interfaces of obj type vnic field type str  type array.
   * @return vlanInterfaces
   */
  public List<VlanInterface> getVlanInterfaces() {
    return vlanInterfaces;
  }

  /**
   * This is the setter method. this will set the vlanInterfaces
   * Placeholder for description of property vlan_interfaces of obj type vnic field type str  type array.
   * @return vlanInterfaces
   */
  public void setVlanInterfaces(List<VlanInterface>  vlanInterfaces) {
    this.vlanInterfaces = vlanInterfaces;
  }

  /**
   * This is the setter method this will set the vlanInterfaces
   * Placeholder for description of property vlan_interfaces of obj type vnic field type str  type array.
   * @return vlanInterfaces
   */
  public vNIC addVlanInterfacesItem(VlanInterface vlanInterfacesItem) {
    if (this.vlanInterfaces == null) {
      this.vlanInterfaces = new ArrayList<VlanInterface>();
    }
    this.vlanInterfaces.add(vlanInterfacesItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vnic_networks of obj type vnic field type str  type array.
   * @return vnicNetworks
   */
  public List<vNICNetwork> getVnicNetworks() {
    return vnicNetworks;
  }

  /**
   * This is the setter method. this will set the vnicNetworks
   * Placeholder for description of property vnic_networks of obj type vnic field type str  type array.
   * @return vnicNetworks
   */
  public void setVnicNetworks(List<vNICNetwork>  vnicNetworks) {
    this.vnicNetworks = vnicNetworks;
  }

  /**
   * This is the setter method this will set the vnicNetworks
   * Placeholder for description of property vnic_networks of obj type vnic field type str  type array.
   * @return vnicNetworks
   */
  public vNIC addVnicNetworksItem(vNICNetwork vnicNetworksItem) {
    if (this.vnicNetworks == null) {
      this.vnicNetworks = new ArrayList<vNICNetwork>();
    }
    this.vnicNetworks.add(vnicNetworksItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vrf_id of obj type vnic field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return vrfId
   */
  public Integer getVrfId() {
    return vrfId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vrf_id of obj type vnic field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param vrfId set the vrfId.
   */
  public void setVrfId(Integer  vrfId) {
    this.vrfId = vrfId;
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
  vNIC objvNIC = (vNIC) o;
  return   Objects.equals(this.ifName, objvNIC.ifName)&&
  Objects.equals(this.macAddress, objvNIC.macAddress)&&
  Objects.equals(this.connected, objvNIC.connected)&&
  Objects.equals(this.isMgmt, objvNIC.isMgmt)&&
  Objects.equals(this.networkRef, objvNIC.networkRef)&&
  Objects.equals(this.networkName, objvNIC.networkName)&&
  Objects.equals(this.dhcpEnabled, objvNIC.dhcpEnabled)&&
  Objects.equals(this.isAviInternalNetwork, objvNIC.isAviInternalNetwork)&&
  Objects.equals(this.enabled, objvNIC.enabled)&&
  Objects.equals(this.adapter, objvNIC.adapter)&&
  Objects.equals(this.vlanId, objvNIC.vlanId)&&
  Objects.equals(this.pciId, objvNIC.pciId)&&
  Objects.equals(this.linuxName, objvNIC.linuxName)&&
  Objects.equals(this.portUuid, objvNIC.portUuid)&&
  Objects.equals(this.delPending, objvNIC.delPending)&&
  Objects.equals(this.mtu, objvNIC.mtu)&&
  Objects.equals(this.vnicNetworks, objvNIC.vnicNetworks)&&
  Objects.equals(this.canSeDpTakeover, objvNIC.canSeDpTakeover)&&
  Objects.equals(this.vrfRef, objvNIC.vrfRef)&&
  Objects.equals(this.vrfId, objvNIC.vrfId)&&
  Objects.equals(this.vlanInterfaces, objvNIC.vlanInterfaces)&&
  Objects.equals(this.isPortchannel, objvNIC.isPortchannel)&&
  Objects.equals(this.members, objvNIC.members)&&
  Objects.equals(this.isHsm, objvNIC.isHsm)&&
  Objects.equals(this.isAsm, objvNIC.isAsm)&&
  Objects.equals(this.ip6AutocfgEnabled, objvNIC.ip6AutocfgEnabled)&&
  Objects.equals(this.aggregatorChgd, objvNIC.aggregatorChgd)&&
  Objects.equals(this.dpDeletionDone, objvNIC.dpDeletionDone)&&
  Objects.equals(this.deleteVnic, objvNIC.deleteVnic)&&
  Objects.equals(this.linkUp, objvNIC.linkUp);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class vNIC {\n");
      sb.append("    adapter: ").append(toIndentedString(adapter)).append("\n");
        sb.append("    aggregatorChgd: ").append(toIndentedString(aggregatorChgd)).append("\n");
        sb.append("    canSeDpTakeover: ").append(toIndentedString(canSeDpTakeover)).append("\n");
        sb.append("    connected: ").append(toIndentedString(connected)).append("\n");
        sb.append("    delPending: ").append(toIndentedString(delPending)).append("\n");
        sb.append("    deleteVnic: ").append(toIndentedString(deleteVnic)).append("\n");
        sb.append("    dhcpEnabled: ").append(toIndentedString(dhcpEnabled)).append("\n");
        sb.append("    dpDeletionDone: ").append(toIndentedString(dpDeletionDone)).append("\n");
        sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
        sb.append("    ifName: ").append(toIndentedString(ifName)).append("\n");
        sb.append("    ip6AutocfgEnabled: ").append(toIndentedString(ip6AutocfgEnabled)).append("\n");
        sb.append("    isAsm: ").append(toIndentedString(isAsm)).append("\n");
        sb.append("    isAviInternalNetwork: ").append(toIndentedString(isAviInternalNetwork)).append("\n");
        sb.append("    isHsm: ").append(toIndentedString(isHsm)).append("\n");
        sb.append("    isMgmt: ").append(toIndentedString(isMgmt)).append("\n");
        sb.append("    isPortchannel: ").append(toIndentedString(isPortchannel)).append("\n");
        sb.append("    linkUp: ").append(toIndentedString(linkUp)).append("\n");
        sb.append("    linuxName: ").append(toIndentedString(linuxName)).append("\n");
        sb.append("    macAddress: ").append(toIndentedString(macAddress)).append("\n");
        sb.append("    members: ").append(toIndentedString(members)).append("\n");
        sb.append("    mtu: ").append(toIndentedString(mtu)).append("\n");
        sb.append("    networkName: ").append(toIndentedString(networkName)).append("\n");
        sb.append("    networkRef: ").append(toIndentedString(networkRef)).append("\n");
        sb.append("    pciId: ").append(toIndentedString(pciId)).append("\n");
        sb.append("    portUuid: ").append(toIndentedString(portUuid)).append("\n");
        sb.append("    vlanId: ").append(toIndentedString(vlanId)).append("\n");
        sb.append("    vlanInterfaces: ").append(toIndentedString(vlanInterfaces)).append("\n");
        sb.append("    vnicNetworks: ").append(toIndentedString(vnicNetworks)).append("\n");
        sb.append("    vrfId: ").append(toIndentedString(vrfId)).append("\n");
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

