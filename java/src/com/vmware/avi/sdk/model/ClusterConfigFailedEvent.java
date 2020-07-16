package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ClusterConfigFailedEvent is a POJO class extends AviRestResource that used for creating
 * ClusterConfigFailedEvent.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClusterConfigFailedEvent  {
    @JsonProperty("reason")
    private String reason = null;



  /**
   * This is the getter method this will return the attribute value.
   * Failure reason.
   * @return reason
   */
  public String getReason() {
    return reason;
  }

  /**
   * This is the setter method to the attribute.
   * Failure reason.
   * @param reason set the reason.
   */
  public void setReason(String  reason) {
    this.reason = reason;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ClusterConfigFailedEvent objClusterConfigFailedEvent = (ClusterConfigFailedEvent) o;
  return   Objects.equals(this.reason, objClusterConfigFailedEvent.reason);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ClusterConfigFailedEvent {\n");
      sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
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

