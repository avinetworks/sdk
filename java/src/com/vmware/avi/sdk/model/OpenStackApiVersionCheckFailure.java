package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The OpenStackApiVersionCheckFailure is a POJO class extends AviRestResource that used for creating
 * OpenStackApiVersionCheckFailure.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OpenStackApiVersionCheckFailure  {
    @JsonProperty("cc_id")
    private String ccId = null;

    @JsonProperty("cc_name")
    private String ccName = null;

    @JsonProperty("error_string")
    private String errorString = null;



  /**
   * This is the getter method this will return the attribute value.
   * Cloud uuid.
   * Field introduced in 20.1.1.
   * @return ccId
   */
  public String getCcId() {
    return ccId;
  }

  /**
   * This is the setter method to the attribute.
   * Cloud uuid.
   * Field introduced in 20.1.1.
   * @param ccId set the ccId.
   */
  public void setCcId(String  ccId) {
    this.ccId = ccId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Cloud name.
   * Field introduced in 20.1.1.
   * @return ccName
   */
  public String getCcName() {
    return ccName;
  }

  /**
   * This is the setter method to the attribute.
   * Cloud name.
   * Field introduced in 20.1.1.
   * @param ccName set the ccName.
   */
  public void setCcName(String  ccName) {
    this.ccName = ccName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Failure reason containing expected api version and actual version.
   * Field introduced in 20.1.1.
   * @return errorString
   */
  public String getErrorString() {
    return errorString;
  }

  /**
   * This is the setter method to the attribute.
   * Failure reason containing expected api version and actual version.
   * Field introduced in 20.1.1.
   * @param errorString set the errorString.
   */
  public void setErrorString(String  errorString) {
    this.errorString = errorString;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  OpenStackApiVersionCheckFailure objOpenStackApiVersionCheckFailure = (OpenStackApiVersionCheckFailure) o;
  return   Objects.equals(this.ccId, objOpenStackApiVersionCheckFailure.ccId)&&
  Objects.equals(this.ccName, objOpenStackApiVersionCheckFailure.ccName)&&
  Objects.equals(this.errorString, objOpenStackApiVersionCheckFailure.errorString);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class OpenStackApiVersionCheckFailure {\n");
      sb.append("    ccId: ").append(toIndentedString(ccId)).append("\n");
        sb.append("    ccName: ").append(toIndentedString(ccName)).append("\n");
        sb.append("    errorString: ").append(toIndentedString(errorString)).append("\n");
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

