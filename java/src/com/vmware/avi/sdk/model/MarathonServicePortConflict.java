package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The MarathonServicePortConflict is a POJO class extends AviRestResource that used for creating
 * MarathonServicePortConflict.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MarathonServicePortConflict  {
    @JsonProperty("app_name")
    private String appName = null;

    @JsonProperty("cc_id")
    private String ccId = null;

    @JsonProperty("marathon_url")
    private String marathonUrl = null;

    @JsonProperty("port")
    private Integer port = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property app_name of obj type marathonserviceportconflict field type str  type string.
   * @return appName
   */
  public String getAppName() {
    return appName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property app_name of obj type marathonserviceportconflict field type str  type string.
   * @param appName set the appName.
   */
  public void setAppName(String  appName) {
    this.appName = appName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cc_id of obj type marathonserviceportconflict field type str  type string.
   * @return ccId
   */
  public String getCcId() {
    return ccId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cc_id of obj type marathonserviceportconflict field type str  type string.
   * @param ccId set the ccId.
   */
  public void setCcId(String  ccId) {
    this.ccId = ccId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property marathon_url of obj type marathonserviceportconflict field type str  type string.
   * @return marathonUrl
   */
  public String getMarathonUrl() {
    return marathonUrl;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property marathon_url of obj type marathonserviceportconflict field type str  type string.
   * @param marathonUrl set the marathonUrl.
   */
  public void setMarathonUrl(String  marathonUrl) {
    this.marathonUrl = marathonUrl;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property port of obj type marathonserviceportconflict field type str  type integer.
   * @return port
   */
  public Integer getPort() {
    return port;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property port of obj type marathonserviceportconflict field type str  type integer.
   * @param port set the port.
   */
  public void setPort(Integer  port) {
    this.port = port;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  MarathonServicePortConflict objMarathonServicePortConflict = (MarathonServicePortConflict) o;
  return   Objects.equals(this.ccId, objMarathonServicePortConflict.ccId)&&
  Objects.equals(this.marathonUrl, objMarathonServicePortConflict.marathonUrl)&&
  Objects.equals(this.port, objMarathonServicePortConflict.port)&&
  Objects.equals(this.appName, objMarathonServicePortConflict.appName);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class MarathonServicePortConflict {\n");
      sb.append("    appName: ").append(toIndentedString(appName)).append("\n");
        sb.append("    ccId: ").append(toIndentedString(ccId)).append("\n");
        sb.append("    marathonUrl: ").append(toIndentedString(marathonUrl)).append("\n");
        sb.append("    port: ").append(toIndentedString(port)).append("\n");
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

