package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The L4ConnectionPolicy is a POJO class extends AviRestResource that used for creating
 * L4ConnectionPolicy.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class L4ConnectionPolicy  {
    @JsonProperty("rules")
    private List<L4Rule> rules = null;


  /**
   * This is the getter method this will return the attribute value.
   * Rules to apply when a new transport connection is setup.
   * Field introduced in 17.2.7.
   * @return rules
   */
  public List<L4Rule> getRules() {
    return rules;
  }

  /**
   * This is the setter method. this will set the rules
   * Rules to apply when a new transport connection is setup.
   * Field introduced in 17.2.7.
   * @return rules
   */
  public void setRules(List<L4Rule>  rules) {
    this.rules = rules;
  }

  /**
   * This is the setter method this will set the rules
   * Rules to apply when a new transport connection is setup.
   * Field introduced in 17.2.7.
   * @return rules
   */
  public L4ConnectionPolicy addRulesItem(L4Rule rulesItem) {
    if (this.rules == null) {
      this.rules = new ArrayList<L4Rule>();
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
  L4ConnectionPolicy objL4ConnectionPolicy = (L4ConnectionPolicy) o;
  return   Objects.equals(this.rules, objL4ConnectionPolicy.rules);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class L4ConnectionPolicy {\n");
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

