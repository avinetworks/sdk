package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The IptableRule is a POJO class extends AviRestResource that used for creating
 * IptableRule.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IptableRule  {
    @JsonProperty("action")
    private String action = null;

    @JsonProperty("dnat_ip")
    private IpAddr dnatIp = null;

    @JsonProperty("dst_ip")
    private IpAddrPrefix dstIp = null;

    @JsonProperty("dst_port")
    private PortRange dstPort = null;

    @JsonProperty("input_interface")
    private String inputInterface = null;

    @JsonProperty("output_interface")
    private String outputInterface = null;

    @JsonProperty("proto")
    private String proto = null;

    @JsonProperty("src_ip")
    private IpAddrPrefix srcIp = null;

    @JsonProperty("src_port")
    private PortRange srcPort = null;

    @JsonProperty("tag")
    private String tag = null;



  /**
   * This is the getter method this will return the attribute value.
   * Enum options - ACCEPT, DROP, REJECT, DNAT, MASQUERADE.
   * @return action
   */
  public String getAction() {
    return action;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - ACCEPT, DROP, REJECT, DNAT, MASQUERADE.
   * @param action set the action.
   */
  public void setAction(String  action) {
    this.action = action;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property dnat_ip of obj type iptablerule field type str  type ref.
   * @return dnatIp
   */
  public IpAddr getDnatIp() {
    return dnatIp;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property dnat_ip of obj type iptablerule field type str  type ref.
   * @param dnatIp set the dnatIp.
   */
  public void setDnatIp(IpAddr dnatIp) {
    this.dnatIp = dnatIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property dst_ip of obj type iptablerule field type str  type ref.
   * @return dstIp
   */
  public IpAddrPrefix getDstIp() {
    return dstIp;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property dst_ip of obj type iptablerule field type str  type ref.
   * @param dstIp set the dstIp.
   */
  public void setDstIp(IpAddrPrefix dstIp) {
    this.dstIp = dstIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property dst_port of obj type iptablerule field type str  type ref.
   * @return dstPort
   */
  public PortRange getDstPort() {
    return dstPort;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property dst_port of obj type iptablerule field type str  type ref.
   * @param dstPort set the dstPort.
   */
  public void setDstPort(PortRange dstPort) {
    this.dstPort = dstPort;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property input_interface of obj type iptablerule field type str  type string.
   * @return inputInterface
   */
  public String getInputInterface() {
    return inputInterface;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property input_interface of obj type iptablerule field type str  type string.
   * @param inputInterface set the inputInterface.
   */
  public void setInputInterface(String  inputInterface) {
    this.inputInterface = inputInterface;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property output_interface of obj type iptablerule field type str  type string.
   * @return outputInterface
   */
  public String getOutputInterface() {
    return outputInterface;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property output_interface of obj type iptablerule field type str  type string.
   * @param outputInterface set the outputInterface.
   */
  public void setOutputInterface(String  outputInterface) {
    this.outputInterface = outputInterface;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - PROTO_TCP, PROTO_UDP, PROTO_ICMP, PROTO_ALL.
   * @return proto
   */
  public String getProto() {
    return proto;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - PROTO_TCP, PROTO_UDP, PROTO_ICMP, PROTO_ALL.
   * @param proto set the proto.
   */
  public void setProto(String  proto) {
    this.proto = proto;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property src_ip of obj type iptablerule field type str  type ref.
   * @return srcIp
   */
  public IpAddrPrefix getSrcIp() {
    return srcIp;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property src_ip of obj type iptablerule field type str  type ref.
   * @param srcIp set the srcIp.
   */
  public void setSrcIp(IpAddrPrefix srcIp) {
    this.srcIp = srcIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property src_port of obj type iptablerule field type str  type ref.
   * @return srcPort
   */
  public PortRange getSrcPort() {
    return srcPort;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property src_port of obj type iptablerule field type str  type ref.
   * @param srcPort set the srcPort.
   */
  public void setSrcPort(PortRange srcPort) {
    this.srcPort = srcPort;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property tag of obj type iptablerule field type str  type string.
   * @return tag
   */
  public String getTag() {
    return tag;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property tag of obj type iptablerule field type str  type string.
   * @param tag set the tag.
   */
  public void setTag(String  tag) {
    this.tag = tag;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  IptableRule objIptableRule = (IptableRule) o;
  return   Objects.equals(this.srcIp, objIptableRule.srcIp)&&
  Objects.equals(this.dstIp, objIptableRule.dstIp)&&
  Objects.equals(this.srcPort, objIptableRule.srcPort)&&
  Objects.equals(this.dstPort, objIptableRule.dstPort)&&
  Objects.equals(this.proto, objIptableRule.proto)&&
  Objects.equals(this.inputInterface, objIptableRule.inputInterface)&&
  Objects.equals(this.outputInterface, objIptableRule.outputInterface)&&
  Objects.equals(this.action, objIptableRule.action)&&
  Objects.equals(this.dnatIp, objIptableRule.dnatIp)&&
  Objects.equals(this.tag, objIptableRule.tag);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class IptableRule {\n");
      sb.append("    action: ").append(toIndentedString(action)).append("\n");
        sb.append("    dnatIp: ").append(toIndentedString(dnatIp)).append("\n");
        sb.append("    dstIp: ").append(toIndentedString(dstIp)).append("\n");
        sb.append("    dstPort: ").append(toIndentedString(dstPort)).append("\n");
        sb.append("    inputInterface: ").append(toIndentedString(inputInterface)).append("\n");
        sb.append("    outputInterface: ").append(toIndentedString(outputInterface)).append("\n");
        sb.append("    proto: ").append(toIndentedString(proto)).append("\n");
        sb.append("    srcIp: ").append(toIndentedString(srcIp)).append("\n");
        sb.append("    srcPort: ").append(toIndentedString(srcPort)).append("\n");
        sb.append("    tag: ").append(toIndentedString(tag)).append("\n");
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

