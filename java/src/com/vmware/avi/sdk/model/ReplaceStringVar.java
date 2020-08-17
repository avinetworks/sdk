package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ReplaceStringVar is a POJO class extends AviRestResource that used for creating
 * ReplaceStringVar.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReplaceStringVar  {
    @JsonProperty("type")
    private String type = null;

    @JsonProperty("val")
    private String val = null;



  /**
   * This is the getter method this will return the attribute value.
   * Type of replacement string - can be a variable exposed from datascript, value of an http header or a custom user-input literal string.
   * Enum options - DATASCRIPT_VAR, HTTP_HEADER_VAR, LITERAL_STRING.
   * @return type
   */
  public String getType() {
    return type;
  }

  /**
   * This is the setter method to the attribute.
   * Type of replacement string - can be a variable exposed from datascript, value of an http header or a custom user-input literal string.
   * Enum options - DATASCRIPT_VAR, HTTP_HEADER_VAR, LITERAL_STRING.
   * @param type set the type.
   */
  public void setType(String  type) {
    this.type = type;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Value of the replacement string - name of variable exposed from datascript, name of the http header or a custom user-input literal string.
   * @return val
   */
  public String getVal() {
    return val;
  }

  /**
   * This is the setter method to the attribute.
   * Value of the replacement string - name of variable exposed from datascript, name of the http header or a custom user-input literal string.
   * @param val set the val.
   */
  public void setVal(String  val) {
    this.val = val;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ReplaceStringVar objReplaceStringVar = (ReplaceStringVar) o;
  return   Objects.equals(this.type, objReplaceStringVar.type)&&
  Objects.equals(this.val, objReplaceStringVar.val);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ReplaceStringVar {\n");
      sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    val: ").append(toIndentedString(val)).append("\n");
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

