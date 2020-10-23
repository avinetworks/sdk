package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The HTTPRequestPolicy is a POJO class extends AviRestResource that used for creating
 * HTTPRequestPolicy.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HTTPRequestPolicy  {
    @JsonProperty("rules")
    private List<HTTPRequestRule> rules = null;


    /**
     * This is the getter method this will return the attribute value.
     * Add rules to the http request policy.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return rules
     */
    public List<HTTPRequestRule> getRules() {
        return rules;
    }

    /**
     * This is the setter method. this will set the rules
     * Add rules to the http request policy.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return rules
     */
    public void setRules(List<HTTPRequestRule>  rules) {
        this.rules = rules;
    }

    /**
     * This is the setter method this will set the rules
     * Add rules to the http request policy.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return rules
     */
    public HTTPRequestPolicy addRulesItem(HTTPRequestRule rulesItem) {
      if (this.rules == null) {
        this.rules = new ArrayList<HTTPRequestRule>();
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
      HTTPRequestPolicy objHTTPRequestPolicy = (HTTPRequestPolicy) o;
      return   Objects.equals(this.rules, objHTTPRequestPolicy.rules);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class HTTPRequestPolicy {\n");
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
