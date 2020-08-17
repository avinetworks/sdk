package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ArpTableFilter is a POJO class extends AviRestResource that used for creating
 * ArpTableFilter.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArpTableFilter  {
    @JsonProperty("ip_address")
    private IpAddr ipAddress = null;



  /**
   * This is the getter method this will return the attribute value.
   * Ip address.
   * @return ipAddress
   */
  public IpAddr getIpAddress() {
    return ipAddress;
  }

  /**
   * This is the setter method to the attribute.
   * Ip address.
   * @param ipAddress set the ipAddress.
   */
  public void setIpAddress(IpAddr ipAddress) {
    this.ipAddress = ipAddress;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ArpTableFilter objArpTableFilter = (ArpTableFilter) o;
  return   Objects.equals(this.ipAddress, objArpTableFilter.ipAddress);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ArpTableFilter {\n");
      sb.append("    ipAddress: ").append(toIndentedString(ipAddress)).append("\n");
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

