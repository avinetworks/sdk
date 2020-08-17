package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The AuthMatchAttribute is a POJO class extends AviRestResource that used for creating
 * AuthMatchAttribute.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthMatchAttribute  {
    @JsonProperty("criteria")
    private String criteria = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("values")
    private List<String> values = null;



  /**
   * This is the getter method this will return the attribute value.
   * Rule match criteria.
   * Enum options - AUTH_MATCH_CONTAINS, AUTH_MATCH_DOES_NOT_CONTAIN, AUTH_MATCH_REGEX.
   * @return criteria
   */
  public String getCriteria() {
    return criteria;
  }

  /**
   * This is the setter method to the attribute.
   * Rule match criteria.
   * Enum options - AUTH_MATCH_CONTAINS, AUTH_MATCH_DOES_NOT_CONTAIN, AUTH_MATCH_REGEX.
   * @param criteria set the criteria.
   */
  public void setCriteria(String  criteria) {
    this.criteria = criteria;
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
   * Placeholder for description of property values of obj type authmatchattribute field type str  type array.
   * @return values
   */
  public List<String> getValues() {
    return values;
  }

  /**
   * This is the setter method. this will set the values
   * Placeholder for description of property values of obj type authmatchattribute field type str  type array.
   * @return values
   */
  public void setValues(List<String>  values) {
    this.values = values;
  }

  /**
   * This is the setter method this will set the values
   * Placeholder for description of property values of obj type authmatchattribute field type str  type array.
   * @return values
   */
  public AuthMatchAttribute addValuesItem(String valuesItem) {
    if (this.values == null) {
      this.values = new ArrayList<String>();
    }
    this.values.add(valuesItem);
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
  AuthMatchAttribute objAuthMatchAttribute = (AuthMatchAttribute) o;
  return   Objects.equals(this.criteria, objAuthMatchAttribute.criteria)&&
  Objects.equals(this.name, objAuthMatchAttribute.name)&&
  Objects.equals(this.values, objAuthMatchAttribute.values);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class AuthMatchAttribute {\n");
      sb.append("    criteria: ").append(toIndentedString(criteria)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    values: ").append(toIndentedString(values)).append("\n");
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

