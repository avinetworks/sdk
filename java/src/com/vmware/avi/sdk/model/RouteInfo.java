package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The RouteInfo is a POJO class extends AviRestResource that used for creating
 * RouteInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RouteInfo  {
    @JsonProperty("if_name")
    private String ifName = null;

    @JsonProperty("network_namespace")
    private String networkNamespace = "HOST_NAMESPACE";

    @JsonProperty("nexthop")
    private IpAddr nexthop = null;

    @JsonProperty("subnet")
    private IpAddrPrefix subnet = null;



  /**
   * This is the getter method this will return the attribute value.
   * Host interface name.
   * Field introduced in 18.2.6.
   * @return ifName
   */
  public String getIfName() {
    return ifName;
  }

  /**
   * This is the setter method to the attribute.
   * Host interface name.
   * Field introduced in 18.2.6.
   * @param ifName set the ifName.
   */
  public void setIfName(String  ifName) {
    this.ifName = ifName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Network namespace type used to add an route entry in a specific namespace.
   * Enum options - LOCAL_NAMESPACE, HOST_NAMESPACE, OTHER_NAMESPACE.
   * Field introduced in 18.2.6.
   * Default value when not specified in API or module is interpreted by Avi Controller as HOST_NAMESPACE.
   * @return networkNamespace
   */
  public String getNetworkNamespace() {
    return networkNamespace;
  }

  /**
   * This is the setter method to the attribute.
   * Network namespace type used to add an route entry in a specific namespace.
   * Enum options - LOCAL_NAMESPACE, HOST_NAMESPACE, OTHER_NAMESPACE.
   * Field introduced in 18.2.6.
   * Default value when not specified in API or module is interpreted by Avi Controller as HOST_NAMESPACE.
   * @param networkNamespace set the networkNamespace.
   */
  public void setNetworkNamespace(String  networkNamespace) {
    this.networkNamespace = networkNamespace;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Host nexthop ip address.
   * Field introduced in 18.2.6.
   * @return nexthop
   */
  public IpAddr getNexthop() {
    return nexthop;
  }

  /**
   * This is the setter method to the attribute.
   * Host nexthop ip address.
   * Field introduced in 18.2.6.
   * @param nexthop set the nexthop.
   */
  public void setNexthop(IpAddr nexthop) {
    this.nexthop = nexthop;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Host subnet address.
   * Field introduced in 18.2.6.
   * @return subnet
   */
  public IpAddrPrefix getSubnet() {
    return subnet;
  }

  /**
   * This is the setter method to the attribute.
   * Host subnet address.
   * Field introduced in 18.2.6.
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
  RouteInfo objRouteInfo = (RouteInfo) o;
  return   Objects.equals(this.subnet, objRouteInfo.subnet)&&
  Objects.equals(this.nexthop, objRouteInfo.nexthop)&&
  Objects.equals(this.ifName, objRouteInfo.ifName)&&
  Objects.equals(this.networkNamespace, objRouteInfo.networkNamespace);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class RouteInfo {\n");
      sb.append("    ifName: ").append(toIndentedString(ifName)).append("\n");
        sb.append("    networkNamespace: ").append(toIndentedString(networkNamespace)).append("\n");
        sb.append("    nexthop: ").append(toIndentedString(nexthop)).append("\n");
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

