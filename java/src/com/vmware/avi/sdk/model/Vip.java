package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Vip is a POJO class extends AviRestResource that used for creating
 * Vip.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Vip  {
    @JsonProperty("auto_allocate_floating_ip")
    private Boolean autoAllocateFloatingIp = false;

    @JsonProperty("auto_allocate_ip")
    private Boolean autoAllocateIp = false;

    @JsonProperty("auto_allocate_ip_type")
    private String autoAllocateIpType = "V4_ONLY";

    @JsonProperty("availability_zone")
    private String availabilityZone = null;

    @JsonProperty("avi_allocated_fip")
    private Boolean aviAllocatedFip = false;

    @JsonProperty("avi_allocated_vip")
    private Boolean aviAllocatedVip = false;

    @JsonProperty("discovered_networks")
    private List<DiscoveredNetwork> discoveredNetworks = null;

    @JsonProperty("enabled")
    private Boolean enabled = true;

    @JsonProperty("floating_ip")
    private IpAddr floatingIp = null;

    @JsonProperty("floating_ip6")
    private IpAddr floatingIp6 = null;

    @JsonProperty("floating_subnet6_uuid")
    private String floatingSubnet6Uuid = null;

    @JsonProperty("floating_subnet_uuid")
    private String floatingSubnetUuid = null;

    @JsonProperty("ip6_address")
    private IpAddr ip6Address = null;

    @JsonProperty("ip_address")
    private IpAddr ipAddress = null;

    @JsonProperty("ipam_network_subnet")
    private IPNetworkSubnet ipamNetworkSubnet = null;

    @JsonProperty("network_ref")
    private String networkRef = null;

    @JsonProperty("placement_networks")
    private List<VipPlacementNetwork> placementNetworks = null;

    @JsonProperty("port_uuid")
    private String portUuid = null;

    @JsonProperty("prefix_length")
    private Integer prefixLength = 32;

    @JsonProperty("subnet")
    private IpAddrPrefix subnet = null;

    @JsonProperty("subnet6")
    private IpAddrPrefix subnet6 = null;

    @JsonProperty("subnet6_uuid")
    private String subnet6Uuid = null;

    @JsonProperty("subnet_uuid")
    private String subnetUuid = null;

    @JsonProperty("vip_id")
    private String vipId = null;



  /**
   * This is the getter method this will return the attribute value.
   * Auto-allocate floating/elastic ip from the cloud infrastructure.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return autoAllocateFloatingIp
   */
  public Boolean getAutoAllocateFloatingIp() {
    return autoAllocateFloatingIp;
  }

  /**
   * This is the setter method to the attribute.
   * Auto-allocate floating/elastic ip from the cloud infrastructure.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param autoAllocateFloatingIp set the autoAllocateFloatingIp.
   */
  public void setAutoAllocateFloatingIp(Boolean  autoAllocateFloatingIp) {
    this.autoAllocateFloatingIp = autoAllocateFloatingIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Auto-allocate vip from the provided subnet.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return autoAllocateIp
   */
  public Boolean getAutoAllocateIp() {
    return autoAllocateIp;
  }

  /**
   * This is the setter method to the attribute.
   * Auto-allocate vip from the provided subnet.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param autoAllocateIp set the autoAllocateIp.
   */
  public void setAutoAllocateIp(Boolean  autoAllocateIp) {
    this.autoAllocateIp = autoAllocateIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Specifies whether to auto-allocate only a v4 address, only a v6 address, or one of each type.
   * Enum options - V4_ONLY, V6_ONLY, V4_V6.
   * Field introduced in 18.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as V4_ONLY.
   * @return autoAllocateIpType
   */
  public String getAutoAllocateIpType() {
    return autoAllocateIpType;
  }

  /**
   * This is the setter method to the attribute.
   * Specifies whether to auto-allocate only a v4 address, only a v6 address, or one of each type.
   * Enum options - V4_ONLY, V6_ONLY, V4_V6.
   * Field introduced in 18.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as V4_ONLY.
   * @param autoAllocateIpType set the autoAllocateIpType.
   */
  public void setAutoAllocateIpType(String  autoAllocateIpType) {
    this.autoAllocateIpType = autoAllocateIpType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Availability-zone to place the virtual service.
   * Field introduced in 17.1.1.
   * @return availabilityZone
   */
  public String getAvailabilityZone() {
    return availabilityZone;
  }

  /**
   * This is the setter method to the attribute.
   * Availability-zone to place the virtual service.
   * Field introduced in 17.1.1.
   * @param availabilityZone set the availabilityZone.
   */
  public void setAvailabilityZone(String  availabilityZone) {
    this.availabilityZone = availabilityZone;
  }

  /**
   * This is the getter method this will return the attribute value.
   * (internal-use) fip allocated by avi in the cloud infrastructure.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return aviAllocatedFip
   */
  public Boolean getAviAllocatedFip() {
    return aviAllocatedFip;
  }

  /**
   * This is the setter method to the attribute.
   * (internal-use) fip allocated by avi in the cloud infrastructure.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param aviAllocatedFip set the aviAllocatedFip.
   */
  public void setAviAllocatedFip(Boolean  aviAllocatedFip) {
    this.aviAllocatedFip = aviAllocatedFip;
  }

  /**
   * This is the getter method this will return the attribute value.
   * (internal-use) vip allocated by avi in the cloud infrastructure.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return aviAllocatedVip
   */
  public Boolean getAviAllocatedVip() {
    return aviAllocatedVip;
  }

  /**
   * This is the setter method to the attribute.
   * (internal-use) vip allocated by avi in the cloud infrastructure.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param aviAllocatedVip set the aviAllocatedVip.
   */
  public void setAviAllocatedVip(Boolean  aviAllocatedVip) {
    this.aviAllocatedVip = aviAllocatedVip;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Discovered networks providing reachability for client facing vip ip.
   * Field introduced in 17.1.1.
   * @return discoveredNetworks
   */
  public List<DiscoveredNetwork> getDiscoveredNetworks() {
    return discoveredNetworks;
  }

  /**
   * This is the setter method. this will set the discoveredNetworks
   * Discovered networks providing reachability for client facing vip ip.
   * Field introduced in 17.1.1.
   * @return discoveredNetworks
   */
  public void setDiscoveredNetworks(List<DiscoveredNetwork>  discoveredNetworks) {
    this.discoveredNetworks = discoveredNetworks;
  }

  /**
   * This is the setter method this will set the discoveredNetworks
   * Discovered networks providing reachability for client facing vip ip.
   * Field introduced in 17.1.1.
   * @return discoveredNetworks
   */
  public Vip addDiscoveredNetworksItem(DiscoveredNetwork discoveredNetworksItem) {
    if (this.discoveredNetworks == null) {
      this.discoveredNetworks = new ArrayList<DiscoveredNetwork>();
    }
    this.discoveredNetworks.add(discoveredNetworksItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable or disable the vip.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return enabled
   */
  public Boolean getEnabled() {
    return enabled;
  }

  /**
   * This is the setter method to the attribute.
   * Enable or disable the vip.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param enabled set the enabled.
   */
  public void setEnabled(Boolean  enabled) {
    this.enabled = enabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Floating ipv4 to associate with this vip.
   * Field introduced in 17.1.1.
   * @return floatingIp
   */
  public IpAddr getFloatingIp() {
    return floatingIp;
  }

  /**
   * This is the setter method to the attribute.
   * Floating ipv4 to associate with this vip.
   * Field introduced in 17.1.1.
   * @param floatingIp set the floatingIp.
   */
  public void setFloatingIp(IpAddr floatingIp) {
    this.floatingIp = floatingIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Floating ipv6 address to associate with this vip.
   * Field introduced in 18.1.1.
   * @return floatingIp6
   */
  public IpAddr getFloatingIp6() {
    return floatingIp6;
  }

  /**
   * This is the setter method to the attribute.
   * Floating ipv6 address to associate with this vip.
   * Field introduced in 18.1.1.
   * @param floatingIp6 set the floatingIp6.
   */
  public void setFloatingIp6(IpAddr floatingIp6) {
    this.floatingIp6 = floatingIp6;
  }

  /**
   * This is the getter method this will return the attribute value.
   * If auto_allocate_floating_ip is true and more than one floating-ip subnets exist, then the subnet for the floating ipv6 address allocation.
   * Field introduced in 18.1.1.
   * @return floatingSubnet6Uuid
   */
  public String getFloatingSubnet6Uuid() {
    return floatingSubnet6Uuid;
  }

  /**
   * This is the setter method to the attribute.
   * If auto_allocate_floating_ip is true and more than one floating-ip subnets exist, then the subnet for the floating ipv6 address allocation.
   * Field introduced in 18.1.1.
   * @param floatingSubnet6Uuid set the floatingSubnet6Uuid.
   */
  public void setFloatingSubnet6Uuid(String  floatingSubnet6Uuid) {
    this.floatingSubnet6Uuid = floatingSubnet6Uuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * If auto_allocate_floating_ip is true and more than one floating-ip subnets exist, then the subnet for the floating ip address allocation.
   * Field introduced in 17.1.1.
   * @return floatingSubnetUuid
   */
  public String getFloatingSubnetUuid() {
    return floatingSubnetUuid;
  }

  /**
   * This is the setter method to the attribute.
   * If auto_allocate_floating_ip is true and more than one floating-ip subnets exist, then the subnet for the floating ip address allocation.
   * Field introduced in 17.1.1.
   * @param floatingSubnetUuid set the floatingSubnetUuid.
   */
  public void setFloatingSubnetUuid(String  floatingSubnetUuid) {
    this.floatingSubnetUuid = floatingSubnetUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ipv6 address of the vip.
   * Field introduced in 18.1.1.
   * @return ip6Address
   */
  public IpAddr getIp6Address() {
    return ip6Address;
  }

  /**
   * This is the setter method to the attribute.
   * Ipv6 address of the vip.
   * Field introduced in 18.1.1.
   * @param ip6Address set the ip6Address.
   */
  public void setIp6Address(IpAddr ip6Address) {
    this.ip6Address = ip6Address;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ipv4 address of the vip.
   * Field introduced in 17.1.1.
   * @return ipAddress
   */
  public IpAddr getIpAddress() {
    return ipAddress;
  }

  /**
   * This is the setter method to the attribute.
   * Ipv4 address of the vip.
   * Field introduced in 17.1.1.
   * @param ipAddress set the ipAddress.
   */
  public void setIpAddress(IpAddr ipAddress) {
    this.ipAddress = ipAddress;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Subnet and/or network for allocating virtualservice ip by ipam provider module.
   * Field introduced in 17.1.1.
   * @return ipamNetworkSubnet
   */
  public IPNetworkSubnet getIpamNetworkSubnet() {
    return ipamNetworkSubnet;
  }

  /**
   * This is the setter method to the attribute.
   * Subnet and/or network for allocating virtualservice ip by ipam provider module.
   * Field introduced in 17.1.1.
   * @param ipamNetworkSubnet set the ipamNetworkSubnet.
   */
  public void setIpamNetworkSubnet(IPNetworkSubnet ipamNetworkSubnet) {
    this.ipamNetworkSubnet = ipamNetworkSubnet;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Manually override the network on which the vip is placed.
   * It is a reference to an object of type network.
   * Field introduced in 17.1.1.
   * @return networkRef
   */
  public String getNetworkRef() {
    return networkRef;
  }

  /**
   * This is the setter method to the attribute.
   * Manually override the network on which the vip is placed.
   * It is a reference to an object of type network.
   * Field introduced in 17.1.1.
   * @param networkRef set the networkRef.
   */
  public void setNetworkRef(String  networkRef) {
    this.networkRef = networkRef;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placement networks/subnets to use for vip placement.
   * Field introduced in 18.2.5.
   * @return placementNetworks
   */
  public List<VipPlacementNetwork> getPlacementNetworks() {
    return placementNetworks;
  }

  /**
   * This is the setter method. this will set the placementNetworks
   * Placement networks/subnets to use for vip placement.
   * Field introduced in 18.2.5.
   * @return placementNetworks
   */
  public void setPlacementNetworks(List<VipPlacementNetwork>  placementNetworks) {
    this.placementNetworks = placementNetworks;
  }

  /**
   * This is the setter method this will set the placementNetworks
   * Placement networks/subnets to use for vip placement.
   * Field introduced in 18.2.5.
   * @return placementNetworks
   */
  public Vip addPlacementNetworksItem(VipPlacementNetwork placementNetworksItem) {
    if (this.placementNetworks == null) {
      this.placementNetworks = new ArrayList<VipPlacementNetwork>();
    }
    this.placementNetworks.add(placementNetworksItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * (internal-use) network port assigned to the vip ip address.
   * Field introduced in 17.1.1.
   * @return portUuid
   */
  public String getPortUuid() {
    return portUuid;
  }

  /**
   * This is the setter method to the attribute.
   * (internal-use) network port assigned to the vip ip address.
   * Field introduced in 17.1.1.
   * @param portUuid set the portUuid.
   */
  public void setPortUuid(String  portUuid) {
    this.portUuid = portUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Mask applied for the vip, non-default mask supported only for wildcard vip.
   * Allowed values are 0-32.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 32.
   * @return prefixLength
   */
  public Integer getPrefixLength() {
    return prefixLength;
  }

  /**
   * This is the setter method to the attribute.
   * Mask applied for the vip, non-default mask supported only for wildcard vip.
   * Allowed values are 0-32.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 32.
   * @param prefixLength set the prefixLength.
   */
  public void setPrefixLength(Integer  prefixLength) {
    this.prefixLength = prefixLength;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Subnet providing reachability for client facing vip ip.
   * Field introduced in 17.1.1.
   * @return subnet
   */
  public IpAddrPrefix getSubnet() {
    return subnet;
  }

  /**
   * This is the setter method to the attribute.
   * Subnet providing reachability for client facing vip ip.
   * Field introduced in 17.1.1.
   * @param subnet set the subnet.
   */
  public void setSubnet(IpAddrPrefix subnet) {
    this.subnet = subnet;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Subnet providing reachability for client facing vip ipv6.
   * Field introduced in 18.1.1.
   * @return subnet6
   */
  public IpAddrPrefix getSubnet6() {
    return subnet6;
  }

  /**
   * This is the setter method to the attribute.
   * Subnet providing reachability for client facing vip ipv6.
   * Field introduced in 18.1.1.
   * @param subnet6 set the subnet6.
   */
  public void setSubnet6(IpAddrPrefix subnet6) {
    this.subnet6 = subnet6;
  }

  /**
   * This is the getter method this will return the attribute value.
   * If auto_allocate_ip is true, then the subnet for the vip ipv6 address allocation.
   * This field is applicable only if the virtualservice belongs to an openstack or aws cloud, in which case it is mandatory, if auto_allocate is
   * selected.
   * Field introduced in 18.1.1.
   * @return subnet6Uuid
   */
  public String getSubnet6Uuid() {
    return subnet6Uuid;
  }

  /**
   * This is the setter method to the attribute.
   * If auto_allocate_ip is true, then the subnet for the vip ipv6 address allocation.
   * This field is applicable only if the virtualservice belongs to an openstack or aws cloud, in which case it is mandatory, if auto_allocate is
   * selected.
   * Field introduced in 18.1.1.
   * @param subnet6Uuid set the subnet6Uuid.
   */
  public void setSubnet6Uuid(String  subnet6Uuid) {
    this.subnet6Uuid = subnet6Uuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * If auto_allocate_ip is true, then the subnet for the vip ip address allocation.
   * This field is applicable only if the virtualservice belongs to an openstack or aws cloud, in which case it is mandatory, if auto_allocate is
   * selected.
   * Field introduced in 17.1.1.
   * @return subnetUuid
   */
  public String getSubnetUuid() {
    return subnetUuid;
  }

  /**
   * This is the setter method to the attribute.
   * If auto_allocate_ip is true, then the subnet for the vip ip address allocation.
   * This field is applicable only if the virtualservice belongs to an openstack or aws cloud, in which case it is mandatory, if auto_allocate is
   * selected.
   * Field introduced in 17.1.1.
   * @param subnetUuid set the subnetUuid.
   */
  public void setSubnetUuid(String  subnetUuid) {
    this.subnetUuid = subnetUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique id associated with the vip.
   * Field introduced in 17.1.1.
   * @return vipId
   */
  public String getVipId() {
    return vipId;
  }

  /**
   * This is the setter method to the attribute.
   * Unique id associated with the vip.
   * Field introduced in 17.1.1.
   * @param vipId set the vipId.
   */
  public void setVipId(String  vipId) {
    this.vipId = vipId;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  Vip objVip = (Vip) o;
  return   Objects.equals(this.vipId, objVip.vipId)&&
  Objects.equals(this.ipAddress, objVip.ipAddress)&&
  Objects.equals(this.enabled, objVip.enabled)&&
  Objects.equals(this.networkRef, objVip.networkRef)&&
  Objects.equals(this.portUuid, objVip.portUuid)&&
  Objects.equals(this.subnetUuid, objVip.subnetUuid)&&
  Objects.equals(this.subnet, objVip.subnet)&&
  Objects.equals(this.discoveredNetworks, objVip.discoveredNetworks)&&
  Objects.equals(this.availabilityZone, objVip.availabilityZone)&&
  Objects.equals(this.autoAllocateIp, objVip.autoAllocateIp)&&
  Objects.equals(this.floatingIp, objVip.floatingIp)&&
  Objects.equals(this.autoAllocateFloatingIp, objVip.autoAllocateFloatingIp)&&
  Objects.equals(this.floatingSubnetUuid, objVip.floatingSubnetUuid)&&
  Objects.equals(this.aviAllocatedVip, objVip.aviAllocatedVip)&&
  Objects.equals(this.aviAllocatedFip, objVip.aviAllocatedFip)&&
  Objects.equals(this.ipamNetworkSubnet, objVip.ipamNetworkSubnet)&&
  Objects.equals(this.ip6Address, objVip.ip6Address)&&
  Objects.equals(this.subnet6Uuid, objVip.subnet6Uuid)&&
  Objects.equals(this.subnet6, objVip.subnet6)&&
  Objects.equals(this.floatingIp6, objVip.floatingIp6)&&
  Objects.equals(this.floatingSubnet6Uuid, objVip.floatingSubnet6Uuid)&&
  Objects.equals(this.autoAllocateIpType, objVip.autoAllocateIpType)&&
  Objects.equals(this.placementNetworks, objVip.placementNetworks)&&
  Objects.equals(this.prefixLength, objVip.prefixLength);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class Vip {\n");
      sb.append("    autoAllocateFloatingIp: ").append(toIndentedString(autoAllocateFloatingIp)).append("\n");
        sb.append("    autoAllocateIp: ").append(toIndentedString(autoAllocateIp)).append("\n");
        sb.append("    autoAllocateIpType: ").append(toIndentedString(autoAllocateIpType)).append("\n");
        sb.append("    availabilityZone: ").append(toIndentedString(availabilityZone)).append("\n");
        sb.append("    aviAllocatedFip: ").append(toIndentedString(aviAllocatedFip)).append("\n");
        sb.append("    aviAllocatedVip: ").append(toIndentedString(aviAllocatedVip)).append("\n");
        sb.append("    discoveredNetworks: ").append(toIndentedString(discoveredNetworks)).append("\n");
        sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
        sb.append("    floatingIp: ").append(toIndentedString(floatingIp)).append("\n");
        sb.append("    floatingIp6: ").append(toIndentedString(floatingIp6)).append("\n");
        sb.append("    floatingSubnet6Uuid: ").append(toIndentedString(floatingSubnet6Uuid)).append("\n");
        sb.append("    floatingSubnetUuid: ").append(toIndentedString(floatingSubnetUuid)).append("\n");
        sb.append("    ip6Address: ").append(toIndentedString(ip6Address)).append("\n");
        sb.append("    ipAddress: ").append(toIndentedString(ipAddress)).append("\n");
        sb.append("    ipamNetworkSubnet: ").append(toIndentedString(ipamNetworkSubnet)).append("\n");
        sb.append("    networkRef: ").append(toIndentedString(networkRef)).append("\n");
        sb.append("    placementNetworks: ").append(toIndentedString(placementNetworks)).append("\n");
        sb.append("    portUuid: ").append(toIndentedString(portUuid)).append("\n");
        sb.append("    prefixLength: ").append(toIndentedString(prefixLength)).append("\n");
        sb.append("    subnet: ").append(toIndentedString(subnet)).append("\n");
        sb.append("    subnet6: ").append(toIndentedString(subnet6)).append("\n");
        sb.append("    subnet6Uuid: ").append(toIndentedString(subnet6Uuid)).append("\n");
        sb.append("    subnetUuid: ").append(toIndentedString(subnetUuid)).append("\n");
        sb.append("    vipId: ").append(toIndentedString(vipId)).append("\n");
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

