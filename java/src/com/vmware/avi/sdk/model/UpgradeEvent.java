package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The UpgradeEvent is a POJO class extends AviRestResource that used for creating
 * UpgradeEvent.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpgradeEvent  {
    @JsonProperty("duration")
    private Integer duration = null;

    @JsonProperty("end_time")
    private String endTime = null;

    @JsonProperty("ip")
    private IpAddr ip = null;

    @JsonProperty("message")
    private String message = null;

    @JsonProperty("start_time")
    private String startTime = null;

    @JsonProperty("status")
    private Boolean status = false;

    @JsonProperty("sub_tasks")
    private List<String> subTasks = null;



  /**
   * This is the getter method this will return the attribute value.
   * Time taken to complete upgrade event in seconds.
   * Field introduced in 18.2.6.
   * @return duration
   */
  public Integer getDuration() {
    return duration;
  }

  /**
   * This is the setter method to the attribute.
   * Time taken to complete upgrade event in seconds.
   * Field introduced in 18.2.6.
   * @param duration set the duration.
   */
  public void setDuration(Integer  duration) {
    this.duration = duration;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Task end time.
   * Field introduced in 18.2.6.
   * @return endTime
   */
  public String getEndTime() {
    return endTime;
  }

  /**
   * This is the setter method to the attribute.
   * Task end time.
   * Field introduced in 18.2.6.
   * @param endTime set the endTime.
   */
  public void setEndTime(String  endTime) {
    this.endTime = endTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ip of the node.
   * Field introduced in 18.2.6.
   * @return ip
   */
  public IpAddr getIp() {
    return ip;
  }

  /**
   * This is the setter method to the attribute.
   * Ip of the node.
   * Field introduced in 18.2.6.
   * @param ip set the ip.
   */
  public void setIp(IpAddr ip) {
    this.ip = ip;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Upgrade event message if any.
   * Field introduced in 18.2.6.
   * @return message
   */
  public String getMessage() {
    return message;
  }

  /**
   * This is the setter method to the attribute.
   * Upgrade event message if any.
   * Field introduced in 18.2.6.
   * @param message set the message.
   */
  public void setMessage(String  message) {
    this.message = message;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Task start time.
   * Field introduced in 18.2.6.
   * @return startTime
   */
  public String getStartTime() {
    return startTime;
  }

  /**
   * This is the setter method to the attribute.
   * Task start time.
   * Field introduced in 18.2.6.
   * @param startTime set the startTime.
   */
  public void setStartTime(String  startTime) {
    this.startTime = startTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Upgrade event status.
   * Field introduced in 18.2.6.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return status
   */
  public Boolean getStatus() {
    return status;
  }

  /**
   * This is the setter method to the attribute.
   * Upgrade event status.
   * Field introduced in 18.2.6.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param status set the status.
   */
  public void setStatus(Boolean  status) {
    this.status = status;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Sub tasks executed on each node.
   * Field introduced in 18.2.8, 20.1.1.
   * @return subTasks
   */
  public List<String> getSubTasks() {
    return subTasks;
  }

  /**
   * This is the setter method. this will set the subTasks
   * Sub tasks executed on each node.
   * Field introduced in 18.2.8, 20.1.1.
   * @return subTasks
   */
  public void setSubTasks(List<String>  subTasks) {
    this.subTasks = subTasks;
  }

  /**
   * This is the setter method this will set the subTasks
   * Sub tasks executed on each node.
   * Field introduced in 18.2.8, 20.1.1.
   * @return subTasks
   */
  public UpgradeEvent addSubTasksItem(String subTasksItem) {
    if (this.subTasks == null) {
      this.subTasks = new ArrayList<String>();
    }
    this.subTasks.add(subTasksItem);
    return this;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  UpgradeEvent objUpgradeEvent = (UpgradeEvent) o;
  return   Objects.equals(this.status, objUpgradeEvent.status)&&
  Objects.equals(this.ip, objUpgradeEvent.ip)&&
  Objects.equals(this.startTime, objUpgradeEvent.startTime)&&
  Objects.equals(this.subTasks, objUpgradeEvent.subTasks)&&
  Objects.equals(this.endTime, objUpgradeEvent.endTime)&&
  Objects.equals(this.duration, objUpgradeEvent.duration)&&
  Objects.equals(this.message, objUpgradeEvent.message);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class UpgradeEvent {\n");
      sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
        sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
        sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    subTasks: ").append(toIndentedString(subTasks)).append("\n");
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

