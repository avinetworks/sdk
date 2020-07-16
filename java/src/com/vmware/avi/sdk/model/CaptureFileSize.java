package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The CaptureFileSize is a POJO class extends AviRestResource that used for creating
 * CaptureFileSize.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CaptureFileSize  {
    @JsonProperty("absolute_size")
    private Integer absoluteSize = 0;

    @JsonProperty("percentage_size")
    private Integer percentageSize = 0;



  /**
   * This is the getter method this will return the attribute value.
   * Maximum size in mb.
   * Set 0 for avi default size.
   * Allowed values are 100-512000.
   * Special values are 0 - 'avi_default'.
   * Field introduced in 18.2.8.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return absoluteSize
   */
  public Integer getAbsoluteSize() {
    return absoluteSize;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum size in mb.
   * Set 0 for avi default size.
   * Allowed values are 100-512000.
   * Special values are 0 - 'avi_default'.
   * Field introduced in 18.2.8.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param absoluteSize set the absoluteSize.
   */
  public void setAbsoluteSize(Integer  absoluteSize) {
    this.absoluteSize = absoluteSize;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Limits capture to percentage of free disk space.
   * Set 0 for avi default size.
   * Allowed values are 0-75.
   * Field introduced in 18.2.8.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return percentageSize
   */
  public Integer getPercentageSize() {
    return percentageSize;
  }

  /**
   * This is the setter method to the attribute.
   * Limits capture to percentage of free disk space.
   * Set 0 for avi default size.
   * Allowed values are 0-75.
   * Field introduced in 18.2.8.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param percentageSize set the percentageSize.
   */
  public void setPercentageSize(Integer  percentageSize) {
    this.percentageSize = percentageSize;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  CaptureFileSize objCaptureFileSize = (CaptureFileSize) o;
  return   Objects.equals(this.absoluteSize, objCaptureFileSize.absoluteSize)&&
  Objects.equals(this.percentageSize, objCaptureFileSize.percentageSize);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class CaptureFileSize {\n");
      sb.append("    absoluteSize: ").append(toIndentedString(absoluteSize)).append("\n");
        sb.append("    percentageSize: ").append(toIndentedString(percentageSize)).append("\n");
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

