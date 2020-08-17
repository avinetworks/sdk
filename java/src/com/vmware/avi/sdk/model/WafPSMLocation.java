package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The WafPSMLocation is a POJO class extends AviRestResource that used for creating
 * WafPSMLocation.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WafPSMLocation  {
    @JsonProperty("description")
    private String description = null;

    @JsonProperty("index")
    private Integer index = null;

    @JsonProperty("match")
    private WafPSMLocationMatch match = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("rules")
    private List<WafPSMRule> rules = null;



  /**
   * This is the getter method this will return the attribute value.
   * Free-text comment about this location.
   * Field introduced in 18.2.3.
   * @return description
   */
  public String getDescription() {
    return description;
  }

  /**
   * This is the setter method to the attribute.
   * Free-text comment about this location.
   * Field introduced in 18.2.3.
   * @param description set the description.
   */
  public void setDescription(String  description) {
    this.description = description;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Location index, this is used to determine the order of the locations.
   * Field introduced in 18.2.3.
   * @return index
   */
  public Integer getIndex() {
    return index;
  }

  /**
   * This is the setter method to the attribute.
   * Location index, this is used to determine the order of the locations.
   * Field introduced in 18.2.3.
   * @param index set the index.
   */
  public void setIndex(Integer  index) {
    this.index = index;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Apply these rules only if the request is matching this description.
   * Field introduced in 18.2.3.
   * @return match
   */
  public WafPSMLocationMatch getMatch() {
    return match;
  }

  /**
   * This is the setter method to the attribute.
   * Apply these rules only if the request is matching this description.
   * Field introduced in 18.2.3.
   * @param match set the match.
   */
  public void setMatch(WafPSMLocationMatch match) {
    this.match = match;
  }

  /**
   * This is the getter method this will return the attribute value.
   * User defined name for this location, it must be unique in the group.
   * Field introduced in 18.2.3.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * User defined name for this location, it must be unique in the group.
   * Field introduced in 18.2.3.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }
  /**
   * This is the getter method this will return the attribute value.
   * A list of rules which should be applied on this location.
   * Field introduced in 18.2.3.
   * @return rules
   */
  public List<WafPSMRule> getRules() {
    return rules;
  }

  /**
   * This is the setter method. this will set the rules
   * A list of rules which should be applied on this location.
   * Field introduced in 18.2.3.
   * @return rules
   */
  public void setRules(List<WafPSMRule>  rules) {
    this.rules = rules;
  }

  /**
   * This is the setter method this will set the rules
   * A list of rules which should be applied on this location.
   * Field introduced in 18.2.3.
   * @return rules
   */
  public WafPSMLocation addRulesItem(WafPSMRule rulesItem) {
    if (this.rules == null) {
      this.rules = new ArrayList<WafPSMRule>();
    }
    this.rules.add(rulesItem);
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
  WafPSMLocation objWafPSMLocation = (WafPSMLocation) o;
  return   Objects.equals(this.index, objWafPSMLocation.index)&&
  Objects.equals(this.name, objWafPSMLocation.name)&&
  Objects.equals(this.match, objWafPSMLocation.match)&&
  Objects.equals(this.rules, objWafPSMLocation.rules)&&
  Objects.equals(this.description, objWafPSMLocation.description);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class WafPSMLocation {\n");
      sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    index: ").append(toIndentedString(index)).append("\n");
        sb.append("    match: ").append(toIndentedString(match)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    rules: ").append(toIndentedString(rules)).append("\n");
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

