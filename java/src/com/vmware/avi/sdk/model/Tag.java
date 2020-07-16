package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Tag is a POJO class extends AviRestResource that used for creating
 * Tag.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tag  {
    @JsonProperty("type")
    private String type = "USER_DEFINED";

    @JsonProperty("value")
    private String value = null;



  /**
   * This is the getter method this will return the attribute value.
   * Enum options - AVI_DEFINED, USER_DEFINED, VCENTER_DEFINED.
   * Default value when not specified in API or module is interpreted by Avi Controller as USER_DEFINED.
   * @return type
   */
  public String getType() {
    return type;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - AVI_DEFINED, USER_DEFINED, VCENTER_DEFINED.
   * Default value when not specified in API or module is interpreted by Avi Controller as USER_DEFINED.
   * @param type set the type.
   */
  public void setType(String  type) {
    this.type = type;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property value of obj type tag field type str  type string.
   * @return value
   */
  public String getValue() {
    return value;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property value of obj type tag field type str  type string.
   * @param value set the value.
   */
  public void setValue(String  value) {
    this.value = value;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  Tag objTag = (Tag) o;
  return   Objects.equals(this.type, objTag.type)&&
  Objects.equals(this.value, objTag.value);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class Tag {\n");
      sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

