package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The L4RulePortMatch is a POJO class extends AviRestResource that used for creating
 * L4RulePortMatch.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class L4RulePortMatch  {
    @JsonProperty("match_criteria")
    private String matchCriteria = null;

    @JsonProperty("port_ranges")
    private List<PortRange> portRanges = null;

    @JsonProperty("ports")
    private List<Integer> ports = null;



  /**
   * This is the getter method this will return the attribute value.
   * Criterion to use for virtual service port matching.
   * Enum options - IS_IN, IS_NOT_IN.
   * Field introduced in 17.2.7.
   * @return matchCriteria
   */
  public String getMatchCriteria() {
    return matchCriteria;
  }

  /**
   * This is the setter method to the attribute.
   * Criterion to use for virtual service port matching.
   * Enum options - IS_IN, IS_NOT_IN.
   * Field introduced in 17.2.7.
   * @param matchCriteria set the matchCriteria.
   */
  public void setMatchCriteria(String  matchCriteria) {
    this.matchCriteria = matchCriteria;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Range of tcp/udp port numbers of the virtual service.
   * Field introduced in 17.2.7.
   * @return portRanges
   */
  public List<PortRange> getPortRanges() {
    return portRanges;
  }

  /**
   * This is the setter method. this will set the portRanges
   * Range of tcp/udp port numbers of the virtual service.
   * Field introduced in 17.2.7.
   * @return portRanges
   */
  public void setPortRanges(List<PortRange>  portRanges) {
    this.portRanges = portRanges;
  }

  /**
   * This is the setter method this will set the portRanges
   * Range of tcp/udp port numbers of the virtual service.
   * Field introduced in 17.2.7.
   * @return portRanges
   */
  public L4RulePortMatch addPortRangesItem(PortRange portRangesItem) {
    if (this.portRanges == null) {
      this.portRanges = new ArrayList<PortRange>();
    }
    this.portRanges.add(portRangesItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Virtual service's listening port(s).
   * Allowed values are 1-65535.
   * Field introduced in 17.2.7.
   * @return ports
   */
  public List<Integer> getPorts() {
    return ports;
  }

  /**
   * This is the setter method. this will set the ports
   * Virtual service's listening port(s).
   * Allowed values are 1-65535.
   * Field introduced in 17.2.7.
   * @return ports
   */
  public void setPorts(List<Integer>  ports) {
    this.ports = ports;
  }

  /**
   * This is the setter method this will set the ports
   * Virtual service's listening port(s).
   * Allowed values are 1-65535.
   * Field introduced in 17.2.7.
   * @return ports
   */
  public L4RulePortMatch addPortsItem(Integer portsItem) {
    if (this.ports == null) {
      this.ports = new ArrayList<Integer>();
    }
    this.ports.add(portsItem);
    return this;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  L4RulePortMatch objL4RulePortMatch = (L4RulePortMatch) o;
  return   Objects.equals(this.matchCriteria, objL4RulePortMatch.matchCriteria)&&
  Objects.equals(this.ports, objL4RulePortMatch.ports)&&
  Objects.equals(this.portRanges, objL4RulePortMatch.portRanges);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class L4RulePortMatch {\n");
      sb.append("    matchCriteria: ").append(toIndentedString(matchCriteria)).append("\n");
        sb.append("    portRanges: ").append(toIndentedString(portRanges)).append("\n");
        sb.append("    ports: ").append(toIndentedString(ports)).append("\n");
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

