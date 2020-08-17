package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ContentRewriteProfile is a POJO class extends AviRestResource that used for creating
 * ContentRewriteProfile.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContentRewriteProfile  {
    @JsonProperty("req_match_replace_pair")
    private List<MatchReplacePair> reqMatchReplacePair = null;

    @JsonProperty("request_rewrite_enabled")
    private Boolean requestRewriteEnabled = false;

    @JsonProperty("response_rewrite_enabled")
    private Boolean responseRewriteEnabled = false;

    @JsonProperty("rewritable_content_ref")
    private String rewritableContentRef = null;

    @JsonProperty("rsp_match_replace_pair")
    private List<MatchReplacePair> rspMatchReplacePair = null;


  /**
   * This is the getter method this will return the attribute value.
   * Strings to be matched and replaced with on the request body.
   * @return reqMatchReplacePair
   */
  public List<MatchReplacePair> getReqMatchReplacePair() {
    return reqMatchReplacePair;
  }

  /**
   * This is the setter method. this will set the reqMatchReplacePair
   * Strings to be matched and replaced with on the request body.
   * @return reqMatchReplacePair
   */
  public void setReqMatchReplacePair(List<MatchReplacePair>  reqMatchReplacePair) {
    this.reqMatchReplacePair = reqMatchReplacePair;
  }

  /**
   * This is the setter method this will set the reqMatchReplacePair
   * Strings to be matched and replaced with on the request body.
   * @return reqMatchReplacePair
   */
  public ContentRewriteProfile addReqMatchReplacePairItem(MatchReplacePair reqMatchReplacePairItem) {
    if (this.reqMatchReplacePair == null) {
      this.reqMatchReplacePair = new ArrayList<MatchReplacePair>();
    }
    this.reqMatchReplacePair.add(reqMatchReplacePairItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable rewrite on request body.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return requestRewriteEnabled
   */
  public Boolean getRequestRewriteEnabled() {
    return requestRewriteEnabled;
  }

  /**
   * This is the setter method to the attribute.
   * Enable rewrite on request body.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param requestRewriteEnabled set the requestRewriteEnabled.
   */
  public void setRequestRewriteEnabled(Boolean  requestRewriteEnabled) {
    this.requestRewriteEnabled = requestRewriteEnabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable rewrite on response body.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return responseRewriteEnabled
   */
  public Boolean getResponseRewriteEnabled() {
    return responseRewriteEnabled;
  }

  /**
   * This is the setter method to the attribute.
   * Enable rewrite on response body.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param responseRewriteEnabled set the responseRewriteEnabled.
   */
  public void setResponseRewriteEnabled(Boolean  responseRewriteEnabled) {
    this.responseRewriteEnabled = responseRewriteEnabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Rewrite only content types listed in this string group.
   * Content types not present in this list are not rewritten.
   * It is a reference to an object of type stringgroup.
   * @return rewritableContentRef
   */
  public String getRewritableContentRef() {
    return rewritableContentRef;
  }

  /**
   * This is the setter method to the attribute.
   * Rewrite only content types listed in this string group.
   * Content types not present in this list are not rewritten.
   * It is a reference to an object of type stringgroup.
   * @param rewritableContentRef set the rewritableContentRef.
   */
  public void setRewritableContentRef(String  rewritableContentRef) {
    this.rewritableContentRef = rewritableContentRef;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Strings to be matched and replaced with on the response body.
   * @return rspMatchReplacePair
   */
  public List<MatchReplacePair> getRspMatchReplacePair() {
    return rspMatchReplacePair;
  }

  /**
   * This is the setter method. this will set the rspMatchReplacePair
   * Strings to be matched and replaced with on the response body.
   * @return rspMatchReplacePair
   */
  public void setRspMatchReplacePair(List<MatchReplacePair>  rspMatchReplacePair) {
    this.rspMatchReplacePair = rspMatchReplacePair;
  }

  /**
   * This is the setter method this will set the rspMatchReplacePair
   * Strings to be matched and replaced with on the response body.
   * @return rspMatchReplacePair
   */
  public ContentRewriteProfile addRspMatchReplacePairItem(MatchReplacePair rspMatchReplacePairItem) {
    if (this.rspMatchReplacePair == null) {
      this.rspMatchReplacePair = new ArrayList<MatchReplacePair>();
    }
    this.rspMatchReplacePair.add(rspMatchReplacePairItem);
    return this;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ContentRewriteProfile objContentRewriteProfile = (ContentRewriteProfile) o;
  return   Objects.equals(this.rewritableContentRef, objContentRewriteProfile.rewritableContentRef)&&
  Objects.equals(this.requestRewriteEnabled, objContentRewriteProfile.requestRewriteEnabled)&&
  Objects.equals(this.responseRewriteEnabled, objContentRewriteProfile.responseRewriteEnabled)&&
  Objects.equals(this.reqMatchReplacePair, objContentRewriteProfile.reqMatchReplacePair)&&
  Objects.equals(this.rspMatchReplacePair, objContentRewriteProfile.rspMatchReplacePair);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ContentRewriteProfile {\n");
      sb.append("    reqMatchReplacePair: ").append(toIndentedString(reqMatchReplacePair)).append("\n");
        sb.append("    requestRewriteEnabled: ").append(toIndentedString(requestRewriteEnabled)).append("\n");
        sb.append("    responseRewriteEnabled: ").append(toIndentedString(responseRewriteEnabled)).append("\n");
        sb.append("    rewritableContentRef: ").append(toIndentedString(rewritableContentRef)).append("\n");
        sb.append("    rspMatchReplacePair: ").append(toIndentedString(rspMatchReplacePair)).append("\n");
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

