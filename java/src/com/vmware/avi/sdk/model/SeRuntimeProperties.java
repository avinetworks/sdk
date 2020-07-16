package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SeRuntimeProperties is a POJO class extends AviRestResource that used for creating
 * SeRuntimeProperties.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeRuntimeProperties  {
    @JsonProperty("admin_ssh_enabled")
    private Boolean adminSshEnabled = true;

    @JsonProperty("app_headers")
    private List<AppHdr> appHeaders = null;

    @JsonProperty("baremetal_dispatcher_handles_flows")
    private Boolean baremetalDispatcherHandlesFlows = false;

    @JsonProperty("connections_lossy_log_rate_limiter_threshold")
    private Integer connectionsLossyLogRateLimiterThreshold = 1000;

    @JsonProperty("connections_udfnf_log_rate_limiter_threshold")
    private Integer connectionsUdfnfLogRateLimiterThreshold = 1000;

    @JsonProperty("disable_flow_probes")
    private Boolean disableFlowProbes = false;

    @JsonProperty("disable_gro")
    private Boolean disableGro = false;

    @JsonProperty("disable_tso")
    private Boolean disableTso = false;

    @JsonProperty("dos_profile")
    private DosThresholdProfile dosProfile = null;

    @JsonProperty("downstream_send_timeout")
    private Integer downstreamSendTimeout = 3600000;

    @JsonProperty("dp_aggressive_hb_frequency")
    private Integer dpAggressiveHbFrequency = 100;

    @JsonProperty("dp_aggressive_hb_timeout_count")
    private Integer dpAggressiveHbTimeoutCount = 10;

    @JsonProperty("dp_hb_frequency")
    private Integer dpHbFrequency = 100;

    @JsonProperty("dp_hb_timeout_count")
    private Integer dpHbTimeoutCount = 10;

    @JsonProperty("dupip_frequency")
    private Integer dupipFrequency = 0;

    @JsonProperty("dupip_timeout_count")
    private Integer dupipTimeoutCount = 5;

    @JsonProperty("enable_hsm_log")
    private Boolean enableHsmLog = false;

    @JsonProperty("feproxy_vips_enable_proxy_arp")
    private Boolean feproxyVipsEnableProxyArp = true;

    @JsonProperty("flow_table_batch_push_frequency")
    private Integer flowTableBatchPushFrequency = 5;

    @JsonProperty("flow_table_max_entries_deprecated")
    private Integer flowTableMaxEntriesDeprecated = 100000000;

    @JsonProperty("flow_table_new_syn_max_entries")
    private Integer flowTableNewSynMaxEntries = 40000;

    @JsonProperty("global_mtu")
    private Integer globalMtu = 0;

    @JsonProperty("http_rum_console_log")
    private Boolean httpRumConsoleLog = false;

    @JsonProperty("http_rum_min_content_length")
    private Integer httpRumMinContentLength = 64;

    @JsonProperty("lb_batch_push_frequency")
    private Integer lbBatchPushFrequency = 5;

    @JsonProperty("lb_fail_max_time")
    private Integer lbFailMaxTime = 5;

    @JsonProperty("lbaction_num_requests_to_dispatch")
    private Integer lbactionNumRequestsToDispatch = 4;

    @JsonProperty("lbaction_rq_per_request_max_retries")
    private Integer lbactionRqPerRequestMaxRetries = 22;

    @JsonProperty("log_agent_compress_logs")
    private Boolean logAgentCompressLogs = true;

    @JsonProperty("log_agent_conn_send_buffer_size")
    private Integer logAgentConnSendBufferSize = 16384;

    @JsonProperty("log_agent_export_msg_buffer_size")
    private Integer logAgentExportMsgBufferSize = 524288;

    @JsonProperty("log_agent_export_wait_time")
    private Integer logAgentExportWaitTime = 100;

    @JsonProperty("log_agent_file_sz_appl")
    private Integer logAgentFileSzAppl = 4;

    @JsonProperty("log_agent_file_sz_conn")
    private Integer logAgentFileSzConn = 4;

    @JsonProperty("log_agent_file_sz_debug")
    private Integer logAgentFileSzDebug = 4;

    @JsonProperty("log_agent_file_sz_event")
    private Integer logAgentFileSzEvent = 4;

    @JsonProperty("log_agent_log_storage_min_sz")
    private Integer logAgentLogStorageMinSz = 1024;

    @JsonProperty("log_agent_max_active_adf_files_per_vs")
    private Integer logAgentMaxActiveAdfFilesPerVs = 100;

    @JsonProperty("log_agent_max_concurrent_rsync")
    private Integer logAgentMaxConcurrentRsync = 1024;

    @JsonProperty("log_agent_max_logmessage_proto_sz")
    private Integer logAgentMaxLogmessageProtoSz = 65536;

    @JsonProperty("log_agent_max_storage_excess_percent")
    private Integer logAgentMaxStorageExcessPercent = 110;

    @JsonProperty("log_agent_max_storage_ignore_percent")
    private float logAgentMaxStorageIgnorePercent = 20.0f;

    @JsonProperty("log_agent_min_storage_per_vs")
    private Integer logAgentMinStoragePerVs = 10;

    @JsonProperty("log_agent_pause_interval")
    private Integer logAgentPauseInterval = 0;

    @JsonProperty("log_agent_sleep_interval")
    private Integer logAgentSleepInterval = 10;

    @JsonProperty("log_agent_unknown_vs_timer")
    private Integer logAgentUnknownVsTimer = 1800;

    @JsonProperty("log_message_max_file_list_size")
    private Integer logMessageMaxFileListSize = 64;

    @JsonProperty("max_throughput")
    private Integer maxThroughput = 10000;

    @JsonProperty("mcache_enabled")
    private Boolean mcacheEnabled = null;

    @JsonProperty("mcache_fetch_enabled")
    private Boolean mcacheFetchEnabled = null;

    @JsonProperty("mcache_max_cache_size")
    private Integer mcacheMaxCacheSize = null;

    @JsonProperty("mcache_store_in_enabled")
    private Boolean mcacheStoreInEnabled = null;

    @JsonProperty("mcache_store_in_max_size")
    private Integer mcacheStoreInMaxSize = null;

    @JsonProperty("mcache_store_in_min_size")
    private Integer mcacheStoreInMinSize = null;

    @JsonProperty("mcache_store_out_enabled")
    private Boolean mcacheStoreOutEnabled = null;

    @JsonProperty("mcache_store_se_max_size")
    private Integer mcacheStoreSeMaxSize = null;

    @JsonProperty("ngx_free_connection_stack")
    private Boolean ngxFreeConnectionStack = false;

    @JsonProperty("persistence_entries_low_watermark")
    private Integer persistenceEntriesLowWatermark = 20000;

    @JsonProperty("persistence_mem_max")
    private Integer persistenceMemMax = 0;

    @JsonProperty("scaleout_udp_per_pkt")
    private Boolean scaleoutUdpPerPkt = true;

    @JsonProperty("se_auth_ldap_bind_timeout")
    private Integer seAuthLdapBindTimeout = 5000;

    @JsonProperty("se_auth_ldap_cache_size")
    private Integer seAuthLdapCacheSize = 100000;

    @JsonProperty("se_auth_ldap_connect_timeout")
    private Integer seAuthLdapConnectTimeout = 10000;

    @JsonProperty("se_auth_ldap_conns_per_server")
    private Integer seAuthLdapConnsPerServer = 1;

    @JsonProperty("se_auth_ldap_reconnect_timeout")
    private Integer seAuthLdapReconnectTimeout = 10000;

    @JsonProperty("se_auth_ldap_request_timeout")
    private Integer seAuthLdapRequestTimeout = 10000;

    @JsonProperty("se_auth_ldap_servers_failover_only")
    private Boolean seAuthLdapServersFailoverOnly = false;

    @JsonProperty("se_dp_compression")
    private SeRuntimeCompressionProperties seDpCompression = null;

    @JsonProperty("se_dp_hm_drops")
    private Integer seDpHmDrops = 0;

    @JsonProperty("se_dp_if_state_poll_interval")
    private Integer seDpIfStatePollInterval = 10;

    @JsonProperty("se_dp_log_nf_enqueue_percent")
    private Integer seDpLogNfEnqueuePercent = 70;

    @JsonProperty("se_dp_log_udf_enqueue_percent")
    private Integer seDpLogUdfEnqueuePercent = 90;

    @JsonProperty("se_dp_vnic_queue_stall_event_sleep")
    private Integer seDpVnicQueueStallEventSleep = null;

    @JsonProperty("se_dp_vnic_queue_stall_threshold")
    private Integer seDpVnicQueueStallThreshold = null;

    @JsonProperty("se_dp_vnic_queue_stall_timeout")
    private Integer seDpVnicQueueStallTimeout = null;

    @JsonProperty("se_dp_vnic_restart_on_queue_stall_count")
    private Integer seDpVnicRestartOnQueueStallCount = null;

    @JsonProperty("se_dp_vnic_stall_se_restart_window")
    private Integer seDpVnicStallSeRestartWindow = null;

    @JsonProperty("se_dump_core_on_assert")
    private Boolean seDumpCoreOnAssert = false;

    @JsonProperty("se_handle_interface_routes")
    private Boolean seHandleInterfaceRoutes = false;

    @JsonProperty("se_hb_persist_fudge_bits")
    private Integer seHbPersistFudgeBits = 3;

    @JsonProperty("se_mac_error_threshold_to_disable_promiscious")
    private Integer seMacErrorThresholdToDisablePromiscious = 1000;

    @JsonProperty("se_malloc_thresh")
    private Integer seMallocThresh = 0;

    @JsonProperty("se_memory_poison")
    private Boolean seMemoryPoison = true;

    @JsonProperty("se_metrics_interval")
    private Integer seMetricsInterval = 60000;

    @JsonProperty("se_metrics_rt_enabled")
    private Boolean seMetricsRtEnabled = true;

    @JsonProperty("se_metrics_rt_interval")
    private Integer seMetricsRtInterval = 1000;

    @JsonProperty("se_packet_buffer_max")
    private Integer sePacketBufferMax = 0;

    @JsonProperty("se_random_tcp_drops")
    private Boolean seRandomTcpDrops = false;

    @JsonProperty("se_rate_limiters")
    private SeRateLimiters seRateLimiters = null;

    @JsonProperty("service_ip_subnets")
    private List<IpAddrPrefix> serviceIpSubnets = null;

    @JsonProperty("service_port_ranges")
    private List<PortRange> servicePortRanges = null;

    @JsonProperty("services_accessible_all_interfaces")
    private Boolean servicesAccessibleAllInterfaces = false;

    @JsonProperty("spdy_fwd_proxy_parse_enable")
    private Boolean spdyFwdProxyParseEnable = true;

    @JsonProperty("tcp_syn_cache_max")
    private Integer tcpSynCacheMax = 32768;

    @JsonProperty("tcp_syncache_max_retransmit_default")
    private Integer tcpSyncacheMaxRetransmitDefault = 4;

    @JsonProperty("upstream_connect_timeout")
    private Integer upstreamConnectTimeout = 3600000;

    @JsonProperty("upstream_connpool_cache_thresh")
    private Integer upstreamConnpoolCacheThresh = -1;

    @JsonProperty("upstream_connpool_conn_idle_thresh_tmo")
    private Integer upstreamConnpoolConnIdleThreshTmo = -1;

    @JsonProperty("upstream_connpool_conn_idle_tmo")
    private Integer upstreamConnpoolConnIdleTmo = null;

    @JsonProperty("upstream_connpool_conn_life_tmo")
    private Integer upstreamConnpoolConnLifeTmo = null;

    @JsonProperty("upstream_connpool_conn_max_reuse")
    private Integer upstreamConnpoolConnMaxReuse = null;

    @JsonProperty("upstream_connpool_core_max_cache")
    private Integer upstreamConnpoolCoreMaxCache = -1;

    @JsonProperty("upstream_connpool_enable")
    private Boolean upstreamConnpoolEnable = true;

    @JsonProperty("upstream_connpool_server_max_cache")
    private Integer upstreamConnpoolServerMaxCache = null;

    @JsonProperty("upstream_connpool_strategy")
    private Integer upstreamConnpoolStrategy = -1;

    @JsonProperty("upstream_keepalive")
    private Boolean upstreamKeepalive = false;

    @JsonProperty("upstream_read_timeout")
    private Integer upstreamReadTimeout = 3600000;

    @JsonProperty("upstream_send_timeout")
    private Integer upstreamSendTimeout = 3600000;

    @JsonProperty("user_defined_metric_age")
    private Integer userDefinedMetricAge = 60;



  /**
   * This is the getter method this will return the attribute value.
   * Allow admin user ssh access to se.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return adminSshEnabled
   */
  public Boolean getAdminSshEnabled() {
    return adminSshEnabled;
  }

  /**
   * This is the setter method to the attribute.
   * Allow admin user ssh access to se.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param adminSshEnabled set the adminSshEnabled.
   */
  public void setAdminSshEnabled(Boolean  adminSshEnabled) {
    this.adminSshEnabled = adminSshEnabled;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property app_headers of obj type seruntimeproperties field type str  type array.
   * @return appHeaders
   */
  public List<AppHdr> getAppHeaders() {
    return appHeaders;
  }

  /**
   * This is the setter method. this will set the appHeaders
   * Placeholder for description of property app_headers of obj type seruntimeproperties field type str  type array.
   * @return appHeaders
   */
  public void setAppHeaders(List<AppHdr>  appHeaders) {
    this.appHeaders = appHeaders;
  }

  /**
   * This is the setter method this will set the appHeaders
   * Placeholder for description of property app_headers of obj type seruntimeproperties field type str  type array.
   * @return appHeaders
   */
  public SeRuntimeProperties addAppHeadersItem(AppHdr appHeadersItem) {
    if (this.appHeaders == null) {
      this.appHeaders = new ArrayList<AppHdr>();
    }
    this.appHeaders.add(appHeadersItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Control if dispatcher core also handles tcp flows in baremetal se.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return baremetalDispatcherHandlesFlows
   */
  public Boolean getBaremetalDispatcherHandlesFlows() {
    return baremetalDispatcherHandlesFlows;
  }

  /**
   * This is the setter method to the attribute.
   * Control if dispatcher core also handles tcp flows in baremetal se.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param baremetalDispatcherHandlesFlows set the baremetalDispatcherHandlesFlows.
   */
  public void setBaremetalDispatcherHandlesFlows(Boolean  baremetalDispatcherHandlesFlows) {
    this.baremetalDispatcherHandlesFlows = baremetalDispatcherHandlesFlows;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Rate limit on maximum adf lossy log to pushper second.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1000.
   * @return connectionsLossyLogRateLimiterThreshold
   */
  public Integer getConnectionsLossyLogRateLimiterThreshold() {
    return connectionsLossyLogRateLimiterThreshold;
  }

  /**
   * This is the setter method to the attribute.
   * Rate limit on maximum adf lossy log to pushper second.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1000.
   * @param connectionsLossyLogRateLimiterThreshold set the connectionsLossyLogRateLimiterThreshold.
   */
  public void setConnectionsLossyLogRateLimiterThreshold(Integer  connectionsLossyLogRateLimiterThreshold) {
    this.connectionsLossyLogRateLimiterThreshold = connectionsLossyLogRateLimiterThreshold;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Rate limit on maximum adf udf or nf log to pushper second.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1000.
   * @return connectionsUdfnfLogRateLimiterThreshold
   */
  public Integer getConnectionsUdfnfLogRateLimiterThreshold() {
    return connectionsUdfnfLogRateLimiterThreshold;
  }

  /**
   * This is the setter method to the attribute.
   * Rate limit on maximum adf udf or nf log to pushper second.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1000.
   * @param connectionsUdfnfLogRateLimiterThreshold set the connectionsUdfnfLogRateLimiterThreshold.
   */
  public void setConnectionsUdfnfLogRateLimiterThreshold(Integer  connectionsUdfnfLogRateLimiterThreshold) {
    this.connectionsUdfnfLogRateLimiterThreshold = connectionsUdfnfLogRateLimiterThreshold;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Disable flow probes for scaled out vs'es.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return disableFlowProbes
   */
  public Boolean getDisableFlowProbes() {
    return disableFlowProbes;
  }

  /**
   * This is the setter method to the attribute.
   * Disable flow probes for scaled out vs'es.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param disableFlowProbes set the disableFlowProbes.
   */
  public void setDisableFlowProbes(Boolean  disableFlowProbes) {
    this.disableFlowProbes = disableFlowProbes;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Deprecated.
   * Field deprecated in 17.2.5.
   * Field introduced in 17.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return disableGro
   */
  public Boolean getDisableGro() {
    return disableGro;
  }

  /**
   * This is the setter method to the attribute.
   * Deprecated.
   * Field deprecated in 17.2.5.
   * Field introduced in 17.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param disableGro set the disableGro.
   */
  public void setDisableGro(Boolean  disableGro) {
    this.disableGro = disableGro;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Deprecated.
   * Field deprecated in 17.2.5.
   * Field introduced in 17.2.4.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return disableTso
   */
  public Boolean getDisableTso() {
    return disableTso;
  }

  /**
   * This is the setter method to the attribute.
   * Deprecated.
   * Field deprecated in 17.2.5.
   * Field introduced in 17.2.4.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param disableTso set the disableTso.
   */
  public void setDisableTso(Boolean  disableTso) {
    this.disableTso = disableTso;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property dos_profile of obj type seruntimeproperties field type str  type ref.
   * @return dosProfile
   */
  public DosThresholdProfile getDosProfile() {
    return dosProfile;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property dos_profile of obj type seruntimeproperties field type str  type ref.
   * @param dosProfile set the dosProfile.
   */
  public void setDosProfile(DosThresholdProfile dosProfile) {
    this.dosProfile = dosProfile;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Timeout for downstream to become writable.
   * Default value when not specified in API or module is interpreted by Avi Controller as 3600000.
   * @return downstreamSendTimeout
   */
  public Integer getDownstreamSendTimeout() {
    return downstreamSendTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * Timeout for downstream to become writable.
   * Default value when not specified in API or module is interpreted by Avi Controller as 3600000.
   * @param downstreamSendTimeout set the downstreamSendTimeout.
   */
  public void setDownstreamSendTimeout(Integer  downstreamSendTimeout) {
    this.downstreamSendTimeout = downstreamSendTimeout;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Frequency of se - se hb messages when aggressive failure mode detection is enabled.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100.
   * @return dpAggressiveHbFrequency
   */
  public Integer getDpAggressiveHbFrequency() {
    return dpAggressiveHbFrequency;
  }

  /**
   * This is the setter method to the attribute.
   * Frequency of se - se hb messages when aggressive failure mode detection is enabled.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100.
   * @param dpAggressiveHbFrequency set the dpAggressiveHbFrequency.
   */
  public void setDpAggressiveHbFrequency(Integer  dpAggressiveHbFrequency) {
    this.dpAggressiveHbFrequency = dpAggressiveHbFrequency;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Consecutive hb failures after which failure is reported to controller,when aggressive failure mode detection is enabled.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.
   * @return dpAggressiveHbTimeoutCount
   */
  public Integer getDpAggressiveHbTimeoutCount() {
    return dpAggressiveHbTimeoutCount;
  }

  /**
   * This is the setter method to the attribute.
   * Consecutive hb failures after which failure is reported to controller,when aggressive failure mode detection is enabled.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.
   * @param dpAggressiveHbTimeoutCount set the dpAggressiveHbTimeoutCount.
   */
  public void setDpAggressiveHbTimeoutCount(Integer  dpAggressiveHbTimeoutCount) {
    this.dpAggressiveHbTimeoutCount = dpAggressiveHbTimeoutCount;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Frequency of se - se hb messages when aggressive failure mode detection is not enabled.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100.
   * @return dpHbFrequency
   */
  public Integer getDpHbFrequency() {
    return dpHbFrequency;
  }

  /**
   * This is the setter method to the attribute.
   * Frequency of se - se hb messages when aggressive failure mode detection is not enabled.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100.
   * @param dpHbFrequency set the dpHbFrequency.
   */
  public void setDpHbFrequency(Integer  dpHbFrequency) {
    this.dpHbFrequency = dpHbFrequency;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Consecutive hb failures after which failure is reported to controller, when aggressive failure mode detection is not enabled.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.
   * @return dpHbTimeoutCount
   */
  public Integer getDpHbTimeoutCount() {
    return dpHbTimeoutCount;
  }

  /**
   * This is the setter method to the attribute.
   * Consecutive hb failures after which failure is reported to controller, when aggressive failure mode detection is not enabled.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.
   * @param dpHbTimeoutCount set the dpHbTimeoutCount.
   */
  public void setDpHbTimeoutCount(Integer  dpHbTimeoutCount) {
    this.dpHbTimeoutCount = dpHbTimeoutCount;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Frequency of arp requests sent by se for each vip to detect duplicate ip when it loses conectivity to controller.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return dupipFrequency
   */
  public Integer getDupipFrequency() {
    return dupipFrequency;
  }

  /**
   * This is the setter method to the attribute.
   * Frequency of arp requests sent by se for each vip to detect duplicate ip when it loses conectivity to controller.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param dupipFrequency set the dupipFrequency.
   */
  public void setDupipFrequency(Integer  dupipFrequency) {
    this.dupipFrequency = dupipFrequency;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Number of arp responses received for the vip after which se decides that the vip has been moved and disables the vip.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5.
   * @return dupipTimeoutCount
   */
  public Integer getDupipTimeoutCount() {
    return dupipTimeoutCount;
  }

  /**
   * This is the setter method to the attribute.
   * Number of arp responses received for the vip after which se decides that the vip has been moved and disables the vip.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5.
   * @param dupipTimeoutCount set the dupipTimeoutCount.
   */
  public void setDupipTimeoutCount(Integer  dupipTimeoutCount) {
    this.dupipTimeoutCount = dupipTimeoutCount;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable hsm luna engine logs.
   * Field introduced in 16.4.8, 17.1.11, 17.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return enableHsmLog
   */
  public Boolean getEnableHsmLog() {
    return enableHsmLog;
  }

  /**
   * This is the setter method to the attribute.
   * Enable hsm luna engine logs.
   * Field introduced in 16.4.8, 17.1.11, 17.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param enableHsmLog set the enableHsmLog.
   */
  public void setEnableHsmLog(Boolean  enableHsmLog) {
    this.enableHsmLog = enableHsmLog;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable proxy arp from host interface for front end  proxies.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return feproxyVipsEnableProxyArp
   */
  public Boolean getFeproxyVipsEnableProxyArp() {
    return feproxyVipsEnableProxyArp;
  }

  /**
   * This is the setter method to the attribute.
   * Enable proxy arp from host interface for front end  proxies.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param feproxyVipsEnableProxyArp set the feproxyVipsEnableProxyArp.
   */
  public void setFeproxyVipsEnableProxyArp(Boolean  feproxyVipsEnableProxyArp) {
    this.feproxyVipsEnableProxyArp = feproxyVipsEnableProxyArp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * How often to push the flow table ipc messages in the main loop.
   * The value is the number of times through the loop before pushing the batch.
   * I.e, a value of 1 means every time through the loop.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5.
   * @return flowTableBatchPushFrequency
   */
  public Integer getFlowTableBatchPushFrequency() {
    return flowTableBatchPushFrequency;
  }

  /**
   * This is the setter method to the attribute.
   * How often to push the flow table ipc messages in the main loop.
   * The value is the number of times through the loop before pushing the batch.
   * I.e, a value of 1 means every time through the loop.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5.
   * @param flowTableBatchPushFrequency set the flowTableBatchPushFrequency.
   */
  public void setFlowTableBatchPushFrequency(Integer  flowTableBatchPushFrequency) {
    this.flowTableBatchPushFrequency = flowTableBatchPushFrequency;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Deprecated.
   * Field deprecated in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100000000.
   * @return flowTableMaxEntriesDeprecated
   */
  public Integer getFlowTableMaxEntriesDeprecated() {
    return flowTableMaxEntriesDeprecated;
  }

  /**
   * This is the setter method to the attribute.
   * Deprecated.
   * Field deprecated in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100000000.
   * @param flowTableMaxEntriesDeprecated set the flowTableMaxEntriesDeprecated.
   */
  public void setFlowTableMaxEntriesDeprecated(Integer  flowTableMaxEntriesDeprecated) {
    this.flowTableMaxEntriesDeprecated = flowTableMaxEntriesDeprecated;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Deprecated.
   * Field deprecated in 17.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 40000.
   * @return flowTableNewSynMaxEntries
   */
  public Integer getFlowTableNewSynMaxEntries() {
    return flowTableNewSynMaxEntries;
  }

  /**
   * This is the setter method to the attribute.
   * Deprecated.
   * Field deprecated in 17.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 40000.
   * @param flowTableNewSynMaxEntries set the flowTableNewSynMaxEntries.
   */
  public void setFlowTableNewSynMaxEntries(Integer  flowTableNewSynMaxEntries) {
    this.flowTableNewSynMaxEntries = flowTableNewSynMaxEntries;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Overrides the mtu value received via dhcp or some other means.
   * Use this when the infrastructure advertises an mtu that is not supported by all devices in the network.
   * For example, in aws or when an overlay is used.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return globalMtu
   */
  public Integer getGlobalMtu() {
    return globalMtu;
  }

  /**
   * This is the setter method to the attribute.
   * Overrides the mtu value received via dhcp or some other means.
   * Use this when the infrastructure advertises an mtu that is not supported by all devices in the network.
   * For example, in aws or when an overlay is used.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param globalMtu set the globalMtu.
   */
  public void setGlobalMtu(Integer  globalMtu) {
    this.globalMtu = globalMtu;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable javascript console logs on the client browser when collecting client insights.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return httpRumConsoleLog
   */
  public Boolean getHttpRumConsoleLog() {
    return httpRumConsoleLog;
  }

  /**
   * This is the setter method to the attribute.
   * Enable javascript console logs on the client browser when collecting client insights.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param httpRumConsoleLog set the httpRumConsoleLog.
   */
  public void setHttpRumConsoleLog(Boolean  httpRumConsoleLog) {
    this.httpRumConsoleLog = httpRumConsoleLog;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Minimum response size content length to sample for client insights.
   * Default value when not specified in API or module is interpreted by Avi Controller as 64.
   * @return httpRumMinContentLength
   */
  public Integer getHttpRumMinContentLength() {
    return httpRumMinContentLength;
  }

  /**
   * This is the setter method to the attribute.
   * Minimum response size content length to sample for client insights.
   * Default value when not specified in API or module is interpreted by Avi Controller as 64.
   * @param httpRumMinContentLength set the httpRumMinContentLength.
   */
  public void setHttpRumMinContentLength(Integer  httpRumMinContentLength) {
    this.httpRumMinContentLength = httpRumMinContentLength;
  }

  /**
   * This is the getter method this will return the attribute value.
   * How often to push the lb ipc messages in the main loop.
   * The value is the number of times the loop has to run before pushing the batch.
   * I.e, a value of 1 means the batch is pushed every time the loop runs.
   * Field deprecated in 18.1.3.
   * Field introduced in 17.2.8.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5.
   * @return lbBatchPushFrequency
   */
  public Integer getLbBatchPushFrequency() {
    return lbBatchPushFrequency;
  }

  /**
   * This is the setter method to the attribute.
   * How often to push the lb ipc messages in the main loop.
   * The value is the number of times the loop has to run before pushing the batch.
   * I.e, a value of 1 means the batch is pushed every time the loop runs.
   * Field deprecated in 18.1.3.
   * Field introduced in 17.2.8.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5.
   * @param lbBatchPushFrequency set the lbBatchPushFrequency.
   */
  public void setLbBatchPushFrequency(Integer  lbBatchPushFrequency) {
    this.lbBatchPushFrequency = lbBatchPushFrequency;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Deprecated.
   * Field deprecated in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5.
   * @return lbFailMaxTime
   */
  public Integer getLbFailMaxTime() {
    return lbFailMaxTime;
  }

  /**
   * This is the setter method to the attribute.
   * Deprecated.
   * Field deprecated in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5.
   * @param lbFailMaxTime set the lbFailMaxTime.
   */
  public void setLbFailMaxTime(Integer  lbFailMaxTime) {
    this.lbFailMaxTime = lbFailMaxTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Number of requests to dispatch from the request queue at a regular interval.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4.
   * @return lbactionNumRequestsToDispatch
   */
  public Integer getLbactionNumRequestsToDispatch() {
    return lbactionNumRequestsToDispatch;
  }

  /**
   * This is the setter method to the attribute.
   * Number of requests to dispatch from the request queue at a regular interval.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4.
   * @param lbactionNumRequestsToDispatch set the lbactionNumRequestsToDispatch.
   */
  public void setLbactionNumRequestsToDispatch(Integer  lbactionNumRequestsToDispatch) {
    this.lbactionNumRequestsToDispatch = lbactionNumRequestsToDispatch;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum retries per request in the request queue.
   * Default value when not specified in API or module is interpreted by Avi Controller as 22.
   * @return lbactionRqPerRequestMaxRetries
   */
  public Integer getLbactionRqPerRequestMaxRetries() {
    return lbactionRqPerRequestMaxRetries;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum retries per request in the request queue.
   * Default value when not specified in API or module is interpreted by Avi Controller as 22.
   * @param lbactionRqPerRequestMaxRetries set the lbactionRqPerRequestMaxRetries.
   */
  public void setLbactionRqPerRequestMaxRetries(Integer  lbactionRqPerRequestMaxRetries) {
    this.lbactionRqPerRequestMaxRetries = lbactionRqPerRequestMaxRetries;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Flag to indicate if log files are compressed upon full on the service engine.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return logAgentCompressLogs
   */
  public Boolean getLogAgentCompressLogs() {
    return logAgentCompressLogs;
  }

  /**
   * This is the setter method to the attribute.
   * Flag to indicate if log files are compressed upon full on the service engine.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param logAgentCompressLogs set the logAgentCompressLogs.
   */
  public void setLogAgentCompressLogs(Boolean  logAgentCompressLogs) {
    this.logAgentCompressLogs = logAgentCompressLogs;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Log-agent test property used to simulate slow tcp connections.
   * Default value when not specified in API or module is interpreted by Avi Controller as 16384.
   * @return logAgentConnSendBufferSize
   */
  public Integer getLogAgentConnSendBufferSize() {
    return logAgentConnSendBufferSize;
  }

  /**
   * This is the setter method to the attribute.
   * Log-agent test property used to simulate slow tcp connections.
   * Default value when not specified in API or module is interpreted by Avi Controller as 16384.
   * @param logAgentConnSendBufferSize set the logAgentConnSendBufferSize.
   */
  public void setLogAgentConnSendBufferSize(Integer  logAgentConnSendBufferSize) {
    this.logAgentConnSendBufferSize = logAgentConnSendBufferSize;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum size of data sent by log-agent to controller over the tcp connection.
   * Default value when not specified in API or module is interpreted by Avi Controller as 524288.
   * @return logAgentExportMsgBufferSize
   */
  public Integer getLogAgentExportMsgBufferSize() {
    return logAgentExportMsgBufferSize;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum size of data sent by log-agent to controller over the tcp connection.
   * Default value when not specified in API or module is interpreted by Avi Controller as 524288.
   * @param logAgentExportMsgBufferSize set the logAgentExportMsgBufferSize.
   */
  public void setLogAgentExportMsgBufferSize(Integer  logAgentExportMsgBufferSize) {
    this.logAgentExportMsgBufferSize = logAgentExportMsgBufferSize;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Time log-agent waits before sending data to the controller.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100.
   * @return logAgentExportWaitTime
   */
  public Integer getLogAgentExportWaitTime() {
    return logAgentExportWaitTime;
  }

  /**
   * This is the setter method to the attribute.
   * Time log-agent waits before sending data to the controller.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100.
   * @param logAgentExportWaitTime set the logAgentExportWaitTime.
   */
  public void setLogAgentExportWaitTime(Integer  logAgentExportWaitTime) {
    this.logAgentExportWaitTime = logAgentExportWaitTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum application log file size before rollover.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4.
   * @return logAgentFileSzAppl
   */
  public Integer getLogAgentFileSzAppl() {
    return logAgentFileSzAppl;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum application log file size before rollover.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4.
   * @param logAgentFileSzAppl set the logAgentFileSzAppl.
   */
  public void setLogAgentFileSzAppl(Integer  logAgentFileSzAppl) {
    this.logAgentFileSzAppl = logAgentFileSzAppl;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum connection log file size before rollover.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4.
   * @return logAgentFileSzConn
   */
  public Integer getLogAgentFileSzConn() {
    return logAgentFileSzConn;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum connection log file size before rollover.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4.
   * @param logAgentFileSzConn set the logAgentFileSzConn.
   */
  public void setLogAgentFileSzConn(Integer  logAgentFileSzConn) {
    this.logAgentFileSzConn = logAgentFileSzConn;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum debug log file size before rollover.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4.
   * @return logAgentFileSzDebug
   */
  public Integer getLogAgentFileSzDebug() {
    return logAgentFileSzDebug;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum debug log file size before rollover.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4.
   * @param logAgentFileSzDebug set the logAgentFileSzDebug.
   */
  public void setLogAgentFileSzDebug(Integer  logAgentFileSzDebug) {
    this.logAgentFileSzDebug = logAgentFileSzDebug;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum event log file size before rollover.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4.
   * @return logAgentFileSzEvent
   */
  public Integer getLogAgentFileSzEvent() {
    return logAgentFileSzEvent;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum event log file size before rollover.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4.
   * @param logAgentFileSzEvent set the logAgentFileSzEvent.
   */
  public void setLogAgentFileSzEvent(Integer  logAgentFileSzEvent) {
    this.logAgentFileSzEvent = logAgentFileSzEvent;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Minimum storage allocated for logs irrespective of memory and cores.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1024.
   * @return logAgentLogStorageMinSz
   */
  public Integer getLogAgentLogStorageMinSz() {
    return logAgentLogStorageMinSz;
  }

  /**
   * This is the setter method to the attribute.
   * Minimum storage allocated for logs irrespective of memory and cores.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1024.
   * @param logAgentLogStorageMinSz set the logAgentLogStorageMinSz.
   */
  public void setLogAgentLogStorageMinSz(Integer  logAgentLogStorageMinSz) {
    this.logAgentLogStorageMinSz = logAgentLogStorageMinSz;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of virtual service log files maintained for significant logs on the service engine.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100.
   * @return logAgentMaxActiveAdfFilesPerVs
   */
  public Integer getLogAgentMaxActiveAdfFilesPerVs() {
    return logAgentMaxActiveAdfFilesPerVs;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of virtual service log files maintained for significant logs on the service engine.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100.
   * @param logAgentMaxActiveAdfFilesPerVs set the logAgentMaxActiveAdfFilesPerVs.
   */
  public void setLogAgentMaxActiveAdfFilesPerVs(Integer  logAgentMaxActiveAdfFilesPerVs) {
    this.logAgentMaxActiveAdfFilesPerVs = logAgentMaxActiveAdfFilesPerVs;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum concurrent rsync requests initiated from log-agent to the controller.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1024.
   * @return logAgentMaxConcurrentRsync
   */
  public Integer getLogAgentMaxConcurrentRsync() {
    return logAgentMaxConcurrentRsync;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum concurrent rsync requests initiated from log-agent to the controller.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1024.
   * @param logAgentMaxConcurrentRsync set the logAgentMaxConcurrentRsync.
   */
  public void setLogAgentMaxConcurrentRsync(Integer  logAgentMaxConcurrentRsync) {
    this.logAgentMaxConcurrentRsync = logAgentMaxConcurrentRsync;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum size of serialized log message on the service engine.
   * Default value when not specified in API or module is interpreted by Avi Controller as 65536.
   * @return logAgentMaxLogmessageProtoSz
   */
  public Integer getLogAgentMaxLogmessageProtoSz() {
    return logAgentMaxLogmessageProtoSz;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum size of serialized log message on the service engine.
   * Default value when not specified in API or module is interpreted by Avi Controller as 65536.
   * @param logAgentMaxLogmessageProtoSz set the logAgentMaxLogmessageProtoSz.
   */
  public void setLogAgentMaxLogmessageProtoSz(Integer  logAgentMaxLogmessageProtoSz) {
    this.logAgentMaxLogmessageProtoSz = logAgentMaxLogmessageProtoSz;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Excess percentage threshold of disk size to trigger cleanup of logs on the service engine.
   * Default value when not specified in API or module is interpreted by Avi Controller as 110.
   * @return logAgentMaxStorageExcessPercent
   */
  public Integer getLogAgentMaxStorageExcessPercent() {
    return logAgentMaxStorageExcessPercent;
  }

  /**
   * This is the setter method to the attribute.
   * Excess percentage threshold of disk size to trigger cleanup of logs on the service engine.
   * Default value when not specified in API or module is interpreted by Avi Controller as 110.
   * @param logAgentMaxStorageExcessPercent set the logAgentMaxStorageExcessPercent.
   */
  public void setLogAgentMaxStorageExcessPercent(Integer  logAgentMaxStorageExcessPercent) {
    this.logAgentMaxStorageExcessPercent = logAgentMaxStorageExcessPercent;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum storage on the disk not allocated for logs on the service engine.
   * Default value when not specified in API or module is interpreted by Avi Controller as 20.0.
   * @return logAgentMaxStorageIgnorePercent
   */
  public Float getLogAgentMaxStorageIgnorePercent() {
    return logAgentMaxStorageIgnorePercent;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum storage on the disk not allocated for logs on the service engine.
   * Default value when not specified in API or module is interpreted by Avi Controller as 20.0.
   * @param logAgentMaxStorageIgnorePercent set the logAgentMaxStorageIgnorePercent.
   */
  public void setLogAgentMaxStorageIgnorePercent(Float  logAgentMaxStorageIgnorePercent) {
    this.logAgentMaxStorageIgnorePercent = logAgentMaxStorageIgnorePercent;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Minimum storage allocated to any given virtualservice on the service engine.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.
   * @return logAgentMinStoragePerVs
   */
  public Integer getLogAgentMinStoragePerVs() {
    return logAgentMinStoragePerVs;
  }

  /**
   * This is the setter method to the attribute.
   * Minimum storage allocated to any given virtualservice on the service engine.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.
   * @param logAgentMinStoragePerVs set the logAgentMinStoragePerVs.
   */
  public void setLogAgentMinStoragePerVs(Integer  logAgentMinStoragePerVs) {
    this.logAgentMinStoragePerVs = logAgentMinStoragePerVs;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Time interval log-agent pauses between logs obtained from the dataplane.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return logAgentPauseInterval
   */
  public Integer getLogAgentPauseInterval() {
    return logAgentPauseInterval;
  }

  /**
   * This is the setter method to the attribute.
   * Time interval log-agent pauses between logs obtained from the dataplane.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param logAgentPauseInterval set the logAgentPauseInterval.
   */
  public void setLogAgentPauseInterval(Integer  logAgentPauseInterval) {
    this.logAgentPauseInterval = logAgentPauseInterval;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Internal timer to stall log-agent and prevent it from hogging cpu cycles on the service engine.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.
   * @return logAgentSleepInterval
   */
  public Integer getLogAgentSleepInterval() {
    return logAgentSleepInterval;
  }

  /**
   * This is the setter method to the attribute.
   * Internal timer to stall log-agent and prevent it from hogging cpu cycles on the service engine.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.
   * @param logAgentSleepInterval set the logAgentSleepInterval.
   */
  public void setLogAgentSleepInterval(Integer  logAgentSleepInterval) {
    this.logAgentSleepInterval = logAgentSleepInterval;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Timeout to purge unknown virtual service logs from the service engine.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1800.
   * @return logAgentUnknownVsTimer
   */
  public Integer getLogAgentUnknownVsTimer() {
    return logAgentUnknownVsTimer;
  }

  /**
   * This is the setter method to the attribute.
   * Timeout to purge unknown virtual service logs from the service engine.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1800.
   * @param logAgentUnknownVsTimer set the logAgentUnknownVsTimer.
   */
  public void setLogAgentUnknownVsTimer(Integer  logAgentUnknownVsTimer) {
    this.logAgentUnknownVsTimer = logAgentUnknownVsTimer;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of file names in a log message.
   * Default value when not specified in API or module is interpreted by Avi Controller as 64.
   * @return logMessageMaxFileListSize
   */
  public Integer getLogMessageMaxFileListSize() {
    return logMessageMaxFileListSize;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of file names in a log message.
   * Default value when not specified in API or module is interpreted by Avi Controller as 64.
   * @param logMessageMaxFileListSize set the logMessageMaxFileListSize.
   */
  public void setLogMessageMaxFileListSize(Integer  logMessageMaxFileListSize) {
    this.logMessageMaxFileListSize = logMessageMaxFileListSize;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Deprecated.
   * Field deprecated in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10000.
   * @return maxThroughput
   */
  public Integer getMaxThroughput() {
    return maxThroughput;
  }

  /**
   * This is the setter method to the attribute.
   * Deprecated.
   * Field deprecated in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10000.
   * @param maxThroughput set the maxThroughput.
   */
  public void setMaxThroughput(Integer  maxThroughput) {
    this.maxThroughput = maxThroughput;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enables mcache - controls fetch/store/store_out.
   * @return mcacheEnabled
   */
  public Boolean getMcacheEnabled() {
    return mcacheEnabled;
  }

  /**
   * This is the setter method to the attribute.
   * Enables mcache - controls fetch/store/store_out.
   * @param mcacheEnabled set the mcacheEnabled.
   */
  public void setMcacheEnabled(Boolean  mcacheEnabled) {
    this.mcacheEnabled = mcacheEnabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enables mcache_fetch.
   * @return mcacheFetchEnabled
   */
  public Boolean getMcacheFetchEnabled() {
    return mcacheFetchEnabled;
  }

  /**
   * This is the setter method to the attribute.
   * Enables mcache_fetch.
   * @param mcacheFetchEnabled set the mcacheFetchEnabled.
   */
  public void setMcacheFetchEnabled(Boolean  mcacheFetchEnabled) {
    this.mcacheFetchEnabled = mcacheFetchEnabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Use se group's app_cache_percent to set cache memory usage limit on se.
   * Field deprecated in 18.2.3.
   * @return mcacheMaxCacheSize
   */
  public Integer getMcacheMaxCacheSize() {
    return mcacheMaxCacheSize;
  }

  /**
   * This is the setter method to the attribute.
   * Use se group's app_cache_percent to set cache memory usage limit on se.
   * Field deprecated in 18.2.3.
   * @param mcacheMaxCacheSize set the mcacheMaxCacheSize.
   */
  public void setMcacheMaxCacheSize(Integer  mcacheMaxCacheSize) {
    this.mcacheMaxCacheSize = mcacheMaxCacheSize;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enables mcache_store.
   * @return mcacheStoreInEnabled
   */
  public Boolean getMcacheStoreInEnabled() {
    return mcacheStoreInEnabled;
  }

  /**
   * This is the setter method to the attribute.
   * Enables mcache_store.
   * @param mcacheStoreInEnabled set the mcacheStoreInEnabled.
   */
  public void setMcacheStoreInEnabled(Boolean  mcacheStoreInEnabled) {
    this.mcacheStoreInEnabled = mcacheStoreInEnabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Max object size.
   * @return mcacheStoreInMaxSize
   */
  public Integer getMcacheStoreInMaxSize() {
    return mcacheStoreInMaxSize;
  }

  /**
   * This is the setter method to the attribute.
   * Max object size.
   * @param mcacheStoreInMaxSize set the mcacheStoreInMaxSize.
   */
  public void setMcacheStoreInMaxSize(Integer  mcacheStoreInMaxSize) {
    this.mcacheStoreInMaxSize = mcacheStoreInMaxSize;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Min object size.
   * @return mcacheStoreInMinSize
   */
  public Integer getMcacheStoreInMinSize() {
    return mcacheStoreInMinSize;
  }

  /**
   * This is the setter method to the attribute.
   * Min object size.
   * @param mcacheStoreInMinSize set the mcacheStoreInMinSize.
   */
  public void setMcacheStoreInMinSize(Integer  mcacheStoreInMinSize) {
    this.mcacheStoreInMinSize = mcacheStoreInMinSize;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enables mcache_store_out.
   * @return mcacheStoreOutEnabled
   */
  public Boolean getMcacheStoreOutEnabled() {
    return mcacheStoreOutEnabled;
  }

  /**
   * This is the setter method to the attribute.
   * Enables mcache_store_out.
   * @param mcacheStoreOutEnabled set the mcacheStoreOutEnabled.
   */
  public void setMcacheStoreOutEnabled(Boolean  mcacheStoreOutEnabled) {
    this.mcacheStoreOutEnabled = mcacheStoreOutEnabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Use se group's app_cache_percent to set cache memory usage limit on se.
   * Field deprecated in 18.2.3.
   * @return mcacheStoreSeMaxSize
   */
  public Integer getMcacheStoreSeMaxSize() {
    return mcacheStoreSeMaxSize;
  }

  /**
   * This is the setter method to the attribute.
   * Use se group's app_cache_percent to set cache memory usage limit on se.
   * Field deprecated in 18.2.3.
   * @param mcacheStoreSeMaxSize set the mcacheStoreSeMaxSize.
   */
  public void setMcacheStoreSeMaxSize(Integer  mcacheStoreSeMaxSize) {
    this.mcacheStoreSeMaxSize = mcacheStoreSeMaxSize;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ngx_free_connection_stack of obj type seruntimeproperties field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return ngxFreeConnectionStack
   */
  public Boolean getNgxFreeConnectionStack() {
    return ngxFreeConnectionStack;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ngx_free_connection_stack of obj type seruntimeproperties field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param ngxFreeConnectionStack set the ngxFreeConnectionStack.
   */
  public void setNgxFreeConnectionStack(Boolean  ngxFreeConnectionStack) {
    this.ngxFreeConnectionStack = ngxFreeConnectionStack;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Deprecated.
   * Field deprecated in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 20000.
   * @return persistenceEntriesLowWatermark
   */
  public Integer getPersistenceEntriesLowWatermark() {
    return persistenceEntriesLowWatermark;
  }

  /**
   * This is the setter method to the attribute.
   * Deprecated.
   * Field deprecated in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 20000.
   * @param persistenceEntriesLowWatermark set the persistenceEntriesLowWatermark.
   */
  public void setPersistenceEntriesLowWatermark(Integer  persistenceEntriesLowWatermark) {
    this.persistenceEntriesLowWatermark = persistenceEntriesLowWatermark;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum memory in bytes allocated for persistence entries.
   * Allowed values are 0-33554432.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return persistenceMemMax
   */
  public Integer getPersistenceMemMax() {
    return persistenceMemMax;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum memory in bytes allocated for persistence entries.
   * Allowed values are 0-33554432.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param persistenceMemMax set the persistenceMemMax.
   */
  public void setPersistenceMemMax(Integer  persistenceMemMax) {
    this.persistenceMemMax = persistenceMemMax;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable punting of udp packets from primary to other service engines.
   * This applies to virtual services with per-packet loadbalancing enabled.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return scaleoutUdpPerPkt
   */
  public Boolean getScaleoutUdpPerPkt() {
    return scaleoutUdpPerPkt;
  }

  /**
   * This is the setter method to the attribute.
   * Enable punting of udp packets from primary to other service engines.
   * This applies to virtual services with per-packet loadbalancing enabled.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param scaleoutUdpPerPkt set the scaleoutUdpPerPkt.
   */
  public void setScaleoutUdpPerPkt(Boolean  scaleoutUdpPerPkt) {
    this.scaleoutUdpPerPkt = scaleoutUdpPerPkt;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ldap basicauth default bind timeout enforced on connections to ldap server.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5000.
   * @return seAuthLdapBindTimeout
   */
  public Integer getSeAuthLdapBindTimeout() {
    return seAuthLdapBindTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * Ldap basicauth default bind timeout enforced on connections to ldap server.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5000.
   * @param seAuthLdapBindTimeout set the seAuthLdapBindTimeout.
   */
  public void setSeAuthLdapBindTimeout(Integer  seAuthLdapBindTimeout) {
    this.seAuthLdapBindTimeout = seAuthLdapBindTimeout;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Size of ldap basicauth credentials cache used on the dataplane.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100000.
   * @return seAuthLdapCacheSize
   */
  public Integer getSeAuthLdapCacheSize() {
    return seAuthLdapCacheSize;
  }

  /**
   * This is the setter method to the attribute.
   * Size of ldap basicauth credentials cache used on the dataplane.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100000.
   * @param seAuthLdapCacheSize set the seAuthLdapCacheSize.
   */
  public void setSeAuthLdapCacheSize(Integer  seAuthLdapCacheSize) {
    this.seAuthLdapCacheSize = seAuthLdapCacheSize;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ldap basicauth default connection timeout enforced on connections to ldap server.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10000.
   * @return seAuthLdapConnectTimeout
   */
  public Integer getSeAuthLdapConnectTimeout() {
    return seAuthLdapConnectTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * Ldap basicauth default connection timeout enforced on connections to ldap server.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10000.
   * @param seAuthLdapConnectTimeout set the seAuthLdapConnectTimeout.
   */
  public void setSeAuthLdapConnectTimeout(Integer  seAuthLdapConnectTimeout) {
    this.seAuthLdapConnectTimeout = seAuthLdapConnectTimeout;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Number of concurrent connections to ldap server by a single basic auth ldap process.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.
   * @return seAuthLdapConnsPerServer
   */
  public Integer getSeAuthLdapConnsPerServer() {
    return seAuthLdapConnsPerServer;
  }

  /**
   * This is the setter method to the attribute.
   * Number of concurrent connections to ldap server by a single basic auth ldap process.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.
   * @param seAuthLdapConnsPerServer set the seAuthLdapConnsPerServer.
   */
  public void setSeAuthLdapConnsPerServer(Integer  seAuthLdapConnsPerServer) {
    this.seAuthLdapConnsPerServer = seAuthLdapConnsPerServer;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ldap basicauth default reconnect timeout enforced on connections to ldap server.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10000.
   * @return seAuthLdapReconnectTimeout
   */
  public Integer getSeAuthLdapReconnectTimeout() {
    return seAuthLdapReconnectTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * Ldap basicauth default reconnect timeout enforced on connections to ldap server.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10000.
   * @param seAuthLdapReconnectTimeout set the seAuthLdapReconnectTimeout.
   */
  public void setSeAuthLdapReconnectTimeout(Integer  seAuthLdapReconnectTimeout) {
    this.seAuthLdapReconnectTimeout = seAuthLdapReconnectTimeout;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ldap basicauth default login or group search request timeout enforced on connections to ldap server.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10000.
   * @return seAuthLdapRequestTimeout
   */
  public Integer getSeAuthLdapRequestTimeout() {
    return seAuthLdapRequestTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * Ldap basicauth default login or group search request timeout enforced on connections to ldap server.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10000.
   * @param seAuthLdapRequestTimeout set the seAuthLdapRequestTimeout.
   */
  public void setSeAuthLdapRequestTimeout(Integer  seAuthLdapRequestTimeout) {
    this.seAuthLdapRequestTimeout = seAuthLdapRequestTimeout;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ldap basicauth uses multiple ldap servers in the event of a failover only.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return seAuthLdapServersFailoverOnly
   */
  public Boolean getSeAuthLdapServersFailoverOnly() {
    return seAuthLdapServersFailoverOnly;
  }

  /**
   * This is the setter method to the attribute.
   * Ldap basicauth uses multiple ldap servers in the event of a failover only.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param seAuthLdapServersFailoverOnly set the seAuthLdapServersFailoverOnly.
   */
  public void setSeAuthLdapServersFailoverOnly(Boolean  seAuthLdapServersFailoverOnly) {
    this.seAuthLdapServersFailoverOnly = seAuthLdapServersFailoverOnly;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_dp_compression of obj type seruntimeproperties field type str  type ref.
   * @return seDpCompression
   */
  public SeRuntimeCompressionProperties getSeDpCompression() {
    return seDpCompression;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_dp_compression of obj type seruntimeproperties field type str  type ref.
   * @param seDpCompression set the seDpCompression.
   */
  public void setSeDpCompression(SeRuntimeCompressionProperties seDpCompression) {
    this.seDpCompression = seDpCompression;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Internal only.
   * Used to simulate se - se hb failure.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return seDpHmDrops
   */
  public Integer getSeDpHmDrops() {
    return seDpHmDrops;
  }

  /**
   * This is the setter method to the attribute.
   * Internal only.
   * Used to simulate se - se hb failure.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param seDpHmDrops set the seDpHmDrops.
   */
  public void setSeDpHmDrops(Integer  seDpHmDrops) {
    this.seDpHmDrops = seDpHmDrops;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Number of jiffies between polling interface state.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.
   * @return seDpIfStatePollInterval
   */
  public Integer getSeDpIfStatePollInterval() {
    return seDpIfStatePollInterval;
  }

  /**
   * This is the setter method to the attribute.
   * Number of jiffies between polling interface state.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.
   * @param seDpIfStatePollInterval set the seDpIfStatePollInterval.
   */
  public void setSeDpIfStatePollInterval(Integer  seDpIfStatePollInterval) {
    this.seDpIfStatePollInterval = seDpIfStatePollInterval;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Internal buffer full indicator on the service engine beyond which the unfiltered logs are abandoned.
   * Default value when not specified in API or module is interpreted by Avi Controller as 70.
   * @return seDpLogNfEnqueuePercent
   */
  public Integer getSeDpLogNfEnqueuePercent() {
    return seDpLogNfEnqueuePercent;
  }

  /**
   * This is the setter method to the attribute.
   * Internal buffer full indicator on the service engine beyond which the unfiltered logs are abandoned.
   * Default value when not specified in API or module is interpreted by Avi Controller as 70.
   * @param seDpLogNfEnqueuePercent set the seDpLogNfEnqueuePercent.
   */
  public void setSeDpLogNfEnqueuePercent(Integer  seDpLogNfEnqueuePercent) {
    this.seDpLogNfEnqueuePercent = seDpLogNfEnqueuePercent;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Internal buffer full indicator on the service engine beyond which the user filtered logs are abandoned.
   * Default value when not specified in API or module is interpreted by Avi Controller as 90.
   * @return seDpLogUdfEnqueuePercent
   */
  public Integer getSeDpLogUdfEnqueuePercent() {
    return seDpLogUdfEnqueuePercent;
  }

  /**
   * This is the setter method to the attribute.
   * Internal buffer full indicator on the service engine beyond which the user filtered logs are abandoned.
   * Default value when not specified in API or module is interpreted by Avi Controller as 90.
   * @param seDpLogUdfEnqueuePercent set the seDpLogUdfEnqueuePercent.
   */
  public void setSeDpLogUdfEnqueuePercent(Integer  seDpLogUdfEnqueuePercent) {
    this.seDpLogUdfEnqueuePercent = seDpLogUdfEnqueuePercent;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Deprecated.
   * Field deprecated in 18.2.5.
   * Field introduced in 17.1.1.
   * @return seDpVnicQueueStallEventSleep
   */
  public Integer getSeDpVnicQueueStallEventSleep() {
    return seDpVnicQueueStallEventSleep;
  }

  /**
   * This is the setter method to the attribute.
   * Deprecated.
   * Field deprecated in 18.2.5.
   * Field introduced in 17.1.1.
   * @param seDpVnicQueueStallEventSleep set the seDpVnicQueueStallEventSleep.
   */
  public void setSeDpVnicQueueStallEventSleep(Integer  seDpVnicQueueStallEventSleep) {
    this.seDpVnicQueueStallEventSleep = seDpVnicQueueStallEventSleep;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Deprecated.
   * Field deprecated in 18.2.5.
   * Field introduced in 17.1.1.
   * @return seDpVnicQueueStallThreshold
   */
  public Integer getSeDpVnicQueueStallThreshold() {
    return seDpVnicQueueStallThreshold;
  }

  /**
   * This is the setter method to the attribute.
   * Deprecated.
   * Field deprecated in 18.2.5.
   * Field introduced in 17.1.1.
   * @param seDpVnicQueueStallThreshold set the seDpVnicQueueStallThreshold.
   */
  public void setSeDpVnicQueueStallThreshold(Integer  seDpVnicQueueStallThreshold) {
    this.seDpVnicQueueStallThreshold = seDpVnicQueueStallThreshold;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Deprecated.
   * Field deprecated in 18.2.5.
   * Field introduced in 17.1.1.
   * @return seDpVnicQueueStallTimeout
   */
  public Integer getSeDpVnicQueueStallTimeout() {
    return seDpVnicQueueStallTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * Deprecated.
   * Field deprecated in 18.2.5.
   * Field introduced in 17.1.1.
   * @param seDpVnicQueueStallTimeout set the seDpVnicQueueStallTimeout.
   */
  public void setSeDpVnicQueueStallTimeout(Integer  seDpVnicQueueStallTimeout) {
    this.seDpVnicQueueStallTimeout = seDpVnicQueueStallTimeout;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Deprecated.
   * Field deprecated in 18.2.5.
   * Field introduced in 17.1.14, 17.2.5, 18.1.1.
   * @return seDpVnicRestartOnQueueStallCount
   */
  public Integer getSeDpVnicRestartOnQueueStallCount() {
    return seDpVnicRestartOnQueueStallCount;
  }

  /**
   * This is the setter method to the attribute.
   * Deprecated.
   * Field deprecated in 18.2.5.
   * Field introduced in 17.1.14, 17.2.5, 18.1.1.
   * @param seDpVnicRestartOnQueueStallCount set the seDpVnicRestartOnQueueStallCount.
   */
  public void setSeDpVnicRestartOnQueueStallCount(Integer  seDpVnicRestartOnQueueStallCount) {
    this.seDpVnicRestartOnQueueStallCount = seDpVnicRestartOnQueueStallCount;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Deprecated.
   * Field deprecated in 18.2.5.
   * Field introduced in 17.1.14, 17.2.5, 18.1.1.
   * @return seDpVnicStallSeRestartWindow
   */
  public Integer getSeDpVnicStallSeRestartWindow() {
    return seDpVnicStallSeRestartWindow;
  }

  /**
   * This is the setter method to the attribute.
   * Deprecated.
   * Field deprecated in 18.2.5.
   * Field introduced in 17.1.14, 17.2.5, 18.1.1.
   * @param seDpVnicStallSeRestartWindow set the seDpVnicStallSeRestartWindow.
   */
  public void setSeDpVnicStallSeRestartWindow(Integer  seDpVnicStallSeRestartWindow) {
    this.seDpVnicStallSeRestartWindow = seDpVnicStallSeRestartWindow;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable core dump on assert.
   * Field introduced in 18.1.3, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return seDumpCoreOnAssert
   */
  public Boolean getSeDumpCoreOnAssert() {
    return seDumpCoreOnAssert;
  }

  /**
   * This is the setter method to the attribute.
   * Enable core dump on assert.
   * Field introduced in 18.1.3, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param seDumpCoreOnAssert set the seDumpCoreOnAssert.
   */
  public void setSeDumpCoreOnAssert(Boolean  seDumpCoreOnAssert) {
    this.seDumpCoreOnAssert = seDumpCoreOnAssert;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Accept/ignore interface routes (i.e, no next hop ip address).
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return seHandleInterfaceRoutes
   */
  public Boolean getSeHandleInterfaceRoutes() {
    return seHandleInterfaceRoutes;
  }

  /**
   * This is the setter method to the attribute.
   * Accept/ignore interface routes (i.e, no next hop ip address).
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param seHandleInterfaceRoutes set the seHandleInterfaceRoutes.
   */
  public void setSeHandleInterfaceRoutes(Boolean  seHandleInterfaceRoutes) {
    this.seHandleInterfaceRoutes = seHandleInterfaceRoutes;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Internal use only.
   * Allowed values are 0-7.
   * Default value when not specified in API or module is interpreted by Avi Controller as 3.
   * @return seHbPersistFudgeBits
   */
  public Integer getSeHbPersistFudgeBits() {
    return seHbPersistFudgeBits;
  }

  /**
   * This is the setter method to the attribute.
   * Internal use only.
   * Allowed values are 0-7.
   * Default value when not specified in API or module is interpreted by Avi Controller as 3.
   * @param seHbPersistFudgeBits set the seHbPersistFudgeBits.
   */
  public void setSeHbPersistFudgeBits(Integer  seHbPersistFudgeBits) {
    this.seHbPersistFudgeBits = seHbPersistFudgeBits;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Number of packets with wrong mac after which se attempts to disable promiscious mode.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1000.
   * @return seMacErrorThresholdToDisablePromiscious
   */
  public Integer getSeMacErrorThresholdToDisablePromiscious() {
    return seMacErrorThresholdToDisablePromiscious;
  }

  /**
   * This is the setter method to the attribute.
   * Number of packets with wrong mac after which se attempts to disable promiscious mode.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1000.
   * @param seMacErrorThresholdToDisablePromiscious set the seMacErrorThresholdToDisablePromiscious.
   */
  public void setSeMacErrorThresholdToDisablePromiscious(Integer  seMacErrorThresholdToDisablePromiscious) {
    this.seMacErrorThresholdToDisablePromiscious = seMacErrorThresholdToDisablePromiscious;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Deprecated.
   * Field deprecated in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return seMallocThresh
   */
  public Integer getSeMallocThresh() {
    return seMallocThresh;
  }

  /**
   * This is the setter method to the attribute.
   * Deprecated.
   * Field deprecated in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param seMallocThresh set the seMallocThresh.
   */
  public void setSeMallocThresh(Integer  seMallocThresh) {
    this.seMallocThresh = seMallocThresh;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Internal use only.
   * Enables poisoning of freed memory blocks.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return seMemoryPoison
   */
  public Boolean getSeMemoryPoison() {
    return seMemoryPoison;
  }

  /**
   * This is the setter method to the attribute.
   * Internal use only.
   * Enables poisoning of freed memory blocks.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param seMemoryPoison set the seMemoryPoison.
   */
  public void setSeMemoryPoison(Boolean  seMemoryPoison) {
    this.seMemoryPoison = seMemoryPoison;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Internal use only.
   * Frequency (ms) of metrics updates from se to controller.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60000.
   * @return seMetricsInterval
   */
  public Integer getSeMetricsInterval() {
    return seMetricsInterval;
  }

  /**
   * This is the setter method to the attribute.
   * Internal use only.
   * Frequency (ms) of metrics updates from se to controller.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60000.
   * @param seMetricsInterval set the seMetricsInterval.
   */
  public void setSeMetricsInterval(Integer  seMetricsInterval) {
    this.seMetricsInterval = seMetricsInterval;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Internal use only.
   * Enable or disable real time metrics irrespective of virtualservice or se group configuration.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return seMetricsRtEnabled
   */
  public Boolean getSeMetricsRtEnabled() {
    return seMetricsRtEnabled;
  }

  /**
   * This is the setter method to the attribute.
   * Internal use only.
   * Enable or disable real time metrics irrespective of virtualservice or se group configuration.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param seMetricsRtEnabled set the seMetricsRtEnabled.
   */
  public void setSeMetricsRtEnabled(Boolean  seMetricsRtEnabled) {
    this.seMetricsRtEnabled = seMetricsRtEnabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Internal use only.
   * Frequency (ms) of realtime metrics updates from se to controller.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1000.
   * @return seMetricsRtInterval
   */
  public Integer getSeMetricsRtInterval() {
    return seMetricsRtInterval;
  }

  /**
   * This is the setter method to the attribute.
   * Internal use only.
   * Frequency (ms) of realtime metrics updates from se to controller.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1000.
   * @param seMetricsRtInterval set the seMetricsRtInterval.
   */
  public void setSeMetricsRtInterval(Integer  seMetricsRtInterval) {
    this.seMetricsRtInterval = seMetricsRtInterval;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Internal use only.
   * Used to artificially reduce the available number of packet buffers.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return sePacketBufferMax
   */
  public Integer getSePacketBufferMax() {
    return sePacketBufferMax;
  }

  /**
   * This is the setter method to the attribute.
   * Internal use only.
   * Used to artificially reduce the available number of packet buffers.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param sePacketBufferMax set the sePacketBufferMax.
   */
  public void setSePacketBufferMax(Integer  sePacketBufferMax) {
    this.sePacketBufferMax = sePacketBufferMax;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Internal use only.
   * If enabled, randomly packets are dropped.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return seRandomTcpDrops
   */
  public Boolean getSeRandomTcpDrops() {
    return seRandomTcpDrops;
  }

  /**
   * This is the setter method to the attribute.
   * Internal use only.
   * If enabled, randomly packets are dropped.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param seRandomTcpDrops set the seRandomTcpDrops.
   */
  public void setSeRandomTcpDrops(Boolean  seRandomTcpDrops) {
    this.seRandomTcpDrops = seRandomTcpDrops;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Se rate limiters.
   * @return seRateLimiters
   */
  public SeRateLimiters getSeRateLimiters() {
    return seRateLimiters;
  }

  /**
   * This is the setter method to the attribute.
   * Se rate limiters.
   * @param seRateLimiters set the seRateLimiters.
   */
  public void setSeRateLimiters(SeRateLimiters seRateLimiters) {
    this.seRateLimiters = seRateLimiters;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Ip ranges on which there may be virtual services (for configuring iptables/routes).
   * @return serviceIpSubnets
   */
  public List<IpAddrPrefix> getServiceIpSubnets() {
    return serviceIpSubnets;
  }

  /**
   * This is the setter method. this will set the serviceIpSubnets
   * Ip ranges on which there may be virtual services (for configuring iptables/routes).
   * @return serviceIpSubnets
   */
  public void setServiceIpSubnets(List<IpAddrPrefix>  serviceIpSubnets) {
    this.serviceIpSubnets = serviceIpSubnets;
  }

  /**
   * This is the setter method this will set the serviceIpSubnets
   * Ip ranges on which there may be virtual services (for configuring iptables/routes).
   * @return serviceIpSubnets
   */
  public SeRuntimeProperties addServiceIpSubnetsItem(IpAddrPrefix serviceIpSubnetsItem) {
    if (this.serviceIpSubnets == null) {
      this.serviceIpSubnets = new ArrayList<IpAddrPrefix>();
    }
    this.serviceIpSubnets.add(serviceIpSubnetsItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Port ranges on which there may be virtual services (for configuring iptables).
   * Applicable in container ecosystems like mesos.
   * @return servicePortRanges
   */
  public List<PortRange> getServicePortRanges() {
    return servicePortRanges;
  }

  /**
   * This is the setter method. this will set the servicePortRanges
   * Port ranges on which there may be virtual services (for configuring iptables).
   * Applicable in container ecosystems like mesos.
   * @return servicePortRanges
   */
  public void setServicePortRanges(List<PortRange>  servicePortRanges) {
    this.servicePortRanges = servicePortRanges;
  }

  /**
   * This is the setter method this will set the servicePortRanges
   * Port ranges on which there may be virtual services (for configuring iptables).
   * Applicable in container ecosystems like mesos.
   * @return servicePortRanges
   */
  public SeRuntimeProperties addServicePortRangesItem(PortRange servicePortRangesItem) {
    if (this.servicePortRanges == null) {
      this.servicePortRanges = new ArrayList<PortRange>();
    }
    this.servicePortRanges.add(servicePortRangesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Make service ports accessible on all host interfaces in addition to east-west vip and/or bridge ip.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return servicesAccessibleAllInterfaces
   */
  public Boolean getServicesAccessibleAllInterfaces() {
    return servicesAccessibleAllInterfaces;
  }

  /**
   * This is the setter method to the attribute.
   * Make service ports accessible on all host interfaces in addition to east-west vip and/or bridge ip.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param servicesAccessibleAllInterfaces set the servicesAccessibleAllInterfaces.
   */
  public void setServicesAccessibleAllInterfaces(Boolean  servicesAccessibleAllInterfaces) {
    this.servicesAccessibleAllInterfaces = servicesAccessibleAllInterfaces;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property spdy_fwd_proxy_parse_enable of obj type seruntimeproperties field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return spdyFwdProxyParseEnable
   */
  public Boolean getSpdyFwdProxyParseEnable() {
    return spdyFwdProxyParseEnable;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property spdy_fwd_proxy_parse_enable of obj type seruntimeproperties field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param spdyFwdProxyParseEnable set the spdyFwdProxyParseEnable.
   */
  public void setSpdyFwdProxyParseEnable(Boolean  spdyFwdProxyParseEnable) {
    this.spdyFwdProxyParseEnable = spdyFwdProxyParseEnable;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum size of the syn cache table.
   * After this limit is reached, syn cookies are used.
   * This is per core of the serviceengine.
   * Field deprecated in 17.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 32768.
   * @return tcpSynCacheMax
   */
  public Integer getTcpSynCacheMax() {
    return tcpSynCacheMax;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum size of the syn cache table.
   * After this limit is reached, syn cookies are used.
   * This is per core of the serviceengine.
   * Field deprecated in 17.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 32768.
   * @param tcpSynCacheMax set the tcpSynCacheMax.
   */
  public void setTcpSynCacheMax(Integer  tcpSynCacheMax) {
    this.tcpSynCacheMax = tcpSynCacheMax;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Default value for max number of retransmissions for a syn packet.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4.
   * @return tcpSyncacheMaxRetransmitDefault
   */
  public Integer getTcpSyncacheMaxRetransmitDefault() {
    return tcpSyncacheMaxRetransmitDefault;
  }

  /**
   * This is the setter method to the attribute.
   * Default value for max number of retransmissions for a syn packet.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4.
   * @param tcpSyncacheMaxRetransmitDefault set the tcpSyncacheMaxRetransmitDefault.
   */
  public void setTcpSyncacheMaxRetransmitDefault(Integer  tcpSyncacheMaxRetransmitDefault) {
    this.tcpSyncacheMaxRetransmitDefault = tcpSyncacheMaxRetransmitDefault;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Timeout for backend connection.
   * Default value when not specified in API or module is interpreted by Avi Controller as 3600000.
   * @return upstreamConnectTimeout
   */
  public Integer getUpstreamConnectTimeout() {
    return upstreamConnectTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * Timeout for backend connection.
   * Default value when not specified in API or module is interpreted by Avi Controller as 3600000.
   * @param upstreamConnectTimeout set the upstreamConnectTimeout.
   */
  public void setUpstreamConnectTimeout(Integer  upstreamConnectTimeout) {
    this.upstreamConnectTimeout = upstreamConnectTimeout;
  }

  /**
   * This is the getter method this will return the attribute value.
   * L7 upstream connection pool cache threshold in percentage.
   * Default value when not specified in API or module is interpreted by Avi Controller as -1.
   * @return upstreamConnpoolCacheThresh
   */
  public Integer getUpstreamConnpoolCacheThresh() {
    return upstreamConnpoolCacheThresh;
  }

  /**
   * This is the setter method to the attribute.
   * L7 upstream connection pool cache threshold in percentage.
   * Default value when not specified in API or module is interpreted by Avi Controller as -1.
   * @param upstreamConnpoolCacheThresh set the upstreamConnpoolCacheThresh.
   */
  public void setUpstreamConnpoolCacheThresh(Integer  upstreamConnpoolCacheThresh) {
    this.upstreamConnpoolCacheThresh = upstreamConnpoolCacheThresh;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Idle timeout value for a connection in the upstream connection pool, when the current cache size is above the threshold.
   * Default value when not specified in API or module is interpreted by Avi Controller as -1.
   * @return upstreamConnpoolConnIdleThreshTmo
   */
  public Integer getUpstreamConnpoolConnIdleThreshTmo() {
    return upstreamConnpoolConnIdleThreshTmo;
  }

  /**
   * This is the setter method to the attribute.
   * Idle timeout value for a connection in the upstream connection pool, when the current cache size is above the threshold.
   * Default value when not specified in API or module is interpreted by Avi Controller as -1.
   * @param upstreamConnpoolConnIdleThreshTmo set the upstreamConnpoolConnIdleThreshTmo.
   */
  public void setUpstreamConnpoolConnIdleThreshTmo(Integer  upstreamConnpoolConnIdleThreshTmo) {
    this.upstreamConnpoolConnIdleThreshTmo = upstreamConnpoolConnIdleThreshTmo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Deprecated.
   * Field deprecated in 18.2.1.
   * @return upstreamConnpoolConnIdleTmo
   */
  public Integer getUpstreamConnpoolConnIdleTmo() {
    return upstreamConnpoolConnIdleTmo;
  }

  /**
   * This is the setter method to the attribute.
   * Deprecated.
   * Field deprecated in 18.2.1.
   * @param upstreamConnpoolConnIdleTmo set the upstreamConnpoolConnIdleTmo.
   */
  public void setUpstreamConnpoolConnIdleTmo(Integer  upstreamConnpoolConnIdleTmo) {
    this.upstreamConnpoolConnIdleTmo = upstreamConnpoolConnIdleTmo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Deprecated.
   * Field deprecated in 18.2.1.
   * @return upstreamConnpoolConnLifeTmo
   */
  public Integer getUpstreamConnpoolConnLifeTmo() {
    return upstreamConnpoolConnLifeTmo;
  }

  /**
   * This is the setter method to the attribute.
   * Deprecated.
   * Field deprecated in 18.2.1.
   * @param upstreamConnpoolConnLifeTmo set the upstreamConnpoolConnLifeTmo.
   */
  public void setUpstreamConnpoolConnLifeTmo(Integer  upstreamConnpoolConnLifeTmo) {
    this.upstreamConnpoolConnLifeTmo = upstreamConnpoolConnLifeTmo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Deprecated.
   * Field deprecated in 18.2.1.
   * @return upstreamConnpoolConnMaxReuse
   */
  public Integer getUpstreamConnpoolConnMaxReuse() {
    return upstreamConnpoolConnMaxReuse;
  }

  /**
   * This is the setter method to the attribute.
   * Deprecated.
   * Field deprecated in 18.2.1.
   * @param upstreamConnpoolConnMaxReuse set the upstreamConnpoolConnMaxReuse.
   */
  public void setUpstreamConnpoolConnMaxReuse(Integer  upstreamConnpoolConnMaxReuse) {
    this.upstreamConnpoolConnMaxReuse = upstreamConnpoolConnMaxReuse;
  }

  /**
   * This is the getter method this will return the attribute value.
   * L7 upstream connection pool max cache size per core.
   * Default value when not specified in API or module is interpreted by Avi Controller as -1.
   * @return upstreamConnpoolCoreMaxCache
   */
  public Integer getUpstreamConnpoolCoreMaxCache() {
    return upstreamConnpoolCoreMaxCache;
  }

  /**
   * This is the setter method to the attribute.
   * L7 upstream connection pool max cache size per core.
   * Default value when not specified in API or module is interpreted by Avi Controller as -1.
   * @param upstreamConnpoolCoreMaxCache set the upstreamConnpoolCoreMaxCache.
   */
  public void setUpstreamConnpoolCoreMaxCache(Integer  upstreamConnpoolCoreMaxCache) {
    this.upstreamConnpoolCoreMaxCache = upstreamConnpoolCoreMaxCache;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable upstream connection pool.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return upstreamConnpoolEnable
   */
  public Boolean getUpstreamConnpoolEnable() {
    return upstreamConnpoolEnable;
  }

  /**
   * This is the setter method to the attribute.
   * Enable upstream connection pool.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param upstreamConnpoolEnable set the upstreamConnpoolEnable.
   */
  public void setUpstreamConnpoolEnable(Boolean  upstreamConnpoolEnable) {
    this.upstreamConnpoolEnable = upstreamConnpoolEnable;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Deprecated.
   * Field deprecated in 18.2.1.
   * @return upstreamConnpoolServerMaxCache
   */
  public Integer getUpstreamConnpoolServerMaxCache() {
    return upstreamConnpoolServerMaxCache;
  }

  /**
   * This is the setter method to the attribute.
   * Deprecated.
   * Field deprecated in 18.2.1.
   * @param upstreamConnpoolServerMaxCache set the upstreamConnpoolServerMaxCache.
   */
  public void setUpstreamConnpoolServerMaxCache(Integer  upstreamConnpoolServerMaxCache) {
    this.upstreamConnpoolServerMaxCache = upstreamConnpoolServerMaxCache;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property upstream_connpool_strategy of obj type seruntimeproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as -1.
   * @return upstreamConnpoolStrategy
   */
  public Integer getUpstreamConnpoolStrategy() {
    return upstreamConnpoolStrategy;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property upstream_connpool_strategy of obj type seruntimeproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as -1.
   * @param upstreamConnpoolStrategy set the upstreamConnpoolStrategy.
   */
  public void setUpstreamConnpoolStrategy(Integer  upstreamConnpoolStrategy) {
    this.upstreamConnpoolStrategy = upstreamConnpoolStrategy;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property upstream_keepalive of obj type seruntimeproperties field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return upstreamKeepalive
   */
  public Boolean getUpstreamKeepalive() {
    return upstreamKeepalive;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property upstream_keepalive of obj type seruntimeproperties field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param upstreamKeepalive set the upstreamKeepalive.
   */
  public void setUpstreamKeepalive(Boolean  upstreamKeepalive) {
    this.upstreamKeepalive = upstreamKeepalive;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Timeout for data to be received from backend.
   * Default value when not specified in API or module is interpreted by Avi Controller as 3600000.
   * @return upstreamReadTimeout
   */
  public Integer getUpstreamReadTimeout() {
    return upstreamReadTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * Timeout for data to be received from backend.
   * Default value when not specified in API or module is interpreted by Avi Controller as 3600000.
   * @param upstreamReadTimeout set the upstreamReadTimeout.
   */
  public void setUpstreamReadTimeout(Integer  upstreamReadTimeout) {
    this.upstreamReadTimeout = upstreamReadTimeout;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Timeout for upstream to become writable.
   * Default value when not specified in API or module is interpreted by Avi Controller as 3600000.
   * @return upstreamSendTimeout
   */
  public Integer getUpstreamSendTimeout() {
    return upstreamSendTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * Timeout for upstream to become writable.
   * Default value when not specified in API or module is interpreted by Avi Controller as 3600000.
   * @param upstreamSendTimeout set the upstreamSendTimeout.
   */
  public void setUpstreamSendTimeout(Integer  upstreamSendTimeout) {
    this.upstreamSendTimeout = upstreamSendTimeout;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Defines in seconds how long before an unused user-defined-metric is garbage collected.
   * Field introduced in 17.1.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @return userDefinedMetricAge
   */
  public Integer getUserDefinedMetricAge() {
    return userDefinedMetricAge;
  }

  /**
   * This is the setter method to the attribute.
   * Defines in seconds how long before an unused user-defined-metric is garbage collected.
   * Field introduced in 17.1.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @param userDefinedMetricAge set the userDefinedMetricAge.
   */
  public void setUserDefinedMetricAge(Integer  userDefinedMetricAge) {
    this.userDefinedMetricAge = userDefinedMetricAge;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SeRuntimeProperties objSeRuntimeProperties = (SeRuntimeProperties) o;
  return   Objects.equals(this.upstreamConnpoolConnLifeTmo, objSeRuntimeProperties.upstreamConnpoolConnLifeTmo)&&
  Objects.equals(this.mcacheStoreOutEnabled, objSeRuntimeProperties.mcacheStoreOutEnabled)&&
  Objects.equals(this.disableTso, objSeRuntimeProperties.disableTso)&&
  Objects.equals(this.logAgentMaxActiveAdfFilesPerVs, objSeRuntimeProperties.logAgentMaxActiveAdfFilesPerVs)&&
  Objects.equals(this.seAuthLdapConnsPerServer, objSeRuntimeProperties.seAuthLdapConnsPerServer)&&
  Objects.equals(this.logAgentFileSzAppl, objSeRuntimeProperties.logAgentFileSzAppl)&&
  Objects.equals(this.sePacketBufferMax, objSeRuntimeProperties.sePacketBufferMax)&&
  Objects.equals(this.logAgentMaxLogmessageProtoSz, objSeRuntimeProperties.logAgentMaxLogmessageProtoSz)&&
  Objects.equals(this.seMallocThresh, objSeRuntimeProperties.seMallocThresh)&&
  Objects.equals(this.seHbPersistFudgeBits, objSeRuntimeProperties.seHbPersistFudgeBits)&&
  Objects.equals(this.seDpVnicStallSeRestartWindow, objSeRuntimeProperties.seDpVnicStallSeRestartWindow)&&
  Objects.equals(this.upstreamConnpoolConnMaxReuse, objSeRuntimeProperties.upstreamConnpoolConnMaxReuse)&&
  Objects.equals(this.upstreamConnpoolServerMaxCache, objSeRuntimeProperties.upstreamConnpoolServerMaxCache)&&
  Objects.equals(this.dosProfile, objSeRuntimeProperties.dosProfile)&&
  Objects.equals(this.dpAggressiveHbTimeoutCount, objSeRuntimeProperties.dpAggressiveHbTimeoutCount)&&
  Objects.equals(this.seMetricsRtInterval, objSeRuntimeProperties.seMetricsRtInterval)&&
  Objects.equals(this.serviceIpSubnets, objSeRuntimeProperties.serviceIpSubnets)&&
  Objects.equals(this.persistenceMemMax, objSeRuntimeProperties.persistenceMemMax)&&
  Objects.equals(this.httpRumConsoleLog, objSeRuntimeProperties.httpRumConsoleLog)&&
  Objects.equals(this.logAgentLogStorageMinSz, objSeRuntimeProperties.logAgentLogStorageMinSz)&&
  Objects.equals(this.seRandomTcpDrops, objSeRuntimeProperties.seRandomTcpDrops)&&
  Objects.equals(this.seDpIfStatePollInterval, objSeRuntimeProperties.seDpIfStatePollInterval)&&
  Objects.equals(this.seAuthLdapCacheSize, objSeRuntimeProperties.seAuthLdapCacheSize)&&
  Objects.equals(this.logMessageMaxFileListSize, objSeRuntimeProperties.logMessageMaxFileListSize)&&
  Objects.equals(this.adminSshEnabled, objSeRuntimeProperties.adminSshEnabled)&&
  Objects.equals(this.servicesAccessibleAllInterfaces, objSeRuntimeProperties.servicesAccessibleAllInterfaces)&&
  Objects.equals(this.dupipTimeoutCount, objSeRuntimeProperties.dupipTimeoutCount)&&
  Objects.equals(this.baremetalDispatcherHandlesFlows, objSeRuntimeProperties.baremetalDispatcherHandlesFlows)&&
  Objects.equals(this.upstreamConnpoolCacheThresh, objSeRuntimeProperties.upstreamConnpoolCacheThresh)&&
  Objects.equals(this.mcacheFetchEnabled, objSeRuntimeProperties.mcacheFetchEnabled)&&
  Objects.equals(this.connectionsLossyLogRateLimiterThreshold, objSeRuntimeProperties.connectionsLossyLogRateLimiterThreshold)&&
  Objects.equals(this.upstreamConnpoolConnIdleTmo, objSeRuntimeProperties.upstreamConnpoolConnIdleTmo)&&
  Objects.equals(this.mcacheStoreInEnabled, objSeRuntimeProperties.mcacheStoreInEnabled)&&
  Objects.equals(this.logAgentUnknownVsTimer, objSeRuntimeProperties.logAgentUnknownVsTimer)&&
  Objects.equals(this.upstreamConnpoolStrategy, objSeRuntimeProperties.upstreamConnpoolStrategy)&&
  Objects.equals(this.upstreamConnpoolConnIdleThreshTmo, objSeRuntimeProperties.upstreamConnpoolConnIdleThreshTmo)&&
  Objects.equals(this.logAgentMinStoragePerVs, objSeRuntimeProperties.logAgentMinStoragePerVs)&&
  Objects.equals(this.feproxyVipsEnableProxyArp, objSeRuntimeProperties.feproxyVipsEnableProxyArp)&&
  Objects.equals(this.servicePortRanges, objSeRuntimeProperties.servicePortRanges)&&
  Objects.equals(this.mcacheMaxCacheSize, objSeRuntimeProperties.mcacheMaxCacheSize)&&
  Objects.equals(this.seDpLogNfEnqueuePercent, objSeRuntimeProperties.seDpLogNfEnqueuePercent)&&
  Objects.equals(this.logAgentConnSendBufferSize, objSeRuntimeProperties.logAgentConnSendBufferSize)&&
  Objects.equals(this.flowTableBatchPushFrequency, objSeRuntimeProperties.flowTableBatchPushFrequency)&&
  Objects.equals(this.logAgentFileSzConn, objSeRuntimeProperties.logAgentFileSzConn)&&
  Objects.equals(this.seMacErrorThresholdToDisablePromiscious, objSeRuntimeProperties.seMacErrorThresholdToDisablePromiscious)&&
  Objects.equals(this.mcacheStoreSeMaxSize, objSeRuntimeProperties.mcacheStoreSeMaxSize)&&
  Objects.equals(this.disableFlowProbes, objSeRuntimeProperties.disableFlowProbes)&&
  Objects.equals(this.lbactionRqPerRequestMaxRetries, objSeRuntimeProperties.lbactionRqPerRequestMaxRetries)&&
  Objects.equals(this.lbactionNumRequestsToDispatch, objSeRuntimeProperties.lbactionNumRequestsToDispatch)&&
  Objects.equals(this.logAgentFileSzDebug, objSeRuntimeProperties.logAgentFileSzDebug)&&
  Objects.equals(this.seDpVnicRestartOnQueueStallCount, objSeRuntimeProperties.seDpVnicRestartOnQueueStallCount)&&
  Objects.equals(this.connectionsUdfnfLogRateLimiterThreshold, objSeRuntimeProperties.connectionsUdfnfLogRateLimiterThreshold)&&
  Objects.equals(this.upstreamSendTimeout, objSeRuntimeProperties.upstreamSendTimeout)&&
  Objects.equals(this.logAgentMaxStorageIgnorePercent, objSeRuntimeProperties.logAgentMaxStorageIgnorePercent)&&
  Objects.equals(this.seAuthLdapReconnectTimeout, objSeRuntimeProperties.seAuthLdapReconnectTimeout)&&
  Objects.equals(this.logAgentMaxConcurrentRsync, objSeRuntimeProperties.logAgentMaxConcurrentRsync)&&
  Objects.equals(this.logAgentCompressLogs, objSeRuntimeProperties.logAgentCompressLogs)&&
  Objects.equals(this.upstreamConnpoolCoreMaxCache, objSeRuntimeProperties.upstreamConnpoolCoreMaxCache)&&
  Objects.equals(this.dpHbFrequency, objSeRuntimeProperties.dpHbFrequency)&&
  Objects.equals(this.dupipFrequency, objSeRuntimeProperties.dupipFrequency)&&
  Objects.equals(this.seDpCompression, objSeRuntimeProperties.seDpCompression)&&
  Objects.equals(this.disableGro, objSeRuntimeProperties.disableGro)&&
  Objects.equals(this.dpAggressiveHbFrequency, objSeRuntimeProperties.dpAggressiveHbFrequency)&&
  Objects.equals(this.logAgentPauseInterval, objSeRuntimeProperties.logAgentPauseInterval)&&
  Objects.equals(this.userDefinedMetricAge, objSeRuntimeProperties.userDefinedMetricAge)&&
  Objects.equals(this.seRateLimiters, objSeRuntimeProperties.seRateLimiters)&&
  Objects.equals(this.seMetricsRtEnabled, objSeRuntimeProperties.seMetricsRtEnabled)&&
  Objects.equals(this.upstreamConnpoolEnable, objSeRuntimeProperties.upstreamConnpoolEnable)&&
  Objects.equals(this.seDpVnicQueueStallThreshold, objSeRuntimeProperties.seDpVnicQueueStallThreshold)&&
  Objects.equals(this.persistenceEntriesLowWatermark, objSeRuntimeProperties.persistenceEntriesLowWatermark)&&
  Objects.equals(this.flowTableNewSynMaxEntries, objSeRuntimeProperties.flowTableNewSynMaxEntries)&&
  Objects.equals(this.seAuthLdapConnectTimeout, objSeRuntimeProperties.seAuthLdapConnectTimeout)&&
  Objects.equals(this.logAgentExportMsgBufferSize, objSeRuntimeProperties.logAgentExportMsgBufferSize)&&
  Objects.equals(this.logAgentMaxStorageExcessPercent, objSeRuntimeProperties.logAgentMaxStorageExcessPercent)&&
  Objects.equals(this.enableHsmLog, objSeRuntimeProperties.enableHsmLog)&&
  Objects.equals(this.seAuthLdapRequestTimeout, objSeRuntimeProperties.seAuthLdapRequestTimeout)&&
  Objects.equals(this.upstreamConnectTimeout, objSeRuntimeProperties.upstreamConnectTimeout)&&
  Objects.equals(this.flowTableMaxEntriesDeprecated, objSeRuntimeProperties.flowTableMaxEntriesDeprecated)&&
  Objects.equals(this.downstreamSendTimeout, objSeRuntimeProperties.downstreamSendTimeout)&&
  Objects.equals(this.logAgentFileSzEvent, objSeRuntimeProperties.logAgentFileSzEvent)&&
  Objects.equals(this.seDpLogUdfEnqueuePercent, objSeRuntimeProperties.seDpLogUdfEnqueuePercent)&&
  Objects.equals(this.spdyFwdProxyParseEnable, objSeRuntimeProperties.spdyFwdProxyParseEnable)&&
  Objects.equals(this.seDpVnicQueueStallTimeout, objSeRuntimeProperties.seDpVnicQueueStallTimeout)&&
  Objects.equals(this.scaleoutUdpPerPkt, objSeRuntimeProperties.scaleoutUdpPerPkt)&&
  Objects.equals(this.seDpHmDrops, objSeRuntimeProperties.seDpHmDrops)&&
  Objects.equals(this.seMemoryPoison, objSeRuntimeProperties.seMemoryPoison)&&
  Objects.equals(this.lbFailMaxTime, objSeRuntimeProperties.lbFailMaxTime)&&
  Objects.equals(this.seDumpCoreOnAssert, objSeRuntimeProperties.seDumpCoreOnAssert)&&
  Objects.equals(this.seMetricsInterval, objSeRuntimeProperties.seMetricsInterval)&&
  Objects.equals(this.logAgentExportWaitTime, objSeRuntimeProperties.logAgentExportWaitTime)&&
  Objects.equals(this.seDpVnicQueueStallEventSleep, objSeRuntimeProperties.seDpVnicQueueStallEventSleep)&&
  Objects.equals(this.seAuthLdapBindTimeout, objSeRuntimeProperties.seAuthLdapBindTimeout)&&
  Objects.equals(this.mcacheStoreInMinSize, objSeRuntimeProperties.mcacheStoreInMinSize)&&
  Objects.equals(this.seAuthLdapServersFailoverOnly, objSeRuntimeProperties.seAuthLdapServersFailoverOnly)&&
  Objects.equals(this.httpRumMinContentLength, objSeRuntimeProperties.httpRumMinContentLength)&&
  Objects.equals(this.globalMtu, objSeRuntimeProperties.globalMtu)&&
  Objects.equals(this.upstreamReadTimeout, objSeRuntimeProperties.upstreamReadTimeout)&&
  Objects.equals(this.seHandleInterfaceRoutes, objSeRuntimeProperties.seHandleInterfaceRoutes)&&
  Objects.equals(this.mcacheEnabled, objSeRuntimeProperties.mcacheEnabled)&&
  Objects.equals(this.upstreamKeepalive, objSeRuntimeProperties.upstreamKeepalive)&&
  Objects.equals(this.tcpSyncacheMaxRetransmitDefault, objSeRuntimeProperties.tcpSyncacheMaxRetransmitDefault)&&
  Objects.equals(this.tcpSynCacheMax, objSeRuntimeProperties.tcpSynCacheMax)&&
  Objects.equals(this.logAgentSleepInterval, objSeRuntimeProperties.logAgentSleepInterval)&&
  Objects.equals(this.maxThroughput, objSeRuntimeProperties.maxThroughput)&&
  Objects.equals(this.ngxFreeConnectionStack, objSeRuntimeProperties.ngxFreeConnectionStack)&&
  Objects.equals(this.dpHbTimeoutCount, objSeRuntimeProperties.dpHbTimeoutCount)&&
  Objects.equals(this.appHeaders, objSeRuntimeProperties.appHeaders)&&
  Objects.equals(this.mcacheStoreInMaxSize, objSeRuntimeProperties.mcacheStoreInMaxSize)&&
  Objects.equals(this.lbBatchPushFrequency, objSeRuntimeProperties.lbBatchPushFrequency);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SeRuntimeProperties {\n");
      sb.append("    adminSshEnabled: ").append(toIndentedString(adminSshEnabled)).append("\n");
        sb.append("    appHeaders: ").append(toIndentedString(appHeaders)).append("\n");
        sb.append("    baremetalDispatcherHandlesFlows: ").append(toIndentedString(baremetalDispatcherHandlesFlows)).append("\n");
        sb.append("    connectionsLossyLogRateLimiterThreshold: ").append(toIndentedString(connectionsLossyLogRateLimiterThreshold)).append("\n");
        sb.append("    connectionsUdfnfLogRateLimiterThreshold: ").append(toIndentedString(connectionsUdfnfLogRateLimiterThreshold)).append("\n");
        sb.append("    disableFlowProbes: ").append(toIndentedString(disableFlowProbes)).append("\n");
        sb.append("    disableGro: ").append(toIndentedString(disableGro)).append("\n");
        sb.append("    disableTso: ").append(toIndentedString(disableTso)).append("\n");
        sb.append("    dosProfile: ").append(toIndentedString(dosProfile)).append("\n");
        sb.append("    downstreamSendTimeout: ").append(toIndentedString(downstreamSendTimeout)).append("\n");
        sb.append("    dpAggressiveHbFrequency: ").append(toIndentedString(dpAggressiveHbFrequency)).append("\n");
        sb.append("    dpAggressiveHbTimeoutCount: ").append(toIndentedString(dpAggressiveHbTimeoutCount)).append("\n");
        sb.append("    dpHbFrequency: ").append(toIndentedString(dpHbFrequency)).append("\n");
        sb.append("    dpHbTimeoutCount: ").append(toIndentedString(dpHbTimeoutCount)).append("\n");
        sb.append("    dupipFrequency: ").append(toIndentedString(dupipFrequency)).append("\n");
        sb.append("    dupipTimeoutCount: ").append(toIndentedString(dupipTimeoutCount)).append("\n");
        sb.append("    enableHsmLog: ").append(toIndentedString(enableHsmLog)).append("\n");
        sb.append("    feproxyVipsEnableProxyArp: ").append(toIndentedString(feproxyVipsEnableProxyArp)).append("\n");
        sb.append("    flowTableBatchPushFrequency: ").append(toIndentedString(flowTableBatchPushFrequency)).append("\n");
        sb.append("    flowTableMaxEntriesDeprecated: ").append(toIndentedString(flowTableMaxEntriesDeprecated)).append("\n");
        sb.append("    flowTableNewSynMaxEntries: ").append(toIndentedString(flowTableNewSynMaxEntries)).append("\n");
        sb.append("    globalMtu: ").append(toIndentedString(globalMtu)).append("\n");
        sb.append("    httpRumConsoleLog: ").append(toIndentedString(httpRumConsoleLog)).append("\n");
        sb.append("    httpRumMinContentLength: ").append(toIndentedString(httpRumMinContentLength)).append("\n");
        sb.append("    lbBatchPushFrequency: ").append(toIndentedString(lbBatchPushFrequency)).append("\n");
        sb.append("    lbFailMaxTime: ").append(toIndentedString(lbFailMaxTime)).append("\n");
        sb.append("    lbactionNumRequestsToDispatch: ").append(toIndentedString(lbactionNumRequestsToDispatch)).append("\n");
        sb.append("    lbactionRqPerRequestMaxRetries: ").append(toIndentedString(lbactionRqPerRequestMaxRetries)).append("\n");
        sb.append("    logAgentCompressLogs: ").append(toIndentedString(logAgentCompressLogs)).append("\n");
        sb.append("    logAgentConnSendBufferSize: ").append(toIndentedString(logAgentConnSendBufferSize)).append("\n");
        sb.append("    logAgentExportMsgBufferSize: ").append(toIndentedString(logAgentExportMsgBufferSize)).append("\n");
        sb.append("    logAgentExportWaitTime: ").append(toIndentedString(logAgentExportWaitTime)).append("\n");
        sb.append("    logAgentFileSzAppl: ").append(toIndentedString(logAgentFileSzAppl)).append("\n");
        sb.append("    logAgentFileSzConn: ").append(toIndentedString(logAgentFileSzConn)).append("\n");
        sb.append("    logAgentFileSzDebug: ").append(toIndentedString(logAgentFileSzDebug)).append("\n");
        sb.append("    logAgentFileSzEvent: ").append(toIndentedString(logAgentFileSzEvent)).append("\n");
        sb.append("    logAgentLogStorageMinSz: ").append(toIndentedString(logAgentLogStorageMinSz)).append("\n");
        sb.append("    logAgentMaxActiveAdfFilesPerVs: ").append(toIndentedString(logAgentMaxActiveAdfFilesPerVs)).append("\n");
        sb.append("    logAgentMaxConcurrentRsync: ").append(toIndentedString(logAgentMaxConcurrentRsync)).append("\n");
        sb.append("    logAgentMaxLogmessageProtoSz: ").append(toIndentedString(logAgentMaxLogmessageProtoSz)).append("\n");
        sb.append("    logAgentMaxStorageExcessPercent: ").append(toIndentedString(logAgentMaxStorageExcessPercent)).append("\n");
        sb.append("    logAgentMaxStorageIgnorePercent: ").append(toIndentedString(logAgentMaxStorageIgnorePercent)).append("\n");
        sb.append("    logAgentMinStoragePerVs: ").append(toIndentedString(logAgentMinStoragePerVs)).append("\n");
        sb.append("    logAgentPauseInterval: ").append(toIndentedString(logAgentPauseInterval)).append("\n");
        sb.append("    logAgentSleepInterval: ").append(toIndentedString(logAgentSleepInterval)).append("\n");
        sb.append("    logAgentUnknownVsTimer: ").append(toIndentedString(logAgentUnknownVsTimer)).append("\n");
        sb.append("    logMessageMaxFileListSize: ").append(toIndentedString(logMessageMaxFileListSize)).append("\n");
        sb.append("    maxThroughput: ").append(toIndentedString(maxThroughput)).append("\n");
        sb.append("    mcacheEnabled: ").append(toIndentedString(mcacheEnabled)).append("\n");
        sb.append("    mcacheFetchEnabled: ").append(toIndentedString(mcacheFetchEnabled)).append("\n");
        sb.append("    mcacheMaxCacheSize: ").append(toIndentedString(mcacheMaxCacheSize)).append("\n");
        sb.append("    mcacheStoreInEnabled: ").append(toIndentedString(mcacheStoreInEnabled)).append("\n");
        sb.append("    mcacheStoreInMaxSize: ").append(toIndentedString(mcacheStoreInMaxSize)).append("\n");
        sb.append("    mcacheStoreInMinSize: ").append(toIndentedString(mcacheStoreInMinSize)).append("\n");
        sb.append("    mcacheStoreOutEnabled: ").append(toIndentedString(mcacheStoreOutEnabled)).append("\n");
        sb.append("    mcacheStoreSeMaxSize: ").append(toIndentedString(mcacheStoreSeMaxSize)).append("\n");
        sb.append("    ngxFreeConnectionStack: ").append(toIndentedString(ngxFreeConnectionStack)).append("\n");
        sb.append("    persistenceEntriesLowWatermark: ").append(toIndentedString(persistenceEntriesLowWatermark)).append("\n");
        sb.append("    persistenceMemMax: ").append(toIndentedString(persistenceMemMax)).append("\n");
        sb.append("    scaleoutUdpPerPkt: ").append(toIndentedString(scaleoutUdpPerPkt)).append("\n");
        sb.append("    seAuthLdapBindTimeout: ").append(toIndentedString(seAuthLdapBindTimeout)).append("\n");
        sb.append("    seAuthLdapCacheSize: ").append(toIndentedString(seAuthLdapCacheSize)).append("\n");
        sb.append("    seAuthLdapConnectTimeout: ").append(toIndentedString(seAuthLdapConnectTimeout)).append("\n");
        sb.append("    seAuthLdapConnsPerServer: ").append(toIndentedString(seAuthLdapConnsPerServer)).append("\n");
        sb.append("    seAuthLdapReconnectTimeout: ").append(toIndentedString(seAuthLdapReconnectTimeout)).append("\n");
        sb.append("    seAuthLdapRequestTimeout: ").append(toIndentedString(seAuthLdapRequestTimeout)).append("\n");
        sb.append("    seAuthLdapServersFailoverOnly: ").append(toIndentedString(seAuthLdapServersFailoverOnly)).append("\n");
        sb.append("    seDpCompression: ").append(toIndentedString(seDpCompression)).append("\n");
        sb.append("    seDpHmDrops: ").append(toIndentedString(seDpHmDrops)).append("\n");
        sb.append("    seDpIfStatePollInterval: ").append(toIndentedString(seDpIfStatePollInterval)).append("\n");
        sb.append("    seDpLogNfEnqueuePercent: ").append(toIndentedString(seDpLogNfEnqueuePercent)).append("\n");
        sb.append("    seDpLogUdfEnqueuePercent: ").append(toIndentedString(seDpLogUdfEnqueuePercent)).append("\n");
        sb.append("    seDpVnicQueueStallEventSleep: ").append(toIndentedString(seDpVnicQueueStallEventSleep)).append("\n");
        sb.append("    seDpVnicQueueStallThreshold: ").append(toIndentedString(seDpVnicQueueStallThreshold)).append("\n");
        sb.append("    seDpVnicQueueStallTimeout: ").append(toIndentedString(seDpVnicQueueStallTimeout)).append("\n");
        sb.append("    seDpVnicRestartOnQueueStallCount: ").append(toIndentedString(seDpVnicRestartOnQueueStallCount)).append("\n");
        sb.append("    seDpVnicStallSeRestartWindow: ").append(toIndentedString(seDpVnicStallSeRestartWindow)).append("\n");
        sb.append("    seDumpCoreOnAssert: ").append(toIndentedString(seDumpCoreOnAssert)).append("\n");
        sb.append("    seHandleInterfaceRoutes: ").append(toIndentedString(seHandleInterfaceRoutes)).append("\n");
        sb.append("    seHbPersistFudgeBits: ").append(toIndentedString(seHbPersistFudgeBits)).append("\n");
        sb.append("    seMacErrorThresholdToDisablePromiscious: ").append(toIndentedString(seMacErrorThresholdToDisablePromiscious)).append("\n");
        sb.append("    seMallocThresh: ").append(toIndentedString(seMallocThresh)).append("\n");
        sb.append("    seMemoryPoison: ").append(toIndentedString(seMemoryPoison)).append("\n");
        sb.append("    seMetricsInterval: ").append(toIndentedString(seMetricsInterval)).append("\n");
        sb.append("    seMetricsRtEnabled: ").append(toIndentedString(seMetricsRtEnabled)).append("\n");
        sb.append("    seMetricsRtInterval: ").append(toIndentedString(seMetricsRtInterval)).append("\n");
        sb.append("    sePacketBufferMax: ").append(toIndentedString(sePacketBufferMax)).append("\n");
        sb.append("    seRandomTcpDrops: ").append(toIndentedString(seRandomTcpDrops)).append("\n");
        sb.append("    seRateLimiters: ").append(toIndentedString(seRateLimiters)).append("\n");
        sb.append("    serviceIpSubnets: ").append(toIndentedString(serviceIpSubnets)).append("\n");
        sb.append("    servicePortRanges: ").append(toIndentedString(servicePortRanges)).append("\n");
        sb.append("    servicesAccessibleAllInterfaces: ").append(toIndentedString(servicesAccessibleAllInterfaces)).append("\n");
        sb.append("    spdyFwdProxyParseEnable: ").append(toIndentedString(spdyFwdProxyParseEnable)).append("\n");
        sb.append("    tcpSynCacheMax: ").append(toIndentedString(tcpSynCacheMax)).append("\n");
        sb.append("    tcpSyncacheMaxRetransmitDefault: ").append(toIndentedString(tcpSyncacheMaxRetransmitDefault)).append("\n");
        sb.append("    upstreamConnectTimeout: ").append(toIndentedString(upstreamConnectTimeout)).append("\n");
        sb.append("    upstreamConnpoolCacheThresh: ").append(toIndentedString(upstreamConnpoolCacheThresh)).append("\n");
        sb.append("    upstreamConnpoolConnIdleThreshTmo: ").append(toIndentedString(upstreamConnpoolConnIdleThreshTmo)).append("\n");
        sb.append("    upstreamConnpoolConnIdleTmo: ").append(toIndentedString(upstreamConnpoolConnIdleTmo)).append("\n");
        sb.append("    upstreamConnpoolConnLifeTmo: ").append(toIndentedString(upstreamConnpoolConnLifeTmo)).append("\n");
        sb.append("    upstreamConnpoolConnMaxReuse: ").append(toIndentedString(upstreamConnpoolConnMaxReuse)).append("\n");
        sb.append("    upstreamConnpoolCoreMaxCache: ").append(toIndentedString(upstreamConnpoolCoreMaxCache)).append("\n");
        sb.append("    upstreamConnpoolEnable: ").append(toIndentedString(upstreamConnpoolEnable)).append("\n");
        sb.append("    upstreamConnpoolServerMaxCache: ").append(toIndentedString(upstreamConnpoolServerMaxCache)).append("\n");
        sb.append("    upstreamConnpoolStrategy: ").append(toIndentedString(upstreamConnpoolStrategy)).append("\n");
        sb.append("    upstreamKeepalive: ").append(toIndentedString(upstreamKeepalive)).append("\n");
        sb.append("    upstreamReadTimeout: ").append(toIndentedString(upstreamReadTimeout)).append("\n");
        sb.append("    upstreamSendTimeout: ").append(toIndentedString(upstreamSendTimeout)).append("\n");
        sb.append("    userDefinedMetricAge: ").append(toIndentedString(userDefinedMetricAge)).append("\n");
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

