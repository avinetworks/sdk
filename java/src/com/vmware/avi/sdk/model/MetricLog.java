package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The MetricLog is a POJO class extends AviRestResource that used for creating
 * MetricLog.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetricLog  {
    @JsonProperty("end_timestamp")
    private Float endTimestamp = null;

    @JsonProperty("metric_id")
    private String metricId = null;

    @JsonProperty("report_timestamp")
    private Float reportTimestamp = null;

    @JsonProperty("step")
    private Integer step = null;

    @JsonProperty("time_series")
    private MetricsQueryResponse timeSeries = null;

    @JsonProperty("value")
    private Float value = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property end_timestamp of obj type metriclog field type str  type float.
   * @return endTimestamp
   */
  public Float getEndTimestamp() {
    return endTimestamp;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property end_timestamp of obj type metriclog field type str  type float.
   * @param endTimestamp set the endTimestamp.
   */
  public void setEndTimestamp(Float  endTimestamp) {
    this.endTimestamp = endTimestamp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property metric_id of obj type metriclog field type str  type string.
   * @return metricId
   */
  public String getMetricId() {
    return metricId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property metric_id of obj type metriclog field type str  type string.
   * @param metricId set the metricId.
   */
  public void setMetricId(String  metricId) {
    this.metricId = metricId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property report_timestamp of obj type metriclog field type str  type float.
   * @return reportTimestamp
   */
  public Float getReportTimestamp() {
    return reportTimestamp;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property report_timestamp of obj type metriclog field type str  type float.
   * @param reportTimestamp set the reportTimestamp.
   */
  public void setReportTimestamp(Float  reportTimestamp) {
    this.reportTimestamp = reportTimestamp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property step of obj type metriclog field type str  type integer.
   * @return step
   */
  public Integer getStep() {
    return step;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property step of obj type metriclog field type str  type integer.
   * @param step set the step.
   */
  public void setStep(Integer  step) {
    this.step = step;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property time_series of obj type metriclog field type str  type ref.
   * @return timeSeries
   */
  public MetricsQueryResponse getTimeSeries() {
    return timeSeries;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property time_series of obj type metriclog field type str  type ref.
   * @param timeSeries set the timeSeries.
   */
  public void setTimeSeries(MetricsQueryResponse timeSeries) {
    this.timeSeries = timeSeries;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property value of obj type metriclog field type str  type float.
   * @return value
   */
  public Float getValue() {
    return value;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property value of obj type metriclog field type str  type float.
   * @param value set the value.
   */
  public void setValue(Float  value) {
    this.value = value;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  MetricLog objMetricLog = (MetricLog) o;
  return   Objects.equals(this.timeSeries, objMetricLog.timeSeries)&&
  Objects.equals(this.metricId, objMetricLog.metricId)&&
  Objects.equals(this.value, objMetricLog.value)&&
  Objects.equals(this.reportTimestamp, objMetricLog.reportTimestamp)&&
  Objects.equals(this.step, objMetricLog.step)&&
  Objects.equals(this.endTimestamp, objMetricLog.endTimestamp);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class MetricLog {\n");
      sb.append("    endTimestamp: ").append(toIndentedString(endTimestamp)).append("\n");
        sb.append("    metricId: ").append(toIndentedString(metricId)).append("\n");
        sb.append("    reportTimestamp: ").append(toIndentedString(reportTimestamp)).append("\n");
        sb.append("    step: ").append(toIndentedString(step)).append("\n");
        sb.append("    timeSeries: ").append(toIndentedString(timeSeries)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

