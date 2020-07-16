package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The RateLimiter is a POJO class extends AviRestResource that used for creating
 * RateLimiter.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RateLimiter  {
    @JsonProperty("burst_sz")
    private Integer burstSz = 0;

    @JsonProperty("count")
    private Integer count = 1000000000;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("period")
    private Integer period = 1;



  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of connections, requests or packets to be let through instantaneously.
   * If this is less than count, it will have no effect.
   * Allowed values are 0-1000000000.
   * Field introduced in 18.2.9.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return burstSz
   */
  public Integer getBurstSz() {
    return burstSz;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of connections, requests or packets to be let through instantaneously.
   * If this is less than count, it will have no effect.
   * Allowed values are 0-1000000000.
   * Field introduced in 18.2.9.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param burstSz set the burstSz.
   */
  public void setBurstSz(Integer  burstSz) {
    this.burstSz = burstSz;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of connections, requests or packets permitted each period.
   * Allowed values are 1-1000000000.
   * Field introduced in 18.2.9.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1000000000.
   * @return count
   */
  public Integer getCount() {
    return count;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of connections, requests or packets permitted each period.
   * Allowed values are 1-1000000000.
   * Field introduced in 18.2.9.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1000000000.
   * @param count set the count.
   */
  public void setCount(Integer  count) {
    this.count = count;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Identifier for rate limit.
   * Constructed according to context.
   * Field introduced in 18.2.9.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Identifier for rate limit.
   * Constructed according to context.
   * Field introduced in 18.2.9.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Time value in seconds to enforce rate count.
   * Allowed values are 1-1000000000.
   * Field introduced in 18.2.9.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.
   * @return period
   */
  public Integer getPeriod() {
    return period;
  }

  /**
   * This is the setter method to the attribute.
   * Time value in seconds to enforce rate count.
   * Allowed values are 1-1000000000.
   * Field introduced in 18.2.9.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.
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
  RateLimiter objRateLimiter = (RateLimiter) o;
  return   Objects.equals(this.count, objRateLimiter.count)&&
  Objects.equals(this.burstSz, objRateLimiter.burstSz)&&
  Objects.equals(this.period, objRateLimiter.period)&&
  Objects.equals(this.name, objRateLimiter.name);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class RateLimiter {\n");
      sb.append("    burstSz: ").append(toIndentedString(burstSz)).append("\n");
        sb.append("    count: ").append(toIndentedString(count)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

