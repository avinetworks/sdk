package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ConfigCreateDetails is a POJO class extends AviRestResource that used for creating
 * ConfigCreateDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConfigCreateDetails  {
    @JsonProperty("error_message")
    private String errorMessage = null;

    @JsonProperty("path")
    private String path = null;

    @JsonProperty("request_data")
    private String requestData = null;

    @JsonProperty("resource_data")
    private String resourceData = null;

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
   * Data of the created resource.
   * @return resourceData
   */
  public String getResourceData() {
    return resourceData;
  }

  /**
   * This is the setter method to the attribute.
   * Data of the created resource.
   * @param resourceData set the resourceData.
   */
  public void setResourceData(String  resourceData) {
    this.resourceData = resourceData;
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
   * Config type of the created resource.
   * @return resourceType
   */
  public String getResourceType() {
    return resourceType;
  }

  /**
   * This is the setter method to the attribute.
   * Config type of the created resource.
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
  ConfigCreateDetails objConfigCreateDetails = (ConfigCreateDetails) o;
  return   Objects.equals(this.status, objConfigCreateDetails.status)&&
  Objects.equals(this.requestData, objConfigCreateDetails.requestData)&&
  Objects.equals(this.resourceName, objConfigCreateDetails.resourceName)&&
  Objects.equals(this.resourceData, objConfigCreateDetails.resourceData)&&
  Objects.equals(this.errorMessage, objConfigCreateDetails.errorMessage)&&
  Objects.equals(this.user, objConfigCreateDetails.user)&&
  Objects.equals(this.path, objConfigCreateDetails.path)&&
  Objects.equals(this.resourceType, objConfigCreateDetails.resourceType);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ConfigCreateDetails {\n");
      sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
        sb.append("    path: ").append(toIndentedString(path)).append("\n");
        sb.append("    requestData: ").append(toIndentedString(requestData)).append("\n");
        sb.append("    resourceData: ").append(toIndentedString(resourceData)).append("\n");
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

