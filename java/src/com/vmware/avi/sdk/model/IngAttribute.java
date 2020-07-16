package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The IngAttribute is a POJO class extends AviRestResource that used for creating
 * IngAttribute.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IngAttribute  {
    @JsonProperty("attribute")
    private String attribute = null;

    @JsonProperty("value")
    private String value = null;



  /**
   * This is the getter method this will return the attribute value.
   * Attribute to match.
   * Field introduced in 17.2.15, 18.1.5, 18.2.1.
   * @return attribute
   */
  public String getAttribute() {
    return attribute;
  }

  /**
   * This is the setter method to the attribute.
   * Attribute to match.
   * Field introduced in 17.2.15, 18.1.5, 18.2.1.
   * @param attribute set the attribute.
   */
  public void setAttribute(String  attribute) {
    this.attribute = attribute;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Attribute value.
   * If not set, match any value.
   * Field introduced in 17.2.15, 18.1.5, 18.2.1.
   * @return value
   */
  public String getValue() {
    return value;
  }

  /**
   * This is the setter method to the attribute.
   * Attribute value.
   * If not set, match any value.
   * Field introduced in 17.2.15, 18.1.5, 18.2.1.
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
  IngAttribute objIngAttribute = (IngAttribute) o;
  return   Objects.equals(this.attribute, objIngAttribute.attribute)&&
  Objects.equals(this.value, objIngAttribute.value);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class IngAttribute {\n");
      sb.append("    attribute: ").append(toIndentedString(attribute)).append("\n");
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

