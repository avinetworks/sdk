package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DiscoveredNetwork is a POJO class extends AviRestResource that used for creating
 * DiscoveredNetwork.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DiscoveredNetwork  {
    @JsonProperty("network_ref")
    private String networkRef = null;

    @JsonProperty("subnet")
    private List<IpAddrPrefix> subnet = null;

    @JsonProperty("subnet6")
    private List<IpAddrPrefix> subnet6 = null;



  /**
   * This is the getter method this will return the attribute value.
   * Discovered network for this ip.
   * It is a reference to an object of type network.
   * @return networkRef
   */
  public String getNetworkRef() {
    return networkRef;
  }

  /**
   * This is the setter method to the attribute.
   * Discovered network for this ip.
   * It is a reference to an object of type network.
   * @param networkRef set the networkRef.
   */
  public void setNetworkRef(String  networkRef) {
    this.networkRef = networkRef;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Discovered subnet for this ip.
   * @return subnet
   */
  public List<IpAddrPrefix> getSubnet() {
    return subnet;
  }

  /**
   * This is the setter method. this will set the subnet
   * Discovered subnet for this ip.
   * @return subnet
   */
  public void setSubnet(List<IpAddrPrefix>  subnet) {
    this.subnet = subnet;
  }

  /**
   * This is the setter method this will set the subnet
   * Discovered subnet for this ip.
   * @return subnet
   */
  public DiscoveredNetwork addSubnetItem(IpAddrPrefix subnetItem) {
    if (this.subnet == null) {
      this.subnet = new ArrayList<IpAddrPrefix>();
    }
    this.subnet.add(subnetItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Discovered ipv6 subnet for this ip.
   * Field introduced in 18.1.1.
   * @return subnet6
   */
  public List<IpAddrPrefix> getSubnet6() {
    return subnet6;
  }

  /**
   * This is the setter method. this will set the subnet6
   * Discovered ipv6 subnet for this ip.
   * Field introduced in 18.1.1.
   * @return subnet6
   */
  public void setSubnet6(List<IpAddrPrefix>  subnet6) {
    this.subnet6 = subnet6;
  }

  /**
   * This is the setter method this will set the subnet6
   * Discovered ipv6 subnet for this ip.
   * Field introduced in 18.1.1.
   * @return subnet6
   */
  public DiscoveredNetwork addSubnet6Item(IpAddrPrefix subnet6Item) {
    if (this.subnet6 == null) {
      this.subnet6 = new ArrayList<IpAddrPrefix>();
    }
    this.subnet6.add(subnet6Item);
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
  DiscoveredNetwork objDiscoveredNetwork = (DiscoveredNetwork) o;
  return   Objects.equals(this.subnet, objDiscoveredNetwork.subnet)&&
  Objects.equals(this.subnet6, objDiscoveredNetwork.subnet6)&&
  Objects.equals(this.networkRef, objDiscoveredNetwork.networkRef);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DiscoveredNetwork {\n");
      sb.append("    networkRef: ").append(toIndentedString(networkRef)).append("\n");
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

