package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The WafPSMMatchElement is a POJO class extends AviRestResource that used for creating
 * WafPSMMatchElement.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WafPSMMatchElement  {
    @JsonProperty("excluded")
    private Boolean excluded = false;

    @JsonProperty("index")
    private Integer index = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("sub_element")
    private String subElement = null;



  /**
   * This is the getter method this will return the attribute value.
   * Mark this element excluded, like in '!args password'.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return excluded
   */
  public Boolean getExcluded() {
    return excluded;
  }

  /**
   * This is the setter method to the attribute.
   * Mark this element excluded, like in '!args password'.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param excluded set the excluded.
   */
  public void setExcluded(Boolean  excluded) {
    this.excluded = excluded;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Match_element index.
   * Field introduced in 18.2.3.
   * @return index
   */
  public Integer getIndex() {
    return index;
  }

  /**
   * This is the setter method to the attribute.
   * Match_element index.
   * Field introduced in 18.2.3.
   * @param index set the index.
   */
  public void setIndex(Integer  index) {
    this.index = index;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The variable specification.
   * For example args or request_cookies.
   * This can be a scalar like path_info.
   * Enum options - WAF_VARIABLE_ARGS, WAF_VARIABLE_ARGS_GET, WAF_VARIABLE_ARGS_POST, WAF_VARIABLE_ARGS_NAMES, WAF_VARIABLE_REQUEST_COOKIES,
   * WAF_VARIABLE_QUERY_STRING, WAF_VARIABLE_REQUEST_BASENAME, WAF_VARIABLE_REQUEST_URI, WAF_VARIABLE_PATH_INFO.
   * Field introduced in 18.2.3.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * The variable specification.
   * For example args or request_cookies.
   * This can be a scalar like path_info.
   * Enum options - WAF_VARIABLE_ARGS, WAF_VARIABLE_ARGS_GET, WAF_VARIABLE_ARGS_POST, WAF_VARIABLE_ARGS_NAMES, WAF_VARIABLE_REQUEST_COOKIES,
   * WAF_VARIABLE_QUERY_STRING, WAF_VARIABLE_REQUEST_BASENAME, WAF_VARIABLE_REQUEST_URI, WAF_VARIABLE_PATH_INFO.
   * Field introduced in 18.2.3.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The name of the request collection element.
   * This can be empty, if we address the whole collection or a scalar element.
   * Field introduced in 18.2.3.
   * @return subElement
   */
  public String getSubElement() {
    return subElement;
  }

  /**
   * This is the setter method to the attribute.
   * The name of the request collection element.
   * This can be empty, if we address the whole collection or a scalar element.
   * Field introduced in 18.2.3.
   * @param subElement set the subElement.
   */
  public void setSubElement(String  subElement) {
    this.subElement = subElement;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  WafPSMMatchElement objWafPSMMatchElement = (WafPSMMatchElement) o;
  return   Objects.equals(this.index, objWafPSMMatchElement.index)&&
  Objects.equals(this.name, objWafPSMMatchElement.name)&&
  Objects.equals(this.subElement, objWafPSMMatchElement.subElement)&&
  Objects.equals(this.excluded, objWafPSMMatchElement.excluded);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class WafPSMMatchElement {\n");
      sb.append("    excluded: ").append(toIndentedString(excluded)).append("\n");
        sb.append("    index: ").append(toIndentedString(index)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    subElement: ").append(toIndentedString(subElement)).append("\n");
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

