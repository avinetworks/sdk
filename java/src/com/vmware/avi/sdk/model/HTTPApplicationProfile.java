package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The HTTPApplicationProfile is a POJO class extends AviRestResource that used for creating
 * HTTPApplicationProfile.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HTTPApplicationProfile  {
    @JsonProperty("allow_dots_in_header_name")
    private Boolean allowDotsInHeaderName = false;

    @JsonProperty("cache_config")
    private HttpCacheConfig cacheConfig = null;

    @JsonProperty("client_body_timeout")
    private Integer clientBodyTimeout = 30000;

    @JsonProperty("client_header_timeout")
    private Integer clientHeaderTimeout = 10000;

    @JsonProperty("client_max_body_size")
    private Integer clientMaxBodySize = 0;

    @JsonProperty("client_max_header_size")
    private Integer clientMaxHeaderSize = 12;

    @JsonProperty("client_max_request_size")
    private Integer clientMaxRequestSize = 48;

    @JsonProperty("compression_profile")
    private CompressionProfile compressionProfile = null;

    @JsonProperty("connection_multiplexing_enabled")
    private Boolean connectionMultiplexingEnabled = true;

    @JsonProperty("disable_keepalive_posts_msie6")
    private Boolean disableKeepalivePostsMsie6 = true;

    @JsonProperty("disable_sni_hostname_check")
    private Boolean disableSniHostnameCheck = false;

    @JsonProperty("enable_chunk_merge")
    private Boolean enableChunkMerge = true;

    @JsonProperty("enable_fire_and_forget")
    private Boolean enableFireAndForget = false;

    @JsonProperty("enable_request_body_buffering")
    private Boolean enableRequestBodyBuffering = false;

    @JsonProperty("enable_request_body_metrics")
    private Boolean enableRequestBodyMetrics = false;

    @JsonProperty("fwd_close_hdr_for_bound_connections")
    private Boolean fwdCloseHdrForBoundConnections = true;

    @JsonProperty("hsts_enabled")
    private Boolean hstsEnabled = false;

    @JsonProperty("hsts_max_age")
    private Integer hstsMaxAge = 365;

    @JsonProperty("hsts_subdomains_enabled")
    private Boolean hstsSubdomainsEnabled = true;

    @JsonProperty("http2_enabled")
    private Boolean http2Enabled = null;

    @JsonProperty("http2_profile")
    private HTTP2ApplicationProfile http2Profile = null;

    @JsonProperty("http_to_https")
    private Boolean httpToHttps = false;

    @JsonProperty("http_upstream_buffer_size")
    private Integer httpUpstreamBufferSize = 0;

    @JsonProperty("httponly_enabled")
    private Boolean httponlyEnabled = false;

    @JsonProperty("keepalive_header")
    private Boolean keepaliveHeader = false;

    @JsonProperty("keepalive_timeout")
    private Integer keepaliveTimeout = 30000;

    @JsonProperty("max_bad_rps_cip")
    private Integer maxBadRpsCip = 0;

    @JsonProperty("max_bad_rps_cip_uri")
    private Integer maxBadRpsCipUri = 0;

    @JsonProperty("max_bad_rps_uri")
    private Integer maxBadRpsUri = 0;

    @JsonProperty("max_http2_concurrent_streams_per_connection")
    private Integer maxHttp2ConcurrentStreamsPerConnection = null;

    @JsonProperty("max_http2_control_frames_per_connection")
    private Integer maxHttp2ControlFramesPerConnection = null;

    @JsonProperty("max_http2_empty_data_frames_per_connection")
    private Integer maxHttp2EmptyDataFramesPerConnection = null;

    @JsonProperty("max_http2_queued_frames_to_client_per_connection")
    private Integer maxHttp2QueuedFramesToClientPerConnection = null;

    @JsonProperty("max_keepalive_requests")
    private Integer maxKeepaliveRequests = 100;

    @JsonProperty("max_response_headers_size")
    private Integer maxResponseHeadersSize = 48;

    @JsonProperty("max_rps_cip")
    private Integer maxRpsCip = 0;

    @JsonProperty("max_rps_cip_uri")
    private Integer maxRpsCipUri = 0;

    @JsonProperty("max_rps_unknown_cip")
    private Integer maxRpsUnknownCip = 0;

    @JsonProperty("max_rps_unknown_uri")
    private Integer maxRpsUnknownUri = 0;

    @JsonProperty("max_rps_uri")
    private Integer maxRpsUri = 0;

    @JsonProperty("pki_profile_ref")
    private String pkiProfileRef = null;

    @JsonProperty("post_accept_timeout")
    private Integer postAcceptTimeout = 30000;

    @JsonProperty("reset_conn_http_on_ssl_port")
    private Boolean resetConnHttpOnSslPort = false;

    @JsonProperty("respond_with_100_continue")
    private Boolean respondWith100Continue = true;

    @JsonProperty("secure_cookie_enabled")
    private Boolean secureCookieEnabled = false;

    @JsonProperty("server_side_redirect_to_https")
    private Boolean serverSideRedirectToHttps = false;

    @JsonProperty("spdy_enabled")
    private Boolean spdyEnabled = null;

    @JsonProperty("spdy_fwd_proxy_mode")
    private Boolean spdyFwdProxyMode = null;

    @JsonProperty("ssl_client_certificate_action")
    private SSLClientCertificateAction sslClientCertificateAction = null;

    @JsonProperty("ssl_client_certificate_mode")
    private String sslClientCertificateMode = "SSL_CLIENT_CERTIFICATE_NONE";

    @JsonProperty("ssl_everywhere_enabled")
    private Boolean sslEverywhereEnabled = null;

    @JsonProperty("use_app_keepalive_timeout")
    private Boolean useAppKeepaliveTimeout = false;

    @JsonProperty("websockets_enabled")
    private Boolean websocketsEnabled = true;

    @JsonProperty("x_forwarded_proto_enabled")
    private Boolean xForwardedProtoEnabled = false;

    @JsonProperty("xff_alternate_name")
    private String xffAlternateName = "x-forwarded-for";

    @JsonProperty("xff_enabled")
    private Boolean xffEnabled = true;



  /**
   * This is the getter method this will return the attribute value.
   * Allow use of dot (.) in http header names, for instance header.app.special  pickappversionx.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return allowDotsInHeaderName
   */
  public Boolean getAllowDotsInHeaderName() {
    return allowDotsInHeaderName;
  }

  /**
   * This is the setter method to the attribute.
   * Allow use of dot (.) in http header names, for instance header.app.special  pickappversionx.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param allowDotsInHeaderName set the allowDotsInHeaderName.
   */
  public void setAllowDotsInHeaderName(Boolean  allowDotsInHeaderName) {
    this.allowDotsInHeaderName = allowDotsInHeaderName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Http caching config to use with this http profile.
   * @return cacheConfig
   */
  public HttpCacheConfig getCacheConfig() {
    return cacheConfig;
  }

  /**
   * This is the setter method to the attribute.
   * Http caching config to use with this http profile.
   * @param cacheConfig set the cacheConfig.
   */
  public void setCacheConfig(HttpCacheConfig cacheConfig) {
    this.cacheConfig = cacheConfig;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The maximum length of time allowed between consecutive read operations for a client request body.
   * The value '0' specifies no timeout.
   * This setting generally impacts the length of time allowed for a client to send a post.
   * Allowed values are 0-100000000.
   * Default value when not specified in API or module is interpreted by Avi Controller as 30000.
   * @return clientBodyTimeout
   */
  public Integer getClientBodyTimeout() {
    return clientBodyTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * The maximum length of time allowed between consecutive read operations for a client request body.
   * The value '0' specifies no timeout.
   * This setting generally impacts the length of time allowed for a client to send a post.
   * Allowed values are 0-100000000.
   * Default value when not specified in API or module is interpreted by Avi Controller as 30000.
   * @param clientBodyTimeout set the clientBodyTimeout.
   */
  public void setClientBodyTimeout(Integer  clientBodyTimeout) {
    this.clientBodyTimeout = clientBodyTimeout;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The maximum length of time allowed for a client to transmit an entire request header.
   * This helps mitigate various forms of slowloris attacks.
   * Allowed values are 10-100000000.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10000.
   * @return clientHeaderTimeout
   */
  public Integer getClientHeaderTimeout() {
    return clientHeaderTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * The maximum length of time allowed for a client to transmit an entire request header.
   * This helps mitigate various forms of slowloris attacks.
   * Allowed values are 10-100000000.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10000.
   * @param clientHeaderTimeout set the clientHeaderTimeout.
   */
  public void setClientHeaderTimeout(Integer  clientHeaderTimeout) {
    this.clientHeaderTimeout = clientHeaderTimeout;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum size for the client request body.
   * This limits the size of the client data that can be uploaded/posted as part of a single http request.
   * Default 0 => unlimited.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return clientMaxBodySize
   */
  public Integer getClientMaxBodySize() {
    return clientMaxBodySize;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum size for the client request body.
   * This limits the size of the client data that can be uploaded/posted as part of a single http request.
   * Default 0 => unlimited.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param clientMaxBodySize set the clientMaxBodySize.
   */
  public void setClientMaxBodySize(Integer  clientMaxBodySize) {
    this.clientMaxBodySize = clientMaxBodySize;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum size in kbytes of a single http header in the client request.
   * Allowed values are 1-64.
   * Default value when not specified in API or module is interpreted by Avi Controller as 12.
   * @return clientMaxHeaderSize
   */
  public Integer getClientMaxHeaderSize() {
    return clientMaxHeaderSize;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum size in kbytes of a single http header in the client request.
   * Allowed values are 1-64.
   * Default value when not specified in API or module is interpreted by Avi Controller as 12.
   * @param clientMaxHeaderSize set the clientMaxHeaderSize.
   */
  public void setClientMaxHeaderSize(Integer  clientMaxHeaderSize) {
    this.clientMaxHeaderSize = clientMaxHeaderSize;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum size in kbytes of all the client http request headers.
   * Allowed values are 1-256.
   * Default value when not specified in API or module is interpreted by Avi Controller as 48.
   * @return clientMaxRequestSize
   */
  public Integer getClientMaxRequestSize() {
    return clientMaxRequestSize;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum size in kbytes of all the client http request headers.
   * Allowed values are 1-256.
   * Default value when not specified in API or module is interpreted by Avi Controller as 48.
   * @param clientMaxRequestSize set the clientMaxRequestSize.
   */
  public void setClientMaxRequestSize(Integer  clientMaxRequestSize) {
    this.clientMaxRequestSize = clientMaxRequestSize;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Http compression settings to use with this http profile.
   * @return compressionProfile
   */
  public CompressionProfile getCompressionProfile() {
    return compressionProfile;
  }

  /**
   * This is the setter method to the attribute.
   * Http compression settings to use with this http profile.
   * @param compressionProfile set the compressionProfile.
   */
  public void setCompressionProfile(CompressionProfile compressionProfile) {
    this.compressionProfile = compressionProfile;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Allows http requests, not just tcp connections, to be load balanced across servers.
   * Proxied tcp connections to servers may be reused by multiple clients to improve performance.
   * Not compatible with preserve client ip.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return connectionMultiplexingEnabled
   */
  public Boolean getConnectionMultiplexingEnabled() {
    return connectionMultiplexingEnabled;
  }

  /**
   * This is the setter method to the attribute.
   * Allows http requests, not just tcp connections, to be load balanced across servers.
   * Proxied tcp connections to servers may be reused by multiple clients to improve performance.
   * Not compatible with preserve client ip.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param connectionMultiplexingEnabled set the connectionMultiplexingEnabled.
   */
  public void setConnectionMultiplexingEnabled(Boolean  connectionMultiplexingEnabled) {
    this.connectionMultiplexingEnabled = connectionMultiplexingEnabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Disable keep-alive client side connections for older browsers based off ms internet explorer 6.0 (msie6).
   * For some applications, this might break ntlm authentication for older clients based off msie6.
   * For such applications, set this option to false to allow keep-alive connections.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return disableKeepalivePostsMsie6
   */
  public Boolean getDisableKeepalivePostsMsie6() {
    return disableKeepalivePostsMsie6;
  }

  /**
   * This is the setter method to the attribute.
   * Disable keep-alive client side connections for older browsers based off ms internet explorer 6.0 (msie6).
   * For some applications, this might break ntlm authentication for older clients based off msie6.
   * For such applications, set this option to false to allow keep-alive connections.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param disableKeepalivePostsMsie6 set the disableKeepalivePostsMsie6.
   */
  public void setDisableKeepalivePostsMsie6(Boolean  disableKeepalivePostsMsie6) {
    this.disableKeepalivePostsMsie6 = disableKeepalivePostsMsie6;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Disable strict check between tls servername and http host name.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return disableSniHostnameCheck
   */
  public Boolean getDisableSniHostnameCheck() {
    return disableSniHostnameCheck;
  }

  /**
   * This is the setter method to the attribute.
   * Disable strict check between tls servername and http host name.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param disableSniHostnameCheck set the disableSniHostnameCheck.
   */
  public void setDisableSniHostnameCheck(Boolean  disableSniHostnameCheck) {
    this.disableSniHostnameCheck = disableSniHostnameCheck;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable chunk body merge for chunked transfer encoding response.
   * Field introduced in 18.2.7.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return enableChunkMerge
   */
  public Boolean getEnableChunkMerge() {
    return enableChunkMerge;
  }

  /**
   * This is the setter method to the attribute.
   * Enable chunk body merge for chunked transfer encoding response.
   * Field introduced in 18.2.7.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param enableChunkMerge set the enableChunkMerge.
   */
  public void setEnableChunkMerge(Boolean  enableChunkMerge) {
    this.enableChunkMerge = enableChunkMerge;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable support for fire and forget feature.
   * If enabled, request from client is forwarded to server even if client prematurely closes the connection.
   * Field introduced in 17.2.4.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return enableFireAndForget
   */
  public Boolean getEnableFireAndForget() {
    return enableFireAndForget;
  }

  /**
   * This is the setter method to the attribute.
   * Enable support for fire and forget feature.
   * If enabled, request from client is forwarded to server even if client prematurely closes the connection.
   * Field introduced in 17.2.4.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param enableFireAndForget set the enableFireAndForget.
   */
  public void setEnableFireAndForget(Boolean  enableFireAndForget) {
    this.enableFireAndForget = enableFireAndForget;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable request body buffering for post requests.
   * If enabled, max buffer size is set to lower of 32m or the value (non-zero) configured in client_max_body_size.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return enableRequestBodyBuffering
   */
  public Boolean getEnableRequestBodyBuffering() {
    return enableRequestBodyBuffering;
  }

  /**
   * This is the setter method to the attribute.
   * Enable request body buffering for post requests.
   * If enabled, max buffer size is set to lower of 32m or the value (non-zero) configured in client_max_body_size.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param enableRequestBodyBuffering set the enableRequestBodyBuffering.
   */
  public void setEnableRequestBodyBuffering(Boolean  enableRequestBodyBuffering) {
    this.enableRequestBodyBuffering = enableRequestBodyBuffering;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable http request body metrics.
   * If enabled, requests from clients are parsed and relevant statistics about them are gathered.
   * Currently, it processes http post requests with content-type application/x-www-form-urlencoded or multipart/form-data, and adds the number of
   * detected parameters to the l7_client.http_params_count.
   * This is an experimental feature and it may have performance impact.
   * Use it when detailed information about the number of http post parameters is needed, e.g.
   * For waf sizing.
   * Field introduced in 18.1.5, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return enableRequestBodyMetrics
   */
  public Boolean getEnableRequestBodyMetrics() {
    return enableRequestBodyMetrics;
  }

  /**
   * This is the setter method to the attribute.
   * Enable http request body metrics.
   * If enabled, requests from clients are parsed and relevant statistics about them are gathered.
   * Currently, it processes http post requests with content-type application/x-www-form-urlencoded or multipart/form-data, and adds the number of
   * detected parameters to the l7_client.http_params_count.
   * This is an experimental feature and it may have performance impact.
   * Use it when detailed information about the number of http post parameters is needed, e.g.
   * For waf sizing.
   * Field introduced in 18.1.5, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param enableRequestBodyMetrics set the enableRequestBodyMetrics.
   */
  public void setEnableRequestBodyMetrics(Boolean  enableRequestBodyMetrics) {
    this.enableRequestBodyMetrics = enableRequestBodyMetrics;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Forward the connection  close header coming from backend server to the client if connection-switching is enabled, i.e.
   * Front-end and backend connections are bound together.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return fwdCloseHdrForBoundConnections
   */
  public Boolean getFwdCloseHdrForBoundConnections() {
    return fwdCloseHdrForBoundConnections;
  }

  /**
   * This is the setter method to the attribute.
   * Forward the connection  close header coming from backend server to the client if connection-switching is enabled, i.e.
   * Front-end and backend connections are bound together.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param fwdCloseHdrForBoundConnections set the fwdCloseHdrForBoundConnections.
   */
  public void setFwdCloseHdrForBoundConnections(Boolean  fwdCloseHdrForBoundConnections) {
    this.fwdCloseHdrForBoundConnections = fwdCloseHdrForBoundConnections;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Inserts http strict-transport-security header in the https response.
   * Hsts can help mitigate man-in-the-middle attacks by telling browsers that support hsts that they should only access this site via https.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return hstsEnabled
   */
  public Boolean getHstsEnabled() {
    return hstsEnabled;
  }

  /**
   * This is the setter method to the attribute.
   * Inserts http strict-transport-security header in the https response.
   * Hsts can help mitigate man-in-the-middle attacks by telling browsers that support hsts that they should only access this site via https.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param hstsEnabled set the hstsEnabled.
   */
  public void setHstsEnabled(Boolean  hstsEnabled) {
    this.hstsEnabled = hstsEnabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Number of days for which the client should regard this virtual service as a known hsts host.
   * Allowed values are 0-10000.
   * Default value when not specified in API or module is interpreted by Avi Controller as 365.
   * @return hstsMaxAge
   */
  public Integer getHstsMaxAge() {
    return hstsMaxAge;
  }

  /**
   * This is the setter method to the attribute.
   * Number of days for which the client should regard this virtual service as a known hsts host.
   * Allowed values are 0-10000.
   * Default value when not specified in API or module is interpreted by Avi Controller as 365.
   * @param hstsMaxAge set the hstsMaxAge.
   */
  public void setHstsMaxAge(Integer  hstsMaxAge) {
    this.hstsMaxAge = hstsMaxAge;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Insert the 'includesubdomains' directive in the http strict-transport-security header.
   * Adding the includesubdomains directive signals the user-agent that the hsts policy applies to this hsts host as well as any subdomains of the
   * host's domain name.
   * Field introduced in 17.2.13, 18.1.4, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return hstsSubdomainsEnabled
   */
  public Boolean getHstsSubdomainsEnabled() {
    return hstsSubdomainsEnabled;
  }

  /**
   * This is the setter method to the attribute.
   * Insert the 'includesubdomains' directive in the http strict-transport-security header.
   * Adding the includesubdomains directive signals the user-agent that the hsts policy applies to this hsts host as well as any subdomains of the
   * host's domain name.
   * Field introduced in 17.2.13, 18.1.4, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param hstsSubdomainsEnabled set the hstsSubdomainsEnabled.
   */
  public void setHstsSubdomainsEnabled(Boolean  hstsSubdomainsEnabled) {
    this.hstsSubdomainsEnabled = hstsSubdomainsEnabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable http2 for traffic from clients to the virtual service.
   * Field deprecated in 20.1.1.
   * Field introduced in 18.1.1.
   * @return http2Enabled
   */
  public Boolean getHttp2Enabled() {
    return http2Enabled;
  }

  /**
   * This is the setter method to the attribute.
   * Enable http2 for traffic from clients to the virtual service.
   * Field deprecated in 20.1.1.
   * Field introduced in 18.1.1.
   * @param http2Enabled set the http2Enabled.
   */
  public void setHttp2Enabled(Boolean  http2Enabled) {
    this.http2Enabled = http2Enabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Specifies the http/2 specific application profile parameters.
   * Field introduced in 20.1.1.
   * @return http2Profile
   */
  public HTTP2ApplicationProfile getHttp2Profile() {
    return http2Profile;
  }

  /**
   * This is the setter method to the attribute.
   * Specifies the http/2 specific application profile parameters.
   * Field introduced in 20.1.1.
   * @param http2Profile set the http2Profile.
   */
  public void setHttp2Profile(HTTP2ApplicationProfile http2Profile) {
    this.http2Profile = http2Profile;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Client requests received via http will be redirected to https.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return httpToHttps
   */
  public Boolean getHttpToHttps() {
    return httpToHttps;
  }

  /**
   * This is the setter method to the attribute.
   * Client requests received via http will be redirected to https.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param httpToHttps set the httpToHttps.
   */
  public void setHttpToHttps(Boolean  httpToHttps) {
    this.httpToHttps = httpToHttps;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Size of http buffer in kb.
   * Allowed values are 1-256.
   * Special values are 0- 'auto compute the size of buffer'.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return httpUpstreamBufferSize
   */
  public Integer getHttpUpstreamBufferSize() {
    return httpUpstreamBufferSize;
  }

  /**
   * This is the setter method to the attribute.
   * Size of http buffer in kb.
   * Allowed values are 1-256.
   * Special values are 0- 'auto compute the size of buffer'.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param httpUpstreamBufferSize set the httpUpstreamBufferSize.
   */
  public void setHttpUpstreamBufferSize(Integer  httpUpstreamBufferSize) {
    this.httpUpstreamBufferSize = httpUpstreamBufferSize;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Mark http cookies as httponly.
   * This helps mitigate cross site scripting attacks as browsers will not allow these cookies to be read by third parties, such as javascript.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return httponlyEnabled
   */
  public Boolean getHttponlyEnabled() {
    return httponlyEnabled;
  }

  /**
   * This is the setter method to the attribute.
   * Mark http cookies as httponly.
   * This helps mitigate cross site scripting attacks as browsers will not allow these cookies to be read by third parties, such as javascript.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param httponlyEnabled set the httponlyEnabled.
   */
  public void setHttponlyEnabled(Boolean  httponlyEnabled) {
    this.httponlyEnabled = httponlyEnabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Send http 'keep-alive' header to the client.
   * By default, the timeout specified in the 'keep-alive timeout' field will be used unless the 'use app keepalive timeout' flag is set, in which
   * case the timeout sent by the application will be honored.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return keepaliveHeader
   */
  public Boolean getKeepaliveHeader() {
    return keepaliveHeader;
  }

  /**
   * This is the setter method to the attribute.
   * Send http 'keep-alive' header to the client.
   * By default, the timeout specified in the 'keep-alive timeout' field will be used unless the 'use app keepalive timeout' flag is set, in which
   * case the timeout sent by the application will be honored.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param keepaliveHeader set the keepaliveHeader.
   */
  public void setKeepaliveHeader(Boolean  keepaliveHeader) {
    this.keepaliveHeader = keepaliveHeader;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The max idle time allowed between http requests over a keep-alive connection.
   * Allowed values are 10-100000000.
   * Default value when not specified in API or module is interpreted by Avi Controller as 30000.
   * @return keepaliveTimeout
   */
  public Integer getKeepaliveTimeout() {
    return keepaliveTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * The max idle time allowed between http requests over a keep-alive connection.
   * Allowed values are 10-100000000.
   * Default value when not specified in API or module is interpreted by Avi Controller as 30000.
   * @param keepaliveTimeout set the keepaliveTimeout.
   */
  public void setKeepaliveTimeout(Integer  keepaliveTimeout) {
    this.keepaliveTimeout = keepaliveTimeout;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum bad requests per second per client ip.
   * Allowed values are 10-1000.
   * Special values are 0- 'unlimited'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return maxBadRpsCip
   */
  public Integer getMaxBadRpsCip() {
    return maxBadRpsCip;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum bad requests per second per client ip.
   * Allowed values are 10-1000.
   * Special values are 0- 'unlimited'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param maxBadRpsCip set the maxBadRpsCip.
   */
  public void setMaxBadRpsCip(Integer  maxBadRpsCip) {
    this.maxBadRpsCip = maxBadRpsCip;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum bad requests per second per client ip and uri.
   * Allowed values are 10-1000.
   * Special values are 0- 'unlimited'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return maxBadRpsCipUri
   */
  public Integer getMaxBadRpsCipUri() {
    return maxBadRpsCipUri;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum bad requests per second per client ip and uri.
   * Allowed values are 10-1000.
   * Special values are 0- 'unlimited'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param maxBadRpsCipUri set the maxBadRpsCipUri.
   */
  public void setMaxBadRpsCipUri(Integer  maxBadRpsCipUri) {
    this.maxBadRpsCipUri = maxBadRpsCipUri;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum bad requests per second per uri.
   * Allowed values are 10-1000.
   * Special values are 0- 'unlimited'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return maxBadRpsUri
   */
  public Integer getMaxBadRpsUri() {
    return maxBadRpsUri;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum bad requests per second per uri.
   * Allowed values are 10-1000.
   * Special values are 0- 'unlimited'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param maxBadRpsUri set the maxBadRpsUri.
   */
  public void setMaxBadRpsUri(Integer  maxBadRpsUri) {
    this.maxBadRpsUri = maxBadRpsUri;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The max number of concurrent streams over a client side http/2 connection.
   * Allowed values are 1-256.
   * Field deprecated in 20.1.1.
   * Field introduced in 18.2.6.
   * @return maxHttp2ConcurrentStreamsPerConnection
   */
  public Integer getMaxHttp2ConcurrentStreamsPerConnection() {
    return maxHttp2ConcurrentStreamsPerConnection;
  }

  /**
   * This is the setter method to the attribute.
   * The max number of concurrent streams over a client side http/2 connection.
   * Allowed values are 1-256.
   * Field deprecated in 20.1.1.
   * Field introduced in 18.2.6.
   * @param maxHttp2ConcurrentStreamsPerConnection set the maxHttp2ConcurrentStreamsPerConnection.
   */
  public void setMaxHttp2ConcurrentStreamsPerConnection(Integer  maxHttp2ConcurrentStreamsPerConnection) {
    this.maxHttp2ConcurrentStreamsPerConnection = maxHttp2ConcurrentStreamsPerConnection;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The max number of control frames that client can send over an http/2 connection.
   * '0' means unlimited.
   * Allowed values are 0-10000.
   * Special values are 0- 'unlimited control frames on a client side http/2 connection'.
   * Field deprecated in 20.1.1.
   * Field introduced in 18.2.6.
   * @return maxHttp2ControlFramesPerConnection
   */
  public Integer getMaxHttp2ControlFramesPerConnection() {
    return maxHttp2ControlFramesPerConnection;
  }

  /**
   * This is the setter method to the attribute.
   * The max number of control frames that client can send over an http/2 connection.
   * '0' means unlimited.
   * Allowed values are 0-10000.
   * Special values are 0- 'unlimited control frames on a client side http/2 connection'.
   * Field deprecated in 20.1.1.
   * Field introduced in 18.2.6.
   * @param maxHttp2ControlFramesPerConnection set the maxHttp2ControlFramesPerConnection.
   */
  public void setMaxHttp2ControlFramesPerConnection(Integer  maxHttp2ControlFramesPerConnection) {
    this.maxHttp2ControlFramesPerConnection = maxHttp2ControlFramesPerConnection;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The max number of empty data frames that client can send over an http/2 connection.
   * '0' means unlimited.
   * Allowed values are 0-10000.
   * Special values are 0- 'unlimited empty data frames over a client side http/2 connection'.
   * Field deprecated in 20.1.1.
   * Field introduced in 18.2.6.
   * @return maxHttp2EmptyDataFramesPerConnection
   */
  public Integer getMaxHttp2EmptyDataFramesPerConnection() {
    return maxHttp2EmptyDataFramesPerConnection;
  }

  /**
   * This is the setter method to the attribute.
   * The max number of empty data frames that client can send over an http/2 connection.
   * '0' means unlimited.
   * Allowed values are 0-10000.
   * Special values are 0- 'unlimited empty data frames over a client side http/2 connection'.
   * Field deprecated in 20.1.1.
   * Field introduced in 18.2.6.
   * @param maxHttp2EmptyDataFramesPerConnection set the maxHttp2EmptyDataFramesPerConnection.
   */
  public void setMaxHttp2EmptyDataFramesPerConnection(Integer  maxHttp2EmptyDataFramesPerConnection) {
    this.maxHttp2EmptyDataFramesPerConnection = maxHttp2EmptyDataFramesPerConnection;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The max number of frames that can be queued waiting to be sent over a client side http/2 connection at any given time.
   * '0' means unlimited.
   * Allowed values are 0-10000.
   * Special values are 0- 'unlimited frames can be queued on a client side http/2 connection'.
   * Field deprecated in 20.1.1.
   * Field introduced in 18.2.6.
   * @return maxHttp2QueuedFramesToClientPerConnection
   */
  public Integer getMaxHttp2QueuedFramesToClientPerConnection() {
    return maxHttp2QueuedFramesToClientPerConnection;
  }

  /**
   * This is the setter method to the attribute.
   * The max number of frames that can be queued waiting to be sent over a client side http/2 connection at any given time.
   * '0' means unlimited.
   * Allowed values are 0-10000.
   * Special values are 0- 'unlimited frames can be queued on a client side http/2 connection'.
   * Field deprecated in 20.1.1.
   * Field introduced in 18.2.6.
   * @param maxHttp2QueuedFramesToClientPerConnection set the maxHttp2QueuedFramesToClientPerConnection.
   */
  public void setMaxHttp2QueuedFramesToClientPerConnection(Integer  maxHttp2QueuedFramesToClientPerConnection) {
    this.maxHttp2QueuedFramesToClientPerConnection = maxHttp2QueuedFramesToClientPerConnection;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The max number of http requests that can be sent over a keep-alive connection.
   * '0' means unlimited.
   * Allowed values are 0-1000000.
   * Special values are 0- 'unlimited requests on a connection'.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100.
   * @return maxKeepaliveRequests
   */
  public Integer getMaxKeepaliveRequests() {
    return maxKeepaliveRequests;
  }

  /**
   * This is the setter method to the attribute.
   * The max number of http requests that can be sent over a keep-alive connection.
   * '0' means unlimited.
   * Allowed values are 0-1000000.
   * Special values are 0- 'unlimited requests on a connection'.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100.
   * @param maxKeepaliveRequests set the maxKeepaliveRequests.
   */
  public void setMaxKeepaliveRequests(Integer  maxKeepaliveRequests) {
    this.maxKeepaliveRequests = maxKeepaliveRequests;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum size in kbytes of all the http response headers.
   * Allowed values are 1-256.
   * Default value when not specified in API or module is interpreted by Avi Controller as 48.
   * @return maxResponseHeadersSize
   */
  public Integer getMaxResponseHeadersSize() {
    return maxResponseHeadersSize;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum size in kbytes of all the http response headers.
   * Allowed values are 1-256.
   * Default value when not specified in API or module is interpreted by Avi Controller as 48.
   * @param maxResponseHeadersSize set the maxResponseHeadersSize.
   */
  public void setMaxResponseHeadersSize(Integer  maxResponseHeadersSize) {
    this.maxResponseHeadersSize = maxResponseHeadersSize;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum requests per second per client ip.
   * Allowed values are 10-1000.
   * Special values are 0- 'unlimited'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return maxRpsCip
   */
  public Integer getMaxRpsCip() {
    return maxRpsCip;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum requests per second per client ip.
   * Allowed values are 10-1000.
   * Special values are 0- 'unlimited'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param maxRpsCip set the maxRpsCip.
   */
  public void setMaxRpsCip(Integer  maxRpsCip) {
    this.maxRpsCip = maxRpsCip;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum requests per second per client ip and uri.
   * Allowed values are 10-1000.
   * Special values are 0- 'unlimited'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return maxRpsCipUri
   */
  public Integer getMaxRpsCipUri() {
    return maxRpsCipUri;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum requests per second per client ip and uri.
   * Allowed values are 10-1000.
   * Special values are 0- 'unlimited'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param maxRpsCipUri set the maxRpsCipUri.
   */
  public void setMaxRpsCipUri(Integer  maxRpsCipUri) {
    this.maxRpsCipUri = maxRpsCipUri;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum unknown client ips per second.
   * Allowed values are 10-1000.
   * Special values are 0- 'unlimited'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return maxRpsUnknownCip
   */
  public Integer getMaxRpsUnknownCip() {
    return maxRpsUnknownCip;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum unknown client ips per second.
   * Allowed values are 10-1000.
   * Special values are 0- 'unlimited'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param maxRpsUnknownCip set the maxRpsUnknownCip.
   */
  public void setMaxRpsUnknownCip(Integer  maxRpsUnknownCip) {
    this.maxRpsUnknownCip = maxRpsUnknownCip;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum unknown uris per second.
   * Allowed values are 10-1000.
   * Special values are 0- 'unlimited'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return maxRpsUnknownUri
   */
  public Integer getMaxRpsUnknownUri() {
    return maxRpsUnknownUri;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum unknown uris per second.
   * Allowed values are 10-1000.
   * Special values are 0- 'unlimited'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param maxRpsUnknownUri set the maxRpsUnknownUri.
   */
  public void setMaxRpsUnknownUri(Integer  maxRpsUnknownUri) {
    this.maxRpsUnknownUri = maxRpsUnknownUri;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum requests per second per uri.
   * Allowed values are 10-1000.
   * Special values are 0- 'unlimited'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return maxRpsUri
   */
  public Integer getMaxRpsUri() {
    return maxRpsUri;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum requests per second per uri.
   * Allowed values are 10-1000.
   * Special values are 0- 'unlimited'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param maxRpsUri set the maxRpsUri.
   */
  public void setMaxRpsUri(Integer  maxRpsUri) {
    this.maxRpsUri = maxRpsUri;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Select the pki profile to be associated with the virtual service.
   * This profile defines the certificate authority and revocation list.
   * It is a reference to an object of type pkiprofile.
   * @return pkiProfileRef
   */
  public String getPkiProfileRef() {
    return pkiProfileRef;
  }

  /**
   * This is the setter method to the attribute.
   * Select the pki profile to be associated with the virtual service.
   * This profile defines the certificate authority and revocation list.
   * It is a reference to an object of type pkiprofile.
   * @param pkiProfileRef set the pkiProfileRef.
   */
  public void setPkiProfileRef(String  pkiProfileRef) {
    this.pkiProfileRef = pkiProfileRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The max allowed length of time between a client establishing a tcp connection until avi receives the first byte of the client's http request.
   * Allowed values are 10-100000000.
   * Default value when not specified in API or module is interpreted by Avi Controller as 30000.
   * @return postAcceptTimeout
   */
  public Integer getPostAcceptTimeout() {
    return postAcceptTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * The max allowed length of time between a client establishing a tcp connection until avi receives the first byte of the client's http request.
   * Allowed values are 10-100000000.
   * Default value when not specified in API or module is interpreted by Avi Controller as 30000.
   * @param postAcceptTimeout set the postAcceptTimeout.
   */
  public void setPostAcceptTimeout(Integer  postAcceptTimeout) {
    this.postAcceptTimeout = postAcceptTimeout;
  }

  /**
   * This is the getter method this will return the attribute value.
   * If enabled, an http request on an ssl port will result in connection close instead of a 400 response.
   * Field introduced in 18.2.6.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return resetConnHttpOnSslPort
   */
  public Boolean getResetConnHttpOnSslPort() {
    return resetConnHttpOnSslPort;
  }

  /**
   * This is the setter method to the attribute.
   * If enabled, an http request on an ssl port will result in connection close instead of a 400 response.
   * Field introduced in 18.2.6.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param resetConnHttpOnSslPort set the resetConnHttpOnSslPort.
   */
  public void setResetConnHttpOnSslPort(Boolean  resetConnHttpOnSslPort) {
    this.resetConnHttpOnSslPort = resetConnHttpOnSslPort;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Avi will respond with 100-continue response if expect  100-continue header received from client.
   * Field introduced in 17.2.8.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return respondWith100Continue
   */
  public Boolean getRespondWith100Continue() {
    return respondWith100Continue;
  }

  /**
   * This is the setter method to the attribute.
   * Avi will respond with 100-continue response if expect  100-continue header received from client.
   * Field introduced in 17.2.8.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param respondWith100Continue set the respondWith100Continue.
   */
  public void setRespondWith100Continue(Boolean  respondWith100Continue) {
    this.respondWith100Continue = respondWith100Continue;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Mark server cookies with the 'secure' attribute.
   * Client browsers will not send a cookie marked as secure over an unencrypted connection.
   * If avi is terminating ssl from clients and passing it as http to the server, the server may return cookies without the secure flag set.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return secureCookieEnabled
   */
  public Boolean getSecureCookieEnabled() {
    return secureCookieEnabled;
  }

  /**
   * This is the setter method to the attribute.
   * Mark server cookies with the 'secure' attribute.
   * Client browsers will not send a cookie marked as secure over an unencrypted connection.
   * If avi is terminating ssl from clients and passing it as http to the server, the server may return cookies without the secure flag set.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param secureCookieEnabled set the secureCookieEnabled.
   */
  public void setSecureCookieEnabled(Boolean  secureCookieEnabled) {
    this.secureCookieEnabled = secureCookieEnabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * When terminating client ssl sessions at avi, servers may incorrectly send redirect to clients as http.
   * This option will rewrite the server's redirect responses for this virtual service from http to https.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return serverSideRedirectToHttps
   */
  public Boolean getServerSideRedirectToHttps() {
    return serverSideRedirectToHttps;
  }

  /**
   * This is the setter method to the attribute.
   * When terminating client ssl sessions at avi, servers may incorrectly send redirect to clients as http.
   * This option will rewrite the server's redirect responses for this virtual service from http to https.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param serverSideRedirectToHttps set the serverSideRedirectToHttps.
   */
  public void setServerSideRedirectToHttps(Boolean  serverSideRedirectToHttps) {
    this.serverSideRedirectToHttps = serverSideRedirectToHttps;
  }

  /**
   * This is the getter method this will return the attribute value.
   * This field is deprecated.
   * Field deprecated in 18.2.8.
   * @return spdyEnabled
   */
  public Boolean getSpdyEnabled() {
    return spdyEnabled;
  }

  /**
   * This is the setter method to the attribute.
   * This field is deprecated.
   * Field deprecated in 18.2.8.
   * @param spdyEnabled set the spdyEnabled.
   */
  public void setSpdyEnabled(Boolean  spdyEnabled) {
    this.spdyEnabled = spdyEnabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * This field is deprecated.
   * Field deprecated in 18.2.8.
   * @return spdyFwdProxyMode
   */
  public Boolean getSpdyFwdProxyMode() {
    return spdyFwdProxyMode;
  }

  /**
   * This is the setter method to the attribute.
   * This field is deprecated.
   * Field deprecated in 18.2.8.
   * @param spdyFwdProxyMode set the spdyFwdProxyMode.
   */
  public void setSpdyFwdProxyMode(Boolean  spdyFwdProxyMode) {
    this.spdyFwdProxyMode = spdyFwdProxyMode;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Set of match/action rules that govern what happens when the client certificate request is enabled.
   * @return sslClientCertificateAction
   */
  public SSLClientCertificateAction getSslClientCertificateAction() {
    return sslClientCertificateAction;
  }

  /**
   * This is the setter method to the attribute.
   * Set of match/action rules that govern what happens when the client certificate request is enabled.
   * @param sslClientCertificateAction set the sslClientCertificateAction.
   */
  public void setSslClientCertificateAction(SSLClientCertificateAction sslClientCertificateAction) {
    this.sslClientCertificateAction = sslClientCertificateAction;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Specifies whether the client side verification is set to none, request or require.
   * Enum options - SSL_CLIENT_CERTIFICATE_NONE, SSL_CLIENT_CERTIFICATE_REQUEST, SSL_CLIENT_CERTIFICATE_REQUIRE.
   * Default value when not specified in API or module is interpreted by Avi Controller as SSL_CLIENT_CERTIFICATE_NONE.
   * @return sslClientCertificateMode
   */
  public String getSslClientCertificateMode() {
    return sslClientCertificateMode;
  }

  /**
   * This is the setter method to the attribute.
   * Specifies whether the client side verification is set to none, request or require.
   * Enum options - SSL_CLIENT_CERTIFICATE_NONE, SSL_CLIENT_CERTIFICATE_REQUEST, SSL_CLIENT_CERTIFICATE_REQUIRE.
   * Default value when not specified in API or module is interpreted by Avi Controller as SSL_CLIENT_CERTIFICATE_NONE.
   * @param sslClientCertificateMode set the sslClientCertificateMode.
   */
  public void setSslClientCertificateMode(String  sslClientCertificateMode) {
    this.sslClientCertificateMode = sslClientCertificateMode;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable common settings to increase the level of security for  virtual services running http and https.
   * For sites that are  http only, these settings will have no effect.
   * Field deprecated in 18.2.7.
   * @return sslEverywhereEnabled
   */
  public Boolean getSslEverywhereEnabled() {
    return sslEverywhereEnabled;
  }

  /**
   * This is the setter method to the attribute.
   * Enable common settings to increase the level of security for  virtual services running http and https.
   * For sites that are  http only, these settings will have no effect.
   * Field deprecated in 18.2.7.
   * @param sslEverywhereEnabled set the sslEverywhereEnabled.
   */
  public void setSslEverywhereEnabled(Boolean  sslEverywhereEnabled) {
    this.sslEverywhereEnabled = sslEverywhereEnabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Use 'keep-alive' header timeout sent by application instead of sending the http keep-alive timeout.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return useAppKeepaliveTimeout
   */
  public Boolean getUseAppKeepaliveTimeout() {
    return useAppKeepaliveTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * Use 'keep-alive' header timeout sent by application instead of sending the http keep-alive timeout.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param useAppKeepaliveTimeout set the useAppKeepaliveTimeout.
   */
  public void setUseAppKeepaliveTimeout(Boolean  useAppKeepaliveTimeout) {
    this.useAppKeepaliveTimeout = useAppKeepaliveTimeout;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable websockets proxy for traffic from clients to the virtual service.
   * Connections to this vs start in http mode.
   * If the client requests an upgrade to websockets, and the server responds back with success, then the connection is upgraded to websockets mode.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return websocketsEnabled
   */
  public Boolean getWebsocketsEnabled() {
    return websocketsEnabled;
  }

  /**
   * This is the setter method to the attribute.
   * Enable websockets proxy for traffic from clients to the virtual service.
   * Connections to this vs start in http mode.
   * If the client requests an upgrade to websockets, and the server responds back with success, then the connection is upgraded to websockets mode.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param websocketsEnabled set the websocketsEnabled.
   */
  public void setWebsocketsEnabled(Boolean  websocketsEnabled) {
    this.websocketsEnabled = websocketsEnabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Insert an x-forwarded-proto header in the request sent to the server.
   * When the client connects via ssl, avi terminates the ssl, and then forwards the requests to the servers via http, so the servers can determine
   * the original protocol via this header.
   * In this example, the value will be 'https'.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return xForwardedProtoEnabled
   */
  public Boolean getXForwardedProtoEnabled() {
    return xForwardedProtoEnabled;
  }

  /**
   * This is the setter method to the attribute.
   * Insert an x-forwarded-proto header in the request sent to the server.
   * When the client connects via ssl, avi terminates the ssl, and then forwards the requests to the servers via http, so the servers can determine
   * the original protocol via this header.
   * In this example, the value will be 'https'.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param xForwardedProtoEnabled set the xForwardedProtoEnabled.
   */
  public void setXForwardedProtoEnabled(Boolean  xForwardedProtoEnabled) {
    this.xForwardedProtoEnabled = xForwardedProtoEnabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Provide a custom name for the x-forwarded-for header sent to the servers.
   * Default value when not specified in API or module is interpreted by Avi Controller as x-forwarded-for.
   * @return xffAlternateName
   */
  public String getXffAlternateName() {
    return xffAlternateName;
  }

  /**
   * This is the setter method to the attribute.
   * Provide a custom name for the x-forwarded-for header sent to the servers.
   * Default value when not specified in API or module is interpreted by Avi Controller as x-forwarded-for.
   * @param xffAlternateName set the xffAlternateName.
   */
  public void setXffAlternateName(String  xffAlternateName) {
    this.xffAlternateName = xffAlternateName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The client's original ip address is inserted into an http request header sent to the server.
   * Servers may use this address for logging or other purposes, rather than avi's source nat address used in the avi to server ip connection.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return xffEnabled
   */
  public Boolean getXffEnabled() {
    return xffEnabled;
  }

  /**
   * This is the setter method to the attribute.
   * The client's original ip address is inserted into an http request header sent to the server.
   * Servers may use this address for logging or other purposes, rather than avi's source nat address used in the avi to server ip connection.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param xffEnabled set the xffEnabled.
   */
  public void setXffEnabled(Boolean  xffEnabled) {
    this.xffEnabled = xffEnabled;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  HTTPApplicationProfile objHTTPApplicationProfile = (HTTPApplicationProfile) o;
  return   Objects.equals(this.maxKeepaliveRequests, objHTTPApplicationProfile.maxKeepaliveRequests)&&
  Objects.equals(this.enableChunkMerge, objHTTPApplicationProfile.enableChunkMerge)&&
  Objects.equals(this.maxRpsUri, objHTTPApplicationProfile.maxRpsUri)&&
  Objects.equals(this.fwdCloseHdrForBoundConnections, objHTTPApplicationProfile.fwdCloseHdrForBoundConnections)&&
  Objects.equals(this.keepaliveHeader, objHTTPApplicationProfile.keepaliveHeader)&&
  Objects.equals(this.maxRpsCipUri, objHTTPApplicationProfile.maxRpsCipUri)&&
  Objects.equals(this.xForwardedProtoEnabled, objHTTPApplicationProfile.xForwardedProtoEnabled)&&
  Objects.equals(this.connectionMultiplexingEnabled, objHTTPApplicationProfile.connectionMultiplexingEnabled)&&
  Objects.equals(this.websocketsEnabled, objHTTPApplicationProfile.websocketsEnabled)&&
  Objects.equals(this.enableRequestBodyMetrics, objHTTPApplicationProfile.enableRequestBodyMetrics)&&
  Objects.equals(this.maxHttp2EmptyDataFramesPerConnection, objHTTPApplicationProfile.maxHttp2EmptyDataFramesPerConnection)&&
  Objects.equals(this.http2Enabled, objHTTPApplicationProfile.http2Enabled)&&
  Objects.equals(this.enableRequestBodyBuffering, objHTTPApplicationProfile.enableRequestBodyBuffering)&&
  Objects.equals(this.hstsEnabled, objHTTPApplicationProfile.hstsEnabled)&&
  Objects.equals(this.compressionProfile, objHTTPApplicationProfile.compressionProfile)&&
  Objects.equals(this.xffEnabled, objHTTPApplicationProfile.xffEnabled)&&
  Objects.equals(this.resetConnHttpOnSslPort, objHTTPApplicationProfile.resetConnHttpOnSslPort)&&
  Objects.equals(this.disableKeepalivePostsMsie6, objHTTPApplicationProfile.disableKeepalivePostsMsie6)&&
  Objects.equals(this.keepaliveTimeout, objHTTPApplicationProfile.keepaliveTimeout)&&
  Objects.equals(this.sslClientCertificateMode, objHTTPApplicationProfile.sslClientCertificateMode)&&
  Objects.equals(this.httpToHttps, objHTTPApplicationProfile.httpToHttps)&&
  Objects.equals(this.disableSniHostnameCheck, objHTTPApplicationProfile.disableSniHostnameCheck)&&
  Objects.equals(this.spdyEnabled, objHTTPApplicationProfile.spdyEnabled)&&
  Objects.equals(this.respondWith100Continue, objHTTPApplicationProfile.respondWith100Continue)&&
  Objects.equals(this.clientBodyTimeout, objHTTPApplicationProfile.clientBodyTimeout)&&
  Objects.equals(this.pkiProfileRef, objHTTPApplicationProfile.pkiProfileRef)&&
  Objects.equals(this.httponlyEnabled, objHTTPApplicationProfile.httponlyEnabled)&&
  Objects.equals(this.hstsMaxAge, objHTTPApplicationProfile.hstsMaxAge)&&
  Objects.equals(this.sslClientCertificateAction, objHTTPApplicationProfile.sslClientCertificateAction)&&
  Objects.equals(this.serverSideRedirectToHttps, objHTTPApplicationProfile.serverSideRedirectToHttps)&&
  Objects.equals(this.clientMaxHeaderSize, objHTTPApplicationProfile.clientMaxHeaderSize)&&
  Objects.equals(this.clientMaxRequestSize, objHTTPApplicationProfile.clientMaxRequestSize)&&
  Objects.equals(this.maxHttp2ControlFramesPerConnection, objHTTPApplicationProfile.maxHttp2ControlFramesPerConnection)&&
  Objects.equals(this.maxHttp2ConcurrentStreamsPerConnection, objHTTPApplicationProfile.maxHttp2ConcurrentStreamsPerConnection)&&
  Objects.equals(this.cacheConfig, objHTTPApplicationProfile.cacheConfig)&&
  Objects.equals(this.maxRpsUnknownUri, objHTTPApplicationProfile.maxRpsUnknownUri)&&
  Objects.equals(this.sslEverywhereEnabled, objHTTPApplicationProfile.sslEverywhereEnabled)&&
  Objects.equals(this.spdyFwdProxyMode, objHTTPApplicationProfile.spdyFwdProxyMode)&&
  Objects.equals(this.httpUpstreamBufferSize, objHTTPApplicationProfile.httpUpstreamBufferSize)&&
  Objects.equals(this.maxHttp2QueuedFramesToClientPerConnection, objHTTPApplicationProfile.maxHttp2QueuedFramesToClientPerConnection)&&
  Objects.equals(this.maxBadRpsCip, objHTTPApplicationProfile.maxBadRpsCip)&&
  Objects.equals(this.http2Profile, objHTTPApplicationProfile.http2Profile)&&
  Objects.equals(this.allowDotsInHeaderName, objHTTPApplicationProfile.allowDotsInHeaderName)&&
  Objects.equals(this.clientHeaderTimeout, objHTTPApplicationProfile.clientHeaderTimeout)&&
  Objects.equals(this.postAcceptTimeout, objHTTPApplicationProfile.postAcceptTimeout)&&
  Objects.equals(this.secureCookieEnabled, objHTTPApplicationProfile.secureCookieEnabled)&&
  Objects.equals(this.maxResponseHeadersSize, objHTTPApplicationProfile.maxResponseHeadersSize)&&
  Objects.equals(this.xffAlternateName, objHTTPApplicationProfile.xffAlternateName)&&
  Objects.equals(this.maxRpsCip, objHTTPApplicationProfile.maxRpsCip)&&
  Objects.equals(this.clientMaxBodySize, objHTTPApplicationProfile.clientMaxBodySize)&&
  Objects.equals(this.enableFireAndForget, objHTTPApplicationProfile.enableFireAndForget)&&
  Objects.equals(this.maxRpsUnknownCip, objHTTPApplicationProfile.maxRpsUnknownCip)&&
  Objects.equals(this.hstsSubdomainsEnabled, objHTTPApplicationProfile.hstsSubdomainsEnabled)&&
  Objects.equals(this.maxBadRpsCipUri, objHTTPApplicationProfile.maxBadRpsCipUri)&&
  Objects.equals(this.maxBadRpsUri, objHTTPApplicationProfile.maxBadRpsUri)&&
  Objects.equals(this.useAppKeepaliveTimeout, objHTTPApplicationProfile.useAppKeepaliveTimeout);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class HTTPApplicationProfile {\n");
      sb.append("    allowDotsInHeaderName: ").append(toIndentedString(allowDotsInHeaderName)).append("\n");
        sb.append("    cacheConfig: ").append(toIndentedString(cacheConfig)).append("\n");
        sb.append("    clientBodyTimeout: ").append(toIndentedString(clientBodyTimeout)).append("\n");
        sb.append("    clientHeaderTimeout: ").append(toIndentedString(clientHeaderTimeout)).append("\n");
        sb.append("    clientMaxBodySize: ").append(toIndentedString(clientMaxBodySize)).append("\n");
        sb.append("    clientMaxHeaderSize: ").append(toIndentedString(clientMaxHeaderSize)).append("\n");
        sb.append("    clientMaxRequestSize: ").append(toIndentedString(clientMaxRequestSize)).append("\n");
        sb.append("    compressionProfile: ").append(toIndentedString(compressionProfile)).append("\n");
        sb.append("    connectionMultiplexingEnabled: ").append(toIndentedString(connectionMultiplexingEnabled)).append("\n");
        sb.append("    disableKeepalivePostsMsie6: ").append(toIndentedString(disableKeepalivePostsMsie6)).append("\n");
        sb.append("    disableSniHostnameCheck: ").append(toIndentedString(disableSniHostnameCheck)).append("\n");
        sb.append("    enableChunkMerge: ").append(toIndentedString(enableChunkMerge)).append("\n");
        sb.append("    enableFireAndForget: ").append(toIndentedString(enableFireAndForget)).append("\n");
        sb.append("    enableRequestBodyBuffering: ").append(toIndentedString(enableRequestBodyBuffering)).append("\n");
        sb.append("    enableRequestBodyMetrics: ").append(toIndentedString(enableRequestBodyMetrics)).append("\n");
        sb.append("    fwdCloseHdrForBoundConnections: ").append(toIndentedString(fwdCloseHdrForBoundConnections)).append("\n");
        sb.append("    hstsEnabled: ").append(toIndentedString(hstsEnabled)).append("\n");
        sb.append("    hstsMaxAge: ").append(toIndentedString(hstsMaxAge)).append("\n");
        sb.append("    hstsSubdomainsEnabled: ").append(toIndentedString(hstsSubdomainsEnabled)).append("\n");
        sb.append("    http2Enabled: ").append(toIndentedString(http2Enabled)).append("\n");
        sb.append("    http2Profile: ").append(toIndentedString(http2Profile)).append("\n");
        sb.append("    httpToHttps: ").append(toIndentedString(httpToHttps)).append("\n");
        sb.append("    httpUpstreamBufferSize: ").append(toIndentedString(httpUpstreamBufferSize)).append("\n");
        sb.append("    httponlyEnabled: ").append(toIndentedString(httponlyEnabled)).append("\n");
        sb.append("    keepaliveHeader: ").append(toIndentedString(keepaliveHeader)).append("\n");
        sb.append("    keepaliveTimeout: ").append(toIndentedString(keepaliveTimeout)).append("\n");
        sb.append("    maxBadRpsCip: ").append(toIndentedString(maxBadRpsCip)).append("\n");
        sb.append("    maxBadRpsCipUri: ").append(toIndentedString(maxBadRpsCipUri)).append("\n");
        sb.append("    maxBadRpsUri: ").append(toIndentedString(maxBadRpsUri)).append("\n");
        sb.append("    maxHttp2ConcurrentStreamsPerConnection: ").append(toIndentedString(maxHttp2ConcurrentStreamsPerConnection)).append("\n");
        sb.append("    maxHttp2ControlFramesPerConnection: ").append(toIndentedString(maxHttp2ControlFramesPerConnection)).append("\n");
        sb.append("    maxHttp2EmptyDataFramesPerConnection: ").append(toIndentedString(maxHttp2EmptyDataFramesPerConnection)).append("\n");
        sb.append("    maxHttp2QueuedFramesToClientPerConnection: ").append(toIndentedString(maxHttp2QueuedFramesToClientPerConnection)).append("\n");
        sb.append("    maxKeepaliveRequests: ").append(toIndentedString(maxKeepaliveRequests)).append("\n");
        sb.append("    maxResponseHeadersSize: ").append(toIndentedString(maxResponseHeadersSize)).append("\n");
        sb.append("    maxRpsCip: ").append(toIndentedString(maxRpsCip)).append("\n");
        sb.append("    maxRpsCipUri: ").append(toIndentedString(maxRpsCipUri)).append("\n");
        sb.append("    maxRpsUnknownCip: ").append(toIndentedString(maxRpsUnknownCip)).append("\n");
        sb.append("    maxRpsUnknownUri: ").append(toIndentedString(maxRpsUnknownUri)).append("\n");
        sb.append("    maxRpsUri: ").append(toIndentedString(maxRpsUri)).append("\n");
        sb.append("    pkiProfileRef: ").append(toIndentedString(pkiProfileRef)).append("\n");
        sb.append("    postAcceptTimeout: ").append(toIndentedString(postAcceptTimeout)).append("\n");
        sb.append("    resetConnHttpOnSslPort: ").append(toIndentedString(resetConnHttpOnSslPort)).append("\n");
        sb.append("    respondWith100Continue: ").append(toIndentedString(respondWith100Continue)).append("\n");
        sb.append("    secureCookieEnabled: ").append(toIndentedString(secureCookieEnabled)).append("\n");
        sb.append("    serverSideRedirectToHttps: ").append(toIndentedString(serverSideRedirectToHttps)).append("\n");
        sb.append("    spdyEnabled: ").append(toIndentedString(spdyEnabled)).append("\n");
        sb.append("    spdyFwdProxyMode: ").append(toIndentedString(spdyFwdProxyMode)).append("\n");
        sb.append("    sslClientCertificateAction: ").append(toIndentedString(sslClientCertificateAction)).append("\n");
        sb.append("    sslClientCertificateMode: ").append(toIndentedString(sslClientCertificateMode)).append("\n");
        sb.append("    sslEverywhereEnabled: ").append(toIndentedString(sslEverywhereEnabled)).append("\n");
        sb.append("    useAppKeepaliveTimeout: ").append(toIndentedString(useAppKeepaliveTimeout)).append("\n");
        sb.append("    websocketsEnabled: ").append(toIndentedString(websocketsEnabled)).append("\n");
        sb.append("    xForwardedProtoEnabled: ").append(toIndentedString(xForwardedProtoEnabled)).append("\n");
        sb.append("    xffAlternateName: ").append(toIndentedString(xffAlternateName)).append("\n");
        sb.append("    xffEnabled: ").append(toIndentedString(xffEnabled)).append("\n");
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

