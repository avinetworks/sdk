package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ContainerCloudBatchSetup is a POJO class extends AviRestResource that used for creating
 * ContainerCloudBatchSetup.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContainerCloudBatchSetup  {
    @JsonProperty("ccs")
    private List<ContainerCloudSetup> ccs = null;


  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ccs of obj type containercloudbatchsetup field type str  type array.
   * @return ccs
   */
  public List<ContainerCloudSetup> getCcs() {
    return ccs;
  }

  /**
   * This is the setter method. this will set the ccs
   * Placeholder for description of property ccs of obj type containercloudbatchsetup field type str  type array.
   * @return ccs
   */
  public void setCcs(List<ContainerCloudSetup>  ccs) {
    this.ccs = ccs;
  }

  /**
   * This is the setter method this will set the ccs
   * Placeholder for description of property ccs of obj type containercloudbatchsetup field type str  type array.
   * @return ccs
   */
  public ContainerCloudBatchSetup addCcsItem(ContainerCloudSetup ccsItem) {
    if (this.ccs == null) {
      this.ccs = new ArrayList<ContainerCloudSetup>();
    }
    this.ccs.add(ccsItem);
    return this;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ContainerCloudBatchSetup objContainerCloudBatchSetup = (ContainerCloudBatchSetup) o;
  return   Objects.equals(this.ccs, objContainerCloudBatchSetup.ccs);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ContainerCloudBatchSetup {\n");
      sb.append("    ccs: ").append(toIndentedString(ccs)).append("\n");
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

