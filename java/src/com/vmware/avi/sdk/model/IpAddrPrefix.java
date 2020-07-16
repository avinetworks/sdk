package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The IpAddrPrefix is a POJO class extends AviRestResource that used for creating
 * IpAddrPrefix.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IpAddrPrefix  {
    @JsonProperty("ip_addr")
    private IpAddr ipAddr = null;

    @JsonProperty("mask")
    private Integer mask = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ip_addr of obj type ipaddrprefix field type str  type ref.
   * @return ipAddr
   */
  public IpAddr getIpAddr() {
    return ipAddr;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ip_addr of obj type ipaddrprefix field type str  type ref.
   * @param ipAddr set the ipAddr.
   */
  public void setIpAddr(IpAddr ipAddr) {
    this.ipAddr = ipAddr;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property mask of obj type ipaddrprefix field type str  type integer.
   * @return mask
   */
  public Integer getMask() {
    return mask;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property mask of obj type ipaddrprefix field type str  type integer.
   * @param mask set the mask.
   */
  public void setMask(Integer  mask) {
    this.mask = mask;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  IpAddrPrefix objIpAddrPrefix = (IpAddrPrefix) o;
  return   Objects.equals(this.mask, objIpAddrPrefix.mask)&&
  Objects.equals(this.ipAddr, objIpAddrPrefix.ipAddr);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class IpAddrPrefix {\n");
      sb.append("    ipAddr: ").append(toIndentedString(ipAddr)).append("\n");
        sb.append("    mask: ").append(toIndentedString(mask)).append("\n");
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

