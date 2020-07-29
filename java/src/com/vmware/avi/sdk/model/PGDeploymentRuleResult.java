package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The PGDeploymentRuleResult is a POJO class extends AviRestResource that used for creating
 * PGDeploymentRuleResult.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PGDeploymentRuleResult  {
    @JsonProperty("metric_value")
    private Float metricValue = null;

    @JsonProperty("result")
    private Boolean result = null;

    @JsonProperty("rule")
    private PGDeploymentRule rule = null;



  /**
   * This is the getter method this will return the attribute value.
   * Metric value that is used as the pass fail.
   * If it is not provided then it will simply compare it with current pool vs new pool.
   * @return metricValue
   */
  public Float getMetricValue() {
    return metricValue;
  }

  /**
   * This is the setter method to the attribute.
   * Metric value that is used as the pass fail.
   * If it is not provided then it will simply compare it with current pool vs new pool.
   * @param metricValue set the metricValue.
   */
  public void setMetricValue(Float  metricValue) {
    this.metricValue = metricValue;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Whether rule passed or failed.
   * @return result
   */
  public Boolean getResult() {
    return result;
  }

  /**
   * This is the setter method to the attribute.
   * Whether rule passed or failed.
   * @param result set the result.
   */
  public void setResult(Boolean  result) {
    this.result = result;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Rule used for evaluation.
   * @return rule
   */
  public PGDeploymentRule getRule() {
    return rule;
  }

  /**
   * This is the setter method to the attribute.
   * Rule used for evaluation.
   * @param rule set the rule.
   */
  public void setRule(PGDeploymentRule rule) {
    this.rule = rule;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  PGDeploymentRuleResult objPGDeploymentRuleResult = (PGDeploymentRuleResult) o;
  return   Objects.equals(this.rule, objPGDeploymentRuleResult.rule)&&
  Objects.equals(this.metricValue, objPGDeploymentRuleResult.metricValue)&&
  Objects.equals(this.result, objPGDeploymentRuleResult.result);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class PGDeploymentRuleResult {\n");
      sb.append("    metricValue: ").append(toIndentedString(metricValue)).append("\n");
        sb.append("    result: ").append(toIndentedString(result)).append("\n");
        sb.append("    rule: ").append(toIndentedString(rule)).append("\n");
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

