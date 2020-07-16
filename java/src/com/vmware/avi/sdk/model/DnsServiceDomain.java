package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DnsServiceDomain is a POJO class extends AviRestResource that used for creating
 * DnsServiceDomain.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DnsServiceDomain  {
    @JsonProperty("domain_name")
    private String domainName = null;

    @JsonProperty("num_dns_ip")
    private Integer numDnsIp = 1;

    @JsonProperty("pass_through")
    private Boolean passThrough = true;

    @JsonProperty("record_ttl")
    private Integer recordTtl = null;



  /**
   * This is the getter method this will return the attribute value.
   * Service domain string used for fqdn.
   * @return domainName
   */
  public String getDomainName() {
    return domainName;
  }

  /**
   * This is the setter method to the attribute.
   * Service domain string used for fqdn.
   * @param domainName set the domainName.
   */
  public void setDomainName(String  domainName) {
    this.domainName = domainName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Specifies the number of a records returned by avi dns service.
   * Allowed values are 0-20.
   * Special values are 0- 'return all ip addresses'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.
   * @return numDnsIp
   */
  public Integer getNumDnsIp() {
    return numDnsIp;
  }

  /**
   * This is the setter method to the attribute.
   * Specifies the number of a records returned by avi dns service.
   * Allowed values are 0-20.
   * Special values are 0- 'return all ip addresses'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.
   * @param numDnsIp set the numDnsIp.
   */
  public void setNumDnsIp(Integer  numDnsIp) {
    this.numDnsIp = numDnsIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Third-party authoritative domain requests are delegated todns virtualservice's pool of nameservers.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return passThrough
   */
  public Boolean getPassThrough() {
    return passThrough;
  }

  /**
   * This is the setter method to the attribute.
   * Third-party authoritative domain requests are delegated todns virtualservice's pool of nameservers.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param passThrough set the passThrough.
   */
  public void setPassThrough(Boolean  passThrough) {
    this.passThrough = passThrough;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ttl value for dns records.
   * Allowed values are 1-604800.
   * @return recordTtl
   */
  public Integer getRecordTtl() {
    return recordTtl;
  }

  /**
   * This is the setter method to the attribute.
   * Ttl value for dns records.
   * Allowed values are 1-604800.
   * @param recordTtl set the recordTtl.
   */
  public void setRecordTtl(Integer  recordTtl) {
    this.recordTtl = recordTtl;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  DnsServiceDomain objDnsServiceDomain = (DnsServiceDomain) o;
  return   Objects.equals(this.recordTtl, objDnsServiceDomain.recordTtl)&&
  Objects.equals(this.numDnsIp, objDnsServiceDomain.numDnsIp)&&
  Objects.equals(this.domainName, objDnsServiceDomain.domainName)&&
  Objects.equals(this.passThrough, objDnsServiceDomain.passThrough);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DnsServiceDomain {\n");
      sb.append("    domainName: ").append(toIndentedString(domainName)).append("\n");
        sb.append("    numDnsIp: ").append(toIndentedString(numDnsIp)).append("\n");
        sb.append("    passThrough: ").append(toIndentedString(passThrough)).append("\n");
        sb.append("    recordTtl: ").append(toIndentedString(recordTtl)).append("\n");
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

