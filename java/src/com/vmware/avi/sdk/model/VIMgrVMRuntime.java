package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VIMgrVMRuntime is a POJO class extends AviRestResource that used for creating
 * VIMgrVMRuntime.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VIMgrVMRuntime extends AviRestResource  {
    @JsonProperty("availability_zone")
    private String availabilityZone = null;

    @JsonProperty("cloud_ref")
    private String cloudRef = null;

    @JsonProperty("connection_state")
    private String connectionState = null;

    @JsonProperty("controller_cluster_uuid")
    private String controllerClusterUuid = null;

    @JsonProperty("controller_ip_addr")
    private String controllerIpAddr = null;

    @JsonProperty("controller_vm")
    private Boolean controllerVm = null;

    @JsonProperty("cpu_reservation")
    private Integer cpuReservation = null;

    @JsonProperty("cpu_shares")
    private Integer cpuShares = null;

    @JsonProperty("creation_in_progress")
    private Boolean creationInProgress = null;

    @JsonProperty("guest_nic")
    private List<VIMgrGuestNicRuntime> guestNic = null;

    @JsonProperty("host")
    private String host = null;

    @JsonProperty("init_vnics")
    private Integer initVnics = null;

    @JsonProperty("managed_object_id")
    private String managedObjectId = null;

    @JsonProperty("mem_shares")
    private Integer memShares = null;

    @JsonProperty("memory")
    private Integer memory = null;

    @JsonProperty("memory_reservation")
    private Integer memoryReservation = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("num_cpu")
    private Integer numCpu = null;

    @JsonProperty("ovf_avisetype_field")
    private String ovfAvisetypeField = null;

    @JsonProperty("powerstate")
    private String powerstate = null;

    @JsonProperty("se_ver")
    private Integer seVer = 1;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("type")
    private String type = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;

    @JsonProperty("vcenter_datacenter_uuid")
    private String vcenterDatacenterUuid = null;

    @JsonProperty("vcenter_rm_cookie")
    private String vcenterRmCookie = null;

    @JsonProperty("vcenter_se_type")
    private String vcenterSeType = null;

    @JsonProperty("vcenter_template_vm")
    private Boolean vcenterTemplateVm = null;

    @JsonProperty("vcenter_vAppName")
    private String vcenterVappname = null;

    @JsonProperty("vcenter_vAppVendor")
    private String vcenterVappvendor = null;

    @JsonProperty("vcenter_vm_type")
    private String vcenterVmType = null;

    @JsonProperty("vcenter_vnic_discovered")
    private Boolean vcenterVnicDiscovered = null;

    @JsonProperty("vm_lb_weight")
    private Integer vmLbWeight = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property availability_zone of obj type vimgrvmruntime field type str  type string.
   * @return availabilityZone
   */
  public String getAvailabilityZone() {
    return availabilityZone;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property availability_zone of obj type vimgrvmruntime field type str  type string.
   * @param availabilityZone set the availabilityZone.
   */
  public void setAvailabilityZone(String  availabilityZone) {
    this.availabilityZone = availabilityZone;
  }

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
   * Placeholder for description of property connection_state of obj type vimgrvmruntime field type str  type string.
   * @return connectionState
   */
  public String getConnectionState() {
    return connectionState;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property connection_state of obj type vimgrvmruntime field type str  type string.
   * @param connectionState set the connectionState.
   */
  public void setConnectionState(String  connectionState) {
    this.connectionState = connectionState;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of controller_cluster.
   * @return controllerClusterUuid
   */
  public String getControllerClusterUuid() {
    return controllerClusterUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of controller_cluster.
   * @param controllerClusterUuid set the controllerClusterUuid.
   */
  public void setControllerClusterUuid(String  controllerClusterUuid) {
    this.controllerClusterUuid = controllerClusterUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property controller_ip_addr of obj type vimgrvmruntime field type str  type string.
   * @return controllerIpAddr
   */
  public String getControllerIpAddr() {
    return controllerIpAddr;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property controller_ip_addr of obj type vimgrvmruntime field type str  type string.
   * @param controllerIpAddr set the controllerIpAddr.
   */
  public void setControllerIpAddr(String  controllerIpAddr) {
    this.controllerIpAddr = controllerIpAddr;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property controller_vm of obj type vimgrvmruntime field type str  type boolean.
   * @return controllerVm
   */
  public Boolean getControllerVm() {
    return controllerVm;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property controller_vm of obj type vimgrvmruntime field type str  type boolean.
   * @param controllerVm set the controllerVm.
   */
  public void setControllerVm(Boolean  controllerVm) {
    this.controllerVm = controllerVm;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cpu_reservation of obj type vimgrvmruntime field type str  type integer.
   * @return cpuReservation
   */
  public Integer getCpuReservation() {
    return cpuReservation;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cpu_reservation of obj type vimgrvmruntime field type str  type integer.
   * @param cpuReservation set the cpuReservation.
   */
  public void setCpuReservation(Integer  cpuReservation) {
    this.cpuReservation = cpuReservation;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cpu_shares of obj type vimgrvmruntime field type str  type integer.
   * @return cpuShares
   */
  public Integer getCpuShares() {
    return cpuShares;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cpu_shares of obj type vimgrvmruntime field type str  type integer.
   * @param cpuShares set the cpuShares.
   */
  public void setCpuShares(Integer  cpuShares) {
    this.cpuShares = cpuShares;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property creation_in_progress of obj type vimgrvmruntime field type str  type boolean.
   * @return creationInProgress
   */
  public Boolean getCreationInProgress() {
    return creationInProgress;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property creation_in_progress of obj type vimgrvmruntime field type str  type boolean.
   * @param creationInProgress set the creationInProgress.
   */
  public void setCreationInProgress(Boolean  creationInProgress) {
    this.creationInProgress = creationInProgress;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property guest_nic of obj type vimgrvmruntime field type str  type array.
   * @return guestNic
   */
  public List<VIMgrGuestNicRuntime> getGuestNic() {
    return guestNic;
  }

  /**
   * This is the setter method. this will set the guestNic
   * Placeholder for description of property guest_nic of obj type vimgrvmruntime field type str  type array.
   * @return guestNic
   */
  public void setGuestNic(List<VIMgrGuestNicRuntime>  guestNic) {
    this.guestNic = guestNic;
  }

  /**
   * This is the setter method this will set the guestNic
   * Placeholder for description of property guest_nic of obj type vimgrvmruntime field type str  type array.
   * @return guestNic
   */
  public VIMgrVMRuntime addGuestNicItem(VIMgrGuestNicRuntime guestNicItem) {
    if (this.guestNic == null) {
      this.guestNic = new ArrayList<VIMgrGuestNicRuntime>();
    }
    this.guestNic.add(guestNicItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property host of obj type vimgrvmruntime field type str  type string.
   * @return host
   */
  public String getHost() {
    return host;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property host of obj type vimgrvmruntime field type str  type string.
   * @param host set the host.
   */
  public void setHost(String  host) {
    this.host = host;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property init_vnics of obj type vimgrvmruntime field type str  type integer.
   * @return initVnics
   */
  public Integer getInitVnics() {
    return initVnics;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property init_vnics of obj type vimgrvmruntime field type str  type integer.
   * @param initVnics set the initVnics.
   */
  public void setInitVnics(Integer  initVnics) {
    this.initVnics = initVnics;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property managed_object_id of obj type vimgrvmruntime field type str  type string.
   * @return managedObjectId
   */
  public String getManagedObjectId() {
    return managedObjectId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property managed_object_id of obj type vimgrvmruntime field type str  type string.
   * @param managedObjectId set the managedObjectId.
   */
  public void setManagedObjectId(String  managedObjectId) {
    this.managedObjectId = managedObjectId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property mem_shares of obj type vimgrvmruntime field type str  type integer.
   * @return memShares
   */
  public Integer getMemShares() {
    return memShares;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property mem_shares of obj type vimgrvmruntime field type str  type integer.
   * @param memShares set the memShares.
   */
  public void setMemShares(Integer  memShares) {
    this.memShares = memShares;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property memory of obj type vimgrvmruntime field type str  type integer.
   * @return memory
   */
  public Integer getMemory() {
    return memory;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property memory of obj type vimgrvmruntime field type str  type integer.
   * @param memory set the memory.
   */
  public void setMemory(Integer  memory) {
    this.memory = memory;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property memory_reservation of obj type vimgrvmruntime field type str  type integer.
   * @return memoryReservation
   */
  public Integer getMemoryReservation() {
    return memoryReservation;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property memory_reservation of obj type vimgrvmruntime field type str  type integer.
   * @param memoryReservation set the memoryReservation.
   */
  public void setMemoryReservation(Integer  memoryReservation) {
    this.memoryReservation = memoryReservation;
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
   * Placeholder for description of property num_cpu of obj type vimgrvmruntime field type str  type integer.
   * @return numCpu
   */
  public Integer getNumCpu() {
    return numCpu;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property num_cpu of obj type vimgrvmruntime field type str  type integer.
   * @param numCpu set the numCpu.
   */
  public void setNumCpu(Integer  numCpu) {
    this.numCpu = numCpu;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.1.1,17.1.3.
   * @return ovfAvisetypeField
   */
  public String getOvfAvisetypeField() {
    return ovfAvisetypeField;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.1.1,17.1.3.
   * @param ovfAvisetypeField set the ovfAvisetypeField.
   */
  public void setOvfAvisetypeField(String  ovfAvisetypeField) {
    this.ovfAvisetypeField = ovfAvisetypeField;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property powerstate of obj type vimgrvmruntime field type str  type string.
   * @return powerstate
   */
  public String getPowerstate() {
    return powerstate;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property powerstate of obj type vimgrvmruntime field type str  type string.
   * @param powerstate set the powerstate.
   */
  public void setPowerstate(String  powerstate) {
    this.powerstate = powerstate;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_ver of obj type vimgrvmruntime field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.
   * @return seVer
   */
  public Integer getSeVer() {
    return seVer;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_ver of obj type vimgrvmruntime field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.
   * @param seVer set the seVer.
   */
  public void setSeVer(Integer  seVer) {
    this.seVer = seVer;
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
   * Unique object identifier of vcenter_datacenter.
   * @return vcenterDatacenterUuid
   */
  public String getVcenterDatacenterUuid() {
    return vcenterDatacenterUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of vcenter_datacenter.
   * @param vcenterDatacenterUuid set the vcenterDatacenterUuid.
   */
  public void setVcenterDatacenterUuid(String  vcenterDatacenterUuid) {
    this.vcenterDatacenterUuid = vcenterDatacenterUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vcenter_rm_cookie of obj type vimgrvmruntime field type str  type string.
   * @return vcenterRmCookie
   */
  public String getVcenterRmCookie() {
    return vcenterRmCookie;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vcenter_rm_cookie of obj type vimgrvmruntime field type str  type string.
   * @param vcenterRmCookie set the vcenterRmCookie.
   */
  public void setVcenterRmCookie(String  vcenterRmCookie) {
    this.vcenterRmCookie = vcenterRmCookie;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - VIMGR_SE_NETWORK_ADMIN, VIMGR_SE_UNIFIED_ADMIN.
   * @return vcenterSeType
   */
  public String getVcenterSeType() {
    return vcenterSeType;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - VIMGR_SE_NETWORK_ADMIN, VIMGR_SE_UNIFIED_ADMIN.
   * @param vcenterSeType set the vcenterSeType.
   */
  public void setVcenterSeType(String  vcenterSeType) {
    this.vcenterSeType = vcenterSeType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vcenter_template_vm of obj type vimgrvmruntime field type str  type boolean.
   * @return vcenterTemplateVm
   */
  public Boolean getVcenterTemplateVm() {
    return vcenterTemplateVm;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vcenter_template_vm of obj type vimgrvmruntime field type str  type boolean.
   * @param vcenterTemplateVm set the vcenterTemplateVm.
   */
  public void setVcenterTemplateVm(Boolean  vcenterTemplateVm) {
    this.vcenterTemplateVm = vcenterTemplateVm;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vcenter_vappname of obj type vimgrvmruntime field type str  type string.
   * @return vcenterVappname
   */
  public String getVcenterVappname() {
    return vcenterVappname;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vcenter_vappname of obj type vimgrvmruntime field type str  type string.
   * @param vcenterVappname set the vcenterVappname.
   */
  public void setVcenterVappname(String  vcenterVappname) {
    this.vcenterVappname = vcenterVappname;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vcenter_vappvendor of obj type vimgrvmruntime field type str  type string.
   * @return vcenterVappvendor
   */
  public String getVcenterVappvendor() {
    return vcenterVappvendor;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vcenter_vappvendor of obj type vimgrvmruntime field type str  type string.
   * @param vcenterVappvendor set the vcenterVappvendor.
   */
  public void setVcenterVappvendor(String  vcenterVappvendor) {
    this.vcenterVappvendor = vcenterVappvendor;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - VMTYPE_SE_VM, VMTYPE_POOL_SRVR.
   * @return vcenterVmType
   */
  public String getVcenterVmType() {
    return vcenterVmType;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - VMTYPE_SE_VM, VMTYPE_POOL_SRVR.
   * @param vcenterVmType set the vcenterVmType.
   */
  public void setVcenterVmType(String  vcenterVmType) {
    this.vcenterVmType = vcenterVmType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vcenter_vnic_discovered of obj type vimgrvmruntime field type str  type boolean.
   * @return vcenterVnicDiscovered
   */
  public Boolean getVcenterVnicDiscovered() {
    return vcenterVnicDiscovered;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vcenter_vnic_discovered of obj type vimgrvmruntime field type str  type boolean.
   * @param vcenterVnicDiscovered set the vcenterVnicDiscovered.
   */
  public void setVcenterVnicDiscovered(Boolean  vcenterVnicDiscovered) {
    this.vcenterVnicDiscovered = vcenterVnicDiscovered;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vm_lb_weight of obj type vimgrvmruntime field type str  type integer.
   * @return vmLbWeight
   */
  public Integer getVmLbWeight() {
    return vmLbWeight;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vm_lb_weight of obj type vimgrvmruntime field type str  type integer.
   * @param vmLbWeight set the vmLbWeight.
   */
  public void setVmLbWeight(Integer  vmLbWeight) {
    this.vmLbWeight = vmLbWeight;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VIMgrVMRuntime objVIMgrVMRuntime = (VIMgrVMRuntime) o;
  return   Objects.equals(this.type, objVIMgrVMRuntime.type)&&
  Objects.equals(this.uuid, objVIMgrVMRuntime.uuid)&&
  Objects.equals(this.name, objVIMgrVMRuntime.name)&&
  Objects.equals(this.managedObjectId, objVIMgrVMRuntime.managedObjectId)&&
  Objects.equals(this.host, objVIMgrVMRuntime.host)&&
  Objects.equals(this.powerstate, objVIMgrVMRuntime.powerstate)&&
  Objects.equals(this.connectionState, objVIMgrVMRuntime.connectionState)&&
  Objects.equals(this.vcenterDatacenterUuid, objVIMgrVMRuntime.vcenterDatacenterUuid)&&
  Objects.equals(this.vcenterVmType, objVIMgrVMRuntime.vcenterVmType)&&
  Objects.equals(this.vcenterVnicDiscovered, objVIMgrVMRuntime.vcenterVnicDiscovered)&&
  Objects.equals(this.vcenterVappname, objVIMgrVMRuntime.vcenterVappname)&&
  Objects.equals(this.vcenterVappvendor, objVIMgrVMRuntime.vcenterVappvendor)&&
  Objects.equals(this.vcenterTemplateVm, objVIMgrVMRuntime.vcenterTemplateVm)&&
  Objects.equals(this.vcenterSeType, objVIMgrVMRuntime.vcenterSeType)&&
  Objects.equals(this.creationInProgress, objVIMgrVMRuntime.creationInProgress)&&
  Objects.equals(this.vcenterRmCookie, objVIMgrVMRuntime.vcenterRmCookie)&&
  Objects.equals(this.numCpu, objVIMgrVMRuntime.numCpu)&&
  Objects.equals(this.cpuShares, objVIMgrVMRuntime.cpuShares)&&
  Objects.equals(this.cpuReservation, objVIMgrVMRuntime.cpuReservation)&&
  Objects.equals(this.memory, objVIMgrVMRuntime.memory)&&
  Objects.equals(this.memShares, objVIMgrVMRuntime.memShares)&&
  Objects.equals(this.memoryReservation, objVIMgrVMRuntime.memoryReservation)&&
  Objects.equals(this.vmLbWeight, objVIMgrVMRuntime.vmLbWeight)&&
  Objects.equals(this.controllerIpAddr, objVIMgrVMRuntime.controllerIpAddr)&&
  Objects.equals(this.guestNic, objVIMgrVMRuntime.guestNic)&&
  Objects.equals(this.controllerVm, objVIMgrVMRuntime.controllerVm)&&
  Objects.equals(this.seVer, objVIMgrVMRuntime.seVer)&&
  Objects.equals(this.initVnics, objVIMgrVMRuntime.initVnics)&&
  Objects.equals(this.controllerClusterUuid, objVIMgrVMRuntime.controllerClusterUuid)&&
  Objects.equals(this.availabilityZone, objVIMgrVMRuntime.availabilityZone)&&
  Objects.equals(this.ovfAvisetypeField, objVIMgrVMRuntime.ovfAvisetypeField)&&
  Objects.equals(this.tenantRef, objVIMgrVMRuntime.tenantRef)&&
  Objects.equals(this.cloudRef, objVIMgrVMRuntime.cloudRef);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VIMgrVMRuntime {\n");
      sb.append("    availabilityZone: ").append(toIndentedString(availabilityZone)).append("\n");
        sb.append("    cloudRef: ").append(toIndentedString(cloudRef)).append("\n");
        sb.append("    connectionState: ").append(toIndentedString(connectionState)).append("\n");
        sb.append("    controllerClusterUuid: ").append(toIndentedString(controllerClusterUuid)).append("\n");
        sb.append("    controllerIpAddr: ").append(toIndentedString(controllerIpAddr)).append("\n");
        sb.append("    controllerVm: ").append(toIndentedString(controllerVm)).append("\n");
        sb.append("    cpuReservation: ").append(toIndentedString(cpuReservation)).append("\n");
        sb.append("    cpuShares: ").append(toIndentedString(cpuShares)).append("\n");
        sb.append("    creationInProgress: ").append(toIndentedString(creationInProgress)).append("\n");
        sb.append("    guestNic: ").append(toIndentedString(guestNic)).append("\n");
        sb.append("    host: ").append(toIndentedString(host)).append("\n");
        sb.append("    initVnics: ").append(toIndentedString(initVnics)).append("\n");
        sb.append("    managedObjectId: ").append(toIndentedString(managedObjectId)).append("\n");
        sb.append("    memShares: ").append(toIndentedString(memShares)).append("\n");
        sb.append("    memory: ").append(toIndentedString(memory)).append("\n");
        sb.append("    memoryReservation: ").append(toIndentedString(memoryReservation)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    numCpu: ").append(toIndentedString(numCpu)).append("\n");
        sb.append("    ovfAvisetypeField: ").append(toIndentedString(ovfAvisetypeField)).append("\n");
        sb.append("    powerstate: ").append(toIndentedString(powerstate)).append("\n");
        sb.append("    seVer: ").append(toIndentedString(seVer)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
            sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
        sb.append("    vcenterDatacenterUuid: ").append(toIndentedString(vcenterDatacenterUuid)).append("\n");
        sb.append("    vcenterRmCookie: ").append(toIndentedString(vcenterRmCookie)).append("\n");
        sb.append("    vcenterSeType: ").append(toIndentedString(vcenterSeType)).append("\n");
        sb.append("    vcenterTemplateVm: ").append(toIndentedString(vcenterTemplateVm)).append("\n");
        sb.append("    vcenterVappname: ").append(toIndentedString(vcenterVappname)).append("\n");
        sb.append("    vcenterVappvendor: ").append(toIndentedString(vcenterVappvendor)).append("\n");
        sb.append("    vcenterVmType: ").append(toIndentedString(vcenterVmType)).append("\n");
        sb.append("    vcenterVnicDiscovered: ").append(toIndentedString(vcenterVnicDiscovered)).append("\n");
        sb.append("    vmLbWeight: ").append(toIndentedString(vmLbWeight)).append("\n");
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

