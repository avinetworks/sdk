package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SensitiveFieldRule is a POJO class extends AviRestResource that used for creating
 * SensitiveFieldRule.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SensitiveFieldRule  {
    @JsonProperty("action")
    private String action = "LOG_FIELD_REMOVE";

    @JsonProperty("enabled")
    private Boolean enabled = false;

    @JsonProperty("index")
    private Integer index = null;

    @JsonProperty("match")
    private StringMatch match = null;

    @JsonProperty("name")
    private String name = null;



  /**
   * This is the getter method this will return the attribute value.
   * Action for the matched log field, for instance the matched field can be removed or masked off.
   * Enum options - LOG_FIELD_REMOVE, LOG_FIELD_MASKOFF.
   * Field introduced in 17.2.10, 18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as LOG_FIELD_REMOVE.
   * @return action
   */
  public String getAction() {
    return action;
  }

  /**
   * This is the setter method to the attribute.
   * Action for the matched log field, for instance the matched field can be removed or masked off.
   * Enum options - LOG_FIELD_REMOVE, LOG_FIELD_MASKOFF.
   * Field introduced in 17.2.10, 18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as LOG_FIELD_REMOVE.
   * @param action set the action.
   */
  public void setAction(String  action) {
    this.action = action;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable rule to match the sensitive fields.
   * Field introduced in 17.2.10, 18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return enabled
   */
  public Boolean getEnabled() {
    return enabled;
  }

  /**
   * This is the setter method to the attribute.
   * Enable rule to match the sensitive fields.
   * Field introduced in 17.2.10, 18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param enabled set the enabled.
   */
  public void setEnabled(Boolean  enabled) {
    this.enabled = enabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Index of the rule.
   * Field introduced in 17.2.10, 18.1.2.
   * @return index
   */
  public Integer getIndex() {
    return index;
  }

  /**
   * This is the setter method to the attribute.
   * Index of the rule.
   * Field introduced in 17.2.10, 18.1.2.
   * @param index set the index.
   */
  public void setIndex(Integer  index) {
    this.index = index;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Criterion to use for matching in the log.
   * Field introduced in 17.2.10, 18.1.2.
   * @return match
   */
  public StringMatch getMatch() {
    return match;
  }

  /**
   * This is the setter method to the attribute.
   * Criterion to use for matching in the log.
   * Field introduced in 17.2.10, 18.1.2.
   * @param match set the match.
   */
  public void setMatch(StringMatch match) {
    this.match = match;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the rule.
   * Field introduced in 17.2.10, 18.1.2.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the rule.
   * Field introduced in 17.2.10, 18.1.2.
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
  SensitiveFieldRule objSensitiveFieldRule = (SensitiveFieldRule) o;
  return   Objects.equals(this.name, objSensitiveFieldRule.name)&&
  Objects.equals(this.index, objSensitiveFieldRule.index)&&
  Objects.equals(this.enabled, objSensitiveFieldRule.enabled)&&
  Objects.equals(this.match, objSensitiveFieldRule.match)&&
  Objects.equals(this.action, objSensitiveFieldRule.action);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SensitiveFieldRule {\n");
      sb.append("    action: ").append(toIndentedString(action)).append("\n");
        sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
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

