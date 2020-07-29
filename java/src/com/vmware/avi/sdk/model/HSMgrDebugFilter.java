package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The HSMgrDebugFilter is a POJO class extends AviRestResource that used for creating
 * HSMgrDebugFilter.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HSMgrDebugFilter  {
    @JsonProperty("entity")
    private String entity = null;

    @JsonProperty("metric_entity")
    private String metricEntity = null;

    @JsonProperty("period")
    private Integer period = null;

    @JsonProperty("pool")
    private String pool = null;

    @JsonProperty("server")
    private String server = null;

    @JsonProperty("skip_hs_db_writes")
    private Boolean skipHsDbWrites = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property entity of obj type hsmgrdebugfilter field type str  type string.
   * @return entity
   */
  public String getEntity() {
    return entity;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property entity of obj type hsmgrdebugfilter field type str  type string.
   * @param entity set the entity.
   */
  public void setEntity(String  entity) {
    this.entity = entity;
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
   * Placeholder for description of property period of obj type hsmgrdebugfilter field type str  type integer.
   * @return period
   */
  public Integer getPeriod() {
    return period;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property period of obj type hsmgrdebugfilter field type str  type integer.
   * @param period set the period.
   */
  public void setPeriod(Integer  period) {
    this.period = period;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property pool of obj type hsmgrdebugfilter field type str  type string.
   * @return pool
   */
  public String getPool() {
    return pool;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property pool of obj type hsmgrdebugfilter field type str  type string.
   * @param pool set the pool.
   */
  public void setPool(String  pool) {
    this.pool = pool;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property server of obj type hsmgrdebugfilter field type str  type string.
   * @return server
   */
  public String getServer() {
    return server;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property server of obj type hsmgrdebugfilter field type str  type string.
   * @param server set the server.
   */
  public void setServer(String  server) {
    this.server = server;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property skip_hs_db_writes of obj type hsmgrdebugfilter field type str  type boolean.
   * @return skipHsDbWrites
   */
  public Boolean getSkipHsDbWrites() {
    return skipHsDbWrites;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property skip_hs_db_writes of obj type hsmgrdebugfilter field type str  type boolean.
   * @param skipHsDbWrites set the skipHsDbWrites.
   */
  public void setSkipHsDbWrites(Boolean  skipHsDbWrites) {
    this.skipHsDbWrites = skipHsDbWrites;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  HSMgrDebugFilter objHSMgrDebugFilter = (HSMgrDebugFilter) o;
  return   Objects.equals(this.metricEntity, objHSMgrDebugFilter.metricEntity)&&
  Objects.equals(this.entity, objHSMgrDebugFilter.entity)&&
  Objects.equals(this.pool, objHSMgrDebugFilter.pool)&&
  Objects.equals(this.server, objHSMgrDebugFilter.server)&&
  Objects.equals(this.period, objHSMgrDebugFilter.period)&&
  Objects.equals(this.skipHsDbWrites, objHSMgrDebugFilter.skipHsDbWrites);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class HSMgrDebugFilter {\n");
      sb.append("    entity: ").append(toIndentedString(entity)).append("\n");
        sb.append("    metricEntity: ").append(toIndentedString(metricEntity)).append("\n");
        sb.append("    period: ").append(toIndentedString(period)).append("\n");
        sb.append("    pool: ").append(toIndentedString(pool)).append("\n");
        sb.append("    server: ").append(toIndentedString(server)).append("\n");
        sb.append("    skipHsDbWrites: ").append(toIndentedString(skipHsDbWrites)).append("\n");
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

