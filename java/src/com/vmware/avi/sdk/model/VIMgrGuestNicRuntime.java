package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VIMgrGuestNicRuntime is a POJO class extends AviRestResource that used for creating
 * VIMgrGuestNicRuntime.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VIMgrGuestNicRuntime  {
    @JsonProperty("avi_internal_network")
    private Boolean aviInternalNetwork = null;

    @JsonProperty("connected")
    private Boolean connected = null;

    @JsonProperty("del_pending")
    private Boolean delPending = false;

    @JsonProperty("guest_ip")
    private List<VIMgrIPSubnetRuntime> guestIp = null;

    @JsonProperty("label")
    private String label = "unknown";

    @JsonProperty("mac_addr")
    private String macAddr = null;

    @JsonProperty("mgmt_vnic")
    private Boolean mgmtVnic = null;

    @JsonProperty("network_name")
    private String networkName = null;

    @JsonProperty("network_uuid")
    private String networkUuid = null;

    @JsonProperty("os_port_uuid")
    private String osPortUuid = null;

    @JsonProperty("type")
    private String type = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property avi_internal_network of obj type vimgrguestnicruntime field type str  type boolean.
   * @return aviInternalNetwork
   */
  public Boolean getAviInternalNetwork() {
    return aviInternalNetwork;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property avi_internal_network of obj type vimgrguestnicruntime field type str  type boolean.
   * @param aviInternalNetwork set the aviInternalNetwork.
   */
  public void setAviInternalNetwork(Boolean  aviInternalNetwork) {
    this.aviInternalNetwork = aviInternalNetwork;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property connected of obj type vimgrguestnicruntime field type str  type boolean.
   * @return connected
   */
  public Boolean getConnected() {
    return connected;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property connected of obj type vimgrguestnicruntime field type str  type boolean.
   * @param connected set the connected.
   */
  public void setConnected(Boolean  connected) {
    this.connected = connected;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property del_pending of obj type vimgrguestnicruntime field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return delPending
   */
  public Boolean getDelPending() {
    return delPending;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property del_pending of obj type vimgrguestnicruntime field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param delPending set the delPending.
   */
  public void setDelPending(Boolean  delPending) {
    this.delPending = delPending;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property guest_ip of obj type vimgrguestnicruntime field type str  type array.
   * @return guestIp
   */
  public List<VIMgrIPSubnetRuntime> getGuestIp() {
    return guestIp;
  }

  /**
   * This is the setter method. this will set the guestIp
   * Placeholder for description of property guest_ip of obj type vimgrguestnicruntime field type str  type array.
   * @return guestIp
   */
  public void setGuestIp(List<VIMgrIPSubnetRuntime>  guestIp) {
    this.guestIp = guestIp;
  }

  /**
   * This is the setter method this will set the guestIp
   * Placeholder for description of property guest_ip of obj type vimgrguestnicruntime field type str  type array.
   * @return guestIp
   */
  public VIMgrGuestNicRuntime addGuestIpItem(VIMgrIPSubnetRuntime guestIpItem) {
    if (this.guestIp == null) {
      this.guestIp = new ArrayList<VIMgrIPSubnetRuntime>();
    }
    this.guestIp.add(guestIpItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property label of obj type vimgrguestnicruntime field type str  type string.
   * Default value when not specified in API or module is interpreted by Avi Controller as unknown.
   * @return label
   */
  public String getLabel() {
    return label;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property label of obj type vimgrguestnicruntime field type str  type string.
   * Default value when not specified in API or module is interpreted by Avi Controller as unknown.
   * @param label set the label.
   */
  public void setLabel(String  label) {
    this.label = label;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property mac_addr of obj type vimgrguestnicruntime field type str  type string.
   * @return macAddr
   */
  public String getMacAddr() {
    return macAddr;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property mac_addr of obj type vimgrguestnicruntime field type str  type string.
   * @param macAddr set the macAddr.
   */
  public void setMacAddr(String  macAddr) {
    this.macAddr = macAddr;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property mgmt_vnic of obj type vimgrguestnicruntime field type str  type boolean.
   * @return mgmtVnic
   */
  public Boolean getMgmtVnic() {
    return mgmtVnic;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property mgmt_vnic of obj type vimgrguestnicruntime field type str  type boolean.
   * @param mgmtVnic set the mgmtVnic.
   */
  public void setMgmtVnic(Boolean  mgmtVnic) {
    this.mgmtVnic = mgmtVnic;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property network_name of obj type vimgrguestnicruntime field type str  type string.
   * @return networkName
   */
  public String getNetworkName() {
    return networkName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property network_name of obj type vimgrguestnicruntime field type str  type string.
   * @param networkName set the networkName.
   */
  public void setNetworkName(String  networkName) {
    this.networkName = networkName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of network.
   * @return networkUuid
   */
  public String getNetworkUuid() {
    return networkUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of network.
   * @param networkUuid set the networkUuid.
   */
  public void setNetworkUuid(String  networkUuid) {
    this.networkUuid = networkUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of os_port.
   * @return osPortUuid
   */
  public String getOsPortUuid() {
    return osPortUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of os_port.
   * @param osPortUuid set the osPortUuid.
   */
  public void setOsPortUuid(String  osPortUuid) {
    this.osPortUuid = osPortUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - CLOUD_NONE, CLOUD_VCENTER, CLOUD_OPENSTACK, CLOUD_AWS, CLOUD_VCA, CLOUD_APIC, CLOUD_MESOS, CLOUD_LINUXSERVER, CLOUD_DOCKER_UCP,
   * CLOUD_RANCHER, CLOUD_OSHIFT_K8S, CLOUD_AZURE, CLOUD_GCP, CLOUD_NSXT.
   * @return type
   */
  public String getType() {
    return type;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - CLOUD_NONE, CLOUD_VCENTER, CLOUD_OPENSTACK, CLOUD_AWS, CLOUD_VCA, CLOUD_APIC, CLOUD_MESOS, CLOUD_LINUXSERVER, CLOUD_DOCKER_UCP,
   * CLOUD_RANCHER, CLOUD_OSHIFT_K8S, CLOUD_AZURE, CLOUD_GCP, CLOUD_NSXT.
   * @param type set the type.
   */
  public void setType(String  type) {
    this.type = type;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VIMgrGuestNicRuntime objVIMgrGuestNicRuntime = (VIMgrGuestNicRuntime) o;
  return   Objects.equals(this.guestIp, objVIMgrGuestNicRuntime.guestIp)&&
  Objects.equals(this.mgmtVnic, objVIMgrGuestNicRuntime.mgmtVnic)&&
  Objects.equals(this.type, objVIMgrGuestNicRuntime.type)&&
  Objects.equals(this.label, objVIMgrGuestNicRuntime.label)&&
  Objects.equals(this.delPending, objVIMgrGuestNicRuntime.delPending)&&
  Objects.equals(this.connected, objVIMgrGuestNicRuntime.connected)&&
  Objects.equals(this.macAddr, objVIMgrGuestNicRuntime.macAddr)&&
  Objects.equals(this.networkUuid, objVIMgrGuestNicRuntime.networkUuid)&&
  Objects.equals(this.osPortUuid, objVIMgrGuestNicRuntime.osPortUuid)&&
  Objects.equals(this.networkName, objVIMgrGuestNicRuntime.networkName)&&
  Objects.equals(this.aviInternalNetwork, objVIMgrGuestNicRuntime.aviInternalNetwork);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VIMgrGuestNicRuntime {\n");
      sb.append("    aviInternalNetwork: ").append(toIndentedString(aviInternalNetwork)).append("\n");
        sb.append("    connected: ").append(toIndentedString(connected)).append("\n");
        sb.append("    delPending: ").append(toIndentedString(delPending)).append("\n");
        sb.append("    guestIp: ").append(toIndentedString(guestIp)).append("\n");
        sb.append("    label: ").append(toIndentedString(label)).append("\n");
        sb.append("    macAddr: ").append(toIndentedString(macAddr)).append("\n");
        sb.append("    mgmtVnic: ").append(toIndentedString(mgmtVnic)).append("\n");
        sb.append("    networkName: ").append(toIndentedString(networkName)).append("\n");
        sb.append("    networkUuid: ").append(toIndentedString(networkUuid)).append("\n");
        sb.append("    osPortUuid: ").append(toIndentedString(osPortUuid)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

