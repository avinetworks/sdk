package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ContainerCloudSetup is a POJO class extends AviRestResource that used for creating
 * ContainerCloudSetup.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContainerCloudSetup  {
    @JsonProperty("cc_id")
    private String ccId = null;

    @JsonProperty("cloud_access")
    private Boolean cloudAccess = null;

    @JsonProperty("failed_hosts")
    private List<String> failedHosts = null;

    @JsonProperty("fleet_endpoint")
    private String fleetEndpoint = null;

    @JsonProperty("hosts")
    private List<String> hosts = null;

    @JsonProperty("master_nodes")
    private List<String> masterNodes = null;

    @JsonProperty("missing_hosts")
    private List<String> missingHosts = null;

    @JsonProperty("new_hosts")
    private List<String> newHosts = null;

    @JsonProperty("reason")
    private String reason = null;

    @JsonProperty("se_deploy_method_access")
    private Boolean seDeployMethodAccess = null;

    @JsonProperty("se_name")
    private String seName = null;

    @JsonProperty("version")
    private String version = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cc_id of obj type containercloudsetup field type str  type string.
   * @return ccId
   */
  public String getCcId() {
    return ccId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cc_id of obj type containercloudsetup field type str  type string.
   * @param ccId set the ccId.
   */
  public void setCcId(String  ccId) {
    this.ccId = ccId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cloud_access of obj type containercloudsetup field type str  type boolean.
   * @return cloudAccess
   */
  public Boolean getCloudAccess() {
    return cloudAccess;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cloud_access of obj type containercloudsetup field type str  type boolean.
   * @param cloudAccess set the cloudAccess.
   */
  public void setCloudAccess(Boolean  cloudAccess) {
    this.cloudAccess = cloudAccess;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property failed_hosts of obj type containercloudsetup field type str  type array.
   * @return failedHosts
   */
  public List<String> getFailedHosts() {
    return failedHosts;
  }

  /**
   * This is the setter method. this will set the failedHosts
   * Placeholder for description of property failed_hosts of obj type containercloudsetup field type str  type array.
   * @return failedHosts
   */
  public void setFailedHosts(List<String>  failedHosts) {
    this.failedHosts = failedHosts;
  }

  /**
   * This is the setter method this will set the failedHosts
   * Placeholder for description of property failed_hosts of obj type containercloudsetup field type str  type array.
   * @return failedHosts
   */
  public ContainerCloudSetup addFailedHostsItem(String failedHostsItem) {
    if (this.failedHosts == null) {
      this.failedHosts = new ArrayList<String>();
    }
    this.failedHosts.add(failedHostsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property fleet_endpoint of obj type containercloudsetup field type str  type string.
   * @return fleetEndpoint
   */
  public String getFleetEndpoint() {
    return fleetEndpoint;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property fleet_endpoint of obj type containercloudsetup field type str  type string.
   * @param fleetEndpoint set the fleetEndpoint.
   */
  public void setFleetEndpoint(String  fleetEndpoint) {
    this.fleetEndpoint = fleetEndpoint;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property hosts of obj type containercloudsetup field type str  type array.
   * @return hosts
   */
  public List<String> getHosts() {
    return hosts;
  }

  /**
   * This is the setter method. this will set the hosts
   * Placeholder for description of property hosts of obj type containercloudsetup field type str  type array.
   * @return hosts
   */
  public void setHosts(List<String>  hosts) {
    this.hosts = hosts;
  }

  /**
   * This is the setter method this will set the hosts
   * Placeholder for description of property hosts of obj type containercloudsetup field type str  type array.
   * @return hosts
   */
  public ContainerCloudSetup addHostsItem(String hostsItem) {
    if (this.hosts == null) {
      this.hosts = new ArrayList<String>();
    }
    this.hosts.add(hostsItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property master_nodes of obj type containercloudsetup field type str  type array.
   * @return masterNodes
   */
  public List<String> getMasterNodes() {
    return masterNodes;
  }

  /**
   * This is the setter method. this will set the masterNodes
   * Placeholder for description of property master_nodes of obj type containercloudsetup field type str  type array.
   * @return masterNodes
   */
  public void setMasterNodes(List<String>  masterNodes) {
    this.masterNodes = masterNodes;
  }

  /**
   * This is the setter method this will set the masterNodes
   * Placeholder for description of property master_nodes of obj type containercloudsetup field type str  type array.
   * @return masterNodes
   */
  public ContainerCloudSetup addMasterNodesItem(String masterNodesItem) {
    if (this.masterNodes == null) {
      this.masterNodes = new ArrayList<String>();
    }
    this.masterNodes.add(masterNodesItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property missing_hosts of obj type containercloudsetup field type str  type array.
   * @return missingHosts
   */
  public List<String> getMissingHosts() {
    return missingHosts;
  }

  /**
   * This is the setter method. this will set the missingHosts
   * Placeholder for description of property missing_hosts of obj type containercloudsetup field type str  type array.
   * @return missingHosts
   */
  public void setMissingHosts(List<String>  missingHosts) {
    this.missingHosts = missingHosts;
  }

  /**
   * This is the setter method this will set the missingHosts
   * Placeholder for description of property missing_hosts of obj type containercloudsetup field type str  type array.
   * @return missingHosts
   */
  public ContainerCloudSetup addMissingHostsItem(String missingHostsItem) {
    if (this.missingHosts == null) {
      this.missingHosts = new ArrayList<String>();
    }
    this.missingHosts.add(missingHostsItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property new_hosts of obj type containercloudsetup field type str  type array.
   * @return newHosts
   */
  public List<String> getNewHosts() {
    return newHosts;
  }

  /**
   * This is the setter method. this will set the newHosts
   * Placeholder for description of property new_hosts of obj type containercloudsetup field type str  type array.
   * @return newHosts
   */
  public void setNewHosts(List<String>  newHosts) {
    this.newHosts = newHosts;
  }

  /**
   * This is the setter method this will set the newHosts
   * Placeholder for description of property new_hosts of obj type containercloudsetup field type str  type array.
   * @return newHosts
   */
  public ContainerCloudSetup addNewHostsItem(String newHostsItem) {
    if (this.newHosts == null) {
      this.newHosts = new ArrayList<String>();
    }
    this.newHosts.add(newHostsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property reason of obj type containercloudsetup field type str  type string.
   * @return reason
   */
  public String getReason() {
    return reason;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property reason of obj type containercloudsetup field type str  type string.
   * @param reason set the reason.
   */
  public void setReason(String  reason) {
    this.reason = reason;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_deploy_method_access of obj type containercloudsetup field type str  type boolean.
   * @return seDeployMethodAccess
   */
  public Boolean getSeDeployMethodAccess() {
    return seDeployMethodAccess;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_deploy_method_access of obj type containercloudsetup field type str  type boolean.
   * @param seDeployMethodAccess set the seDeployMethodAccess.
   */
  public void setSeDeployMethodAccess(Boolean  seDeployMethodAccess) {
    this.seDeployMethodAccess = seDeployMethodAccess;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_name of obj type containercloudsetup field type str  type string.
   * @return seName
   */
  public String getSeName() {
    return seName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_name of obj type containercloudsetup field type str  type string.
   * @param seName set the seName.
   */
  public void setSeName(String  seName) {
    this.seName = seName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property version of obj type containercloudsetup field type str  type string.
   * @return version
   */
  public String getVersion() {
    return version;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property version of obj type containercloudsetup field type str  type string.
   * @param version set the version.
   */
  public void setVersion(String  version) {
    this.version = version;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ContainerCloudSetup objContainerCloudSetup = (ContainerCloudSetup) o;
  return   Objects.equals(this.ccId, objContainerCloudSetup.ccId)&&
  Objects.equals(this.masterNodes, objContainerCloudSetup.masterNodes)&&
  Objects.equals(this.cloudAccess, objContainerCloudSetup.cloudAccess)&&
  Objects.equals(this.fleetEndpoint, objContainerCloudSetup.fleetEndpoint)&&
  Objects.equals(this.seDeployMethodAccess, objContainerCloudSetup.seDeployMethodAccess)&&
  Objects.equals(this.reason, objContainerCloudSetup.reason)&&
  Objects.equals(this.version, objContainerCloudSetup.version)&&
  Objects.equals(this.seName, objContainerCloudSetup.seName)&&
  Objects.equals(this.hosts, objContainerCloudSetup.hosts)&&
  Objects.equals(this.newHosts, objContainerCloudSetup.newHosts)&&
  Objects.equals(this.missingHosts, objContainerCloudSetup.missingHosts)&&
  Objects.equals(this.failedHosts, objContainerCloudSetup.failedHosts);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ContainerCloudSetup {\n");
      sb.append("    ccId: ").append(toIndentedString(ccId)).append("\n");
        sb.append("    cloudAccess: ").append(toIndentedString(cloudAccess)).append("\n");
        sb.append("    failedHosts: ").append(toIndentedString(failedHosts)).append("\n");
        sb.append("    fleetEndpoint: ").append(toIndentedString(fleetEndpoint)).append("\n");
        sb.append("    hosts: ").append(toIndentedString(hosts)).append("\n");
        sb.append("    masterNodes: ").append(toIndentedString(masterNodes)).append("\n");
        sb.append("    missingHosts: ").append(toIndentedString(missingHosts)).append("\n");
        sb.append("    newHosts: ").append(toIndentedString(newHosts)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    seDeployMethodAccess: ").append(toIndentedString(seDeployMethodAccess)).append("\n");
        sb.append("    seName: ").append(toIndentedString(seName)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
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

