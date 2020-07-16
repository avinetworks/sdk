package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Server is a POJO class extends AviRestResource that used for creating
 * Server.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Server  {
    @JsonProperty("autoscaling_group_name")
    private String autoscalingGroupName = null;

    @JsonProperty("availability_zone")
    private String availabilityZone = null;

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("discovered_network_ref")
    private List<String> discoveredNetworkRef = null;

    @JsonProperty("discovered_networks")
    private List<DiscoveredNetwork> discoveredNetworks = null;

    @JsonProperty("discovered_subnet")
    private List<IpAddrPrefix> discoveredSubnet = null;

    @JsonProperty("enabled")
    private Boolean enabled = true;

    @JsonProperty("external_orchestration_id")
    private String externalOrchestrationId = null;

    @JsonProperty("external_uuid")
    private String externalUuid = null;

    @JsonProperty("hostname")
    private String hostname = null;

    @JsonProperty("ip")
    private IpAddr ip = null;

    @JsonProperty("location")
    private GeoLocation location = null;

    @JsonProperty("mac_address")
    private String macAddress = null;

    @JsonProperty("nw_ref")
    private String nwRef = null;

    @JsonProperty("port")
    private Integer port = null;

    @JsonProperty("prst_hdr_val")
    private String prstHdrVal = null;

    @JsonProperty("ratio")
    private Integer ratio = 1;

    @JsonProperty("resolve_server_by_dns")
    private Boolean resolveServerByDns = false;

    @JsonProperty("rewrite_host_header")
    private Boolean rewriteHostHeader = false;

    @JsonProperty("server_node")
    private String serverNode = null;

    @JsonProperty("static")
    private Boolean statics = false;

    @JsonProperty("verify_network")
    private Boolean verifyNetwork = false;

    @JsonProperty("vm_ref")
    private String vmRef = null;



  /**
   * This is the getter method this will return the attribute value.
   * Name of autoscaling group this server belongs to.
   * Field introduced in 17.1.2.
   * @return autoscalingGroupName
   */
  public String getAutoscalingGroupName() {
    return autoscalingGroupName;
  }

  /**
   * This is the setter method to the attribute.
   * Name of autoscaling group this server belongs to.
   * Field introduced in 17.1.2.
   * @param autoscalingGroupName set the autoscalingGroupName.
   */
  public void setAutoscalingGroupName(String  autoscalingGroupName) {
    this.autoscalingGroupName = autoscalingGroupName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Availability-zone of the server vm.
   * @return availabilityZone
   */
  public String getAvailabilityZone() {
    return availabilityZone;
  }

  /**
   * This is the setter method to the attribute.
   * Availability-zone of the server vm.
   * @param availabilityZone set the availabilityZone.
   */
  public void setAvailabilityZone(String  availabilityZone) {
    this.availabilityZone = availabilityZone;
  }

  /**
   * This is the getter method this will return the attribute value.
   * A description of the server.
   * @return description
   */
  public String getDescription() {
    return description;
  }

  /**
   * This is the setter method to the attribute.
   * A description of the server.
   * @param description set the description.
   */
  public void setDescription(String  description) {
    this.description = description;
  }
  /**
   * This is the getter method this will return the attribute value.
   * (internal-use) discovered network for this server.
   * This field is deprecated.
   * It is a reference to an object of type network.
   * Field deprecated in 17.1.1.
   * @return discoveredNetworkRef
   */
  public List<String> getDiscoveredNetworkRef() {
    return discoveredNetworkRef;
  }

  /**
   * This is the setter method. this will set the discoveredNetworkRef
   * (internal-use) discovered network for this server.
   * This field is deprecated.
   * It is a reference to an object of type network.
   * Field deprecated in 17.1.1.
   * @return discoveredNetworkRef
   */
  public void setDiscoveredNetworkRef(List<String>  discoveredNetworkRef) {
    this.discoveredNetworkRef = discoveredNetworkRef;
  }

  /**
   * This is the setter method this will set the discoveredNetworkRef
   * (internal-use) discovered network for this server.
   * This field is deprecated.
   * It is a reference to an object of type network.
   * Field deprecated in 17.1.1.
   * @return discoveredNetworkRef
   */
  public Server addDiscoveredNetworkRefItem(String discoveredNetworkRefItem) {
    if (this.discoveredNetworkRef == null) {
      this.discoveredNetworkRef = new ArrayList<String>();
    }
    this.discoveredNetworkRef.add(discoveredNetworkRefItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * (internal-use) discovered networks providing reachability for server ip.
   * This field is used internally by avi, not editable by the user.
   * @return discoveredNetworks
   */
  public List<DiscoveredNetwork> getDiscoveredNetworks() {
    return discoveredNetworks;
  }

  /**
   * This is the setter method. this will set the discoveredNetworks
   * (internal-use) discovered networks providing reachability for server ip.
   * This field is used internally by avi, not editable by the user.
   * @return discoveredNetworks
   */
  public void setDiscoveredNetworks(List<DiscoveredNetwork>  discoveredNetworks) {
    this.discoveredNetworks = discoveredNetworks;
  }

  /**
   * This is the setter method this will set the discoveredNetworks
   * (internal-use) discovered networks providing reachability for server ip.
   * This field is used internally by avi, not editable by the user.
   * @return discoveredNetworks
   */
  public Server addDiscoveredNetworksItem(DiscoveredNetwork discoveredNetworksItem) {
    if (this.discoveredNetworks == null) {
      this.discoveredNetworks = new ArrayList<DiscoveredNetwork>();
    }
    this.discoveredNetworks.add(discoveredNetworksItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * (internal-use) discovered subnet for this server.
   * This field is deprecated.
   * Field deprecated in 17.1.1.
   * @return discoveredSubnet
   */
  public List<IpAddrPrefix> getDiscoveredSubnet() {
    return discoveredSubnet;
  }

  /**
   * This is the setter method. this will set the discoveredSubnet
   * (internal-use) discovered subnet for this server.
   * This field is deprecated.
   * Field deprecated in 17.1.1.
   * @return discoveredSubnet
   */
  public void setDiscoveredSubnet(List<IpAddrPrefix>  discoveredSubnet) {
    this.discoveredSubnet = discoveredSubnet;
  }

  /**
   * This is the setter method this will set the discoveredSubnet
   * (internal-use) discovered subnet for this server.
   * This field is deprecated.
   * Field deprecated in 17.1.1.
   * @return discoveredSubnet
   */
  public Server addDiscoveredSubnetItem(IpAddrPrefix discoveredSubnetItem) {
    if (this.discoveredSubnet == null) {
      this.discoveredSubnet = new ArrayList<IpAddrPrefix>();
    }
    this.discoveredSubnet.add(discoveredSubnetItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable, disable or graceful disable determine if new or existing connections to the server are allowed.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return enabled
   */
  public Boolean getEnabled() {
    return enabled;
  }

  /**
   * This is the setter method to the attribute.
   * Enable, disable or graceful disable determine if new or existing connections to the server are allowed.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param enabled set the enabled.
   */
  public void setEnabled(Boolean  enabled) {
    this.enabled = enabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Uid of server in external orchestration systems.
   * @return externalOrchestrationId
   */
  public String getExternalOrchestrationId() {
    return externalOrchestrationId;
  }

  /**
   * This is the setter method to the attribute.
   * Uid of server in external orchestration systems.
   * @param externalOrchestrationId set the externalOrchestrationId.
   */
  public void setExternalOrchestrationId(String  externalOrchestrationId) {
    this.externalOrchestrationId = externalOrchestrationId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Uuid identifying vm in openstack and other external compute.
   * @return externalUuid
   */
  public String getExternalUuid() {
    return externalUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid identifying vm in openstack and other external compute.
   * @param externalUuid set the externalUuid.
   */
  public void setExternalUuid(String  externalUuid) {
    this.externalUuid = externalUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dns resolvable name of the server.
   * May be used in place of the ip address.
   * @return hostname
   */
  public String getHostname() {
    return hostname;
  }

  /**
   * This is the setter method to the attribute.
   * Dns resolvable name of the server.
   * May be used in place of the ip address.
   * @param hostname set the hostname.
   */
  public void setHostname(String  hostname) {
    this.hostname = hostname;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ip address of the server.
   * Required if there is no resolvable host name.
   * @return ip
   */
  public IpAddr getIp() {
    return ip;
  }

  /**
   * This is the setter method to the attribute.
   * Ip address of the server.
   * Required if there is no resolvable host name.
   * @param ip set the ip.
   */
  public void setIp(IpAddr ip) {
    this.ip = ip;
  }

  /**
   * This is the getter method this will return the attribute value.
   * (internal-use) geographic location of the server.currently only for internal usage.
   * Field introduced in 17.1.1.
   * @return location
   */
  public GeoLocation getLocation() {
    return location;
  }

  /**
   * This is the setter method to the attribute.
   * (internal-use) geographic location of the server.currently only for internal usage.
   * Field introduced in 17.1.1.
   * @param location set the location.
   */
  public void setLocation(GeoLocation location) {
    this.location = location;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Mac address of server.
   * @return macAddress
   */
  public String getMacAddress() {
    return macAddress;
  }

  /**
   * This is the setter method to the attribute.
   * Mac address of server.
   * @param macAddress set the macAddress.
   */
  public void setMacAddress(String  macAddress) {
    this.macAddress = macAddress;
  }

  /**
   * This is the getter method this will return the attribute value.
   * (internal-use) this field is used internally by avi, not editable by the user.
   * It is a reference to an object of type vimgrnwruntime.
   * @return nwRef
   */
  public String getNwRef() {
    return nwRef;
  }

  /**
   * This is the setter method to the attribute.
   * (internal-use) this field is used internally by avi, not editable by the user.
   * It is a reference to an object of type vimgrnwruntime.
   * @param nwRef set the nwRef.
   */
  public void setNwRef(String  nwRef) {
    this.nwRef = nwRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Optionally specify the servers port number.
   * This will override the pool's default server port attribute.
   * Allowed values are 1-65535.
   * Special values are 0- 'use backend port in pool'.
   * @return port
   */
  public Integer getPort() {
    return port;
  }

  /**
   * This is the setter method to the attribute.
   * Optionally specify the servers port number.
   * This will override the pool's default server port attribute.
   * Allowed values are 1-65535.
   * Special values are 0- 'use backend port in pool'.
   * @param port set the port.
   */
  public void setPort(Integer  port) {
    this.port = port;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Header value for custom header persistence.
   * @return prstHdrVal
   */
  public String getPrstHdrVal() {
    return prstHdrVal;
  }

  /**
   * This is the setter method to the attribute.
   * Header value for custom header persistence.
   * @param prstHdrVal set the prstHdrVal.
   */
  public void setPrstHdrVal(String  prstHdrVal) {
    this.prstHdrVal = prstHdrVal;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ratio of selecting eligible servers in the pool.
   * Allowed values are 1-20.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.
   * @return ratio
   */
  public Integer getRatio() {
    return ratio;
  }

  /**
   * This is the setter method to the attribute.
   * Ratio of selecting eligible servers in the pool.
   * Allowed values are 1-20.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.
   * @param ratio set the ratio.
   */
  public void setRatio(Integer  ratio) {
    this.ratio = ratio;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Auto resolve server's ip using dns name.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return resolveServerByDns
   */
  public Boolean getResolveServerByDns() {
    return resolveServerByDns;
  }

  /**
   * This is the setter method to the attribute.
   * Auto resolve server's ip using dns name.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param resolveServerByDns set the resolveServerByDns.
   */
  public void setResolveServerByDns(Boolean  resolveServerByDns) {
    this.resolveServerByDns = resolveServerByDns;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Rewrite incoming host header to server name.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return rewriteHostHeader
   */
  public Boolean getRewriteHostHeader() {
    return rewriteHostHeader;
  }

  /**
   * This is the setter method to the attribute.
   * Rewrite incoming host header to server name.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param rewriteHostHeader set the rewriteHostHeader.
   */
  public void setRewriteHostHeader(Boolean  rewriteHostHeader) {
    this.rewriteHostHeader = rewriteHostHeader;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Hostname of the node where the server vm or container resides.
   * @return serverNode
   */
  public String getServerNode() {
    return serverNode;
  }

  /**
   * This is the setter method to the attribute.
   * Hostname of the node where the server vm or container resides.
   * @param serverNode set the serverNode.
   */
  public void setServerNode(String  serverNode) {
    this.serverNode = serverNode;
  }

  /**
   * This is the getter method this will return the attribute value.
   * If statically learned.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return statics
   */
  public Boolean getStatic() {
    return statics;
  }

  /**
   * This is the setter method to the attribute.
   * If statically learned.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param statics set the statics.
   */
  public void setStatic(Boolean  statics) {
    this.statics = statics;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Verify server belongs to a discovered network or reachable via a discovered network.
   * Verify reachable network isn't the openstack management network.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return verifyNetwork
   */
  public Boolean getVerifyNetwork() {
    return verifyNetwork;
  }

  /**
   * This is the setter method to the attribute.
   * Verify server belongs to a discovered network or reachable via a discovered network.
   * Verify reachable network isn't the openstack management network.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param verifyNetwork set the verifyNetwork.
   */
  public void setVerifyNetwork(Boolean  verifyNetwork) {
    this.verifyNetwork = verifyNetwork;
  }

  /**
   * This is the getter method this will return the attribute value.
   * (internal-use) this field is used internally by avi, not editable by the user.
   * It is a reference to an object of type vimgrvmruntime.
   * @return vmRef
   */
  public String getVmRef() {
    return vmRef;
  }

  /**
   * This is the setter method to the attribute.
   * (internal-use) this field is used internally by avi, not editable by the user.
   * It is a reference to an object of type vimgrvmruntime.
   * @param vmRef set the vmRef.
   */
  public void setVmRef(String  vmRef) {
    this.vmRef = vmRef;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  Server objServer = (Server) o;
  return   Objects.equals(this.availabilityZone, objServer.availabilityZone)&&
  Objects.equals(this.autoscalingGroupName, objServer.autoscalingGroupName)&&
  Objects.equals(this.ip, objServer.ip)&&
  Objects.equals(this.statics, objServer.statics)&&
  Objects.equals(this.discoveredNetworkRef, objServer.discoveredNetworkRef)&&
  Objects.equals(this.rewriteHostHeader, objServer.rewriteHostHeader)&&
  Objects.equals(this.port, objServer.port)&&
  Objects.equals(this.ratio, objServer.ratio)&&
  Objects.equals(this.hostname, objServer.hostname)&&
  Objects.equals(this.verifyNetwork, objServer.verifyNetwork)&&
  Objects.equals(this.location, objServer.location)&&
  Objects.equals(this.macAddress, objServer.macAddress)&&
  Objects.equals(this.externalUuid, objServer.externalUuid)&&
  Objects.equals(this.prstHdrVal, objServer.prstHdrVal)&&
  Objects.equals(this.description, objServer.description)&&
  Objects.equals(this.resolveServerByDns, objServer.resolveServerByDns)&&
  Objects.equals(this.externalOrchestrationId, objServer.externalOrchestrationId)&&
  Objects.equals(this.discoveredNetworks, objServer.discoveredNetworks)&&
  Objects.equals(this.enabled, objServer.enabled)&&
  Objects.equals(this.discoveredSubnet, objServer.discoveredSubnet)&&
  Objects.equals(this.serverNode, objServer.serverNode)&&
  Objects.equals(this.nwRef, objServer.nwRef)&&
  Objects.equals(this.vmRef, objServer.vmRef);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class Server {\n");
      sb.append("    autoscalingGroupName: ").append(toIndentedString(autoscalingGroupName)).append("\n");
        sb.append("    availabilityZone: ").append(toIndentedString(availabilityZone)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    discoveredNetworkRef: ").append(toIndentedString(discoveredNetworkRef)).append("\n");
        sb.append("    discoveredNetworks: ").append(toIndentedString(discoveredNetworks)).append("\n");
        sb.append("    discoveredSubnet: ").append(toIndentedString(discoveredSubnet)).append("\n");
        sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
        sb.append("    externalOrchestrationId: ").append(toIndentedString(externalOrchestrationId)).append("\n");
        sb.append("    externalUuid: ").append(toIndentedString(externalUuid)).append("\n");
        sb.append("    hostname: ").append(toIndentedString(hostname)).append("\n");
        sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
        sb.append("    location: ").append(toIndentedString(location)).append("\n");
        sb.append("    macAddress: ").append(toIndentedString(macAddress)).append("\n");
        sb.append("    nwRef: ").append(toIndentedString(nwRef)).append("\n");
        sb.append("    port: ").append(toIndentedString(port)).append("\n");
        sb.append("    prstHdrVal: ").append(toIndentedString(prstHdrVal)).append("\n");
        sb.append("    ratio: ").append(toIndentedString(ratio)).append("\n");
        sb.append("    resolveServerByDns: ").append(toIndentedString(resolveServerByDns)).append("\n");
        sb.append("    rewriteHostHeader: ").append(toIndentedString(rewriteHostHeader)).append("\n");
        sb.append("    serverNode: ").append(toIndentedString(serverNode)).append("\n");
        sb.append("    statics: ").append(toIndentedString(statics)).append("\n");
        sb.append("    verifyNetwork: ").append(toIndentedString(verifyNetwork)).append("\n");
        sb.append("    vmRef: ").append(toIndentedString(vmRef)).append("\n");
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

