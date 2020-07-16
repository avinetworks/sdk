package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SSLProfileSelector is a POJO class extends AviRestResource that used for creating
 * SSLProfileSelector.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SSLProfileSelector  {
    @JsonProperty("client_ip_list")
    private IpAddrMatch clientIpList = null;

    @JsonProperty("ssl_profile_ref")
    private String sslProfileRef = null;



  /**
   * This is the getter method this will return the attribute value.
   * Configure client ip address groups.
   * Field introduced in 18.2.3.
   * @return clientIpList
   */
  public IpAddrMatch getClientIpList() {
    return clientIpList;
  }

  /**
   * This is the setter method to the attribute.
   * Configure client ip address groups.
   * Field introduced in 18.2.3.
   * @param clientIpList set the clientIpList.
   */
  public void setClientIpList(IpAddrMatch clientIpList) {
    this.clientIpList = clientIpList;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ssl profile for the client ip addresses listed.
   * It is a reference to an object of type sslprofile.
   * Field introduced in 18.2.3.
   * @return sslProfileRef
   */
  public String getSslProfileRef() {
    return sslProfileRef;
  }

  /**
   * This is the setter method to the attribute.
   * Ssl profile for the client ip addresses listed.
   * It is a reference to an object of type sslprofile.
   * Field introduced in 18.2.3.
   * @param sslProfileRef set the sslProfileRef.
   */
  public void setSslProfileRef(String  sslProfileRef) {
    this.sslProfileRef = sslProfileRef;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SSLProfileSelector objSSLProfileSelector = (SSLProfileSelector) o;
  return   Objects.equals(this.sslProfileRef, objSSLProfileSelector.sslProfileRef)&&
  Objects.equals(this.clientIpList, objSSLProfileSelector.clientIpList);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SSLProfileSelector {\n");
      sb.append("    clientIpList: ").append(toIndentedString(clientIpList)).append("\n");
        sb.append("    sslProfileRef: ").append(toIndentedString(sslProfileRef)).append("\n");
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

