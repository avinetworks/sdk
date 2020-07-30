package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The MetricsDataHeader is a POJO class extends AviRestResource that used for creating
 * MetricsDataHeader.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetricsDataHeader  {
    @JsonProperty("derivation_data")
    private MetricsDerivationData derivationData = null;

    @JsonProperty("dimension_data")
    private List<MetricsDimensionData> dimensionData = null;

    @JsonProperty("entity_uuid")
    private String entityUuid = null;

    @JsonProperty("metric_description")
    private String metricDescription = null;

    @JsonProperty("metrics_min_scale")
    private Float metricsMinScale = null;

    @JsonProperty("metrics_sum_agg_invalid")
    private Boolean metricsSumAggInvalid = false;

    @JsonProperty("missing_intervals")
    private List<MetricsMissingDataInterval> missingIntervals = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("obj_id")
    private String objId = null;

    @JsonProperty("obj_id_type")
    private String objIdType = null;

    @JsonProperty("pool_uuid")
    private String poolUuid = null;

    @JsonProperty("priority")
    private Boolean priority = true;

    @JsonProperty("server")
    private String server = null;

    @JsonProperty("serviceengine_uuid")
    private String serviceengineUuid = null;

    @JsonProperty("statistics")
    private MetricStatistics statistics = null;

    @JsonProperty("tenant_uuid")
    private String tenantUuid = null;

    @JsonProperty("units")
    private String units = "METRIC_COUNT";



  /**
   * This is the getter method this will return the attribute value.
   * Metrics derivation info.
   * @return derivationData
   */
  public MetricsDerivationData getDerivationData() {
    return derivationData;
  }

  /**
   * This is the setter method to the attribute.
   * Metrics derivation info.
   * @param derivationData set the derivationData.
   */
  public void setDerivationData(MetricsDerivationData derivationData) {
    this.derivationData = derivationData;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property dimension_data of obj type metricsdataheader field type str  type array.
   * @return dimensionData
   */
  public List<MetricsDimensionData> getDimensionData() {
    return dimensionData;
  }

  /**
   * This is the setter method. this will set the dimensionData
   * Placeholder for description of property dimension_data of obj type metricsdataheader field type str  type array.
   * @return dimensionData
   */
  public void setDimensionData(List<MetricsDimensionData>  dimensionData) {
    this.dimensionData = dimensionData;
  }

  /**
   * This is the setter method this will set the dimensionData
   * Placeholder for description of property dimension_data of obj type metricsdataheader field type str  type array.
   * @return dimensionData
   */
  public MetricsDataHeader addDimensionDataItem(MetricsDimensionData dimensionDataItem) {
    if (this.dimensionData == null) {
      this.dimensionData = new ArrayList<MetricsDimensionData>();
    }
    this.dimensionData.add(dimensionDataItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Entity uuid.
   * @return entityUuid
   */
  public String getEntityUuid() {
    return entityUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Entity uuid.
   * @param entityUuid set the entityUuid.
   */
  public void setEntityUuid(String  entityUuid) {
    this.entityUuid = entityUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property metric_description of obj type metricsdataheader field type str  type string.
   * @return metricDescription
   */
  public String getMetricDescription() {
    return metricDescription;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property metric_description of obj type metricsdataheader field type str  type string.
   * @param metricDescription set the metricDescription.
   */
  public void setMetricDescription(String  metricDescription) {
    this.metricDescription = metricDescription;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property metrics_min_scale of obj type metricsdataheader field type str  type float.
   * @return metricsMinScale
   */
  public Float getMetricsMinScale() {
    return metricsMinScale;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property metrics_min_scale of obj type metricsdataheader field type str  type float.
   * @param metricsMinScale set the metricsMinScale.
   */
  public void setMetricsMinScale(Float  metricsMinScale) {
    this.metricsMinScale = metricsMinScale;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property metrics_sum_agg_invalid of obj type metricsdataheader field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return metricsSumAggInvalid
   */
  public Boolean getMetricsSumAggInvalid() {
    return metricsSumAggInvalid;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property metrics_sum_agg_invalid of obj type metricsdataheader field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param metricsSumAggInvalid set the metricsSumAggInvalid.
   */
  public void setMetricsSumAggInvalid(Boolean  metricsSumAggInvalid) {
    this.metricsSumAggInvalid = metricsSumAggInvalid;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Missing data intervals.
   * Data in these intervals are not used for stats calculation.
   * @return missingIntervals
   */
  public List<MetricsMissingDataInterval> getMissingIntervals() {
    return missingIntervals;
  }

  /**
   * This is the setter method. this will set the missingIntervals
   * Missing data intervals.
   * Data in these intervals are not used for stats calculation.
   * @return missingIntervals
   */
  public void setMissingIntervals(List<MetricsMissingDataInterval>  missingIntervals) {
    this.missingIntervals = missingIntervals;
  }

  /**
   * This is the setter method this will set the missingIntervals
   * Missing data intervals.
   * Data in these intervals are not used for stats calculation.
   * @return missingIntervals
   */
  public MetricsDataHeader addMissingIntervalsItem(MetricsMissingDataInterval missingIntervalsItem) {
    if (this.missingIntervals == null) {
      this.missingIntervals = new ArrayList<MetricsMissingDataInterval>();
    }
    this.missingIntervals.add(missingIntervalsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the column.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the column.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Object id of the series when object id was specified in the metric.
   * @return objId
   */
  public String getObjId() {
    return objId;
  }

  /**
   * This is the setter method to the attribute.
   * Object id of the series when object id was specified in the metric.
   * @param objId set the objId.
   */
  public void setObjId(String  objId) {
    this.objId = objId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Obj_id_type.
   * Enum options - METRICS_OBJ_ID_TYPE_VIRTUALSERVICE, METRICS_OBJ_ID_TYPE_SERVER, METRICS_OBJ_ID_TYPE_POOL, METRICS_OBJ_ID_TYPE_SERVICEENGINE,
   * METRICS_OBJ_ID_TYPE_VIRTUALMACHINE, METRICS_OBJ_ID_TYPE_CONTROLLER, METRICS_OBJ_ID_TYPE_TENANT, METRICS_OBJ_ID_TYPE_CLUSTER,
   * METRICS_OBJ_ID_TYPE_SE_INTERFACE.
   * @return objIdType
   */
  public String getObjIdType() {
    return objIdType;
  }

  /**
   * This is the setter method to the attribute.
   * Obj_id_type.
   * Enum options - METRICS_OBJ_ID_TYPE_VIRTUALSERVICE, METRICS_OBJ_ID_TYPE_SERVER, METRICS_OBJ_ID_TYPE_POOL, METRICS_OBJ_ID_TYPE_SERVICEENGINE,
   * METRICS_OBJ_ID_TYPE_VIRTUALMACHINE, METRICS_OBJ_ID_TYPE_CONTROLLER, METRICS_OBJ_ID_TYPE_TENANT, METRICS_OBJ_ID_TYPE_CLUSTER,
   * METRICS_OBJ_ID_TYPE_SE_INTERFACE.
   * @param objIdType set the objIdType.
   */
  public void setObjIdType(String  objIdType) {
    this.objIdType = objIdType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Pool_id for the metric.
   * @return poolUuid
   */
  public String getPoolUuid() {
    return poolUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Pool_id for the metric.
   * @param poolUuid set the poolUuid.
   */
  public void setPoolUuid(String  poolUuid) {
    this.poolUuid = poolUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property priority of obj type metricsdataheader field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return priority
   */
  public Boolean getPriority() {
    return priority;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property priority of obj type metricsdataheader field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param priority set the priority.
   */
  public void setPriority(Boolean  priority) {
    this.priority = priority;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Server ip port.
   * @return server
   */
  public String getServer() {
    return server;
  }

  /**
   * This is the setter method to the attribute.
   * Server ip port.
   * @param server set the server.
   */
  public void setServer(String  server) {
    this.server = server;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Service engine ref or uuid.
   * Field introduced in 17.2.8.
   * @return serviceengineUuid
   */
  public String getServiceengineUuid() {
    return serviceengineUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Service engine ref or uuid.
   * Field introduced in 17.2.8.
   * @param serviceengineUuid set the serviceengineUuid.
   */
  public void setServiceengineUuid(String  serviceengineUuid) {
    this.serviceengineUuid = serviceengineUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Statistics of the metric.
   * @return statistics
   */
  public MetricStatistics getStatistics() {
    return statistics;
  }

  /**
   * This is the setter method to the attribute.
   * Statistics of the metric.
   * @param statistics set the statistics.
   */
  public void setStatistics(MetricStatistics statistics) {
    this.statistics = statistics;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Tenant ref or uuid.
   * @return tenantUuid
   */
  public String getTenantUuid() {
    return tenantUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Tenant ref or uuid.
   * @param tenantUuid set the tenantUuid.
   */
  public void setTenantUuid(String  tenantUuid) {
    this.tenantUuid = tenantUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Units of the column data.
   * Enum options - METRIC_COUNT, BITS_PER_SECOND, MILLISECONDS, SECONDS, PER_SECOND, BYTES, PERCENT, KILO_BYTES, KILO_BYTES_PER_SECOND,
   * BYTES_PER_SECOND, KILO_BITS_PER_SECOND, GIGA_BYTES, MEGA_BYTES, NORMALIZED, STRING, SEC, MIN, DAYS, KB, MB...
   * Default value when not specified in API or module is interpreted by Avi Controller as METRIC_COUNT.
   * @return units
   */
  public String getUnits() {
    return units;
  }

  /**
   * This is the setter method to the attribute.
   * Units of the column data.
   * Enum options - METRIC_COUNT, BITS_PER_SECOND, MILLISECONDS, SECONDS, PER_SECOND, BYTES, PERCENT, KILO_BYTES, KILO_BYTES_PER_SECOND,
   * BYTES_PER_SECOND, KILO_BITS_PER_SECOND, GIGA_BYTES, MEGA_BYTES, NORMALIZED, STRING, SEC, MIN, DAYS, KB, MB...
   * Default value when not specified in API or module is interpreted by Avi Controller as METRIC_COUNT.
   * @param units set the units.
   */
  public void setUnits(String  units) {
    this.units = units;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  MetricsDataHeader objMetricsDataHeader = (MetricsDataHeader) o;
  return   Objects.equals(this.name, objMetricsDataHeader.name)&&
  Objects.equals(this.units, objMetricsDataHeader.units)&&
  Objects.equals(this.objId, objMetricsDataHeader.objId)&&
  Objects.equals(this.statistics, objMetricsDataHeader.statistics)&&
  Objects.equals(this.poolUuid, objMetricsDataHeader.poolUuid)&&
  Objects.equals(this.missingIntervals, objMetricsDataHeader.missingIntervals)&&
  Objects.equals(this.derivationData, objMetricsDataHeader.derivationData)&&
  Objects.equals(this.metricDescription, objMetricsDataHeader.metricDescription)&&
  Objects.equals(this.dimensionData, objMetricsDataHeader.dimensionData)&&
  Objects.equals(this.metricsMinScale, objMetricsDataHeader.metricsMinScale)&&
  Objects.equals(this.server, objMetricsDataHeader.server)&&
  Objects.equals(this.entityUuid, objMetricsDataHeader.entityUuid)&&
  Objects.equals(this.objIdType, objMetricsDataHeader.objIdType)&&
  Objects.equals(this.priority, objMetricsDataHeader.priority)&&
  Objects.equals(this.metricsSumAggInvalid, objMetricsDataHeader.metricsSumAggInvalid)&&
  Objects.equals(this.tenantUuid, objMetricsDataHeader.tenantUuid)&&
  Objects.equals(this.serviceengineUuid, objMetricsDataHeader.serviceengineUuid);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class MetricsDataHeader {\n");
      sb.append("    derivationData: ").append(toIndentedString(derivationData)).append("\n");
        sb.append("    dimensionData: ").append(toIndentedString(dimensionData)).append("\n");
        sb.append("    entityUuid: ").append(toIndentedString(entityUuid)).append("\n");
        sb.append("    metricDescription: ").append(toIndentedString(metricDescription)).append("\n");
        sb.append("    metricsMinScale: ").append(toIndentedString(metricsMinScale)).append("\n");
        sb.append("    metricsSumAggInvalid: ").append(toIndentedString(metricsSumAggInvalid)).append("\n");
        sb.append("    missingIntervals: ").append(toIndentedString(missingIntervals)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    objId: ").append(toIndentedString(objId)).append("\n");
        sb.append("    objIdType: ").append(toIndentedString(objIdType)).append("\n");
        sb.append("    poolUuid: ").append(toIndentedString(poolUuid)).append("\n");
        sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
        sb.append("    server: ").append(toIndentedString(server)).append("\n");
        sb.append("    serviceengineUuid: ").append(toIndentedString(serviceengineUuid)).append("\n");
        sb.append("    statistics: ").append(toIndentedString(statistics)).append("\n");
        sb.append("    tenantUuid: ").append(toIndentedString(tenantUuid)).append("\n");
        sb.append("    units: ").append(toIndentedString(units)).append("\n");
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

