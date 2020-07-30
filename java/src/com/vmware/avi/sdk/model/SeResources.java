package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SeResources is a POJO class extends AviRestResource that used for creating
 * SeResources.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeResources  {
    @JsonProperty("cores_per_socket")
    private Integer coresPerSocket = null;

    @JsonProperty("disk")
    private Integer disk = null;

    @JsonProperty("hyper_threading")
    private Boolean hyperThreading = null;

    @JsonProperty("hypervisor_mode")
    private Boolean hypervisorMode = null;

    @JsonProperty("memory")
    private Integer memory = null;

    @JsonProperty("num_datapath_processes")
    private Integer numDatapathProcesses = null;

    @JsonProperty("num_vcpus")
    private Integer numVcpus = null;

    @JsonProperty("sockets")
    private Integer sockets = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cores_per_socket of obj type seresources field type str  type integer.
   * @return coresPerSocket
   */
  public Integer getCoresPerSocket() {
    return coresPerSocket;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cores_per_socket of obj type seresources field type str  type integer.
   * @param coresPerSocket set the coresPerSocket.
   */
  public void setCoresPerSocket(Integer  coresPerSocket) {
    this.coresPerSocket = coresPerSocket;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property disk of obj type seresources field type str  type integer.
   * @return disk
   */
  public Integer getDisk() {
    return disk;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property disk of obj type seresources field type str  type integer.
   * @param disk set the disk.
   */
  public void setDisk(Integer  disk) {
    this.disk = disk;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property hyper_threading of obj type seresources field type str  type boolean.
   * @return hyperThreading
   */
  public Boolean getHyperThreading() {
    return hyperThreading;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property hyper_threading of obj type seresources field type str  type boolean.
   * @param hyperThreading set the hyperThreading.
   */
  public void setHyperThreading(Boolean  hyperThreading) {
    this.hyperThreading = hyperThreading;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Indicates that the se is running on a virtual machine.
   * Field introduced in 20.1.1.
   * @return hypervisorMode
   */
  public Boolean getHypervisorMode() {
    return hypervisorMode;
  }

  /**
   * This is the setter method to the attribute.
   * Indicates that the se is running on a virtual machine.
   * Field introduced in 20.1.1.
   * @param hypervisorMode set the hypervisorMode.
   */
  public void setHypervisorMode(Boolean  hypervisorMode) {
    this.hypervisorMode = hypervisorMode;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property memory of obj type seresources field type str  type integer.
   * @return memory
   */
  public Integer getMemory() {
    return memory;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property memory of obj type seresources field type str  type integer.
   * @param memory set the memory.
   */
  public void setMemory(Integer  memory) {
    this.memory = memory;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Indicates the number of datapath processes spawned.
   * Field introduced in 20.1.1.
   * @return numDatapathProcesses
   */
  public Integer getNumDatapathProcesses() {
    return numDatapathProcesses;
  }

  /**
   * This is the setter method to the attribute.
   * Indicates the number of datapath processes spawned.
   * Field introduced in 20.1.1.
   * @param numDatapathProcesses set the numDatapathProcesses.
   */
  public void setNumDatapathProcesses(Integer  numDatapathProcesses) {
    this.numDatapathProcesses = numDatapathProcesses;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property num_vcpus of obj type seresources field type str  type integer.
   * @return numVcpus
   */
  public Integer getNumVcpus() {
    return numVcpus;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property num_vcpus of obj type seresources field type str  type integer.
   * @param numVcpus set the numVcpus.
   */
  public void setNumVcpus(Integer  numVcpus) {
    this.numVcpus = numVcpus;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property sockets of obj type seresources field type str  type integer.
   * @return sockets
   */
  public Integer getSockets() {
    return sockets;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property sockets of obj type seresources field type str  type integer.
   * @param sockets set the sockets.
   */
  public void setSockets(Integer  sockets) {
    this.sockets = sockets;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SeResources objSeResources = (SeResources) o;
  return   Objects.equals(this.numVcpus, objSeResources.numVcpus)&&
  Objects.equals(this.memory, objSeResources.memory)&&
  Objects.equals(this.disk, objSeResources.disk)&&
  Objects.equals(this.hyperThreading, objSeResources.hyperThreading)&&
  Objects.equals(this.sockets, objSeResources.sockets)&&
  Objects.equals(this.coresPerSocket, objSeResources.coresPerSocket)&&
  Objects.equals(this.hypervisorMode, objSeResources.hypervisorMode)&&
  Objects.equals(this.numDatapathProcesses, objSeResources.numDatapathProcesses);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SeResources {\n");
      sb.append("    coresPerSocket: ").append(toIndentedString(coresPerSocket)).append("\n");
        sb.append("    disk: ").append(toIndentedString(disk)).append("\n");
        sb.append("    hyperThreading: ").append(toIndentedString(hyperThreading)).append("\n");
        sb.append("    hypervisorMode: ").append(toIndentedString(hypervisorMode)).append("\n");
        sb.append("    memory: ").append(toIndentedString(memory)).append("\n");
        sb.append("    numDatapathProcesses: ").append(toIndentedString(numDatapathProcesses)).append("\n");
        sb.append("    numVcpus: ").append(toIndentedString(numVcpus)).append("\n");
        sb.append("    sockets: ").append(toIndentedString(sockets)).append("\n");
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

