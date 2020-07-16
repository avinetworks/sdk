package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The RateLimiterProperties is a POJO class extends AviRestResource that used for creating
 * RateLimiterProperties.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RateLimiterProperties  {
    @JsonProperty("msf_num_stages")
    private Integer msfNumStages = 1;

    @JsonProperty("msf_stage_size")
    private Integer msfStageSize = 16384;



  /**
   * This is the getter method this will return the attribute value.
   * Number of stages in msf rate limiter.
   * Allowed values are 1-2.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.
   * @return msfNumStages
   */
  public Integer getMsfNumStages() {
    return msfNumStages;
  }

  /**
   * This is the setter method to the attribute.
   * Number of stages in msf rate limiter.
   * Allowed values are 1-2.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.
   * @param msfNumStages set the msfNumStages.
   */
  public void setMsfNumStages(Integer  msfNumStages) {
    this.msfNumStages = msfNumStages;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Each stage size in msf rate limiter.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 16384.
   * @return msfStageSize
   */
  public Integer getMsfStageSize() {
    return msfStageSize;
  }

  /**
   * This is the setter method to the attribute.
   * Each stage size in msf rate limiter.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 16384.
   * @param msfStageSize set the msfStageSize.
   */
  public void setMsfStageSize(Integer  msfStageSize) {
    this.msfStageSize = msfStageSize;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  RateLimiterProperties objRateLimiterProperties = (RateLimiterProperties) o;
  return   Objects.equals(this.msfNumStages, objRateLimiterProperties.msfNumStages)&&
  Objects.equals(this.msfStageSize, objRateLimiterProperties.msfStageSize);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class RateLimiterProperties {\n");
      sb.append("    msfNumStages: ").append(toIndentedString(msfNumStages)).append("\n");
        sb.append("    msfStageSize: ").append(toIndentedString(msfStageSize)).append("\n");
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

