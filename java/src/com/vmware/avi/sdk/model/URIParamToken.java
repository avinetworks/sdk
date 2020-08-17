package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The URIParamToken is a POJO class extends AviRestResource that used for creating
 * URIParamToken.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class URIParamToken  {
    @JsonProperty("end_index")
    private Integer endIndex = null;

    @JsonProperty("start_index")
    private Integer startIndex = null;

    @JsonProperty("str_value")
    private String strValue = null;

    @JsonProperty("type")
    private String type = null;



  /**
   * This is the getter method this will return the attribute value.
   * Index of the ending token in the incoming uri.
   * Allowed values are 0-65534.
   * Special values are 65535 - 'end of string'.
   * @return endIndex
   */
  public Integer getEndIndex() {
    return endIndex;
  }

  /**
   * This is the setter method to the attribute.
   * Index of the ending token in the incoming uri.
   * Allowed values are 0-65534.
   * Special values are 65535 - 'end of string'.
   * @param endIndex set the endIndex.
   */
  public void setEndIndex(Integer  endIndex) {
    this.endIndex = endIndex;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Index of the starting token in the incoming uri.
   * @return startIndex
   */
  public Integer getStartIndex() {
    return startIndex;
  }

  /**
   * This is the setter method to the attribute.
   * Index of the starting token in the incoming uri.
   * @param startIndex set the startIndex.
   */
  public void setStartIndex(Integer  startIndex) {
    this.startIndex = startIndex;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Constant string to use as a token.
   * @return strValue
   */
  public String getStrValue() {
    return strValue;
  }

  /**
   * This is the setter method to the attribute.
   * Constant string to use as a token.
   * @param strValue set the strValue.
   */
  public void setStrValue(String  strValue) {
    this.strValue = strValue;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Token type for constructing the uri.
   * Enum options - URI_TOKEN_TYPE_HOST, URI_TOKEN_TYPE_PATH, URI_TOKEN_TYPE_STRING, URI_TOKEN_TYPE_STRING_GROUP, URI_TOKEN_TYPE_REGEX.
   * @return type
   */
  public String getType() {
    return type;
  }

  /**
   * This is the setter method to the attribute.
   * Token type for constructing the uri.
   * Enum options - URI_TOKEN_TYPE_HOST, URI_TOKEN_TYPE_PATH, URI_TOKEN_TYPE_STRING, URI_TOKEN_TYPE_STRING_GROUP, URI_TOKEN_TYPE_REGEX.
   * @param type set the type.
   */
  public void setType(String  type) {
    this.type = type;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  URIParamToken objURIParamToken = (URIParamToken) o;
  return   Objects.equals(this.type, objURIParamToken.type)&&
  Objects.equals(this.startIndex, objURIParamToken.startIndex)&&
  Objects.equals(this.endIndex, objURIParamToken.endIndex)&&
  Objects.equals(this.strValue, objURIParamToken.strValue);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class URIParamToken {\n");
      sb.append("    endIndex: ").append(toIndentedString(endIndex)).append("\n");
        sb.append("    startIndex: ").append(toIndentedString(startIndex)).append("\n");
        sb.append("    strValue: ").append(toIndentedString(strValue)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

