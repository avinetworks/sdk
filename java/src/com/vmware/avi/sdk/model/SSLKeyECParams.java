package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SSLKeyECParams is a POJO class extends AviRestResource that used for creating
 * SSLKeyECParams.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SSLKeyECParams  {
    @JsonProperty("curve")
    private String curve = "SSL_KEY_EC_CURVE_SECP256R1";



  /**
   * This is the getter method this will return the attribute value.
   * Enum options - SSL_KEY_EC_CURVE_SECP256R1, SSL_KEY_EC_CURVE_SECP384R1, SSL_KEY_EC_CURVE_SECP521R1.
   * Default value when not specified in API or module is interpreted by Avi Controller as SSL_KEY_EC_CURVE_SECP256R1.
   * @return curve
   */
  public String getCurve() {
    return curve;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - SSL_KEY_EC_CURVE_SECP256R1, SSL_KEY_EC_CURVE_SECP384R1, SSL_KEY_EC_CURVE_SECP521R1.
   * Default value when not specified in API or module is interpreted by Avi Controller as SSL_KEY_EC_CURVE_SECP256R1.
   * @param curve set the curve.
   */
  public void setCurve(String  curve) {
    this.curve = curve;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SSLKeyECParams objSSLKeyECParams = (SSLKeyECParams) o;
  return   Objects.equals(this.curve, objSSLKeyECParams.curve);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SSLKeyECParams {\n");
      sb.append("    curve: ").append(toIndentedString(curve)).append("\n");
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

