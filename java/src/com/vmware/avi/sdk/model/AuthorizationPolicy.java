package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The AuthorizationPolicy is a POJO class extends AviRestResource that used for creating
 * AuthorizationPolicy.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthorizationPolicy  {
    @JsonProperty("authz_rules")
    private List<AuthorizationRule> authzRules = null;


  /**
   * This is the getter method this will return the attribute value.
   * Authorization policy rules.
   * Field introduced in 18.2.5.
   * @return authzRules
   */
  public List<AuthorizationRule> getAuthzRules() {
    return authzRules;
  }

  /**
   * This is the setter method. this will set the authzRules
   * Authorization policy rules.
   * Field introduced in 18.2.5.
   * @return authzRules
   */
  public void setAuthzRules(List<AuthorizationRule>  authzRules) {
    this.authzRules = authzRules;
  }

  /**
   * This is the setter method this will set the authzRules
   * Authorization policy rules.
   * Field introduced in 18.2.5.
   * @return authzRules
   */
  public AuthorizationPolicy addAuthzRulesItem(AuthorizationRule authzRulesItem) {
    if (this.authzRules == null) {
      this.authzRules = new ArrayList<AuthorizationRule>();
    }
    this.authzRules.add(authzRulesItem);
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
  AuthorizationPolicy objAuthorizationPolicy = (AuthorizationPolicy) o;
  return   Objects.equals(this.authzRules, objAuthorizationPolicy.authzRules);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class AuthorizationPolicy {\n");
      sb.append("    authzRules: ").append(toIndentedString(authzRules)).append("\n");
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

