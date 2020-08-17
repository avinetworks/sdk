package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The AppInfo is a POJO class extends AviRestResource that used for creating
 * AppInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppInfo  {
    @JsonProperty("app_hdr_name")
    private String appHdrName = null;

    @JsonProperty("app_hdr_value")
    private String appHdrValue = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property app_hdr_name of obj type appinfo field type str  type string.
   * @return appHdrName
   */
  public String getAppHdrName() {
    return appHdrName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property app_hdr_name of obj type appinfo field type str  type string.
   * @param appHdrName set the appHdrName.
   */
  public void setAppHdrName(String  appHdrName) {
    this.appHdrName = appHdrName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property app_hdr_value of obj type appinfo field type str  type string.
   * @return appHdrValue
   */
  public String getAppHdrValue() {
    return appHdrValue;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property app_hdr_value of obj type appinfo field type str  type string.
   * @param appHdrValue set the appHdrValue.
   */
  public void setAppHdrValue(String  appHdrValue) {
    this.appHdrValue = appHdrValue;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  AppInfo objAppInfo = (AppInfo) o;
  return   Objects.equals(this.appHdrName, objAppInfo.appHdrName)&&
  Objects.equals(this.appHdrValue, objAppInfo.appHdrValue);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class AppInfo {\n");
      sb.append("    appHdrName: ").append(toIndentedString(appHdrName)).append("\n");
        sb.append("    appHdrValue: ").append(toIndentedString(appHdrValue)).append("\n");
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

