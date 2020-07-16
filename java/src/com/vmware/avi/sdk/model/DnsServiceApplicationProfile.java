package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DnsServiceApplicationProfile is a POJO class extends AviRestResource that used for creating
 * DnsServiceApplicationProfile.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DnsServiceApplicationProfile  {
    @JsonProperty("aaaa_empty_response")
    private Boolean aaaaEmptyResponse = true;

    @JsonProperty("admin_email")
    private String adminEmail = "hostmaster";

    @JsonProperty("authoritative_domain_names")
    private List<String> authoritativeDomainNames = null;

    @JsonProperty("dns_over_tcp_enabled")
    private Boolean dnsOverTcpEnabled = true;

    @JsonProperty("dns_zones")
    private List<DnsZone> dnsZones = null;

    @JsonProperty("domain_names")
    private List<String> domainNames = null;

    @JsonProperty("ecs_stripping_enabled")
    private Boolean ecsStrippingEnabled = true;

    @JsonProperty("edns")
    private Boolean edns = true;

    @JsonProperty("edns_client_subnet_prefix_len")
    private Integer ednsClientSubnetPrefixLen = null;

    @JsonProperty("error_response")
    private String errorResponse = "DNS_ERROR_RESPONSE_NONE";

    @JsonProperty("name_server")
    private String nameServer = null;

    @JsonProperty("negative_caching_ttl")
    private Integer negativeCachingTtl = 30;

    @JsonProperty("num_dns_ip")
    private Integer numDnsIp = 1;

    @JsonProperty("ttl")
    private Integer ttl = 30;



  /**
   * This is the getter method this will return the attribute value.
   * Respond to aaaa queries with empty response when there are only ipv4 records.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return aaaaEmptyResponse
   */
  public Boolean getAaaaEmptyResponse() {
    return aaaaEmptyResponse;
  }

  /**
   * This is the setter method to the attribute.
   * Respond to aaaa queries with empty response when there are only ipv4 records.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param aaaaEmptyResponse set the aaaaEmptyResponse.
   */
  public void setAaaaEmptyResponse(Boolean  aaaaEmptyResponse) {
    this.aaaaEmptyResponse = aaaaEmptyResponse;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Email address of the administrator responsible for this zone.
   * This field is used in soa records (rname) pertaining to all domain names specified as authoritative domain names.
   * If not configured, the default value 'hostmaster' is used in soa responses.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as hostmaster.
   * @return adminEmail
   */
  public String getAdminEmail() {
    return adminEmail;
  }

  /**
   * This is the setter method to the attribute.
   * Email address of the administrator responsible for this zone.
   * This field is used in soa records (rname) pertaining to all domain names specified as authoritative domain names.
   * If not configured, the default value 'hostmaster' is used in soa responses.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as hostmaster.
   * @param adminEmail set the adminEmail.
   */
  public void setAdminEmail(String  adminEmail) {
    this.adminEmail = adminEmail;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Domain names authoritatively serviced by this virtual service.
   * These are configured as ends-with semantics.
   * Queries for fqdns that are subdomains of this domain and do not have any dns record in avi are dropped or nxdomain response sent.
   * Field deprecated in 18.2.6.
   * Field introduced in 17.1.6,17.2.2.
   * @return authoritativeDomainNames
   */
  public List<String> getAuthoritativeDomainNames() {
    return authoritativeDomainNames;
  }

  /**
   * This is the setter method. this will set the authoritativeDomainNames
   * Domain names authoritatively serviced by this virtual service.
   * These are configured as ends-with semantics.
   * Queries for fqdns that are subdomains of this domain and do not have any dns record in avi are dropped or nxdomain response sent.
   * Field deprecated in 18.2.6.
   * Field introduced in 17.1.6,17.2.2.
   * @return authoritativeDomainNames
   */
  public void setAuthoritativeDomainNames(List<String>  authoritativeDomainNames) {
    this.authoritativeDomainNames = authoritativeDomainNames;
  }

  /**
   * This is the setter method this will set the authoritativeDomainNames
   * Domain names authoritatively serviced by this virtual service.
   * These are configured as ends-with semantics.
   * Queries for fqdns that are subdomains of this domain and do not have any dns record in avi are dropped or nxdomain response sent.
   * Field deprecated in 18.2.6.
   * Field introduced in 17.1.6,17.2.2.
   * @return authoritativeDomainNames
   */
  public DnsServiceApplicationProfile addAuthoritativeDomainNamesItem(String authoritativeDomainNamesItem) {
    if (this.authoritativeDomainNames == null) {
      this.authoritativeDomainNames = new ArrayList<String>();
    }
    this.authoritativeDomainNames.add(authoritativeDomainNamesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable dns query/response over tcp.
   * This enables analytics for pass-through queries as well.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return dnsOverTcpEnabled
   */
  public Boolean getDnsOverTcpEnabled() {
    return dnsOverTcpEnabled;
  }

  /**
   * This is the setter method to the attribute.
   * Enable dns query/response over tcp.
   * This enables analytics for pass-through queries as well.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param dnsOverTcpEnabled set the dnsOverTcpEnabled.
   */
  public void setDnsOverTcpEnabled(Boolean  dnsOverTcpEnabled) {
    this.dnsOverTcpEnabled = dnsOverTcpEnabled;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Dns zones hosted on this virtual service.
   * Field introduced in 18.2.6.
   * @return dnsZones
   */
  public List<DnsZone> getDnsZones() {
    return dnsZones;
  }

  /**
   * This is the setter method. this will set the dnsZones
   * Dns zones hosted on this virtual service.
   * Field introduced in 18.2.6.
   * @return dnsZones
   */
  public void setDnsZones(List<DnsZone>  dnsZones) {
    this.dnsZones = dnsZones;
  }

  /**
   * This is the setter method this will set the dnsZones
   * Dns zones hosted on this virtual service.
   * Field introduced in 18.2.6.
   * @return dnsZones
   */
  public DnsServiceApplicationProfile addDnsZonesItem(DnsZone dnsZonesItem) {
    if (this.dnsZones == null) {
      this.dnsZones = new ArrayList<DnsZone>();
    }
    this.dnsZones.add(dnsZonesItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Subdomain names serviced by this virtual service.
   * These are configured as ends-with semantics.
   * @return domainNames
   */
  public List<String> getDomainNames() {
    return domainNames;
  }

  /**
   * This is the setter method. this will set the domainNames
   * Subdomain names serviced by this virtual service.
   * These are configured as ends-with semantics.
   * @return domainNames
   */
  public void setDomainNames(List<String>  domainNames) {
    this.domainNames = domainNames;
  }

  /**
   * This is the setter method this will set the domainNames
   * Subdomain names serviced by this virtual service.
   * These are configured as ends-with semantics.
   * @return domainNames
   */
  public DnsServiceApplicationProfile addDomainNamesItem(String domainNamesItem) {
    if (this.domainNames == null) {
      this.domainNames = new ArrayList<String>();
    }
    this.domainNames.add(domainNamesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable stripping of edns client subnet (ecs) option towards client if dns service inserts ecs option in the dns query towards upstream servers.
   * Field introduced in 17.1.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return ecsStrippingEnabled
   */
  public Boolean getEcsStrippingEnabled() {
    return ecsStrippingEnabled;
  }

  /**
   * This is the setter method to the attribute.
   * Enable stripping of edns client subnet (ecs) option towards client if dns service inserts ecs option in the dns query towards upstream servers.
   * Field introduced in 17.1.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param ecsStrippingEnabled set the ecsStrippingEnabled.
   */
  public void setEcsStrippingEnabled(Boolean  ecsStrippingEnabled) {
    this.ecsStrippingEnabled = ecsStrippingEnabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable dns service to be aware of edns (extension mechanism for dns).
   * Edns extensions are parsed and shown in logs.
   * For gslb services, the edns client subnet option can be used to influence load balancing.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return edns
   */
  public Boolean getEdns() {
    return edns;
  }

  /**
   * This is the setter method to the attribute.
   * Enable dns service to be aware of edns (extension mechanism for dns).
   * Edns extensions are parsed and shown in logs.
   * For gslb services, the edns client subnet option can be used to influence load balancing.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param edns set the edns.
   */
  public void setEdns(Boolean  edns) {
    this.edns = edns;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Specifies the ip address prefix length to use in the edns client subnet (ecs) option.
   * When the incoming request does not have any ecs option and the prefix length is specified, an ecs option is inserted in the request passed to
   * upstream server.
   * If the incoming request already has an ecs option, the prefix length (and correspondingly the address) in the ecs option is updated, with the
   * minimum of the prefix length present in the incoming and the configured prefix length, before passing the request to upstream server.
   * Allowed values are 1-32.
   * Field introduced in 17.1.3.
   * @return ednsClientSubnetPrefixLen
   */
  public Integer getEdnsClientSubnetPrefixLen() {
    return ednsClientSubnetPrefixLen;
  }

  /**
   * This is the setter method to the attribute.
   * Specifies the ip address prefix length to use in the edns client subnet (ecs) option.
   * When the incoming request does not have any ecs option and the prefix length is specified, an ecs option is inserted in the request passed to
   * upstream server.
   * If the incoming request already has an ecs option, the prefix length (and correspondingly the address) in the ecs option is updated, with the
   * minimum of the prefix length present in the incoming and the configured prefix length, before passing the request to upstream server.
   * Allowed values are 1-32.
   * Field introduced in 17.1.3.
   * @param ednsClientSubnetPrefixLen set the ednsClientSubnetPrefixLen.
   */
  public void setEdnsClientSubnetPrefixLen(Integer  ednsClientSubnetPrefixLen) {
    this.ednsClientSubnetPrefixLen = ednsClientSubnetPrefixLen;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Drop or respond to client when the dns service encounters an error processing a client query.
   * By default, such a request is dropped without any response, or passed through to a passthrough pool, if configured.
   * When set to respond, an appropriate response is sent to client, e.g.
   * Nxdomain response for non-existent records, empty noerror response for unsupported queries, etc.
   * Enum options - DNS_ERROR_RESPONSE_ERROR, DNS_ERROR_RESPONSE_NONE.
   * Default value when not specified in API or module is interpreted by Avi Controller as DNS_ERROR_RESPONSE_NONE.
   * @return errorResponse
   */
  public String getErrorResponse() {
    return errorResponse;
  }

  /**
   * This is the setter method to the attribute.
   * Drop or respond to client when the dns service encounters an error processing a client query.
   * By default, such a request is dropped without any response, or passed through to a passthrough pool, if configured.
   * When set to respond, an appropriate response is sent to client, e.g.
   * Nxdomain response for non-existent records, empty noerror response for unsupported queries, etc.
   * Enum options - DNS_ERROR_RESPONSE_ERROR, DNS_ERROR_RESPONSE_NONE.
   * Default value when not specified in API or module is interpreted by Avi Controller as DNS_ERROR_RESPONSE_NONE.
   * @param errorResponse set the errorResponse.
   */
  public void setErrorResponse(String  errorResponse) {
    this.errorResponse = errorResponse;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The <domain-name>  of the name server that was the original or primary source of data for this zone.
   * This field is used in soa records (mname) pertaining to all domain names specified as authoritative domain names.
   * If not configured, domain name is used as name server in soa response.
   * Field introduced in 18.2.5.
   * @return nameServer
   */
  public String getNameServer() {
    return nameServer;
  }

  /**
   * This is the setter method to the attribute.
   * The <domain-name>  of the name server that was the original or primary source of data for this zone.
   * This field is used in soa records (mname) pertaining to all domain names specified as authoritative domain names.
   * If not configured, domain name is used as name server in soa response.
   * Field introduced in 18.2.5.
   * @param nameServer set the nameServer.
   */
  public void setNameServer(String  nameServer) {
    this.nameServer = nameServer;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Specifies the ttl value (in seconds) for soa (start of authority) (corresponding to a authoritative domain owned by this dns virtual service)
   * record's minimum ttl served by the dns virtual service.
   * Allowed values are 0-86400.
   * Field introduced in 17.2.4.
   * Default value when not specified in API or module is interpreted by Avi Controller as 30.
   * @return negativeCachingTtl
   */
  public Integer getNegativeCachingTtl() {
    return negativeCachingTtl;
  }

  /**
   * This is the setter method to the attribute.
   * Specifies the ttl value (in seconds) for soa (start of authority) (corresponding to a authoritative domain owned by this dns virtual service)
   * record's minimum ttl served by the dns virtual service.
   * Allowed values are 0-86400.
   * Field introduced in 17.2.4.
   * Default value when not specified in API or module is interpreted by Avi Controller as 30.
   * @param negativeCachingTtl set the negativeCachingTtl.
   */
  public void setNegativeCachingTtl(Integer  negativeCachingTtl) {
    this.negativeCachingTtl = negativeCachingTtl;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Specifies the number of ip addresses returned by the dns service.
   * Enter 0 to return all ip addresses.
   * Allowed values are 1-20.
   * Special values are 0- 'return all ip addresses'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.
   * @return numDnsIp
   */
  public Integer getNumDnsIp() {
    return numDnsIp;
  }

  /**
   * This is the setter method to the attribute.
   * Specifies the number of ip addresses returned by the dns service.
   * Enter 0 to return all ip addresses.
   * Allowed values are 1-20.
   * Special values are 0- 'return all ip addresses'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.
   * @param numDnsIp set the numDnsIp.
   */
  public void setNumDnsIp(Integer  numDnsIp) {
    this.numDnsIp = numDnsIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Specifies the ttl value (in seconds) for records served by dns service.
   * Allowed values are 0-86400.
   * Default value when not specified in API or module is interpreted by Avi Controller as 30.
   * @return ttl
   */
  public Integer getTtl() {
    return ttl;
  }

  /**
   * This is the setter method to the attribute.
   * Specifies the ttl value (in seconds) for records served by dns service.
   * Allowed values are 0-86400.
   * Default value when not specified in API or module is interpreted by Avi Controller as 30.
   * @param ttl set the ttl.
   */
  public void setTtl(Integer  ttl) {
    this.ttl = ttl;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  DnsServiceApplicationProfile objDnsServiceApplicationProfile = (DnsServiceApplicationProfile) o;
  return   Objects.equals(this.dnsOverTcpEnabled, objDnsServiceApplicationProfile.dnsOverTcpEnabled)&&
  Objects.equals(this.errorResponse, objDnsServiceApplicationProfile.errorResponse)&&
  Objects.equals(this.nameServer, objDnsServiceApplicationProfile.nameServer)&&
  Objects.equals(this.ecsStrippingEnabled, objDnsServiceApplicationProfile.ecsStrippingEnabled)&&
  Objects.equals(this.authoritativeDomainNames, objDnsServiceApplicationProfile.authoritativeDomainNames)&&
  Objects.equals(this.domainNames, objDnsServiceApplicationProfile.domainNames)&&
  Objects.equals(this.negativeCachingTtl, objDnsServiceApplicationProfile.negativeCachingTtl)&&
  Objects.equals(this.aaaaEmptyResponse, objDnsServiceApplicationProfile.aaaaEmptyResponse)&&
  Objects.equals(this.numDnsIp, objDnsServiceApplicationProfile.numDnsIp)&&
  Objects.equals(this.ednsClientSubnetPrefixLen, objDnsServiceApplicationProfile.ednsClientSubnetPrefixLen)&&
  Objects.equals(this.ttl, objDnsServiceApplicationProfile.ttl)&&
  Objects.equals(this.edns, objDnsServiceApplicationProfile.edns)&&
  Objects.equals(this.adminEmail, objDnsServiceApplicationProfile.adminEmail)&&
  Objects.equals(this.dnsZones, objDnsServiceApplicationProfile.dnsZones);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DnsServiceApplicationProfile {\n");
      sb.append("    aaaaEmptyResponse: ").append(toIndentedString(aaaaEmptyResponse)).append("\n");
        sb.append("    adminEmail: ").append(toIndentedString(adminEmail)).append("\n");
        sb.append("    authoritativeDomainNames: ").append(toIndentedString(authoritativeDomainNames)).append("\n");
        sb.append("    dnsOverTcpEnabled: ").append(toIndentedString(dnsOverTcpEnabled)).append("\n");
        sb.append("    dnsZones: ").append(toIndentedString(dnsZones)).append("\n");
        sb.append("    domainNames: ").append(toIndentedString(domainNames)).append("\n");
        sb.append("    ecsStrippingEnabled: ").append(toIndentedString(ecsStrippingEnabled)).append("\n");
        sb.append("    edns: ").append(toIndentedString(edns)).append("\n");
        sb.append("    ednsClientSubnetPrefixLen: ").append(toIndentedString(ednsClientSubnetPrefixLen)).append("\n");
        sb.append("    errorResponse: ").append(toIndentedString(errorResponse)).append("\n");
        sb.append("    nameServer: ").append(toIndentedString(nameServer)).append("\n");
        sb.append("    negativeCachingTtl: ").append(toIndentedString(negativeCachingTtl)).append("\n");
        sb.append("    numDnsIp: ").append(toIndentedString(numDnsIp)).append("\n");
        sb.append("    ttl: ").append(toIndentedString(ttl)).append("\n");
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

