package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SamlAuthzRuleMatch is a POJO class extends AviRestResource that used for creating
 * SamlAuthzRuleMatch.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SamlAuthzRuleMatch  {
    @JsonProperty("saml_authz_matched_rule_action")
    private String samlAuthzMatchedRuleAction = null;

    @JsonProperty("saml_authz_matched_rule_name")
    private String samlAuthzMatchedRuleName = null;



  /**
   * This is the getter method this will return the attribute value.
   * Name of the executed saml authorization rule action.
   * Enum options - ALLOW_ACCESS, CLOSE_CONNECTION, HTTP_LOCAL_RESPONSE.
   * Field introduced in 20.1.1.
   * @return samlAuthzMatchedRuleAction
   */
  public String getSamlAuthzMatchedRuleAction() {
    return samlAuthzMatchedRuleAction;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the executed saml authorization rule action.
   * Enum options - ALLOW_ACCESS, CLOSE_CONNECTION, HTTP_LOCAL_RESPONSE.
   * Field introduced in 20.1.1.
   * @param samlAuthzMatchedRuleAction set the samlAuthzMatchedRuleAction.
   */
  public void setSamlAuthzMatchedRuleAction(String  samlAuthzMatchedRuleAction) {
    this.samlAuthzMatchedRuleAction = samlAuthzMatchedRuleAction;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the matched saml authorization rule.
   * Field introduced in 20.1.1.
   * @return samlAuthzMatchedRuleName
   */
  public String getSamlAuthzMatchedRuleName() {
    return samlAuthzMatchedRuleName;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the matched saml authorization rule.
   * Field introduced in 20.1.1.
   * @param samlAuthzMatchedRuleName set the samlAuthzMatchedRuleName.
   */
  public void setSamlAuthzMatchedRuleName(String  samlAuthzMatchedRuleName) {
    this.samlAuthzMatchedRuleName = samlAuthzMatchedRuleName;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SamlAuthzRuleMatch objSamlAuthzRuleMatch = (SamlAuthzRuleMatch) o;
  return   Objects.equals(this.samlAuthzMatchedRuleAction, objSamlAuthzRuleMatch.samlAuthzMatchedRuleAction)&&
  Objects.equals(this.samlAuthzMatchedRuleName, objSamlAuthzRuleMatch.samlAuthzMatchedRuleName);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SamlAuthzRuleMatch {\n");
      sb.append("    samlAuthzMatchedRuleAction: ").append(toIndentedString(samlAuthzMatchedRuleAction)).append("\n");
        sb.append("    samlAuthzMatchedRuleName: ").append(toIndentedString(samlAuthzMatchedRuleName)).append("\n");
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

