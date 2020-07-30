package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The WafRule is a POJO class extends AviRestResource that used for creating
 * WafRule.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WafRule  {
    @JsonProperty("enable")
    private Boolean enable = true;

    @JsonProperty("exclude_list")
    private List<WafExcludeListEntry> excludeList = null;

    @JsonProperty("force_detection")
    private Boolean forceDetection = null;

    @JsonProperty("index")
    private Integer index = null;

    @JsonProperty("is_sensitive")
    private Boolean isSensitive = false;

    @JsonProperty("mode")
    private String mode = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("phase")
    private String phase = null;

    @JsonProperty("rule")
    private String rule = null;

    @JsonProperty("rule_id")
    private String ruleId = null;

    @JsonProperty("tags")
    private List<String> tags = null;



  /**
   * This is the getter method this will return the attribute value.
   * Enable or disable waf rule group.
   * Field introduced in 17.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return enable
   */
  public Boolean getEnable() {
    return enable;
  }

  /**
   * This is the setter method to the attribute.
   * Enable or disable waf rule group.
   * Field introduced in 17.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param enable set the enable.
   */
  public void setEnable(Boolean  enable) {
    this.enable = enable;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Exclude list for the waf rule.
   * The fields in the exclude list entry are logically and'ed to deduce the exclusion criteria.
   * If there are multiple excludelist entries, it will be 'logical or' of them.
   * Field introduced in 17.2.3.
   * @return excludeList
   */
  public List<WafExcludeListEntry> getExcludeList() {
    return excludeList;
  }

  /**
   * This is the setter method. this will set the excludeList
   * Exclude list for the waf rule.
   * The fields in the exclude list entry are logically and'ed to deduce the exclusion criteria.
   * If there are multiple excludelist entries, it will be 'logical or' of them.
   * Field introduced in 17.2.3.
   * @return excludeList
   */
  public void setExcludeList(List<WafExcludeListEntry>  excludeList) {
    this.excludeList = excludeList;
  }

  /**
   * This is the setter method this will set the excludeList
   * Exclude list for the waf rule.
   * The fields in the exclude list entry are logically and'ed to deduce the exclusion criteria.
   * If there are multiple excludelist entries, it will be 'logical or' of them.
   * Field introduced in 17.2.3.
   * @return excludeList
   */
  public WafRule addExcludeListItem(WafExcludeListEntry excludeListItem) {
    if (this.excludeList == null) {
      this.excludeList = new ArrayList<WafExcludeListEntry>();
    }
    this.excludeList.add(excludeListItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * When set to 'true', this rule will not cause 'deny' or 'redirect' actions to run, even if waf policy is set to enforcement mode.
   * The behavior would be as if this rule operated in detection mode regardless of waf policy setting.
   * Field deprecated in 18.1.5.
   * Field introduced in 18.1.4.
   * @return forceDetection
   */
  public Boolean getForceDetection() {
    return forceDetection;
  }

  /**
   * This is the setter method to the attribute.
   * When set to 'true', this rule will not cause 'deny' or 'redirect' actions to run, even if waf policy is set to enforcement mode.
   * The behavior would be as if this rule operated in detection mode regardless of waf policy setting.
   * Field deprecated in 18.1.5.
   * Field introduced in 18.1.4.
   * @param forceDetection set the forceDetection.
   */
  public void setForceDetection(Boolean  forceDetection) {
    this.forceDetection = forceDetection;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.2.1.
   * @return index
   */
  public Integer getIndex() {
    return index;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.2.1.
   * @param index set the index.
   */
  public void setIndex(Integer  index) {
    this.index = index;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The rule field is sensitive and will not be displayed.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return isSensitive
   */
  public Boolean getIsSensitive() {
    return isSensitive;
  }

  /**
   * This is the setter method to the attribute.
   * The rule field is sensitive and will not be displayed.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param isSensitive set the isSensitive.
   */
  public void setIsSensitive(Boolean  isSensitive) {
    this.isSensitive = isSensitive;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Waf rule mode.
   * This can be detection or enforcement.
   * If this is not set, the policy mode is used.
   * This only takes effect if the policy allows delegation.
   * Enum options - WAF_MODE_DETECTION_ONLY, WAF_MODE_ENFORCEMENT.
   * Field introduced in 18.1.5, 18.2.1.
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
   * Field introduced in 18.1.5, 18.2.1.
   * @param mode set the mode.
   */
  public void setMode(String  mode) {
    this.mode = mode;
  }

  /**
   * This is the getter method this will return the attribute value.
   * User-friendly optional name for a rule.
   * Field introduced in 17.2.1.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * User-friendly optional name for a rule.
   * Field introduced in 17.2.1.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The execution phase where this rule will be executed.
   * Enum options - WAF_PHASE_CONNECTION, WAF_PHASE_REQUEST_HEADER, WAF_PHASE_REQUEST_BODY, WAF_PHASE_RESPONSE_HEADER, WAF_PHASE_RESPONSE_BODY,
   * WAF_PHASE_LOGGING.
   * Field introduced in 20.1.1.
   * @return phase
   */
  public String getPhase() {
    return phase;
  }

  /**
   * This is the setter method to the attribute.
   * The execution phase where this rule will be executed.
   * Enum options - WAF_PHASE_CONNECTION, WAF_PHASE_REQUEST_HEADER, WAF_PHASE_REQUEST_BODY, WAF_PHASE_RESPONSE_HEADER, WAF_PHASE_RESPONSE_BODY,
   * WAF_PHASE_LOGGING.
   * Field introduced in 20.1.1.
   * @param phase set the phase.
   */
  public void setPhase(String  phase) {
    this.phase = phase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Rule as per modsec language.
   * Field introduced in 17.2.1.
   * @return rule
   */
  public String getRule() {
    return rule;
  }

  /**
   * This is the setter method to the attribute.
   * Rule as per modsec language.
   * Field introduced in 17.2.1.
   * @param rule set the rule.
   */
  public void setRule(String  rule) {
    this.rule = rule;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Identifier (id) for a rule per modsec language.
   * All secrule and secaction directives require an id.
   * It is extracted from the id action in a modsec rule.
   * Rules within a single waf policy are required to have unique rule_ids.
   * Field introduced in 17.2.2.
   * @return ruleId
   */
  public String getRuleId() {
    return ruleId;
  }

  /**
   * This is the setter method to the attribute.
   * Identifier (id) for a rule per modsec language.
   * All secrule and secaction directives require an id.
   * It is extracted from the id action in a modsec rule.
   * Rules within a single waf policy are required to have unique rule_ids.
   * Field introduced in 17.2.2.
   * @param ruleId set the ruleId.
   */
  public void setRuleId(String  ruleId) {
    this.ruleId = ruleId;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Tags for waf rule as per modsec language.
   * They are extracted from the tag action in a modsec rule.
   * Field introduced in 18.1.3.
   * @return tags
   */
  public List<String> getTags() {
    return tags;
  }

  /**
   * This is the setter method. this will set the tags
   * Tags for waf rule as per modsec language.
   * They are extracted from the tag action in a modsec rule.
   * Field introduced in 18.1.3.
   * @return tags
   */
  public void setTags(List<String>  tags) {
    this.tags = tags;
  }

  /**
   * This is the setter method this will set the tags
   * Tags for waf rule as per modsec language.
   * They are extracted from the tag action in a modsec rule.
   * Field introduced in 18.1.3.
   * @return tags
   */
  public WafRule addTagsItem(String tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<String>();
    }
    this.tags.add(tagsItem);
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
  WafRule objWafRule = (WafRule) o;
  return   Objects.equals(this.index, objWafRule.index)&&
  Objects.equals(this.name, objWafRule.name)&&
  Objects.equals(this.ruleId, objWafRule.ruleId)&&
  Objects.equals(this.enable, objWafRule.enable)&&
  Objects.equals(this.rule, objWafRule.rule)&&
  Objects.equals(this.excludeList, objWafRule.excludeList)&&
  Objects.equals(this.tags, objWafRule.tags)&&
  Objects.equals(this.forceDetection, objWafRule.forceDetection)&&
  Objects.equals(this.mode, objWafRule.mode)&&
  Objects.equals(this.isSensitive, objWafRule.isSensitive)&&
  Objects.equals(this.phase, objWafRule.phase);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class WafRule {\n");
      sb.append("    enable: ").append(toIndentedString(enable)).append("\n");
        sb.append("    excludeList: ").append(toIndentedString(excludeList)).append("\n");
        sb.append("    forceDetection: ").append(toIndentedString(forceDetection)).append("\n");
        sb.append("    index: ").append(toIndentedString(index)).append("\n");
        sb.append("    isSensitive: ").append(toIndentedString(isSensitive)).append("\n");
        sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    phase: ").append(toIndentedString(phase)).append("\n");
        sb.append("    rule: ").append(toIndentedString(rule)).append("\n");
        sb.append("    ruleId: ").append(toIndentedString(ruleId)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
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

