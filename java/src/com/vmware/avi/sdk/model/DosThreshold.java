package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DosThreshold is a POJO class extends AviRestResource that used for creating
 * DosThreshold.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DosThreshold  {
    @JsonProperty("attack")
    private String attack = null;

    @JsonProperty("max_value")
    private Integer maxValue = null;

    @JsonProperty("min_value")
    private Integer minValue = null;



  /**
   * This is the getter method this will return the attribute value.
   * Attack type.
   * Enum options - LAND, SMURF, ICMP_PING_FLOOD, UNKOWN_PROTOCOL, TEARDROP, IP_FRAG_OVERRUN, IP_FRAG_TOOSMALL, IP_FRAG_FULL, IP_FRAG_INCOMPLETE,
   * PORT_SCAN, TCP_NON_SYN_FLOOD_OLD, SYN_FLOOD, BAD_RST_FLOOD, MALFORMED_FLOOD, FAKE_SESSION, ZERO_WINDOW_STRESS, SMALL_WINDOW_STRESS,
   * DOS_HTTP_TIMEOUT, DOS_HTTP_ERROR, DOS_HTTP_ABORT...
   * @return attack
   */
  public String getAttack() {
    return attack;
  }

  /**
   * This is the setter method to the attribute.
   * Attack type.
   * Enum options - LAND, SMURF, ICMP_PING_FLOOD, UNKOWN_PROTOCOL, TEARDROP, IP_FRAG_OVERRUN, IP_FRAG_TOOSMALL, IP_FRAG_FULL, IP_FRAG_INCOMPLETE,
   * PORT_SCAN, TCP_NON_SYN_FLOOD_OLD, SYN_FLOOD, BAD_RST_FLOOD, MALFORMED_FLOOD, FAKE_SESSION, ZERO_WINDOW_STRESS, SMALL_WINDOW_STRESS,
   * DOS_HTTP_TIMEOUT, DOS_HTTP_ERROR, DOS_HTTP_ABORT...
   * @param attack set the attack.
   */
  public void setAttack(String  attack) {
    this.attack = attack;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of packets or connections or requests in a given interval of time to be deemed as attack.
   * @return maxValue
   */
  public Integer getMaxValue() {
    return maxValue;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of packets or connections or requests in a given interval of time to be deemed as attack.
   * @param maxValue set the maxValue.
   */
  public void setMaxValue(Integer  maxValue) {
    this.maxValue = maxValue;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Minimum number of packets or connections or requests in a given interval of time to be deemed as attack.
   * @return minValue
   */
  public Integer getMinValue() {
    return minValue;
  }

  /**
   * This is the setter method to the attribute.
   * Minimum number of packets or connections or requests in a given interval of time to be deemed as attack.
   * @param minValue set the minValue.
   */
  public void setMinValue(Integer  minValue) {
    this.minValue = minValue;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  DosThreshold objDosThreshold = (DosThreshold) o;
  return   Objects.equals(this.maxValue, objDosThreshold.maxValue)&&
  Objects.equals(this.attack, objDosThreshold.attack)&&
  Objects.equals(this.minValue, objDosThreshold.minValue);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DosThreshold {\n");
      sb.append("    attack: ").append(toIndentedString(attack)).append("\n");
        sb.append("    maxValue: ").append(toIndentedString(maxValue)).append("\n");
        sb.append("    minValue: ").append(toIndentedString(minValue)).append("\n");
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

