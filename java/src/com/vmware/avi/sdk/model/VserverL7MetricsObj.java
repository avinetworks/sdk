package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VserverL7MetricsObj is a POJO class extends AviRestResource that used for creating
 * VserverL7MetricsObj.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VserverL7MetricsObj  {
    @JsonProperty("apdexr")
    private Float apdexr = null;

    @JsonProperty("avg_application_response_time")
    private Float avgApplicationResponseTime = null;

    @JsonProperty("avg_blocking_time")
    private Float avgBlockingTime = null;

    @JsonProperty("avg_browser_rendering_time")
    private Float avgBrowserRenderingTime = null;

    @JsonProperty("avg_cache_bytes")
    private Float avgCacheBytes = null;

    @JsonProperty("avg_cache_hits")
    private Float avgCacheHits = null;

    @JsonProperty("avg_cacheable_bytes")
    private Float avgCacheableBytes = null;

    @JsonProperty("avg_cacheable_hits")
    private Float avgCacheableHits = null;

    @JsonProperty("avg_client_data_transfer_time")
    private Float avgClientDataTransferTime = null;

    @JsonProperty("avg_client_rtt")
    private Float avgClientRtt = null;

    @JsonProperty("avg_client_txn_latency")
    private Float avgClientTxnLatency = null;

    @JsonProperty("avg_complete_responses")
    private Float avgCompleteResponses = null;

    @JsonProperty("avg_connection_time")
    private Float avgConnectionTime = null;

    @JsonProperty("avg_dns_lookup_time")
    private Float avgDnsLookupTime = null;

    @JsonProperty("avg_dom_content_load_time")
    private Float avgDomContentLoadTime = null;

    @JsonProperty("avg_error_responses")
    private Float avgErrorResponses = null;

    @JsonProperty("avg_errors_excluded")
    private Float avgErrorsExcluded = null;

    @JsonProperty("avg_frustrated_responses")
    private Float avgFrustratedResponses = null;

    @JsonProperty("avg_http_headers_bytes")
    private Float avgHttpHeadersBytes = null;

    @JsonProperty("avg_http_headers_count")
    private Float avgHttpHeadersCount = null;

    @JsonProperty("avg_http_params_count")
    private Float avgHttpParamsCount = null;

    @JsonProperty("avg_page_download_time")
    private Float avgPageDownloadTime = null;

    @JsonProperty("avg_page_load_time")
    private Float avgPageLoadTime = null;

    @JsonProperty("avg_params_per_req")
    private Float avgParamsPerReq = null;

    @JsonProperty("avg_post_bytes")
    private Float avgPostBytes = null;

    @JsonProperty("avg_post_compression_bytes")
    private Float avgPostCompressionBytes = null;

    @JsonProperty("avg_pre_compression_bytes")
    private Float avgPreCompressionBytes = null;

    @JsonProperty("avg_redirection_time")
    private Float avgRedirectionTime = null;

    @JsonProperty("avg_reqs_per_session")
    private Float avgReqsPerSession = null;

    @JsonProperty("avg_resp_1xx")
    private Float avgResp1Xx = null;

    @JsonProperty("avg_resp_2xx")
    private Float avgResp2Xx = null;

    @JsonProperty("avg_resp_3xx")
    private Float avgResp3Xx = null;

    @JsonProperty("avg_resp_4xx")
    private Float avgResp4Xx = null;

    @JsonProperty("avg_resp_4xx_avi_errors")
    private Float avgResp4XxAviErrors = null;

    @JsonProperty("avg_resp_5xx")
    private Float avgResp5Xx = null;

    @JsonProperty("avg_resp_5xx_avi_errors")
    private Float avgResp5XxAviErrors = null;

    @JsonProperty("avg_rum_client_data_transfer_time")
    private Float avgRumClientDataTransferTime = null;

    @JsonProperty("avg_satisfactory_responses")
    private Float avgSatisfactoryResponses = null;

    @JsonProperty("avg_server_rtt")
    private Float avgServerRtt = null;

    @JsonProperty("avg_service_time")
    private Float avgServiceTime = null;

    @JsonProperty("avg_ssl_auth_dsa")
    private Float avgSslAuthDsa = null;

    @JsonProperty("avg_ssl_auth_ecdsa")
    private Float avgSslAuthEcdsa = null;

    @JsonProperty("avg_ssl_auth_rsa")
    private Float avgSslAuthRsa = null;

    @JsonProperty("avg_ssl_connections")
    private Float avgSslConnections = null;

    @JsonProperty("avg_ssl_ecdsa_non_pfs")
    private Float avgSslEcdsaNonPfs = null;

    @JsonProperty("avg_ssl_ecdsa_pfs")
    private Float avgSslEcdsaPfs = null;

    @JsonProperty("avg_ssl_errors")
    private Float avgSslErrors = null;

    @JsonProperty("avg_ssl_failed_connections")
    private Float avgSslFailedConnections = null;

    @JsonProperty("avg_ssl_handshake_network_errors")
    private Float avgSslHandshakeNetworkErrors = null;

    @JsonProperty("avg_ssl_handshake_protocol_errors")
    private Float avgSslHandshakeProtocolErrors = null;

    @JsonProperty("avg_ssl_handshakes_new")
    private Float avgSslHandshakesNew = null;

    @JsonProperty("avg_ssl_handshakes_non_pfs")
    private Float avgSslHandshakesNonPfs = null;

    @JsonProperty("avg_ssl_handshakes_pfs")
    private Float avgSslHandshakesPfs = null;

    @JsonProperty("avg_ssl_handshakes_reused")
    private Float avgSslHandshakesReused = null;

    @JsonProperty("avg_ssl_handshakes_timedout")
    private Float avgSslHandshakesTimedout = null;

    @JsonProperty("avg_ssl_kx_dh")
    private Float avgSslKxDh = null;

    @JsonProperty("avg_ssl_kx_ecdh")
    private Float avgSslKxEcdh = null;

    @JsonProperty("avg_ssl_kx_rsa")
    private Float avgSslKxRsa = null;

    @JsonProperty("avg_ssl_rsa_non_pfs")
    private Float avgSslRsaNonPfs = null;

    @JsonProperty("avg_ssl_rsa_pfs")
    private Float avgSslRsaPfs = null;

    @JsonProperty("avg_ssl_ver_ssl30")
    private Float avgSslVerSsl30 = null;

    @JsonProperty("avg_ssl_ver_tls10")
    private Float avgSslVerTls10 = null;

    @JsonProperty("avg_ssl_ver_tls11")
    private Float avgSslVerTls11 = null;

    @JsonProperty("avg_ssl_ver_tls12")
    private Float avgSslVerTls12 = null;

    @JsonProperty("avg_ssl_ver_tls13")
    private Float avgSslVerTls13 = null;

    @JsonProperty("avg_tolerated_responses")
    private Float avgToleratedResponses = null;

    @JsonProperty("avg_total_http2_requests")
    private Float avgTotalHttp2Requests = null;

    @JsonProperty("avg_total_requests")
    private Float avgTotalRequests = null;

    @JsonProperty("avg_uri_length")
    private Float avgUriLength = null;

    @JsonProperty("avg_waf_attacks")
    private Float avgWafAttacks = null;

    @JsonProperty("avg_waf_disabled")
    private Float avgWafDisabled = null;

    @JsonProperty("avg_waf_evaluated")
    private Float avgWafEvaluated = null;

    @JsonProperty("avg_waf_evaluated_request_body_phase")
    private Float avgWafEvaluatedRequestBodyPhase = null;

    @JsonProperty("avg_waf_evaluated_request_header_phase")
    private Float avgWafEvaluatedRequestHeaderPhase = null;

    @JsonProperty("avg_waf_evaluated_response_body_phase")
    private Float avgWafEvaluatedResponseBodyPhase = null;

    @JsonProperty("avg_waf_evaluated_response_header_phase")
    private Float avgWafEvaluatedResponseHeaderPhase = null;

    @JsonProperty("avg_waf_flagged")
    private Float avgWafFlagged = null;

    @JsonProperty("avg_waf_flagged_request_body_phase")
    private Float avgWafFlaggedRequestBodyPhase = null;

    @JsonProperty("avg_waf_flagged_request_header_phase")
    private Float avgWafFlaggedRequestHeaderPhase = null;

    @JsonProperty("avg_waf_flagged_response_body_phase")
    private Float avgWafFlaggedResponseBodyPhase = null;

    @JsonProperty("avg_waf_flagged_response_header_phase")
    private Float avgWafFlaggedResponseHeaderPhase = null;

    @JsonProperty("avg_waf_latency_request_body_phase")
    private Float avgWafLatencyRequestBodyPhase = null;

    @JsonProperty("avg_waf_latency_request_header_phase")
    private Float avgWafLatencyRequestHeaderPhase = null;

    @JsonProperty("avg_waf_latency_response_body_phase")
    private Float avgWafLatencyResponseBodyPhase = null;

    @JsonProperty("avg_waf_latency_response_header_phase")
    private Float avgWafLatencyResponseHeaderPhase = null;

    @JsonProperty("avg_waf_matched")
    private Float avgWafMatched = null;

    @JsonProperty("avg_waf_matched_request_body_phase")
    private Float avgWafMatchedRequestBodyPhase = null;

    @JsonProperty("avg_waf_matched_request_header_phase")
    private Float avgWafMatchedRequestHeaderPhase = null;

    @JsonProperty("avg_waf_matched_response_body_phase")
    private Float avgWafMatchedResponseBodyPhase = null;

    @JsonProperty("avg_waf_matched_response_header_phase")
    private Float avgWafMatchedResponseHeaderPhase = null;

    @JsonProperty("avg_waf_rejected")
    private Float avgWafRejected = null;

    @JsonProperty("avg_waf_rejected_request_body_phase")
    private Float avgWafRejectedRequestBodyPhase = null;

    @JsonProperty("avg_waf_rejected_request_header_phase")
    private Float avgWafRejectedRequestHeaderPhase = null;

    @JsonProperty("avg_waf_rejected_response_body_phase")
    private Float avgWafRejectedResponseBodyPhase = null;

    @JsonProperty("avg_waf_rejected_response_header_phase")
    private Float avgWafRejectedResponseHeaderPhase = null;

    @JsonProperty("avg_waiting_time")
    private Float avgWaitingTime = null;

    @JsonProperty("max_concurrent_sessions")
    private Float maxConcurrentSessions = null;

    @JsonProperty("max_ssl_open_sessions")
    private Float maxSslOpenSessions = null;

    @JsonProperty("node_obj_id")
    private String nodeObjId = null;

    @JsonProperty("pct_cache_hits")
    private Float pctCacheHits = null;

    @JsonProperty("pct_cacheable_hits")
    private Float pctCacheableHits = null;

    @JsonProperty("pct_get_reqs")
    private Float pctGetReqs = null;

    @JsonProperty("pct_post_reqs")
    private Float pctPostReqs = null;

    @JsonProperty("pct_response_errors")
    private Float pctResponseErrors = null;

    @JsonProperty("pct_ssl_failed_connections")
    private Float pctSslFailedConnections = null;

    @JsonProperty("pct_waf_attacks")
    private Float pctWafAttacks = null;

    @JsonProperty("pct_waf_disabled")
    private Float pctWafDisabled = null;

    @JsonProperty("pct_waf_evaluated")
    private Float pctWafEvaluated = null;

    @JsonProperty("pct_waf_flagged")
    private Float pctWafFlagged = null;

    @JsonProperty("pct_waf_matched")
    private Float pctWafMatched = null;

    @JsonProperty("pct_waf_rejected")
    private Float pctWafRejected = null;

    @JsonProperty("rum_apdexr")
    private Float rumApdexr = null;

    @JsonProperty("ssl_protocol_strength")
    private Float sslProtocolStrength = null;

    @JsonProperty("sum_application_response_time")
    private Float sumApplicationResponseTime = null;

    @JsonProperty("sum_blocking_time")
    private Float sumBlockingTime = null;

    @JsonProperty("sum_browser_rendering_time")
    private Float sumBrowserRenderingTime = null;

    @JsonProperty("sum_client_data_transfer_time")
    private Float sumClientDataTransferTime = null;

    @JsonProperty("sum_client_rtt")
    private Float sumClientRtt = null;

    @JsonProperty("sum_connection_time")
    private Float sumConnectionTime = null;

    @JsonProperty("sum_dns_lookup_time")
    private Float sumDnsLookupTime = null;

    @JsonProperty("sum_dom_content_load_time")
    private Float sumDomContentLoadTime = null;

    @JsonProperty("sum_errors")
    private Float sumErrors = null;

    @JsonProperty("sum_finished_sessions")
    private Float sumFinishedSessions = null;

    @JsonProperty("sum_get_client_txn_latency")
    private Float sumGetClientTxnLatency = null;

    @JsonProperty("sum_get_client_txn_latency_bucket1")
    private Float sumGetClientTxnLatencyBucket1 = null;

    @JsonProperty("sum_get_client_txn_latency_bucket2")
    private Float sumGetClientTxnLatencyBucket2 = null;

    @JsonProperty("sum_get_reqs")
    private Float sumGetReqs = null;

    @JsonProperty("sum_http_headers_bytes")
    private Float sumHttpHeadersBytes = null;

    @JsonProperty("sum_http_headers_count")
    private Float sumHttpHeadersCount = null;

    @JsonProperty("sum_http_params_count")
    private Float sumHttpParamsCount = null;

    @JsonProperty("sum_num_page_load_time_bucket1")
    private Float sumNumPageLoadTimeBucket1 = null;

    @JsonProperty("sum_num_page_load_time_bucket2")
    private Float sumNumPageLoadTimeBucket2 = null;

    @JsonProperty("sum_num_rum_samples")
    private Float sumNumRumSamples = null;

    @JsonProperty("sum_other_client_txn_latency")
    private Float sumOtherClientTxnLatency = null;

    @JsonProperty("sum_other_client_txn_latency_bucket1")
    private Float sumOtherClientTxnLatencyBucket1 = null;

    @JsonProperty("sum_other_client_txn_latency_bucket2")
    private Float sumOtherClientTxnLatencyBucket2 = null;

    @JsonProperty("sum_other_reqs")
    private Float sumOtherReqs = null;

    @JsonProperty("sum_page_download_time")
    private Float sumPageDownloadTime = null;

    @JsonProperty("sum_page_load_time")
    private Float sumPageLoadTime = null;

    @JsonProperty("sum_post_bytes")
    private Float sumPostBytes = null;

    @JsonProperty("sum_post_client_txn_latency")
    private Float sumPostClientTxnLatency = null;

    @JsonProperty("sum_post_client_txn_latency_bucket1")
    private Float sumPostClientTxnLatencyBucket1 = null;

    @JsonProperty("sum_post_client_txn_latency_bucket2")
    private Float sumPostClientTxnLatencyBucket2 = null;

    @JsonProperty("sum_post_reqs")
    private Float sumPostReqs = null;

    @JsonProperty("sum_redirection_time")
    private Float sumRedirectionTime = null;

    @JsonProperty("sum_reqs_finished_sessions")
    private Float sumReqsFinishedSessions = null;

    @JsonProperty("sum_reqs_with_params")
    private Float sumReqsWithParams = null;

    @JsonProperty("sum_resp_1xx")
    private Float sumResp1Xx = null;

    @JsonProperty("sum_resp_2xx")
    private Float sumResp2Xx = null;

    @JsonProperty("sum_resp_3xx")
    private Float sumResp3Xx = null;

    @JsonProperty("sum_resp_4xx")
    private Float sumResp4Xx = null;

    @JsonProperty("sum_resp_5xx")
    private Float sumResp5Xx = null;

    @JsonProperty("sum_rum_client_data_transfer_time")
    private Float sumRumClientDataTransferTime = null;

    @JsonProperty("sum_server_rtt")
    private Float sumServerRtt = null;

    @JsonProperty("sum_service_time")
    private Float sumServiceTime = null;

    @JsonProperty("sum_total_responses")
    private Float sumTotalResponses = null;

    @JsonProperty("sum_uri_length")
    private Float sumUriLength = null;

    @JsonProperty("sum_waf_attacks")
    private Float sumWafAttacks = null;

    @JsonProperty("sum_waf_disabled")
    private Float sumWafDisabled = null;

    @JsonProperty("sum_waf_evaluated_request_body_phase")
    private Float sumWafEvaluatedRequestBodyPhase = null;

    @JsonProperty("sum_waf_evaluated_request_header_phase")
    private Float sumWafEvaluatedRequestHeaderPhase = null;

    @JsonProperty("sum_waf_evaluated_response_body_phase")
    private Float sumWafEvaluatedResponseBodyPhase = null;

    @JsonProperty("sum_waf_evaluated_response_header_phase")
    private Float sumWafEvaluatedResponseHeaderPhase = null;

    @JsonProperty("sum_waf_flagged")
    private Float sumWafFlagged = null;

    @JsonProperty("sum_waf_flagged_request_body_phase")
    private Float sumWafFlaggedRequestBodyPhase = null;

    @JsonProperty("sum_waf_flagged_request_header_phase")
    private Float sumWafFlaggedRequestHeaderPhase = null;

    @JsonProperty("sum_waf_flagged_response_body_phase")
    private Float sumWafFlaggedResponseBodyPhase = null;

    @JsonProperty("sum_waf_flagged_response_header_phase")
    private Float sumWafFlaggedResponseHeaderPhase = null;

    @JsonProperty("sum_waf_latency_request_body_phase")
    private Float sumWafLatencyRequestBodyPhase = null;

    @JsonProperty("sum_waf_latency_request_header_phase")
    private Float sumWafLatencyRequestHeaderPhase = null;

    @JsonProperty("sum_waf_latency_response_body_phase")
    private Float sumWafLatencyResponseBodyPhase = null;

    @JsonProperty("sum_waf_latency_response_header_phase")
    private Float sumWafLatencyResponseHeaderPhase = null;

    @JsonProperty("sum_waf_matched_request_body_phase")
    private Float sumWafMatchedRequestBodyPhase = null;

    @JsonProperty("sum_waf_matched_request_header_phase")
    private Float sumWafMatchedRequestHeaderPhase = null;

    @JsonProperty("sum_waf_matched_response_body_phase")
    private Float sumWafMatchedResponseBodyPhase = null;

    @JsonProperty("sum_waf_matched_response_header_phase")
    private Float sumWafMatchedResponseHeaderPhase = null;

    @JsonProperty("sum_waf_rejected")
    private Float sumWafRejected = null;

    @JsonProperty("sum_waf_rejected_request_body_phase")
    private Float sumWafRejectedRequestBodyPhase = null;

    @JsonProperty("sum_waf_rejected_request_header_phase")
    private Float sumWafRejectedRequestHeaderPhase = null;

    @JsonProperty("sum_waf_rejected_response_body_phase")
    private Float sumWafRejectedResponseBodyPhase = null;

    @JsonProperty("sum_waf_rejected_response_header_phase")
    private Float sumWafRejectedResponseHeaderPhase = null;

    @JsonProperty("sum_waiting_time")
    private Float sumWaitingTime = null;



  /**
   * This is the getter method this will return the attribute value.
   * Client apdex measures quality of server response based on latency.
   * @return apdexr
   */
  public Float getApdexr() {
    return apdexr;
  }

  /**
   * This is the setter method to the attribute.
   * Client apdex measures quality of server response based on latency.
   * @param apdexr set the apdexr.
   */
  public void setApdexr(Float  apdexr) {
    this.apdexr = apdexr;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average server/application response latency.
   * @return avgApplicationResponseTime
   */
  public Float getAvgApplicationResponseTime() {
    return avgApplicationResponseTime;
  }

  /**
   * This is the setter method to the attribute.
   * Average server/application response latency.
   * @param avgApplicationResponseTime set the avgApplicationResponseTime.
   */
  public void setAvgApplicationResponseTime(Float  avgApplicationResponseTime) {
    this.avgApplicationResponseTime = avgApplicationResponseTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average time client was blocked as reported by client.
   * @return avgBlockingTime
   */
  public Float getAvgBlockingTime() {
    return avgBlockingTime;
  }

  /**
   * This is the setter method to the attribute.
   * Average time client was blocked as reported by client.
   * @param avgBlockingTime set the avgBlockingTime.
   */
  public void setAvgBlockingTime(Float  avgBlockingTime) {
    this.avgBlockingTime = avgBlockingTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average browser rendering latency.
   * @return avgBrowserRenderingTime
   */
  public Float getAvgBrowserRenderingTime() {
    return avgBrowserRenderingTime;
  }

  /**
   * This is the setter method to the attribute.
   * Average browser rendering latency.
   * @param avgBrowserRenderingTime set the avgBrowserRenderingTime.
   */
  public void setAvgBrowserRenderingTime(Float  avgBrowserRenderingTime) {
    this.avgBrowserRenderingTime = avgBrowserRenderingTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average cache bytes.
   * @return avgCacheBytes
   */
  public Float getAvgCacheBytes() {
    return avgCacheBytes;
  }

  /**
   * This is the setter method to the attribute.
   * Average cache bytes.
   * @param avgCacheBytes set the avgCacheBytes.
   */
  public void setAvgCacheBytes(Float  avgCacheBytes) {
    this.avgCacheBytes = avgCacheBytes;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average cache hit of requests.
   * @return avgCacheHits
   */
  public Float getAvgCacheHits() {
    return avgCacheHits;
  }

  /**
   * This is the setter method to the attribute.
   * Average cache hit of requests.
   * @param avgCacheHits set the avgCacheHits.
   */
  public void setAvgCacheHits(Float  avgCacheHits) {
    this.avgCacheHits = avgCacheHits;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average cacheable bytes.
   * @return avgCacheableBytes
   */
  public Float getAvgCacheableBytes() {
    return avgCacheableBytes;
  }

  /**
   * This is the setter method to the attribute.
   * Average cacheable bytes.
   * @param avgCacheableBytes set the avgCacheableBytes.
   */
  public void setAvgCacheableBytes(Float  avgCacheableBytes) {
    this.avgCacheableBytes = avgCacheableBytes;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average cacheable hit of requests.
   * @return avgCacheableHits
   */
  public Float getAvgCacheableHits() {
    return avgCacheableHits;
  }

  /**
   * This is the setter method to the attribute.
   * Average cacheable hit of requests.
   * @param avgCacheableHits set the avgCacheableHits.
   */
  public void setAvgCacheableHits(Float  avgCacheableHits) {
    this.avgCacheableHits = avgCacheableHits;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average client data transfer time that represents latency of sending response to the client excluding the rtt time.
   * Higher client data transfer time signifies lower bandwidth  between client and avi service engine.
   * @return avgClientDataTransferTime
   */
  public Float getAvgClientDataTransferTime() {
    return avgClientDataTransferTime;
  }

  /**
   * This is the setter method to the attribute.
   * Average client data transfer time that represents latency of sending response to the client excluding the rtt time.
   * Higher client data transfer time signifies lower bandwidth  between client and avi service engine.
   * @param avgClientDataTransferTime set the avgClientDataTransferTime.
   */
  public void setAvgClientDataTransferTime(Float  avgClientDataTransferTime) {
    this.avgClientDataTransferTime = avgClientDataTransferTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average client round trip time.
   * @return avgClientRtt
   */
  public Float getAvgClientRtt() {
    return avgClientRtt;
  }

  /**
   * This is the setter method to the attribute.
   * Average client round trip time.
   * @param avgClientRtt set the avgClientRtt.
   */
  public void setAvgClientRtt(Float  avgClientRtt) {
    this.avgClientRtt = avgClientRtt;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average client transaction latency computed by adding response latencies across all http requests.
   * @return avgClientTxnLatency
   */
  public Float getAvgClientTxnLatency() {
    return avgClientTxnLatency;
  }

  /**
   * This is the setter method to the attribute.
   * Average client transaction latency computed by adding response latencies across all http requests.
   * @param avgClientTxnLatency set the avgClientTxnLatency.
   */
  public void setAvgClientTxnLatency(Float  avgClientTxnLatency) {
    this.avgClientTxnLatency = avgClientTxnLatency;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Rate of http responses sent per second.
   * @return avgCompleteResponses
   */
  public Float getAvgCompleteResponses() {
    return avgCompleteResponses;
  }

  /**
   * This is the setter method to the attribute.
   * Rate of http responses sent per second.
   * @param avgCompleteResponses set the avgCompleteResponses.
   */
  public void setAvgCompleteResponses(Float  avgCompleteResponses) {
    this.avgCompleteResponses = avgCompleteResponses;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average client connection latency reported by client.
   * @return avgConnectionTime
   */
  public Float getAvgConnectionTime() {
    return avgConnectionTime;
  }

  /**
   * This is the setter method to the attribute.
   * Average client connection latency reported by client.
   * @param avgConnectionTime set the avgConnectionTime.
   */
  public void setAvgConnectionTime(Float  avgConnectionTime) {
    this.avgConnectionTime = avgConnectionTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average domain lookup latency reported by client.
   * @return avgDnsLookupTime
   */
  public Float getAvgDnsLookupTime() {
    return avgDnsLookupTime;
  }

  /**
   * This is the setter method to the attribute.
   * Average domain lookup latency reported by client.
   * @param avgDnsLookupTime set the avgDnsLookupTime.
   */
  public void setAvgDnsLookupTime(Float  avgDnsLookupTime) {
    this.avgDnsLookupTime = avgDnsLookupTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average dom content load time reported by clients.
   * @return avgDomContentLoadTime
   */
  public Float getAvgDomContentLoadTime() {
    return avgDomContentLoadTime;
  }

  /**
   * This is the setter method to the attribute.
   * Average dom content load time reported by clients.
   * @param avgDomContentLoadTime set the avgDomContentLoadTime.
   */
  public void setAvgDomContentLoadTime(Float  avgDomContentLoadTime) {
    this.avgDomContentLoadTime = avgDomContentLoadTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Rate of http error responses sent per second.
   * It does not include errors excluded in analytics profile.
   * @return avgErrorResponses
   */
  public Float getAvgErrorResponses() {
    return avgErrorResponses;
  }

  /**
   * This is the setter method to the attribute.
   * Rate of http error responses sent per second.
   * It does not include errors excluded in analytics profile.
   * @param avgErrorResponses set the avgErrorResponses.
   */
  public void setAvgErrorResponses(Float  avgErrorResponses) {
    this.avgErrorResponses = avgErrorResponses;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Rate of http responses excluded as errors based on analytics profile.
   * @return avgErrorsExcluded
   */
  public Float getAvgErrorsExcluded() {
    return avgErrorsExcluded;
  }

  /**
   * This is the setter method to the attribute.
   * Rate of http responses excluded as errors based on analytics profile.
   * @param avgErrorsExcluded set the avgErrorsExcluded.
   */
  public void setAvgErrorsExcluded(Float  avgErrorsExcluded) {
    this.avgErrorsExcluded = avgErrorsExcluded;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Avg number of http requests that completed within frustrated latency.
   * @return avgFrustratedResponses
   */
  public Float getAvgFrustratedResponses() {
    return avgFrustratedResponses;
  }

  /**
   * This is the setter method to the attribute.
   * Avg number of http requests that completed within frustrated latency.
   * @param avgFrustratedResponses set the avgFrustratedResponses.
   */
  public void setAvgFrustratedResponses(Float  avgFrustratedResponses) {
    this.avgFrustratedResponses = avgFrustratedResponses;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average size of http headers per request.
   * Field introduced in 17.2.12, 18.1.2.
   * @return avgHttpHeadersBytes
   */
  public Float getAvgHttpHeadersBytes() {
    return avgHttpHeadersBytes;
  }

  /**
   * This is the setter method to the attribute.
   * Average size of http headers per request.
   * Field introduced in 17.2.12, 18.1.2.
   * @param avgHttpHeadersBytes set the avgHttpHeadersBytes.
   */
  public void setAvgHttpHeadersBytes(Float  avgHttpHeadersBytes) {
    this.avgHttpHeadersBytes = avgHttpHeadersBytes;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average number of http headers per request.
   * Field introduced in 17.2.12, 18.1.2.
   * @return avgHttpHeadersCount
   */
  public Float getAvgHttpHeadersCount() {
    return avgHttpHeadersCount;
  }

  /**
   * This is the setter method to the attribute.
   * Average number of http headers per request.
   * Field introduced in 17.2.12, 18.1.2.
   * @param avgHttpHeadersCount set the avgHttpHeadersCount.
   */
  public void setAvgHttpHeadersCount(Float  avgHttpHeadersCount) {
    this.avgHttpHeadersCount = avgHttpHeadersCount;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average number of http request parameters per request.
   * Field introduced in 17.2.12, 18.1.2.
   * @return avgHttpParamsCount
   */
  public Float getAvgHttpParamsCount() {
    return avgHttpParamsCount;
  }

  /**
   * This is the setter method to the attribute.
   * Average number of http request parameters per request.
   * Field introduced in 17.2.12, 18.1.2.
   * @param avgHttpParamsCount set the avgHttpParamsCount.
   */
  public void setAvgHttpParamsCount(Float  avgHttpParamsCount) {
    this.avgHttpParamsCount = avgHttpParamsCount;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average page load time reported by clients.
   * @return avgPageDownloadTime
   */
  public Float getAvgPageDownloadTime() {
    return avgPageDownloadTime;
  }

  /**
   * This is the setter method to the attribute.
   * Average page load time reported by clients.
   * @param avgPageDownloadTime set the avgPageDownloadTime.
   */
  public void setAvgPageDownloadTime(Float  avgPageDownloadTime) {
    this.avgPageDownloadTime = avgPageDownloadTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average page load time reported by client.
   * @return avgPageLoadTime
   */
  public Float getAvgPageLoadTime() {
    return avgPageLoadTime;
  }

  /**
   * This is the setter method to the attribute.
   * Average page load time reported by client.
   * @param avgPageLoadTime set the avgPageLoadTime.
   */
  public void setAvgPageLoadTime(Float  avgPageLoadTime) {
    this.avgPageLoadTime = avgPageLoadTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average number of http request parameters per request, taking into account only requests with parameters.
   * Field introduced in 17.2.12, 18.1.3.
   * @return avgParamsPerReq
   */
  public Float getAvgParamsPerReq() {
    return avgParamsPerReq;
  }

  /**
   * This is the setter method to the attribute.
   * Average number of http request parameters per request, taking into account only requests with parameters.
   * Field introduced in 17.2.12, 18.1.3.
   * @param avgParamsPerReq set the avgParamsPerReq.
   */
  public void setAvgParamsPerReq(Float  avgParamsPerReq) {
    this.avgParamsPerReq = avgParamsPerReq;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average size of http post request.
   * Field introduced in 17.2.12, 18.1.2.
   * @return avgPostBytes
   */
  public Float getAvgPostBytes() {
    return avgPostBytes;
  }

  /**
   * This is the setter method to the attribute.
   * Average size of http post request.
   * Field introduced in 17.2.12, 18.1.2.
   * @param avgPostBytes set the avgPostBytes.
   */
  public void setAvgPostBytes(Float  avgPostBytes) {
    this.avgPostBytes = avgPostBytes;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average post compression bytes.
   * @return avgPostCompressionBytes
   */
  public Float getAvgPostCompressionBytes() {
    return avgPostCompressionBytes;
  }

  /**
   * This is the setter method to the attribute.
   * Average post compression bytes.
   * @param avgPostCompressionBytes set the avgPostCompressionBytes.
   */
  public void setAvgPostCompressionBytes(Float  avgPostCompressionBytes) {
    this.avgPostCompressionBytes = avgPostCompressionBytes;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average pre compression bytes.
   * @return avgPreCompressionBytes
   */
  public Float getAvgPreCompressionBytes() {
    return avgPreCompressionBytes;
  }

  /**
   * This is the setter method to the attribute.
   * Average pre compression bytes.
   * @param avgPreCompressionBytes set the avgPreCompressionBytes.
   */
  public void setAvgPreCompressionBytes(Float  avgPreCompressionBytes) {
    this.avgPreCompressionBytes = avgPreCompressionBytes;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average redirect latency reported by client.
   * @return avgRedirectionTime
   */
  public Float getAvgRedirectionTime() {
    return avgRedirectionTime;
  }

  /**
   * This is the setter method to the attribute.
   * Average redirect latency reported by client.
   * @param avgRedirectionTime set the avgRedirectionTime.
   */
  public void setAvgRedirectionTime(Float  avgRedirectionTime) {
    this.avgRedirectionTime = avgRedirectionTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average requests per session measured for closed sessions.
   * @return avgReqsPerSession
   */
  public Float getAvgReqsPerSession() {
    return avgReqsPerSession;
  }

  /**
   * This is the setter method to the attribute.
   * Average requests per session measured for closed sessions.
   * @param avgReqsPerSession set the avgReqsPerSession.
   */
  public void setAvgReqsPerSession(Float  avgReqsPerSession) {
    this.avgReqsPerSession = avgReqsPerSession;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Rate of 1xx http responses sent per second.
   * @return avgResp1Xx
   */
  public Float getAvgResp1Xx() {
    return avgResp1Xx;
  }

  /**
   * This is the setter method to the attribute.
   * Rate of 1xx http responses sent per second.
   * @param avgResp1Xx set the avgResp1Xx.
   */
  public void setAvgResp1Xx(Float  avgResp1Xx) {
    this.avgResp1Xx = avgResp1Xx;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Rate of 2xx http responses sent per second.
   * @return avgResp2Xx
   */
  public Float getAvgResp2Xx() {
    return avgResp2Xx;
  }

  /**
   * This is the setter method to the attribute.
   * Rate of 2xx http responses sent per second.
   * @param avgResp2Xx set the avgResp2Xx.
   */
  public void setAvgResp2Xx(Float  avgResp2Xx) {
    this.avgResp2Xx = avgResp2Xx;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Rate of 3xx http responses sent per second.
   * @return avgResp3Xx
   */
  public Float getAvgResp3Xx() {
    return avgResp3Xx;
  }

  /**
   * This is the setter method to the attribute.
   * Rate of 3xx http responses sent per second.
   * @param avgResp3Xx set the avgResp3Xx.
   */
  public void setAvgResp3Xx(Float  avgResp3Xx) {
    this.avgResp3Xx = avgResp3Xx;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Rate of 4xx http responses sent per second.
   * @return avgResp4Xx
   */
  public Float getAvgResp4Xx() {
    return avgResp4Xx;
  }

  /**
   * This is the setter method to the attribute.
   * Rate of 4xx http responses sent per second.
   * @param avgResp4Xx set the avgResp4Xx.
   */
  public void setAvgResp4Xx(Float  avgResp4Xx) {
    this.avgResp4Xx = avgResp4Xx;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Rate of 4xx http responses as errors sent by avi.
   * It does not include any error codes excluded in the analytics profile and pool server errors.
   * @return avgResp4XxAviErrors
   */
  public Float getAvgResp4XxAviErrors() {
    return avgResp4XxAviErrors;
  }

  /**
   * This is the setter method to the attribute.
   * Rate of 4xx http responses as errors sent by avi.
   * It does not include any error codes excluded in the analytics profile and pool server errors.
   * @param avgResp4XxAviErrors set the avgResp4XxAviErrors.
   */
  public void setAvgResp4XxAviErrors(Float  avgResp4XxAviErrors) {
    this.avgResp4XxAviErrors = avgResp4XxAviErrors;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Rate of 5xx http responses sent per second.
   * @return avgResp5Xx
   */
  public Float getAvgResp5Xx() {
    return avgResp5Xx;
  }

  /**
   * This is the setter method to the attribute.
   * Rate of 5xx http responses sent per second.
   * @param avgResp5Xx set the avgResp5Xx.
   */
  public void setAvgResp5Xx(Float  avgResp5Xx) {
    this.avgResp5Xx = avgResp5Xx;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Rate of 5xx http responses as errors sent by avi.
   * It does not include any error codes excluded in the analytics profile and pool server errors.
   * @return avgResp5XxAviErrors
   */
  public Float getAvgResp5XxAviErrors() {
    return avgResp5XxAviErrors;
  }

  /**
   * This is the setter method to the attribute.
   * Rate of 5xx http responses as errors sent by avi.
   * It does not include any error codes excluded in the analytics profile and pool server errors.
   * @param avgResp5XxAviErrors set the avgResp5XxAviErrors.
   */
  public void setAvgResp5XxAviErrors(Float  avgResp5XxAviErrors) {
    this.avgResp5XxAviErrors = avgResp5XxAviErrors;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total client data transfer time by client.
   * @return avgRumClientDataTransferTime
   */
  public Float getAvgRumClientDataTransferTime() {
    return avgRumClientDataTransferTime;
  }

  /**
   * This is the setter method to the attribute.
   * Total client data transfer time by client.
   * @param avgRumClientDataTransferTime set the avgRumClientDataTransferTime.
   */
  public void setAvgRumClientDataTransferTime(Float  avgRumClientDataTransferTime) {
    this.avgRumClientDataTransferTime = avgRumClientDataTransferTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Avg number of http requests that completed within satisfactory latency.
   * @return avgSatisfactoryResponses
   */
  public Float getAvgSatisfactoryResponses() {
    return avgSatisfactoryResponses;
  }

  /**
   * This is the setter method to the attribute.
   * Avg number of http requests that completed within satisfactory latency.
   * @param avgSatisfactoryResponses set the avgSatisfactoryResponses.
   */
  public void setAvgSatisfactoryResponses(Float  avgSatisfactoryResponses) {
    this.avgSatisfactoryResponses = avgSatisfactoryResponses;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average server round trip time.
   * @return avgServerRtt
   */
  public Float getAvgServerRtt() {
    return avgServerRtt;
  }

  /**
   * This is the setter method to the attribute.
   * Average server round trip time.
   * @param avgServerRtt set the avgServerRtt.
   */
  public void setAvgServerRtt(Float  avgServerRtt) {
    this.avgServerRtt = avgServerRtt;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average latency from receipt of request to start of response.
   * @return avgServiceTime
   */
  public Float getAvgServiceTime() {
    return avgServiceTime;
  }

  /**
   * This is the setter method to the attribute.
   * Average latency from receipt of request to start of response.
   * @param avgServiceTime set the avgServiceTime.
   */
  public void setAvgServiceTime(Float  avgServiceTime) {
    this.avgServiceTime = avgServiceTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average ssl sessions using dsa certificate.
   * @return avgSslAuthDsa
   */
  public Float getAvgSslAuthDsa() {
    return avgSslAuthDsa;
  }

  /**
   * This is the setter method to the attribute.
   * Average ssl sessions using dsa certificate.
   * @param avgSslAuthDsa set the avgSslAuthDsa.
   */
  public void setAvgSslAuthDsa(Float  avgSslAuthDsa) {
    this.avgSslAuthDsa = avgSslAuthDsa;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average ssl sessions using elliptic curve dsa (ecdsa) certificates.
   * @return avgSslAuthEcdsa
   */
  public Float getAvgSslAuthEcdsa() {
    return avgSslAuthEcdsa;
  }

  /**
   * This is the setter method to the attribute.
   * Average ssl sessions using elliptic curve dsa (ecdsa) certificates.
   * @param avgSslAuthEcdsa set the avgSslAuthEcdsa.
   */
  public void setAvgSslAuthEcdsa(Float  avgSslAuthEcdsa) {
    this.avgSslAuthEcdsa = avgSslAuthEcdsa;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average ssl sessions using rsa certificate.
   * @return avgSslAuthRsa
   */
  public Float getAvgSslAuthRsa() {
    return avgSslAuthRsa;
  }

  /**
   * This is the setter method to the attribute.
   * Average ssl sessions using rsa certificate.
   * @param avgSslAuthRsa set the avgSslAuthRsa.
   */
  public void setAvgSslAuthRsa(Float  avgSslAuthRsa) {
    this.avgSslAuthRsa = avgSslAuthRsa;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average ssl sessions.
   * @return avgSslConnections
   */
  public Float getAvgSslConnections() {
    return avgSslConnections;
  }

  /**
   * This is the setter method to the attribute.
   * Average ssl sessions.
   * @param avgSslConnections set the avgSslConnections.
   */
  public void setAvgSslConnections(Float  avgSslConnections) {
    this.avgSslConnections = avgSslConnections;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average ssl exchanges using ec cerificates without pfs.
   * @return avgSslEcdsaNonPfs
   */
  public Float getAvgSslEcdsaNonPfs() {
    return avgSslEcdsaNonPfs;
  }

  /**
   * This is the setter method to the attribute.
   * Average ssl exchanges using ec cerificates without pfs.
   * @param avgSslEcdsaNonPfs set the avgSslEcdsaNonPfs.
   */
  public void setAvgSslEcdsaNonPfs(Float  avgSslEcdsaNonPfs) {
    this.avgSslEcdsaNonPfs = avgSslEcdsaNonPfs;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average ssl exchanges using ec cerificates and pfs.
   * @return avgSslEcdsaPfs
   */
  public Float getAvgSslEcdsaPfs() {
    return avgSslEcdsaPfs;
  }

  /**
   * This is the setter method to the attribute.
   * Average ssl exchanges using ec cerificates and pfs.
   * @param avgSslEcdsaPfs set the avgSslEcdsaPfs.
   */
  public void setAvgSslEcdsaPfs(Float  avgSslEcdsaPfs) {
    this.avgSslEcdsaPfs = avgSslEcdsaPfs;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average ssl errors due to clients, protocol errors,network errors and handshake timeouts.
   * @return avgSslErrors
   */
  public Float getAvgSslErrors() {
    return avgSslErrors;
  }

  /**
   * This is the setter method to the attribute.
   * Average ssl errors due to clients, protocol errors,network errors and handshake timeouts.
   * @param avgSslErrors set the avgSslErrors.
   */
  public void setAvgSslErrors(Float  avgSslErrors) {
    this.avgSslErrors = avgSslErrors;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average ssl connections failed due to protocol , network or timeout reasons.
   * @return avgSslFailedConnections
   */
  public Float getAvgSslFailedConnections() {
    return avgSslFailedConnections;
  }

  /**
   * This is the setter method to the attribute.
   * Average ssl connections failed due to protocol , network or timeout reasons.
   * @param avgSslFailedConnections set the avgSslFailedConnections.
   */
  public void setAvgSslFailedConnections(Float  avgSslFailedConnections) {
    this.avgSslFailedConnections = avgSslFailedConnections;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average ssl handshakes failed due to network errors.
   * @return avgSslHandshakeNetworkErrors
   */
  public Float getAvgSslHandshakeNetworkErrors() {
    return avgSslHandshakeNetworkErrors;
  }

  /**
   * This is the setter method to the attribute.
   * Average ssl handshakes failed due to network errors.
   * @param avgSslHandshakeNetworkErrors set the avgSslHandshakeNetworkErrors.
   */
  public void setAvgSslHandshakeNetworkErrors(Float  avgSslHandshakeNetworkErrors) {
    this.avgSslHandshakeNetworkErrors = avgSslHandshakeNetworkErrors;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average ssl handshake failed due to clients or protocol errors.
   * @return avgSslHandshakeProtocolErrors
   */
  public Float getAvgSslHandshakeProtocolErrors() {
    return avgSslHandshakeProtocolErrors;
  }

  /**
   * This is the setter method to the attribute.
   * Average ssl handshake failed due to clients or protocol errors.
   * @param avgSslHandshakeProtocolErrors set the avgSslHandshakeProtocolErrors.
   */
  public void setAvgSslHandshakeProtocolErrors(Float  avgSslHandshakeProtocolErrors) {
    this.avgSslHandshakeProtocolErrors = avgSslHandshakeProtocolErrors;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average new successful ssl sessions.
   * @return avgSslHandshakesNew
   */
  public Float getAvgSslHandshakesNew() {
    return avgSslHandshakesNew;
  }

  /**
   * This is the setter method to the attribute.
   * Average new successful ssl sessions.
   * @param avgSslHandshakesNew set the avgSslHandshakesNew.
   */
  public void setAvgSslHandshakesNew(Float  avgSslHandshakesNew) {
    this.avgSslHandshakesNew = avgSslHandshakesNew;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average ssl exchanges using non-pfs.
   * @return avgSslHandshakesNonPfs
   */
  public Float getAvgSslHandshakesNonPfs() {
    return avgSslHandshakesNonPfs;
  }

  /**
   * This is the setter method to the attribute.
   * Average ssl exchanges using non-pfs.
   * @param avgSslHandshakesNonPfs set the avgSslHandshakesNonPfs.
   */
  public void setAvgSslHandshakesNonPfs(Float  avgSslHandshakesNonPfs) {
    this.avgSslHandshakesNonPfs = avgSslHandshakesNonPfs;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average ssl exchanges using pfs.
   * @return avgSslHandshakesPfs
   */
  public Float getAvgSslHandshakesPfs() {
    return avgSslHandshakesPfs;
  }

  /**
   * This is the setter method to the attribute.
   * Average ssl exchanges using pfs.
   * @param avgSslHandshakesPfs set the avgSslHandshakesPfs.
   */
  public void setAvgSslHandshakesPfs(Float  avgSslHandshakesPfs) {
    this.avgSslHandshakesPfs = avgSslHandshakesPfs;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average new successful resumed ssl sessions.
   * @return avgSslHandshakesReused
   */
  public Float getAvgSslHandshakesReused() {
    return avgSslHandshakesReused;
  }

  /**
   * This is the setter method to the attribute.
   * Average new successful resumed ssl sessions.
   * @param avgSslHandshakesReused set the avgSslHandshakesReused.
   */
  public void setAvgSslHandshakesReused(Float  avgSslHandshakesReused) {
    this.avgSslHandshakesReused = avgSslHandshakesReused;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average ssl handshakes timed out.
   * @return avgSslHandshakesTimedout
   */
  public Float getAvgSslHandshakesTimedout() {
    return avgSslHandshakesTimedout;
  }

  /**
   * This is the setter method to the attribute.
   * Average ssl handshakes timed out.
   * @param avgSslHandshakesTimedout set the avgSslHandshakesTimedout.
   */
  public void setAvgSslHandshakesTimedout(Float  avgSslHandshakesTimedout) {
    this.avgSslHandshakesTimedout = avgSslHandshakesTimedout;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average ssl exchanges using diffie-hellman.
   * @return avgSslKxDh
   */
  public Float getAvgSslKxDh() {
    return avgSslKxDh;
  }

  /**
   * This is the setter method to the attribute.
   * Average ssl exchanges using diffie-hellman.
   * @param avgSslKxDh set the avgSslKxDh.
   */
  public void setAvgSslKxDh(Float  avgSslKxDh) {
    this.avgSslKxDh = avgSslKxDh;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average ssl exchanges using rsa.
   * @return avgSslKxEcdh
   */
  public Float getAvgSslKxEcdh() {
    return avgSslKxEcdh;
  }

  /**
   * This is the setter method to the attribute.
   * Average ssl exchanges using rsa.
   * @param avgSslKxEcdh set the avgSslKxEcdh.
   */
  public void setAvgSslKxEcdh(Float  avgSslKxEcdh) {
    this.avgSslKxEcdh = avgSslKxEcdh;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average ssl exchanges using rsa.
   * @return avgSslKxRsa
   */
  public Float getAvgSslKxRsa() {
    return avgSslKxRsa;
  }

  /**
   * This is the setter method to the attribute.
   * Average ssl exchanges using rsa.
   * @param avgSslKxRsa set the avgSslKxRsa.
   */
  public void setAvgSslKxRsa(Float  avgSslKxRsa) {
    this.avgSslKxRsa = avgSslKxRsa;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average ssl exchanges using rsa cerificates without pfs.
   * @return avgSslRsaNonPfs
   */
  public Float getAvgSslRsaNonPfs() {
    return avgSslRsaNonPfs;
  }

  /**
   * This is the setter method to the attribute.
   * Average ssl exchanges using rsa cerificates without pfs.
   * @param avgSslRsaNonPfs set the avgSslRsaNonPfs.
   */
  public void setAvgSslRsaNonPfs(Float  avgSslRsaNonPfs) {
    this.avgSslRsaNonPfs = avgSslRsaNonPfs;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average ssl exchanges using rsa cerificates and pfs.
   * @return avgSslRsaPfs
   */
  public Float getAvgSslRsaPfs() {
    return avgSslRsaPfs;
  }

  /**
   * This is the setter method to the attribute.
   * Average ssl exchanges using rsa cerificates and pfs.
   * @param avgSslRsaPfs set the avgSslRsaPfs.
   */
  public void setAvgSslRsaPfs(Float  avgSslRsaPfs) {
    this.avgSslRsaPfs = avgSslRsaPfs;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average ssl sessions with version 3.0.
   * @return avgSslVerSsl30
   */
  public Float getAvgSslVerSsl30() {
    return avgSslVerSsl30;
  }

  /**
   * This is the setter method to the attribute.
   * Average ssl sessions with version 3.0.
   * @param avgSslVerSsl30 set the avgSslVerSsl30.
   */
  public void setAvgSslVerSsl30(Float  avgSslVerSsl30) {
    this.avgSslVerSsl30 = avgSslVerSsl30;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average ssl sessions with tls version 1.0.
   * @return avgSslVerTls10
   */
  public Float getAvgSslVerTls10() {
    return avgSslVerTls10;
  }

  /**
   * This is the setter method to the attribute.
   * Average ssl sessions with tls version 1.0.
   * @param avgSslVerTls10 set the avgSslVerTls10.
   */
  public void setAvgSslVerTls10(Float  avgSslVerTls10) {
    this.avgSslVerTls10 = avgSslVerTls10;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average ssl sessions with tls version 1.1.
   * @return avgSslVerTls11
   */
  public Float getAvgSslVerTls11() {
    return avgSslVerTls11;
  }

  /**
   * This is the setter method to the attribute.
   * Average ssl sessions with tls version 1.1.
   * @param avgSslVerTls11 set the avgSslVerTls11.
   */
  public void setAvgSslVerTls11(Float  avgSslVerTls11) {
    this.avgSslVerTls11 = avgSslVerTls11;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average ssl sessions with tls version 1.2.
   * @return avgSslVerTls12
   */
  public Float getAvgSslVerTls12() {
    return avgSslVerTls12;
  }

  /**
   * This is the setter method to the attribute.
   * Average ssl sessions with tls version 1.2.
   * @param avgSslVerTls12 set the avgSslVerTls12.
   */
  public void setAvgSslVerTls12(Float  avgSslVerTls12) {
    this.avgSslVerTls12 = avgSslVerTls12;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average ssl sessions with tls version 1.3.
   * Field introduced in 18.2.6.
   * @return avgSslVerTls13
   */
  public Float getAvgSslVerTls13() {
    return avgSslVerTls13;
  }

  /**
   * This is the setter method to the attribute.
   * Average ssl sessions with tls version 1.3.
   * Field introduced in 18.2.6.
   * @param avgSslVerTls13 set the avgSslVerTls13.
   */
  public void setAvgSslVerTls13(Float  avgSslVerTls13) {
    this.avgSslVerTls13 = avgSslVerTls13;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Avg number of http requests that completed within tolerated latency.
   * @return avgToleratedResponses
   */
  public Float getAvgToleratedResponses() {
    return avgToleratedResponses;
  }

  /**
   * This is the setter method to the attribute.
   * Avg number of http requests that completed within tolerated latency.
   * @param avgToleratedResponses set the avgToleratedResponses.
   */
  public void setAvgToleratedResponses(Float  avgToleratedResponses) {
    this.avgToleratedResponses = avgToleratedResponses;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average number of client http2 requests received by the virtual service per second.
   * Field introduced in 18.2.5.
   * @return avgTotalHttp2Requests
   */
  public Float getAvgTotalHttp2Requests() {
    return avgTotalHttp2Requests;
  }

  /**
   * This is the setter method to the attribute.
   * Average number of client http2 requests received by the virtual service per second.
   * Field introduced in 18.2.5.
   * @param avgTotalHttp2Requests set the avgTotalHttp2Requests.
   */
  public void setAvgTotalHttp2Requests(Float  avgTotalHttp2Requests) {
    this.avgTotalHttp2Requests = avgTotalHttp2Requests;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average rate of client http requests received by the virtual service per second.
   * @return avgTotalRequests
   */
  public Float getAvgTotalRequests() {
    return avgTotalRequests;
  }

  /**
   * This is the setter method to the attribute.
   * Average rate of client http requests received by the virtual service per second.
   * @param avgTotalRequests set the avgTotalRequests.
   */
  public void setAvgTotalRequests(Float  avgTotalRequests) {
    this.avgTotalRequests = avgTotalRequests;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average length of http uri per request.
   * Field introduced in 17.2.12, 18.1.2.
   * @return avgUriLength
   */
  public Float getAvgUriLength() {
    return avgUriLength;
  }

  /**
   * This is the setter method to the attribute.
   * Average length of http uri per request.
   * Field introduced in 17.2.12, 18.1.2.
   * @param avgUriLength set the avgUriLength.
   */
  public void setAvgUriLength(Float  avgUriLength) {
    this.avgUriLength = avgUriLength;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average number of transactions per second identified by waf as attacks.
   * Field introduced in 17.2.3.
   * @return avgWafAttacks
   */
  public Float getAvgWafAttacks() {
    return avgWafAttacks;
  }

  /**
   * This is the setter method to the attribute.
   * Average number of transactions per second identified by waf as attacks.
   * Field introduced in 17.2.3.
   * @param avgWafAttacks set the avgWafAttacks.
   */
  public void setAvgWafAttacks(Float  avgWafAttacks) {
    this.avgWafAttacks = avgWafAttacks;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average number of transactions per second bypassing waf.
   * Field introduced in 17.2.12, 18.1.2.
   * @return avgWafDisabled
   */
  public Float getAvgWafDisabled() {
    return avgWafDisabled;
  }

  /**
   * This is the setter method to the attribute.
   * Average number of transactions per second bypassing waf.
   * Field introduced in 17.2.12, 18.1.2.
   * @param avgWafDisabled set the avgWafDisabled.
   */
  public void setAvgWafDisabled(Float  avgWafDisabled) {
    this.avgWafDisabled = avgWafDisabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average number of transactions per second evaluated by waf.
   * Field introduced in 17.2.2.
   * @return avgWafEvaluated
   */
  public Float getAvgWafEvaluated() {
    return avgWafEvaluated;
  }

  /**
   * This is the setter method to the attribute.
   * Average number of transactions per second evaluated by waf.
   * Field introduced in 17.2.2.
   * @param avgWafEvaluated set the avgWafEvaluated.
   */
  public void setAvgWafEvaluated(Float  avgWafEvaluated) {
    this.avgWafEvaluated = avgWafEvaluated;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average number of requests per second evaluated by waf in request body phase.
   * Field introduced in 17.2.2.
   * @return avgWafEvaluatedRequestBodyPhase
   */
  public Float getAvgWafEvaluatedRequestBodyPhase() {
    return avgWafEvaluatedRequestBodyPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Average number of requests per second evaluated by waf in request body phase.
   * Field introduced in 17.2.2.
   * @param avgWafEvaluatedRequestBodyPhase set the avgWafEvaluatedRequestBodyPhase.
   */
  public void setAvgWafEvaluatedRequestBodyPhase(Float  avgWafEvaluatedRequestBodyPhase) {
    this.avgWafEvaluatedRequestBodyPhase = avgWafEvaluatedRequestBodyPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average number of requests per second evaluated by waf in request header phase.
   * Field introduced in 17.2.2.
   * @return avgWafEvaluatedRequestHeaderPhase
   */
  public Float getAvgWafEvaluatedRequestHeaderPhase() {
    return avgWafEvaluatedRequestHeaderPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Average number of requests per second evaluated by waf in request header phase.
   * Field introduced in 17.2.2.
   * @param avgWafEvaluatedRequestHeaderPhase set the avgWafEvaluatedRequestHeaderPhase.
   */
  public void setAvgWafEvaluatedRequestHeaderPhase(Float  avgWafEvaluatedRequestHeaderPhase) {
    this.avgWafEvaluatedRequestHeaderPhase = avgWafEvaluatedRequestHeaderPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average number of responses per second evaluated by waf in response body phase.
   * Field introduced in 17.2.2.
   * @return avgWafEvaluatedResponseBodyPhase
   */
  public Float getAvgWafEvaluatedResponseBodyPhase() {
    return avgWafEvaluatedResponseBodyPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Average number of responses per second evaluated by waf in response body phase.
   * Field introduced in 17.2.2.
   * @param avgWafEvaluatedResponseBodyPhase set the avgWafEvaluatedResponseBodyPhase.
   */
  public void setAvgWafEvaluatedResponseBodyPhase(Float  avgWafEvaluatedResponseBodyPhase) {
    this.avgWafEvaluatedResponseBodyPhase = avgWafEvaluatedResponseBodyPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average number of responsess per second evaluated by waf in response header phase.
   * Field introduced in 17.2.2.
   * @return avgWafEvaluatedResponseHeaderPhase
   */
  public Float getAvgWafEvaluatedResponseHeaderPhase() {
    return avgWafEvaluatedResponseHeaderPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Average number of responsess per second evaluated by waf in response header phase.
   * Field introduced in 17.2.2.
   * @param avgWafEvaluatedResponseHeaderPhase set the avgWafEvaluatedResponseHeaderPhase.
   */
  public void setAvgWafEvaluatedResponseHeaderPhase(Float  avgWafEvaluatedResponseHeaderPhase) {
    this.avgWafEvaluatedResponseHeaderPhase = avgWafEvaluatedResponseHeaderPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average number of transactions per second flagged by waf.
   * Field introduced in 17.2.2.
   * @return avgWafFlagged
   */
  public Float getAvgWafFlagged() {
    return avgWafFlagged;
  }

  /**
   * This is the setter method to the attribute.
   * Average number of transactions per second flagged by waf.
   * Field introduced in 17.2.2.
   * @param avgWafFlagged set the avgWafFlagged.
   */
  public void setAvgWafFlagged(Float  avgWafFlagged) {
    this.avgWafFlagged = avgWafFlagged;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average number of requests per second flagged (but not rejected) by waf in request body phase.
   * Field introduced in 17.2.2.
   * @return avgWafFlaggedRequestBodyPhase
   */
  public Float getAvgWafFlaggedRequestBodyPhase() {
    return avgWafFlaggedRequestBodyPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Average number of requests per second flagged (but not rejected) by waf in request body phase.
   * Field introduced in 17.2.2.
   * @param avgWafFlaggedRequestBodyPhase set the avgWafFlaggedRequestBodyPhase.
   */
  public void setAvgWafFlaggedRequestBodyPhase(Float  avgWafFlaggedRequestBodyPhase) {
    this.avgWafFlaggedRequestBodyPhase = avgWafFlaggedRequestBodyPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average number of requests per second flagged (but not rejected) by waf in request header phase.
   * Field introduced in 17.2.2.
   * @return avgWafFlaggedRequestHeaderPhase
   */
  public Float getAvgWafFlaggedRequestHeaderPhase() {
    return avgWafFlaggedRequestHeaderPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Average number of requests per second flagged (but not rejected) by waf in request header phase.
   * Field introduced in 17.2.2.
   * @param avgWafFlaggedRequestHeaderPhase set the avgWafFlaggedRequestHeaderPhase.
   */
  public void setAvgWafFlaggedRequestHeaderPhase(Float  avgWafFlaggedRequestHeaderPhase) {
    this.avgWafFlaggedRequestHeaderPhase = avgWafFlaggedRequestHeaderPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average number of responses per second flagged (but not rejected) by waf in response body phase.
   * Field introduced in 17.2.2.
   * @return avgWafFlaggedResponseBodyPhase
   */
  public Float getAvgWafFlaggedResponseBodyPhase() {
    return avgWafFlaggedResponseBodyPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Average number of responses per second flagged (but not rejected) by waf in response body phase.
   * Field introduced in 17.2.2.
   * @param avgWafFlaggedResponseBodyPhase set the avgWafFlaggedResponseBodyPhase.
   */
  public void setAvgWafFlaggedResponseBodyPhase(Float  avgWafFlaggedResponseBodyPhase) {
    this.avgWafFlaggedResponseBodyPhase = avgWafFlaggedResponseBodyPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average number of responses per second flagged (but not rejected) by waf in response header phase.
   * Field introduced in 17.2.2.
   * @return avgWafFlaggedResponseHeaderPhase
   */
  public Float getAvgWafFlaggedResponseHeaderPhase() {
    return avgWafFlaggedResponseHeaderPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Average number of responses per second flagged (but not rejected) by waf in response header phase.
   * Field introduced in 17.2.2.
   * @param avgWafFlaggedResponseHeaderPhase set the avgWafFlaggedResponseHeaderPhase.
   */
  public void setAvgWafFlaggedResponseHeaderPhase(Float  avgWafFlaggedResponseHeaderPhase) {
    this.avgWafFlaggedResponseHeaderPhase = avgWafFlaggedResponseHeaderPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average waf latency seen due to waf request body processing.
   * Field introduced in 17.2.2.
   * @return avgWafLatencyRequestBodyPhase
   */
  public Float getAvgWafLatencyRequestBodyPhase() {
    return avgWafLatencyRequestBodyPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Average waf latency seen due to waf request body processing.
   * Field introduced in 17.2.2.
   * @param avgWafLatencyRequestBodyPhase set the avgWafLatencyRequestBodyPhase.
   */
  public void setAvgWafLatencyRequestBodyPhase(Float  avgWafLatencyRequestBodyPhase) {
    this.avgWafLatencyRequestBodyPhase = avgWafLatencyRequestBodyPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average waf latency seen due to waf request header processing.
   * Field introduced in 17.2.2.
   * @return avgWafLatencyRequestHeaderPhase
   */
  public Float getAvgWafLatencyRequestHeaderPhase() {
    return avgWafLatencyRequestHeaderPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Average waf latency seen due to waf request header processing.
   * Field introduced in 17.2.2.
   * @param avgWafLatencyRequestHeaderPhase set the avgWafLatencyRequestHeaderPhase.
   */
  public void setAvgWafLatencyRequestHeaderPhase(Float  avgWafLatencyRequestHeaderPhase) {
    this.avgWafLatencyRequestHeaderPhase = avgWafLatencyRequestHeaderPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average waf latency seen due to waf response body processing.
   * Field introduced in 17.2.2.
   * @return avgWafLatencyResponseBodyPhase
   */
  public Float getAvgWafLatencyResponseBodyPhase() {
    return avgWafLatencyResponseBodyPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Average waf latency seen due to waf response body processing.
   * Field introduced in 17.2.2.
   * @param avgWafLatencyResponseBodyPhase set the avgWafLatencyResponseBodyPhase.
   */
  public void setAvgWafLatencyResponseBodyPhase(Float  avgWafLatencyResponseBodyPhase) {
    this.avgWafLatencyResponseBodyPhase = avgWafLatencyResponseBodyPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average waf latency seen due to waf response header processing.
   * Field introduced in 17.2.2.
   * @return avgWafLatencyResponseHeaderPhase
   */
  public Float getAvgWafLatencyResponseHeaderPhase() {
    return avgWafLatencyResponseHeaderPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Average waf latency seen due to waf response header processing.
   * Field introduced in 17.2.2.
   * @param avgWafLatencyResponseHeaderPhase set the avgWafLatencyResponseHeaderPhase.
   */
  public void setAvgWafLatencyResponseHeaderPhase(Float  avgWafLatencyResponseHeaderPhase) {
    this.avgWafLatencyResponseHeaderPhase = avgWafLatencyResponseHeaderPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average number of transactions per second matched by waf rule/rules.
   * Field introduced in 17.2.2.
   * @return avgWafMatched
   */
  public Float getAvgWafMatched() {
    return avgWafMatched;
  }

  /**
   * This is the setter method to the attribute.
   * Average number of transactions per second matched by waf rule/rules.
   * Field introduced in 17.2.2.
   * @param avgWafMatched set the avgWafMatched.
   */
  public void setAvgWafMatched(Float  avgWafMatched) {
    this.avgWafMatched = avgWafMatched;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average number of requests per second matched by waf in request body phase.
   * Field introduced in 17.2.2.
   * @return avgWafMatchedRequestBodyPhase
   */
  public Float getAvgWafMatchedRequestBodyPhase() {
    return avgWafMatchedRequestBodyPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Average number of requests per second matched by waf in request body phase.
   * Field introduced in 17.2.2.
   * @param avgWafMatchedRequestBodyPhase set the avgWafMatchedRequestBodyPhase.
   */
  public void setAvgWafMatchedRequestBodyPhase(Float  avgWafMatchedRequestBodyPhase) {
    this.avgWafMatchedRequestBodyPhase = avgWafMatchedRequestBodyPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average number of requests per second matched by waf in request header phase.
   * Field introduced in 17.2.2.
   * @return avgWafMatchedRequestHeaderPhase
   */
  public Float getAvgWafMatchedRequestHeaderPhase() {
    return avgWafMatchedRequestHeaderPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Average number of requests per second matched by waf in request header phase.
   * Field introduced in 17.2.2.
   * @param avgWafMatchedRequestHeaderPhase set the avgWafMatchedRequestHeaderPhase.
   */
  public void setAvgWafMatchedRequestHeaderPhase(Float  avgWafMatchedRequestHeaderPhase) {
    this.avgWafMatchedRequestHeaderPhase = avgWafMatchedRequestHeaderPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average number of responses per second matched by waf in response body phase.
   * Field introduced in 17.2.2.
   * @return avgWafMatchedResponseBodyPhase
   */
  public Float getAvgWafMatchedResponseBodyPhase() {
    return avgWafMatchedResponseBodyPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Average number of responses per second matched by waf in response body phase.
   * Field introduced in 17.2.2.
   * @param avgWafMatchedResponseBodyPhase set the avgWafMatchedResponseBodyPhase.
   */
  public void setAvgWafMatchedResponseBodyPhase(Float  avgWafMatchedResponseBodyPhase) {
    this.avgWafMatchedResponseBodyPhase = avgWafMatchedResponseBodyPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average number of responses per second matched by waf in response header phase.
   * Field introduced in 17.2.2.
   * @return avgWafMatchedResponseHeaderPhase
   */
  public Float getAvgWafMatchedResponseHeaderPhase() {
    return avgWafMatchedResponseHeaderPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Average number of responses per second matched by waf in response header phase.
   * Field introduced in 17.2.2.
   * @param avgWafMatchedResponseHeaderPhase set the avgWafMatchedResponseHeaderPhase.
   */
  public void setAvgWafMatchedResponseHeaderPhase(Float  avgWafMatchedResponseHeaderPhase) {
    this.avgWafMatchedResponseHeaderPhase = avgWafMatchedResponseHeaderPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average number of transactions per second rejected by waf.
   * Field introduced in 17.2.2.
   * @return avgWafRejected
   */
  public Float getAvgWafRejected() {
    return avgWafRejected;
  }

  /**
   * This is the setter method to the attribute.
   * Average number of transactions per second rejected by waf.
   * Field introduced in 17.2.2.
   * @param avgWafRejected set the avgWafRejected.
   */
  public void setAvgWafRejected(Float  avgWafRejected) {
    this.avgWafRejected = avgWafRejected;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average number of requests per second rejected by waf in request body phase.
   * Field introduced in 17.2.2.
   * @return avgWafRejectedRequestBodyPhase
   */
  public Float getAvgWafRejectedRequestBodyPhase() {
    return avgWafRejectedRequestBodyPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Average number of requests per second rejected by waf in request body phase.
   * Field introduced in 17.2.2.
   * @param avgWafRejectedRequestBodyPhase set the avgWafRejectedRequestBodyPhase.
   */
  public void setAvgWafRejectedRequestBodyPhase(Float  avgWafRejectedRequestBodyPhase) {
    this.avgWafRejectedRequestBodyPhase = avgWafRejectedRequestBodyPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average number of requests per second rejected by waf in request header phase.
   * Field introduced in 17.2.2.
   * @return avgWafRejectedRequestHeaderPhase
   */
  public Float getAvgWafRejectedRequestHeaderPhase() {
    return avgWafRejectedRequestHeaderPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Average number of requests per second rejected by waf in request header phase.
   * Field introduced in 17.2.2.
   * @param avgWafRejectedRequestHeaderPhase set the avgWafRejectedRequestHeaderPhase.
   */
  public void setAvgWafRejectedRequestHeaderPhase(Float  avgWafRejectedRequestHeaderPhase) {
    this.avgWafRejectedRequestHeaderPhase = avgWafRejectedRequestHeaderPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average number of responses per second rejected by waf in response body phase.
   * Field introduced in 17.2.2.
   * @return avgWafRejectedResponseBodyPhase
   */
  public Float getAvgWafRejectedResponseBodyPhase() {
    return avgWafRejectedResponseBodyPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Average number of responses per second rejected by waf in response body phase.
   * Field introduced in 17.2.2.
   * @param avgWafRejectedResponseBodyPhase set the avgWafRejectedResponseBodyPhase.
   */
  public void setAvgWafRejectedResponseBodyPhase(Float  avgWafRejectedResponseBodyPhase) {
    this.avgWafRejectedResponseBodyPhase = avgWafRejectedResponseBodyPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average number of responses per second rejected by waf in response header phase.
   * Field introduced in 17.2.2.
   * @return avgWafRejectedResponseHeaderPhase
   */
  public Float getAvgWafRejectedResponseHeaderPhase() {
    return avgWafRejectedResponseHeaderPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Average number of responses per second rejected by waf in response header phase.
   * Field introduced in 17.2.2.
   * @param avgWafRejectedResponseHeaderPhase set the avgWafRejectedResponseHeaderPhase.
   */
  public void setAvgWafRejectedResponseHeaderPhase(Float  avgWafRejectedResponseHeaderPhase) {
    this.avgWafRejectedResponseHeaderPhase = avgWafRejectedResponseHeaderPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average waiting time reported by client.
   * @return avgWaitingTime
   */
  public Float getAvgWaitingTime() {
    return avgWaitingTime;
  }

  /**
   * This is the setter method to the attribute.
   * Average waiting time reported by client.
   * @param avgWaitingTime set the avgWaitingTime.
   */
  public void setAvgWaitingTime(Float  avgWaitingTime) {
    this.avgWaitingTime = avgWaitingTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of concurrent http sessions.
   * @return maxConcurrentSessions
   */
  public Float getMaxConcurrentSessions() {
    return maxConcurrentSessions;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of concurrent http sessions.
   * @param maxConcurrentSessions set the maxConcurrentSessions.
   */
  public void setMaxConcurrentSessions(Float  maxConcurrentSessions) {
    this.maxConcurrentSessions = maxConcurrentSessions;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of open ssl sessions.
   * @return maxSslOpenSessions
   */
  public Float getMaxSslOpenSessions() {
    return maxSslOpenSessions;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of open ssl sessions.
   * @param maxSslOpenSessions set the maxSslOpenSessions.
   */
  public void setMaxSslOpenSessions(Float  maxSslOpenSessions) {
    this.maxSslOpenSessions = maxSslOpenSessions;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property node_obj_id of obj type vserverl7metricsobj field type str  type string.
   * @return nodeObjId
   */
  public String getNodeObjId() {
    return nodeObjId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property node_obj_id of obj type vserverl7metricsobj field type str  type string.
   * @param nodeObjId set the nodeObjId.
   */
  public void setNodeObjId(String  nodeObjId) {
    this.nodeObjId = nodeObjId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Percentage cache hit of requests.
   * @return pctCacheHits
   */
  public Float getPctCacheHits() {
    return pctCacheHits;
  }

  /**
   * This is the setter method to the attribute.
   * Percentage cache hit of requests.
   * @param pctCacheHits set the pctCacheHits.
   */
  public void setPctCacheHits(Float  pctCacheHits) {
    this.pctCacheHits = pctCacheHits;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Percentage cacheable hit of requests.
   * @return pctCacheableHits
   */
  public Float getPctCacheableHits() {
    return pctCacheableHits;
  }

  /**
   * This is the setter method to the attribute.
   * Percentage cacheable hit of requests.
   * @param pctCacheableHits set the pctCacheableHits.
   */
  public void setPctCacheableHits(Float  pctCacheableHits) {
    this.pctCacheableHits = pctCacheableHits;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Number of http get requests as a percentage of total requests received.
   * Field introduced in 17.2.12, 18.1.2.
   * @return pctGetReqs
   */
  public Float getPctGetReqs() {
    return pctGetReqs;
  }

  /**
   * This is the setter method to the attribute.
   * Number of http get requests as a percentage of total requests received.
   * Field introduced in 17.2.12, 18.1.2.
   * @param pctGetReqs set the pctGetReqs.
   */
  public void setPctGetReqs(Float  pctGetReqs) {
    this.pctGetReqs = pctGetReqs;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Number of http post requests as a percentage of total requests received.
   * Field introduced in 17.2.12, 18.1.2.
   * @return pctPostReqs
   */
  public Float getPctPostReqs() {
    return pctPostReqs;
  }

  /**
   * This is the setter method to the attribute.
   * Number of http post requests as a percentage of total requests received.
   * Field introduced in 17.2.12, 18.1.2.
   * @param pctPostReqs set the pctPostReqs.
   */
  public void setPctPostReqs(Float  pctPostReqs) {
    this.pctPostReqs = pctPostReqs;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Percent of 4xx and 5xx responses.
   * @return pctResponseErrors
   */
  public Float getPctResponseErrors() {
    return pctResponseErrors;
  }

  /**
   * This is the setter method to the attribute.
   * Percent of 4xx and 5xx responses.
   * @param pctResponseErrors set the pctResponseErrors.
   */
  public void setPctResponseErrors(Float  pctResponseErrors) {
    this.pctResponseErrors = pctResponseErrors;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Percent of ssl connections failured due to protocol , network or timeout reasons.
   * @return pctSslFailedConnections
   */
  public Float getPctSslFailedConnections() {
    return pctSslFailedConnections;
  }

  /**
   * This is the setter method to the attribute.
   * Percent of ssl connections failured due to protocol , network or timeout reasons.
   * @param pctSslFailedConnections set the pctSslFailedConnections.
   */
  public void setPctSslFailedConnections(Float  pctSslFailedConnections) {
    this.pctSslFailedConnections = pctSslFailedConnections;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Malicious transactions (attacks) identified by waf as the pecentage  of total requests received.
   * Field introduced in 17.2.3.
   * @return pctWafAttacks
   */
  public Float getPctWafAttacks() {
    return pctWafAttacks;
  }

  /**
   * This is the setter method to the attribute.
   * Malicious transactions (attacks) identified by waf as the pecentage  of total requests received.
   * Field introduced in 17.2.3.
   * @param pctWafAttacks set the pctWafAttacks.
   */
  public void setPctWafAttacks(Float  pctWafAttacks) {
    this.pctWafAttacks = pctWafAttacks;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Transactions bypassing waf as the percentage of total requests received.
   * Field introduced in 17.2.12, 18.1.2.
   * @return pctWafDisabled
   */
  public Float getPctWafDisabled() {
    return pctWafDisabled;
  }

  /**
   * This is the setter method to the attribute.
   * Transactions bypassing waf as the percentage of total requests received.
   * Field introduced in 17.2.12, 18.1.2.
   * @param pctWafDisabled set the pctWafDisabled.
   */
  public void setPctWafDisabled(Float  pctWafDisabled) {
    this.pctWafDisabled = pctWafDisabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Waf evaluated transactions as the pecentage of total requests received.
   * Field introduced in 17.2.2.
   * @return pctWafEvaluated
   */
  public Float getPctWafEvaluated() {
    return pctWafEvaluated;
  }

  /**
   * This is the setter method to the attribute.
   * Waf evaluated transactions as the pecentage of total requests received.
   * Field introduced in 17.2.2.
   * @param pctWafEvaluated set the pctWafEvaluated.
   */
  public void setPctWafEvaluated(Float  pctWafEvaluated) {
    this.pctWafEvaluated = pctWafEvaluated;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Waf flagged transactions as the percentage of total waf evaluated transactions.
   * Field introduced in 17.2.2.
   * @return pctWafFlagged
   */
  public Float getPctWafFlagged() {
    return pctWafFlagged;
  }

  /**
   * This is the setter method to the attribute.
   * Waf flagged transactions as the percentage of total waf evaluated transactions.
   * Field introduced in 17.2.2.
   * @param pctWafFlagged set the pctWafFlagged.
   */
  public void setPctWafFlagged(Float  pctWafFlagged) {
    this.pctWafFlagged = pctWafFlagged;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Waf matched requests as the percentage of total waf evaluated requests.
   * Field introduced in 17.2.2.
   * @return pctWafMatched
   */
  public Float getPctWafMatched() {
    return pctWafMatched;
  }

  /**
   * This is the setter method to the attribute.
   * Waf matched requests as the percentage of total waf evaluated requests.
   * Field introduced in 17.2.2.
   * @param pctWafMatched set the pctWafMatched.
   */
  public void setPctWafMatched(Float  pctWafMatched) {
    this.pctWafMatched = pctWafMatched;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Waf rejected transactions as the percentage of total waf evaluated transactions.
   * Field introduced in 17.2.2.
   * @return pctWafRejected
   */
  public Float getPctWafRejected() {
    return pctWafRejected;
  }

  /**
   * This is the setter method to the attribute.
   * Waf rejected transactions as the percentage of total waf evaluated transactions.
   * Field introduced in 17.2.2.
   * @param pctWafRejected set the pctWafRejected.
   */
  public void setPctWafRejected(Float  pctWafRejected) {
    this.pctWafRejected = pctWafRejected;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Apdex measures quality of server response based on real user metric.
   * @return rumApdexr
   */
  public Float getRumApdexr() {
    return rumApdexr;
  }

  /**
   * This is the setter method to the attribute.
   * Apdex measures quality of server response based on real user metric.
   * @param rumApdexr set the rumApdexr.
   */
  public void setRumApdexr(Float  rumApdexr) {
    this.rumApdexr = rumApdexr;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Protocol strength of ssl ciphers used.
   * @return sslProtocolStrength
   */
  public Float getSslProtocolStrength() {
    return sslProtocolStrength;
  }

  /**
   * This is the setter method to the attribute.
   * Protocol strength of ssl ciphers used.
   * @param sslProtocolStrength set the sslProtocolStrength.
   */
  public void setSslProtocolStrength(Float  sslProtocolStrength) {
    this.sslProtocolStrength = sslProtocolStrength;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total time taken by server to respond to requesti.
   * @return sumApplicationResponseTime
   */
  public Float getSumApplicationResponseTime() {
    return sumApplicationResponseTime;
  }

  /**
   * This is the setter method to the attribute.
   * Total time taken by server to respond to requesti.
   * @param sumApplicationResponseTime set the sumApplicationResponseTime.
   */
  public void setSumApplicationResponseTime(Float  sumApplicationResponseTime) {
    this.sumApplicationResponseTime = sumApplicationResponseTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total time client was blocked.
   * @return sumBlockingTime
   */
  public Float getSumBlockingTime() {
    return sumBlockingTime;
  }

  /**
   * This is the setter method to the attribute.
   * Total time client was blocked.
   * @param sumBlockingTime set the sumBlockingTime.
   */
  public void setSumBlockingTime(Float  sumBlockingTime) {
    this.sumBlockingTime = sumBlockingTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total browser rendering latency reported by client.
   * @return sumBrowserRenderingTime
   */
  public Float getSumBrowserRenderingTime() {
    return sumBrowserRenderingTime;
  }

  /**
   * This is the setter method to the attribute.
   * Total browser rendering latency reported by client.
   * @param sumBrowserRenderingTime set the sumBrowserRenderingTime.
   */
  public void setSumBrowserRenderingTime(Float  sumBrowserRenderingTime) {
    this.sumBrowserRenderingTime = sumBrowserRenderingTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Average client data transfer time computed by adding response latencies across all http requests.
   * @return sumClientDataTransferTime
   */
  public Float getSumClientDataTransferTime() {
    return sumClientDataTransferTime;
  }

  /**
   * This is the setter method to the attribute.
   * Average client data transfer time computed by adding response latencies across all http requests.
   * @param sumClientDataTransferTime set the sumClientDataTransferTime.
   */
  public void setSumClientDataTransferTime(Float  sumClientDataTransferTime) {
    this.sumClientDataTransferTime = sumClientDataTransferTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Sum of all client round trip times for all samples.
   * @return sumClientRtt
   */
  public Float getSumClientRtt() {
    return sumClientRtt;
  }

  /**
   * This is the setter method to the attribute.
   * Sum of all client round trip times for all samples.
   * @param sumClientRtt set the sumClientRtt.
   */
  public void setSumClientRtt(Float  sumClientRtt) {
    this.sumClientRtt = sumClientRtt;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total client connection latency reported by client.
   * @return sumConnectionTime
   */
  public Float getSumConnectionTime() {
    return sumConnectionTime;
  }

  /**
   * This is the setter method to the attribute.
   * Total client connection latency reported by client.
   * @param sumConnectionTime set the sumConnectionTime.
   */
  public void setSumConnectionTime(Float  sumConnectionTime) {
    this.sumConnectionTime = sumConnectionTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total domain lookup latency reported by client.
   * @return sumDnsLookupTime
   */
  public Float getSumDnsLookupTime() {
    return sumDnsLookupTime;
  }

  /**
   * This is the setter method to the attribute.
   * Total domain lookup latency reported by client.
   * @param sumDnsLookupTime set the sumDnsLookupTime.
   */
  public void setSumDnsLookupTime(Float  sumDnsLookupTime) {
    this.sumDnsLookupTime = sumDnsLookupTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total dom content latency reported by client.
   * @return sumDomContentLoadTime
   */
  public Float getSumDomContentLoadTime() {
    return sumDomContentLoadTime;
  }

  /**
   * This is the setter method to the attribute.
   * Total dom content latency reported by client.
   * @param sumDomContentLoadTime set the sumDomContentLoadTime.
   */
  public void setSumDomContentLoadTime(Float  sumDomContentLoadTime) {
    this.sumDomContentLoadTime = sumDomContentLoadTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Count of http 400 and 500 errors for a virtual service in a time interval.
   * @return sumErrors
   */
  public Float getSumErrors() {
    return sumErrors;
  }

  /**
   * This is the setter method to the attribute.
   * Count of http 400 and 500 errors for a virtual service in a time interval.
   * @param sumErrors set the sumErrors.
   */
  public void setSumErrors(Float  sumErrors) {
    this.sumErrors = sumErrors;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Number of server sessions closed in this interval.
   * @return sumFinishedSessions
   */
  public Float getSumFinishedSessions() {
    return sumFinishedSessions;
  }

  /**
   * This is the setter method to the attribute.
   * Number of server sessions closed in this interval.
   * @param sumFinishedSessions set the sumFinishedSessions.
   */
  public void setSumFinishedSessions(Float  sumFinishedSessions) {
    this.sumFinishedSessions = sumFinishedSessions;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total latency from responses to all the get requests.
   * @return sumGetClientTxnLatency
   */
  public Float getSumGetClientTxnLatency() {
    return sumGetClientTxnLatency;
  }

  /**
   * This is the setter method to the attribute.
   * Total latency from responses to all the get requests.
   * @param sumGetClientTxnLatency set the sumGetClientTxnLatency.
   */
  public void setSumGetClientTxnLatency(Float  sumGetClientTxnLatency) {
    this.sumGetClientTxnLatency = sumGetClientTxnLatency;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of http get requests that were responded satisfactorily within latency threshold.
   * @return sumGetClientTxnLatencyBucket1
   */
  public Float getSumGetClientTxnLatencyBucket1() {
    return sumGetClientTxnLatencyBucket1;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of http get requests that were responded satisfactorily within latency threshold.
   * @param sumGetClientTxnLatencyBucket1 set the sumGetClientTxnLatencyBucket1.
   */
  public void setSumGetClientTxnLatencyBucket1(Float  sumGetClientTxnLatencyBucket1) {
    this.sumGetClientTxnLatencyBucket1 = sumGetClientTxnLatencyBucket1;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of http get requests that were responded beyond latency threshold but within tolerated limits.
   * @return sumGetClientTxnLatencyBucket2
   */
  public Float getSumGetClientTxnLatencyBucket2() {
    return sumGetClientTxnLatencyBucket2;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of http get requests that were responded beyond latency threshold but within tolerated limits.
   * @param sumGetClientTxnLatencyBucket2 set the sumGetClientTxnLatencyBucket2.
   */
  public void setSumGetClientTxnLatencyBucket2(Float  sumGetClientTxnLatencyBucket2) {
    this.sumGetClientTxnLatencyBucket2 = sumGetClientTxnLatencyBucket2;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of http get requests.
   * @return sumGetReqs
   */
  public Float getSumGetReqs() {
    return sumGetReqs;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of http get requests.
   * @param sumGetReqs set the sumGetReqs.
   */
  public void setSumGetReqs(Float  sumGetReqs) {
    this.sumGetReqs = sumGetReqs;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total size of http request headers.
   * Field introduced in 17.2.12, 18.1.2.
   * @return sumHttpHeadersBytes
   */
  public Float getSumHttpHeadersBytes() {
    return sumHttpHeadersBytes;
  }

  /**
   * This is the setter method to the attribute.
   * Total size of http request headers.
   * Field introduced in 17.2.12, 18.1.2.
   * @param sumHttpHeadersBytes set the sumHttpHeadersBytes.
   */
  public void setSumHttpHeadersBytes(Float  sumHttpHeadersBytes) {
    this.sumHttpHeadersBytes = sumHttpHeadersBytes;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of http headers across all requests in a given metrics interval.
   * Field introduced in 17.2.12, 18.1.2.
   * @return sumHttpHeadersCount
   */
  public Float getSumHttpHeadersCount() {
    return sumHttpHeadersCount;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of http headers across all requests in a given metrics interval.
   * Field introduced in 17.2.12, 18.1.2.
   * @param sumHttpHeadersCount set the sumHttpHeadersCount.
   */
  public void setSumHttpHeadersCount(Float  sumHttpHeadersCount) {
    this.sumHttpHeadersCount = sumHttpHeadersCount;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of http request parameters.
   * Field introduced in 17.2.12, 18.1.2.
   * @return sumHttpParamsCount
   */
  public Float getSumHttpParamsCount() {
    return sumHttpParamsCount;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of http request parameters.
   * Field introduced in 17.2.12, 18.1.2.
   * @param sumHttpParamsCount set the sumHttpParamsCount.
   */
  public void setSumHttpParamsCount(Float  sumHttpParamsCount) {
    this.sumHttpParamsCount = sumHttpParamsCount;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total samples that had satisfactory page load time.
   * @return sumNumPageLoadTimeBucket1
   */
  public Float getSumNumPageLoadTimeBucket1() {
    return sumNumPageLoadTimeBucket1;
  }

  /**
   * This is the setter method to the attribute.
   * Total samples that had satisfactory page load time.
   * @param sumNumPageLoadTimeBucket1 set the sumNumPageLoadTimeBucket1.
   */
  public void setSumNumPageLoadTimeBucket1(Float  sumNumPageLoadTimeBucket1) {
    this.sumNumPageLoadTimeBucket1 = sumNumPageLoadTimeBucket1;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total samples that had tolerated page load time.
   * @return sumNumPageLoadTimeBucket2
   */
  public Float getSumNumPageLoadTimeBucket2() {
    return sumNumPageLoadTimeBucket2;
  }

  /**
   * This is the setter method to the attribute.
   * Total samples that had tolerated page load time.
   * @param sumNumPageLoadTimeBucket2 set the sumNumPageLoadTimeBucket2.
   */
  public void setSumNumPageLoadTimeBucket2(Float  sumNumPageLoadTimeBucket2) {
    this.sumNumPageLoadTimeBucket2 = sumNumPageLoadTimeBucket2;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total samples used for rum metrics.
   * @return sumNumRumSamples
   */
  public Float getSumNumRumSamples() {
    return sumNumRumSamples;
  }

  /**
   * This is the setter method to the attribute.
   * Total samples used for rum metrics.
   * @param sumNumRumSamples set the sumNumRumSamples.
   */
  public void setSumNumRumSamples(Float  sumNumRumSamples) {
    this.sumNumRumSamples = sumNumRumSamples;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total latency from responses to all the requests other than get or post.
   * @return sumOtherClientTxnLatency
   */
  public Float getSumOtherClientTxnLatency() {
    return sumOtherClientTxnLatency;
  }

  /**
   * This is the setter method to the attribute.
   * Total latency from responses to all the requests other than get or post.
   * @param sumOtherClientTxnLatency set the sumOtherClientTxnLatency.
   */
  public void setSumOtherClientTxnLatency(Float  sumOtherClientTxnLatency) {
    this.sumOtherClientTxnLatency = sumOtherClientTxnLatency;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of http requests other than get or post that were responded satisfactorily within latency threshold.
   * @return sumOtherClientTxnLatencyBucket1
   */
  public Float getSumOtherClientTxnLatencyBucket1() {
    return sumOtherClientTxnLatencyBucket1;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of http requests other than get or post that were responded satisfactorily within latency threshold.
   * @param sumOtherClientTxnLatencyBucket1 set the sumOtherClientTxnLatencyBucket1.
   */
  public void setSumOtherClientTxnLatencyBucket1(Float  sumOtherClientTxnLatencyBucket1) {
    this.sumOtherClientTxnLatencyBucket1 = sumOtherClientTxnLatencyBucket1;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of http requests other than get or post that were responded beyond latency threshold but within tolerated limits.
   * @return sumOtherClientTxnLatencyBucket2
   */
  public Float getSumOtherClientTxnLatencyBucket2() {
    return sumOtherClientTxnLatencyBucket2;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of http requests other than get or post that were responded beyond latency threshold but within tolerated limits.
   * @param sumOtherClientTxnLatencyBucket2 set the sumOtherClientTxnLatencyBucket2.
   */
  public void setSumOtherClientTxnLatencyBucket2(Float  sumOtherClientTxnLatencyBucket2) {
    this.sumOtherClientTxnLatencyBucket2 = sumOtherClientTxnLatencyBucket2;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of http requests that are not get or post requests.
   * @return sumOtherReqs
   */
  public Float getSumOtherReqs() {
    return sumOtherReqs;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of http requests that are not get or post requests.
   * @param sumOtherReqs set the sumOtherReqs.
   */
  public void setSumOtherReqs(Float  sumOtherReqs) {
    this.sumOtherReqs = sumOtherReqs;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total time to transfer response to client.
   * @return sumPageDownloadTime
   */
  public Float getSumPageDownloadTime() {
    return sumPageDownloadTime;
  }

  /**
   * This is the setter method to the attribute.
   * Total time to transfer response to client.
   * @param sumPageDownloadTime set the sumPageDownloadTime.
   */
  public void setSumPageDownloadTime(Float  sumPageDownloadTime) {
    this.sumPageDownloadTime = sumPageDownloadTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total page load time reported by client.
   * @return sumPageLoadTime
   */
  public Float getSumPageLoadTime() {
    return sumPageLoadTime;
  }

  /**
   * This is the setter method to the attribute.
   * Total page load time reported by client.
   * @param sumPageLoadTime set the sumPageLoadTime.
   */
  public void setSumPageLoadTime(Float  sumPageLoadTime) {
    this.sumPageLoadTime = sumPageLoadTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total size of http post requests.
   * Field introduced in 17.2.12, 18.1.2.
   * @return sumPostBytes
   */
  public Float getSumPostBytes() {
    return sumPostBytes;
  }

  /**
   * This is the setter method to the attribute.
   * Total size of http post requests.
   * Field introduced in 17.2.12, 18.1.2.
   * @param sumPostBytes set the sumPostBytes.
   */
  public void setSumPostBytes(Float  sumPostBytes) {
    this.sumPostBytes = sumPostBytes;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total latency from responses to all the post requests.
   * @return sumPostClientTxnLatency
   */
  public Float getSumPostClientTxnLatency() {
    return sumPostClientTxnLatency;
  }

  /**
   * This is the setter method to the attribute.
   * Total latency from responses to all the post requests.
   * @param sumPostClientTxnLatency set the sumPostClientTxnLatency.
   */
  public void setSumPostClientTxnLatency(Float  sumPostClientTxnLatency) {
    this.sumPostClientTxnLatency = sumPostClientTxnLatency;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of http post requests that were responded satisfactorily within latency threshold.
   * @return sumPostClientTxnLatencyBucket1
   */
  public Float getSumPostClientTxnLatencyBucket1() {
    return sumPostClientTxnLatencyBucket1;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of http post requests that were responded satisfactorily within latency threshold.
   * @param sumPostClientTxnLatencyBucket1 set the sumPostClientTxnLatencyBucket1.
   */
  public void setSumPostClientTxnLatencyBucket1(Float  sumPostClientTxnLatencyBucket1) {
    this.sumPostClientTxnLatencyBucket1 = sumPostClientTxnLatencyBucket1;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of http post requests that were responded beyond latency threshold but within tolerated limits.
   * @return sumPostClientTxnLatencyBucket2
   */
  public Float getSumPostClientTxnLatencyBucket2() {
    return sumPostClientTxnLatencyBucket2;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of http post requests that were responded beyond latency threshold but within tolerated limits.
   * @param sumPostClientTxnLatencyBucket2 set the sumPostClientTxnLatencyBucket2.
   */
  public void setSumPostClientTxnLatencyBucket2(Float  sumPostClientTxnLatencyBucket2) {
    this.sumPostClientTxnLatencyBucket2 = sumPostClientTxnLatencyBucket2;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of http post requests.
   * @return sumPostReqs
   */
  public Float getSumPostReqs() {
    return sumPostReqs;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of http post requests.
   * @param sumPostReqs set the sumPostReqs.
   */
  public void setSumPostReqs(Float  sumPostReqs) {
    this.sumPostReqs = sumPostReqs;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total redirect latency reported by client.
   * @return sumRedirectionTime
   */
  public Float getSumRedirectionTime() {
    return sumRedirectionTime;
  }

  /**
   * This is the setter method to the attribute.
   * Total redirect latency reported by client.
   * @param sumRedirectionTime set the sumRedirectionTime.
   */
  public void setSumRedirectionTime(Float  sumRedirectionTime) {
    this.sumRedirectionTime = sumRedirectionTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of requests served across server sessions closed in the interval.
   * @return sumReqsFinishedSessions
   */
  public Float getSumReqsFinishedSessions() {
    return sumReqsFinishedSessions;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of requests served across server sessions closed in the interval.
   * @param sumReqsFinishedSessions set the sumReqsFinishedSessions.
   */
  public void setSumReqsFinishedSessions(Float  sumReqsFinishedSessions) {
    this.sumReqsFinishedSessions = sumReqsFinishedSessions;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of http requests containing at least one parameter.
   * Field introduced in 17.2.12, 18.1.3.
   * @return sumReqsWithParams
   */
  public Float getSumReqsWithParams() {
    return sumReqsWithParams;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of http requests containing at least one parameter.
   * Field introduced in 17.2.12, 18.1.3.
   * @param sumReqsWithParams set the sumReqsWithParams.
   */
  public void setSumReqsWithParams(Float  sumReqsWithParams) {
    this.sumReqsWithParams = sumReqsWithParams;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of http 1xx responses.
   * @return sumResp1Xx
   */
  public Float getSumResp1Xx() {
    return sumResp1Xx;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of http 1xx responses.
   * @param sumResp1Xx set the sumResp1Xx.
   */
  public void setSumResp1Xx(Float  sumResp1Xx) {
    this.sumResp1Xx = sumResp1Xx;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of http 2xx responses.
   * @return sumResp2Xx
   */
  public Float getSumResp2Xx() {
    return sumResp2Xx;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of http 2xx responses.
   * @param sumResp2Xx set the sumResp2Xx.
   */
  public void setSumResp2Xx(Float  sumResp2Xx) {
    this.sumResp2Xx = sumResp2Xx;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of http 3xx responses.
   * @return sumResp3Xx
   */
  public Float getSumResp3Xx() {
    return sumResp3Xx;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of http 3xx responses.
   * @param sumResp3Xx set the sumResp3Xx.
   */
  public void setSumResp3Xx(Float  sumResp3Xx) {
    this.sumResp3Xx = sumResp3Xx;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of http 4xx error responses.
   * @return sumResp4Xx
   */
  public Float getSumResp4Xx() {
    return sumResp4Xx;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of http 4xx error responses.
   * @param sumResp4Xx set the sumResp4Xx.
   */
  public void setSumResp4Xx(Float  sumResp4Xx) {
    this.sumResp4Xx = sumResp4Xx;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of http 5xx error responses.
   * @return sumResp5Xx
   */
  public Float getSumResp5Xx() {
    return sumResp5Xx;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of http 5xx error responses.
   * @param sumResp5Xx set the sumResp5Xx.
   */
  public void setSumResp5Xx(Float  sumResp5Xx) {
    this.sumResp5Xx = sumResp5Xx;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total client data transfer time by client.
   * @return sumRumClientDataTransferTime
   */
  public Float getSumRumClientDataTransferTime() {
    return sumRumClientDataTransferTime;
  }

  /**
   * This is the setter method to the attribute.
   * Total client data transfer time by client.
   * @param sumRumClientDataTransferTime set the sumRumClientDataTransferTime.
   */
  public void setSumRumClientDataTransferTime(Float  sumRumClientDataTransferTime) {
    this.sumRumClientDataTransferTime = sumRumClientDataTransferTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Sum of all server round trip times for all samples.
   * @return sumServerRtt
   */
  public Float getSumServerRtt() {
    return sumServerRtt;
  }

  /**
   * This is the setter method to the attribute.
   * Sum of all server round trip times for all samples.
   * @param sumServerRtt set the sumServerRtt.
   */
  public void setSumServerRtt(Float  sumServerRtt) {
    this.sumServerRtt = sumServerRtt;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total time from receipt of request to start of response.
   * @return sumServiceTime
   */
  public Float getSumServiceTime() {
    return sumServiceTime;
  }

  /**
   * This is the setter method to the attribute.
   * Total time from receipt of request to start of response.
   * @param sumServiceTime set the sumServiceTime.
   */
  public void setSumServiceTime(Float  sumServiceTime) {
    this.sumServiceTime = sumServiceTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of http responses sent.
   * @return sumTotalResponses
   */
  public Float getSumTotalResponses() {
    return sumTotalResponses;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of http responses sent.
   * @param sumTotalResponses set the sumTotalResponses.
   */
  public void setSumTotalResponses(Float  sumTotalResponses) {
    this.sumTotalResponses = sumTotalResponses;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total length of http request uris.
   * Field introduced in 17.2.12, 18.1.2.
   * @return sumUriLength
   */
  public Float getSumUriLength() {
    return sumUriLength;
  }

  /**
   * This is the setter method to the attribute.
   * Total length of http request uris.
   * Field introduced in 17.2.12, 18.1.2.
   * @param sumUriLength set the sumUriLength.
   */
  public void setSumUriLength(Float  sumUriLength) {
    this.sumUriLength = sumUriLength;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of transactions identified by waf as attacks.
   * Field introduced in 17.2.3.
   * @return sumWafAttacks
   */
  public Float getSumWafAttacks() {
    return sumWafAttacks;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of transactions identified by waf as attacks.
   * Field introduced in 17.2.3.
   * @param sumWafAttacks set the sumWafAttacks.
   */
  public void setSumWafAttacks(Float  sumWafAttacks) {
    this.sumWafAttacks = sumWafAttacks;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of requests bypassing waf.
   * Field introduced in 17.2.12, 18.1.2.
   * @return sumWafDisabled
   */
  public Float getSumWafDisabled() {
    return sumWafDisabled;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of requests bypassing waf.
   * Field introduced in 17.2.12, 18.1.2.
   * @param sumWafDisabled set the sumWafDisabled.
   */
  public void setSumWafDisabled(Float  sumWafDisabled) {
    this.sumWafDisabled = sumWafDisabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of requests evaluated by waf in request body phase.
   * Field introduced in 17.2.2.
   * @return sumWafEvaluatedRequestBodyPhase
   */
  public Float getSumWafEvaluatedRequestBodyPhase() {
    return sumWafEvaluatedRequestBodyPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of requests evaluated by waf in request body phase.
   * Field introduced in 17.2.2.
   * @param sumWafEvaluatedRequestBodyPhase set the sumWafEvaluatedRequestBodyPhase.
   */
  public void setSumWafEvaluatedRequestBodyPhase(Float  sumWafEvaluatedRequestBodyPhase) {
    this.sumWafEvaluatedRequestBodyPhase = sumWafEvaluatedRequestBodyPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of requests evaluated by waf in request header phase.
   * Field introduced in 17.2.2.
   * @return sumWafEvaluatedRequestHeaderPhase
   */
  public Float getSumWafEvaluatedRequestHeaderPhase() {
    return sumWafEvaluatedRequestHeaderPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of requests evaluated by waf in request header phase.
   * Field introduced in 17.2.2.
   * @param sumWafEvaluatedRequestHeaderPhase set the sumWafEvaluatedRequestHeaderPhase.
   */
  public void setSumWafEvaluatedRequestHeaderPhase(Float  sumWafEvaluatedRequestHeaderPhase) {
    this.sumWafEvaluatedRequestHeaderPhase = sumWafEvaluatedRequestHeaderPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of responses evaluated by waf in response body phase.
   * Field introduced in 17.2.2.
   * @return sumWafEvaluatedResponseBodyPhase
   */
  public Float getSumWafEvaluatedResponseBodyPhase() {
    return sumWafEvaluatedResponseBodyPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of responses evaluated by waf in response body phase.
   * Field introduced in 17.2.2.
   * @param sumWafEvaluatedResponseBodyPhase set the sumWafEvaluatedResponseBodyPhase.
   */
  public void setSumWafEvaluatedResponseBodyPhase(Float  sumWafEvaluatedResponseBodyPhase) {
    this.sumWafEvaluatedResponseBodyPhase = sumWafEvaluatedResponseBodyPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of responses evaluated by waf in response header phase.
   * Field introduced in 17.2.2.
   * @return sumWafEvaluatedResponseHeaderPhase
   */
  public Float getSumWafEvaluatedResponseHeaderPhase() {
    return sumWafEvaluatedResponseHeaderPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of responses evaluated by waf in response header phase.
   * Field introduced in 17.2.2.
   * @param sumWafEvaluatedResponseHeaderPhase set the sumWafEvaluatedResponseHeaderPhase.
   */
  public void setSumWafEvaluatedResponseHeaderPhase(Float  sumWafEvaluatedResponseHeaderPhase) {
    this.sumWafEvaluatedResponseHeaderPhase = sumWafEvaluatedResponseHeaderPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of transactions (requests or responses) flagged as attack by waf.
   * Field introduced in 17.2.3.
   * @return sumWafFlagged
   */
  public Float getSumWafFlagged() {
    return sumWafFlagged;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of transactions (requests or responses) flagged as attack by waf.
   * Field introduced in 17.2.3.
   * @param sumWafFlagged set the sumWafFlagged.
   */
  public void setSumWafFlagged(Float  sumWafFlagged) {
    this.sumWafFlagged = sumWafFlagged;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of requests flagged (but not rejected) by waf in request body phase.
   * Field introduced in 17.2.2.
   * @return sumWafFlaggedRequestBodyPhase
   */
  public Float getSumWafFlaggedRequestBodyPhase() {
    return sumWafFlaggedRequestBodyPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of requests flagged (but not rejected) by waf in request body phase.
   * Field introduced in 17.2.2.
   * @param sumWafFlaggedRequestBodyPhase set the sumWafFlaggedRequestBodyPhase.
   */
  public void setSumWafFlaggedRequestBodyPhase(Float  sumWafFlaggedRequestBodyPhase) {
    this.sumWafFlaggedRequestBodyPhase = sumWafFlaggedRequestBodyPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of requests flagged (but not rejected) by waf in request header phase.
   * Field introduced in 17.2.2.
   * @return sumWafFlaggedRequestHeaderPhase
   */
  public Float getSumWafFlaggedRequestHeaderPhase() {
    return sumWafFlaggedRequestHeaderPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of requests flagged (but not rejected) by waf in request header phase.
   * Field introduced in 17.2.2.
   * @param sumWafFlaggedRequestHeaderPhase set the sumWafFlaggedRequestHeaderPhase.
   */
  public void setSumWafFlaggedRequestHeaderPhase(Float  sumWafFlaggedRequestHeaderPhase) {
    this.sumWafFlaggedRequestHeaderPhase = sumWafFlaggedRequestHeaderPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of responses flagged (but not rejected) by waf in response body phase.
   * Field introduced in 17.2.2.
   * @return sumWafFlaggedResponseBodyPhase
   */
  public Float getSumWafFlaggedResponseBodyPhase() {
    return sumWafFlaggedResponseBodyPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of responses flagged (but not rejected) by waf in response body phase.
   * Field introduced in 17.2.2.
   * @param sumWafFlaggedResponseBodyPhase set the sumWafFlaggedResponseBodyPhase.
   */
  public void setSumWafFlaggedResponseBodyPhase(Float  sumWafFlaggedResponseBodyPhase) {
    this.sumWafFlaggedResponseBodyPhase = sumWafFlaggedResponseBodyPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of responses flagged (but not rejected) by waf in response header phase.
   * Field introduced in 17.2.2.
   * @return sumWafFlaggedResponseHeaderPhase
   */
  public Float getSumWafFlaggedResponseHeaderPhase() {
    return sumWafFlaggedResponseHeaderPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of responses flagged (but not rejected) by waf in response header phase.
   * Field introduced in 17.2.2.
   * @param sumWafFlaggedResponseHeaderPhase set the sumWafFlaggedResponseHeaderPhase.
   */
  public void setSumWafFlaggedResponseHeaderPhase(Float  sumWafFlaggedResponseHeaderPhase) {
    this.sumWafFlaggedResponseHeaderPhase = sumWafFlaggedResponseHeaderPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total latency seen by all evaluated requests in request body phase.
   * Field introduced in 17.2.2.
   * @return sumWafLatencyRequestBodyPhase
   */
  public Float getSumWafLatencyRequestBodyPhase() {
    return sumWafLatencyRequestBodyPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Total latency seen by all evaluated requests in request body phase.
   * Field introduced in 17.2.2.
   * @param sumWafLatencyRequestBodyPhase set the sumWafLatencyRequestBodyPhase.
   */
  public void setSumWafLatencyRequestBodyPhase(Float  sumWafLatencyRequestBodyPhase) {
    this.sumWafLatencyRequestBodyPhase = sumWafLatencyRequestBodyPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total latency seen by all transactions evaluated by waf in request header phase.
   * Field introduced in 17.2.2.
   * @return sumWafLatencyRequestHeaderPhase
   */
  public Float getSumWafLatencyRequestHeaderPhase() {
    return sumWafLatencyRequestHeaderPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Total latency seen by all transactions evaluated by waf in request header phase.
   * Field introduced in 17.2.2.
   * @param sumWafLatencyRequestHeaderPhase set the sumWafLatencyRequestHeaderPhase.
   */
  public void setSumWafLatencyRequestHeaderPhase(Float  sumWafLatencyRequestHeaderPhase) {
    this.sumWafLatencyRequestHeaderPhase = sumWafLatencyRequestHeaderPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total latency seen by all evaluated responses in response body phase.
   * Field introduced in 17.2.2.
   * @return sumWafLatencyResponseBodyPhase
   */
  public Float getSumWafLatencyResponseBodyPhase() {
    return sumWafLatencyResponseBodyPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Total latency seen by all evaluated responses in response body phase.
   * Field introduced in 17.2.2.
   * @param sumWafLatencyResponseBodyPhase set the sumWafLatencyResponseBodyPhase.
   */
  public void setSumWafLatencyResponseBodyPhase(Float  sumWafLatencyResponseBodyPhase) {
    this.sumWafLatencyResponseBodyPhase = sumWafLatencyResponseBodyPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total latency seen by all evaluated responsess in waf response header phase.
   * Field introduced in 17.2.2.
   * @return sumWafLatencyResponseHeaderPhase
   */
  public Float getSumWafLatencyResponseHeaderPhase() {
    return sumWafLatencyResponseHeaderPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Total latency seen by all evaluated responsess in waf response header phase.
   * Field introduced in 17.2.2.
   * @param sumWafLatencyResponseHeaderPhase set the sumWafLatencyResponseHeaderPhase.
   */
  public void setSumWafLatencyResponseHeaderPhase(Float  sumWafLatencyResponseHeaderPhase) {
    this.sumWafLatencyResponseHeaderPhase = sumWafLatencyResponseHeaderPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of requests matched by waf in request body phase.
   * Field introduced in 17.2.2.
   * @return sumWafMatchedRequestBodyPhase
   */
  public Float getSumWafMatchedRequestBodyPhase() {
    return sumWafMatchedRequestBodyPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of requests matched by waf in request body phase.
   * Field introduced in 17.2.2.
   * @param sumWafMatchedRequestBodyPhase set the sumWafMatchedRequestBodyPhase.
   */
  public void setSumWafMatchedRequestBodyPhase(Float  sumWafMatchedRequestBodyPhase) {
    this.sumWafMatchedRequestBodyPhase = sumWafMatchedRequestBodyPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of requests matched by waf in request header phase.
   * Field introduced in 17.2.2.
   * @return sumWafMatchedRequestHeaderPhase
   */
  public Float getSumWafMatchedRequestHeaderPhase() {
    return sumWafMatchedRequestHeaderPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of requests matched by waf in request header phase.
   * Field introduced in 17.2.2.
   * @param sumWafMatchedRequestHeaderPhase set the sumWafMatchedRequestHeaderPhase.
   */
  public void setSumWafMatchedRequestHeaderPhase(Float  sumWafMatchedRequestHeaderPhase) {
    this.sumWafMatchedRequestHeaderPhase = sumWafMatchedRequestHeaderPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of responses matched by waf in response body phase.
   * Field introduced in 17.2.2.
   * @return sumWafMatchedResponseBodyPhase
   */
  public Float getSumWafMatchedResponseBodyPhase() {
    return sumWafMatchedResponseBodyPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of responses matched by waf in response body phase.
   * Field introduced in 17.2.2.
   * @param sumWafMatchedResponseBodyPhase set the sumWafMatchedResponseBodyPhase.
   */
  public void setSumWafMatchedResponseBodyPhase(Float  sumWafMatchedResponseBodyPhase) {
    this.sumWafMatchedResponseBodyPhase = sumWafMatchedResponseBodyPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of responses matched by waf in response header phase.
   * Field introduced in 17.2.2.
   * @return sumWafMatchedResponseHeaderPhase
   */
  public Float getSumWafMatchedResponseHeaderPhase() {
    return sumWafMatchedResponseHeaderPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of responses matched by waf in response header phase.
   * Field introduced in 17.2.2.
   * @param sumWafMatchedResponseHeaderPhase set the sumWafMatchedResponseHeaderPhase.
   */
  public void setSumWafMatchedResponseHeaderPhase(Float  sumWafMatchedResponseHeaderPhase) {
    this.sumWafMatchedResponseHeaderPhase = sumWafMatchedResponseHeaderPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of transactions (requests or responses) rejected by waf.
   * Field introduced in 17.2.3.
   * @return sumWafRejected
   */
  public Float getSumWafRejected() {
    return sumWafRejected;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of transactions (requests or responses) rejected by waf.
   * Field introduced in 17.2.3.
   * @param sumWafRejected set the sumWafRejected.
   */
  public void setSumWafRejected(Float  sumWafRejected) {
    this.sumWafRejected = sumWafRejected;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of requests rejected by waf in request body phase.
   * Field introduced in 17.2.2.
   * @return sumWafRejectedRequestBodyPhase
   */
  public Float getSumWafRejectedRequestBodyPhase() {
    return sumWafRejectedRequestBodyPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of requests rejected by waf in request body phase.
   * Field introduced in 17.2.2.
   * @param sumWafRejectedRequestBodyPhase set the sumWafRejectedRequestBodyPhase.
   */
  public void setSumWafRejectedRequestBodyPhase(Float  sumWafRejectedRequestBodyPhase) {
    this.sumWafRejectedRequestBodyPhase = sumWafRejectedRequestBodyPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of requests rejected by waf in request header phase.
   * Field introduced in 17.2.2.
   * @return sumWafRejectedRequestHeaderPhase
   */
  public Float getSumWafRejectedRequestHeaderPhase() {
    return sumWafRejectedRequestHeaderPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of requests rejected by waf in request header phase.
   * Field introduced in 17.2.2.
   * @param sumWafRejectedRequestHeaderPhase set the sumWafRejectedRequestHeaderPhase.
   */
  public void setSumWafRejectedRequestHeaderPhase(Float  sumWafRejectedRequestHeaderPhase) {
    this.sumWafRejectedRequestHeaderPhase = sumWafRejectedRequestHeaderPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of responses rejected by waf in response body phase.
   * Field introduced in 17.2.2.
   * @return sumWafRejectedResponseBodyPhase
   */
  public Float getSumWafRejectedResponseBodyPhase() {
    return sumWafRejectedResponseBodyPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of responses rejected by waf in response body phase.
   * Field introduced in 17.2.2.
   * @param sumWafRejectedResponseBodyPhase set the sumWafRejectedResponseBodyPhase.
   */
  public void setSumWafRejectedResponseBodyPhase(Float  sumWafRejectedResponseBodyPhase) {
    this.sumWafRejectedResponseBodyPhase = sumWafRejectedResponseBodyPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of responses rejected by waf in response header phase.
   * Field introduced in 17.2.2.
   * @return sumWafRejectedResponseHeaderPhase
   */
  public Float getSumWafRejectedResponseHeaderPhase() {
    return sumWafRejectedResponseHeaderPhase;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of responses rejected by waf in response header phase.
   * Field introduced in 17.2.2.
   * @param sumWafRejectedResponseHeaderPhase set the sumWafRejectedResponseHeaderPhase.
   */
  public void setSumWafRejectedResponseHeaderPhase(Float  sumWafRejectedResponseHeaderPhase) {
    this.sumWafRejectedResponseHeaderPhase = sumWafRejectedResponseHeaderPhase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total waiting reported by client.
   * @return sumWaitingTime
   */
  public Float getSumWaitingTime() {
    return sumWaitingTime;
  }

  /**
   * This is the setter method to the attribute.
   * Total waiting reported by client.
   * @param sumWaitingTime set the sumWaitingTime.
   */
  public void setSumWaitingTime(Float  sumWaitingTime) {
    this.sumWaitingTime = sumWaitingTime;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VserverL7MetricsObj objVserverL7MetricsObj = (VserverL7MetricsObj) o;
  return   Objects.equals(this.sumGetReqs, objVserverL7MetricsObj.sumGetReqs)&&
  Objects.equals(this.sumBlockingTime, objVserverL7MetricsObj.sumBlockingTime)&&
  Objects.equals(this.sumTotalResponses, objVserverL7MetricsObj.sumTotalResponses)&&
  Objects.equals(this.avgUriLength, objVserverL7MetricsObj.avgUriLength)&&
  Objects.equals(this.avgHttpHeadersCount, objVserverL7MetricsObj.avgHttpHeadersCount)&&
  Objects.equals(this.avgWafRejectedResponseHeaderPhase, objVserverL7MetricsObj.avgWafRejectedResponseHeaderPhase)&&
  Objects.equals(this.pctWafEvaluated, objVserverL7MetricsObj.pctWafEvaluated)&&
  Objects.equals(this.sumPageLoadTime, objVserverL7MetricsObj.sumPageLoadTime)&&
  Objects.equals(this.pctWafRejected, objVserverL7MetricsObj.pctWafRejected)&&
  Objects.equals(this.avgParamsPerReq, objVserverL7MetricsObj.avgParamsPerReq)&&
  Objects.equals(this.avgRedirectionTime, objVserverL7MetricsObj.avgRedirectionTime)&&
  Objects.equals(this.sumWafEvaluatedResponseHeaderPhase, objVserverL7MetricsObj.sumWafEvaluatedResponseHeaderPhase)&&
  Objects.equals(this.sumWafLatencyRequestBodyPhase, objVserverL7MetricsObj.sumWafLatencyRequestBodyPhase)&&
  Objects.equals(this.sumWafRejectedRequestBodyPhase, objVserverL7MetricsObj.sumWafRejectedRequestBodyPhase)&&
  Objects.equals(this.sumUriLength, objVserverL7MetricsObj.sumUriLength)&&
  Objects.equals(this.avgSslConnections, objVserverL7MetricsObj.avgSslConnections)&&
  Objects.equals(this.avgConnectionTime, objVserverL7MetricsObj.avgConnectionTime)&&
  Objects.equals(this.avgSslRsaPfs, objVserverL7MetricsObj.avgSslRsaPfs)&&
  Objects.equals(this.sumHttpHeadersBytes, objVserverL7MetricsObj.sumHttpHeadersBytes)&&
  Objects.equals(this.avgTotalRequests, objVserverL7MetricsObj.avgTotalRequests)&&
  Objects.equals(this.avgWafFlaggedRequestBodyPhase, objVserverL7MetricsObj.avgWafFlaggedRequestBodyPhase)&&
  Objects.equals(this.pctWafMatched, objVserverL7MetricsObj.pctWafMatched)&&
  Objects.equals(this.sumResp2Xx, objVserverL7MetricsObj.sumResp2Xx)&&
  Objects.equals(this.sumWaitingTime, objVserverL7MetricsObj.sumWaitingTime)&&
  Objects.equals(this.avgServiceTime, objVserverL7MetricsObj.avgServiceTime)&&
  Objects.equals(this.avgWafMatched, objVserverL7MetricsObj.avgWafMatched)&&
  Objects.equals(this.sumWafMatchedRequestHeaderPhase, objVserverL7MetricsObj.sumWafMatchedRequestHeaderPhase)&&
  Objects.equals(this.avgPageLoadTime, objVserverL7MetricsObj.avgPageLoadTime)&&
  Objects.equals(this.sumResp1Xx, objVserverL7MetricsObj.sumResp1Xx)&&
  Objects.equals(this.sumWafRejectedResponseHeaderPhase, objVserverL7MetricsObj.sumWafRejectedResponseHeaderPhase)&&
  Objects.equals(this.nodeObjId, objVserverL7MetricsObj.nodeObjId)&&
  Objects.equals(this.avgSslVerTls12, objVserverL7MetricsObj.avgSslVerTls12)&&
  Objects.equals(this.avgWafFlaggedRequestHeaderPhase, objVserverL7MetricsObj.avgWafFlaggedRequestHeaderPhase)&&
  Objects.equals(this.avgSslVerTls11, objVserverL7MetricsObj.avgSslVerTls11)&&
  Objects.equals(this.avgSslVerTls10, objVserverL7MetricsObj.avgSslVerTls10)&&
  Objects.equals(this.avgWafFlaggedResponseBodyPhase, objVserverL7MetricsObj.avgWafFlaggedResponseBodyPhase)&&
  Objects.equals(this.sumConnectionTime, objVserverL7MetricsObj.sumConnectionTime)&&
  Objects.equals(this.avgResp4Xx, objVserverL7MetricsObj.avgResp4Xx)&&
  Objects.equals(this.avgReqsPerSession, objVserverL7MetricsObj.avgReqsPerSession)&&
  Objects.equals(this.sumWafFlaggedRequestBodyPhase, objVserverL7MetricsObj.sumWafFlaggedRequestBodyPhase)&&
  Objects.equals(this.avgWafRejectedRequestHeaderPhase, objVserverL7MetricsObj.avgWafRejectedRequestHeaderPhase)&&
  Objects.equals(this.sumFinishedSessions, objVserverL7MetricsObj.sumFinishedSessions)&&
  Objects.equals(this.sumWafMatchedResponseBodyPhase, objVserverL7MetricsObj.sumWafMatchedResponseBodyPhase)&&
  Objects.equals(this.avgPageDownloadTime, objVserverL7MetricsObj.avgPageDownloadTime)&&
  Objects.equals(this.rumApdexr, objVserverL7MetricsObj.rumApdexr)&&
  Objects.equals(this.sumWafLatencyResponseHeaderPhase, objVserverL7MetricsObj.sumWafLatencyResponseHeaderPhase)&&
  Objects.equals(this.sumWafMatchedRequestBodyPhase, objVserverL7MetricsObj.sumWafMatchedRequestBodyPhase)&&
  Objects.equals(this.avgToleratedResponses, objVserverL7MetricsObj.avgToleratedResponses)&&
  Objects.equals(this.avgResp2Xx, objVserverL7MetricsObj.avgResp2Xx)&&
  Objects.equals(this.avgErrorsExcluded, objVserverL7MetricsObj.avgErrorsExcluded)&&
  Objects.equals(this.avgSslErrors, objVserverL7MetricsObj.avgSslErrors)&&
  Objects.equals(this.sumNumRumSamples, objVserverL7MetricsObj.sumNumRumSamples)&&
  Objects.equals(this.avgPostBytes, objVserverL7MetricsObj.avgPostBytes)&&
  Objects.equals(this.avgWafMatchedRequestBodyPhase, objVserverL7MetricsObj.avgWafMatchedRequestBodyPhase)&&
  Objects.equals(this.sumDnsLookupTime, objVserverL7MetricsObj.sumDnsLookupTime)&&
  Objects.equals(this.avgWafLatencyResponseBodyPhase, objVserverL7MetricsObj.avgWafLatencyResponseBodyPhase)&&
  Objects.equals(this.avgCacheableHits, objVserverL7MetricsObj.avgCacheableHits)&&
  Objects.equals(this.avgDnsLookupTime, objVserverL7MetricsObj.avgDnsLookupTime)&&
  Objects.equals(this.sumServiceTime, objVserverL7MetricsObj.sumServiceTime)&&
  Objects.equals(this.sumWafEvaluatedRequestHeaderPhase, objVserverL7MetricsObj.sumWafEvaluatedRequestHeaderPhase)&&
  Objects.equals(this.avgSslHandshakesTimedout, objVserverL7MetricsObj.avgSslHandshakesTimedout)&&
  Objects.equals(this.avgErrorResponses, objVserverL7MetricsObj.avgErrorResponses)&&
  Objects.equals(this.avgWafEvaluatedRequestBodyPhase, objVserverL7MetricsObj.avgWafEvaluatedRequestBodyPhase)&&
  Objects.equals(this.avgRumClientDataTransferTime, objVserverL7MetricsObj.avgRumClientDataTransferTime)&&
  Objects.equals(this.sumHttpParamsCount, objVserverL7MetricsObj.sumHttpParamsCount)&&
  Objects.equals(this.avgServerRtt, objVserverL7MetricsObj.avgServerRtt)&&
  Objects.equals(this.sumPostClientTxnLatencyBucket1, objVserverL7MetricsObj.sumPostClientTxnLatencyBucket1)&&
  Objects.equals(this.sumPostClientTxnLatencyBucket2, objVserverL7MetricsObj.sumPostClientTxnLatencyBucket2)&&
  Objects.equals(this.sumOtherClientTxnLatency, objVserverL7MetricsObj.sumOtherClientTxnLatency)&&
  Objects.equals(this.sumRedirectionTime, objVserverL7MetricsObj.sumRedirectionTime)&&
  Objects.equals(this.sumWafLatencyResponseBodyPhase, objVserverL7MetricsObj.sumWafLatencyResponseBodyPhase)&&
  Objects.equals(this.sumReqsWithParams, objVserverL7MetricsObj.sumReqsWithParams)&&
  Objects.equals(this.avgSslKxDh, objVserverL7MetricsObj.avgSslKxDh)&&
  Objects.equals(this.sumWafLatencyRequestHeaderPhase, objVserverL7MetricsObj.sumWafLatencyRequestHeaderPhase)&&
  Objects.equals(this.sumDomContentLoadTime, objVserverL7MetricsObj.sumDomContentLoadTime)&&
  Objects.equals(this.sslProtocolStrength, objVserverL7MetricsObj.sslProtocolStrength)&&
  Objects.equals(this.avgSslAuthEcdsa, objVserverL7MetricsObj.avgSslAuthEcdsa)&&
  Objects.equals(this.avgWafEvaluated, objVserverL7MetricsObj.avgWafEvaluated)&&
  Objects.equals(this.sumApplicationResponseTime, objVserverL7MetricsObj.sumApplicationResponseTime)&&
  Objects.equals(this.sumWafRejected, objVserverL7MetricsObj.sumWafRejected)&&
  Objects.equals(this.sumGetClientTxnLatency, objVserverL7MetricsObj.sumGetClientTxnLatency)&&
  Objects.equals(this.sumPostBytes, objVserverL7MetricsObj.sumPostBytes)&&
  Objects.equals(this.avgWafLatencyResponseHeaderPhase, objVserverL7MetricsObj.avgWafLatencyResponseHeaderPhase)&&
  Objects.equals(this.sumWafDisabled, objVserverL7MetricsObj.sumWafDisabled)&&
  Objects.equals(this.avgSatisfactoryResponses, objVserverL7MetricsObj.avgSatisfactoryResponses)&&
  Objects.equals(this.avgClientRtt, objVserverL7MetricsObj.avgClientRtt)&&
  Objects.equals(this.sumWafMatchedResponseHeaderPhase, objVserverL7MetricsObj.sumWafMatchedResponseHeaderPhase)&&
  Objects.equals(this.maxSslOpenSessions, objVserverL7MetricsObj.maxSslOpenSessions)&&
  Objects.equals(this.sumGetClientTxnLatencyBucket2, objVserverL7MetricsObj.sumGetClientTxnLatencyBucket2)&&
  Objects.equals(this.avgWafRejectedRequestBodyPhase, objVserverL7MetricsObj.avgWafRejectedRequestBodyPhase)&&
  Objects.equals(this.avgSslVerSsl30, objVserverL7MetricsObj.avgSslVerSsl30)&&
  Objects.equals(this.avgWafFlaggedResponseHeaderPhase, objVserverL7MetricsObj.avgWafFlaggedResponseHeaderPhase)&&
  Objects.equals(this.avgPreCompressionBytes, objVserverL7MetricsObj.avgPreCompressionBytes)&&
  Objects.equals(this.avgWafDisabled, objVserverL7MetricsObj.avgWafDisabled)&&
  Objects.equals(this.sumNumPageLoadTimeBucket2, objVserverL7MetricsObj.sumNumPageLoadTimeBucket2)&&
  Objects.equals(this.avgCacheHits, objVserverL7MetricsObj.avgCacheHits)&&
  Objects.equals(this.sumNumPageLoadTimeBucket1, objVserverL7MetricsObj.sumNumPageLoadTimeBucket1)&&
  Objects.equals(this.pctCacheHits, objVserverL7MetricsObj.pctCacheHits)&&
  Objects.equals(this.sumWafFlagged, objVserverL7MetricsObj.sumWafFlagged)&&
  Objects.equals(this.pctSslFailedConnections, objVserverL7MetricsObj.pctSslFailedConnections)&&
  Objects.equals(this.sumWafEvaluatedResponseBodyPhase, objVserverL7MetricsObj.sumWafEvaluatedResponseBodyPhase)&&
  Objects.equals(this.avgSslHandshakesPfs, objVserverL7MetricsObj.avgSslHandshakesPfs)&&
  Objects.equals(this.avgHttpHeadersBytes, objVserverL7MetricsObj.avgHttpHeadersBytes)&&
  Objects.equals(this.avgResp5XxAviErrors, objVserverL7MetricsObj.avgResp5XxAviErrors)&&
  Objects.equals(this.pctWafDisabled, objVserverL7MetricsObj.pctWafDisabled)&&
  Objects.equals(this.avgResp4XxAviErrors, objVserverL7MetricsObj.avgResp4XxAviErrors)&&
  Objects.equals(this.sumWafRejectedResponseBodyPhase, objVserverL7MetricsObj.sumWafRejectedResponseBodyPhase)&&
  Objects.equals(this.sumClientDataTransferTime, objVserverL7MetricsObj.sumClientDataTransferTime)&&
  Objects.equals(this.avgWafEvaluatedResponseHeaderPhase, objVserverL7MetricsObj.avgWafEvaluatedResponseHeaderPhase)&&
  Objects.equals(this.avgSslHandshakesNew, objVserverL7MetricsObj.avgSslHandshakesNew)&&
  Objects.equals(this.avgWafAttacks, objVserverL7MetricsObj.avgWafAttacks)&&
  Objects.equals(this.sumErrors, objVserverL7MetricsObj.sumErrors)&&
  Objects.equals(this.avgWafMatchedRequestHeaderPhase, objVserverL7MetricsObj.avgWafMatchedRequestHeaderPhase)&&
  Objects.equals(this.avgWafLatencyRequestBodyPhase, objVserverL7MetricsObj.avgWafLatencyRequestBodyPhase)&&
  Objects.equals(this.avgCacheBytes, objVserverL7MetricsObj.avgCacheBytes)&&
  Objects.equals(this.sumServerRtt, objVserverL7MetricsObj.sumServerRtt)&&
  Objects.equals(this.pctWafFlagged, objVserverL7MetricsObj.pctWafFlagged)&&
  Objects.equals(this.avgCacheableBytes, objVserverL7MetricsObj.avgCacheableBytes)&&
  Objects.equals(this.sumWafEvaluatedRequestBodyPhase, objVserverL7MetricsObj.sumWafEvaluatedRequestBodyPhase)&&
  Objects.equals(this.avgSslHandshakeNetworkErrors, objVserverL7MetricsObj.avgSslHandshakeNetworkErrors)&&
  Objects.equals(this.avgSslHandshakesReused, objVserverL7MetricsObj.avgSslHandshakesReused)&&
  Objects.equals(this.avgPostCompressionBytes, objVserverL7MetricsObj.avgPostCompressionBytes)&&
  Objects.equals(this.pctCacheableHits, objVserverL7MetricsObj.pctCacheableHits)&&
  Objects.equals(this.avgBrowserRenderingTime, objVserverL7MetricsObj.avgBrowserRenderingTime)&&
  Objects.equals(this.avgWafMatchedResponseBodyPhase, objVserverL7MetricsObj.avgWafMatchedResponseBodyPhase)&&
  Objects.equals(this.sumResp3Xx, objVserverL7MetricsObj.sumResp3Xx)&&
  Objects.equals(this.avgHttpParamsCount, objVserverL7MetricsObj.avgHttpParamsCount)&&
  Objects.equals(this.pctResponseErrors, objVserverL7MetricsObj.pctResponseErrors)&&
  Objects.equals(this.avgWafEvaluatedRequestHeaderPhase, objVserverL7MetricsObj.avgWafEvaluatedRequestHeaderPhase)&&
  Objects.equals(this.avgSslEcdsaNonPfs, objVserverL7MetricsObj.avgSslEcdsaNonPfs)&&
  Objects.equals(this.avgFrustratedResponses, objVserverL7MetricsObj.avgFrustratedResponses)&&
  Objects.equals(this.avgWaitingTime, objVserverL7MetricsObj.avgWaitingTime)&&
  Objects.equals(this.avgResp5Xx, objVserverL7MetricsObj.avgResp5Xx)&&
  Objects.equals(this.sumResp4Xx, objVserverL7MetricsObj.sumResp4Xx)&&
  Objects.equals(this.avgSslVerTls13, objVserverL7MetricsObj.avgSslVerTls13)&&
  Objects.equals(this.avgSslAuthRsa, objVserverL7MetricsObj.avgSslAuthRsa)&&
  Objects.equals(this.avgResp1Xx, objVserverL7MetricsObj.avgResp1Xx)&&
  Objects.equals(this.avgSslEcdsaPfs, objVserverL7MetricsObj.avgSslEcdsaPfs)&&
  Objects.equals(this.apdexr, objVserverL7MetricsObj.apdexr)&&
  Objects.equals(this.pctWafAttacks, objVserverL7MetricsObj.pctWafAttacks)&&
  Objects.equals(this.pctPostReqs, objVserverL7MetricsObj.pctPostReqs)&&
  Objects.equals(this.avgWafMatchedResponseHeaderPhase, objVserverL7MetricsObj.avgWafMatchedResponseHeaderPhase)&&
  Objects.equals(this.sumResp5Xx, objVserverL7MetricsObj.sumResp5Xx)&&
  Objects.equals(this.avgClientTxnLatency, objVserverL7MetricsObj.avgClientTxnLatency)&&
  Objects.equals(this.sumReqsFinishedSessions, objVserverL7MetricsObj.sumReqsFinishedSessions)&&
  Objects.equals(this.avgResp3Xx, objVserverL7MetricsObj.avgResp3Xx)&&
  Objects.equals(this.avgTotalHttp2Requests, objVserverL7MetricsObj.avgTotalHttp2Requests)&&
  Objects.equals(this.sumWafRejectedRequestHeaderPhase, objVserverL7MetricsObj.sumWafRejectedRequestHeaderPhase)&&
  Objects.equals(this.avgWafRejected, objVserverL7MetricsObj.avgWafRejected)&&
  Objects.equals(this.avgWafEvaluatedResponseBodyPhase, objVserverL7MetricsObj.avgWafEvaluatedResponseBodyPhase)&&
  Objects.equals(this.sumWafFlaggedResponseHeaderPhase, objVserverL7MetricsObj.sumWafFlaggedResponseHeaderPhase)&&
  Objects.equals(this.sumBrowserRenderingTime, objVserverL7MetricsObj.sumBrowserRenderingTime)&&
  Objects.equals(this.avgWafFlagged, objVserverL7MetricsObj.avgWafFlagged)&&
  Objects.equals(this.sumGetClientTxnLatencyBucket1, objVserverL7MetricsObj.sumGetClientTxnLatencyBucket1)&&
  Objects.equals(this.sumOtherReqs, objVserverL7MetricsObj.sumOtherReqs)&&
  Objects.equals(this.avgSslHandshakesNonPfs, objVserverL7MetricsObj.avgSslHandshakesNonPfs)&&
  Objects.equals(this.sumPostReqs, objVserverL7MetricsObj.sumPostReqs)&&
  Objects.equals(this.pctGetReqs, objVserverL7MetricsObj.pctGetReqs)&&
  Objects.equals(this.avgSslKxRsa, objVserverL7MetricsObj.avgSslKxRsa)&&
  Objects.equals(this.sumHttpHeadersCount, objVserverL7MetricsObj.sumHttpHeadersCount)&&
  Objects.equals(this.avgSslFailedConnections, objVserverL7MetricsObj.avgSslFailedConnections)&&
  Objects.equals(this.sumRumClientDataTransferTime, objVserverL7MetricsObj.sumRumClientDataTransferTime)&&
  Objects.equals(this.avgSslRsaNonPfs, objVserverL7MetricsObj.avgSslRsaNonPfs)&&
  Objects.equals(this.avgWafRejectedResponseBodyPhase, objVserverL7MetricsObj.avgWafRejectedResponseBodyPhase)&&
  Objects.equals(this.avgSslHandshakeProtocolErrors, objVserverL7MetricsObj.avgSslHandshakeProtocolErrors)&&
  Objects.equals(this.sumClientRtt, objVserverL7MetricsObj.sumClientRtt)&&
  Objects.equals(this.avgCompleteResponses, objVserverL7MetricsObj.avgCompleteResponses)&&
  Objects.equals(this.avgDomContentLoadTime, objVserverL7MetricsObj.avgDomContentLoadTime)&&
  Objects.equals(this.avgWafLatencyRequestHeaderPhase, objVserverL7MetricsObj.avgWafLatencyRequestHeaderPhase)&&
  Objects.equals(this.sumPostClientTxnLatency, objVserverL7MetricsObj.sumPostClientTxnLatency)&&
  Objects.equals(this.avgClientDataTransferTime, objVserverL7MetricsObj.avgClientDataTransferTime)&&
  Objects.equals(this.avgBlockingTime, objVserverL7MetricsObj.avgBlockingTime)&&
  Objects.equals(this.maxConcurrentSessions, objVserverL7MetricsObj.maxConcurrentSessions)&&
  Objects.equals(this.sumWafAttacks, objVserverL7MetricsObj.sumWafAttacks)&&
  Objects.equals(this.sumWafFlaggedRequestHeaderPhase, objVserverL7MetricsObj.sumWafFlaggedRequestHeaderPhase)&&
  Objects.equals(this.sumPageDownloadTime, objVserverL7MetricsObj.sumPageDownloadTime)&&
  Objects.equals(this.avgSslAuthDsa, objVserverL7MetricsObj.avgSslAuthDsa)&&
  Objects.equals(this.sumOtherClientTxnLatencyBucket2, objVserverL7MetricsObj.sumOtherClientTxnLatencyBucket2)&&
  Objects.equals(this.sumOtherClientTxnLatencyBucket1, objVserverL7MetricsObj.sumOtherClientTxnLatencyBucket1)&&
  Objects.equals(this.avgApplicationResponseTime, objVserverL7MetricsObj.avgApplicationResponseTime)&&
  Objects.equals(this.avgSslKxEcdh, objVserverL7MetricsObj.avgSslKxEcdh)&&
  Objects.equals(this.sumWafFlaggedResponseBodyPhase, objVserverL7MetricsObj.sumWafFlaggedResponseBodyPhase);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VserverL7MetricsObj {\n");
      sb.append("    apdexr: ").append(toIndentedString(apdexr)).append("\n");
        sb.append("    avgApplicationResponseTime: ").append(toIndentedString(avgApplicationResponseTime)).append("\n");
        sb.append("    avgBlockingTime: ").append(toIndentedString(avgBlockingTime)).append("\n");
        sb.append("    avgBrowserRenderingTime: ").append(toIndentedString(avgBrowserRenderingTime)).append("\n");
        sb.append("    avgCacheBytes: ").append(toIndentedString(avgCacheBytes)).append("\n");
        sb.append("    avgCacheHits: ").append(toIndentedString(avgCacheHits)).append("\n");
        sb.append("    avgCacheableBytes: ").append(toIndentedString(avgCacheableBytes)).append("\n");
        sb.append("    avgCacheableHits: ").append(toIndentedString(avgCacheableHits)).append("\n");
        sb.append("    avgClientDataTransferTime: ").append(toIndentedString(avgClientDataTransferTime)).append("\n");
        sb.append("    avgClientRtt: ").append(toIndentedString(avgClientRtt)).append("\n");
        sb.append("    avgClientTxnLatency: ").append(toIndentedString(avgClientTxnLatency)).append("\n");
        sb.append("    avgCompleteResponses: ").append(toIndentedString(avgCompleteResponses)).append("\n");
        sb.append("    avgConnectionTime: ").append(toIndentedString(avgConnectionTime)).append("\n");
        sb.append("    avgDnsLookupTime: ").append(toIndentedString(avgDnsLookupTime)).append("\n");
        sb.append("    avgDomContentLoadTime: ").append(toIndentedString(avgDomContentLoadTime)).append("\n");
        sb.append("    avgErrorResponses: ").append(toIndentedString(avgErrorResponses)).append("\n");
        sb.append("    avgErrorsExcluded: ").append(toIndentedString(avgErrorsExcluded)).append("\n");
        sb.append("    avgFrustratedResponses: ").append(toIndentedString(avgFrustratedResponses)).append("\n");
        sb.append("    avgHttpHeadersBytes: ").append(toIndentedString(avgHttpHeadersBytes)).append("\n");
        sb.append("    avgHttpHeadersCount: ").append(toIndentedString(avgHttpHeadersCount)).append("\n");
        sb.append("    avgHttpParamsCount: ").append(toIndentedString(avgHttpParamsCount)).append("\n");
        sb.append("    avgPageDownloadTime: ").append(toIndentedString(avgPageDownloadTime)).append("\n");
        sb.append("    avgPageLoadTime: ").append(toIndentedString(avgPageLoadTime)).append("\n");
        sb.append("    avgParamsPerReq: ").append(toIndentedString(avgParamsPerReq)).append("\n");
        sb.append("    avgPostBytes: ").append(toIndentedString(avgPostBytes)).append("\n");
        sb.append("    avgPostCompressionBytes: ").append(toIndentedString(avgPostCompressionBytes)).append("\n");
        sb.append("    avgPreCompressionBytes: ").append(toIndentedString(avgPreCompressionBytes)).append("\n");
        sb.append("    avgRedirectionTime: ").append(toIndentedString(avgRedirectionTime)).append("\n");
        sb.append("    avgReqsPerSession: ").append(toIndentedString(avgReqsPerSession)).append("\n");
        sb.append("    avgResp1Xx: ").append(toIndentedString(avgResp1Xx)).append("\n");
        sb.append("    avgResp2Xx: ").append(toIndentedString(avgResp2Xx)).append("\n");
        sb.append("    avgResp3Xx: ").append(toIndentedString(avgResp3Xx)).append("\n");
        sb.append("    avgResp4Xx: ").append(toIndentedString(avgResp4Xx)).append("\n");
        sb.append("    avgResp4XxAviErrors: ").append(toIndentedString(avgResp4XxAviErrors)).append("\n");
        sb.append("    avgResp5Xx: ").append(toIndentedString(avgResp5Xx)).append("\n");
        sb.append("    avgResp5XxAviErrors: ").append(toIndentedString(avgResp5XxAviErrors)).append("\n");
        sb.append("    avgRumClientDataTransferTime: ").append(toIndentedString(avgRumClientDataTransferTime)).append("\n");
        sb.append("    avgSatisfactoryResponses: ").append(toIndentedString(avgSatisfactoryResponses)).append("\n");
        sb.append("    avgServerRtt: ").append(toIndentedString(avgServerRtt)).append("\n");
        sb.append("    avgServiceTime: ").append(toIndentedString(avgServiceTime)).append("\n");
        sb.append("    avgSslAuthDsa: ").append(toIndentedString(avgSslAuthDsa)).append("\n");
        sb.append("    avgSslAuthEcdsa: ").append(toIndentedString(avgSslAuthEcdsa)).append("\n");
        sb.append("    avgSslAuthRsa: ").append(toIndentedString(avgSslAuthRsa)).append("\n");
        sb.append("    avgSslConnections: ").append(toIndentedString(avgSslConnections)).append("\n");
        sb.append("    avgSslEcdsaNonPfs: ").append(toIndentedString(avgSslEcdsaNonPfs)).append("\n");
        sb.append("    avgSslEcdsaPfs: ").append(toIndentedString(avgSslEcdsaPfs)).append("\n");
        sb.append("    avgSslErrors: ").append(toIndentedString(avgSslErrors)).append("\n");
        sb.append("    avgSslFailedConnections: ").append(toIndentedString(avgSslFailedConnections)).append("\n");
        sb.append("    avgSslHandshakeNetworkErrors: ").append(toIndentedString(avgSslHandshakeNetworkErrors)).append("\n");
        sb.append("    avgSslHandshakeProtocolErrors: ").append(toIndentedString(avgSslHandshakeProtocolErrors)).append("\n");
        sb.append("    avgSslHandshakesNew: ").append(toIndentedString(avgSslHandshakesNew)).append("\n");
        sb.append("    avgSslHandshakesNonPfs: ").append(toIndentedString(avgSslHandshakesNonPfs)).append("\n");
        sb.append("    avgSslHandshakesPfs: ").append(toIndentedString(avgSslHandshakesPfs)).append("\n");
        sb.append("    avgSslHandshakesReused: ").append(toIndentedString(avgSslHandshakesReused)).append("\n");
        sb.append("    avgSslHandshakesTimedout: ").append(toIndentedString(avgSslHandshakesTimedout)).append("\n");
        sb.append("    avgSslKxDh: ").append(toIndentedString(avgSslKxDh)).append("\n");
        sb.append("    avgSslKxEcdh: ").append(toIndentedString(avgSslKxEcdh)).append("\n");
        sb.append("    avgSslKxRsa: ").append(toIndentedString(avgSslKxRsa)).append("\n");
        sb.append("    avgSslRsaNonPfs: ").append(toIndentedString(avgSslRsaNonPfs)).append("\n");
        sb.append("    avgSslRsaPfs: ").append(toIndentedString(avgSslRsaPfs)).append("\n");
        sb.append("    avgSslVerSsl30: ").append(toIndentedString(avgSslVerSsl30)).append("\n");
        sb.append("    avgSslVerTls10: ").append(toIndentedString(avgSslVerTls10)).append("\n");
        sb.append("    avgSslVerTls11: ").append(toIndentedString(avgSslVerTls11)).append("\n");
        sb.append("    avgSslVerTls12: ").append(toIndentedString(avgSslVerTls12)).append("\n");
        sb.append("    avgSslVerTls13: ").append(toIndentedString(avgSslVerTls13)).append("\n");
        sb.append("    avgToleratedResponses: ").append(toIndentedString(avgToleratedResponses)).append("\n");
        sb.append("    avgTotalHttp2Requests: ").append(toIndentedString(avgTotalHttp2Requests)).append("\n");
        sb.append("    avgTotalRequests: ").append(toIndentedString(avgTotalRequests)).append("\n");
        sb.append("    avgUriLength: ").append(toIndentedString(avgUriLength)).append("\n");
        sb.append("    avgWafAttacks: ").append(toIndentedString(avgWafAttacks)).append("\n");
        sb.append("    avgWafDisabled: ").append(toIndentedString(avgWafDisabled)).append("\n");
        sb.append("    avgWafEvaluated: ").append(toIndentedString(avgWafEvaluated)).append("\n");
        sb.append("    avgWafEvaluatedRequestBodyPhase: ").append(toIndentedString(avgWafEvaluatedRequestBodyPhase)).append("\n");
        sb.append("    avgWafEvaluatedRequestHeaderPhase: ").append(toIndentedString(avgWafEvaluatedRequestHeaderPhase)).append("\n");
        sb.append("    avgWafEvaluatedResponseBodyPhase: ").append(toIndentedString(avgWafEvaluatedResponseBodyPhase)).append("\n");
        sb.append("    avgWafEvaluatedResponseHeaderPhase: ").append(toIndentedString(avgWafEvaluatedResponseHeaderPhase)).append("\n");
        sb.append("    avgWafFlagged: ").append(toIndentedString(avgWafFlagged)).append("\n");
        sb.append("    avgWafFlaggedRequestBodyPhase: ").append(toIndentedString(avgWafFlaggedRequestBodyPhase)).append("\n");
        sb.append("    avgWafFlaggedRequestHeaderPhase: ").append(toIndentedString(avgWafFlaggedRequestHeaderPhase)).append("\n");
        sb.append("    avgWafFlaggedResponseBodyPhase: ").append(toIndentedString(avgWafFlaggedResponseBodyPhase)).append("\n");
        sb.append("    avgWafFlaggedResponseHeaderPhase: ").append(toIndentedString(avgWafFlaggedResponseHeaderPhase)).append("\n");
        sb.append("    avgWafLatencyRequestBodyPhase: ").append(toIndentedString(avgWafLatencyRequestBodyPhase)).append("\n");
        sb.append("    avgWafLatencyRequestHeaderPhase: ").append(toIndentedString(avgWafLatencyRequestHeaderPhase)).append("\n");
        sb.append("    avgWafLatencyResponseBodyPhase: ").append(toIndentedString(avgWafLatencyResponseBodyPhase)).append("\n");
        sb.append("    avgWafLatencyResponseHeaderPhase: ").append(toIndentedString(avgWafLatencyResponseHeaderPhase)).append("\n");
        sb.append("    avgWafMatched: ").append(toIndentedString(avgWafMatched)).append("\n");
        sb.append("    avgWafMatchedRequestBodyPhase: ").append(toIndentedString(avgWafMatchedRequestBodyPhase)).append("\n");
        sb.append("    avgWafMatchedRequestHeaderPhase: ").append(toIndentedString(avgWafMatchedRequestHeaderPhase)).append("\n");
        sb.append("    avgWafMatchedResponseBodyPhase: ").append(toIndentedString(avgWafMatchedResponseBodyPhase)).append("\n");
        sb.append("    avgWafMatchedResponseHeaderPhase: ").append(toIndentedString(avgWafMatchedResponseHeaderPhase)).append("\n");
        sb.append("    avgWafRejected: ").append(toIndentedString(avgWafRejected)).append("\n");
        sb.append("    avgWafRejectedRequestBodyPhase: ").append(toIndentedString(avgWafRejectedRequestBodyPhase)).append("\n");
        sb.append("    avgWafRejectedRequestHeaderPhase: ").append(toIndentedString(avgWafRejectedRequestHeaderPhase)).append("\n");
        sb.append("    avgWafRejectedResponseBodyPhase: ").append(toIndentedString(avgWafRejectedResponseBodyPhase)).append("\n");
        sb.append("    avgWafRejectedResponseHeaderPhase: ").append(toIndentedString(avgWafRejectedResponseHeaderPhase)).append("\n");
        sb.append("    avgWaitingTime: ").append(toIndentedString(avgWaitingTime)).append("\n");
        sb.append("    maxConcurrentSessions: ").append(toIndentedString(maxConcurrentSessions)).append("\n");
        sb.append("    maxSslOpenSessions: ").append(toIndentedString(maxSslOpenSessions)).append("\n");
        sb.append("    nodeObjId: ").append(toIndentedString(nodeObjId)).append("\n");
        sb.append("    pctCacheHits: ").append(toIndentedString(pctCacheHits)).append("\n");
        sb.append("    pctCacheableHits: ").append(toIndentedString(pctCacheableHits)).append("\n");
        sb.append("    pctGetReqs: ").append(toIndentedString(pctGetReqs)).append("\n");
        sb.append("    pctPostReqs: ").append(toIndentedString(pctPostReqs)).append("\n");
        sb.append("    pctResponseErrors: ").append(toIndentedString(pctResponseErrors)).append("\n");
        sb.append("    pctSslFailedConnections: ").append(toIndentedString(pctSslFailedConnections)).append("\n");
        sb.append("    pctWafAttacks: ").append(toIndentedString(pctWafAttacks)).append("\n");
        sb.append("    pctWafDisabled: ").append(toIndentedString(pctWafDisabled)).append("\n");
        sb.append("    pctWafEvaluated: ").append(toIndentedString(pctWafEvaluated)).append("\n");
        sb.append("    pctWafFlagged: ").append(toIndentedString(pctWafFlagged)).append("\n");
        sb.append("    pctWafMatched: ").append(toIndentedString(pctWafMatched)).append("\n");
        sb.append("    pctWafRejected: ").append(toIndentedString(pctWafRejected)).append("\n");
        sb.append("    rumApdexr: ").append(toIndentedString(rumApdexr)).append("\n");
        sb.append("    sslProtocolStrength: ").append(toIndentedString(sslProtocolStrength)).append("\n");
        sb.append("    sumApplicationResponseTime: ").append(toIndentedString(sumApplicationResponseTime)).append("\n");
        sb.append("    sumBlockingTime: ").append(toIndentedString(sumBlockingTime)).append("\n");
        sb.append("    sumBrowserRenderingTime: ").append(toIndentedString(sumBrowserRenderingTime)).append("\n");
        sb.append("    sumClientDataTransferTime: ").append(toIndentedString(sumClientDataTransferTime)).append("\n");
        sb.append("    sumClientRtt: ").append(toIndentedString(sumClientRtt)).append("\n");
        sb.append("    sumConnectionTime: ").append(toIndentedString(sumConnectionTime)).append("\n");
        sb.append("    sumDnsLookupTime: ").append(toIndentedString(sumDnsLookupTime)).append("\n");
        sb.append("    sumDomContentLoadTime: ").append(toIndentedString(sumDomContentLoadTime)).append("\n");
        sb.append("    sumErrors: ").append(toIndentedString(sumErrors)).append("\n");
        sb.append("    sumFinishedSessions: ").append(toIndentedString(sumFinishedSessions)).append("\n");
        sb.append("    sumGetClientTxnLatency: ").append(toIndentedString(sumGetClientTxnLatency)).append("\n");
        sb.append("    sumGetClientTxnLatencyBucket1: ").append(toIndentedString(sumGetClientTxnLatencyBucket1)).append("\n");
        sb.append("    sumGetClientTxnLatencyBucket2: ").append(toIndentedString(sumGetClientTxnLatencyBucket2)).append("\n");
        sb.append("    sumGetReqs: ").append(toIndentedString(sumGetReqs)).append("\n");
        sb.append("    sumHttpHeadersBytes: ").append(toIndentedString(sumHttpHeadersBytes)).append("\n");
        sb.append("    sumHttpHeadersCount: ").append(toIndentedString(sumHttpHeadersCount)).append("\n");
        sb.append("    sumHttpParamsCount: ").append(toIndentedString(sumHttpParamsCount)).append("\n");
        sb.append("    sumNumPageLoadTimeBucket1: ").append(toIndentedString(sumNumPageLoadTimeBucket1)).append("\n");
        sb.append("    sumNumPageLoadTimeBucket2: ").append(toIndentedString(sumNumPageLoadTimeBucket2)).append("\n");
        sb.append("    sumNumRumSamples: ").append(toIndentedString(sumNumRumSamples)).append("\n");
        sb.append("    sumOtherClientTxnLatency: ").append(toIndentedString(sumOtherClientTxnLatency)).append("\n");
        sb.append("    sumOtherClientTxnLatencyBucket1: ").append(toIndentedString(sumOtherClientTxnLatencyBucket1)).append("\n");
        sb.append("    sumOtherClientTxnLatencyBucket2: ").append(toIndentedString(sumOtherClientTxnLatencyBucket2)).append("\n");
        sb.append("    sumOtherReqs: ").append(toIndentedString(sumOtherReqs)).append("\n");
        sb.append("    sumPageDownloadTime: ").append(toIndentedString(sumPageDownloadTime)).append("\n");
        sb.append("    sumPageLoadTime: ").append(toIndentedString(sumPageLoadTime)).append("\n");
        sb.append("    sumPostBytes: ").append(toIndentedString(sumPostBytes)).append("\n");
        sb.append("    sumPostClientTxnLatency: ").append(toIndentedString(sumPostClientTxnLatency)).append("\n");
        sb.append("    sumPostClientTxnLatencyBucket1: ").append(toIndentedString(sumPostClientTxnLatencyBucket1)).append("\n");
        sb.append("    sumPostClientTxnLatencyBucket2: ").append(toIndentedString(sumPostClientTxnLatencyBucket2)).append("\n");
        sb.append("    sumPostReqs: ").append(toIndentedString(sumPostReqs)).append("\n");
        sb.append("    sumRedirectionTime: ").append(toIndentedString(sumRedirectionTime)).append("\n");
        sb.append("    sumReqsFinishedSessions: ").append(toIndentedString(sumReqsFinishedSessions)).append("\n");
        sb.append("    sumReqsWithParams: ").append(toIndentedString(sumReqsWithParams)).append("\n");
        sb.append("    sumResp1Xx: ").append(toIndentedString(sumResp1Xx)).append("\n");
        sb.append("    sumResp2Xx: ").append(toIndentedString(sumResp2Xx)).append("\n");
        sb.append("    sumResp3Xx: ").append(toIndentedString(sumResp3Xx)).append("\n");
        sb.append("    sumResp4Xx: ").append(toIndentedString(sumResp4Xx)).append("\n");
        sb.append("    sumResp5Xx: ").append(toIndentedString(sumResp5Xx)).append("\n");
        sb.append("    sumRumClientDataTransferTime: ").append(toIndentedString(sumRumClientDataTransferTime)).append("\n");
        sb.append("    sumServerRtt: ").append(toIndentedString(sumServerRtt)).append("\n");
        sb.append("    sumServiceTime: ").append(toIndentedString(sumServiceTime)).append("\n");
        sb.append("    sumTotalResponses: ").append(toIndentedString(sumTotalResponses)).append("\n");
        sb.append("    sumUriLength: ").append(toIndentedString(sumUriLength)).append("\n");
        sb.append("    sumWafAttacks: ").append(toIndentedString(sumWafAttacks)).append("\n");
        sb.append("    sumWafDisabled: ").append(toIndentedString(sumWafDisabled)).append("\n");
        sb.append("    sumWafEvaluatedRequestBodyPhase: ").append(toIndentedString(sumWafEvaluatedRequestBodyPhase)).append("\n");
        sb.append("    sumWafEvaluatedRequestHeaderPhase: ").append(toIndentedString(sumWafEvaluatedRequestHeaderPhase)).append("\n");
        sb.append("    sumWafEvaluatedResponseBodyPhase: ").append(toIndentedString(sumWafEvaluatedResponseBodyPhase)).append("\n");
        sb.append("    sumWafEvaluatedResponseHeaderPhase: ").append(toIndentedString(sumWafEvaluatedResponseHeaderPhase)).append("\n");
        sb.append("    sumWafFlagged: ").append(toIndentedString(sumWafFlagged)).append("\n");
        sb.append("    sumWafFlaggedRequestBodyPhase: ").append(toIndentedString(sumWafFlaggedRequestBodyPhase)).append("\n");
        sb.append("    sumWafFlaggedRequestHeaderPhase: ").append(toIndentedString(sumWafFlaggedRequestHeaderPhase)).append("\n");
        sb.append("    sumWafFlaggedResponseBodyPhase: ").append(toIndentedString(sumWafFlaggedResponseBodyPhase)).append("\n");
        sb.append("    sumWafFlaggedResponseHeaderPhase: ").append(toIndentedString(sumWafFlaggedResponseHeaderPhase)).append("\n");
        sb.append("    sumWafLatencyRequestBodyPhase: ").append(toIndentedString(sumWafLatencyRequestBodyPhase)).append("\n");
        sb.append("    sumWafLatencyRequestHeaderPhase: ").append(toIndentedString(sumWafLatencyRequestHeaderPhase)).append("\n");
        sb.append("    sumWafLatencyResponseBodyPhase: ").append(toIndentedString(sumWafLatencyResponseBodyPhase)).append("\n");
        sb.append("    sumWafLatencyResponseHeaderPhase: ").append(toIndentedString(sumWafLatencyResponseHeaderPhase)).append("\n");
        sb.append("    sumWafMatchedRequestBodyPhase: ").append(toIndentedString(sumWafMatchedRequestBodyPhase)).append("\n");
        sb.append("    sumWafMatchedRequestHeaderPhase: ").append(toIndentedString(sumWafMatchedRequestHeaderPhase)).append("\n");
        sb.append("    sumWafMatchedResponseBodyPhase: ").append(toIndentedString(sumWafMatchedResponseBodyPhase)).append("\n");
        sb.append("    sumWafMatchedResponseHeaderPhase: ").append(toIndentedString(sumWafMatchedResponseHeaderPhase)).append("\n");
        sb.append("    sumWafRejected: ").append(toIndentedString(sumWafRejected)).append("\n");
        sb.append("    sumWafRejectedRequestBodyPhase: ").append(toIndentedString(sumWafRejectedRequestBodyPhase)).append("\n");
        sb.append("    sumWafRejectedRequestHeaderPhase: ").append(toIndentedString(sumWafRejectedRequestHeaderPhase)).append("\n");
        sb.append("    sumWafRejectedResponseBodyPhase: ").append(toIndentedString(sumWafRejectedResponseBodyPhase)).append("\n");
        sb.append("    sumWafRejectedResponseHeaderPhase: ").append(toIndentedString(sumWafRejectedResponseHeaderPhase)).append("\n");
        sb.append("    sumWaitingTime: ").append(toIndentedString(sumWaitingTime)).append("\n");
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

