package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The NatAddrInfo is a POJO class extends AviRestResource that used for creating
 * NatAddrInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NatAddrInfo  {
    @JsonProperty("nat_ip")
    private IpAddr natIp = null;

    @JsonProperty("nat_ip_range")
    private IpAddrRange natIpRange = null;



  /**
   * This is the getter method this will return the attribute value.
   * Nat ip address.
   * Field introduced in 18.2.3.
   * @return natIp
   */
  public IpAddr getNatIp() {
    return natIp;
  }

  /**
   * This is the setter method to the attribute.
   * Nat ip address.
   * Field introduced in 18.2.3.
   * @param natIp set the natIp.
   */
  public void setNatIp(IpAddr natIp) {
    this.natIp = natIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Nat ip address range.
   * Field introduced in 18.2.3.
   * @return natIpRange
   */
  public IpAddrRange getNatIpRange() {
    return natIpRange;
  }

  /**
   * This is the setter method to the attribute.
   * Nat ip address range.
   * Field introduced in 18.2.3.
   * @param natIpRange set the natIpRange.
   */
  public void setNatIpRange(IpAddrRange natIpRange) {
    this.natIpRange = natIpRange;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  NatAddrInfo objNatAddrInfo = (NatAddrInfo) o;
  return   Objects.equals(this.natIpRange, objNatAddrInfo.natIpRange)&&
  Objects.equals(this.natIp, objNatAddrInfo.natIp);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class NatAddrInfo {\n");
      sb.append("    natIp: ").append(toIndentedString(natIp)).append("\n");
        sb.append("    natIpRange: ").append(toIndentedString(natIpRange)).append("\n");
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

