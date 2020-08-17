package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The WafRuleGroup is a POJO class extends AviRestResource that used for creating
 * WafRuleGroup.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WafRuleGroup  {
    @JsonProperty("enable")
    private Boolean enable = true;

    @JsonProperty("exclude_list")
    private List<WafExcludeListEntry> excludeList = null;

    @JsonProperty("force_detection")
    private Boolean forceDetection = null;

    @JsonProperty("index")
    private Integer index = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("rules")
    private List<WafRule> rules = null;



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
   * Exclude list for the waf rule group.
   * The fields in the exclude list entry are logically and'ed to deduce the exclusion criteria.
   * If there are multiple excludelist entries, it will be 'logical or' of them.
   * Field introduced in 17.2.1.
   * @return excludeList
   */
  public List<WafExcludeListEntry> getExcludeList() {
    return excludeList;
  }

  /**
   * This is the setter method. this will set the excludeList
   * Exclude list for the waf rule group.
   * The fields in the exclude list entry are logically and'ed to deduce the exclusion criteria.
   * If there are multiple excludelist entries, it will be 'logical or' of them.
   * Field introduced in 17.2.1.
   * @return excludeList
   */
  public void setExcludeList(List<WafExcludeListEntry>  excludeList) {
    this.excludeList = excludeList;
  }

  /**
   * This is the setter method this will set the excludeList
   * Exclude list for the waf rule group.
   * The fields in the exclude list entry are logically and'ed to deduce the exclusion criteria.
   * If there are multiple excludelist entries, it will be 'logical or' of them.
   * Field introduced in 17.2.1.
   * @return excludeList
   */
  public WafRuleGroup addExcludeListItem(WafExcludeListEntry excludeListItem) {
    if (this.excludeList == null) {
      this.excludeList = new ArrayList<WafExcludeListEntry>();
    }
    this.excludeList.add(excludeListItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * When set to 'true', any rule in this group will not cause 'deny' or 'redirect' actions to run, even if waf policy is set to enforcement mode.
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
   * When set to 'true', any rule in this group will not cause 'deny' or 'redirect' actions to run, even if waf policy is set to enforcement mode.
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
   * Field introduced in 17.2.1.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.2.1.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Rules as per modsec language.
   * Field introduced in 17.2.1.
   * @return rules
   */
  public List<WafRule> getRules() {
    return rules;
  }

  /**
   * This is the setter method. this will set the rules
   * Rules as per modsec language.
   * Field introduced in 17.2.1.
   * @return rules
   */
  public void setRules(List<WafRule>  rules) {
    this.rules = rules;
  }

  /**
   * This is the setter method this will set the rules
   * Rules as per modsec language.
   * Field introduced in 17.2.1.
   * @return rules
   */
  public WafRuleGroup addRulesItem(WafRule rulesItem) {
    if (this.rules == null) {
      this.rules = new ArrayList<WafRule>();
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
  WafRuleGroup objWafRuleGroup = (WafRuleGroup) o;
  return   Objects.equals(this.index, objWafRuleGroup.index)&&
  Objects.equals(this.name, objWafRuleGroup.name)&&
  Objects.equals(this.enable, objWafRuleGroup.enable)&&
  Objects.equals(this.rules, objWafRuleGroup.rules)&&
  Objects.equals(this.excludeList, objWafRuleGroup.excludeList)&&
  Objects.equals(this.forceDetection, objWafRuleGroup.forceDetection);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class WafRuleGroup {\n");
      sb.append("    enable: ").append(toIndentedString(enable)).append("\n");
        sb.append("    excludeList: ").append(toIndentedString(excludeList)).append("\n");
        sb.append("    forceDetection: ").append(toIndentedString(forceDetection)).append("\n");
        sb.append("    index: ").append(toIndentedString(index)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

