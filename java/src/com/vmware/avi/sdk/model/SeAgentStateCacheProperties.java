package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SeAgentStateCacheProperties is a POJO class extends AviRestResource that used for creating
 * SeAgentStateCacheProperties.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeAgentStateCacheProperties  {
    @JsonProperty("sc_batch_buffer_flush_limit")
    private Integer scBatchBufferFlushLimit = 300;

    @JsonProperty("sc_shard_cleanup_max_time")
    private Integer scShardCleanupMaxTime = 900;

    @JsonProperty("sc_state_ring_batch_dequeue_limit")
    private Integer scStateRingBatchDequeueLimit = 300;

    @JsonProperty("sc_states_flush_interval")
    private Integer scStatesFlushInterval = 100;

    @JsonProperty("sc_stream_check_interval")
    private Integer scStreamCheckInterval = 5000;

    @JsonProperty("sc_thread_q_batch_dequeue_limit")
    private Integer scThreadQBatchDequeueLimit = 100;

    @JsonProperty("sc_thread_q_max_size")
    private Integer scThreadQMaxSize = 4096;

    @JsonProperty("sc_thread_sleep_interval")
    private Integer scThreadSleepInterval = 10;



  /**
   * This is the getter method this will return the attribute value.
   * Max elements to flush in one shot from the internal buffer by the statecache thread.
   * Allowed values are 1-10000.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 300.
   * @return scBatchBufferFlushLimit
   */
  public Integer getScBatchBufferFlushLimit() {
    return scBatchBufferFlushLimit;
  }

  /**
   * This is the setter method to the attribute.
   * Max elements to flush in one shot from the internal buffer by the statecache thread.
   * Allowed values are 1-10000.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 300.
   * @param scBatchBufferFlushLimit set the scBatchBufferFlushLimit.
   */
  public void setScBatchBufferFlushLimit(Integer  scBatchBufferFlushLimit) {
    this.scBatchBufferFlushLimit = scBatchBufferFlushLimit;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Max time to wait by the statecache thread before cleaning up connection to the controller shard.
   * Allowed values are 1-1000000.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 900.
   * @return scShardCleanupMaxTime
   */
  public Integer getScShardCleanupMaxTime() {
    return scShardCleanupMaxTime;
  }

  /**
   * This is the setter method to the attribute.
   * Max time to wait by the statecache thread before cleaning up connection to the controller shard.
   * Allowed values are 1-1000000.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 900.
   * @param scShardCleanupMaxTime set the scShardCleanupMaxTime.
   */
  public void setScShardCleanupMaxTime(Integer  scShardCleanupMaxTime) {
    this.scShardCleanupMaxTime = scShardCleanupMaxTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Max elements to dequeue in one shot from the state_ring by the statecache thread.
   * Allowed values are 1-10000.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 300.
   * @return scStateRingBatchDequeueLimit
   */
  public Integer getScStateRingBatchDequeueLimit() {
    return scStateRingBatchDequeueLimit;
  }

  /**
   * This is the setter method to the attribute.
   * Max elements to dequeue in one shot from the state_ring by the statecache thread.
   * Allowed values are 1-10000.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 300.
   * @param scStateRingBatchDequeueLimit set the scStateRingBatchDequeueLimit.
   */
  public void setScStateRingBatchDequeueLimit(Integer  scStateRingBatchDequeueLimit) {
    this.scStateRingBatchDequeueLimit = scStateRingBatchDequeueLimit;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Interval for update of operational states to controller.
   * Allowed values are 1-10000.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100.
   * @return scStatesFlushInterval
   */
  public Integer getScStatesFlushInterval() {
    return scStatesFlushInterval;
  }

  /**
   * This is the setter method to the attribute.
   * Interval for update of operational states to controller.
   * Allowed values are 1-10000.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100.
   * @param scStatesFlushInterval set the scStatesFlushInterval.
   */
  public void setScStatesFlushInterval(Integer  scStatesFlushInterval) {
    this.scStatesFlushInterval = scStatesFlushInterval;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Interval for checking health of grpc streams to statecache_mgr.
   * Allowed values are 1-90000.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5000.
   * @return scStreamCheckInterval
   */
  public Integer getScStreamCheckInterval() {
    return scStreamCheckInterval;
  }

  /**
   * This is the setter method to the attribute.
   * Interval for checking health of grpc streams to statecache_mgr.
   * Allowed values are 1-90000.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5000.
   * @param scStreamCheckInterval set the scStreamCheckInterval.
   */
  public void setScStreamCheckInterval(Integer  scStreamCheckInterval) {
    this.scStreamCheckInterval = scStreamCheckInterval;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Max elements to dequeue in one shot from the q by the statecache thread.
   * Allowed values are 1-10000.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100.
   * @return scThreadQBatchDequeueLimit
   */
  public Integer getScThreadQBatchDequeueLimit() {
    return scThreadQBatchDequeueLimit;
  }

  /**
   * This is the setter method to the attribute.
   * Max elements to dequeue in one shot from the q by the statecache thread.
   * Allowed values are 1-10000.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100.
   * @param scThreadQBatchDequeueLimit set the scThreadQBatchDequeueLimit.
   */
  public void setScThreadQBatchDequeueLimit(Integer  scThreadQBatchDequeueLimit) {
    this.scThreadQBatchDequeueLimit = scThreadQBatchDequeueLimit;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Max elements in the q between seagent main and the statecache thread.
   * Allowed values are 1-10000.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4096.
   * @return scThreadQMaxSize
   */
  public Integer getScThreadQMaxSize() {
    return scThreadQMaxSize;
  }

  /**
   * This is the setter method to the attribute.
   * Max elements in the q between seagent main and the statecache thread.
   * Allowed values are 1-10000.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4096.
   * @param scThreadQMaxSize set the scThreadQMaxSize.
   */
  public void setScThreadQMaxSize(Integer  scThreadQMaxSize) {
    this.scThreadQMaxSize = scThreadQMaxSize;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Interval for grpc thread to sleep between doing work.
   * Allowed values are 1-10000.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.
   * @return scThreadSleepInterval
   */
  public Integer getScThreadSleepInterval() {
    return scThreadSleepInterval;
  }

  /**
   * This is the setter method to the attribute.
   * Interval for grpc thread to sleep between doing work.
   * Allowed values are 1-10000.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.
   * @param scThreadSleepInterval set the scThreadSleepInterval.
   */
  public void setScThreadSleepInterval(Integer  scThreadSleepInterval) {
    this.scThreadSleepInterval = scThreadSleepInterval;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SeAgentStateCacheProperties objSeAgentStateCacheProperties = (SeAgentStateCacheProperties) o;
  return   Objects.equals(this.scThreadQBatchDequeueLimit, objSeAgentStateCacheProperties.scThreadQBatchDequeueLimit)&&
  Objects.equals(this.scBatchBufferFlushLimit, objSeAgentStateCacheProperties.scBatchBufferFlushLimit)&&
  Objects.equals(this.scThreadQMaxSize, objSeAgentStateCacheProperties.scThreadQMaxSize)&&
  Objects.equals(this.scStreamCheckInterval, objSeAgentStateCacheProperties.scStreamCheckInterval)&&
  Objects.equals(this.scStateRingBatchDequeueLimit, objSeAgentStateCacheProperties.scStateRingBatchDequeueLimit)&&
  Objects.equals(this.scStatesFlushInterval, objSeAgentStateCacheProperties.scStatesFlushInterval)&&
  Objects.equals(this.scThreadSleepInterval, objSeAgentStateCacheProperties.scThreadSleepInterval)&&
  Objects.equals(this.scShardCleanupMaxTime, objSeAgentStateCacheProperties.scShardCleanupMaxTime);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SeAgentStateCacheProperties {\n");
      sb.append("    scBatchBufferFlushLimit: ").append(toIndentedString(scBatchBufferFlushLimit)).append("\n");
        sb.append("    scShardCleanupMaxTime: ").append(toIndentedString(scShardCleanupMaxTime)).append("\n");
        sb.append("    scStateRingBatchDequeueLimit: ").append(toIndentedString(scStateRingBatchDequeueLimit)).append("\n");
        sb.append("    scStatesFlushInterval: ").append(toIndentedString(scStatesFlushInterval)).append("\n");
        sb.append("    scStreamCheckInterval: ").append(toIndentedString(scStreamCheckInterval)).append("\n");
        sb.append("    scThreadQBatchDequeueLimit: ").append(toIndentedString(scThreadQBatchDequeueLimit)).append("\n");
        sb.append("    scThreadQMaxSize: ").append(toIndentedString(scThreadQMaxSize)).append("\n");
        sb.append("    scThreadSleepInterval: ").append(toIndentedString(scThreadSleepInterval)).append("\n");
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

