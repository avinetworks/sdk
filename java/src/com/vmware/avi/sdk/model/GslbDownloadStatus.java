package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The GslbDownloadStatus is a POJO class extends AviRestResource that used for creating
 * GslbDownloadStatus.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GslbDownloadStatus  {
    @JsonProperty("last_changed_time")
    private TimeStamp lastChangedTime = null;

    @JsonProperty("state")
    private String state = "GSLB_DOWNLOAD_NONE";



  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.1.1.
   * @return lastChangedTime
   */
  public TimeStamp getLastChangedTime() {
    return lastChangedTime;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.1.1.
   * @param lastChangedTime set the lastChangedTime.
   */
  public void setLastChangedTime(TimeStamp lastChangedTime) {
    this.lastChangedTime = lastChangedTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * This field indicates the download state to a dns-vs(es) or a vs or a se depending on the usage context.
   * Enum options - GSLB_DOWNLOAD_NONE, GSLB_DOWNLOAD_DONE, GSLB_DOWNLOAD_PENDING, GSLB_DOWNLOAD_ERROR.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as GSLB_DOWNLOAD_NONE.
   * @return state
   */
  public String getState() {
    return state;
  }

  /**
   * This is the setter method to the attribute.
   * This field indicates the download state to a dns-vs(es) or a vs or a se depending on the usage context.
   * Enum options - GSLB_DOWNLOAD_NONE, GSLB_DOWNLOAD_DONE, GSLB_DOWNLOAD_PENDING, GSLB_DOWNLOAD_ERROR.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as GSLB_DOWNLOAD_NONE.
   * @param state set the state.
   */
  public void setState(String  state) {
    this.state = state;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  GslbDownloadStatus objGslbDownloadStatus = (GslbDownloadStatus) o;
  return   Objects.equals(this.state, objGslbDownloadStatus.state)&&
  Objects.equals(this.lastChangedTime, objGslbDownloadStatus.lastChangedTime);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class GslbDownloadStatus {\n");
      sb.append("    lastChangedTime: ").append(toIndentedString(lastChangedTime)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
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

