package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The MetricsQueryResponse is a POJO class extends AviRestResource that used for creating
 * MetricsQueryResponse.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetricsQueryResponse  {
    @JsonProperty("entity_uuid")
    private String entityUuid = null;

    @JsonProperty("id")
    private String id = null;

    @JsonProperty("limit")
    private Integer limit = null;

    @JsonProperty("metric_entity")
    private String metricEntity = null;

    @JsonProperty("metric_id")
    private String metricId = null;

    @JsonProperty("series")
    private List<MetricsDataSeries> series = null;

    @JsonProperty("start")
    private String start = null;

    @JsonProperty("step")
    private Integer step = null;

    @JsonProperty("stop")
    private String stop = null;



  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of entity.
   * @return entityUuid
   */
  public String getEntityUuid() {
    return entityUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of entity.
   * @param entityUuid set the entityUuid.
   */
  public void setEntityUuid(String  entityUuid) {
    this.entityUuid = entityUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Returns the id specified in the query.
   * @return id
   */
  public String getId() {
    return id;
  }

  /**
   * This is the setter method to the attribute.
   * Returns the id specified in the query.
   * @param id set the id.
   */
  public void setId(String  id) {
    this.id = id;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property limit of obj type metricsqueryresponse field type str  type integer.
   * @return limit
   */
  public Integer getLimit() {
    return limit;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property limit of obj type metricsqueryresponse field type str  type integer.
   * @param limit set the limit.
   */
  public void setLimit(Integer  limit) {
    this.limit = limit;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - VSERVER_METRICS_ENTITY, VM_METRICS_ENTITY, SE_METRICS_ENTITY, CONTROLLER_METRICS_ENTITY, APPLICATION_METRICS_ENTITY,
   * TENANT_METRICS_ENTITY, POOL_METRICS_ENTITY.
   * @return metricEntity
   */
  public String getMetricEntity() {
    return metricEntity;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - VSERVER_METRICS_ENTITY, VM_METRICS_ENTITY, SE_METRICS_ENTITY, CONTROLLER_METRICS_ENTITY, APPLICATION_METRICS_ENTITY,
   * TENANT_METRICS_ENTITY, POOL_METRICS_ENTITY.
   * @param metricEntity set the metricEntity.
   */
  public void setMetricEntity(String  metricEntity) {
    this.metricEntity = metricEntity;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property metric_id of obj type metricsqueryresponse field type str  type string.
   * @return metricId
   */
  public String getMetricId() {
    return metricId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property metric_id of obj type metricsqueryresponse field type str  type string.
   * @param metricId set the metricId.
   */
  public void setMetricId(String  metricId) {
    this.metricId = metricId;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property series of obj type metricsqueryresponse field type str  type array.
   * @return series
   */
  public List<MetricsDataSeries> getSeries() {
    return series;
  }

  /**
   * This is the setter method. this will set the series
   * Placeholder for description of property series of obj type metricsqueryresponse field type str  type array.
   * @return series
   */
  public void setSeries(List<MetricsDataSeries>  series) {
    this.series = series;
  }

  /**
   * This is the setter method this will set the series
   * Placeholder for description of property series of obj type metricsqueryresponse field type str  type array.
   * @return series
   */
  public MetricsQueryResponse addSeriesItem(MetricsDataSeries seriesItem) {
    if (this.series == null) {
      this.series = new ArrayList<MetricsDataSeries>();
    }
    this.series.add(seriesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property start of obj type metricsqueryresponse field type str  type string.
   * @return start
   */
  public String getStart() {
    return start;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property start of obj type metricsqueryresponse field type str  type string.
   * @param start set the start.
   */
  public void setStart(String  start) {
    this.start = start;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property step of obj type metricsqueryresponse field type str  type integer.
   * @return step
   */
  public Integer getStep() {
    return step;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property step of obj type metricsqueryresponse field type str  type integer.
   * @param step set the step.
   */
  public void setStep(Integer  step) {
    this.step = step;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property stop of obj type metricsqueryresponse field type str  type string.
   * @return stop
   */
  public String getStop() {
    return stop;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property stop of obj type metricsqueryresponse field type str  type string.
   * @param stop set the stop.
   */
  public void setStop(String  stop) {
    this.stop = stop;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  MetricsQueryResponse objMetricsQueryResponse = (MetricsQueryResponse) o;
  return   Objects.equals(this.entityUuid, objMetricsQueryResponse.entityUuid)&&
  Objects.equals(this.metricEntity, objMetricsQueryResponse.metricEntity)&&
  Objects.equals(this.metricId, objMetricsQueryResponse.metricId)&&
  Objects.equals(this.start, objMetricsQueryResponse.start)&&
  Objects.equals(this.stop, objMetricsQueryResponse.stop)&&
  Objects.equals(this.step, objMetricsQueryResponse.step)&&
  Objects.equals(this.limit, objMetricsQueryResponse.limit)&&
  Objects.equals(this.series, objMetricsQueryResponse.series)&&
  Objects.equals(this.id, objMetricsQueryResponse.id);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class MetricsQueryResponse {\n");
      sb.append("    entityUuid: ").append(toIndentedString(entityUuid)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
        sb.append("    metricEntity: ").append(toIndentedString(metricEntity)).append("\n");
        sb.append("    metricId: ").append(toIndentedString(metricId)).append("\n");
        sb.append("    series: ").append(toIndentedString(series)).append("\n");
        sb.append("    start: ").append(toIndentedString(start)).append("\n");
        sb.append("    step: ").append(toIndentedString(step)).append("\n");
        sb.append("    stop: ").append(toIndentedString(stop)).append("\n");
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

