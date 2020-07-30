package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The WafRuleMatchData is a POJO class extends AviRestResource that used for creating
 * WafRuleMatchData.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WafRuleMatchData  {
    @JsonProperty("is_internal")
    private Boolean isInternal = false;

    @JsonProperty("match_element")
    private String matchElement = null;

    @JsonProperty("match_value")
    private String matchValue = null;



  /**
   * This is the getter method this will return the attribute value.
   * The match_element is an internal variable.
   * It is not possible to add exclusions for this element.
   * Field introduced in 17.2.4.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return isInternal
   */
  public Boolean getIsInternal() {
    return isInternal;
  }

  /**
   * This is the setter method to the attribute.
   * The match_element is an internal variable.
   * It is not possible to add exclusions for this element.
   * Field introduced in 17.2.4.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param isInternal set the isInternal.
   */
  public void setIsInternal(Boolean  isInternal) {
    this.isInternal = isInternal;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field from a transaction that matches the rule, for instance if the request parameter is password=foobar, then match_element is args password.
   * Field introduced in 17.2.1.
   * @return matchElement
   */
  public String getMatchElement() {
    return matchElement;
  }

  /**
   * This is the setter method to the attribute.
   * Field from a transaction that matches the rule, for instance if the request parameter is password=foobar, then match_element is args password.
   * Field introduced in 17.2.1.
   * @param matchElement set the matchElement.
   */
  public void setMatchElement(String  matchElement) {
    this.matchElement = matchElement;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Value for a field from a transaction that matches the rule, for instance if the request parameter is password=foobar, then match_value is foobar.
   * Field introduced in 17.2.1.
   * @return matchValue
   */
  public String getMatchValue() {
    return matchValue;
  }

  /**
   * This is the setter method to the attribute.
   * Value for a field from a transaction that matches the rule, for instance if the request parameter is password=foobar, then match_value is foobar.
   * Field introduced in 17.2.1.
   * @param matchValue set the matchValue.
   */
  public void setMatchValue(String  matchValue) {
    this.matchValue = matchValue;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  WafRuleMatchData objWafRuleMatchData = (WafRuleMatchData) o;
  return   Objects.equals(this.matchElement, objWafRuleMatchData.matchElement)&&
  Objects.equals(this.matchValue, objWafRuleMatchData.matchValue)&&
  Objects.equals(this.isInternal, objWafRuleMatchData.isInternal);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class WafRuleMatchData {\n");
      sb.append("    isInternal: ").append(toIndentedString(isInternal)).append("\n");
        sb.append("    matchElement: ").append(toIndentedString(matchElement)).append("\n");
        sb.append("    matchValue: ").append(toIndentedString(matchValue)).append("\n");
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

