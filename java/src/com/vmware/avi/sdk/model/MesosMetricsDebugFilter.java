package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The MesosMetricsDebugFilter is a POJO class extends AviRestResource that used for creating
 * MesosMetricsDebugFilter.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MesosMetricsDebugFilter  {
    @JsonProperty("mesos_master")
    private String mesosMaster = null;

    @JsonProperty("mesos_slave")
    private String mesosSlave = null;

    @JsonProperty("metric_entity")
    private String metricEntity = null;

    @JsonProperty("metrics_collection_frq")
    private Integer metricsCollectionFrq = 60;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property mesos_master of obj type mesosmetricsdebugfilter field type str  type string.
   * @return mesosMaster
   */
  public String getMesosMaster() {
    return mesosMaster;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property mesos_master of obj type mesosmetricsdebugfilter field type str  type string.
   * @param mesosMaster set the mesosMaster.
   */
  public void setMesosMaster(String  mesosMaster) {
    this.mesosMaster = mesosMaster;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property mesos_slave of obj type mesosmetricsdebugfilter field type str  type string.
   * @return mesosSlave
   */
  public String getMesosSlave() {
    return mesosSlave;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property mesos_slave of obj type mesosmetricsdebugfilter field type str  type string.
   * @param mesosSlave set the mesosSlave.
   */
  public void setMesosSlave(String  mesosSlave) {
    this.mesosSlave = mesosSlave;
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
   * Placeholder for description of property metrics_collection_frq of obj type mesosmetricsdebugfilter field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @return metricsCollectionFrq
   */
  public Integer getMetricsCollectionFrq() {
    return metricsCollectionFrq;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property metrics_collection_frq of obj type mesosmetricsdebugfilter field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @param metricsCollectionFrq set the metricsCollectionFrq.
   */
  public void setMetricsCollectionFrq(Integer  metricsCollectionFrq) {
    this.metricsCollectionFrq = metricsCollectionFrq;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  MesosMetricsDebugFilter objMesosMetricsDebugFilter = (MesosMetricsDebugFilter) o;
  return   Objects.equals(this.metricEntity, objMesosMetricsDebugFilter.metricEntity)&&
  Objects.equals(this.mesosMaster, objMesosMetricsDebugFilter.mesosMaster)&&
  Objects.equals(this.mesosSlave, objMesosMetricsDebugFilter.mesosSlave)&&
  Objects.equals(this.metricsCollectionFrq, objMesosMetricsDebugFilter.metricsCollectionFrq);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class MesosMetricsDebugFilter {\n");
      sb.append("    mesosMaster: ").append(toIndentedString(mesosMaster)).append("\n");
        sb.append("    mesosSlave: ").append(toIndentedString(mesosSlave)).append("\n");
        sb.append("    metricEntity: ").append(toIndentedString(metricEntity)).append("\n");
        sb.append("    metricsCollectionFrq: ").append(toIndentedString(metricsCollectionFrq)).append("\n");
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

