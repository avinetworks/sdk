package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The DynamicDnsRecord is a POJO class extends AviRestResource that used for creating
 * DynamicDnsRecord.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DynamicDnsRecord extends AviRestResource  {
    @JsonProperty("algorithm")
    private String algorithm = "DNS_RECORD_RESPONSE_ROUND_ROBIN";

    @JsonProperty("cname")
    private DnsCnameRdata cname = null;

    @JsonProperty("delegated")
    private Boolean delegated = false;

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("dns_vs_uuid")
    private String dnsVsUuid = null;

    @JsonProperty("fqdn")
    private String fqdn = null;

    @JsonProperty("ip6_address")
    private List<DnsAAAARdata> ip6Address = null;

    @JsonProperty("ip_address")
    private List<DnsARdata> ipAddress = null;

    @JsonProperty("metadata")
    private String metadata = null;

    @JsonProperty("mx_records")
    private List<DnsMxRdata> mxRecords = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("ns")
    private List<DnsNsRdata> ns = null;

    @JsonProperty("num_records_in_response")
    private Integer numRecordsInResponse = 0;

    @JsonProperty("service_locators")
    private List<DnsSrvRdata> serviceLocators = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("ttl")
    private Integer ttl = null;

    @JsonProperty("txt_records")
    private List<DnsTxtRdata> txtRecords = null;

    @JsonProperty("type")
    private String type = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;

    @JsonProperty("wildcard_match")
    private Boolean wildcardMatch = false;



    /**
     * This is the getter method this will return the attribute value.
     * Specifies the algorithm to pick the ip address(es) to be returned,when multiple entries are configured.
     * This does not apply if num_records_in_response is 0.
     * Default is round-robin.
     * Enum options - DNS_RECORD_RESPONSE_ROUND_ROBIN, DNS_RECORD_RESPONSE_CONSISTENT_HASH.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as "DNS_RECORD_RESPONSE_ROUND_ROBIN".
     * @return algorithm
     */
    public String getAlgorithm() {
        return algorithm;
    }

    /**
     * This is the setter method to the attribute.
     * Specifies the algorithm to pick the ip address(es) to be returned,when multiple entries are configured.
     * This does not apply if num_records_in_response is 0.
     * Default is round-robin.
     * Enum options - DNS_RECORD_RESPONSE_ROUND_ROBIN, DNS_RECORD_RESPONSE_CONSISTENT_HASH.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as "DNS_RECORD_RESPONSE_ROUND_ROBIN".
     * @param algorithm set the algorithm.
     */
    public void setAlgorithm(String  algorithm) {
        this.algorithm = algorithm;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Canonical name in cname record.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return cname
     */
    public DnsCnameRdata getCname() {
        return cname;
    }

    /**
     * This is the setter method to the attribute.
     * Canonical name in cname record.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param cname set the cname.
     */
    public void setCname(DnsCnameRdata cname) {
        this.cname = cname;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Configured fqdns are delegated domains (i.e.
     * They represent a zone cut).
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @return delegated
     */
    public Boolean getDelegated() {
        return delegated;
    }

    /**
     * This is the setter method to the attribute.
     * Configured fqdns are delegated domains (i.e.
     * They represent a zone cut).
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @param delegated set the delegated.
     */
    public void setDelegated(Boolean  delegated) {
        this.delegated = delegated;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Details of dns record.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * This is the setter method to the attribute.
     * Details of dns record.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param description set the description.
     */
    public void setDescription(String  description) {
        this.description = description;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Uuid of the dns vs.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return dnsVsUuid
     */
    public String getDnsVsUuid() {
        return dnsVsUuid;
    }

    /**
     * This is the setter method to the attribute.
     * Uuid of the dns vs.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param dnsVsUuid set the dnsVsUuid.
     */
    public void setDnsVsUuid(String  dnsVsUuid) {
        this.dnsVsUuid = dnsVsUuid;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Fully qualified domain name.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return fqdn
     */
    public String getFqdn() {
        return fqdn;
    }

    /**
     * This is the setter method to the attribute.
     * Fully qualified domain name.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param fqdn set the fqdn.
     */
    public void setFqdn(String  fqdn) {
        this.fqdn = fqdn;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Ipv6 address in aaaa record.
     * Field introduced in 20.1.3.
     * Maximum of 4 items allowed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return ip6Address
     */
    public List<DnsAAAARdata> getIp6Address() {
        return ip6Address;
    }

    /**
     * This is the setter method. this will set the ip6Address
     * Ipv6 address in aaaa record.
     * Field introduced in 20.1.3.
     * Maximum of 4 items allowed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return ip6Address
     */
    public void setIp6Address(List<DnsAAAARdata>  ip6Address) {
        this.ip6Address = ip6Address;
    }

    /**
     * This is the setter method this will set the ip6Address
     * Ipv6 address in aaaa record.
     * Field introduced in 20.1.3.
     * Maximum of 4 items allowed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return ip6Address
     */
    public DynamicDnsRecord addIp6AddressItem(DnsAAAARdata ip6AddressItem) {
      if (this.ip6Address == null) {
        this.ip6Address = new ArrayList<DnsAAAARdata>();
      }
      this.ip6Address.add(ip6AddressItem);
      return this;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Ip address in a record.
     * Field introduced in 20.1.3.
     * Maximum of 4 items allowed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return ipAddress
     */
    public List<DnsARdata> getIpAddress() {
        return ipAddress;
    }

    /**
     * This is the setter method. this will set the ipAddress
     * Ip address in a record.
     * Field introduced in 20.1.3.
     * Maximum of 4 items allowed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return ipAddress
     */
    public void setIpAddress(List<DnsARdata>  ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * This is the setter method this will set the ipAddress
     * Ip address in a record.
     * Field introduced in 20.1.3.
     * Maximum of 4 items allowed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return ipAddress
     */
    public DynamicDnsRecord addIpAddressItem(DnsARdata ipAddressItem) {
      if (this.ipAddress == null) {
        this.ipAddress = new ArrayList<DnsARdata>();
      }
      this.ipAddress.add(ipAddressItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Internal metadata for the dns record.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return metadata
     */
    public String getMetadata() {
        return metadata;
    }

    /**
     * This is the setter method to the attribute.
     * Internal metadata for the dns record.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param metadata set the metadata.
     */
    public void setMetadata(String  metadata) {
        this.metadata = metadata;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Mx record.
     * Field introduced in 20.1.3.
     * Maximum of 4 items allowed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return mxRecords
     */
    public List<DnsMxRdata> getMxRecords() {
        return mxRecords;
    }

    /**
     * This is the setter method. this will set the mxRecords
     * Mx record.
     * Field introduced in 20.1.3.
     * Maximum of 4 items allowed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return mxRecords
     */
    public void setMxRecords(List<DnsMxRdata>  mxRecords) {
        this.mxRecords = mxRecords;
    }

    /**
     * This is the setter method this will set the mxRecords
     * Mx record.
     * Field introduced in 20.1.3.
     * Maximum of 4 items allowed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return mxRecords
     */
    public DynamicDnsRecord addMxRecordsItem(DnsMxRdata mxRecordsItem) {
      if (this.mxRecords == null) {
        this.mxRecords = new ArrayList<DnsMxRdata>();
      }
      this.mxRecords.add(mxRecordsItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Dynamicdnsrecord name, needed for a top level uuid protobuf, for display in shell.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This is the setter method to the attribute.
     * Dynamicdnsrecord name, needed for a top level uuid protobuf, for display in shell.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param name set the name.
     */
    public void setName(String  name) {
        this.name = name;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Name server information in ns record.
     * Field introduced in 20.1.3.
     * Maximum of 13 items allowed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return ns
     */
    public List<DnsNsRdata> getNs() {
        return ns;
    }

    /**
     * This is the setter method. this will set the ns
     * Name server information in ns record.
     * Field introduced in 20.1.3.
     * Maximum of 13 items allowed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return ns
     */
    public void setNs(List<DnsNsRdata>  ns) {
        this.ns = ns;
    }

    /**
     * This is the setter method this will set the ns
     * Name server information in ns record.
     * Field introduced in 20.1.3.
     * Maximum of 13 items allowed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return ns
     */
    public DynamicDnsRecord addNsItem(DnsNsRdata nsItem) {
      if (this.ns == null) {
        this.ns = new ArrayList<DnsNsRdata>();
      }
      this.ns.add(nsItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Specifies the number of records returned by the dns service.enter 0 to return all records.
     * Default is 0.
     * Allowed values are 0-20.
     * Special values are 0- 'return all records'.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as 0.
     * @return numRecordsInResponse
     */
    public Integer getNumRecordsInResponse() {
        return numRecordsInResponse;
    }

    /**
     * This is the setter method to the attribute.
     * Specifies the number of records returned by the dns service.enter 0 to return all records.
     * Default is 0.
     * Allowed values are 0-20.
     * Special values are 0- 'return all records'.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as 0.
     * @param numRecordsInResponse set the numRecordsInResponse.
     */
    public void setNumRecordsInResponse(Integer  numRecordsInResponse) {
        this.numRecordsInResponse = numRecordsInResponse;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Service locator info in srv record.
     * Field introduced in 20.1.3.
     * Maximum of 4 items allowed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return serviceLocators
     */
    public List<DnsSrvRdata> getServiceLocators() {
        return serviceLocators;
    }

    /**
     * This is the setter method. this will set the serviceLocators
     * Service locator info in srv record.
     * Field introduced in 20.1.3.
     * Maximum of 4 items allowed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return serviceLocators
     */
    public void setServiceLocators(List<DnsSrvRdata>  serviceLocators) {
        this.serviceLocators = serviceLocators;
    }

    /**
     * This is the setter method this will set the serviceLocators
     * Service locator info in srv record.
     * Field introduced in 20.1.3.
     * Maximum of 4 items allowed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return serviceLocators
     */
    public DynamicDnsRecord addServiceLocatorsItem(DnsSrvRdata serviceLocatorsItem) {
      if (this.serviceLocators == null) {
        this.serviceLocators = new ArrayList<DnsSrvRdata>();
      }
      this.serviceLocators.add(serviceLocatorsItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Tenant_uuid from dns vs's tenant_uuid.
     * It is a reference to an object of type tenant.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return tenantRef
     */
    public String getTenantRef() {
        return tenantRef;
    }

    /**
     * This is the setter method to the attribute.
     * Tenant_uuid from dns vs's tenant_uuid.
     * It is a reference to an object of type tenant.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param tenantRef set the tenantRef.
     */
    public void setTenantRef(String  tenantRef) {
        this.tenantRef = tenantRef;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Time to live for this dns record.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return ttl
     */
    public Integer getTtl() {
        return ttl;
    }

    /**
     * This is the setter method to the attribute.
     * Time to live for this dns record.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param ttl set the ttl.
     */
    public void setTtl(Integer  ttl) {
        this.ttl = ttl;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Text record.
     * Field introduced in 20.1.3.
     * Maximum of 4 items allowed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return txtRecords
     */
    public List<DnsTxtRdata> getTxtRecords() {
        return txtRecords;
    }

    /**
     * This is the setter method. this will set the txtRecords
     * Text record.
     * Field introduced in 20.1.3.
     * Maximum of 4 items allowed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return txtRecords
     */
    public void setTxtRecords(List<DnsTxtRdata>  txtRecords) {
        this.txtRecords = txtRecords;
    }

    /**
     * This is the setter method this will set the txtRecords
     * Text record.
     * Field introduced in 20.1.3.
     * Maximum of 4 items allowed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return txtRecords
     */
    public DynamicDnsRecord addTxtRecordsItem(DnsTxtRdata txtRecordsItem) {
      if (this.txtRecords == null) {
        this.txtRecords = new ArrayList<DnsTxtRdata>();
      }
      this.txtRecords.add(txtRecordsItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Dns record type.
     * Enum options - DNS_RECORD_OTHER, DNS_RECORD_A, DNS_RECORD_NS, DNS_RECORD_CNAME, DNS_RECORD_SOA, DNS_RECORD_PTR, DNS_RECORD_HINFO, DNS_RECORD_MX,
     * DNS_RECORD_TXT, DNS_RECORD_RP, DNS_RECORD_DNSKEY, DNS_RECORD_AAAA, DNS_RECORD_SRV, DNS_RECORD_OPT, DNS_RECORD_RRSIG, DNS_RECORD_AXFR,
     * DNS_RECORD_ANY.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
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
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
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
     * Uuid of the dns record.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This is the setter method to the attribute.
     * Uuid of the dns record.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param uuid set the uuid.
     */
    public void setUuid(String  uuid) {
        this.uuid = uuid;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Enable wild-card match of fqdn  if an exact match is not found in the dns table, the longest match is chosen by wild-carding the fqdn in the dns
     * request.
     * Default is false.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @return wildcardMatch
     */
    public Boolean getWildcardMatch() {
        return wildcardMatch;
    }

    /**
     * This is the setter method to the attribute.
     * Enable wild-card match of fqdn  if an exact match is not found in the dns table, the longest match is chosen by wild-carding the fqdn in the dns
     * request.
     * Default is false.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @param wildcardMatch set the wildcardMatch.
     */
    public void setWildcardMatch(Boolean  wildcardMatch) {
        this.wildcardMatch = wildcardMatch;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      DynamicDnsRecord objDynamicDnsRecord = (DynamicDnsRecord) o;
      return   Objects.equals(this.fqdn, objDynamicDnsRecord.fqdn)&&
  Objects.equals(this.uuid, objDynamicDnsRecord.uuid)&&
  Objects.equals(this.dnsVsUuid, objDynamicDnsRecord.dnsVsUuid)&&
  Objects.equals(this.name, objDynamicDnsRecord.name)&&
  Objects.equals(this.type, objDynamicDnsRecord.type)&&
  Objects.equals(this.ttl, objDynamicDnsRecord.ttl)&&
  Objects.equals(this.ipAddress, objDynamicDnsRecord.ipAddress)&&
  Objects.equals(this.serviceLocators, objDynamicDnsRecord.serviceLocators)&&
  Objects.equals(this.cname, objDynamicDnsRecord.cname)&&
  Objects.equals(this.ns, objDynamicDnsRecord.ns)&&
  Objects.equals(this.numRecordsInResponse, objDynamicDnsRecord.numRecordsInResponse)&&
  Objects.equals(this.algorithm, objDynamicDnsRecord.algorithm)&&
  Objects.equals(this.wildcardMatch, objDynamicDnsRecord.wildcardMatch)&&
  Objects.equals(this.delegated, objDynamicDnsRecord.delegated)&&
  Objects.equals(this.ip6Address, objDynamicDnsRecord.ip6Address)&&
  Objects.equals(this.tenantRef, objDynamicDnsRecord.tenantRef)&&
  Objects.equals(this.description, objDynamicDnsRecord.description)&&
  Objects.equals(this.metadata, objDynamicDnsRecord.metadata)&&
  Objects.equals(this.mxRecords, objDynamicDnsRecord.mxRecords)&&
  Objects.equals(this.txtRecords, objDynamicDnsRecord.txtRecords);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class DynamicDnsRecord {\n");
                  sb.append("    algorithm: ").append(toIndentedString(algorithm)).append("\n");
                        sb.append("    cname: ").append(toIndentedString(cname)).append("\n");
                        sb.append("    delegated: ").append(toIndentedString(delegated)).append("\n");
                        sb.append("    description: ").append(toIndentedString(description)).append("\n");
                        sb.append("    dnsVsUuid: ").append(toIndentedString(dnsVsUuid)).append("\n");
                        sb.append("    fqdn: ").append(toIndentedString(fqdn)).append("\n");
                        sb.append("    ip6Address: ").append(toIndentedString(ip6Address)).append("\n");
                        sb.append("    ipAddress: ").append(toIndentedString(ipAddress)).append("\n");
                        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
                        sb.append("    mxRecords: ").append(toIndentedString(mxRecords)).append("\n");
                        sb.append("    name: ").append(toIndentedString(name)).append("\n");
                        sb.append("    ns: ").append(toIndentedString(ns)).append("\n");
                        sb.append("    numRecordsInResponse: ").append(toIndentedString(numRecordsInResponse)).append("\n");
                        sb.append("    serviceLocators: ").append(toIndentedString(serviceLocators)).append("\n");
                        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
                        sb.append("    ttl: ").append(toIndentedString(ttl)).append("\n");
                        sb.append("    txtRecords: ").append(toIndentedString(txtRecords)).append("\n");
                        sb.append("    type: ").append(toIndentedString(type)).append("\n");
                                    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
                        sb.append("    wildcardMatch: ").append(toIndentedString(wildcardMatch)).append("\n");
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
