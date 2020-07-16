package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The MemoryBalancerInfo is a POJO class extends AviRestResource that used for creating
 * MemoryBalancerInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemoryBalancerInfo  {
    @JsonProperty("child")
    private List<ChildProcessInfo> child = null;

    @JsonProperty("controller_memory")
    private Integer controllerMemory = null;

    @JsonProperty("limit")
    private Integer limit = null;

    @JsonProperty("memory_used")
    private Integer memoryUsed = null;

    @JsonProperty("pid")
    private Integer pid = null;

    @JsonProperty("process")
    private String process = null;


  /**
   * This is the getter method this will return the attribute value.
   * Child process information.
   * @return child
   */
  public List<ChildProcessInfo> getChild() {
    return child;
  }

  /**
   * This is the setter method. this will set the child
   * Child process information.
   * @return child
   */
  public void setChild(List<ChildProcessInfo>  child) {
    this.child = child;
  }

  /**
   * This is the setter method this will set the child
   * Child process information.
   * @return child
   */
  public MemoryBalancerInfo addChildItem(ChildProcessInfo childItem) {
    if (this.child == null) {
      this.child = new ArrayList<ChildProcessInfo>();
    }
    this.child.add(childItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Controller memory.
   * @return controllerMemory
   */
  public Integer getControllerMemory() {
    return controllerMemory;
  }

  /**
   * This is the setter method to the attribute.
   * Controller memory.
   * @param controllerMemory set the controllerMemory.
   */
  public void setControllerMemory(Integer  controllerMemory) {
    this.controllerMemory = controllerMemory;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Limit on the memory (in mb) for the process.
   * @return limit
   */
  public Integer getLimit() {
    return limit;
  }

  /**
   * This is the setter method to the attribute.
   * Limit on the memory (in mb) for the process.
   * @param limit set the limit.
   */
  public void setLimit(Integer  limit) {
    this.limit = limit;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Amount of memory (in mb) used by the process.
   * @return memoryUsed
   */
  public Integer getMemoryUsed() {
    return memoryUsed;
  }

  /**
   * This is the setter method to the attribute.
   * Amount of memory (in mb) used by the process.
   * @param memoryUsed set the memoryUsed.
   */
  public void setMemoryUsed(Integer  memoryUsed) {
    this.memoryUsed = memoryUsed;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Pid of the process.
   * @return pid
   */
  public Integer getPid() {
    return pid;
  }

  /**
   * This is the setter method to the attribute.
   * Pid of the process.
   * @param pid set the pid.
   */
  public void setPid(Integer  pid) {
    this.pid = pid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the process.
   * @return process
   */
  public String getProcess() {
    return process;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the process.
   * @param process set the process.
   */
  public void setProcess(String  process) {
    this.process = process;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  MemoryBalancerInfo objMemoryBalancerInfo = (MemoryBalancerInfo) o;
  return   Objects.equals(this.memoryUsed, objMemoryBalancerInfo.memoryUsed)&&
  Objects.equals(this.process, objMemoryBalancerInfo.process)&&
  Objects.equals(this.pid, objMemoryBalancerInfo.pid)&&
  Objects.equals(this.limit, objMemoryBalancerInfo.limit)&&
  Objects.equals(this.child, objMemoryBalancerInfo.child)&&
  Objects.equals(this.controllerMemory, objMemoryBalancerInfo.controllerMemory);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class MemoryBalancerInfo {\n");
      sb.append("    child: ").append(toIndentedString(child)).append("\n");
        sb.append("    controllerMemory: ").append(toIndentedString(controllerMemory)).append("\n");
        sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
        sb.append("    memoryUsed: ").append(toIndentedString(memoryUsed)).append("\n");
        sb.append("    pid: ").append(toIndentedString(pid)).append("\n");
        sb.append("    process: ").append(toIndentedString(process)).append("\n");
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

