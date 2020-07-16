package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DebugController is a POJO class extends AviRestResource that used for creating
 * DebugController.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DebugController extends AviRestResource  {
    @JsonProperty("filters")
    private DebugFilterUnion filters = null;

    @JsonProperty("log_level")
    private String logLevel = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("sub_module")
    private String subModule = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("trace_level")
    private String traceLevel = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property filters of obj type debugcontroller field type str  type ref.
   * @return filters
   */
  public DebugFilterUnion getFilters() {
    return filters;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property filters of obj type debugcontroller field type str  type ref.
   * @param filters set the filters.
   */
  public void setFilters(DebugFilterUnion filters) {
    this.filters = filters;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - LOG_LEVEL_DISABLED, LOG_LEVEL_INFO, LOG_LEVEL_WARNING, LOG_LEVEL_ERROR.
   * @return logLevel
   */
  public String getLogLevel() {
    return logLevel;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - LOG_LEVEL_DISABLED, LOG_LEVEL_INFO, LOG_LEVEL_WARNING, LOG_LEVEL_ERROR.
   * @param logLevel set the logLevel.
   */
  public void setLogLevel(String  logLevel) {
    this.logLevel = logLevel;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the object.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the object.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - TASK_QUEUE_DEBUG, RPC_INFRA_DEBUG, JOB_MGR_DEBUG, TRANSACTION_DEBUG, SE_AGENT_DEBUG, SE_AGENT_METRICS_DEBUG, VIRTUALSERVICE_DEBUG,
   * RES_MGR_DEBUG, SE_MGR_DEBUG, VI_MGR_DEBUG, METRICS_MANAGER_DEBUG, METRICS_MGR_DEBUG, EVENT_API_DEBUG, HS_MGR_DEBUG, ALERT_MGR_DEBUG,
   * AUTOSCALE_MGR_DEBUG, APIC_AGENT_DEBUG, REDIS_INFRA_DEBUG, CLOUD_CONNECTOR_DEBUG, MESOS_METRICS_DEBUG...
   * @return subModule
   */
  public String getSubModule() {
    return subModule;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - TASK_QUEUE_DEBUG, RPC_INFRA_DEBUG, JOB_MGR_DEBUG, TRANSACTION_DEBUG, SE_AGENT_DEBUG, SE_AGENT_METRICS_DEBUG, VIRTUALSERVICE_DEBUG,
   * RES_MGR_DEBUG, SE_MGR_DEBUG, VI_MGR_DEBUG, METRICS_MANAGER_DEBUG, METRICS_MGR_DEBUG, EVENT_API_DEBUG, HS_MGR_DEBUG, ALERT_MGR_DEBUG,
   * AUTOSCALE_MGR_DEBUG, APIC_AGENT_DEBUG, REDIS_INFRA_DEBUG, CLOUD_CONNECTOR_DEBUG, MESOS_METRICS_DEBUG...
   * @param subModule set the subModule.
   */
  public void setSubModule(String  subModule) {
    this.subModule = subModule;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type tenant.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type tenant.
   * @param tenantRef set the tenantRef.
   */
  public void setTenantRef(String  tenantRef) {
    this.tenantRef = tenantRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - TRACE_LEVEL_DISABLED, TRACE_LEVEL_ERROR, TRACE_LEVEL_DEBUG, TRACE_LEVEL_DEBUG_DETAIL.
   * @return traceLevel
   */
  public String getTraceLevel() {
    return traceLevel;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - TRACE_LEVEL_DISABLED, TRACE_LEVEL_ERROR, TRACE_LEVEL_DEBUG, TRACE_LEVEL_DEBUG_DETAIL.
   * @param traceLevel set the traceLevel.
   */
  public void setTraceLevel(String  traceLevel) {
    this.traceLevel = traceLevel;
  }
/**
   * This is the getter method this will return the attribute value.
   * Avi controller URL of the object.
   * @return url
   */
  public String getUrl() {
    return url;
  }

  /**
   * This is the setter method. this will set the url
   * Avi controller URL of the object.
   * @return url
   */
  public void setUrl(String  url) {
    this.url = url;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of the object.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of the object.
   * @param uuid set the uuid.
   */
  public void setUuid(String  uuid) {
    this.uuid = uuid;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  DebugController objDebugController = (DebugController) o;
  return   Objects.equals(this.subModule, objDebugController.subModule)&&
  Objects.equals(this.logLevel, objDebugController.logLevel)&&
  Objects.equals(this.uuid, objDebugController.uuid)&&
  Objects.equals(this.filters, objDebugController.filters)&&
  Objects.equals(this.traceLevel, objDebugController.traceLevel)&&
  Objects.equals(this.tenantRef, objDebugController.tenantRef)&&
  Objects.equals(this.name, objDebugController.name);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DebugController {\n");
      sb.append("    filters: ").append(toIndentedString(filters)).append("\n");
        sb.append("    logLevel: ").append(toIndentedString(logLevel)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    subModule: ").append(toIndentedString(subModule)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
        sb.append("    traceLevel: ").append(toIndentedString(traceLevel)).append("\n");
            sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
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

