package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The IPReputationServiceStatus is a POJO class extends AviRestResource that used for creating
 * IPReputationServiceStatus.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IPReputationServiceStatus  {
    @JsonProperty("error")
    private String error = null;

    @JsonProperty("last_successful_update_check")
    private TimeStamp lastSuccessfulUpdateCheck = null;



  /**
   * This is the getter method this will return the attribute value.
   * If the last attempted update failed, this is a more detailed error message.
   * Field introduced in 20.1.1.
   * @return error
   */
  public String getError() {
    return error;
  }

  /**
   * This is the setter method to the attribute.
   * If the last attempted update failed, this is a more detailed error message.
   * Field introduced in 20.1.1.
   * @param error set the error.
   */
  public void setError(String  error) {
    this.error = error;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The time when the ip reputation service last successfull attemped to update this object.
   * This is the case when either this file references in this object got updated or when the ip reputation service knows positively that there are no
   * newer versions for these files.
   * It will be not update, if an error occurs during an update attempt.
   * In this case, the errror will be set.
   * Field introduced in 20.1.1.
   * @return lastSuccessfulUpdateCheck
   */
  public TimeStamp getLastSuccessfulUpdateCheck() {
    return lastSuccessfulUpdateCheck;
  }

  /**
   * This is the setter method to the attribute.
   * The time when the ip reputation service last successfull attemped to update this object.
   * This is the case when either this file references in this object got updated or when the ip reputation service knows positively that there are no
   * newer versions for these files.
   * It will be not update, if an error occurs during an update attempt.
   * In this case, the errror will be set.
   * Field introduced in 20.1.1.
   * @param lastSuccessfulUpdateCheck set the lastSuccessfulUpdateCheck.
   */
  public void setLastSuccessfulUpdateCheck(TimeStamp lastSuccessfulUpdateCheck) {
    this.lastSuccessfulUpdateCheck = lastSuccessfulUpdateCheck;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  IPReputationServiceStatus objIPReputationServiceStatus = (IPReputationServiceStatus) o;
  return   Objects.equals(this.lastSuccessfulUpdateCheck, objIPReputationServiceStatus.lastSuccessfulUpdateCheck)&&
  Objects.equals(this.error, objIPReputationServiceStatus.error);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class IPReputationServiceStatus {\n");
      sb.append("    error: ").append(toIndentedString(error)).append("\n");
        sb.append("    lastSuccessfulUpdateCheck: ").append(toIndentedString(lastSuccessfulUpdateCheck)).append("\n");
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

