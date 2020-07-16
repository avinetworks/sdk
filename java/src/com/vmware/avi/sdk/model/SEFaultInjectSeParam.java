package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SEFaultInjectSeParam is a POJO class extends AviRestResource that used for creating
 * SEFaultInjectSeParam.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SEFaultInjectSeParam  {
    @JsonProperty("core")
    private Integer core = 1000;

    @JsonProperty("random_core")
    private Boolean randomCore = false;

    @JsonProperty("se_agent_fault")
    private String seAgentFault = "SE_AGENT_FAULT_DISABLED";

    @JsonProperty("se_dp_fault")
    private String seDpFault = "SE_DP_FAULT_DISABLED";



  /**
   * This is the getter method this will return the attribute value.
   * Inject fault in specific core.
   * Field introduced in 18.1.5,18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1000.
   * @return core
   */
  public Integer getCore() {
    return core;
  }

  /**
   * This is the setter method to the attribute.
   * Inject fault in specific core.
   * Field introduced in 18.1.5,18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1000.
   * @param core set the core.
   */
  public void setCore(Integer  core) {
    this.core = core;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Inject fault in random no of cores.
   * Field introduced in 18.1.5,18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return randomCore
   */
  public Boolean getRandomCore() {
    return randomCore;
  }

  /**
   * This is the setter method to the attribute.
   * Inject fault in random no of cores.
   * Field introduced in 18.1.5,18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param randomCore set the randomCore.
   */
  public void setRandomCore(Boolean  randomCore) {
    this.randomCore = randomCore;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Set se-agent fault type.
   * Enum options - SE_AGENT_FAULT_DISABLED, SE_AGENT_PRE_PROCESS_FAULT, SE_AGENT_POST_PROCESS_FAULT, SE_AGENT_DP_RESPONSE_FAULT,
   * SE_AGENT_RANDOM_PROCESS_FAULT.
   * Field introduced in 18.1.5,18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as SE_AGENT_FAULT_DISABLED.
   * @return seAgentFault
   */
  public String getSeAgentFault() {
    return seAgentFault;
  }

  /**
   * This is the setter method to the attribute.
   * Set se-agent fault type.
   * Enum options - SE_AGENT_FAULT_DISABLED, SE_AGENT_PRE_PROCESS_FAULT, SE_AGENT_POST_PROCESS_FAULT, SE_AGENT_DP_RESPONSE_FAULT,
   * SE_AGENT_RANDOM_PROCESS_FAULT.
   * Field introduced in 18.1.5,18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as SE_AGENT_FAULT_DISABLED.
   * @param seAgentFault set the seAgentFault.
   */
  public void setSeAgentFault(String  seAgentFault) {
    this.seAgentFault = seAgentFault;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Set se-dp fault type.
   * Enum options - SE_DP_FAULT_DISABLED.
   * Field introduced in 18.1.5,18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as SE_DP_FAULT_DISABLED.
   * @return seDpFault
   */
  public String getSeDpFault() {
    return seDpFault;
  }

  /**
   * This is the setter method to the attribute.
   * Set se-dp fault type.
   * Enum options - SE_DP_FAULT_DISABLED.
   * Field introduced in 18.1.5,18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as SE_DP_FAULT_DISABLED.
   * @param seDpFault set the seDpFault.
   */
  public void setSeDpFault(String  seDpFault) {
    this.seDpFault = seDpFault;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SEFaultInjectSeParam objSEFaultInjectSeParam = (SEFaultInjectSeParam) o;
  return   Objects.equals(this.core, objSEFaultInjectSeParam.core)&&
  Objects.equals(this.seAgentFault, objSEFaultInjectSeParam.seAgentFault)&&
  Objects.equals(this.randomCore, objSEFaultInjectSeParam.randomCore)&&
  Objects.equals(this.seDpFault, objSEFaultInjectSeParam.seDpFault);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SEFaultInjectSeParam {\n");
      sb.append("    core: ").append(toIndentedString(core)).append("\n");
        sb.append("    randomCore: ").append(toIndentedString(randomCore)).append("\n");
        sb.append("    seAgentFault: ").append(toIndentedString(seAgentFault)).append("\n");
        sb.append("    seDpFault: ").append(toIndentedString(seDpFault)).append("\n");
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

