package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The PatchSystemParams is a POJO class extends AviRestResource that used for creating
 * PatchSystemParams.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatchSystemParams  {
    @JsonProperty("controller_patch_ref")
    private String controllerPatchRef = null;

    @JsonProperty("se_group_options")
    private SeGroupOptions seGroupOptions = null;

    @JsonProperty("se_patch_ref")
    private String sePatchRef = null;

    @JsonProperty("skip_warnings")
    private Boolean skipWarnings = false;



  /**
   * This is the getter method this will return the attribute value.
   * Image uuid for identifying controller patch image.
   * It is a reference to an object of type image.
   * Field introduced in 18.2.6.
   * @return controllerPatchRef
   */
  public String getControllerPatchRef() {
    return controllerPatchRef;
  }

  /**
   * This is the setter method to the attribute.
   * Image uuid for identifying controller patch image.
   * It is a reference to an object of type image.
   * Field introduced in 18.2.6.
   * @param controllerPatchRef set the controllerPatchRef.
   */
  public void setControllerPatchRef(String  controllerPatchRef) {
    this.controllerPatchRef = controllerPatchRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Se group options for the patch operations.
   * Field introduced in 18.2.6.
   * @return seGroupOptions
   */
  public SeGroupOptions getSeGroupOptions() {
    return seGroupOptions;
  }

  /**
   * This is the setter method to the attribute.
   * Se group options for the patch operations.
   * Field introduced in 18.2.6.
   * @param seGroupOptions set the seGroupOptions.
   */
  public void setSeGroupOptions(SeGroupOptions seGroupOptions) {
    this.seGroupOptions = seGroupOptions;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Image uuid for identifying se patch image.
   * It is a reference to an object of type image.
   * Field introduced in 18.2.6.
   * @return sePatchRef
   */
  public String getSePatchRef() {
    return sePatchRef;
  }

  /**
   * This is the setter method to the attribute.
   * Image uuid for identifying se patch image.
   * It is a reference to an object of type image.
   * Field introduced in 18.2.6.
   * @param sePatchRef set the sePatchRef.
   */
  public void setSePatchRef(String  sePatchRef) {
    this.sePatchRef = sePatchRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * This is flag when set as true skips few optional must checks.
   * Field introduced in 18.2.6.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return skipWarnings
   */
  public Boolean getSkipWarnings() {
    return skipWarnings;
  }

  /**
   * This is the setter method to the attribute.
   * This is flag when set as true skips few optional must checks.
   * Field introduced in 18.2.6.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param skipWarnings set the skipWarnings.
   */
  public void setSkipWarnings(Boolean  skipWarnings) {
    this.skipWarnings = skipWarnings;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  PatchSystemParams objPatchSystemParams = (PatchSystemParams) o;
  return   Objects.equals(this.controllerPatchRef, objPatchSystemParams.controllerPatchRef)&&
  Objects.equals(this.skipWarnings, objPatchSystemParams.skipWarnings)&&
  Objects.equals(this.sePatchRef, objPatchSystemParams.sePatchRef)&&
  Objects.equals(this.seGroupOptions, objPatchSystemParams.seGroupOptions);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class PatchSystemParams {\n");
      sb.append("    controllerPatchRef: ").append(toIndentedString(controllerPatchRef)).append("\n");
        sb.append("    seGroupOptions: ").append(toIndentedString(seGroupOptions)).append("\n");
        sb.append("    sePatchRef: ").append(toIndentedString(sePatchRef)).append("\n");
        sb.append("    skipWarnings: ").append(toIndentedString(skipWarnings)).append("\n");
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

