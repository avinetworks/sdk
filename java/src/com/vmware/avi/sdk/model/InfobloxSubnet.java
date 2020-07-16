package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The InfobloxSubnet is a POJO class extends AviRestResource that used for creating
 * InfobloxSubnet.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InfobloxSubnet  {
    @JsonProperty("subnet")
    private IpAddrPrefix subnet = null;

    @JsonProperty("subnet6")
    private IpAddrPrefix subnet6 = null;



  /**
   * This is the getter method this will return the attribute value.
   * Ipv4 subnet to use for infoblox allocation.
   * Field introduced in 18.2.8, 20.1.1.
   * @return subnet
   */
  public IpAddrPrefix getSubnet() {
    return subnet;
  }

  /**
   * This is the setter method to the attribute.
   * Ipv4 subnet to use for infoblox allocation.
   * Field introduced in 18.2.8, 20.1.1.
   * @param subnet set the subnet.
   */
  public void setSubnet(IpAddrPrefix subnet) {
    this.subnet = subnet;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ipv6 subnet to use for infoblox allocation.
   * Field introduced in 18.2.8, 20.1.1.
   * @return subnet6
   */
  public IpAddrPrefix getSubnet6() {
    return subnet6;
  }

  /**
   * This is the setter method to the attribute.
   * Ipv6 subnet to use for infoblox allocation.
   * Field introduced in 18.2.8, 20.1.1.
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
  InfobloxSubnet objInfobloxSubnet = (InfobloxSubnet) o;
  return   Objects.equals(this.subnet, objInfobloxSubnet.subnet)&&
  Objects.equals(this.subnet6, objInfobloxSubnet.subnet6);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class InfobloxSubnet {\n");
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

