package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SeRuntimeCompressionProperties is a POJO class extends AviRestResource that used for creating
 * SeRuntimeCompressionProperties.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeRuntimeCompressionProperties  {
    @JsonProperty("max_low_rtt")
    private Integer maxLowRtt = 10;

    @JsonProperty("min_high_rtt")
    private Integer minHighRtt = 200;

    @JsonProperty("min_length")
    private Integer minLength = 128;

    @JsonProperty("mobile_str")
    private List<String> mobileStr = null;



  /**
   * This is the getter method this will return the attribute value.
   * If client rtt is higher than this threshold, enable normal compression on the response.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.
   * @return maxLowRtt
   */
  public Integer getMaxLowRtt() {
    return maxLowRtt;
  }

  /**
   * This is the setter method to the attribute.
   * If client rtt is higher than this threshold, enable normal compression on the response.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.
   * @param maxLowRtt set the maxLowRtt.
   */
  public void setMaxLowRtt(Integer  maxLowRtt) {
    this.maxLowRtt = maxLowRtt;
  }

  /**
   * This is the getter method this will return the attribute value.
   * If client rtt is higher than this threshold, enable aggressive compression on the response.
   * Default value when not specified in API or module is interpreted by Avi Controller as 200.
   * @return minHighRtt
   */
  public Integer getMinHighRtt() {
    return minHighRtt;
  }

  /**
   * This is the setter method to the attribute.
   * If client rtt is higher than this threshold, enable aggressive compression on the response.
   * Default value when not specified in API or module is interpreted by Avi Controller as 200.
   * @param minHighRtt set the minHighRtt.
   */
  public void setMinHighRtt(Integer  minHighRtt) {
    this.minHighRtt = minHighRtt;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Minimum response content length to enable compression.
   * Default value when not specified in API or module is interpreted by Avi Controller as 128.
   * @return minLength
   */
  public Integer getMinLength() {
    return minLength;
  }

  /**
   * This is the setter method to the attribute.
   * Minimum response content length to enable compression.
   * Default value when not specified in API or module is interpreted by Avi Controller as 128.
   * @param minLength set the minLength.
   */
  public void setMinLength(Integer  minLength) {
    this.minLength = minLength;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Values that identify mobile browsers in order to enable aggressive compression.
   * @return mobileStr
   */
  public List<String> getMobileStr() {
    return mobileStr;
  }

  /**
   * This is the setter method. this will set the mobileStr
   * Values that identify mobile browsers in order to enable aggressive compression.
   * @return mobileStr
   */
  public void setMobileStr(List<String>  mobileStr) {
    this.mobileStr = mobileStr;
  }

  /**
   * This is the setter method this will set the mobileStr
   * Values that identify mobile browsers in order to enable aggressive compression.
   * @return mobileStr
   */
  public SeRuntimeCompressionProperties addMobileStrItem(String mobileStrItem) {
    if (this.mobileStr == null) {
      this.mobileStr = new ArrayList<String>();
    }
    this.mobileStr.add(mobileStrItem);
    return this;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SeRuntimeCompressionProperties objSeRuntimeCompressionProperties = (SeRuntimeCompressionProperties) o;
  return   Objects.equals(this.minLength, objSeRuntimeCompressionProperties.minLength)&&
  Objects.equals(this.maxLowRtt, objSeRuntimeCompressionProperties.maxLowRtt)&&
  Objects.equals(this.minHighRtt, objSeRuntimeCompressionProperties.minHighRtt)&&
  Objects.equals(this.mobileStr, objSeRuntimeCompressionProperties.mobileStr);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SeRuntimeCompressionProperties {\n");
      sb.append("    maxLowRtt: ").append(toIndentedString(maxLowRtt)).append("\n");
        sb.append("    minHighRtt: ").append(toIndentedString(minHighRtt)).append("\n");
        sb.append("    minLength: ").append(toIndentedString(minLength)).append("\n");
        sb.append("    mobileStr: ").append(toIndentedString(mobileStr)).append("\n");
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

