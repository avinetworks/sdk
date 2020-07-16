package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The AnalyticsPolicy is a POJO class extends AviRestResource that used for creating
 * AnalyticsPolicy.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnalyticsPolicy  {
    @JsonProperty("all_headers")
    private Boolean allHeaders = false;

    @JsonProperty("client_insights")
    private String clientInsights = "NO_INSIGHTS";

    @JsonProperty("client_insights_sampling")
    private ClientInsightsSampling clientInsightsSampling = null;

    @JsonProperty("client_log_filters")
    private List<ClientLogFilter> clientLogFilters = null;

    @JsonProperty("enabled")
    private Boolean enabled = null;

    @JsonProperty("full_client_logs")
    private FullClientLogs fullClientLogs = null;

    @JsonProperty("metrics_realtime_update")
    private MetricsRealTimeUpdate metricsRealtimeUpdate = null;

    @JsonProperty("significant_log_throttle")
    private Integer significantLogThrottle = 10;

    @JsonProperty("udf_log_throttle")
    private Integer udfLogThrottle = 10;



  /**
   * This is the getter method this will return the attribute value.
   * Log all headers.
   * Field introduced in 18.1.4, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return allHeaders
   */
  public Boolean getAllHeaders() {
    return allHeaders;
  }

  /**
   * This is the setter method to the attribute.
   * Log all headers.
   * Field introduced in 18.1.4, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param allHeaders set the allHeaders.
   */
  public void setAllHeaders(Boolean  allHeaders) {
    this.allHeaders = allHeaders;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Gain insights from sampled client to server http requests and responses.
   * Enum options - NO_INSIGHTS, PASSIVE, ACTIVE.
   * Default value when not specified in API or module is interpreted by Avi Controller as NO_INSIGHTS.
   * @return clientInsights
   */
  public String getClientInsights() {
    return clientInsights;
  }

  /**
   * This is the setter method to the attribute.
   * Gain insights from sampled client to server http requests and responses.
   * Enum options - NO_INSIGHTS, PASSIVE, ACTIVE.
   * Default value when not specified in API or module is interpreted by Avi Controller as NO_INSIGHTS.
   * @param clientInsights set the clientInsights.
   */
  public void setClientInsights(String  clientInsights) {
    this.clientInsights = clientInsights;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property client_insights_sampling of obj type analyticspolicy field type str  type ref.
   * @return clientInsightsSampling
   */
  public ClientInsightsSampling getClientInsightsSampling() {
    return clientInsightsSampling;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property client_insights_sampling of obj type analyticspolicy field type str  type ref.
   * @param clientInsightsSampling set the clientInsightsSampling.
   */
  public void setClientInsightsSampling(ClientInsightsSampling clientInsightsSampling) {
    this.clientInsightsSampling = clientInsightsSampling;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property client_log_filters of obj type analyticspolicy field type str  type array.
   * @return clientLogFilters
   */
  public List<ClientLogFilter> getClientLogFilters() {
    return clientLogFilters;
  }

  /**
   * This is the setter method. this will set the clientLogFilters
   * Placeholder for description of property client_log_filters of obj type analyticspolicy field type str  type array.
   * @return clientLogFilters
   */
  public void setClientLogFilters(List<ClientLogFilter>  clientLogFilters) {
    this.clientLogFilters = clientLogFilters;
  }

  /**
   * This is the setter method this will set the clientLogFilters
   * Placeholder for description of property client_log_filters of obj type analyticspolicy field type str  type array.
   * @return clientLogFilters
   */
  public AnalyticsPolicy addClientLogFiltersItem(ClientLogFilter clientLogFiltersItem) {
    if (this.clientLogFilters == null) {
      this.clientLogFilters = new ArrayList<ClientLogFilter>();
    }
    this.clientLogFilters.add(clientLogFiltersItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * [deprecated] disable analytics on this virtualservice.
   * This will disable the collection of both metrics and logs.
   * Please use following fields in analytcsprofile to control this behavior instead.
   * Disable_vs_analytics (for virtualservices metrics), disable_server_analytics (for pool metrics) and client_log_config (for logs).
   * Field deprecated in 18.2.1.
   * Field introduced in 17.2.4.
   * @return enabled
   */
  public Boolean getEnabled() {
    return enabled;
  }

  /**
   * This is the setter method to the attribute.
   * [deprecated] disable analytics on this virtualservice.
   * This will disable the collection of both metrics and logs.
   * Please use following fields in analytcsprofile to control this behavior instead.
   * Disable_vs_analytics (for virtualservices metrics), disable_server_analytics (for pool metrics) and client_log_config (for logs).
   * Field deprecated in 18.2.1.
   * Field introduced in 17.2.4.
   * @param enabled set the enabled.
   */
  public void setEnabled(Boolean  enabled) {
    this.enabled = enabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property full_client_logs of obj type analyticspolicy field type str  type ref.
   * @return fullClientLogs
   */
  public FullClientLogs getFullClientLogs() {
    return fullClientLogs;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property full_client_logs of obj type analyticspolicy field type str  type ref.
   * @param fullClientLogs set the fullClientLogs.
   */
  public void setFullClientLogs(FullClientLogs fullClientLogs) {
    this.fullClientLogs = fullClientLogs;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Settings to turn on realtime metrics and set duration for realtime updates.
   * @return metricsRealtimeUpdate
   */
  public MetricsRealTimeUpdate getMetricsRealtimeUpdate() {
    return metricsRealtimeUpdate;
  }

  /**
   * This is the setter method to the attribute.
   * Settings to turn on realtime metrics and set duration for realtime updates.
   * @param metricsRealtimeUpdate set the metricsRealtimeUpdate.
   */
  public void setMetricsRealtimeUpdate(MetricsRealTimeUpdate metricsRealtimeUpdate) {
    this.metricsRealtimeUpdate = metricsRealtimeUpdate;
  }

  /**
   * This is the getter method this will return the attribute value.
   * This setting limits the number of significant logs generated per second for this vs on each se.
   * Default is 10 logs per second.
   * Set it to zero (0) to disable throttling.
   * Field introduced in 17.1.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.
   * @return significantLogThrottle
   */
  public Integer getSignificantLogThrottle() {
    return significantLogThrottle;
  }

  /**
   * This is the setter method to the attribute.
   * This setting limits the number of significant logs generated per second for this vs on each se.
   * Default is 10 logs per second.
   * Set it to zero (0) to disable throttling.
   * Field introduced in 17.1.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.
   * @param significantLogThrottle set the significantLogThrottle.
   */
  public void setSignificantLogThrottle(Integer  significantLogThrottle) {
    this.significantLogThrottle = significantLogThrottle;
  }

  /**
   * This is the getter method this will return the attribute value.
   * This setting limits the total number of udf logs generated per second for this vs on each se.
   * Udf logs are generated due to the configured client log filters or the rules with logging enabled.
   * Default is 10 logs per second.
   * Set it to zero (0) to disable throttling.
   * Field introduced in 17.1.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.
   * @return udfLogThrottle
   */
  public Integer getUdfLogThrottle() {
    return udfLogThrottle;
  }

  /**
   * This is the setter method to the attribute.
   * This setting limits the total number of udf logs generated per second for this vs on each se.
   * Udf logs are generated due to the configured client log filters or the rules with logging enabled.
   * Default is 10 logs per second.
   * Set it to zero (0) to disable throttling.
   * Field introduced in 17.1.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.
   * @param udfLogThrottle set the udfLogThrottle.
   */
  public void setUdfLogThrottle(Integer  udfLogThrottle) {
    this.udfLogThrottle = udfLogThrottle;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  AnalyticsPolicy objAnalyticsPolicy = (AnalyticsPolicy) o;
  return   Objects.equals(this.udfLogThrottle, objAnalyticsPolicy.udfLogThrottle)&&
  Objects.equals(this.enabled, objAnalyticsPolicy.enabled)&&
  Objects.equals(this.clientInsightsSampling, objAnalyticsPolicy.clientInsightsSampling)&&
  Objects.equals(this.fullClientLogs, objAnalyticsPolicy.fullClientLogs)&&
  Objects.equals(this.clientLogFilters, objAnalyticsPolicy.clientLogFilters)&&
  Objects.equals(this.metricsRealtimeUpdate, objAnalyticsPolicy.metricsRealtimeUpdate)&&
  Objects.equals(this.significantLogThrottle, objAnalyticsPolicy.significantLogThrottle)&&
  Objects.equals(this.clientInsights, objAnalyticsPolicy.clientInsights)&&
  Objects.equals(this.allHeaders, objAnalyticsPolicy.allHeaders);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class AnalyticsPolicy {\n");
      sb.append("    allHeaders: ").append(toIndentedString(allHeaders)).append("\n");
        sb.append("    clientInsights: ").append(toIndentedString(clientInsights)).append("\n");
        sb.append("    clientInsightsSampling: ").append(toIndentedString(clientInsightsSampling)).append("\n");
        sb.append("    clientLogFilters: ").append(toIndentedString(clientLogFilters)).append("\n");
        sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
        sb.append("    fullClientLogs: ").append(toIndentedString(fullClientLogs)).append("\n");
        sb.append("    metricsRealtimeUpdate: ").append(toIndentedString(metricsRealtimeUpdate)).append("\n");
        sb.append("    significantLogThrottle: ").append(toIndentedString(significantLogThrottle)).append("\n");
        sb.append("    udfLogThrottle: ").append(toIndentedString(udfLogThrottle)).append("\n");
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

