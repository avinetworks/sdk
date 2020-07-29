package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VIMgrDCRuntime is a POJO class extends AviRestResource that used for creating
 * VIMgrDCRuntime.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VIMgrDCRuntime extends AviRestResource  {
    @JsonProperty("cloud_ref")
    private String cloudRef = null;

    @JsonProperty("cluster_refs")
    private List<String> clusterRefs = null;

    @JsonProperty("host_refs")
    private List<String> hostRefs = null;

    @JsonProperty("interested_hosts")
    private List<VIMgrInterestedEntity> interestedHosts = null;

    @JsonProperty("interested_nws")
    private List<VIMgrInterestedEntity> interestedNws = null;

    @JsonProperty("interested_vms")
    private List<VIMgrInterestedEntity> interestedVms = null;

    @JsonProperty("inventory_state")
    private Integer inventoryState = null;

    @JsonProperty("managed_object_id")
    private String managedObjectId = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("nw_refs")
    private List<String> nwRefs = null;

    @JsonProperty("pending_vcenter_reqs")
    private Integer pendingVcenterReqs = null;

    @JsonProperty("sevm_refs")
    private List<String> sevmRefs = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("type")
    private String type = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;

    @JsonProperty("vcenter_uuid")
    private String vcenterUuid = null;

    @JsonProperty("vm_refs")
    private List<String> vmRefs = null;



  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type cloud.
   * @return cloudRef
   */
  public String getCloudRef() {
    return cloudRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type cloud.
   * @param cloudRef set the cloudRef.
   */
  public void setCloudRef(String  cloudRef) {
    this.cloudRef = cloudRef;
  }
  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type vimgrclusterruntime.
   * @return clusterRefs
   */
  public List<String> getClusterRefs() {
    return clusterRefs;
  }

  /**
   * This is the setter method. this will set the clusterRefs
   * It is a reference to an object of type vimgrclusterruntime.
   * @return clusterRefs
   */
  public void setClusterRefs(List<String>  clusterRefs) {
    this.clusterRefs = clusterRefs;
  }

  /**
   * This is the setter method this will set the clusterRefs
   * It is a reference to an object of type vimgrclusterruntime.
   * @return clusterRefs
   */
  public VIMgrDCRuntime addClusterRefsItem(String clusterRefsItem) {
    if (this.clusterRefs == null) {
      this.clusterRefs = new ArrayList<String>();
    }
    this.clusterRefs.add(clusterRefsItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type vimgrhostruntime.
   * @return hostRefs
   */
  public List<String> getHostRefs() {
    return hostRefs;
  }

  /**
   * This is the setter method. this will set the hostRefs
   * It is a reference to an object of type vimgrhostruntime.
   * @return hostRefs
   */
  public void setHostRefs(List<String>  hostRefs) {
    this.hostRefs = hostRefs;
  }

  /**
   * This is the setter method this will set the hostRefs
   * It is a reference to an object of type vimgrhostruntime.
   * @return hostRefs
   */
  public VIMgrDCRuntime addHostRefsItem(String hostRefsItem) {
    if (this.hostRefs == null) {
      this.hostRefs = new ArrayList<String>();
    }
    this.hostRefs.add(hostRefsItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property interested_hosts of obj type vimgrdcruntime field type str  type array.
   * @return interestedHosts
   */
  public List<VIMgrInterestedEntity> getInterestedHosts() {
    return interestedHosts;
  }

  /**
   * This is the setter method. this will set the interestedHosts
   * Placeholder for description of property interested_hosts of obj type vimgrdcruntime field type str  type array.
   * @return interestedHosts
   */
  public void setInterestedHosts(List<VIMgrInterestedEntity>  interestedHosts) {
    this.interestedHosts = interestedHosts;
  }

  /**
   * This is the setter method this will set the interestedHosts
   * Placeholder for description of property interested_hosts of obj type vimgrdcruntime field type str  type array.
   * @return interestedHosts
   */
  public VIMgrDCRuntime addInterestedHostsItem(VIMgrInterestedEntity interestedHostsItem) {
    if (this.interestedHosts == null) {
      this.interestedHosts = new ArrayList<VIMgrInterestedEntity>();
    }
    this.interestedHosts.add(interestedHostsItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property interested_nws of obj type vimgrdcruntime field type str  type array.
   * @return interestedNws
   */
  public List<VIMgrInterestedEntity> getInterestedNws() {
    return interestedNws;
  }

  /**
   * This is the setter method. this will set the interestedNws
   * Placeholder for description of property interested_nws of obj type vimgrdcruntime field type str  type array.
   * @return interestedNws
   */
  public void setInterestedNws(List<VIMgrInterestedEntity>  interestedNws) {
    this.interestedNws = interestedNws;
  }

  /**
   * This is the setter method this will set the interestedNws
   * Placeholder for description of property interested_nws of obj type vimgrdcruntime field type str  type array.
   * @return interestedNws
   */
  public VIMgrDCRuntime addInterestedNwsItem(VIMgrInterestedEntity interestedNwsItem) {
    if (this.interestedNws == null) {
      this.interestedNws = new ArrayList<VIMgrInterestedEntity>();
    }
    this.interestedNws.add(interestedNwsItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property interested_vms of obj type vimgrdcruntime field type str  type array.
   * @return interestedVms
   */
  public List<VIMgrInterestedEntity> getInterestedVms() {
    return interestedVms;
  }

  /**
   * This is the setter method. this will set the interestedVms
   * Placeholder for description of property interested_vms of obj type vimgrdcruntime field type str  type array.
   * @return interestedVms
   */
  public void setInterestedVms(List<VIMgrInterestedEntity>  interestedVms) {
    this.interestedVms = interestedVms;
  }

  /**
   * This is the setter method this will set the interestedVms
   * Placeholder for description of property interested_vms of obj type vimgrdcruntime field type str  type array.
   * @return interestedVms
   */
  public VIMgrDCRuntime addInterestedVmsItem(VIMgrInterestedEntity interestedVmsItem) {
    if (this.interestedVms == null) {
      this.interestedVms = new ArrayList<VIMgrInterestedEntity>();
    }
    this.interestedVms.add(interestedVmsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property inventory_state of obj type vimgrdcruntime field type str  type integer.
   * @return inventoryState
   */
  public Integer getInventoryState() {
    return inventoryState;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property inventory_state of obj type vimgrdcruntime field type str  type integer.
   * @param inventoryState set the inventoryState.
   */
  public void setInventoryState(Integer  inventoryState) {
    this.inventoryState = inventoryState;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property managed_object_id of obj type vimgrdcruntime field type str  type string.
   * @return managedObjectId
   */
  public String getManagedObjectId() {
    return managedObjectId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property managed_object_id of obj type vimgrdcruntime field type str  type string.
   * @param managedObjectId set the managedObjectId.
   */
  public void setManagedObjectId(String  managedObjectId) {
    this.managedObjectId = managedObjectId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the object.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the object.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }
  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type vimgrnwruntime.
   * @return nwRefs
   */
  public List<String> getNwRefs() {
    return nwRefs;
  }

  /**
   * This is the setter method. this will set the nwRefs
   * It is a reference to an object of type vimgrnwruntime.
   * @return nwRefs
   */
  public void setNwRefs(List<String>  nwRefs) {
    this.nwRefs = nwRefs;
  }

  /**
   * This is the setter method this will set the nwRefs
   * It is a reference to an object of type vimgrnwruntime.
   * @return nwRefs
   */
  public VIMgrDCRuntime addNwRefsItem(String nwRefsItem) {
    if (this.nwRefs == null) {
      this.nwRefs = new ArrayList<String>();
    }
    this.nwRefs.add(nwRefsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property pending_vcenter_reqs of obj type vimgrdcruntime field type str  type integer.
   * @return pendingVcenterReqs
   */
  public Integer getPendingVcenterReqs() {
    return pendingVcenterReqs;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property pending_vcenter_reqs of obj type vimgrdcruntime field type str  type integer.
   * @param pendingVcenterReqs set the pendingVcenterReqs.
   */
  public void setPendingVcenterReqs(Integer  pendingVcenterReqs) {
    this.pendingVcenterReqs = pendingVcenterReqs;
  }
  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type vimgrsevmruntime.
   * @return sevmRefs
   */
  public List<String> getSevmRefs() {
    return sevmRefs;
  }

  /**
   * This is the setter method. this will set the sevmRefs
   * It is a reference to an object of type vimgrsevmruntime.
   * @return sevmRefs
   */
  public void setSevmRefs(List<String>  sevmRefs) {
    this.sevmRefs = sevmRefs;
  }

  /**
   * This is the setter method this will set the sevmRefs
   * It is a reference to an object of type vimgrsevmruntime.
   * @return sevmRefs
   */
  public VIMgrDCRuntime addSevmRefsItem(String sevmRefsItem) {
    if (this.sevmRefs == null) {
      this.sevmRefs = new ArrayList<String>();
    }
    this.sevmRefs.add(sevmRefsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type tenant.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type tenant.
   * @param tenantRef set the tenantRef.
   */
  public void setTenantRef(String  tenantRef) {
    this.tenantRef = tenantRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - CLOUD_NONE, CLOUD_VCENTER, CLOUD_OPENSTACK, CLOUD_AWS, CLOUD_VCA, CLOUD_APIC, CLOUD_MESOS, CLOUD_LINUXSERVER, CLOUD_DOCKER_UCP,
   * CLOUD_RANCHER, CLOUD_OSHIFT_K8S, CLOUD_AZURE, CLOUD_GCP, CLOUD_NSXT.
   * @return type
   */
  public String getType() {
    return type;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - CLOUD_NONE, CLOUD_VCENTER, CLOUD_OPENSTACK, CLOUD_AWS, CLOUD_VCA, CLOUD_APIC, CLOUD_MESOS, CLOUD_LINUXSERVER, CLOUD_DOCKER_UCP,
   * CLOUD_RANCHER, CLOUD_OSHIFT_K8S, CLOUD_AZURE, CLOUD_GCP, CLOUD_NSXT.
   * @param type set the type.
   */
  public void setType(String  type) {
    this.type = type;
  }
/**
   * This is the getter method this will return the attribute value.
   * Avi controller URL of the object.
   * @return url
   */
  public String getUrl() {
    return url;
  }

  /**
   * This is the setter method. this will set the url
   * Avi controller URL of the object.
   * @return url
   */
  public void setUrl(String  url) {
    this.url = url;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of the object.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of the object.
   * @param uuid set the uuid.
   */
  public void setUuid(String  uuid) {
    this.uuid = uuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of vcenter.
   * @return vcenterUuid
   */
  public String getVcenterUuid() {
    return vcenterUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of vcenter.
   * @param vcenterUuid set the vcenterUuid.
   */
  public void setVcenterUuid(String  vcenterUuid) {
    this.vcenterUuid = vcenterUuid;
  }
  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type vimgrvmruntime.
   * @return vmRefs
   */
  public List<String> getVmRefs() {
    return vmRefs;
  }

  /**
   * This is the setter method. this will set the vmRefs
   * It is a reference to an object of type vimgrvmruntime.
   * @return vmRefs
   */
  public void setVmRefs(List<String>  vmRefs) {
    this.vmRefs = vmRefs;
  }

  /**
   * This is the setter method this will set the vmRefs
   * It is a reference to an object of type vimgrvmruntime.
   * @return vmRefs
   */
  public VIMgrDCRuntime addVmRefsItem(String vmRefsItem) {
    if (this.vmRefs == null) {
      this.vmRefs = new ArrayList<String>();
    }
    this.vmRefs.add(vmRefsItem);
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
  VIMgrDCRuntime objVIMgrDCRuntime = (VIMgrDCRuntime) o;
  return   Objects.equals(this.type, objVIMgrDCRuntime.type)&&
  Objects.equals(this.uuid, objVIMgrDCRuntime.uuid)&&
  Objects.equals(this.name, objVIMgrDCRuntime.name)&&
  Objects.equals(this.managedObjectId, objVIMgrDCRuntime.managedObjectId)&&
  Objects.equals(this.clusterRefs, objVIMgrDCRuntime.clusterRefs)&&
  Objects.equals(this.hostRefs, objVIMgrDCRuntime.hostRefs)&&
  Objects.equals(this.sevmRefs, objVIMgrDCRuntime.sevmRefs)&&
  Objects.equals(this.nwRefs, objVIMgrDCRuntime.nwRefs)&&
  Objects.equals(this.vmRefs, objVIMgrDCRuntime.vmRefs)&&
  Objects.equals(this.vcenterUuid, objVIMgrDCRuntime.vcenterUuid)&&
  Objects.equals(this.interestedVms, objVIMgrDCRuntime.interestedVms)&&
  Objects.equals(this.interestedNws, objVIMgrDCRuntime.interestedNws)&&
  Objects.equals(this.interestedHosts, objVIMgrDCRuntime.interestedHosts)&&
  Objects.equals(this.inventoryState, objVIMgrDCRuntime.inventoryState)&&
  Objects.equals(this.pendingVcenterReqs, objVIMgrDCRuntime.pendingVcenterReqs)&&
  Objects.equals(this.tenantRef, objVIMgrDCRuntime.tenantRef)&&
  Objects.equals(this.cloudRef, objVIMgrDCRuntime.cloudRef);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VIMgrDCRuntime {\n");
      sb.append("    cloudRef: ").append(toIndentedString(cloudRef)).append("\n");
        sb.append("    clusterRefs: ").append(toIndentedString(clusterRefs)).append("\n");
        sb.append("    hostRefs: ").append(toIndentedString(hostRefs)).append("\n");
        sb.append("    interestedHosts: ").append(toIndentedString(interestedHosts)).append("\n");
        sb.append("    interestedNws: ").append(toIndentedString(interestedNws)).append("\n");
        sb.append("    interestedVms: ").append(toIndentedString(interestedVms)).append("\n");
        sb.append("    inventoryState: ").append(toIndentedString(inventoryState)).append("\n");
        sb.append("    managedObjectId: ").append(toIndentedString(managedObjectId)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    nwRefs: ").append(toIndentedString(nwRefs)).append("\n");
        sb.append("    pendingVcenterReqs: ").append(toIndentedString(pendingVcenterReqs)).append("\n");
        sb.append("    sevmRefs: ").append(toIndentedString(sevmRefs)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
            sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
        sb.append("    vcenterUuid: ").append(toIndentedString(vcenterUuid)).append("\n");
        sb.append("    vmRefs: ").append(toIndentedString(vmRefs)).append("\n");
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

