package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The AppLearningConfidenceOverride is a POJO class extends AviRestResource that used for creating
 * AppLearningConfidenceOverride.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppLearningConfidenceOverride  {
    @JsonProperty("confid_high_value")
    private Integer confidHighValue = 9500;

    @JsonProperty("confid_low_value")
    private Integer confidLowValue = 7500;

    @JsonProperty("confid_probable_value")
    private Integer confidProbableValue = 9000;

    @JsonProperty("confid_very_high_value")
    private Integer confidVeryHighValue = 9999;



  /**
   * This is the getter method this will return the attribute value.
   * Confidence threshold for label confidence_high.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as 9500.
   * @return confidHighValue
   */
  public Integer getConfidHighValue() {
    return confidHighValue;
  }

  /**
   * This is the setter method to the attribute.
   * Confidence threshold for label confidence_high.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as 9500.
   * @param confidHighValue set the confidHighValue.
   */
  public void setConfidHighValue(Integer  confidHighValue) {
    this.confidHighValue = confidHighValue;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Confidence threshold for label confidence_low.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as 7500.
   * @return confidLowValue
   */
  public Integer getConfidLowValue() {
    return confidLowValue;
  }

  /**
   * This is the setter method to the attribute.
   * Confidence threshold for label confidence_low.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as 7500.
   * @param confidLowValue set the confidLowValue.
   */
  public void setConfidLowValue(Integer  confidLowValue) {
    this.confidLowValue = confidLowValue;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Confidence threshold for label confidence_probable.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as 9000.
   * @return confidProbableValue
   */
  public Integer getConfidProbableValue() {
    return confidProbableValue;
  }

  /**
   * This is the setter method to the attribute.
   * Confidence threshold for label confidence_probable.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as 9000.
   * @param confidProbableValue set the confidProbableValue.
   */
  public void setConfidProbableValue(Integer  confidProbableValue) {
    this.confidProbableValue = confidProbableValue;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Confidence threshold for label confidence_very_high.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as 9999.
   * @return confidVeryHighValue
   */
  public Integer getConfidVeryHighValue() {
    return confidVeryHighValue;
  }

  /**
   * This is the setter method to the attribute.
   * Confidence threshold for label confidence_very_high.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as 9999.
   * @param confidVeryHighValue set the confidVeryHighValue.
   */
  public void setConfidVeryHighValue(Integer  confidVeryHighValue) {
    this.confidVeryHighValue = confidVeryHighValue;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  AppLearningConfidenceOverride objAppLearningConfidenceOverride = (AppLearningConfidenceOverride) o;
  return   Objects.equals(this.confidVeryHighValue, objAppLearningConfidenceOverride.confidVeryHighValue)&&
  Objects.equals(this.confidHighValue, objAppLearningConfidenceOverride.confidHighValue)&&
  Objects.equals(this.confidProbableValue, objAppLearningConfidenceOverride.confidProbableValue)&&
  Objects.equals(this.confidLowValue, objAppLearningConfidenceOverride.confidLowValue);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class AppLearningConfidenceOverride {\n");
      sb.append("    confidHighValue: ").append(toIndentedString(confidHighValue)).append("\n");
        sb.append("    confidLowValue: ").append(toIndentedString(confidLowValue)).append("\n");
        sb.append("    confidProbableValue: ").append(toIndentedString(confidProbableValue)).append("\n");
        sb.append("    confidVeryHighValue: ").append(toIndentedString(confidVeryHighValue)).append("\n");
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

