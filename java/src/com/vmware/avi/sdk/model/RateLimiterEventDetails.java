package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The RateLimiterEventDetails is a POJO class extends AviRestResource that used for creating
 * RateLimiterEventDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RateLimiterEventDetails  {
    @JsonProperty("error_message")
    private String errorMessage = null;

    @JsonProperty("rl_resource_name")
    private String rlResourceName = null;

    @JsonProperty("rl_resource_type")
    private String rlResourceType = null;

    @JsonProperty("status")
    private String status = null;



  /**
   * This is the getter method this will return the attribute value.
   * Rate limiter error message.
   * Field introduced in 20.1.1.
   * @return errorMessage
   */
  public String getErrorMessage() {
    return errorMessage;
  }

  /**
   * This is the setter method to the attribute.
   * Rate limiter error message.
   * Field introduced in 20.1.1.
   * @param errorMessage set the errorMessage.
   */
  public void setErrorMessage(String  errorMessage) {
    this.errorMessage = errorMessage;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the rate limiter.
   * Field introduced in 20.1.1.
   * @return rlResourceName
   */
  public String getRlResourceName() {
    return rlResourceName;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the rate limiter.
   * Field introduced in 20.1.1.
   * @param rlResourceName set the rlResourceName.
   */
  public void setRlResourceName(String  rlResourceName) {
    this.rlResourceName = rlResourceName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Rate limiter type.
   * Field introduced in 20.1.1.
   * @return rlResourceType
   */
  public String getRlResourceType() {
    return rlResourceType;
  }

  /**
   * This is the setter method to the attribute.
   * Rate limiter type.
   * Field introduced in 20.1.1.
   * @param rlResourceType set the rlResourceType.
   */
  public void setRlResourceType(String  rlResourceType) {
    this.rlResourceType = rlResourceType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Status.
   * Field introduced in 20.1.1.
   * @return status
   */
  public String getStatus() {
    return status;
  }

  /**
   * This is the setter method to the attribute.
   * Status.
   * Field introduced in 20.1.1.
   * @param status set the status.
   */
  public void setStatus(String  status) {
    this.status = status;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  RateLimiterEventDetails objRateLimiterEventDetails = (RateLimiterEventDetails) o;
  return   Objects.equals(this.status, objRateLimiterEventDetails.status)&&
  Objects.equals(this.rlResourceType, objRateLimiterEventDetails.rlResourceType)&&
  Objects.equals(this.rlResourceName, objRateLimiterEventDetails.rlResourceName)&&
  Objects.equals(this.errorMessage, objRateLimiterEventDetails.errorMessage);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class RateLimiterEventDetails {\n");
      sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
        sb.append("    rlResourceName: ").append(toIndentedString(rlResourceName)).append("\n");
        sb.append("    rlResourceType: ").append(toIndentedString(rlResourceType)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

