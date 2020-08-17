package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DnsRrSet is a POJO class extends AviRestResource that used for creating
 * DnsRrSet.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DnsRrSet  {
    @JsonProperty("cname")
    private DnsCnameRdata cname = null;

    @JsonProperty("fqdn")
    private String fqdn = null;

    @JsonProperty("ip6_addresses")
    private List<DnsAAAARdata> ip6Addresses = null;

    @JsonProperty("ip_addresses")
    private List<DnsARdata> ipAddresses = null;

    @JsonProperty("nses")
    private List<DnsNsRdata> nses = null;

    @JsonProperty("ttl")
    private Integer ttl = null;

    @JsonProperty("type")
    private String type = null;



  /**
   * This is the getter method this will return the attribute value.
   * Canonical name in cname record.
   * Field introduced in 17.2.12, 18.1.2.
   * @return cname
   */
  public DnsCnameRdata getCname() {
    return cname;
  }

  /**
   * This is the setter method to the attribute.
   * Canonical name in cname record.
   * Field introduced in 17.2.12, 18.1.2.
   * @param cname set the cname.
   */
  public void setCname(DnsCnameRdata cname) {
    this.cname = cname;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Fully qualified domain name.
   * Field introduced in 17.2.12, 18.1.2.
   * @return fqdn
   */
  public String getFqdn() {
    return fqdn;
  }

  /**
   * This is the setter method to the attribute.
   * Fully qualified domain name.
   * Field introduced in 17.2.12, 18.1.2.
   * @param fqdn set the fqdn.
   */
  public void setFqdn(String  fqdn) {
    this.fqdn = fqdn;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Ipv6 address in aaaa record.
   * Field introduced in 18.1.2.
   * @return ip6Addresses
   */
  public List<DnsAAAARdata> getIp6Addresses() {
    return ip6Addresses;
  }

  /**
   * This is the setter method. this will set the ip6Addresses
   * Ipv6 address in aaaa record.
   * Field introduced in 18.1.2.
   * @return ip6Addresses
   */
  public void setIp6Addresses(List<DnsAAAARdata>  ip6Addresses) {
    this.ip6Addresses = ip6Addresses;
  }

  /**
   * This is the setter method this will set the ip6Addresses
   * Ipv6 address in aaaa record.
   * Field introduced in 18.1.2.
   * @return ip6Addresses
   */
  public DnsRrSet addIp6AddressesItem(DnsAAAARdata ip6AddressesItem) {
    if (this.ip6Addresses == null) {
      this.ip6Addresses = new ArrayList<DnsAAAARdata>();
    }
    this.ip6Addresses.add(ip6AddressesItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Ip address in a record.
   * Field introduced in 17.2.12, 18.1.2.
   * @return ipAddresses
   */
  public List<DnsARdata> getIpAddresses() {
    return ipAddresses;
  }

  /**
   * This is the setter method. this will set the ipAddresses
   * Ip address in a record.
   * Field introduced in 17.2.12, 18.1.2.
   * @return ipAddresses
   */
  public void setIpAddresses(List<DnsARdata>  ipAddresses) {
    this.ipAddresses = ipAddresses;
  }

  /**
   * This is the setter method this will set the ipAddresses
   * Ip address in a record.
   * Field introduced in 17.2.12, 18.1.2.
   * @return ipAddresses
   */
  public DnsRrSet addIpAddressesItem(DnsARdata ipAddressesItem) {
    if (this.ipAddresses == null) {
      this.ipAddresses = new ArrayList<DnsARdata>();
    }
    this.ipAddresses.add(ipAddressesItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Name server information in ns record.
   * Field introduced in 17.2.12, 18.1.2.
   * @return nses
   */
  public List<DnsNsRdata> getNses() {
    return nses;
  }

  /**
   * This is the setter method. this will set the nses
   * Name server information in ns record.
   * Field introduced in 17.2.12, 18.1.2.
   * @return nses
   */
  public void setNses(List<DnsNsRdata>  nses) {
    this.nses = nses;
  }

  /**
   * This is the setter method this will set the nses
   * Name server information in ns record.
   * Field introduced in 17.2.12, 18.1.2.
   * @return nses
   */
  public DnsRrSet addNsesItem(DnsNsRdata nsesItem) {
    if (this.nses == null) {
      this.nses = new ArrayList<DnsNsRdata>();
    }
    this.nses.add(nsesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Time to live for this dns record.
   * Allowed values are 0-2147483647.
   * Field introduced in 17.2.12, 18.1.2.
   * @return ttl
   */
  public Integer getTtl() {
    return ttl;
  }

  /**
   * This is the setter method to the attribute.
   * Time to live for this dns record.
   * Allowed values are 0-2147483647.
   * Field introduced in 17.2.12, 18.1.2.
   * @param ttl set the ttl.
   */
  public void setTtl(Integer  ttl) {
    this.ttl = ttl;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dns record type.
   * Enum options - DNS_RECORD_OTHER, DNS_RECORD_A, DNS_RECORD_NS, DNS_RECORD_CNAME, DNS_RECORD_SOA, DNS_RECORD_PTR, DNS_RECORD_HINFO, DNS_RECORD_MX,
   * DNS_RECORD_TXT, DNS_RECORD_RP, DNS_RECORD_DNSKEY, DNS_RECORD_AAAA, DNS_RECORD_SRV, DNS_RECORD_OPT, DNS_RECORD_RRSIG, DNS_RECORD_AXFR,
   * DNS_RECORD_ANY.
   * Field introduced in 17.2.12, 18.1.2.
   * @return type
   */
  public String getType() {
    return type;
  }

  /**
   * This is the setter method to the attribute.
   * Dns record type.
   * Enum options - DNS_RECORD_OTHER, DNS_RECORD_A, DNS_RECORD_NS, DNS_RECORD_CNAME, DNS_RECORD_SOA, DNS_RECORD_PTR, DNS_RECORD_HINFO, DNS_RECORD_MX,
   * DNS_RECORD_TXT, DNS_RECORD_RP, DNS_RECORD_DNSKEY, DNS_RECORD_AAAA, DNS_RECORD_SRV, DNS_RECORD_OPT, DNS_RECORD_RRSIG, DNS_RECORD_AXFR,
   * DNS_RECORD_ANY.
   * Field introduced in 17.2.12, 18.1.2.
   * @param type set the type.
   */
  public void setType(String  type) {
    this.type = type;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  DnsRrSet objDnsRrSet = (DnsRrSet) o;
  return   Objects.equals(this.fqdn, objDnsRrSet.fqdn)&&
  Objects.equals(this.type, objDnsRrSet.type)&&
  Objects.equals(this.ttl, objDnsRrSet.ttl)&&
  Objects.equals(this.ipAddresses, objDnsRrSet.ipAddresses)&&
  Objects.equals(this.cname, objDnsRrSet.cname)&&
  Objects.equals(this.nses, objDnsRrSet.nses)&&
  Objects.equals(this.ip6Addresses, objDnsRrSet.ip6Addresses);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DnsRrSet {\n");
      sb.append("    cname: ").append(toIndentedString(cname)).append("\n");
        sb.append("    fqdn: ").append(toIndentedString(fqdn)).append("\n");
        sb.append("    ip6Addresses: ").append(toIndentedString(ip6Addresses)).append("\n");
        sb.append("    ipAddresses: ").append(toIndentedString(ipAddresses)).append("\n");
        sb.append("    nses: ").append(toIndentedString(nses)).append("\n");
        sb.append("    ttl: ").append(toIndentedString(ttl)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

