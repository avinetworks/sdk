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
import com.vmware.avi.sdk.model.AzureServicePrincipalCredentials;
import com.vmware.avi.sdk.model.AzureUserPassCredentials;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
/**
 * IpamDnsAzureProfile
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-12T12:27:26.755+05:30[Asia/Kolkata]")
public class IpamDnsAzureProfile {
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
  private Boolean useEnhancedHa = null;

  @JsonProperty("use_standard_alb")
  private Boolean useStandardAlb = null;

  @JsonProperty("virtual_network_ids")
  private List<String> virtualNetworkIds = null;

  public IpamDnsAzureProfile azureServiceprincipal(AzureServicePrincipalCredentials azureServiceprincipal) {
    this.azureServiceprincipal = azureServiceprincipal;
    return this;
  }

   /**
   * Get azureServiceprincipal
   * @return azureServiceprincipal
  **/
  @Schema(description = "")
  public AzureServicePrincipalCredentials getAzureServiceprincipal() {
    return azureServiceprincipal;
  }

  public void setAzureServiceprincipal(AzureServicePrincipalCredentials azureServiceprincipal) {
    this.azureServiceprincipal = azureServiceprincipal;
  }

  public IpamDnsAzureProfile azureUserpass(AzureUserPassCredentials azureUserpass) {
    this.azureUserpass = azureUserpass;
    return this;
  }

   /**
   * Get azureUserpass
   * @return azureUserpass
  **/
  @Schema(description = "")
  public AzureUserPassCredentials getAzureUserpass() {
    return azureUserpass;
  }

  public void setAzureUserpass(AzureUserPassCredentials azureUserpass) {
    this.azureUserpass = azureUserpass;
  }

  public IpamDnsAzureProfile egressServiceSubnets(List<String> egressServiceSubnets) {
    this.egressServiceSubnets = egressServiceSubnets;
    return this;
  }

  public IpamDnsAzureProfile addEgressServiceSubnetsItem(String egressServiceSubnetsItem) {
    if (this.egressServiceSubnets == null) {
      this.egressServiceSubnets = new ArrayList<String>();
    }
    this.egressServiceSubnets.add(egressServiceSubnetsItem);
    return this;
  }

   /**
   * Used for allocating egress service source IPs. Field introduced in 17.2.8.
   * @return egressServiceSubnets
  **/
  @Schema(description = "Used for allocating egress service source IPs. Field introduced in 17.2.8.")
  public List<String> getEgressServiceSubnets() {
    return egressServiceSubnets;
  }

  public void setEgressServiceSubnets(List<String> egressServiceSubnets) {
    this.egressServiceSubnets = egressServiceSubnets;
  }

  public IpamDnsAzureProfile resourceGroup(String resourceGroup) {
    this.resourceGroup = resourceGroup;
    return this;
  }

   /**
   * Azure resource group dedicated for Avi Controller. Avi Controller will create all its resources in this resource group. Field introduced in 17.2.1.
   * @return resourceGroup
  **/
  @Schema(description = "Azure resource group dedicated for Avi Controller. Avi Controller will create all its resources in this resource group. Field introduced in 17.2.1.")
  public String getResourceGroup() {
    return resourceGroup;
  }

  public void setResourceGroup(String resourceGroup) {
    this.resourceGroup = resourceGroup;
  }

  public IpamDnsAzureProfile subscriptionId(String subscriptionId) {
    this.subscriptionId = subscriptionId;
    return this;
  }

   /**
   * Subscription Id for the Azure subscription. Field introduced in 17.2.1.
   * @return subscriptionId
  **/
  @Schema(description = "Subscription Id for the Azure subscription. Field introduced in 17.2.1.")
  public String getSubscriptionId() {
    return subscriptionId;
  }

  public void setSubscriptionId(String subscriptionId) {
    this.subscriptionId = subscriptionId;
  }

  public IpamDnsAzureProfile usableDomains(List<String> usableDomains) {
    this.usableDomains = usableDomains;
    return this;
  }

  public IpamDnsAzureProfile addUsableDomainsItem(String usableDomainsItem) {
    if (this.usableDomains == null) {
      this.usableDomains = new ArrayList<String>();
    }
    this.usableDomains.add(usableDomainsItem);
    return this;
  }

   /**
   * Usable domains to pick from Azure DNS. Field introduced in 17.2.1.
   * @return usableDomains
  **/
  @Schema(description = "Usable domains to pick from Azure DNS. Field introduced in 17.2.1.")
  public List<String> getUsableDomains() {
    return usableDomains;
  }

  public void setUsableDomains(List<String> usableDomains) {
    this.usableDomains = usableDomains;
  }

  public IpamDnsAzureProfile usableNetworkUuids(List<String> usableNetworkUuids) {
    this.usableNetworkUuids = usableNetworkUuids;
    return this;
  }

  public IpamDnsAzureProfile addUsableNetworkUuidsItem(String usableNetworkUuidsItem) {
    if (this.usableNetworkUuids == null) {
      this.usableNetworkUuids = new ArrayList<String>();
    }
    this.usableNetworkUuids.add(usableNetworkUuidsItem);
    return this;
  }

   /**
   * Usable networks for Virtual IP. If VirtualService does not specify a network and auto_allocate_ip is set, then the first available network from this list will be chosen for IP allocation. Field introduced in 17.2.1.
   * @return usableNetworkUuids
  **/
  @Schema(description = "Usable networks for Virtual IP. If VirtualService does not specify a network and auto_allocate_ip is set, then the first available network from this list will be chosen for IP allocation. Field introduced in 17.2.1.")
  public List<String> getUsableNetworkUuids() {
    return usableNetworkUuids;
  }

  public void setUsableNetworkUuids(List<String> usableNetworkUuids) {
    this.usableNetworkUuids = usableNetworkUuids;
  }

  public IpamDnsAzureProfile useEnhancedHa(Boolean useEnhancedHa) {
    this.useEnhancedHa = useEnhancedHa;
    return this;
  }

   /**
   * Use Azure&#x27;s enhanced HA features. This needs a public IP to be associated with the VIP. Field introduced in 17.2.1.
   * @return useEnhancedHa
  **/
  @Schema(description = "Use Azure's enhanced HA features. This needs a public IP to be associated with the VIP. Field introduced in 17.2.1.")
  public Boolean isUseEnhancedHa() {
    return useEnhancedHa;
  }

  public void setUseEnhancedHa(Boolean useEnhancedHa) {
    this.useEnhancedHa = useEnhancedHa;
  }

  public IpamDnsAzureProfile useStandardAlb(Boolean useStandardAlb) {
    this.useStandardAlb = useStandardAlb;
    return this;
  }

   /**
   * Use Standard SKU Azure Load Balancer. By default Basic SKU Load Balancer is used. Field introduced in 17.2.7.
   * @return useStandardAlb
  **/
  @Schema(description = "Use Standard SKU Azure Load Balancer. By default Basic SKU Load Balancer is used. Field introduced in 17.2.7.")
  public Boolean isUseStandardAlb() {
    return useStandardAlb;
  }

  public void setUseStandardAlb(Boolean useStandardAlb) {
    this.useStandardAlb = useStandardAlb;
  }

  public IpamDnsAzureProfile virtualNetworkIds(List<String> virtualNetworkIds) {
    this.virtualNetworkIds = virtualNetworkIds;
    return this;
  }

  public IpamDnsAzureProfile addVirtualNetworkIdsItem(String virtualNetworkIdsItem) {
    if (this.virtualNetworkIds == null) {
      this.virtualNetworkIds = new ArrayList<String>();
    }
    this.virtualNetworkIds.add(virtualNetworkIdsItem);
    return this;
  }

   /**
   * Virtual networks where Virtual IPs will belong. Field introduced in 17.2.1.
   * @return virtualNetworkIds
  **/
  @Schema(description = "Virtual networks where Virtual IPs will belong. Field introduced in 17.2.1.")
  public List<String> getVirtualNetworkIds() {
    return virtualNetworkIds;
  }

  public void setVirtualNetworkIds(List<String> virtualNetworkIds) {
    this.virtualNetworkIds = virtualNetworkIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IpamDnsAzureProfile ipamDnsAzureProfile = (IpamDnsAzureProfile) o;
    return Objects.equals(this.azureServiceprincipal, ipamDnsAzureProfile.azureServiceprincipal) &&
        Objects.equals(this.azureUserpass, ipamDnsAzureProfile.azureUserpass) &&
        Objects.equals(this.egressServiceSubnets, ipamDnsAzureProfile.egressServiceSubnets) &&
        Objects.equals(this.resourceGroup, ipamDnsAzureProfile.resourceGroup) &&
        Objects.equals(this.subscriptionId, ipamDnsAzureProfile.subscriptionId) &&
        Objects.equals(this.usableDomains, ipamDnsAzureProfile.usableDomains) &&
        Objects.equals(this.usableNetworkUuids, ipamDnsAzureProfile.usableNetworkUuids) &&
        Objects.equals(this.useEnhancedHa, ipamDnsAzureProfile.useEnhancedHa) &&
        Objects.equals(this.useStandardAlb, ipamDnsAzureProfile.useStandardAlb) &&
        Objects.equals(this.virtualNetworkIds, ipamDnsAzureProfile.virtualNetworkIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(azureServiceprincipal, azureUserpass, egressServiceSubnets, resourceGroup, subscriptionId, usableDomains, usableNetworkUuids, useEnhancedHa, useStandardAlb, virtualNetworkIds);
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