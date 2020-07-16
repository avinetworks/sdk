package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The PatchInfo is a POJO class extends AviRestResource that used for creating
 * PatchInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatchInfo  {
    @JsonProperty("patch_type")
    private String patchType = null;

    @JsonProperty("reboot")
    private Boolean reboot = null;

    @JsonProperty("reboot_list")
    private List<RebootData> rebootList = null;



  /**
   * This is the getter method this will return the attribute value.
   * Patch type describes the controller or se patch type.
   * Field introduced in 18.2.6.
   * @return patchType
   */
  public String getPatchType() {
    return patchType;
  }

  /**
   * This is the setter method to the attribute.
   * Patch type describes the controller or se patch type.
   * Field introduced in 18.2.6.
   * @param patchType set the patchType.
   */
  public void setPatchType(String  patchType) {
    this.patchType = patchType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * This variable tells whether reboot has to be performed.
   * Field introduced in 18.2.6.
   * @return reboot
   */
  public Boolean getReboot() {
    return reboot;
  }

  /**
   * This is the setter method to the attribute.
   * This variable tells whether reboot has to be performed.
   * Field introduced in 18.2.6.
   * @param reboot set the reboot.
   */
  public void setReboot(Boolean  reboot) {
    this.reboot = reboot;
  }
  /**
   * This is the getter method this will return the attribute value.
   * This variable is for full list of patch reboot details.
   * Field introduced in 18.2.8, 20.1.1.
   * @return rebootList
   */
  public List<RebootData> getRebootList() {
    return rebootList;
  }

  /**
   * This is the setter method. this will set the rebootList
   * This variable is for full list of patch reboot details.
   * Field introduced in 18.2.8, 20.1.1.
   * @return rebootList
   */
  public void setRebootList(List<RebootData>  rebootList) {
    this.rebootList = rebootList;
  }

  /**
   * This is the setter method this will set the rebootList
   * This variable is for full list of patch reboot details.
   * Field introduced in 18.2.8, 20.1.1.
   * @return rebootList
   */
  public PatchInfo addRebootListItem(RebootData rebootListItem) {
    if (this.rebootList == null) {
      this.rebootList = new ArrayList<RebootData>();
    }
    this.rebootList.add(rebootListItem);
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
  PatchInfo objPatchInfo = (PatchInfo) o;
  return   Objects.equals(this.rebootList, objPatchInfo.rebootList)&&
  Objects.equals(this.patchType, objPatchInfo.patchType)&&
  Objects.equals(this.reboot, objPatchInfo.reboot);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class PatchInfo {\n");
      sb.append("    patchType: ").append(toIndentedString(patchType)).append("\n");
        sb.append("    reboot: ").append(toIndentedString(reboot)).append("\n");
        sb.append("    rebootList: ").append(toIndentedString(rebootList)).append("\n");
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

