package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The WafPolicyAllowlist is a POJO class extends AviRestResource that used for creating
 * WafPolicyAllowlist.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WafPolicyAllowlist  {
    @JsonProperty("rules")
    private List<WafPolicyAllowlistRule> rules = null;


    /**
     * This is the getter method this will return the attribute value.
     * Rules to bypass waf.
     * Field introduced in 20.1.3.
     * Maximum of 1024 items allowed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return rules
     */
    public List<WafPolicyAllowlistRule> getRules() {
        return rules;
    }

    /**
     * This is the setter method. this will set the rules
     * Rules to bypass waf.
     * Field introduced in 20.1.3.
     * Maximum of 1024 items allowed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return rules
     */
    public void setRules(List<WafPolicyAllowlistRule>  rules) {
        this.rules = rules;
    }

    /**
     * This is the setter method this will set the rules
     * Rules to bypass waf.
     * Field introduced in 20.1.3.
     * Maximum of 1024 items allowed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return rules
     */
    public WafPolicyAllowlist addRulesItem(WafPolicyAllowlistRule rulesItem) {
      if (this.rules == null) {
        this.rules = new ArrayList<WafPolicyAllowlistRule>();
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
      WafPolicyAllowlist objWafPolicyAllowlist = (WafPolicyAllowlist) o;
      return   Objects.equals(this.rules, objWafPolicyAllowlist.rules);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class WafPolicyAllowlist {\n");
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
