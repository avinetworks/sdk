package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The HTTPSecurityRule is a POJO class extends AviRestResource that used for creating
 * HTTPSecurityRule.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HTTPSecurityRule  {
    @JsonProperty("action")
    private HTTPSecurityAction action = null;

    @JsonProperty("enable")
    private Boolean enable = true;

    @JsonProperty("index")
    private Integer index = null;

    @JsonProperty("log")
    private Boolean log = null;

    @JsonProperty("match")
    private MatchTarget match = null;

    @JsonProperty("name")
    private String name = null;



  /**
   * This is the getter method this will return the attribute value.
   * Action to be performed upon successful matching.
   * @return action
   */
  public HTTPSecurityAction getAction() {
    return action;
  }

  /**
   * This is the setter method to the attribute.
   * Action to be performed upon successful matching.
   * @param action set the action.
   */
  public void setAction(HTTPSecurityAction action) {
    this.action = action;
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


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  HTTPSecurityRule objHTTPSecurityRule = (HTTPSecurityRule) o;
  return   Objects.equals(this.index, objHTTPSecurityRule.index)&&
  Objects.equals(this.enable, objHTTPSecurityRule.enable)&&
  Objects.equals(this.name, objHTTPSecurityRule.name)&&
  Objects.equals(this.action, objHTTPSecurityRule.action)&&
  Objects.equals(this.match, objHTTPSecurityRule.match)&&
  Objects.equals(this.log, objHTTPSecurityRule.log);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class HTTPSecurityRule {\n");
      sb.append("    action: ").append(toIndentedString(action)).append("\n");
        sb.append("    enable: ").append(toIndentedString(enable)).append("\n");
        sb.append("    index: ").append(toIndentedString(index)).append("\n");
        sb.append("    log: ").append(toIndentedString(log)).append("\n");
        sb.append("    match: ").append(toIndentedString(match)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

