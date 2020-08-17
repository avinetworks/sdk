package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The RateProfile is a POJO class extends AviRestResource that used for creating
 * RateProfile.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RateProfile  {
    @JsonProperty("action")
    private RateLimiterAction action = null;

    @JsonProperty("burst_sz")
    private Integer burstSz = null;

    @JsonProperty("count")
    private Integer count = null;

    @JsonProperty("explicit_tracking")
    private Boolean explicitTracking = false;

    @JsonProperty("fine_grain")
    private Boolean fineGrain = false;

    @JsonProperty("http_cookie")
    private String httpCookie = null;

    @JsonProperty("http_header")
    private String httpHeader = null;

    @JsonProperty("period")
    private Integer period = null;

    @JsonProperty("rate_limiter")
    private RateLimiter rateLimiter = null;



  /**
   * This is the getter method this will return the attribute value.
   * Action to perform upon rate limiting.
   * @return action
   */
  public RateLimiterAction getAction() {
    return action;
  }

  /**
   * This is the setter method to the attribute.
   * Action to perform upon rate limiting.
   * @param action set the action.
   */
  public void setAction(RateLimiterAction action) {
    this.action = action;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of connections or requests or packets to be let through instantaneously.
   * Allowed values are 10-2500.
   * Special values are 0- 'automatic'.
   * Field deprecated in 18.2.9.
   * @return burstSz
   */
  public Integer getBurstSz() {
    return burstSz;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of connections or requests or packets to be let through instantaneously.
   * Allowed values are 10-2500.
   * Special values are 0- 'automatic'.
   * Field deprecated in 18.2.9.
   * @param burstSz set the burstSz.
   */
  public void setBurstSz(Integer  burstSz) {
    this.burstSz = burstSz;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of connections or requests or packets.
   * Allowed values are 1-1000000000.
   * Special values are 0- 'unlimited'.
   * Field deprecated in 18.2.9.
   * @return count
   */
  public Integer getCount() {
    return count;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of connections or requests or packets.
   * Allowed values are 1-1000000000.
   * Special values are 0- 'unlimited'.
   * Field deprecated in 18.2.9.
   * @param count set the count.
   */
  public void setCount(Integer  count) {
    this.count = count;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Explicitly tracks an attacker across rate periods.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return explicitTracking
   */
  public Boolean getExplicitTracking() {
    return explicitTracking;
  }

  /**
   * This is the setter method to the attribute.
   * Explicitly tracks an attacker across rate periods.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param explicitTracking set the explicitTracking.
   */
  public void setExplicitTracking(Boolean  explicitTracking) {
    this.explicitTracking = explicitTracking;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable fine granularity.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return fineGrain
   */
  public Boolean getFineGrain() {
    return fineGrain;
  }

  /**
   * This is the setter method to the attribute.
   * Enable fine granularity.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param fineGrain set the fineGrain.
   */
  public void setFineGrain(Boolean  fineGrain) {
    this.fineGrain = fineGrain;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Http cookie name.
   * Field introduced in 17.1.1.
   * @return httpCookie
   */
  public String getHttpCookie() {
    return httpCookie;
  }

  /**
   * This is the setter method to the attribute.
   * Http cookie name.
   * Field introduced in 17.1.1.
   * @param httpCookie set the httpCookie.
   */
  public void setHttpCookie(String  httpCookie) {
    this.httpCookie = httpCookie;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Http header name.
   * Field introduced in 17.1.1.
   * @return httpHeader
   */
  public String getHttpHeader() {
    return httpHeader;
  }

  /**
   * This is the setter method to the attribute.
   * Http header name.
   * Field introduced in 17.1.1.
   * @param httpHeader set the httpHeader.
   */
  public void setHttpHeader(String  httpHeader) {
    this.httpHeader = httpHeader;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Time value in seconds to enforce rate count.
   * Allowed values are 1-300.
   * Field deprecated in 18.2.9.
   * @return period
   */
  public Integer getPeriod() {
    return period;
  }

  /**
   * This is the setter method to the attribute.
   * Time value in seconds to enforce rate count.
   * Allowed values are 1-300.
   * Field deprecated in 18.2.9.
   * @param period set the period.
   */
  public void setPeriod(Integer  period) {
    this.period = period;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The rate limiter configuration for this rate profile.
   * Field introduced in 18.2.9.
   * @return rateLimiter
   */
  public RateLimiter getRateLimiter() {
    return rateLimiter;
  }

  /**
   * This is the setter method to the attribute.
   * The rate limiter configuration for this rate profile.
   * Field introduced in 18.2.9.
   * @param rateLimiter set the rateLimiter.
   */
  public void setRateLimiter(RateLimiter rateLimiter) {
    this.rateLimiter = rateLimiter;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  RateProfile objRateProfile = (RateProfile) o;
  return   Objects.equals(this.count, objRateProfile.count)&&
  Objects.equals(this.burstSz, objRateProfile.burstSz)&&
  Objects.equals(this.period, objRateProfile.period)&&
  Objects.equals(this.explicitTracking, objRateProfile.explicitTracking)&&
  Objects.equals(this.fineGrain, objRateProfile.fineGrain)&&
  Objects.equals(this.action, objRateProfile.action)&&
  Objects.equals(this.httpHeader, objRateProfile.httpHeader)&&
  Objects.equals(this.httpCookie, objRateProfile.httpCookie)&&
  Objects.equals(this.rateLimiter, objRateProfile.rateLimiter);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class RateProfile {\n");
      sb.append("    action: ").append(toIndentedString(action)).append("\n");
        sb.append("    burstSz: ").append(toIndentedString(burstSz)).append("\n");
        sb.append("    count: ").append(toIndentedString(count)).append("\n");
        sb.append("    explicitTracking: ").append(toIndentedString(explicitTracking)).append("\n");
        sb.append("    fineGrain: ").append(toIndentedString(fineGrain)).append("\n");
        sb.append("    httpCookie: ").append(toIndentedString(httpCookie)).append("\n");
        sb.append("    httpHeader: ").append(toIndentedString(httpHeader)).append("\n");
        sb.append("    period: ").append(toIndentedString(period)).append("\n");
        sb.append("    rateLimiter: ").append(toIndentedString(rateLimiter)).append("\n");
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

