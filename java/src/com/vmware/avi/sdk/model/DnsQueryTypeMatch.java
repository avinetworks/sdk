package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DnsQueryTypeMatch is a POJO class extends AviRestResource that used for creating
 * DnsQueryTypeMatch.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DnsQueryTypeMatch  {
    @JsonProperty("match_criteria")
    private String matchCriteria = null;

    @JsonProperty("query_type")
    private List<String> queryType = null;



  /**
   * This is the getter method this will return the attribute value.
   * Criterion to use for matching the dns query typein the question section.
   * Enum options - IS_IN, IS_NOT_IN.
   * Field introduced in 17.1.1.
   * @return matchCriteria
   */
  public String getMatchCriteria() {
    return matchCriteria;
  }

  /**
   * This is the setter method to the attribute.
   * Criterion to use for matching the dns query typein the question section.
   * Enum options - IS_IN, IS_NOT_IN.
   * Field introduced in 17.1.1.
   * @param matchCriteria set the matchCriteria.
   */
  public void setMatchCriteria(String  matchCriteria) {
    this.matchCriteria = matchCriteria;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Dns query types in the request query.
   * Enum options - DNS_RECORD_OTHER, DNS_RECORD_A, DNS_RECORD_NS, DNS_RECORD_CNAME, DNS_RECORD_SOA, DNS_RECORD_PTR, DNS_RECORD_HINFO, DNS_RECORD_MX,
   * DNS_RECORD_TXT, DNS_RECORD_RP, DNS_RECORD_DNSKEY, DNS_RECORD_AAAA, DNS_RECORD_SRV, DNS_RECORD_OPT, DNS_RECORD_RRSIG, DNS_RECORD_AXFR,
   * DNS_RECORD_ANY.
   * Field introduced in 17.1.1.
   * @return queryType
   */
  public List<String> getQueryType() {
    return queryType;
  }

  /**
   * This is the setter method. this will set the queryType
   * Dns query types in the request query.
   * Enum options - DNS_RECORD_OTHER, DNS_RECORD_A, DNS_RECORD_NS, DNS_RECORD_CNAME, DNS_RECORD_SOA, DNS_RECORD_PTR, DNS_RECORD_HINFO, DNS_RECORD_MX,
   * DNS_RECORD_TXT, DNS_RECORD_RP, DNS_RECORD_DNSKEY, DNS_RECORD_AAAA, DNS_RECORD_SRV, DNS_RECORD_OPT, DNS_RECORD_RRSIG, DNS_RECORD_AXFR,
   * DNS_RECORD_ANY.
   * Field introduced in 17.1.1.
   * @return queryType
   */
  public void setQueryType(List<String>  queryType) {
    this.queryType = queryType;
  }

  /**
   * This is the setter method this will set the queryType
   * Dns query types in the request query.
   * Enum options - DNS_RECORD_OTHER, DNS_RECORD_A, DNS_RECORD_NS, DNS_RECORD_CNAME, DNS_RECORD_SOA, DNS_RECORD_PTR, DNS_RECORD_HINFO, DNS_RECORD_MX,
   * DNS_RECORD_TXT, DNS_RECORD_RP, DNS_RECORD_DNSKEY, DNS_RECORD_AAAA, DNS_RECORD_SRV, DNS_RECORD_OPT, DNS_RECORD_RRSIG, DNS_RECORD_AXFR,
   * DNS_RECORD_ANY.
   * Field introduced in 17.1.1.
   * @return queryType
   */
  public DnsQueryTypeMatch addQueryTypeItem(String queryTypeItem) {
    if (this.queryType == null) {
      this.queryType = new ArrayList<String>();
    }
    this.queryType.add(queryTypeItem);
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
  DnsQueryTypeMatch objDnsQueryTypeMatch = (DnsQueryTypeMatch) o;
  return   Objects.equals(this.matchCriteria, objDnsQueryTypeMatch.matchCriteria)&&
  Objects.equals(this.queryType, objDnsQueryTypeMatch.queryType);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DnsQueryTypeMatch {\n");
      sb.append("    matchCriteria: ").append(toIndentedString(matchCriteria)).append("\n");
        sb.append("    queryType: ").append(toIndentedString(queryType)).append("\n");
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

