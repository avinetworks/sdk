package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The TimeStamp is a POJO class extends AviRestResource that used for creating
 * TimeStamp.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TimeStamp  {
    @JsonProperty("secs")
    private Integer secs = null;

    @JsonProperty("usecs")
    private Integer usecs = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property secs of obj type timestamp field type str  type integer.
   * @return secs
   */
  public Integer getSecs() {
    return secs;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property secs of obj type timestamp field type str  type integer.
   * @param secs set the secs.
   */
  public void setSecs(Integer  secs) {
    this.secs = secs;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property usecs of obj type timestamp field type str  type integer.
   * @return usecs
   */
  public Integer getUsecs() {
    return usecs;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property usecs of obj type timestamp field type str  type integer.
   * @param usecs set the usecs.
   */
  public void setUsecs(Integer  usecs) {
    this.usecs = usecs;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  TimeStamp objTimeStamp = (TimeStamp) o;
  return   Objects.equals(this.secs, objTimeStamp.secs)&&
  Objects.equals(this.usecs, objTimeStamp.usecs);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class TimeStamp {\n");
      sb.append("    secs: ").append(toIndentedString(secs)).append("\n");
        sb.append("    usecs: ").append(toIndentedString(usecs)).append("\n");
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

