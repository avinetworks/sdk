package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DebugVrfContext is a POJO class extends AviRestResource that used for creating
 * DebugVrfContext.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DebugVrfContext  {
    @JsonProperty("command_buffer_interval")
    private Integer commandBufferInterval = 2;

    @JsonProperty("command_buffer_size")
    private Integer commandBufferSize = 32768;

    @JsonProperty("flags")
    private List<DebugVrf> flags = null;



  /**
   * This is the getter method this will return the attribute value.
   * Vrf config command buffer process interval.
   * Allowed values are 1-4.
   * Field introduced in 17.2.13,18.1.5,18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 2.
   * @return commandBufferInterval
   */
  public Integer getCommandBufferInterval() {
    return commandBufferInterval;
  }

  /**
   * This is the setter method to the attribute.
   * Vrf config command buffer process interval.
   * Allowed values are 1-4.
   * Field introduced in 17.2.13,18.1.5,18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 2.
   * @param commandBufferInterval set the commandBufferInterval.
   */
  public void setCommandBufferInterval(Integer  commandBufferInterval) {
    this.commandBufferInterval = commandBufferInterval;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Vrf config command buffer size.
   * Allowed values are 1-32768.
   * Field introduced in 17.2.13,18.1.5,18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 32768.
   * @return commandBufferSize
   */
  public Integer getCommandBufferSize() {
    return commandBufferSize;
  }

  /**
   * This is the setter method to the attribute.
   * Vrf config command buffer size.
   * Allowed values are 1-32768.
   * Field introduced in 17.2.13,18.1.5,18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 32768.
   * @param commandBufferSize set the commandBufferSize.
   */
  public void setCommandBufferSize(Integer  commandBufferSize) {
    this.commandBufferSize = commandBufferSize;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.1.1.
   * @return flags
   */
  public List<DebugVrf> getFlags() {
    return flags;
  }

  /**
   * This is the setter method. this will set the flags
   * Field introduced in 17.1.1.
   * @return flags
   */
  public void setFlags(List<DebugVrf>  flags) {
    this.flags = flags;
  }

  /**
   * This is the setter method this will set the flags
   * Field introduced in 17.1.1.
   * @return flags
   */
  public DebugVrfContext addFlagsItem(DebugVrf flagsItem) {
    if (this.flags == null) {
      this.flags = new ArrayList<DebugVrf>();
    }
    this.flags.add(flagsItem);
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
  DebugVrfContext objDebugVrfContext = (DebugVrfContext) o;
  return   Objects.equals(this.flags, objDebugVrfContext.flags)&&
  Objects.equals(this.commandBufferSize, objDebugVrfContext.commandBufferSize)&&
  Objects.equals(this.commandBufferInterval, objDebugVrfContext.commandBufferInterval);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DebugVrfContext {\n");
      sb.append("    commandBufferInterval: ").append(toIndentedString(commandBufferInterval)).append("\n");
        sb.append("    commandBufferSize: ").append(toIndentedString(commandBufferSize)).append("\n");
        sb.append("    flags: ").append(toIndentedString(flags)).append("\n");
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

