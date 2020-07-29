package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The AuthAttributeMatch is a POJO class extends AviRestResource that used for creating
 * AuthAttributeMatch.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthAttributeMatch  {
    @JsonProperty("attribute_name")
    private String attributeName = null;

    @JsonProperty("attribute_value_list")
    private StringMatch attributeValueList = null;



  /**
   * This is the getter method this will return the attribute value.
   * Attribute name whose values will be looked up in the access lists.
   * Field introduced in 18.2.5.
   * @return attributeName
   */
  public String getAttributeName() {
    return attributeName;
  }

  /**
   * This is the setter method to the attribute.
   * Attribute name whose values will be looked up in the access lists.
   * Field introduced in 18.2.5.
   * @param attributeName set the attributeName.
   */
  public void setAttributeName(String  attributeName) {
    this.attributeName = attributeName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Attribute values used to determine access when authentication applies.
   * Field introduced in 18.2.5.
   * @return attributeValueList
   */
  public StringMatch getAttributeValueList() {
    return attributeValueList;
  }

  /**
   * This is the setter method to the attribute.
   * Attribute values used to determine access when authentication applies.
   * Field introduced in 18.2.5.
   * @param attributeValueList set the attributeValueList.
   */
  public void setAttributeValueList(StringMatch attributeValueList) {
    this.attributeValueList = attributeValueList;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  AuthAttributeMatch objAuthAttributeMatch = (AuthAttributeMatch) o;
  return   Objects.equals(this.attributeName, objAuthAttributeMatch.attributeName)&&
  Objects.equals(this.attributeValueList, objAuthAttributeMatch.attributeValueList);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class AuthAttributeMatch {\n");
      sb.append("    attributeName: ").append(toIndentedString(attributeName)).append("\n");
        sb.append("    attributeValueList: ").append(toIndentedString(attributeValueList)).append("\n");
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

