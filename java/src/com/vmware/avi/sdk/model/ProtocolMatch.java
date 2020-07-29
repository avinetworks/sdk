package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ProtocolMatch is a POJO class extends AviRestResource that used for creating
 * ProtocolMatch.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProtocolMatch  {
    @JsonProperty("match_criteria")
    private String matchCriteria = null;

    @JsonProperty("protocols")
    private String protocols = null;



  /**
   * This is the getter method this will return the attribute value.
   * Criterion to use for protocol matching the http request.
   * Enum options - IS_IN, IS_NOT_IN.
   * @return matchCriteria
   */
  public String getMatchCriteria() {
    return matchCriteria;
  }

  /**
   * This is the setter method to the attribute.
   * Criterion to use for protocol matching the http request.
   * Enum options - IS_IN, IS_NOT_IN.
   * @param matchCriteria set the matchCriteria.
   */
  public void setMatchCriteria(String  matchCriteria) {
    this.matchCriteria = matchCriteria;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Http or https protocol.
   * Enum options - HTTP, HTTPS.
   * @return protocols
   */
  public String getProtocols() {
    return protocols;
  }

  /**
   * This is the setter method to the attribute.
   * Http or https protocol.
   * Enum options - HTTP, HTTPS.
   * @param protocols set the protocols.
   */
  public void setProtocols(String  protocols) {
    this.protocols = protocols;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ProtocolMatch objProtocolMatch = (ProtocolMatch) o;
  return   Objects.equals(this.matchCriteria, objProtocolMatch.matchCriteria)&&
  Objects.equals(this.protocols, objProtocolMatch.protocols);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ProtocolMatch {\n");
      sb.append("    matchCriteria: ").append(toIndentedString(matchCriteria)).append("\n");
        sb.append("    protocols: ").append(toIndentedString(protocols)).append("\n");
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

