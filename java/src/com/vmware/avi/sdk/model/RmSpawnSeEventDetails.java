package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The RmSpawnSeEventDetails is a POJO class extends AviRestResource that used for creating
 * RmSpawnSeEventDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RmSpawnSeEventDetails  {
    @JsonProperty("availability_zone")
    private String availabilityZone = null;

    @JsonProperty("cloud_name")
    private String cloudName = null;

    @JsonProperty("cloud_uuid")
    private String cloudUuid = null;

    @JsonProperty("host_name")
    private String hostName = null;

    @JsonProperty("host_uuid")
    private String hostUuid = null;

    @JsonProperty("memory")
    private Integer memory = null;

    @JsonProperty("network_names")
    private List<String> networkNames = null;

    @JsonProperty("networks")
    private List<String> networks = null;

    @JsonProperty("reason")
    private String reason = null;

    @JsonProperty("se_cookie")
    private String seCookie = null;

    @JsonProperty("se_grp_name")
    private String seGrpName = null;

    @JsonProperty("se_grp_uuid")
    private String seGrpUuid = null;

    @JsonProperty("se_name")
    private String seName = null;

    @JsonProperty("se_uuid")
    private String seUuid = null;

    @JsonProperty("status_code")
    private Integer statusCode = null;

    @JsonProperty("vcpus")
    private Integer vcpus = null;

    @JsonProperty("vs_name")
    private String vsName = null;

    @JsonProperty("vs_uuid")
    private String vsUuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property availability_zone of obj type rmspawnseeventdetails field type str  type string.
   * @return availabilityZone
   */
  public String getAvailabilityZone() {
    return availabilityZone;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property availability_zone of obj type rmspawnseeventdetails field type str  type string.
   * @param availabilityZone set the availabilityZone.
   */
  public void setAvailabilityZone(String  availabilityZone) {
    this.availabilityZone = availabilityZone;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cloud_name of obj type rmspawnseeventdetails field type str  type string.
   * @return cloudName
   */
  public String getCloudName() {
    return cloudName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cloud_name of obj type rmspawnseeventdetails field type str  type string.
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
   * Placeholder for description of property host_name of obj type rmspawnseeventdetails field type str  type string.
   * @return hostName
   */
  public String getHostName() {
    return hostName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property host_name of obj type rmspawnseeventdetails field type str  type string.
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
   * Placeholder for description of property memory of obj type rmspawnseeventdetails field type str  type integer.
   * @return memory
   */
  public Integer getMemory() {
    return memory;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property memory of obj type rmspawnseeventdetails field type str  type integer.
   * @param memory set the memory.
   */
  public void setMemory(Integer  memory) {
    this.memory = memory;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property network_names of obj type rmspawnseeventdetails field type str  type array.
   * @return networkNames
   */
  public List<String> getNetworkNames() {
    return networkNames;
  }

  /**
   * This is the setter method. this will set the networkNames
   * Placeholder for description of property network_names of obj type rmspawnseeventdetails field type str  type array.
   * @return networkNames
   */
  public void setNetworkNames(List<String>  networkNames) {
    this.networkNames = networkNames;
  }

  /**
   * This is the setter method this will set the networkNames
   * Placeholder for description of property network_names of obj type rmspawnseeventdetails field type str  type array.
   * @return networkNames
   */
  public RmSpawnSeEventDetails addNetworkNamesItem(String networkNamesItem) {
    if (this.networkNames == null) {
      this.networkNames = new ArrayList<String>();
    }
    this.networkNames.add(networkNamesItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property networks of obj type rmspawnseeventdetails field type str  type array.
   * @return networks
   */
  public List<String> getNetworks() {
    return networks;
  }

  /**
   * This is the setter method. this will set the networks
   * Placeholder for description of property networks of obj type rmspawnseeventdetails field type str  type array.
   * @return networks
   */
  public void setNetworks(List<String>  networks) {
    this.networks = networks;
  }

  /**
   * This is the setter method this will set the networks
   * Placeholder for description of property networks of obj type rmspawnseeventdetails field type str  type array.
   * @return networks
   */
  public RmSpawnSeEventDetails addNetworksItem(String networksItem) {
    if (this.networks == null) {
      this.networks = new ArrayList<String>();
    }
    this.networks.add(networksItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property reason of obj type rmspawnseeventdetails field type str  type string.
   * @return reason
   */
  public String getReason() {
    return reason;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property reason of obj type rmspawnseeventdetails field type str  type string.
   * @param reason set the reason.
   */
  public void setReason(String  reason) {
    this.reason = reason;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_cookie of obj type rmspawnseeventdetails field type str  type string.
   * @return seCookie
   */
  public String getSeCookie() {
    return seCookie;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_cookie of obj type rmspawnseeventdetails field type str  type string.
   * @param seCookie set the seCookie.
   */
  public void setSeCookie(String  seCookie) {
    this.seCookie = seCookie;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_grp_name of obj type rmspawnseeventdetails field type str  type string.
   * @return seGrpName
   */
  public String getSeGrpName() {
    return seGrpName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_grp_name of obj type rmspawnseeventdetails field type str  type string.
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
   * Placeholder for description of property se_name of obj type rmspawnseeventdetails field type str  type string.
   * @return seName
   */
  public String getSeName() {
    return seName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_name of obj type rmspawnseeventdetails field type str  type string.
   * @param seName set the seName.
   */
  public void setSeName(String  seName) {
    this.seName = seName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of se.
   * @return seUuid
   */
  public String getSeUuid() {
    return seUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of se.
   * @param seUuid set the seUuid.
   */
  public void setSeUuid(String  seUuid) {
    this.seUuid = seUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property status_code of obj type rmspawnseeventdetails field type str  type integer.
   * @return statusCode
   */
  public Integer getStatusCode() {
    return statusCode;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property status_code of obj type rmspawnseeventdetails field type str  type integer.
   * @param statusCode set the statusCode.
   */
  public void setStatusCode(Integer  statusCode) {
    this.statusCode = statusCode;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vcpus of obj type rmspawnseeventdetails field type str  type integer.
   * @return vcpus
   */
  public Integer getVcpus() {
    return vcpus;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vcpus of obj type rmspawnseeventdetails field type str  type integer.
   * @param vcpus set the vcpus.
   */
  public void setVcpus(Integer  vcpus) {
    this.vcpus = vcpus;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vs_name of obj type rmspawnseeventdetails field type str  type string.
   * @return vsName
   */
  public String getVsName() {
    return vsName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vs_name of obj type rmspawnseeventdetails field type str  type string.
   * @param vsName set the vsName.
   */
  public void setVsName(String  vsName) {
    this.vsName = vsName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of vs.
   * @return vsUuid
   */
  public String getVsUuid() {
    return vsUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of vs.
   * @param vsUuid set the vsUuid.
   */
  public void setVsUuid(String  vsUuid) {
    this.vsUuid = vsUuid;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  RmSpawnSeEventDetails objRmSpawnSeEventDetails = (RmSpawnSeEventDetails) o;
  return   Objects.equals(this.seName, objRmSpawnSeEventDetails.seName)&&
  Objects.equals(this.seCookie, objRmSpawnSeEventDetails.seCookie)&&
  Objects.equals(this.seUuid, objRmSpawnSeEventDetails.seUuid)&&
  Objects.equals(this.hostUuid, objRmSpawnSeEventDetails.hostUuid)&&
  Objects.equals(this.hostName, objRmSpawnSeEventDetails.hostName)&&
  Objects.equals(this.availabilityZone, objRmSpawnSeEventDetails.availabilityZone)&&
  Objects.equals(this.networks, objRmSpawnSeEventDetails.networks)&&
  Objects.equals(this.statusCode, objRmSpawnSeEventDetails.statusCode)&&
  Objects.equals(this.reason, objRmSpawnSeEventDetails.reason)&&
  Objects.equals(this.vsUuid, objRmSpawnSeEventDetails.vsUuid)&&
  Objects.equals(this.vsName, objRmSpawnSeEventDetails.vsName)&&
  Objects.equals(this.networkNames, objRmSpawnSeEventDetails.networkNames)&&
  Objects.equals(this.vcpus, objRmSpawnSeEventDetails.vcpus)&&
  Objects.equals(this.memory, objRmSpawnSeEventDetails.memory)&&
  Objects.equals(this.seGrpUuid, objRmSpawnSeEventDetails.seGrpUuid)&&
  Objects.equals(this.seGrpName, objRmSpawnSeEventDetails.seGrpName)&&
  Objects.equals(this.cloudUuid, objRmSpawnSeEventDetails.cloudUuid)&&
  Objects.equals(this.cloudName, objRmSpawnSeEventDetails.cloudName);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class RmSpawnSeEventDetails {\n");
      sb.append("    availabilityZone: ").append(toIndentedString(availabilityZone)).append("\n");
        sb.append("    cloudName: ").append(toIndentedString(cloudName)).append("\n");
        sb.append("    cloudUuid: ").append(toIndentedString(cloudUuid)).append("\n");
        sb.append("    hostName: ").append(toIndentedString(hostName)).append("\n");
        sb.append("    hostUuid: ").append(toIndentedString(hostUuid)).append("\n");
        sb.append("    memory: ").append(toIndentedString(memory)).append("\n");
        sb.append("    networkNames: ").append(toIndentedString(networkNames)).append("\n");
        sb.append("    networks: ").append(toIndentedString(networks)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    seCookie: ").append(toIndentedString(seCookie)).append("\n");
        sb.append("    seGrpName: ").append(toIndentedString(seGrpName)).append("\n");
        sb.append("    seGrpUuid: ").append(toIndentedString(seGrpUuid)).append("\n");
        sb.append("    seName: ").append(toIndentedString(seName)).append("\n");
        sb.append("    seUuid: ").append(toIndentedString(seUuid)).append("\n");
        sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
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

