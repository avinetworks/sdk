package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VirtualService is a POJO class extends AviRestResource that used for creating
 * VirtualService.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VirtualService extends AviRestResource  {
    @JsonProperty("active_standby_se_tag")
    private String activeStandbySeTag = "ACTIVE_STANDBY_SE_1";

    @JsonProperty("advertise_down_vs")
    private Boolean advertiseDownVs = false;

    @JsonProperty("allow_invalid_client_cert")
    private Boolean allowInvalidClientCert = false;

    @JsonProperty("analytics_policy")
    private AnalyticsPolicy analyticsPolicy = null;

    @JsonProperty("analytics_profile_ref")
    private String analyticsProfileRef = null;

    @JsonProperty("apic_contract_graph")
    private String apicContractGraph = null;

    @JsonProperty("application_profile_ref")
    private String applicationProfileRef = null;

    @JsonProperty("auto_allocate_floating_ip")
    private Boolean autoAllocateFloatingIp = null;

    @JsonProperty("auto_allocate_ip")
    private Boolean autoAllocateIp = null;

    @JsonProperty("availability_zone")
    private String availabilityZone = null;

    @JsonProperty("avi_allocated_fip")
    private Boolean aviAllocatedFip = null;

    @JsonProperty("avi_allocated_vip")
    private Boolean aviAllocatedVip = null;

    @JsonProperty("azure_availability_set")
    private String azureAvailabilitySet = null;

    @JsonProperty("bulk_sync_kvcache")
    private Boolean bulkSyncKvcache = false;

    @JsonProperty("client_auth")
    private HTTPClientAuthenticationParams clientAuth = null;

    @JsonProperty("close_client_conn_on_config_update")
    private Boolean closeClientConnOnConfigUpdate = false;

    @JsonProperty("cloud_config_cksum")
    private String cloudConfigCksum = null;

    @JsonProperty("cloud_ref")
    private String cloudRef = null;

    @JsonProperty("cloud_type")
    private String cloudType = "CLOUD_NONE";

    @JsonProperty("connections_rate_limit")
    private RateProfile connectionsRateLimit = null;

    @JsonProperty("content_rewrite")
    private ContentRewriteProfile contentRewrite = null;

    @JsonProperty("created_by")
    private String createdBy = null;

    @JsonProperty("delay_fairness")
    private Boolean delayFairness = false;

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("discovered_network_ref")
    private List<String> discoveredNetworkRef = null;

    @JsonProperty("discovered_networks")
    private List<DiscoveredNetwork> discoveredNetworks = null;

    @JsonProperty("discovered_subnet")
    private List<IpAddrPrefix> discoveredSubnet = null;

    @JsonProperty("dns_info")
    private List<DnsInfo> dnsInfo = null;

    @JsonProperty("dns_policies")
    private List<DnsPolicies> dnsPolicies = null;

    @JsonProperty("east_west_placement")
    private Boolean eastWestPlacement = false;

    @JsonProperty("enable_autogw")
    private Boolean enableAutogw = true;

    @JsonProperty("enable_rhi")
    private Boolean enableRhi = null;

    @JsonProperty("enable_rhi_snat")
    private Boolean enableRhiSnat = null;

    @JsonProperty("enabled")
    private Boolean enabled = true;

    @JsonProperty("error_page_profile_ref")
    private String errorPageProfileRef = null;

    @JsonProperty("floating_ip")
    private IpAddr floatingIp = null;

    @JsonProperty("floating_subnet_uuid")
    private String floatingSubnetUuid = null;

    @JsonProperty("flow_dist")
    private String flowDist = "LOAD_AWARE";

    @JsonProperty("flow_label_type")
    private String flowLabelType = "NO_LABEL";

    @JsonProperty("fqdn")
    private String fqdn = null;

    @JsonProperty("host_name_xlate")
    private String hostNameXlate = null;

    @JsonProperty("http_policies")
    private List<HTTPPolicies> httpPolicies = null;

    @JsonProperty("icap_request_profile_refs")
    private List<String> icapRequestProfileRefs = null;

    @JsonProperty("ign_pool_net_reach")
    private Boolean ignPoolNetReach = false;

    @JsonProperty("ip_address")
    private IpAddr ipAddress = null;

    @JsonProperty("ipam_network_subnet")
    private IPNetworkSubnet ipamNetworkSubnet = null;

    @JsonProperty("l4_policies")
    private List<L4Policies> l4Policies = null;

    @JsonProperty("limit_doser")
    private Boolean limitDoser = false;

    @JsonProperty("max_cps_per_client")
    private Integer maxCpsPerClient = 0;

    @JsonProperty("microservice_ref")
    private String microserviceRef = null;

    @JsonProperty("min_pools_up")
    private Integer minPoolsUp = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("network_profile_ref")
    private String networkProfileRef = null;

    @JsonProperty("network_ref")
    private String networkRef = null;

    @JsonProperty("network_security_policy_ref")
    private String networkSecurityPolicyRef = null;

    @JsonProperty("nsx_securitygroup")
    private List<String> nsxSecuritygroup = null;

    @JsonProperty("performance_limits")
    private PerformanceLimits performanceLimits = null;

    @JsonProperty("pool_group_ref")
    private String poolGroupRef = null;

    @JsonProperty("pool_ref")
    private String poolRef = null;

    @JsonProperty("port_uuid")
    private String portUuid = null;

    @JsonProperty("remove_listening_port_on_vs_down")
    private Boolean removeListeningPortOnVsDown = false;

    @JsonProperty("requests_rate_limit")
    private RateProfile requestsRateLimit = null;

    @JsonProperty("saml_sp_config")
    private SAMLSPConfig samlSpConfig = null;

    @JsonProperty("scaleout_ecmp")
    private Boolean scaleoutEcmp = false;

    @JsonProperty("se_group_ref")
    private String seGroupRef = null;

    @JsonProperty("security_policy_ref")
    private String securityPolicyRef = null;

    @JsonProperty("server_network_profile_ref")
    private String serverNetworkProfileRef = null;

    @JsonProperty("service_metadata")
    private String serviceMetadata = null;

    @JsonProperty("service_pool_select")
    private List<ServicePoolSelector> servicePoolSelect = null;

    @JsonProperty("services")
    private List<Service> services = null;

    @JsonProperty("sideband_profile")
    private SidebandProfile sidebandProfile = null;

    @JsonProperty("snat_ip")
    private List<IpAddr> snatIp = null;

    @JsonProperty("sp_pool_refs")
    private List<String> spPoolRefs = null;

    @JsonProperty("ssl_key_and_certificate_refs")
    private List<String> sslKeyAndCertificateRefs = null;

    @JsonProperty("ssl_profile_ref")
    private String sslProfileRef = null;

    @JsonProperty("ssl_profile_selectors")
    private List<SSLProfileSelector> sslProfileSelectors = null;

    @JsonProperty("ssl_sess_cache_avg_size")
    private Integer sslSessCacheAvgSize = 1024;

    @JsonProperty("sso_policy")
    private SSOPolicy ssoPolicy = null;

    @JsonProperty("sso_policy_ref")
    private String ssoPolicyRef = null;

    @JsonProperty("static_dns_records")
    private List<DnsRecord> staticDnsRecords = null;

    @JsonProperty("subnet")
    private IpAddrPrefix subnet = null;

    @JsonProperty("subnet_uuid")
    private String subnetUuid = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("test_se_datastore_level_1_ref")
    private String testSeDatastoreLevel1Ref = null;

    @JsonProperty("topology_policies")
    private List<DnsPolicies> topologyPolicies = null;

    @JsonProperty("traffic_clone_profile_ref")
    private String trafficCloneProfileRef = null;

    @JsonProperty("traffic_enabled")
    private Boolean trafficEnabled = true;

    @JsonProperty("type")
    private String type = "VS_TYPE_NORMAL";

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("use_bridge_ip_as_vip")
    private Boolean useBridgeIpAsVip = false;

    @JsonProperty("use_vip_as_snat")
    private Boolean useVipAsSnat = false;

    @JsonProperty("uuid")
    private String uuid = null;

    @JsonProperty("vh_domain_name")
    private List<String> vhDomainName = null;

    @JsonProperty("vh_parent_vs_uuid")
    private String vhParentVsUuid = null;

    @JsonProperty("vip")
    private List<Vip> vip = null;

    @JsonProperty("vrf_context_ref")
    private String vrfContextRef = null;

    @JsonProperty("vs_datascripts")
    private List<VSDataScripts> vsDatascripts = null;

    @JsonProperty("vsvip_cloud_config_cksum")
    private String vsvipCloudConfigCksum = null;

    @JsonProperty("vsvip_ref")
    private String vsvipRef = null;

    @JsonProperty("waf_policy_ref")
    private String wafPolicyRef = null;

    @JsonProperty("weight")
    private Integer weight = 1;



  /**
   * This is the getter method this will return the attribute value.
   * This configuration only applies if the virtualservice is in legacy active standby ha mode and load distribution among active standby is enabled.
   * This field is used to tag the virtualservice so that virtualservices with the same tag will share the same active serviceengine.
   * Virtualservices with different tags will have different active serviceengines.
   * If one of the serviceengine's in the serviceenginegroup fails, all virtualservices will end up using the same active serviceengine.
   * Redistribution of the virtualservices can be either manual or automated when the failed serviceengine recovers.
   * Redistribution is based on the auto redistribute property of the serviceenginegroup.
   * Enum options - ACTIVE_STANDBY_SE_1, ACTIVE_STANDBY_SE_2.
   * Default value when not specified in API or module is interpreted by Avi Controller as ACTIVE_STANDBY_SE_1.
   * @return activeStandbySeTag
   */
  public String getActiveStandbySeTag() {
    return activeStandbySeTag;
  }

  /**
   * This is the setter method to the attribute.
   * This configuration only applies if the virtualservice is in legacy active standby ha mode and load distribution among active standby is enabled.
   * This field is used to tag the virtualservice so that virtualservices with the same tag will share the same active serviceengine.
   * Virtualservices with different tags will have different active serviceengines.
   * If one of the serviceengine's in the serviceenginegroup fails, all virtualservices will end up using the same active serviceengine.
   * Redistribution of the virtualservices can be either manual or automated when the failed serviceengine recovers.
   * Redistribution is based on the auto redistribute property of the serviceenginegroup.
   * Enum options - ACTIVE_STANDBY_SE_1, ACTIVE_STANDBY_SE_2.
   * Default value when not specified in API or module is interpreted by Avi Controller as ACTIVE_STANDBY_SE_1.
   * @param activeStandbySeTag set the activeStandbySeTag.
   */
  public void setActiveStandbySeTag(String  activeStandbySeTag) {
    this.activeStandbySeTag = activeStandbySeTag;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Keep advertising virtual service via bgp even if it is marked down by health monitor.
   * This setting takes effect for future virtual service flaps.
   * To advertise current vses that are down, please disable and re-enable the virtual service.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return advertiseDownVs
   */
  public Boolean getAdvertiseDownVs() {
    return advertiseDownVs;
  }

  /**
   * This is the setter method to the attribute.
   * Keep advertising virtual service via bgp even if it is marked down by health monitor.
   * This setting takes effect for future virtual service flaps.
   * To advertise current vses that are down, please disable and re-enable the virtual service.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param advertiseDownVs set the advertiseDownVs.
   */
  public void setAdvertiseDownVs(Boolean  advertiseDownVs) {
    this.advertiseDownVs = advertiseDownVs;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Process request even if invalid client certificate is presented.
   * Datascript apis need to be used for processing of such requests.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return allowInvalidClientCert
   */
  public Boolean getAllowInvalidClientCert() {
    return allowInvalidClientCert;
  }

  /**
   * This is the setter method to the attribute.
   * Process request even if invalid client certificate is presented.
   * Datascript apis need to be used for processing of such requests.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param allowInvalidClientCert set the allowInvalidClientCert.
   */
  public void setAllowInvalidClientCert(Boolean  allowInvalidClientCert) {
    this.allowInvalidClientCert = allowInvalidClientCert;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Determines analytics settings for the application.
   * @return analyticsPolicy
   */
  public AnalyticsPolicy getAnalyticsPolicy() {
    return analyticsPolicy;
  }

  /**
   * This is the setter method to the attribute.
   * Determines analytics settings for the application.
   * @param analyticsPolicy set the analyticsPolicy.
   */
  public void setAnalyticsPolicy(AnalyticsPolicy analyticsPolicy) {
    this.analyticsPolicy = analyticsPolicy;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Specifies settings related to analytics.
   * It is a reference to an object of type analyticsprofile.
   * @return analyticsProfileRef
   */
  public String getAnalyticsProfileRef() {
    return analyticsProfileRef;
  }

  /**
   * This is the setter method to the attribute.
   * Specifies settings related to analytics.
   * It is a reference to an object of type analyticsprofile.
   * @param analyticsProfileRef set the analyticsProfileRef.
   */
  public void setAnalyticsProfileRef(String  analyticsProfileRef) {
    this.analyticsProfileRef = analyticsProfileRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The name of the contract/graph associated with the virtual service.
   * Should be in the <contract name> <graph name> format.
   * This is applicable only for service integration mode with cisco apic controller.
   * Field introduced in 17.2.12,18.1.2.
   * @return apicContractGraph
   */
  public String getApicContractGraph() {
    return apicContractGraph;
  }

  /**
   * This is the setter method to the attribute.
   * The name of the contract/graph associated with the virtual service.
   * Should be in the <contract name> <graph name> format.
   * This is applicable only for service integration mode with cisco apic controller.
   * Field introduced in 17.2.12,18.1.2.
   * @param apicContractGraph set the apicContractGraph.
   */
  public void setApicContractGraph(String  apicContractGraph) {
    this.apicContractGraph = apicContractGraph;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable application layer specific features for the virtual service.
   * It is a reference to an object of type applicationprofile.
   * @return applicationProfileRef
   */
  public String getApplicationProfileRef() {
    return applicationProfileRef;
  }

  /**
   * This is the setter method to the attribute.
   * Enable application layer specific features for the virtual service.
   * It is a reference to an object of type applicationprofile.
   * @param applicationProfileRef set the applicationProfileRef.
   */
  public void setApplicationProfileRef(String  applicationProfileRef) {
    this.applicationProfileRef = applicationProfileRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Auto-allocate floating/elastic ip from the cloud infrastructure.
   * Field deprecated in 17.1.1.
   * @return autoAllocateFloatingIp
   */
  public Boolean getAutoAllocateFloatingIp() {
    return autoAllocateFloatingIp;
  }

  /**
   * This is the setter method to the attribute.
   * Auto-allocate floating/elastic ip from the cloud infrastructure.
   * Field deprecated in 17.1.1.
   * @param autoAllocateFloatingIp set the autoAllocateFloatingIp.
   */
  public void setAutoAllocateFloatingIp(Boolean  autoAllocateFloatingIp) {
    this.autoAllocateFloatingIp = autoAllocateFloatingIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Auto-allocate vip from the provided subnet.
   * Field deprecated in 17.1.1.
   * @return autoAllocateIp
   */
  public Boolean getAutoAllocateIp() {
    return autoAllocateIp;
  }

  /**
   * This is the setter method to the attribute.
   * Auto-allocate vip from the provided subnet.
   * Field deprecated in 17.1.1.
   * @param autoAllocateIp set the autoAllocateIp.
   */
  public void setAutoAllocateIp(Boolean  autoAllocateIp) {
    this.autoAllocateIp = autoAllocateIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Availability-zone to place the virtual service.
   * Field deprecated in 17.1.1.
   * @return availabilityZone
   */
  public String getAvailabilityZone() {
    return availabilityZone;
  }

  /**
   * This is the setter method to the attribute.
   * Availability-zone to place the virtual service.
   * Field deprecated in 17.1.1.
   * @param availabilityZone set the availabilityZone.
   */
  public void setAvailabilityZone(String  availabilityZone) {
    this.availabilityZone = availabilityZone;
  }

  /**
   * This is the getter method this will return the attribute value.
   * (internal-use) fip allocated by avi in the cloud infrastructure.
   * Field deprecated in 17.1.1.
   * @return aviAllocatedFip
   */
  public Boolean getAviAllocatedFip() {
    return aviAllocatedFip;
  }

  /**
   * This is the setter method to the attribute.
   * (internal-use) fip allocated by avi in the cloud infrastructure.
   * Field deprecated in 17.1.1.
   * @param aviAllocatedFip set the aviAllocatedFip.
   */
  public void setAviAllocatedFip(Boolean  aviAllocatedFip) {
    this.aviAllocatedFip = aviAllocatedFip;
  }

  /**
   * This is the getter method this will return the attribute value.
   * (internal-use) vip allocated by avi in the cloud infrastructure.
   * Field deprecated in 17.1.1.
   * @return aviAllocatedVip
   */
  public Boolean getAviAllocatedVip() {
    return aviAllocatedVip;
  }

  /**
   * This is the setter method to the attribute.
   * (internal-use) vip allocated by avi in the cloud infrastructure.
   * Field deprecated in 17.1.1.
   * @param aviAllocatedVip set the aviAllocatedVip.
   */
  public void setAviAllocatedVip(Boolean  aviAllocatedVip) {
    this.aviAllocatedVip = aviAllocatedVip;
  }

  /**
   * This is the getter method this will return the attribute value.
   * (internal-use)applicable for azure only.
   * Azure availability set to which this vs is associated.
   * Internally set by the cloud connector.
   * Field introduced in 17.2.12, 18.1.2.
   * @return azureAvailabilitySet
   */
  public String getAzureAvailabilitySet() {
    return azureAvailabilitySet;
  }

  /**
   * This is the setter method to the attribute.
   * (internal-use)applicable for azure only.
   * Azure availability set to which this vs is associated.
   * Internally set by the cloud connector.
   * Field introduced in 17.2.12, 18.1.2.
   * @param azureAvailabilitySet set the azureAvailabilitySet.
   */
  public void setAzureAvailabilitySet(String  azureAvailabilitySet) {
    this.azureAvailabilitySet = azureAvailabilitySet;
  }

  /**
   * This is the getter method this will return the attribute value.
   * (this is a beta feature).
   * Sync key-value cache to the new ses when vs is scaled out.
   * For ex  ssl sessions are stored using vs's key-value cache.
   * When the vs is scaled out, the ssl session information is synced to the new se, allowing existing ssl sessions to be reused on the new se.
   * Field introduced in 17.2.7, 18.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return bulkSyncKvcache
   */
  public Boolean getBulkSyncKvcache() {
    return bulkSyncKvcache;
  }

  /**
   * This is the setter method to the attribute.
   * (this is a beta feature).
   * Sync key-value cache to the new ses when vs is scaled out.
   * For ex  ssl sessions are stored using vs's key-value cache.
   * When the vs is scaled out, the ssl session information is synced to the new se, allowing existing ssl sessions to be reused on the new se.
   * Field introduced in 17.2.7, 18.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param bulkSyncKvcache set the bulkSyncKvcache.
   */
  public void setBulkSyncKvcache(Boolean  bulkSyncKvcache) {
    this.bulkSyncKvcache = bulkSyncKvcache;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Http authentication configuration for protected resources.
   * @return clientAuth
   */
  public HTTPClientAuthenticationParams getClientAuth() {
    return clientAuth;
  }

  /**
   * This is the setter method to the attribute.
   * Http authentication configuration for protected resources.
   * @param clientAuth set the clientAuth.
   */
  public void setClientAuth(HTTPClientAuthenticationParams clientAuth) {
    this.clientAuth = clientAuth;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Close client connection on vs config update.
   * Field introduced in 17.2.4.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return closeClientConnOnConfigUpdate
   */
  public Boolean getCloseClientConnOnConfigUpdate() {
    return closeClientConnOnConfigUpdate;
  }

  /**
   * This is the setter method to the attribute.
   * Close client connection on vs config update.
   * Field introduced in 17.2.4.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param closeClientConnOnConfigUpdate set the closeClientConnOnConfigUpdate.
   */
  public void setCloseClientConnOnConfigUpdate(Boolean  closeClientConnOnConfigUpdate) {
    this.closeClientConnOnConfigUpdate = closeClientConnOnConfigUpdate;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Checksum of cloud configuration for vs.
   * Internally set by cloud connector.
   * @return cloudConfigCksum
   */
  public String getCloudConfigCksum() {
    return cloudConfigCksum;
  }

  /**
   * This is the setter method to the attribute.
   * Checksum of cloud configuration for vs.
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
   * Enum options - CLOUD_NONE, CLOUD_VCENTER, CLOUD_OPENSTACK, CLOUD_AWS, CLOUD_VCA, CLOUD_APIC, CLOUD_MESOS, CLOUD_LINUXSERVER, CLOUD_DOCKER_UCP,
   * CLOUD_RANCHER, CLOUD_OSHIFT_K8S, CLOUD_AZURE, CLOUD_GCP, CLOUD_NSXT.
   * Default value when not specified in API or module is interpreted by Avi Controller as CLOUD_NONE.
   * @return cloudType
   */
  public String getCloudType() {
    return cloudType;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - CLOUD_NONE, CLOUD_VCENTER, CLOUD_OPENSTACK, CLOUD_AWS, CLOUD_VCA, CLOUD_APIC, CLOUD_MESOS, CLOUD_LINUXSERVER, CLOUD_DOCKER_UCP,
   * CLOUD_RANCHER, CLOUD_OSHIFT_K8S, CLOUD_AZURE, CLOUD_GCP, CLOUD_NSXT.
   * Default value when not specified in API or module is interpreted by Avi Controller as CLOUD_NONE.
   * @param cloudType set the cloudType.
   */
  public void setCloudType(String  cloudType) {
    this.cloudType = cloudType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Rate limit the incoming connections to this virtual service.
   * @return connectionsRateLimit
   */
  public RateProfile getConnectionsRateLimit() {
    return connectionsRateLimit;
  }

  /**
   * This is the setter method to the attribute.
   * Rate limit the incoming connections to this virtual service.
   * @param connectionsRateLimit set the connectionsRateLimit.
   */
  public void setConnectionsRateLimit(RateProfile connectionsRateLimit) {
    this.connectionsRateLimit = connectionsRateLimit;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Profile used to match and rewrite strings in request and/or response body.
   * @return contentRewrite
   */
  public ContentRewriteProfile getContentRewrite() {
    return contentRewrite;
  }

  /**
   * This is the setter method to the attribute.
   * Profile used to match and rewrite strings in request and/or response body.
   * @param contentRewrite set the contentRewrite.
   */
  public void setContentRewrite(ContentRewriteProfile contentRewrite) {
    this.contentRewrite = contentRewrite;
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
   * Select the algorithm for qos fairness.
   * This determines how multiple virtual services sharing the same service engines will prioritize traffic over a congested network.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return delayFairness
   */
  public Boolean getDelayFairness() {
    return delayFairness;
  }

  /**
   * This is the setter method to the attribute.
   * Select the algorithm for qos fairness.
   * This determines how multiple virtual services sharing the same service engines will prioritize traffic over a congested network.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param delayFairness set the delayFairness.
   */
  public void setDelayFairness(Boolean  delayFairness) {
    this.delayFairness = delayFairness;
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
   * (internal-use) discovered networks providing reachability for client facing virtual service ip.
   * This field is deprecated.
   * It is a reference to an object of type network.
   * Field deprecated in 17.1.1.
   * @return discoveredNetworkRef
   */
  public List<String> getDiscoveredNetworkRef() {
    return discoveredNetworkRef;
  }

  /**
   * This is the setter method. this will set the discoveredNetworkRef
   * (internal-use) discovered networks providing reachability for client facing virtual service ip.
   * This field is deprecated.
   * It is a reference to an object of type network.
   * Field deprecated in 17.1.1.
   * @return discoveredNetworkRef
   */
  public void setDiscoveredNetworkRef(List<String>  discoveredNetworkRef) {
    this.discoveredNetworkRef = discoveredNetworkRef;
  }

  /**
   * This is the setter method this will set the discoveredNetworkRef
   * (internal-use) discovered networks providing reachability for client facing virtual service ip.
   * This field is deprecated.
   * It is a reference to an object of type network.
   * Field deprecated in 17.1.1.
   * @return discoveredNetworkRef
   */
  public VirtualService addDiscoveredNetworkRefItem(String discoveredNetworkRefItem) {
    if (this.discoveredNetworkRef == null) {
      this.discoveredNetworkRef = new ArrayList<String>();
    }
    this.discoveredNetworkRef.add(discoveredNetworkRefItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * (internal-use) discovered networks providing reachability for client facing virtual service ip.
   * This field is used internally by avi, not editable by the user.
   * Field deprecated in 17.1.1.
   * @return discoveredNetworks
   */
  public List<DiscoveredNetwork> getDiscoveredNetworks() {
    return discoveredNetworks;
  }

  /**
   * This is the setter method. this will set the discoveredNetworks
   * (internal-use) discovered networks providing reachability for client facing virtual service ip.
   * This field is used internally by avi, not editable by the user.
   * Field deprecated in 17.1.1.
   * @return discoveredNetworks
   */
  public void setDiscoveredNetworks(List<DiscoveredNetwork>  discoveredNetworks) {
    this.discoveredNetworks = discoveredNetworks;
  }

  /**
   * This is the setter method this will set the discoveredNetworks
   * (internal-use) discovered networks providing reachability for client facing virtual service ip.
   * This field is used internally by avi, not editable by the user.
   * Field deprecated in 17.1.1.
   * @return discoveredNetworks
   */
  public VirtualService addDiscoveredNetworksItem(DiscoveredNetwork discoveredNetworksItem) {
    if (this.discoveredNetworks == null) {
      this.discoveredNetworks = new ArrayList<DiscoveredNetwork>();
    }
    this.discoveredNetworks.add(discoveredNetworksItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * (internal-use) discovered subnets providing reachability for client facing virtual service ip.
   * This field is deprecated.
   * Field deprecated in 17.1.1.
   * @return discoveredSubnet
   */
  public List<IpAddrPrefix> getDiscoveredSubnet() {
    return discoveredSubnet;
  }

  /**
   * This is the setter method. this will set the discoveredSubnet
   * (internal-use) discovered subnets providing reachability for client facing virtual service ip.
   * This field is deprecated.
   * Field deprecated in 17.1.1.
   * @return discoveredSubnet
   */
  public void setDiscoveredSubnet(List<IpAddrPrefix>  discoveredSubnet) {
    this.discoveredSubnet = discoveredSubnet;
  }

  /**
   * This is the setter method this will set the discoveredSubnet
   * (internal-use) discovered subnets providing reachability for client facing virtual service ip.
   * This field is deprecated.
   * Field deprecated in 17.1.1.
   * @return discoveredSubnet
   */
  public VirtualService addDiscoveredSubnetItem(IpAddrPrefix discoveredSubnetItem) {
    if (this.discoveredSubnet == null) {
      this.discoveredSubnet = new ArrayList<IpAddrPrefix>();
    }
    this.discoveredSubnet.add(discoveredSubnetItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Service discovery specific data including fully qualified domain name, type and time-to-live of the dns record.
   * Note that only one of fqdn and dns_info setting is allowed.
   * @return dnsInfo
   */
  public List<DnsInfo> getDnsInfo() {
    return dnsInfo;
  }

  /**
   * This is the setter method. this will set the dnsInfo
   * Service discovery specific data including fully qualified domain name, type and time-to-live of the dns record.
   * Note that only one of fqdn and dns_info setting is allowed.
   * @return dnsInfo
   */
  public void setDnsInfo(List<DnsInfo>  dnsInfo) {
    this.dnsInfo = dnsInfo;
  }

  /**
   * This is the setter method this will set the dnsInfo
   * Service discovery specific data including fully qualified domain name, type and time-to-live of the dns record.
   * Note that only one of fqdn and dns_info setting is allowed.
   * @return dnsInfo
   */
  public VirtualService addDnsInfoItem(DnsInfo dnsInfoItem) {
    if (this.dnsInfo == null) {
      this.dnsInfo = new ArrayList<DnsInfo>();
    }
    this.dnsInfo.add(dnsInfoItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Dns policies applied on the dns traffic of the virtual service.
   * Field introduced in 17.1.1.
   * @return dnsPolicies
   */
  public List<DnsPolicies> getDnsPolicies() {
    return dnsPolicies;
  }

  /**
   * This is the setter method. this will set the dnsPolicies
   * Dns policies applied on the dns traffic of the virtual service.
   * Field introduced in 17.1.1.
   * @return dnsPolicies
   */
  public void setDnsPolicies(List<DnsPolicies>  dnsPolicies) {
    this.dnsPolicies = dnsPolicies;
  }

  /**
   * This is the setter method this will set the dnsPolicies
   * Dns policies applied on the dns traffic of the virtual service.
   * Field introduced in 17.1.1.
   * @return dnsPolicies
   */
  public VirtualService addDnsPoliciesItem(DnsPolicies dnsPoliciesItem) {
    if (this.dnsPolicies == null) {
      this.dnsPolicies = new ArrayList<DnsPolicies>();
    }
    this.dnsPolicies.add(dnsPoliciesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Force placement on all se's in service group (mesos mode only).
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return eastWestPlacement
   */
  public Boolean getEastWestPlacement() {
    return eastWestPlacement;
  }

  /**
   * This is the setter method to the attribute.
   * Force placement on all se's in service group (mesos mode only).
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param eastWestPlacement set the eastWestPlacement.
   */
  public void setEastWestPlacement(Boolean  eastWestPlacement) {
    this.eastWestPlacement = eastWestPlacement;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Response traffic to clients will be sent back to the source mac address of the connection, rather than statically sent to a default gateway.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return enableAutogw
   */
  public Boolean getEnableAutogw() {
    return enableAutogw;
  }

  /**
   * This is the setter method to the attribute.
   * Response traffic to clients will be sent back to the source mac address of the connection, rather than statically sent to a default gateway.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param enableAutogw set the enableAutogw.
   */
  public void setEnableAutogw(Boolean  enableAutogw) {
    this.enableAutogw = enableAutogw;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable route health injection using the bgp config in the vrf context.
   * @return enableRhi
   */
  public Boolean getEnableRhi() {
    return enableRhi;
  }

  /**
   * This is the setter method to the attribute.
   * Enable route health injection using the bgp config in the vrf context.
   * @param enableRhi set the enableRhi.
   */
  public void setEnableRhi(Boolean  enableRhi) {
    this.enableRhi = enableRhi;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable route health injection for source nat'ted floating ip address using the bgp config in the vrf context.
   * @return enableRhiSnat
   */
  public Boolean getEnableRhiSnat() {
    return enableRhiSnat;
  }

  /**
   * This is the setter method to the attribute.
   * Enable route health injection for source nat'ted floating ip address using the bgp config in the vrf context.
   * @param enableRhiSnat set the enableRhiSnat.
   */
  public void setEnableRhiSnat(Boolean  enableRhiSnat) {
    this.enableRhiSnat = enableRhiSnat;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable or disable the virtual service.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return enabled
   */
  public Boolean getEnabled() {
    return enabled;
  }

  /**
   * This is the setter method to the attribute.
   * Enable or disable the virtual service.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param enabled set the enabled.
   */
  public void setEnabled(Boolean  enabled) {
    this.enabled = enabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Error page profile to be used for this virtualservice.this profile is used to send the custom error page to the client generated by the proxy.
   * It is a reference to an object of type errorpageprofile.
   * Field introduced in 17.2.4.
   * @return errorPageProfileRef
   */
  public String getErrorPageProfileRef() {
    return errorPageProfileRef;
  }

  /**
   * This is the setter method to the attribute.
   * Error page profile to be used for this virtualservice.this profile is used to send the custom error page to the client generated by the proxy.
   * It is a reference to an object of type errorpageprofile.
   * Field introduced in 17.2.4.
   * @param errorPageProfileRef set the errorPageProfileRef.
   */
  public void setErrorPageProfileRef(String  errorPageProfileRef) {
    this.errorPageProfileRef = errorPageProfileRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Floating ip to associate with this virtual service.
   * Field deprecated in 17.1.1.
   * @return floatingIp
   */
  public IpAddr getFloatingIp() {
    return floatingIp;
  }

  /**
   * This is the setter method to the attribute.
   * Floating ip to associate with this virtual service.
   * Field deprecated in 17.1.1.
   * @param floatingIp set the floatingIp.
   */
  public void setFloatingIp(IpAddr floatingIp) {
    this.floatingIp = floatingIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * If auto_allocate_floating_ip is true and more than one floating-ip subnets exist, then the subnet for the floating ip address allocation.
   * This field is applicable only if the virtualservice belongs to an openstack or aws cloud.
   * In openstack or aws cloud it is required when auto_allocate_floating_ip is selected.
   * Field deprecated in 17.1.1.
   * @return floatingSubnetUuid
   */
  public String getFloatingSubnetUuid() {
    return floatingSubnetUuid;
  }

  /**
   * This is the setter method to the attribute.
   * If auto_allocate_floating_ip is true and more than one floating-ip subnets exist, then the subnet for the floating ip address allocation.
   * This field is applicable only if the virtualservice belongs to an openstack or aws cloud.
   * In openstack or aws cloud it is required when auto_allocate_floating_ip is selected.
   * Field deprecated in 17.1.1.
   * @param floatingSubnetUuid set the floatingSubnetUuid.
   */
  public void setFloatingSubnetUuid(String  floatingSubnetUuid) {
    this.floatingSubnetUuid = floatingSubnetUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Criteria for flow distribution among ses.
   * Enum options - LOAD_AWARE, CONSISTENT_HASH_SOURCE_IP_ADDRESS, CONSISTENT_HASH_SOURCE_IP_ADDRESS_AND_PORT.
   * Default value when not specified in API or module is interpreted by Avi Controller as LOAD_AWARE.
   * @return flowDist
   */
  public String getFlowDist() {
    return flowDist;
  }

  /**
   * This is the setter method to the attribute.
   * Criteria for flow distribution among ses.
   * Enum options - LOAD_AWARE, CONSISTENT_HASH_SOURCE_IP_ADDRESS, CONSISTENT_HASH_SOURCE_IP_ADDRESS_AND_PORT.
   * Default value when not specified in API or module is interpreted by Avi Controller as LOAD_AWARE.
   * @param flowDist set the flowDist.
   */
  public void setFlowDist(String  flowDist) {
    this.flowDist = flowDist;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Criteria for flow labelling.
   * Enum options - NO_LABEL, APPLICATION_LABEL, SERVICE_LABEL.
   * Default value when not specified in API or module is interpreted by Avi Controller as NO_LABEL.
   * @return flowLabelType
   */
  public String getFlowLabelType() {
    return flowLabelType;
  }

  /**
   * This is the setter method to the attribute.
   * Criteria for flow labelling.
   * Enum options - NO_LABEL, APPLICATION_LABEL, SERVICE_LABEL.
   * Default value when not specified in API or module is interpreted by Avi Controller as NO_LABEL.
   * @param flowLabelType set the flowLabelType.
   */
  public void setFlowLabelType(String  flowLabelType) {
    this.flowLabelType = flowLabelType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dns resolvable, fully qualified domain name of the virtualservice.
   * Only one of 'fqdn' and 'dns_info' configuration is allowed.
   * @return fqdn
   */
  public String getFqdn() {
    return fqdn;
  }

  /**
   * This is the setter method to the attribute.
   * Dns resolvable, fully qualified domain name of the virtualservice.
   * Only one of 'fqdn' and 'dns_info' configuration is allowed.
   * @param fqdn set the fqdn.
   */
  public void setFqdn(String  fqdn) {
    this.fqdn = fqdn;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Translate the host name sent to the servers to this value.
   * Translate the host name sent from servers back to the value used by the client.
   * @return hostNameXlate
   */
  public String getHostNameXlate() {
    return hostNameXlate;
  }

  /**
   * This is the setter method to the attribute.
   * Translate the host name sent to the servers to this value.
   * Translate the host name sent from servers back to the value used by the client.
   * @param hostNameXlate set the hostNameXlate.
   */
  public void setHostNameXlate(String  hostNameXlate) {
    this.hostNameXlate = hostNameXlate;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Http policies applied on the data traffic of the virtual service.
   * @return httpPolicies
   */
  public List<HTTPPolicies> getHttpPolicies() {
    return httpPolicies;
  }

  /**
   * This is the setter method. this will set the httpPolicies
   * Http policies applied on the data traffic of the virtual service.
   * @return httpPolicies
   */
  public void setHttpPolicies(List<HTTPPolicies>  httpPolicies) {
    this.httpPolicies = httpPolicies;
  }

  /**
   * This is the setter method this will set the httpPolicies
   * Http policies applied on the data traffic of the virtual service.
   * @return httpPolicies
   */
  public VirtualService addHttpPoliciesItem(HTTPPolicies httpPoliciesItem) {
    if (this.httpPolicies == null) {
      this.httpPolicies = new ArrayList<HTTPPolicies>();
    }
    this.httpPolicies.add(httpPoliciesItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * The config settings for the icap server when checking the http request.
   * It is a reference to an object of type icapprofile.
   * Field introduced in 20.1.1.
   * @return icapRequestProfileRefs
   */
  public List<String> getIcapRequestProfileRefs() {
    return icapRequestProfileRefs;
  }

  /**
   * This is the setter method. this will set the icapRequestProfileRefs
   * The config settings for the icap server when checking the http request.
   * It is a reference to an object of type icapprofile.
   * Field introduced in 20.1.1.
   * @return icapRequestProfileRefs
   */
  public void setIcapRequestProfileRefs(List<String>  icapRequestProfileRefs) {
    this.icapRequestProfileRefs = icapRequestProfileRefs;
  }

  /**
   * This is the setter method this will set the icapRequestProfileRefs
   * The config settings for the icap server when checking the http request.
   * It is a reference to an object of type icapprofile.
   * Field introduced in 20.1.1.
   * @return icapRequestProfileRefs
   */
  public VirtualService addIcapRequestProfileRefsItem(String icapRequestProfileRefsItem) {
    if (this.icapRequestProfileRefs == null) {
      this.icapRequestProfileRefs = new ArrayList<String>();
    }
    this.icapRequestProfileRefs.add(icapRequestProfileRefsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ignore pool servers network reachability constraints for virtual service placement.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return ignPoolNetReach
   */
  public Boolean getIgnPoolNetReach() {
    return ignPoolNetReach;
  }

  /**
   * This is the setter method to the attribute.
   * Ignore pool servers network reachability constraints for virtual service placement.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param ignPoolNetReach set the ignPoolNetReach.
   */
  public void setIgnPoolNetReach(Boolean  ignPoolNetReach) {
    this.ignPoolNetReach = ignPoolNetReach;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ip address of the virtual service.
   * Field deprecated in 17.1.1.
   * @return ipAddress
   */
  public IpAddr getIpAddress() {
    return ipAddress;
  }

  /**
   * This is the setter method to the attribute.
   * Ip address of the virtual service.
   * Field deprecated in 17.1.1.
   * @param ipAddress set the ipAddress.
   */
  public void setIpAddress(IpAddr ipAddress) {
    this.ipAddress = ipAddress;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Subnet and/or network for allocating virtualservice ip by ipam provider module.
   * Field deprecated in 17.1.1.
   * @return ipamNetworkSubnet
   */
  public IPNetworkSubnet getIpamNetworkSubnet() {
    return ipamNetworkSubnet;
  }

  /**
   * This is the setter method to the attribute.
   * Subnet and/or network for allocating virtualservice ip by ipam provider module.
   * Field deprecated in 17.1.1.
   * @param ipamNetworkSubnet set the ipamNetworkSubnet.
   */
  public void setIpamNetworkSubnet(IPNetworkSubnet ipamNetworkSubnet) {
    this.ipamNetworkSubnet = ipamNetworkSubnet;
  }
  /**
   * This is the getter method this will return the attribute value.
   * L4 policies applied to the data traffic of the virtual service.
   * Field introduced in 17.2.7.
   * @return l4Policies
   */
  public List<L4Policies> getL4Policies() {
    return l4Policies;
  }

  /**
   * This is the setter method. this will set the l4Policies
   * L4 policies applied to the data traffic of the virtual service.
   * Field introduced in 17.2.7.
   * @return l4Policies
   */
  public void setL4Policies(List<L4Policies>  l4Policies) {
    this.l4Policies = l4Policies;
  }

  /**
   * This is the setter method this will set the l4Policies
   * L4 policies applied to the data traffic of the virtual service.
   * Field introduced in 17.2.7.
   * @return l4Policies
   */
  public VirtualService addL4PoliciesItem(L4Policies l4PoliciesItem) {
    if (this.l4Policies == null) {
      this.l4Policies = new ArrayList<L4Policies>();
    }
    this.l4Policies.add(l4PoliciesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Limit potential dos attackers who exceed max_cps_per_client significantly to a fraction of max_cps_per_client for a while.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return limitDoser
   */
  public Boolean getLimitDoser() {
    return limitDoser;
  }

  /**
   * This is the setter method to the attribute.
   * Limit potential dos attackers who exceed max_cps_per_client significantly to a fraction of max_cps_per_client for a while.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param limitDoser set the limitDoser.
   */
  public void setLimitDoser(Boolean  limitDoser) {
    this.limitDoser = limitDoser;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum connections per second per client ip.
   * Allowed values are 10-1000.
   * Special values are 0- 'unlimited'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return maxCpsPerClient
   */
  public Integer getMaxCpsPerClient() {
    return maxCpsPerClient;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum connections per second per client ip.
   * Allowed values are 10-1000.
   * Special values are 0- 'unlimited'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param maxCpsPerClient set the maxCpsPerClient.
   */
  public void setMaxCpsPerClient(Integer  maxCpsPerClient) {
    this.maxCpsPerClient = maxCpsPerClient;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Microservice representing the virtual service.
   * It is a reference to an object of type microservice.
   * @return microserviceRef
   */
  public String getMicroserviceRef() {
    return microserviceRef;
  }

  /**
   * This is the setter method to the attribute.
   * Microservice representing the virtual service.
   * It is a reference to an object of type microservice.
   * @param microserviceRef set the microserviceRef.
   */
  public void setMicroserviceRef(String  microserviceRef) {
    this.microserviceRef = microserviceRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Minimum number of up pools to mark vs up.
   * Field introduced in 18.2.1, 17.2.12.
   * @return minPoolsUp
   */
  public Integer getMinPoolsUp() {
    return minPoolsUp;
  }

  /**
   * This is the setter method to the attribute.
   * Minimum number of up pools to mark vs up.
   * Field introduced in 18.2.1, 17.2.12.
   * @param minPoolsUp set the minPoolsUp.
   */
  public void setMinPoolsUp(Integer  minPoolsUp) {
    this.minPoolsUp = minPoolsUp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name for the virtual service.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name for the virtual service.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Determines network settings such as protocol, tcp or udp, and related options for the protocol.
   * It is a reference to an object of type networkprofile.
   * @return networkProfileRef
   */
  public String getNetworkProfileRef() {
    return networkProfileRef;
  }

  /**
   * This is the setter method to the attribute.
   * Determines network settings such as protocol, tcp or udp, and related options for the protocol.
   * It is a reference to an object of type networkprofile.
   * @param networkProfileRef set the networkProfileRef.
   */
  public void setNetworkProfileRef(String  networkProfileRef) {
    this.networkProfileRef = networkProfileRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Manually override the network on which the virtual service is placed.
   * It is a reference to an object of type network.
   * Field deprecated in 17.1.1.
   * @return networkRef
   */
  public String getNetworkRef() {
    return networkRef;
  }

  /**
   * This is the setter method to the attribute.
   * Manually override the network on which the virtual service is placed.
   * It is a reference to an object of type network.
   * Field deprecated in 17.1.1.
   * @param networkRef set the networkRef.
   */
  public void setNetworkRef(String  networkRef) {
    this.networkRef = networkRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Network security policies for the virtual service.
   * It is a reference to an object of type networksecuritypolicy.
   * @return networkSecurityPolicyRef
   */
  public String getNetworkSecurityPolicyRef() {
    return networkSecurityPolicyRef;
  }

  /**
   * This is the setter method to the attribute.
   * Network security policies for the virtual service.
   * It is a reference to an object of type networksecuritypolicy.
   * @param networkSecurityPolicyRef set the networkSecurityPolicyRef.
   */
  public void setNetworkSecurityPolicyRef(String  networkSecurityPolicyRef) {
    this.networkSecurityPolicyRef = networkSecurityPolicyRef;
  }
  /**
   * This is the getter method this will return the attribute value.
   * A list of nsx service groups representing the clients which can access the virtual ip of the virtual service.
   * Field introduced in 17.1.1.
   * @return nsxSecuritygroup
   */
  public List<String> getNsxSecuritygroup() {
    return nsxSecuritygroup;
  }

  /**
   * This is the setter method. this will set the nsxSecuritygroup
   * A list of nsx service groups representing the clients which can access the virtual ip of the virtual service.
   * Field introduced in 17.1.1.
   * @return nsxSecuritygroup
   */
  public void setNsxSecuritygroup(List<String>  nsxSecuritygroup) {
    this.nsxSecuritygroup = nsxSecuritygroup;
  }

  /**
   * This is the setter method this will set the nsxSecuritygroup
   * A list of nsx service groups representing the clients which can access the virtual ip of the virtual service.
   * Field introduced in 17.1.1.
   * @return nsxSecuritygroup
   */
  public VirtualService addNsxSecuritygroupItem(String nsxSecuritygroupItem) {
    if (this.nsxSecuritygroup == null) {
      this.nsxSecuritygroup = new ArrayList<String>();
    }
    this.nsxSecuritygroup.add(nsxSecuritygroupItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Optional settings that determine performance limits like max connections or bandwdith etc.
   * @return performanceLimits
   */
  public PerformanceLimits getPerformanceLimits() {
    return performanceLimits;
  }

  /**
   * This is the setter method to the attribute.
   * Optional settings that determine performance limits like max connections or bandwdith etc.
   * @param performanceLimits set the performanceLimits.
   */
  public void setPerformanceLimits(PerformanceLimits performanceLimits) {
    this.performanceLimits = performanceLimits;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The pool group is an object that contains pools.
   * It is a reference to an object of type poolgroup.
   * @return poolGroupRef
   */
  public String getPoolGroupRef() {
    return poolGroupRef;
  }

  /**
   * This is the setter method to the attribute.
   * The pool group is an object that contains pools.
   * It is a reference to an object of type poolgroup.
   * @param poolGroupRef set the poolGroupRef.
   */
  public void setPoolGroupRef(String  poolGroupRef) {
    this.poolGroupRef = poolGroupRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The pool is an object that contains destination servers and related attributes such as load-balancing and persistence.
   * It is a reference to an object of type pool.
   * @return poolRef
   */
  public String getPoolRef() {
    return poolRef;
  }

  /**
   * This is the setter method to the attribute.
   * The pool is an object that contains destination servers and related attributes such as load-balancing and persistence.
   * It is a reference to an object of type pool.
   * @param poolRef set the poolRef.
   */
  public void setPoolRef(String  poolRef) {
    this.poolRef = poolRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * (internal-use) network port assigned to the virtual service ip address.
   * Field deprecated in 17.1.1.
   * @return portUuid
   */
  public String getPortUuid() {
    return portUuid;
  }

  /**
   * This is the setter method to the attribute.
   * (internal-use) network port assigned to the virtual service ip address.
   * Field deprecated in 17.1.1.
   * @param portUuid set the portUuid.
   */
  public void setPortUuid(String  portUuid) {
    this.portUuid = portUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Remove listening port if virtualservice is down.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return removeListeningPortOnVsDown
   */
  public Boolean getRemoveListeningPortOnVsDown() {
    return removeListeningPortOnVsDown;
  }

  /**
   * This is the setter method to the attribute.
   * Remove listening port if virtualservice is down.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param removeListeningPortOnVsDown set the removeListeningPortOnVsDown.
   */
  public void setRemoveListeningPortOnVsDown(Boolean  removeListeningPortOnVsDown) {
    this.removeListeningPortOnVsDown = removeListeningPortOnVsDown;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Rate limit the incoming requests to this virtual service.
   * @return requestsRateLimit
   */
  public RateProfile getRequestsRateLimit() {
    return requestsRateLimit;
  }

  /**
   * This is the setter method to the attribute.
   * Rate limit the incoming requests to this virtual service.
   * @param requestsRateLimit set the requestsRateLimit.
   */
  public void setRequestsRateLimit(RateProfile requestsRateLimit) {
    this.requestsRateLimit = requestsRateLimit;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Application-specific saml config.
   * Field introduced in 18.2.3.
   * @return samlSpConfig
   */
  public SAMLSPConfig getSamlSpConfig() {
    return samlSpConfig;
  }

  /**
   * This is the setter method to the attribute.
   * Application-specific saml config.
   * Field introduced in 18.2.3.
   * @param samlSpConfig set the samlSpConfig.
   */
  public void setSamlSpConfig(SAMLSPConfig samlSpConfig) {
    this.samlSpConfig = samlSpConfig;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Disable re-distribution of flows across service engines for a virtual service.
   * Enable if the network itself performs flow hashing with ecmp in environments such as gcp.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return scaleoutEcmp
   */
  public Boolean getScaleoutEcmp() {
    return scaleoutEcmp;
  }

  /**
   * This is the setter method to the attribute.
   * Disable re-distribution of flows across service engines for a virtual service.
   * Enable if the network itself performs flow hashing with ecmp in environments such as gcp.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param scaleoutEcmp set the scaleoutEcmp.
   */
  public void setScaleoutEcmp(Boolean  scaleoutEcmp) {
    this.scaleoutEcmp = scaleoutEcmp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The service engine group to use for this virtual service.
   * Moving to a new se group is disruptive to existing connections for this vs.
   * It is a reference to an object of type serviceenginegroup.
   * @return seGroupRef
   */
  public String getSeGroupRef() {
    return seGroupRef;
  }

  /**
   * This is the setter method to the attribute.
   * The service engine group to use for this virtual service.
   * Moving to a new se group is disruptive to existing connections for this vs.
   * It is a reference to an object of type serviceenginegroup.
   * @param seGroupRef set the seGroupRef.
   */
  public void setSeGroupRef(String  seGroupRef) {
    this.seGroupRef = seGroupRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Security policy applied on the traffic of the virtual service.
   * This policy is used to perform security actions such as distributed denial of service (ddos) attack mitigation, etc.
   * It is a reference to an object of type securitypolicy.
   * Field introduced in 18.2.1.
   * @return securityPolicyRef
   */
  public String getSecurityPolicyRef() {
    return securityPolicyRef;
  }

  /**
   * This is the setter method to the attribute.
   * Security policy applied on the traffic of the virtual service.
   * This policy is used to perform security actions such as distributed denial of service (ddos) attack mitigation, etc.
   * It is a reference to an object of type securitypolicy.
   * Field introduced in 18.2.1.
   * @param securityPolicyRef set the securityPolicyRef.
   */
  public void setSecurityPolicyRef(String  securityPolicyRef) {
    this.securityPolicyRef = securityPolicyRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Determines the network settings profile for the server side of tcp proxied connections.
   * Leave blank to use the same settings as the client to vs side of the connection.
   * It is a reference to an object of type networkprofile.
   * @return serverNetworkProfileRef
   */
  public String getServerNetworkProfileRef() {
    return serverNetworkProfileRef;
  }

  /**
   * This is the setter method to the attribute.
   * Determines the network settings profile for the server side of tcp proxied connections.
   * Leave blank to use the same settings as the client to vs side of the connection.
   * It is a reference to an object of type networkprofile.
   * @param serverNetworkProfileRef set the serverNetworkProfileRef.
   */
  public void setServerNetworkProfileRef(String  serverNetworkProfileRef) {
    this.serverNetworkProfileRef = serverNetworkProfileRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Metadata pertaining to the service provided by this virtual service.
   * In openshift/kubernetes environments, egress pod info is stored.
   * Any user input to this field will be overwritten by avi vantage.
   * @return serviceMetadata
   */
  public String getServiceMetadata() {
    return serviceMetadata;
  }

  /**
   * This is the setter method to the attribute.
   * Metadata pertaining to the service provided by this virtual service.
   * In openshift/kubernetes environments, egress pod info is stored.
   * Any user input to this field will be overwritten by avi vantage.
   * @param serviceMetadata set the serviceMetadata.
   */
  public void setServiceMetadata(String  serviceMetadata) {
    this.serviceMetadata = serviceMetadata;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Select pool based on destination port.
   * @return servicePoolSelect
   */
  public List<ServicePoolSelector> getServicePoolSelect() {
    return servicePoolSelect;
  }

  /**
   * This is the setter method. this will set the servicePoolSelect
   * Select pool based on destination port.
   * @return servicePoolSelect
   */
  public void setServicePoolSelect(List<ServicePoolSelector>  servicePoolSelect) {
    this.servicePoolSelect = servicePoolSelect;
  }

  /**
   * This is the setter method this will set the servicePoolSelect
   * Select pool based on destination port.
   * @return servicePoolSelect
   */
  public VirtualService addServicePoolSelectItem(ServicePoolSelector servicePoolSelectItem) {
    if (this.servicePoolSelect == null) {
      this.servicePoolSelect = new ArrayList<ServicePoolSelector>();
    }
    this.servicePoolSelect.add(servicePoolSelectItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * List of services defined for this virtual service.
   * @return services
   */
  public List<Service> getServices() {
    return services;
  }

  /**
   * This is the setter method. this will set the services
   * List of services defined for this virtual service.
   * @return services
   */
  public void setServices(List<Service>  services) {
    this.services = services;
  }

  /**
   * This is the setter method this will set the services
   * List of services defined for this virtual service.
   * @return services
   */
  public VirtualService addServicesItem(Service servicesItem) {
    if (this.services == null) {
      this.services = new ArrayList<Service>();
    }
    this.services.add(servicesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Sideband configuration to be used for this virtualservice.it can be used for sending traffic to sideband vips for external inspection etc.
   * @return sidebandProfile
   */
  public SidebandProfile getSidebandProfile() {
    return sidebandProfile;
  }

  /**
   * This is the setter method to the attribute.
   * Sideband configuration to be used for this virtualservice.it can be used for sending traffic to sideband vips for external inspection etc.
   * @param sidebandProfile set the sidebandProfile.
   */
  public void setSidebandProfile(SidebandProfile sidebandProfile) {
    this.sidebandProfile = sidebandProfile;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Nat'ted floating source ip address(es) for upstream connection to servers.
   * @return snatIp
   */
  public List<IpAddr> getSnatIp() {
    return snatIp;
  }

  /**
   * This is the setter method. this will set the snatIp
   * Nat'ted floating source ip address(es) for upstream connection to servers.
   * @return snatIp
   */
  public void setSnatIp(List<IpAddr>  snatIp) {
    this.snatIp = snatIp;
  }

  /**
   * This is the setter method this will set the snatIp
   * Nat'ted floating source ip address(es) for upstream connection to servers.
   * @return snatIp
   */
  public VirtualService addSnatIpItem(IpAddr snatIpItem) {
    if (this.snatIp == null) {
      this.snatIp = new ArrayList<IpAddr>();
    }
    this.snatIp.add(snatIpItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Gslb pools used to manage site-persistence functionality.
   * Each site-persistence pool contains the virtualservices in all the other sites, that is auto-generated by the gslb manager.
   * This is a read-only field for the user.
   * It is a reference to an object of type pool.
   * Field introduced in 17.2.2.
   * @return spPoolRefs
   */
  public List<String> getSpPoolRefs() {
    return spPoolRefs;
  }

  /**
   * This is the setter method. this will set the spPoolRefs
   * Gslb pools used to manage site-persistence functionality.
   * Each site-persistence pool contains the virtualservices in all the other sites, that is auto-generated by the gslb manager.
   * This is a read-only field for the user.
   * It is a reference to an object of type pool.
   * Field introduced in 17.2.2.
   * @return spPoolRefs
   */
  public void setSpPoolRefs(List<String>  spPoolRefs) {
    this.spPoolRefs = spPoolRefs;
  }

  /**
   * This is the setter method this will set the spPoolRefs
   * Gslb pools used to manage site-persistence functionality.
   * Each site-persistence pool contains the virtualservices in all the other sites, that is auto-generated by the gslb manager.
   * This is a read-only field for the user.
   * It is a reference to an object of type pool.
   * Field introduced in 17.2.2.
   * @return spPoolRefs
   */
  public VirtualService addSpPoolRefsItem(String spPoolRefsItem) {
    if (this.spPoolRefs == null) {
      this.spPoolRefs = new ArrayList<String>();
    }
    this.spPoolRefs.add(spPoolRefsItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Select or create one or two certificates, ec and/or rsa, that will be presented to ssl/tls terminated connections.
   * It is a reference to an object of type sslkeyandcertificate.
   * @return sslKeyAndCertificateRefs
   */
  public List<String> getSslKeyAndCertificateRefs() {
    return sslKeyAndCertificateRefs;
  }

  /**
   * This is the setter method. this will set the sslKeyAndCertificateRefs
   * Select or create one or two certificates, ec and/or rsa, that will be presented to ssl/tls terminated connections.
   * It is a reference to an object of type sslkeyandcertificate.
   * @return sslKeyAndCertificateRefs
   */
  public void setSslKeyAndCertificateRefs(List<String>  sslKeyAndCertificateRefs) {
    this.sslKeyAndCertificateRefs = sslKeyAndCertificateRefs;
  }

  /**
   * This is the setter method this will set the sslKeyAndCertificateRefs
   * Select or create one or two certificates, ec and/or rsa, that will be presented to ssl/tls terminated connections.
   * It is a reference to an object of type sslkeyandcertificate.
   * @return sslKeyAndCertificateRefs
   */
  public VirtualService addSslKeyAndCertificateRefsItem(String sslKeyAndCertificateRefsItem) {
    if (this.sslKeyAndCertificateRefs == null) {
      this.sslKeyAndCertificateRefs = new ArrayList<String>();
    }
    this.sslKeyAndCertificateRefs.add(sslKeyAndCertificateRefsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Determines the set of ssl versions and ciphers to accept for ssl/tls terminated connections.
   * It is a reference to an object of type sslprofile.
   * @return sslProfileRef
   */
  public String getSslProfileRef() {
    return sslProfileRef;
  }

  /**
   * This is the setter method to the attribute.
   * Determines the set of ssl versions and ciphers to accept for ssl/tls terminated connections.
   * It is a reference to an object of type sslprofile.
   * @param sslProfileRef set the sslProfileRef.
   */
  public void setSslProfileRef(String  sslProfileRef) {
    this.sslProfileRef = sslProfileRef;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Select ssl profile based on client ip address match.
   * Field introduced in 18.2.3.
   * @return sslProfileSelectors
   */
  public List<SSLProfileSelector> getSslProfileSelectors() {
    return sslProfileSelectors;
  }

  /**
   * This is the setter method. this will set the sslProfileSelectors
   * Select ssl profile based on client ip address match.
   * Field introduced in 18.2.3.
   * @return sslProfileSelectors
   */
  public void setSslProfileSelectors(List<SSLProfileSelector>  sslProfileSelectors) {
    this.sslProfileSelectors = sslProfileSelectors;
  }

  /**
   * This is the setter method this will set the sslProfileSelectors
   * Select ssl profile based on client ip address match.
   * Field introduced in 18.2.3.
   * @return sslProfileSelectors
   */
  public VirtualService addSslProfileSelectorsItem(SSLProfileSelector sslProfileSelectorsItem) {
    if (this.sslProfileSelectors == null) {
      this.sslProfileSelectors = new ArrayList<SSLProfileSelector>();
    }
    this.sslProfileSelectors.add(sslProfileSelectorsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Expected number of ssl session cache entries (may be exceeded).
   * Allowed values are 1024-16383.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1024.
   * @return sslSessCacheAvgSize
   */
  public Integer getSslSessCacheAvgSize() {
    return sslSessCacheAvgSize;
  }

  /**
   * This is the setter method to the attribute.
   * Expected number of ssl session cache entries (may be exceeded).
   * Allowed values are 1024-16383.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1024.
   * @param sslSessCacheAvgSize set the sslSessCacheAvgSize.
   */
  public void setSslSessCacheAvgSize(Integer  sslSessCacheAvgSize) {
    this.sslSessCacheAvgSize = sslSessCacheAvgSize;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Client authentication and authorization policy for the virtualservice.
   * Field deprecated in 18.2.3.
   * Field introduced in 18.2.1.
   * @return ssoPolicy
   */
  public SSOPolicy getSsoPolicy() {
    return ssoPolicy;
  }

  /**
   * This is the setter method to the attribute.
   * Client authentication and authorization policy for the virtualservice.
   * Field deprecated in 18.2.3.
   * Field introduced in 18.2.1.
   * @param ssoPolicy set the ssoPolicy.
   */
  public void setSsoPolicy(SSOPolicy ssoPolicy) {
    this.ssoPolicy = ssoPolicy;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The sso policy attached to the virtualservice.
   * It is a reference to an object of type ssopolicy.
   * Field introduced in 18.2.3.
   * @return ssoPolicyRef
   */
  public String getSsoPolicyRef() {
    return ssoPolicyRef;
  }

  /**
   * This is the setter method to the attribute.
   * The sso policy attached to the virtualservice.
   * It is a reference to an object of type ssopolicy.
   * Field introduced in 18.2.3.
   * @param ssoPolicyRef set the ssoPolicyRef.
   */
  public void setSsoPolicyRef(String  ssoPolicyRef) {
    this.ssoPolicyRef = ssoPolicyRef;
  }
  /**
   * This is the getter method this will return the attribute value.
   * List of static dns records applied to this virtual service.
   * These are static entries and no health monitoring is performed against the ip addresses.
   * @return staticDnsRecords
   */
  public List<DnsRecord> getStaticDnsRecords() {
    return staticDnsRecords;
  }

  /**
   * This is the setter method. this will set the staticDnsRecords
   * List of static dns records applied to this virtual service.
   * These are static entries and no health monitoring is performed against the ip addresses.
   * @return staticDnsRecords
   */
  public void setStaticDnsRecords(List<DnsRecord>  staticDnsRecords) {
    this.staticDnsRecords = staticDnsRecords;
  }

  /**
   * This is the setter method this will set the staticDnsRecords
   * List of static dns records applied to this virtual service.
   * These are static entries and no health monitoring is performed against the ip addresses.
   * @return staticDnsRecords
   */
  public VirtualService addStaticDnsRecordsItem(DnsRecord staticDnsRecordsItem) {
    if (this.staticDnsRecords == null) {
      this.staticDnsRecords = new ArrayList<DnsRecord>();
    }
    this.staticDnsRecords.add(staticDnsRecordsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Subnet providing reachability for client facing virtual service ip.
   * Field deprecated in 17.1.1.
   * @return subnet
   */
  public IpAddrPrefix getSubnet() {
    return subnet;
  }

  /**
   * This is the setter method to the attribute.
   * Subnet providing reachability for client facing virtual service ip.
   * Field deprecated in 17.1.1.
   * @param subnet set the subnet.
   */
  public void setSubnet(IpAddrPrefix subnet) {
    this.subnet = subnet;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It represents subnet for the virtual service ip address allocation when auto_allocate_ip is true.it is only applicable in openstack or aws cloud.
   * This field is required if auto_allocate_ip is true.
   * Field deprecated in 17.1.1.
   * @return subnetUuid
   */
  public String getSubnetUuid() {
    return subnetUuid;
  }

  /**
   * This is the setter method to the attribute.
   * It represents subnet for the virtual service ip address allocation when auto_allocate_ip is true.it is only applicable in openstack or aws cloud.
   * This field is required if auto_allocate_ip is true.
   * Field deprecated in 17.1.1.
   * @param subnetUuid set the subnetUuid.
   */
  public void setSubnetUuid(String  subnetUuid) {
    this.subnetUuid = subnetUuid;
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
   * Used for testing se datastore upgrade 2.0 functionality.
   * It is a reference to an object of type testsedatastorelevel1.
   * Field introduced in 18.2.6.
   * @return testSeDatastoreLevel1Ref
   */
  public String getTestSeDatastoreLevel1Ref() {
    return testSeDatastoreLevel1Ref;
  }

  /**
   * This is the setter method to the attribute.
   * Used for testing se datastore upgrade 2.0 functionality.
   * It is a reference to an object of type testsedatastorelevel1.
   * Field introduced in 18.2.6.
   * @param testSeDatastoreLevel1Ref set the testSeDatastoreLevel1Ref.
   */
  public void setTestSeDatastoreLevel1Ref(String  testSeDatastoreLevel1Ref) {
    this.testSeDatastoreLevel1Ref = testSeDatastoreLevel1Ref;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Topology policies applied on the dns traffic of the virtual service based ongslb topology algorithm.
   * Field introduced in 18.2.3.
   * @return topologyPolicies
   */
  public List<DnsPolicies> getTopologyPolicies() {
    return topologyPolicies;
  }

  /**
   * This is the setter method. this will set the topologyPolicies
   * Topology policies applied on the dns traffic of the virtual service based ongslb topology algorithm.
   * Field introduced in 18.2.3.
   * @return topologyPolicies
   */
  public void setTopologyPolicies(List<DnsPolicies>  topologyPolicies) {
    this.topologyPolicies = topologyPolicies;
  }

  /**
   * This is the setter method this will set the topologyPolicies
   * Topology policies applied on the dns traffic of the virtual service based ongslb topology algorithm.
   * Field introduced in 18.2.3.
   * @return topologyPolicies
   */
  public VirtualService addTopologyPoliciesItem(DnsPolicies topologyPoliciesItem) {
    if (this.topologyPolicies == null) {
      this.topologyPolicies = new ArrayList<DnsPolicies>();
    }
    this.topologyPolicies.add(topologyPoliciesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Server network or list of servers for cloning traffic.
   * It is a reference to an object of type trafficcloneprofile.
   * Field introduced in 17.1.1.
   * @return trafficCloneProfileRef
   */
  public String getTrafficCloneProfileRef() {
    return trafficCloneProfileRef;
  }

  /**
   * This is the setter method to the attribute.
   * Server network or list of servers for cloning traffic.
   * It is a reference to an object of type trafficcloneprofile.
   * Field introduced in 17.1.1.
   * @param trafficCloneProfileRef set the trafficCloneProfileRef.
   */
  public void setTrafficCloneProfileRef(String  trafficCloneProfileRef) {
    this.trafficCloneProfileRef = trafficCloneProfileRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Knob to enable the virtual service traffic on its assigned service engines.
   * This setting is effective only when the enabled flag is set to true.
   * Field introduced in 17.2.8.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return trafficEnabled
   */
  public Boolean getTrafficEnabled() {
    return trafficEnabled;
  }

  /**
   * This is the setter method to the attribute.
   * Knob to enable the virtual service traffic on its assigned service engines.
   * This setting is effective only when the enabled flag is set to true.
   * Field introduced in 17.2.8.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param trafficEnabled set the trafficEnabled.
   */
  public void setTrafficEnabled(Boolean  trafficEnabled) {
    this.trafficEnabled = trafficEnabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Specify if this is a normal virtual service, or if it is the parent or child of an sni-enabled virtual hosted virtual service.
   * Enum options - VS_TYPE_NORMAL, VS_TYPE_VH_PARENT, VS_TYPE_VH_CHILD.
   * Default value when not specified in API or module is interpreted by Avi Controller as VS_TYPE_NORMAL.
   * @return type
   */
  public String getType() {
    return type;
  }

  /**
   * This is the setter method to the attribute.
   * Specify if this is a normal virtual service, or if it is the parent or child of an sni-enabled virtual hosted virtual service.
   * Enum options - VS_TYPE_NORMAL, VS_TYPE_VH_PARENT, VS_TYPE_VH_CHILD.
   * Default value when not specified in API or module is interpreted by Avi Controller as VS_TYPE_NORMAL.
   * @param type set the type.
   */
  public void setType(String  type) {
    this.type = type;
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
   * Use bridge ip as vip on each host in mesos deployments.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return useBridgeIpAsVip
   */
  public Boolean getUseBridgeIpAsVip() {
    return useBridgeIpAsVip;
  }

  /**
   * This is the setter method to the attribute.
   * Use bridge ip as vip on each host in mesos deployments.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param useBridgeIpAsVip set the useBridgeIpAsVip.
   */
  public void setUseBridgeIpAsVip(Boolean  useBridgeIpAsVip) {
    this.useBridgeIpAsVip = useBridgeIpAsVip;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Use the virtual ip as the snat ip for health monitoring and sending traffic to the backend servers instead of the service engine interface ip.
   * The caveat of enabling this option is that the virtualservice cannot be configued in an active-active ha mode.
   * Dns based multi vip solution has to be used for ha & non-disruptive upgrade purposes.
   * Field introduced in 17.1.9,17.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return useVipAsSnat
   */
  public Boolean getUseVipAsSnat() {
    return useVipAsSnat;
  }

  /**
   * This is the setter method to the attribute.
   * Use the virtual ip as the snat ip for health monitoring and sending traffic to the backend servers instead of the service engine interface ip.
   * The caveat of enabling this option is that the virtualservice cannot be configued in an active-active ha mode.
   * Dns based multi vip solution has to be used for ha & non-disruptive upgrade purposes.
   * Field introduced in 17.1.9,17.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param useVipAsSnat set the useVipAsSnat.
   */
  public void setUseVipAsSnat(Boolean  useVipAsSnat) {
    this.useVipAsSnat = useVipAsSnat;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Uuid of the virtualservice.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the virtualservice.
   * @param uuid set the uuid.
   */
  public void setUuid(String  uuid) {
    this.uuid = uuid;
  }
  /**
   * This is the getter method this will return the attribute value.
   * The exact name requested from the client's sni-enabled tls hello domain name field.
   * If this is a match, the parent vs will forward the connection to this child vs.
   * @return vhDomainName
   */
  public List<String> getVhDomainName() {
    return vhDomainName;
  }

  /**
   * This is the setter method. this will set the vhDomainName
   * The exact name requested from the client's sni-enabled tls hello domain name field.
   * If this is a match, the parent vs will forward the connection to this child vs.
   * @return vhDomainName
   */
  public void setVhDomainName(List<String>  vhDomainName) {
    this.vhDomainName = vhDomainName;
  }

  /**
   * This is the setter method this will set the vhDomainName
   * The exact name requested from the client's sni-enabled tls hello domain name field.
   * If this is a match, the parent vs will forward the connection to this child vs.
   * @return vhDomainName
   */
  public VirtualService addVhDomainNameItem(String vhDomainNameItem) {
    if (this.vhDomainName == null) {
      this.vhDomainName = new ArrayList<String>();
    }
    this.vhDomainName.add(vhDomainNameItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Specifies the virtual service acting as virtual hosting (sni) parent.
   * @return vhParentVsUuid
   */
  public String getVhParentVsUuid() {
    return vhParentVsUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Specifies the virtual service acting as virtual hosting (sni) parent.
   * @param vhParentVsUuid set the vhParentVsUuid.
   */
  public void setVhParentVsUuid(String  vhParentVsUuid) {
    this.vhParentVsUuid = vhParentVsUuid;
  }
  /**
   * This is the getter method this will return the attribute value.
   * List of virtual service ips.
   * While creating a 'shared vs',please use vsvip_ref to point to the shared entities.
   * Field introduced in 17.1.1.
   * @return vip
   */
  public List<Vip> getVip() {
    return vip;
  }

  /**
   * This is the setter method. this will set the vip
   * List of virtual service ips.
   * While creating a 'shared vs',please use vsvip_ref to point to the shared entities.
   * Field introduced in 17.1.1.
   * @return vip
   */
  public void setVip(List<Vip>  vip) {
    this.vip = vip;
  }

  /**
   * This is the setter method this will set the vip
   * List of virtual service ips.
   * While creating a 'shared vs',please use vsvip_ref to point to the shared entities.
   * Field introduced in 17.1.1.
   * @return vip
   */
  public VirtualService addVipItem(Vip vipItem) {
    if (this.vip == null) {
      this.vip = new ArrayList<Vip>();
    }
    this.vip.add(vipItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Virtual routing context that the virtual service is bound to.
   * This is used to provide the isolation of the set of networks the application is attached to.
   * It is a reference to an object of type vrfcontext.
   * @return vrfContextRef
   */
  public String getVrfContextRef() {
    return vrfContextRef;
  }

  /**
   * This is the setter method to the attribute.
   * Virtual routing context that the virtual service is bound to.
   * This is used to provide the isolation of the set of networks the application is attached to.
   * It is a reference to an object of type vrfcontext.
   * @param vrfContextRef set the vrfContextRef.
   */
  public void setVrfContextRef(String  vrfContextRef) {
    this.vrfContextRef = vrfContextRef;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Datascripts applied on the data traffic of the virtual service.
   * @return vsDatascripts
   */
  public List<VSDataScripts> getVsDatascripts() {
    return vsDatascripts;
  }

  /**
   * This is the setter method. this will set the vsDatascripts
   * Datascripts applied on the data traffic of the virtual service.
   * @return vsDatascripts
   */
  public void setVsDatascripts(List<VSDataScripts>  vsDatascripts) {
    this.vsDatascripts = vsDatascripts;
  }

  /**
   * This is the setter method this will set the vsDatascripts
   * Datascripts applied on the data traffic of the virtual service.
   * @return vsDatascripts
   */
  public VirtualService addVsDatascriptsItem(VSDataScripts vsDatascriptsItem) {
    if (this.vsDatascripts == null) {
      this.vsDatascripts = new ArrayList<VSDataScripts>();
    }
    this.vsDatascripts.add(vsDatascriptsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Checksum of cloud configuration for vsvip.
   * Internally set by cloud connector.
   * Field introduced in 17.2.9, 18.1.2.
   * @return vsvipCloudConfigCksum
   */
  public String getVsvipCloudConfigCksum() {
    return vsvipCloudConfigCksum;
  }

  /**
   * This is the setter method to the attribute.
   * Checksum of cloud configuration for vsvip.
   * Internally set by cloud connector.
   * Field introduced in 17.2.9, 18.1.2.
   * @param vsvipCloudConfigCksum set the vsvipCloudConfigCksum.
   */
  public void setVsvipCloudConfigCksum(String  vsvipCloudConfigCksum) {
    this.vsvipCloudConfigCksum = vsvipCloudConfigCksum;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Mostly used during the creation of shared vs, this field refers to entities that can be shared across virtual services.
   * It is a reference to an object of type vsvip.
   * Field introduced in 17.1.1.
   * @return vsvipRef
   */
  public String getVsvipRef() {
    return vsvipRef;
  }

  /**
   * This is the setter method to the attribute.
   * Mostly used during the creation of shared vs, this field refers to entities that can be shared across virtual services.
   * It is a reference to an object of type vsvip.
   * Field introduced in 17.1.1.
   * @param vsvipRef set the vsvipRef.
   */
  public void setVsvipRef(String  vsvipRef) {
    this.vsvipRef = vsvipRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Waf policy for the virtual service.
   * It is a reference to an object of type wafpolicy.
   * Field introduced in 17.2.1.
   * @return wafPolicyRef
   */
  public String getWafPolicyRef() {
    return wafPolicyRef;
  }

  /**
   * This is the setter method to the attribute.
   * Waf policy for the virtual service.
   * It is a reference to an object of type wafpolicy.
   * Field introduced in 17.2.1.
   * @param wafPolicyRef set the wafPolicyRef.
   */
  public void setWafPolicyRef(String  wafPolicyRef) {
    this.wafPolicyRef = wafPolicyRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The quality of service weight to assign to traffic transmitted from this virtual service.
   * A higher weight will prioritize traffic versus other virtual services sharing the same service engines.
   * Allowed values are 1-128.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.
   * @return weight
   */
  public Integer getWeight() {
    return weight;
  }

  /**
   * This is the setter method to the attribute.
   * The quality of service weight to assign to traffic transmitted from this virtual service.
   * A higher weight will prioritize traffic versus other virtual services sharing the same service engines.
   * Allowed values are 1-128.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.
   * @param weight set the weight.
   */
  public void setWeight(Integer  weight) {
    this.weight = weight;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VirtualService objVirtualService = (VirtualService) o;
  return   Objects.equals(this.uuid, objVirtualService.uuid)&&
  Objects.equals(this.name, objVirtualService.name)&&
  Objects.equals(this.fqdn, objVirtualService.fqdn)&&
  Objects.equals(this.ipAddress, objVirtualService.ipAddress)&&
  Objects.equals(this.enabled, objVirtualService.enabled)&&
  Objects.equals(this.services, objVirtualService.services)&&
  Objects.equals(this.applicationProfileRef, objVirtualService.applicationProfileRef)&&
  Objects.equals(this.networkProfileRef, objVirtualService.networkProfileRef)&&
  Objects.equals(this.serverNetworkProfileRef, objVirtualService.serverNetworkProfileRef)&&
  Objects.equals(this.poolRef, objVirtualService.poolRef)&&
  Objects.equals(this.seGroupRef, objVirtualService.seGroupRef)&&
  Objects.equals(this.networkSecurityPolicyRef, objVirtualService.networkSecurityPolicyRef)&&
  Objects.equals(this.httpPolicies, objVirtualService.httpPolicies)&&
  Objects.equals(this.dnsPolicies, objVirtualService.dnsPolicies)&&
  Objects.equals(this.securityPolicyRef, objVirtualService.securityPolicyRef)&&
  Objects.equals(this.sslKeyAndCertificateRefs, objVirtualService.sslKeyAndCertificateRefs)&&
  Objects.equals(this.sslProfileRef, objVirtualService.sslProfileRef)&&
  Objects.equals(this.performanceLimits, objVirtualService.performanceLimits)&&
  Objects.equals(this.analyticsPolicy, objVirtualService.analyticsPolicy)&&
  Objects.equals(this.networkRef, objVirtualService.networkRef)&&
  Objects.equals(this.vrfContextRef, objVirtualService.vrfContextRef)&&
  Objects.equals(this.enableAutogw, objVirtualService.enableAutogw)&&
  Objects.equals(this.portUuid, objVirtualService.portUuid)&&
  Objects.equals(this.subnetUuid, objVirtualService.subnetUuid)&&
  Objects.equals(this.analyticsProfileRef, objVirtualService.analyticsProfileRef)&&
  Objects.equals(this.discoveredNetworkRef, objVirtualService.discoveredNetworkRef)&&
  Objects.equals(this.discoveredSubnet, objVirtualService.discoveredSubnet)&&
  Objects.equals(this.hostNameXlate, objVirtualService.hostNameXlate)&&
  Objects.equals(this.subnet, objVirtualService.subnet)&&
  Objects.equals(this.discoveredNetworks, objVirtualService.discoveredNetworks)&&
  Objects.equals(this.vsDatascripts, objVirtualService.vsDatascripts)&&
  Objects.equals(this.clientAuth, objVirtualService.clientAuth)&&
  Objects.equals(this.weight, objVirtualService.weight)&&
  Objects.equals(this.delayFairness, objVirtualService.delayFairness)&&
  Objects.equals(this.maxCpsPerClient, objVirtualService.maxCpsPerClient)&&
  Objects.equals(this.limitDoser, objVirtualService.limitDoser)&&
  Objects.equals(this.type, objVirtualService.type)&&
  Objects.equals(this.vhParentVsUuid, objVirtualService.vhParentVsUuid)&&
  Objects.equals(this.vhDomainName, objVirtualService.vhDomainName)&&
  Objects.equals(this.availabilityZone, objVirtualService.availabilityZone)&&
  Objects.equals(this.autoAllocateIp, objVirtualService.autoAllocateIp)&&
  Objects.equals(this.floatingIp, objVirtualService.floatingIp)&&
  Objects.equals(this.autoAllocateFloatingIp, objVirtualService.autoAllocateFloatingIp)&&
  Objects.equals(this.floatingSubnetUuid, objVirtualService.floatingSubnetUuid)&&
  Objects.equals(this.cloudType, objVirtualService.cloudType)&&
  Objects.equals(this.aviAllocatedVip, objVirtualService.aviAllocatedVip)&&
  Objects.equals(this.aviAllocatedFip, objVirtualService.aviAllocatedFip)&&
  Objects.equals(this.connectionsRateLimit, objVirtualService.connectionsRateLimit)&&
  Objects.equals(this.requestsRateLimit, objVirtualService.requestsRateLimit)&&
  Objects.equals(this.useBridgeIpAsVip, objVirtualService.useBridgeIpAsVip)&&
  Objects.equals(this.flowDist, objVirtualService.flowDist)&&
  Objects.equals(this.ignPoolNetReach, objVirtualService.ignPoolNetReach)&&
  Objects.equals(this.sslSessCacheAvgSize, objVirtualService.sslSessCacheAvgSize)&&
  Objects.equals(this.poolGroupRef, objVirtualService.poolGroupRef)&&
  Objects.equals(this.removeListeningPortOnVsDown, objVirtualService.removeListeningPortOnVsDown)&&
  Objects.equals(this.closeClientConnOnConfigUpdate, objVirtualService.closeClientConnOnConfigUpdate)&&
  Objects.equals(this.bulkSyncKvcache, objVirtualService.bulkSyncKvcache)&&
  Objects.equals(this.topologyPolicies, objVirtualService.topologyPolicies)&&
  Objects.equals(this.advertiseDownVs, objVirtualService.advertiseDownVs)&&
  Objects.equals(this.description, objVirtualService.description)&&
  Objects.equals(this.tenantRef, objVirtualService.tenantRef)&&
  Objects.equals(this.cloudRef, objVirtualService.cloudRef)&&
  Objects.equals(this.eastWestPlacement, objVirtualService.eastWestPlacement)&&
  Objects.equals(this.scaleoutEcmp, objVirtualService.scaleoutEcmp)&&
  Objects.equals(this.microserviceRef, objVirtualService.microserviceRef)&&
  Objects.equals(this.servicePoolSelect, objVirtualService.servicePoolSelect)&&
  Objects.equals(this.createdBy, objVirtualService.createdBy)&&
  Objects.equals(this.cloudConfigCksum, objVirtualService.cloudConfigCksum)&&
  Objects.equals(this.enableRhi, objVirtualService.enableRhi)&&
  Objects.equals(this.snatIp, objVirtualService.snatIp)&&
  Objects.equals(this.activeStandbySeTag, objVirtualService.activeStandbySeTag)&&
  Objects.equals(this.flowLabelType, objVirtualService.flowLabelType)&&
  Objects.equals(this.enableRhiSnat, objVirtualService.enableRhiSnat)&&
  Objects.equals(this.staticDnsRecords, objVirtualService.staticDnsRecords)&&
  Objects.equals(this.ipamNetworkSubnet, objVirtualService.ipamNetworkSubnet)&&
  Objects.equals(this.dnsInfo, objVirtualService.dnsInfo)&&
  Objects.equals(this.serviceMetadata, objVirtualService.serviceMetadata)&&
  Objects.equals(this.trafficCloneProfileRef, objVirtualService.trafficCloneProfileRef)&&
  Objects.equals(this.contentRewrite, objVirtualService.contentRewrite)&&
  Objects.equals(this.sidebandProfile, objVirtualService.sidebandProfile)&&
  Objects.equals(this.vip, objVirtualService.vip)&&
  Objects.equals(this.nsxSecuritygroup, objVirtualService.nsxSecuritygroup)&&
  Objects.equals(this.vsvipRef, objVirtualService.vsvipRef)&&
  Objects.equals(this.wafPolicyRef, objVirtualService.wafPolicyRef)&&
  Objects.equals(this.spPoolRefs, objVirtualService.spPoolRefs)&&
  Objects.equals(this.useVipAsSnat, objVirtualService.useVipAsSnat)&&
  Objects.equals(this.errorPageProfileRef, objVirtualService.errorPageProfileRef)&&
  Objects.equals(this.l4Policies, objVirtualService.l4Policies)&&
  Objects.equals(this.trafficEnabled, objVirtualService.trafficEnabled)&&
  Objects.equals(this.apicContractGraph, objVirtualService.apicContractGraph)&&
  Objects.equals(this.vsvipCloudConfigCksum, objVirtualService.vsvipCloudConfigCksum)&&
  Objects.equals(this.azureAvailabilitySet, objVirtualService.azureAvailabilitySet)&&
  Objects.equals(this.minPoolsUp, objVirtualService.minPoolsUp)&&
  Objects.equals(this.ssoPolicy, objVirtualService.ssoPolicy)&&
  Objects.equals(this.allowInvalidClientCert, objVirtualService.allowInvalidClientCert)&&
  Objects.equals(this.sslProfileSelectors, objVirtualService.sslProfileSelectors)&&
  Objects.equals(this.ssoPolicyRef, objVirtualService.ssoPolicyRef)&&
  Objects.equals(this.samlSpConfig, objVirtualService.samlSpConfig)&&
  Objects.equals(this.testSeDatastoreLevel1Ref, objVirtualService.testSeDatastoreLevel1Ref)&&
  Objects.equals(this.icapRequestProfileRefs, objVirtualService.icapRequestProfileRefs);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VirtualService {\n");
      sb.append("    activeStandbySeTag: ").append(toIndentedString(activeStandbySeTag)).append("\n");
        sb.append("    advertiseDownVs: ").append(toIndentedString(advertiseDownVs)).append("\n");
        sb.append("    allowInvalidClientCert: ").append(toIndentedString(allowInvalidClientCert)).append("\n");
        sb.append("    analyticsPolicy: ").append(toIndentedString(analyticsPolicy)).append("\n");
        sb.append("    analyticsProfileRef: ").append(toIndentedString(analyticsProfileRef)).append("\n");
        sb.append("    apicContractGraph: ").append(toIndentedString(apicContractGraph)).append("\n");
        sb.append("    applicationProfileRef: ").append(toIndentedString(applicationProfileRef)).append("\n");
        sb.append("    autoAllocateFloatingIp: ").append(toIndentedString(autoAllocateFloatingIp)).append("\n");
        sb.append("    autoAllocateIp: ").append(toIndentedString(autoAllocateIp)).append("\n");
        sb.append("    availabilityZone: ").append(toIndentedString(availabilityZone)).append("\n");
        sb.append("    aviAllocatedFip: ").append(toIndentedString(aviAllocatedFip)).append("\n");
        sb.append("    aviAllocatedVip: ").append(toIndentedString(aviAllocatedVip)).append("\n");
        sb.append("    azureAvailabilitySet: ").append(toIndentedString(azureAvailabilitySet)).append("\n");
        sb.append("    bulkSyncKvcache: ").append(toIndentedString(bulkSyncKvcache)).append("\n");
        sb.append("    clientAuth: ").append(toIndentedString(clientAuth)).append("\n");
        sb.append("    closeClientConnOnConfigUpdate: ").append(toIndentedString(closeClientConnOnConfigUpdate)).append("\n");
        sb.append("    cloudConfigCksum: ").append(toIndentedString(cloudConfigCksum)).append("\n");
        sb.append("    cloudRef: ").append(toIndentedString(cloudRef)).append("\n");
        sb.append("    cloudType: ").append(toIndentedString(cloudType)).append("\n");
        sb.append("    connectionsRateLimit: ").append(toIndentedString(connectionsRateLimit)).append("\n");
        sb.append("    contentRewrite: ").append(toIndentedString(contentRewrite)).append("\n");
        sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
        sb.append("    delayFairness: ").append(toIndentedString(delayFairness)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    discoveredNetworkRef: ").append(toIndentedString(discoveredNetworkRef)).append("\n");
        sb.append("    discoveredNetworks: ").append(toIndentedString(discoveredNetworks)).append("\n");
        sb.append("    discoveredSubnet: ").append(toIndentedString(discoveredSubnet)).append("\n");
        sb.append("    dnsInfo: ").append(toIndentedString(dnsInfo)).append("\n");
        sb.append("    dnsPolicies: ").append(toIndentedString(dnsPolicies)).append("\n");
        sb.append("    eastWestPlacement: ").append(toIndentedString(eastWestPlacement)).append("\n");
        sb.append("    enableAutogw: ").append(toIndentedString(enableAutogw)).append("\n");
        sb.append("    enableRhi: ").append(toIndentedString(enableRhi)).append("\n");
        sb.append("    enableRhiSnat: ").append(toIndentedString(enableRhiSnat)).append("\n");
        sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
        sb.append("    errorPageProfileRef: ").append(toIndentedString(errorPageProfileRef)).append("\n");
        sb.append("    floatingIp: ").append(toIndentedString(floatingIp)).append("\n");
        sb.append("    floatingSubnetUuid: ").append(toIndentedString(floatingSubnetUuid)).append("\n");
        sb.append("    flowDist: ").append(toIndentedString(flowDist)).append("\n");
        sb.append("    flowLabelType: ").append(toIndentedString(flowLabelType)).append("\n");
        sb.append("    fqdn: ").append(toIndentedString(fqdn)).append("\n");
        sb.append("    hostNameXlate: ").append(toIndentedString(hostNameXlate)).append("\n");
        sb.append("    httpPolicies: ").append(toIndentedString(httpPolicies)).append("\n");
        sb.append("    icapRequestProfileRefs: ").append(toIndentedString(icapRequestProfileRefs)).append("\n");
        sb.append("    ignPoolNetReach: ").append(toIndentedString(ignPoolNetReach)).append("\n");
        sb.append("    ipAddress: ").append(toIndentedString(ipAddress)).append("\n");
        sb.append("    ipamNetworkSubnet: ").append(toIndentedString(ipamNetworkSubnet)).append("\n");
        sb.append("    l4Policies: ").append(toIndentedString(l4Policies)).append("\n");
        sb.append("    limitDoser: ").append(toIndentedString(limitDoser)).append("\n");
        sb.append("    maxCpsPerClient: ").append(toIndentedString(maxCpsPerClient)).append("\n");
        sb.append("    microserviceRef: ").append(toIndentedString(microserviceRef)).append("\n");
        sb.append("    minPoolsUp: ").append(toIndentedString(minPoolsUp)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    networkProfileRef: ").append(toIndentedString(networkProfileRef)).append("\n");
        sb.append("    networkRef: ").append(toIndentedString(networkRef)).append("\n");
        sb.append("    networkSecurityPolicyRef: ").append(toIndentedString(networkSecurityPolicyRef)).append("\n");
        sb.append("    nsxSecuritygroup: ").append(toIndentedString(nsxSecuritygroup)).append("\n");
        sb.append("    performanceLimits: ").append(toIndentedString(performanceLimits)).append("\n");
        sb.append("    poolGroupRef: ").append(toIndentedString(poolGroupRef)).append("\n");
        sb.append("    poolRef: ").append(toIndentedString(poolRef)).append("\n");
        sb.append("    portUuid: ").append(toIndentedString(portUuid)).append("\n");
        sb.append("    removeListeningPortOnVsDown: ").append(toIndentedString(removeListeningPortOnVsDown)).append("\n");
        sb.append("    requestsRateLimit: ").append(toIndentedString(requestsRateLimit)).append("\n");
        sb.append("    samlSpConfig: ").append(toIndentedString(samlSpConfig)).append("\n");
        sb.append("    scaleoutEcmp: ").append(toIndentedString(scaleoutEcmp)).append("\n");
        sb.append("    seGroupRef: ").append(toIndentedString(seGroupRef)).append("\n");
        sb.append("    securityPolicyRef: ").append(toIndentedString(securityPolicyRef)).append("\n");
        sb.append("    serverNetworkProfileRef: ").append(toIndentedString(serverNetworkProfileRef)).append("\n");
        sb.append("    serviceMetadata: ").append(toIndentedString(serviceMetadata)).append("\n");
        sb.append("    servicePoolSelect: ").append(toIndentedString(servicePoolSelect)).append("\n");
        sb.append("    services: ").append(toIndentedString(services)).append("\n");
        sb.append("    sidebandProfile: ").append(toIndentedString(sidebandProfile)).append("\n");
        sb.append("    snatIp: ").append(toIndentedString(snatIp)).append("\n");
        sb.append("    spPoolRefs: ").append(toIndentedString(spPoolRefs)).append("\n");
        sb.append("    sslKeyAndCertificateRefs: ").append(toIndentedString(sslKeyAndCertificateRefs)).append("\n");
        sb.append("    sslProfileRef: ").append(toIndentedString(sslProfileRef)).append("\n");
        sb.append("    sslProfileSelectors: ").append(toIndentedString(sslProfileSelectors)).append("\n");
        sb.append("    sslSessCacheAvgSize: ").append(toIndentedString(sslSessCacheAvgSize)).append("\n");
        sb.append("    ssoPolicy: ").append(toIndentedString(ssoPolicy)).append("\n");
        sb.append("    ssoPolicyRef: ").append(toIndentedString(ssoPolicyRef)).append("\n");
        sb.append("    staticDnsRecords: ").append(toIndentedString(staticDnsRecords)).append("\n");
        sb.append("    subnet: ").append(toIndentedString(subnet)).append("\n");
        sb.append("    subnetUuid: ").append(toIndentedString(subnetUuid)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
        sb.append("    testSeDatastoreLevel1Ref: ").append(toIndentedString(testSeDatastoreLevel1Ref)).append("\n");
        sb.append("    topologyPolicies: ").append(toIndentedString(topologyPolicies)).append("\n");
        sb.append("    trafficCloneProfileRef: ").append(toIndentedString(trafficCloneProfileRef)).append("\n");
        sb.append("    trafficEnabled: ").append(toIndentedString(trafficEnabled)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
            sb.append("    useBridgeIpAsVip: ").append(toIndentedString(useBridgeIpAsVip)).append("\n");
        sb.append("    useVipAsSnat: ").append(toIndentedString(useVipAsSnat)).append("\n");
        sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
        sb.append("    vhDomainName: ").append(toIndentedString(vhDomainName)).append("\n");
        sb.append("    vhParentVsUuid: ").append(toIndentedString(vhParentVsUuid)).append("\n");
        sb.append("    vip: ").append(toIndentedString(vip)).append("\n");
        sb.append("    vrfContextRef: ").append(toIndentedString(vrfContextRef)).append("\n");
        sb.append("    vsDatascripts: ").append(toIndentedString(vsDatascripts)).append("\n");
        sb.append("    vsvipCloudConfigCksum: ").append(toIndentedString(vsvipCloudConfigCksum)).append("\n");
        sb.append("    vsvipRef: ").append(toIndentedString(vsvipRef)).append("\n");
        sb.append("    wafPolicyRef: ").append(toIndentedString(wafPolicyRef)).append("\n");
        sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
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

