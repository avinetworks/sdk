package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SSLExportDetails is a POJO class extends AviRestResource that used for creating
 * SSLExportDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SSLExportDetails  {
    @JsonProperty("user")
    private String user = null;



  /**
   * This is the getter method this will return the attribute value.
   * Request user.
   * @return user
   */
  public String getUser() {
    return user;
  }

  /**
   * This is the setter method to the attribute.
   * Request user.
   * @param user set the user.
   */
  public void setUser(String  user) {
    this.user = user;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SSLExportDetails objSSLExportDetails = (SSLExportDetails) o;
  return   Objects.equals(this.user, objSSLExportDetails.user);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SSLExportDetails {\n");
      sb.append("    user: ").append(toIndentedString(user)).append("\n");
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

