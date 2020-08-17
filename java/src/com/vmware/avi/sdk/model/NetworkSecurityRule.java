package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The NetworkSecurityRule is a POJO class extends AviRestResource that used for creating
 * NetworkSecurityRule.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NetworkSecurityRule  {
    @JsonProperty("action")
    private String action = null;

    @JsonProperty("age")
    private Integer age = 0;

    @JsonProperty("created_by")
    private String createdBy = null;

    @JsonProperty("enable")
    private Boolean enable = null;

    @JsonProperty("index")
    private Integer index = null;

    @JsonProperty("log")
    private Boolean log = false;

    @JsonProperty("match")
    private NetworkSecurityMatchTarget match = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("rl_param")
    private NetworkSecurityPolicyActionRLParam rlParam = null;



  /**
   * This is the getter method this will return the attribute value.
   * Enum options - NETWORK_SECURITY_POLICY_ACTION_TYPE_ALLOW, NETWORK_SECURITY_POLICY_ACTION_TYPE_DENY,
   * NETWORK_SECURITY_POLICY_ACTION_TYPE_RATE_LIMIT.
   * @return action
   */
  public String getAction() {
    return action;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - NETWORK_SECURITY_POLICY_ACTION_TYPE_ALLOW, NETWORK_SECURITY_POLICY_ACTION_TYPE_DENY,
   * NETWORK_SECURITY_POLICY_ACTION_TYPE_RATE_LIMIT.
   * @param action set the action.
   */
  public void setAction(String  action) {
    this.action = action;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Time in minutes after which rule will be deleted.
   * Allowed values are 1-4294967295.
   * Special values are 0- 'blocked for ever'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return age
   */
  public Integer getAge() {
    return age;
  }

  /**
   * This is the setter method to the attribute.
   * Time in minutes after which rule will be deleted.
   * Allowed values are 1-4294967295.
   * Special values are 0- 'blocked for ever'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param age set the age.
   */
  public void setAge(Integer  age) {
    this.age = age;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Creator name.
   * @return createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * This is the setter method to the attribute.
   * Creator name.
   * @param createdBy set the createdBy.
   */
  public void setCreatedBy(String  createdBy) {
    this.createdBy = createdBy;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property enable of obj type networksecurityrule field type str  type boolean.
   * @return enable
   */
  public Boolean getEnable() {
    return enable;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property enable of obj type networksecurityrule field type str  type boolean.
   * @param enable set the enable.
   */
  public void setEnable(Boolean  enable) {
    this.enable = enable;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property index of obj type networksecurityrule field type str  type integer.
   * @return index
   */
  public Integer getIndex() {
    return index;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property index of obj type networksecurityrule field type str  type integer.
   * @param index set the index.
   */
  public void setIndex(Integer  index) {
    this.index = index;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property log of obj type networksecurityrule field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return log
   */
  public Boolean getLog() {
    return log;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property log of obj type networksecurityrule field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param log set the log.
   */
  public void setLog(Boolean  log) {
    this.log = log;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property match of obj type networksecurityrule field type str  type ref.
   * @return match
   */
  public NetworkSecurityMatchTarget getMatch() {
    return match;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property match of obj type networksecurityrule field type str  type ref.
   * @param match set the match.
   */
  public void setMatch(NetworkSecurityMatchTarget match) {
    this.match = match;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the object.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the object.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property rl_param of obj type networksecurityrule field type str  type ref.
   * @return rlParam
   */
  public NetworkSecurityPolicyActionRLParam getRlParam() {
    return rlParam;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property rl_param of obj type networksecurityrule field type str  type ref.
   * @param rlParam set the rlParam.
   */
  public void setRlParam(NetworkSecurityPolicyActionRLParam rlParam) {
    this.rlParam = rlParam;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  NetworkSecurityRule objNetworkSecurityRule = (NetworkSecurityRule) o;
  return   Objects.equals(this.name, objNetworkSecurityRule.name)&&
  Objects.equals(this.index, objNetworkSecurityRule.index)&&
  Objects.equals(this.enable, objNetworkSecurityRule.enable)&&
  Objects.equals(this.match, objNetworkSecurityRule.match)&&
  Objects.equals(this.action, objNetworkSecurityRule.action)&&
  Objects.equals(this.log, objNetworkSecurityRule.log)&&
  Objects.equals(this.rlParam, objNetworkSecurityRule.rlParam)&&
  Objects.equals(this.age, objNetworkSecurityRule.age)&&
  Objects.equals(this.createdBy, objNetworkSecurityRule.createdBy);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class NetworkSecurityRule {\n");
      sb.append("    action: ").append(toIndentedString(action)).append("\n");
        sb.append("    age: ").append(toIndentedString(age)).append("\n");
        sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
        sb.append("    enable: ").append(toIndentedString(enable)).append("\n");
        sb.append("    index: ").append(toIndentedString(index)).append("\n");
        sb.append("    log: ").append(toIndentedString(log)).append("\n");
        sb.append("    match: ").append(toIndentedString(match)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    rlParam: ").append(toIndentedString(rlParam)).append("\n");
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

