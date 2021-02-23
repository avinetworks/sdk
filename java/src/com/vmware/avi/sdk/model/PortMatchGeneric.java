package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The PortMatchGeneric is a POJO class extends AviRestResource that used for creating
 * PortMatchGeneric.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PortMatchGeneric  {
    @JsonProperty("match_criteria")
    private String matchCriteria = null;

    @JsonProperty("ports")
    private List<Integer> ports = null;

    @JsonProperty("ranges")
    private List<PortRange> ranges = null;



    /**
     * This is the getter method this will return the attribute value.
     * Criterion to use for src/dest port in a tcp/udp packet.
     * Enum options - IS_IN, IS_NOT_IN.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return matchCriteria
     */
    public String getMatchCriteria() {
        return matchCriteria;
    }

    /**
     * This is the setter method to the attribute.
     * Criterion to use for src/dest port in a tcp/udp packet.
     * Enum options - IS_IN, IS_NOT_IN.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param matchCriteria set the matchCriteria.
     */
    public void setMatchCriteria(String  matchCriteria) {
        this.matchCriteria = matchCriteria;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Listening tcp port(s).
     * Allowed values are 1-65535.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return ports
     */
    public List<Integer> getPorts() {
        return ports;
    }

    /**
     * This is the setter method. this will set the ports
     * Listening tcp port(s).
     * Allowed values are 1-65535.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return ports
     */
    public void setPorts(List<Integer>  ports) {
        this.ports = ports;
    }

    /**
     * This is the setter method this will set the ports
     * Listening tcp port(s).
     * Allowed values are 1-65535.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return ports
     */
    public PortMatchGeneric addPortsItem(Integer portsItem) {
      if (this.ports == null) {
        this.ports = new ArrayList<Integer>();
      }
      this.ports.add(portsItem);
      return this;
    }
    /**
     * This is the getter method this will return the attribute value.
     * A port range defined by a start and end, including both.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return ranges
     */
    public List<PortRange> getRanges() {
        return ranges;
    }

    /**
     * This is the setter method. this will set the ranges
     * A port range defined by a start and end, including both.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return ranges
     */
    public void setRanges(List<PortRange>  ranges) {
        this.ranges = ranges;
    }

    /**
     * This is the setter method this will set the ranges
     * A port range defined by a start and end, including both.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return ranges
     */
    public PortMatchGeneric addRangesItem(PortRange rangesItem) {
      if (this.ranges == null) {
        this.ranges = new ArrayList<PortRange>();
      }
      this.ranges.add(rangesItem);
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
      PortMatchGeneric objPortMatchGeneric = (PortMatchGeneric) o;
      return   Objects.equals(this.matchCriteria, objPortMatchGeneric.matchCriteria)&&
  Objects.equals(this.ports, objPortMatchGeneric.ports)&&
  Objects.equals(this.ranges, objPortMatchGeneric.ranges);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PortMatchGeneric {\n");
                  sb.append("    matchCriteria: ").append(toIndentedString(matchCriteria)).append("\n");
                        sb.append("    ports: ").append(toIndentedString(ports)).append("\n");
                        sb.append("    ranges: ").append(toIndentedString(ranges)).append("\n");
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
