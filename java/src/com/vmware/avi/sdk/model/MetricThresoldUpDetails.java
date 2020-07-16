package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The MetricThresoldUpDetails is a POJO class extends AviRestResource that used for creating
 * MetricThresoldUpDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetricThresoldUpDetails  {
    @JsonProperty("current_value")
    private Float currentValue = null;

    @JsonProperty("entity_uuid")
    private String entityUuid = null;

    @JsonProperty("metric_id")
    private String metricId = null;

    @JsonProperty("metric_name")
    private String metricName = null;

    @JsonProperty("pool_uuid")
    private String poolUuid = null;

    @JsonProperty("server")
    private String server = null;

    @JsonProperty("threshold")
    private Float threshold = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property current_value of obj type metricthresoldupdetails field type str  type float.
   * @return currentValue
   */
  public Float getCurrentValue() {
    return currentValue;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property current_value of obj type metricthresoldupdetails field type str  type float.
   * @param currentValue set the currentValue.
   */
  public void setCurrentValue(Float  currentValue) {
    this.currentValue = currentValue;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Id of the object whose metric has hit the threshold.
   * @return entityUuid
   */
  public String getEntityUuid() {
    return entityUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Id of the object whose metric has hit the threshold.
   * @param entityUuid set the entityUuid.
   */
  public void setEntityUuid(String  entityUuid) {
    this.entityUuid = entityUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property metric_id of obj type metricthresoldupdetails field type str  type string.
   * @return metricId
   */
  public String getMetricId() {
    return metricId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property metric_id of obj type metricthresoldupdetails field type str  type string.
   * @param metricId set the metricId.
   */
  public void setMetricId(String  metricId) {
    this.metricId = metricId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property metric_name of obj type metricthresoldupdetails field type str  type string.
   * @return metricName
   */
  public String getMetricName() {
    return metricName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property metric_name of obj type metricthresoldupdetails field type str  type string.
   * @param metricName set the metricName.
   */
  public void setMetricName(String  metricName) {
    this.metricName = metricName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Identity of the pool.
   * @return poolUuid
   */
  public String getPoolUuid() {
    return poolUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Identity of the pool.
   * @param poolUuid set the poolUuid.
   */
  public void setPoolUuid(String  poolUuid) {
    this.poolUuid = poolUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Server ip port on which event was generated.
   * @return server
   */
  public String getServer() {
    return server;
  }

  /**
   * This is the setter method to the attribute.
   * Server ip port on which event was generated.
   * @param server set the server.
   */
  public void setServer(String  server) {
    this.server = server;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property threshold of obj type metricthresoldupdetails field type str  type float.
   * @return threshold
   */
  public Float getThreshold() {
    return threshold;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property threshold of obj type metricthresoldupdetails field type str  type float.
   * @param threshold set the threshold.
   */
  public void setThreshold(Float  threshold) {
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
  MetricThresoldUpDetails objMetricThresoldUpDetails = (MetricThresoldUpDetails) o;
  return   Objects.equals(this.metricName, objMetricThresoldUpDetails.metricName)&&
  Objects.equals(this.server, objMetricThresoldUpDetails.server)&&
  Objects.equals(this.threshold, objMetricThresoldUpDetails.threshold)&&
  Objects.equals(this.entityUuid, objMetricThresoldUpDetails.entityUuid)&&
  Objects.equals(this.currentValue, objMetricThresoldUpDetails.currentValue)&&
  Objects.equals(this.poolUuid, objMetricThresoldUpDetails.poolUuid)&&
  Objects.equals(this.metricId, objMetricThresoldUpDetails.metricId);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class MetricThresoldUpDetails {\n");
      sb.append("    currentValue: ").append(toIndentedString(currentValue)).append("\n");
        sb.append("    entityUuid: ").append(toIndentedString(entityUuid)).append("\n");
        sb.append("    metricId: ").append(toIndentedString(metricId)).append("\n");
        sb.append("    metricName: ").append(toIndentedString(metricName)).append("\n");
        sb.append("    poolUuid: ").append(toIndentedString(poolUuid)).append("\n");
        sb.append("    server: ").append(toIndentedString(server)).append("\n");
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

