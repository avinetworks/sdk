package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VIMgrVcenterRuntime is a POJO class extends AviRestResource that used for creating
 * VIMgrVcenterRuntime.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VIMgrVcenterRuntime extends AviRestResource  {
    @JsonProperty("api_version")
    private String apiVersion = null;

    @JsonProperty("apic_mode")
    private Boolean apicMode = false;

    @JsonProperty("cloud_ref")
    private String cloudRef = null;

    @JsonProperty("datacenter_refs")
    private List<String> datacenterRefs = null;

    @JsonProperty("disc_end_time")
    private String discEndTime = null;

    @JsonProperty("disc_start_time")
    private String discStartTime = null;

    @JsonProperty("discovered_datacenter")
    private String discoveredDatacenter = null;

    @JsonProperty("inventory_progress")
    private String inventoryProgress = null;

    @JsonProperty("inventory_state")
    private String inventoryState = null;

    @JsonProperty("management_network")
    private String managementNetwork = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("num_clusters")
    private Integer numClusters = null;

    @JsonProperty("num_dcs")
    private Integer numDcs = null;

    @JsonProperty("num_hosts")
    private Integer numHosts = null;

    @JsonProperty("num_nws")
    private Integer numNws = null;

    @JsonProperty("num_vcenter_req_pending")
    private Integer numVcenterReqPending = null;

    @JsonProperty("num_vms")
    private Integer numVms = null;

    @JsonProperty("password")
    private String password = null;

    @JsonProperty("privilege")
    private String privilege = null;

    @JsonProperty("progress")
    private Integer progress = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("type")
    private String type = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("username")
    private String username = null;

    @JsonProperty("uuid")
    private String uuid = null;

    @JsonProperty("vcenter_connected")
    private Boolean vcenterConnected = false;

    @JsonProperty("vcenter_fullname")
    private String vcenterFullname = null;

    @JsonProperty("vcenter_template_se_location")
    private String vcenterTemplateSeLocation = null;

    @JsonProperty("vcenter_url")
    private String vcenterUrl = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property api_version of obj type vimgrvcenterruntime field type str  type string.
   * @return apiVersion
   */
  public String getApiVersion() {
    return apiVersion;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property api_version of obj type vimgrvcenterruntime field type str  type string.
   * @param apiVersion set the apiVersion.
   */
  public void setApiVersion(String  apiVersion) {
    this.apiVersion = apiVersion;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property apic_mode of obj type vimgrvcenterruntime field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return apicMode
   */
  public Boolean getApicMode() {
    return apicMode;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property apic_mode of obj type vimgrvcenterruntime field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param apicMode set the apicMode.
   */
  public void setApicMode(Boolean  apicMode) {
    this.apicMode = apicMode;
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
   * It is a reference to an object of type vimgrdcruntime.
   * @return datacenterRefs
   */
  public List<String> getDatacenterRefs() {
    return datacenterRefs;
  }

  /**
   * This is the setter method. this will set the datacenterRefs
   * It is a reference to an object of type vimgrdcruntime.
   * @return datacenterRefs
   */
  public void setDatacenterRefs(List<String>  datacenterRefs) {
    this.datacenterRefs = datacenterRefs;
  }

  /**
   * This is the setter method this will set the datacenterRefs
   * It is a reference to an object of type vimgrdcruntime.
   * @return datacenterRefs
   */
  public VIMgrVcenterRuntime addDatacenterRefsItem(String datacenterRefsItem) {
    if (this.datacenterRefs == null) {
      this.datacenterRefs = new ArrayList<String>();
    }
    this.datacenterRefs.add(datacenterRefsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property disc_end_time of obj type vimgrvcenterruntime field type str  type string.
   * @return discEndTime
   */
  public String getDiscEndTime() {
    return discEndTime;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property disc_end_time of obj type vimgrvcenterruntime field type str  type string.
   * @param discEndTime set the discEndTime.
   */
  public void setDiscEndTime(String  discEndTime) {
    this.discEndTime = discEndTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property disc_start_time of obj type vimgrvcenterruntime field type str  type string.
   * @return discStartTime
   */
  public String getDiscStartTime() {
    return discStartTime;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property disc_start_time of obj type vimgrvcenterruntime field type str  type string.
   * @param discStartTime set the discStartTime.
   */
  public void setDiscStartTime(String  discStartTime) {
    this.discStartTime = discStartTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property discovered_datacenter of obj type vimgrvcenterruntime field type str  type string.
   * @return discoveredDatacenter
   */
  public String getDiscoveredDatacenter() {
    return discoveredDatacenter;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property discovered_datacenter of obj type vimgrvcenterruntime field type str  type string.
   * @param discoveredDatacenter set the discoveredDatacenter.
   */
  public void setDiscoveredDatacenter(String  discoveredDatacenter) {
    this.discoveredDatacenter = discoveredDatacenter;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property inventory_progress of obj type vimgrvcenterruntime field type str  type string.
   * @return inventoryProgress
   */
  public String getInventoryProgress() {
    return inventoryProgress;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property inventory_progress of obj type vimgrvcenterruntime field type str  type string.
   * @param inventoryProgress set the inventoryProgress.
   */
  public void setInventoryProgress(String  inventoryProgress) {
    this.inventoryProgress = inventoryProgress;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - VCENTER_DISCOVERY_BAD_CREDENTIALS, VCENTER_DISCOVERY_RETRIEVING_DC, VCENTER_DISCOVERY_WAITING_DC, VCENTER_DISCOVERY_RETRIEVING_NW,
   * VCENTER_DISCOVERY_ONGOING, VCENTER_DISCOVERY_RESYNCING, VCENTER_DISCOVERY_COMPLETE, VCENTER_DISCOVERY_DELETING_VCENTER, VCENTER_DISCOVERY_FAILURE,
   * VCENTER_DISCOVERY_COMPLETE_NO_MGMT_NW, VCENTER_DISCOVERY_COMPLETE_PER_TENANT_IP_ROUTE, VCENTER_DISCOVERY_MAKING_SE_OVA,
   * VCENTER_DISCOVERY_RESYNC_FAILED, VCENTER_DISCOVERY_OBJECT_LIMIT_REACHED.
   * @return inventoryState
   */
  public String getInventoryState() {
    return inventoryState;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - VCENTER_DISCOVERY_BAD_CREDENTIALS, VCENTER_DISCOVERY_RETRIEVING_DC, VCENTER_DISCOVERY_WAITING_DC, VCENTER_DISCOVERY_RETRIEVING_NW,
   * VCENTER_DISCOVERY_ONGOING, VCENTER_DISCOVERY_RESYNCING, VCENTER_DISCOVERY_COMPLETE, VCENTER_DISCOVERY_DELETING_VCENTER, VCENTER_DISCOVERY_FAILURE,
   * VCENTER_DISCOVERY_COMPLETE_NO_MGMT_NW, VCENTER_DISCOVERY_COMPLETE_PER_TENANT_IP_ROUTE, VCENTER_DISCOVERY_MAKING_SE_OVA,
   * VCENTER_DISCOVERY_RESYNC_FAILED, VCENTER_DISCOVERY_OBJECT_LIMIT_REACHED.
   * @param inventoryState set the inventoryState.
   */
  public void setInventoryState(String  inventoryState) {
    this.inventoryState = inventoryState;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property management_network of obj type vimgrvcenterruntime field type str  type string.
   * @return managementNetwork
   */
  public String getManagementNetwork() {
    return managementNetwork;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property management_network of obj type vimgrvcenterruntime field type str  type string.
   * @param managementNetwork set the managementNetwork.
   */
  public void setManagementNetwork(String  managementNetwork) {
    this.managementNetwork = managementNetwork;
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
   * Placeholder for description of property num_clusters of obj type vimgrvcenterruntime field type str  type integer.
   * @return numClusters
   */
  public Integer getNumClusters() {
    return numClusters;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property num_clusters of obj type vimgrvcenterruntime field type str  type integer.
   * @param numClusters set the numClusters.
   */
  public void setNumClusters(Integer  numClusters) {
    this.numClusters = numClusters;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property num_dcs of obj type vimgrvcenterruntime field type str  type integer.
   * @return numDcs
   */
  public Integer getNumDcs() {
    return numDcs;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property num_dcs of obj type vimgrvcenterruntime field type str  type integer.
   * @param numDcs set the numDcs.
   */
  public void setNumDcs(Integer  numDcs) {
    this.numDcs = numDcs;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property num_hosts of obj type vimgrvcenterruntime field type str  type integer.
   * @return numHosts
   */
  public Integer getNumHosts() {
    return numHosts;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property num_hosts of obj type vimgrvcenterruntime field type str  type integer.
   * @param numHosts set the numHosts.
   */
  public void setNumHosts(Integer  numHosts) {
    this.numHosts = numHosts;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property num_nws of obj type vimgrvcenterruntime field type str  type integer.
   * @return numNws
   */
  public Integer getNumNws() {
    return numNws;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property num_nws of obj type vimgrvcenterruntime field type str  type integer.
   * @param numNws set the numNws.
   */
  public void setNumNws(Integer  numNws) {
    this.numNws = numNws;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property num_vcenter_req_pending of obj type vimgrvcenterruntime field type str  type integer.
   * @return numVcenterReqPending
   */
  public Integer getNumVcenterReqPending() {
    return numVcenterReqPending;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property num_vcenter_req_pending of obj type vimgrvcenterruntime field type str  type integer.
   * @param numVcenterReqPending set the numVcenterReqPending.
   */
  public void setNumVcenterReqPending(Integer  numVcenterReqPending) {
    this.numVcenterReqPending = numVcenterReqPending;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property num_vms of obj type vimgrvcenterruntime field type str  type integer.
   * @return numVms
   */
  public Integer getNumVms() {
    return numVms;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property num_vms of obj type vimgrvcenterruntime field type str  type integer.
   * @param numVms set the numVms.
   */
  public void setNumVms(Integer  numVms) {
    this.numVms = numVms;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property password of obj type vimgrvcenterruntime field type str  type string.
   * @return password
   */
  public String getPassword() {
    return password;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property password of obj type vimgrvcenterruntime field type str  type string.
   * @param password set the password.
   */
  public void setPassword(String  password) {
    this.password = password;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - NO_ACCESS, READ_ACCESS, WRITE_ACCESS.
   * @return privilege
   */
  public String getPrivilege() {
    return privilege;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - NO_ACCESS, READ_ACCESS, WRITE_ACCESS.
   * @param privilege set the privilege.
   */
  public void setPrivilege(String  privilege) {
    this.privilege = privilege;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property progress of obj type vimgrvcenterruntime field type str  type integer.
   * @return progress
   */
  public Integer getProgress() {
    return progress;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property progress of obj type vimgrvcenterruntime field type str  type integer.
   * @param progress set the progress.
   */
  public void setProgress(Integer  progress) {
    this.progress = progress;
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
   * Placeholder for description of property username of obj type vimgrvcenterruntime field type str  type string.
   * @return username
   */
  public String getUsername() {
    return username;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property username of obj type vimgrvcenterruntime field type str  type string.
   * @param username set the username.
   */
  public void setUsername(String  username) {
    this.username = username;
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
   * Placeholder for description of property vcenter_connected of obj type vimgrvcenterruntime field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return vcenterConnected
   */
  public Boolean getVcenterConnected() {
    return vcenterConnected;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vcenter_connected of obj type vimgrvcenterruntime field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param vcenterConnected set the vcenterConnected.
   */
  public void setVcenterConnected(Boolean  vcenterConnected) {
    this.vcenterConnected = vcenterConnected;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vcenter_fullname of obj type vimgrvcenterruntime field type str  type string.
   * @return vcenterFullname
   */
  public String getVcenterFullname() {
    return vcenterFullname;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vcenter_fullname of obj type vimgrvcenterruntime field type str  type string.
   * @param vcenterFullname set the vcenterFullname.
   */
  public void setVcenterFullname(String  vcenterFullname) {
    this.vcenterFullname = vcenterFullname;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vcenter_template_se_location of obj type vimgrvcenterruntime field type str  type string.
   * @return vcenterTemplateSeLocation
   */
  public String getVcenterTemplateSeLocation() {
    return vcenterTemplateSeLocation;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vcenter_template_se_location of obj type vimgrvcenterruntime field type str  type string.
   * @param vcenterTemplateSeLocation set the vcenterTemplateSeLocation.
   */
  public void setVcenterTemplateSeLocation(String  vcenterTemplateSeLocation) {
    this.vcenterTemplateSeLocation = vcenterTemplateSeLocation;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vcenter_url of obj type vimgrvcenterruntime field type str  type string.
   * @return vcenterUrl
   */
  public String getVcenterUrl() {
    return vcenterUrl;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vcenter_url of obj type vimgrvcenterruntime field type str  type string.
   * @param vcenterUrl set the vcenterUrl.
   */
  public void setVcenterUrl(String  vcenterUrl) {
    this.vcenterUrl = vcenterUrl;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VIMgrVcenterRuntime objVIMgrVcenterRuntime = (VIMgrVcenterRuntime) o;
  return   Objects.equals(this.type, objVIMgrVcenterRuntime.type)&&
  Objects.equals(this.uuid, objVIMgrVcenterRuntime.uuid)&&
  Objects.equals(this.name, objVIMgrVcenterRuntime.name)&&
  Objects.equals(this.vcenterUrl, objVIMgrVcenterRuntime.vcenterUrl)&&
  Objects.equals(this.username, objVIMgrVcenterRuntime.username)&&
  Objects.equals(this.password, objVIMgrVcenterRuntime.password)&&
  Objects.equals(this.datacenterRefs, objVIMgrVcenterRuntime.datacenterRefs)&&
  Objects.equals(this.privilege, objVIMgrVcenterRuntime.privilege)&&
  Objects.equals(this.inventoryState, objVIMgrVcenterRuntime.inventoryState)&&
  Objects.equals(this.discoveredDatacenter, objVIMgrVcenterRuntime.discoveredDatacenter)&&
  Objects.equals(this.progress, objVIMgrVcenterRuntime.progress)&&
  Objects.equals(this.numDcs, objVIMgrVcenterRuntime.numDcs)&&
  Objects.equals(this.numHosts, objVIMgrVcenterRuntime.numHosts)&&
  Objects.equals(this.numClusters, objVIMgrVcenterRuntime.numClusters)&&
  Objects.equals(this.numVms, objVIMgrVcenterRuntime.numVms)&&
  Objects.equals(this.numNws, objVIMgrVcenterRuntime.numNws)&&
  Objects.equals(this.numVcenterReqPending, objVIMgrVcenterRuntime.numVcenterReqPending)&&
  Objects.equals(this.discStartTime, objVIMgrVcenterRuntime.discStartTime)&&
  Objects.equals(this.discEndTime, objVIMgrVcenterRuntime.discEndTime)&&
  Objects.equals(this.managementNetwork, objVIMgrVcenterRuntime.managementNetwork)&&
  Objects.equals(this.inventoryProgress, objVIMgrVcenterRuntime.inventoryProgress)&&
  Objects.equals(this.apicMode, objVIMgrVcenterRuntime.apicMode)&&
  Objects.equals(this.vcenterTemplateSeLocation, objVIMgrVcenterRuntime.vcenterTemplateSeLocation)&&
  Objects.equals(this.apiVersion, objVIMgrVcenterRuntime.apiVersion)&&
  Objects.equals(this.vcenterFullname, objVIMgrVcenterRuntime.vcenterFullname)&&
  Objects.equals(this.vcenterConnected, objVIMgrVcenterRuntime.vcenterConnected)&&
  Objects.equals(this.tenantRef, objVIMgrVcenterRuntime.tenantRef)&&
  Objects.equals(this.cloudRef, objVIMgrVcenterRuntime.cloudRef);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VIMgrVcenterRuntime {\n");
      sb.append("    apiVersion: ").append(toIndentedString(apiVersion)).append("\n");
        sb.append("    apicMode: ").append(toIndentedString(apicMode)).append("\n");
        sb.append("    cloudRef: ").append(toIndentedString(cloudRef)).append("\n");
        sb.append("    datacenterRefs: ").append(toIndentedString(datacenterRefs)).append("\n");
        sb.append("    discEndTime: ").append(toIndentedString(discEndTime)).append("\n");
        sb.append("    discStartTime: ").append(toIndentedString(discStartTime)).append("\n");
        sb.append("    discoveredDatacenter: ").append(toIndentedString(discoveredDatacenter)).append("\n");
        sb.append("    inventoryProgress: ").append(toIndentedString(inventoryProgress)).append("\n");
        sb.append("    inventoryState: ").append(toIndentedString(inventoryState)).append("\n");
        sb.append("    managementNetwork: ").append(toIndentedString(managementNetwork)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    numClusters: ").append(toIndentedString(numClusters)).append("\n");
        sb.append("    numDcs: ").append(toIndentedString(numDcs)).append("\n");
        sb.append("    numHosts: ").append(toIndentedString(numHosts)).append("\n");
        sb.append("    numNws: ").append(toIndentedString(numNws)).append("\n");
        sb.append("    numVcenterReqPending: ").append(toIndentedString(numVcenterReqPending)).append("\n");
        sb.append("    numVms: ").append(toIndentedString(numVms)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
        sb.append("    privilege: ").append(toIndentedString(privilege)).append("\n");
        sb.append("    progress: ").append(toIndentedString(progress)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
            sb.append("    username: ").append(toIndentedString(username)).append("\n");
        sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
        sb.append("    vcenterConnected: ").append(toIndentedString(vcenterConnected)).append("\n");
        sb.append("    vcenterFullname: ").append(toIndentedString(vcenterFullname)).append("\n");
        sb.append("    vcenterTemplateSeLocation: ").append(toIndentedString(vcenterTemplateSeLocation)).append("\n");
        sb.append("    vcenterUrl: ").append(toIndentedString(vcenterUrl)).append("\n");
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

