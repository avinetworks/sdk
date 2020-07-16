package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The HTTPHdrData is a POJO class extends AviRestResource that used for creating
 * HTTPHdrData.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HTTPHdrData  {
    @JsonProperty("name")
    private String name = null;

    @JsonProperty("value")
    private HTTPHdrValue value = null;



  /**
   * This is the getter method this will return the attribute value.
   * Http header name.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Http header name.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Http header value.
   * @return value
   */
  public HTTPHdrValue getValue() {
    return value;
  }

  /**
   * This is the setter method to the attribute.
   * Http header value.
   * @param value set the value.
   */
  public void setValue(HTTPHdrValue value) {
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
  HTTPHdrData objHTTPHdrData = (HTTPHdrData) o;
  return   Objects.equals(this.name, objHTTPHdrData.name)&&
  Objects.equals(this.value, objHTTPHdrData.value);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class HTTPHdrData {\n");
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

