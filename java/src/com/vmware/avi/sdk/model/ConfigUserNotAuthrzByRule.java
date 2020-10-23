package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The ConfigUserNotAuthrzByRule is a POJO class extends AviRestResource that used for creating
 * ConfigUserNotAuthrzByRule.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConfigUserNotAuthrzByRule  {
    @JsonProperty("policies")
    private String policies = "No Policies";

    @JsonProperty("roles")
    private String roles = "No Roles";

    @JsonProperty("tenants")
    private String tenants = "No Tenants";

    @JsonProperty("user")
    private String user = null;



    /**
     * This is the getter method this will return the attribute value.
     * Comma separated list of policies assigned to the user.
     * Field introduced in 18.2.7, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as "No Policies".
     * @return policies
     */
    public String getPolicies() {
        return policies;
    }

    /**
     * This is the setter method to the attribute.
     * Comma separated list of policies assigned to the user.
     * Field introduced in 18.2.7, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as "No Policies".
     * @param policies set the policies.
     */
    public void setPolicies(String  policies) {
        this.policies = policies;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Assigned roles.
     * Default value when not specified in API or module is interpreted by Avi Controller as "No Roles".
     * @return roles
     */
    public String getRoles() {
        return roles;
    }

    /**
     * This is the setter method to the attribute.
     * Assigned roles.
     * Default value when not specified in API or module is interpreted by Avi Controller as "No Roles".
     * @param roles set the roles.
     */
    public void setRoles(String  roles) {
        this.roles = roles;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Assigned tenants.
     * Default value when not specified in API or module is interpreted by Avi Controller as "No Tenants".
     * @return tenants
     */
    public String getTenants() {
        return tenants;
    }

    /**
     * This is the setter method to the attribute.
     * Assigned tenants.
     * Default value when not specified in API or module is interpreted by Avi Controller as "No Tenants".
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


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      ConfigUserNotAuthrzByRule objConfigUserNotAuthrzByRule = (ConfigUserNotAuthrzByRule) o;
      return   Objects.equals(this.user, objConfigUserNotAuthrzByRule.user)&&
  Objects.equals(this.roles, objConfigUserNotAuthrzByRule.roles)&&
  Objects.equals(this.tenants, objConfigUserNotAuthrzByRule.tenants)&&
  Objects.equals(this.policies, objConfigUserNotAuthrzByRule.policies);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ConfigUserNotAuthrzByRule {\n");
                  sb.append("    policies: ").append(toIndentedString(policies)).append("\n");
                        sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
                        sb.append("    tenants: ").append(toIndentedString(tenants)).append("\n");
                        sb.append("    user: ").append(toIndentedString(user)).append("\n");
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
