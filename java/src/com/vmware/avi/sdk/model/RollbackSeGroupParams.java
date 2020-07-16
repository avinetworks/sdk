package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The RollbackSeGroupParams is a POJO class extends AviRestResource that used for creating
 * RollbackSeGroupParams.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RollbackSeGroupParams  {
    @JsonProperty("se_group_options")
    private SeGroupOptions seGroupOptions = null;

    @JsonProperty("se_group_refs")
    private List<String> seGroupRefs = null;

    @JsonProperty("skip_warnings")
    private Boolean skipWarnings = false;



  /**
   * This is the getter method this will return the attribute value.
   * This field identifies se group options that need to be applied during the rollback operations.
   * Field introduced in 18.2.6.
   * @return seGroupOptions
   */
  public SeGroupOptions getSeGroupOptions() {
    return seGroupOptions;
  }

  /**
   * This is the setter method to the attribute.
   * This field identifies se group options that need to be applied during the rollback operations.
   * Field introduced in 18.2.6.
   * @param seGroupOptions set the seGroupOptions.
   */
  public void setSeGroupOptions(SeGroupOptions seGroupOptions) {
    this.seGroupOptions = seGroupOptions;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Se group uuids for applying rollback operations.
   * It is a reference to an object of type serviceenginegroup.
   * Field introduced in 18.2.6.
   * @return seGroupRefs
   */
  public List<String> getSeGroupRefs() {
    return seGroupRefs;
  }

  /**
   * This is the setter method. this will set the seGroupRefs
   * Se group uuids for applying rollback operations.
   * It is a reference to an object of type serviceenginegroup.
   * Field introduced in 18.2.6.
   * @return seGroupRefs
   */
  public void setSeGroupRefs(List<String>  seGroupRefs) {
    this.seGroupRefs = seGroupRefs;
  }

  /**
   * This is the setter method this will set the seGroupRefs
   * Se group uuids for applying rollback operations.
   * It is a reference to an object of type serviceenginegroup.
   * Field introduced in 18.2.6.
   * @return seGroupRefs
   */
  public RollbackSeGroupParams addSeGroupRefsItem(String seGroupRefsItem) {
    if (this.seGroupRefs == null) {
      this.seGroupRefs = new ArrayList<String>();
    }
    this.seGroupRefs.add(seGroupRefsItem);
    return this;
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
  RollbackSeGroupParams objRollbackSeGroupParams = (RollbackSeGroupParams) o;
  return   Objects.equals(this.skipWarnings, objRollbackSeGroupParams.skipWarnings)&&
  Objects.equals(this.seGroupOptions, objRollbackSeGroupParams.seGroupOptions)&&
  Objects.equals(this.seGroupRefs, objRollbackSeGroupParams.seGroupRefs);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class RollbackSeGroupParams {\n");
      sb.append("    seGroupOptions: ").append(toIndentedString(seGroupOptions)).append("\n");
        sb.append("    seGroupRefs: ").append(toIndentedString(seGroupRefs)).append("\n");
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

