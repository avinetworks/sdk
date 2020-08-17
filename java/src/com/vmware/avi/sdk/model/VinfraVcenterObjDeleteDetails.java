package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VinfraVcenterObjDeleteDetails is a POJO class extends AviRestResource that used for creating
 * VinfraVcenterObjDeleteDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VinfraVcenterObjDeleteDetails  {
    @JsonProperty("obj_name")
    private String objName = null;

    @JsonProperty("vcenter")
    private String vcenter = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property obj_name of obj type vinfravcenterobjdeletedetails field type str  type string.
   * @return objName
   */
  public String getObjName() {
    return objName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property obj_name of obj type vinfravcenterobjdeletedetails field type str  type string.
   * @param objName set the objName.
   */
  public void setObjName(String  objName) {
    this.objName = objName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vcenter of obj type vinfravcenterobjdeletedetails field type str  type string.
   * @return vcenter
   */
  public String getVcenter() {
    return vcenter;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vcenter of obj type vinfravcenterobjdeletedetails field type str  type string.
   * @param vcenter set the vcenter.
   */
  public void setVcenter(String  vcenter) {
    this.vcenter = vcenter;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VinfraVcenterObjDeleteDetails objVinfraVcenterObjDeleteDetails = (VinfraVcenterObjDeleteDetails) o;
  return   Objects.equals(this.vcenter, objVinfraVcenterObjDeleteDetails.vcenter)&&
  Objects.equals(this.objName, objVinfraVcenterObjDeleteDetails.objName);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VinfraVcenterObjDeleteDetails {\n");
      sb.append("    objName: ").append(toIndentedString(objName)).append("\n");
        sb.append("    vcenter: ").append(toIndentedString(vcenter)).append("\n");
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

