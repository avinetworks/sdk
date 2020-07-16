package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SecMgrThreshold is a POJO class extends AviRestResource that used for creating
 * SecMgrThreshold.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SecMgrThreshold  {
    @JsonProperty("attack_type")
    private String attackType = null;

    @JsonProperty("threshold")
    private Integer threshold = null;



  /**
   * This is the getter method this will return the attribute value.
   * Enum options - LAND, SMURF, ICMP_PING_FLOOD, UNKOWN_PROTOCOL, TEARDROP, IP_FRAG_OVERRUN, IP_FRAG_TOOSMALL, IP_FRAG_FULL, IP_FRAG_INCOMPLETE,
   * PORT_SCAN, TCP_NON_SYN_FLOOD_OLD, SYN_FLOOD, BAD_RST_FLOOD, MALFORMED_FLOOD, FAKE_SESSION, ZERO_WINDOW_STRESS, SMALL_WINDOW_STRESS,
   * DOS_HTTP_TIMEOUT, DOS_HTTP_ERROR, DOS_HTTP_ABORT...
   * Field introduced in 18.2.5.
   * @return attackType
   */
  public String getAttackType() {
    return attackType;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - LAND, SMURF, ICMP_PING_FLOOD, UNKOWN_PROTOCOL, TEARDROP, IP_FRAG_OVERRUN, IP_FRAG_TOOSMALL, IP_FRAG_FULL, IP_FRAG_INCOMPLETE,
   * PORT_SCAN, TCP_NON_SYN_FLOOD_OLD, SYN_FLOOD, BAD_RST_FLOOD, MALFORMED_FLOOD, FAKE_SESSION, ZERO_WINDOW_STRESS, SMALL_WINDOW_STRESS,
   * DOS_HTTP_TIMEOUT, DOS_HTTP_ERROR, DOS_HTTP_ABORT...
   * Field introduced in 18.2.5.
   * @param attackType set the attackType.
   */
  public void setAttackType(String  attackType) {
    this.attackType = attackType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 18.2.5.
   * @return threshold
   */
  public Integer getThreshold() {
    return threshold;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 18.2.5.
   * @param threshold set the threshold.
   */
  public void setThreshold(Integer  threshold) {
    this.threshold = threshold;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SecMgrThreshold objSecMgrThreshold = (SecMgrThreshold) o;
  return   Objects.equals(this.attackType, objSecMgrThreshold.attackType)&&
  Objects.equals(this.threshold, objSecMgrThreshold.threshold);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SecMgrThreshold {\n");
      sb.append("    attackType: ").append(toIndentedString(attackType)).append("\n");
        sb.append("    threshold: ").append(toIndentedString(threshold)).append("\n");
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

