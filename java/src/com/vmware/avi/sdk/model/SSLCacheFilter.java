package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SSLCacheFilter is a POJO class extends AviRestResource that used for creating
 * SSLCacheFilter.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SSLCacheFilter  {
    @JsonProperty("ssl_session_id")
    private String sslSessionId = null;



  /**
   * This is the getter method this will return the attribute value.
   * Hexadecimal representation of the ssl session id.
   * Field introduced in 20.1.1.
   * @return sslSessionId
   */
  public String getSslSessionId() {
    return sslSessionId;
  }

  /**
   * This is the setter method to the attribute.
   * Hexadecimal representation of the ssl session id.
   * Field introduced in 20.1.1.
   * @param sslSessionId set the sslSessionId.
   */
  public void setSslSessionId(String  sslSessionId) {
    this.sslSessionId = sslSessionId;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SSLCacheFilter objSSLCacheFilter = (SSLCacheFilter) o;
  return   Objects.equals(this.sslSessionId, objSSLCacheFilter.sslSessionId);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SSLCacheFilter {\n");
      sb.append("    sslSessionId: ").append(toIndentedString(sslSessionId)).append("\n");
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

