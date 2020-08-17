package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The NetworkProfileUnion is a POJO class extends AviRestResource that used for creating
 * NetworkProfileUnion.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NetworkProfileUnion  {
    @JsonProperty("tcp_fast_path_profile")
    private TCPFastPathProfile tcpFastPathProfile = null;

    @JsonProperty("tcp_proxy_profile")
    private TCPProxyProfile tcpProxyProfile = null;

    @JsonProperty("type")
    private String type = "PROTOCOL_TYPE_TCP_PROXY";

    @JsonProperty("udp_fast_path_profile")
    private UDPFastPathProfile udpFastPathProfile = null;

    @JsonProperty("udp_proxy_profile")
    private UDPProxyProfile udpProxyProfile = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property tcp_fast_path_profile of obj type networkprofileunion field type str  type ref.
   * @return tcpFastPathProfile
   */
  public TCPFastPathProfile getTcpFastPathProfile() {
    return tcpFastPathProfile;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property tcp_fast_path_profile of obj type networkprofileunion field type str  type ref.
   * @param tcpFastPathProfile set the tcpFastPathProfile.
   */
  public void setTcpFastPathProfile(TCPFastPathProfile tcpFastPathProfile) {
    this.tcpFastPathProfile = tcpFastPathProfile;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property tcp_proxy_profile of obj type networkprofileunion field type str  type ref.
   * @return tcpProxyProfile
   */
  public TCPProxyProfile getTcpProxyProfile() {
    return tcpProxyProfile;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property tcp_proxy_profile of obj type networkprofileunion field type str  type ref.
   * @param tcpProxyProfile set the tcpProxyProfile.
   */
  public void setTcpProxyProfile(TCPProxyProfile tcpProxyProfile) {
    this.tcpProxyProfile = tcpProxyProfile;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Configure one of either proxy or fast path profiles.
   * Enum options - PROTOCOL_TYPE_TCP_PROXY, PROTOCOL_TYPE_TCP_FAST_PATH, PROTOCOL_TYPE_UDP_FAST_PATH, PROTOCOL_TYPE_UDP_PROXY.
   * Default value when not specified in API or module is interpreted by Avi Controller as PROTOCOL_TYPE_TCP_PROXY.
   * @return type
   */
  public String getType() {
    return type;
  }

  /**
   * This is the setter method to the attribute.
   * Configure one of either proxy or fast path profiles.
   * Enum options - PROTOCOL_TYPE_TCP_PROXY, PROTOCOL_TYPE_TCP_FAST_PATH, PROTOCOL_TYPE_UDP_FAST_PATH, PROTOCOL_TYPE_UDP_PROXY.
   * Default value when not specified in API or module is interpreted by Avi Controller as PROTOCOL_TYPE_TCP_PROXY.
   * @param type set the type.
   */
  public void setType(String  type) {
    this.type = type;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property udp_fast_path_profile of obj type networkprofileunion field type str  type ref.
   * @return udpFastPathProfile
   */
  public UDPFastPathProfile getUdpFastPathProfile() {
    return udpFastPathProfile;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property udp_fast_path_profile of obj type networkprofileunion field type str  type ref.
   * @param udpFastPathProfile set the udpFastPathProfile.
   */
  public void setUdpFastPathProfile(UDPFastPathProfile udpFastPathProfile) {
    this.udpFastPathProfile = udpFastPathProfile;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Configure udp proxy network profile.
   * Field introduced in 17.2.8, 18.1.3, 18.2.1.
   * @return udpProxyProfile
   */
  public UDPProxyProfile getUdpProxyProfile() {
    return udpProxyProfile;
  }

  /**
   * This is the setter method to the attribute.
   * Configure udp proxy network profile.
   * Field introduced in 17.2.8, 18.1.3, 18.2.1.
   * @param udpProxyProfile set the udpProxyProfile.
   */
  public void setUdpProxyProfile(UDPProxyProfile udpProxyProfile) {
    this.udpProxyProfile = udpProxyProfile;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  NetworkProfileUnion objNetworkProfileUnion = (NetworkProfileUnion) o;
  return   Objects.equals(this.type, objNetworkProfileUnion.type)&&
  Objects.equals(this.tcpProxyProfile, objNetworkProfileUnion.tcpProxyProfile)&&
  Objects.equals(this.tcpFastPathProfile, objNetworkProfileUnion.tcpFastPathProfile)&&
  Objects.equals(this.udpFastPathProfile, objNetworkProfileUnion.udpFastPathProfile)&&
  Objects.equals(this.udpProxyProfile, objNetworkProfileUnion.udpProxyProfile);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class NetworkProfileUnion {\n");
      sb.append("    tcpFastPathProfile: ").append(toIndentedString(tcpFastPathProfile)).append("\n");
        sb.append("    tcpProxyProfile: ").append(toIndentedString(tcpProxyProfile)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    udpFastPathProfile: ").append(toIndentedString(udpFastPathProfile)).append("\n");
        sb.append("    udpProxyProfile: ").append(toIndentedString(udpProxyProfile)).append("\n");
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

