package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SSLVersion is a POJO class extends AviRestResource that used for creating
 * SSLVersion.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SSLVersion  {
    @JsonProperty("type")
    private String type = "SSL_VERSION_TLS1_1";



  /**
   * This is the getter method this will return the attribute value.
   * Enum options - SSL_VERSION_SSLV3, SSL_VERSION_TLS1, SSL_VERSION_TLS1_1, SSL_VERSION_TLS1_2, SSL_VERSION_TLS1_3.
   * Default value when not specified in API or module is interpreted by Avi Controller as SSL_VERSION_TLS1_1.
   * @return type
   */
  public String getType() {
    return type;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - SSL_VERSION_SSLV3, SSL_VERSION_TLS1, SSL_VERSION_TLS1_1, SSL_VERSION_TLS1_2, SSL_VERSION_TLS1_3.
   * Default value when not specified in API or module is interpreted by Avi Controller as SSL_VERSION_TLS1_1.
   * @param type set the type.
   */
  public void setType(String  type) {
    this.type = type;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SSLVersion objSSLVersion = (SSLVersion) o;
  return   Objects.equals(this.type, objSSLVersion.type);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SSLVersion {\n");
      sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

