package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DebugVrf is a POJO class extends AviRestResource that used for creating
 * DebugVrf.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DebugVrf  {
    @JsonProperty("flag")
    private String flag = null;



  /**
   * This is the getter method this will return the attribute value.
   * Enum options - DEBUG_VRF_BGP, DEBUG_VRF_QUAGGA, DEBUG_VRF_ALL, DEBUG_VRF_NONE.
   * Field introduced in 17.1.1.
   * @return flag
   */
  public String getFlag() {
    return flag;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - DEBUG_VRF_BGP, DEBUG_VRF_QUAGGA, DEBUG_VRF_ALL, DEBUG_VRF_NONE.
   * Field introduced in 17.1.1.
   * @param flag set the flag.
   */
  public void setFlag(String  flag) {
    this.flag = flag;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  DebugVrf objDebugVrf = (DebugVrf) o;
  return   Objects.equals(this.flag, objDebugVrf.flag);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DebugVrf {\n");
      sb.append("    flag: ").append(toIndentedString(flag)).append("\n");
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

