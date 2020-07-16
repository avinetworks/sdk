package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The HealthMonitorExternal is a POJO class extends AviRestResource that used for creating
 * HealthMonitorExternal.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HealthMonitorExternal  {
    @JsonProperty("command_code")
    private String commandCode = null;

    @JsonProperty("command_parameters")
    private String commandParameters = null;

    @JsonProperty("command_path")
    private String commandPath = null;

    @JsonProperty("command_variables")
    private String commandVariables = null;



  /**
   * This is the getter method this will return the attribute value.
   * Command script provided inline.
   * @return commandCode
   */
  public String getCommandCode() {
    return commandCode;
  }

  /**
   * This is the setter method to the attribute.
   * Command script provided inline.
   * @param commandCode set the commandCode.
   */
  public void setCommandCode(String  commandCode) {
    this.commandCode = commandCode;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Optional arguments to feed into the script.
   * @return commandParameters
   */
  public String getCommandParameters() {
    return commandParameters;
  }

  /**
   * This is the setter method to the attribute.
   * Optional arguments to feed into the script.
   * @param commandParameters set the commandParameters.
   */
  public void setCommandParameters(String  commandParameters) {
    this.commandParameters = commandParameters;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Path of external health monitor script.
   * @return commandPath
   */
  public String getCommandPath() {
    return commandPath;
  }

  /**
   * This is the setter method to the attribute.
   * Path of external health monitor script.
   * @param commandPath set the commandPath.
   */
  public void setCommandPath(String  commandPath) {
    this.commandPath = commandPath;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Environment variables to be fed into the script.
   * @return commandVariables
   */
  public String getCommandVariables() {
    return commandVariables;
  }

  /**
   * This is the setter method to the attribute.
   * Environment variables to be fed into the script.
   * @param commandVariables set the commandVariables.
   */
  public void setCommandVariables(String  commandVariables) {
    this.commandVariables = commandVariables;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  HealthMonitorExternal objHealthMonitorExternal = (HealthMonitorExternal) o;
  return   Objects.equals(this.commandCode, objHealthMonitorExternal.commandCode)&&
  Objects.equals(this.commandVariables, objHealthMonitorExternal.commandVariables)&&
  Objects.equals(this.commandParameters, objHealthMonitorExternal.commandParameters)&&
  Objects.equals(this.commandPath, objHealthMonitorExternal.commandPath);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class HealthMonitorExternal {\n");
      sb.append("    commandCode: ").append(toIndentedString(commandCode)).append("\n");
        sb.append("    commandParameters: ").append(toIndentedString(commandParameters)).append("\n");
        sb.append("    commandPath: ").append(toIndentedString(commandPath)).append("\n");
        sb.append("    commandVariables: ").append(toIndentedString(commandVariables)).append("\n");
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

