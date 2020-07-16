package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The WafPolicyWhitelist is a POJO class extends AviRestResource that used for creating
 * WafPolicyWhitelist.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WafPolicyWhitelist  {
    @JsonProperty("rules")
    private List<WafPolicyWhitelistRule> rules = null;


  /**
   * This is the getter method this will return the attribute value.
   * Rules to bypass waf.
   * Field introduced in 18.2.3.
   * @return rules
   */
  public List<WafPolicyWhitelistRule> getRules() {
    return rules;
  }

  /**
   * This is the setter method. this will set the rules
   * Rules to bypass waf.
   * Field introduced in 18.2.3.
   * @return rules
   */
  public void setRules(List<WafPolicyWhitelistRule>  rules) {
    this.rules = rules;
  }

  /**
   * This is the setter method this will set the rules
   * Rules to bypass waf.
   * Field introduced in 18.2.3.
   * @return rules
   */
  public WafPolicyWhitelist addRulesItem(WafPolicyWhitelistRule rulesItem) {
    if (this.rules == null) {
      this.rules = new ArrayList<WafPolicyWhitelistRule>();
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
  WafPolicyWhitelist objWafPolicyWhitelist = (WafPolicyWhitelist) o;
  return   Objects.equals(this.rules, objWafPolicyWhitelist.rules);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class WafPolicyWhitelist {\n");
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

