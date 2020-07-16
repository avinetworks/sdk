package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The GCPNetworkConfig is a POJO class extends AviRestResource that used for creating
 * GCPNetworkConfig.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GCPNetworkConfig  {
    @JsonProperty("config")
    private String config = null;

    @JsonProperty("inband")
    private GCPInBandManagement inband = null;

    @JsonProperty("one_arm")
    private GCPOneArmMode oneArm = null;

    @JsonProperty("two_arm")
    private GCPTwoArmMode twoArm = null;



  /**
   * This is the getter method this will return the attribute value.
   * Config mode for google cloud network configuration.
   * Enum options - INBAND_MANAGEMENT, ONE_ARM_MODE, TWO_ARM_MODE.
   * Field introduced in 18.2.1.
   * @return config
   */
  public String getConfig() {
    return config;
  }

  /**
   * This is the setter method to the attribute.
   * Config mode for google cloud network configuration.
   * Enum options - INBAND_MANAGEMENT, ONE_ARM_MODE, TWO_ARM_MODE.
   * Field introduced in 18.2.1.
   * @param config set the config.
   */
  public void setConfig(String  config) {
    this.config = config;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Configure inband management as google cloud network configuration.
   * In this configuration the data network and management network for service engines will be same.
   * Field introduced in 18.2.1.
   * @return inband
   */
  public GCPInBandManagement getInband() {
    return inband;
  }

  /**
   * This is the setter method to the attribute.
   * Configure inband management as google cloud network configuration.
   * In this configuration the data network and management network for service engines will be same.
   * Field introduced in 18.2.1.
   * @param inband set the inband.
   */
  public void setInband(GCPInBandManagement inband) {
    this.inband = inband;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Configure one arm mode as google cloud network configuration.
   * In this configuration the data network and the management network for the service engines will be separated.
   * Field introduced in 18.2.1.
   * @return oneArm
   */
  public GCPOneArmMode getOneArm() {
    return oneArm;
  }

  /**
   * This is the setter method to the attribute.
   * Configure one arm mode as google cloud network configuration.
   * In this configuration the data network and the management network for the service engines will be separated.
   * Field introduced in 18.2.1.
   * @param oneArm set the oneArm.
   */
  public void setOneArm(GCPOneArmMode oneArm) {
    this.oneArm = oneArm;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Configure two arm mode as google cloud network configuration.
   * In this configuration the frontend data network, backend data network and the management network for the service engines will be separated.
   * Field introduced in 18.2.1.
   * @return twoArm
   */
  public GCPTwoArmMode getTwoArm() {
    return twoArm;
  }

  /**
   * This is the setter method to the attribute.
   * Configure two arm mode as google cloud network configuration.
   * In this configuration the frontend data network, backend data network and the management network for the service engines will be separated.
   * Field introduced in 18.2.1.
   * @param twoArm set the twoArm.
   */
  public void setTwoArm(GCPTwoArmMode twoArm) {
    this.twoArm = twoArm;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  GCPNetworkConfig objGCPNetworkConfig = (GCPNetworkConfig) o;
  return   Objects.equals(this.oneArm, objGCPNetworkConfig.oneArm)&&
  Objects.equals(this.twoArm, objGCPNetworkConfig.twoArm)&&
  Objects.equals(this.config, objGCPNetworkConfig.config)&&
  Objects.equals(this.inband, objGCPNetworkConfig.inband);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class GCPNetworkConfig {\n");
      sb.append("    config: ").append(toIndentedString(config)).append("\n");
        sb.append("    inband: ").append(toIndentedString(inband)).append("\n");
        sb.append("    oneArm: ").append(toIndentedString(oneArm)).append("\n");
        sb.append("    twoArm: ").append(toIndentedString(twoArm)).append("\n");
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

