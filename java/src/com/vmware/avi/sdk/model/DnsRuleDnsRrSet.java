package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DnsRuleDnsRrSet is a POJO class extends AviRestResource that used for creating
 * DnsRuleDnsRrSet.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DnsRuleDnsRrSet  {
    @JsonProperty("resource_record_set")
    private DnsRrSet resourceRecordSet = null;

    @JsonProperty("section")
    private String section = "DNS_MESSAGE_SECTION_ANSWER";



  /**
   * This is the getter method this will return the attribute value.
   * Dns resource record set - (records in the resource record set share the dns domain name, type, and class).
   * Field introduced in 17.2.12, 18.1.2.
   * @return resourceRecordSet
   */
  public DnsRrSet getResourceRecordSet() {
    return resourceRecordSet;
  }

  /**
   * This is the setter method to the attribute.
   * Dns resource record set - (records in the resource record set share the dns domain name, type, and class).
   * Field introduced in 17.2.12, 18.1.2.
   * @param resourceRecordSet set the resourceRecordSet.
   */
  public void setResourceRecordSet(DnsRrSet resourceRecordSet) {
    this.resourceRecordSet = resourceRecordSet;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dns message section for the resource record set.
   * Enum options - DNS_MESSAGE_SECTION_QUESTION, DNS_MESSAGE_SECTION_ANSWER, DNS_MESSAGE_SECTION_AUTHORITY, DNS_MESSAGE_SECTION_ADDITIONAL.
   * Field introduced in 17.2.12, 18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as DNS_MESSAGE_SECTION_ANSWER.
   * @return section
   */
  public String getSection() {
    return section;
  }

  /**
   * This is the setter method to the attribute.
   * Dns message section for the resource record set.
   * Enum options - DNS_MESSAGE_SECTION_QUESTION, DNS_MESSAGE_SECTION_ANSWER, DNS_MESSAGE_SECTION_AUTHORITY, DNS_MESSAGE_SECTION_ADDITIONAL.
   * Field introduced in 17.2.12, 18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as DNS_MESSAGE_SECTION_ANSWER.
   * @param section set the section.
   */
  public void setSection(String  section) {
    this.section = section;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  DnsRuleDnsRrSet objDnsRuleDnsRrSet = (DnsRuleDnsRrSet) o;
  return   Objects.equals(this.resourceRecordSet, objDnsRuleDnsRrSet.resourceRecordSet)&&
  Objects.equals(this.section, objDnsRuleDnsRrSet.section);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DnsRuleDnsRrSet {\n");
      sb.append("    resourceRecordSet: ").append(toIndentedString(resourceRecordSet)).append("\n");
        sb.append("    section: ").append(toIndentedString(section)).append("\n");
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

