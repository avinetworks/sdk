package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SeVnicTxQueueStallEventDetails is a POJO class extends AviRestResource that used for creating
 * SeVnicTxQueueStallEventDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeVnicTxQueueStallEventDetails  {
    @JsonProperty("if_name")
    private String ifName = null;

    @JsonProperty("linux_name")
    private String linuxName = null;

    @JsonProperty("queue")
    private Integer queue = null;

    @JsonProperty("se_ref")
    private String seRef = null;



  /**
   * This is the getter method this will return the attribute value.
   * Vnic name.
   * @return ifName
   */
  public String getIfName() {
    return ifName;
  }

  /**
   * This is the setter method to the attribute.
   * Vnic name.
   * @param ifName set the ifName.
   */
  public void setIfName(String  ifName) {
    this.ifName = ifName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Vnic linux name.
   * @return linuxName
   */
  public String getLinuxName() {
    return linuxName;
  }

  /**
   * This is the setter method to the attribute.
   * Vnic linux name.
   * @param linuxName set the linuxName.
   */
  public void setLinuxName(String  linuxName) {
    this.linuxName = linuxName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Queue number.
   * @return queue
   */
  public Integer getQueue() {
    return queue;
  }

  /**
   * This is the setter method to the attribute.
   * Queue number.
   * @param queue set the queue.
   */
  public void setQueue(Integer  queue) {
    this.queue = queue;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Uuid of the se responsible for this event.
   * It is a reference to an object of type serviceengine.
   * @return seRef
   */
  public String getSeRef() {
    return seRef;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the se responsible for this event.
   * It is a reference to an object of type serviceengine.
   * @param seRef set the seRef.
   */
  public void setSeRef(String  seRef) {
    this.seRef = seRef;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SeVnicTxQueueStallEventDetails objSeVnicTxQueueStallEventDetails = (SeVnicTxQueueStallEventDetails) o;
  return   Objects.equals(this.seRef, objSeVnicTxQueueStallEventDetails.seRef)&&
  Objects.equals(this.linuxName, objSeVnicTxQueueStallEventDetails.linuxName)&&
  Objects.equals(this.ifName, objSeVnicTxQueueStallEventDetails.ifName)&&
  Objects.equals(this.queue, objSeVnicTxQueueStallEventDetails.queue);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SeVnicTxQueueStallEventDetails {\n");
      sb.append("    ifName: ").append(toIndentedString(ifName)).append("\n");
        sb.append("    linuxName: ").append(toIndentedString(linuxName)).append("\n");
        sb.append("    queue: ").append(toIndentedString(queue)).append("\n");
        sb.append("    seRef: ").append(toIndentedString(seRef)).append("\n");
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

