package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The WafPSMRule is a POJO class extends AviRestResource that used for creating
 * WafPSMRule.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WafPSMRule  {
    @JsonProperty("description")
    private String description = null;

    @JsonProperty("enable")
    private Boolean enable = true;

    @JsonProperty("index")
    private Integer index = null;

    @JsonProperty("match_case")
    private String matchCase = "INSENSITIVE";

    @JsonProperty("match_elements")
    private List<WafPSMMatchElement> matchElements = null;

    @JsonProperty("match_value_max_length")
    private Integer matchValueMaxLength = null;

    @JsonProperty("match_value_pattern")
    private String matchValuePattern = null;

    @JsonProperty("mode")
    private String mode = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("paranoia_level")
    private String paranoiaLevel = "WAF_PARANOIA_LEVEL_LOW";

    @JsonProperty("rule_id")
    private String ruleId = null;



  /**
   * This is the getter method this will return the attribute value.
   * Free-text comment about this rule.
   * Field introduced in 18.2.3.
   * @return description
   */
  public String getDescription() {
    return description;
  }

  /**
   * This is the setter method to the attribute.
   * Free-text comment about this rule.
   * Field introduced in 18.2.3.
   * @param description set the description.
   */
  public void setDescription(String  description) {
    this.description = description;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable or disable this rule.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return enable
   */
  public Boolean getEnable() {
    return enable;
  }

  /**
   * This is the setter method to the attribute.
   * Enable or disable this rule.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param enable set the enable.
   */
  public void setEnable(Boolean  enable) {
    this.enable = enable;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Rule index, this is used to determine the order of the rules.
   * Field introduced in 18.2.3.
   * @return index
   */
  public Integer getIndex() {
    return index;
  }

  /**
   * This is the setter method to the attribute.
   * Rule index, this is used to determine the order of the rules.
   * Field introduced in 18.2.3.
   * @param index set the index.
   */
  public void setIndex(Integer  index) {
    this.index = index;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The field match_value_pattern regular expression is case sensitive.
   * Enum options - SENSITIVE, INSENSITIVE.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as INSENSITIVE.
   * @return matchCase
   */
  public String getMatchCase() {
    return matchCase;
  }

  /**
   * This is the setter method to the attribute.
   * The field match_value_pattern regular expression is case sensitive.
   * Enum options - SENSITIVE, INSENSITIVE.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as INSENSITIVE.
   * @param matchCase set the matchCase.
   */
  public void setMatchCase(String  matchCase) {
    this.matchCase = matchCase;
  }
  /**
   * This is the getter method this will return the attribute value.
   * The match elements, for example args id or args|!args password.
   * Field introduced in 18.2.3.
   * @return matchElements
   */
  public List<WafPSMMatchElement> getMatchElements() {
    return matchElements;
  }

  /**
   * This is the setter method. this will set the matchElements
   * The match elements, for example args id or args|!args password.
   * Field introduced in 18.2.3.
   * @return matchElements
   */
  public void setMatchElements(List<WafPSMMatchElement>  matchElements) {
    this.matchElements = matchElements;
  }

  /**
   * This is the setter method this will set the matchElements
   * The match elements, for example args id or args|!args password.
   * Field introduced in 18.2.3.
   * @return matchElements
   */
  public WafPSMRule addMatchElementsItem(WafPSMMatchElement matchElementsItem) {
    if (this.matchElements == null) {
      this.matchElements = new ArrayList<WafPSMMatchElement>();
    }
    this.matchElements.add(matchElementsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The maximum allowed length of the match_value.
   * If this is not set, the length will not be checked.
   * Field introduced in 18.2.3.
   * @return matchValueMaxLength
   */
  public Integer getMatchValueMaxLength() {
    return matchValueMaxLength;
  }

  /**
   * This is the setter method to the attribute.
   * The maximum allowed length of the match_value.
   * If this is not set, the length will not be checked.
   * Field introduced in 18.2.3.
   * @param matchValueMaxLength set the matchValueMaxLength.
   */
  public void setMatchValueMaxLength(Integer  matchValueMaxLength) {
    this.matchValueMaxLength = matchValueMaxLength;
  }

  /**
   * This is the getter method this will return the attribute value.
   * A regular expression which describes the expected value.
   * Field introduced in 18.2.3.
   * @return matchValuePattern
   */
  public String getMatchValuePattern() {
    return matchValuePattern;
  }

  /**
   * This is the setter method to the attribute.
   * A regular expression which describes the expected value.
   * Field introduced in 18.2.3.
   * @param matchValuePattern set the matchValuePattern.
   */
  public void setMatchValuePattern(String  matchValuePattern) {
    this.matchValuePattern = matchValuePattern;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Waf rule mode.
   * This can be detection or enforcement.
   * If this is not set, the policy mode is used.
   * This only takes effect if the policy allows delegation.
   * Enum options - WAF_MODE_DETECTION_ONLY, WAF_MODE_ENFORCEMENT.
   * Field introduced in 18.2.3.
   * @return mode
   */
  public String getMode() {
    return mode;
  }

  /**
   * This is the setter method to the attribute.
   * Waf rule mode.
   * This can be detection or enforcement.
   * If this is not set, the policy mode is used.
   * This only takes effect if the policy allows delegation.
   * Enum options - WAF_MODE_DETECTION_ONLY, WAF_MODE_ENFORCEMENT.
   * Field introduced in 18.2.3.
   * @param mode set the mode.
   */
  public void setMode(String  mode) {
    this.mode = mode;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the rule.
   * Field introduced in 18.2.3.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the rule.
   * Field introduced in 18.2.3.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Waf ruleset paranoia mode.
   * This is used to select rules based on the paranoia-level.
   * Enum options - WAF_PARANOIA_LEVEL_LOW, WAF_PARANOIA_LEVEL_MEDIUM, WAF_PARANOIA_LEVEL_HIGH, WAF_PARANOIA_LEVEL_EXTREME.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as WAF_PARANOIA_LEVEL_LOW.
   * @return paranoiaLevel
   */
  public String getParanoiaLevel() {
    return paranoiaLevel;
  }

  /**
   * This is the setter method to the attribute.
   * Waf ruleset paranoia mode.
   * This is used to select rules based on the paranoia-level.
   * Enum options - WAF_PARANOIA_LEVEL_LOW, WAF_PARANOIA_LEVEL_MEDIUM, WAF_PARANOIA_LEVEL_HIGH, WAF_PARANOIA_LEVEL_EXTREME.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as WAF_PARANOIA_LEVEL_LOW.
   * @param paranoiaLevel set the paranoiaLevel.
   */
  public void setParanoiaLevel(String  paranoiaLevel) {
    this.paranoiaLevel = paranoiaLevel;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Id field which is used for log and metric generation.
   * This id must be unique for all rules in this group.
   * Field introduced in 18.2.3.
   * @return ruleId
   */
  public String getRuleId() {
    return ruleId;
  }

  /**
   * This is the setter method to the attribute.
   * Id field which is used for log and metric generation.
   * This id must be unique for all rules in this group.
   * Field introduced in 18.2.3.
   * @param ruleId set the ruleId.
   */
  public void setRuleId(String  ruleId) {
    this.ruleId = ruleId;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  WafPSMRule objWafPSMRule = (WafPSMRule) o;
  return   Objects.equals(this.index, objWafPSMRule.index)&&
  Objects.equals(this.ruleId, objWafPSMRule.ruleId)&&
  Objects.equals(this.name, objWafPSMRule.name)&&
  Objects.equals(this.enable, objWafPSMRule.enable)&&
  Objects.equals(this.mode, objWafPSMRule.mode)&&
  Objects.equals(this.paranoiaLevel, objWafPSMRule.paranoiaLevel)&&
  Objects.equals(this.matchElements, objWafPSMRule.matchElements)&&
  Objects.equals(this.matchValueMaxLength, objWafPSMRule.matchValueMaxLength)&&
  Objects.equals(this.matchValuePattern, objWafPSMRule.matchValuePattern)&&
  Objects.equals(this.matchCase, objWafPSMRule.matchCase)&&
  Objects.equals(this.description, objWafPSMRule.description);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class WafPSMRule {\n");
      sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    enable: ").append(toIndentedString(enable)).append("\n");
        sb.append("    index: ").append(toIndentedString(index)).append("\n");
        sb.append("    matchCase: ").append(toIndentedString(matchCase)).append("\n");
        sb.append("    matchElements: ").append(toIndentedString(matchElements)).append("\n");
        sb.append("    matchValueMaxLength: ").append(toIndentedString(matchValueMaxLength)).append("\n");
        sb.append("    matchValuePattern: ").append(toIndentedString(matchValuePattern)).append("\n");
        sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    paranoiaLevel: ").append(toIndentedString(paranoiaLevel)).append("\n");
        sb.append("    ruleId: ").append(toIndentedString(ruleId)).append("\n");
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

