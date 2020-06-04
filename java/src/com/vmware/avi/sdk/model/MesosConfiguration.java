/*
 * Avi avi_global_spec Object API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 20.1.1
 * Contact: support@avinetworks.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.vmware.avi.sdk.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.vmware.avi.sdk.model.DockerRegistry;
import com.vmware.avi.sdk.model.FeProxyRoutePublishConfig;
import com.vmware.avi.sdk.model.IpAddr;
import com.vmware.avi.sdk.model.IpAddrPrefix;
import com.vmware.avi.sdk.model.MarathonConfiguration;
import com.vmware.avi.sdk.model.MarathonSeDeployment;
import com.vmware.avi.sdk.model.MesosAttribute;
import com.vmware.avi.sdk.model.MesosSeResources;
import com.vmware.avi.sdk.model.NuageSDNController;
import com.vmware.avi.sdk.model.SSHSeDeployment;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
/**
 * MesosConfiguration
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-12T12:27:26.755+05:30[Asia/Kolkata]")
public class MesosConfiguration {
  @JsonProperty("all_vses_are_feproxy")
  private Boolean allVsesAreFeproxy = null;

  @JsonProperty("app_sync_frequency")
  private Integer appSyncFrequency = 60;

  @JsonProperty("container_port_match_http_service")
  private Boolean containerPortMatchHttpService = true;

  @JsonProperty("coredump_directory")
  private String coredumpDirectory = "/var/lib/systemd/coredump";

  @JsonProperty("disable_auto_backend_service_sync")
  private Boolean disableAutoBackendServiceSync = null;

  @JsonProperty("disable_auto_frontend_service_sync")
  private Boolean disableAutoFrontendServiceSync = null;

  @JsonProperty("disable_auto_gs_sync")
  private Boolean disableAutoGsSync = null;

  @JsonProperty("disable_auto_se_creation")
  private Boolean disableAutoSeCreation = null;

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
  private Boolean servicesAccessibleAllInterfaces = null;

  @JsonProperty("ssh_se_deployment")
  private SSHSeDeployment sshSeDeployment = null;

  @JsonProperty("ssh_user_ref")
  private String sshUserRef = null;

  @JsonProperty("use_bridge_ip_as_vip")
  private Boolean useBridgeIpAsVip = null;

  @JsonProperty("use_container_ip_port")
  private Boolean useContainerIpPort = null;

  @JsonProperty("use_controller_image")
  private Boolean useControllerImage = null;

  @JsonProperty("use_vips_for_east_west_services")
  private Boolean useVipsForEastWestServices = true;

  @JsonProperty("vip")
  private IpAddr vip = null;

  public MesosConfiguration allVsesAreFeproxy(Boolean allVsesAreFeproxy) {
    this.allVsesAreFeproxy = allVsesAreFeproxy;
    return this;
  }

   /**
   * Consider all Virtualservices as Front End Proxies. Front End proxies are placed on specific SEs as opposed to Back End proxies placed on all SEs. Applicable where each service has its own VIP and VIP is reachable from anywhere.
   * @return allVsesAreFeproxy
  **/
  @Schema(description = "Consider all Virtualservices as Front End Proxies. Front End proxies are placed on specific SEs as opposed to Back End proxies placed on all SEs. Applicable where each service has its own VIP and VIP is reachable from anywhere.")
  public Boolean isAllVsesAreFeproxy() {
    return allVsesAreFeproxy;
  }

  public void setAllVsesAreFeproxy(Boolean allVsesAreFeproxy) {
    this.allVsesAreFeproxy = allVsesAreFeproxy;
  }

  public MesosConfiguration appSyncFrequency(Integer appSyncFrequency) {
    this.appSyncFrequency = appSyncFrequency;
    return this;
  }

   /**
   * Sync frequency in seconds with frameworks.
   * @return appSyncFrequency
  **/
  @Schema(description = "Sync frequency in seconds with frameworks.")
  public Integer getAppSyncFrequency() {
    return appSyncFrequency;
  }

  public void setAppSyncFrequency(Integer appSyncFrequency) {
    this.appSyncFrequency = appSyncFrequency;
  }

  public MesosConfiguration containerPortMatchHttpService(Boolean containerPortMatchHttpService) {
    this.containerPortMatchHttpService = containerPortMatchHttpService;
    return this;
  }

   /**
   * Perform container port matching to create a HTTP Virtualservice instead of a TCP/UDP VirtualService.
   * @return containerPortMatchHttpService
  **/
  @Schema(description = "Perform container port matching to create a HTTP Virtualservice instead of a TCP/UDP VirtualService.")
  public Boolean isContainerPortMatchHttpService() {
    return containerPortMatchHttpService;
  }

  public void setContainerPortMatchHttpService(Boolean containerPortMatchHttpService) {
    this.containerPortMatchHttpService = containerPortMatchHttpService;
  }

  public MesosConfiguration coredumpDirectory(String coredumpDirectory) {
    this.coredumpDirectory = coredumpDirectory;
    return this;
  }

   /**
   * Directory to mount to check for core dumps on Service Engines. This will be mapped read only to /var/crash on any new Service Engines. This is a disruptive change.
   * @return coredumpDirectory
  **/
  @Schema(description = "Directory to mount to check for core dumps on Service Engines. This will be mapped read only to /var/crash on any new Service Engines. This is a disruptive change.")
  public String getCoredumpDirectory() {
    return coredumpDirectory;
  }

  public void setCoredumpDirectory(String coredumpDirectory) {
    this.coredumpDirectory = coredumpDirectory;
  }

  public MesosConfiguration disableAutoBackendServiceSync(Boolean disableAutoBackendServiceSync) {
    this.disableAutoBackendServiceSync = disableAutoBackendServiceSync;
    return this;
  }

   /**
   * Disable auto service sync for back end services.
   * @return disableAutoBackendServiceSync
  **/
  @Schema(description = "Disable auto service sync for back end services.")
  public Boolean isDisableAutoBackendServiceSync() {
    return disableAutoBackendServiceSync;
  }

  public void setDisableAutoBackendServiceSync(Boolean disableAutoBackendServiceSync) {
    this.disableAutoBackendServiceSync = disableAutoBackendServiceSync;
  }

  public MesosConfiguration disableAutoFrontendServiceSync(Boolean disableAutoFrontendServiceSync) {
    this.disableAutoFrontendServiceSync = disableAutoFrontendServiceSync;
    return this;
  }

   /**
   * Disable auto service sync for front end services.
   * @return disableAutoFrontendServiceSync
  **/
  @Schema(description = "Disable auto service sync for front end services.")
  public Boolean isDisableAutoFrontendServiceSync() {
    return disableAutoFrontendServiceSync;
  }

  public void setDisableAutoFrontendServiceSync(Boolean disableAutoFrontendServiceSync) {
    this.disableAutoFrontendServiceSync = disableAutoFrontendServiceSync;
  }

  public MesosConfiguration disableAutoGsSync(Boolean disableAutoGsSync) {
    this.disableAutoGsSync = disableAutoGsSync;
    return this;
  }

   /**
   * Disable auto sync for GSLB services. Field introduced in 17.1.2.
   * @return disableAutoGsSync
  **/
  @Schema(description = "Disable auto sync for GSLB services. Field introduced in 17.1.2.")
  public Boolean isDisableAutoGsSync() {
    return disableAutoGsSync;
  }

  public void setDisableAutoGsSync(Boolean disableAutoGsSync) {
    this.disableAutoGsSync = disableAutoGsSync;
  }

  public MesosConfiguration disableAutoSeCreation(Boolean disableAutoSeCreation) {
    this.disableAutoSeCreation = disableAutoSeCreation;
    return this;
  }

   /**
   * Disable SE creation.
   * @return disableAutoSeCreation
  **/
  @Schema(description = "Disable SE creation.")
  public Boolean isDisableAutoSeCreation() {
    return disableAutoSeCreation;
  }

  public void setDisableAutoSeCreation(Boolean disableAutoSeCreation) {
    this.disableAutoSeCreation = disableAutoSeCreation;
  }

  public MesosConfiguration dockerRegistrySe(DockerRegistry dockerRegistrySe) {
    this.dockerRegistrySe = dockerRegistrySe;
    return this;
  }

   /**
   * Get dockerRegistrySe
   * @return dockerRegistrySe
  **/
  @Schema(description = "")
  public DockerRegistry getDockerRegistrySe() {
    return dockerRegistrySe;
  }

  public void setDockerRegistrySe(DockerRegistry dockerRegistrySe) {
    this.dockerRegistrySe = dockerRegistrySe;
  }

  public MesosConfiguration eastWestPlacementSubnet(IpAddrPrefix eastWestPlacementSubnet) {
    this.eastWestPlacementSubnet = eastWestPlacementSubnet;
    return this;
  }

   /**
   * Get eastWestPlacementSubnet
   * @return eastWestPlacementSubnet
  **/
  @Schema(description = "")
  public IpAddrPrefix getEastWestPlacementSubnet() {
    return eastWestPlacementSubnet;
  }

  public void setEastWestPlacementSubnet(IpAddrPrefix eastWestPlacementSubnet) {
    this.eastWestPlacementSubnet = eastWestPlacementSubnet;
  }

  public MesosConfiguration enableEventSubscription(Boolean enableEventSubscription) {
    this.enableEventSubscription = enableEventSubscription;
    return this;
  }

   /**
   * Enable Marathon event subscriptions.
   * @return enableEventSubscription
  **/
  @Schema(description = "Enable Marathon event subscriptions.")
  public Boolean isEnableEventSubscription() {
    return enableEventSubscription;
  }

  public void setEnableEventSubscription(Boolean enableEventSubscription) {
    this.enableEventSubscription = enableEventSubscription;
  }

  public MesosConfiguration feproxyBridgeName(String feproxyBridgeName) {
    this.feproxyBridgeName = feproxyBridgeName;
    return this;
  }

   /**
   * Name of second Linux bridge on Host providing connectivity for Front End proxies. This is a disruptive change.
   * @return feproxyBridgeName
  **/
  @Schema(description = "Name of second Linux bridge on Host providing connectivity for Front End proxies. This is a disruptive change.")
  public String getFeproxyBridgeName() {
    return feproxyBridgeName;
  }

  public void setFeproxyBridgeName(String feproxyBridgeName) {
    this.feproxyBridgeName = feproxyBridgeName;
  }

  public MesosConfiguration feproxyContainerPortAsService(Boolean feproxyContainerPortAsService) {
    this.feproxyContainerPortAsService = feproxyContainerPortAsService;
    return this;
  }

   /**
   * For Front End proxies, use container port as service port.
   * @return feproxyContainerPortAsService
  **/
  @Schema(description = "For Front End proxies, use container port as service port.")
  public Boolean isFeproxyContainerPortAsService() {
    return feproxyContainerPortAsService;
  }

  public void setFeproxyContainerPortAsService(Boolean feproxyContainerPortAsService) {
    this.feproxyContainerPortAsService = feproxyContainerPortAsService;
  }

  public MesosConfiguration feproxyRoutePublish(FeProxyRoutePublishConfig feproxyRoutePublish) {
    this.feproxyRoutePublish = feproxyRoutePublish;
    return this;
  }

   /**
   * Get feproxyRoutePublish
   * @return feproxyRoutePublish
  **/
  @Schema(description = "")
  public FeProxyRoutePublishConfig getFeproxyRoutePublish() {
    return feproxyRoutePublish;
  }

  public void setFeproxyRoutePublish(FeProxyRoutePublishConfig feproxyRoutePublish) {
    this.feproxyRoutePublish = feproxyRoutePublish;
  }

  public MesosConfiguration feproxyVipsEnableProxyArp(Boolean feproxyVipsEnableProxyArp) {
    this.feproxyVipsEnableProxyArp = feproxyVipsEnableProxyArp;
    return this;
  }

   /**
   * Enable proxy ARP from Host interface for Front End  proxies.
   * @return feproxyVipsEnableProxyArp
  **/
  @Schema(description = "Enable proxy ARP from Host interface for Front End  proxies.")
  public Boolean isFeproxyVipsEnableProxyArp() {
    return feproxyVipsEnableProxyArp;
  }

  public void setFeproxyVipsEnableProxyArp(Boolean feproxyVipsEnableProxyArp) {
    this.feproxyVipsEnableProxyArp = feproxyVipsEnableProxyArp;
  }

  public MesosConfiguration fleetEndpoint(String fleetEndpoint) {
    this.fleetEndpoint = fleetEndpoint;
    return this;
  }

   /**
   * Optional fleet remote endpoint if fleet is used for SE deployment.
   * @return fleetEndpoint
  **/
  @Schema(description = "Optional fleet remote endpoint if fleet is used for SE deployment.")
  public String getFleetEndpoint() {
    return fleetEndpoint;
  }

  public void setFleetEndpoint(String fleetEndpoint) {
    this.fleetEndpoint = fleetEndpoint;
  }

  public MesosConfiguration httpContainerPorts(List<Integer> httpContainerPorts) {
    this.httpContainerPorts = httpContainerPorts;
    return this;
  }

  public MesosConfiguration addHttpContainerPortsItem(Integer httpContainerPortsItem) {
    if (this.httpContainerPorts == null) {
      this.httpContainerPorts = new ArrayList<Integer>();
    }
    this.httpContainerPorts.add(httpContainerPortsItem);
    return this;
  }

   /**
   * List of container ports that create a HTTP Virtualservice instead of a TCP/UDP VirtualService. Defaults to 80.
   * @return httpContainerPorts
  **/
  @Schema(description = "List of container ports that create a HTTP Virtualservice instead of a TCP/UDP VirtualService. Defaults to 80.")
  public List<Integer> getHttpContainerPorts() {
    return httpContainerPorts;
  }

  public void setHttpContainerPorts(List<Integer> httpContainerPorts) {
    this.httpContainerPorts = httpContainerPorts;
  }

  public MesosConfiguration marathonConfigurations(List<MarathonConfiguration> marathonConfigurations) {
    this.marathonConfigurations = marathonConfigurations;
    return this;
  }

  public MesosConfiguration addMarathonConfigurationsItem(MarathonConfiguration marathonConfigurationsItem) {
    if (this.marathonConfigurations == null) {
      this.marathonConfigurations = new ArrayList<MarathonConfiguration>();
    }
    this.marathonConfigurations.add(marathonConfigurationsItem);
    return this;
  }

   /**
   * List of Marathon frameworks.
   * @return marathonConfigurations
  **/
  @Schema(description = "List of Marathon frameworks.")
  public List<MarathonConfiguration> getMarathonConfigurations() {
    return marathonConfigurations;
  }

  public void setMarathonConfigurations(List<MarathonConfiguration> marathonConfigurations) {
    this.marathonConfigurations = marathonConfigurations;
  }

  public MesosConfiguration marathonSeDeployment(MarathonSeDeployment marathonSeDeployment) {
    this.marathonSeDeployment = marathonSeDeployment;
    return this;
  }

   /**
   * Get marathonSeDeployment
   * @return marathonSeDeployment
  **/
  @Schema(description = "")
  public MarathonSeDeployment getMarathonSeDeployment() {
    return marathonSeDeployment;
  }

  public void setMarathonSeDeployment(MarathonSeDeployment marathonSeDeployment) {
    this.marathonSeDeployment = marathonSeDeployment;
  }

  public MesosConfiguration mesosUrl(String mesosUrl) {
    this.mesosUrl = mesosUrl;
    return this;
  }

   /**
   * Mesos URL of the form http //host port.
   * @return mesosUrl
  **/
  @Schema(description = "Mesos URL of the form http //host port.")
  public String getMesosUrl() {
    return mesosUrl;
  }

  public void setMesosUrl(String mesosUrl) {
    this.mesosUrl = mesosUrl;
  }

  public MesosConfiguration nodeAvailabilityZoneLabel(String nodeAvailabilityZoneLabel) {
    this.nodeAvailabilityZoneLabel = nodeAvailabilityZoneLabel;
    return this;
  }

   /**
   * Mesos Node label to be used as Mesos Node&#x27;s availability zone in a dual availability zone deployment. ServiceEngines belonging to the availability zone will be rebooted during a manual DR failover.
   * @return nodeAvailabilityZoneLabel
  **/
  @Schema(description = "Mesos Node label to be used as Mesos Node's availability zone in a dual availability zone deployment. ServiceEngines belonging to the availability zone will be rebooted during a manual DR failover.")
  public String getNodeAvailabilityZoneLabel() {
    return nodeAvailabilityZoneLabel;
  }

  public void setNodeAvailabilityZoneLabel(String nodeAvailabilityZoneLabel) {
    this.nodeAvailabilityZoneLabel = nodeAvailabilityZoneLabel;
  }

  public MesosConfiguration nuageController(NuageSDNController nuageController) {
    this.nuageController = nuageController;
    return this;
  }

   /**
   * Get nuageController
   * @return nuageController
  **/
  @Schema(description = "")
  public NuageSDNController getNuageController() {
    return nuageController;
  }

  public void setNuageController(NuageSDNController nuageController) {
    this.nuageController = nuageController;
  }

  public MesosConfiguration seDeploymentMethod(String seDeploymentMethod) {
    this.seDeploymentMethod = seDeploymentMethod;
    return this;
  }

   /**
   * Use Fleet/SSH for deploying Service Engines. Enum options - MESOS_SE_CREATE_FLEET, MESOS_SE_CREATE_SSH, MESOS_SE_CREATE_MARATHON.
   * @return seDeploymentMethod
  **/
  @Schema(description = "Use Fleet/SSH for deploying Service Engines. Enum options - MESOS_SE_CREATE_FLEET, MESOS_SE_CREATE_SSH, MESOS_SE_CREATE_MARATHON.")
  public String getSeDeploymentMethod() {
    return seDeploymentMethod;
  }

  public void setSeDeploymentMethod(String seDeploymentMethod) {
    this.seDeploymentMethod = seDeploymentMethod;
  }

  public MesosConfiguration seExcludeAttributes(List<MesosAttribute> seExcludeAttributes) {
    this.seExcludeAttributes = seExcludeAttributes;
    return this;
  }

  public MesosConfiguration addSeExcludeAttributesItem(MesosAttribute seExcludeAttributesItem) {
    if (this.seExcludeAttributes == null) {
      this.seExcludeAttributes = new ArrayList<MesosAttribute>();
    }
    this.seExcludeAttributes.add(seExcludeAttributesItem);
    return this;
  }

   /**
   * Exclude hosts with attributes for SE creation.
   * @return seExcludeAttributes
  **/
  @Schema(description = "Exclude hosts with attributes for SE creation.")
  public List<MesosAttribute> getSeExcludeAttributes() {
    return seExcludeAttributes;
  }

  public void setSeExcludeAttributes(List<MesosAttribute> seExcludeAttributes) {
    this.seExcludeAttributes = seExcludeAttributes;
  }

  public MesosConfiguration seIncludeAttributes(List<MesosAttribute> seIncludeAttributes) {
    this.seIncludeAttributes = seIncludeAttributes;
    return this;
  }

  public MesosConfiguration addSeIncludeAttributesItem(MesosAttribute seIncludeAttributesItem) {
    if (this.seIncludeAttributes == null) {
      this.seIncludeAttributes = new ArrayList<MesosAttribute>();
    }
    this.seIncludeAttributes.add(seIncludeAttributesItem);
    return this;
  }

   /**
   * Create SEs just on hosts with include attributes.
   * @return seIncludeAttributes
  **/
  @Schema(description = "Create SEs just on hosts with include attributes.")
  public List<MesosAttribute> getSeIncludeAttributes() {
    return seIncludeAttributes;
  }

  public void setSeIncludeAttributes(List<MesosAttribute> seIncludeAttributes) {
    this.seIncludeAttributes = seIncludeAttributes;
  }

  public MesosConfiguration seResources(List<MesosSeResources> seResources) {
    this.seResources = seResources;
    return this;
  }

  public MesosConfiguration addSeResourcesItem(MesosSeResources seResourcesItem) {
    if (this.seResources == null) {
      this.seResources = new ArrayList<MesosSeResources>();
    }
    this.seResources.add(seResourcesItem);
    return this;
  }

   /**
   * Obsolete - ignored.
   * @return seResources
  **/
  @Schema(description = "Obsolete - ignored.")
  public List<MesosSeResources> getSeResources() {
    return seResources;
  }

  public void setSeResources(List<MesosSeResources> seResources) {
    this.seResources = seResources;
  }

  public MesosConfiguration seSpawnRate(Integer seSpawnRate) {
    this.seSpawnRate = seSpawnRate;
    return this;
  }

   /**
   * New SE spawn rate per minute.
   * @return seSpawnRate
  **/
  @Schema(description = "New SE spawn rate per minute.")
  public Integer getSeSpawnRate() {
    return seSpawnRate;
  }

  public void setSeSpawnRate(Integer seSpawnRate) {
    this.seSpawnRate = seSpawnRate;
  }

  public MesosConfiguration seVolume(String seVolume) {
    this.seVolume = seVolume;
    return this;
  }

   /**
   * Host volume to be used as a disk for Avi SE, This is a disruptive change.
   * @return seVolume
  **/
  @Schema(description = "Host volume to be used as a disk for Avi SE, This is a disruptive change.")
  public String getSeVolume() {
    return seVolume;
  }

  public void setSeVolume(String seVolume) {
    this.seVolume = seVolume;
  }

  public MesosConfiguration servicesAccessibleAllInterfaces(Boolean servicesAccessibleAllInterfaces) {
    this.servicesAccessibleAllInterfaces = servicesAccessibleAllInterfaces;
    return this;
  }

   /**
   * Make service ports accessible on all Host interfaces in addition to East-West VIP and/or bridge IP. Usually enabled AWS Mesos clusters to export East-West services on Host interface.
   * @return servicesAccessibleAllInterfaces
  **/
  @Schema(description = "Make service ports accessible on all Host interfaces in addition to East-West VIP and/or bridge IP. Usually enabled AWS Mesos clusters to export East-West services on Host interface.")
  public Boolean isServicesAccessibleAllInterfaces() {
    return servicesAccessibleAllInterfaces;
  }

  public void setServicesAccessibleAllInterfaces(Boolean servicesAccessibleAllInterfaces) {
    this.servicesAccessibleAllInterfaces = servicesAccessibleAllInterfaces;
  }

  public MesosConfiguration sshSeDeployment(SSHSeDeployment sshSeDeployment) {
    this.sshSeDeployment = sshSeDeployment;
    return this;
  }

   /**
   * Get sshSeDeployment
   * @return sshSeDeployment
  **/
  @Schema(description = "")
  public SSHSeDeployment getSshSeDeployment() {
    return sshSeDeployment;
  }

  public void setSshSeDeployment(SSHSeDeployment sshSeDeployment) {
    this.sshSeDeployment = sshSeDeployment;
  }

  public MesosConfiguration sshUserRef(String sshUserRef) {
    this.sshUserRef = sshUserRef;
    return this;
  }

   /**
   * Cloud connector user uuid for SSH to hosts. It is a reference to an object of type CloudConnectorUser. Field introduced in 17.1.1.
   * @return sshUserRef
  **/
  @Schema(description = "Cloud connector user uuid for SSH to hosts. It is a reference to an object of type CloudConnectorUser. Field introduced in 17.1.1.")
  public String getSshUserRef() {
    return sshUserRef;
  }

  public void setSshUserRef(String sshUserRef) {
    this.sshUserRef = sshUserRef;
  }

  public MesosConfiguration useBridgeIpAsVip(Boolean useBridgeIpAsVip) {
    this.useBridgeIpAsVip = useBridgeIpAsVip;
    return this;
  }

   /**
   * Use Bridge IP on each Host as VIP.
   * @return useBridgeIpAsVip
  **/
  @Schema(description = "Use Bridge IP on each Host as VIP.")
  public Boolean isUseBridgeIpAsVip() {
    return useBridgeIpAsVip;
  }

  public void setUseBridgeIpAsVip(Boolean useBridgeIpAsVip) {
    this.useBridgeIpAsVip = useBridgeIpAsVip;
  }

  public MesosConfiguration useContainerIpPort(Boolean useContainerIpPort) {
    this.useContainerIpPort = useContainerIpPort;
    return this;
  }

   /**
   * Use container IP address port for pool instead of host IP address hostport. This mode is applicable if the container IP is reachable (not a private NATed IP) from other hosts in a routed environment for containers.
   * @return useContainerIpPort
  **/
  @Schema(description = "Use container IP address port for pool instead of host IP address hostport. This mode is applicable if the container IP is reachable (not a private NATed IP) from other hosts in a routed environment for containers.")
  public Boolean isUseContainerIpPort() {
    return useContainerIpPort;
  }

  public void setUseContainerIpPort(Boolean useContainerIpPort) {
    this.useContainerIpPort = useContainerIpPort;
  }

  public MesosConfiguration useControllerImage(Boolean useControllerImage) {
    this.useControllerImage = useControllerImage;
    return this;
  }

   /**
   * If true, use controller generated SE docker image via fileservice, else use docker repository image as defined by docker_registry_se.
   * @return useControllerImage
  **/
  @Schema(description = "If true, use controller generated SE docker image via fileservice, else use docker repository image as defined by docker_registry_se.")
  public Boolean isUseControllerImage() {
    return useControllerImage;
  }

  public void setUseControllerImage(Boolean useControllerImage) {
    this.useControllerImage = useControllerImage;
  }

  public MesosConfiguration useVipsForEastWestServices(Boolean useVipsForEastWestServices) {
    this.useVipsForEastWestServices = useVipsForEastWestServices;
    return this;
  }

   /**
   * Use unique virtual IP address for every east west service in Mesos/Marathon. &#x27;use_bridge_ip_as_vip&#x27; and &#x27;vip&#x27; fields , if set, will not be used if this field is set.
   * @return useVipsForEastWestServices
  **/
  @Schema(description = "Use unique virtual IP address for every east west service in Mesos/Marathon. 'use_bridge_ip_as_vip' and 'vip' fields , if set, will not be used if this field is set.")
  public Boolean isUseVipsForEastWestServices() {
    return useVipsForEastWestServices;
  }

  public void setUseVipsForEastWestServices(Boolean useVipsForEastWestServices) {
    this.useVipsForEastWestServices = useVipsForEastWestServices;
  }

  public MesosConfiguration vip(IpAddr vip) {
    this.vip = vip;
    return this;
  }

   /**
   * Get vip
   * @return vip
  **/
  @Schema(description = "")
  public IpAddr getVip() {
    return vip;
  }

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
    MesosConfiguration mesosConfiguration = (MesosConfiguration) o;
    return Objects.equals(this.allVsesAreFeproxy, mesosConfiguration.allVsesAreFeproxy) &&
        Objects.equals(this.appSyncFrequency, mesosConfiguration.appSyncFrequency) &&
        Objects.equals(this.containerPortMatchHttpService, mesosConfiguration.containerPortMatchHttpService) &&
        Objects.equals(this.coredumpDirectory, mesosConfiguration.coredumpDirectory) &&
        Objects.equals(this.disableAutoBackendServiceSync, mesosConfiguration.disableAutoBackendServiceSync) &&
        Objects.equals(this.disableAutoFrontendServiceSync, mesosConfiguration.disableAutoFrontendServiceSync) &&
        Objects.equals(this.disableAutoGsSync, mesosConfiguration.disableAutoGsSync) &&
        Objects.equals(this.disableAutoSeCreation, mesosConfiguration.disableAutoSeCreation) &&
        Objects.equals(this.dockerRegistrySe, mesosConfiguration.dockerRegistrySe) &&
        Objects.equals(this.eastWestPlacementSubnet, mesosConfiguration.eastWestPlacementSubnet) &&
        Objects.equals(this.enableEventSubscription, mesosConfiguration.enableEventSubscription) &&
        Objects.equals(this.feproxyBridgeName, mesosConfiguration.feproxyBridgeName) &&
        Objects.equals(this.feproxyContainerPortAsService, mesosConfiguration.feproxyContainerPortAsService) &&
        Objects.equals(this.feproxyRoutePublish, mesosConfiguration.feproxyRoutePublish) &&
        Objects.equals(this.feproxyVipsEnableProxyArp, mesosConfiguration.feproxyVipsEnableProxyArp) &&
        Objects.equals(this.fleetEndpoint, mesosConfiguration.fleetEndpoint) &&
        Objects.equals(this.httpContainerPorts, mesosConfiguration.httpContainerPorts) &&
        Objects.equals(this.marathonConfigurations, mesosConfiguration.marathonConfigurations) &&
        Objects.equals(this.marathonSeDeployment, mesosConfiguration.marathonSeDeployment) &&
        Objects.equals(this.mesosUrl, mesosConfiguration.mesosUrl) &&
        Objects.equals(this.nodeAvailabilityZoneLabel, mesosConfiguration.nodeAvailabilityZoneLabel) &&
        Objects.equals(this.nuageController, mesosConfiguration.nuageController) &&
        Objects.equals(this.seDeploymentMethod, mesosConfiguration.seDeploymentMethod) &&
        Objects.equals(this.seExcludeAttributes, mesosConfiguration.seExcludeAttributes) &&
        Objects.equals(this.seIncludeAttributes, mesosConfiguration.seIncludeAttributes) &&
        Objects.equals(this.seResources, mesosConfiguration.seResources) &&
        Objects.equals(this.seSpawnRate, mesosConfiguration.seSpawnRate) &&
        Objects.equals(this.seVolume, mesosConfiguration.seVolume) &&
        Objects.equals(this.servicesAccessibleAllInterfaces, mesosConfiguration.servicesAccessibleAllInterfaces) &&
        Objects.equals(this.sshSeDeployment, mesosConfiguration.sshSeDeployment) &&
        Objects.equals(this.sshUserRef, mesosConfiguration.sshUserRef) &&
        Objects.equals(this.useBridgeIpAsVip, mesosConfiguration.useBridgeIpAsVip) &&
        Objects.equals(this.useContainerIpPort, mesosConfiguration.useContainerIpPort) &&
        Objects.equals(this.useControllerImage, mesosConfiguration.useControllerImage) &&
        Objects.equals(this.useVipsForEastWestServices, mesosConfiguration.useVipsForEastWestServices) &&
        Objects.equals(this.vip, mesosConfiguration.vip);
  }

  @Override
  public int hashCode() {
    return Objects.hash(allVsesAreFeproxy, appSyncFrequency, containerPortMatchHttpService, coredumpDirectory, disableAutoBackendServiceSync, disableAutoFrontendServiceSync, disableAutoGsSync, disableAutoSeCreation, dockerRegistrySe, eastWestPlacementSubnet, enableEventSubscription, feproxyBridgeName, feproxyContainerPortAsService, feproxyRoutePublish, feproxyVipsEnableProxyArp, fleetEndpoint, httpContainerPorts, marathonConfigurations, marathonSeDeployment, mesosUrl, nodeAvailabilityZoneLabel, nuageController, seDeploymentMethod, seExcludeAttributes, seIncludeAttributes, seResources, seSpawnRate, seVolume, servicesAccessibleAllInterfaces, sshSeDeployment, sshUserRef, useBridgeIpAsVip, useContainerIpPort, useControllerImage, useVipsForEastWestServices, vip);
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