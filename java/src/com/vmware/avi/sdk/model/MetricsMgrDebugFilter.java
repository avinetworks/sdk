package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The MetricsMgrDebugFilter is a POJO class extends AviRestResource that used for creating
 * MetricsMgrDebugFilter.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetricsMgrDebugFilter  {
    @JsonProperty("disable_hw_training")
    private String disableHwTraining = null;

    @JsonProperty("entity")
    private String entity = null;

    @JsonProperty("license_grace_period")
    private String licenseGracePeriod = null;

    @JsonProperty("log_first_n")
    private String logFirstN = null;

    @JsonProperty("logging_freq")
    private String loggingFreq = null;

    @JsonProperty("metric_instance_id")
    private String metricInstanceId = null;

    @JsonProperty("obj")
    private String obj = null;

    @JsonProperty("skip_cluster_map_check")
    private String skipClusterMapCheck = null;

    @JsonProperty("skip_metrics_db_writes")
    private String skipMetricsDbWrites = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property disable_hw_training of obj type metricsmgrdebugfilter field type str  type string.
   * @return disableHwTraining
   */
  public String getDisableHwTraining() {
    return disableHwTraining;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property disable_hw_training of obj type metricsmgrdebugfilter field type str  type string.
   * @param disableHwTraining set the disableHwTraining.
   */
  public void setDisableHwTraining(String  disableHwTraining) {
    this.disableHwTraining = disableHwTraining;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property entity of obj type metricsmgrdebugfilter field type str  type string.
   * @return entity
   */
  public String getEntity() {
    return entity;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property entity of obj type metricsmgrdebugfilter field type str  type string.
   * @param entity set the entity.
   */
  public void setEntity(String  entity) {
    this.entity = entity;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Setting to reduce the grace period for license expiry in hours.
   * @return licenseGracePeriod
   */
  public String getLicenseGracePeriod() {
    return licenseGracePeriod;
  }

  /**
   * This is the setter method to the attribute.
   * Setting to reduce the grace period for license expiry in hours.
   * @param licenseGracePeriod set the licenseGracePeriod.
   */
  public void setLicenseGracePeriod(String  licenseGracePeriod) {
    this.licenseGracePeriod = licenseGracePeriod;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property log_first_n of obj type metricsmgrdebugfilter field type str  type string.
   * @return logFirstN
   */
  public String getLogFirstN() {
    return logFirstN;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property log_first_n of obj type metricsmgrdebugfilter field type str  type string.
   * @param logFirstN set the logFirstN.
   */
  public void setLogFirstN(String  logFirstN) {
    this.logFirstN = logFirstN;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property logging_freq of obj type metricsmgrdebugfilter field type str  type string.
   * @return loggingFreq
   */
  public String getLoggingFreq() {
    return loggingFreq;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property logging_freq of obj type metricsmgrdebugfilter field type str  type string.
   * @param loggingFreq set the loggingFreq.
   */
  public void setLoggingFreq(String  loggingFreq) {
    this.loggingFreq = loggingFreq;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property metric_instance_id of obj type metricsmgrdebugfilter field type str  type string.
   * @return metricInstanceId
   */
  public String getMetricInstanceId() {
    return metricInstanceId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property metric_instance_id of obj type metricsmgrdebugfilter field type str  type string.
   * @param metricInstanceId set the metricInstanceId.
   */
  public void setMetricInstanceId(String  metricInstanceId) {
    this.metricInstanceId = metricInstanceId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property obj of obj type metricsmgrdebugfilter field type str  type string.
   * @return obj
   */
  public String getObj() {
    return obj;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property obj of obj type metricsmgrdebugfilter field type str  type string.
   * @param obj set the obj.
   */
  public void setObj(String  obj) {
    this.obj = obj;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property skip_cluster_map_check of obj type metricsmgrdebugfilter field type str  type string.
   * @return skipClusterMapCheck
   */
  public String getSkipClusterMapCheck() {
    return skipClusterMapCheck;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property skip_cluster_map_check of obj type metricsmgrdebugfilter field type str  type string.
   * @param skipClusterMapCheck set the skipClusterMapCheck.
   */
  public void setSkipClusterMapCheck(String  skipClusterMapCheck) {
    this.skipClusterMapCheck = skipClusterMapCheck;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property skip_metrics_db_writes of obj type metricsmgrdebugfilter field type str  type string.
   * @return skipMetricsDbWrites
   */
  public String getSkipMetricsDbWrites() {
    return skipMetricsDbWrites;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property skip_metrics_db_writes of obj type metricsmgrdebugfilter field type str  type string.
   * @param skipMetricsDbWrites set the skipMetricsDbWrites.
   */
  public void setSkipMetricsDbWrites(String  skipMetricsDbWrites) {
    this.skipMetricsDbWrites = skipMetricsDbWrites;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  MetricsMgrDebugFilter objMetricsMgrDebugFilter = (MetricsMgrDebugFilter) o;
  return   Objects.equals(this.loggingFreq, objMetricsMgrDebugFilter.loggingFreq)&&
  Objects.equals(this.logFirstN, objMetricsMgrDebugFilter.logFirstN)&&
  Objects.equals(this.obj, objMetricsMgrDebugFilter.obj)&&
  Objects.equals(this.skipMetricsDbWrites, objMetricsMgrDebugFilter.skipMetricsDbWrites)&&
  Objects.equals(this.metricInstanceId, objMetricsMgrDebugFilter.metricInstanceId)&&
  Objects.equals(this.licenseGracePeriod, objMetricsMgrDebugFilter.licenseGracePeriod)&&
  Objects.equals(this.skipClusterMapCheck, objMetricsMgrDebugFilter.skipClusterMapCheck)&&
  Objects.equals(this.entity, objMetricsMgrDebugFilter.entity)&&
  Objects.equals(this.disableHwTraining, objMetricsMgrDebugFilter.disableHwTraining);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class MetricsMgrDebugFilter {\n");
      sb.append("    disableHwTraining: ").append(toIndentedString(disableHwTraining)).append("\n");
        sb.append("    entity: ").append(toIndentedString(entity)).append("\n");
        sb.append("    licenseGracePeriod: ").append(toIndentedString(licenseGracePeriod)).append("\n");
        sb.append("    logFirstN: ").append(toIndentedString(logFirstN)).append("\n");
        sb.append("    loggingFreq: ").append(toIndentedString(loggingFreq)).append("\n");
        sb.append("    metricInstanceId: ").append(toIndentedString(metricInstanceId)).append("\n");
        sb.append("    obj: ").append(toIndentedString(obj)).append("\n");
        sb.append("    skipClusterMapCheck: ").append(toIndentedString(skipClusterMapCheck)).append("\n");
        sb.append("    skipMetricsDbWrites: ").append(toIndentedString(skipMetricsDbWrites)).append("\n");
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

