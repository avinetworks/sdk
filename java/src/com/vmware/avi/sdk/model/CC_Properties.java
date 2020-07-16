package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The CC_Properties is a POJO class extends AviRestResource that used for creating
 * CC_Properties.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CC_Properties  {
    @JsonProperty("rpc_poll_interval")
    private Integer rpcPollInterval = 60;

    @JsonProperty("rpc_queue_size")
    private Integer rpcQueueSize = 100;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property rpc_poll_interval of obj type cc_properties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @return rpcPollInterval
   */
  public Integer getRpcPollInterval() {
    return rpcPollInterval;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property rpc_poll_interval of obj type cc_properties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 60.
   * @param rpcPollInterval set the rpcPollInterval.
   */
  public void setRpcPollInterval(Integer  rpcPollInterval) {
    this.rpcPollInterval = rpcPollInterval;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property rpc_queue_size of obj type cc_properties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100.
   * @return rpcQueueSize
   */
  public Integer getRpcQueueSize() {
    return rpcQueueSize;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property rpc_queue_size of obj type cc_properties field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100.
   * @param rpcQueueSize set the rpcQueueSize.
   */
  public void setRpcQueueSize(Integer  rpcQueueSize) {
    this.rpcQueueSize = rpcQueueSize;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  CC_Properties objCC_Properties = (CC_Properties) o;
  return   Objects.equals(this.rpcQueueSize, objCC_Properties.rpcQueueSize)&&
  Objects.equals(this.rpcPollInterval, objCC_Properties.rpcPollInterval);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class CC_Properties {\n");
      sb.append("    rpcPollInterval: ").append(toIndentedString(rpcPollInterval)).append("\n");
        sb.append("    rpcQueueSize: ").append(toIndentedString(rpcQueueSize)).append("\n");
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

