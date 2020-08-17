package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VinfraVcenterDiscoveryFailure is a POJO class extends AviRestResource that used for creating
 * VinfraVcenterDiscoveryFailure.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VinfraVcenterDiscoveryFailure  {
    @JsonProperty("state")
    private String state = null;

    @JsonProperty("vcenter")
    private String vcenter = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property state of obj type vinfravcenterdiscoveryfailure field type str  type string.
   * @return state
   */
  public String getState() {
    return state;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property state of obj type vinfravcenterdiscoveryfailure field type str  type string.
   * @param state set the state.
   */
  public void setState(String  state) {
    this.state = state;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vcenter of obj type vinfravcenterdiscoveryfailure field type str  type string.
   * @return vcenter
   */
  public String getVcenter() {
    return vcenter;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vcenter of obj type vinfravcenterdiscoveryfailure field type str  type string.
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
  VinfraVcenterDiscoveryFailure objVinfraVcenterDiscoveryFailure = (VinfraVcenterDiscoveryFailure) o;
  return   Objects.equals(this.vcenter, objVinfraVcenterDiscoveryFailure.vcenter)&&
  Objects.equals(this.state, objVinfraVcenterDiscoveryFailure.state);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VinfraVcenterDiscoveryFailure {\n");
      sb.append("    state: ").append(toIndentedString(state)).append("\n");
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

