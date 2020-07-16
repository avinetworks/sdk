package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The HTTPRequestRule is a POJO class extends AviRestResource that used for creating
 * HTTPRequestRule.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HTTPRequestRule  {
    @JsonProperty("all_headers")
    private Boolean allHeaders = null;

    @JsonProperty("enable")
    private Boolean enable = true;

    @JsonProperty("hdr_action")
    private List<HTTPHdrAction> hdrAction = null;

    @JsonProperty("index")
    private Integer index = null;

    @JsonProperty("log")
    private Boolean log = null;

    @JsonProperty("match")
    private MatchTarget match = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("redirect_action")
    private HTTPRedirectAction redirectAction = null;

    @JsonProperty("rewrite_url_action")
    private HTTPRewriteURLAction rewriteUrlAction = null;

    @JsonProperty("switching_action")
    private HTTPSwitchingAction switchingAction = null;



  /**
   * This is the getter method this will return the attribute value.
   * Log all http headers upon rule match.
   * @return allHeaders
   */
  public Boolean getAllHeaders() {
    return allHeaders;
  }

  /**
   * This is the setter method to the attribute.
   * Log all http headers upon rule match.
   * @param allHeaders set the allHeaders.
   */
  public void setAllHeaders(Boolean  allHeaders) {
    this.allHeaders = allHeaders;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable or disable the rule.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return enable
   */
  public Boolean getEnable() {
    return enable;
  }

  /**
   * This is the setter method to the attribute.
   * Enable or disable the rule.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param enable set the enable.
   */
  public void setEnable(Boolean  enable) {
    this.enable = enable;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Http header rewrite action.
   * @return hdrAction
   */
  public List<HTTPHdrAction> getHdrAction() {
    return hdrAction;
  }

  /**
   * This is the setter method. this will set the hdrAction
   * Http header rewrite action.
   * @return hdrAction
   */
  public void setHdrAction(List<HTTPHdrAction>  hdrAction) {
    this.hdrAction = hdrAction;
  }

  /**
   * This is the setter method this will set the hdrAction
   * Http header rewrite action.
   * @return hdrAction
   */
  public HTTPRequestRule addHdrActionItem(HTTPHdrAction hdrActionItem) {
    if (this.hdrAction == null) {
      this.hdrAction = new ArrayList<HTTPHdrAction>();
    }
    this.hdrAction.add(hdrActionItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Index of the rule.
   * @return index
   */
  public Integer getIndex() {
    return index;
  }

  /**
   * This is the setter method to the attribute.
   * Index of the rule.
   * @param index set the index.
   */
  public void setIndex(Integer  index) {
    this.index = index;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Log http request upon rule match.
   * @return log
   */
  public Boolean getLog() {
    return log;
  }

  /**
   * This is the setter method to the attribute.
   * Log http request upon rule match.
   * @param log set the log.
   */
  public void setLog(Boolean  log) {
    this.log = log;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Add match criteria to the rule.
   * @return match
   */
  public MatchTarget getMatch() {
    return match;
  }

  /**
   * This is the setter method to the attribute.
   * Add match criteria to the rule.
   * @param match set the match.
   */
  public void setMatch(MatchTarget match) {
    this.match = match;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the rule.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the rule.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Http redirect action.
   * @return redirectAction
   */
  public HTTPRedirectAction getRedirectAction() {
    return redirectAction;
  }

  /**
   * This is the setter method to the attribute.
   * Http redirect action.
   * @param redirectAction set the redirectAction.
   */
  public void setRedirectAction(HTTPRedirectAction redirectAction) {
    this.redirectAction = redirectAction;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Http request url rewrite action.
   * @return rewriteUrlAction
   */
  public HTTPRewriteURLAction getRewriteUrlAction() {
    return rewriteUrlAction;
  }

  /**
   * This is the setter method to the attribute.
   * Http request url rewrite action.
   * @param rewriteUrlAction set the rewriteUrlAction.
   */
  public void setRewriteUrlAction(HTTPRewriteURLAction rewriteUrlAction) {
    this.rewriteUrlAction = rewriteUrlAction;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Content switching action.
   * @return switchingAction
   */
  public HTTPSwitchingAction getSwitchingAction() {
    return switchingAction;
  }

  /**
   * This is the setter method to the attribute.
   * Content switching action.
   * @param switchingAction set the switchingAction.
   */
  public void setSwitchingAction(HTTPSwitchingAction switchingAction) {
    this.switchingAction = switchingAction;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  HTTPRequestRule objHTTPRequestRule = (HTTPRequestRule) o;
  return   Objects.equals(this.index, objHTTPRequestRule.index)&&
  Objects.equals(this.enable, objHTTPRequestRule.enable)&&
  Objects.equals(this.name, objHTTPRequestRule.name)&&
  Objects.equals(this.rewriteUrlAction, objHTTPRequestRule.rewriteUrlAction)&&
  Objects.equals(this.switchingAction, objHTTPRequestRule.switchingAction)&&
  Objects.equals(this.redirectAction, objHTTPRequestRule.redirectAction)&&
  Objects.equals(this.hdrAction, objHTTPRequestRule.hdrAction)&&
  Objects.equals(this.allHeaders, objHTTPRequestRule.allHeaders)&&
  Objects.equals(this.match, objHTTPRequestRule.match)&&
  Objects.equals(this.log, objHTTPRequestRule.log);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class HTTPRequestRule {\n");
      sb.append("    allHeaders: ").append(toIndentedString(allHeaders)).append("\n");
        sb.append("    enable: ").append(toIndentedString(enable)).append("\n");
        sb.append("    hdrAction: ").append(toIndentedString(hdrAction)).append("\n");
        sb.append("    index: ").append(toIndentedString(index)).append("\n");
        sb.append("    log: ").append(toIndentedString(log)).append("\n");
        sb.append("    match: ").append(toIndentedString(match)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    redirectAction: ").append(toIndentedString(redirectAction)).append("\n");
        sb.append("    rewriteUrlAction: ").append(toIndentedString(rewriteUrlAction)).append("\n");
        sb.append("    switchingAction: ").append(toIndentedString(switchingAction)).append("\n");
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

