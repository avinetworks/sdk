package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DockerConfiguration is a POJO class extends AviRestResource that used for creating
 * DockerConfiguration.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DockerConfiguration  {
    @JsonProperty("app_sync_frequency")
    private Integer appSyncFrequency = 60;

    @JsonProperty("ca_tls_key_and_certificate_ref")
    private String caTlsKeyAndCertificateRef = null;

    @JsonProperty("client_tls_key_and_certificate_ref")
    private String clientTlsKeyAndCertificateRef = null;

    @JsonProperty("container_port_match_http_service")
    private Boolean containerPortMatchHttpService = true;

    @JsonProperty("coredump_directory")
    private String coredumpDirectory = "/var/lib/systemd/coredump";

    @JsonProperty("disable_auto_backend_service_sync")
    private Boolean disableAutoBackendServiceSync = false;

    @JsonProperty("disable_auto_frontend_service_sync")
    private Boolean disableAutoFrontendServiceSync = false;

    @JsonProperty("disable_auto_se_creation")
    private Boolean disableAutoSeCreation = false;

    @JsonProperty("docker_registry_se")
    private DockerRegistry dockerRegistrySe = null;

    @JsonProperty("east_west_placement_subnet")
    private IpAddrPrefix eastWestPlacementSubnet = null;

    @JsonProperty("enable_event_subscription")
    private Boolean enableEventSubscription = true;

    @JsonProperty("feproxy_container_port_as_service")
    private Boolean feproxyContainerPortAsService = false;

    @JsonProperty("feproxy_vips_enable_proxy_arp")
    private Boolean feproxyVipsEnableProxyArp = true;

    @JsonProperty("fleet_endpoint")
    private String fleetEndpoint = null;

    @JsonProperty("http_container_ports")
    private List<Integer> httpContainerPorts = null;

    @JsonProperty("se_deployment_method")
    private String seDeploymentMethod = "SE_CREATE_SSH";

    @JsonProperty("se_exclude_attributes")
    private List<MesosAttribute> seExcludeAttributes = null;

    @JsonProperty("se_include_attributes")
    private List<MesosAttribute> seIncludeAttributes = null;

    @JsonProperty("se_spawn_rate")
    private Integer seSpawnRate = 25;

    @JsonProperty("se_volume")
    private String seVolume = "/opt/avi";

    @JsonProperty("services_accessible_all_interfaces")
    private Boolean servicesAccessibleAllInterfaces = false;

    @JsonProperty("ssh_se_deployment")
    private SSHSeDeployment sshSeDeployment = null;

    @JsonProperty("ssh_user_ref")
    private String sshUserRef = null;

    @JsonProperty("ucp_nodes")
    private List<String> ucpNodes = null;

    @JsonProperty("use_container_ip_port")
    private Boolean useContainerIpPort = false;

    @JsonProperty("use_controller_image")
    private Boolean useControllerImage = false;



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
   * Uuid of the client tls cert and key.
   * It is a reference to an object of type sslkeyandcertificate.
   * @return clientTlsKeyAndCertificateRef
   */
  public String getClientTlsKeyAndCertificateRef() {
    return clientTlsKeyAndCertificateRef;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the client tls cert and key.
   * It is a reference to an object of type sslkeyandcertificate.
   * @param clientTlsKeyAndCertificateRef set the clientTlsKeyAndCertificateRef.
   */
  public void setClientTlsKeyAndCertificateRef(String  clientTlsKeyAndCertificateRef) {
    this.clientTlsKeyAndCertificateRef = clientTlsKeyAndCertificateRef;
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
   * Enable docker event subscription.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return enableEventSubscription
   */
  public Boolean getEnableEventSubscription() {
    return enableEventSubscription;
  }

  /**
   * This is the setter method to the attribute.
   * Enable docker event subscription.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param enableEventSubscription set the enableEventSubscription.
   */
  public void setEnableEventSubscription(Boolean  enableEventSubscription) {
    this.enableEventSubscription = enableEventSubscription;
  }

  /**
   * This is the getter method this will return the attribute value.
   * For front end proxies, use container port as service port.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return feproxyContainerPortAsService
   */
  public Boolean getFeproxyContainerPortAsService() {
    return feproxyContainerPortAsService;
  }

  /**
   * This is the setter method to the attribute.
   * For front end proxies, use container port as service port.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param feproxyContainerPortAsService set the feproxyContainerPortAsService.
   */
  public void setFeproxyContainerPortAsService(Boolean  feproxyContainerPortAsService) {
    this.feproxyContainerPortAsService = feproxyContainerPortAsService;
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
  public DockerConfiguration addHttpContainerPortsItem(Integer httpContainerPortsItem) {
    if (this.httpContainerPorts == null) {
      this.httpContainerPorts = new ArrayList<Integer>();
    }
    this.httpContainerPorts.add(httpContainerPortsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Use fleet/ssh for se deployment.
   * Enum options - SE_CREATE_FLEET, SE_CREATE_SSH, SE_CREATE_POD.
   * Default value when not specified in API or module is interpreted by Avi Controller as SE_CREATE_SSH.
   * @return seDeploymentMethod
   */
  public String getSeDeploymentMethod() {
    return seDeploymentMethod;
  }

  /**
   * This is the setter method to the attribute.
   * Use fleet/ssh for se deployment.
   * Enum options - SE_CREATE_FLEET, SE_CREATE_SSH, SE_CREATE_POD.
   * Default value when not specified in API or module is interpreted by Avi Controller as SE_CREATE_SSH.
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
  public DockerConfiguration addSeExcludeAttributesItem(MesosAttribute seExcludeAttributesItem) {
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
  public DockerConfiguration addSeIncludeAttributesItem(MesosAttribute seIncludeAttributesItem) {
    if (this.seIncludeAttributes == null) {
      this.seIncludeAttributes = new ArrayList<MesosAttribute>();
    }
    this.seIncludeAttributes.add(seIncludeAttributesItem);
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
   * Default value when not specified in API or module is interpreted by Avi Controller as /opt/avi.
   * @return seVolume
   */
  public String getSeVolume() {
    return seVolume;
  }

  /**
   * This is the setter method to the attribute.
   * Host volume to be used as a disk for avi se, this is a disruptive change.
   * Default value when not specified in API or module is interpreted by Avi Controller as /opt/avi.
   * @param seVolume set the seVolume.
   */
  public void setSeVolume(String  seVolume) {
    this.seVolume = seVolume;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Make service ports accessible on all host interfaces in addition to east-west vip and/or bridge ip.
   * Usually enabled aws clusters to export east-west services on host interface.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return servicesAccessibleAllInterfaces
   */
  public Boolean getServicesAccessibleAllInterfaces() {
    return servicesAccessibleAllInterfaces;
  }

  /**
   * This is the setter method to the attribute.
   * Make service ports accessible on all host interfaces in addition to east-west vip and/or bridge ip.
   * Usually enabled aws clusters to export east-west services on host interface.
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
   * List of docker ucp nodes; in case of a load balanced ucp cluster, use virtual ip of the cluster.
   * @return ucpNodes
   */
  public List<String> getUcpNodes() {
    return ucpNodes;
  }

  /**
   * This is the setter method. this will set the ucpNodes
   * List of docker ucp nodes; in case of a load balanced ucp cluster, use virtual ip of the cluster.
   * @return ucpNodes
   */
  public void setUcpNodes(List<String>  ucpNodes) {
    this.ucpNodes = ucpNodes;
  }

  /**
   * This is the setter method this will set the ucpNodes
   * List of docker ucp nodes; in case of a load balanced ucp cluster, use virtual ip of the cluster.
   * @return ucpNodes
   */
  public DockerConfiguration addUcpNodesItem(String ucpNodesItem) {
    if (this.ucpNodes == null) {
      this.ucpNodes = new ArrayList<String>();
    }
    this.ucpNodes.add(ucpNodesItem);
    return this;
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


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  DockerConfiguration objDockerConfiguration = (DockerConfiguration) o;
  return   Objects.equals(this.ucpNodes, objDockerConfiguration.ucpNodes)&&
  Objects.equals(this.clientTlsKeyAndCertificateRef, objDockerConfiguration.clientTlsKeyAndCertificateRef)&&
  Objects.equals(this.caTlsKeyAndCertificateRef, objDockerConfiguration.caTlsKeyAndCertificateRef)&&
  Objects.equals(this.containerPortMatchHttpService, objDockerConfiguration.containerPortMatchHttpService)&&
  Objects.equals(this.httpContainerPorts, objDockerConfiguration.httpContainerPorts)&&
  Objects.equals(this.eastWestPlacementSubnet, objDockerConfiguration.eastWestPlacementSubnet)&&
  Objects.equals(this.seDeploymentMethod, objDockerConfiguration.seDeploymentMethod)&&
  Objects.equals(this.fleetEndpoint, objDockerConfiguration.fleetEndpoint)&&
  Objects.equals(this.dockerRegistrySe, objDockerConfiguration.dockerRegistrySe)&&
  Objects.equals(this.seSpawnRate, objDockerConfiguration.seSpawnRate)&&
  Objects.equals(this.appSyncFrequency, objDockerConfiguration.appSyncFrequency)&&
  Objects.equals(this.disableAutoSeCreation, objDockerConfiguration.disableAutoSeCreation)&&
  Objects.equals(this.disableAutoFrontendServiceSync, objDockerConfiguration.disableAutoFrontendServiceSync)&&
  Objects.equals(this.disableAutoBackendServiceSync, objDockerConfiguration.disableAutoBackendServiceSync)&&
  Objects.equals(this.useContainerIpPort, objDockerConfiguration.useContainerIpPort)&&
  Objects.equals(this.seVolume, objDockerConfiguration.seVolume)&&
  Objects.equals(this.coredumpDirectory, objDockerConfiguration.coredumpDirectory)&&
  Objects.equals(this.sshSeDeployment, objDockerConfiguration.sshSeDeployment)&&
  Objects.equals(this.enableEventSubscription, objDockerConfiguration.enableEventSubscription)&&
  Objects.equals(this.feproxyContainerPortAsService, objDockerConfiguration.feproxyContainerPortAsService)&&
  Objects.equals(this.servicesAccessibleAllInterfaces, objDockerConfiguration.servicesAccessibleAllInterfaces)&&
  Objects.equals(this.feproxyVipsEnableProxyArp, objDockerConfiguration.feproxyVipsEnableProxyArp)&&
  Objects.equals(this.seExcludeAttributes, objDockerConfiguration.seExcludeAttributes)&&
  Objects.equals(this.seIncludeAttributes, objDockerConfiguration.seIncludeAttributes)&&
  Objects.equals(this.useControllerImage, objDockerConfiguration.useControllerImage)&&
  Objects.equals(this.sshUserRef, objDockerConfiguration.sshUserRef);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DockerConfiguration {\n");
      sb.append("    appSyncFrequency: ").append(toIndentedString(appSyncFrequency)).append("\n");
        sb.append("    caTlsKeyAndCertificateRef: ").append(toIndentedString(caTlsKeyAndCertificateRef)).append("\n");
        sb.append("    clientTlsKeyAndCertificateRef: ").append(toIndentedString(clientTlsKeyAndCertificateRef)).append("\n");
        sb.append("    containerPortMatchHttpService: ").append(toIndentedString(containerPortMatchHttpService)).append("\n");
        sb.append("    coredumpDirectory: ").append(toIndentedString(coredumpDirectory)).append("\n");
        sb.append("    disableAutoBackendServiceSync: ").append(toIndentedString(disableAutoBackendServiceSync)).append("\n");
        sb.append("    disableAutoFrontendServiceSync: ").append(toIndentedString(disableAutoFrontendServiceSync)).append("\n");
        sb.append("    disableAutoSeCreation: ").append(toIndentedString(disableAutoSeCreation)).append("\n");
        sb.append("    dockerRegistrySe: ").append(toIndentedString(dockerRegistrySe)).append("\n");
        sb.append("    eastWestPlacementSubnet: ").append(toIndentedString(eastWestPlacementSubnet)).append("\n");
        sb.append("    enableEventSubscription: ").append(toIndentedString(enableEventSubscription)).append("\n");
        sb.append("    feproxyContainerPortAsService: ").append(toIndentedString(feproxyContainerPortAsService)).append("\n");
        sb.append("    feproxyVipsEnableProxyArp: ").append(toIndentedString(feproxyVipsEnableProxyArp)).append("\n");
        sb.append("    fleetEndpoint: ").append(toIndentedString(fleetEndpoint)).append("\n");
        sb.append("    httpContainerPorts: ").append(toIndentedString(httpContainerPorts)).append("\n");
        sb.append("    seDeploymentMethod: ").append(toIndentedString(seDeploymentMethod)).append("\n");
        sb.append("    seExcludeAttributes: ").append(toIndentedString(seExcludeAttributes)).append("\n");
        sb.append("    seIncludeAttributes: ").append(toIndentedString(seIncludeAttributes)).append("\n");
        sb.append("    seSpawnRate: ").append(toIndentedString(seSpawnRate)).append("\n");
        sb.append("    seVolume: ").append(toIndentedString(seVolume)).append("\n");
        sb.append("    servicesAccessibleAllInterfaces: ").append(toIndentedString(servicesAccessibleAllInterfaces)).append("\n");
        sb.append("    sshSeDeployment: ").append(toIndentedString(sshSeDeployment)).append("\n");
        sb.append("    sshUserRef: ").append(toIndentedString(sshUserRef)).append("\n");
        sb.append("    ucpNodes: ").append(toIndentedString(ucpNodes)).append("\n");
        sb.append("    useContainerIpPort: ").append(toIndentedString(useContainerIpPort)).append("\n");
        sb.append("    useControllerImage: ").append(toIndentedString(useControllerImage)).append("\n");
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

