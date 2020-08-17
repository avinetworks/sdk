package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The GCPInBandManagement is a POJO class extends AviRestResource that used for creating
 * GCPInBandManagement.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GCPInBandManagement  {
    @JsonProperty("vpc_network_name")
    private String vpcNetworkName = null;

    @JsonProperty("vpc_project_id")
    private String vpcProjectId = null;

    @JsonProperty("vpc_subnet_name")
    private String vpcSubnetName = null;



  /**
   * This is the getter method this will return the attribute value.
   * Service engine network name.
   * Field introduced in 18.2.2.
   * @return vpcNetworkName
   */
  public String getVpcNetworkName() {
    return vpcNetworkName;
  }

  /**
   * This is the setter method to the attribute.
   * Service engine network name.
   * Field introduced in 18.2.2.
   * @param vpcNetworkName set the vpcNetworkName.
   */
  public void setVpcNetworkName(String  vpcNetworkName) {
    this.vpcNetworkName = vpcNetworkName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Project id of the service engine network.
   * By default, service engine project id will be used.
   * Field introduced in 18.2.1.
   * @return vpcProjectId
   */
  public String getVpcProjectId() {
    return vpcProjectId;
  }

  /**
   * This is the setter method to the attribute.
   * Project id of the service engine network.
   * By default, service engine project id will be used.
   * Field introduced in 18.2.1.
   * @param vpcProjectId set the vpcProjectId.
   */
  public void setVpcProjectId(String  vpcProjectId) {
    this.vpcProjectId = vpcProjectId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Service engine network subnet name.
   * Field introduced in 18.2.1.
   * @return vpcSubnetName
   */
  public String getVpcSubnetName() {
    return vpcSubnetName;
  }

  /**
   * This is the setter method to the attribute.
   * Service engine network subnet name.
   * Field introduced in 18.2.1.
   * @param vpcSubnetName set the vpcSubnetName.
   */
  public void setVpcSubnetName(String  vpcSubnetName) {
    this.vpcSubnetName = vpcSubnetName;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  GCPInBandManagement objGCPInBandManagement = (GCPInBandManagement) o;
  return   Objects.equals(this.vpcSubnetName, objGCPInBandManagement.vpcSubnetName)&&
  Objects.equals(this.vpcProjectId, objGCPInBandManagement.vpcProjectId)&&
  Objects.equals(this.vpcNetworkName, objGCPInBandManagement.vpcNetworkName);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class GCPInBandManagement {\n");
      sb.append("    vpcNetworkName: ").append(toIndentedString(vpcNetworkName)).append("\n");
        sb.append("    vpcProjectId: ").append(toIndentedString(vpcProjectId)).append("\n");
        sb.append("    vpcSubnetName: ").append(toIndentedString(vpcSubnetName)).append("\n");
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

