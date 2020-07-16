package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DnsRuleActionResponse is a POJO class extends AviRestResource that used for creating
 * DnsRuleActionResponse.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DnsRuleActionResponse  {
    @JsonProperty("authoritative")
    private Boolean authoritative = true;

    @JsonProperty("rcode")
    private String rcode = "DNS_RCODE_NOERROR";

    @JsonProperty("resource_record_sets")
    private List<DnsRuleDnsRrSet> resourceRecordSets = null;

    @JsonProperty("truncation")
    private Boolean truncation = false;



  /**
   * This is the getter method this will return the attribute value.
   * Dns response is authoritative.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return authoritative
   */
  public Boolean getAuthoritative() {
    return authoritative;
  }

  /**
   * This is the setter method to the attribute.
   * Dns response is authoritative.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param authoritative set the authoritative.
   */
  public void setAuthoritative(Boolean  authoritative) {
    this.authoritative = authoritative;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dns response code.
   * Enum options - DNS_RCODE_NOERROR, DNS_RCODE_FORMERR, DNS_RCODE_SERVFAIL, DNS_RCODE_NXDOMAIN, DNS_RCODE_NOTIMP, DNS_RCODE_REFUSED,
   * DNS_RCODE_YXDOMAIN, DNS_RCODE_YXRRSET, DNS_RCODE_NXRRSET, DNS_RCODE_NOTAUTH, DNS_RCODE_NOTZONE.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as DNS_RCODE_NOERROR.
   * @return rcode
   */
  public String getRcode() {
    return rcode;
  }

  /**
   * This is the setter method to the attribute.
   * Dns response code.
   * Enum options - DNS_RCODE_NOERROR, DNS_RCODE_FORMERR, DNS_RCODE_SERVFAIL, DNS_RCODE_NXDOMAIN, DNS_RCODE_NOTIMP, DNS_RCODE_REFUSED,
   * DNS_RCODE_YXDOMAIN, DNS_RCODE_YXRRSET, DNS_RCODE_NXRRSET, DNS_RCODE_NOTAUTH, DNS_RCODE_NOTZONE.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as DNS_RCODE_NOERROR.
   * @param rcode set the rcode.
   */
  public void setRcode(String  rcode) {
    this.rcode = rcode;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Dns resource record sets - (resource record set share the dns domain name, type, and class).
   * Field introduced in 17.2.12, 18.1.2.
   * @return resourceRecordSets
   */
  public List<DnsRuleDnsRrSet> getResourceRecordSets() {
    return resourceRecordSets;
  }

  /**
   * This is the setter method. this will set the resourceRecordSets
   * Dns resource record sets - (resource record set share the dns domain name, type, and class).
   * Field introduced in 17.2.12, 18.1.2.
   * @return resourceRecordSets
   */
  public void setResourceRecordSets(List<DnsRuleDnsRrSet>  resourceRecordSets) {
    this.resourceRecordSets = resourceRecordSets;
  }

  /**
   * This is the setter method this will set the resourceRecordSets
   * Dns resource record sets - (resource record set share the dns domain name, type, and class).
   * Field introduced in 17.2.12, 18.1.2.
   * @return resourceRecordSets
   */
  public DnsRuleActionResponse addResourceRecordSetsItem(DnsRuleDnsRrSet resourceRecordSetsItem) {
    if (this.resourceRecordSets == null) {
      this.resourceRecordSets = new ArrayList<DnsRuleDnsRrSet>();
    }
    this.resourceRecordSets.add(resourceRecordSetsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dns response is truncated.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return truncation
   */
  public Boolean getTruncation() {
    return truncation;
  }

  /**
   * This is the setter method to the attribute.
   * Dns response is truncated.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param truncation set the truncation.
   */
  public void setTruncation(Boolean  truncation) {
    this.truncation = truncation;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  DnsRuleActionResponse objDnsRuleActionResponse = (DnsRuleActionResponse) o;
  return   Objects.equals(this.authoritative, objDnsRuleActionResponse.authoritative)&&
  Objects.equals(this.resourceRecordSets, objDnsRuleActionResponse.resourceRecordSets)&&
  Objects.equals(this.rcode, objDnsRuleActionResponse.rcode)&&
  Objects.equals(this.truncation, objDnsRuleActionResponse.truncation);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DnsRuleActionResponse {\n");
      sb.append("    authoritative: ").append(toIndentedString(authoritative)).append("\n");
        sb.append("    rcode: ").append(toIndentedString(rcode)).append("\n");
        sb.append("    resourceRecordSets: ").append(toIndentedString(resourceRecordSets)).append("\n");
        sb.append("    truncation: ").append(toIndentedString(truncation)).append("\n");
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

