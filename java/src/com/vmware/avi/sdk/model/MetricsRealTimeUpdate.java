package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The MetricsRealTimeUpdate is a POJO class extends AviRestResource that used for creating
 * MetricsRealTimeUpdate.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetricsRealTimeUpdate  {
    @JsonProperty("duration")
    private Integer duration = 30;

    @JsonProperty("enabled")
    private Boolean enabled = false;



  /**
   * This is the getter method this will return the attribute value.
   * Real time metrics collection duration in minutes.
   * 0 for infinite.
   * Special values are 0 - 'infinite'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 30.
   * @return duration
   */
  public Integer getDuration() {
    return duration;
  }

  /**
   * This is the setter method to the attribute.
   * Real time metrics collection duration in minutes.
   * 0 for infinite.
   * Special values are 0 - 'infinite'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 30.
   * @param duration set the duration.
   */
  public void setDuration(Integer  duration) {
    this.duration = duration;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enables real time metrics collection.
   * When disabled, 6 hour view is the most granular the system will track.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return enabled
   */
  public Boolean getEnabled() {
    return enabled;
  }

  /**
   * This is the setter method to the attribute.
   * Enables real time metrics collection.
   * When disabled, 6 hour view is the most granular the system will track.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param enabled set the enabled.
   */
  public void setEnabled(Boolean  enabled) {
    this.enabled = enabled;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  MetricsRealTimeUpdate objMetricsRealTimeUpdate = (MetricsRealTimeUpdate) o;
  return   Objects.equals(this.duration, objMetricsRealTimeUpdate.duration)&&
  Objects.equals(this.enabled, objMetricsRealTimeUpdate.enabled);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class MetricsRealTimeUpdate {\n");
      sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
        sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
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

