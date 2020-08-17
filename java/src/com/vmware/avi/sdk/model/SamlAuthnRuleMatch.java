package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SamlAuthnRuleMatch is a POJO class extends AviRestResource that used for creating
 * SamlAuthnRuleMatch.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SamlAuthnRuleMatch  {
    @JsonProperty("saml_authn_matched_rule_action")
    private String samlAuthnMatchedRuleAction = null;

    @JsonProperty("saml_authn_matched_rule_name")
    private String samlAuthnMatchedRuleName = null;



  /**
   * This is the getter method this will return the attribute value.
   * Name of the executed saml authentication rule action.
   * Enum options - SKIP_AUTHENTICATION, USE_DEFAULT_AUTHENTICATION.
   * Field introduced in 20.1.1.
   * @return samlAuthnMatchedRuleAction
   */
  public String getSamlAuthnMatchedRuleAction() {
    return samlAuthnMatchedRuleAction;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the executed saml authentication rule action.
   * Enum options - SKIP_AUTHENTICATION, USE_DEFAULT_AUTHENTICATION.
   * Field introduced in 20.1.1.
   * @param samlAuthnMatchedRuleAction set the samlAuthnMatchedRuleAction.
   */
  public void setSamlAuthnMatchedRuleAction(String  samlAuthnMatchedRuleAction) {
    this.samlAuthnMatchedRuleAction = samlAuthnMatchedRuleAction;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the matched saml authentication rule.
   * Field introduced in 20.1.1.
   * @return samlAuthnMatchedRuleName
   */
  public String getSamlAuthnMatchedRuleName() {
    return samlAuthnMatchedRuleName;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the matched saml authentication rule.
   * Field introduced in 20.1.1.
   * @param samlAuthnMatchedRuleName set the samlAuthnMatchedRuleName.
   */
  public void setSamlAuthnMatchedRuleName(String  samlAuthnMatchedRuleName) {
    this.samlAuthnMatchedRuleName = samlAuthnMatchedRuleName;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SamlAuthnRuleMatch objSamlAuthnRuleMatch = (SamlAuthnRuleMatch) o;
  return   Objects.equals(this.samlAuthnMatchedRuleName, objSamlAuthnRuleMatch.samlAuthnMatchedRuleName)&&
  Objects.equals(this.samlAuthnMatchedRuleAction, objSamlAuthnRuleMatch.samlAuthnMatchedRuleAction);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SamlAuthnRuleMatch {\n");
      sb.append("    samlAuthnMatchedRuleAction: ").append(toIndentedString(samlAuthnMatchedRuleAction)).append("\n");
        sb.append("    samlAuthnMatchedRuleName: ").append(toIndentedString(samlAuthnMatchedRuleName)).append("\n");
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

