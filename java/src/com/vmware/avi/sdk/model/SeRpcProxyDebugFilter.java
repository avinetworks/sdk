package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SeRpcProxyDebugFilter is a POJO class extends AviRestResource that used for creating
 * SeRpcProxyDebugFilter.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeRpcProxyDebugFilter  {
    @JsonProperty("method_name")
    private String methodName = null;

    @JsonProperty("queue")
    private String queue = null;

    @JsonProperty("se_uuid")
    private String seUuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Method name of rpc.
   * Field introduced in 18.1.5, 18.2.1.
   * @return methodName
   */
  public String getMethodName() {
    return methodName;
  }

  /**
   * This is the setter method to the attribute.
   * Method name of rpc.
   * Field introduced in 18.1.5, 18.2.1.
   * @param methodName set the methodName.
   */
  public void setMethodName(String  methodName) {
    this.methodName = methodName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Queue name of rpc.
   * Field introduced in 18.1.5, 18.2.1.
   * @return queue
   */
  public String getQueue() {
    return queue;
  }

  /**
   * This is the setter method to the attribute.
   * Queue name of rpc.
   * Field introduced in 18.1.5, 18.2.1.
   * @param queue set the queue.
   */
  public void setQueue(String  queue) {
    this.queue = queue;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Uuid of service engine.
   * Field introduced in 18.1.5, 18.2.1.
   * @return seUuid
   */
  public String getSeUuid() {
    return seUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of service engine.
   * Field introduced in 18.1.5, 18.2.1.
   * @param seUuid set the seUuid.
   */
  public void setSeUuid(String  seUuid) {
    this.seUuid = seUuid;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SeRpcProxyDebugFilter objSeRpcProxyDebugFilter = (SeRpcProxyDebugFilter) o;
  return   Objects.equals(this.methodName, objSeRpcProxyDebugFilter.methodName)&&
  Objects.equals(this.seUuid, objSeRpcProxyDebugFilter.seUuid)&&
  Objects.equals(this.queue, objSeRpcProxyDebugFilter.queue);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SeRpcProxyDebugFilter {\n");
      sb.append("    methodName: ").append(toIndentedString(methodName)).append("\n");
        sb.append("    queue: ").append(toIndentedString(queue)).append("\n");
        sb.append("    seUuid: ").append(toIndentedString(seUuid)).append("\n");
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

