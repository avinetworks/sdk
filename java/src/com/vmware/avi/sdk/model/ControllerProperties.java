package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ControllerProperties is a POJO class extends AviRestResource that used for creating
 * ControllerProperties.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ControllerProperties extends AviRestResource  {
    @JsonProperty("allow_admin_network_updates")
    private Boolean allowAdminNetworkUpdates = false;

    @JsonProperty("allow_ip_forwarding")
    private Boolean allowIpForwarding = false;

    @JsonProperty("allow_unauthenticated_apis")
    private Boolean allowUnauthenticatedApis = false;

    @JsonProperty("allow_unauthenticated_nodes")
    private Boolean allowUnauthenticatedNodes = false;

    @JsonProperty("api_idle_timeout")
    private Integer apiIdleTimeout = 15;

    @JsonProperty("api_perf_logging_threshold")
    private Integer apiPerfLoggingThreshold = 10000;

    @JsonProperty("appviewx_compat_mode")
    private Boolean appviewxCompatMode = false;

    @JsonProperty("attach_ip_retry_interval")
    private Integer attachIpRetryInterval = 360;

    @JsonProperty("attach_ip_retry_limit")
    private Integer attachIpRetryLimit = 4;

    @JsonProperty("bm_use_ansible")
    private Boolean bmUseAnsible = true;

    @JsonProperty("cleanup_expired_authtoken_timeout_period")
    private Integer cleanupExpiredAuthtokenTimeoutPeriod = 60;

    @JsonProperty("cleanup_sessions_timeout_period")
    private Integer cleanupSessionsTimeoutPeriod = 60;

    @JsonProperty("cloud_reconcile")
    private Boolean cloudReconcile = true;

    @JsonProperty("cluster_ip_gratuitous_arp_period")
    private Integer clusterIpGratuitousArpPeriod = 60;

    @JsonProperty("consistency_check_timeout_period")
    private Integer consistencyCheckTimeoutPeriod = 60;

    @JsonProperty("crashed_se_reboot")
    private Integer crashedSeReboot = 900;

    @JsonProperty("dead_se_detection_timer")
    private Integer deadSeDetectionTimer = 360;

    @JsonProperty("default_minimum_api_timeout")
    private Integer defaultMinimumApiTimeout = 60;

    @JsonProperty("dns_refresh_period")
    private Integer dnsRefreshPeriod = 60;

    @JsonProperty("dummy")
    private Integer dummy = null;

    @JsonProperty("edit_system_limits")
    private Boolean editSystemLimits = false;

    @JsonProperty("enable_api_sharding")
    private Boolean enableApiSharding = true;

    @JsonProperty("enable_memory_balancer")
    private Boolean enableMemoryBalancer = true;

    @JsonProperty("fatal_error_lease_time")
    private Integer fatalErrorLeaseTime = 120;

    @JsonProperty("federated_datastore_cleanup_duration")
    private Integer federatedDatastoreCleanupDuration = 120;

    @JsonProperty("file_object_cleanup_period")
    private Integer fileObjectCleanupPeriod = 1440;

    @JsonProperty("max_dead_se_in_grp")
    private Integer maxDeadSeInGrp = 1;

    @JsonProperty("max_pcap_per_tenant")
    private Integer maxPcapPerTenant = 4;

    @JsonProperty("max_se_spawn_interval_delay")
    private Integer maxSeSpawnIntervalDelay = 1800;

    @JsonProperty("max_seq_attach_ip_failures")
    private Integer maxSeqAttachIpFailures = 3;

    @JsonProperty("max_seq_vnic_failures")
    private Integer maxSeqVnicFailures = 3;

    @JsonProperty("permission_scoped_shared_admin_networks")
    private Boolean permissionScopedSharedAdminNetworks = false;

    @JsonProperty("persistence_key_rotate_period")
    private Integer persistenceKeyRotatePeriod = 0;

    @JsonProperty("portal_request_burst_limit")
    private Integer portalRequestBurstLimit = 0;

    @JsonProperty("portal_request_rate_limit")
    private Integer portalRequestRateLimit = 0;

    @JsonProperty("portal_token")
    private String portalToken = null;

    @JsonProperty("process_locked_useraccounts_timeout_period")
    private Integer processLockedUseraccountsTimeoutPeriod = 1;

    @JsonProperty("process_pki_profile_timeout_period")
    private Integer processPkiProfileTimeoutPeriod = 1440;

    @JsonProperty("query_host_fail")
    private Integer queryHostFail = 180;

    @JsonProperty("safenet_hsm_version")
    private String safenetHsmVersion = null;

    @JsonProperty("se_create_timeout")
    private Integer seCreateTimeout = 900;

    @JsonProperty("se_failover_attempt_interval")
    private Integer seFailoverAttemptInterval = 300;

    @JsonProperty("se_from_marketplace")
    private String seFromMarketplace = "IMAGE";

    @JsonProperty("se_offline_del")
    private Integer seOfflineDel = 172000;

    @JsonProperty("se_spawn_retry_interval")
    private Integer seSpawnRetryInterval = 300;

    @JsonProperty("se_vnic_cooldown")
    private Integer seVnicCooldown = 120;

    @JsonProperty("secure_channel_cleanup_timeout")
    private Integer secureChannelCleanupTimeout = 60;

    @JsonProperty("secure_channel_controller_token_timeout")
    private Integer secureChannelControllerTokenTimeout = 60;

    @JsonProperty("secure_channel_se_token_timeout")
    private Integer secureChannelSeTokenTimeout = 60;

    @JsonProperty("seupgrade_copy_pool_size")
    private Integer seupgradeCopyPoolSize = 5;

    @JsonProperty("seupgrade_fabric_pool_size")
    private Integer seupgradeFabricPoolSize = 20;

    @JsonProperty("seupgrade_segroup_min_dead_timeout")
    private Integer seupgradeSegroupMinDeadTimeout = 360;

    @JsonProperty("shared_ssl_certificates")
    private Boolean sharedSslCertificates = false;

    @JsonProperty("ssl_certificate_expiry_warning_days")
    private List<Integer> sslCertificateExpiryWarningDays = null;

    @JsonProperty("unresponsive_se_reboot")
    private Integer unresponsiveSeReboot = 300;

    @JsonProperty("upgrade_dns_ttl")
    private Integer upgradeDnsTtl = 5;

    @JsonProperty("upgrade_fat_se_lease_time")
    private Integer upgradeFatSeLeaseTime = 1200;

    @JsonProperty("upgrade_lease_time")
    private Integer upgradeLeaseTime = 600;

    @JsonProperty("upgrade_se_per_vs_scale_ops_txn_time")
    private Integer upgradeSePerVsScaleOpsTxnTime = 3;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;

    @JsonProperty("vnic_op_fail_time")
    private Integer vnicOpFailTime = 180;

    @JsonProperty("vs_apic_scaleout_timeout")
    private Integer vsApicScaleoutTimeout = 360;

    @JsonProperty("vs_awaiting_se_timeout")
    private Integer vsAwaitingSeTimeout = 60;

    @JsonProperty("vs_key_rotate_period")
    private Integer vsKeyRotatePeriod = 360;

    @JsonProperty("vs_scaleout_ready_check_interval")
    private Integer vsScaleoutReadyCheckInterval = 60;

    @JsonProperty("vs_se_attach_ip_fail")
    private Integer vsSeAttachIpFail = 600;

    @JsonProperty("vs_se_bootup_fail")
    private Integer vsSeBootupFail = 480;

    @JsonProperty("vs_se_create_fail")
    private Integer vsSeCreateFail = 1500;

    @JsonProperty("vs_se_ping_fail")
    private Integer vsSePingFail = 60;

    @JsonProperty("vs_se_vnic_fail")
    private Integer vsSeVnicFail = 300;

    @JsonProperty("vs_se_vnic_ip_fail")
    private Integer vsSeVnicIpFail = 120;

    @JsonProperty("warmstart_se_reconnect_wait_time")
    private Integer warmstartSeReconnectWaitTime = 480;

    @JsonProperty("warmstart_vs_resync_wait_time")
    private Integer warmstartVsResyncWaitTime = 300;



  /**
   * This is the getter method this will return the attribute value.
   * Allow non-admin tenants to update admin vrfcontext and network objects.
   * Field introduced in 18.2.7, 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return allowAdminNetworkUpdates
   */
  public Boolean getAllowAdminNetworkUpdates() {
    return allowAdminNetworkUpdates;
  }

  /**
   * This is the setter method to the attribute.
   * Allow non-admin tenants to update admin vrfcontext and network objects.
   * Field introduced in 18.2.7, 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param allowAdminNetworkUpdates set the allowAdminNetworkUpdates.
   */
  public void setAllowAdminNetworkUpdates(Boolean  allowAdminNetworkUpdates) {
    this.allowAdminNetworkUpdates = allowAdminNetworkUpdates;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return allowIpForwarding
   */
  public Boolean getAllowIpForwarding() {
    return allowIpForwarding;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param allowIpForwarding set the allowIpForwarding.
   */
  public void setAllowIpForwarding(Boolean  allowIpForwarding) {
    this.allowIpForwarding = allowIpForwarding;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Allow unauthenticated access for special apis.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return allowUnauthenticatedApis
   */
  public Boolean getAllowUnauthenticatedApis() {
    return allowUnauthenticatedApis;
  }

  /**
   * This is the setter method to the attribute.
   * Allow unauthenticated access for special apis.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param allowUnauthenticatedApis set the allowUnauthenticatedApis.
   */
  public void setAllowUnauthenticatedApis(Boolean  allowUnauthenticatedApis) {
    this.allowUnauthenticatedApis = allowUnauthenticatedApis;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property allow_unauthenticated_nodes of obj type controllerproperties field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return allowUnauthenticatedNodes
   */
  public Boolean getAllowUnauthenticatedNodes() {
    return allowUnauthenticatedNodes;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property allow_unauthenticated_nodes of obj type controllerproperties field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param allowUnauthenticatedNodes set the allowUnauthenticatedNodes.
   */
  public void setAllowUnauthenticatedNodes(Boolean  allowUnauthenticatedNodes) {
    this.allowUnauthenticatedNodes = allowUnauthenticatedNodes;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Allowed values are 0-1440.
   * Default value when not specified in API or module is interpreted by Avi Controller as 15.
   * @return apiIdleTimeout
   */
  public Integer getApiIdleTimeout() {
    return apiIdleTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * Allowed values are 0-1440.
   * Default value when not specified in API or module is interpreted by Avi Controller as 15.
   * @param apiIdleTimeout set the apiIdleTimeout.
   */
  public void setApiIdleTimeout(Integer  apiIdleTimeout) {
    this.apiIdleTimeout = apiIdleTimeout;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Threshold to log request timing in portal_performance.log and server-timing response header.
   * Any stage taking longer than 1% of the threshold will be included in the server-timing header.
   * Field introduced in 18.1.4, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10000.
   * @return apiPerfLoggingThreshold
   */
  public Integer getApiPerfLoggingThreshold() {
    return apiPerfLoggingThreshold;
  }

  /**
   * This is the setter method to the attribute.
   * Threshold to log request timing in portal_performance.log and server-timing response header.
   * Any stage taking longer than 1% of the threshold will be included in the server-timing header.
   * Field introduced in 18.1.4, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10000.
   * @param apiPerfLoggingThreshold set the apiPerfLoggingThreshold.
   */
  public void setApiPerfLoggingThreshold(Integer  apiPerfLoggingThreshold) {
    this.apiPerfLoggingThreshold = apiPerfLoggingThreshold;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Export configuration in appviewx compatibility mode.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return appviewxCompatMode
   */
  public Boolean getAppviewxCompatMode() {
    return appviewxCompatMode;
  }

  /**
   * This is the setter method to the attribute.
   * Export configuration in appviewx compatibility mode.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param appviewxCompatMode set the appviewxCompatMode.
   */
  public void setAppviewxCompatMode(Boolean  appviewxCompatMode) {
    this.appviewxCompatMode = appviewxCompatMode;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property attach_ip_retry_interval of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 360.
   * @return attachIpRetryInterval
   */
  public Integer getAttachIpRetryInterval() {
    return attachIpRetryInterval;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property attach_ip_retry_interval of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 360.
   * @param attachIpRetryInterval set the attachIpRetryInterval.
   */
  public void setAttachIpRetryInterval(Integer  attachIpRetryInterval) {
    this.attachIpRetryInterval = attachIpRetryInterval;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property attach_ip_retry_limit of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4.
   * @return attachIpRetryLimit
   */
  public Integer getAttachIpRetryLimit() {
    return attachIpRetryLimit;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property attach_ip_retry_limit of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4.
   * @param attachIpRetryLimit set the attachIpRetryLimit.
   */
  public void setAttachIpRetryLimit(Integer  attachIpRetryLimit) {
    this.attachIpRetryLimit = attachIpRetryLimit;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Use ansible for se creation in baremetal.
   * Field introduced in 17.2.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return bmUseAnsible
   */
  public Boolean getBmUseAnsible() {
    return bmUseAnsible;
  }

  /**
   * This is the setter method to the attribute.
   * Use ansible for se creation in baremetal.
   * Field introduced in 17.2.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param bmUseAnsible set the bmUseAnsible.
   */
  public void setBmUseAnsible(Boolean  bmUseAnsible) {
    this.bmUseAnsible = bmUseAnsible;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Period for auth token cleanup job.
   * Field introduced in 18.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @return cleanupExpiredAuthtokenTimeoutPeriod
   */
  public Integer getCleanupExpiredAuthtokenTimeoutPeriod() {
    return cleanupExpiredAuthtokenTimeoutPeriod;
  }

  /**
   * This is the setter method to the attribute.
   * Period for auth token cleanup job.
   * Field introduced in 18.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @param cleanupExpiredAuthtokenTimeoutPeriod set the cleanupExpiredAuthtokenTimeoutPeriod.
   */
  public void setCleanupExpiredAuthtokenTimeoutPeriod(Integer  cleanupExpiredAuthtokenTimeoutPeriod) {
    this.cleanupExpiredAuthtokenTimeoutPeriod = cleanupExpiredAuthtokenTimeoutPeriod;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Period for sessions cleanup job.
   * Field introduced in 18.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @return cleanupSessionsTimeoutPeriod
   */
  public Integer getCleanupSessionsTimeoutPeriod() {
    return cleanupSessionsTimeoutPeriod;
  }

  /**
   * This is the setter method to the attribute.
   * Period for sessions cleanup job.
   * Field introduced in 18.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @param cleanupSessionsTimeoutPeriod set the cleanupSessionsTimeoutPeriod.
   */
  public void setCleanupSessionsTimeoutPeriod(Integer  cleanupSessionsTimeoutPeriod) {
    this.cleanupSessionsTimeoutPeriod = cleanupSessionsTimeoutPeriod;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable/disable periodic reconcile for all the clouds.
   * Field introduced in 17.2.14,18.1.5,18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return cloudReconcile
   */
  public Boolean getCloudReconcile() {
    return cloudReconcile;
  }

  /**
   * This is the setter method to the attribute.
   * Enable/disable periodic reconcile for all the clouds.
   * Field introduced in 17.2.14,18.1.5,18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param cloudReconcile set the cloudReconcile.
   */
  public void setCloudReconcile(Boolean  cloudReconcile) {
    this.cloudReconcile = cloudReconcile;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Period for cluster ip gratuitous arp job.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @return clusterIpGratuitousArpPeriod
   */
  public Integer getClusterIpGratuitousArpPeriod() {
    return clusterIpGratuitousArpPeriod;
  }

  /**
   * This is the setter method to the attribute.
   * Period for cluster ip gratuitous arp job.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @param clusterIpGratuitousArpPeriod set the clusterIpGratuitousArpPeriod.
   */
  public void setClusterIpGratuitousArpPeriod(Integer  clusterIpGratuitousArpPeriod) {
    this.clusterIpGratuitousArpPeriod = clusterIpGratuitousArpPeriod;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Period for consistency check job.
   * Field introduced in 18.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @return consistencyCheckTimeoutPeriod
   */
  public Integer getConsistencyCheckTimeoutPeriod() {
    return consistencyCheckTimeoutPeriod;
  }

  /**
   * This is the setter method to the attribute.
   * Period for consistency check job.
   * Field introduced in 18.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @param consistencyCheckTimeoutPeriod set the consistencyCheckTimeoutPeriod.
   */
  public void setConsistencyCheckTimeoutPeriod(Integer  consistencyCheckTimeoutPeriod) {
    this.consistencyCheckTimeoutPeriod = consistencyCheckTimeoutPeriod;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property crashed_se_reboot of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 900.
   * @return crashedSeReboot
   */
  public Integer getCrashedSeReboot() {
    return crashedSeReboot;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property crashed_se_reboot of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 900.
   * @param crashedSeReboot set the crashedSeReboot.
   */
  public void setCrashedSeReboot(Integer  crashedSeReboot) {
    this.crashedSeReboot = crashedSeReboot;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property dead_se_detection_timer of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 360.
   * @return deadSeDetectionTimer
   */
  public Integer getDeadSeDetectionTimer() {
    return deadSeDetectionTimer;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property dead_se_detection_timer of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 360.
   * @param deadSeDetectionTimer set the deadSeDetectionTimer.
   */
  public void setDeadSeDetectionTimer(Integer  deadSeDetectionTimer) {
    this.deadSeDetectionTimer = deadSeDetectionTimer;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Minimum api timeout value.if this value is not 60, it will be the default timeout for all apis that do not have a specific timeout.if an api has
   * a specific timeout but is less than this value, this value will become the new timeout.
   * Allowed values are 60-3600.
   * Field introduced in 18.2.6.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @return defaultMinimumApiTimeout
   */
  public Integer getDefaultMinimumApiTimeout() {
    return defaultMinimumApiTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * Minimum api timeout value.if this value is not 60, it will be the default timeout for all apis that do not have a specific timeout.if an api has
   * a specific timeout but is less than this value, this value will become the new timeout.
   * Allowed values are 60-3600.
   * Field introduced in 18.2.6.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @param defaultMinimumApiTimeout set the defaultMinimumApiTimeout.
   */
  public void setDefaultMinimumApiTimeout(Integer  defaultMinimumApiTimeout) {
    this.defaultMinimumApiTimeout = defaultMinimumApiTimeout;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Period for refresh pool and gslb dns job.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @return dnsRefreshPeriod
   */
  public Integer getDnsRefreshPeriod() {
    return dnsRefreshPeriod;
  }

  /**
   * This is the setter method to the attribute.
   * Period for refresh pool and gslb dns job.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @param dnsRefreshPeriod set the dnsRefreshPeriod.
   */
  public void setDnsRefreshPeriod(Integer  dnsRefreshPeriod) {
    this.dnsRefreshPeriod = dnsRefreshPeriod;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property dummy of obj type controllerproperties field type str  type integer.
   * @return dummy
   */
  public Integer getDummy() {
    return dummy;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property dummy of obj type controllerproperties field type str  type integer.
   * @param dummy set the dummy.
   */
  public void setDummy(Integer  dummy) {
    this.dummy = dummy;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Allow editing of system limits.
   * Keep in mind that these system limits have been carefully selected based on rigorous testing in our testig environments.
   * Modifying these limits could destabilize your cluster.
   * Do this at your own risk!.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return editSystemLimits
   */
  public Boolean getEditSystemLimits() {
    return editSystemLimits;
  }

  /**
   * This is the setter method to the attribute.
   * Allow editing of system limits.
   * Keep in mind that these system limits have been carefully selected based on rigorous testing in our testig environments.
   * Modifying these limits could destabilize your cluster.
   * Do this at your own risk!.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param editSystemLimits set the editSystemLimits.
   */
  public void setEditSystemLimits(Boolean  editSystemLimits) {
    this.editSystemLimits = editSystemLimits;
  }

  /**
   * This is the getter method this will return the attribute value.
   * This setting enables the controller leader to shard api requests to the followers (if any).
   * Field introduced in 18.1.5, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return enableApiSharding
   */
  public Boolean getEnableApiSharding() {
    return enableApiSharding;
  }

  /**
   * This is the setter method to the attribute.
   * This setting enables the controller leader to shard api requests to the followers (if any).
   * Field introduced in 18.1.5, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param enableApiSharding set the enableApiSharding.
   */
  public void setEnableApiSharding(Boolean  enableApiSharding) {
    this.enableApiSharding = enableApiSharding;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable/disable memory balancer.
   * Field introduced in 17.2.8.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return enableMemoryBalancer
   */
  public Boolean getEnableMemoryBalancer() {
    return enableMemoryBalancer;
  }

  /**
   * This is the setter method to the attribute.
   * Enable/disable memory balancer.
   * Field introduced in 17.2.8.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param enableMemoryBalancer set the enableMemoryBalancer.
   */
  public void setEnableMemoryBalancer(Boolean  enableMemoryBalancer) {
    this.enableMemoryBalancer = enableMemoryBalancer;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property fatal_error_lease_time of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 120.
   * @return fatalErrorLeaseTime
   */
  public Integer getFatalErrorLeaseTime() {
    return fatalErrorLeaseTime;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property fatal_error_lease_time of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 120.
   * @param fatalErrorLeaseTime set the fatalErrorLeaseTime.
   */
  public void setFatalErrorLeaseTime(Integer  fatalErrorLeaseTime) {
    this.fatalErrorLeaseTime = fatalErrorLeaseTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Federated datastore will not cleanup diffs unless they are at least this duration in the past.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 120.
   * @return federatedDatastoreCleanupDuration
   */
  public Integer getFederatedDatastoreCleanupDuration() {
    return federatedDatastoreCleanupDuration;
  }

  /**
   * This is the setter method to the attribute.
   * Federated datastore will not cleanup diffs unless they are at least this duration in the past.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 120.
   * @param federatedDatastoreCleanupDuration set the federatedDatastoreCleanupDuration.
   */
  public void setFederatedDatastoreCleanupDuration(Integer  federatedDatastoreCleanupDuration) {
    this.federatedDatastoreCleanupDuration = federatedDatastoreCleanupDuration;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Period for file object cleanup job.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1440.
   * @return fileObjectCleanupPeriod
   */
  public Integer getFileObjectCleanupPeriod() {
    return fileObjectCleanupPeriod;
  }

  /**
   * This is the setter method to the attribute.
   * Period for file object cleanup job.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1440.
   * @param fileObjectCleanupPeriod set the fileObjectCleanupPeriod.
   */
  public void setFileObjectCleanupPeriod(Integer  fileObjectCleanupPeriod) {
    this.fileObjectCleanupPeriod = fileObjectCleanupPeriod;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property max_dead_se_in_grp of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.
   * @return maxDeadSeInGrp
   */
  public Integer getMaxDeadSeInGrp() {
    return maxDeadSeInGrp;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property max_dead_se_in_grp of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.
   * @param maxDeadSeInGrp set the maxDeadSeInGrp.
   */
  public void setMaxDeadSeInGrp(Integer  maxDeadSeInGrp) {
    this.maxDeadSeInGrp = maxDeadSeInGrp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of pcap files stored per tenant.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4.
   * @return maxPcapPerTenant
   */
  public Integer getMaxPcapPerTenant() {
    return maxPcapPerTenant;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of pcap files stored per tenant.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4.
   * @param maxPcapPerTenant set the maxPcapPerTenant.
   */
  public void setMaxPcapPerTenant(Integer  maxPcapPerTenant) {
    this.maxPcapPerTenant = maxPcapPerTenant;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum delay possible to add to se_spawn_retry_interval after successive se spawn failure.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1800.
   * @return maxSeSpawnIntervalDelay
   */
  public Integer getMaxSeSpawnIntervalDelay() {
    return maxSeSpawnIntervalDelay;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum delay possible to add to se_spawn_retry_interval after successive se spawn failure.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1800.
   * @param maxSeSpawnIntervalDelay set the maxSeSpawnIntervalDelay.
   */
  public void setMaxSeSpawnIntervalDelay(Integer  maxSeSpawnIntervalDelay) {
    this.maxSeSpawnIntervalDelay = maxSeSpawnIntervalDelay;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of consecutive attach ip failures that halts vs placement.
   * Field introduced in 17.2.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as 3.
   * @return maxSeqAttachIpFailures
   */
  public Integer getMaxSeqAttachIpFailures() {
    return maxSeqAttachIpFailures;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of consecutive attach ip failures that halts vs placement.
   * Field introduced in 17.2.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as 3.
   * @param maxSeqAttachIpFailures set the maxSeqAttachIpFailures.
   */
  public void setMaxSeqAttachIpFailures(Integer  maxSeqAttachIpFailures) {
    this.maxSeqAttachIpFailures = maxSeqAttachIpFailures;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property max_seq_vnic_failures of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 3.
   * @return maxSeqVnicFailures
   */
  public Integer getMaxSeqVnicFailures() {
    return maxSeqVnicFailures;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property max_seq_vnic_failures of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 3.
   * @param maxSeqVnicFailures set the maxSeqVnicFailures.
   */
  public void setMaxSeqVnicFailures(Integer  maxSeqVnicFailures) {
    this.maxSeqVnicFailures = maxSeqVnicFailures;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Network and vrfcontext objects from the admin tenant will not be shared to non-admin tenants unless admin permissions are granted.
   * Field introduced in 18.2.7, 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return permissionScopedSharedAdminNetworks
   */
  public Boolean getPermissionScopedSharedAdminNetworks() {
    return permissionScopedSharedAdminNetworks;
  }

  /**
   * This is the setter method to the attribute.
   * Network and vrfcontext objects from the admin tenant will not be shared to non-admin tenants unless admin permissions are granted.
   * Field introduced in 18.2.7, 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param permissionScopedSharedAdminNetworks set the permissionScopedSharedAdminNetworks.
   */
  public void setPermissionScopedSharedAdminNetworks(Boolean  permissionScopedSharedAdminNetworks) {
    this.permissionScopedSharedAdminNetworks = permissionScopedSharedAdminNetworks;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Period for rotate app persistence keys job.
   * Allowed values are 1-1051200.
   * Special values are 0 - 'disabled'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return persistenceKeyRotatePeriod
   */
  public Integer getPersistenceKeyRotatePeriod() {
    return persistenceKeyRotatePeriod;
  }

  /**
   * This is the setter method to the attribute.
   * Period for rotate app persistence keys job.
   * Allowed values are 1-1051200.
   * Special values are 0 - 'disabled'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param persistenceKeyRotatePeriod set the persistenceKeyRotatePeriod.
   */
  public void setPersistenceKeyRotatePeriod(Integer  persistenceKeyRotatePeriod) {
    this.persistenceKeyRotatePeriod = persistenceKeyRotatePeriod;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Burst limit on number of incoming requests0 to disable.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return portalRequestBurstLimit
   */
  public Integer getPortalRequestBurstLimit() {
    return portalRequestBurstLimit;
  }

  /**
   * This is the setter method to the attribute.
   * Burst limit on number of incoming requests0 to disable.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param portalRequestBurstLimit set the portalRequestBurstLimit.
   */
  public void setPortalRequestBurstLimit(Integer  portalRequestBurstLimit) {
    this.portalRequestBurstLimit = portalRequestBurstLimit;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum average number of requests allowed per second0 to disable.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return portalRequestRateLimit
   */
  public Integer getPortalRequestRateLimit() {
    return portalRequestRateLimit;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum average number of requests allowed per second0 to disable.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param portalRequestRateLimit set the portalRequestRateLimit.
   */
  public void setPortalRequestRateLimit(Integer  portalRequestRateLimit) {
    this.portalRequestRateLimit = portalRequestRateLimit;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Token used for uploading tech-support to portal.
   * Field introduced in 16.4.6,17.1.2.
   * @return portalToken
   */
  public String getPortalToken() {
    return portalToken;
  }

  /**
   * This is the setter method to the attribute.
   * Token used for uploading tech-support to portal.
   * Field introduced in 16.4.6,17.1.2.
   * @param portalToken set the portalToken.
   */
  public void setPortalToken(String  portalToken) {
    this.portalToken = portalToken;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Period for process locked user accounts job.
   * Field introduced in 18.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.
   * @return processLockedUseraccountsTimeoutPeriod
   */
  public Integer getProcessLockedUseraccountsTimeoutPeriod() {
    return processLockedUseraccountsTimeoutPeriod;
  }

  /**
   * This is the setter method to the attribute.
   * Period for process locked user accounts job.
   * Field introduced in 18.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.
   * @param processLockedUseraccountsTimeoutPeriod set the processLockedUseraccountsTimeoutPeriod.
   */
  public void setProcessLockedUseraccountsTimeoutPeriod(Integer  processLockedUseraccountsTimeoutPeriod) {
    this.processLockedUseraccountsTimeoutPeriod = processLockedUseraccountsTimeoutPeriod;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Period for process pki profile job.
   * Field introduced in 18.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1440.
   * @return processPkiProfileTimeoutPeriod
   */
  public Integer getProcessPkiProfileTimeoutPeriod() {
    return processPkiProfileTimeoutPeriod;
  }

  /**
   * This is the setter method to the attribute.
   * Period for process pki profile job.
   * Field introduced in 18.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1440.
   * @param processPkiProfileTimeoutPeriod set the processPkiProfileTimeoutPeriod.
   */
  public void setProcessPkiProfileTimeoutPeriod(Integer  processPkiProfileTimeoutPeriod) {
    this.processPkiProfileTimeoutPeriod = processPkiProfileTimeoutPeriod;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property query_host_fail of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 180.
   * @return queryHostFail
   */
  public Integer getQueryHostFail() {
    return queryHostFail;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property query_host_fail of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 180.
   * @param queryHostFail set the queryHostFail.
   */
  public void setQueryHostFail(Integer  queryHostFail) {
    this.queryHostFail = queryHostFail;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Version of the safenet package installed on the controller.
   * Field introduced in 16.5.2,17.2.3.
   * @return safenetHsmVersion
   */
  public String getSafenetHsmVersion() {
    return safenetHsmVersion;
  }

  /**
   * This is the setter method to the attribute.
   * Version of the safenet package installed on the controller.
   * Field introduced in 16.5.2,17.2.3.
   * @param safenetHsmVersion set the safenetHsmVersion.
   */
  public void setSafenetHsmVersion(String  safenetHsmVersion) {
    this.safenetHsmVersion = safenetHsmVersion;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_create_timeout of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 900.
   * @return seCreateTimeout
   */
  public Integer getSeCreateTimeout() {
    return seCreateTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_create_timeout of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 900.
   * @param seCreateTimeout set the seCreateTimeout.
   */
  public void setSeCreateTimeout(Integer  seCreateTimeout) {
    this.seCreateTimeout = seCreateTimeout;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Interval between attempting failovers to an se.
   * Default value when not specified in API or module is interpreted by Avi Controller as 300.
   * @return seFailoverAttemptInterval
   */
  public Integer getSeFailoverAttemptInterval() {
    return seFailoverAttemptInterval;
  }

  /**
   * This is the setter method to the attribute.
   * Interval between attempting failovers to an se.
   * Default value when not specified in API or module is interpreted by Avi Controller as 300.
   * @param seFailoverAttemptInterval set the seFailoverAttemptInterval.
   */
  public void setSeFailoverAttemptInterval(Integer  seFailoverAttemptInterval) {
    this.seFailoverAttemptInterval = seFailoverAttemptInterval;
  }

  /**
   * This is the getter method this will return the attribute value.
   * This setting decides whether se is to be deployed from the cloud marketplace or to be created by the controller.
   * The setting is applicable only when byol license is selected.
   * Enum options - MARKETPLACE, IMAGE.
   * Field introduced in 18.1.4, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as IMAGE.
   * @return seFromMarketplace
   */
  public String getSeFromMarketplace() {
    return seFromMarketplace;
  }

  /**
   * This is the setter method to the attribute.
   * This setting decides whether se is to be deployed from the cloud marketplace or to be created by the controller.
   * The setting is applicable only when byol license is selected.
   * Enum options - MARKETPLACE, IMAGE.
   * Field introduced in 18.1.4, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as IMAGE.
   * @param seFromMarketplace set the seFromMarketplace.
   */
  public void setSeFromMarketplace(String  seFromMarketplace) {
    this.seFromMarketplace = seFromMarketplace;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_offline_del of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 172000.
   * @return seOfflineDel
   */
  public Integer getSeOfflineDel() {
    return seOfflineDel;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_offline_del of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 172000.
   * @param seOfflineDel set the seOfflineDel.
   */
  public void setSeOfflineDel(Integer  seOfflineDel) {
    this.seOfflineDel = seOfflineDel;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Default retry period before attempting another service engine spawn in se group.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 300.
   * @return seSpawnRetryInterval
   */
  public Integer getSeSpawnRetryInterval() {
    return seSpawnRetryInterval;
  }

  /**
   * This is the setter method to the attribute.
   * Default retry period before attempting another service engine spawn in se group.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 300.
   * @param seSpawnRetryInterval set the seSpawnRetryInterval.
   */
  public void setSeSpawnRetryInterval(Integer  seSpawnRetryInterval) {
    this.seSpawnRetryInterval = seSpawnRetryInterval;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_vnic_cooldown of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 120.
   * @return seVnicCooldown
   */
  public Integer getSeVnicCooldown() {
    return seVnicCooldown;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_vnic_cooldown of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 120.
   * @param seVnicCooldown set the seVnicCooldown.
   */
  public void setSeVnicCooldown(Integer  seVnicCooldown) {
    this.seVnicCooldown = seVnicCooldown;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Period for secure channel cleanup job.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @return secureChannelCleanupTimeout
   */
  public Integer getSecureChannelCleanupTimeout() {
    return secureChannelCleanupTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * Period for secure channel cleanup job.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @param secureChannelCleanupTimeout set the secureChannelCleanupTimeout.
   */
  public void setSecureChannelCleanupTimeout(Integer  secureChannelCleanupTimeout) {
    this.secureChannelCleanupTimeout = secureChannelCleanupTimeout;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property secure_channel_controller_token_timeout of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @return secureChannelControllerTokenTimeout
   */
  public Integer getSecureChannelControllerTokenTimeout() {
    return secureChannelControllerTokenTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property secure_channel_controller_token_timeout of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @param secureChannelControllerTokenTimeout set the secureChannelControllerTokenTimeout.
   */
  public void setSecureChannelControllerTokenTimeout(Integer  secureChannelControllerTokenTimeout) {
    this.secureChannelControllerTokenTimeout = secureChannelControllerTokenTimeout;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property secure_channel_se_token_timeout of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @return secureChannelSeTokenTimeout
   */
  public Integer getSecureChannelSeTokenTimeout() {
    return secureChannelSeTokenTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property secure_channel_se_token_timeout of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @param secureChannelSeTokenTimeout set the secureChannelSeTokenTimeout.
   */
  public void setSecureChannelSeTokenTimeout(Integer  secureChannelSeTokenTimeout) {
    this.secureChannelSeTokenTimeout = secureChannelSeTokenTimeout;
  }

  /**
   * This is the getter method this will return the attribute value.
   * This parameter defines the number of simultaneous se image downloads in a segroup.
   * It is used to pace the se downloads so that controller network/cpu bandwidth is a bounded operation.
   * A value of 0 will disable the pacing scheme and all the se(s) in the segroup will attempt to download the image.
   * Field introduced in 18.2.6.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5.
   * @return seupgradeCopyPoolSize
   */
  public Integer getSeupgradeCopyPoolSize() {
    return seupgradeCopyPoolSize;
  }

  /**
   * This is the setter method to the attribute.
   * This parameter defines the number of simultaneous se image downloads in a segroup.
   * It is used to pace the se downloads so that controller network/cpu bandwidth is a bounded operation.
   * A value of 0 will disable the pacing scheme and all the se(s) in the segroup will attempt to download the image.
   * Field introduced in 18.2.6.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5.
   * @param seupgradeCopyPoolSize set the seupgradeCopyPoolSize.
   */
  public void setSeupgradeCopyPoolSize(Integer  seupgradeCopyPoolSize) {
    this.seupgradeCopyPoolSize = seupgradeCopyPoolSize;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Pool size used for all fabric commands during se upgrade.
   * Default value when not specified in API or module is interpreted by Avi Controller as 20.
   * @return seupgradeFabricPoolSize
   */
  public Integer getSeupgradeFabricPoolSize() {
    return seupgradeFabricPoolSize;
  }

  /**
   * This is the setter method to the attribute.
   * Pool size used for all fabric commands during se upgrade.
   * Default value when not specified in API or module is interpreted by Avi Controller as 20.
   * @param seupgradeFabricPoolSize set the seupgradeFabricPoolSize.
   */
  public void setSeupgradeFabricPoolSize(Integer  seupgradeFabricPoolSize) {
    this.seupgradeFabricPoolSize = seupgradeFabricPoolSize;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Time to wait before marking segroup upgrade as stuck.
   * Default value when not specified in API or module is interpreted by Avi Controller as 360.
   * @return seupgradeSegroupMinDeadTimeout
   */
  public Integer getSeupgradeSegroupMinDeadTimeout() {
    return seupgradeSegroupMinDeadTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * Time to wait before marking segroup upgrade as stuck.
   * Default value when not specified in API or module is interpreted by Avi Controller as 360.
   * @param seupgradeSegroupMinDeadTimeout set the seupgradeSegroupMinDeadTimeout.
   */
  public void setSeupgradeSegroupMinDeadTimeout(Integer  seupgradeSegroupMinDeadTimeout) {
    this.seupgradeSegroupMinDeadTimeout = seupgradeSegroupMinDeadTimeout;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ssl certificates in the admin tenant can be used in non-admin tenants.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return sharedSslCertificates
   */
  public Boolean getSharedSslCertificates() {
    return sharedSslCertificates;
  }

  /**
   * This is the setter method to the attribute.
   * Ssl certificates in the admin tenant can be used in non-admin tenants.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param sharedSslCertificates set the sharedSslCertificates.
   */
  public void setSharedSslCertificates(Boolean  sharedSslCertificates) {
    this.sharedSslCertificates = sharedSslCertificates;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Number of days for ssl certificate expiry warning.
   * @return sslCertificateExpiryWarningDays
   */
  public List<Integer> getSslCertificateExpiryWarningDays() {
    return sslCertificateExpiryWarningDays;
  }

  /**
   * This is the setter method. this will set the sslCertificateExpiryWarningDays
   * Number of days for ssl certificate expiry warning.
   * @return sslCertificateExpiryWarningDays
   */
  public void setSslCertificateExpiryWarningDays(List<Integer>  sslCertificateExpiryWarningDays) {
    this.sslCertificateExpiryWarningDays = sslCertificateExpiryWarningDays;
  }

  /**
   * This is the setter method this will set the sslCertificateExpiryWarningDays
   * Number of days for ssl certificate expiry warning.
   * @return sslCertificateExpiryWarningDays
   */
  public ControllerProperties addSslCertificateExpiryWarningDaysItem(Integer sslCertificateExpiryWarningDaysItem) {
    if (this.sslCertificateExpiryWarningDays == null) {
      this.sslCertificateExpiryWarningDays = new ArrayList<Integer>();
    }
    this.sslCertificateExpiryWarningDays.add(sslCertificateExpiryWarningDaysItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property unresponsive_se_reboot of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 300.
   * @return unresponsiveSeReboot
   */
  public Integer getUnresponsiveSeReboot() {
    return unresponsiveSeReboot;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property unresponsive_se_reboot of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 300.
   * @param unresponsiveSeReboot set the unresponsiveSeReboot.
   */
  public void setUnresponsiveSeReboot(Integer  unresponsiveSeReboot) {
    this.unresponsiveSeReboot = unresponsiveSeReboot;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Time to account for dns ttl during upgrade.
   * This is in addition to vs_scalein_timeout_for_upgrade in se_group.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5.
   * @return upgradeDnsTtl
   */
  public Integer getUpgradeDnsTtl() {
    return upgradeDnsTtl;
  }

  /**
   * This is the setter method to the attribute.
   * Time to account for dns ttl during upgrade.
   * This is in addition to vs_scalein_timeout_for_upgrade in se_group.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5.
   * @param upgradeDnsTtl set the upgradeDnsTtl.
   */
  public void setUpgradeDnsTtl(Integer  upgradeDnsTtl) {
    this.upgradeDnsTtl = upgradeDnsTtl;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Amount of time controller waits for a large-sized se (>=128gb memory) to reconnect after it is rebooted during upgrade.
   * Field introduced in 18.2.10, 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1200.
   * @return upgradeFatSeLeaseTime
   */
  public Integer getUpgradeFatSeLeaseTime() {
    return upgradeFatSeLeaseTime;
  }

  /**
   * This is the setter method to the attribute.
   * Amount of time controller waits for a large-sized se (>=128gb memory) to reconnect after it is rebooted during upgrade.
   * Field introduced in 18.2.10, 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1200.
   * @param upgradeFatSeLeaseTime set the upgradeFatSeLeaseTime.
   */
  public void setUpgradeFatSeLeaseTime(Integer  upgradeFatSeLeaseTime) {
    this.upgradeFatSeLeaseTime = upgradeFatSeLeaseTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Amount of time controller waits for a regular-sized se (<128gb memory) to reconnect after it is rebooted during upgrade.
   * Starting 18.2.10/20.1.1, the default time has increased from 360 seconds to 600 seconds.
   * Default value when not specified in API or module is interpreted by Avi Controller as 600.
   * @return upgradeLeaseTime
   */
  public Integer getUpgradeLeaseTime() {
    return upgradeLeaseTime;
  }

  /**
   * This is the setter method to the attribute.
   * Amount of time controller waits for a regular-sized se (<128gb memory) to reconnect after it is rebooted during upgrade.
   * Starting 18.2.10/20.1.1, the default time has increased from 360 seconds to 600 seconds.
   * Default value when not specified in API or module is interpreted by Avi Controller as 600.
   * @param upgradeLeaseTime set the upgradeLeaseTime.
   */
  public void setUpgradeLeaseTime(Integer  upgradeLeaseTime) {
    this.upgradeLeaseTime = upgradeLeaseTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * This parameter defines the upper-bound value of the vs scale-in or vs scale-out operation executed in the sescalein and sescale context.
   * User can tweak this parameter to a higher value if the segroup gets suspended due to sescalein or sescaleout timeout failure typically associated
   * with high number of vs(es) scaled out.
   * Field introduced in 18.2.10, 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 3.
   * @return upgradeSePerVsScaleOpsTxnTime
   */
  public Integer getUpgradeSePerVsScaleOpsTxnTime() {
    return upgradeSePerVsScaleOpsTxnTime;
  }

  /**
   * This is the setter method to the attribute.
   * This parameter defines the upper-bound value of the vs scale-in or vs scale-out operation executed in the sescalein and sescale context.
   * User can tweak this parameter to a higher value if the segroup gets suspended due to sescalein or sescaleout timeout failure typically associated
   * with high number of vs(es) scaled out.
   * Field introduced in 18.2.10, 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 3.
   * @param upgradeSePerVsScaleOpsTxnTime set the upgradeSePerVsScaleOpsTxnTime.
   */
  public void setUpgradeSePerVsScaleOpsTxnTime(Integer  upgradeSePerVsScaleOpsTxnTime) {
    this.upgradeSePerVsScaleOpsTxnTime = upgradeSePerVsScaleOpsTxnTime;
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
   * Unique object identifier of the object.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of the object.
   * @param uuid set the uuid.
   */
  public void setUuid(String  uuid) {
    this.uuid = uuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vnic_op_fail_time of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 180.
   * @return vnicOpFailTime
   */
  public Integer getVnicOpFailTime() {
    return vnicOpFailTime;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vnic_op_fail_time of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 180.
   * @param vnicOpFailTime set the vnicOpFailTime.
   */
  public void setVnicOpFailTime(Integer  vnicOpFailTime) {
    this.vnicOpFailTime = vnicOpFailTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Time to wait for the scaled out se to become ready before marking the scaleout done, applies to apic configuration only.
   * Default value when not specified in API or module is interpreted by Avi Controller as 360.
   * @return vsApicScaleoutTimeout
   */
  public Integer getVsApicScaleoutTimeout() {
    return vsApicScaleoutTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * Time to wait for the scaled out se to become ready before marking the scaleout done, applies to apic configuration only.
   * Default value when not specified in API or module is interpreted by Avi Controller as 360.
   * @param vsApicScaleoutTimeout set the vsApicScaleoutTimeout.
   */
  public void setVsApicScaleoutTimeout(Integer  vsApicScaleoutTimeout) {
    this.vsApicScaleoutTimeout = vsApicScaleoutTimeout;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vs_awaiting_se_timeout of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @return vsAwaitingSeTimeout
   */
  public Integer getVsAwaitingSeTimeout() {
    return vsAwaitingSeTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vs_awaiting_se_timeout of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @param vsAwaitingSeTimeout set the vsAwaitingSeTimeout.
   */
  public void setVsAwaitingSeTimeout(Integer  vsAwaitingSeTimeout) {
    this.vsAwaitingSeTimeout = vsAwaitingSeTimeout;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Period for rotate vs keys job.
   * Allowed values are 1-1051200.
   * Special values are 0 - 'disabled'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 360.
   * @return vsKeyRotatePeriod
   */
  public Integer getVsKeyRotatePeriod() {
    return vsKeyRotatePeriod;
  }

  /**
   * This is the setter method to the attribute.
   * Period for rotate vs keys job.
   * Allowed values are 1-1051200.
   * Special values are 0 - 'disabled'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 360.
   * @param vsKeyRotatePeriod set the vsKeyRotatePeriod.
   */
  public void setVsKeyRotatePeriod(Integer  vsKeyRotatePeriod) {
    this.vsKeyRotatePeriod = vsKeyRotatePeriod;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Interval for checking scaleout_ready status while controller is waiting for scaleoutready rpc from the service engine.
   * Field introduced in 18.2.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @return vsScaleoutReadyCheckInterval
   */
  public Integer getVsScaleoutReadyCheckInterval() {
    return vsScaleoutReadyCheckInterval;
  }

  /**
   * This is the setter method to the attribute.
   * Interval for checking scaleout_ready status while controller is waiting for scaleoutready rpc from the service engine.
   * Field introduced in 18.2.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @param vsScaleoutReadyCheckInterval set the vsScaleoutReadyCheckInterval.
   */
  public void setVsScaleoutReadyCheckInterval(Integer  vsScaleoutReadyCheckInterval) {
    this.vsScaleoutReadyCheckInterval = vsScaleoutReadyCheckInterval;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Time to wait before marking attach ip operation on an se as failed.
   * Field introduced in 17.2.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as 600.
   * @return vsSeAttachIpFail
   */
  public Integer getVsSeAttachIpFail() {
    return vsSeAttachIpFail;
  }

  /**
   * This is the setter method to the attribute.
   * Time to wait before marking attach ip operation on an se as failed.
   * Field introduced in 17.2.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as 600.
   * @param vsSeAttachIpFail set the vsSeAttachIpFail.
   */
  public void setVsSeAttachIpFail(Integer  vsSeAttachIpFail) {
    this.vsSeAttachIpFail = vsSeAttachIpFail;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vs_se_bootup_fail of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 480.
   * @return vsSeBootupFail
   */
  public Integer getVsSeBootupFail() {
    return vsSeBootupFail;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vs_se_bootup_fail of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 480.
   * @param vsSeBootupFail set the vsSeBootupFail.
   */
  public void setVsSeBootupFail(Integer  vsSeBootupFail) {
    this.vsSeBootupFail = vsSeBootupFail;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vs_se_create_fail of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1500.
   * @return vsSeCreateFail
   */
  public Integer getVsSeCreateFail() {
    return vsSeCreateFail;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vs_se_create_fail of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1500.
   * @param vsSeCreateFail set the vsSeCreateFail.
   */
  public void setVsSeCreateFail(Integer  vsSeCreateFail) {
    this.vsSeCreateFail = vsSeCreateFail;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vs_se_ping_fail of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @return vsSePingFail
   */
  public Integer getVsSePingFail() {
    return vsSePingFail;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vs_se_ping_fail of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @param vsSePingFail set the vsSePingFail.
   */
  public void setVsSePingFail(Integer  vsSePingFail) {
    this.vsSePingFail = vsSePingFail;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vs_se_vnic_fail of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 300.
   * @return vsSeVnicFail
   */
  public Integer getVsSeVnicFail() {
    return vsSeVnicFail;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vs_se_vnic_fail of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 300.
   * @param vsSeVnicFail set the vsSeVnicFail.
   */
  public void setVsSeVnicFail(Integer  vsSeVnicFail) {
    this.vsSeVnicFail = vsSeVnicFail;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vs_se_vnic_ip_fail of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 120.
   * @return vsSeVnicIpFail
   */
  public Integer getVsSeVnicIpFail() {
    return vsSeVnicIpFail;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vs_se_vnic_ip_fail of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 120.
   * @param vsSeVnicIpFail set the vsSeVnicIpFail.
   */
  public void setVsSeVnicIpFail(Integer  vsSeVnicIpFail) {
    this.vsSeVnicIpFail = vsSeVnicIpFail;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property warmstart_se_reconnect_wait_time of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 480.
   * @return warmstartSeReconnectWaitTime
   */
  public Integer getWarmstartSeReconnectWaitTime() {
    return warmstartSeReconnectWaitTime;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property warmstart_se_reconnect_wait_time of obj type controllerproperties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 480.
   * @param warmstartSeReconnectWaitTime set the warmstartSeReconnectWaitTime.
   */
  public void setWarmstartSeReconnectWaitTime(Integer  warmstartSeReconnectWaitTime) {
    this.warmstartSeReconnectWaitTime = warmstartSeReconnectWaitTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Timeout for warmstart vs resync.
   * Field introduced in 18.1.4, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 300.
   * @return warmstartVsResyncWaitTime
   */
  public Integer getWarmstartVsResyncWaitTime() {
    return warmstartVsResyncWaitTime;
  }

  /**
   * This is the setter method to the attribute.
   * Timeout for warmstart vs resync.
   * Field introduced in 18.1.4, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 300.
   * @param warmstartVsResyncWaitTime set the warmstartVsResyncWaitTime.
   */
  public void setWarmstartVsResyncWaitTime(Integer  warmstartVsResyncWaitTime) {
    this.warmstartVsResyncWaitTime = warmstartVsResyncWaitTime;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ControllerProperties objControllerProperties = (ControllerProperties) o;
  return   Objects.equals(this.uuid, objControllerProperties.uuid)&&
  Objects.equals(this.dummy, objControllerProperties.dummy)&&
  Objects.equals(this.unresponsiveSeReboot, objControllerProperties.unresponsiveSeReboot)&&
  Objects.equals(this.crashedSeReboot, objControllerProperties.crashedSeReboot)&&
  Objects.equals(this.seOfflineDel, objControllerProperties.seOfflineDel)&&
  Objects.equals(this.vsSeCreateFail, objControllerProperties.vsSeCreateFail)&&
  Objects.equals(this.vsSeVnicFail, objControllerProperties.vsSeVnicFail)&&
  Objects.equals(this.vsSeBootupFail, objControllerProperties.vsSeBootupFail)&&
  Objects.equals(this.seVnicCooldown, objControllerProperties.seVnicCooldown)&&
  Objects.equals(this.vsSeVnicIpFail, objControllerProperties.vsSeVnicIpFail)&&
  Objects.equals(this.fatalErrorLeaseTime, objControllerProperties.fatalErrorLeaseTime)&&
  Objects.equals(this.upgradeLeaseTime, objControllerProperties.upgradeLeaseTime)&&
  Objects.equals(this.queryHostFail, objControllerProperties.queryHostFail)&&
  Objects.equals(this.vnicOpFailTime, objControllerProperties.vnicOpFailTime)&&
  Objects.equals(this.dnsRefreshPeriod, objControllerProperties.dnsRefreshPeriod)&&
  Objects.equals(this.seCreateTimeout, objControllerProperties.seCreateTimeout)&&
  Objects.equals(this.maxDeadSeInGrp, objControllerProperties.maxDeadSeInGrp)&&
  Objects.equals(this.deadSeDetectionTimer, objControllerProperties.deadSeDetectionTimer)&&
  Objects.equals(this.apiIdleTimeout, objControllerProperties.apiIdleTimeout)&&
  Objects.equals(this.allowUnauthenticatedNodes, objControllerProperties.allowUnauthenticatedNodes)&&
  Objects.equals(this.clusterIpGratuitousArpPeriod, objControllerProperties.clusterIpGratuitousArpPeriod)&&
  Objects.equals(this.vsKeyRotatePeriod, objControllerProperties.vsKeyRotatePeriod)&&
  Objects.equals(this.secureChannelControllerTokenTimeout, objControllerProperties.secureChannelControllerTokenTimeout)&&
  Objects.equals(this.secureChannelSeTokenTimeout, objControllerProperties.secureChannelSeTokenTimeout)&&
  Objects.equals(this.maxSeqVnicFailures, objControllerProperties.maxSeqVnicFailures)&&
  Objects.equals(this.vsAwaitingSeTimeout, objControllerProperties.vsAwaitingSeTimeout)&&
  Objects.equals(this.vsApicScaleoutTimeout, objControllerProperties.vsApicScaleoutTimeout)&&
  Objects.equals(this.secureChannelCleanupTimeout, objControllerProperties.secureChannelCleanupTimeout)&&
  Objects.equals(this.attachIpRetryInterval, objControllerProperties.attachIpRetryInterval)&&
  Objects.equals(this.attachIpRetryLimit, objControllerProperties.attachIpRetryLimit)&&
  Objects.equals(this.persistenceKeyRotatePeriod, objControllerProperties.persistenceKeyRotatePeriod)&&
  Objects.equals(this.allowUnauthenticatedApis, objControllerProperties.allowUnauthenticatedApis)&&
  Objects.equals(this.warmstartSeReconnectWaitTime, objControllerProperties.warmstartSeReconnectWaitTime)&&
  Objects.equals(this.vsSePingFail, objControllerProperties.vsSePingFail)&&
  Objects.equals(this.seFailoverAttemptInterval, objControllerProperties.seFailoverAttemptInterval)&&
  Objects.equals(this.maxPcapPerTenant, objControllerProperties.maxPcapPerTenant)&&
  Objects.equals(this.sslCertificateExpiryWarningDays, objControllerProperties.sslCertificateExpiryWarningDays)&&
  Objects.equals(this.seupgradeFabricPoolSize, objControllerProperties.seupgradeFabricPoolSize)&&
  Objects.equals(this.seupgradeSegroupMinDeadTimeout, objControllerProperties.seupgradeSegroupMinDeadTimeout)&&
  Objects.equals(this.allowIpForwarding, objControllerProperties.allowIpForwarding)&&
  Objects.equals(this.appviewxCompatMode, objControllerProperties.appviewxCompatMode)&&
  Objects.equals(this.upgradeDnsTtl, objControllerProperties.upgradeDnsTtl)&&
  Objects.equals(this.portalToken, objControllerProperties.portalToken)&&
  Objects.equals(this.bmUseAnsible, objControllerProperties.bmUseAnsible)&&
  Objects.equals(this.vsSeAttachIpFail, objControllerProperties.vsSeAttachIpFail)&&
  Objects.equals(this.maxSeqAttachIpFailures, objControllerProperties.maxSeqAttachIpFailures)&&
  Objects.equals(this.safenetHsmVersion, objControllerProperties.safenetHsmVersion)&&
  Objects.equals(this.cleanupExpiredAuthtokenTimeoutPeriod, objControllerProperties.cleanupExpiredAuthtokenTimeoutPeriod)&&
  Objects.equals(this.cleanupSessionsTimeoutPeriod, objControllerProperties.cleanupSessionsTimeoutPeriod)&&
  Objects.equals(this.consistencyCheckTimeoutPeriod, objControllerProperties.consistencyCheckTimeoutPeriod)&&
  Objects.equals(this.processLockedUseraccountsTimeoutPeriod, objControllerProperties.processLockedUseraccountsTimeoutPeriod)&&
  Objects.equals(this.processPkiProfileTimeoutPeriod, objControllerProperties.processPkiProfileTimeoutPeriod)&&
  Objects.equals(this.enableMemoryBalancer, objControllerProperties.enableMemoryBalancer)&&
  Objects.equals(this.warmstartVsResyncWaitTime, objControllerProperties.warmstartVsResyncWaitTime)&&
  Objects.equals(this.apiPerfLoggingThreshold, objControllerProperties.apiPerfLoggingThreshold)&&
  Objects.equals(this.seFromMarketplace, objControllerProperties.seFromMarketplace)&&
  Objects.equals(this.cloudReconcile, objControllerProperties.cloudReconcile)&&
  Objects.equals(this.enableApiSharding, objControllerProperties.enableApiSharding)&&
  Objects.equals(this.vsScaleoutReadyCheckInterval, objControllerProperties.vsScaleoutReadyCheckInterval)&&
  Objects.equals(this.sharedSslCertificates, objControllerProperties.sharedSslCertificates)&&
  Objects.equals(this.defaultMinimumApiTimeout, objControllerProperties.defaultMinimumApiTimeout)&&
  Objects.equals(this.seupgradeCopyPoolSize, objControllerProperties.seupgradeCopyPoolSize)&&
  Objects.equals(this.permissionScopedSharedAdminNetworks, objControllerProperties.permissionScopedSharedAdminNetworks)&&
  Objects.equals(this.allowAdminNetworkUpdates, objControllerProperties.allowAdminNetworkUpdates)&&
  Objects.equals(this.seSpawnRetryInterval, objControllerProperties.seSpawnRetryInterval)&&
  Objects.equals(this.maxSeSpawnIntervalDelay, objControllerProperties.maxSeSpawnIntervalDelay)&&
  Objects.equals(this.portalRequestRateLimit, objControllerProperties.portalRequestRateLimit)&&
  Objects.equals(this.portalRequestBurstLimit, objControllerProperties.portalRequestBurstLimit)&&
  Objects.equals(this.federatedDatastoreCleanupDuration, objControllerProperties.federatedDatastoreCleanupDuration)&&
  Objects.equals(this.editSystemLimits, objControllerProperties.editSystemLimits)&&
  Objects.equals(this.fileObjectCleanupPeriod, objControllerProperties.fileObjectCleanupPeriod)&&
  Objects.equals(this.upgradeFatSeLeaseTime, objControllerProperties.upgradeFatSeLeaseTime)&&
  Objects.equals(this.upgradeSePerVsScaleOpsTxnTime, objControllerProperties.upgradeSePerVsScaleOpsTxnTime);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ControllerProperties {\n");
      sb.append("    allowAdminNetworkUpdates: ").append(toIndentedString(allowAdminNetworkUpdates)).append("\n");
        sb.append("    allowIpForwarding: ").append(toIndentedString(allowIpForwarding)).append("\n");
        sb.append("    allowUnauthenticatedApis: ").append(toIndentedString(allowUnauthenticatedApis)).append("\n");
        sb.append("    allowUnauthenticatedNodes: ").append(toIndentedString(allowUnauthenticatedNodes)).append("\n");
        sb.append("    apiIdleTimeout: ").append(toIndentedString(apiIdleTimeout)).append("\n");
        sb.append("    apiPerfLoggingThreshold: ").append(toIndentedString(apiPerfLoggingThreshold)).append("\n");
        sb.append("    appviewxCompatMode: ").append(toIndentedString(appviewxCompatMode)).append("\n");
        sb.append("    attachIpRetryInterval: ").append(toIndentedString(attachIpRetryInterval)).append("\n");
        sb.append("    attachIpRetryLimit: ").append(toIndentedString(attachIpRetryLimit)).append("\n");
        sb.append("    bmUseAnsible: ").append(toIndentedString(bmUseAnsible)).append("\n");
        sb.append("    cleanupExpiredAuthtokenTimeoutPeriod: ").append(toIndentedString(cleanupExpiredAuthtokenTimeoutPeriod)).append("\n");
        sb.append("    cleanupSessionsTimeoutPeriod: ").append(toIndentedString(cleanupSessionsTimeoutPeriod)).append("\n");
        sb.append("    cloudReconcile: ").append(toIndentedString(cloudReconcile)).append("\n");
        sb.append("    clusterIpGratuitousArpPeriod: ").append(toIndentedString(clusterIpGratuitousArpPeriod)).append("\n");
        sb.append("    consistencyCheckTimeoutPeriod: ").append(toIndentedString(consistencyCheckTimeoutPeriod)).append("\n");
        sb.append("    crashedSeReboot: ").append(toIndentedString(crashedSeReboot)).append("\n");
        sb.append("    deadSeDetectionTimer: ").append(toIndentedString(deadSeDetectionTimer)).append("\n");
        sb.append("    defaultMinimumApiTimeout: ").append(toIndentedString(defaultMinimumApiTimeout)).append("\n");
        sb.append("    dnsRefreshPeriod: ").append(toIndentedString(dnsRefreshPeriod)).append("\n");
        sb.append("    dummy: ").append(toIndentedString(dummy)).append("\n");
        sb.append("    editSystemLimits: ").append(toIndentedString(editSystemLimits)).append("\n");
        sb.append("    enableApiSharding: ").append(toIndentedString(enableApiSharding)).append("\n");
        sb.append("    enableMemoryBalancer: ").append(toIndentedString(enableMemoryBalancer)).append("\n");
        sb.append("    fatalErrorLeaseTime: ").append(toIndentedString(fatalErrorLeaseTime)).append("\n");
        sb.append("    federatedDatastoreCleanupDuration: ").append(toIndentedString(federatedDatastoreCleanupDuration)).append("\n");
        sb.append("    fileObjectCleanupPeriod: ").append(toIndentedString(fileObjectCleanupPeriod)).append("\n");
        sb.append("    maxDeadSeInGrp: ").append(toIndentedString(maxDeadSeInGrp)).append("\n");
        sb.append("    maxPcapPerTenant: ").append(toIndentedString(maxPcapPerTenant)).append("\n");
        sb.append("    maxSeSpawnIntervalDelay: ").append(toIndentedString(maxSeSpawnIntervalDelay)).append("\n");
        sb.append("    maxSeqAttachIpFailures: ").append(toIndentedString(maxSeqAttachIpFailures)).append("\n");
        sb.append("    maxSeqVnicFailures: ").append(toIndentedString(maxSeqVnicFailures)).append("\n");
        sb.append("    permissionScopedSharedAdminNetworks: ").append(toIndentedString(permissionScopedSharedAdminNetworks)).append("\n");
        sb.append("    persistenceKeyRotatePeriod: ").append(toIndentedString(persistenceKeyRotatePeriod)).append("\n");
        sb.append("    portalRequestBurstLimit: ").append(toIndentedString(portalRequestBurstLimit)).append("\n");
        sb.append("    portalRequestRateLimit: ").append(toIndentedString(portalRequestRateLimit)).append("\n");
        sb.append("    portalToken: ").append(toIndentedString(portalToken)).append("\n");
        sb.append("    processLockedUseraccountsTimeoutPeriod: ").append(toIndentedString(processLockedUseraccountsTimeoutPeriod)).append("\n");
        sb.append("    processPkiProfileTimeoutPeriod: ").append(toIndentedString(processPkiProfileTimeoutPeriod)).append("\n");
        sb.append("    queryHostFail: ").append(toIndentedString(queryHostFail)).append("\n");
        sb.append("    safenetHsmVersion: ").append(toIndentedString(safenetHsmVersion)).append("\n");
        sb.append("    seCreateTimeout: ").append(toIndentedString(seCreateTimeout)).append("\n");
        sb.append("    seFailoverAttemptInterval: ").append(toIndentedString(seFailoverAttemptInterval)).append("\n");
        sb.append("    seFromMarketplace: ").append(toIndentedString(seFromMarketplace)).append("\n");
        sb.append("    seOfflineDel: ").append(toIndentedString(seOfflineDel)).append("\n");
        sb.append("    seSpawnRetryInterval: ").append(toIndentedString(seSpawnRetryInterval)).append("\n");
        sb.append("    seVnicCooldown: ").append(toIndentedString(seVnicCooldown)).append("\n");
        sb.append("    secureChannelCleanupTimeout: ").append(toIndentedString(secureChannelCleanupTimeout)).append("\n");
        sb.append("    secureChannelControllerTokenTimeout: ").append(toIndentedString(secureChannelControllerTokenTimeout)).append("\n");
        sb.append("    secureChannelSeTokenTimeout: ").append(toIndentedString(secureChannelSeTokenTimeout)).append("\n");
        sb.append("    seupgradeCopyPoolSize: ").append(toIndentedString(seupgradeCopyPoolSize)).append("\n");
        sb.append("    seupgradeFabricPoolSize: ").append(toIndentedString(seupgradeFabricPoolSize)).append("\n");
        sb.append("    seupgradeSegroupMinDeadTimeout: ").append(toIndentedString(seupgradeSegroupMinDeadTimeout)).append("\n");
        sb.append("    sharedSslCertificates: ").append(toIndentedString(sharedSslCertificates)).append("\n");
        sb.append("    sslCertificateExpiryWarningDays: ").append(toIndentedString(sslCertificateExpiryWarningDays)).append("\n");
        sb.append("    unresponsiveSeReboot: ").append(toIndentedString(unresponsiveSeReboot)).append("\n");
        sb.append("    upgradeDnsTtl: ").append(toIndentedString(upgradeDnsTtl)).append("\n");
        sb.append("    upgradeFatSeLeaseTime: ").append(toIndentedString(upgradeFatSeLeaseTime)).append("\n");
        sb.append("    upgradeLeaseTime: ").append(toIndentedString(upgradeLeaseTime)).append("\n");
        sb.append("    upgradeSePerVsScaleOpsTxnTime: ").append(toIndentedString(upgradeSePerVsScaleOpsTxnTime)).append("\n");
            sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
        sb.append("    vnicOpFailTime: ").append(toIndentedString(vnicOpFailTime)).append("\n");
        sb.append("    vsApicScaleoutTimeout: ").append(toIndentedString(vsApicScaleoutTimeout)).append("\n");
        sb.append("    vsAwaitingSeTimeout: ").append(toIndentedString(vsAwaitingSeTimeout)).append("\n");
        sb.append("    vsKeyRotatePeriod: ").append(toIndentedString(vsKeyRotatePeriod)).append("\n");
        sb.append("    vsScaleoutReadyCheckInterval: ").append(toIndentedString(vsScaleoutReadyCheckInterval)).append("\n");
        sb.append("    vsSeAttachIpFail: ").append(toIndentedString(vsSeAttachIpFail)).append("\n");
        sb.append("    vsSeBootupFail: ").append(toIndentedString(vsSeBootupFail)).append("\n");
        sb.append("    vsSeCreateFail: ").append(toIndentedString(vsSeCreateFail)).append("\n");
        sb.append("    vsSePingFail: ").append(toIndentedString(vsSePingFail)).append("\n");
        sb.append("    vsSeVnicFail: ").append(toIndentedString(vsSeVnicFail)).append("\n");
        sb.append("    vsSeVnicIpFail: ").append(toIndentedString(vsSeVnicIpFail)).append("\n");
        sb.append("    warmstartSeReconnectWaitTime: ").append(toIndentedString(warmstartSeReconnectWaitTime)).append("\n");
        sb.append("    warmstartVsResyncWaitTime: ").append(toIndentedString(warmstartVsResyncWaitTime)).append("\n");
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

