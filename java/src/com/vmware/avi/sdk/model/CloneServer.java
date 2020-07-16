package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The CloneServer is a POJO class extends AviRestResource that used for creating
 * CloneServer.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CloneServer  {
    @JsonProperty("ip_address")
    private IpAddr ipAddress = null;

    @JsonProperty("mac")
    private String mac = null;

    @JsonProperty("network_ref")
    private String networkRef = null;

    @JsonProperty("subnet")
    private IpAddrPrefix subnet = null;



  /**
   * This is the getter method this will return the attribute value.
   * Ip address of the clone server.
   * Field introduced in 17.1.1.
   * @return ipAddress
   */
  public IpAddr getIpAddress() {
    return ipAddress;
  }

  /**
   * This is the setter method to the attribute.
   * Ip address of the clone server.
   * Field introduced in 17.1.1.
   * @param ipAddress set the ipAddress.
   */
  public void setIpAddress(IpAddr ipAddress) {
    this.ipAddress = ipAddress;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Mac address of the clone server.
   * Field introduced in 17.1.1.
   * @return mac
   */
  public String getMac() {
    return mac;
  }

  /**
   * This is the setter method to the attribute.
   * Mac address of the clone server.
   * Field introduced in 17.1.1.
   * @param mac set the mac.
   */
  public void setMac(String  mac) {
    this.mac = mac;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Network to clone the traffic to.
   * It is a reference to an object of type network.
   * Field introduced in 17.1.1.
   * @return networkRef
   */
  public String getNetworkRef() {
    return networkRef;
  }

  /**
   * This is the setter method to the attribute.
   * Network to clone the traffic to.
   * It is a reference to an object of type network.
   * Field introduced in 17.1.1.
   * @param networkRef set the networkRef.
   */
  public void setNetworkRef(String  networkRef) {
    this.networkRef = networkRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Subnet of the network to clone the traffic to.
   * Field introduced in 17.1.1.
   * @return subnet
   */
  public IpAddrPrefix getSubnet() {
    return subnet;
  }

  /**
   * This is the setter method to the attribute.
   * Subnet of the network to clone the traffic to.
   * Field introduced in 17.1.1.
   * @param subnet set the subnet.
   */
  public void setSubnet(IpAddrPrefix subnet) {
    this.subnet = subnet;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  CloneServer objCloneServer = (CloneServer) o;
  return   Objects.equals(this.subnet, objCloneServer.subnet)&&
  Objects.equals(this.mac, objCloneServer.mac)&&
  Objects.equals(this.ipAddress, objCloneServer.ipAddress)&&
  Objects.equals(this.networkRef, objCloneServer.networkRef);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class CloneServer {\n");
      sb.append("    ipAddress: ").append(toIndentedString(ipAddress)).append("\n");
        sb.append("    mac: ").append(toIndentedString(mac)).append("\n");
        sb.append("    networkRef: ").append(toIndentedString(networkRef)).append("\n");
        sb.append("    subnet: ").append(toIndentedString(subnet)).append("\n");
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

