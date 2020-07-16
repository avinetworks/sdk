package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The NetworkSecurityPolicyActionRLParam is a POJO class extends AviRestResource that used for creating
 * NetworkSecurityPolicyActionRLParam.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NetworkSecurityPolicyActionRLParam  {
    @JsonProperty("burst_size")
    private Integer burstSize = 0;

    @JsonProperty("max_rate")
    private Integer maxRate = null;



  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of connections or requests or packets to be rate limited instantaneously.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return burstSize
   */
  public Integer getBurstSize() {
    return burstSize;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of connections or requests or packets to be rate limited instantaneously.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param burstSize set the burstSize.
   */
  public void setBurstSize(Integer  burstSize) {
    this.burstSize = burstSize;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of connections or requests or packets per second.
   * Allowed values are 1-4294967295.
   * @return maxRate
   */
  public Integer getMaxRate() {
    return maxRate;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of connections or requests or packets per second.
   * Allowed values are 1-4294967295.
   * @param maxRate set the maxRate.
   */
  public void setMaxRate(Integer  maxRate) {
    this.maxRate = maxRate;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  NetworkSecurityPolicyActionRLParam objNetworkSecurityPolicyActionRLParam = (NetworkSecurityPolicyActionRLParam) o;
  return   Objects.equals(this.maxRate, objNetworkSecurityPolicyActionRLParam.maxRate)&&
  Objects.equals(this.burstSize, objNetworkSecurityPolicyActionRLParam.burstSize);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class NetworkSecurityPolicyActionRLParam {\n");
      sb.append("    burstSize: ").append(toIndentedString(burstSize)).append("\n");
        sb.append("    maxRate: ").append(toIndentedString(maxRate)).append("\n");
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

