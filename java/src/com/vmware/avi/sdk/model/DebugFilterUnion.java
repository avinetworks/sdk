package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DebugFilterUnion is a POJO class extends AviRestResource that used for creating
 * DebugFilterUnion.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DebugFilterUnion  {
    @JsonProperty("alert_debug_filter")
    private AlertMgrDebugFilter alertDebugFilter = null;

    @JsonProperty("autoscale_mgr_debug_filter")
    private AutoScaleMgrDebugFilter autoscaleMgrDebugFilter = null;

    @JsonProperty("cloud_connector_debug_filter")
    private CloudConnectorDebugFilter cloudConnectorDebugFilter = null;

    @JsonProperty("hs_debug_filter")
    private HSMgrDebugFilter hsDebugFilter = null;

    @JsonProperty("mesos_metrics_debug_filter")
    private MesosMetricsDebugFilter mesosMetricsDebugFilter = null;

    @JsonProperty("metrics_debug_filter")
    private MetricsMgrDebugFilter metricsDebugFilter = null;

    @JsonProperty("metricsapi_srv_debug_filter")
    private MetricsApiSrvDebugFilter metricsapiSrvDebugFilter = null;

    @JsonProperty("se_mgr_debug_filter")
    private SeMgrDebugFilter seMgrDebugFilter = null;

    @JsonProperty("se_rpc_proxy_filter")
    private SeRpcProxyDebugFilter seRpcProxyFilter = null;

    @JsonProperty("securitymgr_debug_filter")
    private SecurityMgrDebugFilter securitymgrDebugFilter = null;

    @JsonProperty("state_cache_mgr_debug_filter")
    private StateCacheMgrDebugFilter stateCacheMgrDebugFilter = null;

    @JsonProperty("type")
    private String type = null;

    @JsonProperty("vs_debug_filter")
    private VsDebugFilter vsDebugFilter = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property alert_debug_filter of obj type debugfilterunion field type str  type ref.
   * @return alertDebugFilter
   */
  public AlertMgrDebugFilter getAlertDebugFilter() {
    return alertDebugFilter;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property alert_debug_filter of obj type debugfilterunion field type str  type ref.
   * @param alertDebugFilter set the alertDebugFilter.
   */
  public void setAlertDebugFilter(AlertMgrDebugFilter alertDebugFilter) {
    this.alertDebugFilter = alertDebugFilter;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property autoscale_mgr_debug_filter of obj type debugfilterunion field type str  type ref.
   * @return autoscaleMgrDebugFilter
   */
  public AutoScaleMgrDebugFilter getAutoscaleMgrDebugFilter() {
    return autoscaleMgrDebugFilter;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property autoscale_mgr_debug_filter of obj type debugfilterunion field type str  type ref.
   * @param autoscaleMgrDebugFilter set the autoscaleMgrDebugFilter.
   */
  public void setAutoscaleMgrDebugFilter(AutoScaleMgrDebugFilter autoscaleMgrDebugFilter) {
    this.autoscaleMgrDebugFilter = autoscaleMgrDebugFilter;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cloud_connector_debug_filter of obj type debugfilterunion field type str  type ref.
   * @return cloudConnectorDebugFilter
   */
  public CloudConnectorDebugFilter getCloudConnectorDebugFilter() {
    return cloudConnectorDebugFilter;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cloud_connector_debug_filter of obj type debugfilterunion field type str  type ref.
   * @param cloudConnectorDebugFilter set the cloudConnectorDebugFilter.
   */
  public void setCloudConnectorDebugFilter(CloudConnectorDebugFilter cloudConnectorDebugFilter) {
    this.cloudConnectorDebugFilter = cloudConnectorDebugFilter;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property hs_debug_filter of obj type debugfilterunion field type str  type ref.
   * @return hsDebugFilter
   */
  public HSMgrDebugFilter getHsDebugFilter() {
    return hsDebugFilter;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property hs_debug_filter of obj type debugfilterunion field type str  type ref.
   * @param hsDebugFilter set the hsDebugFilter.
   */
  public void setHsDebugFilter(HSMgrDebugFilter hsDebugFilter) {
    this.hsDebugFilter = hsDebugFilter;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property mesos_metrics_debug_filter of obj type debugfilterunion field type str  type ref.
   * @return mesosMetricsDebugFilter
   */
  public MesosMetricsDebugFilter getMesosMetricsDebugFilter() {
    return mesosMetricsDebugFilter;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property mesos_metrics_debug_filter of obj type debugfilterunion field type str  type ref.
   * @param mesosMetricsDebugFilter set the mesosMetricsDebugFilter.
   */
  public void setMesosMetricsDebugFilter(MesosMetricsDebugFilter mesosMetricsDebugFilter) {
    this.mesosMetricsDebugFilter = mesosMetricsDebugFilter;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property metrics_debug_filter of obj type debugfilterunion field type str  type ref.
   * @return metricsDebugFilter
   */
  public MetricsMgrDebugFilter getMetricsDebugFilter() {
    return metricsDebugFilter;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property metrics_debug_filter of obj type debugfilterunion field type str  type ref.
   * @param metricsDebugFilter set the metricsDebugFilter.
   */
  public void setMetricsDebugFilter(MetricsMgrDebugFilter metricsDebugFilter) {
    this.metricsDebugFilter = metricsDebugFilter;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Add metricsapi server filter.
   * Field introduced in 18.2.3.
   * @return metricsapiSrvDebugFilter
   */
  public MetricsApiSrvDebugFilter getMetricsapiSrvDebugFilter() {
    return metricsapiSrvDebugFilter;
  }

  /**
   * This is the setter method to the attribute.
   * Add metricsapi server filter.
   * Field introduced in 18.2.3.
   * @param metricsapiSrvDebugFilter set the metricsapiSrvDebugFilter.
   */
  public void setMetricsapiSrvDebugFilter(MetricsApiSrvDebugFilter metricsapiSrvDebugFilter) {
    this.metricsapiSrvDebugFilter = metricsapiSrvDebugFilter;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_mgr_debug_filter of obj type debugfilterunion field type str  type ref.
   * @return seMgrDebugFilter
   */
  public SeMgrDebugFilter getSeMgrDebugFilter() {
    return seMgrDebugFilter;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_mgr_debug_filter of obj type debugfilterunion field type str  type ref.
   * @param seMgrDebugFilter set the seMgrDebugFilter.
   */
  public void setSeMgrDebugFilter(SeMgrDebugFilter seMgrDebugFilter) {
    this.seMgrDebugFilter = seMgrDebugFilter;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Add se rpc proxy filter.
   * Field introduced in 18.1.5, 18.2.1.
   * @return seRpcProxyFilter
   */
  public SeRpcProxyDebugFilter getSeRpcProxyFilter() {
    return seRpcProxyFilter;
  }

  /**
   * This is the setter method to the attribute.
   * Add se rpc proxy filter.
   * Field introduced in 18.1.5, 18.2.1.
   * @param seRpcProxyFilter set the seRpcProxyFilter.
   */
  public void setSeRpcProxyFilter(SeRpcProxyDebugFilter seRpcProxyFilter) {
    this.seRpcProxyFilter = seRpcProxyFilter;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Add metricsapi server filter.
   * Field introduced in 18.2.6.
   * @return securitymgrDebugFilter
   */
  public SecurityMgrDebugFilter getSecuritymgrDebugFilter() {
    return securitymgrDebugFilter;
  }

  /**
   * This is the setter method to the attribute.
   * Add metricsapi server filter.
   * Field introduced in 18.2.6.
   * @param securitymgrDebugFilter set the securitymgrDebugFilter.
   */
  public void setSecuritymgrDebugFilter(SecurityMgrDebugFilter securitymgrDebugFilter) {
    this.securitymgrDebugFilter = securitymgrDebugFilter;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property state_cache_mgr_debug_filter of obj type debugfilterunion field type str  type ref.
   * @return stateCacheMgrDebugFilter
   */
  public StateCacheMgrDebugFilter getStateCacheMgrDebugFilter() {
    return stateCacheMgrDebugFilter;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property state_cache_mgr_debug_filter of obj type debugfilterunion field type str  type ref.
   * @param stateCacheMgrDebugFilter set the stateCacheMgrDebugFilter.
   */
  public void setStateCacheMgrDebugFilter(StateCacheMgrDebugFilter stateCacheMgrDebugFilter) {
    this.stateCacheMgrDebugFilter = stateCacheMgrDebugFilter;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - TASK_QUEUE_DEBUG, RPC_INFRA_DEBUG, JOB_MGR_DEBUG, TRANSACTION_DEBUG, SE_AGENT_DEBUG, SE_AGENT_METRICS_DEBUG, VIRTUALSERVICE_DEBUG,
   * RES_MGR_DEBUG, SE_MGR_DEBUG, VI_MGR_DEBUG, METRICS_MANAGER_DEBUG, METRICS_MGR_DEBUG, EVENT_API_DEBUG, HS_MGR_DEBUG, ALERT_MGR_DEBUG,
   * AUTOSCALE_MGR_DEBUG, APIC_AGENT_DEBUG, REDIS_INFRA_DEBUG, CLOUD_CONNECTOR_DEBUG, MESOS_METRICS_DEBUG...
   * @return type
   */
  public String getType() {
    return type;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - TASK_QUEUE_DEBUG, RPC_INFRA_DEBUG, JOB_MGR_DEBUG, TRANSACTION_DEBUG, SE_AGENT_DEBUG, SE_AGENT_METRICS_DEBUG, VIRTUALSERVICE_DEBUG,
   * RES_MGR_DEBUG, SE_MGR_DEBUG, VI_MGR_DEBUG, METRICS_MANAGER_DEBUG, METRICS_MGR_DEBUG, EVENT_API_DEBUG, HS_MGR_DEBUG, ALERT_MGR_DEBUG,
   * AUTOSCALE_MGR_DEBUG, APIC_AGENT_DEBUG, REDIS_INFRA_DEBUG, CLOUD_CONNECTOR_DEBUG, MESOS_METRICS_DEBUG...
   * @param type set the type.
   */
  public void setType(String  type) {
    this.type = type;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vs_debug_filter of obj type debugfilterunion field type str  type ref.
   * @return vsDebugFilter
   */
  public VsDebugFilter getVsDebugFilter() {
    return vsDebugFilter;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vs_debug_filter of obj type debugfilterunion field type str  type ref.
   * @param vsDebugFilter set the vsDebugFilter.
   */
  public void setVsDebugFilter(VsDebugFilter vsDebugFilter) {
    this.vsDebugFilter = vsDebugFilter;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  DebugFilterUnion objDebugFilterUnion = (DebugFilterUnion) o;
  return   Objects.equals(this.mesosMetricsDebugFilter, objDebugFilterUnion.mesosMetricsDebugFilter)&&
  Objects.equals(this.cloudConnectorDebugFilter, objDebugFilterUnion.cloudConnectorDebugFilter)&&
  Objects.equals(this.seRpcProxyFilter, objDebugFilterUnion.seRpcProxyFilter)&&
  Objects.equals(this.securitymgrDebugFilter, objDebugFilterUnion.securitymgrDebugFilter)&&
  Objects.equals(this.metricsDebugFilter, objDebugFilterUnion.metricsDebugFilter)&&
  Objects.equals(this.alertDebugFilter, objDebugFilterUnion.alertDebugFilter)&&
  Objects.equals(this.seMgrDebugFilter, objDebugFilterUnion.seMgrDebugFilter)&&
  Objects.equals(this.stateCacheMgrDebugFilter, objDebugFilterUnion.stateCacheMgrDebugFilter)&&
  Objects.equals(this.metricsapiSrvDebugFilter, objDebugFilterUnion.metricsapiSrvDebugFilter)&&
  Objects.equals(this.autoscaleMgrDebugFilter, objDebugFilterUnion.autoscaleMgrDebugFilter)&&
  Objects.equals(this.type, objDebugFilterUnion.type)&&
  Objects.equals(this.vsDebugFilter, objDebugFilterUnion.vsDebugFilter)&&
  Objects.equals(this.hsDebugFilter, objDebugFilterUnion.hsDebugFilter);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DebugFilterUnion {\n");
      sb.append("    alertDebugFilter: ").append(toIndentedString(alertDebugFilter)).append("\n");
        sb.append("    autoscaleMgrDebugFilter: ").append(toIndentedString(autoscaleMgrDebugFilter)).append("\n");
        sb.append("    cloudConnectorDebugFilter: ").append(toIndentedString(cloudConnectorDebugFilter)).append("\n");
        sb.append("    hsDebugFilter: ").append(toIndentedString(hsDebugFilter)).append("\n");
        sb.append("    mesosMetricsDebugFilter: ").append(toIndentedString(mesosMetricsDebugFilter)).append("\n");
        sb.append("    metricsDebugFilter: ").append(toIndentedString(metricsDebugFilter)).append("\n");
        sb.append("    metricsapiSrvDebugFilter: ").append(toIndentedString(metricsapiSrvDebugFilter)).append("\n");
        sb.append("    seMgrDebugFilter: ").append(toIndentedString(seMgrDebugFilter)).append("\n");
        sb.append("    seRpcProxyFilter: ").append(toIndentedString(seRpcProxyFilter)).append("\n");
        sb.append("    securitymgrDebugFilter: ").append(toIndentedString(securitymgrDebugFilter)).append("\n");
        sb.append("    stateCacheMgrDebugFilter: ").append(toIndentedString(stateCacheMgrDebugFilter)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    vsDebugFilter: ").append(toIndentedString(vsDebugFilter)).append("\n");
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

