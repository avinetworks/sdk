package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ConfigUpdateDetails is a POJO class extends AviRestResource that used for creating
 * ConfigUpdateDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConfigUpdateDetails  {
    @JsonProperty("error_message")
    private String errorMessage = null;

    @JsonProperty("new_resource_data")
    private String newResourceData = null;

    @JsonProperty("old_resource_data")
    private String oldResourceData = null;

    @JsonProperty("path")
    private String path = null;

    @JsonProperty("request_data")
    private String requestData = null;

    @JsonProperty("resource_name")
    private String resourceName = null;

    @JsonProperty("resource_type")
    private String resourceType = null;

    @JsonProperty("status")
    private String status = null;

    @JsonProperty("user")
    private String user = null;



  /**
   * This is the getter method this will return the attribute value.
   * Error message if request failed.
   * @return errorMessage
   */
  public String getErrorMessage() {
    return errorMessage;
  }

  /**
   * This is the setter method to the attribute.
   * Error message if request failed.
   * @param errorMessage set the errorMessage.
   */
  public void setErrorMessage(String  errorMessage) {
    this.errorMessage = errorMessage;
  }

  /**
   * This is the getter method this will return the attribute value.
   * New updated data of the resource.
   * @return newResourceData
   */
  public String getNewResourceData() {
    return newResourceData;
  }

  /**
   * This is the setter method to the attribute.
   * New updated data of the resource.
   * @param newResourceData set the newResourceData.
   */
  public void setNewResourceData(String  newResourceData) {
    this.newResourceData = newResourceData;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Old & overwritten data of the resource.
   * @return oldResourceData
   */
  public String getOldResourceData() {
    return oldResourceData;
  }

  /**
   * This is the setter method to the attribute.
   * Old & overwritten data of the resource.
   * @param oldResourceData set the oldResourceData.
   */
  public void setOldResourceData(String  oldResourceData) {
    this.oldResourceData = oldResourceData;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Api path.
   * @return path
   */
  public String getPath() {
    return path;
  }

  /**
   * This is the setter method to the attribute.
   * Api path.
   * @param path set the path.
   */
  public void setPath(String  path) {
    this.path = path;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Request data if request failed.
   * @return requestData
   */
  public String getRequestData() {
    return requestData;
  }

  /**
   * This is the setter method to the attribute.
   * Request data if request failed.
   * @param requestData set the requestData.
   */
  public void setRequestData(String  requestData) {
    this.requestData = requestData;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the created resource.
   * @return resourceName
   */
  public String getResourceName() {
    return resourceName;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the created resource.
   * @param resourceName set the resourceName.
   */
  public void setResourceName(String  resourceName) {
    this.resourceName = resourceName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Config type of the updated resource.
   * @return resourceType
   */
  public String getResourceType() {
    return resourceType;
  }

  /**
   * This is the setter method to the attribute.
   * Config type of the updated resource.
   * @param resourceType set the resourceType.
   */
  public void setResourceType(String  resourceType) {
    this.resourceType = resourceType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Status.
   * @return status
   */
  public String getStatus() {
    return status;
  }

  /**
   * This is the setter method to the attribute.
   * Status.
   * @param status set the status.
   */
  public void setStatus(String  status) {
    this.status = status;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Request user.
   * @return user
   */
  public String getUser() {
    return user;
  }

  /**
   * This is the setter method to the attribute.
   * Request user.
   * @param user set the user.
   */
  public void setUser(String  user) {
    this.user = user;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ConfigUpdateDetails objConfigUpdateDetails = (ConfigUpdateDetails) o;
  return   Objects.equals(this.status, objConfigUpdateDetails.status)&&
  Objects.equals(this.requestData, objConfigUpdateDetails.requestData)&&
  Objects.equals(this.resourceName, objConfigUpdateDetails.resourceName)&&
  Objects.equals(this.errorMessage, objConfigUpdateDetails.errorMessage)&&
  Objects.equals(this.oldResourceData, objConfigUpdateDetails.oldResourceData)&&
  Objects.equals(this.user, objConfigUpdateDetails.user)&&
  Objects.equals(this.newResourceData, objConfigUpdateDetails.newResourceData)&&
  Objects.equals(this.path, objConfigUpdateDetails.path)&&
  Objects.equals(this.resourceType, objConfigUpdateDetails.resourceType);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ConfigUpdateDetails {\n");
      sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
        sb.append("    newResourceData: ").append(toIndentedString(newResourceData)).append("\n");
        sb.append("    oldResourceData: ").append(toIndentedString(oldResourceData)).append("\n");
        sb.append("    path: ").append(toIndentedString(path)).append("\n");
        sb.append("    requestData: ").append(toIndentedString(requestData)).append("\n");
        sb.append("    resourceName: ").append(toIndentedString(resourceName)).append("\n");
        sb.append("    resourceType: ").append(toIndentedString(resourceType)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    user: ").append(toIndentedString(user)).append("\n");
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

