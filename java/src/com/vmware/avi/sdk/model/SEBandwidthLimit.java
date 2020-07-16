package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SEBandwidthLimit is a POJO class extends AviRestResource that used for creating
 * SEBandwidthLimit.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SEBandwidthLimit  {
    @JsonProperty("count")
    private Integer count = null;

    @JsonProperty("type")
    private String type = null;



  /**
   * This is the getter method this will return the attribute value.
   * Total number of service engines for bandwidth based licenses.
   * Field introduced in 17.2.5.
   * @return count
   */
  public Integer getCount() {
    return count;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of service engines for bandwidth based licenses.
   * Field introduced in 17.2.5.
   * @param count set the count.
   */
  public void setCount(Integer  count) {
    this.count = count;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum bandwidth allowed by each service engine.
   * Enum options - SE_BANDWIDTH_UNLIMITED, SE_BANDWIDTH_25M, SE_BANDWIDTH_200M, SE_BANDWIDTH_1000M, SE_BANDWIDTH_10000M.
   * Field introduced in 17.2.5.
   * @return type
   */
  public String getType() {
    return type;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum bandwidth allowed by each service engine.
   * Enum options - SE_BANDWIDTH_UNLIMITED, SE_BANDWIDTH_25M, SE_BANDWIDTH_200M, SE_BANDWIDTH_1000M, SE_BANDWIDTH_10000M.
   * Field introduced in 17.2.5.
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
  SEBandwidthLimit objSEBandwidthLimit = (SEBandwidthLimit) o;
  return   Objects.equals(this.count, objSEBandwidthLimit.count)&&
  Objects.equals(this.type, objSEBandwidthLimit.type);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SEBandwidthLimit {\n");
      sb.append("    count: ").append(toIndentedString(count)).append("\n");
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

