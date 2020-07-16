package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The HostAttributes is a POJO class extends AviRestResource that used for creating
 * HostAttributes.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HostAttributes  {
    @JsonProperty("attr_key")
    private String attrKey = null;

    @JsonProperty("attr_val")
    private String attrVal = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property attr_key of obj type hostattributes field type str  type string.
   * @return attrKey
   */
  public String getAttrKey() {
    return attrKey;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property attr_key of obj type hostattributes field type str  type string.
   * @param attrKey set the attrKey.
   */
  public void setAttrKey(String  attrKey) {
    this.attrKey = attrKey;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property attr_val of obj type hostattributes field type str  type string.
   * @return attrVal
   */
  public String getAttrVal() {
    return attrVal;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property attr_val of obj type hostattributes field type str  type string.
   * @param attrVal set the attrVal.
   */
  public void setAttrVal(String  attrVal) {
    this.attrVal = attrVal;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  HostAttributes objHostAttributes = (HostAttributes) o;
  return   Objects.equals(this.attrKey, objHostAttributes.attrKey)&&
  Objects.equals(this.attrVal, objHostAttributes.attrVal);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class HostAttributes {\n");
      sb.append("    attrKey: ").append(toIndentedString(attrKey)).append("\n");
        sb.append("    attrVal: ").append(toIndentedString(attrVal)).append("\n");
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

