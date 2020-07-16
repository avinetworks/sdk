package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The IpamDnsAzureProfile is a POJO class extends AviRestResource that used for creating
 * IpamDnsAzureProfile.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IpamDnsAzureProfile  {
    @JsonProperty("azure_serviceprincipal")
    private AzureServicePrincipalCredentials azureServiceprincipal = null;

    @JsonProperty("azure_userpass")
    private AzureUserPassCredentials azureUserpass = null;

    @JsonProperty("egress_service_subnets")
    private List<String> egressServiceSubnets = null;

    @JsonProperty("resource_group")
    private String resourceGroup = null;

    @JsonProperty("subscription_id")
    private String subscriptionId = null;

    @JsonProperty("usable_domains")
    private List<String> usableDomains = null;

    @JsonProperty("usable_network_uuids")
    private List<String> usableNetworkUuids = null;

    @JsonProperty("use_enhanced_ha")
    private Boolean useEnhancedHa = false;

    @JsonProperty("use_standard_alb")
    private Boolean useStandardAlb = false;

    @JsonProperty("virtual_network_ids")
    private List<String> virtualNetworkIds = null;



  /**
   * This is the getter method this will return the attribute value.
   * Service principal based credentials for azure.
   * Only one of azure_userpass or azure_serviceprincipal is allowed.
   * Field introduced in 17.2.1.
   * @return azureServiceprincipal
   */
  public AzureServicePrincipalCredentials getAzureServiceprincipal() {
    return azureServiceprincipal;
  }

  /**
   * This is the setter method to the attribute.
   * Service principal based credentials for azure.
   * Only one of azure_userpass or azure_serviceprincipal is allowed.
   * Field introduced in 17.2.1.
   * @param azureServiceprincipal set the azureServiceprincipal.
   */
  public void setAzureServiceprincipal(AzureServicePrincipalCredentials azureServiceprincipal) {
    this.azureServiceprincipal = azureServiceprincipal;
  }

  /**
   * This is the getter method this will return the attribute value.
   * User name password based credentials for azure.
   * Only one of azure_userpass or azure_serviceprincipal is allowed.
   * Field introduced in 17.2.1.
   * @return azureUserpass
   */
  public AzureUserPassCredentials getAzureUserpass() {
    return azureUserpass;
  }

  /**
   * This is the setter method to the attribute.
   * User name password based credentials for azure.
   * Only one of azure_userpass or azure_serviceprincipal is allowed.
   * Field introduced in 17.2.1.
   * @param azureUserpass set the azureUserpass.
   */
  public void setAzureUserpass(AzureUserPassCredentials azureUserpass) {
    this.azureUserpass = azureUserpass;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Used for allocating egress service source ips.
   * Field introduced in 17.2.8.
   * @return egressServiceSubnets
   */
  public List<String> getEgressServiceSubnets() {
    return egressServiceSubnets;
  }

  /**
   * This is the setter method. this will set the egressServiceSubnets
   * Used for allocating egress service source ips.
   * Field introduced in 17.2.8.
   * @return egressServiceSubnets
   */
  public void setEgressServiceSubnets(List<String>  egressServiceSubnets) {
    this.egressServiceSubnets = egressServiceSubnets;
  }

  /**
   * This is the setter method this will set the egressServiceSubnets
   * Used for allocating egress service source ips.
   * Field introduced in 17.2.8.
   * @return egressServiceSubnets
   */
  public IpamDnsAzureProfile addEgressServiceSubnetsItem(String egressServiceSubnetsItem) {
    if (this.egressServiceSubnets == null) {
      this.egressServiceSubnets = new ArrayList<String>();
    }
    this.egressServiceSubnets.add(egressServiceSubnetsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Azure resource group dedicated for avi controller.
   * Avi controller will create all its resources in this resource group.
   * Field introduced in 17.2.1.
   * @return resourceGroup
   */
  public String getResourceGroup() {
    return resourceGroup;
  }

  /**
   * This is the setter method to the attribute.
   * Azure resource group dedicated for avi controller.
   * Avi controller will create all its resources in this resource group.
   * Field introduced in 17.2.1.
   * @param resourceGroup set the resourceGroup.
   */
  public void setResourceGroup(String  resourceGroup) {
    this.resourceGroup = resourceGroup;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Subscription id for the azure subscription.
   * Field introduced in 17.2.1.
   * @return subscriptionId
   */
  public String getSubscriptionId() {
    return subscriptionId;
  }

  /**
   * This is the setter method to the attribute.
   * Subscription id for the azure subscription.
   * Field introduced in 17.2.1.
   * @param subscriptionId set the subscriptionId.
   */
  public void setSubscriptionId(String  subscriptionId) {
    this.subscriptionId = subscriptionId;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Usable domains to pick from azure dns.
   * Field introduced in 17.2.1.
   * @return usableDomains
   */
  public List<String> getUsableDomains() {
    return usableDomains;
  }

  /**
   * This is the setter method. this will set the usableDomains
   * Usable domains to pick from azure dns.
   * Field introduced in 17.2.1.
   * @return usableDomains
   */
  public void setUsableDomains(List<String>  usableDomains) {
    this.usableDomains = usableDomains;
  }

  /**
   * This is the setter method this will set the usableDomains
   * Usable domains to pick from azure dns.
   * Field introduced in 17.2.1.
   * @return usableDomains
   */
  public IpamDnsAzureProfile addUsableDomainsItem(String usableDomainsItem) {
    if (this.usableDomains == null) {
      this.usableDomains = new ArrayList<String>();
    }
    this.usableDomains.add(usableDomainsItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Usable networks for virtual ip.
   * If virtualservice does not specify a network and auto_allocate_ip is set, then the first available network from this list will be chosen for ip
   * allocation.
   * Field introduced in 17.2.1.
   * @return usableNetworkUuids
   */
  public List<String> getUsableNetworkUuids() {
    return usableNetworkUuids;
  }

  /**
   * This is the setter method. this will set the usableNetworkUuids
   * Usable networks for virtual ip.
   * If virtualservice does not specify a network and auto_allocate_ip is set, then the first available network from this list will be chosen for ip
   * allocation.
   * Field introduced in 17.2.1.
   * @return usableNetworkUuids
   */
  public void setUsableNetworkUuids(List<String>  usableNetworkUuids) {
    this.usableNetworkUuids = usableNetworkUuids;
  }

  /**
   * This is the setter method this will set the usableNetworkUuids
   * Usable networks for virtual ip.
   * If virtualservice does not specify a network and auto_allocate_ip is set, then the first available network from this list will be chosen for ip
   * allocation.
   * Field introduced in 17.2.1.
   * @return usableNetworkUuids
   */
  public IpamDnsAzureProfile addUsableNetworkUuidsItem(String usableNetworkUuidsItem) {
    if (this.usableNetworkUuids == null) {
      this.usableNetworkUuids = new ArrayList<String>();
    }
    this.usableNetworkUuids.add(usableNetworkUuidsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Use azure's enhanced ha features.
   * This needs a public ip to be associated with the vip.
   * Field introduced in 17.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return useEnhancedHa
   */
  public Boolean getUseEnhancedHa() {
    return useEnhancedHa;
  }

  /**
   * This is the setter method to the attribute.
   * Use azure's enhanced ha features.
   * This needs a public ip to be associated with the vip.
   * Field introduced in 17.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param useEnhancedHa set the useEnhancedHa.
   */
  public void setUseEnhancedHa(Boolean  useEnhancedHa) {
    this.useEnhancedHa = useEnhancedHa;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Use standard sku azure load balancer.
   * By default basic sku load balancer is used.
   * Field introduced in 17.2.7.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return useStandardAlb
   */
  public Boolean getUseStandardAlb() {
    return useStandardAlb;
  }

  /**
   * This is the setter method to the attribute.
   * Use standard sku azure load balancer.
   * By default basic sku load balancer is used.
   * Field introduced in 17.2.7.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param useStandardAlb set the useStandardAlb.
   */
  public void setUseStandardAlb(Boolean  useStandardAlb) {
    this.useStandardAlb = useStandardAlb;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Virtual networks where virtual ips will belong.
   * Field introduced in 17.2.1.
   * @return virtualNetworkIds
   */
  public List<String> getVirtualNetworkIds() {
    return virtualNetworkIds;
  }

  /**
   * This is the setter method. this will set the virtualNetworkIds
   * Virtual networks where virtual ips will belong.
   * Field introduced in 17.2.1.
   * @return virtualNetworkIds
   */
  public void setVirtualNetworkIds(List<String>  virtualNetworkIds) {
    this.virtualNetworkIds = virtualNetworkIds;
  }

  /**
   * This is the setter method this will set the virtualNetworkIds
   * Virtual networks where virtual ips will belong.
   * Field introduced in 17.2.1.
   * @return virtualNetworkIds
   */
  public IpamDnsAzureProfile addVirtualNetworkIdsItem(String virtualNetworkIdsItem) {
    if (this.virtualNetworkIds == null) {
      this.virtualNetworkIds = new ArrayList<String>();
    }
    this.virtualNetworkIds.add(virtualNetworkIdsItem);
    return this;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  IpamDnsAzureProfile objIpamDnsAzureProfile = (IpamDnsAzureProfile) o;
  return   Objects.equals(this.resourceGroup, objIpamDnsAzureProfile.resourceGroup)&&
  Objects.equals(this.useEnhancedHa, objIpamDnsAzureProfile.useEnhancedHa)&&
  Objects.equals(this.usableDomains, objIpamDnsAzureProfile.usableDomains)&&
  Objects.equals(this.usableNetworkUuids, objIpamDnsAzureProfile.usableNetworkUuids)&&
  Objects.equals(this.egressServiceSubnets, objIpamDnsAzureProfile.egressServiceSubnets)&&
  Objects.equals(this.useStandardAlb, objIpamDnsAzureProfile.useStandardAlb)&&
  Objects.equals(this.azureServiceprincipal, objIpamDnsAzureProfile.azureServiceprincipal)&&
  Objects.equals(this.azureUserpass, objIpamDnsAzureProfile.azureUserpass)&&
  Objects.equals(this.subscriptionId, objIpamDnsAzureProfile.subscriptionId)&&
  Objects.equals(this.virtualNetworkIds, objIpamDnsAzureProfile.virtualNetworkIds);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class IpamDnsAzureProfile {\n");
      sb.append("    azureServiceprincipal: ").append(toIndentedString(azureServiceprincipal)).append("\n");
        sb.append("    azureUserpass: ").append(toIndentedString(azureUserpass)).append("\n");
        sb.append("    egressServiceSubnets: ").append(toIndentedString(egressServiceSubnets)).append("\n");
        sb.append("    resourceGroup: ").append(toIndentedString(resourceGroup)).append("\n");
        sb.append("    subscriptionId: ").append(toIndentedString(subscriptionId)).append("\n");
        sb.append("    usableDomains: ").append(toIndentedString(usableDomains)).append("\n");
        sb.append("    usableNetworkUuids: ").append(toIndentedString(usableNetworkUuids)).append("\n");
        sb.append("    useEnhancedHa: ").append(toIndentedString(useEnhancedHa)).append("\n");
        sb.append("    useStandardAlb: ").append(toIndentedString(useStandardAlb)).append("\n");
        sb.append("    virtualNetworkIds: ").append(toIndentedString(virtualNetworkIds)).append("\n");
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

