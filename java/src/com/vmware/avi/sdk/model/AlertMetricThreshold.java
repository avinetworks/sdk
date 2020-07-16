package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The AlertMetricThreshold is a POJO class extends AviRestResource that used for creating
 * AlertMetricThreshold.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlertMetricThreshold  {
    @JsonProperty("comparator")
    private String comparator = "ALERT_OP_GT";

    @JsonProperty("threshold")
    private Integer threshold = null;



  /**
   * This is the getter method this will return the attribute value.
   * Enum options - ALERT_OP_LT, ALERT_OP_LE, ALERT_OP_EQ, ALERT_OP_NE, ALERT_OP_GE, ALERT_OP_GT.
   * Default value when not specified in API or module is interpreted by Avi Controller as ALERT_OP_GT.
   * @return comparator
   */
  public String getComparator() {
    return comparator;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - ALERT_OP_LT, ALERT_OP_LE, ALERT_OP_EQ, ALERT_OP_NE, ALERT_OP_GE, ALERT_OP_GT.
   * Default value when not specified in API or module is interpreted by Avi Controller as ALERT_OP_GT.
   * @param comparator set the comparator.
   */
  public void setComparator(String  comparator) {
    this.comparator = comparator;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Metric threshold for comparison.
   * @return threshold
   */
  public Integer getThreshold() {
    return threshold;
  }

  /**
   * This is the setter method to the attribute.
   * Metric threshold for comparison.
   * @param threshold set the threshold.
   */
  public void setThreshold(Integer  threshold) {
    this.threshold = threshold;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  AlertMetricThreshold objAlertMetricThreshold = (AlertMetricThreshold) o;
  return   Objects.equals(this.threshold, objAlertMetricThreshold.threshold)&&
  Objects.equals(this.comparator, objAlertMetricThreshold.comparator);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class AlertMetricThreshold {\n");
      sb.append("    comparator: ").append(toIndentedString(comparator)).append("\n");
        sb.append("    threshold: ").append(toIndentedString(threshold)).append("\n");
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

