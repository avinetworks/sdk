package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The WafLearning is a POJO class extends AviRestResource that used for creating
 * WafLearning.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WafLearning  {
    @JsonProperty("arg_summarization_threshold")
    private Integer argSummarizationThreshold = null;

    @JsonProperty("confidence")
    private Integer confidence = null;

    @JsonProperty("enable")
    private Boolean enable = null;

    @JsonProperty("path_summarization_threshold")
    private Integer pathSummarizationThreshold = null;

    @JsonProperty("sampling_percent")
    private Integer samplingPercent = null;



  /**
   * This is the getter method this will return the attribute value.
   * Suffix summarization threshold used to compress args.
   * Allowed values are 3-255.
   * Field deprecated in 18.2.3.
   * Field introduced in 18.1.2.
   * @return argSummarizationThreshold
   */
  public Integer getArgSummarizationThreshold() {
    return argSummarizationThreshold;
  }

  /**
   * This is the setter method to the attribute.
   * Suffix summarization threshold used to compress args.
   * Allowed values are 3-255.
   * Field deprecated in 18.2.3.
   * Field introduced in 18.1.2.
   * @param argSummarizationThreshold set the argSummarizationThreshold.
   */
  public void setArgSummarizationThreshold(Integer  argSummarizationThreshold) {
    this.argSummarizationThreshold = argSummarizationThreshold;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Confidence level used to derive rules from the waf learning.
   * Allowed values are 60-100.
   * Field deprecated in 18.2.3.
   * Field introduced in 18.1.2.
   * @return confidence
   */
  public Integer getConfidence() {
    return confidence;
  }

  /**
   * This is the setter method to the attribute.
   * Confidence level used to derive rules from the waf learning.
   * Allowed values are 60-100.
   * Field deprecated in 18.2.3.
   * Field introduced in 18.1.2.
   * @param confidence set the confidence.
   */
  public void setConfidence(Integer  confidence) {
    this.confidence = confidence;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable learning for waf policy.
   * Field deprecated in 18.2.3.
   * Field introduced in 18.1.2.
   * @return enable
   */
  public Boolean getEnable() {
    return enable;
  }

  /**
   * This is the setter method to the attribute.
   * Enable learning for waf policy.
   * Field deprecated in 18.2.3.
   * Field introduced in 18.1.2.
   * @param enable set the enable.
   */
  public void setEnable(Boolean  enable) {
    this.enable = enable;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Suffix summarization threshold used to compress paths.
   * Allowed values are 3-255.
   * Field deprecated in 18.2.3.
   * Field introduced in 18.1.2.
   * @return pathSummarizationThreshold
   */
  public Integer getPathSummarizationThreshold() {
    return pathSummarizationThreshold;
  }

  /**
   * This is the setter method to the attribute.
   * Suffix summarization threshold used to compress paths.
   * Allowed values are 3-255.
   * Field deprecated in 18.2.3.
   * Field introduced in 18.1.2.
   * @param pathSummarizationThreshold set the pathSummarizationThreshold.
   */
  public void setPathSummarizationThreshold(Integer  pathSummarizationThreshold) {
    this.pathSummarizationThreshold = pathSummarizationThreshold;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Sampling percent of the requests subjected to waf learning.
   * Allowed values are 1-100.
   * Field deprecated in 18.2.3.
   * Field introduced in 18.1.2.
   * @return samplingPercent
   */
  public Integer getSamplingPercent() {
    return samplingPercent;
  }

  /**
   * This is the setter method to the attribute.
   * Sampling percent of the requests subjected to waf learning.
   * Allowed values are 1-100.
   * Field deprecated in 18.2.3.
   * Field introduced in 18.1.2.
   * @param samplingPercent set the samplingPercent.
   */
  public void setSamplingPercent(Integer  samplingPercent) {
    this.samplingPercent = samplingPercent;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  WafLearning objWafLearning = (WafLearning) o;
  return   Objects.equals(this.enable, objWafLearning.enable)&&
  Objects.equals(this.samplingPercent, objWafLearning.samplingPercent)&&
  Objects.equals(this.confidence, objWafLearning.confidence)&&
  Objects.equals(this.pathSummarizationThreshold, objWafLearning.pathSummarizationThreshold)&&
  Objects.equals(this.argSummarizationThreshold, objWafLearning.argSummarizationThreshold);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class WafLearning {\n");
      sb.append("    argSummarizationThreshold: ").append(toIndentedString(argSummarizationThreshold)).append("\n");
        sb.append("    confidence: ").append(toIndentedString(confidence)).append("\n");
        sb.append("    enable: ").append(toIndentedString(enable)).append("\n");
        sb.append("    pathSummarizationThreshold: ").append(toIndentedString(pathSummarizationThreshold)).append("\n");
        sb.append("    samplingPercent: ").append(toIndentedString(samplingPercent)).append("\n");
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

