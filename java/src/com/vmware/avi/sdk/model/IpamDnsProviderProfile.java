package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The IpamDnsProviderProfile is a POJO class extends AviRestResource that used for creating
 * IpamDnsProviderProfile.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IpamDnsProviderProfile extends AviRestResource  {
    @JsonProperty("allocate_ip_in_vrf")
    private Boolean allocateIpInVrf = false;

    @JsonProperty("aws_profile")
    private IpamDnsAwsProfile awsProfile = null;

    @JsonProperty("azure_profile")
    private IpamDnsAzureProfile azureProfile = null;

    @JsonProperty("custom_profile")
    private IpamDnsCustomProfile customProfile = null;

    @JsonProperty("gcp_profile")
    private IpamDnsGCPProfile gcpProfile = null;

    @JsonProperty("infoblox_profile")
    private IpamDnsInfobloxProfile infobloxProfile = null;

    @JsonProperty("internal_profile")
    private IpamDnsInternalProfile internalProfile = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("oci_profile")
    private IpamDnsOCIProfile ociProfile = null;

    @JsonProperty("openstack_profile")
    private IpamDnsOpenstackProfile openstackProfile = null;

    @JsonProperty("proxy_configuration")
    private ProxyConfiguration proxyConfiguration = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("tencent_profile")
    private IpamDnsTencentProfile tencentProfile = null;

    @JsonProperty("type")
    private String type = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * If this flag is set, only allocate ip from networks in the virtual service vrf.
   * Applicable for avi vantage ipam only.
   * Field introduced in 17.2.4.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return allocateIpInVrf
   */
  public Boolean getAllocateIpInVrf() {
    return allocateIpInVrf;
  }

  /**
   * This is the setter method to the attribute.
   * If this flag is set, only allocate ip from networks in the virtual service vrf.
   * Applicable for avi vantage ipam only.
   * Field introduced in 17.2.4.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param allocateIpInVrf set the allocateIpInVrf.
   */
  public void setAllocateIpInVrf(Boolean  allocateIpInVrf) {
    this.allocateIpInVrf = allocateIpInVrf;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Provider details if type is aws.
   * @return awsProfile
   */
  public IpamDnsAwsProfile getAwsProfile() {
    return awsProfile;
  }

  /**
   * This is the setter method to the attribute.
   * Provider details if type is aws.
   * @param awsProfile set the awsProfile.
   */
  public void setAwsProfile(IpamDnsAwsProfile awsProfile) {
    this.awsProfile = awsProfile;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Provider details if type is microsoft azure.
   * Field introduced in 17.2.1.
   * @return azureProfile
   */
  public IpamDnsAzureProfile getAzureProfile() {
    return azureProfile;
  }

  /**
   * This is the setter method to the attribute.
   * Provider details if type is microsoft azure.
   * Field introduced in 17.2.1.
   * @param azureProfile set the azureProfile.
   */
  public void setAzureProfile(IpamDnsAzureProfile azureProfile) {
    this.azureProfile = azureProfile;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Provider details if type is custom.
   * Field introduced in 17.1.1.
   * @return customProfile
   */
  public IpamDnsCustomProfile getCustomProfile() {
    return customProfile;
  }

  /**
   * This is the setter method to the attribute.
   * Provider details if type is custom.
   * Field introduced in 17.1.1.
   * @param customProfile set the customProfile.
   */
  public void setCustomProfile(IpamDnsCustomProfile customProfile) {
    this.customProfile = customProfile;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Provider details if type is google cloud.
   * @return gcpProfile
   */
  public IpamDnsGCPProfile getGcpProfile() {
    return gcpProfile;
  }

  /**
   * This is the setter method to the attribute.
   * Provider details if type is google cloud.
   * @param gcpProfile set the gcpProfile.
   */
  public void setGcpProfile(IpamDnsGCPProfile gcpProfile) {
    this.gcpProfile = gcpProfile;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Provider details if type is infoblox.
   * @return infobloxProfile
   */
  public IpamDnsInfobloxProfile getInfobloxProfile() {
    return infobloxProfile;
  }

  /**
   * This is the setter method to the attribute.
   * Provider details if type is infoblox.
   * @param infobloxProfile set the infobloxProfile.
   */
  public void setInfobloxProfile(IpamDnsInfobloxProfile infobloxProfile) {
    this.infobloxProfile = infobloxProfile;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Provider details if type is avi.
   * @return internalProfile
   */
  public IpamDnsInternalProfile getInternalProfile() {
    return internalProfile;
  }

  /**
   * This is the setter method to the attribute.
   * Provider details if type is avi.
   * @param internalProfile set the internalProfile.
   */
  public void setInternalProfile(IpamDnsInternalProfile internalProfile) {
    this.internalProfile = internalProfile;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name for the ipam/dns provider profile.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name for the ipam/dns provider profile.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Provider details for oracle cloud.
   * Field introduced in 18.2.1,18.1.3.
   * @return ociProfile
   */
  public IpamDnsOCIProfile getOciProfile() {
    return ociProfile;
  }

  /**
   * This is the setter method to the attribute.
   * Provider details for oracle cloud.
   * Field introduced in 18.2.1,18.1.3.
   * @param ociProfile set the ociProfile.
   */
  public void setOciProfile(IpamDnsOCIProfile ociProfile) {
    this.ociProfile = ociProfile;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Provider details if type is openstack.
   * @return openstackProfile
   */
  public IpamDnsOpenstackProfile getOpenstackProfile() {
    return openstackProfile;
  }

  /**
   * This is the setter method to the attribute.
   * Provider details if type is openstack.
   * @param openstackProfile set the openstackProfile.
   */
  public void setOpenstackProfile(IpamDnsOpenstackProfile openstackProfile) {
    this.openstackProfile = openstackProfile;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.1.1.
   * @return proxyConfiguration
   */
  public ProxyConfiguration getProxyConfiguration() {
    return proxyConfiguration;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.1.1.
   * @param proxyConfiguration set the proxyConfiguration.
   */
  public void setProxyConfiguration(ProxyConfiguration proxyConfiguration) {
    this.proxyConfiguration = proxyConfiguration;
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
   * Provider details for tencent cloud.
   * Field introduced in 18.2.3.
   * @return tencentProfile
   */
  public IpamDnsTencentProfile getTencentProfile() {
    return tencentProfile;
  }

  /**
   * This is the setter method to the attribute.
   * Provider details for tencent cloud.
   * Field introduced in 18.2.3.
   * @param tencentProfile set the tencentProfile.
   */
  public void setTencentProfile(IpamDnsTencentProfile tencentProfile) {
    this.tencentProfile = tencentProfile;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Provider type for the ipam/dns provider profile.
   * Enum options - IPAMDNS_TYPE_INFOBLOX, IPAMDNS_TYPE_AWS, IPAMDNS_TYPE_OPENSTACK, IPAMDNS_TYPE_GCP, IPAMDNS_TYPE_INFOBLOX_DNS, IPAMDNS_TYPE_CUSTOM,
   * IPAMDNS_TYPE_CUSTOM_DNS, IPAMDNS_TYPE_AZURE, IPAMDNS_TYPE_OCI, IPAMDNS_TYPE_TENCENT, IPAMDNS_TYPE_INTERNAL, IPAMDNS_TYPE_INTERNAL_DNS,
   * IPAMDNS_TYPE_AWS_DNS, IPAMDNS_TYPE_AZURE_DNS.
   * @return type
   */
  public String getType() {
    return type;
  }

  /**
   * This is the setter method to the attribute.
   * Provider type for the ipam/dns provider profile.
   * Enum options - IPAMDNS_TYPE_INFOBLOX, IPAMDNS_TYPE_AWS, IPAMDNS_TYPE_OPENSTACK, IPAMDNS_TYPE_GCP, IPAMDNS_TYPE_INFOBLOX_DNS, IPAMDNS_TYPE_CUSTOM,
   * IPAMDNS_TYPE_CUSTOM_DNS, IPAMDNS_TYPE_AZURE, IPAMDNS_TYPE_OCI, IPAMDNS_TYPE_TENCENT, IPAMDNS_TYPE_INTERNAL, IPAMDNS_TYPE_INTERNAL_DNS,
   * IPAMDNS_TYPE_AWS_DNS, IPAMDNS_TYPE_AZURE_DNS.
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
   * Uuid of the ipam/dns provider profile.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the ipam/dns provider profile.
   * @param uuid set the uuid.
   */
  public void setUuid(String  uuid) {
    this.uuid = uuid;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  IpamDnsProviderProfile objIpamDnsProviderProfile = (IpamDnsProviderProfile) o;
  return   Objects.equals(this.azureProfile, objIpamDnsProviderProfile.azureProfile)&&
  Objects.equals(this.openstackProfile, objIpamDnsProviderProfile.openstackProfile)&&
  Objects.equals(this.uuid, objIpamDnsProviderProfile.uuid)&&
  Objects.equals(this.gcpProfile, objIpamDnsProviderProfile.gcpProfile)&&
  Objects.equals(this.infobloxProfile, objIpamDnsProviderProfile.infobloxProfile)&&
  Objects.equals(this.internalProfile, objIpamDnsProviderProfile.internalProfile)&&
  Objects.equals(this.ociProfile, objIpamDnsProviderProfile.ociProfile)&&
  Objects.equals(this.customProfile, objIpamDnsProviderProfile.customProfile)&&
  Objects.equals(this.proxyConfiguration, objIpamDnsProviderProfile.proxyConfiguration)&&
  Objects.equals(this.awsProfile, objIpamDnsProviderProfile.awsProfile)&&
  Objects.equals(this.allocateIpInVrf, objIpamDnsProviderProfile.allocateIpInVrf)&&
  Objects.equals(this.tencentProfile, objIpamDnsProviderProfile.tencentProfile)&&
  Objects.equals(this.type, objIpamDnsProviderProfile.type)&&
  Objects.equals(this.tenantRef, objIpamDnsProviderProfile.tenantRef)&&
  Objects.equals(this.name, objIpamDnsProviderProfile.name);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class IpamDnsProviderProfile {\n");
      sb.append("    allocateIpInVrf: ").append(toIndentedString(allocateIpInVrf)).append("\n");
        sb.append("    awsProfile: ").append(toIndentedString(awsProfile)).append("\n");
        sb.append("    azureProfile: ").append(toIndentedString(azureProfile)).append("\n");
        sb.append("    customProfile: ").append(toIndentedString(customProfile)).append("\n");
        sb.append("    gcpProfile: ").append(toIndentedString(gcpProfile)).append("\n");
        sb.append("    infobloxProfile: ").append(toIndentedString(infobloxProfile)).append("\n");
        sb.append("    internalProfile: ").append(toIndentedString(internalProfile)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    ociProfile: ").append(toIndentedString(ociProfile)).append("\n");
        sb.append("    openstackProfile: ").append(toIndentedString(openstackProfile)).append("\n");
        sb.append("    proxyConfiguration: ").append(toIndentedString(proxyConfiguration)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
        sb.append("    tencentProfile: ").append(toIndentedString(tencentProfile)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
            sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
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

