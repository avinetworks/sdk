package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The HealthMonitorDNS is a POJO class extends AviRestResource that used for creating
 * HealthMonitorDNS.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HealthMonitorDNS  {
    @JsonProperty("qtype")
    private String qtype = "DNS_QUERY_TYPE";

    @JsonProperty("query_name")
    private String queryName = null;

    @JsonProperty("rcode")
    private String rcode = "RCODE_NO_ERROR";

    @JsonProperty("record_type")
    private String recordType = "DNS_RECORD_A";

    @JsonProperty("response_string")
    private String responseString = null;



  /**
   * This is the getter method this will return the attribute value.
   * Query_type  response has atleast one answer of which      the resource record type matches the query type   any_type  response should contain
   * atleast one answer  anything  an empty answer is enough.
   * Enum options - DNS_QUERY_TYPE, DNS_ANY_TYPE, DNS_ANY_THING.
   * Default value when not specified in API or module is interpreted by Avi Controller as DNS_QUERY_TYPE.
   * @return qtype
   */
  public String getQtype() {
    return qtype;
  }

  /**
   * This is the setter method to the attribute.
   * Query_type  response has atleast one answer of which      the resource record type matches the query type   any_type  response should contain
   * atleast one answer  anything  an empty answer is enough.
   * Enum options - DNS_QUERY_TYPE, DNS_ANY_TYPE, DNS_ANY_THING.
   * Default value when not specified in API or module is interpreted by Avi Controller as DNS_QUERY_TYPE.
   * @param qtype set the qtype.
   */
  public void setQtype(String  qtype) {
    this.qtype = qtype;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The dns monitor will query the dns server for the fully qualified name in this field.
   * @return queryName
   */
  public String getQueryName() {
    return queryName;
  }

  /**
   * This is the setter method to the attribute.
   * The dns monitor will query the dns server for the fully qualified name in this field.
   * @param queryName set the queryName.
   */
  public void setQueryName(String  queryName) {
    this.queryName = queryName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * When no error is selected, a dns query will be marked failed is any error code is returned by the server.
   * With any selected, the monitor ignores error code in the responses.
   * Enum options - RCODE_NO_ERROR, RCODE_ANYTHING.
   * Default value when not specified in API or module is interpreted by Avi Controller as RCODE_NO_ERROR.
   * @return rcode
   */
  public String getRcode() {
    return rcode;
  }

  /**
   * This is the setter method to the attribute.
   * When no error is selected, a dns query will be marked failed is any error code is returned by the server.
   * With any selected, the monitor ignores error code in the responses.
   * Enum options - RCODE_NO_ERROR, RCODE_ANYTHING.
   * Default value when not specified in API or module is interpreted by Avi Controller as RCODE_NO_ERROR.
   * @param rcode set the rcode.
   */
  public void setRcode(String  rcode) {
    this.rcode = rcode;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Resource record type used in the healthmonitor dns query, only a or aaaa type supported.
   * Enum options - DNS_RECORD_OTHER, DNS_RECORD_A, DNS_RECORD_NS, DNS_RECORD_CNAME, DNS_RECORD_SOA, DNS_RECORD_PTR, DNS_RECORD_HINFO, DNS_RECORD_MX,
   * DNS_RECORD_TXT, DNS_RECORD_RP, DNS_RECORD_DNSKEY, DNS_RECORD_AAAA, DNS_RECORD_SRV, DNS_RECORD_OPT, DNS_RECORD_RRSIG, DNS_RECORD_AXFR,
   * DNS_RECORD_ANY.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as DNS_RECORD_A.
   * @return recordType
   */
  public String getRecordType() {
    return recordType;
  }

  /**
   * This is the setter method to the attribute.
   * Resource record type used in the healthmonitor dns query, only a or aaaa type supported.
   * Enum options - DNS_RECORD_OTHER, DNS_RECORD_A, DNS_RECORD_NS, DNS_RECORD_CNAME, DNS_RECORD_SOA, DNS_RECORD_PTR, DNS_RECORD_HINFO, DNS_RECORD_MX,
   * DNS_RECORD_TXT, DNS_RECORD_RP, DNS_RECORD_DNSKEY, DNS_RECORD_AAAA, DNS_RECORD_SRV, DNS_RECORD_OPT, DNS_RECORD_RRSIG, DNS_RECORD_AXFR,
   * DNS_RECORD_ANY.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as DNS_RECORD_A.
   * @param recordType set the recordType.
   */
  public void setRecordType(String  recordType) {
    this.recordType = recordType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The resource record of the queried dns server's response for the request name must include the ip address defined in this field.
   * @return responseString
   */
  public String getResponseString() {
    return responseString;
  }

  /**
   * This is the setter method to the attribute.
   * The resource record of the queried dns server's response for the request name must include the ip address defined in this field.
   * @param responseString set the responseString.
   */
  public void setResponseString(String  responseString) {
    this.responseString = responseString;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  HealthMonitorDNS objHealthMonitorDNS = (HealthMonitorDNS) o;
  return   Objects.equals(this.qtype, objHealthMonitorDNS.qtype)&&
  Objects.equals(this.rcode, objHealthMonitorDNS.rcode)&&
  Objects.equals(this.queryName, objHealthMonitorDNS.queryName)&&
  Objects.equals(this.responseString, objHealthMonitorDNS.responseString)&&
  Objects.equals(this.recordType, objHealthMonitorDNS.recordType);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class HealthMonitorDNS {\n");
      sb.append("    qtype: ").append(toIndentedString(qtype)).append("\n");
        sb.append("    queryName: ").append(toIndentedString(queryName)).append("\n");
        sb.append("    rcode: ").append(toIndentedString(rcode)).append("\n");
        sb.append("    recordType: ").append(toIndentedString(recordType)).append("\n");
        sb.append("    responseString: ").append(toIndentedString(responseString)).append("\n");
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

