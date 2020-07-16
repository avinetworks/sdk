package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Pool is a POJO class extends AviRestResource that used for creating
 * Pool.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pool extends AviRestResource  {
    @JsonProperty("a_pool")
    private String aPool = null;

    @JsonProperty("ab_pool")
    private AbPool abPool = null;

    @JsonProperty("ab_priority")
    private Integer abPriority = null;

    @JsonProperty("analytics_policy")
    private PoolAnalyticsPolicy analyticsPolicy = null;

    @JsonProperty("analytics_profile_ref")
    private String analyticsProfileRef = null;

    @JsonProperty("apic_epg_name")
    private String apicEpgName = null;

    @JsonProperty("application_persistence_profile_ref")
    private String applicationPersistenceProfileRef = null;

    @JsonProperty("autoscale_launch_config_ref")
    private String autoscaleLaunchConfigRef = null;

    @JsonProperty("autoscale_networks")
    private List<String> autoscaleNetworks = null;

    @JsonProperty("autoscale_policy_ref")
    private String autoscalePolicyRef = null;

    @JsonProperty("capacity_estimation")
    private Boolean capacityEstimation = false;

    @JsonProperty("capacity_estimation_ttfb_thresh")
    private Integer capacityEstimationTtfbThresh = 0;

    @JsonProperty("cloud_config_cksum")
    private String cloudConfigCksum = null;

    @JsonProperty("cloud_ref")
    private String cloudRef = null;

    @JsonProperty("conn_pool_properties")
    private ConnPoolProperties connPoolProperties = null;

    @JsonProperty("connection_ramp_duration")
    private Integer connectionRampDuration = 10;

    @JsonProperty("created_by")
    private String createdBy = null;

    @JsonProperty("default_server_port")
    private Integer defaultServerPort = 80;

    @JsonProperty("delete_server_on_dns_refresh")
    private Boolean deleteServerOnDnsRefresh = true;

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("domain_name")
    private List<String> domainName = null;

    @JsonProperty("east_west")
    private Boolean eastWest = null;

    @JsonProperty("enable_http2")
    private Boolean enableHttp2 = false;

    @JsonProperty("enabled")
    private Boolean enabled = true;

    @JsonProperty("external_autoscale_groups")
    private List<String> externalAutoscaleGroups = null;

    @JsonProperty("fail_action")
    private FailAction failAction = null;

    @JsonProperty("fewest_tasks_feedback_delay")
    private Integer fewestTasksFeedbackDelay = 10;

    @JsonProperty("graceful_disable_timeout")
    private Integer gracefulDisableTimeout = 1;

    @JsonProperty("gslb_sp_enabled")
    private Boolean gslbSpEnabled = null;

    @JsonProperty("health_monitor_refs")
    private List<String> healthMonitorRefs = null;

    @JsonProperty("host_check_enabled")
    private Boolean hostCheckEnabled = false;

    @JsonProperty("ignore_server_port")
    private Boolean ignoreServerPort = false;

    @JsonProperty("inline_health_monitor")
    private Boolean inlineHealthMonitor = true;

    @JsonProperty("ipaddrgroup_ref")
    private String ipaddrgroupRef = null;

    @JsonProperty("lb_algorithm")
    private String lbAlgorithm = "LB_ALGORITHM_LEAST_CONNECTIONS";

    @JsonProperty("lb_algorithm_consistent_hash_hdr")
    private String lbAlgorithmConsistentHashHdr = null;

    @JsonProperty("lb_algorithm_core_nonaffinity")
    private Integer lbAlgorithmCoreNonaffinity = 2;

    @JsonProperty("lb_algorithm_hash")
    private String lbAlgorithmHash = "LB_ALGORITHM_CONSISTENT_HASH_SOURCE_IP_ADDRESS";

    @JsonProperty("lookup_server_by_name")
    private Boolean lookupServerByName = false;

    @JsonProperty("max_concurrent_connections_per_server")
    private Integer maxConcurrentConnectionsPerServer = 0;

    @JsonProperty("max_conn_rate_per_server")
    private RateProfile maxConnRatePerServer = null;

    @JsonProperty("min_health_monitors_up")
    private Integer minHealthMonitorsUp = null;

    @JsonProperty("min_servers_up")
    private Integer minServersUp = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("networks")
    private List<NetworkFilter> networks = null;

    @JsonProperty("nsx_securitygroup")
    private List<String> nsxSecuritygroup = null;

    @JsonProperty("pki_profile_ref")
    private String pkiProfileRef = null;

    @JsonProperty("placement_networks")
    private List<PlacementNetwork> placementNetworks = null;

    @JsonProperty("prst_hdr_name")
    private String prstHdrName = null;

    @JsonProperty("request_queue_depth")
    private Integer requestQueueDepth = 128;

    @JsonProperty("request_queue_enabled")
    private Boolean requestQueueEnabled = false;

    @JsonProperty("rewrite_host_header_to_server_name")
    private Boolean rewriteHostHeaderToServerName = false;

    @JsonProperty("rewrite_host_header_to_sni")
    private Boolean rewriteHostHeaderToSni = false;

    @JsonProperty("routing_pool")
    private Boolean routingPool = false;

    @JsonProperty("server_auto_scale")
    private Boolean serverAutoScale = null;

    @JsonProperty("server_count")
    private Integer serverCount = null;

    @JsonProperty("server_name")
    private String serverName = null;

    @JsonProperty("server_reselect")
    private HTTPServerReselect serverReselect = null;

    @JsonProperty("server_timeout")
    private Integer serverTimeout = 0;

    @JsonProperty("servers")
    private List<Server> servers = null;

    @JsonProperty("service_metadata")
    private String serviceMetadata = null;

    @JsonProperty("sni_enabled")
    private Boolean sniEnabled = true;

    @JsonProperty("ssl_key_and_certificate_ref")
    private String sslKeyAndCertificateRef = null;

    @JsonProperty("ssl_profile_ref")
    private String sslProfileRef = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("use_service_port")
    private Boolean useServicePort = false;

    @JsonProperty("uuid")
    private String uuid = null;

    @JsonProperty("vrf_ref")
    private String vrfRef = null;



  /**
   * This is the getter method this will return the attribute value.
   * Name of container cloud application that constitutes a pool in a a-b pool configuration, if different from vs app.
   * Field deprecated in 18.1.2.
   * @return aPool
   */
  public String getAPool() {
    return aPool;
  }

  /**
   * This is the setter method to the attribute.
   * Name of container cloud application that constitutes a pool in a a-b pool configuration, if different from vs app.
   * Field deprecated in 18.1.2.
   * @param aPool set the aPool.
   */
  public void setAPool(String  aPool) {
    this.aPool = aPool;
  }

  /**
   * This is the getter method this will return the attribute value.
   * A/b pool configuration.
   * Field deprecated in 18.1.2.
   * @return abPool
   */
  public AbPool getAbPool() {
    return abPool;
  }

  /**
   * This is the setter method to the attribute.
   * A/b pool configuration.
   * Field deprecated in 18.1.2.
   * @param abPool set the abPool.
   */
  public void setAbPool(AbPool abPool) {
    this.abPool = abPool;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Priority of this pool in a a-b pool pair.
   * Internally used.
   * Field deprecated in 18.1.2.
   * @return abPriority
   */
  public Integer getAbPriority() {
    return abPriority;
  }

  /**
   * This is the setter method to the attribute.
   * Priority of this pool in a a-b pool pair.
   * Internally used.
   * Field deprecated in 18.1.2.
   * @param abPriority set the abPriority.
   */
  public void setAbPriority(Integer  abPriority) {
    this.abPriority = abPriority;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Determines analytics settings for the pool.
   * Field introduced in 18.1.5, 18.2.1.
   * @return analyticsPolicy
   */
  public PoolAnalyticsPolicy getAnalyticsPolicy() {
    return analyticsPolicy;
  }

  /**
   * This is the setter method to the attribute.
   * Determines analytics settings for the pool.
   * Field introduced in 18.1.5, 18.2.1.
   * @param analyticsPolicy set the analyticsPolicy.
   */
  public void setAnalyticsPolicy(PoolAnalyticsPolicy analyticsPolicy) {
    this.analyticsPolicy = analyticsPolicy;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Specifies settings related to analytics.
   * It is a reference to an object of type analyticsprofile.
   * Field introduced in 18.1.4,18.2.1.
   * @return analyticsProfileRef
   */
  public String getAnalyticsProfileRef() {
    return analyticsProfileRef;
  }

  /**
   * This is the setter method to the attribute.
   * Specifies settings related to analytics.
   * It is a reference to an object of type analyticsprofile.
   * Field introduced in 18.1.4,18.2.1.
   * @param analyticsProfileRef set the analyticsProfileRef.
   */
  public void setAnalyticsProfileRef(String  analyticsProfileRef) {
    this.analyticsProfileRef = analyticsProfileRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Synchronize cisco apic epg members with pool servers.
   * @return apicEpgName
   */
  public String getApicEpgName() {
    return apicEpgName;
  }

  /**
   * This is the setter method to the attribute.
   * Synchronize cisco apic epg members with pool servers.
   * @param apicEpgName set the apicEpgName.
   */
  public void setApicEpgName(String  apicEpgName) {
    this.apicEpgName = apicEpgName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Persistence will ensure the same user sticks to the same server for a desired duration of time.
   * It is a reference to an object of type applicationpersistenceprofile.
   * @return applicationPersistenceProfileRef
   */
  public String getApplicationPersistenceProfileRef() {
    return applicationPersistenceProfileRef;
  }

  /**
   * This is the setter method to the attribute.
   * Persistence will ensure the same user sticks to the same server for a desired duration of time.
   * It is a reference to an object of type applicationpersistenceprofile.
   * @param applicationPersistenceProfileRef set the applicationPersistenceProfileRef.
   */
  public void setApplicationPersistenceProfileRef(String  applicationPersistenceProfileRef) {
    this.applicationPersistenceProfileRef = applicationPersistenceProfileRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * If configured then avi will trigger orchestration of pool server creation and deletion.
   * It is only supported for container clouds like mesos, opensift, kubernates, docker etc.
   * It is a reference to an object of type autoscalelaunchconfig.
   * @return autoscaleLaunchConfigRef
   */
  public String getAutoscaleLaunchConfigRef() {
    return autoscaleLaunchConfigRef;
  }

  /**
   * This is the setter method to the attribute.
   * If configured then avi will trigger orchestration of pool server creation and deletion.
   * It is only supported for container clouds like mesos, opensift, kubernates, docker etc.
   * It is a reference to an object of type autoscalelaunchconfig.
   * @param autoscaleLaunchConfigRef set the autoscaleLaunchConfigRef.
   */
  public void setAutoscaleLaunchConfigRef(String  autoscaleLaunchConfigRef) {
    this.autoscaleLaunchConfigRef = autoscaleLaunchConfigRef;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Network ids for the launch configuration.
   * @return autoscaleNetworks
   */
  public List<String> getAutoscaleNetworks() {
    return autoscaleNetworks;
  }

  /**
   * This is the setter method. this will set the autoscaleNetworks
   * Network ids for the launch configuration.
   * @return autoscaleNetworks
   */
  public void setAutoscaleNetworks(List<String>  autoscaleNetworks) {
    this.autoscaleNetworks = autoscaleNetworks;
  }

  /**
   * This is the setter method this will set the autoscaleNetworks
   * Network ids for the launch configuration.
   * @return autoscaleNetworks
   */
  public Pool addAutoscaleNetworksItem(String autoscaleNetworksItem) {
    if (this.autoscaleNetworks == null) {
      this.autoscaleNetworks = new ArrayList<String>();
    }
    this.autoscaleNetworks.add(autoscaleNetworksItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Reference to server autoscale policy.
   * It is a reference to an object of type serverautoscalepolicy.
   * @return autoscalePolicyRef
   */
  public String getAutoscalePolicyRef() {
    return autoscalePolicyRef;
  }

  /**
   * This is the setter method to the attribute.
   * Reference to server autoscale policy.
   * It is a reference to an object of type serverautoscalepolicy.
   * @param autoscalePolicyRef set the autoscalePolicyRef.
   */
  public void setAutoscalePolicyRef(String  autoscalePolicyRef) {
    this.autoscalePolicyRef = autoscalePolicyRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Inline estimation of capacity of servers.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return capacityEstimation
   */
  public Boolean getCapacityEstimation() {
    return capacityEstimation;
  }

  /**
   * This is the setter method to the attribute.
   * Inline estimation of capacity of servers.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param capacityEstimation set the capacityEstimation.
   */
  public void setCapacityEstimation(Boolean  capacityEstimation) {
    this.capacityEstimation = capacityEstimation;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The maximum time-to-first-byte of a server.
   * Allowed values are 1-5000.
   * Special values are 0 - 'automatic'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return capacityEstimationTtfbThresh
   */
  public Integer getCapacityEstimationTtfbThresh() {
    return capacityEstimationTtfbThresh;
  }

  /**
   * This is the setter method to the attribute.
   * The maximum time-to-first-byte of a server.
   * Allowed values are 1-5000.
   * Special values are 0 - 'automatic'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param capacityEstimationTtfbThresh set the capacityEstimationTtfbThresh.
   */
  public void setCapacityEstimationTtfbThresh(Integer  capacityEstimationTtfbThresh) {
    this.capacityEstimationTtfbThresh = capacityEstimationTtfbThresh;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Checksum of cloud configuration for pool.
   * Internally set by cloud connector.
   * @return cloudConfigCksum
   */
  public String getCloudConfigCksum() {
    return cloudConfigCksum;
  }

  /**
   * This is the setter method to the attribute.
   * Checksum of cloud configuration for pool.
   * Internally set by cloud connector.
   * @param cloudConfigCksum set the cloudConfigCksum.
   */
  public void setCloudConfigCksum(String  cloudConfigCksum) {
    this.cloudConfigCksum = cloudConfigCksum;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type cloud.
   * @return cloudRef
   */
  public String getCloudRef() {
    return cloudRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type cloud.
   * @param cloudRef set the cloudRef.
   */
  public void setCloudRef(String  cloudRef) {
    this.cloudRef = cloudRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Connnection pool properties.
   * Field introduced in 18.2.1.
   * @return connPoolProperties
   */
  public ConnPoolProperties getConnPoolProperties() {
    return connPoolProperties;
  }

  /**
   * This is the setter method to the attribute.
   * Connnection pool properties.
   * Field introduced in 18.2.1.
   * @param connPoolProperties set the connPoolProperties.
   */
  public void setConnPoolProperties(ConnPoolProperties connPoolProperties) {
    this.connPoolProperties = connPoolProperties;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Duration for which new connections will be gradually ramped up to a server recently brought online.
   * Useful for lb algorithms that are least connection based.
   * Allowed values are 1-300.
   * Special values are 0 - 'immediate'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.
   * @return connectionRampDuration
   */
  public Integer getConnectionRampDuration() {
    return connectionRampDuration;
  }

  /**
   * This is the setter method to the attribute.
   * Duration for which new connections will be gradually ramped up to a server recently brought online.
   * Useful for lb algorithms that are least connection based.
   * Allowed values are 1-300.
   * Special values are 0 - 'immediate'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.
   * @param connectionRampDuration set the connectionRampDuration.
   */
  public void setConnectionRampDuration(Integer  connectionRampDuration) {
    this.connectionRampDuration = connectionRampDuration;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Creator name.
   * @return createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * This is the setter method to the attribute.
   * Creator name.
   * @param createdBy set the createdBy.
   */
  public void setCreatedBy(String  createdBy) {
    this.createdBy = createdBy;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Traffic sent to servers will use this destination server port unless overridden by the server's specific port attribute.
   * The ssl checkbox enables avi to server encryption.
   * Allowed values are 1-65535.
   * Default value when not specified in API or module is interpreted by Avi Controller as 80.
   * @return defaultServerPort
   */
  public Integer getDefaultServerPort() {
    return defaultServerPort;
  }

  /**
   * This is the setter method to the attribute.
   * Traffic sent to servers will use this destination server port unless overridden by the server's specific port attribute.
   * The ssl checkbox enables avi to server encryption.
   * Allowed values are 1-65535.
   * Default value when not specified in API or module is interpreted by Avi Controller as 80.
   * @param defaultServerPort set the defaultServerPort.
   */
  public void setDefaultServerPort(Integer  defaultServerPort) {
    this.defaultServerPort = defaultServerPort;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Indicates whether existing ips are disabled(false) or deleted(true) on dns hostname refreshdetail -- on a dns refresh, some ips set on pool may
   * no longer be returned by the resolver.
   * These ips are deleted from the pool when this knob is set to true.
   * They are disabled, if the knob is set to false.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return deleteServerOnDnsRefresh
   */
  public Boolean getDeleteServerOnDnsRefresh() {
    return deleteServerOnDnsRefresh;
  }

  /**
   * This is the setter method to the attribute.
   * Indicates whether existing ips are disabled(false) or deleted(true) on dns hostname refreshdetail -- on a dns refresh, some ips set on pool may
   * no longer be returned by the resolver.
   * These ips are deleted from the pool when this knob is set to true.
   * They are disabled, if the knob is set to false.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param deleteServerOnDnsRefresh set the deleteServerOnDnsRefresh.
   */
  public void setDeleteServerOnDnsRefresh(Boolean  deleteServerOnDnsRefresh) {
    this.deleteServerOnDnsRefresh = deleteServerOnDnsRefresh;
  }

  /**
   * This is the getter method this will return the attribute value.
   * A description of the pool.
   * @return description
   */
  public String getDescription() {
    return description;
  }

  /**
   * This is the setter method to the attribute.
   * A description of the pool.
   * @param description set the description.
   */
  public void setDescription(String  description) {
    this.description = description;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Comma separated list of domain names which will be used to verify the common names or subject alternative names presented by server certificates.
   * It is performed only when common name check host_check_enabled is enabled.
   * @return domainName
   */
  public List<String> getDomainName() {
    return domainName;
  }

  /**
   * This is the setter method. this will set the domainName
   * Comma separated list of domain names which will be used to verify the common names or subject alternative names presented by server certificates.
   * It is performed only when common name check host_check_enabled is enabled.
   * @return domainName
   */
  public void setDomainName(List<String>  domainName) {
    this.domainName = domainName;
  }

  /**
   * This is the setter method this will set the domainName
   * Comma separated list of domain names which will be used to verify the common names or subject alternative names presented by server certificates.
   * It is performed only when common name check host_check_enabled is enabled.
   * @return domainName
   */
  public Pool addDomainNameItem(String domainNameItem) {
    if (this.domainName == null) {
      this.domainName = new ArrayList<String>();
    }
    this.domainName.add(domainNameItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Inherited config from virtualservice.
   * @return eastWest
   */
  public Boolean getEastWest() {
    return eastWest;
  }

  /**
   * This is the setter method to the attribute.
   * Inherited config from virtualservice.
   * @param eastWest set the eastWest.
   */
  public void setEastWest(Boolean  eastWest) {
    this.eastWest = eastWest;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable http/2 for traffic from virtualservice to all backend servers in this pool.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return enableHttp2
   */
  public Boolean getEnableHttp2() {
    return enableHttp2;
  }

  /**
   * This is the setter method to the attribute.
   * Enable http/2 for traffic from virtualservice to all backend servers in this pool.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param enableHttp2 set the enableHttp2.
   */
  public void setEnableHttp2(Boolean  enableHttp2) {
    this.enableHttp2 = enableHttp2;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable or disable the pool.
   * Disabling will terminate all open connections and pause health monitors.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return enabled
   */
  public Boolean getEnabled() {
    return enabled;
  }

  /**
   * This is the setter method to the attribute.
   * Enable or disable the pool.
   * Disabling will terminate all open connections and pause health monitors.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param enabled set the enabled.
   */
  public void setEnabled(Boolean  enabled) {
    this.enabled = enabled;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Names of external auto-scale groups for pool servers.
   * Currently available only for aws and azure.
   * Field introduced in 17.1.2.
   * @return externalAutoscaleGroups
   */
  public List<String> getExternalAutoscaleGroups() {
    return externalAutoscaleGroups;
  }

  /**
   * This is the setter method. this will set the externalAutoscaleGroups
   * Names of external auto-scale groups for pool servers.
   * Currently available only for aws and azure.
   * Field introduced in 17.1.2.
   * @return externalAutoscaleGroups
   */
  public void setExternalAutoscaleGroups(List<String>  externalAutoscaleGroups) {
    this.externalAutoscaleGroups = externalAutoscaleGroups;
  }

  /**
   * This is the setter method this will set the externalAutoscaleGroups
   * Names of external auto-scale groups for pool servers.
   * Currently available only for aws and azure.
   * Field introduced in 17.1.2.
   * @return externalAutoscaleGroups
   */
  public Pool addExternalAutoscaleGroupsItem(String externalAutoscaleGroupsItem) {
    if (this.externalAutoscaleGroups == null) {
      this.externalAutoscaleGroups = new ArrayList<String>();
    }
    this.externalAutoscaleGroups.add(externalAutoscaleGroupsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable an action - close connection, http redirect or local http response - when a pool failure happens.
   * By default, a connection will be closed, in case the pool experiences a failure.
   * @return failAction
   */
  public FailAction getFailAction() {
    return failAction;
  }

  /**
   * This is the setter method to the attribute.
   * Enable an action - close connection, http redirect or local http response - when a pool failure happens.
   * By default, a connection will be closed, in case the pool experiences a failure.
   * @param failAction set the failAction.
   */
  public void setFailAction(FailAction failAction) {
    this.failAction = failAction;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Periodicity of feedback for fewest tasks server selection algorithm.
   * Allowed values are 1-300.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.
   * @return fewestTasksFeedbackDelay
   */
  public Integer getFewestTasksFeedbackDelay() {
    return fewestTasksFeedbackDelay;
  }

  /**
   * This is the setter method to the attribute.
   * Periodicity of feedback for fewest tasks server selection algorithm.
   * Allowed values are 1-300.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.
   * @param fewestTasksFeedbackDelay set the fewestTasksFeedbackDelay.
   */
  public void setFewestTasksFeedbackDelay(Integer  fewestTasksFeedbackDelay) {
    this.fewestTasksFeedbackDelay = fewestTasksFeedbackDelay;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Used to gracefully disable a server.
   * Virtual service waits for the specified time before terminating the existing connections  to the servers that are disabled.
   * Allowed values are 1-7200.
   * Special values are 0 - 'immediate', -1 - 'infinite'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.
   * @return gracefulDisableTimeout
   */
  public Integer getGracefulDisableTimeout() {
    return gracefulDisableTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * Used to gracefully disable a server.
   * Virtual service waits for the specified time before terminating the existing connections  to the servers that are disabled.
   * Allowed values are 1-7200.
   * Special values are 0 - 'immediate', -1 - 'infinite'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.
   * @param gracefulDisableTimeout set the gracefulDisableTimeout.
   */
  public void setGracefulDisableTimeout(Integer  gracefulDisableTimeout) {
    this.gracefulDisableTimeout = gracefulDisableTimeout;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Indicates if the pool is a site-persistence pool.
   * Field introduced in 17.2.1.
   * @return gslbSpEnabled
   */
  public Boolean getGslbSpEnabled() {
    return gslbSpEnabled;
  }

  /**
   * This is the setter method to the attribute.
   * Indicates if the pool is a site-persistence pool.
   * Field introduced in 17.2.1.
   * @param gslbSpEnabled set the gslbSpEnabled.
   */
  public void setGslbSpEnabled(Boolean  gslbSpEnabled) {
    this.gslbSpEnabled = gslbSpEnabled;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Verify server health by applying one or more health monitors.
   * Active monitors generate synthetic traffic from each service engine and mark a server up or down based on the response.
   * The passive monitor listens only to client to server communication.
   * It raises or lowers the ratio of traffic destined to a server based on successful responses.
   * It is a reference to an object of type healthmonitor.
   * @return healthMonitorRefs
   */
  public List<String> getHealthMonitorRefs() {
    return healthMonitorRefs;
  }

  /**
   * This is the setter method. this will set the healthMonitorRefs
   * Verify server health by applying one or more health monitors.
   * Active monitors generate synthetic traffic from each service engine and mark a server up or down based on the response.
   * The passive monitor listens only to client to server communication.
   * It raises or lowers the ratio of traffic destined to a server based on successful responses.
   * It is a reference to an object of type healthmonitor.
   * @return healthMonitorRefs
   */
  public void setHealthMonitorRefs(List<String>  healthMonitorRefs) {
    this.healthMonitorRefs = healthMonitorRefs;
  }

  /**
   * This is the setter method this will set the healthMonitorRefs
   * Verify server health by applying one or more health monitors.
   * Active monitors generate synthetic traffic from each service engine and mark a server up or down based on the response.
   * The passive monitor listens only to client to server communication.
   * It raises or lowers the ratio of traffic destined to a server based on successful responses.
   * It is a reference to an object of type healthmonitor.
   * @return healthMonitorRefs
   */
  public Pool addHealthMonitorRefsItem(String healthMonitorRefsItem) {
    if (this.healthMonitorRefs == null) {
      this.healthMonitorRefs = new ArrayList<String>();
    }
    this.healthMonitorRefs.add(healthMonitorRefsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable common name check for server certificate.
   * If enabled and no explicit domain name is specified, avi will use the incoming host header to do the match.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return hostCheckEnabled
   */
  public Boolean getHostCheckEnabled() {
    return hostCheckEnabled;
  }

  /**
   * This is the setter method to the attribute.
   * Enable common name check for server certificate.
   * If enabled and no explicit domain name is specified, avi will use the incoming host header to do the match.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param hostCheckEnabled set the hostCheckEnabled.
   */
  public void setHostCheckEnabled(Boolean  hostCheckEnabled) {
    this.hostCheckEnabled = hostCheckEnabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ignore the server port in building the load balancing state.applicable only for consistent hash load balancing algorithm or disable port
   * translation (use_service_port) use cases.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return ignoreServerPort
   */
  public Boolean getIgnoreServerPort() {
    return ignoreServerPort;
  }

  /**
   * This is the setter method to the attribute.
   * Ignore the server port in building the load balancing state.applicable only for consistent hash load balancing algorithm or disable port
   * translation (use_service_port) use cases.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param ignoreServerPort set the ignoreServerPort.
   */
  public void setIgnoreServerPort(Boolean  ignoreServerPort) {
    this.ignoreServerPort = ignoreServerPort;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The passive monitor will monitor client to server connections and requests and adjust traffic load to servers based on successful responses.
   * This may alter the expected behavior of the lb method, such as round robin.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return inlineHealthMonitor
   */
  public Boolean getInlineHealthMonitor() {
    return inlineHealthMonitor;
  }

  /**
   * This is the setter method to the attribute.
   * The passive monitor will monitor client to server connections and requests and adjust traffic load to servers based on successful responses.
   * This may alter the expected behavior of the lb method, such as round robin.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param inlineHealthMonitor set the inlineHealthMonitor.
   */
  public void setInlineHealthMonitor(Boolean  inlineHealthMonitor) {
    this.inlineHealthMonitor = inlineHealthMonitor;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Use list of servers from ip address group.
   * It is a reference to an object of type ipaddrgroup.
   * @return ipaddrgroupRef
   */
  public String getIpaddrgroupRef() {
    return ipaddrgroupRef;
  }

  /**
   * This is the setter method to the attribute.
   * Use list of servers from ip address group.
   * It is a reference to an object of type ipaddrgroup.
   * @param ipaddrgroupRef set the ipaddrgroupRef.
   */
  public void setIpaddrgroupRef(String  ipaddrgroupRef) {
    this.ipaddrgroupRef = ipaddrgroupRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The load balancing algorithm will pick a server within the pool's list of available servers.
   * Enum options - LB_ALGORITHM_LEAST_CONNECTIONS, LB_ALGORITHM_ROUND_ROBIN, LB_ALGORITHM_FASTEST_RESPONSE, LB_ALGORITHM_CONSISTENT_HASH,
   * LB_ALGORITHM_LEAST_LOAD, LB_ALGORITHM_FEWEST_SERVERS, LB_ALGORITHM_RANDOM, LB_ALGORITHM_FEWEST_TASKS, LB_ALGORITHM_NEAREST_SERVER,
   * LB_ALGORITHM_CORE_AFFINITY, LB_ALGORITHM_TOPOLOGY.
   * Default value when not specified in API or module is interpreted by Avi Controller as LB_ALGORITHM_LEAST_CONNECTIONS.
   * @return lbAlgorithm
   */
  public String getLbAlgorithm() {
    return lbAlgorithm;
  }

  /**
   * This is the setter method to the attribute.
   * The load balancing algorithm will pick a server within the pool's list of available servers.
   * Enum options - LB_ALGORITHM_LEAST_CONNECTIONS, LB_ALGORITHM_ROUND_ROBIN, LB_ALGORITHM_FASTEST_RESPONSE, LB_ALGORITHM_CONSISTENT_HASH,
   * LB_ALGORITHM_LEAST_LOAD, LB_ALGORITHM_FEWEST_SERVERS, LB_ALGORITHM_RANDOM, LB_ALGORITHM_FEWEST_TASKS, LB_ALGORITHM_NEAREST_SERVER,
   * LB_ALGORITHM_CORE_AFFINITY, LB_ALGORITHM_TOPOLOGY.
   * Default value when not specified in API or module is interpreted by Avi Controller as LB_ALGORITHM_LEAST_CONNECTIONS.
   * @param lbAlgorithm set the lbAlgorithm.
   */
  public void setLbAlgorithm(String  lbAlgorithm) {
    this.lbAlgorithm = lbAlgorithm;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Http header name to be used for the hash key.
   * @return lbAlgorithmConsistentHashHdr
   */
  public String getLbAlgorithmConsistentHashHdr() {
    return lbAlgorithmConsistentHashHdr;
  }

  /**
   * This is the setter method to the attribute.
   * Http header name to be used for the hash key.
   * @param lbAlgorithmConsistentHashHdr set the lbAlgorithmConsistentHashHdr.
   */
  public void setLbAlgorithmConsistentHashHdr(String  lbAlgorithmConsistentHashHdr) {
    this.lbAlgorithmConsistentHashHdr = lbAlgorithmConsistentHashHdr;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Degree of non-affinity for core afffinity based server selection.
   * Allowed values are 1-65535.
   * Field introduced in 17.1.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as 2.
   * @return lbAlgorithmCoreNonaffinity
   */
  public Integer getLbAlgorithmCoreNonaffinity() {
    return lbAlgorithmCoreNonaffinity;
  }

  /**
   * This is the setter method to the attribute.
   * Degree of non-affinity for core afffinity based server selection.
   * Allowed values are 1-65535.
   * Field introduced in 17.1.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as 2.
   * @param lbAlgorithmCoreNonaffinity set the lbAlgorithmCoreNonaffinity.
   */
  public void setLbAlgorithmCoreNonaffinity(Integer  lbAlgorithmCoreNonaffinity) {
    this.lbAlgorithmCoreNonaffinity = lbAlgorithmCoreNonaffinity;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Criteria used as a key for determining the hash between the client and  server.
   * Enum options - LB_ALGORITHM_CONSISTENT_HASH_SOURCE_IP_ADDRESS, LB_ALGORITHM_CONSISTENT_HASH_SOURCE_IP_ADDRESS_AND_PORT,
   * LB_ALGORITHM_CONSISTENT_HASH_URI, LB_ALGORITHM_CONSISTENT_HASH_CUSTOM_HEADER, LB_ALGORITHM_CONSISTENT_HASH_CUSTOM_STRING,
   * LB_ALGORITHM_CONSISTENT_HASH_CALLID.
   * Default value when not specified in API or module is interpreted by Avi Controller as LB_ALGORITHM_CONSISTENT_HASH_SOURCE_IP_ADDRESS.
   * @return lbAlgorithmHash
   */
  public String getLbAlgorithmHash() {
    return lbAlgorithmHash;
  }

  /**
   * This is the setter method to the attribute.
   * Criteria used as a key for determining the hash between the client and  server.
   * Enum options - LB_ALGORITHM_CONSISTENT_HASH_SOURCE_IP_ADDRESS, LB_ALGORITHM_CONSISTENT_HASH_SOURCE_IP_ADDRESS_AND_PORT,
   * LB_ALGORITHM_CONSISTENT_HASH_URI, LB_ALGORITHM_CONSISTENT_HASH_CUSTOM_HEADER, LB_ALGORITHM_CONSISTENT_HASH_CUSTOM_STRING,
   * LB_ALGORITHM_CONSISTENT_HASH_CALLID.
   * Default value when not specified in API or module is interpreted by Avi Controller as LB_ALGORITHM_CONSISTENT_HASH_SOURCE_IP_ADDRESS.
   * @param lbAlgorithmHash set the lbAlgorithmHash.
   */
  public void setLbAlgorithmHash(String  lbAlgorithmHash) {
    this.lbAlgorithmHash = lbAlgorithmHash;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Allow server lookup by name.
   * Field introduced in 17.1.11,17.2.4.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return lookupServerByName
   */
  public Boolean getLookupServerByName() {
    return lookupServerByName;
  }

  /**
   * This is the setter method to the attribute.
   * Allow server lookup by name.
   * Field introduced in 17.1.11,17.2.4.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param lookupServerByName set the lookupServerByName.
   */
  public void setLookupServerByName(Boolean  lookupServerByName) {
    this.lookupServerByName = lookupServerByName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The maximum number of concurrent connections allowed to each server within the pool.
   * Note  applied value will be no less than the number of service engines that the pool is placed on.
   * If set to 0, no limit is applied.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return maxConcurrentConnectionsPerServer
   */
  public Integer getMaxConcurrentConnectionsPerServer() {
    return maxConcurrentConnectionsPerServer;
  }

  /**
   * This is the setter method to the attribute.
   * The maximum number of concurrent connections allowed to each server within the pool.
   * Note  applied value will be no less than the number of service engines that the pool is placed on.
   * If set to 0, no limit is applied.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param maxConcurrentConnectionsPerServer set the maxConcurrentConnectionsPerServer.
   */
  public void setMaxConcurrentConnectionsPerServer(Integer  maxConcurrentConnectionsPerServer) {
    this.maxConcurrentConnectionsPerServer = maxConcurrentConnectionsPerServer;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Rate limit connections to each server.
   * @return maxConnRatePerServer
   */
  public RateProfile getMaxConnRatePerServer() {
    return maxConnRatePerServer;
  }

  /**
   * This is the setter method to the attribute.
   * Rate limit connections to each server.
   * @param maxConnRatePerServer set the maxConnRatePerServer.
   */
  public void setMaxConnRatePerServer(RateProfile maxConnRatePerServer) {
    this.maxConnRatePerServer = maxConnRatePerServer;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Minimum number of health monitors in up state to mark server up.
   * Field introduced in 18.2.1, 17.2.12.
   * @return minHealthMonitorsUp
   */
  public Integer getMinHealthMonitorsUp() {
    return minHealthMonitorsUp;
  }

  /**
   * This is the setter method to the attribute.
   * Minimum number of health monitors in up state to mark server up.
   * Field introduced in 18.2.1, 17.2.12.
   * @param minHealthMonitorsUp set the minHealthMonitorsUp.
   */
  public void setMinHealthMonitorsUp(Integer  minHealthMonitorsUp) {
    this.minHealthMonitorsUp = minHealthMonitorsUp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Minimum number of servers in up state for marking the pool up.
   * Field introduced in 18.2.1, 17.2.12.
   * @return minServersUp
   */
  public Integer getMinServersUp() {
    return minServersUp;
  }

  /**
   * This is the setter method to the attribute.
   * Minimum number of servers in up state for marking the pool up.
   * Field introduced in 18.2.1, 17.2.12.
   * @param minServersUp set the minServersUp.
   */
  public void setMinServersUp(Integer  minServersUp) {
    this.minServersUp = minServersUp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The name of the pool.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * The name of the pool.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }
  /**
   * This is the getter method this will return the attribute value.
   * (internal-use) networks designated as containing servers for this pool.
   * The servers may be further narrowed down by a filter.
   * This field is used internally by avi, not editable by the user.
   * @return networks
   */
  public List<NetworkFilter> getNetworks() {
    return networks;
  }

  /**
   * This is the setter method. this will set the networks
   * (internal-use) networks designated as containing servers for this pool.
   * The servers may be further narrowed down by a filter.
   * This field is used internally by avi, not editable by the user.
   * @return networks
   */
  public void setNetworks(List<NetworkFilter>  networks) {
    this.networks = networks;
  }

  /**
   * This is the setter method this will set the networks
   * (internal-use) networks designated as containing servers for this pool.
   * The servers may be further narrowed down by a filter.
   * This field is used internally by avi, not editable by the user.
   * @return networks
   */
  public Pool addNetworksItem(NetworkFilter networksItem) {
    if (this.networks == null) {
      this.networks = new ArrayList<NetworkFilter>();
    }
    this.networks.add(networksItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * A list of nsx service groups where the servers for the pool are created.
   * Field introduced in 17.1.1.
   * @return nsxSecuritygroup
   */
  public List<String> getNsxSecuritygroup() {
    return nsxSecuritygroup;
  }

  /**
   * This is the setter method. this will set the nsxSecuritygroup
   * A list of nsx service groups where the servers for the pool are created.
   * Field introduced in 17.1.1.
   * @return nsxSecuritygroup
   */
  public void setNsxSecuritygroup(List<String>  nsxSecuritygroup) {
    this.nsxSecuritygroup = nsxSecuritygroup;
  }

  /**
   * This is the setter method this will set the nsxSecuritygroup
   * A list of nsx service groups where the servers for the pool are created.
   * Field introduced in 17.1.1.
   * @return nsxSecuritygroup
   */
  public Pool addNsxSecuritygroupItem(String nsxSecuritygroupItem) {
    if (this.nsxSecuritygroup == null) {
      this.nsxSecuritygroup = new ArrayList<String>();
    }
    this.nsxSecuritygroup.add(nsxSecuritygroupItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Avi will validate the ssl certificate present by a server against the selected pki profile.
   * It is a reference to an object of type pkiprofile.
   * @return pkiProfileRef
   */
  public String getPkiProfileRef() {
    return pkiProfileRef;
  }

  /**
   * This is the setter method to the attribute.
   * Avi will validate the ssl certificate present by a server against the selected pki profile.
   * It is a reference to an object of type pkiprofile.
   * @param pkiProfileRef set the pkiProfileRef.
   */
  public void setPkiProfileRef(String  pkiProfileRef) {
    this.pkiProfileRef = pkiProfileRef;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Manually select the networks and subnets used to provide reachability to the pool's servers.
   * Specify the subnet using the following syntax  10-1-1-0/24.
   * Use static routes in vrf configuration when pool servers are not directly connected butroutable from the service engine.
   * @return placementNetworks
   */
  public List<PlacementNetwork> getPlacementNetworks() {
    return placementNetworks;
  }

  /**
   * This is the setter method. this will set the placementNetworks
   * Manually select the networks and subnets used to provide reachability to the pool's servers.
   * Specify the subnet using the following syntax  10-1-1-0/24.
   * Use static routes in vrf configuration when pool servers are not directly connected butroutable from the service engine.
   * @return placementNetworks
   */
  public void setPlacementNetworks(List<PlacementNetwork>  placementNetworks) {
    this.placementNetworks = placementNetworks;
  }

  /**
   * This is the setter method this will set the placementNetworks
   * Manually select the networks and subnets used to provide reachability to the pool's servers.
   * Specify the subnet using the following syntax  10-1-1-0/24.
   * Use static routes in vrf configuration when pool servers are not directly connected butroutable from the service engine.
   * @return placementNetworks
   */
  public Pool addPlacementNetworksItem(PlacementNetwork placementNetworksItem) {
    if (this.placementNetworks == null) {
      this.placementNetworks = new ArrayList<PlacementNetwork>();
    }
    this.placementNetworks.add(placementNetworksItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Header name for custom header persistence.
   * Field deprecated in 18.1.2.
   * @return prstHdrName
   */
  public String getPrstHdrName() {
    return prstHdrName;
  }

  /**
   * This is the setter method to the attribute.
   * Header name for custom header persistence.
   * Field deprecated in 18.1.2.
   * @param prstHdrName set the prstHdrName.
   */
  public void setPrstHdrName(String  prstHdrName) {
    this.prstHdrName = prstHdrName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Minimum number of requests to be queued when pool is full.
   * Default value when not specified in API or module is interpreted by Avi Controller as 128.
   * @return requestQueueDepth
   */
  public Integer getRequestQueueDepth() {
    return requestQueueDepth;
  }

  /**
   * This is the setter method to the attribute.
   * Minimum number of requests to be queued when pool is full.
   * Default value when not specified in API or module is interpreted by Avi Controller as 128.
   * @param requestQueueDepth set the requestQueueDepth.
   */
  public void setRequestQueueDepth(Integer  requestQueueDepth) {
    this.requestQueueDepth = requestQueueDepth;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable request queue when pool is full.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return requestQueueEnabled
   */
  public Boolean getRequestQueueEnabled() {
    return requestQueueEnabled;
  }

  /**
   * This is the setter method to the attribute.
   * Enable request queue when pool is full.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param requestQueueEnabled set the requestQueueEnabled.
   */
  public void setRequestQueueEnabled(Boolean  requestQueueEnabled) {
    this.requestQueueEnabled = requestQueueEnabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Rewrite incoming host header to server name of the server to which the request is proxied.
   * Enabling this feature rewrites host header for requests to all servers in the pool.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return rewriteHostHeaderToServerName
   */
  public Boolean getRewriteHostHeaderToServerName() {
    return rewriteHostHeaderToServerName;
  }

  /**
   * This is the setter method to the attribute.
   * Rewrite incoming host header to server name of the server to which the request is proxied.
   * Enabling this feature rewrites host header for requests to all servers in the pool.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param rewriteHostHeaderToServerName set the rewriteHostHeaderToServerName.
   */
  public void setRewriteHostHeaderToServerName(Boolean  rewriteHostHeaderToServerName) {
    this.rewriteHostHeaderToServerName = rewriteHostHeaderToServerName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * If sni server name is specified, rewrite incoming host header to the sni server name.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return rewriteHostHeaderToSni
   */
  public Boolean getRewriteHostHeaderToSni() {
    return rewriteHostHeaderToSni;
  }

  /**
   * This is the setter method to the attribute.
   * If sni server name is specified, rewrite incoming host header to the sni server name.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param rewriteHostHeaderToSni set the rewriteHostHeaderToSni.
   */
  public void setRewriteHostHeaderToSni(Boolean  rewriteHostHeaderToSni) {
    this.rewriteHostHeaderToSni = rewriteHostHeaderToSni;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable to do routing when this pool is selected to send traffic.
   * No servers present in routing pool.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return routingPool
   */
  public Boolean getRoutingPool() {
    return routingPool;
  }

  /**
   * This is the setter method to the attribute.
   * Enable to do routing when this pool is selected to send traffic.
   * No servers present in routing pool.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param routingPool set the routingPool.
   */
  public void setRoutingPool(Boolean  routingPool) {
    this.routingPool = routingPool;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Server autoscale.
   * Not used anymore.
   * Field deprecated in 18.1.2.
   * @return serverAutoScale
   */
  public Boolean getServerAutoScale() {
    return serverAutoScale;
  }

  /**
   * This is the setter method to the attribute.
   * Server autoscale.
   * Not used anymore.
   * Field deprecated in 18.1.2.
   * @param serverAutoScale set the serverAutoScale.
   */
  public void setServerAutoScale(Boolean  serverAutoScale) {
    this.serverAutoScale = serverAutoScale;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field deprecated in 18.2.1.
   * @return serverCount
   */
  public Integer getServerCount() {
    return serverCount;
  }

  /**
   * This is the setter method to the attribute.
   * Field deprecated in 18.2.1.
   * @param serverCount set the serverCount.
   */
  public void setServerCount(Integer  serverCount) {
    this.serverCount = serverCount;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Fully qualified dns hostname which will be used in the tls sni extension in server connections if sni is enabled.
   * If no value is specified, avi will use the incoming host header instead.
   * @return serverName
   */
  public String getServerName() {
    return serverName;
  }

  /**
   * This is the setter method to the attribute.
   * Fully qualified dns hostname which will be used in the tls sni extension in server connections if sni is enabled.
   * If no value is specified, avi will use the incoming host header instead.
   * @param serverName set the serverName.
   */
  public void setServerName(String  serverName) {
    this.serverName = serverName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Server reselect configuration for http requests.
   * @return serverReselect
   */
  public HTTPServerReselect getServerReselect() {
    return serverReselect;
  }

  /**
   * This is the setter method to the attribute.
   * Server reselect configuration for http requests.
   * @param serverReselect set the serverReselect.
   */
  public void setServerReselect(HTTPServerReselect serverReselect) {
    this.serverReselect = serverReselect;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Server timeout value specifies the time within which a server connection needs to be established and a request-response exchange completes
   * between avi and the server.
   * Value of 0 results in using default timeout of 60 minutes.
   * Allowed values are 0-3600000.
   * Field introduced in 18.1.5,18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return serverTimeout
   */
  public Integer getServerTimeout() {
    return serverTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * Server timeout value specifies the time within which a server connection needs to be established and a request-response exchange completes
   * between avi and the server.
   * Value of 0 results in using default timeout of 60 minutes.
   * Allowed values are 0-3600000.
   * Field introduced in 18.1.5,18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param serverTimeout set the serverTimeout.
   */
  public void setServerTimeout(Integer  serverTimeout) {
    this.serverTimeout = serverTimeout;
  }
  /**
   * This is the getter method this will return the attribute value.
   * The pool directs load balanced traffic to this list of destination servers.
   * The servers can be configured by ip address, name, network or via ip address group.
   * @return servers
   */
  public List<Server> getServers() {
    return servers;
  }

  /**
   * This is the setter method. this will set the servers
   * The pool directs load balanced traffic to this list of destination servers.
   * The servers can be configured by ip address, name, network or via ip address group.
   * @return servers
   */
  public void setServers(List<Server>  servers) {
    this.servers = servers;
  }

  /**
   * This is the setter method this will set the servers
   * The pool directs load balanced traffic to this list of destination servers.
   * The servers can be configured by ip address, name, network or via ip address group.
   * @return servers
   */
  public Pool addServersItem(Server serversItem) {
    if (this.servers == null) {
      this.servers = new ArrayList<Server>();
    }
    this.servers.add(serversItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Metadata pertaining to the service provided by this pool.
   * In openshift/kubernetes environments, app metadata info is stored.
   * Any user input to this field will be overwritten by avi vantage.
   * Field introduced in 17.2.14,18.1.5,18.2.1.
   * @return serviceMetadata
   */
  public String getServiceMetadata() {
    return serviceMetadata;
  }

  /**
   * This is the setter method to the attribute.
   * Metadata pertaining to the service provided by this pool.
   * In openshift/kubernetes environments, app metadata info is stored.
   * Any user input to this field will be overwritten by avi vantage.
   * Field introduced in 17.2.14,18.1.5,18.2.1.
   * @param serviceMetadata set the serviceMetadata.
   */
  public void setServiceMetadata(String  serviceMetadata) {
    this.serviceMetadata = serviceMetadata;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable tls sni for server connections.
   * If disabled, avi will not send the sni extension as part of the handshake.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return sniEnabled
   */
  public Boolean getSniEnabled() {
    return sniEnabled;
  }

  /**
   * This is the setter method to the attribute.
   * Enable tls sni for server connections.
   * If disabled, avi will not send the sni extension as part of the handshake.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param sniEnabled set the sniEnabled.
   */
  public void setSniEnabled(Boolean  sniEnabled) {
    this.sniEnabled = sniEnabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Service engines will present a client ssl certificate to the server.
   * It is a reference to an object of type sslkeyandcertificate.
   * @return sslKeyAndCertificateRef
   */
  public String getSslKeyAndCertificateRef() {
    return sslKeyAndCertificateRef;
  }

  /**
   * This is the setter method to the attribute.
   * Service engines will present a client ssl certificate to the server.
   * It is a reference to an object of type sslkeyandcertificate.
   * @param sslKeyAndCertificateRef set the sslKeyAndCertificateRef.
   */
  public void setSslKeyAndCertificateRef(String  sslKeyAndCertificateRef) {
    this.sslKeyAndCertificateRef = sslKeyAndCertificateRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * When enabled, avi re-encrypts traffic to the backend servers.
   * The specific ssl profile defines which ciphers and ssl versions will be supported.
   * It is a reference to an object of type sslprofile.
   * @return sslProfileRef
   */
  public String getSslProfileRef() {
    return sslProfileRef;
  }

  /**
   * This is the setter method to the attribute.
   * When enabled, avi re-encrypts traffic to the backend servers.
   * The specific ssl profile defines which ciphers and ssl versions will be supported.
   * It is a reference to an object of type sslprofile.
   * @param sslProfileRef set the sslProfileRef.
   */
  public void setSslProfileRef(String  sslProfileRef) {
    this.sslProfileRef = sslProfileRef;
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
   * Do not translate the client's destination port when sending the connection to the server.
   * The pool or servers specified service port will still be used for health monitoring.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return useServicePort
   */
  public Boolean getUseServicePort() {
    return useServicePort;
  }

  /**
   * This is the setter method to the attribute.
   * Do not translate the client's destination port when sending the connection to the server.
   * The pool or servers specified service port will still be used for health monitoring.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param useServicePort set the useServicePort.
   */
  public void setUseServicePort(Boolean  useServicePort) {
    this.useServicePort = useServicePort;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Uuid of the pool.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the pool.
   * @param uuid set the uuid.
   */
  public void setUuid(String  uuid) {
    this.uuid = uuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Virtual routing context that the pool is bound to.
   * This is used to provide the isolation of the set of networks the pool is attached to.
   * The pool inherits the virtual routing conext of the virtual service, and this field is used only internally, and is set by pb-transform.
   * It is a reference to an object of type vrfcontext.
   * @return vrfRef
   */
  public String getVrfRef() {
    return vrfRef;
  }

  /**
   * This is the setter method to the attribute.
   * Virtual routing context that the pool is bound to.
   * This is used to provide the isolation of the set of networks the pool is attached to.
   * The pool inherits the virtual routing conext of the virtual service, and this field is used only internally, and is set by pb-transform.
   * It is a reference to an object of type vrfcontext.
   * @param vrfRef set the vrfRef.
   */
  public void setVrfRef(String  vrfRef) {
    this.vrfRef = vrfRef;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  Pool objPool = (Pool) o;
  return   Objects.equals(this.lbAlgorithm, objPool.lbAlgorithm)&&
  Objects.equals(this.useServicePort, objPool.useServicePort)&&
  Objects.equals(this.serverAutoScale, objPool.serverAutoScale)&&
  Objects.equals(this.applicationPersistenceProfileRef, objPool.applicationPersistenceProfileRef)&&
  Objects.equals(this.hostCheckEnabled, objPool.hostCheckEnabled)&&
  Objects.equals(this.connPoolProperties, objPool.connPoolProperties)&&
  Objects.equals(this.rewriteHostHeaderToSni, objPool.rewriteHostHeaderToSni)&&
  Objects.equals(this.deleteServerOnDnsRefresh, objPool.deleteServerOnDnsRefresh)&&
  Objects.equals(this.capacityEstimation, objPool.capacityEstimation)&&
  Objects.equals(this.maxConnRatePerServer, objPool.maxConnRatePerServer)&&
  Objects.equals(this.servers, objPool.servers)&&
  Objects.equals(this.fewestTasksFeedbackDelay, objPool.fewestTasksFeedbackDelay)&&
  Objects.equals(this.rewriteHostHeaderToServerName, objPool.rewriteHostHeaderToServerName)&&
  Objects.equals(this.createdBy, objPool.createdBy)&&
  Objects.equals(this.abPool, objPool.abPool)&&
  Objects.equals(this.capacityEstimationTtfbThresh, objPool.capacityEstimationTtfbThresh)&&
  Objects.equals(this.failAction, objPool.failAction)&&
  Objects.equals(this.apicEpgName, objPool.apicEpgName)&&
  Objects.equals(this.networks, objPool.networks)&&
  Objects.equals(this.lbAlgorithmHash, objPool.lbAlgorithmHash)&&
  Objects.equals(this.autoscaleLaunchConfigRef, objPool.autoscaleLaunchConfigRef)&&
  Objects.equals(this.lookupServerByName, objPool.lookupServerByName)&&
  Objects.equals(this.uuid, objPool.uuid)&&
  Objects.equals(this.serverName, objPool.serverName)&&
  Objects.equals(this.minServersUp, objPool.minServersUp)&&
  Objects.equals(this.domainName, objPool.domainName)&&
  Objects.equals(this.connectionRampDuration, objPool.connectionRampDuration)&&
  Objects.equals(this.eastWest, objPool.eastWest)&&
  Objects.equals(this.placementNetworks, objPool.placementNetworks)&&
  Objects.equals(this.serverReselect, objPool.serverReselect)&&
  Objects.equals(this.analyticsProfileRef, objPool.analyticsProfileRef)&&
  Objects.equals(this.enableHttp2, objPool.enableHttp2)&&
  Objects.equals(this.nsxSecuritygroup, objPool.nsxSecuritygroup)&&
  Objects.equals(this.aPool, objPool.aPool)&&
  Objects.equals(this.lbAlgorithmCoreNonaffinity, objPool.lbAlgorithmCoreNonaffinity)&&
  Objects.equals(this.minHealthMonitorsUp, objPool.minHealthMonitorsUp)&&
  Objects.equals(this.pkiProfileRef, objPool.pkiProfileRef)&&
  Objects.equals(this.autoscalePolicyRef, objPool.autoscalePolicyRef)&&
  Objects.equals(this.inlineHealthMonitor, objPool.inlineHealthMonitor)&&
  Objects.equals(this.defaultServerPort, objPool.defaultServerPort)&&
  Objects.equals(this.description, objPool.description)&&
  Objects.equals(this.requestQueueDepth, objPool.requestQueueDepth)&&
  Objects.equals(this.ipaddrgroupRef, objPool.ipaddrgroupRef)&&
  Objects.equals(this.gracefulDisableTimeout, objPool.gracefulDisableTimeout)&&
  Objects.equals(this.sslKeyAndCertificateRef, objPool.sslKeyAndCertificateRef)&&
  Objects.equals(this.abPriority, objPool.abPriority)&&
  Objects.equals(this.routingPool, objPool.routingPool)&&
  Objects.equals(this.vrfRef, objPool.vrfRef)&&
  Objects.equals(this.serverCount, objPool.serverCount)&&
  Objects.equals(this.sniEnabled, objPool.sniEnabled)&&
  Objects.equals(this.serverTimeout, objPool.serverTimeout)&&
  Objects.equals(this.requestQueueEnabled, objPool.requestQueueEnabled)&&
  Objects.equals(this.name, objPool.name)&&
  Objects.equals(this.maxConcurrentConnectionsPerServer, objPool.maxConcurrentConnectionsPerServer)&&
  Objects.equals(this.ignoreServerPort, objPool.ignoreServerPort)&&
  Objects.equals(this.serviceMetadata, objPool.serviceMetadata)&&
  Objects.equals(this.prstHdrName, objPool.prstHdrName)&&
  Objects.equals(this.enabled, objPool.enabled)&&
  Objects.equals(this.autoscaleNetworks, objPool.autoscaleNetworks)&&
  Objects.equals(this.healthMonitorRefs, objPool.healthMonitorRefs)&&
  Objects.equals(this.lbAlgorithmConsistentHashHdr, objPool.lbAlgorithmConsistentHashHdr)&&
  Objects.equals(this.sslProfileRef, objPool.sslProfileRef)&&
  Objects.equals(this.cloudConfigCksum, objPool.cloudConfigCksum)&&
  Objects.equals(this.analyticsPolicy, objPool.analyticsPolicy)&&
  Objects.equals(this.externalAutoscaleGroups, objPool.externalAutoscaleGroups)&&
  Objects.equals(this.cloudRef, objPool.cloudRef)&&
  Objects.equals(this.tenantRef, objPool.tenantRef)&&
  Objects.equals(this.gslbSpEnabled, objPool.gslbSpEnabled);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class Pool {\n");
      sb.append("    aPool: ").append(toIndentedString(aPool)).append("\n");
        sb.append("    abPool: ").append(toIndentedString(abPool)).append("\n");
        sb.append("    abPriority: ").append(toIndentedString(abPriority)).append("\n");
        sb.append("    analyticsPolicy: ").append(toIndentedString(analyticsPolicy)).append("\n");
        sb.append("    analyticsProfileRef: ").append(toIndentedString(analyticsProfileRef)).append("\n");
        sb.append("    apicEpgName: ").append(toIndentedString(apicEpgName)).append("\n");
        sb.append("    applicationPersistenceProfileRef: ").append(toIndentedString(applicationPersistenceProfileRef)).append("\n");
        sb.append("    autoscaleLaunchConfigRef: ").append(toIndentedString(autoscaleLaunchConfigRef)).append("\n");
        sb.append("    autoscaleNetworks: ").append(toIndentedString(autoscaleNetworks)).append("\n");
        sb.append("    autoscalePolicyRef: ").append(toIndentedString(autoscalePolicyRef)).append("\n");
        sb.append("    capacityEstimation: ").append(toIndentedString(capacityEstimation)).append("\n");
        sb.append("    capacityEstimationTtfbThresh: ").append(toIndentedString(capacityEstimationTtfbThresh)).append("\n");
        sb.append("    cloudConfigCksum: ").append(toIndentedString(cloudConfigCksum)).append("\n");
        sb.append("    cloudRef: ").append(toIndentedString(cloudRef)).append("\n");
        sb.append("    connPoolProperties: ").append(toIndentedString(connPoolProperties)).append("\n");
        sb.append("    connectionRampDuration: ").append(toIndentedString(connectionRampDuration)).append("\n");
        sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
        sb.append("    defaultServerPort: ").append(toIndentedString(defaultServerPort)).append("\n");
        sb.append("    deleteServerOnDnsRefresh: ").append(toIndentedString(deleteServerOnDnsRefresh)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    domainName: ").append(toIndentedString(domainName)).append("\n");
        sb.append("    eastWest: ").append(toIndentedString(eastWest)).append("\n");
        sb.append("    enableHttp2: ").append(toIndentedString(enableHttp2)).append("\n");
        sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
        sb.append("    externalAutoscaleGroups: ").append(toIndentedString(externalAutoscaleGroups)).append("\n");
        sb.append("    failAction: ").append(toIndentedString(failAction)).append("\n");
        sb.append("    fewestTasksFeedbackDelay: ").append(toIndentedString(fewestTasksFeedbackDelay)).append("\n");
        sb.append("    gracefulDisableTimeout: ").append(toIndentedString(gracefulDisableTimeout)).append("\n");
        sb.append("    gslbSpEnabled: ").append(toIndentedString(gslbSpEnabled)).append("\n");
        sb.append("    healthMonitorRefs: ").append(toIndentedString(healthMonitorRefs)).append("\n");
        sb.append("    hostCheckEnabled: ").append(toIndentedString(hostCheckEnabled)).append("\n");
        sb.append("    ignoreServerPort: ").append(toIndentedString(ignoreServerPort)).append("\n");
        sb.append("    inlineHealthMonitor: ").append(toIndentedString(inlineHealthMonitor)).append("\n");
        sb.append("    ipaddrgroupRef: ").append(toIndentedString(ipaddrgroupRef)).append("\n");
        sb.append("    lbAlgorithm: ").append(toIndentedString(lbAlgorithm)).append("\n");
        sb.append("    lbAlgorithmConsistentHashHdr: ").append(toIndentedString(lbAlgorithmConsistentHashHdr)).append("\n");
        sb.append("    lbAlgorithmCoreNonaffinity: ").append(toIndentedString(lbAlgorithmCoreNonaffinity)).append("\n");
        sb.append("    lbAlgorithmHash: ").append(toIndentedString(lbAlgorithmHash)).append("\n");
        sb.append("    lookupServerByName: ").append(toIndentedString(lookupServerByName)).append("\n");
        sb.append("    maxConcurrentConnectionsPerServer: ").append(toIndentedString(maxConcurrentConnectionsPerServer)).append("\n");
        sb.append("    maxConnRatePerServer: ").append(toIndentedString(maxConnRatePerServer)).append("\n");
        sb.append("    minHealthMonitorsUp: ").append(toIndentedString(minHealthMonitorsUp)).append("\n");
        sb.append("    minServersUp: ").append(toIndentedString(minServersUp)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    networks: ").append(toIndentedString(networks)).append("\n");
        sb.append("    nsxSecuritygroup: ").append(toIndentedString(nsxSecuritygroup)).append("\n");
        sb.append("    pkiProfileRef: ").append(toIndentedString(pkiProfileRef)).append("\n");
        sb.append("    placementNetworks: ").append(toIndentedString(placementNetworks)).append("\n");
        sb.append("    prstHdrName: ").append(toIndentedString(prstHdrName)).append("\n");
        sb.append("    requestQueueDepth: ").append(toIndentedString(requestQueueDepth)).append("\n");
        sb.append("    requestQueueEnabled: ").append(toIndentedString(requestQueueEnabled)).append("\n");
        sb.append("    rewriteHostHeaderToServerName: ").append(toIndentedString(rewriteHostHeaderToServerName)).append("\n");
        sb.append("    rewriteHostHeaderToSni: ").append(toIndentedString(rewriteHostHeaderToSni)).append("\n");
        sb.append("    routingPool: ").append(toIndentedString(routingPool)).append("\n");
        sb.append("    serverAutoScale: ").append(toIndentedString(serverAutoScale)).append("\n");
        sb.append("    serverCount: ").append(toIndentedString(serverCount)).append("\n");
        sb.append("    serverName: ").append(toIndentedString(serverName)).append("\n");
        sb.append("    serverReselect: ").append(toIndentedString(serverReselect)).append("\n");
        sb.append("    serverTimeout: ").append(toIndentedString(serverTimeout)).append("\n");
        sb.append("    servers: ").append(toIndentedString(servers)).append("\n");
        sb.append("    serviceMetadata: ").append(toIndentedString(serviceMetadata)).append("\n");
        sb.append("    sniEnabled: ").append(toIndentedString(sniEnabled)).append("\n");
        sb.append("    sslKeyAndCertificateRef: ").append(toIndentedString(sslKeyAndCertificateRef)).append("\n");
        sb.append("    sslProfileRef: ").append(toIndentedString(sslProfileRef)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
            sb.append("    useServicePort: ").append(toIndentedString(useServicePort)).append("\n");
        sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
        sb.append("    vrfRef: ").append(toIndentedString(vrfRef)).append("\n");
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

