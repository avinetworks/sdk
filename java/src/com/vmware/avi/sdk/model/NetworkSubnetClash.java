package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The NetworkSubnetClash is a POJO class extends AviRestResource that used for creating
 * NetworkSubnetClash.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NetworkSubnetClash  {
    @JsonProperty("ip_nw")
    private String ipNw = null;

    @JsonProperty("networks")
    private List<String> networks = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ip_nw of obj type networksubnetclash field type str  type string.
   * @return ipNw
   */
  public String getIpNw() {
    return ipNw;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ip_nw of obj type networksubnetclash field type str  type string.
   * @param ipNw set the ipNw.
   */
  public void setIpNw(String  ipNw) {
    this.ipNw = ipNw;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property networks of obj type networksubnetclash field type str  type array.
   * @return networks
   */
  public List<String> getNetworks() {
    return networks;
  }

  /**
   * This is the setter method. this will set the networks
   * Placeholder for description of property networks of obj type networksubnetclash field type str  type array.
   * @return networks
   */
  public void setNetworks(List<String>  networks) {
    this.networks = networks;
  }

  /**
   * This is the setter method this will set the networks
   * Placeholder for description of property networks of obj type networksubnetclash field type str  type array.
   * @return networks
   */
  public NetworkSubnetClash addNetworksItem(String networksItem) {
    if (this.networks == null) {
      this.networks = new ArrayList<String>();
    }
    this.networks.add(networksItem);
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
  NetworkSubnetClash objNetworkSubnetClash = (NetworkSubnetClash) o;
  return   Objects.equals(this.ipNw, objNetworkSubnetClash.ipNw)&&
  Objects.equals(this.networks, objNetworkSubnetClash.networks);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class NetworkSubnetClash {\n");
      sb.append("    ipNw: ").append(toIndentedString(ipNw)).append("\n");
        sb.append("    networks: ").append(toIndentedString(networks)).append("\n");
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

