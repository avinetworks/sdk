package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SecMgrDataEvent is a POJO class extends AviRestResource that used for creating
 * SecMgrDataEvent.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SecMgrDataEvent  {
    @JsonProperty("error")
    private String error = null;

    @JsonProperty("name")
    private String name = null;



  /**
   * This is the getter method this will return the attribute value.
   * Type of the generated for an application.
   * Field introduced in 20.1.1.
   * @return error
   */
  public String getError() {
    return error;
  }

  /**
   * This is the setter method to the attribute.
   * Type of the generated for an application.
   * Field introduced in 20.1.1.
   * @param error set the error.
   */
  public void setError(String  error) {
    this.error = error;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the application.
   * Field introduced in 20.1.1.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the application.
   * Field introduced in 20.1.1.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SecMgrDataEvent objSecMgrDataEvent = (SecMgrDataEvent) o;
  return   Objects.equals(this.name, objSecMgrDataEvent.name)&&
  Objects.equals(this.error, objSecMgrDataEvent.error);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SecMgrDataEvent {\n");
      sb.append("    error: ").append(toIndentedString(error)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

