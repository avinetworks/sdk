package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ApicAgentVsNetworkError is a POJO class extends AviRestResource that used for creating
 * ApicAgentVsNetworkError.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApicAgentVsNetworkError  {
    @JsonProperty("pool_name")
    private String poolName = null;

    @JsonProperty("pool_network")
    private String poolNetwork = null;

    @JsonProperty("vs_name")
    private String vsName = null;

    @JsonProperty("vs_network")
    private String vsNetwork = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property pool_name of obj type apicagentvsnetworkerror field type str  type string.
   * @return poolName
   */
  public String getPoolName() {
    return poolName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property pool_name of obj type apicagentvsnetworkerror field type str  type string.
   * @param poolName set the poolName.
   */
  public void setPoolName(String  poolName) {
    this.poolName = poolName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property pool_network of obj type apicagentvsnetworkerror field type str  type string.
   * @return poolNetwork
   */
  public String getPoolNetwork() {
    return poolNetwork;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property pool_network of obj type apicagentvsnetworkerror field type str  type string.
   * @param poolNetwork set the poolNetwork.
   */
  public void setPoolNetwork(String  poolNetwork) {
    this.poolNetwork = poolNetwork;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vs_name of obj type apicagentvsnetworkerror field type str  type string.
   * @return vsName
   */
  public String getVsName() {
    return vsName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vs_name of obj type apicagentvsnetworkerror field type str  type string.
   * @param vsName set the vsName.
   */
  public void setVsName(String  vsName) {
    this.vsName = vsName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vs_network of obj type apicagentvsnetworkerror field type str  type string.
   * @return vsNetwork
   */
  public String getVsNetwork() {
    return vsNetwork;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vs_network of obj type apicagentvsnetworkerror field type str  type string.
   * @param vsNetwork set the vsNetwork.
   */
  public void setVsNetwork(String  vsNetwork) {
    this.vsNetwork = vsNetwork;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ApicAgentVsNetworkError objApicAgentVsNetworkError = (ApicAgentVsNetworkError) o;
  return   Objects.equals(this.vsName, objApicAgentVsNetworkError.vsName)&&
  Objects.equals(this.vsNetwork, objApicAgentVsNetworkError.vsNetwork)&&
  Objects.equals(this.poolName, objApicAgentVsNetworkError.poolName)&&
  Objects.equals(this.poolNetwork, objApicAgentVsNetworkError.poolNetwork);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ApicAgentVsNetworkError {\n");
      sb.append("    poolName: ").append(toIndentedString(poolName)).append("\n");
        sb.append("    poolNetwork: ").append(toIndentedString(poolNetwork)).append("\n");
        sb.append("    vsName: ").append(toIndentedString(vsName)).append("\n");
        sb.append("    vsNetwork: ").append(toIndentedString(vsNetwork)).append("\n");
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

