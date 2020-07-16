package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The CaptureFilters is a POJO class extends AviRestResource that used for creating
 * CaptureFilters.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CaptureFilters  {
    @JsonProperty("capture_ip")
    private DebugIpAddr captureIp = null;

    @JsonProperty("capture_ipc")
    private CaptureIPC captureIpc = null;

    @JsonProperty("dst_port_end")
    private Integer dstPortEnd = null;

    @JsonProperty("dst_port_start")
    private Integer dstPortStart = null;

    @JsonProperty("eth_proto")
    private String ethProto = null;

    @JsonProperty("ip_proto")
    private String ipProto = null;

    @JsonProperty("src_port")
    private Integer srcPort = null;

    @JsonProperty("tcp_ack")
    private Boolean tcpAck = null;

    @JsonProperty("tcp_fin")
    private Boolean tcpFin = null;

    @JsonProperty("tcp_push")
    private Boolean tcpPush = null;

    @JsonProperty("tcp_syn")
    private Boolean tcpSyn = null;



  /**
   * This is the getter method this will return the attribute value.
   * Per packet ip filter.
   * Matches with source and destination address.
   * Curently not applicable for debugserviceengine.
   * Field introduced in 18.2.5.
   * @return captureIp
   */
  public DebugIpAddr getCaptureIp() {
    return captureIp;
  }

  /**
   * This is the setter method to the attribute.
   * Per packet ip filter.
   * Matches with source and destination address.
   * Curently not applicable for debugserviceengine.
   * Field introduced in 18.2.5.
   * @param captureIp set the captureIp.
   */
  public void setCaptureIp(DebugIpAddr captureIp) {
    this.captureIp = captureIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Capture filter for se ipc.
   * Not applicable for debug virtual service.
   * Field introduced in 18.2.5.
   * @return captureIpc
   */
  public CaptureIPC getCaptureIpc() {
    return captureIpc;
  }

  /**
   * This is the setter method to the attribute.
   * Capture filter for se ipc.
   * Not applicable for debug virtual service.
   * Field introduced in 18.2.5.
   * @param captureIpc set the captureIpc.
   */
  public void setCaptureIpc(CaptureIPC captureIpc) {
    this.captureIpc = captureIpc;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Destination port range filter.
   * Field introduced in 18.2.5.
   * @return dstPortEnd
   */
  public Integer getDstPortEnd() {
    return dstPortEnd;
  }

  /**
   * This is the setter method to the attribute.
   * Destination port range filter.
   * Field introduced in 18.2.5.
   * @param dstPortEnd set the dstPortEnd.
   */
  public void setDstPortEnd(Integer  dstPortEnd) {
    this.dstPortEnd = dstPortEnd;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Destination port range filter.
   * Field introduced in 18.2.5.
   * @return dstPortStart
   */
  public Integer getDstPortStart() {
    return dstPortStart;
  }

  /**
   * This is the setter method to the attribute.
   * Destination port range filter.
   * Field introduced in 18.2.5.
   * @param dstPortStart set the dstPortStart.
   */
  public void setDstPortStart(Integer  dstPortStart) {
    this.dstPortStart = dstPortStart;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ethernet proto filter.
   * Enum options - ETH_TYPE_IPV4.
   * Field introduced in 18.2.5.
   * @return ethProto
   */
  public String getEthProto() {
    return ethProto;
  }

  /**
   * This is the setter method to the attribute.
   * Ethernet proto filter.
   * Enum options - ETH_TYPE_IPV4.
   * Field introduced in 18.2.5.
   * @param ethProto set the ethProto.
   */
  public void setEthProto(String  ethProto) {
    this.ethProto = ethProto;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ip proto filter.
   * Support for tcp only for now.
   * Enum options - IP_TYPE_TCP.
   * Field introduced in 18.2.5.
   * @return ipProto
   */
  public String getIpProto() {
    return ipProto;
  }

  /**
   * This is the setter method to the attribute.
   * Ip proto filter.
   * Support for tcp only for now.
   * Enum options - IP_TYPE_TCP.
   * Field introduced in 18.2.5.
   * @param ipProto set the ipProto.
   */
  public void setIpProto(String  ipProto) {
    this.ipProto = ipProto;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Source port filter.
   * Field introduced in 18.2.5.
   * @return srcPort
   */
  public Integer getSrcPort() {
    return srcPort;
  }

  /**
   * This is the setter method to the attribute.
   * Source port filter.
   * Field introduced in 18.2.5.
   * @param srcPort set the srcPort.
   */
  public void setSrcPort(Integer  srcPort) {
    this.srcPort = srcPort;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Tcp ack flag filter.
   * Field introduced in 18.2.5.
   * @return tcpAck
   */
  public Boolean getTcpAck() {
    return tcpAck;
  }

  /**
   * This is the setter method to the attribute.
   * Tcp ack flag filter.
   * Field introduced in 18.2.5.
   * @param tcpAck set the tcpAck.
   */
  public void setTcpAck(Boolean  tcpAck) {
    this.tcpAck = tcpAck;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Tcp fin flag filter.
   * Field introduced in 18.2.5.
   * @return tcpFin
   */
  public Boolean getTcpFin() {
    return tcpFin;
  }

  /**
   * This is the setter method to the attribute.
   * Tcp fin flag filter.
   * Field introduced in 18.2.5.
   * @param tcpFin set the tcpFin.
   */
  public void setTcpFin(Boolean  tcpFin) {
    this.tcpFin = tcpFin;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Tcp push flag filter.
   * Field introduced in 18.2.5.
   * @return tcpPush
   */
  public Boolean getTcpPush() {
    return tcpPush;
  }

  /**
   * This is the setter method to the attribute.
   * Tcp push flag filter.
   * Field introduced in 18.2.5.
   * @param tcpPush set the tcpPush.
   */
  public void setTcpPush(Boolean  tcpPush) {
    this.tcpPush = tcpPush;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Tcp syn flag filter.
   * Field introduced in 18.2.5.
   * @return tcpSyn
   */
  public Boolean getTcpSyn() {
    return tcpSyn;
  }

  /**
   * This is the setter method to the attribute.
   * Tcp syn flag filter.
   * Field introduced in 18.2.5.
   * @param tcpSyn set the tcpSyn.
   */
  public void setTcpSyn(Boolean  tcpSyn) {
    this.tcpSyn = tcpSyn;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  CaptureFilters objCaptureFilters = (CaptureFilters) o;
  return   Objects.equals(this.tcpFin, objCaptureFilters.tcpFin)&&
  Objects.equals(this.dstPortStart, objCaptureFilters.dstPortStart)&&
  Objects.equals(this.dstPortEnd, objCaptureFilters.dstPortEnd)&&
  Objects.equals(this.srcPort, objCaptureFilters.srcPort)&&
  Objects.equals(this.captureIpc, objCaptureFilters.captureIpc)&&
  Objects.equals(this.tcpPush, objCaptureFilters.tcpPush)&&
  Objects.equals(this.captureIp, objCaptureFilters.captureIp)&&
  Objects.equals(this.tcpSyn, objCaptureFilters.tcpSyn)&&
  Objects.equals(this.ipProto, objCaptureFilters.ipProto)&&
  Objects.equals(this.tcpAck, objCaptureFilters.tcpAck)&&
  Objects.equals(this.ethProto, objCaptureFilters.ethProto);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class CaptureFilters {\n");
      sb.append("    captureIp: ").append(toIndentedString(captureIp)).append("\n");
        sb.append("    captureIpc: ").append(toIndentedString(captureIpc)).append("\n");
        sb.append("    dstPortEnd: ").append(toIndentedString(dstPortEnd)).append("\n");
        sb.append("    dstPortStart: ").append(toIndentedString(dstPortStart)).append("\n");
        sb.append("    ethProto: ").append(toIndentedString(ethProto)).append("\n");
        sb.append("    ipProto: ").append(toIndentedString(ipProto)).append("\n");
        sb.append("    srcPort: ").append(toIndentedString(srcPort)).append("\n");
        sb.append("    tcpAck: ").append(toIndentedString(tcpAck)).append("\n");
        sb.append("    tcpFin: ").append(toIndentedString(tcpFin)).append("\n");
        sb.append("    tcpPush: ").append(toIndentedString(tcpPush)).append("\n");
        sb.append("    tcpSyn: ").append(toIndentedString(tcpSyn)).append("\n");
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

