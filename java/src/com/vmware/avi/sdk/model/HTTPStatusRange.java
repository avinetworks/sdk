package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The HTTPStatusRange is a POJO class extends AviRestResource that used for creating
 * HTTPStatusRange.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HTTPStatusRange  {
    @JsonProperty("begin")
    private Integer begin = null;

    @JsonProperty("end")
    private Integer end = null;



  /**
   * This is the getter method this will return the attribute value.
   * Starting http response status code.
   * @return begin
   */
  public Integer getBegin() {
    return begin;
  }

  /**
   * This is the setter method to the attribute.
   * Starting http response status code.
   * @param begin set the begin.
   */
  public void setBegin(Integer  begin) {
    this.begin = begin;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ending http response status code.
   * @return end
   */
  public Integer getEnd() {
    return end;
  }

  /**
   * This is the setter method to the attribute.
   * Ending http response status code.
   * @param end set the end.
   */
  public void setEnd(Integer  end) {
    this.end = end;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  HTTPStatusRange objHTTPStatusRange = (HTTPStatusRange) o;
  return   Objects.equals(this.begin, objHTTPStatusRange.begin)&&
  Objects.equals(this.end, objHTTPStatusRange.end);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class HTTPStatusRange {\n");
      sb.append("    begin: ").append(toIndentedString(begin)).append("\n");
        sb.append("    end: ").append(toIndentedString(end)).append("\n");
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

