package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The IpamDnsInternalProfile is a POJO class extends AviRestResource that used for creating
 * IpamDnsInternalProfile.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IpamDnsInternalProfile  {
    @JsonProperty("dns_service_domain")
    private List<DnsServiceDomain> dnsServiceDomain = null;

    @JsonProperty("dns_virtualservice_ref")
    private String dnsVirtualserviceRef = null;

    @JsonProperty("ttl")
    private Integer ttl = 30;

    @JsonProperty("usable_network_refs")
    private List<String> usableNetworkRefs = null;


  /**
   * This is the getter method this will return the attribute value.
   * List of service domains.
   * @return dnsServiceDomain
   */
  public List<DnsServiceDomain> getDnsServiceDomain() {
    return dnsServiceDomain;
  }

  /**
   * This is the setter method. this will set the dnsServiceDomain
   * List of service domains.
   * @return dnsServiceDomain
   */
  public void setDnsServiceDomain(List<DnsServiceDomain>  dnsServiceDomain) {
    this.dnsServiceDomain = dnsServiceDomain;
  }

  /**
   * This is the setter method this will set the dnsServiceDomain
   * List of service domains.
   * @return dnsServiceDomain
   */
  public IpamDnsInternalProfile addDnsServiceDomainItem(DnsServiceDomain dnsServiceDomainItem) {
    if (this.dnsServiceDomain == null) {
      this.dnsServiceDomain = new ArrayList<DnsServiceDomain>();
    }
    this.dnsServiceDomain.add(dnsServiceDomainItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Avi virtualservice to be used for serving dns records.
   * It is a reference to an object of type virtualservice.
   * @return dnsVirtualserviceRef
   */
  public String getDnsVirtualserviceRef() {
    return dnsVirtualserviceRef;
  }

  /**
   * This is the setter method to the attribute.
   * Avi virtualservice to be used for serving dns records.
   * It is a reference to an object of type virtualservice.
   * @param dnsVirtualserviceRef set the dnsVirtualserviceRef.
   */
  public void setDnsVirtualserviceRef(String  dnsVirtualserviceRef) {
    this.dnsVirtualserviceRef = dnsVirtualserviceRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Default ttl for all records, overridden by ttl value for each service domain configured in dnsservicedomain.
   * Allowed values are 1-604800.
   * Default value when not specified in API or module is interpreted by Avi Controller as 30.
   * @return ttl
   */
  public Integer getTtl() {
    return ttl;
  }

  /**
   * This is the setter method to the attribute.
   * Default ttl for all records, overridden by ttl value for each service domain configured in dnsservicedomain.
   * Allowed values are 1-604800.
   * Default value when not specified in API or module is interpreted by Avi Controller as 30.
   * @param ttl set the ttl.
   */
  public void setTtl(Integer  ttl) {
    this.ttl = ttl;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Usable networks for virtual ip.
   * If virtualservice does not specify a network and auto_allocate_ip is set, then the first available network from this list will be chosen for ip
   * allocation.
   * It is a reference to an object of type network.
   * @return usableNetworkRefs
   */
  public List<String> getUsableNetworkRefs() {
    return usableNetworkRefs;
  }

  /**
   * This is the setter method. this will set the usableNetworkRefs
   * Usable networks for virtual ip.
   * If virtualservice does not specify a network and auto_allocate_ip is set, then the first available network from this list will be chosen for ip
   * allocation.
   * It is a reference to an object of type network.
   * @return usableNetworkRefs
   */
  public void setUsableNetworkRefs(List<String>  usableNetworkRefs) {
    this.usableNetworkRefs = usableNetworkRefs;
  }

  /**
   * This is the setter method this will set the usableNetworkRefs
   * Usable networks for virtual ip.
   * If virtualservice does not specify a network and auto_allocate_ip is set, then the first available network from this list will be chosen for ip
   * allocation.
   * It is a reference to an object of type network.
   * @return usableNetworkRefs
   */
  public IpamDnsInternalProfile addUsableNetworkRefsItem(String usableNetworkRefsItem) {
    if (this.usableNetworkRefs == null) {
      this.usableNetworkRefs = new ArrayList<String>();
    }
    this.usableNetworkRefs.add(usableNetworkRefsItem);
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
  IpamDnsInternalProfile objIpamDnsInternalProfile = (IpamDnsInternalProfile) o;
  return   Objects.equals(this.dnsServiceDomain, objIpamDnsInternalProfile.dnsServiceDomain)&&
  Objects.equals(this.ttl, objIpamDnsInternalProfile.ttl)&&
  Objects.equals(this.dnsVirtualserviceRef, objIpamDnsInternalProfile.dnsVirtualserviceRef)&&
  Objects.equals(this.usableNetworkRefs, objIpamDnsInternalProfile.usableNetworkRefs);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class IpamDnsInternalProfile {\n");
      sb.append("    dnsServiceDomain: ").append(toIndentedString(dnsServiceDomain)).append("\n");
        sb.append("    dnsVirtualserviceRef: ").append(toIndentedString(dnsVirtualserviceRef)).append("\n");
        sb.append("    ttl: ").append(toIndentedString(ttl)).append("\n");
        sb.append("    usableNetworkRefs: ").append(toIndentedString(usableNetworkRefs)).append("\n");
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

