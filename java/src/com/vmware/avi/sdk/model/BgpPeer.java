package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The BgpPeer is a POJO class extends AviRestResource that used for creating
 * BgpPeer.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BgpPeer  {
    @JsonProperty("advertise_snat_ip")
    private Boolean advertiseSnatIp = true;

    @JsonProperty("advertise_vip")
    private Boolean advertiseVip = true;

    @JsonProperty("advertisement_interval")
    private Integer advertisementInterval = 5;

    @JsonProperty("bfd")
    private Boolean bfd = true;

    @JsonProperty("connect_timer")
    private Integer connectTimer = 10;

    @JsonProperty("ebgp_multihop")
    private Integer ebgpMultihop = 0;

    @JsonProperty("hold_time")
    private Integer holdTime = null;

    @JsonProperty("keepalive_interval")
    private Integer keepaliveInterval = null;

    @JsonProperty("label")
    private String label = null;

    @JsonProperty("local_as")
    private Integer localAs = null;

    @JsonProperty("md5_secret")
    private String md5Secret = null;

    @JsonProperty("network_ref")
    private String networkRef = null;

    @JsonProperty("peer_ip")
    private IpAddr peerIp = null;

    @JsonProperty("peer_ip6")
    private IpAddr peerIp6 = null;

    @JsonProperty("remote_as")
    private Integer remoteAs = null;

    @JsonProperty("shutdown")
    private Boolean shutdown = false;

    @JsonProperty("subnet")
    private IpAddrPrefix subnet = null;

    @JsonProperty("subnet6")
    private IpAddrPrefix subnet6 = null;



  /**
   * This is the getter method this will return the attribute value.
   * Advertise snat ip to this peer.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return advertiseSnatIp
   */
  public Boolean getAdvertiseSnatIp() {
    return advertiseSnatIp;
  }

  /**
   * This is the setter method to the attribute.
   * Advertise snat ip to this peer.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param advertiseSnatIp set the advertiseSnatIp.
   */
  public void setAdvertiseSnatIp(Boolean  advertiseSnatIp) {
    this.advertiseSnatIp = advertiseSnatIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Advertise vip to this peer.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return advertiseVip
   */
  public Boolean getAdvertiseVip() {
    return advertiseVip;
  }

  /**
   * This is the setter method to the attribute.
   * Advertise vip to this peer.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param advertiseVip set the advertiseVip.
   */
  public void setAdvertiseVip(Boolean  advertiseVip) {
    this.advertiseVip = advertiseVip;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Advertisement interval for this peer.
   * Allowed values are 1-60.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5.
   * @return advertisementInterval
   */
  public Integer getAdvertisementInterval() {
    return advertisementInterval;
  }

  /**
   * This is the setter method to the attribute.
   * Advertisement interval for this peer.
   * Allowed values are 1-60.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5.
   * @param advertisementInterval set the advertisementInterval.
   */
  public void setAdvertisementInterval(Integer  advertisementInterval) {
    this.advertisementInterval = advertisementInterval;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable bi-directional forward detection.
   * Only async mode supported.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return bfd
   */
  public Boolean getBfd() {
    return bfd;
  }

  /**
   * This is the setter method to the attribute.
   * Enable bi-directional forward detection.
   * Only async mode supported.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param bfd set the bfd.
   */
  public void setBfd(Boolean  bfd) {
    this.bfd = bfd;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Connect timer for this peer.
   * Allowed values are 1-120.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.
   * @return connectTimer
   */
  public Integer getConnectTimer() {
    return connectTimer;
  }

  /**
   * This is the setter method to the attribute.
   * Connect timer for this peer.
   * Allowed values are 1-120.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.
   * @param connectTimer set the connectTimer.
   */
  public void setConnectTimer(Integer  connectTimer) {
    this.connectTimer = connectTimer;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ttl for multihop ebgp peer.
   * Allowed values are 0-255.
   * Field introduced in 17.1.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return ebgpMultihop
   */
  public Integer getEbgpMultihop() {
    return ebgpMultihop;
  }

  /**
   * This is the setter method to the attribute.
   * Ttl for multihop ebgp peer.
   * Allowed values are 0-255.
   * Field introduced in 17.1.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param ebgpMultihop set the ebgpMultihop.
   */
  public void setEbgpMultihop(Integer  ebgpMultihop) {
    this.ebgpMultihop = ebgpMultihop;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Hold time for this peer.
   * Allowed values are 3-7200.
   * @return holdTime
   */
  public Integer getHoldTime() {
    return holdTime;
  }

  /**
   * This is the setter method to the attribute.
   * Hold time for this peer.
   * Allowed values are 3-7200.
   * @param holdTime set the holdTime.
   */
  public void setHoldTime(Integer  holdTime) {
    this.holdTime = holdTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Keepalive interval for this peer.
   * Allowed values are 0-3600.
   * @return keepaliveInterval
   */
  public Integer getKeepaliveInterval() {
    return keepaliveInterval;
  }

  /**
   * This is the setter method to the attribute.
   * Keepalive interval for this peer.
   * Allowed values are 0-3600.
   * @param keepaliveInterval set the keepaliveInterval.
   */
  public void setKeepaliveInterval(Integer  keepaliveInterval) {
    this.keepaliveInterval = keepaliveInterval;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Label used to enable learning and/or advertisement of routes to this peer.
   * Field introduced in 20.1.1.
   * @return label
   */
  public String getLabel() {
    return label;
  }

  /**
   * This is the setter method to the attribute.
   * Label used to enable learning and/or advertisement of routes to this peer.
   * Field introduced in 20.1.1.
   * @param label set the label.
   */
  public void setLabel(String  label) {
    this.label = label;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Local as to use for this ebgp peer.
   * If specified, this will override the local as configured at the vrf level.
   * Allowed values are 1-4294967295.
   * Field introduced in 17.1.6,17.2.2.
   * @return localAs
   */
  public Integer getLocalAs() {
    return localAs;
  }

  /**
   * This is the setter method to the attribute.
   * Local as to use for this ebgp peer.
   * If specified, this will override the local as configured at the vrf level.
   * Allowed values are 1-4294967295.
   * Field introduced in 17.1.6,17.2.2.
   * @param localAs set the localAs.
   */
  public void setLocalAs(Integer  localAs) {
    this.localAs = localAs;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Peer autonomous system md5 digest secret key.
   * @return md5Secret
   */
  public String getMd5Secret() {
    return md5Secret;
  }

  /**
   * This is the setter method to the attribute.
   * Peer autonomous system md5 digest secret key.
   * @param md5Secret set the md5Secret.
   */
  public void setMd5Secret(String  md5Secret) {
    this.md5Secret = md5Secret;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Network providing reachability for peer.
   * It is a reference to an object of type network.
   * @return networkRef
   */
  public String getNetworkRef() {
    return networkRef;
  }

  /**
   * This is the setter method to the attribute.
   * Network providing reachability for peer.
   * It is a reference to an object of type network.
   * @param networkRef set the networkRef.
   */
  public void setNetworkRef(String  networkRef) {
    this.networkRef = networkRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ip address of the bgp peer.
   * @return peerIp
   */
  public IpAddr getPeerIp() {
    return peerIp;
  }

  /**
   * This is the setter method to the attribute.
   * Ip address of the bgp peer.
   * @param peerIp set the peerIp.
   */
  public void setPeerIp(IpAddr peerIp) {
    this.peerIp = peerIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ipv6 address of the bgp peer.
   * Field introduced in 18.1.1.
   * @return peerIp6
   */
  public IpAddr getPeerIp6() {
    return peerIp6;
  }

  /**
   * This is the setter method to the attribute.
   * Ipv6 address of the bgp peer.
   * Field introduced in 18.1.1.
   * @param peerIp6 set the peerIp6.
   */
  public void setPeerIp6(IpAddr peerIp6) {
    this.peerIp6 = peerIp6;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Peer autonomous system id.
   * Allowed values are 1-4294967295.
   * @return remoteAs
   */
  public Integer getRemoteAs() {
    return remoteAs;
  }

  /**
   * This is the setter method to the attribute.
   * Peer autonomous system id.
   * Allowed values are 1-4294967295.
   * @param remoteAs set the remoteAs.
   */
  public void setRemoteAs(Integer  remoteAs) {
    this.remoteAs = remoteAs;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Shutdown the bgp peer.
   * Field introduced in 17.2.4.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return shutdown
   */
  public Boolean getShutdown() {
    return shutdown;
  }

  /**
   * This is the setter method to the attribute.
   * Shutdown the bgp peer.
   * Field introduced in 17.2.4.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param shutdown set the shutdown.
   */
  public void setShutdown(Boolean  shutdown) {
    this.shutdown = shutdown;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Subnet providing reachability for peer.
   * @return subnet
   */
  public IpAddrPrefix getSubnet() {
    return subnet;
  }

  /**
   * This is the setter method to the attribute.
   * Subnet providing reachability for peer.
   * @param subnet set the subnet.
   */
  public void setSubnet(IpAddrPrefix subnet) {
    this.subnet = subnet;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ipv6 subnet providing reachability for peer.
   * Field introduced in 18.1.1.
   * @return subnet6
   */
  public IpAddrPrefix getSubnet6() {
    return subnet6;
  }

  /**
   * This is the setter method to the attribute.
   * Ipv6 subnet providing reachability for peer.
   * Field introduced in 18.1.1.
   * @param subnet6 set the subnet6.
   */
  public void setSubnet6(IpAddrPrefix subnet6) {
    this.subnet6 = subnet6;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  BgpPeer objBgpPeer = (BgpPeer) o;
  return   Objects.equals(this.remoteAs, objBgpPeer.remoteAs)&&
  Objects.equals(this.peerIp, objBgpPeer.peerIp)&&
  Objects.equals(this.subnet, objBgpPeer.subnet)&&
  Objects.equals(this.md5Secret, objBgpPeer.md5Secret)&&
  Objects.equals(this.bfd, objBgpPeer.bfd)&&
  Objects.equals(this.networkRef, objBgpPeer.networkRef)&&
  Objects.equals(this.advertiseVip, objBgpPeer.advertiseVip)&&
  Objects.equals(this.advertiseSnatIp, objBgpPeer.advertiseSnatIp)&&
  Objects.equals(this.advertisementInterval, objBgpPeer.advertisementInterval)&&
  Objects.equals(this.connectTimer, objBgpPeer.connectTimer)&&
  Objects.equals(this.keepaliveInterval, objBgpPeer.keepaliveInterval)&&
  Objects.equals(this.holdTime, objBgpPeer.holdTime)&&
  Objects.equals(this.ebgpMultihop, objBgpPeer.ebgpMultihop)&&
  Objects.equals(this.localAs, objBgpPeer.localAs)&&
  Objects.equals(this.peerIp6, objBgpPeer.peerIp6)&&
  Objects.equals(this.subnet6, objBgpPeer.subnet6)&&
  Objects.equals(this.shutdown, objBgpPeer.shutdown)&&
  Objects.equals(this.label, objBgpPeer.label);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class BgpPeer {\n");
      sb.append("    advertiseSnatIp: ").append(toIndentedString(advertiseSnatIp)).append("\n");
        sb.append("    advertiseVip: ").append(toIndentedString(advertiseVip)).append("\n");
        sb.append("    advertisementInterval: ").append(toIndentedString(advertisementInterval)).append("\n");
        sb.append("    bfd: ").append(toIndentedString(bfd)).append("\n");
        sb.append("    connectTimer: ").append(toIndentedString(connectTimer)).append("\n");
        sb.append("    ebgpMultihop: ").append(toIndentedString(ebgpMultihop)).append("\n");
        sb.append("    holdTime: ").append(toIndentedString(holdTime)).append("\n");
        sb.append("    keepaliveInterval: ").append(toIndentedString(keepaliveInterval)).append("\n");
        sb.append("    label: ").append(toIndentedString(label)).append("\n");
        sb.append("    localAs: ").append(toIndentedString(localAs)).append("\n");
        sb.append("    md5Secret: ").append(toIndentedString(md5Secret)).append("\n");
        sb.append("    networkRef: ").append(toIndentedString(networkRef)).append("\n");
        sb.append("    peerIp: ").append(toIndentedString(peerIp)).append("\n");
        sb.append("    peerIp6: ").append(toIndentedString(peerIp6)).append("\n");
        sb.append("    remoteAs: ").append(toIndentedString(remoteAs)).append("\n");
        sb.append("    shutdown: ").append(toIndentedString(shutdown)).append("\n");
        sb.append("    subnet: ").append(toIndentedString(subnet)).append("\n");
        sb.append("    subnet6: ").append(toIndentedString(subnet6)).append("\n");
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

