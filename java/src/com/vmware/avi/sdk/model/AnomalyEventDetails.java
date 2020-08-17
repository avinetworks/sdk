package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The AnomalyEventDetails is a POJO class extends AviRestResource that used for creating
 * AnomalyEventDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnomalyEventDetails  {
    @JsonProperty("deviation")
    private float deviation = 0.0f;

    @JsonProperty("metric_id")
    private String metricId = null;

    @JsonProperty("metric_timestamp")
    private String metricTimestamp = null;

    @JsonProperty("model")
    private String model = "EXPONENTIAL_WEIGHTED_MOVING_AVG";

    @JsonProperty("models")
    private List<String> models = null;

    @JsonProperty("node_id")
    private String nodeId = null;

    @JsonProperty("obj_type")
    private String objType = null;

    @JsonProperty("pool_name")
    private String poolName = null;

    @JsonProperty("pool_uuid")
    private String poolUuid = null;

    @JsonProperty("priority")
    private String priority = null;

    @JsonProperty("server")
    private String server = null;

    @JsonProperty("value")
    private Float value = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property deviation of obj type anomalyeventdetails field type str  type float.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.0.
   * @return deviation
   */
  public Float getDeviation() {
    return deviation;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property deviation of obj type anomalyeventdetails field type str  type float.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.0.
   * @param deviation set the deviation.
   */
  public void setDeviation(Float  deviation) {
    this.deviation = deviation;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property metric_id of obj type anomalyeventdetails field type str  type string.
   * @return metricId
   */
  public String getMetricId() {
    return metricId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property metric_id of obj type anomalyeventdetails field type str  type string.
   * @param metricId set the metricId.
   */
  public void setMetricId(String  metricId) {
    this.metricId = metricId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property metric_timestamp of obj type anomalyeventdetails field type str  type string.
   * @return metricTimestamp
   */
  public String getMetricTimestamp() {
    return metricTimestamp;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property metric_timestamp of obj type anomalyeventdetails field type str  type string.
   * @param metricTimestamp set the metricTimestamp.
   */
  public void setMetricTimestamp(String  metricTimestamp) {
    this.metricTimestamp = metricTimestamp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Deprecated.
   * Enum options - EXPONENTIAL_MOVING_AVG, EXPONENTIAL_WEIGHTED_MOVING_AVG, HOLTWINTERS_AT_AS, HOLTWINTERS_AT_MS.
   * Default value when not specified in API or module is interpreted by Avi Controller as EXPONENTIAL_WEIGHTED_MOVING_AVG.
   * @return model
   */
  public String getModel() {
    return model;
  }

  /**
   * This is the setter method to the attribute.
   * Deprecated.
   * Enum options - EXPONENTIAL_MOVING_AVG, EXPONENTIAL_WEIGHTED_MOVING_AVG, HOLTWINTERS_AT_AS, HOLTWINTERS_AT_MS.
   * Default value when not specified in API or module is interpreted by Avi Controller as EXPONENTIAL_WEIGHTED_MOVING_AVG.
   * @param model set the model.
   */
  public void setModel(String  model) {
    this.model = model;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Enum options - EXPONENTIAL_MOVING_AVG, EXPONENTIAL_WEIGHTED_MOVING_AVG, HOLTWINTERS_AT_AS, HOLTWINTERS_AT_MS.
   * @return models
   */
  public List<String> getModels() {
    return models;
  }

  /**
   * This is the setter method. this will set the models
   * Enum options - EXPONENTIAL_MOVING_AVG, EXPONENTIAL_WEIGHTED_MOVING_AVG, HOLTWINTERS_AT_AS, HOLTWINTERS_AT_MS.
   * @return models
   */
  public void setModels(List<String>  models) {
    this.models = models;
  }

  /**
   * This is the setter method this will set the models
   * Enum options - EXPONENTIAL_MOVING_AVG, EXPONENTIAL_WEIGHTED_MOVING_AVG, HOLTWINTERS_AT_AS, HOLTWINTERS_AT_MS.
   * @return models
   */
  public AnomalyEventDetails addModelsItem(String modelsItem) {
    if (this.models == null) {
      this.models = new ArrayList<String>();
    }
    this.models.add(modelsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property node_id of obj type anomalyeventdetails field type str  type string.
   * @return nodeId
   */
  public String getNodeId() {
    return nodeId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property node_id of obj type anomalyeventdetails field type str  type string.
   * @param nodeId set the nodeId.
   */
  public void setNodeId(String  nodeId) {
    this.nodeId = nodeId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - METRICS_OBJ_TYPE_UNKNOWN, VSERVER_L4_SERVER, VSERVER_L4_CLIENT, VSERVER_L7_SERVER, VSERVER_L7_CLIENT, VM_METRICS_OBJ,
   * SE_METRICS_OBJ, VSERVER_RUM, CONTROLLER_METRICS_OBJ, METRICS_COLLECTION, METRICS_RUM_PREAGG_BROWSER_OBJ, METRICS_RUM_PREAGG_COUNTRY_OBJ,
   * METRICS_RUM_PREAGG_DEVTYPE_OBJ, METRICS_RUM_PREAGG_LANG_OBJ, METRICS_RUM_PREAGG_OS_OBJ, METRICS_RUM_PREAGG_URL_OBJ, METRICS_ANOMALY_OBJ,
   * METRICS_HEALTHSCORE_OBJ, METRICS_RESOURCE_TIMING_BROWSER_OBJ, METRICS_RESOURCE_TIMING_OS_OBJ...
   * @return objType
   */
  public String getObjType() {
    return objType;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - METRICS_OBJ_TYPE_UNKNOWN, VSERVER_L4_SERVER, VSERVER_L4_CLIENT, VSERVER_L7_SERVER, VSERVER_L7_CLIENT, VM_METRICS_OBJ,
   * SE_METRICS_OBJ, VSERVER_RUM, CONTROLLER_METRICS_OBJ, METRICS_COLLECTION, METRICS_RUM_PREAGG_BROWSER_OBJ, METRICS_RUM_PREAGG_COUNTRY_OBJ,
   * METRICS_RUM_PREAGG_DEVTYPE_OBJ, METRICS_RUM_PREAGG_LANG_OBJ, METRICS_RUM_PREAGG_OS_OBJ, METRICS_RUM_PREAGG_URL_OBJ, METRICS_ANOMALY_OBJ,
   * METRICS_HEALTHSCORE_OBJ, METRICS_RESOURCE_TIMING_BROWSER_OBJ, METRICS_RESOURCE_TIMING_OS_OBJ...
   * @param objType set the objType.
   */
  public void setObjType(String  objType) {
    this.objType = objType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property pool_name of obj type anomalyeventdetails field type str  type string.
   * @return poolName
   */
  public String getPoolName() {
    return poolName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property pool_name of obj type anomalyeventdetails field type str  type string.
   * @param poolName set the poolName.
   */
  public void setPoolName(String  poolName) {
    this.poolName = poolName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of pool.
   * @return poolUuid
   */
  public String getPoolUuid() {
    return poolUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of pool.
   * @param poolUuid set the poolUuid.
   */
  public void setPoolUuid(String  poolUuid) {
    this.poolUuid = poolUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - ANZ_PRIORITY_HIGH, ANZ_PRIORITY_MEDIUM, ANZ_PRIORITY_LOW.
   * @return priority
   */
  public String getPriority() {
    return priority;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - ANZ_PRIORITY_HIGH, ANZ_PRIORITY_MEDIUM, ANZ_PRIORITY_LOW.
   * @param priority set the priority.
   */
  public void setPriority(String  priority) {
    this.priority = priority;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property server of obj type anomalyeventdetails field type str  type string.
   * @return server
   */
  public String getServer() {
    return server;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property server of obj type anomalyeventdetails field type str  type string.
   * @param server set the server.
   */
  public void setServer(String  server) {
    this.server = server;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property value of obj type anomalyeventdetails field type str  type float.
   * @return value
   */
  public Float getValue() {
    return value;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property value of obj type anomalyeventdetails field type str  type float.
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
  AnomalyEventDetails objAnomalyEventDetails = (AnomalyEventDetails) o;
  return   Objects.equals(this.deviation, objAnomalyEventDetails.deviation)&&
  Objects.equals(this.value, objAnomalyEventDetails.value)&&
  Objects.equals(this.metricTimestamp, objAnomalyEventDetails.metricTimestamp)&&
  Objects.equals(this.model, objAnomalyEventDetails.model)&&
  Objects.equals(this.metricId, objAnomalyEventDetails.metricId)&&
  Objects.equals(this.priority, objAnomalyEventDetails.priority)&&
  Objects.equals(this.nodeId, objAnomalyEventDetails.nodeId)&&
  Objects.equals(this.objType, objAnomalyEventDetails.objType)&&
  Objects.equals(this.server, objAnomalyEventDetails.server)&&
  Objects.equals(this.poolUuid, objAnomalyEventDetails.poolUuid)&&
  Objects.equals(this.poolName, objAnomalyEventDetails.poolName)&&
  Objects.equals(this.models, objAnomalyEventDetails.models);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class AnomalyEventDetails {\n");
      sb.append("    deviation: ").append(toIndentedString(deviation)).append("\n");
        sb.append("    metricId: ").append(toIndentedString(metricId)).append("\n");
        sb.append("    metricTimestamp: ").append(toIndentedString(metricTimestamp)).append("\n");
        sb.append("    model: ").append(toIndentedString(model)).append("\n");
        sb.append("    models: ").append(toIndentedString(models)).append("\n");
        sb.append("    nodeId: ").append(toIndentedString(nodeId)).append("\n");
        sb.append("    objType: ").append(toIndentedString(objType)).append("\n");
        sb.append("    poolName: ").append(toIndentedString(poolName)).append("\n");
        sb.append("    poolUuid: ").append(toIndentedString(poolUuid)).append("\n");
        sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
        sb.append("    server: ").append(toIndentedString(server)).append("\n");
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

