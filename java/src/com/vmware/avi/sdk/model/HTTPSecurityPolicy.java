package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The HTTPSecurityPolicy is a POJO class extends AviRestResource that used for creating
 * HTTPSecurityPolicy.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HTTPSecurityPolicy  {
    @JsonProperty("rules")
    private List<HTTPSecurityRule> rules = null;


  /**
   * This is the getter method this will return the attribute value.
   * Add rules to the http security policy.
   * @return rules
   */
  public List<HTTPSecurityRule> getRules() {
    return rules;
  }

  /**
   * This is the setter method. this will set the rules
   * Add rules to the http security policy.
   * @return rules
   */
  public void setRules(List<HTTPSecurityRule>  rules) {
    this.rules = rules;
  }

  /**
   * This is the setter method this will set the rules
   * Add rules to the http security policy.
   * @return rules
   */
  public HTTPSecurityPolicy addRulesItem(HTTPSecurityRule rulesItem) {
    if (this.rules == null) {
      this.rules = new ArrayList<HTTPSecurityRule>();
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
  HTTPSecurityPolicy objHTTPSecurityPolicy = (HTTPSecurityPolicy) o;
  return   Objects.equals(this.rules, objHTTPSecurityPolicy.rules);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class HTTPSecurityPolicy {\n");
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

