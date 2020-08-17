package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The IpamDnsInfobloxProfile is a POJO class extends AviRestResource that used for creating
 * IpamDnsInfobloxProfile.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IpamDnsInfobloxProfile  {
    @JsonProperty("dns_view")
    private String dnsView = "default";

    @JsonProperty("extensible_attributes")
    private List<CustomParams> extensibleAttributes = null;

    @JsonProperty("ip_address")
    private IpAddr ipAddress = null;

    @JsonProperty("network_view")
    private String networkView = "default";

    @JsonProperty("password")
    private String password = null;

    @JsonProperty("usable_alloc_subnets")
    private List<InfobloxSubnet> usableAllocSubnets = null;

    @JsonProperty("usable_domains")
    private List<String> usableDomains = null;

    @JsonProperty("usable_subnets")
    private List<IpAddrPrefix> usableSubnets = null;

    @JsonProperty("username")
    private String username = null;

    @JsonProperty("wapi_version")
    private String wapiVersion = "2.0";



  /**
   * This is the getter method this will return the attribute value.
   * Dns view.
   * Default value when not specified in API or module is interpreted by Avi Controller as default.
   * @return dnsView
   */
  public String getDnsView() {
    return dnsView;
  }

  /**
   * This is the setter method to the attribute.
   * Dns view.
   * Default value when not specified in API or module is interpreted by Avi Controller as default.
   * @param dnsView set the dnsView.
   */
  public void setDnsView(String  dnsView) {
    this.dnsView = dnsView;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Custom parameters that will passed to the infoblox provider as extensible attributes.
   * Field introduced in 18.2.7, 20.1.1.
   * @return extensibleAttributes
   */
  public List<CustomParams> getExtensibleAttributes() {
    return extensibleAttributes;
  }

  /**
   * This is the setter method. this will set the extensibleAttributes
   * Custom parameters that will passed to the infoblox provider as extensible attributes.
   * Field introduced in 18.2.7, 20.1.1.
   * @return extensibleAttributes
   */
  public void setExtensibleAttributes(List<CustomParams>  extensibleAttributes) {
    this.extensibleAttributes = extensibleAttributes;
  }

  /**
   * This is the setter method this will set the extensibleAttributes
   * Custom parameters that will passed to the infoblox provider as extensible attributes.
   * Field introduced in 18.2.7, 20.1.1.
   * @return extensibleAttributes
   */
  public IpamDnsInfobloxProfile addExtensibleAttributesItem(CustomParams extensibleAttributesItem) {
    if (this.extensibleAttributes == null) {
      this.extensibleAttributes = new ArrayList<CustomParams>();
    }
    this.extensibleAttributes.add(extensibleAttributesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Address of infoblox appliance.
   * @return ipAddress
   */
  public IpAddr getIpAddress() {
    return ipAddress;
  }

  /**
   * This is the setter method to the attribute.
   * Address of infoblox appliance.
   * @param ipAddress set the ipAddress.
   */
  public void setIpAddress(IpAddr ipAddress) {
    this.ipAddress = ipAddress;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Network view.
   * Default value when not specified in API or module is interpreted by Avi Controller as default.
   * @return networkView
   */
  public String getNetworkView() {
    return networkView;
  }

  /**
   * This is the setter method to the attribute.
   * Network view.
   * Default value when not specified in API or module is interpreted by Avi Controller as default.
   * @param networkView set the networkView.
   */
  public void setNetworkView(String  networkView) {
    this.networkView = networkView;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Password for api access for infoblox appliance.
   * @return password
   */
  public String getPassword() {
    return password;
  }

  /**
   * This is the setter method to the attribute.
   * Password for api access for infoblox appliance.
   * @param password set the password.
   */
  public void setPassword(String  password) {
    this.password = password;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Subnets to use for infoblox ip allocation.
   * Field introduced in 18.2.8, 20.1.1.
   * @return usableAllocSubnets
   */
  public List<InfobloxSubnet> getUsableAllocSubnets() {
    return usableAllocSubnets;
  }

  /**
   * This is the setter method. this will set the usableAllocSubnets
   * Subnets to use for infoblox ip allocation.
   * Field introduced in 18.2.8, 20.1.1.
   * @return usableAllocSubnets
   */
  public void setUsableAllocSubnets(List<InfobloxSubnet>  usableAllocSubnets) {
    this.usableAllocSubnets = usableAllocSubnets;
  }

  /**
   * This is the setter method this will set the usableAllocSubnets
   * Subnets to use for infoblox ip allocation.
   * Field introduced in 18.2.8, 20.1.1.
   * @return usableAllocSubnets
   */
  public IpamDnsInfobloxProfile addUsableAllocSubnetsItem(InfobloxSubnet usableAllocSubnetsItem) {
    if (this.usableAllocSubnets == null) {
      this.usableAllocSubnets = new ArrayList<InfobloxSubnet>();
    }
    this.usableAllocSubnets.add(usableAllocSubnetsItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Usable domains to pick from infoblox.
   * @return usableDomains
   */
  public List<String> getUsableDomains() {
    return usableDomains;
  }

  /**
   * This is the setter method. this will set the usableDomains
   * Usable domains to pick from infoblox.
   * @return usableDomains
   */
  public void setUsableDomains(List<String>  usableDomains) {
    this.usableDomains = usableDomains;
  }

  /**
   * This is the setter method this will set the usableDomains
   * Usable domains to pick from infoblox.
   * @return usableDomains
   */
  public IpamDnsInfobloxProfile addUsableDomainsItem(String usableDomainsItem) {
    if (this.usableDomains == null) {
      this.usableDomains = new ArrayList<String>();
    }
    this.usableDomains.add(usableDomainsItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * This field is deprecated, use usable_alloc_subnets instead.
   * Field deprecated in 18.2.8.
   * @return usableSubnets
   */
  public List<IpAddrPrefix> getUsableSubnets() {
    return usableSubnets;
  }

  /**
   * This is the setter method. this will set the usableSubnets
   * This field is deprecated, use usable_alloc_subnets instead.
   * Field deprecated in 18.2.8.
   * @return usableSubnets
   */
  public void setUsableSubnets(List<IpAddrPrefix>  usableSubnets) {
    this.usableSubnets = usableSubnets;
  }

  /**
   * This is the setter method this will set the usableSubnets
   * This field is deprecated, use usable_alloc_subnets instead.
   * Field deprecated in 18.2.8.
   * @return usableSubnets
   */
  public IpamDnsInfobloxProfile addUsableSubnetsItem(IpAddrPrefix usableSubnetsItem) {
    if (this.usableSubnets == null) {
      this.usableSubnets = new ArrayList<IpAddrPrefix>();
    }
    this.usableSubnets.add(usableSubnetsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Username for api access for infoblox appliance.
   * @return username
   */
  public String getUsername() {
    return username;
  }

  /**
   * This is the setter method to the attribute.
   * Username for api access for infoblox appliance.
   * @param username set the username.
   */
  public void setUsername(String  username) {
    this.username = username;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Wapi version.
   * Default value when not specified in API or module is interpreted by Avi Controller as 2.0.
   * @return wapiVersion
   */
  public String getWapiVersion() {
    return wapiVersion;
  }

  /**
   * This is the setter method to the attribute.
   * Wapi version.
   * Default value when not specified in API or module is interpreted by Avi Controller as 2.0.
   * @param wapiVersion set the wapiVersion.
   */
  public void setWapiVersion(String  wapiVersion) {
    this.wapiVersion = wapiVersion;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  IpamDnsInfobloxProfile objIpamDnsInfobloxProfile = (IpamDnsInfobloxProfile) o;
  return   Objects.equals(this.ipAddress, objIpamDnsInfobloxProfile.ipAddress)&&
  Objects.equals(this.username, objIpamDnsInfobloxProfile.username)&&
  Objects.equals(this.password, objIpamDnsInfobloxProfile.password)&&
  Objects.equals(this.wapiVersion, objIpamDnsInfobloxProfile.wapiVersion)&&
  Objects.equals(this.dnsView, objIpamDnsInfobloxProfile.dnsView)&&
  Objects.equals(this.networkView, objIpamDnsInfobloxProfile.networkView)&&
  Objects.equals(this.usableSubnets, objIpamDnsInfobloxProfile.usableSubnets)&&
  Objects.equals(this.usableDomains, objIpamDnsInfobloxProfile.usableDomains)&&
  Objects.equals(this.extensibleAttributes, objIpamDnsInfobloxProfile.extensibleAttributes)&&
  Objects.equals(this.usableAllocSubnets, objIpamDnsInfobloxProfile.usableAllocSubnets);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class IpamDnsInfobloxProfile {\n");
      sb.append("    dnsView: ").append(toIndentedString(dnsView)).append("\n");
        sb.append("    extensibleAttributes: ").append(toIndentedString(extensibleAttributes)).append("\n");
        sb.append("    ipAddress: ").append(toIndentedString(ipAddress)).append("\n");
        sb.append("    networkView: ").append(toIndentedString(networkView)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
        sb.append("    usableAllocSubnets: ").append(toIndentedString(usableAllocSubnets)).append("\n");
        sb.append("    usableDomains: ").append(toIndentedString(usableDomains)).append("\n");
        sb.append("    usableSubnets: ").append(toIndentedString(usableSubnets)).append("\n");
        sb.append("    username: ").append(toIndentedString(username)).append("\n");
        sb.append("    wapiVersion: ").append(toIndentedString(wapiVersion)).append("\n");
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

