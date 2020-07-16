package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The UpgradeParams is a POJO class extends AviRestResource that used for creating
 * UpgradeParams.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpgradeParams  {
    @JsonProperty("controller_patch_ref")
    private String controllerPatchRef = null;

    @JsonProperty("image_ref")
    private String imageRef = null;

    @JsonProperty("se_group_options")
    private SeGroupOptions seGroupOptions = null;

    @JsonProperty("se_group_refs")
    private List<String> seGroupRefs = null;

    @JsonProperty("se_patch_ref")
    private String sePatchRef = null;

    @JsonProperty("skip_warnings")
    private Boolean skipWarnings = false;

    @JsonProperty("system")
    private Boolean system = false;



  /**
   * This is the getter method this will return the attribute value.
   * Image uuid for identifying controller patch.
   * It is a reference to an object of type image.
   * Field introduced in 18.2.6.
   * @return controllerPatchRef
   */
  public String getControllerPatchRef() {
    return controllerPatchRef;
  }

  /**
   * This is the setter method to the attribute.
   * Image uuid for identifying controller patch.
   * It is a reference to an object of type image.
   * Field introduced in 18.2.6.
   * @param controllerPatchRef set the controllerPatchRef.
   */
  public void setControllerPatchRef(String  controllerPatchRef) {
    this.controllerPatchRef = controllerPatchRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Image uuid for identifying base image.
   * It is a reference to an object of type image.
   * Field introduced in 18.2.6.
   * @return imageRef
   */
  public String getImageRef() {
    return imageRef;
  }

  /**
   * This is the setter method to the attribute.
   * Image uuid for identifying base image.
   * It is a reference to an object of type image.
   * Field introduced in 18.2.6.
   * @param imageRef set the imageRef.
   */
  public void setImageRef(String  imageRef) {
    this.imageRef = imageRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * This field identifies se group options that need to be applied during the upgrade operations.
   * Field introduced in 18.2.6.
   * @return seGroupOptions
   */
  public SeGroupOptions getSeGroupOptions() {
    return seGroupOptions;
  }

  /**
   * This is the setter method to the attribute.
   * This field identifies se group options that need to be applied during the upgrade operations.
   * Field introduced in 18.2.6.
   * @param seGroupOptions set the seGroupOptions.
   */
  public void setSeGroupOptions(SeGroupOptions seGroupOptions) {
    this.seGroupOptions = seGroupOptions;
  }
  /**
   * This is the getter method this will return the attribute value.
   * This field identifies the list of se groups for which the upgrade operations are applicable.
   * This field is ignored if the 'system' is enabled.
   * It is a reference to an object of type serviceenginegroup.
   * Field introduced in 18.2.6.
   * @return seGroupRefs
   */
  public List<String> getSeGroupRefs() {
    return seGroupRefs;
  }

  /**
   * This is the setter method. this will set the seGroupRefs
   * This field identifies the list of se groups for which the upgrade operations are applicable.
   * This field is ignored if the 'system' is enabled.
   * It is a reference to an object of type serviceenginegroup.
   * Field introduced in 18.2.6.
   * @return seGroupRefs
   */
  public void setSeGroupRefs(List<String>  seGroupRefs) {
    this.seGroupRefs = seGroupRefs;
  }

  /**
   * This is the setter method this will set the seGroupRefs
   * This field identifies the list of se groups for which the upgrade operations are applicable.
   * This field is ignored if the 'system' is enabled.
   * It is a reference to an object of type serviceenginegroup.
   * Field introduced in 18.2.6.
   * @return seGroupRefs
   */
  public UpgradeParams addSeGroupRefsItem(String seGroupRefsItem) {
    if (this.seGroupRefs == null) {
      this.seGroupRefs = new ArrayList<String>();
    }
    this.seGroupRefs.add(seGroupRefsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Image uuid for identifying service engine patch.
   * It is a reference to an object of type image.
   * Field introduced in 18.2.6.
   * @return sePatchRef
   */
  public String getSePatchRef() {
    return sePatchRef;
  }

  /**
   * This is the setter method to the attribute.
   * Image uuid for identifying service engine patch.
   * It is a reference to an object of type image.
   * Field introduced in 18.2.6.
   * @param sePatchRef set the sePatchRef.
   */
  public void setSePatchRef(String  sePatchRef) {
    this.sePatchRef = sePatchRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * This is flag when set as true skips few optional must check.
   * Field introduced in 18.2.6.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return skipWarnings
   */
  public Boolean getSkipWarnings() {
    return skipWarnings;
  }

  /**
   * This is the setter method to the attribute.
   * This is flag when set as true skips few optional must check.
   * Field introduced in 18.2.6.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param skipWarnings set the skipWarnings.
   */
  public void setSkipWarnings(Boolean  skipWarnings) {
    this.skipWarnings = skipWarnings;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Apply upgrade operations such as upgrade/patch to controller and all se groups.
   * Field introduced in 18.2.6.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return system
   */
  public Boolean getSystem() {
    return system;
  }

  /**
   * This is the setter method to the attribute.
   * Apply upgrade operations such as upgrade/patch to controller and all se groups.
   * Field introduced in 18.2.6.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param system set the system.
   */
  public void setSystem(Boolean  system) {
    this.system = system;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  UpgradeParams objUpgradeParams = (UpgradeParams) o;
  return   Objects.equals(this.seGroupOptions, objUpgradeParams.seGroupOptions)&&
  Objects.equals(this.controllerPatchRef, objUpgradeParams.controllerPatchRef)&&
  Objects.equals(this.system, objUpgradeParams.system)&&
  Objects.equals(this.sePatchRef, objUpgradeParams.sePatchRef)&&
  Objects.equals(this.imageRef, objUpgradeParams.imageRef)&&
  Objects.equals(this.skipWarnings, objUpgradeParams.skipWarnings)&&
  Objects.equals(this.seGroupRefs, objUpgradeParams.seGroupRefs);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class UpgradeParams {\n");
      sb.append("    controllerPatchRef: ").append(toIndentedString(controllerPatchRef)).append("\n");
        sb.append("    imageRef: ").append(toIndentedString(imageRef)).append("\n");
        sb.append("    seGroupOptions: ").append(toIndentedString(seGroupOptions)).append("\n");
        sb.append("    seGroupRefs: ").append(toIndentedString(seGroupRefs)).append("\n");
        sb.append("    sePatchRef: ").append(toIndentedString(sePatchRef)).append("\n");
        sb.append("    skipWarnings: ").append(toIndentedString(skipWarnings)).append("\n");
        sb.append("    system: ").append(toIndentedString(system)).append("\n");
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

