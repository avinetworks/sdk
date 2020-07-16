package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ControllerVersion is a POJO class extends AviRestResource that used for creating
 * ControllerVersion.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ControllerVersion  {
    @JsonProperty("name")
    private String name = null;

    @JsonProperty("patch")
    private String patch = null;

    @JsonProperty("version")
    private String version = null;



  /**
   * This is the getter method this will return the attribute value.
   * Name of the object.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the object.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Patch level for controller.
   * Field introduced in 17.2.2.
   * @return patch
   */
  public String getPatch() {
    return patch;
  }

  /**
   * This is the setter method to the attribute.
   * Patch level for controller.
   * Field introduced in 17.2.2.
   * @param patch set the patch.
   */
  public void setPatch(String  patch) {
    this.patch = patch;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property version of obj type controllerversion field type str  type string.
   * @return version
   */
  public String getVersion() {
    return version;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property version of obj type controllerversion field type str  type string.
   * @param version set the version.
   */
  public void setVersion(String  version) {
    this.version = version;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ControllerVersion objControllerVersion = (ControllerVersion) o;
  return   Objects.equals(this.version, objControllerVersion.version)&&
  Objects.equals(this.name, objControllerVersion.name)&&
  Objects.equals(this.patch, objControllerVersion.patch);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ControllerVersion {\n");
      sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    patch: ").append(toIndentedString(patch)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
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

