package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VIMgrSEVMRuntime is a POJO class extends AviRestResource that used for creating
 * VIMgrSEVMRuntime.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VIMgrSEVMRuntime extends AviRestResource  {
    @JsonProperty("availability_zone")
    private String availabilityZone = null;

    @JsonProperty("azure_info")
    private AzureInfo azureInfo = null;

    @JsonProperty("cloud_name")
    private String cloudName = null;

    @JsonProperty("cloud_ref")
    private String cloudRef = null;

    @JsonProperty("connection_state")
    private String connectionState = null;

    @JsonProperty("controller_cluster_uuid")
    private String controllerClusterUuid = null;

    @JsonProperty("controller_ip_addr")
    private String controllerIpAddr = null;

    @JsonProperty("cookie")
    private String cookie = null;

    @JsonProperty("creation_in_progress")
    private Boolean creationInProgress = null;

    @JsonProperty("deletion_in_progress")
    private Boolean deletionInProgress = null;

    @JsonProperty("discovery_response")
    private String discoveryResponse = null;

    @JsonProperty("discovery_status")
    private Integer discoveryStatus = null;

    @JsonProperty("disk_gb")
    private Integer diskGb = null;

    @JsonProperty("flavor")
    private String flavor = null;

    @JsonProperty("guest_nic")
    private List<VIMgrGuestNicRuntime> guestNic = null;

    @JsonProperty("host")
    private String host = null;

    @JsonProperty("host_ref")
    private String hostRef = null;

    @JsonProperty("hostid")
    private String hostid = null;

    @JsonProperty("hypervisor")
    private String hypervisor = null;

    @JsonProperty("init_vnics")
    private Integer initVnics = null;

    @JsonProperty("last_discovery")
    private Integer lastDiscovery = null;

    @JsonProperty("managed_object_id")
    private String managedObjectId = null;

    @JsonProperty("memory_mb")
    private Integer memoryMb = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("powerstate")
    private String powerstate = null;

    @JsonProperty("security_group_uuid")
    private String securityGroupUuid = null;

    @JsonProperty("segroup_ref")
    private String segroupRef = null;

    @JsonProperty("server_group_uuid")
    private String serverGroupUuid = null;

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

    @JsonProperty("vcenter_ref")
    private String vcenterRef = null;

    @JsonProperty("vcenter_rm_cookie")
    private String vcenterRmCookie = null;

    @JsonProperty("vcenter_se_type")
    private String vcenterSeType = null;

    @JsonProperty("vcenter_template_vm")
    private Boolean vcenterTemplateVm = null;

    @JsonProperty("vcenter_url")
    private String vcenterUrl = null;

    @JsonProperty("vcenter_vAppName")
    private String vcenterVappname = null;

    @JsonProperty("vcenter_vAppVendor")
    private String vcenterVappvendor = null;

    @JsonProperty("vcenter_vm_type")
    private String vcenterVmType = null;

    @JsonProperty("vcpus")
    private Integer vcpus = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property availability_zone of obj type vimgrsevmruntime field type str  type string.
   * @return availabilityZone
   */
  public String getAvailabilityZone() {
    return availabilityZone;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property availability_zone of obj type vimgrsevmruntime field type str  type string.
   * @param availabilityZone set the availabilityZone.
   */
  public void setAvailabilityZone(String  availabilityZone) {
    this.availabilityZone = availabilityZone;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.2.1.
   * @return azureInfo
   */
  public AzureInfo getAzureInfo() {
    return azureInfo;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.2.1.
   * @param azureInfo set the azureInfo.
   */
  public void setAzureInfo(AzureInfo azureInfo) {
    this.azureInfo = azureInfo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cloud_name of obj type vimgrsevmruntime field type str  type string.
   * @return cloudName
   */
  public String getCloudName() {
    return cloudName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cloud_name of obj type vimgrsevmruntime field type str  type string.
   * @param cloudName set the cloudName.
   */
  public void setCloudName(String  cloudName) {
    this.cloudName = cloudName;
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
   * Placeholder for description of property connection_state of obj type vimgrsevmruntime field type str  type string.
   * @return connectionState
   */
  public String getConnectionState() {
    return connectionState;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property connection_state of obj type vimgrsevmruntime field type str  type string.
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
   * Placeholder for description of property controller_ip_addr of obj type vimgrsevmruntime field type str  type string.
   * @return controllerIpAddr
   */
  public String getControllerIpAddr() {
    return controllerIpAddr;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property controller_ip_addr of obj type vimgrsevmruntime field type str  type string.
   * @param controllerIpAddr set the controllerIpAddr.
   */
  public void setControllerIpAddr(String  controllerIpAddr) {
    this.controllerIpAddr = controllerIpAddr;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Service engine cookie set by the resource manager.
   * Field introduced in 18.2.2.
   * @return cookie
   */
  public String getCookie() {
    return cookie;
  }

  /**
   * This is the setter method to the attribute.
   * Service engine cookie set by the resource manager.
   * Field introduced in 18.2.2.
   * @param cookie set the cookie.
   */
  public void setCookie(String  cookie) {
    this.cookie = cookie;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property creation_in_progress of obj type vimgrsevmruntime field type str  type boolean.
   * @return creationInProgress
   */
  public Boolean getCreationInProgress() {
    return creationInProgress;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property creation_in_progress of obj type vimgrsevmruntime field type str  type boolean.
   * @param creationInProgress set the creationInProgress.
   */
  public void setCreationInProgress(Boolean  creationInProgress) {
    this.creationInProgress = creationInProgress;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property deletion_in_progress of obj type vimgrsevmruntime field type str  type boolean.
   * @return deletionInProgress
   */
  public Boolean getDeletionInProgress() {
    return deletionInProgress;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property deletion_in_progress of obj type vimgrsevmruntime field type str  type boolean.
   * @param deletionInProgress set the deletionInProgress.
   */
  public void setDeletionInProgress(Boolean  deletionInProgress) {
    this.deletionInProgress = deletionInProgress;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property discovery_response of obj type vimgrsevmruntime field type str  type string.
   * @return discoveryResponse
   */
  public String getDiscoveryResponse() {
    return discoveryResponse;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property discovery_response of obj type vimgrsevmruntime field type str  type string.
   * @param discoveryResponse set the discoveryResponse.
   */
  public void setDiscoveryResponse(String  discoveryResponse) {
    this.discoveryResponse = discoveryResponse;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property discovery_status of obj type vimgrsevmruntime field type str  type integer.
   * @return discoveryStatus
   */
  public Integer getDiscoveryStatus() {
    return discoveryStatus;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property discovery_status of obj type vimgrsevmruntime field type str  type integer.
   * @param discoveryStatus set the discoveryStatus.
   */
  public void setDiscoveryStatus(Integer  discoveryStatus) {
    this.discoveryStatus = discoveryStatus;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Disk space in gb for each service engine vm.
   * Field introduced in 18.2.2.
   * @return diskGb
   */
  public Integer getDiskGb() {
    return diskGb;
  }

  /**
   * This is the setter method to the attribute.
   * Disk space in gb for each service engine vm.
   * Field introduced in 18.2.2.
   * @param diskGb set the diskGb.
   */
  public void setDiskGb(Integer  diskGb) {
    this.diskGb = diskGb;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property flavor of obj type vimgrsevmruntime field type str  type string.
   * @return flavor
   */
  public String getFlavor() {
    return flavor;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property flavor of obj type vimgrsevmruntime field type str  type string.
   * @param flavor set the flavor.
   */
  public void setFlavor(String  flavor) {
    this.flavor = flavor;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property guest_nic of obj type vimgrsevmruntime field type str  type array.
   * @return guestNic
   */
  public List<VIMgrGuestNicRuntime> getGuestNic() {
    return guestNic;
  }

  /**
   * This is the setter method. this will set the guestNic
   * Placeholder for description of property guest_nic of obj type vimgrsevmruntime field type str  type array.
   * @return guestNic
   */
  public void setGuestNic(List<VIMgrGuestNicRuntime>  guestNic) {
    this.guestNic = guestNic;
  }

  /**
   * This is the setter method this will set the guestNic
   * Placeholder for description of property guest_nic of obj type vimgrsevmruntime field type str  type array.
   * @return guestNic
   */
  public VIMgrSEVMRuntime addGuestNicItem(VIMgrGuestNicRuntime guestNicItem) {
    if (this.guestNic == null) {
      this.guestNic = new ArrayList<VIMgrGuestNicRuntime>();
    }
    this.guestNic.add(guestNicItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property host of obj type vimgrsevmruntime field type str  type string.
   * @return host
   */
  public String getHost() {
    return host;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property host of obj type vimgrsevmruntime field type str  type string.
   * @param host set the host.
   */
  public void setHost(String  host) {
    this.host = host;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type vimgrhostruntime.
   * @return hostRef
   */
  public String getHostRef() {
    return hostRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type vimgrhostruntime.
   * @param hostRef set the hostRef.
   */
  public void setHostRef(String  hostRef) {
    this.hostRef = hostRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property hostid of obj type vimgrsevmruntime field type str  type string.
   * @return hostid
   */
  public String getHostid() {
    return hostid;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property hostid of obj type vimgrsevmruntime field type str  type string.
   * @param hostid set the hostid.
   */
  public void setHostid(String  hostid) {
    this.hostid = hostid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - DEFAULT, VMWARE_ESX, KVM, VMWARE_VSAN, XEN.
   * @return hypervisor
   */
  public String getHypervisor() {
    return hypervisor;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - DEFAULT, VMWARE_ESX, KVM, VMWARE_VSAN, XEN.
   * @param hypervisor set the hypervisor.
   */
  public void setHypervisor(String  hypervisor) {
    this.hypervisor = hypervisor;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property init_vnics of obj type vimgrsevmruntime field type str  type integer.
   * @return initVnics
   */
  public Integer getInitVnics() {
    return initVnics;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property init_vnics of obj type vimgrsevmruntime field type str  type integer.
   * @param initVnics set the initVnics.
   */
  public void setInitVnics(Integer  initVnics) {
    this.initVnics = initVnics;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property last_discovery of obj type vimgrsevmruntime field type str  type integer.
   * @return lastDiscovery
   */
  public Integer getLastDiscovery() {
    return lastDiscovery;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property last_discovery of obj type vimgrsevmruntime field type str  type integer.
   * @param lastDiscovery set the lastDiscovery.
   */
  public void setLastDiscovery(Integer  lastDiscovery) {
    this.lastDiscovery = lastDiscovery;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property managed_object_id of obj type vimgrsevmruntime field type str  type string.
   * @return managedObjectId
   */
  public String getManagedObjectId() {
    return managedObjectId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property managed_object_id of obj type vimgrsevmruntime field type str  type string.
   * @param managedObjectId set the managedObjectId.
   */
  public void setManagedObjectId(String  managedObjectId) {
    this.managedObjectId = managedObjectId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Memory in mb for each service engine vm.
   * Field introduced in 18.2.2.
   * @return memoryMb
   */
  public Integer getMemoryMb() {
    return memoryMb;
  }

  /**
   * This is the setter method to the attribute.
   * Memory in mb for each service engine vm.
   * Field introduced in 18.2.2.
   * @param memoryMb set the memoryMb.
   */
  public void setMemoryMb(Integer  memoryMb) {
    this.memoryMb = memoryMb;
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
   * Placeholder for description of property powerstate of obj type vimgrsevmruntime field type str  type string.
   * @return powerstate
   */
  public String getPowerstate() {
    return powerstate;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property powerstate of obj type vimgrsevmruntime field type str  type string.
   * @param powerstate set the powerstate.
   */
  public void setPowerstate(String  powerstate) {
    this.powerstate = powerstate;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of security_group.
   * @return securityGroupUuid
   */
  public String getSecurityGroupUuid() {
    return securityGroupUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of security_group.
   * @param securityGroupUuid set the securityGroupUuid.
   */
  public void setSecurityGroupUuid(String  securityGroupUuid) {
    this.securityGroupUuid = securityGroupUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type serviceenginegroup.
   * @return segroupRef
   */
  public String getSegroupRef() {
    return segroupRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type serviceenginegroup.
   * @param segroupRef set the segroupRef.
   */
  public void setSegroupRef(String  segroupRef) {
    this.segroupRef = segroupRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of server_group.
   * @return serverGroupUuid
   */
  public String getServerGroupUuid() {
    return serverGroupUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of server_group.
   * @param serverGroupUuid set the serverGroupUuid.
   */
  public void setServerGroupUuid(String  serverGroupUuid) {
    this.serverGroupUuid = serverGroupUuid;
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
   * Serviceengine belongs to vcenter.
   * It is a reference to an object of type vcenterserver.
   * Field introduced in 20.1.1.
   * @return vcenterRef
   */
  public String getVcenterRef() {
    return vcenterRef;
  }

  /**
   * This is the setter method to the attribute.
   * Serviceengine belongs to vcenter.
   * It is a reference to an object of type vcenterserver.
   * Field introduced in 20.1.1.
   * @param vcenterRef set the vcenterRef.
   */
  public void setVcenterRef(String  vcenterRef) {
    this.vcenterRef = vcenterRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vcenter_rm_cookie of obj type vimgrsevmruntime field type str  type string.
   * @return vcenterRmCookie
   */
  public String getVcenterRmCookie() {
    return vcenterRmCookie;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vcenter_rm_cookie of obj type vimgrsevmruntime field type str  type string.
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
   * Placeholder for description of property vcenter_template_vm of obj type vimgrsevmruntime field type str  type boolean.
   * @return vcenterTemplateVm
   */
  public Boolean getVcenterTemplateVm() {
    return vcenterTemplateVm;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vcenter_template_vm of obj type vimgrsevmruntime field type str  type boolean.
   * @param vcenterTemplateVm set the vcenterTemplateVm.
   */
  public void setVcenterTemplateVm(Boolean  vcenterTemplateVm) {
    this.vcenterTemplateVm = vcenterTemplateVm;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Service engine deployed in vcenter.
   * Field introduced in 20.1.1.
   * @return vcenterUrl
   */
  public String getVcenterUrl() {
    return vcenterUrl;
  }

  /**
   * This is the setter method to the attribute.
   * Service engine deployed in vcenter.
   * Field introduced in 20.1.1.
   * @param vcenterUrl set the vcenterUrl.
   */
  public void setVcenterUrl(String  vcenterUrl) {
    this.vcenterUrl = vcenterUrl;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vcenter_vappname of obj type vimgrsevmruntime field type str  type string.
   * @return vcenterVappname
   */
  public String getVcenterVappname() {
    return vcenterVappname;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vcenter_vappname of obj type vimgrsevmruntime field type str  type string.
   * @param vcenterVappname set the vcenterVappname.
   */
  public void setVcenterVappname(String  vcenterVappname) {
    this.vcenterVappname = vcenterVappname;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vcenter_vappvendor of obj type vimgrsevmruntime field type str  type string.
   * @return vcenterVappvendor
   */
  public String getVcenterVappvendor() {
    return vcenterVappvendor;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vcenter_vappvendor of obj type vimgrsevmruntime field type str  type string.
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
   * Count of vcpus for each service engine vm.
   * Field introduced in 18.2.2.
   * @return vcpus
   */
  public Integer getVcpus() {
    return vcpus;
  }

  /**
   * This is the setter method to the attribute.
   * Count of vcpus for each service engine vm.
   * Field introduced in 18.2.2.
   * @param vcpus set the vcpus.
   */
  public void setVcpus(Integer  vcpus) {
    this.vcpus = vcpus;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VIMgrSEVMRuntime objVIMgrSEVMRuntime = (VIMgrSEVMRuntime) o;
  return   Objects.equals(this.powerstate, objVIMgrSEVMRuntime.powerstate)&&
  Objects.equals(this.vcenterVappname, objVIMgrSEVMRuntime.vcenterVappname)&&
  Objects.equals(this.availabilityZone, objVIMgrSEVMRuntime.availabilityZone)&&
  Objects.equals(this.discoveryStatus, objVIMgrSEVMRuntime.discoveryStatus)&&
  Objects.equals(this.initVnics, objVIMgrSEVMRuntime.initVnics)&&
  Objects.equals(this.managedObjectId, objVIMgrSEVMRuntime.managedObjectId)&&
  Objects.equals(this.creationInProgress, objVIMgrSEVMRuntime.creationInProgress)&&
  Objects.equals(this.vcenterUrl, objVIMgrSEVMRuntime.vcenterUrl)&&
  Objects.equals(this.flavor, objVIMgrSEVMRuntime.flavor)&&
  Objects.equals(this.memoryMb, objVIMgrSEVMRuntime.memoryMb)&&
  Objects.equals(this.uuid, objVIMgrSEVMRuntime.uuid)&&
  Objects.equals(this.vcenterVappvendor, objVIMgrSEVMRuntime.vcenterVappvendor)&&
  Objects.equals(this.cloudRef, objVIMgrSEVMRuntime.cloudRef)&&
  Objects.equals(this.vcenterRef, objVIMgrSEVMRuntime.vcenterRef)&&
  Objects.equals(this.azureInfo, objVIMgrSEVMRuntime.azureInfo)&&
  Objects.equals(this.vcenterDatacenterUuid, objVIMgrSEVMRuntime.vcenterDatacenterUuid)&&
  Objects.equals(this.type, objVIMgrSEVMRuntime.type)&&
  Objects.equals(this.connectionState, objVIMgrSEVMRuntime.connectionState)&&
  Objects.equals(this.vcenterVmType, objVIMgrSEVMRuntime.vcenterVmType)&&
  Objects.equals(this.diskGb, objVIMgrSEVMRuntime.diskGb)&&
  Objects.equals(this.deletionInProgress, objVIMgrSEVMRuntime.deletionInProgress)&&
  Objects.equals(this.serverGroupUuid, objVIMgrSEVMRuntime.serverGroupUuid)&&
  Objects.equals(this.cloudName, objVIMgrSEVMRuntime.cloudName)&&
  Objects.equals(this.host, objVIMgrSEVMRuntime.host)&&
  Objects.equals(this.vcenterSeType, objVIMgrSEVMRuntime.vcenterSeType)&&
  Objects.equals(this.guestNic, objVIMgrSEVMRuntime.guestNic)&&
  Objects.equals(this.hostRef, objVIMgrSEVMRuntime.hostRef)&&
  Objects.equals(this.segroupRef, objVIMgrSEVMRuntime.segroupRef)&&
  Objects.equals(this.vcenterRmCookie, objVIMgrSEVMRuntime.vcenterRmCookie)&&
  Objects.equals(this.hostid, objVIMgrSEVMRuntime.hostid)&&
  Objects.equals(this.name, objVIMgrSEVMRuntime.name)&&
  Objects.equals(this.lastDiscovery, objVIMgrSEVMRuntime.lastDiscovery)&&
  Objects.equals(this.hypervisor, objVIMgrSEVMRuntime.hypervisor)&&
  Objects.equals(this.securityGroupUuid, objVIMgrSEVMRuntime.securityGroupUuid)&&
  Objects.equals(this.vcenterTemplateVm, objVIMgrSEVMRuntime.vcenterTemplateVm)&&
  Objects.equals(this.controllerIpAddr, objVIMgrSEVMRuntime.controllerIpAddr)&&
  Objects.equals(this.vcpus, objVIMgrSEVMRuntime.vcpus)&&
  Objects.equals(this.controllerClusterUuid, objVIMgrSEVMRuntime.controllerClusterUuid)&&
  Objects.equals(this.cookie, objVIMgrSEVMRuntime.cookie)&&
  Objects.equals(this.tenantRef, objVIMgrSEVMRuntime.tenantRef)&&
  Objects.equals(this.discoveryResponse, objVIMgrSEVMRuntime.discoveryResponse);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VIMgrSEVMRuntime {\n");
      sb.append("    availabilityZone: ").append(toIndentedString(availabilityZone)).append("\n");
        sb.append("    azureInfo: ").append(toIndentedString(azureInfo)).append("\n");
        sb.append("    cloudName: ").append(toIndentedString(cloudName)).append("\n");
        sb.append("    cloudRef: ").append(toIndentedString(cloudRef)).append("\n");
        sb.append("    connectionState: ").append(toIndentedString(connectionState)).append("\n");
        sb.append("    controllerClusterUuid: ").append(toIndentedString(controllerClusterUuid)).append("\n");
        sb.append("    controllerIpAddr: ").append(toIndentedString(controllerIpAddr)).append("\n");
        sb.append("    cookie: ").append(toIndentedString(cookie)).append("\n");
        sb.append("    creationInProgress: ").append(toIndentedString(creationInProgress)).append("\n");
        sb.append("    deletionInProgress: ").append(toIndentedString(deletionInProgress)).append("\n");
        sb.append("    discoveryResponse: ").append(toIndentedString(discoveryResponse)).append("\n");
        sb.append("    discoveryStatus: ").append(toIndentedString(discoveryStatus)).append("\n");
        sb.append("    diskGb: ").append(toIndentedString(diskGb)).append("\n");
        sb.append("    flavor: ").append(toIndentedString(flavor)).append("\n");
        sb.append("    guestNic: ").append(toIndentedString(guestNic)).append("\n");
        sb.append("    host: ").append(toIndentedString(host)).append("\n");
        sb.append("    hostRef: ").append(toIndentedString(hostRef)).append("\n");
        sb.append("    hostid: ").append(toIndentedString(hostid)).append("\n");
        sb.append("    hypervisor: ").append(toIndentedString(hypervisor)).append("\n");
        sb.append("    initVnics: ").append(toIndentedString(initVnics)).append("\n");
        sb.append("    lastDiscovery: ").append(toIndentedString(lastDiscovery)).append("\n");
        sb.append("    managedObjectId: ").append(toIndentedString(managedObjectId)).append("\n");
        sb.append("    memoryMb: ").append(toIndentedString(memoryMb)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    powerstate: ").append(toIndentedString(powerstate)).append("\n");
        sb.append("    securityGroupUuid: ").append(toIndentedString(securityGroupUuid)).append("\n");
        sb.append("    segroupRef: ").append(toIndentedString(segroupRef)).append("\n");
        sb.append("    serverGroupUuid: ").append(toIndentedString(serverGroupUuid)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
            sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
        sb.append("    vcenterDatacenterUuid: ").append(toIndentedString(vcenterDatacenterUuid)).append("\n");
        sb.append("    vcenterRef: ").append(toIndentedString(vcenterRef)).append("\n");
        sb.append("    vcenterRmCookie: ").append(toIndentedString(vcenterRmCookie)).append("\n");
        sb.append("    vcenterSeType: ").append(toIndentedString(vcenterSeType)).append("\n");
        sb.append("    vcenterTemplateVm: ").append(toIndentedString(vcenterTemplateVm)).append("\n");
        sb.append("    vcenterUrl: ").append(toIndentedString(vcenterUrl)).append("\n");
        sb.append("    vcenterVappname: ").append(toIndentedString(vcenterVappname)).append("\n");
        sb.append("    vcenterVappvendor: ").append(toIndentedString(vcenterVappvendor)).append("\n");
        sb.append("    vcenterVmType: ").append(toIndentedString(vcenterVmType)).append("\n");
        sb.append("    vcpus: ").append(toIndentedString(vcpus)).append("\n");
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

