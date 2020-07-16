package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Subnet is a POJO class extends AviRestResource that used for creating
 * Subnet.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Subnet  {
    @JsonProperty("prefix")
    private IpAddrPrefix prefix = null;

    @JsonProperty("static_ips")
    private List<IpAddr> staticIps = null;

    @JsonProperty("static_ranges")
    private List<IpAddrRange> staticRanges = null;



  /**
   * This is the getter method this will return the attribute value.
   * Specify an ip subnet prefix for this network.
   * @return prefix
   */
  public IpAddrPrefix getPrefix() {
    return prefix;
  }

  /**
   * This is the setter method to the attribute.
   * Specify an ip subnet prefix for this network.
   * @param prefix set the prefix.
   */
  public void setPrefix(IpAddrPrefix prefix) {
    this.prefix = prefix;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Specify a pool of ip addresses for use in service engines.
   * @return staticIps
   */
  public List<IpAddr> getStaticIps() {
    return staticIps;
  }

  /**
   * This is the setter method. this will set the staticIps
   * Specify a pool of ip addresses for use in service engines.
   * @return staticIps
   */
  public void setStaticIps(List<IpAddr>  staticIps) {
    this.staticIps = staticIps;
  }

  /**
   * This is the setter method this will set the staticIps
   * Specify a pool of ip addresses for use in service engines.
   * @return staticIps
   */
  public Subnet addStaticIpsItem(IpAddr staticIpsItem) {
    if (this.staticIps == null) {
      this.staticIps = new ArrayList<IpAddr>();
    }
    this.staticIps.add(staticIpsItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property static_ranges of obj type subnet field type str  type array.
   * @return staticRanges
   */
  public List<IpAddrRange> getStaticRanges() {
    return staticRanges;
  }

  /**
   * This is the setter method. this will set the staticRanges
   * Placeholder for description of property static_ranges of obj type subnet field type str  type array.
   * @return staticRanges
   */
  public void setStaticRanges(List<IpAddrRange>  staticRanges) {
    this.staticRanges = staticRanges;
  }

  /**
   * This is the setter method this will set the staticRanges
   * Placeholder for description of property static_ranges of obj type subnet field type str  type array.
   * @return staticRanges
   */
  public Subnet addStaticRangesItem(IpAddrRange staticRangesItem) {
    if (this.staticRanges == null) {
      this.staticRanges = new ArrayList<IpAddrRange>();
    }
    this.staticRanges.add(staticRangesItem);
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
  Subnet objSubnet = (Subnet) o;
  return   Objects.equals(this.prefix, objSubnet.prefix)&&
  Objects.equals(this.staticIps, objSubnet.staticIps)&&
  Objects.equals(this.staticRanges, objSubnet.staticRanges);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class Subnet {\n");
      sb.append("    prefix: ").append(toIndentedString(prefix)).append("\n");
        sb.append("    staticIps: ").append(toIndentedString(staticIps)).append("\n");
        sb.append("    staticRanges: ").append(toIndentedString(staticRanges)).append("\n");
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

