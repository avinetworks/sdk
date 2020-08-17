package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ChildProcessInfo is a POJO class extends AviRestResource that used for creating
 * ChildProcessInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChildProcessInfo  {
    @JsonProperty("memory")
    private Integer memory = null;

    @JsonProperty("pid")
    private Integer pid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Amount of memory (in mb) used by the sub process.
   * @return memory
   */
  public Integer getMemory() {
    return memory;
  }

  /**
   * This is the setter method to the attribute.
   * Amount of memory (in mb) used by the sub process.
   * @param memory set the memory.
   */
  public void setMemory(Integer  memory) {
    this.memory = memory;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Process id of the sub process.
   * @return pid
   */
  public Integer getPid() {
    return pid;
  }

  /**
   * This is the setter method to the attribute.
   * Process id of the sub process.
   * @param pid set the pid.
   */
  public void setPid(Integer  pid) {
    this.pid = pid;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ChildProcessInfo objChildProcessInfo = (ChildProcessInfo) o;
  return   Objects.equals(this.pid, objChildProcessInfo.pid)&&
  Objects.equals(this.memory, objChildProcessInfo.memory);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ChildProcessInfo {\n");
      sb.append("    memory: ").append(toIndentedString(memory)).append("\n");
        sb.append("    pid: ").append(toIndentedString(pid)).append("\n");
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

