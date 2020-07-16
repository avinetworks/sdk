package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DebugSeCpuShares is a POJO class extends AviRestResource that used for creating
 * DebugSeCpuShares.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DebugSeCpuShares  {
    @JsonProperty("cpu")
    private Integer cpu = null;

    @JsonProperty("shares")
    private Integer shares = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cpu of obj type debugsecpushares field type str  type integer.
   * @return cpu
   */
  public Integer getCpu() {
    return cpu;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cpu of obj type debugsecpushares field type str  type integer.
   * @param cpu set the cpu.
   */
  public void setCpu(Integer  cpu) {
    this.cpu = cpu;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property shares of obj type debugsecpushares field type str  type integer.
   * @return shares
   */
  public Integer getShares() {
    return shares;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property shares of obj type debugsecpushares field type str  type integer.
   * @param shares set the shares.
   */
  public void setShares(Integer  shares) {
    this.shares = shares;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  DebugSeCpuShares objDebugSeCpuShares = (DebugSeCpuShares) o;
  return   Objects.equals(this.cpu, objDebugSeCpuShares.cpu)&&
  Objects.equals(this.shares, objDebugSeCpuShares.shares);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DebugSeCpuShares {\n");
      sb.append("    cpu: ").append(toIndentedString(cpu)).append("\n");
        sb.append("    shares: ").append(toIndentedString(shares)).append("\n");
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

