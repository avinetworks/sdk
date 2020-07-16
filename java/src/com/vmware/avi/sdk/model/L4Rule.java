package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The L4Rule is a POJO class extends AviRestResource that used for creating
 * L4Rule.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class L4Rule  {
    @JsonProperty("action")
    private L4RuleAction action = null;

    @JsonProperty("enable")
    private Boolean enable = true;

    @JsonProperty("index")
    private Integer index = null;

    @JsonProperty("match")
    private L4RuleMatchTarget match = null;

    @JsonProperty("name")
    private String name = null;



  /**
   * This is the getter method this will return the attribute value.
   * Action to be performed upon successful rule match.
   * Field introduced in 17.2.7.
   * @return action
   */
  public L4RuleAction getAction() {
    return action;
  }

  /**
   * This is the setter method to the attribute.
   * Action to be performed upon successful rule match.
   * Field introduced in 17.2.7.
   * @param action set the action.
   */
  public void setAction(L4RuleAction action) {
    this.action = action;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable or disable the rule.
   * Field introduced in 17.2.7.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return enable
   */
  public Boolean getEnable() {
    return enable;
  }

  /**
   * This is the setter method to the attribute.
   * Enable or disable the rule.
   * Field introduced in 17.2.7.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param enable set the enable.
   */
  public void setEnable(Boolean  enable) {
    this.enable = enable;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Index of the rule.
   * Field introduced in 17.2.7.
   * @return index
   */
  public Integer getIndex() {
    return index;
  }

  /**
   * This is the setter method to the attribute.
   * Index of the rule.
   * Field introduced in 17.2.7.
   * @param index set the index.
   */
  public void setIndex(Integer  index) {
    this.index = index;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Match criteria of the rule.
   * Field introduced in 17.2.7.
   * @return match
   */
  public L4RuleMatchTarget getMatch() {
    return match;
  }

  /**
   * This is the setter method to the attribute.
   * Match criteria of the rule.
   * Field introduced in 17.2.7.
   * @param match set the match.
   */
  public void setMatch(L4RuleMatchTarget match) {
    this.match = match;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the rule.
   * Field introduced in 17.2.7.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the rule.
   * Field introduced in 17.2.7.
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
  L4Rule objL4Rule = (L4Rule) o;
  return   Objects.equals(this.action, objL4Rule.action)&&
  Objects.equals(this.index, objL4Rule.index)&&
  Objects.equals(this.enable, objL4Rule.enable)&&
  Objects.equals(this.name, objL4Rule.name)&&
  Objects.equals(this.match, objL4Rule.match);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class L4Rule {\n");
      sb.append("    action: ").append(toIndentedString(action)).append("\n");
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

