package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The MetricsDbQueueHealthyEventDetails is a POJO class extends AviRestResource that used for creating
 * MetricsDbQueueHealthyEventDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetricsDbQueueHealthyEventDetails  {
    @JsonProperty("high")
    private Integer high = null;

    @JsonProperty("instanceport")
    private Integer instanceport = null;

    @JsonProperty("low")
    private Integer low = null;

    @JsonProperty("nodeid")
    private String nodeid = null;

    @JsonProperty("period")
    private String period = null;

    @JsonProperty("runtime")
    private MetricsDbRuntime runtime = null;

    @JsonProperty("watermark")
    private Integer watermark = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property high of obj type metricsdbqueuehealthyeventdetails field type str  type integer.
   * @return high
   */
  public Integer getHigh() {
    return high;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property high of obj type metricsdbqueuehealthyeventdetails field type str  type integer.
   * @param high set the high.
   */
  public void setHigh(Integer  high) {
    this.high = high;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property instanceport of obj type metricsdbqueuehealthyeventdetails field type str  type integer.
   * @return instanceport
   */
  public Integer getInstanceport() {
    return instanceport;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property instanceport of obj type metricsdbqueuehealthyeventdetails field type str  type integer.
   * @param instanceport set the instanceport.
   */
  public void setInstanceport(Integer  instanceport) {
    this.instanceport = instanceport;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property low of obj type metricsdbqueuehealthyeventdetails field type str  type integer.
   * @return low
   */
  public Integer getLow() {
    return low;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property low of obj type metricsdbqueuehealthyeventdetails field type str  type integer.
   * @param low set the low.
   */
  public void setLow(Integer  low) {
    this.low = low;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property nodeid of obj type metricsdbqueuehealthyeventdetails field type str  type string.
   * @return nodeid
   */
  public String getNodeid() {
    return nodeid;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property nodeid of obj type metricsdbqueuehealthyeventdetails field type str  type string.
   * @param nodeid set the nodeid.
   */
  public void setNodeid(String  nodeid) {
    this.nodeid = nodeid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property period of obj type metricsdbqueuehealthyeventdetails field type str  type string.
   * @return period
   */
  public String getPeriod() {
    return period;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property period of obj type metricsdbqueuehealthyeventdetails field type str  type string.
   * @param period set the period.
   */
  public void setPeriod(String  period) {
    this.period = period;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property runtime of obj type metricsdbqueuehealthyeventdetails field type str  type ref.
   * @return runtime
   */
  public MetricsDbRuntime getRuntime() {
    return runtime;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property runtime of obj type metricsdbqueuehealthyeventdetails field type str  type ref.
   * @param runtime set the runtime.
   */
  public void setRuntime(MetricsDbRuntime runtime) {
    this.runtime = runtime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property watermark of obj type metricsdbqueuehealthyeventdetails field type str  type integer.
   * @return watermark
   */
  public Integer getWatermark() {
    return watermark;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property watermark of obj type metricsdbqueuehealthyeventdetails field type str  type integer.
   * @param watermark set the watermark.
   */
  public void setWatermark(Integer  watermark) {
    this.watermark = watermark;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  MetricsDbQueueHealthyEventDetails objMetricsDbQueueHealthyEventDetails = (MetricsDbQueueHealthyEventDetails) o;
  return   Objects.equals(this.low, objMetricsDbQueueHealthyEventDetails.low)&&
  Objects.equals(this.high, objMetricsDbQueueHealthyEventDetails.high)&&
  Objects.equals(this.watermark, objMetricsDbQueueHealthyEventDetails.watermark)&&
  Objects.equals(this.nodeid, objMetricsDbQueueHealthyEventDetails.nodeid)&&
  Objects.equals(this.instanceport, objMetricsDbQueueHealthyEventDetails.instanceport)&&
  Objects.equals(this.period, objMetricsDbQueueHealthyEventDetails.period)&&
  Objects.equals(this.runtime, objMetricsDbQueueHealthyEventDetails.runtime);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class MetricsDbQueueHealthyEventDetails {\n");
      sb.append("    high: ").append(toIndentedString(high)).append("\n");
        sb.append("    instanceport: ").append(toIndentedString(instanceport)).append("\n");
        sb.append("    low: ").append(toIndentedString(low)).append("\n");
        sb.append("    nodeid: ").append(toIndentedString(nodeid)).append("\n");
        sb.append("    period: ").append(toIndentedString(period)).append("\n");
        sb.append("    runtime: ").append(toIndentedString(runtime)).append("\n");
        sb.append("    watermark: ").append(toIndentedString(watermark)).append("\n");
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

