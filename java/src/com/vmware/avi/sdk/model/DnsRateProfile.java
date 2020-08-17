package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DnsRateProfile is a POJO class extends AviRestResource that used for creating
 * DnsRateProfile.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DnsRateProfile  {
    @JsonProperty("action")
    private DnsRuleRLAction action = null;

    @JsonProperty("burst_size")
    private Integer burstSize = null;

    @JsonProperty("count")
    private Integer count = null;

    @JsonProperty("fine_grain")
    private Boolean fineGrain = null;

    @JsonProperty("period")
    private Integer period = null;



  /**
   * This is the getter method this will return the attribute value.
   * Action to perform upon rate limiting.
   * Field deprecated in 20.1.1.
   * Field introduced in 18.2.5.
   * @return action
   */
  public DnsRuleRLAction getAction() {
    return action;
  }

  /**
   * This is the setter method to the attribute.
   * Action to perform upon rate limiting.
   * Field deprecated in 20.1.1.
   * Field introduced in 18.2.5.
   * @param action set the action.
   */
  public void setAction(DnsRuleRLAction action) {
    this.action = action;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of connections or requests or packets to be rate limited instantaneously.
   * Field deprecated in 20.1.1.
   * Field introduced in 18.2.5.
   * @return burstSize
   */
  public Integer getBurstSize() {
    return burstSize;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of connections or requests or packets to be rate limited instantaneously.
   * Field deprecated in 20.1.1.
   * Field introduced in 18.2.5.
   * @param burstSize set the burstSize.
   */
  public void setBurstSize(Integer  burstSize) {
    this.burstSize = burstSize;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of connections or requests or packets per second.
   * It is deprecated because of adoption of new shared rate limiter protobuf.
   * Allowed values are 1-4294967295.
   * Special values are 0- 'unlimited'.
   * Field deprecated in 20.1.1.
   * Field introduced in 18.2.5.
   * @return count
   */
  public Integer getCount() {
    return count;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of connections or requests or packets per second.
   * It is deprecated because of adoption of new shared rate limiter protobuf.
   * Allowed values are 1-4294967295.
   * Special values are 0- 'unlimited'.
   * Field deprecated in 20.1.1.
   * Field introduced in 18.2.5.
   * @param count set the count.
   */
  public void setCount(Integer  count) {
    this.count = count;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable fine granularity.
   * Field deprecated in 20.1.1.
   * Field introduced in 18.2.5.
   * @return fineGrain
   */
  public Boolean getFineGrain() {
    return fineGrain;
  }

  /**
   * This is the setter method to the attribute.
   * Enable fine granularity.
   * Field deprecated in 20.1.1.
   * Field introduced in 18.2.5.
   * @param fineGrain set the fineGrain.
   */
  public void setFineGrain(Boolean  fineGrain) {
    this.fineGrain = fineGrain;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Time value in seconds to enforce rate count.
   * Allowed values are 1-300.
   * Field deprecated in 20.1.1.
   * Field introduced in 18.2.5.
   * @return period
   */
  public Integer getPeriod() {
    return period;
  }

  /**
   * This is the setter method to the attribute.
   * Time value in seconds to enforce rate count.
   * Allowed values are 1-300.
   * Field deprecated in 20.1.1.
   * Field introduced in 18.2.5.
   * @param period set the period.
   */
  public void setPeriod(Integer  period) {
    this.period = period;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  DnsRateProfile objDnsRateProfile = (DnsRateProfile) o;
  return   Objects.equals(this.count, objDnsRateProfile.count)&&
  Objects.equals(this.burstSize, objDnsRateProfile.burstSize)&&
  Objects.equals(this.period, objDnsRateProfile.period)&&
  Objects.equals(this.fineGrain, objDnsRateProfile.fineGrain)&&
  Objects.equals(this.action, objDnsRateProfile.action);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DnsRateProfile {\n");
      sb.append("    action: ").append(toIndentedString(action)).append("\n");
        sb.append("    burstSize: ").append(toIndentedString(burstSize)).append("\n");
        sb.append("    count: ").append(toIndentedString(count)).append("\n");
        sb.append("    fineGrain: ").append(toIndentedString(fineGrain)).append("\n");
        sb.append("    period: ").append(toIndentedString(period)).append("\n");
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

