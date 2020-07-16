package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The MesosSeResources is a POJO class extends AviRestResource that used for creating
 * MesosSeResources.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MesosSeResources  {
    @JsonProperty("attribute_key")
    private String attributeKey = null;

    @JsonProperty("attribute_value")
    private String attributeValue = null;

    @JsonProperty("cpu")
    private float cpu = 2.0f;

    @JsonProperty("memory")
    private Integer memory = 4096;



  /**
   * This is the getter method this will return the attribute value.
   * Attribute (fleet or mesos) key of hosts.
   * @return attributeKey
   */
  public String getAttributeKey() {
    return attributeKey;
  }

  /**
   * This is the setter method to the attribute.
   * Attribute (fleet or mesos) key of hosts.
   * @param attributeKey set the attributeKey.
   */
  public void setAttributeKey(String  attributeKey) {
    this.attributeKey = attributeKey;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Attribute (fleet or mesos) value of hosts.
   * @return attributeValue
   */
  public String getAttributeValue() {
    return attributeValue;
  }

  /**
   * This is the setter method to the attribute.
   * Attribute (fleet or mesos) value of hosts.
   * @param attributeValue set the attributeValue.
   */
  public void setAttributeValue(String  attributeValue) {
    this.attributeValue = attributeValue;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Obsolete - ignored.
   * Default value when not specified in API or module is interpreted by Avi Controller as 2.0.
   * @return cpu
   */
  public Float getCpu() {
    return cpu;
  }

  /**
   * This is the setter method to the attribute.
   * Obsolete - ignored.
   * Default value when not specified in API or module is interpreted by Avi Controller as 2.0.
   * @param cpu set the cpu.
   */
  public void setCpu(Float  cpu) {
    this.cpu = cpu;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Obsolete - ignored.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4096.
   * @return memory
   */
  public Integer getMemory() {
    return memory;
  }

  /**
   * This is the setter method to the attribute.
   * Obsolete - ignored.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4096.
   * @param memory set the memory.
   */
  public void setMemory(Integer  memory) {
    this.memory = memory;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  MesosSeResources objMesosSeResources = (MesosSeResources) o;
  return   Objects.equals(this.attributeKey, objMesosSeResources.attributeKey)&&
  Objects.equals(this.memory, objMesosSeResources.memory)&&
  Objects.equals(this.cpu, objMesosSeResources.cpu)&&
  Objects.equals(this.attributeValue, objMesosSeResources.attributeValue);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class MesosSeResources {\n");
      sb.append("    attributeKey: ").append(toIndentedString(attributeKey)).append("\n");
        sb.append("    attributeValue: ").append(toIndentedString(attributeValue)).append("\n");
        sb.append("    cpu: ").append(toIndentedString(cpu)).append("\n");
        sb.append("    memory: ").append(toIndentedString(memory)).append("\n");
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

