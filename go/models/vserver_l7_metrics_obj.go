package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// VserverL7MetricsObj vserver l7 metrics obj
// swagger:model VserverL7MetricsObj
type VserverL7MetricsObj struct {

	// Client Apdex measures quality of server response based on latency.
	Apdexr float64 `json:"apdexr,omitempty"`

	// Average server/application response latency.
	AvgApplicationResponseTime float64 `json:"avg_application_response_time,omitempty"`

	// Average time client was blocked as reported by client.
	AvgBlockingTime float64 `json:"avg_blocking_time,omitempty"`

	// Average browser rendering latency.
	AvgBrowserRenderingTime float64 `json:"avg_browser_rendering_time,omitempty"`

	// Average cache bytes.
	AvgCacheBytes float64 `json:"avg_cache_bytes,omitempty"`

	// Average cache hit of requests.
	AvgCacheHits float64 `json:"avg_cache_hits,omitempty"`

	// Average cacheable bytes.
	AvgCacheableBytes float64 `json:"avg_cacheable_bytes,omitempty"`

	// Average cacheable hit of requests.
	AvgCacheableHits float64 `json:"avg_cacheable_hits,omitempty"`

	// Average client data transfer time that represents latency of sending response to the client excluding the RTT time . Higher client data transfer time signifies lower bandwidth  between client and Avi Service Engine.
	AvgClientDataTransferTime float64 `json:"avg_client_data_transfer_time,omitempty"`

	// Average client Round Trip Time.
	AvgClientRtt float64 `json:"avg_client_rtt,omitempty"`

	// Average client transaction latency computed by adding response latencies across all HTTP requests.
	AvgClientTxnLatency float64 `json:"avg_client_txn_latency,omitempty"`

	// Rate of HTTP responses sent per second.
	AvgCompleteResponses float64 `json:"avg_complete_responses,omitempty"`

	// Average client connection latency reported by client.
	AvgConnectionTime float64 `json:"avg_connection_time,omitempty"`

	// Average domain lookup latency reported by client.
	AvgDNSLookupTime float64 `json:"avg_dns_lookup_time,omitempty"`

	// Average Dom content Load Time reported by clients.
	AvgDomContentLoadTime float64 `json:"avg_dom_content_load_time,omitempty"`

	// Rate of HTTP error responses sent per second. It does not include errors excluded in analytics profile.
	AvgErrorResponses float64 `json:"avg_error_responses,omitempty"`

	// Rate of HTTP responses excluded as errors based on analytics profile.
	AvgErrorsExcluded float64 `json:"avg_errors_excluded,omitempty"`

	// Avg number of HTTP requests that completed within frustrated latency.
	AvgFrustratedResponses float64 `json:"avg_frustrated_responses,omitempty"`

	// Average Page Load time reported by clients.
	AvgPageDownloadTime float64 `json:"avg_page_download_time,omitempty"`

	// Average Page Load Time reported by client.
	AvgPageLoadTime float64 `json:"avg_page_load_time,omitempty"`

	// Average post compression bytes.
	AvgPostCompressionBytes float64 `json:"avg_post_compression_bytes,omitempty"`

	// Average pre compression bytes.
	AvgPreCompressionBytes float64 `json:"avg_pre_compression_bytes,omitempty"`

	// Average redirect latency reported by client.
	AvgRedirectionTime float64 `json:"avg_redirection_time,omitempty"`

	// Average requests per session measured for closed sessions.
	AvgReqsPerSession float64 `json:"avg_reqs_per_session,omitempty"`

	// Rate of 1xx HTTP responses sent per second.
	AvgResp1xx float64 `json:"avg_resp_1xx,omitempty"`

	// Rate of 2xx HTTP responses sent per second.
	AvgResp2xx float64 `json:"avg_resp_2xx,omitempty"`

	// Rate of 3xx HTTP responses sent per second.
	AvgResp3xx float64 `json:"avg_resp_3xx,omitempty"`

	// Rate of 4xx HTTP responses sent per second.
	AvgResp4xx float64 `json:"avg_resp_4xx,omitempty"`

	// Rate of 4xx HTTP responses as errors sent by avi. It does not include any error codes excluded in the analytics profile and pool server errors.
	AvgResp4xxAviErrors float64 `json:"avg_resp_4xx_avi_errors,omitempty"`

	// Rate of 5xx HTTP responses sent per second.
	AvgResp5xx float64 `json:"avg_resp_5xx,omitempty"`

	// Rate of 5xx HTTP responses as errors sent by avi. It does not include any error codes excluded in the analytics profile and pool server errors.
	AvgResp5xxAviErrors float64 `json:"avg_resp_5xx_avi_errors,omitempty"`

	// Total client data transfer time by client.
	AvgRumClientDataTransferTime float64 `json:"avg_rum_client_data_transfer_time,omitempty"`

	// Avg number of HTTP requests that completed within satisfactory latency.
	AvgSatisfactoryResponses float64 `json:"avg_satisfactory_responses,omitempty"`

	// Average server Round Trip Time.
	AvgServerRtt float64 `json:"avg_server_rtt,omitempty"`

	// Average latency from receipt of request to start of response.
	AvgServiceTime float64 `json:"avg_service_time,omitempty"`

	// Average SSL Sessions using DSA certificate.
	AvgSslAuthDsa float64 `json:"avg_ssl_auth_dsa,omitempty"`

	// Average SSL Sessions using Elliptic Curve DSA (ECDSA) certificates.
	AvgSslAuthEcdsa float64 `json:"avg_ssl_auth_ecdsa,omitempty"`

	// Average SSL Sessions using RSA certificate.
	AvgSslAuthRsa float64 `json:"avg_ssl_auth_rsa,omitempty"`

	// Average SSL Sessions.
	AvgSslConnections float64 `json:"avg_ssl_connections,omitempty"`

	// Average SSL Exchanges using EC Cerificates without PFS.
	AvgSslEcdsaNonPfs float64 `json:"avg_ssl_ecdsa_non_pfs,omitempty"`

	// Average SSL Exchanges using EC Cerificates and PFS.
	AvgSslEcdsaPfs float64 `json:"avg_ssl_ecdsa_pfs,omitempty"`

	// Average SSL errors due to clients, protocol errors,network errors and handshake timeouts.
	AvgSslErrors float64 `json:"avg_ssl_errors,omitempty"`

	// Average SSL connections failed due to protocol , network or timeout reasons.
	AvgSslFailedConnections float64 `json:"avg_ssl_failed_connections,omitempty"`

	// Average SSL handshakes failed due to network errors.
	AvgSslHandshakeNetworkErrors float64 `json:"avg_ssl_handshake_network_errors,omitempty"`

	// Average SSL handshake failed due to clients or protocol errors.
	AvgSslHandshakeProtocolErrors float64 `json:"avg_ssl_handshake_protocol_errors,omitempty"`

	// Average new successful SSL sessions.
	AvgSslHandshakesNew float64 `json:"avg_ssl_handshakes_new,omitempty"`

	// Average SSL Exchanges using Non-PFS.
	AvgSslHandshakesNonPfs float64 `json:"avg_ssl_handshakes_non_pfs,omitempty"`

	// Average SSL Exchanges using PFS.
	AvgSslHandshakesPfs float64 `json:"avg_ssl_handshakes_pfs,omitempty"`

	// Average new successful resumed SSL sessions.
	AvgSslHandshakesReused float64 `json:"avg_ssl_handshakes_reused,omitempty"`

	// Average SSL handshakes timed out.
	AvgSslHandshakesTimedout float64 `json:"avg_ssl_handshakes_timedout,omitempty"`

	// Average SSL Exchanges using Diffie-Hellman.
	AvgSslKxDh float64 `json:"avg_ssl_kx_dh,omitempty"`

	// Average SSL Exchanges using RSA.
	AvgSslKxEcdh float64 `json:"avg_ssl_kx_ecdh,omitempty"`

	// Average SSL Exchanges using RSA.
	AvgSslKxRsa float64 `json:"avg_ssl_kx_rsa,omitempty"`

	// Average SSL Exchanges using RSA Cerificates without PFS.
	AvgSslRsaNonPfs float64 `json:"avg_ssl_rsa_non_pfs,omitempty"`

	// Average SSL Exchanges using RSA Cerificates and PFS.
	AvgSslRsaPfs float64 `json:"avg_ssl_rsa_pfs,omitempty"`

	// Average SSL Sessions with version 3.0.
	AvgSslVerSsl30 float64 `json:"avg_ssl_ver_ssl30,omitempty"`

	// Average SSL Sessions with TLS version 1.0.
	AvgSslVerTLS10 float64 `json:"avg_ssl_ver_tls10,omitempty"`

	// Average SSL Sessions with TLS version 1.1.
	AvgSslVerTLS11 float64 `json:"avg_ssl_ver_tls11,omitempty"`

	// Average SSL Sessions with TLS version 1.2.
	AvgSslVerTLS12 float64 `json:"avg_ssl_ver_tls12,omitempty"`

	// Avg number of HTTP requests that completed within tolerated latency.
	AvgToleratedResponses float64 `json:"avg_tolerated_responses,omitempty"`

	// Average rate of client HTTP requests received by the virtual service per second.
	AvgTotalRequests float64 `json:"avg_total_requests,omitempty"`

	// Average Waiting Time reported by client.
	AvgWaitingTime float64 `json:"avg_waiting_time,omitempty"`

	// Maximum number of concurrent HTTP sessions.
	MaxConcurrentSessions float64 `json:"max_concurrent_sessions,omitempty"`

	// Maximum number of open SSL sessions.
	MaxSslOpenSessions float64 `json:"max_ssl_open_sessions,omitempty"`

	// node_obj_id of VserverL7MetricsObj.
	// Required: true
	NodeObjID string `json:"node_obj_id"`

	// Percentage cache hit of requests.
	PctCacheHits float64 `json:"pct_cache_hits,omitempty"`

	// Percentage cacheable hit of requests.
	PctCacheableHits float64 `json:"pct_cacheable_hits,omitempty"`

	// Percent of 4xx and 5xx responses.
	PctResponseErrors float64 `json:"pct_response_errors,omitempty"`

	// Percent of SSL connections failured due to protocol , network or timeout reasons.
	PctSslFailedConnections float64 `json:"pct_ssl_failed_connections,omitempty"`

	// Apdex measures quality of server response based on Real User Metric.
	RumApdexr float64 `json:"rum_apdexr,omitempty"`

	// Protocol strength of SSL ciphers used.
	SslProtocolStrength float64 `json:"ssl_protocol_strength,omitempty"`

	// Total time taken by server to respond to requesti.
	SumApplicationResponseTime float64 `json:"sum_application_response_time,omitempty"`

	// Total time client was blocked.
	SumBlockingTime float64 `json:"sum_blocking_time,omitempty"`

	// Total browser rendering latency reported by client.
	SumBrowserRenderingTime float64 `json:"sum_browser_rendering_time,omitempty"`

	// Average client data transfer time computed by adding response latencies across all HTTP requests.
	SumClientDataTransferTime float64 `json:"sum_client_data_transfer_time,omitempty"`

	// Sum of all client Round Trip Times for all samples.
	SumClientRtt float64 `json:"sum_client_rtt,omitempty"`

	// Total client connection latency reported by client.
	SumConnectionTime float64 `json:"sum_connection_time,omitempty"`

	// Total domain lookup latency reported by client.
	SumDNSLookupTime float64 `json:"sum_dns_lookup_time,omitempty"`

	// Total dom content latency reported by client.
	SumDomContentLoadTime float64 `json:"sum_dom_content_load_time,omitempty"`

	// Count of HTTP 400 and 500 errors for a virtual service in a time interval.
	SumErrors float64 `json:"sum_errors,omitempty"`

	// Number of server sessions closed in this interval.
	SumFinishedSessions float64 `json:"sum_finished_sessions,omitempty"`

	// Total latency from responses to all the GET requests.
	SumGetClientTxnLatency float64 `json:"sum_get_client_txn_latency,omitempty"`

	// Total number of HTTP GET requests that were responded satisfactorily within latency threshold.
	SumGetClientTxnLatencyBucket1 float64 `json:"sum_get_client_txn_latency_bucket1,omitempty"`

	// Total number of HTTP GET requests that were responded beyond latency threshold but within tolerated limits.
	SumGetClientTxnLatencyBucket2 float64 `json:"sum_get_client_txn_latency_bucket2,omitempty"`

	// Total number of HTTP GET requests.
	SumGetReqs float64 `json:"sum_get_reqs,omitempty"`

	// Total samples that had satisfactory page load time.
	SumNumPageLoadTimeBucket1 float64 `json:"sum_num_page_load_time_bucket1,omitempty"`

	// Total samples that had tolerated page load time.
	SumNumPageLoadTimeBucket2 float64 `json:"sum_num_page_load_time_bucket2,omitempty"`

	// Total samples used for rum metrics.
	SumNumRumSamples float64 `json:"sum_num_rum_samples,omitempty"`

	// Total latency from responses to all the requests other than GET or POST.
	SumOtherClientTxnLatency float64 `json:"sum_other_client_txn_latency,omitempty"`

	// Total number of HTTP requests other than GET or POST that were responded satisfactorily within latency threshold.
	SumOtherClientTxnLatencyBucket1 float64 `json:"sum_other_client_txn_latency_bucket1,omitempty"`

	// Total number of HTTP requests other than GET or POST that were responded beyond latency threshold but within tolerated limits.
	SumOtherClientTxnLatencyBucket2 float64 `json:"sum_other_client_txn_latency_bucket2,omitempty"`

	// Total number of HTTP requests that are not GET or POST requests.
	SumOtherReqs float64 `json:"sum_other_reqs,omitempty"`

	// Total time to transfer response to client.
	SumPageDownloadTime float64 `json:"sum_page_download_time,omitempty"`

	// Total Page Load Time reported by client.
	SumPageLoadTime float64 `json:"sum_page_load_time,omitempty"`

	// Total latency from responses to all the POST requests.
	SumPostClientTxnLatency float64 `json:"sum_post_client_txn_latency,omitempty"`

	// Total number of HTTP POST requests that were responded satisfactorily within latency threshold.
	SumPostClientTxnLatencyBucket1 float64 `json:"sum_post_client_txn_latency_bucket1,omitempty"`

	// Total number of HTTP POST requests that were responded beyond latency threshold but within tolerated limits.
	SumPostClientTxnLatencyBucket2 float64 `json:"sum_post_client_txn_latency_bucket2,omitempty"`

	// Total number of HTTP POST requests.
	SumPostReqs float64 `json:"sum_post_reqs,omitempty"`

	// Total redirect latency reported by client.
	SumRedirectionTime float64 `json:"sum_redirection_time,omitempty"`

	// Total number of requests served across server sessions closed in the interval.
	SumReqsFinishedSessions float64 `json:"sum_reqs_finished_sessions,omitempty"`

	// Total number of HTTP 1XX responses.
	SumResp1xx float64 `json:"sum_resp_1xx,omitempty"`

	// Total number of HTTP 2XX responses.
	SumResp2xx float64 `json:"sum_resp_2xx,omitempty"`

	// Total number of HTTP 3XX responses.
	SumResp3xx float64 `json:"sum_resp_3xx,omitempty"`

	// Total number of HTTP 4XX error responses.
	SumResp4xx float64 `json:"sum_resp_4xx,omitempty"`

	// Total number of HTTP 5XX error responses.
	SumResp5xx float64 `json:"sum_resp_5xx,omitempty"`

	// Total client data transfer time by client.
	SumRumClientDataTransferTime float64 `json:"sum_rum_client_data_transfer_time,omitempty"`

	// Sum of all server Round Trip Times for all samples.
	SumServerRtt float64 `json:"sum_server_rtt,omitempty"`

	// Total time from receipt of request to start of response.
	SumServiceTime float64 `json:"sum_service_time,omitempty"`

	// Total number of HTTP responses sent.
	SumTotalResponses float64 `json:"sum_total_responses,omitempty"`

	// Total waiting reported by client.
	SumWaitingTime float64 `json:"sum_waiting_time,omitempty"`
}
