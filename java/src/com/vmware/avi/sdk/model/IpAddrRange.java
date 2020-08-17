package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The IpAddrRange is a POJO class extends AviRestResource that used for creating
 * IpAddrRange.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IpAddrRange  {
    @JsonProperty("begin")
    private IpAddr begin = null;

    @JsonProperty("end")
    private IpAddr end = null;



  /**
   * This is the getter method this will return the attribute value.
   * Starting ip address of the range.
   * @return begin
   */
  public IpAddr getBegin() {
    return begin;
  }

  /**
   * This is the setter method to the attribute.
   * Starting ip address of the range.
   * @param begin set the begin.
   */
  public void setBegin(IpAddr begin) {
    this.begin = begin;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ending ip address of the range.
   * @return end
   */
  public IpAddr getEnd() {
    return end;
  }

  /**
   * This is the setter method to the attribute.
   * Ending ip address of the range.
   * @param end set the end.
   */
  public void setEnd(IpAddr end) {
    this.end = end;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  IpAddrRange objIpAddrRange = (IpAddrRange) o;
  return   Objects.equals(this.begin, objIpAddrRange.begin)&&
  Objects.equals(this.end, objIpAddrRange.end);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class IpAddrRange {\n");
      sb.append("    begin: ").append(toIndentedString(begin)).append("\n");
        sb.append("    end: ").append(toIndentedString(end)).append("\n");
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

