package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The TCPProxyProfile is a POJO class extends AviRestResource that used for creating
 * TCPProxyProfile.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TCPProxyProfile  {
    @JsonProperty("aggressive_congestion_avoidance")
    private Boolean aggressiveCongestionAvoidance = false;

    @JsonProperty("auto_window_growth")
    private Boolean autoWindowGrowth = true;

    @JsonProperty("automatic")
    private Boolean automatic = true;

    @JsonProperty("cc_algo")
    private String ccAlgo = "CC_ALGO_NEW_RENO";

    @JsonProperty("congestion_recovery_scaling_factor")
    private Integer congestionRecoveryScalingFactor = 2;

    @JsonProperty("idle_connection_timeout")
    private Integer idleConnectionTimeout = 600;

    @JsonProperty("idle_connection_type")
    private String idleConnectionType = "KEEP_ALIVE";

    @JsonProperty("ignore_time_wait")
    private Boolean ignoreTimeWait = false;

    @JsonProperty("ip_dscp")
    private Integer ipDscp = 0;

    @JsonProperty("keepalive_in_halfclose_state")
    private Boolean keepaliveInHalfcloseState = true;

    @JsonProperty("max_retransmissions")
    private Integer maxRetransmissions = 8;

    @JsonProperty("max_segment_size")
    private Integer maxSegmentSize = null;

    @JsonProperty("max_syn_retransmissions")
    private Integer maxSynRetransmissions = 8;

    @JsonProperty("min_rexmt_timeout")
    private Integer minRexmtTimeout = null;

    @JsonProperty("nagles_algorithm")
    private Boolean naglesAlgorithm = false;

    @JsonProperty("reassembly_queue_size")
    private Integer reassemblyQueueSize = 0;

    @JsonProperty("receive_window")
    private Integer receiveWindow = 64;

    @JsonProperty("reorder_threshold")
    private Integer reorderThreshold = null;

    @JsonProperty("slow_start_scaling_factor")
    private Integer slowStartScalingFactor = 1;

    @JsonProperty("time_wait_delay")
    private Integer timeWaitDelay = 2000;

    @JsonProperty("use_interface_mtu")
    private Boolean useInterfaceMtu = true;



  /**
   * This is the getter method this will return the attribute value.
   * Controls the our congestion window to send, normally it's 1 mss, if this option is turned on, we use 10 msses.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return aggressiveCongestionAvoidance
   */
  public Boolean getAggressiveCongestionAvoidance() {
    return aggressiveCongestionAvoidance;
  }

  /**
   * This is the setter method to the attribute.
   * Controls the our congestion window to send, normally it's 1 mss, if this option is turned on, we use 10 msses.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param aggressiveCongestionAvoidance set the aggressiveCongestionAvoidance.
   */
  public void setAggressiveCongestionAvoidance(Boolean  aggressiveCongestionAvoidance) {
    this.aggressiveCongestionAvoidance = aggressiveCongestionAvoidance;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Controls whether the windows are static or supports autogrowth.
   * Maximum that it can grow to is limited to 4mb.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return autoWindowGrowth
   */
  public Boolean getAutoWindowGrowth() {
    return autoWindowGrowth;
  }

  /**
   * This is the setter method to the attribute.
   * Controls whether the windows are static or supports autogrowth.
   * Maximum that it can grow to is limited to 4mb.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param autoWindowGrowth set the autoWindowGrowth.
   */
  public void setAutoWindowGrowth(Boolean  autoWindowGrowth) {
    this.autoWindowGrowth = autoWindowGrowth;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dynamically pick the relevant parameters for connections.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return automatic
   */
  public Boolean getAutomatic() {
    return automatic;
  }

  /**
   * This is the setter method to the attribute.
   * Dynamically pick the relevant parameters for connections.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param automatic set the automatic.
   */
  public void setAutomatic(Boolean  automatic) {
    this.automatic = automatic;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Controls the congestion control algorithm we use.
   * Enum options - CC_ALGO_NEW_RENO, CC_ALGO_CUBIC, CC_ALGO_HTCP.
   * Default value when not specified in API or module is interpreted by Avi Controller as CC_ALGO_NEW_RENO.
   * @return ccAlgo
   */
  public String getCcAlgo() {
    return ccAlgo;
  }

  /**
   * This is the setter method to the attribute.
   * Controls the congestion control algorithm we use.
   * Enum options - CC_ALGO_NEW_RENO, CC_ALGO_CUBIC, CC_ALGO_HTCP.
   * Default value when not specified in API or module is interpreted by Avi Controller as CC_ALGO_NEW_RENO.
   * @param ccAlgo set the ccAlgo.
   */
  public void setCcAlgo(String  ccAlgo) {
    this.ccAlgo = ccAlgo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Congestion window scaling factor after recovery.
   * Allowed values are 0-8.
   * Field introduced in 17.2.12, 18.1.3, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 2.
   * @return congestionRecoveryScalingFactor
   */
  public Integer getCongestionRecoveryScalingFactor() {
    return congestionRecoveryScalingFactor;
  }

  /**
   * This is the setter method to the attribute.
   * Congestion window scaling factor after recovery.
   * Allowed values are 0-8.
   * Field introduced in 17.2.12, 18.1.3, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 2.
   * @param congestionRecoveryScalingFactor set the congestionRecoveryScalingFactor.
   */
  public void setCongestionRecoveryScalingFactor(Integer  congestionRecoveryScalingFactor) {
    this.congestionRecoveryScalingFactor = congestionRecoveryScalingFactor;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The duration for keepalive probes or session idle timeout.
   * Max value is 3600 seconds, min is 5.
   * Set to 0 to allow infinite idle time.
   * Allowed values are 5-14400.
   * Special values are 0 - 'infinite'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 600.
   * @return idleConnectionTimeout
   */
  public Integer getIdleConnectionTimeout() {
    return idleConnectionTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * The duration for keepalive probes or session idle timeout.
   * Max value is 3600 seconds, min is 5.
   * Set to 0 to allow infinite idle time.
   * Allowed values are 5-14400.
   * Special values are 0 - 'infinite'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 600.
   * @param idleConnectionTimeout set the idleConnectionTimeout.
   */
  public void setIdleConnectionTimeout(Integer  idleConnectionTimeout) {
    this.idleConnectionTimeout = idleConnectionTimeout;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Controls the behavior of idle connections.
   * Enum options - KEEP_ALIVE, CLOSE_IDLE.
   * Default value when not specified in API or module is interpreted by Avi Controller as KEEP_ALIVE.
   * @return idleConnectionType
   */
  public String getIdleConnectionType() {
    return idleConnectionType;
  }

  /**
   * This is the setter method to the attribute.
   * Controls the behavior of idle connections.
   * Enum options - KEEP_ALIVE, CLOSE_IDLE.
   * Default value when not specified in API or module is interpreted by Avi Controller as KEEP_ALIVE.
   * @param idleConnectionType set the idleConnectionType.
   */
  public void setIdleConnectionType(String  idleConnectionType) {
    this.idleConnectionType = idleConnectionType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * A new syn is accepted from the same 4-tuple even if there is already a connection in time_wait state.
   * This is equivalent of setting time wait delay to 0.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return ignoreTimeWait
   */
  public Boolean getIgnoreTimeWait() {
    return ignoreTimeWait;
  }

  /**
   * This is the setter method to the attribute.
   * A new syn is accepted from the same 4-tuple even if there is already a connection in time_wait state.
   * This is equivalent of setting time wait delay to 0.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param ignoreTimeWait set the ignoreTimeWait.
   */
  public void setIgnoreTimeWait(Boolean  ignoreTimeWait) {
    this.ignoreTimeWait = ignoreTimeWait;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Controls the value of the differentiated services code point field inserted in the ip header.
   * This has two options   set to a specific value, or pass through, which uses the incoming dscp value.
   * Allowed values are 0-63.
   * Special values are max - 'passthrough'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return ipDscp
   */
  public Integer getIpDscp() {
    return ipDscp;
  }

  /**
   * This is the setter method to the attribute.
   * Controls the value of the differentiated services code point field inserted in the ip header.
   * This has two options   set to a specific value, or pass through, which uses the incoming dscp value.
   * Allowed values are 0-63.
   * Special values are max - 'passthrough'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param ipDscp set the ipDscp.
   */
  public void setIpDscp(Integer  ipDscp) {
    this.ipDscp = ipDscp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Controls whether to keep the connection alive with keepalive messages in the tcp half close state.
   * The interval for sending keepalive messages is 30s.
   * If a timeout is already configured in the network profile, this will not override it.
   * Field introduced in 18.2.6.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return keepaliveInHalfcloseState
   */
  public Boolean getKeepaliveInHalfcloseState() {
    return keepaliveInHalfcloseState;
  }

  /**
   * This is the setter method to the attribute.
   * Controls whether to keep the connection alive with keepalive messages in the tcp half close state.
   * The interval for sending keepalive messages is 30s.
   * If a timeout is already configured in the network profile, this will not override it.
   * Field introduced in 18.2.6.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param keepaliveInHalfcloseState set the keepaliveInHalfcloseState.
   */
  public void setKeepaliveInHalfcloseState(Boolean  keepaliveInHalfcloseState) {
    this.keepaliveInHalfcloseState = keepaliveInHalfcloseState;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The number of attempts at retransmit before closing the connection.
   * Allowed values are 3-8.
   * Default value when not specified in API or module is interpreted by Avi Controller as 8.
   * @return maxRetransmissions
   */
  public Integer getMaxRetransmissions() {
    return maxRetransmissions;
  }

  /**
   * This is the setter method to the attribute.
   * The number of attempts at retransmit before closing the connection.
   * Allowed values are 3-8.
   * Default value when not specified in API or module is interpreted by Avi Controller as 8.
   * @param maxRetransmissions set the maxRetransmissions.
   */
  public void setMaxRetransmissions(Integer  maxRetransmissions) {
    this.maxRetransmissions = maxRetransmissions;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum tcp segment size.
   * Allowed values are 512-9000.
   * Special values are 0 - 'use interface mtu'.
   * @return maxSegmentSize
   */
  public Integer getMaxSegmentSize() {
    return maxSegmentSize;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum tcp segment size.
   * Allowed values are 512-9000.
   * Special values are 0 - 'use interface mtu'.
   * @param maxSegmentSize set the maxSegmentSize.
   */
  public void setMaxSegmentSize(Integer  maxSegmentSize) {
    this.maxSegmentSize = maxSegmentSize;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The maximum number of attempts at retransmitting a syn packet before giving up.
   * Allowed values are 3-8.
   * Default value when not specified in API or module is interpreted by Avi Controller as 8.
   * @return maxSynRetransmissions
   */
  public Integer getMaxSynRetransmissions() {
    return maxSynRetransmissions;
  }

  /**
   * This is the setter method to the attribute.
   * The maximum number of attempts at retransmitting a syn packet before giving up.
   * Allowed values are 3-8.
   * Default value when not specified in API or module is interpreted by Avi Controller as 8.
   * @param maxSynRetransmissions set the maxSynRetransmissions.
   */
  public void setMaxSynRetransmissions(Integer  maxSynRetransmissions) {
    this.maxSynRetransmissions = maxSynRetransmissions;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The minimum wait time (in millisec) to retransmit packet.
   * Allowed values are 50-5000.
   * Field introduced in 17.2.8.
   * @return minRexmtTimeout
   */
  public Integer getMinRexmtTimeout() {
    return minRexmtTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * The minimum wait time (in millisec) to retransmit packet.
   * Allowed values are 50-5000.
   * Field introduced in 17.2.8.
   * @param minRexmtTimeout set the minRexmtTimeout.
   */
  public void setMinRexmtTimeout(Integer  minRexmtTimeout) {
    this.minRexmtTimeout = minRexmtTimeout;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Consolidates small data packets to send clients fewer but larger packets.
   * Adversely affects real time protocols such as telnet or ssh.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return naglesAlgorithm
   */
  public Boolean getNaglesAlgorithm() {
    return naglesAlgorithm;
  }

  /**
   * This is the setter method to the attribute.
   * Consolidates small data packets to send clients fewer but larger packets.
   * Adversely affects real time protocols such as telnet or ssh.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param naglesAlgorithm set the naglesAlgorithm.
   */
  public void setNaglesAlgorithm(Boolean  naglesAlgorithm) {
    this.naglesAlgorithm = naglesAlgorithm;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of tcp segments that can be queued for reassembly.
   * Configuring this to 0 disables the feature and provides unlimited queuing.
   * Field introduced in 17.2.13, 18.1.4, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return reassemblyQueueSize
   */
  public Integer getReassemblyQueueSize() {
    return reassemblyQueueSize;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of tcp segments that can be queued for reassembly.
   * Configuring this to 0 disables the feature and provides unlimited queuing.
   * Field introduced in 17.2.13, 18.1.4, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param reassemblyQueueSize set the reassemblyQueueSize.
   */
  public void setReassemblyQueueSize(Integer  reassemblyQueueSize) {
    this.reassemblyQueueSize = reassemblyQueueSize;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Size of the receive window.
   * Allowed values are 2-65536.
   * Default value when not specified in API or module is interpreted by Avi Controller as 64.
   * @return receiveWindow
   */
  public Integer getReceiveWindow() {
    return receiveWindow;
  }

  /**
   * This is the setter method to the attribute.
   * Size of the receive window.
   * Allowed values are 2-65536.
   * Default value when not specified in API or module is interpreted by Avi Controller as 64.
   * @param receiveWindow set the receiveWindow.
   */
  public void setReceiveWindow(Integer  receiveWindow) {
    this.receiveWindow = receiveWindow;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Controls the number of duplicate acks required to trigger retransmission.
   * Setting a higher value reduces retransmission caused by packet reordering.
   * A larger value is recommended in public cloud environments where packet reordering is quite common.
   * The default value is 8 in public cloud platforms (aws, azure, gcp), and 3 in other environments.
   * Allowed values are 1-100.
   * Field introduced in 17.2.7.
   * @return reorderThreshold
   */
  public Integer getReorderThreshold() {
    return reorderThreshold;
  }

  /**
   * This is the setter method to the attribute.
   * Controls the number of duplicate acks required to trigger retransmission.
   * Setting a higher value reduces retransmission caused by packet reordering.
   * A larger value is recommended in public cloud environments where packet reordering is quite common.
   * The default value is 8 in public cloud platforms (aws, azure, gcp), and 3 in other environments.
   * Allowed values are 1-100.
   * Field introduced in 17.2.7.
   * @param reorderThreshold set the reorderThreshold.
   */
  public void setReorderThreshold(Integer  reorderThreshold) {
    this.reorderThreshold = reorderThreshold;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Congestion window scaling factor during slow start.
   * Allowed values are 0-8.
   * Field introduced in 17.2.12, 18.1.3, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.
   * @return slowStartScalingFactor
   */
  public Integer getSlowStartScalingFactor() {
    return slowStartScalingFactor;
  }

  /**
   * This is the setter method to the attribute.
   * Congestion window scaling factor during slow start.
   * Allowed values are 0-8.
   * Field introduced in 17.2.12, 18.1.3, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.
   * @param slowStartScalingFactor set the slowStartScalingFactor.
   */
  public void setSlowStartScalingFactor(Integer  slowStartScalingFactor) {
    this.slowStartScalingFactor = slowStartScalingFactor;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The time (in millisec) to wait before closing a connection in the time_wait state.
   * Allowed values are 500-2000.
   * Special values are 0 - 'immediate'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 2000.
   * @return timeWaitDelay
   */
  public Integer getTimeWaitDelay() {
    return timeWaitDelay;
  }

  /**
   * This is the setter method to the attribute.
   * The time (in millisec) to wait before closing a connection in the time_wait state.
   * Allowed values are 500-2000.
   * Special values are 0 - 'immediate'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 2000.
   * @param timeWaitDelay set the timeWaitDelay.
   */
  public void setTimeWaitDelay(Integer  timeWaitDelay) {
    this.timeWaitDelay = timeWaitDelay;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Use the interface mtu to calculate the tcp max segment size.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return useInterfaceMtu
   */
  public Boolean getUseInterfaceMtu() {
    return useInterfaceMtu;
  }

  /**
   * This is the setter method to the attribute.
   * Use the interface mtu to calculate the tcp max segment size.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param useInterfaceMtu set the useInterfaceMtu.
   */
  public void setUseInterfaceMtu(Boolean  useInterfaceMtu) {
    this.useInterfaceMtu = useInterfaceMtu;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  TCPProxyProfile objTCPProxyProfile = (TCPProxyProfile) o;
  return   Objects.equals(this.automatic, objTCPProxyProfile.automatic)&&
  Objects.equals(this.idleConnectionType, objTCPProxyProfile.idleConnectionType)&&
  Objects.equals(this.idleConnectionTimeout, objTCPProxyProfile.idleConnectionTimeout)&&
  Objects.equals(this.ignoreTimeWait, objTCPProxyProfile.ignoreTimeWait)&&
  Objects.equals(this.timeWaitDelay, objTCPProxyProfile.timeWaitDelay)&&
  Objects.equals(this.maxRetransmissions, objTCPProxyProfile.maxRetransmissions)&&
  Objects.equals(this.maxSynRetransmissions, objTCPProxyProfile.maxSynRetransmissions)&&
  Objects.equals(this.receiveWindow, objTCPProxyProfile.receiveWindow)&&
  Objects.equals(this.useInterfaceMtu, objTCPProxyProfile.useInterfaceMtu)&&
  Objects.equals(this.maxSegmentSize, objTCPProxyProfile.maxSegmentSize)&&
  Objects.equals(this.naglesAlgorithm, objTCPProxyProfile.naglesAlgorithm)&&
  Objects.equals(this.ipDscp, objTCPProxyProfile.ipDscp)&&
  Objects.equals(this.ccAlgo, objTCPProxyProfile.ccAlgo)&&
  Objects.equals(this.aggressiveCongestionAvoidance, objTCPProxyProfile.aggressiveCongestionAvoidance)&&
  Objects.equals(this.reorderThreshold, objTCPProxyProfile.reorderThreshold)&&
  Objects.equals(this.minRexmtTimeout, objTCPProxyProfile.minRexmtTimeout)&&
  Objects.equals(this.slowStartScalingFactor, objTCPProxyProfile.slowStartScalingFactor)&&
  Objects.equals(this.congestionRecoveryScalingFactor, objTCPProxyProfile.congestionRecoveryScalingFactor)&&
  Objects.equals(this.reassemblyQueueSize, objTCPProxyProfile.reassemblyQueueSize)&&
  Objects.equals(this.keepaliveInHalfcloseState, objTCPProxyProfile.keepaliveInHalfcloseState)&&
  Objects.equals(this.autoWindowGrowth, objTCPProxyProfile.autoWindowGrowth);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class TCPProxyProfile {\n");
      sb.append("    aggressiveCongestionAvoidance: ").append(toIndentedString(aggressiveCongestionAvoidance)).append("\n");
        sb.append("    autoWindowGrowth: ").append(toIndentedString(autoWindowGrowth)).append("\n");
        sb.append("    automatic: ").append(toIndentedString(automatic)).append("\n");
        sb.append("    ccAlgo: ").append(toIndentedString(ccAlgo)).append("\n");
        sb.append("    congestionRecoveryScalingFactor: ").append(toIndentedString(congestionRecoveryScalingFactor)).append("\n");
        sb.append("    idleConnectionTimeout: ").append(toIndentedString(idleConnectionTimeout)).append("\n");
        sb.append("    idleConnectionType: ").append(toIndentedString(idleConnectionType)).append("\n");
        sb.append("    ignoreTimeWait: ").append(toIndentedString(ignoreTimeWait)).append("\n");
        sb.append("    ipDscp: ").append(toIndentedString(ipDscp)).append("\n");
        sb.append("    keepaliveInHalfcloseState: ").append(toIndentedString(keepaliveInHalfcloseState)).append("\n");
        sb.append("    maxRetransmissions: ").append(toIndentedString(maxRetransmissions)).append("\n");
        sb.append("    maxSegmentSize: ").append(toIndentedString(maxSegmentSize)).append("\n");
        sb.append("    maxSynRetransmissions: ").append(toIndentedString(maxSynRetransmissions)).append("\n");
        sb.append("    minRexmtTimeout: ").append(toIndentedString(minRexmtTimeout)).append("\n");
        sb.append("    naglesAlgorithm: ").append(toIndentedString(naglesAlgorithm)).append("\n");
        sb.append("    reassemblyQueueSize: ").append(toIndentedString(reassemblyQueueSize)).append("\n");
        sb.append("    receiveWindow: ").append(toIndentedString(receiveWindow)).append("\n");
        sb.append("    reorderThreshold: ").append(toIndentedString(reorderThreshold)).append("\n");
        sb.append("    slowStartScalingFactor: ").append(toIndentedString(slowStartScalingFactor)).append("\n");
        sb.append("    timeWaitDelay: ").append(toIndentedString(timeWaitDelay)).append("\n");
        sb.append("    useInterfaceMtu: ").append(toIndentedString(useInterfaceMtu)).append("\n");
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

