package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The HTTPSecurityAction is a POJO class extends AviRestResource that used for creating
 * HTTPSecurityAction.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HTTPSecurityAction  {
    @JsonProperty("action")
    private String action = null;

    @JsonProperty("file")
    private HTTPLocalFile file = null;

    @JsonProperty("https_port")
    private Integer httpsPort = null;

    @JsonProperty("rate_limit")
    private RateProfile rateLimit;

    @JsonProperty("rate_profile")
    private HTTPSecurityActionRateProfile rateProfile = null;

    @JsonProperty("status_code")
    private String statusCode = null;



    /**
     * This is the getter method this will return the attribute value.
     * Type of the security action to perform.
     * Enum options - HTTP_SECURITY_ACTION_CLOSE_CONN, HTTP_SECURITY_ACTION_SEND_RESPONSE, HTTP_SECURITY_ACTION_ALLOW,
     * HTTP_SECURITY_ACTION_REDIRECT_TO_HTTPS, HTTP_SECURITY_ACTION_RATE_LIMIT, HTTP_SECURITY_ACTION_REQUEST_CHECK_ICAP.
     * Allowed in basic(allowed values- http_security_action_close_conn,http_security_action_send_response,http_security_action_redirect_to_https)
     * edition, essentials(allowed values- http_security_action_close_conn,http_security_action_send_response,http_security_action_redirect_to_https)
     * edition, enterprise edition.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return action
     */
    public String getAction() {
        return action;
    }

    /**
     * This is the setter method to the attribute.
     * Type of the security action to perform.
     * Enum options - HTTP_SECURITY_ACTION_CLOSE_CONN, HTTP_SECURITY_ACTION_SEND_RESPONSE, HTTP_SECURITY_ACTION_ALLOW,
     * HTTP_SECURITY_ACTION_REDIRECT_TO_HTTPS, HTTP_SECURITY_ACTION_RATE_LIMIT, HTTP_SECURITY_ACTION_REQUEST_CHECK_ICAP.
     * Allowed in basic(allowed values- http_security_action_close_conn,http_security_action_send_response,http_security_action_redirect_to_https)
     * edition, essentials(allowed values- http_security_action_close_conn,http_security_action_send_response,http_security_action_redirect_to_https)
     * edition, enterprise edition.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param action set the action.
     */
    public void setAction(String  action) {
        this.action = action;
    }

    /**
     * This is the getter method this will return the attribute value.
     * File to be used for generating http local response.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return file
     */
    public HTTPLocalFile getFile() {
        return file;
    }

    /**
     * This is the setter method to the attribute.
     * File to be used for generating http local response.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param file set the file.
     */
    public void setFile(HTTPLocalFile file) {
        this.file = file;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Secure ssl/tls port to redirect the http request to.
     * Allowed values are 1-65535.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return httpsPort
     */
    public Integer getHttpsPort() {
        return httpsPort;
    }

    /**
     * This is the setter method to the attribute.
     * Secure ssl/tls port to redirect the http request to.
     * Allowed values are 1-65535.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param httpsPort set the httpsPort.
     */
    public void setHttpsPort(Integer  httpsPort) {
        this.httpsPort = httpsPort;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Rate limit profile to be used to rate-limit the flow.
     * (deprecated).
     * Field deprecated in 18.2.9.
     * @return rateLimit
     */
    public RateProfile getRateLimit() {
        return rateLimit;
    }

    /**
     * This is the setter method to the attribute.
     * Rate limit profile to be used to rate-limit the flow.
     * (deprecated).
     * Field deprecated in 18.2.9.
     * @param rateLimit set the rateLimit.
     */
    public void setRateLimit(RateProfile rateLimit) {
        this.rateLimit = rateLimit;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Rate limiting configuration for this action.
     * Field introduced in 18.2.9.
     * Allowed in basic edition, essentials edition, enterprise edition.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return rateProfile
     */
    public HTTPSecurityActionRateProfile getRateProfile() {
        return rateProfile;
    }

    /**
     * This is the setter method to the attribute.
     * Rate limiting configuration for this action.
     * Field introduced in 18.2.9.
     * Allowed in basic edition, essentials edition, enterprise edition.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param rateProfile set the rateProfile.
     */
    public void setRateProfile(HTTPSecurityActionRateProfile rateProfile) {
        this.rateProfile = rateProfile;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Http status code to use for local response.
     * Enum options - HTTP_LOCAL_RESPONSE_STATUS_CODE_200, HTTP_LOCAL_RESPONSE_STATUS_CODE_204, HTTP_LOCAL_RESPONSE_STATUS_CODE_403,
     * HTTP_LOCAL_RESPONSE_STATUS_CODE_404, HTTP_LOCAL_RESPONSE_STATUS_CODE_429, HTTP_LOCAL_RESPONSE_STATUS_CODE_501.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return statusCode
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * This is the setter method to the attribute.
     * Http status code to use for local response.
     * Enum options - HTTP_LOCAL_RESPONSE_STATUS_CODE_200, HTTP_LOCAL_RESPONSE_STATUS_CODE_204, HTTP_LOCAL_RESPONSE_STATUS_CODE_403,
     * HTTP_LOCAL_RESPONSE_STATUS_CODE_404, HTTP_LOCAL_RESPONSE_STATUS_CODE_429, HTTP_LOCAL_RESPONSE_STATUS_CODE_501.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param statusCode set the statusCode.
     */
    public void setStatusCode(String  statusCode) {
        this.statusCode = statusCode;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      HTTPSecurityAction objHTTPSecurityAction = (HTTPSecurityAction) o;
      return   Objects.equals(this.action, objHTTPSecurityAction.action)&&
  Objects.equals(this.statusCode, objHTTPSecurityAction.statusCode)&&
  Objects.equals(this.httpsPort, objHTTPSecurityAction.httpsPort)&&
  Objects.equals(this.file, objHTTPSecurityAction.file)&&
  Objects.equals(this.rateLimit, objHTTPSecurityAction.rateLimit)&&
  Objects.equals(this.rateProfile, objHTTPSecurityAction.rateProfile);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class HTTPSecurityAction {\n");
                  sb.append("    action: ").append(toIndentedString(action)).append("\n");
                        sb.append("    file: ").append(toIndentedString(file)).append("\n");
                        sb.append("    httpsPort: ").append(toIndentedString(httpsPort)).append("\n");
                        sb.append("    rateLimit: ").append(toIndentedString(rateLimit)).append("\n");
                        sb.append("    rateProfile: ").append(toIndentedString(rateProfile)).append("\n");
                        sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
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
