package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The NatRule is a POJO class extends AviRestResource that used for creating
 * NatRule.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NatRule  {
    @JsonProperty("action")
    private NatPolicyAction action = null;

    @JsonProperty("created_by")
    private String createdBy = null;

    @JsonProperty("enable")
    private Boolean enable = null;

    @JsonProperty("index")
    private Integer index = null;

    @JsonProperty("match")
    private NatMatchTarget match = null;

    @JsonProperty("name")
    private String name = null;



  /**
   * This is the getter method this will return the attribute value.
   * Nat rule action information.
   * Field introduced in 18.2.3.
   * @return action
   */
  public NatPolicyAction getAction() {
    return action;
  }

  /**
   * This is the setter method to the attribute.
   * Nat rule action information.
   * Field introduced in 18.2.3.
   * @param action set the action.
   */
  public void setAction(NatPolicyAction action) {
    this.action = action;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Creator name.
   * Field introduced in 18.2.3.
   * @return createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * This is the setter method to the attribute.
   * Creator name.
   * Field introduced in 18.2.3.
   * @param createdBy set the createdBy.
   */
  public void setCreatedBy(String  createdBy) {
    this.createdBy = createdBy;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Nat rule enable flag.
   * Field introduced in 18.2.3.
   * @return enable
   */
  public Boolean getEnable() {
    return enable;
  }

  /**
   * This is the setter method to the attribute.
   * Nat rule enable flag.
   * Field introduced in 18.2.3.
   * @param enable set the enable.
   */
  public void setEnable(Boolean  enable) {
    this.enable = enable;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Nat rule index.
   * Field introduced in 18.2.3.
   * @return index
   */
  public Integer getIndex() {
    return index;
  }

  /**
   * This is the setter method to the attribute.
   * Nat rule index.
   * Field introduced in 18.2.3.
   * @param index set the index.
   */
  public void setIndex(Integer  index) {
    this.index = index;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Nat rule match criteria.
   * Field introduced in 18.2.3.
   * @return match
   */
  public NatMatchTarget getMatch() {
    return match;
  }

  /**
   * This is the setter method to the attribute.
   * Nat rule match criteria.
   * Field introduced in 18.2.3.
   * @param match set the match.
   */
  public void setMatch(NatMatchTarget match) {
    this.match = match;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Nat rule name.
   * Field introduced in 18.2.3.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Nat rule name.
   * Field introduced in 18.2.3.
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
  NatRule objNatRule = (NatRule) o;
  return   Objects.equals(this.name, objNatRule.name)&&
  Objects.equals(this.index, objNatRule.index)&&
  Objects.equals(this.enable, objNatRule.enable)&&
  Objects.equals(this.match, objNatRule.match)&&
  Objects.equals(this.action, objNatRule.action)&&
  Objects.equals(this.createdBy, objNatRule.createdBy);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class NatRule {\n");
      sb.append("    action: ").append(toIndentedString(action)).append("\n");
        sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
        sb.append("    enable: ").append(toIndentedString(enable)).append("\n");
        sb.append("    index: ").append(toIndentedString(index)).append("\n");
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

