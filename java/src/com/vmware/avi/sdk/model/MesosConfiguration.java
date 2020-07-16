package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The MesosConfiguration is a POJO class extends AviRestResource that used for creating
 * MesosConfiguration.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MesosConfiguration  {
    @JsonProperty("all_vses_are_feproxy")
    private Boolean allVsesAreFeproxy = false;

    @JsonProperty("app_sync_frequency")
    private Integer appSyncFrequency = 60;

    @JsonProperty("container_port_match_http_service")
    private Boolean containerPortMatchHttpService = true;

    @JsonProperty("coredump_directory")
    private String coredumpDirectory = "/var/lib/systemd/coredump";

    @JsonProperty("disable_auto_backend_service_sync")
    private Boolean disableAutoBackendServiceSync = false;

    @JsonProperty("disable_auto_frontend_service_sync")
    private Boolean disableAutoFrontendServiceSync = false;

    @JsonProperty("disable_auto_gs_sync")
    private Boolean disableAutoGsSync = false;

    @JsonProperty("disable_auto_se_creation")
    private Boolean disableAutoSeCreation = false;

    @JsonProperty("docker_registry_se")
    private DockerRegistry dockerRegistrySe = null;

    @JsonProperty("east_west_placement_subnet")
    private IpAddrPrefix eastWestPlacementSubnet = null;

    @JsonProperty("enable_event_subscription")
    private Boolean enableEventSubscription = true;

    @JsonProperty("feproxy_bridge_name")
    private String feproxyBridgeName = "cbr1";

    @JsonProperty("feproxy_container_port_as_service")
    private Boolean feproxyContainerPortAsService = true;

    @JsonProperty("feproxy_route_publish")
    private FeProxyRoutePublishConfig feproxyRoutePublish = null;

    @JsonProperty("feproxy_vips_enable_proxy_arp")
    private Boolean feproxyVipsEnableProxyArp = true;

    @JsonProperty("fleet_endpoint")
    private String fleetEndpoint = null;

    @JsonProperty("http_container_ports")
    private List<Integer> httpContainerPorts = null;

    @JsonProperty("marathon_configurations")
    private List<MarathonConfiguration> marathonConfigurations = null;

    @JsonProperty("marathon_se_deployment")
    private MarathonSeDeployment marathonSeDeployment = null;

    @JsonProperty("mesos_url")
    private String mesosUrl = "http://leader.mesos:5050";

    @JsonProperty("node_availability_zone_label")
    private String nodeAvailabilityZoneLabel = null;

    @JsonProperty("nuage_controller")
    private NuageSDNController nuageController = null;

    @JsonProperty("se_deployment_method")
    private String seDeploymentMethod = "MESOS_SE_CREATE_FLEET";

    @JsonProperty("se_exclude_attributes")
    private List<MesosAttribute> seExcludeAttributes = null;

    @JsonProperty("se_include_attributes")
    private List<MesosAttribute> seIncludeAttributes = null;

    @JsonProperty("se_resources")
    private List<MesosSeResources> seResources = null;

    @JsonProperty("se_spawn_rate")
    private Integer seSpawnRate = 25;

    @JsonProperty("se_volume")
    private String seVolume = "/opt/avi/se";

    @JsonProperty("services_accessible_all_interfaces")
    private Boolean servicesAccessibleAllInterfaces = false;

    @JsonProperty("ssh_se_deployment")
    private SSHSeDeployment sshSeDeployment = null;

    @JsonProperty("ssh_user_ref")
    private String sshUserRef = null;

    @JsonProperty("use_bridge_ip_as_vip")
    private Boolean useBridgeIpAsVip = false;

    @JsonProperty("use_container_ip_port")
    private Boolean useContainerIpPort = false;

    @JsonProperty("use_controller_image")
    private Boolean useControllerImage = false;

    @JsonProperty("use_vips_for_east_west_services")
    private Boolean useVipsForEastWestServices = true;

    @JsonProperty("vip")
    private IpAddr vip = null;



  /**
   * This is the getter method this will return the attribute value.
   * Consider all virtualservices as front end proxies.
   * Front end proxies are placed on specific ses as opposed to back end proxies placed on all ses.
   * Applicable where each service has its own vip and vip is reachable from anywhere.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return allVsesAreFeproxy
   */
  public Boolean getAllVsesAreFeproxy() {
    return allVsesAreFeproxy;
  }

  /**
   * This is the setter method to the attribute.
   * Consider all virtualservices as front end proxies.
   * Front end proxies are placed on specific ses as opposed to back end proxies placed on all ses.
   * Applicable where each service has its own vip and vip is reachable from anywhere.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param allVsesAreFeproxy set the allVsesAreFeproxy.
   */
  public void setAllVsesAreFeproxy(Boolean  allVsesAreFeproxy) {
    this.allVsesAreFeproxy = allVsesAreFeproxy;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Sync frequency in seconds with frameworks.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @return appSyncFrequency
   */
  public Integer getAppSyncFrequency() {
    return appSyncFrequency;
  }

  /**
   * This is the setter method to the attribute.
   * Sync frequency in seconds with frameworks.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @param appSyncFrequency set the appSyncFrequency.
   */
  public void setAppSyncFrequency(Integer  appSyncFrequency) {
    this.appSyncFrequency = appSyncFrequency;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Perform container port matching to create a http virtualservice instead of a tcp/udp virtualservice.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return containerPortMatchHttpService
   */
  public Boolean getContainerPortMatchHttpService() {
    return containerPortMatchHttpService;
  }

  /**
   * This is the setter method to the attribute.
   * Perform container port matching to create a http virtualservice instead of a tcp/udp virtualservice.
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
   * Field introduced in 17.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return disableAutoGsSync
   */
  public Boolean getDisableAutoGsSync() {
    return disableAutoGsSync;
  }

  /**
   * This is the setter method to the attribute.
   * Disable auto sync for gslb services.
   * Field introduced in 17.1.2.
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
   * Match against this prefix when placing east-west vss on ses (mesos mode only).
   * @return eastWestPlacementSubnet
   */
  public IpAddrPrefix getEastWestPlacementSubnet() {
    return eastWestPlacementSubnet;
  }

  /**
   * This is the setter method to the attribute.
   * Match against this prefix when placing east-west vss on ses (mesos mode only).
   * @param eastWestPlacementSubnet set the eastWestPlacementSubnet.
   */
  public void setEastWestPlacementSubnet(IpAddrPrefix eastWestPlacementSubnet) {
    this.eastWestPlacementSubnet = eastWestPlacementSubnet;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable marathon event subscriptions.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return enableEventSubscription
   */
  public Boolean getEnableEventSubscription() {
    return enableEventSubscription;
  }

  /**
   * This is the setter method to the attribute.
   * Enable marathon event subscriptions.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param enableEventSubscription set the enableEventSubscription.
   */
  public void setEnableEventSubscription(Boolean  enableEventSubscription) {
    this.enableEventSubscription = enableEventSubscription;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of second linux bridge on host providing connectivity for front end proxies.
   * This is a disruptive change.
   * Default value when not specified in API or module is interpreted by Avi Controller as cbr1.
   * @return feproxyBridgeName
   */
  public String getFeproxyBridgeName() {
    return feproxyBridgeName;
  }

  /**
   * This is the setter method to the attribute.
   * Name of second linux bridge on host providing connectivity for front end proxies.
   * This is a disruptive change.
   * Default value when not specified in API or module is interpreted by Avi Controller as cbr1.
   * @param feproxyBridgeName set the feproxyBridgeName.
   */
  public void setFeproxyBridgeName(String  feproxyBridgeName) {
    this.feproxyBridgeName = feproxyBridgeName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * For front end proxies, use container port as service port.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return feproxyContainerPortAsService
   */
  public Boolean getFeproxyContainerPortAsService() {
    return feproxyContainerPortAsService;
  }

  /**
   * This is the setter method to the attribute.
   * For front end proxies, use container port as service port.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param feproxyContainerPortAsService set the feproxyContainerPortAsService.
   */
  public void setFeproxyContainerPortAsService(Boolean  feproxyContainerPortAsService) {
    this.feproxyContainerPortAsService = feproxyContainerPortAsService;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Publish ecmp route to upstream router for vip.
   * @return feproxyRoutePublish
   */
  public FeProxyRoutePublishConfig getFeproxyRoutePublish() {
    return feproxyRoutePublish;
  }

  /**
   * This is the setter method to the attribute.
   * Publish ecmp route to upstream router for vip.
   * @param feproxyRoutePublish set the feproxyRoutePublish.
   */
  public void setFeproxyRoutePublish(FeProxyRoutePublishConfig feproxyRoutePublish) {
    this.feproxyRoutePublish = feproxyRoutePublish;
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
   * @return fleetEndpoint
   */
  public String getFleetEndpoint() {
    return fleetEndpoint;
  }

  /**
   * This is the setter method to the attribute.
   * Optional fleet remote endpoint if fleet is used for se deployment.
   * @param fleetEndpoint set the fleetEndpoint.
   */
  public void setFleetEndpoint(String  fleetEndpoint) {
    this.fleetEndpoint = fleetEndpoint;
  }
  /**
   * This is the getter method this will return the attribute value.
   * List of container ports that create a http virtualservice instead of a tcp/udp virtualservice.
   * Defaults to 80.
   * @return httpContainerPorts
   */
  public List<Integer> getHttpContainerPorts() {
    return httpContainerPorts;
  }

  /**
   * This is the setter method. this will set the httpContainerPorts
   * List of container ports that create a http virtualservice instead of a tcp/udp virtualservice.
   * Defaults to 80.
   * @return httpContainerPorts
   */
  public void setHttpContainerPorts(List<Integer>  httpContainerPorts) {
    this.httpContainerPorts = httpContainerPorts;
  }

  /**
   * This is the setter method this will set the httpContainerPorts
   * List of container ports that create a http virtualservice instead of a tcp/udp virtualservice.
   * Defaults to 80.
   * @return httpContainerPorts
   */
  public MesosConfiguration addHttpContainerPortsItem(Integer httpContainerPortsItem) {
    if (this.httpContainerPorts == null) {
      this.httpContainerPorts = new ArrayList<Integer>();
    }
    this.httpContainerPorts.add(httpContainerPortsItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * List of marathon frameworks.
   * @return marathonConfigurations
   */
  public List<MarathonConfiguration> getMarathonConfigurations() {
    return marathonConfigurations;
  }

  /**
   * This is the setter method. this will set the marathonConfigurations
   * List of marathon frameworks.
   * @return marathonConfigurations
   */
  public void setMarathonConfigurations(List<MarathonConfiguration>  marathonConfigurations) {
    this.marathonConfigurations = marathonConfigurations;
  }

  /**
   * This is the setter method this will set the marathonConfigurations
   * List of marathon frameworks.
   * @return marathonConfigurations
   */
  public MesosConfiguration addMarathonConfigurationsItem(MarathonConfiguration marathonConfigurationsItem) {
    if (this.marathonConfigurations == null) {
      this.marathonConfigurations = new ArrayList<MarathonConfiguration>();
    }
    this.marathonConfigurations.add(marathonConfigurationsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Options for marathon se deployment.
   * @return marathonSeDeployment
   */
  public MarathonSeDeployment getMarathonSeDeployment() {
    return marathonSeDeployment;
  }

  /**
   * This is the setter method to the attribute.
   * Options for marathon se deployment.
   * @param marathonSeDeployment set the marathonSeDeployment.
   */
  public void setMarathonSeDeployment(MarathonSeDeployment marathonSeDeployment) {
    this.marathonSeDeployment = marathonSeDeployment;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Mesos url of the form http //host port.
   * Default value when not specified in API or module is interpreted by Avi Controller as http://leader.mesos:5050.
   * @return mesosUrl
   */
  public String getMesosUrl() {
    return mesosUrl;
  }

  /**
   * This is the setter method to the attribute.
   * Mesos url of the form http //host port.
   * Default value when not specified in API or module is interpreted by Avi Controller as http://leader.mesos:5050.
   * @param mesosUrl set the mesosUrl.
   */
  public void setMesosUrl(String  mesosUrl) {
    this.mesosUrl = mesosUrl;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Mesos node label to be used as mesos node's availability zone in a dual availability zone deployment.
   * Serviceengines belonging to the availability zone will be rebooted during a manual dr failover.
   * @return nodeAvailabilityZoneLabel
   */
  public String getNodeAvailabilityZoneLabel() {
    return nodeAvailabilityZoneLabel;
  }

  /**
   * This is the setter method to the attribute.
   * Mesos node label to be used as mesos node's availability zone in a dual availability zone deployment.
   * Serviceengines belonging to the availability zone will be rebooted during a manual dr failover.
   * @param nodeAvailabilityZoneLabel set the nodeAvailabilityZoneLabel.
   */
  public void setNodeAvailabilityZoneLabel(String  nodeAvailabilityZoneLabel) {
    this.nodeAvailabilityZoneLabel = nodeAvailabilityZoneLabel;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Nuage overlay sdn controller information.
   * @return nuageController
   */
  public NuageSDNController getNuageController() {
    return nuageController;
  }

  /**
   * This is the setter method to the attribute.
   * Nuage overlay sdn controller information.
   * @param nuageController set the nuageController.
   */
  public void setNuageController(NuageSDNController nuageController) {
    this.nuageController = nuageController;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Use fleet/ssh for deploying service engines.
   * Enum options - MESOS_SE_CREATE_FLEET, MESOS_SE_CREATE_SSH, MESOS_SE_CREATE_MARATHON.
   * Default value when not specified in API or module is interpreted by Avi Controller as MESOS_SE_CREATE_FLEET.
   * @return seDeploymentMethod
   */
  public String getSeDeploymentMethod() {
    return seDeploymentMethod;
  }

  /**
   * This is the setter method to the attribute.
   * Use fleet/ssh for deploying service engines.
   * Enum options - MESOS_SE_CREATE_FLEET, MESOS_SE_CREATE_SSH, MESOS_SE_CREATE_MARATHON.
   * Default value when not specified in API or module is interpreted by Avi Controller as MESOS_SE_CREATE_FLEET.
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
  public MesosConfiguration addSeExcludeAttributesItem(MesosAttribute seExcludeAttributesItem) {
    if (this.seExcludeAttributes == null) {
      this.seExcludeAttributes = new ArrayList<MesosAttribute>();
    }
    this.seExcludeAttributes.add(seExcludeAttributesItem);
    return this;
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
  public MesosConfiguration addSeIncludeAttributesItem(MesosAttribute seIncludeAttributesItem) {
    if (this.seIncludeAttributes == null) {
      this.seIncludeAttributes = new ArrayList<MesosAttribute>();
    }
    this.seIncludeAttributes.add(seIncludeAttributesItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Obsolete - ignored.
   * @return seResources
   */
  public List<MesosSeResources> getSeResources() {
    return seResources;
  }

  /**
   * This is the setter method. this will set the seResources
   * Obsolete - ignored.
   * @return seResources
   */
  public void setSeResources(List<MesosSeResources>  seResources) {
    this.seResources = seResources;
  }

  /**
   * This is the setter method this will set the seResources
   * Obsolete - ignored.
   * @return seResources
   */
  public MesosConfiguration addSeResourcesItem(MesosSeResources seResourcesItem) {
    if (this.seResources == null) {
      this.seResources = new ArrayList<MesosSeResources>();
    }
    this.seResources.add(seResourcesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * New se spawn rate per minute.
   * Default value when not specified in API or module is interpreted by Avi Controller as 25.
   * @return seSpawnRate
   */
  public Integer getSeSpawnRate() {
    return seSpawnRate;
  }

  /**
   * This is the setter method to the attribute.
   * New se spawn rate per minute.
   * Default value when not specified in API or module is interpreted by Avi Controller as 25.
   * @param seSpawnRate set the seSpawnRate.
   */
  public void setSeSpawnRate(Integer  seSpawnRate) {
    this.seSpawnRate = seSpawnRate;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Host volume to be used as a disk for avi se, this is a disruptive change.
   * Default value when not specified in API or module is interpreted by Avi Controller as /opt/avi/se.
   * @return seVolume
   */
  public String getSeVolume() {
    return seVolume;
  }

  /**
   * This is the setter method to the attribute.
   * Host volume to be used as a disk for avi se, this is a disruptive change.
   * Default value when not specified in API or module is interpreted by Avi Controller as /opt/avi/se.
   * @param seVolume set the seVolume.
   */
  public void setSeVolume(String  seVolume) {
    this.seVolume = seVolume;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Make service ports accessible on all host interfaces in addition to east-west vip and/or bridge ip.
   * Usually enabled aws mesos clusters to export east-west services on host interface.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return servicesAccessibleAllInterfaces
   */
  public Boolean getServicesAccessibleAllInterfaces() {
    return servicesAccessibleAllInterfaces;
  }

  /**
   * This is the setter method to the attribute.
   * Make service ports accessible on all host interfaces in addition to east-west vip and/or bridge ip.
   * Usually enabled aws mesos clusters to export east-west services on host interface.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param servicesAccessibleAllInterfaces set the servicesAccessibleAllInterfaces.
   */
  public void setServicesAccessibleAllInterfaces(Boolean  servicesAccessibleAllInterfaces) {
    this.servicesAccessibleAllInterfaces = servicesAccessibleAllInterfaces;
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
   * Use bridge ip on each host as vip.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return useBridgeIpAsVip
   */
  public Boolean getUseBridgeIpAsVip() {
    return useBridgeIpAsVip;
  }

  /**
   * This is the setter method to the attribute.
   * Use bridge ip on each host as vip.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param useBridgeIpAsVip set the useBridgeIpAsVip.
   */
  public void setUseBridgeIpAsVip(Boolean  useBridgeIpAsVip) {
    this.useBridgeIpAsVip = useBridgeIpAsVip;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Use container ip address port for pool instead of host ip address hostport.
   * This mode is applicable if the container ip is reachable (not a private nated ip) from other hosts in a routed environment for containers.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return useContainerIpPort
   */
  public Boolean getUseContainerIpPort() {
    return useContainerIpPort;
  }

  /**
   * This is the setter method to the attribute.
   * Use container ip address port for pool instead of host ip address hostport.
   * This mode is applicable if the container ip is reachable (not a private nated ip) from other hosts in a routed environment for containers.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param useContainerIpPort set the useContainerIpPort.
   */
  public void setUseContainerIpPort(Boolean  useContainerIpPort) {
    this.useContainerIpPort = useContainerIpPort;
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
   * Use unique virtual ip address for every east west service in mesos/marathon.
   * 'use_bridge_ip_as_vip' and 'vip' fields , if set, will not be used if this field is set.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return useVipsForEastWestServices
   */
  public Boolean getUseVipsForEastWestServices() {
    return useVipsForEastWestServices;
  }

  /**
   * This is the setter method to the attribute.
   * Use unique virtual ip address for every east west service in mesos/marathon.
   * 'use_bridge_ip_as_vip' and 'vip' fields , if set, will not be used if this field is set.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param useVipsForEastWestServices set the useVipsForEastWestServices.
   */
  public void setUseVipsForEastWestServices(Boolean  useVipsForEastWestServices) {
    this.useVipsForEastWestServices = useVipsForEastWestServices;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Vip to be used by all east-west apps on all hosts.
   * Preferrably use an address from outside the subnet.
   * @return vip
   */
  public IpAddr getVip() {
    return vip;
  }

  /**
   * This is the setter method to the attribute.
   * Vip to be used by all east-west apps on all hosts.
   * Preferrably use an address from outside the subnet.
   * @param vip set the vip.
   */
  public void setVip(IpAddr vip) {
    this.vip = vip;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  MesosConfiguration objMesosConfiguration = (MesosConfiguration) o;
  return   Objects.equals(this.useVipsForEastWestServices, objMesosConfiguration.useVipsForEastWestServices)&&
  Objects.equals(this.eastWestPlacementSubnet, objMesosConfiguration.eastWestPlacementSubnet)&&
  Objects.equals(this.enableEventSubscription, objMesosConfiguration.enableEventSubscription)&&
  Objects.equals(this.nuageController, objMesosConfiguration.nuageController)&&
  Objects.equals(this.feproxyVipsEnableProxyArp, objMesosConfiguration.feproxyVipsEnableProxyArp)&&
  Objects.equals(this.disableAutoBackendServiceSync, objMesosConfiguration.disableAutoBackendServiceSync)&&
  Objects.equals(this.feproxyBridgeName, objMesosConfiguration.feproxyBridgeName)&&
  Objects.equals(this.vip, objMesosConfiguration.vip)&&
  Objects.equals(this.containerPortMatchHttpService, objMesosConfiguration.containerPortMatchHttpService)&&
  Objects.equals(this.fleetEndpoint, objMesosConfiguration.fleetEndpoint)&&
  Objects.equals(this.sshUserRef, objMesosConfiguration.sshUserRef)&&
  Objects.equals(this.seVolume, objMesosConfiguration.seVolume)&&
  Objects.equals(this.httpContainerPorts, objMesosConfiguration.httpContainerPorts)&&
  Objects.equals(this.seExcludeAttributes, objMesosConfiguration.seExcludeAttributes)&&
  Objects.equals(this.seDeploymentMethod, objMesosConfiguration.seDeploymentMethod)&&
  Objects.equals(this.nodeAvailabilityZoneLabel, objMesosConfiguration.nodeAvailabilityZoneLabel)&&
  Objects.equals(this.dockerRegistrySe, objMesosConfiguration.dockerRegistrySe)&&
  Objects.equals(this.feproxyRoutePublish, objMesosConfiguration.feproxyRoutePublish)&&
  Objects.equals(this.sshSeDeployment, objMesosConfiguration.sshSeDeployment)&&
  Objects.equals(this.feproxyContainerPortAsService, objMesosConfiguration.feproxyContainerPortAsService)&&
  Objects.equals(this.useControllerImage, objMesosConfiguration.useControllerImage)&&
  Objects.equals(this.disableAutoGsSync, objMesosConfiguration.disableAutoGsSync)&&
  Objects.equals(this.useBridgeIpAsVip, objMesosConfiguration.useBridgeIpAsVip)&&
  Objects.equals(this.coredumpDirectory, objMesosConfiguration.coredumpDirectory)&&
  Objects.equals(this.disableAutoFrontendServiceSync, objMesosConfiguration.disableAutoFrontendServiceSync)&&
  Objects.equals(this.seResources, objMesosConfiguration.seResources)&&
  Objects.equals(this.seIncludeAttributes, objMesosConfiguration.seIncludeAttributes)&&
  Objects.equals(this.appSyncFrequency, objMesosConfiguration.appSyncFrequency)&&
  Objects.equals(this.mesosUrl, objMesosConfiguration.mesosUrl)&&
  Objects.equals(this.marathonConfigurations, objMesosConfiguration.marathonConfigurations)&&
  Objects.equals(this.marathonSeDeployment, objMesosConfiguration.marathonSeDeployment)&&
  Objects.equals(this.servicesAccessibleAllInterfaces, objMesosConfiguration.servicesAccessibleAllInterfaces)&&
  Objects.equals(this.seSpawnRate, objMesosConfiguration.seSpawnRate)&&
  Objects.equals(this.allVsesAreFeproxy, objMesosConfiguration.allVsesAreFeproxy)&&
  Objects.equals(this.useContainerIpPort, objMesosConfiguration.useContainerIpPort)&&
  Objects.equals(this.disableAutoSeCreation, objMesosConfiguration.disableAutoSeCreation);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class MesosConfiguration {\n");
      sb.append("    allVsesAreFeproxy: ").append(toIndentedString(allVsesAreFeproxy)).append("\n");
        sb.append("    appSyncFrequency: ").append(toIndentedString(appSyncFrequency)).append("\n");
        sb.append("    containerPortMatchHttpService: ").append(toIndentedString(containerPortMatchHttpService)).append("\n");
        sb.append("    coredumpDirectory: ").append(toIndentedString(coredumpDirectory)).append("\n");
        sb.append("    disableAutoBackendServiceSync: ").append(toIndentedString(disableAutoBackendServiceSync)).append("\n");
        sb.append("    disableAutoFrontendServiceSync: ").append(toIndentedString(disableAutoFrontendServiceSync)).append("\n");
        sb.append("    disableAutoGsSync: ").append(toIndentedString(disableAutoGsSync)).append("\n");
        sb.append("    disableAutoSeCreation: ").append(toIndentedString(disableAutoSeCreation)).append("\n");
        sb.append("    dockerRegistrySe: ").append(toIndentedString(dockerRegistrySe)).append("\n");
        sb.append("    eastWestPlacementSubnet: ").append(toIndentedString(eastWestPlacementSubnet)).append("\n");
        sb.append("    enableEventSubscription: ").append(toIndentedString(enableEventSubscription)).append("\n");
        sb.append("    feproxyBridgeName: ").append(toIndentedString(feproxyBridgeName)).append("\n");
        sb.append("    feproxyContainerPortAsService: ").append(toIndentedString(feproxyContainerPortAsService)).append("\n");
        sb.append("    feproxyRoutePublish: ").append(toIndentedString(feproxyRoutePublish)).append("\n");
        sb.append("    feproxyVipsEnableProxyArp: ").append(toIndentedString(feproxyVipsEnableProxyArp)).append("\n");
        sb.append("    fleetEndpoint: ").append(toIndentedString(fleetEndpoint)).append("\n");
        sb.append("    httpContainerPorts: ").append(toIndentedString(httpContainerPorts)).append("\n");
        sb.append("    marathonConfigurations: ").append(toIndentedString(marathonConfigurations)).append("\n");
        sb.append("    marathonSeDeployment: ").append(toIndentedString(marathonSeDeployment)).append("\n");
        sb.append("    mesosUrl: ").append(toIndentedString(mesosUrl)).append("\n");
        sb.append("    nodeAvailabilityZoneLabel: ").append(toIndentedString(nodeAvailabilityZoneLabel)).append("\n");
        sb.append("    nuageController: ").append(toIndentedString(nuageController)).append("\n");
        sb.append("    seDeploymentMethod: ").append(toIndentedString(seDeploymentMethod)).append("\n");
        sb.append("    seExcludeAttributes: ").append(toIndentedString(seExcludeAttributes)).append("\n");
        sb.append("    seIncludeAttributes: ").append(toIndentedString(seIncludeAttributes)).append("\n");
        sb.append("    seResources: ").append(toIndentedString(seResources)).append("\n");
        sb.append("    seSpawnRate: ").append(toIndentedString(seSpawnRate)).append("\n");
        sb.append("    seVolume: ").append(toIndentedString(seVolume)).append("\n");
        sb.append("    servicesAccessibleAllInterfaces: ").append(toIndentedString(servicesAccessibleAllInterfaces)).append("\n");
        sb.append("    sshSeDeployment: ").append(toIndentedString(sshSeDeployment)).append("\n");
        sb.append("    sshUserRef: ").append(toIndentedString(sshUserRef)).append("\n");
        sb.append("    useBridgeIpAsVip: ").append(toIndentedString(useBridgeIpAsVip)).append("\n");
        sb.append("    useContainerIpPort: ").append(toIndentedString(useContainerIpPort)).append("\n");
        sb.append("    useControllerImage: ").append(toIndentedString(useControllerImage)).append("\n");
        sb.append("    useVipsForEastWestServices: ").append(toIndentedString(useVipsForEastWestServices)).append("\n");
        sb.append("    vip: ").append(toIndentedString(vip)).append("\n");
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

