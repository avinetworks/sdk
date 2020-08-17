package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The AzureInfo is a POJO class extends AviRestResource that used for creating
 * AzureInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AzureInfo  {
    @JsonProperty("availability_set")
    private String availabilitySet = null;

    @JsonProperty("fault_domain")
    private String faultDomain = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("resource_group")
    private String resourceGroup = null;

    @JsonProperty("subnet_id")
    private String subnetId = null;

    @JsonProperty("update_domain")
    private String updateDomain = null;

    @JsonProperty("vm_uuid")
    private String vmUuid = null;

    @JsonProperty("vnic_id")
    private String vnicId = null;



  /**
   * This is the getter method this will return the attribute value.
   * Name of the availability set of which the vm is a part of.
   * Field introduced in 17.2.1.
   * @return availabilitySet
   */
  public String getAvailabilitySet() {
    return availabilitySet;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the availability set of which the vm is a part of.
   * Field introduced in 17.2.1.
   * @param availabilitySet set the availabilitySet.
   */
  public void setAvailabilitySet(String  availabilitySet) {
    this.availabilitySet = availabilitySet;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Fault domain within the availability set the vm is a part of.
   * Field introduced in 17.2.1.
   * @return faultDomain
   */
  public String getFaultDomain() {
    return faultDomain;
  }

  /**
   * This is the setter method to the attribute.
   * Fault domain within the availability set the vm is a part of.
   * Field introduced in 17.2.1.
   * @param faultDomain set the faultDomain.
   */
  public void setFaultDomain(String  faultDomain) {
    this.faultDomain = faultDomain;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the azure vm.
   * Field introduced in 17.2.1.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the azure vm.
   * Field introduced in 17.2.1.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Resource group name for the vm.
   * Field introduced in 17.2.1.
   * @return resourceGroup
   */
  public String getResourceGroup() {
    return resourceGroup;
  }

  /**
   * This is the setter method to the attribute.
   * Resource group name for the vm.
   * Field introduced in 17.2.1.
   * @param resourceGroup set the resourceGroup.
   */
  public void setResourceGroup(String  resourceGroup) {
    this.resourceGroup = resourceGroup;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Subnet id of the primary nic of the vm.
   * Field introduced in 17.2.1.
   * @return subnetId
   */
  public String getSubnetId() {
    return subnetId;
  }

  /**
   * This is the setter method to the attribute.
   * Subnet id of the primary nic of the vm.
   * Field introduced in 17.2.1.
   * @param subnetId set the subnetId.
   */
  public void setSubnetId(String  subnetId) {
    this.subnetId = subnetId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Update domain within the availability set the vm is a part of.
   * Field introduced in 17.2.1.
   * @return updateDomain
   */
  public String getUpdateDomain() {
    return updateDomain;
  }

  /**
   * This is the setter method to the attribute.
   * Update domain within the availability set the vm is a part of.
   * Field introduced in 17.2.1.
   * @param updateDomain set the updateDomain.
   */
  public void setUpdateDomain(String  updateDomain) {
    this.updateDomain = updateDomain;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Azure vm uuid for the se vm.
   * Field introduced in 17.2.1.
   * @return vmUuid
   */
  public String getVmUuid() {
    return vmUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Azure vm uuid for the se vm.
   * Field introduced in 17.2.1.
   * @param vmUuid set the vmUuid.
   */
  public void setVmUuid(String  vmUuid) {
    this.vmUuid = vmUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Vnic id of the primary nic of the vm.
   * Field introduced in 17.2.1.
   * @return vnicId
   */
  public String getVnicId() {
    return vnicId;
  }

  /**
   * This is the setter method to the attribute.
   * Vnic id of the primary nic of the vm.
   * Field introduced in 17.2.1.
   * @param vnicId set the vnicId.
   */
  public void setVnicId(String  vnicId) {
    this.vnicId = vnicId;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  AzureInfo objAzureInfo = (AzureInfo) o;
  return   Objects.equals(this.vmUuid, objAzureInfo.vmUuid)&&
  Objects.equals(this.resourceGroup, objAzureInfo.resourceGroup)&&
  Objects.equals(this.name, objAzureInfo.name)&&
  Objects.equals(this.subnetId, objAzureInfo.subnetId)&&
  Objects.equals(this.vnicId, objAzureInfo.vnicId)&&
  Objects.equals(this.availabilitySet, objAzureInfo.availabilitySet)&&
  Objects.equals(this.faultDomain, objAzureInfo.faultDomain)&&
  Objects.equals(this.updateDomain, objAzureInfo.updateDomain);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class AzureInfo {\n");
      sb.append("    availabilitySet: ").append(toIndentedString(availabilitySet)).append("\n");
        sb.append("    faultDomain: ").append(toIndentedString(faultDomain)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    resourceGroup: ").append(toIndentedString(resourceGroup)).append("\n");
        sb.append("    subnetId: ").append(toIndentedString(subnetId)).append("\n");
        sb.append("    updateDomain: ").append(toIndentedString(updateDomain)).append("\n");
        sb.append("    vmUuid: ").append(toIndentedString(vmUuid)).append("\n");
        sb.append("    vnicId: ").append(toIndentedString(vnicId)).append("\n");
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

