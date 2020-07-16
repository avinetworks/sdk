package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VserverL4MetricsObj is a POJO class extends AviRestResource that used for creating
 * VserverL4MetricsObj.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VserverL4MetricsObj  {
    @JsonProperty("apdexc")
    private Float apdexc = null;

    @JsonProperty("apdexrtt")
    private Float apdexrtt = null;

    @JsonProperty("avg_application_dos_attacks")
    private Float avgApplicationDosAttacks = null;

    @JsonProperty("avg_bandwidth")
    private Float avgBandwidth = null;

    @JsonProperty("avg_bytes_policy_drops")
    private Float avgBytesPolicyDrops = null;

    @JsonProperty("avg_complete_conns")
    private Float avgCompleteConns = null;

    @JsonProperty("avg_connections_dropped")
    private Float avgConnectionsDropped = null;

    @JsonProperty("avg_dos_app_error")
    private Float avgDosAppError = null;

    @JsonProperty("avg_dos_attacks")
    private Float avgDosAttacks = null;

    @JsonProperty("avg_dos_bad_rst_flood")
    private Float avgDosBadRstFlood = null;

    @JsonProperty("avg_dos_bandwidth")
    private Float avgDosBandwidth = null;

    @JsonProperty("avg_dos_conn")
    private Float avgDosConn = null;

    @JsonProperty("avg_dos_conn_ip_rl_drop")
    private Float avgDosConnIpRlDrop = null;

    @JsonProperty("avg_dos_conn_rl_drop")
    private Float avgDosConnRlDrop = null;

    @JsonProperty("avg_dos_fake_session")
    private Float avgDosFakeSession = null;

    @JsonProperty("avg_dos_http_abort")
    private Float avgDosHttpAbort = null;

    @JsonProperty("avg_dos_http_error")
    private Float avgDosHttpError = null;

    @JsonProperty("avg_dos_http_timeout")
    private Float avgDosHttpTimeout = null;

    @JsonProperty("avg_dos_malformed_flood")
    private Float avgDosMalformedFlood = null;

    @JsonProperty("avg_dos_non_syn_flood")
    private Float avgDosNonSynFlood = null;

    @JsonProperty("avg_dos_req")
    private Float avgDosReq = null;

    @JsonProperty("avg_dos_req_cookie_rl_drop")
    private Float avgDosReqCookieRlDrop = null;

    @JsonProperty("avg_dos_req_custom_rl_drop")
    private Float avgDosReqCustomRlDrop = null;

    @JsonProperty("avg_dos_req_hdr_rl_drop")
    private Float avgDosReqHdrRlDrop = null;

    @JsonProperty("avg_dos_req_ip_rl_drop")
    private Float avgDosReqIpRlDrop = null;

    @JsonProperty("avg_dos_req_ip_rl_drop_bad")
    private Float avgDosReqIpRlDropBad = null;

    @JsonProperty("avg_dos_req_ip_scan_bad_rl_drop")
    private Float avgDosReqIpScanBadRlDrop = null;

    @JsonProperty("avg_dos_req_ip_scan_unknown_rl_drop")
    private Float avgDosReqIpScanUnknownRlDrop = null;

    @JsonProperty("avg_dos_req_ip_uri_rl_drop")
    private Float avgDosReqIpUriRlDrop = null;

    @JsonProperty("avg_dos_req_ip_uri_rl_drop_bad")
    private Float avgDosReqIpUriRlDropBad = null;

    @JsonProperty("avg_dos_req_rl_drop")
    private Float avgDosReqRlDrop = null;

    @JsonProperty("avg_dos_req_uri_rl_drop")
    private Float avgDosReqUriRlDrop = null;

    @JsonProperty("avg_dos_req_uri_rl_drop_bad")
    private Float avgDosReqUriRlDropBad = null;

    @JsonProperty("avg_dos_req_uri_scan_bad_rl_drop")
    private Float avgDosReqUriScanBadRlDrop = null;

    @JsonProperty("avg_dos_req_uri_scan_unknown_rl_drop")
    private Float avgDosReqUriScanUnknownRlDrop = null;

    @JsonProperty("avg_dos_rx_bytes")
    private Float avgDosRxBytes = null;

    @JsonProperty("avg_dos_slow_uri")
    private Float avgDosSlowUri = null;

    @JsonProperty("avg_dos_small_window_stress")
    private Float avgDosSmallWindowStress = null;

    @JsonProperty("avg_dos_ssl_error")
    private Float avgDosSslError = null;

    @JsonProperty("avg_dos_syn_flood")
    private Float avgDosSynFlood = null;

    @JsonProperty("avg_dos_total_req")
    private Float avgDosTotalReq = null;

    @JsonProperty("avg_dos_tx_bytes")
    private Float avgDosTxBytes = null;

    @JsonProperty("avg_dos_zero_window_stress")
    private Float avgDosZeroWindowStress = null;

    @JsonProperty("avg_errored_connections")
    private Float avgErroredConnections = null;

    @JsonProperty("avg_l4_client_latency")
    private Float avgL4ClientLatency = null;

    @JsonProperty("avg_lossy_connections")
    private Float avgLossyConnections = null;

    @JsonProperty("avg_lossy_req")
    private Float avgLossyReq = null;

    @JsonProperty("avg_network_dos_attacks")
    private Float avgNetworkDosAttacks = null;

    @JsonProperty("avg_new_established_conns")
    private Float avgNewEstablishedConns = null;

    @JsonProperty("avg_pkts_policy_drops")
    private Float avgPktsPolicyDrops = null;

    @JsonProperty("avg_policy_drops")
    private Float avgPolicyDrops = null;

    @JsonProperty("avg_rx_bytes")
    private Float avgRxBytes = null;

    @JsonProperty("avg_rx_bytes_dropped")
    private Float avgRxBytesDropped = null;

    @JsonProperty("avg_rx_pkts")
    private Float avgRxPkts = null;

    @JsonProperty("avg_rx_pkts_dropped")
    private Float avgRxPktsDropped = null;

    @JsonProperty("avg_syns")
    private Float avgSyns = null;

    @JsonProperty("avg_total_connections")
    private Float avgTotalConnections = null;

    @JsonProperty("avg_total_rtt")
    private Float avgTotalRtt = null;

    @JsonProperty("avg_tx_bytes")
    private Float avgTxBytes = null;

    @JsonProperty("avg_tx_pkts")
    private Float avgTxPkts = null;

    @JsonProperty("max_num_active_se")
    private Float maxNumActiveSe = null;

    @JsonProperty("max_open_conns")
    private Float maxOpenConns = null;

    @JsonProperty("max_rx_bytes_absolute")
    private Float maxRxBytesAbsolute = null;

    @JsonProperty("max_rx_pkts_absolute")
    private Float maxRxPktsAbsolute = null;

    @JsonProperty("max_tx_bytes_absolute")
    private Float maxTxBytesAbsolute = null;

    @JsonProperty("max_tx_pkts_absolute")
    private Float maxTxPktsAbsolute = null;

    @JsonProperty("node_obj_id")
    private String nodeObjId = null;

    @JsonProperty("pct_application_dos_attacks")
    private Float pctApplicationDosAttacks = null;

    @JsonProperty("pct_connection_errors")
    private Float pctConnectionErrors = null;

    @JsonProperty("pct_connections_dos_attacks")
    private Float pctConnectionsDosAttacks = null;

    @JsonProperty("pct_dos_bandwidth")
    private Float pctDosBandwidth = null;

    @JsonProperty("pct_dos_rx_bytes")
    private Float pctDosRxBytes = null;

    @JsonProperty("pct_network_dos_attacks")
    private Float pctNetworkDosAttacks = null;

    @JsonProperty("pct_pkts_dos_attacks")
    private Float pctPktsDosAttacks = null;

    @JsonProperty("pct_policy_drops")
    private Float pctPolicyDrops = null;

    @JsonProperty("sum_conn_duration")
    private Float sumConnDuration = null;

    @JsonProperty("sum_connection_dropped_user_limit")
    private Float sumConnectionDroppedUserLimit = null;

    @JsonProperty("sum_connection_errors")
    private Float sumConnectionErrors = null;

    @JsonProperty("sum_connections_dropped")
    private Float sumConnectionsDropped = null;

    @JsonProperty("sum_dup_ack_retransmits")
    private Float sumDupAckRetransmits = null;

    @JsonProperty("sum_end_to_end_rtt")
    private Float sumEndToEndRtt = null;

    @JsonProperty("sum_end_to_end_rtt_bucket1")
    private Float sumEndToEndRttBucket1 = null;

    @JsonProperty("sum_end_to_end_rtt_bucket2")
    private Float sumEndToEndRttBucket2 = null;

    @JsonProperty("sum_finished_conns")
    private Float sumFinishedConns = null;

    @JsonProperty("sum_lossy_connections")
    private Float sumLossyConnections = null;

    @JsonProperty("sum_lossy_req")
    private Float sumLossyReq = null;

    @JsonProperty("sum_out_of_orders")
    private Float sumOutOfOrders = null;

    @JsonProperty("sum_packet_dropped_user_bandwidth_limit")
    private Float sumPacketDroppedUserBandwidthLimit = null;

    @JsonProperty("sum_rtt_valid_connections")
    private Float sumRttValidConnections = null;

    @JsonProperty("sum_sack_retransmits")
    private Float sumSackRetransmits = null;

    @JsonProperty("sum_server_flow_control")
    private Float sumServerFlowControl = null;

    @JsonProperty("sum_timeout_retransmits")
    private Float sumTimeoutRetransmits = null;

    @JsonProperty("sum_zero_window_size_events")
    private Float sumZeroWindowSizeEvents = null;



  /**
   * This is the getter method this will return the attribute value.
   * Apdex measuring quality of network connections to servers.
   * @return apdexc
   */
  public Float getApdexc() {
    return apdexc;
  }

  /**
   * This is the setter method to the attribute.
   * Apdex measuring quality of network connections to servers.
   * @param apdexc set the apdexc.
   */
  public void setApdexc(Float  apdexc) {
    this.apdexc = apdexc;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Apdex measuring network connection quality based on rtt.
   * @return apdexrtt
   */
  public Float getApdexrtt() {
    return apdexrtt;
  }

  /**
   * This is the setter method to the attribute.
   * Apdex measuring network connection quality based on rtt.
   * @param apdexrtt set the apdexrtt.
   */
  public void setApdexrtt(Float  apdexrtt) {
    this.apdexrtt = apdexrtt;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Number of application ddos attacks occurring.
   * @return avgApplicationDosAttacks
   */
  public Float getAvgApplicationDosAttacks() {
    return avgApplicationDosAttacks;
  }

  /**
   * This is the setter method to the attribute.
   * Number of application ddos attacks occurring.
   * @param avgApplicationDosAttacks set the avgApplicationDosAttacks.
   */
  public void setAvgApplicationDosAttacks(Float  avgApplicationDosAttacks) {
    this.avgApplicationDosAttacks = avgApplicationDosAttacks;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average transmit and receive network bandwidth between client and virtual service.
   * @return avgBandwidth
   */
  public Float getAvgBandwidth() {
    return avgBandwidth;
  }

  /**
   * This is the setter method to the attribute.
   * Average transmit and receive network bandwidth between client and virtual service.
   * @param avgBandwidth set the avgBandwidth.
   */
  public void setAvgBandwidth(Float  avgBandwidth) {
    this.avgBandwidth = avgBandwidth;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Averaged rate bytes dropped per second.
   * @return avgBytesPolicyDrops
   */
  public Float getAvgBytesPolicyDrops() {
    return avgBytesPolicyDrops;
  }

  /**
   * This is the setter method to the attribute.
   * Averaged rate bytes dropped per second.
   * @param avgBytesPolicyDrops set the avgBytesPolicyDrops.
   */
  public void setAvgBytesPolicyDrops(Float  avgBytesPolicyDrops) {
    this.avgBytesPolicyDrops = avgBytesPolicyDrops;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Rate of total connections per second.
   * @return avgCompleteConns
   */
  public Float getAvgCompleteConns() {
    return avgCompleteConns;
  }

  /**
   * This is the setter method to the attribute.
   * Rate of total connections per second.
   * @param avgCompleteConns set the avgCompleteConns.
   */
  public void setAvgCompleteConns(Float  avgCompleteConns) {
    this.avgCompleteConns = avgCompleteConns;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Rate of dropped connections per second.
   * @return avgConnectionsDropped
   */
  public Float getAvgConnectionsDropped() {
    return avgConnectionsDropped;
  }

  /**
   * This is the setter method to the attribute.
   * Rate of dropped connections per second.
   * @param avgConnectionsDropped set the avgConnectionsDropped.
   */
  public void setAvgConnectionsDropped(Float  avgConnectionsDropped) {
    this.avgConnectionsDropped = avgConnectionsDropped;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dos attack  rate of http app errors.
   * @return avgDosAppError
   */
  public Float getAvgDosAppError() {
    return avgDosAppError;
  }

  /**
   * This is the setter method to the attribute.
   * Dos attack  rate of http app errors.
   * @param avgDosAppError set the avgDosAppError.
   */
  public void setAvgDosAppError(Float  avgDosAppError) {
    this.avgDosAppError = avgDosAppError;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Number ddos attacks occurring.
   * @return avgDosAttacks
   */
  public Float getAvgDosAttacks() {
    return avgDosAttacks;
  }

  /**
   * This is the setter method to the attribute.
   * Number ddos attacks occurring.
   * @param avgDosAttacks set the avgDosAttacks.
   */
  public void setAvgDosAttacks(Float  avgDosAttacks) {
    this.avgDosAttacks = avgDosAttacks;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dos attack  rate of bad rst floods.
   * @return avgDosBadRstFlood
   */
  public Float getAvgDosBadRstFlood() {
    return avgDosBadRstFlood;
  }

  /**
   * This is the setter method to the attribute.
   * Dos attack  rate of bad rst floods.
   * @param avgDosBadRstFlood set the avgDosBadRstFlood.
   */
  public void setAvgDosBadRstFlood(Float  avgDosBadRstFlood) {
    this.avgDosBadRstFlood = avgDosBadRstFlood;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average transmit and receive network bandwidth between client and virtual service related to ddos attack.
   * @return avgDosBandwidth
   */
  public Float getAvgDosBandwidth() {
    return avgDosBandwidth;
  }

  /**
   * This is the setter method to the attribute.
   * Average transmit and receive network bandwidth between client and virtual service related to ddos attack.
   * @param avgDosBandwidth set the avgDosBandwidth.
   */
  public void setAvgDosBandwidth(Float  avgDosBandwidth) {
    this.avgDosBandwidth = avgDosBandwidth;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Number of connections considered as dos.
   * @return avgDosConn
   */
  public Float getAvgDosConn() {
    return avgDosConn;
  }

  /**
   * This is the setter method to the attribute.
   * Number of connections considered as dos.
   * @param avgDosConn set the avgDosConn.
   */
  public void setAvgDosConn(Float  avgDosConn) {
    this.avgDosConn = avgDosConn;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dos attack  connections dropped due to ip rate limit.
   * @return avgDosConnIpRlDrop
   */
  public Float getAvgDosConnIpRlDrop() {
    return avgDosConnIpRlDrop;
  }

  /**
   * This is the setter method to the attribute.
   * Dos attack  connections dropped due to ip rate limit.
   * @param avgDosConnIpRlDrop set the avgDosConnIpRlDrop.
   */
  public void setAvgDosConnIpRlDrop(Float  avgDosConnIpRlDrop) {
    this.avgDosConnIpRlDrop = avgDosConnIpRlDrop;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dos attack  connections dropped due to vs rate limit.
   * @return avgDosConnRlDrop
   */
  public Float getAvgDosConnRlDrop() {
    return avgDosConnRlDrop;
  }

  /**
   * This is the setter method to the attribute.
   * Dos attack  connections dropped due to vs rate limit.
   * @param avgDosConnRlDrop set the avgDosConnRlDrop.
   */
  public void setAvgDosConnRlDrop(Float  avgDosConnRlDrop) {
    this.avgDosConnRlDrop = avgDosConnRlDrop;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dos attack  rate of fake sessions.
   * @return avgDosFakeSession
   */
  public Float getAvgDosFakeSession() {
    return avgDosFakeSession;
  }

  /**
   * This is the setter method to the attribute.
   * Dos attack  rate of fake sessions.
   * @param avgDosFakeSession set the avgDosFakeSession.
   */
  public void setAvgDosFakeSession(Float  avgDosFakeSession) {
    this.avgDosFakeSession = avgDosFakeSession;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dos attack  rate of http aborts.
   * @return avgDosHttpAbort
   */
  public Float getAvgDosHttpAbort() {
    return avgDosHttpAbort;
  }

  /**
   * This is the setter method to the attribute.
   * Dos attack  rate of http aborts.
   * @param avgDosHttpAbort set the avgDosHttpAbort.
   */
  public void setAvgDosHttpAbort(Float  avgDosHttpAbort) {
    this.avgDosHttpAbort = avgDosHttpAbort;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dos attack  rate of http errors.
   * @return avgDosHttpError
   */
  public Float getAvgDosHttpError() {
    return avgDosHttpError;
  }

  /**
   * This is the setter method to the attribute.
   * Dos attack  rate of http errors.
   * @param avgDosHttpError set the avgDosHttpError.
   */
  public void setAvgDosHttpError(Float  avgDosHttpError) {
    this.avgDosHttpError = avgDosHttpError;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dos attack  rate of http timeouts.
   * @return avgDosHttpTimeout
   */
  public Float getAvgDosHttpTimeout() {
    return avgDosHttpTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * Dos attack  rate of http timeouts.
   * @param avgDosHttpTimeout set the avgDosHttpTimeout.
   */
  public void setAvgDosHttpTimeout(Float  avgDosHttpTimeout) {
    this.avgDosHttpTimeout = avgDosHttpTimeout;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dos attack  rate of malformed packet floods.
   * @return avgDosMalformedFlood
   */
  public Float getAvgDosMalformedFlood() {
    return avgDosMalformedFlood;
  }

  /**
   * This is the setter method to the attribute.
   * Dos attack  rate of malformed packet floods.
   * @param avgDosMalformedFlood set the avgDosMalformedFlood.
   */
  public void setAvgDosMalformedFlood(Float  avgDosMalformedFlood) {
    this.avgDosMalformedFlood = avgDosMalformedFlood;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dos attack  non syn packet flood.
   * @return avgDosNonSynFlood
   */
  public Float getAvgDosNonSynFlood() {
    return avgDosNonSynFlood;
  }

  /**
   * This is the setter method to the attribute.
   * Dos attack  non syn packet flood.
   * @param avgDosNonSynFlood set the avgDosNonSynFlood.
   */
  public void setAvgDosNonSynFlood(Float  avgDosNonSynFlood) {
    this.avgDosNonSynFlood = avgDosNonSynFlood;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Number of request considered as dos.
   * @return avgDosReq
   */
  public Float getAvgDosReq() {
    return avgDosReq;
  }

  /**
   * This is the setter method to the attribute.
   * Number of request considered as dos.
   * @param avgDosReq set the avgDosReq.
   */
  public void setAvgDosReq(Float  avgDosReq) {
    this.avgDosReq = avgDosReq;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dos attack  requests dropped due to cookie rate limit.
   * @return avgDosReqCookieRlDrop
   */
  public Float getAvgDosReqCookieRlDrop() {
    return avgDosReqCookieRlDrop;
  }

  /**
   * This is the setter method to the attribute.
   * Dos attack  requests dropped due to cookie rate limit.
   * @param avgDosReqCookieRlDrop set the avgDosReqCookieRlDrop.
   */
  public void setAvgDosReqCookieRlDrop(Float  avgDosReqCookieRlDrop) {
    this.avgDosReqCookieRlDrop = avgDosReqCookieRlDrop;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dos attack  requests dropped due to custom rate limit.
   * Field introduced in 17.2.13,18.1.3,18.2.1.
   * @return avgDosReqCustomRlDrop
   */
  public Float getAvgDosReqCustomRlDrop() {
    return avgDosReqCustomRlDrop;
  }

  /**
   * This is the setter method to the attribute.
   * Dos attack  requests dropped due to custom rate limit.
   * Field introduced in 17.2.13,18.1.3,18.2.1.
   * @param avgDosReqCustomRlDrop set the avgDosReqCustomRlDrop.
   */
  public void setAvgDosReqCustomRlDrop(Float  avgDosReqCustomRlDrop) {
    this.avgDosReqCustomRlDrop = avgDosReqCustomRlDrop;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dos attack  requests dropped due to header rate limit.
   * @return avgDosReqHdrRlDrop
   */
  public Float getAvgDosReqHdrRlDrop() {
    return avgDosReqHdrRlDrop;
  }

  /**
   * This is the setter method to the attribute.
   * Dos attack  requests dropped due to header rate limit.
   * @param avgDosReqHdrRlDrop set the avgDosReqHdrRlDrop.
   */
  public void setAvgDosReqHdrRlDrop(Float  avgDosReqHdrRlDrop) {
    this.avgDosReqHdrRlDrop = avgDosReqHdrRlDrop;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dos attack  requests dropped due to ip rate limit.
   * @return avgDosReqIpRlDrop
   */
  public Float getAvgDosReqIpRlDrop() {
    return avgDosReqIpRlDrop;
  }

  /**
   * This is the setter method to the attribute.
   * Dos attack  requests dropped due to ip rate limit.
   * @param avgDosReqIpRlDrop set the avgDosReqIpRlDrop.
   */
  public void setAvgDosReqIpRlDrop(Float  avgDosReqIpRlDrop) {
    this.avgDosReqIpRlDrop = avgDosReqIpRlDrop;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dos attack  requests dropped due to ip rate limit for bad requests.
   * @return avgDosReqIpRlDropBad
   */
  public Float getAvgDosReqIpRlDropBad() {
    return avgDosReqIpRlDropBad;
  }

  /**
   * This is the setter method to the attribute.
   * Dos attack  requests dropped due to ip rate limit for bad requests.
   * @param avgDosReqIpRlDropBad set the avgDosReqIpRlDropBad.
   */
  public void setAvgDosReqIpRlDropBad(Float  avgDosReqIpRlDropBad) {
    this.avgDosReqIpRlDropBad = avgDosReqIpRlDropBad;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dos attack  requests dropped due to bad ip rate limit.
   * @return avgDosReqIpScanBadRlDrop
   */
  public Float getAvgDosReqIpScanBadRlDrop() {
    return avgDosReqIpScanBadRlDrop;
  }

  /**
   * This is the setter method to the attribute.
   * Dos attack  requests dropped due to bad ip rate limit.
   * @param avgDosReqIpScanBadRlDrop set the avgDosReqIpScanBadRlDrop.
   */
  public void setAvgDosReqIpScanBadRlDrop(Float  avgDosReqIpScanBadRlDrop) {
    this.avgDosReqIpScanBadRlDrop = avgDosReqIpScanBadRlDrop;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dos attack  requests dropped due to unknown ip rate limit.
   * @return avgDosReqIpScanUnknownRlDrop
   */
  public Float getAvgDosReqIpScanUnknownRlDrop() {
    return avgDosReqIpScanUnknownRlDrop;
  }

  /**
   * This is the setter method to the attribute.
   * Dos attack  requests dropped due to unknown ip rate limit.
   * @param avgDosReqIpScanUnknownRlDrop set the avgDosReqIpScanUnknownRlDrop.
   */
  public void setAvgDosReqIpScanUnknownRlDrop(Float  avgDosReqIpScanUnknownRlDrop) {
    this.avgDosReqIpScanUnknownRlDrop = avgDosReqIpScanUnknownRlDrop;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dos attack  requests dropped due to ip+url rate limit.
   * @return avgDosReqIpUriRlDrop
   */
  public Float getAvgDosReqIpUriRlDrop() {
    return avgDosReqIpUriRlDrop;
  }

  /**
   * This is the setter method to the attribute.
   * Dos attack  requests dropped due to ip+url rate limit.
   * @param avgDosReqIpUriRlDrop set the avgDosReqIpUriRlDrop.
   */
  public void setAvgDosReqIpUriRlDrop(Float  avgDosReqIpUriRlDrop) {
    this.avgDosReqIpUriRlDrop = avgDosReqIpUriRlDrop;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dos attack  requests dropped due to ip+url rate limit for bad requests.
   * @return avgDosReqIpUriRlDropBad
   */
  public Float getAvgDosReqIpUriRlDropBad() {
    return avgDosReqIpUriRlDropBad;
  }

  /**
   * This is the setter method to the attribute.
   * Dos attack  requests dropped due to ip+url rate limit for bad requests.
   * @param avgDosReqIpUriRlDropBad set the avgDosReqIpUriRlDropBad.
   */
  public void setAvgDosReqIpUriRlDropBad(Float  avgDosReqIpUriRlDropBad) {
    this.avgDosReqIpUriRlDropBad = avgDosReqIpUriRlDropBad;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dos attack  requests dropped due to vs rate limit.
   * @return avgDosReqRlDrop
   */
  public Float getAvgDosReqRlDrop() {
    return avgDosReqRlDrop;
  }

  /**
   * This is the setter method to the attribute.
   * Dos attack  requests dropped due to vs rate limit.
   * @param avgDosReqRlDrop set the avgDosReqRlDrop.
   */
  public void setAvgDosReqRlDrop(Float  avgDosReqRlDrop) {
    this.avgDosReqRlDrop = avgDosReqRlDrop;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dos attack  requests dropped due to url rate limit.
   * @return avgDosReqUriRlDrop
   */
  public Float getAvgDosReqUriRlDrop() {
    return avgDosReqUriRlDrop;
  }

  /**
   * This is the setter method to the attribute.
   * Dos attack  requests dropped due to url rate limit.
   * @param avgDosReqUriRlDrop set the avgDosReqUriRlDrop.
   */
  public void setAvgDosReqUriRlDrop(Float  avgDosReqUriRlDrop) {
    this.avgDosReqUriRlDrop = avgDosReqUriRlDrop;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dos attack  requests dropped due to url rate limit for bad requests.
   * @return avgDosReqUriRlDropBad
   */
  public Float getAvgDosReqUriRlDropBad() {
    return avgDosReqUriRlDropBad;
  }

  /**
   * This is the setter method to the attribute.
   * Dos attack  requests dropped due to url rate limit for bad requests.
   * @param avgDosReqUriRlDropBad set the avgDosReqUriRlDropBad.
   */
  public void setAvgDosReqUriRlDropBad(Float  avgDosReqUriRlDropBad) {
    this.avgDosReqUriRlDropBad = avgDosReqUriRlDropBad;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dos attack  requests dropped due to bad url rate limit.
   * @return avgDosReqUriScanBadRlDrop
   */
  public Float getAvgDosReqUriScanBadRlDrop() {
    return avgDosReqUriScanBadRlDrop;
  }

  /**
   * This is the setter method to the attribute.
   * Dos attack  requests dropped due to bad url rate limit.
   * @param avgDosReqUriScanBadRlDrop set the avgDosReqUriScanBadRlDrop.
   */
  public void setAvgDosReqUriScanBadRlDrop(Float  avgDosReqUriScanBadRlDrop) {
    this.avgDosReqUriScanBadRlDrop = avgDosReqUriScanBadRlDrop;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dos attack  requests dropped due to unknown url rate limit.
   * @return avgDosReqUriScanUnknownRlDrop
   */
  public Float getAvgDosReqUriScanUnknownRlDrop() {
    return avgDosReqUriScanUnknownRlDrop;
  }

  /**
   * This is the setter method to the attribute.
   * Dos attack  requests dropped due to unknown url rate limit.
   * @param avgDosReqUriScanUnknownRlDrop set the avgDosReqUriScanUnknownRlDrop.
   */
  public void setAvgDosReqUriScanUnknownRlDrop(Float  avgDosReqUriScanUnknownRlDrop) {
    this.avgDosReqUriScanUnknownRlDrop = avgDosReqUriScanUnknownRlDrop;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average rate of bytes received per second related to ddos attack.
   * @return avgDosRxBytes
   */
  public Float getAvgDosRxBytes() {
    return avgDosRxBytes;
  }

  /**
   * This is the setter method to the attribute.
   * Average rate of bytes received per second related to ddos attack.
   * @param avgDosRxBytes set the avgDosRxBytes.
   */
  public void setAvgDosRxBytes(Float  avgDosRxBytes) {
    this.avgDosRxBytes = avgDosRxBytes;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dos attack  slow uri.
   * @return avgDosSlowUri
   */
  public Float getAvgDosSlowUri() {
    return avgDosSlowUri;
  }

  /**
   * This is the setter method to the attribute.
   * Dos attack  slow uri.
   * @param avgDosSlowUri set the avgDosSlowUri.
   */
  public void setAvgDosSlowUri(Float  avgDosSlowUri) {
    this.avgDosSlowUri = avgDosSlowUri;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dos attack  rate of small window stresses.
   * @return avgDosSmallWindowStress
   */
  public Float getAvgDosSmallWindowStress() {
    return avgDosSmallWindowStress;
  }

  /**
   * This is the setter method to the attribute.
   * Dos attack  rate of small window stresses.
   * @param avgDosSmallWindowStress set the avgDosSmallWindowStress.
   */
  public void setAvgDosSmallWindowStress(Float  avgDosSmallWindowStress) {
    this.avgDosSmallWindowStress = avgDosSmallWindowStress;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dos attack  rate of http ssl errors.
   * @return avgDosSslError
   */
  public Float getAvgDosSslError() {
    return avgDosSslError;
  }

  /**
   * This is the setter method to the attribute.
   * Dos attack  rate of http ssl errors.
   * @param avgDosSslError set the avgDosSslError.
   */
  public void setAvgDosSslError(Float  avgDosSslError) {
    this.avgDosSslError = avgDosSslError;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dos attack  rate of syn floods.
   * @return avgDosSynFlood
   */
  public Float getAvgDosSynFlood() {
    return avgDosSynFlood;
  }

  /**
   * This is the setter method to the attribute.
   * Dos attack  rate of syn floods.
   * @param avgDosSynFlood set the avgDosSynFlood.
   */
  public void setAvgDosSynFlood(Float  avgDosSynFlood) {
    this.avgDosSynFlood = avgDosSynFlood;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of request used for l7 dos requests normalization.
   * @return avgDosTotalReq
   */
  public Float getAvgDosTotalReq() {
    return avgDosTotalReq;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of request used for l7 dos requests normalization.
   * @param avgDosTotalReq set the avgDosTotalReq.
   */
  public void setAvgDosTotalReq(Float  avgDosTotalReq) {
    this.avgDosTotalReq = avgDosTotalReq;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average rate of bytes transmitted per second related to ddos attack.
   * @return avgDosTxBytes
   */
  public Float getAvgDosTxBytes() {
    return avgDosTxBytes;
  }

  /**
   * This is the setter method to the attribute.
   * Average rate of bytes transmitted per second related to ddos attack.
   * @param avgDosTxBytes set the avgDosTxBytes.
   */
  public void setAvgDosTxBytes(Float  avgDosTxBytes) {
    this.avgDosTxBytes = avgDosTxBytes;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dos attack  rate of zero window stresses.
   * @return avgDosZeroWindowStress
   */
  public Float getAvgDosZeroWindowStress() {
    return avgDosZeroWindowStress;
  }

  /**
   * This is the setter method to the attribute.
   * Dos attack  rate of zero window stresses.
   * @param avgDosZeroWindowStress set the avgDosZeroWindowStress.
   */
  public void setAvgDosZeroWindowStress(Float  avgDosZeroWindowStress) {
    this.avgDosZeroWindowStress = avgDosZeroWindowStress;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Rate of total errored connections per second.
   * @return avgErroredConnections
   */
  public Float getAvgErroredConnections() {
    return avgErroredConnections;
  }

  /**
   * This is the setter method to the attribute.
   * Rate of total errored connections per second.
   * @param avgErroredConnections set the avgErroredConnections.
   */
  public void setAvgErroredConnections(Float  avgErroredConnections) {
    this.avgErroredConnections = avgErroredConnections;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average l4 connection duration which does not include client rtt.
   * @return avgL4ClientLatency
   */
  public Float getAvgL4ClientLatency() {
    return avgL4ClientLatency;
  }

  /**
   * This is the setter method to the attribute.
   * Average l4 connection duration which does not include client rtt.
   * @param avgL4ClientLatency set the avgL4ClientLatency.
   */
  public void setAvgL4ClientLatency(Float  avgL4ClientLatency) {
    this.avgL4ClientLatency = avgL4ClientLatency;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Rate of lossy connections per second.
   * @return avgLossyConnections
   */
  public Float getAvgLossyConnections() {
    return avgLossyConnections;
  }

  /**
   * This is the setter method to the attribute.
   * Rate of lossy connections per second.
   * @param avgLossyConnections set the avgLossyConnections.
   */
  public void setAvgLossyConnections(Float  avgLossyConnections) {
    this.avgLossyConnections = avgLossyConnections;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Averaged rate of lossy request per second.
   * @return avgLossyReq
   */
  public Float getAvgLossyReq() {
    return avgLossyReq;
  }

  /**
   * This is the setter method to the attribute.
   * Averaged rate of lossy request per second.
   * @param avgLossyReq set the avgLossyReq.
   */
  public void setAvgLossyReq(Float  avgLossyReq) {
    this.avgLossyReq = avgLossyReq;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Number of network ddos attacks occurring.
   * @return avgNetworkDosAttacks
   */
  public Float getAvgNetworkDosAttacks() {
    return avgNetworkDosAttacks;
  }

  /**
   * This is the setter method to the attribute.
   * Number of network ddos attacks occurring.
   * @param avgNetworkDosAttacks set the avgNetworkDosAttacks.
   */
  public void setAvgNetworkDosAttacks(Float  avgNetworkDosAttacks) {
    this.avgNetworkDosAttacks = avgNetworkDosAttacks;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Averaged rate of new client connections per second.
   * @return avgNewEstablishedConns
   */
  public Float getAvgNewEstablishedConns() {
    return avgNewEstablishedConns;
  }

  /**
   * This is the setter method to the attribute.
   * Averaged rate of new client connections per second.
   * @param avgNewEstablishedConns set the avgNewEstablishedConns.
   */
  public void setAvgNewEstablishedConns(Float  avgNewEstablishedConns) {
    this.avgNewEstablishedConns = avgNewEstablishedConns;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Averaged rate of dropped packets per second due to policy.
   * @return avgPktsPolicyDrops
   */
  public Float getAvgPktsPolicyDrops() {
    return avgPktsPolicyDrops;
  }

  /**
   * This is the setter method to the attribute.
   * Averaged rate of dropped packets per second due to policy.
   * @param avgPktsPolicyDrops set the avgPktsPolicyDrops.
   */
  public void setAvgPktsPolicyDrops(Float  avgPktsPolicyDrops) {
    this.avgPktsPolicyDrops = avgPktsPolicyDrops;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Rate of total connections dropped due to vs policy per second.
   * It includes drops due to rate limits, security policy drops, connection limits etc.
   * @return avgPolicyDrops
   */
  public Float getAvgPolicyDrops() {
    return avgPolicyDrops;
  }

  /**
   * This is the setter method to the attribute.
   * Rate of total connections dropped due to vs policy per second.
   * It includes drops due to rate limits, security policy drops, connection limits etc.
   * @param avgPolicyDrops set the avgPolicyDrops.
   */
  public void setAvgPolicyDrops(Float  avgPolicyDrops) {
    this.avgPolicyDrops = avgPolicyDrops;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average rate of bytes received per second.
   * @return avgRxBytes
   */
  public Float getAvgRxBytes() {
    return avgRxBytes;
  }

  /**
   * This is the setter method to the attribute.
   * Average rate of bytes received per second.
   * @param avgRxBytes set the avgRxBytes.
   */
  public void setAvgRxBytes(Float  avgRxBytes) {
    this.avgRxBytes = avgRxBytes;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average rate of received bytes dropped per second.
   * @return avgRxBytesDropped
   */
  public Float getAvgRxBytesDropped() {
    return avgRxBytesDropped;
  }

  /**
   * This is the setter method to the attribute.
   * Average rate of received bytes dropped per second.
   * @param avgRxBytesDropped set the avgRxBytesDropped.
   */
  public void setAvgRxBytesDropped(Float  avgRxBytesDropped) {
    this.avgRxBytesDropped = avgRxBytesDropped;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average rate of packets received per second.
   * @return avgRxPkts
   */
  public Float getAvgRxPkts() {
    return avgRxPkts;
  }

  /**
   * This is the setter method to the attribute.
   * Average rate of packets received per second.
   * @param avgRxPkts set the avgRxPkts.
   */
  public void setAvgRxPkts(Float  avgRxPkts) {
    this.avgRxPkts = avgRxPkts;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average rate of received packets dropped per second.
   * @return avgRxPktsDropped
   */
  public Float getAvgRxPktsDropped() {
    return avgRxPktsDropped;
  }

  /**
   * This is the setter method to the attribute.
   * Average rate of received packets dropped per second.
   * @param avgRxPktsDropped set the avgRxPktsDropped.
   */
  public void setAvgRxPktsDropped(Float  avgRxPktsDropped) {
    this.avgRxPktsDropped = avgRxPktsDropped;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total syncs sent across all connections.
   * @return avgSyns
   */
  public Float getAvgSyns() {
    return avgSyns;
  }

  /**
   * This is the setter method to the attribute.
   * Total syncs sent across all connections.
   * @param avgSyns set the avgSyns.
   */
  public void setAvgSyns(Float  avgSyns) {
    this.avgSyns = avgSyns;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Averaged rate bytes dropped per second.
   * @return avgTotalConnections
   */
  public Float getAvgTotalConnections() {
    return avgTotalConnections;
  }

  /**
   * This is the setter method to the attribute.
   * Averaged rate bytes dropped per second.
   * @param avgTotalConnections set the avgTotalConnections.
   */
  public void setAvgTotalConnections(Float  avgTotalConnections) {
    this.avgTotalConnections = avgTotalConnections;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average network round trip time between client and virtual service.
   * @return avgTotalRtt
   */
  public Float getAvgTotalRtt() {
    return avgTotalRtt;
  }

  /**
   * This is the setter method to the attribute.
   * Average network round trip time between client and virtual service.
   * @param avgTotalRtt set the avgTotalRtt.
   */
  public void setAvgTotalRtt(Float  avgTotalRtt) {
    this.avgTotalRtt = avgTotalRtt;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average rate of bytes transmitted per second.
   * @return avgTxBytes
   */
  public Float getAvgTxBytes() {
    return avgTxBytes;
  }

  /**
   * This is the setter method to the attribute.
   * Average rate of bytes transmitted per second.
   * @param avgTxBytes set the avgTxBytes.
   */
  public void setAvgTxBytes(Float  avgTxBytes) {
    this.avgTxBytes = avgTxBytes;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average rate of packets transmitted per second.
   * @return avgTxPkts
   */
  public Float getAvgTxPkts() {
    return avgTxPkts;
  }

  /**
   * This is the setter method to the attribute.
   * Average rate of packets transmitted per second.
   * @param avgTxPkts set the avgTxPkts.
   */
  public void setAvgTxPkts(Float  avgTxPkts) {
    this.avgTxPkts = avgTxPkts;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Max number of ses.
   * @return maxNumActiveSe
   */
  public Float getMaxNumActiveSe() {
    return maxNumActiveSe;
  }

  /**
   * This is the setter method to the attribute.
   * Max number of ses.
   * @param maxNumActiveSe set the maxNumActiveSe.
   */
  public void setMaxNumActiveSe(Float  maxNumActiveSe) {
    this.maxNumActiveSe = maxNumActiveSe;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Max number of open connections.
   * @return maxOpenConns
   */
  public Float getMaxOpenConns() {
    return maxOpenConns;
  }

  /**
   * This is the setter method to the attribute.
   * Max number of open connections.
   * @param maxOpenConns set the maxOpenConns.
   */
  public void setMaxOpenConns(Float  maxOpenConns) {
    this.maxOpenConns = maxOpenConns;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of received bytes.
   * @return maxRxBytesAbsolute
   */
  public Float getMaxRxBytesAbsolute() {
    return maxRxBytesAbsolute;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of received bytes.
   * @param maxRxBytesAbsolute set the maxRxBytesAbsolute.
   */
  public void setMaxRxBytesAbsolute(Float  maxRxBytesAbsolute) {
    this.maxRxBytesAbsolute = maxRxBytesAbsolute;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of received frames.
   * @return maxRxPktsAbsolute
   */
  public Float getMaxRxPktsAbsolute() {
    return maxRxPktsAbsolute;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of received frames.
   * @param maxRxPktsAbsolute set the maxRxPktsAbsolute.
   */
  public void setMaxRxPktsAbsolute(Float  maxRxPktsAbsolute) {
    this.maxRxPktsAbsolute = maxRxPktsAbsolute;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of transmitted bytes.
   * @return maxTxBytesAbsolute
   */
  public Float getMaxTxBytesAbsolute() {
    return maxTxBytesAbsolute;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of transmitted bytes.
   * @param maxTxBytesAbsolute set the maxTxBytesAbsolute.
   */
  public void setMaxTxBytesAbsolute(Float  maxTxBytesAbsolute) {
    this.maxTxBytesAbsolute = maxTxBytesAbsolute;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of transmitted frames.
   * @return maxTxPktsAbsolute
   */
  public Float getMaxTxPktsAbsolute() {
    return maxTxPktsAbsolute;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of transmitted frames.
   * @param maxTxPktsAbsolute set the maxTxPktsAbsolute.
   */
  public void setMaxTxPktsAbsolute(Float  maxTxPktsAbsolute) {
    this.maxTxPktsAbsolute = maxTxPktsAbsolute;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property node_obj_id of obj type vserverl4metricsobj field type str  type string.
   * @return nodeObjId
   */
  public String getNodeObjId() {
    return nodeObjId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property node_obj_id of obj type vserverl4metricsobj field type str  type string.
   * @param nodeObjId set the nodeObjId.
   */
  public void setNodeObjId(String  nodeObjId) {
    this.nodeObjId = nodeObjId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Fraction of l7 requests owing to dos.
   * @return pctApplicationDosAttacks
   */
  public Float getPctApplicationDosAttacks() {
    return pctApplicationDosAttacks;
  }

  /**
   * This is the setter method to the attribute.
   * Fraction of l7 requests owing to dos.
   * @param pctApplicationDosAttacks set the pctApplicationDosAttacks.
   */
  public void setPctApplicationDosAttacks(Float  pctApplicationDosAttacks) {
    this.pctApplicationDosAttacks = pctApplicationDosAttacks;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Percent of l4 connection dropped and lossy for virtual service.
   * @return pctConnectionErrors
   */
  public Float getPctConnectionErrors() {
    return pctConnectionErrors;
  }

  /**
   * This is the setter method to the attribute.
   * Percent of l4 connection dropped and lossy for virtual service.
   * @param pctConnectionErrors set the pctConnectionErrors.
   */
  public void setPctConnectionErrors(Float  pctConnectionErrors) {
    this.pctConnectionErrors = pctConnectionErrors;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Fraction of l4 connections owing to dos.
   * @return pctConnectionsDosAttacks
   */
  public Float getPctConnectionsDosAttacks() {
    return pctConnectionsDosAttacks;
  }

  /**
   * This is the setter method to the attribute.
   * Fraction of l4 connections owing to dos.
   * @param pctConnectionsDosAttacks set the pctConnectionsDosAttacks.
   */
  public void setPctConnectionsDosAttacks(Float  pctConnectionsDosAttacks) {
    this.pctConnectionsDosAttacks = pctConnectionsDosAttacks;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dos bandwidth percentage.
   * @return pctDosBandwidth
   */
  public Float getPctDosBandwidth() {
    return pctDosBandwidth;
  }

  /**
   * This is the setter method to the attribute.
   * Dos bandwidth percentage.
   * @param pctDosBandwidth set the pctDosBandwidth.
   */
  public void setPctDosBandwidth(Float  pctDosBandwidth) {
    this.pctDosBandwidth = pctDosBandwidth;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Percentage of received bytes as part of a dos attack.
   * @return pctDosRxBytes
   */
  public Float getPctDosRxBytes() {
    return pctDosRxBytes;
  }

  /**
   * This is the setter method to the attribute.
   * Percentage of received bytes as part of a dos attack.
   * @param pctDosRxBytes set the pctDosRxBytes.
   */
  public void setPctDosRxBytes(Float  pctDosRxBytes) {
    this.pctDosRxBytes = pctDosRxBytes;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Deprecated.
   * @return pctNetworkDosAttacks
   */
  public Float getPctNetworkDosAttacks() {
    return pctNetworkDosAttacks;
  }

  /**
   * This is the setter method to the attribute.
   * Deprecated.
   * @param pctNetworkDosAttacks set the pctNetworkDosAttacks.
   */
  public void setPctNetworkDosAttacks(Float  pctNetworkDosAttacks) {
    this.pctNetworkDosAttacks = pctNetworkDosAttacks;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Fraction of packets owing to dos.
   * @return pctPktsDosAttacks
   */
  public Float getPctPktsDosAttacks() {
    return pctPktsDosAttacks;
  }

  /**
   * This is the setter method to the attribute.
   * Fraction of packets owing to dos.
   * @param pctPktsDosAttacks set the pctPktsDosAttacks.
   */
  public void setPctPktsDosAttacks(Float  pctPktsDosAttacks) {
    this.pctPktsDosAttacks = pctPktsDosAttacks;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Fraction of l4 requests dropped owing to policy.
   * @return pctPolicyDrops
   */
  public Float getPctPolicyDrops() {
    return pctPolicyDrops;
  }

  /**
   * This is the setter method to the attribute.
   * Fraction of l4 requests dropped owing to policy.
   * @param pctPolicyDrops set the pctPolicyDrops.
   */
  public void setPctPolicyDrops(Float  pctPolicyDrops) {
    this.pctPolicyDrops = pctPolicyDrops;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total duration across all connections.
   * @return sumConnDuration
   */
  public Float getSumConnDuration() {
    return sumConnDuration;
  }

  /**
   * This is the setter method to the attribute.
   * Total duration across all connections.
   * @param sumConnDuration set the sumConnDuration.
   */
  public void setSumConnDuration(Float  sumConnDuration) {
    this.sumConnDuration = sumConnDuration;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of connection dropped due to vserver connection limit.
   * @return sumConnectionDroppedUserLimit
   */
  public Float getSumConnectionDroppedUserLimit() {
    return sumConnectionDroppedUserLimit;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of connection dropped due to vserver connection limit.
   * @param sumConnectionDroppedUserLimit set the sumConnectionDroppedUserLimit.
   */
  public void setSumConnectionDroppedUserLimit(Float  sumConnectionDroppedUserLimit) {
    this.sumConnectionDroppedUserLimit = sumConnectionDroppedUserLimit;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of client network connections that were lossy or dropped.
   * @return sumConnectionErrors
   */
  public Float getSumConnectionErrors() {
    return sumConnectionErrors;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of client network connections that were lossy or dropped.
   * @param sumConnectionErrors set the sumConnectionErrors.
   */
  public void setSumConnectionErrors(Float  sumConnectionErrors) {
    this.sumConnectionErrors = sumConnectionErrors;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total connections dropped including failed.
   * @return sumConnectionsDropped
   */
  public Float getSumConnectionsDropped() {
    return sumConnectionsDropped;
  }

  /**
   * This is the setter method to the attribute.
   * Total connections dropped including failed.
   * @param sumConnectionsDropped set the sumConnectionsDropped.
   */
  public void setSumConnectionsDropped(Float  sumConnectionsDropped) {
    this.sumConnectionsDropped = sumConnectionsDropped;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total duplicate ack retransmits across all connections.
   * @return sumDupAckRetransmits
   */
  public Float getSumDupAckRetransmits() {
    return sumDupAckRetransmits;
  }

  /**
   * This is the setter method to the attribute.
   * Total duplicate ack retransmits across all connections.
   * @param sumDupAckRetransmits set the sumDupAckRetransmits.
   */
  public void setSumDupAckRetransmits(Float  sumDupAckRetransmits) {
    this.sumDupAckRetransmits = sumDupAckRetransmits;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Sum of end to end network rtt experienced by end clients.
   * Higher value would increase response times experienced by clients.
   * @return sumEndToEndRtt
   */
  public Float getSumEndToEndRtt() {
    return sumEndToEndRtt;
  }

  /**
   * This is the setter method to the attribute.
   * Sum of end to end network rtt experienced by end clients.
   * Higher value would increase response times experienced by clients.
   * @param sumEndToEndRtt set the sumEndToEndRtt.
   */
  public void setSumEndToEndRtt(Float  sumEndToEndRtt) {
    this.sumEndToEndRtt = sumEndToEndRtt;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total connections that have rtt values from 0 to rtt threshold.
   * @return sumEndToEndRttBucket1
   */
  public Float getSumEndToEndRttBucket1() {
    return sumEndToEndRttBucket1;
  }

  /**
   * This is the setter method to the attribute.
   * Total connections that have rtt values from 0 to rtt threshold.
   * @param sumEndToEndRttBucket1 set the sumEndToEndRttBucket1.
   */
  public void setSumEndToEndRttBucket1(Float  sumEndToEndRttBucket1) {
    this.sumEndToEndRttBucket1 = sumEndToEndRttBucket1;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total connections that have rtt values rtt threshold and above.
   * @return sumEndToEndRttBucket2
   */
  public Float getSumEndToEndRttBucket2() {
    return sumEndToEndRttBucket2;
  }

  /**
   * This is the setter method to the attribute.
   * Total connections that have rtt values rtt threshold and above.
   * @param sumEndToEndRttBucket2 set the sumEndToEndRttBucket2.
   */
  public void setSumEndToEndRttBucket2(Float  sumEndToEndRttBucket2) {
    this.sumEndToEndRttBucket2 = sumEndToEndRttBucket2;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of finished connections.
   * @return sumFinishedConns
   */
  public Float getSumFinishedConns() {
    return sumFinishedConns;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of finished connections.
   * @param sumFinishedConns set the sumFinishedConns.
   */
  public void setSumFinishedConns(Float  sumFinishedConns) {
    this.sumFinishedConns = sumFinishedConns;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total connections that were lossy due to high packet retransmissions.
   * @return sumLossyConnections
   */
  public Float getSumLossyConnections() {
    return sumLossyConnections;
  }

  /**
   * This is the setter method to the attribute.
   * Total connections that were lossy due to high packet retransmissions.
   * @param sumLossyConnections set the sumLossyConnections.
   */
  public void setSumLossyConnections(Float  sumLossyConnections) {
    this.sumLossyConnections = sumLossyConnections;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total requests that were lossy due to high packet retransmissions.
   * @return sumLossyReq
   */
  public Float getSumLossyReq() {
    return sumLossyReq;
  }

  /**
   * This is the setter method to the attribute.
   * Total requests that were lossy due to high packet retransmissions.
   * @param sumLossyReq set the sumLossyReq.
   */
  public void setSumLossyReq(Float  sumLossyReq) {
    this.sumLossyReq = sumLossyReq;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total out of order packets across all connections.
   * @return sumOutOfOrders
   */
  public Float getSumOutOfOrders() {
    return sumOutOfOrders;
  }

  /**
   * This is the setter method to the attribute.
   * Total out of order packets across all connections.
   * @param sumOutOfOrders set the sumOutOfOrders.
   */
  public void setSumOutOfOrders(Float  sumOutOfOrders) {
    this.sumOutOfOrders = sumOutOfOrders;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of packets dropped due to vserver bandwidth limit.
   * @return sumPacketDroppedUserBandwidthLimit
   */
  public Float getSumPacketDroppedUserBandwidthLimit() {
    return sumPacketDroppedUserBandwidthLimit;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of packets dropped due to vserver bandwidth limit.
   * @param sumPacketDroppedUserBandwidthLimit set the sumPacketDroppedUserBandwidthLimit.
   */
  public void setSumPacketDroppedUserBandwidthLimit(Float  sumPacketDroppedUserBandwidthLimit) {
    this.sumPacketDroppedUserBandwidthLimit = sumPacketDroppedUserBandwidthLimit;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number connections used for rtt.
   * @return sumRttValidConnections
   */
  public Float getSumRttValidConnections() {
    return sumRttValidConnections;
  }

  /**
   * This is the setter method to the attribute.
   * Total number connections used for rtt.
   * @param sumRttValidConnections set the sumRttValidConnections.
   */
  public void setSumRttValidConnections(Float  sumRttValidConnections) {
    this.sumRttValidConnections = sumRttValidConnections;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total sack retransmits across all connections.
   * @return sumSackRetransmits
   */
  public Float getSumSackRetransmits() {
    return sumSackRetransmits;
  }

  /**
   * This is the setter method to the attribute.
   * Total sack retransmits across all connections.
   * @param sumSackRetransmits set the sumSackRetransmits.
   */
  public void setSumSackRetransmits(Float  sumSackRetransmits) {
    this.sumSackRetransmits = sumSackRetransmits;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of connections with server flow control condition.
   * @return sumServerFlowControl
   */
  public Float getSumServerFlowControl() {
    return sumServerFlowControl;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of connections with server flow control condition.
   * @param sumServerFlowControl set the sumServerFlowControl.
   */
  public void setSumServerFlowControl(Float  sumServerFlowControl) {
    this.sumServerFlowControl = sumServerFlowControl;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total connection timeouts in the interval.
   * @return sumTimeoutRetransmits
   */
  public Float getSumTimeoutRetransmits() {
    return sumTimeoutRetransmits;
  }

  /**
   * This is the setter method to the attribute.
   * Total connection timeouts in the interval.
   * @param sumTimeoutRetransmits set the sumTimeoutRetransmits.
   */
  public void setSumTimeoutRetransmits(Float  sumTimeoutRetransmits) {
    this.sumTimeoutRetransmits = sumTimeoutRetransmits;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of zero window size events across all connections.
   * @return sumZeroWindowSizeEvents
   */
  public Float getSumZeroWindowSizeEvents() {
    return sumZeroWindowSizeEvents;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of zero window size events across all connections.
   * @param sumZeroWindowSizeEvents set the sumZeroWindowSizeEvents.
   */
  public void setSumZeroWindowSizeEvents(Float  sumZeroWindowSizeEvents) {
    this.sumZeroWindowSizeEvents = sumZeroWindowSizeEvents;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VserverL4MetricsObj objVserverL4MetricsObj = (VserverL4MetricsObj) o;
  return   Objects.equals(this.sumTimeoutRetransmits, objVserverL4MetricsObj.sumTimeoutRetransmits)&&
  Objects.equals(this.maxOpenConns, objVserverL4MetricsObj.maxOpenConns)&&
  Objects.equals(this.avgBandwidth, objVserverL4MetricsObj.avgBandwidth)&&
  Objects.equals(this.sumLossyConnections, objVserverL4MetricsObj.sumLossyConnections)&&
  Objects.equals(this.avgCompleteConns, objVserverL4MetricsObj.avgCompleteConns)&&
  Objects.equals(this.avgNetworkDosAttacks, objVserverL4MetricsObj.avgNetworkDosAttacks)&&
  Objects.equals(this.avgConnectionsDropped, objVserverL4MetricsObj.avgConnectionsDropped)&&
  Objects.equals(this.avgDosHttpError, objVserverL4MetricsObj.avgDosHttpError)&&
  Objects.equals(this.avgDosConnRlDrop, objVserverL4MetricsObj.avgDosConnRlDrop)&&
  Objects.equals(this.avgDosReqIpRlDrop, objVserverL4MetricsObj.avgDosReqIpRlDrop)&&
  Objects.equals(this.pctNetworkDosAttacks, objVserverL4MetricsObj.pctNetworkDosAttacks)&&
  Objects.equals(this.avgDosReqIpRlDropBad, objVserverL4MetricsObj.avgDosReqIpRlDropBad)&&
  Objects.equals(this.avgDosConnIpRlDrop, objVserverL4MetricsObj.avgDosConnIpRlDrop)&&
  Objects.equals(this.sumEndToEndRttBucket1, objVserverL4MetricsObj.sumEndToEndRttBucket1)&&
  Objects.equals(this.sumEndToEndRttBucket2, objVserverL4MetricsObj.sumEndToEndRttBucket2)&&
  Objects.equals(this.avgApplicationDosAttacks, objVserverL4MetricsObj.avgApplicationDosAttacks)&&
  Objects.equals(this.sumConnectionsDropped, objVserverL4MetricsObj.sumConnectionsDropped)&&
  Objects.equals(this.sumZeroWindowSizeEvents, objVserverL4MetricsObj.sumZeroWindowSizeEvents)&&
  Objects.equals(this.maxTxBytesAbsolute, objVserverL4MetricsObj.maxTxBytesAbsolute)&&
  Objects.equals(this.avgDosMalformedFlood, objVserverL4MetricsObj.avgDosMalformedFlood)&&
  Objects.equals(this.nodeObjId, objVserverL4MetricsObj.nodeObjId)&&
  Objects.equals(this.pctDosBandwidth, objVserverL4MetricsObj.pctDosBandwidth)&&
  Objects.equals(this.avgDosReqUriScanUnknownRlDrop, objVserverL4MetricsObj.avgDosReqUriScanUnknownRlDrop)&&
  Objects.equals(this.avgRxPkts, objVserverL4MetricsObj.avgRxPkts)&&
  Objects.equals(this.maxRxPktsAbsolute, objVserverL4MetricsObj.maxRxPktsAbsolute)&&
  Objects.equals(this.avgDosSmallWindowStress, objVserverL4MetricsObj.avgDosSmallWindowStress)&&
  Objects.equals(this.avgNewEstablishedConns, objVserverL4MetricsObj.avgNewEstablishedConns)&&
  Objects.equals(this.avgDosHttpTimeout, objVserverL4MetricsObj.avgDosHttpTimeout)&&
  Objects.equals(this.avgDosReqHdrRlDrop, objVserverL4MetricsObj.avgDosReqHdrRlDrop)&&
  Objects.equals(this.avgLossyReq, objVserverL4MetricsObj.avgLossyReq)&&
  Objects.equals(this.pctConnectionsDosAttacks, objVserverL4MetricsObj.pctConnectionsDosAttacks)&&
  Objects.equals(this.avgBytesPolicyDrops, objVserverL4MetricsObj.avgBytesPolicyDrops)&&
  Objects.equals(this.pctPolicyDrops, objVserverL4MetricsObj.pctPolicyDrops)&&
  Objects.equals(this.sumDupAckRetransmits, objVserverL4MetricsObj.sumDupAckRetransmits)&&
  Objects.equals(this.maxTxPktsAbsolute, objVserverL4MetricsObj.maxTxPktsAbsolute)&&
  Objects.equals(this.avgDosFakeSession, objVserverL4MetricsObj.avgDosFakeSession)&&
  Objects.equals(this.avgDosAttacks, objVserverL4MetricsObj.avgDosAttacks)&&
  Objects.equals(this.pctConnectionErrors, objVserverL4MetricsObj.pctConnectionErrors)&&
  Objects.equals(this.avgDosTxBytes, objVserverL4MetricsObj.avgDosTxBytes)&&
  Objects.equals(this.avgDosReqIpScanUnknownRlDrop, objVserverL4MetricsObj.avgDosReqIpScanUnknownRlDrop)&&
  Objects.equals(this.avgDosSlowUri, objVserverL4MetricsObj.avgDosSlowUri)&&
  Objects.equals(this.avgDosAppError, objVserverL4MetricsObj.avgDosAppError)&&
  Objects.equals(this.avgTxPkts, objVserverL4MetricsObj.avgTxPkts)&&
  Objects.equals(this.sumOutOfOrders, objVserverL4MetricsObj.sumOutOfOrders)&&
  Objects.equals(this.avgDosHttpAbort, objVserverL4MetricsObj.avgDosHttpAbort)&&
  Objects.equals(this.avgDosTotalReq, objVserverL4MetricsObj.avgDosTotalReq)&&
  Objects.equals(this.avgDosZeroWindowStress, objVserverL4MetricsObj.avgDosZeroWindowStress)&&
  Objects.equals(this.pctDosRxBytes, objVserverL4MetricsObj.pctDosRxBytes)&&
  Objects.equals(this.avgTotalConnections, objVserverL4MetricsObj.avgTotalConnections)&&
  Objects.equals(this.maxRxBytesAbsolute, objVserverL4MetricsObj.maxRxBytesAbsolute)&&
  Objects.equals(this.avgRxBytes, objVserverL4MetricsObj.avgRxBytes)&&
  Objects.equals(this.avgDosBadRstFlood, objVserverL4MetricsObj.avgDosBadRstFlood)&&
  Objects.equals(this.apdexrtt, objVserverL4MetricsObj.apdexrtt)&&
  Objects.equals(this.avgDosNonSynFlood, objVserverL4MetricsObj.avgDosNonSynFlood)&&
  Objects.equals(this.avgDosReqUriRlDrop, objVserverL4MetricsObj.avgDosReqUriRlDrop)&&
  Objects.equals(this.avgL4ClientLatency, objVserverL4MetricsObj.avgL4ClientLatency)&&
  Objects.equals(this.avgSyns, objVserverL4MetricsObj.avgSyns)&&
  Objects.equals(this.avgDosReq, objVserverL4MetricsObj.avgDosReq)&&
  Objects.equals(this.sumServerFlowControl, objVserverL4MetricsObj.sumServerFlowControl)&&
  Objects.equals(this.avgDosBandwidth, objVserverL4MetricsObj.avgDosBandwidth)&&
  Objects.equals(this.avgPktsPolicyDrops, objVserverL4MetricsObj.avgPktsPolicyDrops)&&
  Objects.equals(this.avgDosSynFlood, objVserverL4MetricsObj.avgDosSynFlood)&&
  Objects.equals(this.avgErroredConnections, objVserverL4MetricsObj.avgErroredConnections)&&
  Objects.equals(this.apdexc, objVserverL4MetricsObj.apdexc)&&
  Objects.equals(this.avgDosReqUriScanBadRlDrop, objVserverL4MetricsObj.avgDosReqUriScanBadRlDrop)&&
  Objects.equals(this.sumSackRetransmits, objVserverL4MetricsObj.sumSackRetransmits)&&
  Objects.equals(this.avgDosRxBytes, objVserverL4MetricsObj.avgDosRxBytes)&&
  Objects.equals(this.maxNumActiveSe, objVserverL4MetricsObj.maxNumActiveSe)&&
  Objects.equals(this.avgDosSslError, objVserverL4MetricsObj.avgDosSslError)&&
  Objects.equals(this.sumPacketDroppedUserBandwidthLimit, objVserverL4MetricsObj.sumPacketDroppedUserBandwidthLimit)&&
  Objects.equals(this.avgTxBytes, objVserverL4MetricsObj.avgTxBytes)&&
  Objects.equals(this.avgDosConn, objVserverL4MetricsObj.avgDosConn)&&
  Objects.equals(this.avgRxPktsDropped, objVserverL4MetricsObj.avgRxPktsDropped)&&
  Objects.equals(this.avgDosReqCustomRlDrop, objVserverL4MetricsObj.avgDosReqCustomRlDrop)&&
  Objects.equals(this.avgDosReqIpUriRlDrop, objVserverL4MetricsObj.avgDosReqIpUriRlDrop)&&
  Objects.equals(this.sumRttValidConnections, objVserverL4MetricsObj.sumRttValidConnections)&&
  Objects.equals(this.avgDosReqIpScanBadRlDrop, objVserverL4MetricsObj.avgDosReqIpScanBadRlDrop)&&
  Objects.equals(this.avgRxBytesDropped, objVserverL4MetricsObj.avgRxBytesDropped)&&
  Objects.equals(this.sumLossyReq, objVserverL4MetricsObj.sumLossyReq)&&
  Objects.equals(this.avgDosReqRlDrop, objVserverL4MetricsObj.avgDosReqRlDrop)&&
  Objects.equals(this.avgDosReqCookieRlDrop, objVserverL4MetricsObj.avgDosReqCookieRlDrop)&&
  Objects.equals(this.avgDosReqIpUriRlDropBad, objVserverL4MetricsObj.avgDosReqIpUriRlDropBad)&&
  Objects.equals(this.sumEndToEndRtt, objVserverL4MetricsObj.sumEndToEndRtt)&&
  Objects.equals(this.sumConnectionErrors, objVserverL4MetricsObj.sumConnectionErrors)&&
  Objects.equals(this.sumConnDuration, objVserverL4MetricsObj.sumConnDuration)&&
  Objects.equals(this.pctPktsDosAttacks, objVserverL4MetricsObj.pctPktsDosAttacks)&&
  Objects.equals(this.pctApplicationDosAttacks, objVserverL4MetricsObj.pctApplicationDosAttacks)&&
  Objects.equals(this.avgDosReqUriRlDropBad, objVserverL4MetricsObj.avgDosReqUriRlDropBad)&&
  Objects.equals(this.sumFinishedConns, objVserverL4MetricsObj.sumFinishedConns)&&
  Objects.equals(this.avgLossyConnections, objVserverL4MetricsObj.avgLossyConnections)&&
  Objects.equals(this.avgTotalRtt, objVserverL4MetricsObj.avgTotalRtt)&&
  Objects.equals(this.sumConnectionDroppedUserLimit, objVserverL4MetricsObj.sumConnectionDroppedUserLimit)&&
  Objects.equals(this.avgPolicyDrops, objVserverL4MetricsObj.avgPolicyDrops);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VserverL4MetricsObj {\n");
      sb.append("    apdexc: ").append(toIndentedString(apdexc)).append("\n");
        sb.append("    apdexrtt: ").append(toIndentedString(apdexrtt)).append("\n");
        sb.append("    avgApplicationDosAttacks: ").append(toIndentedString(avgApplicationDosAttacks)).append("\n");
        sb.append("    avgBandwidth: ").append(toIndentedString(avgBandwidth)).append("\n");
        sb.append("    avgBytesPolicyDrops: ").append(toIndentedString(avgBytesPolicyDrops)).append("\n");
        sb.append("    avgCompleteConns: ").append(toIndentedString(avgCompleteConns)).append("\n");
        sb.append("    avgConnectionsDropped: ").append(toIndentedString(avgConnectionsDropped)).append("\n");
        sb.append("    avgDosAppError: ").append(toIndentedString(avgDosAppError)).append("\n");
        sb.append("    avgDosAttacks: ").append(toIndentedString(avgDosAttacks)).append("\n");
        sb.append("    avgDosBadRstFlood: ").append(toIndentedString(avgDosBadRstFlood)).append("\n");
        sb.append("    avgDosBandwidth: ").append(toIndentedString(avgDosBandwidth)).append("\n");
        sb.append("    avgDosConn: ").append(toIndentedString(avgDosConn)).append("\n");
        sb.append("    avgDosConnIpRlDrop: ").append(toIndentedString(avgDosConnIpRlDrop)).append("\n");
        sb.append("    avgDosConnRlDrop: ").append(toIndentedString(avgDosConnRlDrop)).append("\n");
        sb.append("    avgDosFakeSession: ").append(toIndentedString(avgDosFakeSession)).append("\n");
        sb.append("    avgDosHttpAbort: ").append(toIndentedString(avgDosHttpAbort)).append("\n");
        sb.append("    avgDosHttpError: ").append(toIndentedString(avgDosHttpError)).append("\n");
        sb.append("    avgDosHttpTimeout: ").append(toIndentedString(avgDosHttpTimeout)).append("\n");
        sb.append("    avgDosMalformedFlood: ").append(toIndentedString(avgDosMalformedFlood)).append("\n");
        sb.append("    avgDosNonSynFlood: ").append(toIndentedString(avgDosNonSynFlood)).append("\n");
        sb.append("    avgDosReq: ").append(toIndentedString(avgDosReq)).append("\n");
        sb.append("    avgDosReqCookieRlDrop: ").append(toIndentedString(avgDosReqCookieRlDrop)).append("\n");
        sb.append("    avgDosReqCustomRlDrop: ").append(toIndentedString(avgDosReqCustomRlDrop)).append("\n");
        sb.append("    avgDosReqHdrRlDrop: ").append(toIndentedString(avgDosReqHdrRlDrop)).append("\n");
        sb.append("    avgDosReqIpRlDrop: ").append(toIndentedString(avgDosReqIpRlDrop)).append("\n");
        sb.append("    avgDosReqIpRlDropBad: ").append(toIndentedString(avgDosReqIpRlDropBad)).append("\n");
        sb.append("    avgDosReqIpScanBadRlDrop: ").append(toIndentedString(avgDosReqIpScanBadRlDrop)).append("\n");
        sb.append("    avgDosReqIpScanUnknownRlDrop: ").append(toIndentedString(avgDosReqIpScanUnknownRlDrop)).append("\n");
        sb.append("    avgDosReqIpUriRlDrop: ").append(toIndentedString(avgDosReqIpUriRlDrop)).append("\n");
        sb.append("    avgDosReqIpUriRlDropBad: ").append(toIndentedString(avgDosReqIpUriRlDropBad)).append("\n");
        sb.append("    avgDosReqRlDrop: ").append(toIndentedString(avgDosReqRlDrop)).append("\n");
        sb.append("    avgDosReqUriRlDrop: ").append(toIndentedString(avgDosReqUriRlDrop)).append("\n");
        sb.append("    avgDosReqUriRlDropBad: ").append(toIndentedString(avgDosReqUriRlDropBad)).append("\n");
        sb.append("    avgDosReqUriScanBadRlDrop: ").append(toIndentedString(avgDosReqUriScanBadRlDrop)).append("\n");
        sb.append("    avgDosReqUriScanUnknownRlDrop: ").append(toIndentedString(avgDosReqUriScanUnknownRlDrop)).append("\n");
        sb.append("    avgDosRxBytes: ").append(toIndentedString(avgDosRxBytes)).append("\n");
        sb.append("    avgDosSlowUri: ").append(toIndentedString(avgDosSlowUri)).append("\n");
        sb.append("    avgDosSmallWindowStress: ").append(toIndentedString(avgDosSmallWindowStress)).append("\n");
        sb.append("    avgDosSslError: ").append(toIndentedString(avgDosSslError)).append("\n");
        sb.append("    avgDosSynFlood: ").append(toIndentedString(avgDosSynFlood)).append("\n");
        sb.append("    avgDosTotalReq: ").append(toIndentedString(avgDosTotalReq)).append("\n");
        sb.append("    avgDosTxBytes: ").append(toIndentedString(avgDosTxBytes)).append("\n");
        sb.append("    avgDosZeroWindowStress: ").append(toIndentedString(avgDosZeroWindowStress)).append("\n");
        sb.append("    avgErroredConnections: ").append(toIndentedString(avgErroredConnections)).append("\n");
        sb.append("    avgL4ClientLatency: ").append(toIndentedString(avgL4ClientLatency)).append("\n");
        sb.append("    avgLossyConnections: ").append(toIndentedString(avgLossyConnections)).append("\n");
        sb.append("    avgLossyReq: ").append(toIndentedString(avgLossyReq)).append("\n");
        sb.append("    avgNetworkDosAttacks: ").append(toIndentedString(avgNetworkDosAttacks)).append("\n");
        sb.append("    avgNewEstablishedConns: ").append(toIndentedString(avgNewEstablishedConns)).append("\n");
        sb.append("    avgPktsPolicyDrops: ").append(toIndentedString(avgPktsPolicyDrops)).append("\n");
        sb.append("    avgPolicyDrops: ").append(toIndentedString(avgPolicyDrops)).append("\n");
        sb.append("    avgRxBytes: ").append(toIndentedString(avgRxBytes)).append("\n");
        sb.append("    avgRxBytesDropped: ").append(toIndentedString(avgRxBytesDropped)).append("\n");
        sb.append("    avgRxPkts: ").append(toIndentedString(avgRxPkts)).append("\n");
        sb.append("    avgRxPktsDropped: ").append(toIndentedString(avgRxPktsDropped)).append("\n");
        sb.append("    avgSyns: ").append(toIndentedString(avgSyns)).append("\n");
        sb.append("    avgTotalConnections: ").append(toIndentedString(avgTotalConnections)).append("\n");
        sb.append("    avgTotalRtt: ").append(toIndentedString(avgTotalRtt)).append("\n");
        sb.append("    avgTxBytes: ").append(toIndentedString(avgTxBytes)).append("\n");
        sb.append("    avgTxPkts: ").append(toIndentedString(avgTxPkts)).append("\n");
        sb.append("    maxNumActiveSe: ").append(toIndentedString(maxNumActiveSe)).append("\n");
        sb.append("    maxOpenConns: ").append(toIndentedString(maxOpenConns)).append("\n");
        sb.append("    maxRxBytesAbsolute: ").append(toIndentedString(maxRxBytesAbsolute)).append("\n");
        sb.append("    maxRxPktsAbsolute: ").append(toIndentedString(maxRxPktsAbsolute)).append("\n");
        sb.append("    maxTxBytesAbsolute: ").append(toIndentedString(maxTxBytesAbsolute)).append("\n");
        sb.append("    maxTxPktsAbsolute: ").append(toIndentedString(maxTxPktsAbsolute)).append("\n");
        sb.append("    nodeObjId: ").append(toIndentedString(nodeObjId)).append("\n");
        sb.append("    pctApplicationDosAttacks: ").append(toIndentedString(pctApplicationDosAttacks)).append("\n");
        sb.append("    pctConnectionErrors: ").append(toIndentedString(pctConnectionErrors)).append("\n");
        sb.append("    pctConnectionsDosAttacks: ").append(toIndentedString(pctConnectionsDosAttacks)).append("\n");
        sb.append("    pctDosBandwidth: ").append(toIndentedString(pctDosBandwidth)).append("\n");
        sb.append("    pctDosRxBytes: ").append(toIndentedString(pctDosRxBytes)).append("\n");
        sb.append("    pctNetworkDosAttacks: ").append(toIndentedString(pctNetworkDosAttacks)).append("\n");
        sb.append("    pctPktsDosAttacks: ").append(toIndentedString(pctPktsDosAttacks)).append("\n");
        sb.append("    pctPolicyDrops: ").append(toIndentedString(pctPolicyDrops)).append("\n");
        sb.append("    sumConnDuration: ").append(toIndentedString(sumConnDuration)).append("\n");
        sb.append("    sumConnectionDroppedUserLimit: ").append(toIndentedString(sumConnectionDroppedUserLimit)).append("\n");
        sb.append("    sumConnectionErrors: ").append(toIndentedString(sumConnectionErrors)).append("\n");
        sb.append("    sumConnectionsDropped: ").append(toIndentedString(sumConnectionsDropped)).append("\n");
        sb.append("    sumDupAckRetransmits: ").append(toIndentedString(sumDupAckRetransmits)).append("\n");
        sb.append("    sumEndToEndRtt: ").append(toIndentedString(sumEndToEndRtt)).append("\n");
        sb.append("    sumEndToEndRttBucket1: ").append(toIndentedString(sumEndToEndRttBucket1)).append("\n");
        sb.append("    sumEndToEndRttBucket2: ").append(toIndentedString(sumEndToEndRttBucket2)).append("\n");
        sb.append("    sumFinishedConns: ").append(toIndentedString(sumFinishedConns)).append("\n");
        sb.append("    sumLossyConnections: ").append(toIndentedString(sumLossyConnections)).append("\n");
        sb.append("    sumLossyReq: ").append(toIndentedString(sumLossyReq)).append("\n");
        sb.append("    sumOutOfOrders: ").append(toIndentedString(sumOutOfOrders)).append("\n");
        sb.append("    sumPacketDroppedUserBandwidthLimit: ").append(toIndentedString(sumPacketDroppedUserBandwidthLimit)).append("\n");
        sb.append("    sumRttValidConnections: ").append(toIndentedString(sumRttValidConnections)).append("\n");
        sb.append("    sumSackRetransmits: ").append(toIndentedString(sumSackRetransmits)).append("\n");
        sb.append("    sumServerFlowControl: ").append(toIndentedString(sumServerFlowControl)).append("\n");
        sb.append("    sumTimeoutRetransmits: ").append(toIndentedString(sumTimeoutRetransmits)).append("\n");
        sb.append("    sumZeroWindowSizeEvents: ").append(toIndentedString(sumZeroWindowSizeEvents)).append("\n");
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

