package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The PoolAnalyticsPolicy is a POJO class extends AviRestResource that used for creating
 * PoolAnalyticsPolicy.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PoolAnalyticsPolicy  {
    @JsonProperty("enable_realtime_metrics")
    private Boolean enableRealtimeMetrics = false;



  /**
   * This is the getter method this will return the attribute value.
   * Enable real time metrics for server and pool metrics eg.
   * L4_server.xxx, l7_server.xxx.
   * Field introduced in 18.1.5, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return enableRealtimeMetrics
   */
  public Boolean getEnableRealtimeMetrics() {
    return enableRealtimeMetrics;
  }

  /**
   * This is the setter method to the attribute.
   * Enable real time metrics for server and pool metrics eg.
   * L4_server.xxx, l7_server.xxx.
   * Field introduced in 18.1.5, 18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param enableRealtimeMetrics set the enableRealtimeMetrics.
   */
  public void setEnableRealtimeMetrics(Boolean  enableRealtimeMetrics) {
    this.enableRealtimeMetrics = enableRealtimeMetrics;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  PoolAnalyticsPolicy objPoolAnalyticsPolicy = (PoolAnalyticsPolicy) o;
  return   Objects.equals(this.enableRealtimeMetrics, objPoolAnalyticsPolicy.enableRealtimeMetrics);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class PoolAnalyticsPolicy {\n");
      sb.append("    enableRealtimeMetrics: ").append(toIndentedString(enableRealtimeMetrics)).append("\n");
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

