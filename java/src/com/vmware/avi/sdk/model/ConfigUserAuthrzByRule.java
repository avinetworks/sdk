package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The ConfigUserAuthrzByRule is a POJO class extends AviRestResource that used for creating
 * ConfigUserAuthrzByRule.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConfigUserAuthrzByRule  {
    @JsonProperty("policies")
    private String policies = null;

    @JsonProperty("roles")
    private String roles = null;

    @JsonProperty("rule")
    private String rule = null;

    @JsonProperty("tenants")
    private String tenants = null;

    @JsonProperty("user")
    private String user = null;

    @JsonProperty("userprofile")
    private String userprofile = null;



    /**
     * This is the getter method this will return the attribute value.
     * Comma separated list of policies assigned to the user.
     * Field introduced in 18.2.7, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return policies
     */
    public String getPolicies() {
        return policies;
    }

    /**
     * This is the setter method to the attribute.
     * Comma separated list of policies assigned to the user.
     * Field introduced in 18.2.7, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param policies set the policies.
     */
    public void setPolicies(String  policies) {
        this.policies = policies;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Assigned roles.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return roles
     */
    public String getRoles() {
        return roles;
    }

    /**
     * This is the setter method to the attribute.
     * Assigned roles.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param roles set the roles.
     */
    public void setRoles(String  roles) {
        this.roles = roles;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Matching rule string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return rule
     */
    public String getRule() {
        return rule;
    }

    /**
     * This is the setter method to the attribute.
     * Matching rule string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param rule set the rule.
     */
    public void setRule(String  rule) {
        this.rule = rule;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Assigned tenants.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return tenants
     */
    public String getTenants() {
        return tenants;
    }

    /**
     * This is the setter method to the attribute.
     * Assigned tenants.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param tenants set the tenants.
     */
    public void setTenants(String  tenants) {
        this.tenants = tenants;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Request user.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return user
     */
    public String getUser() {
        return user;
    }

    /**
     * This is the setter method to the attribute.
     * Request user.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param user set the user.
     */
    public void setUser(String  user) {
        this.user = user;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Assigned user account profile name.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return userprofile
     */
    public String getUserprofile() {
        return userprofile;
    }

    /**
     * This is the setter method to the attribute.
     * Assigned user account profile name.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param userprofile set the userprofile.
     */
    public void setUserprofile(String  userprofile) {
        this.userprofile = userprofile;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      ConfigUserAuthrzByRule objConfigUserAuthrzByRule = (ConfigUserAuthrzByRule) o;
      return   Objects.equals(this.user, objConfigUserAuthrzByRule.user)&&
  Objects.equals(this.rule, objConfigUserAuthrzByRule.rule)&&
  Objects.equals(this.roles, objConfigUserAuthrzByRule.roles)&&
  Objects.equals(this.tenants, objConfigUserAuthrzByRule.tenants)&&
  Objects.equals(this.policies, objConfigUserAuthrzByRule.policies)&&
  Objects.equals(this.userprofile, objConfigUserAuthrzByRule.userprofile);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ConfigUserAuthrzByRule {\n");
                  sb.append("    policies: ").append(toIndentedString(policies)).append("\n");
                        sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
                        sb.append("    rule: ").append(toIndentedString(rule)).append("\n");
                        sb.append("    tenants: ").append(toIndentedString(tenants)).append("\n");
                        sb.append("    user: ").append(toIndentedString(user)).append("\n");
                        sb.append("    userprofile: ").append(toIndentedString(userprofile)).append("\n");
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
