package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The L4RuleMatchTarget is a POJO class extends AviRestResource that used for creating
 * L4RuleMatchTarget.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class L4RuleMatchTarget  {
    @JsonProperty("client_ip")
    private IpAddrMatch clientIp = null;

    @JsonProperty("port")
    private L4RulePortMatch port = null;

    @JsonProperty("protocol")
    private L4RuleProtocolMatch protocol = null;



  /**
   * This is the getter method this will return the attribute value.
   * Ip addresses to match against client ip.
   * Field introduced in 17.2.7.
   * @return clientIp
   */
  public IpAddrMatch getClientIp() {
    return clientIp;
  }

  /**
   * This is the setter method to the attribute.
   * Ip addresses to match against client ip.
   * Field introduced in 17.2.7.
   * @param clientIp set the clientIp.
   */
  public void setClientIp(IpAddrMatch clientIp) {
    this.clientIp = clientIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Port number to match against virtual service listner port.
   * Field introduced in 17.2.7.
   * @return port
   */
  public L4RulePortMatch getPort() {
    return port;
  }

  /**
   * This is the setter method to the attribute.
   * Port number to match against virtual service listner port.
   * Field introduced in 17.2.7.
   * @param port set the port.
   */
  public void setPort(L4RulePortMatch port) {
    this.port = port;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Tcp/udp/icmp protocol to match against transport protocol.
   * Field introduced in 17.2.7.
   * @return protocol
   */
  public L4RuleProtocolMatch getProtocol() {
    return protocol;
  }

  /**
   * This is the setter method to the attribute.
   * Tcp/udp/icmp protocol to match against transport protocol.
   * Field introduced in 17.2.7.
   * @param protocol set the protocol.
   */
  public void setProtocol(L4RuleProtocolMatch protocol) {
    this.protocol = protocol;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  L4RuleMatchTarget objL4RuleMatchTarget = (L4RuleMatchTarget) o;
  return   Objects.equals(this.clientIp, objL4RuleMatchTarget.clientIp)&&
  Objects.equals(this.port, objL4RuleMatchTarget.port)&&
  Objects.equals(this.protocol, objL4RuleMatchTarget.protocol);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class L4RuleMatchTarget {\n");
      sb.append("    clientIp: ").append(toIndentedString(clientIp)).append("\n");
        sb.append("    port: ").append(toIndentedString(port)).append("\n");
        sb.append("    protocol: ").append(toIndentedString(protocol)).append("\n");
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

