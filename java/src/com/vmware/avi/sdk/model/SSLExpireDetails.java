package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SSLExpireDetails is a POJO class extends AviRestResource that used for creating
 * SSLExpireDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SSLExpireDetails  {
    @JsonProperty("days_left")
    private Integer daysLeft = null;

    @JsonProperty("name")
    private String name = null;



  /**
   * This is the getter method this will return the attribute value.
   * Number of days until certificate is expired.
   * @return daysLeft
   */
  public Integer getDaysLeft() {
    return daysLeft;
  }

  /**
   * This is the setter method to the attribute.
   * Number of days until certificate is expired.
   * @param daysLeft set the daysLeft.
   */
  public void setDaysLeft(Integer  daysLeft) {
    this.daysLeft = daysLeft;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of ssl certificate.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of ssl certificate.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SSLExpireDetails objSSLExpireDetails = (SSLExpireDetails) o;
  return   Objects.equals(this.name, objSSLExpireDetails.name)&&
  Objects.equals(this.daysLeft, objSSLExpireDetails.daysLeft);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SSLExpireDetails {\n");
      sb.append("    daysLeft: ").append(toIndentedString(daysLeft)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

