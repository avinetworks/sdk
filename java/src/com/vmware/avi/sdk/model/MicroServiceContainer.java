package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The MicroServiceContainer is a POJO class extends AviRestResource that used for creating
 * MicroServiceContainer.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MicroServiceContainer  {
    @JsonProperty("container_id")
    private String containerId = null;

    @JsonProperty("host")
    private String host = null;

    @JsonProperty("ip")
    private IpAddr ip = null;

    @JsonProperty("port")
    private Integer port = null;

    @JsonProperty("task_id")
    private String taskId = null;



  /**
   * This is the getter method this will return the attribute value.
   * Id of the container.
   * @return containerId
   */
  public String getContainerId() {
    return containerId;
  }

  /**
   * This is the setter method to the attribute.
   * Id of the container.
   * @param containerId set the containerId.
   */
  public void setContainerId(String  containerId) {
    this.containerId = containerId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Id or name of the host where the container is.
   * @return host
   */
  public String getHost() {
    return host;
  }

  /**
   * This is the setter method to the attribute.
   * Id or name of the host where the container is.
   * @param host set the host.
   */
  public void setHost(String  host) {
    this.host = host;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ip address of the container.
   * @return ip
   */
  public IpAddr getIp() {
    return ip;
  }

  /**
   * This is the setter method to the attribute.
   * Ip address of the container.
   * @param ip set the ip.
   */
  public void setIp(IpAddr ip) {
    this.ip = ip;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Port nunber of the instance.
   * @return port
   */
  public Integer getPort() {
    return port;
  }

  /**
   * This is the setter method to the attribute.
   * Port nunber of the instance.
   * @param port set the port.
   */
  public void setPort(Integer  port) {
    this.port = port;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Marathon task id of the instance.
   * @return taskId
   */
  public String getTaskId() {
    return taskId;
  }

  /**
   * This is the setter method to the attribute.
   * Marathon task id of the instance.
   * @param taskId set the taskId.
   */
  public void setTaskId(String  taskId) {
    this.taskId = taskId;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  MicroServiceContainer objMicroServiceContainer = (MicroServiceContainer) o;
  return   Objects.equals(this.ip, objMicroServiceContainer.ip)&&
  Objects.equals(this.host, objMicroServiceContainer.host)&&
  Objects.equals(this.containerId, objMicroServiceContainer.containerId)&&
  Objects.equals(this.port, objMicroServiceContainer.port)&&
  Objects.equals(this.taskId, objMicroServiceContainer.taskId);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class MicroServiceContainer {\n");
      sb.append("    containerId: ").append(toIndentedString(containerId)).append("\n");
        sb.append("    host: ").append(toIndentedString(host)).append("\n");
        sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
        sb.append("    port: ").append(toIndentedString(port)).append("\n");
        sb.append("    taskId: ").append(toIndentedString(taskId)).append("\n");
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

