package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Cloud is a POJO class extends AviRestResource that used for creating
 * Cloud.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cloud extends AviRestResource  {
    @JsonProperty("apic_configuration")
    private APICConfiguration apicConfiguration = null;

    @JsonProperty("apic_mode")
    private Boolean apicMode = false;

    @JsonProperty("autoscale_polling_interval")
    private Integer autoscalePollingInterval = 60;

    @JsonProperty("aws_configuration")
    private AwsConfiguration awsConfiguration = null;

    @JsonProperty("azure_configuration")
    private AzureConfiguration azureConfiguration = null;

    @JsonProperty("cloudstack_configuration")
    private CloudStackConfiguration cloudstackConfiguration = null;

    @JsonProperty("custom_tags")
    private List<CustomTag> customTags = null;

    @JsonProperty("dhcp_enabled")
    private Boolean dhcpEnabled = false;

    @JsonProperty("dns_provider_ref")
    private String dnsProviderRef = null;

    @JsonProperty("dns_resolution_on_se")
    private Boolean dnsResolutionOnSe = false;

    @JsonProperty("docker_configuration")
    private DockerConfiguration dockerConfiguration = null;

    @JsonProperty("east_west_dns_provider_ref")
    private String eastWestDnsProviderRef = null;

    @JsonProperty("east_west_ipam_provider_ref")
    private String eastWestIpamProviderRef = null;

    @JsonProperty("enable_vip_on_all_interfaces")
    private Boolean enableVipOnAllInterfaces = false;

    @JsonProperty("enable_vip_static_routes")
    private Boolean enableVipStaticRoutes = false;

    @JsonProperty("gcp_configuration")
    private GCPConfiguration gcpConfiguration = null;

    @JsonProperty("ip6_autocfg_enabled")
    private Boolean ip6AutocfgEnabled = false;

    @JsonProperty("ipam_provider_ref")
    private String ipamProviderRef = null;

    @JsonProperty("license_tier")
    private String licenseTier = null;

    @JsonProperty("license_type")
    private String licenseType = null;

    @JsonProperty("linuxserver_configuration")
    private LinuxServerConfiguration linuxserverConfiguration = null;

    @JsonProperty("mesos_configuration")
    private MesosConfiguration mesosConfiguration = null;

    @JsonProperty("mtu")
    private Integer mtu = 1500;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("nsx_configuration")
    private NsxConfiguration nsxConfiguration = null;

    @JsonProperty("nsxt_configuration")
    private NsxtConfiguration nsxtConfiguration = null;

    @JsonProperty("obj_name_prefix")
    private String objNamePrefix = null;

    @JsonProperty("openstack_configuration")
    private OpenStackConfiguration openstackConfiguration = null;

    @JsonProperty("oshiftk8s_configuration")
    private OShiftK8SConfiguration oshiftk8sConfiguration = null;

    @JsonProperty("prefer_static_routes")
    private Boolean preferStaticRoutes = false;

    @JsonProperty("proxy_configuration")
    private ProxyConfiguration proxyConfiguration = null;

    @JsonProperty("rancher_configuration")
    private RancherConfiguration rancherConfiguration = null;

    @JsonProperty("se_group_template_ref")
    private String seGroupTemplateRef = null;

    @JsonProperty("state_based_dns_registration")
    private Boolean stateBasedDnsRegistration = true;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;

    @JsonProperty("vca_configuration")
    private vCloudAirConfiguration vcaConfiguration = null;

    @JsonProperty("vcenter_configuration")
    private vCenterConfiguration vcenterConfiguration = null;

    @JsonProperty("vtype")
    private String vtype = "CLOUD_NONE";



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property apic_configuration of obj type cloud field type str  type ref.
   * @return apicConfiguration
   */
  public APICConfiguration getApicConfiguration() {
    return apicConfiguration;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property apic_configuration of obj type cloud field type str  type ref.
   * @param apicConfiguration set the apicConfiguration.
   */
  public void setApicConfiguration(APICConfiguration apicConfiguration) {
    this.apicConfiguration = apicConfiguration;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property apic_mode of obj type cloud field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return apicMode
   */
  public Boolean getApicMode() {
    return apicMode;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property apic_mode of obj type cloud field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param apicMode set the apicMode.
   */
  public void setApicMode(Boolean  apicMode) {
    this.apicMode = apicMode;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Cloudconnector polling interval in seconds for external autoscale groups, minimum 60 seconds.
   * Allowed values are 60-3600.
   * Field introduced in 18.2.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @return autoscalePollingInterval
   */
  public Integer getAutoscalePollingInterval() {
    return autoscalePollingInterval;
  }

  /**
   * This is the setter method to the attribute.
   * Cloudconnector polling interval in seconds for external autoscale groups, minimum 60 seconds.
   * Allowed values are 60-3600.
   * Field introduced in 18.2.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @param autoscalePollingInterval set the autoscalePollingInterval.
   */
  public void setAutoscalePollingInterval(Integer  autoscalePollingInterval) {
    this.autoscalePollingInterval = autoscalePollingInterval;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property aws_configuration of obj type cloud field type str  type ref.
   * @return awsConfiguration
   */
  public AwsConfiguration getAwsConfiguration() {
    return awsConfiguration;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property aws_configuration of obj type cloud field type str  type ref.
   * @param awsConfiguration set the awsConfiguration.
   */
  public void setAwsConfiguration(AwsConfiguration awsConfiguration) {
    this.awsConfiguration = awsConfiguration;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.2.1.
   * @return azureConfiguration
   */
  public AzureConfiguration getAzureConfiguration() {
    return azureConfiguration;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.2.1.
   * @param azureConfiguration set the azureConfiguration.
   */
  public void setAzureConfiguration(AzureConfiguration azureConfiguration) {
    this.azureConfiguration = azureConfiguration;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cloudstack_configuration of obj type cloud field type str  type ref.
   * @return cloudstackConfiguration
   */
  public CloudStackConfiguration getCloudstackConfiguration() {
    return cloudstackConfiguration;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cloudstack_configuration of obj type cloud field type str  type ref.
   * @param cloudstackConfiguration set the cloudstackConfiguration.
   */
  public void setCloudstackConfiguration(CloudStackConfiguration cloudstackConfiguration) {
    this.cloudstackConfiguration = cloudstackConfiguration;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Custom tags for all avi created resources in the cloud infrastructure.
   * Field introduced in 17.1.5.
   * @return customTags
   */
  public List<CustomTag> getCustomTags() {
    return customTags;
  }

  /**
   * This is the setter method. this will set the customTags
   * Custom tags for all avi created resources in the cloud infrastructure.
   * Field introduced in 17.1.5.
   * @return customTags
   */
  public void setCustomTags(List<CustomTag>  customTags) {
    this.customTags = customTags;
  }

  /**
   * This is the setter method this will set the customTags
   * Custom tags for all avi created resources in the cloud infrastructure.
   * Field introduced in 17.1.5.
   * @return customTags
   */
  public Cloud addCustomTagsItem(CustomTag customTagsItem) {
    if (this.customTags == null) {
      this.customTags = new ArrayList<CustomTag>();
    }
    this.customTags.add(customTagsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Select the ip address management scheme.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return dhcpEnabled
   */
  public Boolean getDhcpEnabled() {
    return dhcpEnabled;
  }

  /**
   * This is the setter method to the attribute.
   * Select the ip address management scheme.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param dhcpEnabled set the dhcpEnabled.
   */
  public void setDhcpEnabled(Boolean  dhcpEnabled) {
    this.dhcpEnabled = dhcpEnabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dns profile for the cloud.
   * It is a reference to an object of type ipamdnsproviderprofile.
   * @return dnsProviderRef
   */
  public String getDnsProviderRef() {
    return dnsProviderRef;
  }

  /**
   * This is the setter method to the attribute.
   * Dns profile for the cloud.
   * It is a reference to an object of type ipamdnsproviderprofile.
   * @param dnsProviderRef set the dnsProviderRef.
   */
  public void setDnsProviderRef(String  dnsProviderRef) {
    this.dnsProviderRef = dnsProviderRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * By default, pool member fqdns are resolved on the controller.
   * When this is set, pool member fqdns are instead resolved on service engines in this cloud.
   * This is useful in scenarios where pool member fqdns can only be resolved from service engines and not from the controller.
   * Field introduced in 18.2.6.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return dnsResolutionOnSe
   */
  public Boolean getDnsResolutionOnSe() {
    return dnsResolutionOnSe;
  }

  /**
   * This is the setter method to the attribute.
   * By default, pool member fqdns are resolved on the controller.
   * When this is set, pool member fqdns are instead resolved on service engines in this cloud.
   * This is useful in scenarios where pool member fqdns can only be resolved from service engines and not from the controller.
   * Field introduced in 18.2.6.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param dnsResolutionOnSe set the dnsResolutionOnSe.
   */
  public void setDnsResolutionOnSe(Boolean  dnsResolutionOnSe) {
    this.dnsResolutionOnSe = dnsResolutionOnSe;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property docker_configuration of obj type cloud field type str  type ref.
   * @return dockerConfiguration
   */
  public DockerConfiguration getDockerConfiguration() {
    return dockerConfiguration;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property docker_configuration of obj type cloud field type str  type ref.
   * @param dockerConfiguration set the dockerConfiguration.
   */
  public void setDockerConfiguration(DockerConfiguration dockerConfiguration) {
    this.dockerConfiguration = dockerConfiguration;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dns profile for east-west services.
   * It is a reference to an object of type ipamdnsproviderprofile.
   * @return eastWestDnsProviderRef
   */
  public String getEastWestDnsProviderRef() {
    return eastWestDnsProviderRef;
  }

  /**
   * This is the setter method to the attribute.
   * Dns profile for east-west services.
   * It is a reference to an object of type ipamdnsproviderprofile.
   * @param eastWestDnsProviderRef set the eastWestDnsProviderRef.
   */
  public void setEastWestDnsProviderRef(String  eastWestDnsProviderRef) {
    this.eastWestDnsProviderRef = eastWestDnsProviderRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ipam profile for east-west services.
   * Warning - please use virtual subnets in this ipam profile that do not conflict with the underlay networks or any overlay networks in the cluster.
   * For example in aws and gcp, 169.254.0.0/16 is used for storing instance metadata.
   * Hence, it should not be used in this profile.
   * It is a reference to an object of type ipamdnsproviderprofile.
   * @return eastWestIpamProviderRef
   */
  public String getEastWestIpamProviderRef() {
    return eastWestIpamProviderRef;
  }

  /**
   * This is the setter method to the attribute.
   * Ipam profile for east-west services.
   * Warning - please use virtual subnets in this ipam profile that do not conflict with the underlay networks or any overlay networks in the cluster.
   * For example in aws and gcp, 169.254.0.0/16 is used for storing instance metadata.
   * Hence, it should not be used in this profile.
   * It is a reference to an object of type ipamdnsproviderprofile.
   * @param eastWestIpamProviderRef set the eastWestIpamProviderRef.
   */
  public void setEastWestIpamProviderRef(String  eastWestIpamProviderRef) {
    this.eastWestIpamProviderRef = eastWestIpamProviderRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable vip on all data interfaces for the cloud.
   * Field introduced in 18.2.9, 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return enableVipOnAllInterfaces
   */
  public Boolean getEnableVipOnAllInterfaces() {
    return enableVipOnAllInterfaces;
  }

  /**
   * This is the setter method to the attribute.
   * Enable vip on all data interfaces for the cloud.
   * Field introduced in 18.2.9, 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param enableVipOnAllInterfaces set the enableVipOnAllInterfaces.
   */
  public void setEnableVipOnAllInterfaces(Boolean  enableVipOnAllInterfaces) {
    this.enableVipOnAllInterfaces = enableVipOnAllInterfaces;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Use static routes for vip side network resolution during virtualservice placement.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return enableVipStaticRoutes
   */
  public Boolean getEnableVipStaticRoutes() {
    return enableVipStaticRoutes;
  }

  /**
   * This is the setter method to the attribute.
   * Use static routes for vip side network resolution during virtualservice placement.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param enableVipStaticRoutes set the enableVipStaticRoutes.
   */
  public void setEnableVipStaticRoutes(Boolean  enableVipStaticRoutes) {
    this.enableVipStaticRoutes = enableVipStaticRoutes;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Google cloud platform configuration.
   * Field introduced in 18.2.1.
   * @return gcpConfiguration
   */
  public GCPConfiguration getGcpConfiguration() {
    return gcpConfiguration;
  }

  /**
   * This is the setter method to the attribute.
   * Google cloud platform configuration.
   * Field introduced in 18.2.1.
   * @param gcpConfiguration set the gcpConfiguration.
   */
  public void setGcpConfiguration(GCPConfiguration gcpConfiguration) {
    this.gcpConfiguration = gcpConfiguration;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable ipv6 auto configuration.
   * Field introduced in 18.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return ip6AutocfgEnabled
   */
  public Boolean getIp6AutocfgEnabled() {
    return ip6AutocfgEnabled;
  }

  /**
   * This is the setter method to the attribute.
   * Enable ipv6 auto configuration.
   * Field introduced in 18.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param ip6AutocfgEnabled set the ip6AutocfgEnabled.
   */
  public void setIp6AutocfgEnabled(Boolean  ip6AutocfgEnabled) {
    this.ip6AutocfgEnabled = ip6AutocfgEnabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ipam profile for the cloud.
   * It is a reference to an object of type ipamdnsproviderprofile.
   * @return ipamProviderRef
   */
  public String getIpamProviderRef() {
    return ipamProviderRef;
  }

  /**
   * This is the setter method to the attribute.
   * Ipam profile for the cloud.
   * It is a reference to an object of type ipamdnsproviderprofile.
   * @param ipamProviderRef set the ipamProviderRef.
   */
  public void setIpamProviderRef(String  ipamProviderRef) {
    this.ipamProviderRef = ipamProviderRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Specifies the default license tier which would be used by new se groups.
   * This field by default inherits the value from system configuration.
   * Enum options - ENTERPRISE_16, ENTERPRISE, ENTERPRISE_18, BASIC.
   * Field introduced in 17.2.5.
   * @return licenseTier
   */
  public String getLicenseTier() {
    return licenseTier;
  }

  /**
   * This is the setter method to the attribute.
   * Specifies the default license tier which would be used by new se groups.
   * This field by default inherits the value from system configuration.
   * Enum options - ENTERPRISE_16, ENTERPRISE, ENTERPRISE_18, BASIC.
   * Field introduced in 17.2.5.
   * @param licenseTier set the licenseTier.
   */
  public void setLicenseTier(String  licenseTier) {
    this.licenseTier = licenseTier;
  }

  /**
   * This is the getter method this will return the attribute value.
   * If no license type is specified then default license enforcement for the cloud type is chosen.
   * The default mappings are container cloud is max ses, openstack and vmware is cores and linux it is sockets.
   * Enum options - LIC_BACKEND_SERVERS, LIC_SOCKETS, LIC_CORES, LIC_HOSTS, LIC_SE_BANDWIDTH, LIC_METERED_SE_BANDWIDTH.
   * @return licenseType
   */
  public String getLicenseType() {
    return licenseType;
  }

  /**
   * This is the setter method to the attribute.
   * If no license type is specified then default license enforcement for the cloud type is chosen.
   * The default mappings are container cloud is max ses, openstack and vmware is cores and linux it is sockets.
   * Enum options - LIC_BACKEND_SERVERS, LIC_SOCKETS, LIC_CORES, LIC_HOSTS, LIC_SE_BANDWIDTH, LIC_METERED_SE_BANDWIDTH.
   * @param licenseType set the licenseType.
   */
  public void setLicenseType(String  licenseType) {
    this.licenseType = licenseType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property linuxserver_configuration of obj type cloud field type str  type ref.
   * @return linuxserverConfiguration
   */
  public LinuxServerConfiguration getLinuxserverConfiguration() {
    return linuxserverConfiguration;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property linuxserver_configuration of obj type cloud field type str  type ref.
   * @param linuxserverConfiguration set the linuxserverConfiguration.
   */
  public void setLinuxserverConfiguration(LinuxServerConfiguration linuxserverConfiguration) {
    this.linuxserverConfiguration = linuxserverConfiguration;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field deprecated in 18.2.2.
   * @return mesosConfiguration
   */
  public MesosConfiguration getMesosConfiguration() {
    return mesosConfiguration;
  }

  /**
   * This is the setter method to the attribute.
   * Field deprecated in 18.2.2.
   * @param mesosConfiguration set the mesosConfiguration.
   */
  public void setMesosConfiguration(MesosConfiguration mesosConfiguration) {
    this.mesosConfiguration = mesosConfiguration;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Mtu setting for the cloud.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1500.
   * @return mtu
   */
  public Integer getMtu() {
    return mtu;
  }

  /**
   * This is the setter method to the attribute.
   * Mtu setting for the cloud.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1500.
   * @param mtu set the mtu.
   */
  public void setMtu(Integer  mtu) {
    this.mtu = mtu;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the object.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the object.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Configuration parameters for nsx manager.
   * Field introduced in 17.1.1.
   * @return nsxConfiguration
   */
  public NsxConfiguration getNsxConfiguration() {
    return nsxConfiguration;
  }

  /**
   * This is the setter method to the attribute.
   * Configuration parameters for nsx manager.
   * Field introduced in 17.1.1.
   * @param nsxConfiguration set the nsxConfiguration.
   */
  public void setNsxConfiguration(NsxConfiguration nsxConfiguration) {
    this.nsxConfiguration = nsxConfiguration;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Nsx-t cloud platform configuration.
   * Field introduced in 20.1.1.
   * @return nsxtConfiguration
   */
  public NsxtConfiguration getNsxtConfiguration() {
    return nsxtConfiguration;
  }

  /**
   * This is the setter method to the attribute.
   * Nsx-t cloud platform configuration.
   * Field introduced in 20.1.1.
   * @param nsxtConfiguration set the nsxtConfiguration.
   */
  public void setNsxtConfiguration(NsxtConfiguration nsxtConfiguration) {
    this.nsxtConfiguration = nsxtConfiguration;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Default prefix for all automatically created objects in this cloud.
   * This prefix can be overridden by the se-group template.
   * @return objNamePrefix
   */
  public String getObjNamePrefix() {
    return objNamePrefix;
  }

  /**
   * This is the setter method to the attribute.
   * Default prefix for all automatically created objects in this cloud.
   * This prefix can be overridden by the se-group template.
   * @param objNamePrefix set the objNamePrefix.
   */
  public void setObjNamePrefix(String  objNamePrefix) {
    this.objNamePrefix = objNamePrefix;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property openstack_configuration of obj type cloud field type str  type ref.
   * @return openstackConfiguration
   */
  public OpenStackConfiguration getOpenstackConfiguration() {
    return openstackConfiguration;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property openstack_configuration of obj type cloud field type str  type ref.
   * @param openstackConfiguration set the openstackConfiguration.
   */
  public void setOpenstackConfiguration(OpenStackConfiguration openstackConfiguration) {
    this.openstackConfiguration = openstackConfiguration;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field deprecated in 20.1.1.
   * @return oshiftk8sConfiguration
   */
  public OShiftK8SConfiguration getOshiftk8SConfiguration() {
    return oshiftk8sConfiguration;
  }

  /**
   * This is the setter method to the attribute.
   * Field deprecated in 20.1.1.
   * @param oshiftk8sConfiguration set the oshiftk8sConfiguration.
   */
  public void setOshiftk8SConfiguration(OShiftK8SConfiguration oshiftk8sConfiguration) {
    this.oshiftk8sConfiguration = oshiftk8sConfiguration;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Prefer static routes over interface routes during virtualservice placement.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return preferStaticRoutes
   */
  public Boolean getPreferStaticRoutes() {
    return preferStaticRoutes;
  }

  /**
   * This is the setter method to the attribute.
   * Prefer static routes over interface routes during virtualservice placement.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param preferStaticRoutes set the preferStaticRoutes.
   */
  public void setPreferStaticRoutes(Boolean  preferStaticRoutes) {
    this.preferStaticRoutes = preferStaticRoutes;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property proxy_configuration of obj type cloud field type str  type ref.
   * @return proxyConfiguration
   */
  public ProxyConfiguration getProxyConfiguration() {
    return proxyConfiguration;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property proxy_configuration of obj type cloud field type str  type ref.
   * @param proxyConfiguration set the proxyConfiguration.
   */
  public void setProxyConfiguration(ProxyConfiguration proxyConfiguration) {
    this.proxyConfiguration = proxyConfiguration;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property rancher_configuration of obj type cloud field type str  type ref.
   * @return rancherConfiguration
   */
  public RancherConfiguration getRancherConfiguration() {
    return rancherConfiguration;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property rancher_configuration of obj type cloud field type str  type ref.
   * @param rancherConfiguration set the rancherConfiguration.
   */
  public void setRancherConfiguration(RancherConfiguration rancherConfiguration) {
    this.rancherConfiguration = rancherConfiguration;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The service engine group to use as template.
   * It is a reference to an object of type serviceenginegroup.
   * Field introduced in 18.2.5.
   * @return seGroupTemplateRef
   */
  public String getSeGroupTemplateRef() {
    return seGroupTemplateRef;
  }

  /**
   * This is the setter method to the attribute.
   * The service engine group to use as template.
   * It is a reference to an object of type serviceenginegroup.
   * Field introduced in 18.2.5.
   * @param seGroupTemplateRef set the seGroupTemplateRef.
   */
  public void setSeGroupTemplateRef(String  seGroupTemplateRef) {
    this.seGroupTemplateRef = seGroupTemplateRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dns records for vips are added/deleted based on the operational state of the vips.
   * Field introduced in 17.1.12.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return stateBasedDnsRegistration
   */
  public Boolean getStateBasedDnsRegistration() {
    return stateBasedDnsRegistration;
  }

  /**
   * This is the setter method to the attribute.
   * Dns records for vips are added/deleted based on the operational state of the vips.
   * Field introduced in 17.1.12.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param stateBasedDnsRegistration set the stateBasedDnsRegistration.
   */
  public void setStateBasedDnsRegistration(Boolean  stateBasedDnsRegistration) {
    this.stateBasedDnsRegistration = stateBasedDnsRegistration;
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
   * Placeholder for description of property vca_configuration of obj type cloud field type str  type ref.
   * @return vcaConfiguration
   */
  public vCloudAirConfiguration getVcaConfiguration() {
    return vcaConfiguration;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vca_configuration of obj type cloud field type str  type ref.
   * @param vcaConfiguration set the vcaConfiguration.
   */
  public void setVcaConfiguration(vCloudAirConfiguration vcaConfiguration) {
    this.vcaConfiguration = vcaConfiguration;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vcenter_configuration of obj type cloud field type str  type ref.
   * @return vcenterConfiguration
   */
  public vCenterConfiguration getVcenterConfiguration() {
    return vcenterConfiguration;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vcenter_configuration of obj type cloud field type str  type ref.
   * @param vcenterConfiguration set the vcenterConfiguration.
   */
  public void setVcenterConfiguration(vCenterConfiguration vcenterConfiguration) {
    this.vcenterConfiguration = vcenterConfiguration;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Cloud type.
   * Enum options - CLOUD_NONE, CLOUD_VCENTER, CLOUD_OPENSTACK, CLOUD_AWS, CLOUD_VCA, CLOUD_APIC, CLOUD_MESOS, CLOUD_LINUXSERVER, CLOUD_DOCKER_UCP,
   * CLOUD_RANCHER, CLOUD_OSHIFT_K8S, CLOUD_AZURE, CLOUD_GCP, CLOUD_NSXT.
   * Default value when not specified in API or module is interpreted by Avi Controller as CLOUD_NONE.
   * @return vtype
   */
  public String getVtype() {
    return vtype;
  }

  /**
   * This is the setter method to the attribute.
   * Cloud type.
   * Enum options - CLOUD_NONE, CLOUD_VCENTER, CLOUD_OPENSTACK, CLOUD_AWS, CLOUD_VCA, CLOUD_APIC, CLOUD_MESOS, CLOUD_LINUXSERVER, CLOUD_DOCKER_UCP,
   * CLOUD_RANCHER, CLOUD_OSHIFT_K8S, CLOUD_AZURE, CLOUD_GCP, CLOUD_NSXT.
   * Default value when not specified in API or module is interpreted by Avi Controller as CLOUD_NONE.
   * @param vtype set the vtype.
   */
  public void setVtype(String  vtype) {
    this.vtype = vtype;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  Cloud objCloud = (Cloud) o;
  return   Objects.equals(this.uuid, objCloud.uuid)&&
  Objects.equals(this.name, objCloud.name)&&
  Objects.equals(this.vtype, objCloud.vtype)&&
  Objects.equals(this.vcenterConfiguration, objCloud.vcenterConfiguration)&&
  Objects.equals(this.openstackConfiguration, objCloud.openstackConfiguration)&&
  Objects.equals(this.awsConfiguration, objCloud.awsConfiguration)&&
  Objects.equals(this.apicMode, objCloud.apicMode)&&
  Objects.equals(this.apicConfiguration, objCloud.apicConfiguration)&&
  Objects.equals(this.cloudstackConfiguration, objCloud.cloudstackConfiguration)&&
  Objects.equals(this.vcaConfiguration, objCloud.vcaConfiguration)&&
  Objects.equals(this.mesosConfiguration, objCloud.mesosConfiguration)&&
  Objects.equals(this.proxyConfiguration, objCloud.proxyConfiguration)&&
  Objects.equals(this.linuxserverConfiguration, objCloud.linuxserverConfiguration)&&
  Objects.equals(this.dockerConfiguration, objCloud.dockerConfiguration)&&
  Objects.equals(this.rancherConfiguration, objCloud.rancherConfiguration)&&
  Objects.equals(this.oshiftk8sConfiguration, objCloud.oshiftk8sConfiguration)&&
  Objects.equals(this.azureConfiguration, objCloud.azureConfiguration)&&
  Objects.equals(this.gcpConfiguration, objCloud.gcpConfiguration)&&
  Objects.equals(this.nsxtConfiguration, objCloud.nsxtConfiguration)&&
  Objects.equals(this.dhcpEnabled, objCloud.dhcpEnabled)&&
  Objects.equals(this.mtu, objCloud.mtu)&&
  Objects.equals(this.preferStaticRoutes, objCloud.preferStaticRoutes)&&
  Objects.equals(this.enableVipStaticRoutes, objCloud.enableVipStaticRoutes)&&
  Objects.equals(this.objNamePrefix, objCloud.objNamePrefix)&&
  Objects.equals(this.licenseType, objCloud.licenseType)&&
  Objects.equals(this.ipamProviderRef, objCloud.ipamProviderRef)&&
  Objects.equals(this.dnsProviderRef, objCloud.dnsProviderRef)&&
  Objects.equals(this.eastWestIpamProviderRef, objCloud.eastWestIpamProviderRef)&&
  Objects.equals(this.eastWestDnsProviderRef, objCloud.eastWestDnsProviderRef)&&
  Objects.equals(this.nsxConfiguration, objCloud.nsxConfiguration)&&
  Objects.equals(this.customTags, objCloud.customTags)&&
  Objects.equals(this.stateBasedDnsRegistration, objCloud.stateBasedDnsRegistration)&&
  Objects.equals(this.ip6AutocfgEnabled, objCloud.ip6AutocfgEnabled)&&
  Objects.equals(this.dnsResolutionOnSe, objCloud.dnsResolutionOnSe)&&
  Objects.equals(this.enableVipOnAllInterfaces, objCloud.enableVipOnAllInterfaces)&&
  Objects.equals(this.tenantRef, objCloud.tenantRef)&&
  Objects.equals(this.licenseTier, objCloud.licenseTier)&&
  Objects.equals(this.autoscalePollingInterval, objCloud.autoscalePollingInterval)&&
  Objects.equals(this.seGroupTemplateRef, objCloud.seGroupTemplateRef);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class Cloud {\n");
      sb.append("    apicConfiguration: ").append(toIndentedString(apicConfiguration)).append("\n");
        sb.append("    apicMode: ").append(toIndentedString(apicMode)).append("\n");
        sb.append("    autoscalePollingInterval: ").append(toIndentedString(autoscalePollingInterval)).append("\n");
        sb.append("    awsConfiguration: ").append(toIndentedString(awsConfiguration)).append("\n");
        sb.append("    azureConfiguration: ").append(toIndentedString(azureConfiguration)).append("\n");
        sb.append("    cloudstackConfiguration: ").append(toIndentedString(cloudstackConfiguration)).append("\n");
        sb.append("    customTags: ").append(toIndentedString(customTags)).append("\n");
        sb.append("    dhcpEnabled: ").append(toIndentedString(dhcpEnabled)).append("\n");
        sb.append("    dnsProviderRef: ").append(toIndentedString(dnsProviderRef)).append("\n");
        sb.append("    dnsResolutionOnSe: ").append(toIndentedString(dnsResolutionOnSe)).append("\n");
        sb.append("    dockerConfiguration: ").append(toIndentedString(dockerConfiguration)).append("\n");
        sb.append("    eastWestDnsProviderRef: ").append(toIndentedString(eastWestDnsProviderRef)).append("\n");
        sb.append("    eastWestIpamProviderRef: ").append(toIndentedString(eastWestIpamProviderRef)).append("\n");
        sb.append("    enableVipOnAllInterfaces: ").append(toIndentedString(enableVipOnAllInterfaces)).append("\n");
        sb.append("    enableVipStaticRoutes: ").append(toIndentedString(enableVipStaticRoutes)).append("\n");
        sb.append("    gcpConfiguration: ").append(toIndentedString(gcpConfiguration)).append("\n");
        sb.append("    ip6AutocfgEnabled: ").append(toIndentedString(ip6AutocfgEnabled)).append("\n");
        sb.append("    ipamProviderRef: ").append(toIndentedString(ipamProviderRef)).append("\n");
        sb.append("    licenseTier: ").append(toIndentedString(licenseTier)).append("\n");
        sb.append("    licenseType: ").append(toIndentedString(licenseType)).append("\n");
        sb.append("    linuxserverConfiguration: ").append(toIndentedString(linuxserverConfiguration)).append("\n");
        sb.append("    mesosConfiguration: ").append(toIndentedString(mesosConfiguration)).append("\n");
        sb.append("    mtu: ").append(toIndentedString(mtu)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    nsxConfiguration: ").append(toIndentedString(nsxConfiguration)).append("\n");
        sb.append("    nsxtConfiguration: ").append(toIndentedString(nsxtConfiguration)).append("\n");
        sb.append("    objNamePrefix: ").append(toIndentedString(objNamePrefix)).append("\n");
        sb.append("    openstackConfiguration: ").append(toIndentedString(openstackConfiguration)).append("\n");
        sb.append("    oshiftk8sConfiguration: ").append(toIndentedString(oshiftk8sConfiguration)).append("\n");
        sb.append("    preferStaticRoutes: ").append(toIndentedString(preferStaticRoutes)).append("\n");
        sb.append("    proxyConfiguration: ").append(toIndentedString(proxyConfiguration)).append("\n");
        sb.append("    rancherConfiguration: ").append(toIndentedString(rancherConfiguration)).append("\n");
        sb.append("    seGroupTemplateRef: ").append(toIndentedString(seGroupTemplateRef)).append("\n");
        sb.append("    stateBasedDnsRegistration: ").append(toIndentedString(stateBasedDnsRegistration)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
            sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
        sb.append("    vcaConfiguration: ").append(toIndentedString(vcaConfiguration)).append("\n");
        sb.append("    vcenterConfiguration: ").append(toIndentedString(vcenterConfiguration)).append("\n");
        sb.append("    vtype: ").append(toIndentedString(vtype)).append("\n");
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

