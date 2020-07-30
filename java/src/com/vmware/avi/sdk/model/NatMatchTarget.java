package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The NatMatchTarget is a POJO class extends AviRestResource that used for creating
 * NatMatchTarget.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NatMatchTarget  {
    @JsonProperty("destination_ip")
    private IpAddrMatch destinationIp = null;

    @JsonProperty("services")
    private ServiceMatch services = null;

    @JsonProperty("source_ip")
    private IpAddrMatch sourceIp = null;



  /**
   * This is the getter method this will return the attribute value.
   * Destination ip of the packet.
   * Field introduced in 18.2.3.
   * @return destinationIp
   */
  public IpAddrMatch getDestinationIp() {
    return destinationIp;
  }

  /**
   * This is the setter method to the attribute.
   * Destination ip of the packet.
   * Field introduced in 18.2.3.
   * @param destinationIp set the destinationIp.
   */
  public void setDestinationIp(IpAddrMatch destinationIp) {
    this.destinationIp = destinationIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Services like port-matching and protocol.
   * Field introduced in 18.2.5.
   * @return services
   */
  public ServiceMatch getServices() {
    return services;
  }

  /**
   * This is the setter method to the attribute.
   * Services like port-matching and protocol.
   * Field introduced in 18.2.5.
   * @param services set the services.
   */
  public void setServices(ServiceMatch services) {
    this.services = services;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Source ip of the packet.
   * Field introduced in 18.2.3.
   * @return sourceIp
   */
  public IpAddrMatch getSourceIp() {
    return sourceIp;
  }

  /**
   * This is the setter method to the attribute.
   * Source ip of the packet.
   * Field introduced in 18.2.3.
   * @param sourceIp set the sourceIp.
   */
  public void setSourceIp(IpAddrMatch sourceIp) {
    this.sourceIp = sourceIp;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  NatMatchTarget objNatMatchTarget = (NatMatchTarget) o;
  return   Objects.equals(this.sourceIp, objNatMatchTarget.sourceIp)&&
  Objects.equals(this.destinationIp, objNatMatchTarget.destinationIp)&&
  Objects.equals(this.services, objNatMatchTarget.services);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class NatMatchTarget {\n");
      sb.append("    destinationIp: ").append(toIndentedString(destinationIp)).append("\n");
        sb.append("    services: ").append(toIndentedString(services)).append("\n");
        sb.append("    sourceIp: ").append(toIndentedString(sourceIp)).append("\n");
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

