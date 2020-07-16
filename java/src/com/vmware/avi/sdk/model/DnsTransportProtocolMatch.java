package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DnsTransportProtocolMatch is a POJO class extends AviRestResource that used for creating
 * DnsTransportProtocolMatch.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DnsTransportProtocolMatch  {
    @JsonProperty("match_criteria")
    private String matchCriteria = null;

    @JsonProperty("protocol")
    private String protocol = null;



  /**
   * This is the getter method this will return the attribute value.
   * Criterion to use for matching the dns transport protocol.
   * Enum options - IS_IN, IS_NOT_IN.
   * Field introduced in 17.1.1.
   * @return matchCriteria
   */
  public String getMatchCriteria() {
    return matchCriteria;
  }

  /**
   * This is the setter method to the attribute.
   * Criterion to use for matching the dns transport protocol.
   * Enum options - IS_IN, IS_NOT_IN.
   * Field introduced in 17.1.1.
   * @param matchCriteria set the matchCriteria.
   */
  public void setMatchCriteria(String  matchCriteria) {
    this.matchCriteria = matchCriteria;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Protocol to match against transport protocol used by dns query.
   * Enum options - DNS_OVER_UDP, DNS_OVER_TCP.
   * Field introduced in 17.1.1.
   * @return protocol
   */
  public String getProtocol() {
    return protocol;
  }

  /**
   * This is the setter method to the attribute.
   * Protocol to match against transport protocol used by dns query.
   * Enum options - DNS_OVER_UDP, DNS_OVER_TCP.
   * Field introduced in 17.1.1.
   * @param protocol set the protocol.
   */
  public void setProtocol(String  protocol) {
    this.protocol = protocol;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  DnsTransportProtocolMatch objDnsTransportProtocolMatch = (DnsTransportProtocolMatch) o;
  return   Objects.equals(this.protocol, objDnsTransportProtocolMatch.protocol)&&
  Objects.equals(this.matchCriteria, objDnsTransportProtocolMatch.matchCriteria);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DnsTransportProtocolMatch {\n");
      sb.append("    matchCriteria: ").append(toIndentedString(matchCriteria)).append("\n");
        sb.append("    protocol: ").append(toIndentedString(protocol)).append("\n");
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

