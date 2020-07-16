package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The AppLearningParams is a POJO class extends AviRestResource that used for creating
 * AppLearningParams.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppLearningParams  {
    @JsonProperty("enable_per_uri_learning")
    private Boolean enablePerUriLearning = true;

    @JsonProperty("max_params")
    private Integer maxParams = 100;

    @JsonProperty("max_uris")
    private Integer maxUris = 500;

    @JsonProperty("min_hits_to_learn")
    private Integer minHitsToLearn = 10000;

    @JsonProperty("sampling_percent")
    private Integer samplingPercent = 1;

    @JsonProperty("update_interval")
    private Integer updateInterval = 30;



  /**
   * This is the getter method this will return the attribute value.
   * Learn the params per uri path.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return enablePerUriLearning
   */
  public Boolean getEnablePerUriLearning() {
    return enablePerUriLearning;
  }

  /**
   * This is the setter method to the attribute.
   * Learn the params per uri path.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param enablePerUriLearning set the enablePerUriLearning.
   */
  public void setEnablePerUriLearning(Boolean  enablePerUriLearning) {
    this.enablePerUriLearning = enablePerUriLearning;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of params to learn for an application.
   * Allowed values are 10-1000.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100.
   * @return maxParams
   */
  public Integer getMaxParams() {
    return maxParams;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of params to learn for an application.
   * Allowed values are 10-1000.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100.
   * @param maxParams set the maxParams.
   */
  public void setMaxParams(Integer  maxParams) {
    this.maxParams = maxParams;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of uri paths to learn for an application.
   * Allowed values are 10-10000.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as 500.
   * @return maxUris
   */
  public Integer getMaxUris() {
    return maxUris;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of uri paths to learn for an application.
   * Allowed values are 10-10000.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as 500.
   * @param maxUris set the maxUris.
   */
  public void setMaxUris(Integer  maxUris) {
    this.maxUris = maxUris;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Minimum number of occurances required for a param to qualify for learning.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10000.
   * @return minHitsToLearn
   */
  public Integer getMinHitsToLearn() {
    return minHitsToLearn;
  }

  /**
   * This is the setter method to the attribute.
   * Minimum number of occurances required for a param to qualify for learning.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10000.
   * @param minHitsToLearn set the minHitsToLearn.
   */
  public void setMinHitsToLearn(Integer  minHitsToLearn) {
    this.minHitsToLearn = minHitsToLearn;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Percent of the requests subjected to application learning.
   * Allowed values are 1-100.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.
   * @return samplingPercent
   */
  public Integer getSamplingPercent() {
    return samplingPercent;
  }

  /**
   * This is the setter method to the attribute.
   * Percent of the requests subjected to application learning.
   * Allowed values are 1-100.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.
   * @param samplingPercent set the samplingPercent.
   */
  public void setSamplingPercent(Integer  samplingPercent) {
    this.samplingPercent = samplingPercent;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Frequency with which se publishes application learning data to controller.
   * Allowed values are 1-10080.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as 30.
   * @return updateInterval
   */
  public Integer getUpdateInterval() {
    return updateInterval;
  }

  /**
   * This is the setter method to the attribute.
   * Frequency with which se publishes application learning data to controller.
   * Allowed values are 1-10080.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as 30.
   * @param updateInterval set the updateInterval.
   */
  public void setUpdateInterval(Integer  updateInterval) {
    this.updateInterval = updateInterval;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  AppLearningParams objAppLearningParams = (AppLearningParams) o;
  return   Objects.equals(this.enablePerUriLearning, objAppLearningParams.enablePerUriLearning)&&
  Objects.equals(this.maxUris, objAppLearningParams.maxUris)&&
  Objects.equals(this.minHitsToLearn, objAppLearningParams.minHitsToLearn)&&
  Objects.equals(this.maxParams, objAppLearningParams.maxParams)&&
  Objects.equals(this.updateInterval, objAppLearningParams.updateInterval)&&
  Objects.equals(this.samplingPercent, objAppLearningParams.samplingPercent);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class AppLearningParams {\n");
      sb.append("    enablePerUriLearning: ").append(toIndentedString(enablePerUriLearning)).append("\n");
        sb.append("    maxParams: ").append(toIndentedString(maxParams)).append("\n");
        sb.append("    maxUris: ").append(toIndentedString(maxUris)).append("\n");
        sb.append("    minHitsToLearn: ").append(toIndentedString(minHitsToLearn)).append("\n");
        sb.append("    samplingPercent: ").append(toIndentedString(samplingPercent)).append("\n");
        sb.append("    updateInterval: ").append(toIndentedString(updateInterval)).append("\n");
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

