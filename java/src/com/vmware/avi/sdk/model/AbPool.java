package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The AbPool is a POJO class extends AviRestResource that used for creating
 * AbPool.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AbPool  {
    @JsonProperty("pool_ref")
    private String poolRef = null;

    @JsonProperty("ratio")
    private Integer ratio = 0;



  /**
   * This is the getter method this will return the attribute value.
   * Pool configured as b pool for a/b testing.
   * It is a reference to an object of type pool.
   * @return poolRef
   */
  public String getPoolRef() {
    return poolRef;
  }

  /**
   * This is the setter method to the attribute.
   * Pool configured as b pool for a/b testing.
   * It is a reference to an object of type pool.
   * @param poolRef set the poolRef.
   */
  public void setPoolRef(String  poolRef) {
    this.poolRef = poolRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ratio of traffic diverted to the b pool, for a/b testing.
   * Allowed values are 0-100.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return ratio
   */
  public Integer getRatio() {
    return ratio;
  }

  /**
   * This is the setter method to the attribute.
   * Ratio of traffic diverted to the b pool, for a/b testing.
   * Allowed values are 0-100.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param ratio set the ratio.
   */
  public void setRatio(Integer  ratio) {
    this.ratio = ratio;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  AbPool objAbPool = (AbPool) o;
  return   Objects.equals(this.poolRef, objAbPool.poolRef)&&
  Objects.equals(this.ratio, objAbPool.ratio);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class AbPool {\n");
      sb.append("    poolRef: ").append(toIndentedString(poolRef)).append("\n");
        sb.append("    ratio: ").append(toIndentedString(ratio)).append("\n");
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

