package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The AuthenticationMatch is a POJO class extends AviRestResource that used for creating
 * AuthenticationMatch.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthenticationMatch  {
    @JsonProperty("client_ip")
    private IpAddrMatch clientIp = null;

    @JsonProperty("host_hdr")
    private HostHdrMatch hostHdr = null;

    @JsonProperty("path")
    private PathMatch path = null;



  /**
   * This is the getter method this will return the attribute value.
   * Configure client ip addresses.
   * Field introduced in 18.2.5.
   * @return clientIp
   */
  public IpAddrMatch getClientIp() {
    return clientIp;
  }

  /**
   * This is the setter method to the attribute.
   * Configure client ip addresses.
   * Field introduced in 18.2.5.
   * @param clientIp set the clientIp.
   */
  public void setClientIp(IpAddrMatch clientIp) {
    this.clientIp = clientIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Configure the host header.
   * Field introduced in 18.2.5.
   * @return hostHdr
   */
  public HostHdrMatch getHostHdr() {
    return hostHdr;
  }

  /**
   * This is the setter method to the attribute.
   * Configure the host header.
   * Field introduced in 18.2.5.
   * @param hostHdr set the hostHdr.
   */
  public void setHostHdr(HostHdrMatch hostHdr) {
    this.hostHdr = hostHdr;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Configure request paths.
   * Field introduced in 18.2.5.
   * @return path
   */
  public PathMatch getPath() {
    return path;
  }

  /**
   * This is the setter method to the attribute.
   * Configure request paths.
   * Field introduced in 18.2.5.
   * @param path set the path.
   */
  public void setPath(PathMatch path) {
    this.path = path;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  AuthenticationMatch objAuthenticationMatch = (AuthenticationMatch) o;
  return   Objects.equals(this.clientIp, objAuthenticationMatch.clientIp)&&
  Objects.equals(this.path, objAuthenticationMatch.path)&&
  Objects.equals(this.hostHdr, objAuthenticationMatch.hostHdr);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class AuthenticationMatch {\n");
      sb.append("    clientIp: ").append(toIndentedString(clientIp)).append("\n");
        sb.append("    hostHdr: ").append(toIndentedString(hostHdr)).append("\n");
        sb.append("    path: ").append(toIndentedString(path)).append("\n");
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

