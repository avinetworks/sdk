package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The DnsRateLimiter is a POJO class extends AviRestResource that used for creating
 * DnsRateLimiter.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DnsRateLimiter  {
    @JsonProperty("action")
    private DnsRuleRLAction action = null;

    @JsonProperty("rate_limiter_object")
    private RateLimiter rateLimiterObject = null;



    /**
     * This is the getter method this will return the attribute value.
     * Action to perform upon rate limiting.
     * Field introduced in 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return action
     */
    public DnsRuleRLAction getAction() {
        return action;
    }

    /**
     * This is the setter method to the attribute.
     * Action to perform upon rate limiting.
     * Field introduced in 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param action set the action.
     */
    public void setAction(DnsRuleRLAction action) {
        this.action = action;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Rate limiting object.
     * Field introduced in 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return rateLimiterObject
     */
    public RateLimiter getRateLimiterObject() {
        return rateLimiterObject;
    }

    /**
     * This is the setter method to the attribute.
     * Rate limiting object.
     * Field introduced in 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param rateLimiterObject set the rateLimiterObject.
     */
    public void setRateLimiterObject(RateLimiter rateLimiterObject) {
        this.rateLimiterObject = rateLimiterObject;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      DnsRateLimiter objDnsRateLimiter = (DnsRateLimiter) o;
      return   Objects.equals(this.rateLimiterObject, objDnsRateLimiter.rateLimiterObject)&&
  Objects.equals(this.action, objDnsRateLimiter.action);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class DnsRateLimiter {\n");
                  sb.append("    action: ").append(toIndentedString(action)).append("\n");
                        sb.append("    rateLimiterObject: ").append(toIndentedString(rateLimiterObject)).append("\n");
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
