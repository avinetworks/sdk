package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The MetricsMissingDataInterval is a POJO class extends AviRestResource that used for creating
 * MetricsMissingDataInterval.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetricsMissingDataInterval  {
    @JsonProperty("end")
    private String end = null;

    @JsonProperty("start")
    private String start = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property end of obj type metricsmissingdatainterval field type str  type string.
   * @return end
   */
  public String getEnd() {
    return end;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property end of obj type metricsmissingdatainterval field type str  type string.
   * @param end set the end.
   */
  public void setEnd(String  end) {
    this.end = end;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property start of obj type metricsmissingdatainterval field type str  type string.
   * @return start
   */
  public String getStart() {
    return start;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property start of obj type metricsmissingdatainterval field type str  type string.
   * @param start set the start.
   */
  public void setStart(String  start) {
    this.start = start;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  MetricsMissingDataInterval objMetricsMissingDataInterval = (MetricsMissingDataInterval) o;
  return   Objects.equals(this.start, objMetricsMissingDataInterval.start)&&
  Objects.equals(this.end, objMetricsMissingDataInterval.end);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class MetricsMissingDataInterval {\n");
      sb.append("    end: ").append(toIndentedString(end)).append("\n");
        sb.append("    start: ").append(toIndentedString(start)).append("\n");
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

