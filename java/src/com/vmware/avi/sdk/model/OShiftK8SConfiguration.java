package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The OShiftK8SConfiguration is a POJO class extends AviRestResource that used for creating
 * OShiftK8SConfiguration.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OShiftK8SConfiguration  {
    @JsonProperty("app_sync_frequency")
    private Integer appSyncFrequency = 300;

    @JsonProperty("auto_assign_fqdn")
    private Boolean autoAssignFqdn = true;

    @JsonProperty("avi_bridge_subnet")
    private IpAddrPrefix aviBridgeSubnet = null;

    @JsonProperty("ca_tls_key_and_certificate_ref")
    private String caTlsKeyAndCertificateRef = null;

    @JsonProperty("client_tls_key_and_certificate_ref")
    private String clientTlsKeyAndCertificateRef = null;

    @JsonProperty("cluster_tag")
    private String clusterTag = null;

    @JsonProperty("container_port_match_http_service")
    private Boolean containerPortMatchHttpService = true;

    @JsonProperty("coredump_directory")
    private String coredumpDirectory = "/var/lib/systemd/coredump";

    @JsonProperty("default_service_as_east_west_service")
    private Boolean defaultServiceAsEastWestService = true;

    @JsonProperty("default_shared_virtualservice")
    private OshiftSharedVirtualService defaultSharedVirtualservice = null;

    @JsonProperty("disable_auto_backend_service_sync")
    private Boolean disableAutoBackendServiceSync = false;

    @JsonProperty("disable_auto_frontend_service_sync")
    private Boolean disableAutoFrontendServiceSync = false;

    @JsonProperty("disable_auto_gs_sync")
    private Boolean disableAutoGsSync = false;

    @JsonProperty("disable_auto_se_creation")
    private Boolean disableAutoSeCreation = false;

    @JsonProperty("docker_endpoint")
    private String dockerEndpoint = "/var/run/docker.sock";

    @JsonProperty("docker_registry_se")
    private DockerRegistry dockerRegistrySe = null;

    @JsonProperty("east_west_placement_subnet")
    private IpAddrPrefix eastWestPlacementSubnet = null;

    @JsonProperty("enable_event_subscription")
    private Boolean enableEventSubscription = true;

    @JsonProperty("enable_route_ingress_hardening")
    private Boolean enableRouteIngressHardening = true;

    @JsonProperty("feproxy_vips_enable_proxy_arp")
    private Boolean feproxyVipsEnableProxyArp = true;

    @JsonProperty("fleet_endpoint")
    private String fleetEndpoint = null;

    @JsonProperty("http_container_ports")
    private List<Integer> httpContainerPorts = null;

    @JsonProperty("ing_exclude_attributes")
    private List<IngAttribute> ingExcludeAttributes = null;

    @JsonProperty("ing_include_attributes")
    private List<IngAttribute> ingIncludeAttributes = null;

    @JsonProperty("l4_health_monitoring")
    private Boolean l4HealthMonitoring = true;

    @JsonProperty("master_nodes")
    private List<String> masterNodes = null;

    @JsonProperty("node_availability_zone_label")
    private String nodeAvailabilityZoneLabel = null;

    @JsonProperty("ns_exclude_attributes")
    private List<MesosAttribute> nsExcludeAttributes = null;

    @JsonProperty("ns_include_attributes")
    private List<MesosAttribute> nsIncludeAttributes = null;

    @JsonProperty("nuage_controller")
    private NuageSDNController nuageController = null;

    @JsonProperty("num_shards")
    private Integer numShards = 0;

    @JsonProperty("override_service_ports")
    private Boolean overrideServicePorts = true;

    @JsonProperty("persistent_volume_claim")
    private String persistentVolumeClaim = null;

    @JsonProperty("routes")
    private List<RouteInfo> routes = null;

    @JsonProperty("routes_share_virtualservice")
    private Boolean routesShareVirtualservice = null;

    @JsonProperty("sdn_overlay")
    private Boolean sdnOverlay = true;

    @JsonProperty("se_deployment_method")
    private String seDeploymentMethod = "SE_CREATE_POD";

    @JsonProperty("se_exclude_attributes")
    private List<MesosAttribute> seExcludeAttributes = null;

    @JsonProperty("se_image_pull_secret")
    private String seImagePullSecret = null;

    @JsonProperty("se_include_attributes")
    private List<MesosAttribute> seIncludeAttributes = null;

    @JsonProperty("se_namespace")
    private String seNamespace = "default";

    @JsonProperty("se_pod_tolerations")
    private List<PodToleration> sePodTolerations = null;

    @JsonProperty("se_priority_class")
    private String sePriorityClass = null;

    @JsonProperty("se_restart_batch_size")
    private Integer seRestartBatchSize = 1;

    @JsonProperty("se_restart_force")
    private Boolean seRestartForce = false;

    @JsonProperty("se_spawn_rate")
    private Integer seSpawnRate = 25;

    @JsonProperty("se_volume")
    private String seVolume = "/var/lib/avi";

    @JsonProperty("secure_egress_mode")
    private Boolean secureEgressMode = false;

    @JsonProperty("service_account_token")
    private String serviceAccountToken = null;

    @JsonProperty("service_port_match_http_service")
    private Boolean servicePortMatchHttpService = null;

    @JsonProperty("shard_prefix")
    private String shardPrefix = null;

    @JsonProperty("shared_virtualservice_namespace")
    private Boolean sharedVirtualserviceNamespace = false;

    @JsonProperty("ssh_se_deployment")
    private SSHSeDeployment sshSeDeployment = null;

    @JsonProperty("ssh_user_ref")
    private String sshUserRef = null;

    @JsonProperty("sync_not_ready_addresses")
    private Boolean syncNotReadyAddresses = true;

    @JsonProperty("use_controller_image")
    private Boolean useControllerImage = false;

    @JsonProperty("use_resource_definition_as_ssot")
    private Boolean useResourceDefinitionAsSsot = false;

    @JsonProperty("use_scheduling_disabled_nodes")
    private Boolean useSchedulingDisabledNodes = false;

    @JsonProperty("use_service_cluster_ip_as_ew_vip")
    private Boolean useServiceClusterIpAsEwVip = false;

    @JsonProperty("vip_default_gateway")
    private IpAddr vipDefaultGateway = null;



  /**
   * This is the getter method this will return the attribute value.
   * Sync frequency in seconds with frameworks.
   * Default value when not specified in API or module is interpreted by Avi Controller as 300.
   * @return appSyncFrequency
   */
  public Integer getAppSyncFrequency() {
    return appSyncFrequency;
  }

  /**
   * This is the setter method to the attribute.
   * Sync frequency in seconds with frameworks.
   * Default value when not specified in API or module is interpreted by Avi Controller as 300.
   * @param appSyncFrequency set the appSyncFrequency.
   */
  public void setAppSyncFrequency(Integer  appSyncFrequency) {
    this.appSyncFrequency = appSyncFrequency;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Auto assign fqdn to a virtual service if a valid fqdn is not configured.
   * Field introduced in 17.2.8.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return autoAssignFqdn
   */
  public Boolean getAutoAssignFqdn() {
    return autoAssignFqdn;
  }

  /**
   * This is the setter method to the attribute.
   * Auto assign fqdn to a virtual service if a valid fqdn is not configured.
   * Field introduced in 17.2.8.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param autoAssignFqdn set the autoAssignFqdn.
   */
  public void setAutoAssignFqdn(Boolean  autoAssignFqdn) {
    this.autoAssignFqdn = autoAssignFqdn;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Avi linux bridge subnet on openshift/k8s nodes.
   * @return aviBridgeSubnet
   */
  public IpAddrPrefix getAviBridgeSubnet() {
    return aviBridgeSubnet;
  }

  /**
   * This is the setter method to the attribute.
   * Avi linux bridge subnet on openshift/k8s nodes.
   * @param aviBridgeSubnet set the aviBridgeSubnet.
   */
  public void setAviBridgeSubnet(IpAddrPrefix aviBridgeSubnet) {
    this.aviBridgeSubnet = aviBridgeSubnet;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Uuid of the ucp ca tls cert and key.
   * It is a reference to an object of type sslkeyandcertificate.
   * @return caTlsKeyAndCertificateRef
   */
  public String getCaTlsKeyAndCertificateRef() {
    return caTlsKeyAndCertificateRef;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the ucp ca tls cert and key.
   * It is a reference to an object of type sslkeyandcertificate.
   * @param caTlsKeyAndCertificateRef set the caTlsKeyAndCertificateRef.
   */
  public void setCaTlsKeyAndCertificateRef(String  caTlsKeyAndCertificateRef) {
    this.caTlsKeyAndCertificateRef = caTlsKeyAndCertificateRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Uuid of the client tls cert and key instead of service account token.
   * One of client certificate or token is required.
   * It is a reference to an object of type sslkeyandcertificate.
   * @return clientTlsKeyAndCertificateRef
   */
  public String getClientTlsKeyAndCertificateRef() {
    return clientTlsKeyAndCertificateRef;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the client tls cert and key instead of service account token.
   * One of client certificate or token is required.
   * It is a reference to an object of type sslkeyandcertificate.
   * @param clientTlsKeyAndCertificateRef set the clientTlsKeyAndCertificateRef.
   */
  public void setClientTlsKeyAndCertificateRef(String  clientTlsKeyAndCertificateRef) {
    this.clientTlsKeyAndCertificateRef = clientTlsKeyAndCertificateRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Openshift/k8s cluster id used to uniquely map same named namespaces as tenants in avi.
   * In order to use more than one openshift/k8s cloud on this controller, cluster_tag has to be unique across these clouds.
   * Changing cluster_tag is disruptive as all virtual services in the cloud will be recreated.
   * Field introduced in 17.2.5.
   * @return clusterTag
   */
  public String getClusterTag() {
    return clusterTag;
  }

  /**
   * This is the setter method to the attribute.
   * Openshift/k8s cluster id used to uniquely map same named namespaces as tenants in avi.
   * In order to use more than one openshift/k8s cloud on this controller, cluster_tag has to be unique across these clouds.
   * Changing cluster_tag is disruptive as all virtual services in the cloud will be recreated.
   * Field introduced in 17.2.5.
   * @param clusterTag set the clusterTag.
   */
  public void setClusterTag(String  clusterTag) {
    this.clusterTag = clusterTag;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Perform container port matching to create a http virtualservice instead of a tcp/udp virtualservice.
   * By default, ports 80, 8080, 443, 8443 are considered http.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return containerPortMatchHttpService
   */
  public Boolean getContainerPortMatchHttpService() {
    return containerPortMatchHttpService;
  }

  /**
   * This is the setter method to the attribute.
   * Perform container port matching to create a http virtualservice instead of a tcp/udp virtualservice.
   * By default, ports 80, 8080, 443, 8443 are considered http.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param containerPortMatchHttpService set the containerPortMatchHttpService.
   */
  public void setContainerPortMatchHttpService(Boolean  containerPortMatchHttpService) {
    this.containerPortMatchHttpService = containerPortMatchHttpService;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Directory to mount to check for core dumps on service engines.
   * This will be mapped read only to /var/crash on any new service engines.
   * This is a disruptive change.
   * Default value when not specified in API or module is interpreted by Avi Controller as /var/lib/systemd/coredump.
   * @return coredumpDirectory
   */
  public String getCoredumpDirectory() {
    return coredumpDirectory;
  }

  /**
   * This is the setter method to the attribute.
   * Directory to mount to check for core dumps on service engines.
   * This will be mapped read only to /var/crash on any new service engines.
   * This is a disruptive change.
   * Default value when not specified in API or module is interpreted by Avi Controller as /var/lib/systemd/coredump.
   * @param coredumpDirectory set the coredumpDirectory.
   */
  public void setCoredumpDirectory(String  coredumpDirectory) {
    this.coredumpDirectory = coredumpDirectory;
  }

  /**
   * This is the getter method this will return the attribute value.
   * If there is no explicit east_west_placement field in virtualservice configuration, treat service as a east-west service; default services such a
   * openshift api server do not have virtualservice configuration.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return defaultServiceAsEastWestService
   */
  public Boolean getDefaultServiceAsEastWestService() {
    return defaultServiceAsEastWestService;
  }

  /**
   * This is the setter method to the attribute.
   * If there is no explicit east_west_placement field in virtualservice configuration, treat service as a east-west service; default services such a
   * openshift api server do not have virtualservice configuration.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param defaultServiceAsEastWestService set the defaultServiceAsEastWestService.
   */
  public void setDefaultServiceAsEastWestService(Boolean  defaultServiceAsEastWestService) {
    this.defaultServiceAsEastWestService = defaultServiceAsEastWestService;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Deprecated.
   * Field deprecated in 17.1.9.
   * Field introduced in 17.1.1.
   * @return defaultSharedVirtualservice
   */
  public OshiftSharedVirtualService getDefaultSharedVirtualservice() {
    return defaultSharedVirtualservice;
  }

  /**
   * This is the setter method to the attribute.
   * Deprecated.
   * Field deprecated in 17.1.9.
   * Field introduced in 17.1.1.
   * @param defaultSharedVirtualservice set the defaultSharedVirtualservice.
   */
  public void setDefaultSharedVirtualservice(OshiftSharedVirtualService defaultSharedVirtualservice) {
    this.defaultSharedVirtualservice = defaultSharedVirtualservice;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Disable auto service sync for back end services.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return disableAutoBackendServiceSync
   */
  public Boolean getDisableAutoBackendServiceSync() {
    return disableAutoBackendServiceSync;
  }

  /**
   * This is the setter method to the attribute.
   * Disable auto service sync for back end services.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param disableAutoBackendServiceSync set the disableAutoBackendServiceSync.
   */
  public void setDisableAutoBackendServiceSync(Boolean  disableAutoBackendServiceSync) {
    this.disableAutoBackendServiceSync = disableAutoBackendServiceSync;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Disable auto service sync for front end services.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return disableAutoFrontendServiceSync
   */
  public Boolean getDisableAutoFrontendServiceSync() {
    return disableAutoFrontendServiceSync;
  }

  /**
   * This is the setter method to the attribute.
   * Disable auto service sync for front end services.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param disableAutoFrontendServiceSync set the disableAutoFrontendServiceSync.
   */
  public void setDisableAutoFrontendServiceSync(Boolean  disableAutoFrontendServiceSync) {
    this.disableAutoFrontendServiceSync = disableAutoFrontendServiceSync;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Disable auto sync for gslb services.
   * Field introduced in 17.1.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return disableAutoGsSync
   */
  public Boolean getDisableAutoGsSync() {
    return disableAutoGsSync;
  }

  /**
   * This is the setter method to the attribute.
   * Disable auto sync for gslb services.
   * Field introduced in 17.1.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param disableAutoGsSync set the disableAutoGsSync.
   */
  public void setDisableAutoGsSync(Boolean  disableAutoGsSync) {
    this.disableAutoGsSync = disableAutoGsSync;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Disable se creation.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return disableAutoSeCreation
   */
  public Boolean getDisableAutoSeCreation() {
    return disableAutoSeCreation;
  }

  /**
   * This is the setter method to the attribute.
   * Disable se creation.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param disableAutoSeCreation set the disableAutoSeCreation.
   */
  public void setDisableAutoSeCreation(Boolean  disableAutoSeCreation) {
    this.disableAutoSeCreation = disableAutoSeCreation;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Host docker server unix socket endpoint.
   * Field introduced in 17.2.14, 18.1.5, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as /var/run/docker.sock.
   * @return dockerEndpoint
   */
  public String getDockerEndpoint() {
    return dockerEndpoint;
  }

  /**
   * This is the setter method to the attribute.
   * Host docker server unix socket endpoint.
   * Field introduced in 17.2.14, 18.1.5, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as /var/run/docker.sock.
   * @param dockerEndpoint set the dockerEndpoint.
   */
  public void setDockerEndpoint(String  dockerEndpoint) {
    this.dockerEndpoint = dockerEndpoint;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Docker registry for serviceengine image.
   * @return dockerRegistrySe
   */
  public DockerRegistry getDockerRegistrySe() {
    return dockerRegistrySe;
  }

  /**
   * This is the setter method to the attribute.
   * Docker registry for serviceengine image.
   * @param dockerRegistrySe set the dockerRegistrySe.
   */
  public void setDockerRegistrySe(DockerRegistry dockerRegistrySe) {
    this.dockerRegistrySe = dockerRegistrySe;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Match against this prefix when placing east-west vss on ses .
   * @return eastWestPlacementSubnet
   */
  public IpAddrPrefix getEastWestPlacementSubnet() {
    return eastWestPlacementSubnet;
  }

  /**
   * This is the setter method to the attribute.
   * Match against this prefix when placing east-west vss on ses .
   * @param eastWestPlacementSubnet set the eastWestPlacementSubnet.
   */
  public void setEastWestPlacementSubnet(IpAddrPrefix eastWestPlacementSubnet) {
    this.eastWestPlacementSubnet = eastWestPlacementSubnet;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable kubernetes event subscription.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return enableEventSubscription
   */
  public Boolean getEnableEventSubscription() {
    return enableEventSubscription;
  }

  /**
   * This is the setter method to the attribute.
   * Enable kubernetes event subscription.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param enableEventSubscription set the enableEventSubscription.
   */
  public void setEnableEventSubscription(Boolean  enableEventSubscription) {
    this.enableEventSubscription = enableEventSubscription;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Knob to turn on adding of http drop rules for host and path combinations in incoming request header, specified as part of ingress/route spec.
   * The default state is to enable this behavior.
   * Note  toggling this knob only affects any new routes/ingresses, existing routes/ingresses present in avi will continue to function as-is.
   * Field introduced in 18.2.6.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return enableRouteIngressHardening
   */
  public Boolean getEnableRouteIngressHardening() {
    return enableRouteIngressHardening;
  }

  /**
   * This is the setter method to the attribute.
   * Knob to turn on adding of http drop rules for host and path combinations in incoming request header, specified as part of ingress/route spec.
   * The default state is to enable this behavior.
   * Note  toggling this knob only affects any new routes/ingresses, existing routes/ingresses present in avi will continue to function as-is.
   * Field introduced in 18.2.6.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param enableRouteIngressHardening set the enableRouteIngressHardening.
   */
  public void setEnableRouteIngressHardening(Boolean  enableRouteIngressHardening) {
    this.enableRouteIngressHardening = enableRouteIngressHardening;
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
   * Optional fleet remote endpoint if fleet is used for se deployment.
   * Field deprecated in 17.2.13,18.1.5,18.2.1.
   * @return fleetEndpoint
   */
  public String getFleetEndpoint() {
    return fleetEndpoint;
  }

  /**
   * This is the setter method to the attribute.
   * Optional fleet remote endpoint if fleet is used for se deployment.
   * Field deprecated in 17.2.13,18.1.5,18.2.1.
   * @param fleetEndpoint set the fleetEndpoint.
   */
  public void setFleetEndpoint(String  fleetEndpoint) {
    this.fleetEndpoint = fleetEndpoint;
  }
  /**
   * This is the getter method this will return the attribute value.
   * List of container ports that create a http virtualservice instead of a tcp/udp virtualservice.
   * Defaults to 80, 8080, 443 and 8443.
   * @return httpContainerPorts
   */
  public List<Integer> getHttpContainerPorts() {
    return httpContainerPorts;
  }

  /**
   * This is the setter method. this will set the httpContainerPorts
   * List of container ports that create a http virtualservice instead of a tcp/udp virtualservice.
   * Defaults to 80, 8080, 443 and 8443.
   * @return httpContainerPorts
   */
  public void setHttpContainerPorts(List<Integer>  httpContainerPorts) {
    this.httpContainerPorts = httpContainerPorts;
  }

  /**
   * This is the setter method this will set the httpContainerPorts
   * List of container ports that create a http virtualservice instead of a tcp/udp virtualservice.
   * Defaults to 80, 8080, 443 and 8443.
   * @return httpContainerPorts
   */
  public OShiftK8SConfiguration addHttpContainerPortsItem(Integer httpContainerPortsItem) {
    if (this.httpContainerPorts == null) {
      this.httpContainerPorts = new ArrayList<Integer>();
    }
    this.httpContainerPorts.add(httpContainerPortsItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Do not sync applications only for ingress that have these exclude attributes configured.
   * Field introduced in 17.2.15, 18.1.5, 18.2.1.
   * @return ingExcludeAttributes
   */
  public List<IngAttribute> getIngExcludeAttributes() {
    return ingExcludeAttributes;
  }

  /**
   * This is the setter method. this will set the ingExcludeAttributes
   * Do not sync applications only for ingress that have these exclude attributes configured.
   * Field introduced in 17.2.15, 18.1.5, 18.2.1.
   * @return ingExcludeAttributes
   */
  public void setIngExcludeAttributes(List<IngAttribute>  ingExcludeAttributes) {
    this.ingExcludeAttributes = ingExcludeAttributes;
  }

  /**
   * This is the setter method this will set the ingExcludeAttributes
   * Do not sync applications only for ingress that have these exclude attributes configured.
   * Field introduced in 17.2.15, 18.1.5, 18.2.1.
   * @return ingExcludeAttributes
   */
  public OShiftK8SConfiguration addIngExcludeAttributesItem(IngAttribute ingExcludeAttributesItem) {
    if (this.ingExcludeAttributes == null) {
      this.ingExcludeAttributes = new ArrayList<IngAttribute>();
    }
    this.ingExcludeAttributes.add(ingExcludeAttributesItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Sync applications only for ingress objects that have these include attributes configured.
   * Default values are populated for this field if not provided.
   * The default value are  'attribute'  'kubernetes.io/ingress.class', 'value' 'avi'.
   * Field introduced in 17.2.15, 18.1.5, 18.2.1.
   * @return ingIncludeAttributes
   */
  public List<IngAttribute> getIngIncludeAttributes() {
    return ingIncludeAttributes;
  }

  /**
   * This is the setter method. this will set the ingIncludeAttributes
   * Sync applications only for ingress objects that have these include attributes configured.
   * Default values are populated for this field if not provided.
   * The default value are  'attribute'  'kubernetes.io/ingress.class', 'value' 'avi'.
   * Field introduced in 17.2.15, 18.1.5, 18.2.1.
   * @return ingIncludeAttributes
   */
  public void setIngIncludeAttributes(List<IngAttribute>  ingIncludeAttributes) {
    this.ingIncludeAttributes = ingIncludeAttributes;
  }

  /**
   * This is the setter method this will set the ingIncludeAttributes
   * Sync applications only for ingress objects that have these include attributes configured.
   * Default values are populated for this field if not provided.
   * The default value are  'attribute'  'kubernetes.io/ingress.class', 'value' 'avi'.
   * Field introduced in 17.2.15, 18.1.5, 18.2.1.
   * @return ingIncludeAttributes
   */
  public OShiftK8SConfiguration addIngIncludeAttributesItem(IngAttribute ingIncludeAttributesItem) {
    if (this.ingIncludeAttributes == null) {
      this.ingIncludeAttributes = new ArrayList<IngAttribute>();
    }
    this.ingIncludeAttributes.add(ingIncludeAttributesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Perform layer4 (tcp/udp) health monitoring even for layer7 (http) pools.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return l4HealthMonitoring
   */
  public Boolean getL4HealthMonitoring() {
    return l4HealthMonitoring;
  }

  /**
   * This is the setter method to the attribute.
   * Perform layer4 (tcp/udp) health monitoring even for layer7 (http) pools.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param l4HealthMonitoring set the l4HealthMonitoring.
   */
  public void setL4HealthMonitoring(Boolean  l4HealthMonitoring) {
    this.l4HealthMonitoring = l4HealthMonitoring;
  }
  /**
   * This is the getter method this will return the attribute value.
   * List of openshift/kubernetes master nodes; in case of a load balanced openshift/k8s cluster, use virtual ip of the cluster.
   * Each node is of the form node 8443 or http //node 8080.
   * If scheme is not provided, https is assumed.
   * @return masterNodes
   */
  public List<String> getMasterNodes() {
    return masterNodes;
  }

  /**
   * This is the setter method. this will set the masterNodes
   * List of openshift/kubernetes master nodes; in case of a load balanced openshift/k8s cluster, use virtual ip of the cluster.
   * Each node is of the form node 8443 or http //node 8080.
   * If scheme is not provided, https is assumed.
   * @return masterNodes
   */
  public void setMasterNodes(List<String>  masterNodes) {
    this.masterNodes = masterNodes;
  }

  /**
   * This is the setter method this will set the masterNodes
   * List of openshift/kubernetes master nodes; in case of a load balanced openshift/k8s cluster, use virtual ip of the cluster.
   * Each node is of the form node 8443 or http //node 8080.
   * If scheme is not provided, https is assumed.
   * @return masterNodes
   */
  public OShiftK8SConfiguration addMasterNodesItem(String masterNodesItem) {
    if (this.masterNodes == null) {
      this.masterNodes = new ArrayList<String>();
    }
    this.masterNodes.add(masterNodesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Openshift/k8s node label to be used as openshift/k8s node's availability zone in a dual availability zone deployment.
   * Serviceengines belonging to the availability zone will be rebooted during a manual dr failover.
   * @return nodeAvailabilityZoneLabel
   */
  public String getNodeAvailabilityZoneLabel() {
    return nodeAvailabilityZoneLabel;
  }

  /**
   * This is the setter method to the attribute.
   * Openshift/k8s node label to be used as openshift/k8s node's availability zone in a dual availability zone deployment.
   * Serviceengines belonging to the availability zone will be rebooted during a manual dr failover.
   * @param nodeAvailabilityZoneLabel set the nodeAvailabilityZoneLabel.
   */
  public void setNodeAvailabilityZoneLabel(String  nodeAvailabilityZoneLabel) {
    this.nodeAvailabilityZoneLabel = nodeAvailabilityZoneLabel;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Syncing of applications is disabled only for namespaces/projects that have these exclude attributes configured.
   * If there are apps synced already for these namespaces, they will be removed from avi.
   * Field introduced in 17.1.9,17.2.3.
   * @return nsExcludeAttributes
   */
  public List<MesosAttribute> getNsExcludeAttributes() {
    return nsExcludeAttributes;
  }

  /**
   * This is the setter method. this will set the nsExcludeAttributes
   * Syncing of applications is disabled only for namespaces/projects that have these exclude attributes configured.
   * If there are apps synced already for these namespaces, they will be removed from avi.
   * Field introduced in 17.1.9,17.2.3.
   * @return nsExcludeAttributes
   */
  public void setNsExcludeAttributes(List<MesosAttribute>  nsExcludeAttributes) {
    this.nsExcludeAttributes = nsExcludeAttributes;
  }

  /**
   * This is the setter method this will set the nsExcludeAttributes
   * Syncing of applications is disabled only for namespaces/projects that have these exclude attributes configured.
   * If there are apps synced already for these namespaces, they will be removed from avi.
   * Field introduced in 17.1.9,17.2.3.
   * @return nsExcludeAttributes
   */
  public OShiftK8SConfiguration addNsExcludeAttributesItem(MesosAttribute nsExcludeAttributesItem) {
    if (this.nsExcludeAttributes == null) {
      this.nsExcludeAttributes = new ArrayList<MesosAttribute>();
    }
    this.nsExcludeAttributes.add(nsExcludeAttributesItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Sync applications only for namespaces/projects that have these include attributes configured.
   * Field introduced in 17.1.9,17.2.3.
   * @return nsIncludeAttributes
   */
  public List<MesosAttribute> getNsIncludeAttributes() {
    return nsIncludeAttributes;
  }

  /**
   * This is the setter method. this will set the nsIncludeAttributes
   * Sync applications only for namespaces/projects that have these include attributes configured.
   * Field introduced in 17.1.9,17.2.3.
   * @return nsIncludeAttributes
   */
  public void setNsIncludeAttributes(List<MesosAttribute>  nsIncludeAttributes) {
    this.nsIncludeAttributes = nsIncludeAttributes;
  }

  /**
   * This is the setter method this will set the nsIncludeAttributes
   * Sync applications only for namespaces/projects that have these include attributes configured.
   * Field introduced in 17.1.9,17.2.3.
   * @return nsIncludeAttributes
   */
  public OShiftK8SConfiguration addNsIncludeAttributesItem(MesosAttribute nsIncludeAttributesItem) {
    if (this.nsIncludeAttributes == null) {
      this.nsIncludeAttributes = new ArrayList<MesosAttribute>();
    }
    this.nsIncludeAttributes.add(nsIncludeAttributesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Nuage overlay sdn controller information.
   * Field deprecated in 17.2.13,18.1.5,18.2.1.
   * @return nuageController
   */
  public NuageSDNController getNuageController() {
    return nuageController;
  }

  /**
   * This is the setter method to the attribute.
   * Nuage overlay sdn controller information.
   * Field deprecated in 17.2.13,18.1.5,18.2.1.
   * @param nuageController set the nuageController.
   */
  public void setNuageController(NuageSDNController nuageController) {
    this.nuageController = nuageController;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enables sharding of routes and ingresses to this number (if non zero) of virtual services in the admin tenant per segroup.
   * Sharding is done by hashing on the namespace of the ingress/route object.
   * This knob is valid only if shared_virtualservice_namespace flag is set.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return numShards
   */
  public Integer getNumShards() {
    return numShards;
  }

  /**
   * This is the setter method to the attribute.
   * Enables sharding of routes and ingresses to this number (if non zero) of virtual services in the admin tenant per segroup.
   * Sharding is done by hashing on the namespace of the ingress/route object.
   * This knob is valid only if shared_virtualservice_namespace flag is set.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param numShards set the numShards.
   */
  public void setNumShards(Integer  numShards) {
    this.numShards = numShards;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Override service ports with well known ports (80/443) for http/https route/ingress virtualservices.
   * Field introduced in 17.2.12,18.1.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return overrideServicePorts
   */
  public Boolean getOverrideServicePorts() {
    return overrideServicePorts;
  }

  /**
   * This is the setter method to the attribute.
   * Override service ports with well known ports (80/443) for http/https route/ingress virtualservices.
   * Field introduced in 17.2.12,18.1.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param overrideServicePorts set the overrideServicePorts.
   */
  public void setOverrideServicePorts(Boolean  overrideServicePorts) {
    this.overrideServicePorts = overrideServicePorts;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Persistent volume claim name to be used for persistent storage for avi service engines.
   * This could be used in scenarios where host based volumes are ephemeral.
   * Refer https //kubernetes.io/docs/concepts/storage/persistent-volumes/#persistentvolumeclaims for more details on the usage of this field.
   * Field introduced in 18.2.6.
   * @return persistentVolumeClaim
   */
  public String getPersistentVolumeClaim() {
    return persistentVolumeClaim;
  }

  /**
   * This is the setter method to the attribute.
   * Persistent volume claim name to be used for persistent storage for avi service engines.
   * This could be used in scenarios where host based volumes are ephemeral.
   * Refer https //kubernetes.io/docs/concepts/storage/persistent-volumes/#persistentvolumeclaims for more details on the usage of this field.
   * Field introduced in 18.2.6.
   * @param persistentVolumeClaim set the persistentVolumeClaim.
   */
  public void setPersistentVolumeClaim(String  persistentVolumeClaim) {
    this.persistentVolumeClaim = persistentVolumeClaim;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Routes support adding routes to a particular namespace routing table in openshift/k8s cluster.
   * Each route is a combination of subnet and nexthop ip address or nexthop interface name, and a enum type is used to distinguish an entry in the
   * host (default behaviour) or in the container/pod or in other namespace.
   * This knob should be enabled in the following cases  1.
   * Forwarding the network packets to the same network interface from where it came from in the openshift/k8s node.
   * 2.
   * Openshift/k8s node connected to the internet via multiple network interfaces on different networks/isps.3.
   * Handling north-south traffic originating from with in the node when the default gateway for outgoing traffic of vs is configured.4.
   * Handling the container/pod traffic by adding the routes in the container/pod.
   * Field introduced in 18.2.6.
   * @return routes
   */
  public List<RouteInfo> getRoutes() {
    return routes;
  }

  /**
   * This is the setter method. this will set the routes
   * Routes support adding routes to a particular namespace routing table in openshift/k8s cluster.
   * Each route is a combination of subnet and nexthop ip address or nexthop interface name, and a enum type is used to distinguish an entry in the
   * host (default behaviour) or in the container/pod or in other namespace.
   * This knob should be enabled in the following cases  1.
   * Forwarding the network packets to the same network interface from where it came from in the openshift/k8s node.
   * 2.
   * Openshift/k8s node connected to the internet via multiple network interfaces on different networks/isps.3.
   * Handling north-south traffic originating from with in the node when the default gateway for outgoing traffic of vs is configured.4.
   * Handling the container/pod traffic by adding the routes in the container/pod.
   * Field introduced in 18.2.6.
   * @return routes
   */
  public void setRoutes(List<RouteInfo>  routes) {
    this.routes = routes;
  }

  /**
   * This is the setter method this will set the routes
   * Routes support adding routes to a particular namespace routing table in openshift/k8s cluster.
   * Each route is a combination of subnet and nexthop ip address or nexthop interface name, and a enum type is used to distinguish an entry in the
   * host (default behaviour) or in the container/pod or in other namespace.
   * This knob should be enabled in the following cases  1.
   * Forwarding the network packets to the same network interface from where it came from in the openshift/k8s node.
   * 2.
   * Openshift/k8s node connected to the internet via multiple network interfaces on different networks/isps.3.
   * Handling north-south traffic originating from with in the node when the default gateway for outgoing traffic of vs is configured.4.
   * Handling the container/pod traffic by adding the routes in the container/pod.
   * Field introduced in 18.2.6.
   * @return routes
   */
  public OShiftK8SConfiguration addRoutesItem(RouteInfo routesItem) {
    if (this.routes == null) {
      this.routes = new ArrayList<RouteInfo>();
    }
    this.routes.add(routesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Deprecated.
   * Field deprecated in 17.1.9.
   * Field introduced in 17.1.1.
   * @return routesShareVirtualservice
   */
  public Boolean getRoutesShareVirtualservice() {
    return routesShareVirtualservice;
  }

  /**
   * This is the setter method to the attribute.
   * Deprecated.
   * Field deprecated in 17.1.9.
   * Field introduced in 17.1.1.
   * @param routesShareVirtualservice set the routesShareVirtualservice.
   */
  public void setRoutesShareVirtualservice(Boolean  routesShareVirtualservice) {
    this.routesShareVirtualservice = routesShareVirtualservice;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Cluster uses overlay based sdn.
   * Enable this flag if cluster uses a overlay based sdn for openshift, flannel, weave, nuage.
   * Disable for routed mode.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return sdnOverlay
   */
  public Boolean getSdnOverlay() {
    return sdnOverlay;
  }

  /**
   * This is the setter method to the attribute.
   * Cluster uses overlay based sdn.
   * Enable this flag if cluster uses a overlay based sdn for openshift, flannel, weave, nuage.
   * Disable for routed mode.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param sdnOverlay set the sdnOverlay.
   */
  public void setSdnOverlay(Boolean  sdnOverlay) {
    this.sdnOverlay = sdnOverlay;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Use ssh/pod for se deployment.
   * Enum options - SE_CREATE_FLEET, SE_CREATE_SSH, SE_CREATE_POD.
   * Default value when not specified in API or module is interpreted by Avi Controller as SE_CREATE_POD.
   * @return seDeploymentMethod
   */
  public String getSeDeploymentMethod() {
    return seDeploymentMethod;
  }

  /**
   * This is the setter method to the attribute.
   * Use ssh/pod for se deployment.
   * Enum options - SE_CREATE_FLEET, SE_CREATE_SSH, SE_CREATE_POD.
   * Default value when not specified in API or module is interpreted by Avi Controller as SE_CREATE_POD.
   * @param seDeploymentMethod set the seDeploymentMethod.
   */
  public void setSeDeploymentMethod(String  seDeploymentMethod) {
    this.seDeploymentMethod = seDeploymentMethod;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Exclude hosts with attributes for se creation.
   * @return seExcludeAttributes
   */
  public List<MesosAttribute> getSeExcludeAttributes() {
    return seExcludeAttributes;
  }

  /**
   * This is the setter method. this will set the seExcludeAttributes
   * Exclude hosts with attributes for se creation.
   * @return seExcludeAttributes
   */
  public void setSeExcludeAttributes(List<MesosAttribute>  seExcludeAttributes) {
    this.seExcludeAttributes = seExcludeAttributes;
  }

  /**
   * This is the setter method this will set the seExcludeAttributes
   * Exclude hosts with attributes for se creation.
   * @return seExcludeAttributes
   */
  public OShiftK8SConfiguration addSeExcludeAttributesItem(MesosAttribute seExcludeAttributesItem) {
    if (this.seExcludeAttributes == null) {
      this.seExcludeAttributes = new ArrayList<MesosAttribute>();
    }
    this.seExcludeAttributes.add(seExcludeAttributesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Openshift/k8s secret name to be used for private docker repos when deploying se as a pod.
   * Reference link  https //kubernetes.io/docs/tasks/configure-pod-container/pull-image-private-registry/.
   * Field introduced in 17.2.13,18.1.3,18.2.1.
   * @return seImagePullSecret
   */
  public String getSeImagePullSecret() {
    return seImagePullSecret;
  }

  /**
   * This is the setter method to the attribute.
   * Openshift/k8s secret name to be used for private docker repos when deploying se as a pod.
   * Reference link  https //kubernetes.io/docs/tasks/configure-pod-container/pull-image-private-registry/.
   * Field introduced in 17.2.13,18.1.3,18.2.1.
   * @param seImagePullSecret set the seImagePullSecret.
   */
  public void setSeImagePullSecret(String  seImagePullSecret) {
    this.seImagePullSecret = seImagePullSecret;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Create ses just on hosts with include attributes.
   * @return seIncludeAttributes
   */
  public List<MesosAttribute> getSeIncludeAttributes() {
    return seIncludeAttributes;
  }

  /**
   * This is the setter method. this will set the seIncludeAttributes
   * Create ses just on hosts with include attributes.
   * @return seIncludeAttributes
   */
  public void setSeIncludeAttributes(List<MesosAttribute>  seIncludeAttributes) {
    this.seIncludeAttributes = seIncludeAttributes;
  }

  /**
   * This is the setter method this will set the seIncludeAttributes
   * Create ses just on hosts with include attributes.
   * @return seIncludeAttributes
   */
  public OShiftK8SConfiguration addSeIncludeAttributesItem(MesosAttribute seIncludeAttributesItem) {
    if (this.seIncludeAttributes == null) {
      this.seIncludeAttributes = new ArrayList<MesosAttribute>();
    }
    this.seIncludeAttributes.add(seIncludeAttributesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Kubernetes namespace to be used for deploying avi service engines.
   * This namespace is used to create daemonsets, service accounts, etc.
   * For avi only use.
   * Setting this value is a disruptive operation and assumes the namespace exists in kubernetes.
   * 'default' namespace is picked if this field is unset.
   * Field introduced in 18.2.6.
   * Default value when not specified in API or module is interpreted by Avi Controller as default.
   * @return seNamespace
   */
  public String getSeNamespace() {
    return seNamespace;
  }

  /**
   * This is the setter method to the attribute.
   * Kubernetes namespace to be used for deploying avi service engines.
   * This namespace is used to create daemonsets, service accounts, etc.
   * For avi only use.
   * Setting this value is a disruptive operation and assumes the namespace exists in kubernetes.
   * 'default' namespace is picked if this field is unset.
   * Field introduced in 18.2.6.
   * Default value when not specified in API or module is interpreted by Avi Controller as default.
   * @param seNamespace set the seNamespace.
   */
  public void setSeNamespace(String  seNamespace) {
    this.seNamespace = seNamespace;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Match se pod tolerations against taints of openshift/k8s nodes https //kubernetes.io/docs/concepts/configuration/taint-and-toleration/.
   * Field introduced in 17.2.14, 18.1.5, 18.2.1.
   * @return sePodTolerations
   */
  public List<PodToleration> getSePodTolerations() {
    return sePodTolerations;
  }

  /**
   * This is the setter method. this will set the sePodTolerations
   * Match se pod tolerations against taints of openshift/k8s nodes https //kubernetes.io/docs/concepts/configuration/taint-and-toleration/.
   * Field introduced in 17.2.14, 18.1.5, 18.2.1.
   * @return sePodTolerations
   */
  public void setSePodTolerations(List<PodToleration>  sePodTolerations) {
    this.sePodTolerations = sePodTolerations;
  }

  /**
   * This is the setter method this will set the sePodTolerations
   * Match se pod tolerations against taints of openshift/k8s nodes https //kubernetes.io/docs/concepts/configuration/taint-and-toleration/.
   * Field introduced in 17.2.14, 18.1.5, 18.2.1.
   * @return sePodTolerations
   */
  public OShiftK8SConfiguration addSePodTolerationsItem(PodToleration sePodTolerationsItem) {
    if (this.sePodTolerations == null) {
      this.sePodTolerations = new ArrayList<PodToleration>();
    }
    this.sePodTolerations.add(sePodTolerationsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Priority class for avi ses when running as pods.
   * User is expected to have the priority class (with this name) created in kubernetes, beforehand.
   * If the priority class doesn't exist while assigning this field, the se pods may not start.
   * If empty no priority class will be used for deploying se pods (default behaviour).
   * Field introduced in 18.2.6.
   * @return sePriorityClass
   */
  public String getSePriorityClass() {
    return sePriorityClass;
  }

  /**
   * This is the setter method to the attribute.
   * Priority class for avi ses when running as pods.
   * User is expected to have the priority class (with this name) created in kubernetes, beforehand.
   * If the priority class doesn't exist while assigning this field, the se pods may not start.
   * If empty no priority class will be used for deploying se pods (default behaviour).
   * Field introduced in 18.2.6.
   * @param sePriorityClass set the sePriorityClass.
   */
  public void setSePriorityClass(String  sePriorityClass) {
    this.sePriorityClass = sePriorityClass;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Restart serviceengines by batch on serviceenginegroup updates (cpu, memory..etc).
   * Field introduced in 17.2.15, 18.1.5, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.
   * @return seRestartBatchSize
   */
  public Integer getSeRestartBatchSize() {
    return seRestartBatchSize;
  }

  /**
   * This is the setter method to the attribute.
   * Restart serviceengines by batch on serviceenginegroup updates (cpu, memory..etc).
   * Field introduced in 17.2.15, 18.1.5, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.
   * @param seRestartBatchSize set the seRestartBatchSize.
   */
  public void setSeRestartBatchSize(Integer  seRestartBatchSize) {
    this.seRestartBatchSize = seRestartBatchSize;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Restart serviceengines forcely if virtualservices failed to migrate to another se.
   * Field introduced in 17.2.15, 18.1.5, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return seRestartForce
   */
  public Boolean getSeRestartForce() {
    return seRestartForce;
  }

  /**
   * This is the setter method to the attribute.
   * Restart serviceengines forcely if virtualservices failed to migrate to another se.
   * Field introduced in 17.2.15, 18.1.5, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param seRestartForce set the seRestartForce.
   */
  public void setSeRestartForce(Boolean  seRestartForce) {
    this.seRestartForce = seRestartForce;
  }

  /**
   * This is the getter method this will return the attribute value.
   * New se spawn rate per minute.
   * Field deprecated in 17.2.13,18.1.5,18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 25.
   * @return seSpawnRate
   */
  public Integer getSeSpawnRate() {
    return seSpawnRate;
  }

  /**
   * This is the setter method to the attribute.
   * New se spawn rate per minute.
   * Field deprecated in 17.2.13,18.1.5,18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 25.
   * @param seSpawnRate set the seSpawnRate.
   */
  public void setSeSpawnRate(Integer  seSpawnRate) {
    this.seSpawnRate = seSpawnRate;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Host volume to be used as a disk for avi se, this is a disruptive change.
   * Default value when not specified in API or module is interpreted by Avi Controller as /var/lib/avi.
   * @return seVolume
   */
  public String getSeVolume() {
    return seVolume;
  }

  /**
   * This is the setter method to the attribute.
   * Host volume to be used as a disk for avi se, this is a disruptive change.
   * Default value when not specified in API or module is interpreted by Avi Controller as /var/lib/avi.
   * @param seVolume set the seVolume.
   */
  public void setSeVolume(String  seVolume) {
    this.seVolume = seVolume;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Allow avi vantage to create securitycontextconstraints and serviceaccounts which allow egress pods to run in privileged mode in an openshift
   * environment.
   * Enabling this would exclude egress services from 'disable_auto_backend_service_sync' (if set) behaviour.
   * Note  access credentials must have cluster-admin role privileges.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return secureEgressMode
   */
  public Boolean getSecureEgressMode() {
    return secureEgressMode;
  }

  /**
   * This is the setter method to the attribute.
   * Allow avi vantage to create securitycontextconstraints and serviceaccounts which allow egress pods to run in privileged mode in an openshift
   * environment.
   * Enabling this would exclude egress services from 'disable_auto_backend_service_sync' (if set) behaviour.
   * Note  access credentials must have cluster-admin role privileges.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param secureEgressMode set the secureEgressMode.
   */
  public void setSecureEgressMode(Boolean  secureEgressMode) {
    this.secureEgressMode = secureEgressMode;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Authorization token for service account instead of client certificate.
   * One of client certificate or token is required.
   * @return serviceAccountToken
   */
  public String getServiceAccountToken() {
    return serviceAccountToken;
  }

  /**
   * This is the setter method to the attribute.
   * Authorization token for service account instead of client certificate.
   * One of client certificate or token is required.
   * @param serviceAccountToken set the serviceAccountToken.
   */
  public void setServiceAccountToken(String  serviceAccountToken) {
    this.serviceAccountToken = serviceAccountToken;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Perform service port matching to create a http virtualservice instead of a tcp/udp virtualservice.
   * Field deprecated in 17.2.11,18.1.2.
   * @return servicePortMatchHttpService
   */
  public Boolean getServicePortMatchHttpService() {
    return servicePortMatchHttpService;
  }

  /**
   * This is the setter method to the attribute.
   * Perform service port matching to create a http virtualservice instead of a tcp/udp virtualservice.
   * Field deprecated in 17.2.11,18.1.2.
   * @param servicePortMatchHttpService set the servicePortMatchHttpService.
   */
  public void setServicePortMatchHttpService(Boolean  servicePortMatchHttpService) {
    this.servicePortMatchHttpService = servicePortMatchHttpService;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Prefix to be used for shard vs name when num_shards knob is non zero.
   * Format for shard vs name will be <shard_prefix>-<idx>-cloudname-segroupname.
   * Field introduced in 18.2.5.
   * @return shardPrefix
   */
  public String getShardPrefix() {
    return shardPrefix;
  }

  /**
   * This is the setter method to the attribute.
   * Prefix to be used for shard vs name when num_shards knob is non zero.
   * Format for shard vs name will be <shard_prefix>-<idx>-cloudname-segroupname.
   * Field introduced in 18.2.5.
   * @param shardPrefix set the shardPrefix.
   */
  public void setShardPrefix(String  shardPrefix) {
    this.shardPrefix = shardPrefix;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Projects/namespaces use a shared virtualservice for http/https routes and ingress objects unless overriden by the avi_virtualservice
   * dedicated|shared annotation.
   * Field introduced in 17.1.9,17.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return sharedVirtualserviceNamespace
   */
  public Boolean getSharedVirtualserviceNamespace() {
    return sharedVirtualserviceNamespace;
  }

  /**
   * This is the setter method to the attribute.
   * Projects/namespaces use a shared virtualservice for http/https routes and ingress objects unless overriden by the avi_virtualservice
   * dedicated|shared annotation.
   * Field introduced in 17.1.9,17.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param sharedVirtualserviceNamespace set the sharedVirtualserviceNamespace.
   */
  public void setSharedVirtualserviceNamespace(Boolean  sharedVirtualserviceNamespace) {
    this.sharedVirtualserviceNamespace = sharedVirtualserviceNamespace;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Parameters for ssh se deployment.
   * Field deprecated in 17.1.1.
   * @return sshSeDeployment
   */
  public SSHSeDeployment getSshSeDeployment() {
    return sshSeDeployment;
  }

  /**
   * This is the setter method to the attribute.
   * Parameters for ssh se deployment.
   * Field deprecated in 17.1.1.
   * @param sshSeDeployment set the sshSeDeployment.
   */
  public void setSshSeDeployment(SSHSeDeployment sshSeDeployment) {
    this.sshSeDeployment = sshSeDeployment;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Cloud connector user uuid for ssh to hosts.
   * It is a reference to an object of type cloudconnectoruser.
   * Field introduced in 17.1.1.
   * @return sshUserRef
   */
  public String getSshUserRef() {
    return sshUserRef;
  }

  /**
   * This is the setter method to the attribute.
   * Cloud connector user uuid for ssh to hosts.
   * It is a reference to an object of type cloudconnectoruser.
   * Field introduced in 17.1.1.
   * @param sshUserRef set the sshUserRef.
   */
  public void setSshUserRef(String  sshUserRef) {
    this.sshUserRef = sshUserRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Allow the not_ready_addresses in the kubernetes endpoint object to be added as servers in the avi pool object.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return syncNotReadyAddresses
   */
  public Boolean getSyncNotReadyAddresses() {
    return syncNotReadyAddresses;
  }

  /**
   * This is the setter method to the attribute.
   * Allow the not_ready_addresses in the kubernetes endpoint object to be added as servers in the avi pool object.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param syncNotReadyAddresses set the syncNotReadyAddresses.
   */
  public void setSyncNotReadyAddresses(Boolean  syncNotReadyAddresses) {
    this.syncNotReadyAddresses = syncNotReadyAddresses;
  }

  /**
   * This is the getter method this will return the attribute value.
   * If true, use controller generated se docker image via fileservice, else use docker repository image as defined by docker_registry_se.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return useControllerImage
   */
  public Boolean getUseControllerImage() {
    return useControllerImage;
  }

  /**
   * This is the setter method to the attribute.
   * If true, use controller generated se docker image via fileservice, else use docker repository image as defined by docker_registry_se.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param useControllerImage set the useControllerImage.
   */
  public void setUseControllerImage(Boolean  useControllerImage) {
    this.useControllerImage = useControllerImage;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Use openshift/kubernetes resource definition and annotations as single-source-of-truth.
   * Any changes made in avi controller via ui or cli will be overridden by values provided in annotations.
   * Field introduced in 17.2.13, 18.1.4, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return useResourceDefinitionAsSsot
   */
  public Boolean getUseResourceDefinitionAsSsot() {
    return useResourceDefinitionAsSsot;
  }

  /**
   * This is the setter method to the attribute.
   * Use openshift/kubernetes resource definition and annotations as single-source-of-truth.
   * Any changes made in avi controller via ui or cli will be overridden by values provided in annotations.
   * Field introduced in 17.2.13, 18.1.4, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param useResourceDefinitionAsSsot set the useResourceDefinitionAsSsot.
   */
  public void setUseResourceDefinitionAsSsot(Boolean  useResourceDefinitionAsSsot) {
    this.useResourceDefinitionAsSsot = useResourceDefinitionAsSsot;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable virtualservice placement on service engines on nodes with scheduling disabled.
   * When false, service engines are disabled on nodes where scheduling is disabled.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return useSchedulingDisabledNodes
   */
  public Boolean getUseSchedulingDisabledNodes() {
    return useSchedulingDisabledNodes;
  }

  /**
   * This is the setter method to the attribute.
   * Enable virtualservice placement on service engines on nodes with scheduling disabled.
   * When false, service engines are disabled on nodes where scheduling is disabled.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param useSchedulingDisabledNodes set the useSchedulingDisabledNodes.
   */
  public void setUseSchedulingDisabledNodes(Boolean  useSchedulingDisabledNodes) {
    this.useSchedulingDisabledNodes = useSchedulingDisabledNodes;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Use cluster ip of service as vip for east-west services; this option requires that kube proxy is disabled on all nodes.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return useServiceClusterIpAsEwVip
   */
  public Boolean getUseServiceClusterIpAsEwVip() {
    return useServiceClusterIpAsEwVip;
  }

  /**
   * This is the setter method to the attribute.
   * Use cluster ip of service as vip for east-west services; this option requires that kube proxy is disabled on all nodes.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param useServiceClusterIpAsEwVip set the useServiceClusterIpAsEwVip.
   */
  public void setUseServiceClusterIpAsEwVip(Boolean  useServiceClusterIpAsEwVip) {
    this.useServiceClusterIpAsEwVip = useServiceClusterIpAsEwVip;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Virtualservice default gateway if multiple nics are present in the host.
   * Field introduced in 18.2.2.
   * @return vipDefaultGateway
   */
  public IpAddr getVipDefaultGateway() {
    return vipDefaultGateway;
  }

  /**
   * This is the setter method to the attribute.
   * Virtualservice default gateway if multiple nics are present in the host.
   * Field introduced in 18.2.2.
   * @param vipDefaultGateway set the vipDefaultGateway.
   */
  public void setVipDefaultGateway(IpAddr vipDefaultGateway) {
    this.vipDefaultGateway = vipDefaultGateway;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  OShiftK8SConfiguration objOShiftK8SConfiguration = (OShiftK8SConfiguration) o;
  return   Objects.equals(this.syncNotReadyAddresses, objOShiftK8SConfiguration.syncNotReadyAddresses)&&
  Objects.equals(this.eastWestPlacementSubnet, objOShiftK8SConfiguration.eastWestPlacementSubnet)&&
  Objects.equals(this.enableEventSubscription, objOShiftK8SConfiguration.enableEventSubscription)&&
  Objects.equals(this.nuageController, objOShiftK8SConfiguration.nuageController)&&
  Objects.equals(this.seRestartForce, objOShiftK8SConfiguration.seRestartForce)&&
  Objects.equals(this.persistentVolumeClaim, objOShiftK8SConfiguration.persistentVolumeClaim)&&
  Objects.equals(this.sePriorityClass, objOShiftK8SConfiguration.sePriorityClass)&&
  Objects.equals(this.feproxyVipsEnableProxyArp, objOShiftK8SConfiguration.feproxyVipsEnableProxyArp)&&
  Objects.equals(this.useResourceDefinitionAsSsot, objOShiftK8SConfiguration.useResourceDefinitionAsSsot)&&
  Objects.equals(this.disableAutoBackendServiceSync, objOShiftK8SConfiguration.disableAutoBackendServiceSync)&&
  Objects.equals(this.nsIncludeAttributes, objOShiftK8SConfiguration.nsIncludeAttributes)&&
  Objects.equals(this.containerPortMatchHttpService, objOShiftK8SConfiguration.containerPortMatchHttpService)&&
  Objects.equals(this.fleetEndpoint, objOShiftK8SConfiguration.fleetEndpoint)&&
  Objects.equals(this.dockerEndpoint, objOShiftK8SConfiguration.dockerEndpoint)&&
  Objects.equals(this.defaultSharedVirtualservice, objOShiftK8SConfiguration.defaultSharedVirtualservice)&&
  Objects.equals(this.routesShareVirtualservice, objOShiftK8SConfiguration.routesShareVirtualservice)&&
  Objects.equals(this.sshUserRef, objOShiftK8SConfiguration.sshUserRef)&&
  Objects.equals(this.seVolume, objOShiftK8SConfiguration.seVolume)&&
  Objects.equals(this.ingExcludeAttributes, objOShiftK8SConfiguration.ingExcludeAttributes)&&
  Objects.equals(this.httpContainerPorts, objOShiftK8SConfiguration.httpContainerPorts)&&
  Objects.equals(this.seExcludeAttributes, objOShiftK8SConfiguration.seExcludeAttributes)&&
  Objects.equals(this.sePodTolerations, objOShiftK8SConfiguration.sePodTolerations)&&
  Objects.equals(this.enableRouteIngressHardening, objOShiftK8SConfiguration.enableRouteIngressHardening)&&
  Objects.equals(this.servicePortMatchHttpService, objOShiftK8SConfiguration.servicePortMatchHttpService)&&
  Objects.equals(this.l4HealthMonitoring, objOShiftK8SConfiguration.l4HealthMonitoring)&&
  Objects.equals(this.autoAssignFqdn, objOShiftK8SConfiguration.autoAssignFqdn)&&
  Objects.equals(this.seDeploymentMethod, objOShiftK8SConfiguration.seDeploymentMethod)&&
  Objects.equals(this.sdnOverlay, objOShiftK8SConfiguration.sdnOverlay)&&
  Objects.equals(this.useServiceClusterIpAsEwVip, objOShiftK8SConfiguration.useServiceClusterIpAsEwVip)&&
  Objects.equals(this.clusterTag, objOShiftK8SConfiguration.clusterTag)&&
  Objects.equals(this.numShards, objOShiftK8SConfiguration.numShards)&&
  Objects.equals(this.dockerRegistrySe, objOShiftK8SConfiguration.dockerRegistrySe)&&
  Objects.equals(this.ingIncludeAttributes, objOShiftK8SConfiguration.ingIncludeAttributes)&&
  Objects.equals(this.vipDefaultGateway, objOShiftK8SConfiguration.vipDefaultGateway)&&
  Objects.equals(this.seNamespace, objOShiftK8SConfiguration.seNamespace)&&
  Objects.equals(this.sshSeDeployment, objOShiftK8SConfiguration.sshSeDeployment)&&
  Objects.equals(this.useSchedulingDisabledNodes, objOShiftK8SConfiguration.useSchedulingDisabledNodes)&&
  Objects.equals(this.serviceAccountToken, objOShiftK8SConfiguration.serviceAccountToken)&&
  Objects.equals(this.useControllerImage, objOShiftK8SConfiguration.useControllerImage)&&
  Objects.equals(this.disableAutoGsSync, objOShiftK8SConfiguration.disableAutoGsSync)&&
  Objects.equals(this.coredumpDirectory, objOShiftK8SConfiguration.coredumpDirectory)&&
  Objects.equals(this.disableAutoFrontendServiceSync, objOShiftK8SConfiguration.disableAutoFrontendServiceSync)&&
  Objects.equals(this.nodeAvailabilityZoneLabel, objOShiftK8SConfiguration.nodeAvailabilityZoneLabel)&&
  Objects.equals(this.seIncludeAttributes, objOShiftK8SConfiguration.seIncludeAttributes)&&
  Objects.equals(this.masterNodes, objOShiftK8SConfiguration.masterNodes)&&
  Objects.equals(this.appSyncFrequency, objOShiftK8SConfiguration.appSyncFrequency)&&
  Objects.equals(this.secureEgressMode, objOShiftK8SConfiguration.secureEgressMode)&&
  Objects.equals(this.defaultServiceAsEastWestService, objOShiftK8SConfiguration.defaultServiceAsEastWestService)&&
  Objects.equals(this.overrideServicePorts, objOShiftK8SConfiguration.overrideServicePorts)&&
  Objects.equals(this.seRestartBatchSize, objOShiftK8SConfiguration.seRestartBatchSize)&&
  Objects.equals(this.aviBridgeSubnet, objOShiftK8SConfiguration.aviBridgeSubnet)&&
  Objects.equals(this.clientTlsKeyAndCertificateRef, objOShiftK8SConfiguration.clientTlsKeyAndCertificateRef)&&
  Objects.equals(this.sharedVirtualserviceNamespace, objOShiftK8SConfiguration.sharedVirtualserviceNamespace)&&
  Objects.equals(this.seSpawnRate, objOShiftK8SConfiguration.seSpawnRate)&&
  Objects.equals(this.nsExcludeAttributes, objOShiftK8SConfiguration.nsExcludeAttributes)&&
  Objects.equals(this.routes, objOShiftK8SConfiguration.routes)&&
  Objects.equals(this.seImagePullSecret, objOShiftK8SConfiguration.seImagePullSecret)&&
  Objects.equals(this.caTlsKeyAndCertificateRef, objOShiftK8SConfiguration.caTlsKeyAndCertificateRef)&&
  Objects.equals(this.shardPrefix, objOShiftK8SConfiguration.shardPrefix)&&
  Objects.equals(this.disableAutoSeCreation, objOShiftK8SConfiguration.disableAutoSeCreation);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class OShiftK8SConfiguration {\n");
      sb.append("    appSyncFrequency: ").append(toIndentedString(appSyncFrequency)).append("\n");
        sb.append("    autoAssignFqdn: ").append(toIndentedString(autoAssignFqdn)).append("\n");
        sb.append("    aviBridgeSubnet: ").append(toIndentedString(aviBridgeSubnet)).append("\n");
        sb.append("    caTlsKeyAndCertificateRef: ").append(toIndentedString(caTlsKeyAndCertificateRef)).append("\n");
        sb.append("    clientTlsKeyAndCertificateRef: ").append(toIndentedString(clientTlsKeyAndCertificateRef)).append("\n");
        sb.append("    clusterTag: ").append(toIndentedString(clusterTag)).append("\n");
        sb.append("    containerPortMatchHttpService: ").append(toIndentedString(containerPortMatchHttpService)).append("\n");
        sb.append("    coredumpDirectory: ").append(toIndentedString(coredumpDirectory)).append("\n");
        sb.append("    defaultServiceAsEastWestService: ").append(toIndentedString(defaultServiceAsEastWestService)).append("\n");
        sb.append("    defaultSharedVirtualservice: ").append(toIndentedString(defaultSharedVirtualservice)).append("\n");
        sb.append("    disableAutoBackendServiceSync: ").append(toIndentedString(disableAutoBackendServiceSync)).append("\n");
        sb.append("    disableAutoFrontendServiceSync: ").append(toIndentedString(disableAutoFrontendServiceSync)).append("\n");
        sb.append("    disableAutoGsSync: ").append(toIndentedString(disableAutoGsSync)).append("\n");
        sb.append("    disableAutoSeCreation: ").append(toIndentedString(disableAutoSeCreation)).append("\n");
        sb.append("    dockerEndpoint: ").append(toIndentedString(dockerEndpoint)).append("\n");
        sb.append("    dockerRegistrySe: ").append(toIndentedString(dockerRegistrySe)).append("\n");
        sb.append("    eastWestPlacementSubnet: ").append(toIndentedString(eastWestPlacementSubnet)).append("\n");
        sb.append("    enableEventSubscription: ").append(toIndentedString(enableEventSubscription)).append("\n");
        sb.append("    enableRouteIngressHardening: ").append(toIndentedString(enableRouteIngressHardening)).append("\n");
        sb.append("    feproxyVipsEnableProxyArp: ").append(toIndentedString(feproxyVipsEnableProxyArp)).append("\n");
        sb.append("    fleetEndpoint: ").append(toIndentedString(fleetEndpoint)).append("\n");
        sb.append("    httpContainerPorts: ").append(toIndentedString(httpContainerPorts)).append("\n");
        sb.append("    ingExcludeAttributes: ").append(toIndentedString(ingExcludeAttributes)).append("\n");
        sb.append("    ingIncludeAttributes: ").append(toIndentedString(ingIncludeAttributes)).append("\n");
        sb.append("    l4HealthMonitoring: ").append(toIndentedString(l4HealthMonitoring)).append("\n");
        sb.append("    masterNodes: ").append(toIndentedString(masterNodes)).append("\n");
        sb.append("    nodeAvailabilityZoneLabel: ").append(toIndentedString(nodeAvailabilityZoneLabel)).append("\n");
        sb.append("    nsExcludeAttributes: ").append(toIndentedString(nsExcludeAttributes)).append("\n");
        sb.append("    nsIncludeAttributes: ").append(toIndentedString(nsIncludeAttributes)).append("\n");
        sb.append("    nuageController: ").append(toIndentedString(nuageController)).append("\n");
        sb.append("    numShards: ").append(toIndentedString(numShards)).append("\n");
        sb.append("    overrideServicePorts: ").append(toIndentedString(overrideServicePorts)).append("\n");
        sb.append("    persistentVolumeClaim: ").append(toIndentedString(persistentVolumeClaim)).append("\n");
        sb.append("    routes: ").append(toIndentedString(routes)).append("\n");
        sb.append("    routesShareVirtualservice: ").append(toIndentedString(routesShareVirtualservice)).append("\n");
        sb.append("    sdnOverlay: ").append(toIndentedString(sdnOverlay)).append("\n");
        sb.append("    seDeploymentMethod: ").append(toIndentedString(seDeploymentMethod)).append("\n");
        sb.append("    seExcludeAttributes: ").append(toIndentedString(seExcludeAttributes)).append("\n");
        sb.append("    seImagePullSecret: ").append(toIndentedString(seImagePullSecret)).append("\n");
        sb.append("    seIncludeAttributes: ").append(toIndentedString(seIncludeAttributes)).append("\n");
        sb.append("    seNamespace: ").append(toIndentedString(seNamespace)).append("\n");
        sb.append("    sePodTolerations: ").append(toIndentedString(sePodTolerations)).append("\n");
        sb.append("    sePriorityClass: ").append(toIndentedString(sePriorityClass)).append("\n");
        sb.append("    seRestartBatchSize: ").append(toIndentedString(seRestartBatchSize)).append("\n");
        sb.append("    seRestartForce: ").append(toIndentedString(seRestartForce)).append("\n");
        sb.append("    seSpawnRate: ").append(toIndentedString(seSpawnRate)).append("\n");
        sb.append("    seVolume: ").append(toIndentedString(seVolume)).append("\n");
        sb.append("    secureEgressMode: ").append(toIndentedString(secureEgressMode)).append("\n");
        sb.append("    serviceAccountToken: ").append(toIndentedString(serviceAccountToken)).append("\n");
        sb.append("    servicePortMatchHttpService: ").append(toIndentedString(servicePortMatchHttpService)).append("\n");
        sb.append("    shardPrefix: ").append(toIndentedString(shardPrefix)).append("\n");
        sb.append("    sharedVirtualserviceNamespace: ").append(toIndentedString(sharedVirtualserviceNamespace)).append("\n");
        sb.append("    sshSeDeployment: ").append(toIndentedString(sshSeDeployment)).append("\n");
        sb.append("    sshUserRef: ").append(toIndentedString(sshUserRef)).append("\n");
        sb.append("    syncNotReadyAddresses: ").append(toIndentedString(syncNotReadyAddresses)).append("\n");
        sb.append("    useControllerImage: ").append(toIndentedString(useControllerImage)).append("\n");
        sb.append("    useResourceDefinitionAsSsot: ").append(toIndentedString(useResourceDefinitionAsSsot)).append("\n");
        sb.append("    useSchedulingDisabledNodes: ").append(toIndentedString(useSchedulingDisabledNodes)).append("\n");
        sb.append("    useServiceClusterIpAsEwVip: ").append(toIndentedString(useServiceClusterIpAsEwVip)).append("\n");
        sb.append("    vipDefaultGateway: ").append(toIndentedString(vipDefaultGateway)).append("\n");
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

