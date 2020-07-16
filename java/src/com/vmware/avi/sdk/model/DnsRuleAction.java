package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DnsRuleAction is a POJO class extends AviRestResource that used for creating
 * DnsRuleAction.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DnsRuleAction  {
    @JsonProperty("allow")
    private DnsRuleActionAllowDrop allow = null;

    @JsonProperty("dns_rate_limit")
    private DnsRateProfile dnsRateLimit = null;

    @JsonProperty("dns_rate_limiter")
    private DnsRateLimiter dnsRateLimiter = null;

    @JsonProperty("gslb_site_selection")
    private DnsRuleActionGslbSiteSelection gslbSiteSelection = null;

    @JsonProperty("pool_switching")
    private DnsRuleActionPoolSwitching poolSwitching = null;

    @JsonProperty("response")
    private DnsRuleActionResponse response = null;



  /**
   * This is the getter method this will return the attribute value.
   * Allow or drop the dns query.
   * Field introduced in 17.1.1.
   * @return allow
   */
  public DnsRuleActionAllowDrop getAllow() {
    return allow;
  }

  /**
   * This is the setter method to the attribute.
   * Allow or drop the dns query.
   * Field introduced in 17.1.1.
   * @param allow set the allow.
   */
  public void setAllow(DnsRuleActionAllowDrop allow) {
    this.allow = allow;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Rate limits the dns requests.
   * Field deprecated in 20.1.1.
   * Field introduced in 18.2.5.
   * @return dnsRateLimit
   */
  public DnsRateProfile getDnsRateLimit() {
    return dnsRateLimit;
  }

  /**
   * This is the setter method to the attribute.
   * Rate limits the dns requests.
   * Field deprecated in 20.1.1.
   * Field introduced in 18.2.5.
   * @param dnsRateLimit set the dnsRateLimit.
   */
  public void setDnsRateLimit(DnsRateProfile dnsRateLimit) {
    this.dnsRateLimit = dnsRateLimit;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Rate limits the dns requests.
   * Field introduced in 20.1.1.
   * @return dnsRateLimiter
   */
  public DnsRateLimiter getDnsRateLimiter() {
    return dnsRateLimiter;
  }

  /**
   * This is the setter method to the attribute.
   * Rate limits the dns requests.
   * Field introduced in 20.1.1.
   * @param dnsRateLimiter set the dnsRateLimiter.
   */
  public void setDnsRateLimiter(DnsRateLimiter dnsRateLimiter) {
    this.dnsRateLimiter = dnsRateLimiter;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Select a specific gslb site for the dns query.
   * This action should be used only when gslb services have been configured for the dns virtual service.
   * Field introduced in 17.1.5.
   * @return gslbSiteSelection
   */
  public DnsRuleActionGslbSiteSelection getGslbSiteSelection() {
    return gslbSiteSelection;
  }

  /**
   * This is the setter method to the attribute.
   * Select a specific gslb site for the dns query.
   * This action should be used only when gslb services have been configured for the dns virtual service.
   * Field introduced in 17.1.5.
   * @param gslbSiteSelection set the gslbSiteSelection.
   */
  public void setGslbSiteSelection(DnsRuleActionGslbSiteSelection gslbSiteSelection) {
    this.gslbSiteSelection = gslbSiteSelection;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Select a pool or pool group for the passthrough dns query which cannot be served locally but could be served by upstream servers.
   * Field introduced in 18.1.3, 17.2.12.
   * @return poolSwitching
   */
  public DnsRuleActionPoolSwitching getPoolSwitching() {
    return poolSwitching;
  }

  /**
   * This is the setter method to the attribute.
   * Select a pool or pool group for the passthrough dns query which cannot be served locally but could be served by upstream servers.
   * Field introduced in 18.1.3, 17.2.12.
   * @param poolSwitching set the poolSwitching.
   */
  public void setPoolSwitching(DnsRuleActionPoolSwitching poolSwitching) {
    this.poolSwitching = poolSwitching;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Generate a response for the dns query.
   * Field introduced in 17.1.1.
   * @return response
   */
  public DnsRuleActionResponse getResponse() {
    return response;
  }

  /**
   * This is the setter method to the attribute.
   * Generate a response for the dns query.
   * Field introduced in 17.1.1.
   * @param response set the response.
   */
  public void setResponse(DnsRuleActionResponse response) {
    this.response = response;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  DnsRuleAction objDnsRuleAction = (DnsRuleAction) o;
  return   Objects.equals(this.dnsRateLimiter, objDnsRuleAction.dnsRateLimiter)&&
  Objects.equals(this.dnsRateLimit, objDnsRuleAction.dnsRateLimit)&&
  Objects.equals(this.poolSwitching, objDnsRuleAction.poolSwitching)&&
  Objects.equals(this.gslbSiteSelection, objDnsRuleAction.gslbSiteSelection)&&
  Objects.equals(this.allow, objDnsRuleAction.allow)&&
  Objects.equals(this.response, objDnsRuleAction.response);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DnsRuleAction {\n");
      sb.append("    allow: ").append(toIndentedString(allow)).append("\n");
        sb.append("    dnsRateLimit: ").append(toIndentedString(dnsRateLimit)).append("\n");
        sb.append("    dnsRateLimiter: ").append(toIndentedString(dnsRateLimiter)).append("\n");
        sb.append("    gslbSiteSelection: ").append(toIndentedString(gslbSiteSelection)).append("\n");
        sb.append("    poolSwitching: ").append(toIndentedString(poolSwitching)).append("\n");
        sb.append("    response: ").append(toIndentedString(response)).append("\n");
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

