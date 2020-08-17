package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The AnalyticsProfile is a POJO class extends AviRestResource that used for creating
 * AnalyticsProfile.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnalyticsProfile extends AviRestResource  {
    @JsonProperty("apdex_response_threshold")
    private Integer apdexResponseThreshold = 500;

    @JsonProperty("apdex_response_tolerated_factor")
    private float apdexResponseToleratedFactor = 4.0f;

    @JsonProperty("apdex_rtt_threshold")
    private Integer apdexRttThreshold = 250;

    @JsonProperty("apdex_rtt_tolerated_factor")
    private float apdexRttToleratedFactor = 4.0f;

    @JsonProperty("apdex_rum_threshold")
    private Integer apdexRumThreshold = 5000;

    @JsonProperty("apdex_rum_tolerated_factor")
    private float apdexRumToleratedFactor = 4.0f;

    @JsonProperty("apdex_server_response_threshold")
    private Integer apdexServerResponseThreshold = 400;

    @JsonProperty("apdex_server_response_tolerated_factor")
    private float apdexServerResponseToleratedFactor = 4.0f;

    @JsonProperty("apdex_server_rtt_threshold")
    private Integer apdexServerRttThreshold = 125;

    @JsonProperty("apdex_server_rtt_tolerated_factor")
    private float apdexServerRttToleratedFactor = 4.0f;

    @JsonProperty("client_log_config")
    private ClientLogConfiguration clientLogConfig = null;

    @JsonProperty("client_log_streaming_config")
    private ClientLogStreamingConfig clientLogStreamingConfig = null;

    @JsonProperty("conn_lossy_ooo_threshold")
    private Integer connLossyOooThreshold = 50;

    @JsonProperty("conn_lossy_timeo_rexmt_threshold")
    private Integer connLossyTimeoRexmtThreshold = 20;

    @JsonProperty("conn_lossy_total_rexmt_threshold")
    private Integer connLossyTotalRexmtThreshold = 50;

    @JsonProperty("conn_lossy_zero_win_size_event_threshold")
    private Integer connLossyZeroWinSizeEventThreshold = 2;

    @JsonProperty("conn_server_lossy_ooo_threshold")
    private Integer connServerLossyOooThreshold = 50;

    @JsonProperty("conn_server_lossy_timeo_rexmt_threshold")
    private Integer connServerLossyTimeoRexmtThreshold = 20;

    @JsonProperty("conn_server_lossy_total_rexmt_threshold")
    private Integer connServerLossyTotalRexmtThreshold = 50;

    @JsonProperty("conn_server_lossy_zero_win_size_event_threshold")
    private Integer connServerLossyZeroWinSizeEventThreshold = 2;

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("disable_ondemand_metrics")
    private Boolean disableOndemandMetrics = false;

    @JsonProperty("disable_se_analytics")
    private Boolean disableSeAnalytics = false;

    @JsonProperty("disable_server_analytics")
    private Boolean disableServerAnalytics = false;

    @JsonProperty("disable_vs_analytics")
    private Boolean disableVsAnalytics = false;

    @JsonProperty("enable_adaptive_config")
    private Boolean enableAdaptiveConfig = true;

    @JsonProperty("enable_advanced_analytics")
    private Boolean enableAdvancedAnalytics = true;

    @JsonProperty("exclude_client_close_before_request_as_error")
    private Boolean excludeClientCloseBeforeRequestAsError = false;

    @JsonProperty("exclude_dns_policy_drop_as_significant")
    private Boolean excludeDnsPolicyDropAsSignificant = false;

    @JsonProperty("exclude_gs_down_as_error")
    private Boolean excludeGsDownAsError = false;

    @JsonProperty("exclude_http_error_codes")
    private List<Integer> excludeHttpErrorCodes = null;

    @JsonProperty("exclude_invalid_dns_domain_as_error")
    private Boolean excludeInvalidDnsDomainAsError = false;

    @JsonProperty("exclude_invalid_dns_query_as_error")
    private Boolean excludeInvalidDnsQueryAsError = false;

    @JsonProperty("exclude_issuer_revoked_ocsp_responses_as_error")
    private Boolean excludeIssuerRevokedOcspResponsesAsError = true;

    @JsonProperty("exclude_no_dns_record_as_error")
    private Boolean excludeNoDnsRecordAsError = false;

    @JsonProperty("exclude_no_valid_gs_member_as_error")
    private Boolean excludeNoValidGsMemberAsError = false;

    @JsonProperty("exclude_persistence_change_as_error")
    private Boolean excludePersistenceChangeAsError = false;

    @JsonProperty("exclude_revoked_ocsp_responses_as_error")
    private Boolean excludeRevokedOcspResponsesAsError = true;

    @JsonProperty("exclude_server_dns_error_as_error")
    private Boolean excludeServerDnsErrorAsError = false;

    @JsonProperty("exclude_server_tcp_reset_as_error")
    private Boolean excludeServerTcpResetAsError = false;

    @JsonProperty("exclude_sip_error_codes")
    private List<Integer> excludeSipErrorCodes = null;

    @JsonProperty("exclude_stale_ocsp_responses_as_error")
    private Boolean excludeStaleOcspResponsesAsError = true;

    @JsonProperty("exclude_syn_retransmit_as_error")
    private Boolean excludeSynRetransmitAsError = false;

    @JsonProperty("exclude_tcp_reset_as_error")
    private Boolean excludeTcpResetAsError = false;

    @JsonProperty("exclude_unavailable_ocsp_responses_as_error")
    private Boolean excludeUnavailableOcspResponsesAsError = true;

    @JsonProperty("exclude_unsupported_dns_query_as_error")
    private Boolean excludeUnsupportedDnsQueryAsError = false;

    @JsonProperty("healthscore_max_server_limit")
    private Integer healthscoreMaxServerLimit = 20;

    @JsonProperty("hs_event_throttle_window")
    private Integer hsEventThrottleWindow = 1209600;

    @JsonProperty("hs_max_anomaly_penalty")
    private Integer hsMaxAnomalyPenalty = 10;

    @JsonProperty("hs_max_resources_penalty")
    private Integer hsMaxResourcesPenalty = 25;

    @JsonProperty("hs_max_security_penalty")
    private Integer hsMaxSecurityPenalty = 100;

    @JsonProperty("hs_min_dos_rate")
    private Integer hsMinDosRate = 1000;

    @JsonProperty("hs_performance_boost")
    private Integer hsPerformanceBoost = 0;

    @JsonProperty("hs_pscore_traffic_threshold_l4_client")
    private float hsPscoreTrafficThresholdL4Client = 10.0f;

    @JsonProperty("hs_pscore_traffic_threshold_l4_server")
    private float hsPscoreTrafficThresholdL4Server = 10.0f;

    @JsonProperty("hs_security_certscore_expired")
    private float hsSecurityCertscoreExpired = 0.0f;

    @JsonProperty("hs_security_certscore_gt30d")
    private float hsSecurityCertscoreGt30D = 5.0f;

    @JsonProperty("hs_security_certscore_le07d")
    private float hsSecurityCertscoreLe07D = 2.0f;

    @JsonProperty("hs_security_certscore_le30d")
    private float hsSecurityCertscoreLe30D = 4.0f;

    @JsonProperty("hs_security_chain_invalidity_penalty")
    private float hsSecurityChainInvalidityPenalty = 1.0f;

    @JsonProperty("hs_security_cipherscore_eq000b")
    private float hsSecurityCipherscoreEq000B = 0.0f;

    @JsonProperty("hs_security_cipherscore_ge128b")
    private float hsSecurityCipherscoreGe128B = 5.0f;

    @JsonProperty("hs_security_cipherscore_lt128b")
    private float hsSecurityCipherscoreLt128B = 3.5f;

    @JsonProperty("hs_security_encalgo_score_none")
    private float hsSecurityEncalgoScoreNone = 0.0f;

    @JsonProperty("hs_security_encalgo_score_rc4")
    private float hsSecurityEncalgoScoreRc4 = 2.5f;

    @JsonProperty("hs_security_hsts_penalty")
    private float hsSecurityHstsPenalty = 1.0f;

    @JsonProperty("hs_security_nonpfs_penalty")
    private float hsSecurityNonpfsPenalty = 1.0f;

    @JsonProperty("hs_security_ocsp_revoked_score")
    private float hsSecurityOcspRevokedScore = 0.0f;

    @JsonProperty("hs_security_selfsignedcert_penalty")
    private float hsSecuritySelfsignedcertPenalty = 1.0f;

    @JsonProperty("hs_security_ssl30_score")
    private float hsSecuritySsl30Score = 3.5f;

    @JsonProperty("hs_security_tls10_score")
    private float hsSecurityTls10Score = 5.0f;

    @JsonProperty("hs_security_tls11_score")
    private float hsSecurityTls11Score = 5.0f;

    @JsonProperty("hs_security_tls12_score")
    private float hsSecurityTls12Score = 5.0f;

    @JsonProperty("hs_security_tls13_score")
    private float hsSecurityTls13Score = 5.0f;

    @JsonProperty("hs_security_weak_signature_algo_penalty")
    private float hsSecurityWeakSignatureAlgoPenalty = 1.0f;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("ondemand_metrics_idle_timeout")
    private Integer ondemandMetricsIdleTimeout = 1800;

    @JsonProperty("ranges")
    private List<HTTPStatusRange> ranges = null;

    @JsonProperty("resp_code_block")
    private List<String> respCodeBlock = null;

    @JsonProperty("sensitive_log_profile")
    private SensitiveLogProfile sensitiveLogProfile = null;

    @JsonProperty("sip_log_depth")
    private Integer sipLogDepth = 20;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * If a client receives an http response in less than the satisfactory latency threshold, the request is considered satisfied.
   * It is considered tolerated if it is not satisfied and less than tolerated latency factor multiplied by the satisfactory latency threshold.
   * Greater than this number and the client's request is considered frustrated.
   * Allowed values are 1-30000.
   * Default value when not specified in API or module is interpreted by Avi Controller as 500.
   * @return apdexResponseThreshold
   */
  public Integer getApdexResponseThreshold() {
    return apdexResponseThreshold;
  }

  /**
   * This is the setter method to the attribute.
   * If a client receives an http response in less than the satisfactory latency threshold, the request is considered satisfied.
   * It is considered tolerated if it is not satisfied and less than tolerated latency factor multiplied by the satisfactory latency threshold.
   * Greater than this number and the client's request is considered frustrated.
   * Allowed values are 1-30000.
   * Default value when not specified in API or module is interpreted by Avi Controller as 500.
   * @param apdexResponseThreshold set the apdexResponseThreshold.
   */
  public void setApdexResponseThreshold(Integer  apdexResponseThreshold) {
    this.apdexResponseThreshold = apdexResponseThreshold;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Client tolerated response latency factor.
   * Client must receive a response within this factor times the satisfactory threshold (apdex_response_threshold) to be considered tolerated.
   * Allowed values are 1-1000.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4.0.
   * @return apdexResponseToleratedFactor
   */
  public Float getApdexResponseToleratedFactor() {
    return apdexResponseToleratedFactor;
  }

  /**
   * This is the setter method to the attribute.
   * Client tolerated response latency factor.
   * Client must receive a response within this factor times the satisfactory threshold (apdex_response_threshold) to be considered tolerated.
   * Allowed values are 1-1000.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4.0.
   * @param apdexResponseToleratedFactor set the apdexResponseToleratedFactor.
   */
  public void setApdexResponseToleratedFactor(Float  apdexResponseToleratedFactor) {
    this.apdexResponseToleratedFactor = apdexResponseToleratedFactor;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Satisfactory client to avi round trip time(rtt).
   * Allowed values are 1-2000.
   * Default value when not specified in API or module is interpreted by Avi Controller as 250.
   * @return apdexRttThreshold
   */
  public Integer getApdexRttThreshold() {
    return apdexRttThreshold;
  }

  /**
   * This is the setter method to the attribute.
   * Satisfactory client to avi round trip time(rtt).
   * Allowed values are 1-2000.
   * Default value when not specified in API or module is interpreted by Avi Controller as 250.
   * @param apdexRttThreshold set the apdexRttThreshold.
   */
  public void setApdexRttThreshold(Integer  apdexRttThreshold) {
    this.apdexRttThreshold = apdexRttThreshold;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Tolerated client to avi round trip time(rtt) factor.
   * It is a multiple of apdex_rtt_tolerated_factor.
   * Allowed values are 1-1000.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4.0.
   * @return apdexRttToleratedFactor
   */
  public Float getApdexRttToleratedFactor() {
    return apdexRttToleratedFactor;
  }

  /**
   * This is the setter method to the attribute.
   * Tolerated client to avi round trip time(rtt) factor.
   * It is a multiple of apdex_rtt_tolerated_factor.
   * Allowed values are 1-1000.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4.0.
   * @param apdexRttToleratedFactor set the apdexRttToleratedFactor.
   */
  public void setApdexRttToleratedFactor(Float  apdexRttToleratedFactor) {
    this.apdexRttToleratedFactor = apdexRttToleratedFactor;
  }

  /**
   * This is the getter method this will return the attribute value.
   * If a client is able to load a page in less than the satisfactory latency threshold, the pageload is considered satisfied.
   * It is considered tolerated if it is greater than satisfied but less than the tolerated latency multiplied by satisifed latency.
   * Greater than this number and the client's request is considered frustrated.
   * A pageload includes the time for dns lookup, download of all http objects, and page render time.
   * Allowed values are 1-30000.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5000.
   * @return apdexRumThreshold
   */
  public Integer getApdexRumThreshold() {
    return apdexRumThreshold;
  }

  /**
   * This is the setter method to the attribute.
   * If a client is able to load a page in less than the satisfactory latency threshold, the pageload is considered satisfied.
   * It is considered tolerated if it is greater than satisfied but less than the tolerated latency multiplied by satisifed latency.
   * Greater than this number and the client's request is considered frustrated.
   * A pageload includes the time for dns lookup, download of all http objects, and page render time.
   * Allowed values are 1-30000.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5000.
   * @param apdexRumThreshold set the apdexRumThreshold.
   */
  public void setApdexRumThreshold(Integer  apdexRumThreshold) {
    this.apdexRumThreshold = apdexRumThreshold;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Virtual service threshold factor for tolerated page load time (plt) as multiple of apdex_rum_threshold.
   * Allowed values are 1-1000.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4.0.
   * @return apdexRumToleratedFactor
   */
  public Float getApdexRumToleratedFactor() {
    return apdexRumToleratedFactor;
  }

  /**
   * This is the setter method to the attribute.
   * Virtual service threshold factor for tolerated page load time (plt) as multiple of apdex_rum_threshold.
   * Allowed values are 1-1000.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4.0.
   * @param apdexRumToleratedFactor set the apdexRumToleratedFactor.
   */
  public void setApdexRumToleratedFactor(Float  apdexRumToleratedFactor) {
    this.apdexRumToleratedFactor = apdexRumToleratedFactor;
  }

  /**
   * This is the getter method this will return the attribute value.
   * A server http response is considered satisfied if latency is less than the satisfactory latency threshold.
   * The response is considered tolerated when it is greater than satisfied but less than the tolerated latency factor * s_latency.
   * Greater than this number and the server response is considered frustrated.
   * Allowed values are 1-30000.
   * Default value when not specified in API or module is interpreted by Avi Controller as 400.
   * @return apdexServerResponseThreshold
   */
  public Integer getApdexServerResponseThreshold() {
    return apdexServerResponseThreshold;
  }

  /**
   * This is the setter method to the attribute.
   * A server http response is considered satisfied if latency is less than the satisfactory latency threshold.
   * The response is considered tolerated when it is greater than satisfied but less than the tolerated latency factor * s_latency.
   * Greater than this number and the server response is considered frustrated.
   * Allowed values are 1-30000.
   * Default value when not specified in API or module is interpreted by Avi Controller as 400.
   * @param apdexServerResponseThreshold set the apdexServerResponseThreshold.
   */
  public void setApdexServerResponseThreshold(Integer  apdexServerResponseThreshold) {
    this.apdexServerResponseThreshold = apdexServerResponseThreshold;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Server tolerated response latency factor.
   * Servermust response within this factor times the satisfactory threshold (apdex_server_response_threshold) to be considered tolerated.
   * Allowed values are 1-1000.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4.0.
   * @return apdexServerResponseToleratedFactor
   */
  public Float getApdexServerResponseToleratedFactor() {
    return apdexServerResponseToleratedFactor;
  }

  /**
   * This is the setter method to the attribute.
   * Server tolerated response latency factor.
   * Servermust response within this factor times the satisfactory threshold (apdex_server_response_threshold) to be considered tolerated.
   * Allowed values are 1-1000.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4.0.
   * @param apdexServerResponseToleratedFactor set the apdexServerResponseToleratedFactor.
   */
  public void setApdexServerResponseToleratedFactor(Float  apdexServerResponseToleratedFactor) {
    this.apdexServerResponseToleratedFactor = apdexServerResponseToleratedFactor;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Satisfactory client to avi round trip time(rtt).
   * Allowed values are 1-2000.
   * Default value when not specified in API or module is interpreted by Avi Controller as 125.
   * @return apdexServerRttThreshold
   */
  public Integer getApdexServerRttThreshold() {
    return apdexServerRttThreshold;
  }

  /**
   * This is the setter method to the attribute.
   * Satisfactory client to avi round trip time(rtt).
   * Allowed values are 1-2000.
   * Default value when not specified in API or module is interpreted by Avi Controller as 125.
   * @param apdexServerRttThreshold set the apdexServerRttThreshold.
   */
  public void setApdexServerRttThreshold(Integer  apdexServerRttThreshold) {
    this.apdexServerRttThreshold = apdexServerRttThreshold;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Tolerated client to avi round trip time(rtt) factor.
   * It is a multiple of apdex_rtt_tolerated_factor.
   * Allowed values are 1-1000.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4.0.
   * @return apdexServerRttToleratedFactor
   */
  public Float getApdexServerRttToleratedFactor() {
    return apdexServerRttToleratedFactor;
  }

  /**
   * This is the setter method to the attribute.
   * Tolerated client to avi round trip time(rtt) factor.
   * It is a multiple of apdex_rtt_tolerated_factor.
   * Allowed values are 1-1000.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4.0.
   * @param apdexServerRttToleratedFactor set the apdexServerRttToleratedFactor.
   */
  public void setApdexServerRttToleratedFactor(Float  apdexServerRttToleratedFactor) {
    this.apdexServerRttToleratedFactor = apdexServerRttToleratedFactor;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Configure which logs are sent to the avi controller from ses and how they are processed.
   * @return clientLogConfig
   */
  public ClientLogConfiguration getClientLogConfig() {
    return clientLogConfig;
  }

  /**
   * This is the setter method to the attribute.
   * Configure which logs are sent to the avi controller from ses and how they are processed.
   * @param clientLogConfig set the clientLogConfig.
   */
  public void setClientLogConfig(ClientLogConfiguration clientLogConfig) {
    this.clientLogConfig = clientLogConfig;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Configure to stream logs to an external server.
   * Field introduced in 17.1.1.
   * @return clientLogStreamingConfig
   */
  public ClientLogStreamingConfig getClientLogStreamingConfig() {
    return clientLogStreamingConfig;
  }

  /**
   * This is the setter method to the attribute.
   * Configure to stream logs to an external server.
   * Field introduced in 17.1.1.
   * @param clientLogStreamingConfig set the clientLogStreamingConfig.
   */
  public void setClientLogStreamingConfig(ClientLogStreamingConfig clientLogStreamingConfig) {
    this.clientLogStreamingConfig = clientLogStreamingConfig;
  }

  /**
   * This is the getter method this will return the attribute value.
   * A connection between client and avi is considered lossy when more than this percentage of out of order packets are received.
   * Allowed values are 1-100.
   * Default value when not specified in API or module is interpreted by Avi Controller as 50.
   * @return connLossyOooThreshold
   */
  public Integer getConnLossyOooThreshold() {
    return connLossyOooThreshold;
  }

  /**
   * This is the setter method to the attribute.
   * A connection between client and avi is considered lossy when more than this percentage of out of order packets are received.
   * Allowed values are 1-100.
   * Default value when not specified in API or module is interpreted by Avi Controller as 50.
   * @param connLossyOooThreshold set the connLossyOooThreshold.
   */
  public void setConnLossyOooThreshold(Integer  connLossyOooThreshold) {
    this.connLossyOooThreshold = connLossyOooThreshold;
  }

  /**
   * This is the getter method this will return the attribute value.
   * A connection between client and avi is considered lossy when more than this percentage of packets are retransmitted due to timeout.
   * Allowed values are 1-100.
   * Default value when not specified in API or module is interpreted by Avi Controller as 20.
   * @return connLossyTimeoRexmtThreshold
   */
  public Integer getConnLossyTimeoRexmtThreshold() {
    return connLossyTimeoRexmtThreshold;
  }

  /**
   * This is the setter method to the attribute.
   * A connection between client and avi is considered lossy when more than this percentage of packets are retransmitted due to timeout.
   * Allowed values are 1-100.
   * Default value when not specified in API or module is interpreted by Avi Controller as 20.
   * @param connLossyTimeoRexmtThreshold set the connLossyTimeoRexmtThreshold.
   */
  public void setConnLossyTimeoRexmtThreshold(Integer  connLossyTimeoRexmtThreshold) {
    this.connLossyTimeoRexmtThreshold = connLossyTimeoRexmtThreshold;
  }

  /**
   * This is the getter method this will return the attribute value.
   * A connection between client and avi is considered lossy when more than this percentage of packets are retransmitted.
   * Allowed values are 1-100.
   * Default value when not specified in API or module is interpreted by Avi Controller as 50.
   * @return connLossyTotalRexmtThreshold
   */
  public Integer getConnLossyTotalRexmtThreshold() {
    return connLossyTotalRexmtThreshold;
  }

  /**
   * This is the setter method to the attribute.
   * A connection between client and avi is considered lossy when more than this percentage of packets are retransmitted.
   * Allowed values are 1-100.
   * Default value when not specified in API or module is interpreted by Avi Controller as 50.
   * @param connLossyTotalRexmtThreshold set the connLossyTotalRexmtThreshold.
   */
  public void setConnLossyTotalRexmtThreshold(Integer  connLossyTotalRexmtThreshold) {
    this.connLossyTotalRexmtThreshold = connLossyTotalRexmtThreshold;
  }

  /**
   * This is the getter method this will return the attribute value.
   * A client connection is considered lossy when percentage of times a packet could not be trasmitted due to tcp zero window is above this threshold.
   * Allowed values are 0-100.
   * Default value when not specified in API or module is interpreted by Avi Controller as 2.
   * @return connLossyZeroWinSizeEventThreshold
   */
  public Integer getConnLossyZeroWinSizeEventThreshold() {
    return connLossyZeroWinSizeEventThreshold;
  }

  /**
   * This is the setter method to the attribute.
   * A client connection is considered lossy when percentage of times a packet could not be trasmitted due to tcp zero window is above this threshold.
   * Allowed values are 0-100.
   * Default value when not specified in API or module is interpreted by Avi Controller as 2.
   * @param connLossyZeroWinSizeEventThreshold set the connLossyZeroWinSizeEventThreshold.
   */
  public void setConnLossyZeroWinSizeEventThreshold(Integer  connLossyZeroWinSizeEventThreshold) {
    this.connLossyZeroWinSizeEventThreshold = connLossyZeroWinSizeEventThreshold;
  }

  /**
   * This is the getter method this will return the attribute value.
   * A connection between avi and server is considered lossy when more than this percentage of out of order packets are received.
   * Allowed values are 1-100.
   * Default value when not specified in API or module is interpreted by Avi Controller as 50.
   * @return connServerLossyOooThreshold
   */
  public Integer getConnServerLossyOooThreshold() {
    return connServerLossyOooThreshold;
  }

  /**
   * This is the setter method to the attribute.
   * A connection between avi and server is considered lossy when more than this percentage of out of order packets are received.
   * Allowed values are 1-100.
   * Default value when not specified in API or module is interpreted by Avi Controller as 50.
   * @param connServerLossyOooThreshold set the connServerLossyOooThreshold.
   */
  public void setConnServerLossyOooThreshold(Integer  connServerLossyOooThreshold) {
    this.connServerLossyOooThreshold = connServerLossyOooThreshold;
  }

  /**
   * This is the getter method this will return the attribute value.
   * A connection between avi and server is considered lossy when more than this percentage of packets are retransmitted due to timeout.
   * Allowed values are 1-100.
   * Default value when not specified in API or module is interpreted by Avi Controller as 20.
   * @return connServerLossyTimeoRexmtThreshold
   */
  public Integer getConnServerLossyTimeoRexmtThreshold() {
    return connServerLossyTimeoRexmtThreshold;
  }

  /**
   * This is the setter method to the attribute.
   * A connection between avi and server is considered lossy when more than this percentage of packets are retransmitted due to timeout.
   * Allowed values are 1-100.
   * Default value when not specified in API or module is interpreted by Avi Controller as 20.
   * @param connServerLossyTimeoRexmtThreshold set the connServerLossyTimeoRexmtThreshold.
   */
  public void setConnServerLossyTimeoRexmtThreshold(Integer  connServerLossyTimeoRexmtThreshold) {
    this.connServerLossyTimeoRexmtThreshold = connServerLossyTimeoRexmtThreshold;
  }

  /**
   * This is the getter method this will return the attribute value.
   * A connection between avi and server is considered lossy when more than this percentage of packets are retransmitted.
   * Allowed values are 1-100.
   * Default value when not specified in API or module is interpreted by Avi Controller as 50.
   * @return connServerLossyTotalRexmtThreshold
   */
  public Integer getConnServerLossyTotalRexmtThreshold() {
    return connServerLossyTotalRexmtThreshold;
  }

  /**
   * This is the setter method to the attribute.
   * A connection between avi and server is considered lossy when more than this percentage of packets are retransmitted.
   * Allowed values are 1-100.
   * Default value when not specified in API or module is interpreted by Avi Controller as 50.
   * @param connServerLossyTotalRexmtThreshold set the connServerLossyTotalRexmtThreshold.
   */
  public void setConnServerLossyTotalRexmtThreshold(Integer  connServerLossyTotalRexmtThreshold) {
    this.connServerLossyTotalRexmtThreshold = connServerLossyTotalRexmtThreshold;
  }

  /**
   * This is the getter method this will return the attribute value.
   * A server connection is considered lossy when percentage of times a packet could not be trasmitted due to tcp zero window is above this threshold.
   * Allowed values are 0-100.
   * Default value when not specified in API or module is interpreted by Avi Controller as 2.
   * @return connServerLossyZeroWinSizeEventThreshold
   */
  public Integer getConnServerLossyZeroWinSizeEventThreshold() {
    return connServerLossyZeroWinSizeEventThreshold;
  }

  /**
   * This is the setter method to the attribute.
   * A server connection is considered lossy when percentage of times a packet could not be trasmitted due to tcp zero window is above this threshold.
   * Allowed values are 0-100.
   * Default value when not specified in API or module is interpreted by Avi Controller as 2.
   * @param connServerLossyZeroWinSizeEventThreshold set the connServerLossyZeroWinSizeEventThreshold.
   */
  public void setConnServerLossyZeroWinSizeEventThreshold(Integer  connServerLossyZeroWinSizeEventThreshold) {
    this.connServerLossyZeroWinSizeEventThreshold = connServerLossyZeroWinSizeEventThreshold;
  }

  /**
   * This is the getter method this will return the attribute value.
   * User defined description for the object.
   * @return description
   */
  public String getDescription() {
    return description;
  }

  /**
   * This is the setter method to the attribute.
   * User defined description for the object.
   * @param description set the description.
   */
  public void setDescription(String  description) {
    this.description = description;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Virtual service (vs) metrics are processed only when there is live data traffic on the vs.
   * In case, vs is idle for a period of time as specified by ondemand_metrics_idle_timeout then metrics processing is suspended for that vs.
   * Field introduced in 18.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return disableOndemandMetrics
   */
  public Boolean getDisableOndemandMetrics() {
    return disableOndemandMetrics;
  }

  /**
   * This is the setter method to the attribute.
   * Virtual service (vs) metrics are processed only when there is live data traffic on the vs.
   * In case, vs is idle for a period of time as specified by ondemand_metrics_idle_timeout then metrics processing is suspended for that vs.
   * Field introduced in 18.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param disableOndemandMetrics set the disableOndemandMetrics.
   */
  public void setDisableOndemandMetrics(Boolean  disableOndemandMetrics) {
    this.disableOndemandMetrics = disableOndemandMetrics;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Disable node (service engine) level analytics forvs metrics.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return disableSeAnalytics
   */
  public Boolean getDisableSeAnalytics() {
    return disableSeAnalytics;
  }

  /**
   * This is the setter method to the attribute.
   * Disable node (service engine) level analytics forvs metrics.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param disableSeAnalytics set the disableSeAnalytics.
   */
  public void setDisableSeAnalytics(Boolean  disableSeAnalytics) {
    this.disableSeAnalytics = disableSeAnalytics;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Disable analytics on backend servers.
   * This may be desired in container environment when there are large number of ephemeral servers.
   * Additionally, no healthscore of servers is computed when server analytics is disabled.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return disableServerAnalytics
   */
  public Boolean getDisableServerAnalytics() {
    return disableServerAnalytics;
  }

  /**
   * This is the setter method to the attribute.
   * Disable analytics on backend servers.
   * This may be desired in container environment when there are large number of ephemeral servers.
   * Additionally, no healthscore of servers is computed when server analytics is disabled.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param disableServerAnalytics set the disableServerAnalytics.
   */
  public void setDisableServerAnalytics(Boolean  disableServerAnalytics) {
    this.disableServerAnalytics = disableServerAnalytics;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Disable virtualservice (frontend) analytics.
   * This flag disables metrics and healthscore for virtualservice.
   * Field introduced in 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return disableVsAnalytics
   */
  public Boolean getDisableVsAnalytics() {
    return disableVsAnalytics;
  }

  /**
   * This is the setter method to the attribute.
   * Disable virtualservice (frontend) analytics.
   * This flag disables metrics and healthscore for virtualservice.
   * Field introduced in 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param disableVsAnalytics set the disableVsAnalytics.
   */
  public void setDisableVsAnalytics(Boolean  disableVsAnalytics) {
    this.disableVsAnalytics = disableVsAnalytics;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable adaptive configuration for optimizing resource usage.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return enableAdaptiveConfig
   */
  public Boolean getEnableAdaptiveConfig() {
    return enableAdaptiveConfig;
  }

  /**
   * This is the setter method to the attribute.
   * Enable adaptive configuration for optimizing resource usage.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param enableAdaptiveConfig set the enableAdaptiveConfig.
   */
  public void setEnableAdaptiveConfig(Boolean  enableAdaptiveConfig) {
    this.enableAdaptiveConfig = enableAdaptiveConfig;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enables advanced analytics features like anomaly detection.
   * If set to false, anomaly computation (and associated rules/events) for vs, pool and server metrics will be disabled.
   * However, setting it to false reduces cpu and memory requirements for analytics subsystem.
   * Field introduced in 17.2.13, 18.1.5, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return enableAdvancedAnalytics
   */
  public Boolean getEnableAdvancedAnalytics() {
    return enableAdvancedAnalytics;
  }

  /**
   * This is the setter method to the attribute.
   * Enables advanced analytics features like anomaly detection.
   * If set to false, anomaly computation (and associated rules/events) for vs, pool and server metrics will be disabled.
   * However, setting it to false reduces cpu and memory requirements for analytics subsystem.
   * Field introduced in 17.2.13, 18.1.5, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param enableAdvancedAnalytics set the enableAdvancedAnalytics.
   */
  public void setEnableAdvancedAnalytics(Boolean  enableAdvancedAnalytics) {
    this.enableAdvancedAnalytics = enableAdvancedAnalytics;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Exclude client closed connection before an http request could be completed from being classified as an error.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return excludeClientCloseBeforeRequestAsError
   */
  public Boolean getExcludeClientCloseBeforeRequestAsError() {
    return excludeClientCloseBeforeRequestAsError;
  }

  /**
   * This is the setter method to the attribute.
   * Exclude client closed connection before an http request could be completed from being classified as an error.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param excludeClientCloseBeforeRequestAsError set the excludeClientCloseBeforeRequestAsError.
   */
  public void setExcludeClientCloseBeforeRequestAsError(Boolean  excludeClientCloseBeforeRequestAsError) {
    this.excludeClientCloseBeforeRequestAsError = excludeClientCloseBeforeRequestAsError;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Exclude dns policy drops from the list of errors.
   * Field introduced in 17.2.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return excludeDnsPolicyDropAsSignificant
   */
  public Boolean getExcludeDnsPolicyDropAsSignificant() {
    return excludeDnsPolicyDropAsSignificant;
  }

  /**
   * This is the setter method to the attribute.
   * Exclude dns policy drops from the list of errors.
   * Field introduced in 17.2.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param excludeDnsPolicyDropAsSignificant set the excludeDnsPolicyDropAsSignificant.
   */
  public void setExcludeDnsPolicyDropAsSignificant(Boolean  excludeDnsPolicyDropAsSignificant) {
    this.excludeDnsPolicyDropAsSignificant = excludeDnsPolicyDropAsSignificant;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Exclude queries to gslb services that are operationally down from the list of errors.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return excludeGsDownAsError
   */
  public Boolean getExcludeGsDownAsError() {
    return excludeGsDownAsError;
  }

  /**
   * This is the setter method to the attribute.
   * Exclude queries to gslb services that are operationally down from the list of errors.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param excludeGsDownAsError set the excludeGsDownAsError.
   */
  public void setExcludeGsDownAsError(Boolean  excludeGsDownAsError) {
    this.excludeGsDownAsError = excludeGsDownAsError;
  }
  /**
   * This is the getter method this will return the attribute value.
   * List of http status codes to be excluded from being classified as an error.
   * Error connections or responses impacts health score, are included as significant logs, and may be classified as part of a dos attack.
   * @return excludeHttpErrorCodes
   */
  public List<Integer> getExcludeHttpErrorCodes() {
    return excludeHttpErrorCodes;
  }

  /**
   * This is the setter method. this will set the excludeHttpErrorCodes
   * List of http status codes to be excluded from being classified as an error.
   * Error connections or responses impacts health score, are included as significant logs, and may be classified as part of a dos attack.
   * @return excludeHttpErrorCodes
   */
  public void setExcludeHttpErrorCodes(List<Integer>  excludeHttpErrorCodes) {
    this.excludeHttpErrorCodes = excludeHttpErrorCodes;
  }

  /**
   * This is the setter method this will set the excludeHttpErrorCodes
   * List of http status codes to be excluded from being classified as an error.
   * Error connections or responses impacts health score, are included as significant logs, and may be classified as part of a dos attack.
   * @return excludeHttpErrorCodes
   */
  public AnalyticsProfile addExcludeHttpErrorCodesItem(Integer excludeHttpErrorCodesItem) {
    if (this.excludeHttpErrorCodes == null) {
      this.excludeHttpErrorCodes = new ArrayList<Integer>();
    }
    this.excludeHttpErrorCodes.add(excludeHttpErrorCodesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Exclude dns queries to domains outside the domains configured in the dns application profile from the list of errors.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return excludeInvalidDnsDomainAsError
   */
  public Boolean getExcludeInvalidDnsDomainAsError() {
    return excludeInvalidDnsDomainAsError;
  }

  /**
   * This is the setter method to the attribute.
   * Exclude dns queries to domains outside the domains configured in the dns application profile from the list of errors.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param excludeInvalidDnsDomainAsError set the excludeInvalidDnsDomainAsError.
   */
  public void setExcludeInvalidDnsDomainAsError(Boolean  excludeInvalidDnsDomainAsError) {
    this.excludeInvalidDnsDomainAsError = excludeInvalidDnsDomainAsError;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Exclude invalid dns queries from the list of errors.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return excludeInvalidDnsQueryAsError
   */
  public Boolean getExcludeInvalidDnsQueryAsError() {
    return excludeInvalidDnsQueryAsError;
  }

  /**
   * This is the setter method to the attribute.
   * Exclude invalid dns queries from the list of errors.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param excludeInvalidDnsQueryAsError set the excludeInvalidDnsQueryAsError.
   */
  public void setExcludeInvalidDnsQueryAsError(Boolean  excludeInvalidDnsQueryAsError) {
    this.excludeInvalidDnsQueryAsError = excludeInvalidDnsQueryAsError;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Exclude the issuer-revoked ocsp responses from the list of errors.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return excludeIssuerRevokedOcspResponsesAsError
   */
  public Boolean getExcludeIssuerRevokedOcspResponsesAsError() {
    return excludeIssuerRevokedOcspResponsesAsError;
  }

  /**
   * This is the setter method to the attribute.
   * Exclude the issuer-revoked ocsp responses from the list of errors.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param excludeIssuerRevokedOcspResponsesAsError set the excludeIssuerRevokedOcspResponsesAsError.
   */
  public void setExcludeIssuerRevokedOcspResponsesAsError(Boolean  excludeIssuerRevokedOcspResponsesAsError) {
    this.excludeIssuerRevokedOcspResponsesAsError = excludeIssuerRevokedOcspResponsesAsError;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Exclude queries to domains that did not have configured services/records from the list of errors.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return excludeNoDnsRecordAsError
   */
  public Boolean getExcludeNoDnsRecordAsError() {
    return excludeNoDnsRecordAsError;
  }

  /**
   * This is the setter method to the attribute.
   * Exclude queries to domains that did not have configured services/records from the list of errors.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param excludeNoDnsRecordAsError set the excludeNoDnsRecordAsError.
   */
  public void setExcludeNoDnsRecordAsError(Boolean  excludeNoDnsRecordAsError) {
    this.excludeNoDnsRecordAsError = excludeNoDnsRecordAsError;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Exclude queries to gslb services that have no available members from the list of errors.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return excludeNoValidGsMemberAsError
   */
  public Boolean getExcludeNoValidGsMemberAsError() {
    return excludeNoValidGsMemberAsError;
  }

  /**
   * This is the setter method to the attribute.
   * Exclude queries to gslb services that have no available members from the list of errors.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param excludeNoValidGsMemberAsError set the excludeNoValidGsMemberAsError.
   */
  public void setExcludeNoValidGsMemberAsError(Boolean  excludeNoValidGsMemberAsError) {
    this.excludeNoValidGsMemberAsError = excludeNoValidGsMemberAsError;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Exclude persistence server changed while load balancing' from the list of errors.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return excludePersistenceChangeAsError
   */
  public Boolean getExcludePersistenceChangeAsError() {
    return excludePersistenceChangeAsError;
  }

  /**
   * This is the setter method to the attribute.
   * Exclude persistence server changed while load balancing' from the list of errors.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param excludePersistenceChangeAsError set the excludePersistenceChangeAsError.
   */
  public void setExcludePersistenceChangeAsError(Boolean  excludePersistenceChangeAsError) {
    this.excludePersistenceChangeAsError = excludePersistenceChangeAsError;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Exclude the revoked ocsp certificate status responses from the list of errors.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return excludeRevokedOcspResponsesAsError
   */
  public Boolean getExcludeRevokedOcspResponsesAsError() {
    return excludeRevokedOcspResponsesAsError;
  }

  /**
   * This is the setter method to the attribute.
   * Exclude the revoked ocsp certificate status responses from the list of errors.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param excludeRevokedOcspResponsesAsError set the excludeRevokedOcspResponsesAsError.
   */
  public void setExcludeRevokedOcspResponsesAsError(Boolean  excludeRevokedOcspResponsesAsError) {
    this.excludeRevokedOcspResponsesAsError = excludeRevokedOcspResponsesAsError;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Exclude server dns error response from the list of errors.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return excludeServerDnsErrorAsError
   */
  public Boolean getExcludeServerDnsErrorAsError() {
    return excludeServerDnsErrorAsError;
  }

  /**
   * This is the setter method to the attribute.
   * Exclude server dns error response from the list of errors.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param excludeServerDnsErrorAsError set the excludeServerDnsErrorAsError.
   */
  public void setExcludeServerDnsErrorAsError(Boolean  excludeServerDnsErrorAsError) {
    this.excludeServerDnsErrorAsError = excludeServerDnsErrorAsError;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Exclude server tcp reset from errors.
   * It is common for applications like ms exchange.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return excludeServerTcpResetAsError
   */
  public Boolean getExcludeServerTcpResetAsError() {
    return excludeServerTcpResetAsError;
  }

  /**
   * This is the setter method to the attribute.
   * Exclude server tcp reset from errors.
   * It is common for applications like ms exchange.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param excludeServerTcpResetAsError set the excludeServerTcpResetAsError.
   */
  public void setExcludeServerTcpResetAsError(Boolean  excludeServerTcpResetAsError) {
    this.excludeServerTcpResetAsError = excludeServerTcpResetAsError;
  }
  /**
   * This is the getter method this will return the attribute value.
   * List of sip status codes to be excluded from being classified as an error.
   * Field introduced in 17.2.13, 18.1.5, 18.2.1.
   * @return excludeSipErrorCodes
   */
  public List<Integer> getExcludeSipErrorCodes() {
    return excludeSipErrorCodes;
  }

  /**
   * This is the setter method. this will set the excludeSipErrorCodes
   * List of sip status codes to be excluded from being classified as an error.
   * Field introduced in 17.2.13, 18.1.5, 18.2.1.
   * @return excludeSipErrorCodes
   */
  public void setExcludeSipErrorCodes(List<Integer>  excludeSipErrorCodes) {
    this.excludeSipErrorCodes = excludeSipErrorCodes;
  }

  /**
   * This is the setter method this will set the excludeSipErrorCodes
   * List of sip status codes to be excluded from being classified as an error.
   * Field introduced in 17.2.13, 18.1.5, 18.2.1.
   * @return excludeSipErrorCodes
   */
  public AnalyticsProfile addExcludeSipErrorCodesItem(Integer excludeSipErrorCodesItem) {
    if (this.excludeSipErrorCodes == null) {
      this.excludeSipErrorCodes = new ArrayList<Integer>();
    }
    this.excludeSipErrorCodes.add(excludeSipErrorCodesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Exclude the stale ocsp certificate status responses from the list of errors.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return excludeStaleOcspResponsesAsError
   */
  public Boolean getExcludeStaleOcspResponsesAsError() {
    return excludeStaleOcspResponsesAsError;
  }

  /**
   * This is the setter method to the attribute.
   * Exclude the stale ocsp certificate status responses from the list of errors.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param excludeStaleOcspResponsesAsError set the excludeStaleOcspResponsesAsError.
   */
  public void setExcludeStaleOcspResponsesAsError(Boolean  excludeStaleOcspResponsesAsError) {
    this.excludeStaleOcspResponsesAsError = excludeStaleOcspResponsesAsError;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Exclude 'server unanswered syns' from the list of errors.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return excludeSynRetransmitAsError
   */
  public Boolean getExcludeSynRetransmitAsError() {
    return excludeSynRetransmitAsError;
  }

  /**
   * This is the setter method to the attribute.
   * Exclude 'server unanswered syns' from the list of errors.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param excludeSynRetransmitAsError set the excludeSynRetransmitAsError.
   */
  public void setExcludeSynRetransmitAsError(Boolean  excludeSynRetransmitAsError) {
    this.excludeSynRetransmitAsError = excludeSynRetransmitAsError;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Exclude tcp resets by client from the list of potential errors.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return excludeTcpResetAsError
   */
  public Boolean getExcludeTcpResetAsError() {
    return excludeTcpResetAsError;
  }

  /**
   * This is the setter method to the attribute.
   * Exclude tcp resets by client from the list of potential errors.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param excludeTcpResetAsError set the excludeTcpResetAsError.
   */
  public void setExcludeTcpResetAsError(Boolean  excludeTcpResetAsError) {
    this.excludeTcpResetAsError = excludeTcpResetAsError;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Exclude the unavailable ocsp responses from the list of errors.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return excludeUnavailableOcspResponsesAsError
   */
  public Boolean getExcludeUnavailableOcspResponsesAsError() {
    return excludeUnavailableOcspResponsesAsError;
  }

  /**
   * This is the setter method to the attribute.
   * Exclude the unavailable ocsp responses from the list of errors.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param excludeUnavailableOcspResponsesAsError set the excludeUnavailableOcspResponsesAsError.
   */
  public void setExcludeUnavailableOcspResponsesAsError(Boolean  excludeUnavailableOcspResponsesAsError) {
    this.excludeUnavailableOcspResponsesAsError = excludeUnavailableOcspResponsesAsError;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Exclude unsupported dns queries from the list of errors.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return excludeUnsupportedDnsQueryAsError
   */
  public Boolean getExcludeUnsupportedDnsQueryAsError() {
    return excludeUnsupportedDnsQueryAsError;
  }

  /**
   * This is the setter method to the attribute.
   * Exclude unsupported dns queries from the list of errors.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param excludeUnsupportedDnsQueryAsError set the excludeUnsupportedDnsQueryAsError.
   */
  public void setExcludeUnsupportedDnsQueryAsError(Boolean  excludeUnsupportedDnsQueryAsError) {
    this.excludeUnsupportedDnsQueryAsError = excludeUnsupportedDnsQueryAsError;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Skips health score computation of pool servers when number of servers in a pool is more than this setting.
   * Allowed values are 0-5000.
   * Special values are 0- 'server health score is disabled'.
   * Field introduced in 17.2.13, 18.1.4.
   * Default value when not specified in API or module is interpreted by Avi Controller as 20.
   * @return healthscoreMaxServerLimit
   */
  public Integer getHealthscoreMaxServerLimit() {
    return healthscoreMaxServerLimit;
  }

  /**
   * This is the setter method to the attribute.
   * Skips health score computation of pool servers when number of servers in a pool is more than this setting.
   * Allowed values are 0-5000.
   * Special values are 0- 'server health score is disabled'.
   * Field introduced in 17.2.13, 18.1.4.
   * Default value when not specified in API or module is interpreted by Avi Controller as 20.
   * @param healthscoreMaxServerLimit set the healthscoreMaxServerLimit.
   */
  public void setHealthscoreMaxServerLimit(Integer  healthscoreMaxServerLimit) {
    this.healthscoreMaxServerLimit = healthscoreMaxServerLimit;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Time window (in secs) within which only unique health change events should occur.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1209600.
   * @return hsEventThrottleWindow
   */
  public Integer getHsEventThrottleWindow() {
    return hsEventThrottleWindow;
  }

  /**
   * This is the setter method to the attribute.
   * Time window (in secs) within which only unique health change events should occur.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1209600.
   * @param hsEventThrottleWindow set the hsEventThrottleWindow.
   */
  public void setHsEventThrottleWindow(Integer  hsEventThrottleWindow) {
    this.hsEventThrottleWindow = hsEventThrottleWindow;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum penalty that may be deducted from health score for anomalies.
   * Allowed values are 0-100.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.
   * @return hsMaxAnomalyPenalty
   */
  public Integer getHsMaxAnomalyPenalty() {
    return hsMaxAnomalyPenalty;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum penalty that may be deducted from health score for anomalies.
   * Allowed values are 0-100.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.
   * @param hsMaxAnomalyPenalty set the hsMaxAnomalyPenalty.
   */
  public void setHsMaxAnomalyPenalty(Integer  hsMaxAnomalyPenalty) {
    this.hsMaxAnomalyPenalty = hsMaxAnomalyPenalty;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum penalty that may be deducted from health score for high resource utilization.
   * Allowed values are 0-100.
   * Default value when not specified in API or module is interpreted by Avi Controller as 25.
   * @return hsMaxResourcesPenalty
   */
  public Integer getHsMaxResourcesPenalty() {
    return hsMaxResourcesPenalty;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum penalty that may be deducted from health score for high resource utilization.
   * Allowed values are 0-100.
   * Default value when not specified in API or module is interpreted by Avi Controller as 25.
   * @param hsMaxResourcesPenalty set the hsMaxResourcesPenalty.
   */
  public void setHsMaxResourcesPenalty(Integer  hsMaxResourcesPenalty) {
    this.hsMaxResourcesPenalty = hsMaxResourcesPenalty;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum penalty that may be deducted from health score based on security assessment.
   * Allowed values are 0-100.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100.
   * @return hsMaxSecurityPenalty
   */
  public Integer getHsMaxSecurityPenalty() {
    return hsMaxSecurityPenalty;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum penalty that may be deducted from health score based on security assessment.
   * Allowed values are 0-100.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100.
   * @param hsMaxSecurityPenalty set the hsMaxSecurityPenalty.
   */
  public void setHsMaxSecurityPenalty(Integer  hsMaxSecurityPenalty) {
    this.hsMaxSecurityPenalty = hsMaxSecurityPenalty;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dos connection rate below which the dos security assessment will not kick in.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1000.
   * @return hsMinDosRate
   */
  public Integer getHsMinDosRate() {
    return hsMinDosRate;
  }

  /**
   * This is the setter method to the attribute.
   * Dos connection rate below which the dos security assessment will not kick in.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1000.
   * @param hsMinDosRate set the hsMinDosRate.
   */
  public void setHsMinDosRate(Integer  hsMinDosRate) {
    this.hsMinDosRate = hsMinDosRate;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Adds free performance score credits to health score.
   * It can be used for compensating health score for known slow applications.
   * Allowed values are 0-100.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return hsPerformanceBoost
   */
  public Integer getHsPerformanceBoost() {
    return hsPerformanceBoost;
  }

  /**
   * This is the setter method to the attribute.
   * Adds free performance score credits to health score.
   * It can be used for compensating health score for known slow applications.
   * Allowed values are 0-100.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param hsPerformanceBoost set the hsPerformanceBoost.
   */
  public void setHsPerformanceBoost(Integer  hsPerformanceBoost) {
    this.hsPerformanceBoost = hsPerformanceBoost;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Threshold number of connections in 5min, below which apdexr, apdexc, rum_apdex, and other network quality metrics are not computed.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.0.
   * @return hsPscoreTrafficThresholdL4Client
   */
  public Float getHsPscoreTrafficThresholdL4Client() {
    return hsPscoreTrafficThresholdL4Client;
  }

  /**
   * This is the setter method to the attribute.
   * Threshold number of connections in 5min, below which apdexr, apdexc, rum_apdex, and other network quality metrics are not computed.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.0.
   * @param hsPscoreTrafficThresholdL4Client set the hsPscoreTrafficThresholdL4Client.
   */
  public void setHsPscoreTrafficThresholdL4Client(Float  hsPscoreTrafficThresholdL4Client) {
    this.hsPscoreTrafficThresholdL4Client = hsPscoreTrafficThresholdL4Client;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Threshold number of connections in 5min, below which apdexr, apdexc, rum_apdex, and other network quality metrics are not computed.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.0.
   * @return hsPscoreTrafficThresholdL4Server
   */
  public Float getHsPscoreTrafficThresholdL4Server() {
    return hsPscoreTrafficThresholdL4Server;
  }

  /**
   * This is the setter method to the attribute.
   * Threshold number of connections in 5min, below which apdexr, apdexc, rum_apdex, and other network quality metrics are not computed.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.0.
   * @param hsPscoreTrafficThresholdL4Server set the hsPscoreTrafficThresholdL4Server.
   */
  public void setHsPscoreTrafficThresholdL4Server(Float  hsPscoreTrafficThresholdL4Server) {
    this.hsPscoreTrafficThresholdL4Server = hsPscoreTrafficThresholdL4Server;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Score assigned when the certificate has expired.
   * Allowed values are 0-5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.0.
   * @return hsSecurityCertscoreExpired
   */
  public Float getHsSecurityCertscoreExpired() {
    return hsSecurityCertscoreExpired;
  }

  /**
   * This is the setter method to the attribute.
   * Score assigned when the certificate has expired.
   * Allowed values are 0-5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.0.
   * @param hsSecurityCertscoreExpired set the hsSecurityCertscoreExpired.
   */
  public void setHsSecurityCertscoreExpired(Float  hsSecurityCertscoreExpired) {
    this.hsSecurityCertscoreExpired = hsSecurityCertscoreExpired;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Score assigned when the certificate expires in more than 30 days.
   * Allowed values are 0-5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5.0.
   * @return hsSecurityCertscoreGt30D
   */
  public Float getHsSecurityCertscoreGt30D() {
    return hsSecurityCertscoreGt30D;
  }

  /**
   * This is the setter method to the attribute.
   * Score assigned when the certificate expires in more than 30 days.
   * Allowed values are 0-5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5.0.
   * @param hsSecurityCertscoreGt30D set the hsSecurityCertscoreGt30D.
   */
  public void setHsSecurityCertscoreGt30D(Float  hsSecurityCertscoreGt30D) {
    this.hsSecurityCertscoreGt30D = hsSecurityCertscoreGt30D;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Score assigned when the certificate expires in less than or equal to 7 days.
   * Allowed values are 0-5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 2.0.
   * @return hsSecurityCertscoreLe07D
   */
  public Float getHsSecurityCertscoreLe07D() {
    return hsSecurityCertscoreLe07D;
  }

  /**
   * This is the setter method to the attribute.
   * Score assigned when the certificate expires in less than or equal to 7 days.
   * Allowed values are 0-5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 2.0.
   * @param hsSecurityCertscoreLe07D set the hsSecurityCertscoreLe07D.
   */
  public void setHsSecurityCertscoreLe07D(Float  hsSecurityCertscoreLe07D) {
    this.hsSecurityCertscoreLe07D = hsSecurityCertscoreLe07D;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Score assigned when the certificate expires in less than or equal to 30 days.
   * Allowed values are 0-5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4.0.
   * @return hsSecurityCertscoreLe30D
   */
  public Float getHsSecurityCertscoreLe30D() {
    return hsSecurityCertscoreLe30D;
  }

  /**
   * This is the setter method to the attribute.
   * Score assigned when the certificate expires in less than or equal to 30 days.
   * Allowed values are 0-5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4.0.
   * @param hsSecurityCertscoreLe30D set the hsSecurityCertscoreLe30D.
   */
  public void setHsSecurityCertscoreLe30D(Float  hsSecurityCertscoreLe30D) {
    this.hsSecurityCertscoreLe30D = hsSecurityCertscoreLe30D;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Penalty for allowing certificates with invalid chain.
   * Allowed values are 0-5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.0.
   * @return hsSecurityChainInvalidityPenalty
   */
  public Float getHsSecurityChainInvalidityPenalty() {
    return hsSecurityChainInvalidityPenalty;
  }

  /**
   * This is the setter method to the attribute.
   * Penalty for allowing certificates with invalid chain.
   * Allowed values are 0-5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.0.
   * @param hsSecurityChainInvalidityPenalty set the hsSecurityChainInvalidityPenalty.
   */
  public void setHsSecurityChainInvalidityPenalty(Float  hsSecurityChainInvalidityPenalty) {
    this.hsSecurityChainInvalidityPenalty = hsSecurityChainInvalidityPenalty;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Score assigned when the minimum cipher strength is 0 bits.
   * Allowed values are 0-5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.0.
   * @return hsSecurityCipherscoreEq000B
   */
  public Float getHsSecurityCipherscoreEq000B() {
    return hsSecurityCipherscoreEq000B;
  }

  /**
   * This is the setter method to the attribute.
   * Score assigned when the minimum cipher strength is 0 bits.
   * Allowed values are 0-5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.0.
   * @param hsSecurityCipherscoreEq000B set the hsSecurityCipherscoreEq000B.
   */
  public void setHsSecurityCipherscoreEq000B(Float  hsSecurityCipherscoreEq000B) {
    this.hsSecurityCipherscoreEq000B = hsSecurityCipherscoreEq000B;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Score assigned when the minimum cipher strength is greater than equal to 128 bits.
   * Allowed values are 0-5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5.0.
   * @return hsSecurityCipherscoreGe128B
   */
  public Float getHsSecurityCipherscoreGe128B() {
    return hsSecurityCipherscoreGe128B;
  }

  /**
   * This is the setter method to the attribute.
   * Score assigned when the minimum cipher strength is greater than equal to 128 bits.
   * Allowed values are 0-5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5.0.
   * @param hsSecurityCipherscoreGe128B set the hsSecurityCipherscoreGe128B.
   */
  public void setHsSecurityCipherscoreGe128B(Float  hsSecurityCipherscoreGe128B) {
    this.hsSecurityCipherscoreGe128B = hsSecurityCipherscoreGe128B;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Score assigned when the minimum cipher strength is less than 128 bits.
   * Allowed values are 0-5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 3.5.
   * @return hsSecurityCipherscoreLt128B
   */
  public Float getHsSecurityCipherscoreLt128B() {
    return hsSecurityCipherscoreLt128B;
  }

  /**
   * This is the setter method to the attribute.
   * Score assigned when the minimum cipher strength is less than 128 bits.
   * Allowed values are 0-5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 3.5.
   * @param hsSecurityCipherscoreLt128B set the hsSecurityCipherscoreLt128B.
   */
  public void setHsSecurityCipherscoreLt128B(Float  hsSecurityCipherscoreLt128B) {
    this.hsSecurityCipherscoreLt128B = hsSecurityCipherscoreLt128B;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Score assigned when no algorithm is used for encryption.
   * Allowed values are 0-5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.0.
   * @return hsSecurityEncalgoScoreNone
   */
  public Float getHsSecurityEncalgoScoreNone() {
    return hsSecurityEncalgoScoreNone;
  }

  /**
   * This is the setter method to the attribute.
   * Score assigned when no algorithm is used for encryption.
   * Allowed values are 0-5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.0.
   * @param hsSecurityEncalgoScoreNone set the hsSecurityEncalgoScoreNone.
   */
  public void setHsSecurityEncalgoScoreNone(Float  hsSecurityEncalgoScoreNone) {
    this.hsSecurityEncalgoScoreNone = hsSecurityEncalgoScoreNone;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Score assigned when rc4 algorithm is used for encryption.
   * Allowed values are 0-5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 2.5.
   * @return hsSecurityEncalgoScoreRc4
   */
  public Float getHsSecurityEncalgoScoreRc4() {
    return hsSecurityEncalgoScoreRc4;
  }

  /**
   * This is the setter method to the attribute.
   * Score assigned when rc4 algorithm is used for encryption.
   * Allowed values are 0-5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 2.5.
   * @param hsSecurityEncalgoScoreRc4 set the hsSecurityEncalgoScoreRc4.
   */
  public void setHsSecurityEncalgoScoreRc4(Float  hsSecurityEncalgoScoreRc4) {
    this.hsSecurityEncalgoScoreRc4 = hsSecurityEncalgoScoreRc4;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Penalty for not enabling hsts.
   * Allowed values are 0-5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.0.
   * @return hsSecurityHstsPenalty
   */
  public Float getHsSecurityHstsPenalty() {
    return hsSecurityHstsPenalty;
  }

  /**
   * This is the setter method to the attribute.
   * Penalty for not enabling hsts.
   * Allowed values are 0-5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.0.
   * @param hsSecurityHstsPenalty set the hsSecurityHstsPenalty.
   */
  public void setHsSecurityHstsPenalty(Float  hsSecurityHstsPenalty) {
    this.hsSecurityHstsPenalty = hsSecurityHstsPenalty;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Penalty for allowing non-pfs handshakes.
   * Allowed values are 0-5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.0.
   * @return hsSecurityNonpfsPenalty
   */
  public Float getHsSecurityNonpfsPenalty() {
    return hsSecurityNonpfsPenalty;
  }

  /**
   * This is the setter method to the attribute.
   * Penalty for allowing non-pfs handshakes.
   * Allowed values are 0-5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.0.
   * @param hsSecurityNonpfsPenalty set the hsSecurityNonpfsPenalty.
   */
  public void setHsSecurityNonpfsPenalty(Float  hsSecurityNonpfsPenalty) {
    this.hsSecurityNonpfsPenalty = hsSecurityNonpfsPenalty;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Score assigned when ocsp certificate status is set to revoked or issuer revoked.
   * Allowed values are 0.0-5.0.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.0.
   * @return hsSecurityOcspRevokedScore
   */
  public Float getHsSecurityOcspRevokedScore() {
    return hsSecurityOcspRevokedScore;
  }

  /**
   * This is the setter method to the attribute.
   * Score assigned when ocsp certificate status is set to revoked or issuer revoked.
   * Allowed values are 0.0-5.0.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.0.
   * @param hsSecurityOcspRevokedScore set the hsSecurityOcspRevokedScore.
   */
  public void setHsSecurityOcspRevokedScore(Float  hsSecurityOcspRevokedScore) {
    this.hsSecurityOcspRevokedScore = hsSecurityOcspRevokedScore;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Deprecated.
   * Allowed values are 0-5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.0.
   * @return hsSecuritySelfsignedcertPenalty
   */
  public Float getHsSecuritySelfsignedcertPenalty() {
    return hsSecuritySelfsignedcertPenalty;
  }

  /**
   * This is the setter method to the attribute.
   * Deprecated.
   * Allowed values are 0-5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.0.
   * @param hsSecuritySelfsignedcertPenalty set the hsSecuritySelfsignedcertPenalty.
   */
  public void setHsSecuritySelfsignedcertPenalty(Float  hsSecuritySelfsignedcertPenalty) {
    this.hsSecuritySelfsignedcertPenalty = hsSecuritySelfsignedcertPenalty;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Score assigned when supporting ssl3.0 encryption protocol.
   * Allowed values are 0-5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 3.5.
   * @return hsSecuritySsl30Score
   */
  public Float getHsSecuritySsl30Score() {
    return hsSecuritySsl30Score;
  }

  /**
   * This is the setter method to the attribute.
   * Score assigned when supporting ssl3.0 encryption protocol.
   * Allowed values are 0-5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 3.5.
   * @param hsSecuritySsl30Score set the hsSecuritySsl30Score.
   */
  public void setHsSecuritySsl30Score(Float  hsSecuritySsl30Score) {
    this.hsSecuritySsl30Score = hsSecuritySsl30Score;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Score assigned when supporting tls1.0 encryption protocol.
   * Allowed values are 0-5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5.0.
   * @return hsSecurityTls10Score
   */
  public Float getHsSecurityTls10Score() {
    return hsSecurityTls10Score;
  }

  /**
   * This is the setter method to the attribute.
   * Score assigned when supporting tls1.0 encryption protocol.
   * Allowed values are 0-5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5.0.
   * @param hsSecurityTls10Score set the hsSecurityTls10Score.
   */
  public void setHsSecurityTls10Score(Float  hsSecurityTls10Score) {
    this.hsSecurityTls10Score = hsSecurityTls10Score;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Score assigned when supporting tls1.1 encryption protocol.
   * Allowed values are 0-5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5.0.
   * @return hsSecurityTls11Score
   */
  public Float getHsSecurityTls11Score() {
    return hsSecurityTls11Score;
  }

  /**
   * This is the setter method to the attribute.
   * Score assigned when supporting tls1.1 encryption protocol.
   * Allowed values are 0-5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5.0.
   * @param hsSecurityTls11Score set the hsSecurityTls11Score.
   */
  public void setHsSecurityTls11Score(Float  hsSecurityTls11Score) {
    this.hsSecurityTls11Score = hsSecurityTls11Score;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Score assigned when supporting tls1.2 encryption protocol.
   * Allowed values are 0-5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5.0.
   * @return hsSecurityTls12Score
   */
  public Float getHsSecurityTls12Score() {
    return hsSecurityTls12Score;
  }

  /**
   * This is the setter method to the attribute.
   * Score assigned when supporting tls1.2 encryption protocol.
   * Allowed values are 0-5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5.0.
   * @param hsSecurityTls12Score set the hsSecurityTls12Score.
   */
  public void setHsSecurityTls12Score(Float  hsSecurityTls12Score) {
    this.hsSecurityTls12Score = hsSecurityTls12Score;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Score assigned when supporting tls1.3 encryption protocol.
   * Allowed values are 0-5.
   * Field introduced in 18.2.6.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5.0.
   * @return hsSecurityTls13Score
   */
  public Float getHsSecurityTls13Score() {
    return hsSecurityTls13Score;
  }

  /**
   * This is the setter method to the attribute.
   * Score assigned when supporting tls1.3 encryption protocol.
   * Allowed values are 0-5.
   * Field introduced in 18.2.6.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5.0.
   * @param hsSecurityTls13Score set the hsSecurityTls13Score.
   */
  public void setHsSecurityTls13Score(Float  hsSecurityTls13Score) {
    this.hsSecurityTls13Score = hsSecurityTls13Score;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Penalty for allowing weak signature algorithm(s).
   * Allowed values are 0-5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.0.
   * @return hsSecurityWeakSignatureAlgoPenalty
   */
  public Float getHsSecurityWeakSignatureAlgoPenalty() {
    return hsSecurityWeakSignatureAlgoPenalty;
  }

  /**
   * This is the setter method to the attribute.
   * Penalty for allowing weak signature algorithm(s).
   * Allowed values are 0-5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.0.
   * @param hsSecurityWeakSignatureAlgoPenalty set the hsSecurityWeakSignatureAlgoPenalty.
   */
  public void setHsSecurityWeakSignatureAlgoPenalty(Float  hsSecurityWeakSignatureAlgoPenalty) {
    this.hsSecurityWeakSignatureAlgoPenalty = hsSecurityWeakSignatureAlgoPenalty;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The name of the analytics profile.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * The name of the analytics profile.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * This flag sets the time duration of no live data traffic after which virtual service metrics processing is suspended.
   * It is applicable only when disable_ondemand_metrics is set to false.
   * Field introduced in 18.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1800.
   * @return ondemandMetricsIdleTimeout
   */
  public Integer getOndemandMetricsIdleTimeout() {
    return ondemandMetricsIdleTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * This flag sets the time duration of no live data traffic after which virtual service metrics processing is suspended.
   * It is applicable only when disable_ondemand_metrics is set to false.
   * Field introduced in 18.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1800.
   * @param ondemandMetricsIdleTimeout set the ondemandMetricsIdleTimeout.
   */
  public void setOndemandMetricsIdleTimeout(Integer  ondemandMetricsIdleTimeout) {
    this.ondemandMetricsIdleTimeout = ondemandMetricsIdleTimeout;
  }
  /**
   * This is the getter method this will return the attribute value.
   * List of http status code ranges to be excluded from being classified as an error.
   * @return ranges
   */
  public List<HTTPStatusRange> getRanges() {
    return ranges;
  }

  /**
   * This is the setter method. this will set the ranges
   * List of http status code ranges to be excluded from being classified as an error.
   * @return ranges
   */
  public void setRanges(List<HTTPStatusRange>  ranges) {
    this.ranges = ranges;
  }

  /**
   * This is the setter method this will set the ranges
   * List of http status code ranges to be excluded from being classified as an error.
   * @return ranges
   */
  public AnalyticsProfile addRangesItem(HTTPStatusRange rangesItem) {
    if (this.ranges == null) {
      this.ranges = new ArrayList<HTTPStatusRange>();
    }
    this.ranges.add(rangesItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Block of http response codes to be excluded from being classified as an error.
   * Enum options - AP_HTTP_RSP_4XX, AP_HTTP_RSP_5XX.
   * @return respCodeBlock
   */
  public List<String> getRespCodeBlock() {
    return respCodeBlock;
  }

  /**
   * This is the setter method. this will set the respCodeBlock
   * Block of http response codes to be excluded from being classified as an error.
   * Enum options - AP_HTTP_RSP_4XX, AP_HTTP_RSP_5XX.
   * @return respCodeBlock
   */
  public void setRespCodeBlock(List<String>  respCodeBlock) {
    this.respCodeBlock = respCodeBlock;
  }

  /**
   * This is the setter method this will set the respCodeBlock
   * Block of http response codes to be excluded from being classified as an error.
   * Enum options - AP_HTTP_RSP_4XX, AP_HTTP_RSP_5XX.
   * @return respCodeBlock
   */
  public AnalyticsProfile addRespCodeBlockItem(String respCodeBlockItem) {
    if (this.respCodeBlock == null) {
      this.respCodeBlock = new ArrayList<String>();
    }
    this.respCodeBlock.add(respCodeBlockItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Rules applied to the http application log for filtering sensitive information.
   * Field introduced in 17.2.10, 18.1.2.
   * @return sensitiveLogProfile
   */
  public SensitiveLogProfile getSensitiveLogProfile() {
    return sensitiveLogProfile;
  }

  /**
   * This is the setter method to the attribute.
   * Rules applied to the http application log for filtering sensitive information.
   * Field introduced in 17.2.10, 18.1.2.
   * @param sensitiveLogProfile set the sensitiveLogProfile.
   */
  public void setSensitiveLogProfile(SensitiveLogProfile sensitiveLogProfile) {
    this.sensitiveLogProfile = sensitiveLogProfile;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of sip messages added in logs for a sip transaction.
   * By default, this value is 20.
   * Allowed values are 1-1000.
   * Field introduced in 17.2.13, 18.1.5, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 20.
   * @return sipLogDepth
   */
  public Integer getSipLogDepth() {
    return sipLogDepth;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of sip messages added in logs for a sip transaction.
   * By default, this value is 20.
   * Allowed values are 1-1000.
   * Field introduced in 17.2.13, 18.1.5, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 20.
   * @param sipLogDepth set the sipLogDepth.
   */
  public void setSipLogDepth(Integer  sipLogDepth) {
    this.sipLogDepth = sipLogDepth;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type tenant.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type tenant.
   * @param tenantRef set the tenantRef.
   */
  public void setTenantRef(String  tenantRef) {
    this.tenantRef = tenantRef;
  }
/**
   * This is the getter method this will return the attribute value.
   * Avi controller URL of the object.
   * @return url
   */
  public String getUrl() {
    return url;
  }

  /**
   * This is the setter method. this will set the url
   * Avi controller URL of the object.
   * @return url
   */
  public void setUrl(String  url) {
    this.url = url;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Uuid of the analytics profile.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the analytics profile.
   * @param uuid set the uuid.
   */
  public void setUuid(String  uuid) {
    this.uuid = uuid;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  AnalyticsProfile objAnalyticsProfile = (AnalyticsProfile) o;
  return   Objects.equals(this.uuid, objAnalyticsProfile.uuid)&&
  Objects.equals(this.name, objAnalyticsProfile.name)&&
  Objects.equals(this.tenantRef, objAnalyticsProfile.tenantRef)&&
  Objects.equals(this.description, objAnalyticsProfile.description)&&
  Objects.equals(this.apdexResponseThreshold, objAnalyticsProfile.apdexResponseThreshold)&&
  Objects.equals(this.apdexResponseToleratedFactor, objAnalyticsProfile.apdexResponseToleratedFactor)&&
  Objects.equals(this.apdexServerResponseThreshold, objAnalyticsProfile.apdexServerResponseThreshold)&&
  Objects.equals(this.apdexServerResponseToleratedFactor, objAnalyticsProfile.apdexServerResponseToleratedFactor)&&
  Objects.equals(this.apdexRttThreshold, objAnalyticsProfile.apdexRttThreshold)&&
  Objects.equals(this.apdexRttToleratedFactor, objAnalyticsProfile.apdexRttToleratedFactor)&&
  Objects.equals(this.apdexServerRttThreshold, objAnalyticsProfile.apdexServerRttThreshold)&&
  Objects.equals(this.apdexServerRttToleratedFactor, objAnalyticsProfile.apdexServerRttToleratedFactor)&&
  Objects.equals(this.apdexRumThreshold, objAnalyticsProfile.apdexRumThreshold)&&
  Objects.equals(this.apdexRumToleratedFactor, objAnalyticsProfile.apdexRumToleratedFactor)&&
  Objects.equals(this.connLossyTotalRexmtThreshold, objAnalyticsProfile.connLossyTotalRexmtThreshold)&&
  Objects.equals(this.connLossyTimeoRexmtThreshold, objAnalyticsProfile.connLossyTimeoRexmtThreshold)&&
  Objects.equals(this.connLossyOooThreshold, objAnalyticsProfile.connLossyOooThreshold)&&
  Objects.equals(this.connLossyZeroWinSizeEventThreshold, objAnalyticsProfile.connLossyZeroWinSizeEventThreshold)&&
  Objects.equals(this.connServerLossyTotalRexmtThreshold, objAnalyticsProfile.connServerLossyTotalRexmtThreshold)&&
  Objects.equals(this.connServerLossyTimeoRexmtThreshold, objAnalyticsProfile.connServerLossyTimeoRexmtThreshold)&&
  Objects.equals(this.connServerLossyOooThreshold, objAnalyticsProfile.connServerLossyOooThreshold)&&
  Objects.equals(this.connServerLossyZeroWinSizeEventThreshold, objAnalyticsProfile.connServerLossyZeroWinSizeEventThreshold)&&
  Objects.equals(this.excludeClientCloseBeforeRequestAsError, objAnalyticsProfile.excludeClientCloseBeforeRequestAsError)&&
  Objects.equals(this.excludeTcpResetAsError, objAnalyticsProfile.excludeTcpResetAsError)&&
  Objects.equals(this.excludeServerTcpResetAsError, objAnalyticsProfile.excludeServerTcpResetAsError)&&
  Objects.equals(this.excludePersistenceChangeAsError, objAnalyticsProfile.excludePersistenceChangeAsError)&&
  Objects.equals(this.excludeSynRetransmitAsError, objAnalyticsProfile.excludeSynRetransmitAsError)&&
  Objects.equals(this.excludeInvalidDnsQueryAsError, objAnalyticsProfile.excludeInvalidDnsQueryAsError)&&
  Objects.equals(this.excludeInvalidDnsDomainAsError, objAnalyticsProfile.excludeInvalidDnsDomainAsError)&&
  Objects.equals(this.excludeNoDnsRecordAsError, objAnalyticsProfile.excludeNoDnsRecordAsError)&&
  Objects.equals(this.excludeUnsupportedDnsQueryAsError, objAnalyticsProfile.excludeUnsupportedDnsQueryAsError)&&
  Objects.equals(this.hsPerformanceBoost, objAnalyticsProfile.hsPerformanceBoost)&&
  Objects.equals(this.hsMaxAnomalyPenalty, objAnalyticsProfile.hsMaxAnomalyPenalty)&&
  Objects.equals(this.hsMaxResourcesPenalty, objAnalyticsProfile.hsMaxResourcesPenalty)&&
  Objects.equals(this.hsMaxSecurityPenalty, objAnalyticsProfile.hsMaxSecurityPenalty)&&
  Objects.equals(this.hsSecurityNonpfsPenalty, objAnalyticsProfile.hsSecurityNonpfsPenalty)&&
  Objects.equals(this.hsSecurityWeakSignatureAlgoPenalty, objAnalyticsProfile.hsSecurityWeakSignatureAlgoPenalty)&&
  Objects.equals(this.hsSecuritySsl30Score, objAnalyticsProfile.hsSecuritySsl30Score)&&
  Objects.equals(this.hsSecurityTls10Score, objAnalyticsProfile.hsSecurityTls10Score)&&
  Objects.equals(this.hsSecurityTls11Score, objAnalyticsProfile.hsSecurityTls11Score)&&
  Objects.equals(this.hsSecurityTls12Score, objAnalyticsProfile.hsSecurityTls12Score)&&
  Objects.equals(this.hsEventThrottleWindow, objAnalyticsProfile.hsEventThrottleWindow)&&
  Objects.equals(this.hsMinDosRate, objAnalyticsProfile.hsMinDosRate)&&
  Objects.equals(this.hsSecurityCertscoreExpired, objAnalyticsProfile.hsSecurityCertscoreExpired)&&
  Objects.equals(this.hsSecurityCertscoreLe07D, objAnalyticsProfile.hsSecurityCertscoreLe07D)&&
  Objects.equals(this.hsSecurityCertscoreLe30D, objAnalyticsProfile.hsSecurityCertscoreLe30D)&&
  Objects.equals(this.hsSecurityCertscoreGt30D, objAnalyticsProfile.hsSecurityCertscoreGt30D)&&
  Objects.equals(this.hsSecurityCipherscoreEq000B, objAnalyticsProfile.hsSecurityCipherscoreEq000B)&&
  Objects.equals(this.hsSecurityCipherscoreLt128B, objAnalyticsProfile.hsSecurityCipherscoreLt128B)&&
  Objects.equals(this.hsSecurityCipherscoreGe128B, objAnalyticsProfile.hsSecurityCipherscoreGe128B)&&
  Objects.equals(this.hsSecuritySelfsignedcertPenalty, objAnalyticsProfile.hsSecuritySelfsignedcertPenalty)&&
  Objects.equals(this.hsSecurityEncalgoScoreRc4, objAnalyticsProfile.hsSecurityEncalgoScoreRc4)&&
  Objects.equals(this.hsSecurityEncalgoScoreNone, objAnalyticsProfile.hsSecurityEncalgoScoreNone)&&
  Objects.equals(this.hsSecurityChainInvalidityPenalty, objAnalyticsProfile.hsSecurityChainInvalidityPenalty)&&
  Objects.equals(this.hsSecurityHstsPenalty, objAnalyticsProfile.hsSecurityHstsPenalty)&&
  Objects.equals(this.disableServerAnalytics, objAnalyticsProfile.disableServerAnalytics)&&
  Objects.equals(this.disableSeAnalytics, objAnalyticsProfile.disableSeAnalytics)&&
  Objects.equals(this.hsPscoreTrafficThresholdL4Client, objAnalyticsProfile.hsPscoreTrafficThresholdL4Client)&&
  Objects.equals(this.hsPscoreTrafficThresholdL4Server, objAnalyticsProfile.hsPscoreTrafficThresholdL4Server)&&
  Objects.equals(this.excludeGsDownAsError, objAnalyticsProfile.excludeGsDownAsError)&&
  Objects.equals(this.excludeNoValidGsMemberAsError, objAnalyticsProfile.excludeNoValidGsMemberAsError)&&
  Objects.equals(this.clientLogConfig, objAnalyticsProfile.clientLogConfig)&&
  Objects.equals(this.clientLogStreamingConfig, objAnalyticsProfile.clientLogStreamingConfig)&&
  Objects.equals(this.excludeHttpErrorCodes, objAnalyticsProfile.excludeHttpErrorCodes)&&
  Objects.equals(this.ranges, objAnalyticsProfile.ranges)&&
  Objects.equals(this.respCodeBlock, objAnalyticsProfile.respCodeBlock)&&
  Objects.equals(this.excludeServerDnsErrorAsError, objAnalyticsProfile.excludeServerDnsErrorAsError)&&
  Objects.equals(this.excludeDnsPolicyDropAsSignificant, objAnalyticsProfile.excludeDnsPolicyDropAsSignificant)&&
  Objects.equals(this.disableOndemandMetrics, objAnalyticsProfile.disableOndemandMetrics)&&
  Objects.equals(this.ondemandMetricsIdleTimeout, objAnalyticsProfile.ondemandMetricsIdleTimeout)&&
  Objects.equals(this.sensitiveLogProfile, objAnalyticsProfile.sensitiveLogProfile)&&
  Objects.equals(this.sipLogDepth, objAnalyticsProfile.sipLogDepth)&&
  Objects.equals(this.excludeSipErrorCodes, objAnalyticsProfile.excludeSipErrorCodes)&&
  Objects.equals(this.healthscoreMaxServerLimit, objAnalyticsProfile.healthscoreMaxServerLimit)&&
  Objects.equals(this.enableAdvancedAnalytics, objAnalyticsProfile.enableAdvancedAnalytics)&&
  Objects.equals(this.disableVsAnalytics, objAnalyticsProfile.disableVsAnalytics)&&
  Objects.equals(this.hsSecurityTls13Score, objAnalyticsProfile.hsSecurityTls13Score)&&
  Objects.equals(this.excludeRevokedOcspResponsesAsError, objAnalyticsProfile.excludeRevokedOcspResponsesAsError)&&
  Objects.equals(this.excludeStaleOcspResponsesAsError, objAnalyticsProfile.excludeStaleOcspResponsesAsError)&&
  Objects.equals(this.excludeIssuerRevokedOcspResponsesAsError, objAnalyticsProfile.excludeIssuerRevokedOcspResponsesAsError)&&
  Objects.equals(this.excludeUnavailableOcspResponsesAsError, objAnalyticsProfile.excludeUnavailableOcspResponsesAsError)&&
  Objects.equals(this.hsSecurityOcspRevokedScore, objAnalyticsProfile.hsSecurityOcspRevokedScore)&&
  Objects.equals(this.enableAdaptiveConfig, objAnalyticsProfile.enableAdaptiveConfig);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class AnalyticsProfile {\n");
      sb.append("    apdexResponseThreshold: ").append(toIndentedString(apdexResponseThreshold)).append("\n");
        sb.append("    apdexResponseToleratedFactor: ").append(toIndentedString(apdexResponseToleratedFactor)).append("\n");
        sb.append("    apdexRttThreshold: ").append(toIndentedString(apdexRttThreshold)).append("\n");
        sb.append("    apdexRttToleratedFactor: ").append(toIndentedString(apdexRttToleratedFactor)).append("\n");
        sb.append("    apdexRumThreshold: ").append(toIndentedString(apdexRumThreshold)).append("\n");
        sb.append("    apdexRumToleratedFactor: ").append(toIndentedString(apdexRumToleratedFactor)).append("\n");
        sb.append("    apdexServerResponseThreshold: ").append(toIndentedString(apdexServerResponseThreshold)).append("\n");
        sb.append("    apdexServerResponseToleratedFactor: ").append(toIndentedString(apdexServerResponseToleratedFactor)).append("\n");
        sb.append("    apdexServerRttThreshold: ").append(toIndentedString(apdexServerRttThreshold)).append("\n");
        sb.append("    apdexServerRttToleratedFactor: ").append(toIndentedString(apdexServerRttToleratedFactor)).append("\n");
        sb.append("    clientLogConfig: ").append(toIndentedString(clientLogConfig)).append("\n");
        sb.append("    clientLogStreamingConfig: ").append(toIndentedString(clientLogStreamingConfig)).append("\n");
        sb.append("    connLossyOooThreshold: ").append(toIndentedString(connLossyOooThreshold)).append("\n");
        sb.append("    connLossyTimeoRexmtThreshold: ").append(toIndentedString(connLossyTimeoRexmtThreshold)).append("\n");
        sb.append("    connLossyTotalRexmtThreshold: ").append(toIndentedString(connLossyTotalRexmtThreshold)).append("\n");
        sb.append("    connLossyZeroWinSizeEventThreshold: ").append(toIndentedString(connLossyZeroWinSizeEventThreshold)).append("\n");
        sb.append("    connServerLossyOooThreshold: ").append(toIndentedString(connServerLossyOooThreshold)).append("\n");
        sb.append("    connServerLossyTimeoRexmtThreshold: ").append(toIndentedString(connServerLossyTimeoRexmtThreshold)).append("\n");
        sb.append("    connServerLossyTotalRexmtThreshold: ").append(toIndentedString(connServerLossyTotalRexmtThreshold)).append("\n");
        sb.append("    connServerLossyZeroWinSizeEventThreshold: ").append(toIndentedString(connServerLossyZeroWinSizeEventThreshold)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    disableOndemandMetrics: ").append(toIndentedString(disableOndemandMetrics)).append("\n");
        sb.append("    disableSeAnalytics: ").append(toIndentedString(disableSeAnalytics)).append("\n");
        sb.append("    disableServerAnalytics: ").append(toIndentedString(disableServerAnalytics)).append("\n");
        sb.append("    disableVsAnalytics: ").append(toIndentedString(disableVsAnalytics)).append("\n");
        sb.append("    enableAdaptiveConfig: ").append(toIndentedString(enableAdaptiveConfig)).append("\n");
        sb.append("    enableAdvancedAnalytics: ").append(toIndentedString(enableAdvancedAnalytics)).append("\n");
        sb.append("    excludeClientCloseBeforeRequestAsError: ").append(toIndentedString(excludeClientCloseBeforeRequestAsError)).append("\n");
        sb.append("    excludeDnsPolicyDropAsSignificant: ").append(toIndentedString(excludeDnsPolicyDropAsSignificant)).append("\n");
        sb.append("    excludeGsDownAsError: ").append(toIndentedString(excludeGsDownAsError)).append("\n");
        sb.append("    excludeHttpErrorCodes: ").append(toIndentedString(excludeHttpErrorCodes)).append("\n");
        sb.append("    excludeInvalidDnsDomainAsError: ").append(toIndentedString(excludeInvalidDnsDomainAsError)).append("\n");
        sb.append("    excludeInvalidDnsQueryAsError: ").append(toIndentedString(excludeInvalidDnsQueryAsError)).append("\n");
        sb.append("    excludeIssuerRevokedOcspResponsesAsError: ").append(toIndentedString(excludeIssuerRevokedOcspResponsesAsError)).append("\n");
        sb.append("    excludeNoDnsRecordAsError: ").append(toIndentedString(excludeNoDnsRecordAsError)).append("\n");
        sb.append("    excludeNoValidGsMemberAsError: ").append(toIndentedString(excludeNoValidGsMemberAsError)).append("\n");
        sb.append("    excludePersistenceChangeAsError: ").append(toIndentedString(excludePersistenceChangeAsError)).append("\n");
        sb.append("    excludeRevokedOcspResponsesAsError: ").append(toIndentedString(excludeRevokedOcspResponsesAsError)).append("\n");
        sb.append("    excludeServerDnsErrorAsError: ").append(toIndentedString(excludeServerDnsErrorAsError)).append("\n");
        sb.append("    excludeServerTcpResetAsError: ").append(toIndentedString(excludeServerTcpResetAsError)).append("\n");
        sb.append("    excludeSipErrorCodes: ").append(toIndentedString(excludeSipErrorCodes)).append("\n");
        sb.append("    excludeStaleOcspResponsesAsError: ").append(toIndentedString(excludeStaleOcspResponsesAsError)).append("\n");
        sb.append("    excludeSynRetransmitAsError: ").append(toIndentedString(excludeSynRetransmitAsError)).append("\n");
        sb.append("    excludeTcpResetAsError: ").append(toIndentedString(excludeTcpResetAsError)).append("\n");
        sb.append("    excludeUnavailableOcspResponsesAsError: ").append(toIndentedString(excludeUnavailableOcspResponsesAsError)).append("\n");
        sb.append("    excludeUnsupportedDnsQueryAsError: ").append(toIndentedString(excludeUnsupportedDnsQueryAsError)).append("\n");
        sb.append("    healthscoreMaxServerLimit: ").append(toIndentedString(healthscoreMaxServerLimit)).append("\n");
        sb.append("    hsEventThrottleWindow: ").append(toIndentedString(hsEventThrottleWindow)).append("\n");
        sb.append("    hsMaxAnomalyPenalty: ").append(toIndentedString(hsMaxAnomalyPenalty)).append("\n");
        sb.append("    hsMaxResourcesPenalty: ").append(toIndentedString(hsMaxResourcesPenalty)).append("\n");
        sb.append("    hsMaxSecurityPenalty: ").append(toIndentedString(hsMaxSecurityPenalty)).append("\n");
        sb.append("    hsMinDosRate: ").append(toIndentedString(hsMinDosRate)).append("\n");
        sb.append("    hsPerformanceBoost: ").append(toIndentedString(hsPerformanceBoost)).append("\n");
        sb.append("    hsPscoreTrafficThresholdL4Client: ").append(toIndentedString(hsPscoreTrafficThresholdL4Client)).append("\n");
        sb.append("    hsPscoreTrafficThresholdL4Server: ").append(toIndentedString(hsPscoreTrafficThresholdL4Server)).append("\n");
        sb.append("    hsSecurityCertscoreExpired: ").append(toIndentedString(hsSecurityCertscoreExpired)).append("\n");
        sb.append("    hsSecurityCertscoreGt30D: ").append(toIndentedString(hsSecurityCertscoreGt30D)).append("\n");
        sb.append("    hsSecurityCertscoreLe07D: ").append(toIndentedString(hsSecurityCertscoreLe07D)).append("\n");
        sb.append("    hsSecurityCertscoreLe30D: ").append(toIndentedString(hsSecurityCertscoreLe30D)).append("\n");
        sb.append("    hsSecurityChainInvalidityPenalty: ").append(toIndentedString(hsSecurityChainInvalidityPenalty)).append("\n");
        sb.append("    hsSecurityCipherscoreEq000B: ").append(toIndentedString(hsSecurityCipherscoreEq000B)).append("\n");
        sb.append("    hsSecurityCipherscoreGe128B: ").append(toIndentedString(hsSecurityCipherscoreGe128B)).append("\n");
        sb.append("    hsSecurityCipherscoreLt128B: ").append(toIndentedString(hsSecurityCipherscoreLt128B)).append("\n");
        sb.append("    hsSecurityEncalgoScoreNone: ").append(toIndentedString(hsSecurityEncalgoScoreNone)).append("\n");
        sb.append("    hsSecurityEncalgoScoreRc4: ").append(toIndentedString(hsSecurityEncalgoScoreRc4)).append("\n");
        sb.append("    hsSecurityHstsPenalty: ").append(toIndentedString(hsSecurityHstsPenalty)).append("\n");
        sb.append("    hsSecurityNonpfsPenalty: ").append(toIndentedString(hsSecurityNonpfsPenalty)).append("\n");
        sb.append("    hsSecurityOcspRevokedScore: ").append(toIndentedString(hsSecurityOcspRevokedScore)).append("\n");
        sb.append("    hsSecuritySelfsignedcertPenalty: ").append(toIndentedString(hsSecuritySelfsignedcertPenalty)).append("\n");
        sb.append("    hsSecuritySsl30Score: ").append(toIndentedString(hsSecuritySsl30Score)).append("\n");
        sb.append("    hsSecurityTls10Score: ").append(toIndentedString(hsSecurityTls10Score)).append("\n");
        sb.append("    hsSecurityTls11Score: ").append(toIndentedString(hsSecurityTls11Score)).append("\n");
        sb.append("    hsSecurityTls12Score: ").append(toIndentedString(hsSecurityTls12Score)).append("\n");
        sb.append("    hsSecurityTls13Score: ").append(toIndentedString(hsSecurityTls13Score)).append("\n");
        sb.append("    hsSecurityWeakSignatureAlgoPenalty: ").append(toIndentedString(hsSecurityWeakSignatureAlgoPenalty)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    ondemandMetricsIdleTimeout: ").append(toIndentedString(ondemandMetricsIdleTimeout)).append("\n");
        sb.append("    ranges: ").append(toIndentedString(ranges)).append("\n");
        sb.append("    respCodeBlock: ").append(toIndentedString(respCodeBlock)).append("\n");
        sb.append("    sensitiveLogProfile: ").append(toIndentedString(sensitiveLogProfile)).append("\n");
        sb.append("    sipLogDepth: ").append(toIndentedString(sipLogDepth)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
            sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
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

