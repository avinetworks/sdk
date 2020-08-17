package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The GslbGeoDbEntry is a POJO class extends AviRestResource that used for creating
 * GslbGeoDbEntry.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GslbGeoDbEntry  {
    @JsonProperty("file")
    private GslbGeoDbFile file = null;

    @JsonProperty("priority")
    private Integer priority = 10;



  /**
   * This is the getter method this will return the attribute value.
   * This field describes the geodb file.
   * Field introduced in 17.1.1.
   * @return file
   */
  public GslbGeoDbFile getFile() {
    return file;
  }

  /**
   * This is the setter method to the attribute.
   * This field describes the geodb file.
   * Field introduced in 17.1.1.
   * @param file set the file.
   */
  public void setFile(GslbGeoDbFile file) {
    this.file = file;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Priority of this geodb entry.
   * This value should be unique in a repeated list of geodb entries.
   * Higher the value, then greater is the priority.
   * Allowed values are 1-100.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.
   * @return priority
   */
  public Integer getPriority() {
    return priority;
  }

  /**
   * This is the setter method to the attribute.
   * Priority of this geodb entry.
   * This value should be unique in a repeated list of geodb entries.
   * Higher the value, then greater is the priority.
   * Allowed values are 1-100.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.
   * @param priority set the priority.
   */
  public void setPriority(Integer  priority) {
    this.priority = priority;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  GslbGeoDbEntry objGslbGeoDbEntry = (GslbGeoDbEntry) o;
  return   Objects.equals(this.priority, objGslbGeoDbEntry.priority)&&
  Objects.equals(this.file, objGslbGeoDbEntry.file);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class GslbGeoDbEntry {\n");
      sb.append("    file: ").append(toIndentedString(file)).append("\n");
        sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
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

