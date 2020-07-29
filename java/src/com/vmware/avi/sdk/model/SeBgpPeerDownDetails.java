package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SeBgpPeerDownDetails is a POJO class extends AviRestResource that used for creating
 * SeBgpPeerDownDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeBgpPeerDownDetails  {
    @JsonProperty("message")
    private String message = null;

    @JsonProperty("peer_ip")
    private String peerIp = null;

    @JsonProperty("vrf_name")
    private String vrfName = null;



  /**
   * This is the getter method this will return the attribute value.
   * Message specific to the down condition.
   * Field introduced in 20.1.1.
   * @return message
   */
  public String getMessage() {
    return message;
  }

  /**
   * This is the setter method to the attribute.
   * Message specific to the down condition.
   * Field introduced in 20.1.1.
   * @param message set the message.
   */
  public void setMessage(String  message) {
    this.message = message;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ip address of bgp peer.
   * Field introduced in 20.1.1.
   * @return peerIp
   */
  public String getPeerIp() {
    return peerIp;
  }

  /**
   * This is the setter method to the attribute.
   * Ip address of bgp peer.
   * Field introduced in 20.1.1.
   * @param peerIp set the peerIp.
   */
  public void setPeerIp(String  peerIp) {
    this.peerIp = peerIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of virtual routing context in which bgp is configured.
   * Field introduced in 20.1.1.
   * @return vrfName
   */
  public String getVrfName() {
    return vrfName;
  }

  /**
   * This is the setter method to the attribute.
   * Name of virtual routing context in which bgp is configured.
   * Field introduced in 20.1.1.
   * @param vrfName set the vrfName.
   */
  public void setVrfName(String  vrfName) {
    this.vrfName = vrfName;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SeBgpPeerDownDetails objSeBgpPeerDownDetails = (SeBgpPeerDownDetails) o;
  return   Objects.equals(this.peerIp, objSeBgpPeerDownDetails.peerIp)&&
  Objects.equals(this.vrfName, objSeBgpPeerDownDetails.vrfName)&&
  Objects.equals(this.message, objSeBgpPeerDownDetails.message);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SeBgpPeerDownDetails {\n");
      sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("    peerIp: ").append(toIndentedString(peerIp)).append("\n");
        sb.append("    vrfName: ").append(toIndentedString(vrfName)).append("\n");
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

