package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The HTTPServerReselect is a POJO class extends AviRestResource that used for creating
 * HTTPServerReselect.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HTTPServerReselect  {
    @JsonProperty("enabled")
    private Boolean enabled = false;

    @JsonProperty("num_retries")
    private Integer numRetries = 4;

    @JsonProperty("retry_nonidempotent")
    private Boolean retryNonidempotent = false;

    @JsonProperty("retry_timeout")
    private Integer retryTimeout = 0;

    @JsonProperty("svr_resp_code")
    private HTTPReselectRespCode svrRespCode = null;



  /**
   * This is the getter method this will return the attribute value.
   * Enable http request reselect when server responds with specific response codes.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return enabled
   */
  public Boolean getEnabled() {
    return enabled;
  }

  /**
   * This is the setter method to the attribute.
   * Enable http request reselect when server responds with specific response codes.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param enabled set the enabled.
   */
  public void setEnabled(Boolean  enabled) {
    this.enabled = enabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Number of times to retry an http request when server responds with configured status codes.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4.
   * @return numRetries
   */
  public Integer getNumRetries() {
    return numRetries;
  }

  /**
   * This is the setter method to the attribute.
   * Number of times to retry an http request when server responds with configured status codes.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4.
   * @param numRetries set the numRetries.
   */
  public void setNumRetries(Integer  numRetries) {
    this.numRetries = numRetries;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Allow retry of non-idempotent http requests.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return retryNonidempotent
   */
  public Boolean getRetryNonidempotent() {
    return retryNonidempotent;
  }

  /**
   * This is the setter method to the attribute.
   * Allow retry of non-idempotent http requests.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param retryNonidempotent set the retryNonidempotent.
   */
  public void setRetryNonidempotent(Boolean  retryNonidempotent) {
    this.retryNonidempotent = retryNonidempotent;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Timeout per retry attempt, for a given request.
   * Value of 0 indicates default timeout.
   * Allowed values are 0-3600000.
   * Field introduced in 18.1.5,18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return retryTimeout
   */
  public Integer getRetryTimeout() {
    return retryTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * Timeout per retry attempt, for a given request.
   * Value of 0 indicates default timeout.
   * Allowed values are 0-3600000.
   * Field introduced in 18.1.5,18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param retryTimeout set the retryTimeout.
   */
  public void setRetryTimeout(Integer  retryTimeout) {
    this.retryTimeout = retryTimeout;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Server response codes which will trigger an http request retry.
   * @return svrRespCode
   */
  public HTTPReselectRespCode getSvrRespCode() {
    return svrRespCode;
  }

  /**
   * This is the setter method to the attribute.
   * Server response codes which will trigger an http request retry.
   * @param svrRespCode set the svrRespCode.
   */
  public void setSvrRespCode(HTTPReselectRespCode svrRespCode) {
    this.svrRespCode = svrRespCode;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  HTTPServerReselect objHTTPServerReselect = (HTTPServerReselect) o;
  return   Objects.equals(this.enabled, objHTTPServerReselect.enabled)&&
  Objects.equals(this.svrRespCode, objHTTPServerReselect.svrRespCode)&&
  Objects.equals(this.numRetries, objHTTPServerReselect.numRetries)&&
  Objects.equals(this.retryNonidempotent, objHTTPServerReselect.retryNonidempotent)&&
  Objects.equals(this.retryTimeout, objHTTPServerReselect.retryTimeout);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class HTTPServerReselect {\n");
      sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
        sb.append("    numRetries: ").append(toIndentedString(numRetries)).append("\n");
        sb.append("    retryNonidempotent: ").append(toIndentedString(retryNonidempotent)).append("\n");
        sb.append("    retryTimeout: ").append(toIndentedString(retryTimeout)).append("\n");
        sb.append("    svrRespCode: ").append(toIndentedString(svrRespCode)).append("\n");
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

