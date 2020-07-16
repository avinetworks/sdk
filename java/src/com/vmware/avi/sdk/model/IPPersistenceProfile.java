package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The IPPersistenceProfile is a POJO class extends AviRestResource that used for creating
 * IPPersistenceProfile.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IPPersistenceProfile  {
    @JsonProperty("ip_mask")
    private Integer ipMask = null;

    @JsonProperty("ip_persistent_timeout")
    private Integer ipPersistentTimeout = 5;



  /**
   * This is the getter method this will return the attribute value.
   * Mask to be applied on client ip.
   * This may be used to persist clients from a subnet to the same server.
   * When set to 0, all requests are sent to the same server.
   * Allowed values are 0-128.
   * Field introduced in 18.2.7.
   * @return ipMask
   */
  public Integer getIpMask() {
    return ipMask;
  }

  /**
   * This is the setter method to the attribute.
   * Mask to be applied on client ip.
   * This may be used to persist clients from a subnet to the same server.
   * When set to 0, all requests are sent to the same server.
   * Allowed values are 0-128.
   * Field introduced in 18.2.7.
   * @param ipMask set the ipMask.
   */
  public void setIpMask(Integer  ipMask) {
    this.ipMask = ipMask;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The length of time after a client's connections have closed before expiring the client's persistence to a server.
   * Allowed values are 1-720.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5.
   * @return ipPersistentTimeout
   */
  public Integer getIpPersistentTimeout() {
    return ipPersistentTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * The length of time after a client's connections have closed before expiring the client's persistence to a server.
   * Allowed values are 1-720.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5.
   * @param ipPersistentTimeout set the ipPersistentTimeout.
   */
  public void setIpPersistentTimeout(Integer  ipPersistentTimeout) {
    this.ipPersistentTimeout = ipPersistentTimeout;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  IPPersistenceProfile objIPPersistenceProfile = (IPPersistenceProfile) o;
  return   Objects.equals(this.ipMask, objIPPersistenceProfile.ipMask)&&
  Objects.equals(this.ipPersistentTimeout, objIPPersistenceProfile.ipPersistentTimeout);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class IPPersistenceProfile {\n");
      sb.append("    ipMask: ").append(toIndentedString(ipMask)).append("\n");
        sb.append("    ipPersistentTimeout: ").append(toIndentedString(ipPersistentTimeout)).append("\n");
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

