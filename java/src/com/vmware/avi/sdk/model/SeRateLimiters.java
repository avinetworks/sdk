package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SeRateLimiters is a POJO class extends AviRestResource that used for creating
 * SeRateLimiters.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeRateLimiters  {
    @JsonProperty("arp_rl")
    private Integer arpRl = 100;

    @JsonProperty("default_rl")
    private Integer defaultRl = 100;

    @JsonProperty("flow_probe_rl")
    private Integer flowProbeRl = 250;

    @JsonProperty("icmp_rl")
    private Integer icmpRl = 100;

    @JsonProperty("icmp_rsp_rl")
    private Integer icmpRspRl = 500;

    @JsonProperty("rst_rl")
    private Integer rstRl = 100;



  /**
   * This is the getter method this will return the attribute value.
   * Rate limiter for arp packets in pps.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100.
   * @return arpRl
   */
  public Integer getArpRl() {
    return arpRl;
  }

  /**
   * This is the setter method to the attribute.
   * Rate limiter for arp packets in pps.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100.
   * @param arpRl set the arpRl.
   */
  public void setArpRl(Integer  arpRl) {
    this.arpRl = arpRl;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Default rate limiter in pps.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100.
   * @return defaultRl
   */
  public Integer getDefaultRl() {
    return defaultRl;
  }

  /**
   * This is the setter method to the attribute.
   * Default rate limiter in pps.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100.
   * @param defaultRl set the defaultRl.
   */
  public void setDefaultRl(Integer  defaultRl) {
    this.defaultRl = defaultRl;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Rate limiter for number of flow probes in pps.
   * Default value when not specified in API or module is interpreted by Avi Controller as 250.
   * @return flowProbeRl
   */
  public Integer getFlowProbeRl() {
    return flowProbeRl;
  }

  /**
   * This is the setter method to the attribute.
   * Rate limiter for number of flow probes in pps.
   * Default value when not specified in API or module is interpreted by Avi Controller as 250.
   * @param flowProbeRl set the flowProbeRl.
   */
  public void setFlowProbeRl(Integer  flowProbeRl) {
    this.flowProbeRl = flowProbeRl;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Rate limiter for icmp requests in pps.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100.
   * @return icmpRl
   */
  public Integer getIcmpRl() {
    return icmpRl;
  }

  /**
   * This is the setter method to the attribute.
   * Rate limiter for icmp requests in pps.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100.
   * @param icmpRl set the icmpRl.
   */
  public void setIcmpRl(Integer  icmpRl) {
    this.icmpRl = icmpRl;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Rate limiter for icmp response in pps.
   * Default value when not specified in API or module is interpreted by Avi Controller as 500.
   * @return icmpRspRl
   */
  public Integer getIcmpRspRl() {
    return icmpRspRl;
  }

  /**
   * This is the setter method to the attribute.
   * Rate limiter for icmp response in pps.
   * Default value when not specified in API or module is interpreted by Avi Controller as 500.
   * @param icmpRspRl set the icmpRspRl.
   */
  public void setIcmpRspRl(Integer  icmpRspRl) {
    this.icmpRspRl = icmpRspRl;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Rate limiter for number rst pkts sent in pps.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100.
   * @return rstRl
   */
  public Integer getRstRl() {
    return rstRl;
  }

  /**
   * This is the setter method to the attribute.
   * Rate limiter for number rst pkts sent in pps.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100.
   * @param rstRl set the rstRl.
   */
  public void setRstRl(Integer  rstRl) {
    this.rstRl = rstRl;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SeRateLimiters objSeRateLimiters = (SeRateLimiters) o;
  return   Objects.equals(this.rstRl, objSeRateLimiters.rstRl)&&
  Objects.equals(this.flowProbeRl, objSeRateLimiters.flowProbeRl)&&
  Objects.equals(this.defaultRl, objSeRateLimiters.defaultRl)&&
  Objects.equals(this.icmpRl, objSeRateLimiters.icmpRl)&&
  Objects.equals(this.icmpRspRl, objSeRateLimiters.icmpRspRl)&&
  Objects.equals(this.arpRl, objSeRateLimiters.arpRl);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SeRateLimiters {\n");
      sb.append("    arpRl: ").append(toIndentedString(arpRl)).append("\n");
        sb.append("    defaultRl: ").append(toIndentedString(defaultRl)).append("\n");
        sb.append("    flowProbeRl: ").append(toIndentedString(flowProbeRl)).append("\n");
        sb.append("    icmpRl: ").append(toIndentedString(icmpRl)).append("\n");
        sb.append("    icmpRspRl: ").append(toIndentedString(icmpRspRl)).append("\n");
        sb.append("    rstRl: ").append(toIndentedString(rstRl)).append("\n");
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

