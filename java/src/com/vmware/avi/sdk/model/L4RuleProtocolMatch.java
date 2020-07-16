package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The L4RuleProtocolMatch is a POJO class extends AviRestResource that used for creating
 * L4RuleProtocolMatch.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class L4RuleProtocolMatch  {
    @JsonProperty("match_criteria")
    private String matchCriteria = null;

    @JsonProperty("protocol")
    private String protocol = null;



  /**
   * This is the getter method this will return the attribute value.
   * Criterion to use for transport protocol matching.
   * Enum options - IS_IN, IS_NOT_IN.
   * Field introduced in 17.2.7.
   * @return matchCriteria
   */
  public String getMatchCriteria() {
    return matchCriteria;
  }

  /**
   * This is the setter method to the attribute.
   * Criterion to use for transport protocol matching.
   * Enum options - IS_IN, IS_NOT_IN.
   * Field introduced in 17.2.7.
   * @param matchCriteria set the matchCriteria.
   */
  public void setMatchCriteria(String  matchCriteria) {
    this.matchCriteria = matchCriteria;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Transport protocol to match.
   * Enum options - PROTOCOL_ICMP, PROTOCOL_TCP, PROTOCOL_UDP.
   * Field introduced in 17.2.7.
   * @return protocol
   */
  public String getProtocol() {
    return protocol;
  }

  /**
   * This is the setter method to the attribute.
   * Transport protocol to match.
   * Enum options - PROTOCOL_ICMP, PROTOCOL_TCP, PROTOCOL_UDP.
   * Field introduced in 17.2.7.
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
  L4RuleProtocolMatch objL4RuleProtocolMatch = (L4RuleProtocolMatch) o;
  return   Objects.equals(this.protocol, objL4RuleProtocolMatch.protocol)&&
  Objects.equals(this.matchCriteria, objL4RuleProtocolMatch.matchCriteria);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class L4RuleProtocolMatch {\n");
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

