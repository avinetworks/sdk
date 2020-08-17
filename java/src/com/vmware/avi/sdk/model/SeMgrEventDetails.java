package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SeMgrEventDetails is a POJO class extends AviRestResource that used for creating
 * SeMgrEventDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeMgrEventDetails  {
    @JsonProperty("cloud_name")
    private String cloudName = null;

    @JsonProperty("cloud_uuid")
    private String cloudUuid = null;

    @JsonProperty("enable_state")
    private String enableState = null;

    @JsonProperty("gcp_info")
    private GcpInfo gcpInfo = null;

    @JsonProperty("host_name")
    private String hostName = null;

    @JsonProperty("host_uuid")
    private String hostUuid = null;

    @JsonProperty("memory")
    private Integer memory = null;

    @JsonProperty("migrate_state")
    private String migrateState = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("reason")
    private String reason = null;

    @JsonProperty("se_grp_name")
    private String seGrpName = null;

    @JsonProperty("se_grp_uuid")
    private String seGrpUuid = null;

    @JsonProperty("vcpus")
    private Integer vcpus = null;

    @JsonProperty("vs_name")
    private List<String> vsName = null;

    @JsonProperty("vs_uuid")
    private List<String> vsUuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cloud_name of obj type semgreventdetails field type str  type string.
   * @return cloudName
   */
  public String getCloudName() {
    return cloudName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cloud_name of obj type semgreventdetails field type str  type string.
   * @param cloudName set the cloudName.
   */
  public void setCloudName(String  cloudName) {
    this.cloudName = cloudName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of cloud.
   * @return cloudUuid
   */
  public String getCloudUuid() {
    return cloudUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of cloud.
   * @param cloudUuid set the cloudUuid.
   */
  public void setCloudUuid(String  cloudUuid) {
    this.cloudUuid = cloudUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property enable_state of obj type semgreventdetails field type str  type string.
   * @return enableState
   */
  public String getEnableState() {
    return enableState;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property enable_state of obj type semgreventdetails field type str  type string.
   * @param enableState set the enableState.
   */
  public void setEnableState(String  enableState) {
    this.enableState = enableState;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property gcp_info of obj type semgreventdetails field type str  type ref.
   * @return gcpInfo
   */
  public GcpInfo getGcpInfo() {
    return gcpInfo;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property gcp_info of obj type semgreventdetails field type str  type ref.
   * @param gcpInfo set the gcpInfo.
   */
  public void setGcpInfo(GcpInfo gcpInfo) {
    this.gcpInfo = gcpInfo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property host_name of obj type semgreventdetails field type str  type string.
   * @return hostName
   */
  public String getHostName() {
    return hostName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property host_name of obj type semgreventdetails field type str  type string.
   * @param hostName set the hostName.
   */
  public void setHostName(String  hostName) {
    this.hostName = hostName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of host.
   * @return hostUuid
   */
  public String getHostUuid() {
    return hostUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of host.
   * @param hostUuid set the hostUuid.
   */
  public void setHostUuid(String  hostUuid) {
    this.hostUuid = hostUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property memory of obj type semgreventdetails field type str  type integer.
   * @return memory
   */
  public Integer getMemory() {
    return memory;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property memory of obj type semgreventdetails field type str  type integer.
   * @param memory set the memory.
   */
  public void setMemory(Integer  memory) {
    this.memory = memory;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property migrate_state of obj type semgreventdetails field type str  type string.
   * @return migrateState
   */
  public String getMigrateState() {
    return migrateState;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property migrate_state of obj type semgreventdetails field type str  type string.
   * @param migrateState set the migrateState.
   */
  public void setMigrateState(String  migrateState) {
    this.migrateState = migrateState;
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
   * Placeholder for description of property reason of obj type semgreventdetails field type str  type string.
   * @return reason
   */
  public String getReason() {
    return reason;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property reason of obj type semgreventdetails field type str  type string.
   * @param reason set the reason.
   */
  public void setReason(String  reason) {
    this.reason = reason;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_grp_name of obj type semgreventdetails field type str  type string.
   * @return seGrpName
   */
  public String getSeGrpName() {
    return seGrpName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_grp_name of obj type semgreventdetails field type str  type string.
   * @param seGrpName set the seGrpName.
   */
  public void setSeGrpName(String  seGrpName) {
    this.seGrpName = seGrpName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of se_grp.
   * @return seGrpUuid
   */
  public String getSeGrpUuid() {
    return seGrpUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of se_grp.
   * @param seGrpUuid set the seGrpUuid.
   */
  public void setSeGrpUuid(String  seGrpUuid) {
    this.seGrpUuid = seGrpUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vcpus of obj type semgreventdetails field type str  type integer.
   * @return vcpus
   */
  public Integer getVcpus() {
    return vcpus;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vcpus of obj type semgreventdetails field type str  type integer.
   * @param vcpus set the vcpus.
   */
  public void setVcpus(Integer  vcpus) {
    this.vcpus = vcpus;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vs_name of obj type semgreventdetails field type str  type array.
   * @return vsName
   */
  public List<String> getVsName() {
    return vsName;
  }

  /**
   * This is the setter method. this will set the vsName
   * Placeholder for description of property vs_name of obj type semgreventdetails field type str  type array.
   * @return vsName
   */
  public void setVsName(List<String>  vsName) {
    this.vsName = vsName;
  }

  /**
   * This is the setter method this will set the vsName
   * Placeholder for description of property vs_name of obj type semgreventdetails field type str  type array.
   * @return vsName
   */
  public SeMgrEventDetails addVsNameItem(String vsNameItem) {
    if (this.vsName == null) {
      this.vsName = new ArrayList<String>();
    }
    this.vsName.add(vsNameItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of vs.
   * @return vsUuid
   */
  public List<String> getVsUuid() {
    return vsUuid;
  }

  /**
   * This is the setter method. this will set the vsUuid
   * Unique object identifier of vs.
   * @return vsUuid
   */
  public void setVsUuid(List<String>  vsUuid) {
    this.vsUuid = vsUuid;
  }

  /**
   * This is the setter method this will set the vsUuid
   * Unique object identifier of vs.
   * @return vsUuid
   */
  public SeMgrEventDetails addVsUuidItem(String vsUuidItem) {
    if (this.vsUuid == null) {
      this.vsUuid = new ArrayList<String>();
    }
    this.vsUuid.add(vsUuidItem);
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
  SeMgrEventDetails objSeMgrEventDetails = (SeMgrEventDetails) o;
  return   Objects.equals(this.name, objSeMgrEventDetails.name)&&
  Objects.equals(this.reason, objSeMgrEventDetails.reason)&&
  Objects.equals(this.hostUuid, objSeMgrEventDetails.hostUuid)&&
  Objects.equals(this.hostName, objSeMgrEventDetails.hostName)&&
  Objects.equals(this.vsUuid, objSeMgrEventDetails.vsUuid)&&
  Objects.equals(this.vsName, objSeMgrEventDetails.vsName)&&
  Objects.equals(this.vcpus, objSeMgrEventDetails.vcpus)&&
  Objects.equals(this.memory, objSeMgrEventDetails.memory)&&
  Objects.equals(this.seGrpUuid, objSeMgrEventDetails.seGrpUuid)&&
  Objects.equals(this.seGrpName, objSeMgrEventDetails.seGrpName)&&
  Objects.equals(this.cloudUuid, objSeMgrEventDetails.cloudUuid)&&
  Objects.equals(this.cloudName, objSeMgrEventDetails.cloudName)&&
  Objects.equals(this.enableState, objSeMgrEventDetails.enableState)&&
  Objects.equals(this.migrateState, objSeMgrEventDetails.migrateState)&&
  Objects.equals(this.gcpInfo, objSeMgrEventDetails.gcpInfo);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SeMgrEventDetails {\n");
      sb.append("    cloudName: ").append(toIndentedString(cloudName)).append("\n");
        sb.append("    cloudUuid: ").append(toIndentedString(cloudUuid)).append("\n");
        sb.append("    enableState: ").append(toIndentedString(enableState)).append("\n");
        sb.append("    gcpInfo: ").append(toIndentedString(gcpInfo)).append("\n");
        sb.append("    hostName: ").append(toIndentedString(hostName)).append("\n");
        sb.append("    hostUuid: ").append(toIndentedString(hostUuid)).append("\n");
        sb.append("    memory: ").append(toIndentedString(memory)).append("\n");
        sb.append("    migrateState: ").append(toIndentedString(migrateState)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    seGrpName: ").append(toIndentedString(seGrpName)).append("\n");
        sb.append("    seGrpUuid: ").append(toIndentedString(seGrpUuid)).append("\n");
        sb.append("    vcpus: ").append(toIndentedString(vcpus)).append("\n");
        sb.append("    vsName: ").append(toIndentedString(vsName)).append("\n");
        sb.append("    vsUuid: ").append(toIndentedString(vsUuid)).append("\n");
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

