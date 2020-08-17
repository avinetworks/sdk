package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The PatchSeGroupParams is a POJO class extends AviRestResource that used for creating
 * PatchSeGroupParams.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatchSeGroupParams  {
    @JsonProperty("se_group_options")
    private SeGroupOptions seGroupOptions = null;

    @JsonProperty("se_group_refs")
    private List<String> seGroupRefs = null;

    @JsonProperty("se_patch_ref")
    private String sePatchRef = null;

    @JsonProperty("skip_warnings")
    private Boolean skipWarnings = false;



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
   * Se groups subjected to patch operations.
   * It is a reference to an object of type serviceenginegroup.
   * Field introduced in 18.2.6.
   * @return seGroupRefs
   */
  public List<String> getSeGroupRefs() {
    return seGroupRefs;
  }

  /**
   * This is the setter method. this will set the seGroupRefs
   * Se groups subjected to patch operations.
   * It is a reference to an object of type serviceenginegroup.
   * Field introduced in 18.2.6.
   * @return seGroupRefs
   */
  public void setSeGroupRefs(List<String>  seGroupRefs) {
    this.seGroupRefs = seGroupRefs;
  }

  /**
   * This is the setter method this will set the seGroupRefs
   * Se groups subjected to patch operations.
   * It is a reference to an object of type serviceenginegroup.
   * Field introduced in 18.2.6.
   * @return seGroupRefs
   */
  public PatchSeGroupParams addSeGroupRefsItem(String seGroupRefsItem) {
    if (this.seGroupRefs == null) {
      this.seGroupRefs = new ArrayList<String>();
    }
    this.seGroupRefs.add(seGroupRefsItem);
    return this;
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
  PatchSeGroupParams objPatchSeGroupParams = (PatchSeGroupParams) o;
  return   Objects.equals(this.sePatchRef, objPatchSeGroupParams.sePatchRef)&&
  Objects.equals(this.seGroupOptions, objPatchSeGroupParams.seGroupOptions)&&
  Objects.equals(this.seGroupRefs, objPatchSeGroupParams.seGroupRefs)&&
  Objects.equals(this.skipWarnings, objPatchSeGroupParams.skipWarnings);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class PatchSeGroupParams {\n");
      sb.append("    seGroupOptions: ").append(toIndentedString(seGroupOptions)).append("\n");
        sb.append("    seGroupRefs: ").append(toIndentedString(seGroupRefs)).append("\n");
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

