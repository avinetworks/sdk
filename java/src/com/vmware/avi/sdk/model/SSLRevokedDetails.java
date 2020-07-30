package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SSLRevokedDetails is a POJO class extends AviRestResource that used for creating
 * SSLRevokedDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SSLRevokedDetails  {
    @JsonProperty("name")
    private String name = null;

    @JsonProperty("reason")
    private String reason = null;



  /**
   * This is the getter method this will return the attribute value.
   * Name of ssl certificate.
   * Field introduced in 20.1.1.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of ssl certificate.
   * Field introduced in 20.1.1.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Certificate revocation reason provided by ocsp responder.
   * Field introduced in 20.1.1.
   * @return reason
   */
  public String getReason() {
    return reason;
  }

  /**
   * This is the setter method to the attribute.
   * Certificate revocation reason provided by ocsp responder.
   * Field introduced in 20.1.1.
   * @param reason set the reason.
   */
  public void setReason(String  reason) {
    this.reason = reason;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SSLRevokedDetails objSSLRevokedDetails = (SSLRevokedDetails) o;
  return   Objects.equals(this.name, objSSLRevokedDetails.name)&&
  Objects.equals(this.reason, objSSLRevokedDetails.reason);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SSLRevokedDetails {\n");
      sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
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

