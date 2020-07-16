package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The RediscoverVcenterParam is a POJO class extends AviRestResource that used for creating
 * RediscoverVcenterParam.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RediscoverVcenterParam  {
    @JsonProperty("cloud")
    private String cloud = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cloud of obj type rediscovervcenterparam field type str  type string.
   * @return cloud
   */
  public String getCloud() {
    return cloud;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cloud of obj type rediscovervcenterparam field type str  type string.
   * @param cloud set the cloud.
   */
  public void setCloud(String  cloud) {
    this.cloud = cloud;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  RediscoverVcenterParam objRediscoverVcenterParam = (RediscoverVcenterParam) o;
  return   Objects.equals(this.cloud, objRediscoverVcenterParam.cloud);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class RediscoverVcenterParam {\n");
      sb.append("    cloud: ").append(toIndentedString(cloud)).append("\n");
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

