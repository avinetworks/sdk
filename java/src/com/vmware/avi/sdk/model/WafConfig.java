package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The WafConfig is a POJO class extends AviRestResource that used for creating
 * WafConfig.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WafConfig  {
    @JsonProperty("allowed_http_versions")
    private List<String> allowedHttpVersions = null;

    @JsonProperty("allowed_methods")
    private List<String> allowedMethods = null;

    @JsonProperty("allowed_request_content_types")
    private List<String> allowedRequestContentTypes = null;

    @JsonProperty("argument_separator")
    private String argumentSeparator = "&";

    @JsonProperty("buffer_response_body_for_inspection")
    private Boolean bufferResponseBodyForInspection = null;

    @JsonProperty("client_file_upload_max_body_size")
    private Integer clientFileUploadMaxBodySize = null;

    @JsonProperty("client_nonfile_upload_max_body_size")
    private Integer clientNonfileUploadMaxBodySize = null;

    @JsonProperty("client_request_max_body_size")
    private Integer clientRequestMaxBodySize = 32;

    @JsonProperty("confidence_override")
    private AppLearningConfidenceOverride confidenceOverride = null;

    @JsonProperty("cookie_format_version")
    private Integer cookieFormatVersion = 0;

    @JsonProperty("enable_auto_rule_updates")
    private Boolean enableAutoRuleUpdates = true;

    @JsonProperty("enable_regex_learning")
    private Boolean enableRegexLearning = false;

    @JsonProperty("ignore_incomplete_request_body_error")
    private Boolean ignoreIncompleteRequestBodyError = true;

    @JsonProperty("learning_params")
    private AppLearningParams learningParams = null;

    @JsonProperty("max_execution_time")
    private Integer maxExecutionTime = 50;

    @JsonProperty("min_confidence")
    private String minConfidence = "CONFIDENCE_VERY_HIGH";

    @JsonProperty("regex_match_limit")
    private Integer regexMatchLimit = 30000;

    @JsonProperty("regex_recursion_limit")
    private Integer regexRecursionLimit = 10000;

    @JsonProperty("request_body_default_action")
    private String requestBodyDefaultAction = "phase:2,deny,status:403,log,auditlog";

    @JsonProperty("request_hdr_default_action")
    private String requestHdrDefaultAction = "phase:1,deny,status:403,log,auditlog";

    @JsonProperty("response_body_default_action")
    private String responseBodyDefaultAction = "phase:4,deny,status:403,log,auditlog";

    @JsonProperty("response_hdr_default_action")
    private String responseHdrDefaultAction = "phase:3,deny,status:403,log,auditlog";

    @JsonProperty("restricted_extensions")
    private List<String> restrictedExtensions = null;

    @JsonProperty("restricted_headers")
    private List<String> restrictedHeaders = null;

    @JsonProperty("server_response_max_body_size")
    private Integer serverResponseMaxBodySize = 128;

    @JsonProperty("static_extensions")
    private List<String> staticExtensions = null;

    @JsonProperty("status_code_for_rejected_requests")
    private String statusCodeForRejectedRequests = "HTTP_RESPONSE_CODE_403";

    @JsonProperty("xml_xxe_protection")
    private Boolean xmlXxeProtection = true;


  /**
   * This is the getter method this will return the attribute value.
   * Waf allowed http versions.
   * Enum options - ZERO_NINE, ONE_ZERO, ONE_ONE, TWO_ZERO.
   * Field introduced in 17.2.1.
   * @return allowedHttpVersions
   */
  public List<String> getAllowedHttpVersions() {
    return allowedHttpVersions;
  }

  /**
   * This is the setter method. this will set the allowedHttpVersions
   * Waf allowed http versions.
   * Enum options - ZERO_NINE, ONE_ZERO, ONE_ONE, TWO_ZERO.
   * Field introduced in 17.2.1.
   * @return allowedHttpVersions
   */
  public void setAllowedHttpVersions(List<String>  allowedHttpVersions) {
    this.allowedHttpVersions = allowedHttpVersions;
  }

  /**
   * This is the setter method this will set the allowedHttpVersions
   * Waf allowed http versions.
   * Enum options - ZERO_NINE, ONE_ZERO, ONE_ONE, TWO_ZERO.
   * Field introduced in 17.2.1.
   * @return allowedHttpVersions
   */
  public WafConfig addAllowedHttpVersionsItem(String allowedHttpVersionsItem) {
    if (this.allowedHttpVersions == null) {
      this.allowedHttpVersions = new ArrayList<String>();
    }
    this.allowedHttpVersions.add(allowedHttpVersionsItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Waf allowed http methods.
   * Enum options - HTTP_METHOD_GET, HTTP_METHOD_HEAD, HTTP_METHOD_PUT, HTTP_METHOD_DELETE, HTTP_METHOD_POST, HTTP_METHOD_OPTIONS, HTTP_METHOD_TRACE,
   * HTTP_METHOD_CONNECT, HTTP_METHOD_PATCH, HTTP_METHOD_PROPFIND, HTTP_METHOD_PROPPATCH, HTTP_METHOD_MKCOL, HTTP_METHOD_COPY, HTTP_METHOD_MOVE,
   * HTTP_METHOD_LOCK, HTTP_METHOD_UNLOCK.
   * Field introduced in 17.2.1.
   * @return allowedMethods
   */
  public List<String> getAllowedMethods() {
    return allowedMethods;
  }

  /**
   * This is the setter method. this will set the allowedMethods
   * Waf allowed http methods.
   * Enum options - HTTP_METHOD_GET, HTTP_METHOD_HEAD, HTTP_METHOD_PUT, HTTP_METHOD_DELETE, HTTP_METHOD_POST, HTTP_METHOD_OPTIONS, HTTP_METHOD_TRACE,
   * HTTP_METHOD_CONNECT, HTTP_METHOD_PATCH, HTTP_METHOD_PROPFIND, HTTP_METHOD_PROPPATCH, HTTP_METHOD_MKCOL, HTTP_METHOD_COPY, HTTP_METHOD_MOVE,
   * HTTP_METHOD_LOCK, HTTP_METHOD_UNLOCK.
   * Field introduced in 17.2.1.
   * @return allowedMethods
   */
  public void setAllowedMethods(List<String>  allowedMethods) {
    this.allowedMethods = allowedMethods;
  }

  /**
   * This is the setter method this will set the allowedMethods
   * Waf allowed http methods.
   * Enum options - HTTP_METHOD_GET, HTTP_METHOD_HEAD, HTTP_METHOD_PUT, HTTP_METHOD_DELETE, HTTP_METHOD_POST, HTTP_METHOD_OPTIONS, HTTP_METHOD_TRACE,
   * HTTP_METHOD_CONNECT, HTTP_METHOD_PATCH, HTTP_METHOD_PROPFIND, HTTP_METHOD_PROPPATCH, HTTP_METHOD_MKCOL, HTTP_METHOD_COPY, HTTP_METHOD_MOVE,
   * HTTP_METHOD_LOCK, HTTP_METHOD_UNLOCK.
   * Field introduced in 17.2.1.
   * @return allowedMethods
   */
  public WafConfig addAllowedMethodsItem(String allowedMethodsItem) {
    if (this.allowedMethods == null) {
      this.allowedMethods = new ArrayList<String>();
    }
    this.allowedMethods.add(allowedMethodsItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Waf allowed content types.
   * Field introduced in 17.2.1.
   * @return allowedRequestContentTypes
   */
  public List<String> getAllowedRequestContentTypes() {
    return allowedRequestContentTypes;
  }

  /**
   * This is the setter method. this will set the allowedRequestContentTypes
   * Waf allowed content types.
   * Field introduced in 17.2.1.
   * @return allowedRequestContentTypes
   */
  public void setAllowedRequestContentTypes(List<String>  allowedRequestContentTypes) {
    this.allowedRequestContentTypes = allowedRequestContentTypes;
  }

  /**
   * This is the setter method this will set the allowedRequestContentTypes
   * Waf allowed content types.
   * Field introduced in 17.2.1.
   * @return allowedRequestContentTypes
   */
  public WafConfig addAllowedRequestContentTypesItem(String allowedRequestContentTypesItem) {
    if (this.allowedRequestContentTypes == null) {
      this.allowedRequestContentTypes = new ArrayList<String>();
    }
    this.allowedRequestContentTypes.add(allowedRequestContentTypesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Argument seperator.
   * Field introduced in 17.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as &.
   * @return argumentSeparator
   */
  public String getArgumentSeparator() {
    return argumentSeparator;
  }

  /**
   * This is the setter method to the attribute.
   * Argument seperator.
   * Field introduced in 17.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as &.
   * @param argumentSeparator set the argumentSeparator.
   */
  public void setArgumentSeparator(String  argumentSeparator) {
    this.argumentSeparator = argumentSeparator;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable to buffer response body for inspection.
   * Field deprecated in 18.2.2.
   * Field introduced in 17.2.3.
   * @return bufferResponseBodyForInspection
   */
  public Boolean getBufferResponseBodyForInspection() {
    return bufferResponseBodyForInspection;
  }

  /**
   * This is the setter method to the attribute.
   * Enable to buffer response body for inspection.
   * Field deprecated in 18.2.2.
   * Field introduced in 17.2.3.
   * @param bufferResponseBodyForInspection set the bufferResponseBodyForInspection.
   */
  public void setBufferResponseBodyForInspection(Boolean  bufferResponseBodyForInspection) {
    this.bufferResponseBodyForInspection = bufferResponseBodyForInspection;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum size for the client request body for file uploads.
   * Allowed values are 1-32768.
   * Field deprecated in 18.1.5.
   * Field introduced in 17.2.1.
   * @return clientFileUploadMaxBodySize
   */
  public Integer getClientFileUploadMaxBodySize() {
    return clientFileUploadMaxBodySize;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum size for the client request body for file uploads.
   * Allowed values are 1-32768.
   * Field deprecated in 18.1.5.
   * Field introduced in 17.2.1.
   * @param clientFileUploadMaxBodySize set the clientFileUploadMaxBodySize.
   */
  public void setClientFileUploadMaxBodySize(Integer  clientFileUploadMaxBodySize) {
    this.clientFileUploadMaxBodySize = clientFileUploadMaxBodySize;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum size for the client request body for non-file uploads.
   * Allowed values are 1-32768.
   * Field deprecated in 18.1.5.
   * Field introduced in 17.2.1.
   * @return clientNonfileUploadMaxBodySize
   */
  public Integer getClientNonfileUploadMaxBodySize() {
    return clientNonfileUploadMaxBodySize;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum size for the client request body for non-file uploads.
   * Allowed values are 1-32768.
   * Field deprecated in 18.1.5.
   * Field introduced in 17.2.1.
   * @param clientNonfileUploadMaxBodySize set the clientNonfileUploadMaxBodySize.
   */
  public void setClientNonfileUploadMaxBodySize(Integer  clientNonfileUploadMaxBodySize) {
    this.clientNonfileUploadMaxBodySize = clientNonfileUploadMaxBodySize;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum size for the client request body scanned by waf.
   * Allowed values are 1-32768.
   * Field introduced in 18.1.5, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 32.
   * @return clientRequestMaxBodySize
   */
  public Integer getClientRequestMaxBodySize() {
    return clientRequestMaxBodySize;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum size for the client request body scanned by waf.
   * Allowed values are 1-32768.
   * Field introduced in 18.1.5, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 32.
   * @param clientRequestMaxBodySize set the clientRequestMaxBodySize.
   */
  public void setClientRequestMaxBodySize(Integer  clientRequestMaxBodySize) {
    this.clientRequestMaxBodySize = clientRequestMaxBodySize;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Configure thresholds for confidence labels.
   * Field introduced in 18.2.3.
   * @return confidenceOverride
   */
  public AppLearningConfidenceOverride getConfidenceOverride() {
    return confidenceOverride;
  }

  /**
   * This is the setter method to the attribute.
   * Configure thresholds for confidence labels.
   * Field introduced in 18.2.3.
   * @param confidenceOverride set the confidenceOverride.
   */
  public void setConfidenceOverride(AppLearningConfidenceOverride confidenceOverride) {
    this.confidenceOverride = confidenceOverride;
  }

  /**
   * This is the getter method this will return the attribute value.
   * 0  for netscape cookies.
   * 1  for version 1 cookies.
   * Allowed values are 0-1.
   * Field introduced in 17.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return cookieFormatVersion
   */
  public Integer getCookieFormatVersion() {
    return cookieFormatVersion;
  }

  /**
   * This is the setter method to the attribute.
   * 0  for netscape cookies.
   * 1  for version 1 cookies.
   * Allowed values are 0-1.
   * Field introduced in 17.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param cookieFormatVersion set the cookieFormatVersion.
   */
  public void setCookieFormatVersion(Integer  cookieFormatVersion) {
    this.cookieFormatVersion = cookieFormatVersion;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable application learning based rule updates on the waf profile.
   * Rules will be programmed in dedicated waf learning group.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return enableAutoRuleUpdates
   */
  public Boolean getEnableAutoRuleUpdates() {
    return enableAutoRuleUpdates;
  }

  /**
   * This is the setter method to the attribute.
   * Enable application learning based rule updates on the waf profile.
   * Rules will be programmed in dedicated waf learning group.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param enableAutoRuleUpdates set the enableAutoRuleUpdates.
   */
  public void setEnableAutoRuleUpdates(Boolean  enableAutoRuleUpdates) {
    this.enableAutoRuleUpdates = enableAutoRuleUpdates;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable dynamic regex generation for positive security model rules.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return enableRegexLearning
   */
  public Boolean getEnableRegexLearning() {
    return enableRegexLearning;
  }

  /**
   * This is the setter method to the attribute.
   * Enable dynamic regex generation for positive security model rules.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param enableRegexLearning set the enableRegexLearning.
   */
  public void setEnableRegexLearning(Boolean  enableRegexLearning) {
    this.enableRegexLearning = enableRegexLearning;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ignore request body parsing errors due to partial scanning.
   * Field introduced in 18.1.5, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return ignoreIncompleteRequestBodyError
   */
  public Boolean getIgnoreIncompleteRequestBodyError() {
    return ignoreIncompleteRequestBodyError;
  }

  /**
   * This is the setter method to the attribute.
   * Ignore request body parsing errors due to partial scanning.
   * Field introduced in 18.1.5, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param ignoreIncompleteRequestBodyError set the ignoreIncompleteRequestBodyError.
   */
  public void setIgnoreIncompleteRequestBodyError(Boolean  ignoreIncompleteRequestBodyError) {
    this.ignoreIncompleteRequestBodyError = ignoreIncompleteRequestBodyError;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Parameters for tuning application learning.
   * Field introduced in 18.2.3.
   * @return learningParams
   */
  public AppLearningParams getLearningParams() {
    return learningParams;
  }

  /**
   * This is the setter method to the attribute.
   * Parameters for tuning application learning.
   * Field introduced in 18.2.3.
   * @param learningParams set the learningParams.
   */
  public void setLearningParams(AppLearningParams learningParams) {
    this.learningParams = learningParams;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The maximum period of time waf processing is allowed to take for a single request.
   * A value of 0 (zero) means no limit and should not be chosen in production deployments.
   * It is only used for exceptional situations where crashes of se_dp processes are acceptable.
   * The behavior of the system if this time is exceeded depends on two other configuration settings, the waf policy mode and the waf failure mode.
   * In waf policy mode 'detection', the request is allowed and flagged for both failure mode 'closed' and 'open'.
   * In enforcement node, 'closed' means the request is rejected, 'open' means the request is allowed and flagged.
   * Irrespective of these settings, no subsequent waf rules of this or other phases will be executed once the maximum execution time has been
   * exceeded.
   * Allowed values are 0-5000.
   * Field introduced in 17.2.12, 18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as 50.
   * @return maxExecutionTime
   */
  public Integer getMaxExecutionTime() {
    return maxExecutionTime;
  }

  /**
   * This is the setter method to the attribute.
   * The maximum period of time waf processing is allowed to take for a single request.
   * A value of 0 (zero) means no limit and should not be chosen in production deployments.
   * It is only used for exceptional situations where crashes of se_dp processes are acceptable.
   * The behavior of the system if this time is exceeded depends on two other configuration settings, the waf policy mode and the waf failure mode.
   * In waf policy mode 'detection', the request is allowed and flagged for both failure mode 'closed' and 'open'.
   * In enforcement node, 'closed' means the request is rejected, 'open' means the request is allowed and flagged.
   * Irrespective of these settings, no subsequent waf rules of this or other phases will be executed once the maximum execution time has been
   * exceeded.
   * Allowed values are 0-5000.
   * Field introduced in 17.2.12, 18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as 50.
   * @param maxExecutionTime set the maxExecutionTime.
   */
  public void setMaxExecutionTime(Integer  maxExecutionTime) {
    this.maxExecutionTime = maxExecutionTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Minimum confidence label required for auto rule updates.
   * Enum options - CONFIDENCE_VERY_HIGH, CONFIDENCE_HIGH, CONFIDENCE_PROBABLE, CONFIDENCE_LOW, CONFIDENCE_NONE.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as CONFIDENCE_VERY_HIGH.
   * @return minConfidence
   */
  public String getMinConfidence() {
    return minConfidence;
  }

  /**
   * This is the setter method to the attribute.
   * Minimum confidence label required for auto rule updates.
   * Enum options - CONFIDENCE_VERY_HIGH, CONFIDENCE_HIGH, CONFIDENCE_PROBABLE, CONFIDENCE_LOW, CONFIDENCE_NONE.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as CONFIDENCE_VERY_HIGH.
   * @param minConfidence set the minConfidence.
   */
  public void setMinConfidence(String  minConfidence) {
    this.minConfidence = minConfidence;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Limit cpu utilization for each regular expression match when processing rules.
   * Field introduced in 17.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 30000.
   * @return regexMatchLimit
   */
  public Integer getRegexMatchLimit() {
    return regexMatchLimit;
  }

  /**
   * This is the setter method to the attribute.
   * Limit cpu utilization for each regular expression match when processing rules.
   * Field introduced in 17.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 30000.
   * @param regexMatchLimit set the regexMatchLimit.
   */
  public void setRegexMatchLimit(Integer  regexMatchLimit) {
    this.regexMatchLimit = regexMatchLimit;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Limit depth of recursion for each regular expression match when processing rules.
   * Field introduced in 18.2.9.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10000.
   * @return regexRecursionLimit
   */
  public Integer getRegexRecursionLimit() {
    return regexRecursionLimit;
  }

  /**
   * This is the setter method to the attribute.
   * Limit depth of recursion for each regular expression match when processing rules.
   * Field introduced in 18.2.9.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10000.
   * @param regexRecursionLimit set the regexRecursionLimit.
   */
  public void setRegexRecursionLimit(Integer  regexRecursionLimit) {
    this.regexRecursionLimit = regexRecursionLimit;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Waf default action for request body phase.
   * Field introduced in 17.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as phase:2,deny,status:403,log,auditlog.
   * @return requestBodyDefaultAction
   */
  public String getRequestBodyDefaultAction() {
    return requestBodyDefaultAction;
  }

  /**
   * This is the setter method to the attribute.
   * Waf default action for request body phase.
   * Field introduced in 17.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as phase:2,deny,status:403,log,auditlog.
   * @param requestBodyDefaultAction set the requestBodyDefaultAction.
   */
  public void setRequestBodyDefaultAction(String  requestBodyDefaultAction) {
    this.requestBodyDefaultAction = requestBodyDefaultAction;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Waf default action for request header phase.
   * Field introduced in 17.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as phase:1,deny,status:403,log,auditlog.
   * @return requestHdrDefaultAction
   */
  public String getRequestHdrDefaultAction() {
    return requestHdrDefaultAction;
  }

  /**
   * This is the setter method to the attribute.
   * Waf default action for request header phase.
   * Field introduced in 17.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as phase:1,deny,status:403,log,auditlog.
   * @param requestHdrDefaultAction set the requestHdrDefaultAction.
   */
  public void setRequestHdrDefaultAction(String  requestHdrDefaultAction) {
    this.requestHdrDefaultAction = requestHdrDefaultAction;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Waf default action for response body phase.
   * Field introduced in 17.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as phase:4,deny,status:403,log,auditlog.
   * @return responseBodyDefaultAction
   */
  public String getResponseBodyDefaultAction() {
    return responseBodyDefaultAction;
  }

  /**
   * This is the setter method to the attribute.
   * Waf default action for response body phase.
   * Field introduced in 17.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as phase:4,deny,status:403,log,auditlog.
   * @param responseBodyDefaultAction set the responseBodyDefaultAction.
   */
  public void setResponseBodyDefaultAction(String  responseBodyDefaultAction) {
    this.responseBodyDefaultAction = responseBodyDefaultAction;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Waf default action for response header phase.
   * Field introduced in 17.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as phase:3,deny,status:403,log,auditlog.
   * @return responseHdrDefaultAction
   */
  public String getResponseHdrDefaultAction() {
    return responseHdrDefaultAction;
  }

  /**
   * This is the setter method to the attribute.
   * Waf default action for response header phase.
   * Field introduced in 17.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as phase:3,deny,status:403,log,auditlog.
   * @param responseHdrDefaultAction set the responseHdrDefaultAction.
   */
  public void setResponseHdrDefaultAction(String  responseHdrDefaultAction) {
    this.responseHdrDefaultAction = responseHdrDefaultAction;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Waf restricted file extensions.
   * Field introduced in 17.2.1.
   * @return restrictedExtensions
   */
  public List<String> getRestrictedExtensions() {
    return restrictedExtensions;
  }

  /**
   * This is the setter method. this will set the restrictedExtensions
   * Waf restricted file extensions.
   * Field introduced in 17.2.1.
   * @return restrictedExtensions
   */
  public void setRestrictedExtensions(List<String>  restrictedExtensions) {
    this.restrictedExtensions = restrictedExtensions;
  }

  /**
   * This is the setter method this will set the restrictedExtensions
   * Waf restricted file extensions.
   * Field introduced in 17.2.1.
   * @return restrictedExtensions
   */
  public WafConfig addRestrictedExtensionsItem(String restrictedExtensionsItem) {
    if (this.restrictedExtensions == null) {
      this.restrictedExtensions = new ArrayList<String>();
    }
    this.restrictedExtensions.add(restrictedExtensionsItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Waf restricted http headers.
   * Field introduced in 17.2.1.
   * @return restrictedHeaders
   */
  public List<String> getRestrictedHeaders() {
    return restrictedHeaders;
  }

  /**
   * This is the setter method. this will set the restrictedHeaders
   * Waf restricted http headers.
   * Field introduced in 17.2.1.
   * @return restrictedHeaders
   */
  public void setRestrictedHeaders(List<String>  restrictedHeaders) {
    this.restrictedHeaders = restrictedHeaders;
  }

  /**
   * This is the setter method this will set the restrictedHeaders
   * Waf restricted http headers.
   * Field introduced in 17.2.1.
   * @return restrictedHeaders
   */
  public WafConfig addRestrictedHeadersItem(String restrictedHeadersItem) {
    if (this.restrictedHeaders == null) {
      this.restrictedHeaders = new ArrayList<String>();
    }
    this.restrictedHeaders.add(restrictedHeadersItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum size for response body scanned by waf.
   * Allowed values are 1-32768.
   * Field introduced in 17.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 128.
   * @return serverResponseMaxBodySize
   */
  public Integer getServerResponseMaxBodySize() {
    return serverResponseMaxBodySize;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum size for response body scanned by waf.
   * Allowed values are 1-32768.
   * Field introduced in 17.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 128.
   * @param serverResponseMaxBodySize set the serverResponseMaxBodySize.
   */
  public void setServerResponseMaxBodySize(Integer  serverResponseMaxBodySize) {
    this.serverResponseMaxBodySize = serverResponseMaxBodySize;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Waf static file extensions.
   * Get and head requests with no query args and one of these extensions are whitelisted and not checked by the ruleset.
   * Field introduced in 17.2.5.
   * @return staticExtensions
   */
  public List<String> getStaticExtensions() {
    return staticExtensions;
  }

  /**
   * This is the setter method. this will set the staticExtensions
   * Waf static file extensions.
   * Get and head requests with no query args and one of these extensions are whitelisted and not checked by the ruleset.
   * Field introduced in 17.2.5.
   * @return staticExtensions
   */
  public void setStaticExtensions(List<String>  staticExtensions) {
    this.staticExtensions = staticExtensions;
  }

  /**
   * This is the setter method this will set the staticExtensions
   * Waf static file extensions.
   * Get and head requests with no query args and one of these extensions are whitelisted and not checked by the ruleset.
   * Field introduced in 17.2.5.
   * @return staticExtensions
   */
  public WafConfig addStaticExtensionsItem(String staticExtensionsItem) {
    if (this.staticExtensions == null) {
      this.staticExtensions = new ArrayList<String>();
    }
    this.staticExtensions.add(staticExtensionsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Http status code used by waf positive security model when rejecting a request.
   * Enum options - HTTP_RESPONSE_CODE_0, HTTP_RESPONSE_CODE_100, HTTP_RESPONSE_CODE_101, HTTP_RESPONSE_CODE_200, HTTP_RESPONSE_CODE_201,
   * HTTP_RESPONSE_CODE_202, HTTP_RESPONSE_CODE_203, HTTP_RESPONSE_CODE_204, HTTP_RESPONSE_CODE_205, HTTP_RESPONSE_CODE_206, HTTP_RESPONSE_CODE_300,
   * HTTP_RESPONSE_CODE_301, HTTP_RESPONSE_CODE_302, HTTP_RESPONSE_CODE_303, HTTP_RESPONSE_CODE_304, HTTP_RESPONSE_CODE_305, HTTP_RESPONSE_CODE_307,
   * HTTP_RESPONSE_CODE_400, HTTP_RESPONSE_CODE_401, HTTP_RESPONSE_CODE_402...
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as HTTP_RESPONSE_CODE_403.
   * @return statusCodeForRejectedRequests
   */
  public String getStatusCodeForRejectedRequests() {
    return statusCodeForRejectedRequests;
  }

  /**
   * This is the setter method to the attribute.
   * Http status code used by waf positive security model when rejecting a request.
   * Enum options - HTTP_RESPONSE_CODE_0, HTTP_RESPONSE_CODE_100, HTTP_RESPONSE_CODE_101, HTTP_RESPONSE_CODE_200, HTTP_RESPONSE_CODE_201,
   * HTTP_RESPONSE_CODE_202, HTTP_RESPONSE_CODE_203, HTTP_RESPONSE_CODE_204, HTTP_RESPONSE_CODE_205, HTTP_RESPONSE_CODE_206, HTTP_RESPONSE_CODE_300,
   * HTTP_RESPONSE_CODE_301, HTTP_RESPONSE_CODE_302, HTTP_RESPONSE_CODE_303, HTTP_RESPONSE_CODE_304, HTTP_RESPONSE_CODE_305, HTTP_RESPONSE_CODE_307,
   * HTTP_RESPONSE_CODE_400, HTTP_RESPONSE_CODE_401, HTTP_RESPONSE_CODE_402...
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as HTTP_RESPONSE_CODE_403.
   * @param statusCodeForRejectedRequests set the statusCodeForRejectedRequests.
   */
  public void setStatusCodeForRejectedRequests(String  statusCodeForRejectedRequests) {
    this.statusCodeForRejectedRequests = statusCodeForRejectedRequests;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Block or flag xml requests referring to external entities.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return xmlXxeProtection
   */
  public Boolean getXmlXxeProtection() {
    return xmlXxeProtection;
  }

  /**
   * This is the setter method to the attribute.
   * Block or flag xml requests referring to external entities.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param xmlXxeProtection set the xmlXxeProtection.
   */
  public void setXmlXxeProtection(Boolean  xmlXxeProtection) {
    this.xmlXxeProtection = xmlXxeProtection;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  WafConfig objWafConfig = (WafConfig) o;
  return   Objects.equals(this.learningParams, objWafConfig.learningParams)&&
  Objects.equals(this.restrictedHeaders, objWafConfig.restrictedHeaders)&&
  Objects.equals(this.responseBodyDefaultAction, objWafConfig.responseBodyDefaultAction)&&
  Objects.equals(this.regexRecursionLimit, objWafConfig.regexRecursionLimit)&&
  Objects.equals(this.bufferResponseBodyForInspection, objWafConfig.bufferResponseBodyForInspection)&&
  Objects.equals(this.allowedHttpVersions, objWafConfig.allowedHttpVersions)&&
  Objects.equals(this.enableAutoRuleUpdates, objWafConfig.enableAutoRuleUpdates)&&
  Objects.equals(this.allowedRequestContentTypes, objWafConfig.allowedRequestContentTypes)&&
  Objects.equals(this.clientFileUploadMaxBodySize, objWafConfig.clientFileUploadMaxBodySize)&&
  Objects.equals(this.confidenceOverride, objWafConfig.confidenceOverride)&&
  Objects.equals(this.clientNonfileUploadMaxBodySize, objWafConfig.clientNonfileUploadMaxBodySize)&&
  Objects.equals(this.minConfidence, objWafConfig.minConfidence)&&
  Objects.equals(this.regexMatchLimit, objWafConfig.regexMatchLimit)&&
  Objects.equals(this.maxExecutionTime, objWafConfig.maxExecutionTime)&&
  Objects.equals(this.responseHdrDefaultAction, objWafConfig.responseHdrDefaultAction)&&
  Objects.equals(this.requestHdrDefaultAction, objWafConfig.requestHdrDefaultAction)&&
  Objects.equals(this.xmlXxeProtection, objWafConfig.xmlXxeProtection)&&
  Objects.equals(this.clientRequestMaxBodySize, objWafConfig.clientRequestMaxBodySize)&&
  Objects.equals(this.cookieFormatVersion, objWafConfig.cookieFormatVersion)&&
  Objects.equals(this.serverResponseMaxBodySize, objWafConfig.serverResponseMaxBodySize)&&
  Objects.equals(this.argumentSeparator, objWafConfig.argumentSeparator)&&
  Objects.equals(this.ignoreIncompleteRequestBodyError, objWafConfig.ignoreIncompleteRequestBodyError)&&
  Objects.equals(this.allowedMethods, objWafConfig.allowedMethods)&&
  Objects.equals(this.requestBodyDefaultAction, objWafConfig.requestBodyDefaultAction)&&
  Objects.equals(this.enableRegexLearning, objWafConfig.enableRegexLearning)&&
  Objects.equals(this.statusCodeForRejectedRequests, objWafConfig.statusCodeForRejectedRequests)&&
  Objects.equals(this.staticExtensions, objWafConfig.staticExtensions)&&
  Objects.equals(this.restrictedExtensions, objWafConfig.restrictedExtensions);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class WafConfig {\n");
      sb.append("    allowedHttpVersions: ").append(toIndentedString(allowedHttpVersions)).append("\n");
        sb.append("    allowedMethods: ").append(toIndentedString(allowedMethods)).append("\n");
        sb.append("    allowedRequestContentTypes: ").append(toIndentedString(allowedRequestContentTypes)).append("\n");
        sb.append("    argumentSeparator: ").append(toIndentedString(argumentSeparator)).append("\n");
        sb.append("    bufferResponseBodyForInspection: ").append(toIndentedString(bufferResponseBodyForInspection)).append("\n");
        sb.append("    clientFileUploadMaxBodySize: ").append(toIndentedString(clientFileUploadMaxBodySize)).append("\n");
        sb.append("    clientNonfileUploadMaxBodySize: ").append(toIndentedString(clientNonfileUploadMaxBodySize)).append("\n");
        sb.append("    clientRequestMaxBodySize: ").append(toIndentedString(clientRequestMaxBodySize)).append("\n");
        sb.append("    confidenceOverride: ").append(toIndentedString(confidenceOverride)).append("\n");
        sb.append("    cookieFormatVersion: ").append(toIndentedString(cookieFormatVersion)).append("\n");
        sb.append("    enableAutoRuleUpdates: ").append(toIndentedString(enableAutoRuleUpdates)).append("\n");
        sb.append("    enableRegexLearning: ").append(toIndentedString(enableRegexLearning)).append("\n");
        sb.append("    ignoreIncompleteRequestBodyError: ").append(toIndentedString(ignoreIncompleteRequestBodyError)).append("\n");
        sb.append("    learningParams: ").append(toIndentedString(learningParams)).append("\n");
        sb.append("    maxExecutionTime: ").append(toIndentedString(maxExecutionTime)).append("\n");
        sb.append("    minConfidence: ").append(toIndentedString(minConfidence)).append("\n");
        sb.append("    regexMatchLimit: ").append(toIndentedString(regexMatchLimit)).append("\n");
        sb.append("    regexRecursionLimit: ").append(toIndentedString(regexRecursionLimit)).append("\n");
        sb.append("    requestBodyDefaultAction: ").append(toIndentedString(requestBodyDefaultAction)).append("\n");
        sb.append("    requestHdrDefaultAction: ").append(toIndentedString(requestHdrDefaultAction)).append("\n");
        sb.append("    responseBodyDefaultAction: ").append(toIndentedString(responseBodyDefaultAction)).append("\n");
        sb.append("    responseHdrDefaultAction: ").append(toIndentedString(responseHdrDefaultAction)).append("\n");
        sb.append("    restrictedExtensions: ").append(toIndentedString(restrictedExtensions)).append("\n");
        sb.append("    restrictedHeaders: ").append(toIndentedString(restrictedHeaders)).append("\n");
        sb.append("    serverResponseMaxBodySize: ").append(toIndentedString(serverResponseMaxBodySize)).append("\n");
        sb.append("    staticExtensions: ").append(toIndentedString(staticExtensions)).append("\n");
        sb.append("    statusCodeForRejectedRequests: ").append(toIndentedString(statusCodeForRejectedRequests)).append("\n");
        sb.append("    xmlXxeProtection: ").append(toIndentedString(xmlXxeProtection)).append("\n");
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

