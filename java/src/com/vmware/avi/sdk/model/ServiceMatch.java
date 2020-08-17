package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ServiceMatch is a POJO class extends AviRestResource that used for creating
 * ServiceMatch.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceMatch  {
    @JsonProperty("destination_port")
    private PortMatch destinationPort = null;

    @JsonProperty("protocol")
    private L4RuleProtocolMatch protocol = null;

    @JsonProperty("source_port")
    private PortMatch sourcePort = null;



  /**
   * This is the getter method this will return the attribute value.
   * Destination port of the packet.
   * Field introduced in 18.2.5.
   * @return destinationPort
   */
  public PortMatch getDestinationPort() {
    return destinationPort;
  }

  /**
   * This is the setter method to the attribute.
   * Destination port of the packet.
   * Field introduced in 18.2.5.
   * @param destinationPort set the destinationPort.
   */
  public void setDestinationPort(PortMatch destinationPort) {
    this.destinationPort = destinationPort;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Protocol to match.
   * Field introduced in 20.1.1.
   * @return protocol
   */
  public L4RuleProtocolMatch getProtocol() {
    return protocol;
  }

  /**
   * This is the setter method to the attribute.
   * Protocol to match.
   * Field introduced in 20.1.1.
   * @param protocol set the protocol.
   */
  public void setProtocol(L4RuleProtocolMatch protocol) {
    this.protocol = protocol;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Source port of the packet.
   * Field introduced in 18.2.5.
   * @return sourcePort
   */
  public PortMatch getSourcePort() {
    return sourcePort;
  }

  /**
   * This is the setter method to the attribute.
   * Source port of the packet.
   * Field introduced in 18.2.5.
   * @param sourcePort set the sourcePort.
   */
  public void setSourcePort(PortMatch sourcePort) {
    this.sourcePort = sourcePort;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ServiceMatch objServiceMatch = (ServiceMatch) o;
  return   Objects.equals(this.sourcePort, objServiceMatch.sourcePort)&&
  Objects.equals(this.destinationPort, objServiceMatch.destinationPort)&&
  Objects.equals(this.protocol, objServiceMatch.protocol);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ServiceMatch {\n");
      sb.append("    destinationPort: ").append(toIndentedString(destinationPort)).append("\n");
        sb.append("    protocol: ").append(toIndentedString(protocol)).append("\n");
        sb.append("    sourcePort: ").append(toIndentedString(sourcePort)).append("\n");
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

