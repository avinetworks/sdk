package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ConfigActionDetails is a POJO class extends AviRestResource that used for creating
 * ConfigActionDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConfigActionDetails  {
    @JsonProperty("action_name")
    private String actionName = null;

    @JsonProperty("error_message")
    private String errorMessage = null;

    @JsonProperty("parameter_data")
    private String parameterData = null;

    @JsonProperty("path")
    private String path = null;

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
   * Name of the action.
   * @return actionName
   */
  public String getActionName() {
    return actionName;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the action.
   * @param actionName set the actionName.
   */
  public void setActionName(String  actionName) {
    this.actionName = actionName;
  }

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
   * Parameter data.
   * @return parameterData
   */
  public String getParameterData() {
    return parameterData;
  }

  /**
   * This is the setter method to the attribute.
   * Parameter data.
   * @param parameterData set the parameterData.
   */
  public void setParameterData(String  parameterData) {
    this.parameterData = parameterData;
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
   * Name of the resource.
   * @return resourceName
   */
  public String getResourceName() {
    return resourceName;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the resource.
   * @param resourceName set the resourceName.
   */
  public void setResourceName(String  resourceName) {
    this.resourceName = resourceName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Config type of the resource.
   * @return resourceType
   */
  public String getResourceType() {
    return resourceType;
  }

  /**
   * This is the setter method to the attribute.
   * Config type of the resource.
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
  ConfigActionDetails objConfigActionDetails = (ConfigActionDetails) o;
  return   Objects.equals(this.status, objConfigActionDetails.status)&&
  Objects.equals(this.resourceName, objConfigActionDetails.resourceName)&&
  Objects.equals(this.errorMessage, objConfigActionDetails.errorMessage)&&
  Objects.equals(this.actionName, objConfigActionDetails.actionName)&&
  Objects.equals(this.user, objConfigActionDetails.user)&&
  Objects.equals(this.parameterData, objConfigActionDetails.parameterData)&&
  Objects.equals(this.path, objConfigActionDetails.path)&&
  Objects.equals(this.resourceType, objConfigActionDetails.resourceType);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ConfigActionDetails {\n");
      sb.append("    actionName: ").append(toIndentedString(actionName)).append("\n");
        sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
        sb.append("    parameterData: ").append(toIndentedString(parameterData)).append("\n");
        sb.append("    path: ").append(toIndentedString(path)).append("\n");
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

