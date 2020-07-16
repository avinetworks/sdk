package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The CustomParams is a POJO class extends AviRestResource that used for creating
 * CustomParams.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomParams  {
    @JsonProperty("is_dynamic")
    private Boolean isDynamic = false;

    @JsonProperty("is_sensitive")
    private Boolean isSensitive = false;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("value")
    private String value = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property is_dynamic of obj type customparams field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return isDynamic
   */
  public Boolean getIsDynamic() {
    return isDynamic;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property is_dynamic of obj type customparams field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param isDynamic set the isDynamic.
   */
  public void setIsDynamic(Boolean  isDynamic) {
    this.isDynamic = isDynamic;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property is_sensitive of obj type customparams field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return isSensitive
   */
  public Boolean getIsSensitive() {
    return isSensitive;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property is_sensitive of obj type customparams field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param isSensitive set the isSensitive.
   */
  public void setIsSensitive(Boolean  isSensitive) {
    this.isSensitive = isSensitive;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the object.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the object.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property value of obj type customparams field type str  type string.
   * @return value
   */
  public String getValue() {
    return value;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property value of obj type customparams field type str  type string.
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
  CustomParams objCustomParams = (CustomParams) o;
  return   Objects.equals(this.isDynamic, objCustomParams.isDynamic)&&
  Objects.equals(this.isSensitive, objCustomParams.isSensitive)&&
  Objects.equals(this.name, objCustomParams.name)&&
  Objects.equals(this.value, objCustomParams.value);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class CustomParams {\n");
      sb.append("    isDynamic: ").append(toIndentedString(isDynamic)).append("\n");
        sb.append("    isSensitive: ").append(toIndentedString(isSensitive)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

