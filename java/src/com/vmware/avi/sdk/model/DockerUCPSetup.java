package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DockerUCPSetup is a POJO class extends AviRestResource that used for creating
 * DockerUCPSetup.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DockerUCPSetup  {
    @JsonProperty("cc_id")
    private String ccId = null;

    @JsonProperty("docker_ucp_access")
    private Boolean dockerUcpAccess = null;

    @JsonProperty("failed_hosts")
    private List<String> failedHosts = null;

    @JsonProperty("fleet_endpoint")
    private String fleetEndpoint = null;

    @JsonProperty("hosts")
    private List<String> hosts = null;

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

    @JsonProperty("ucp_nodes")
    private List<String> ucpNodes = null;

    @JsonProperty("version")
    private String version = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cc_id of obj type dockerucpsetup field type str  type string.
   * @return ccId
   */
  public String getCcId() {
    return ccId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cc_id of obj type dockerucpsetup field type str  type string.
   * @param ccId set the ccId.
   */
  public void setCcId(String  ccId) {
    this.ccId = ccId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property docker_ucp_access of obj type dockerucpsetup field type str  type boolean.
   * @return dockerUcpAccess
   */
  public Boolean getDockerUcpAccess() {
    return dockerUcpAccess;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property docker_ucp_access of obj type dockerucpsetup field type str  type boolean.
   * @param dockerUcpAccess set the dockerUcpAccess.
   */
  public void setDockerUcpAccess(Boolean  dockerUcpAccess) {
    this.dockerUcpAccess = dockerUcpAccess;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property failed_hosts of obj type dockerucpsetup field type str  type array.
   * @return failedHosts
   */
  public List<String> getFailedHosts() {
    return failedHosts;
  }

  /**
   * This is the setter method. this will set the failedHosts
   * Placeholder for description of property failed_hosts of obj type dockerucpsetup field type str  type array.
   * @return failedHosts
   */
  public void setFailedHosts(List<String>  failedHosts) {
    this.failedHosts = failedHosts;
  }

  /**
   * This is the setter method this will set the failedHosts
   * Placeholder for description of property failed_hosts of obj type dockerucpsetup field type str  type array.
   * @return failedHosts
   */
  public DockerUCPSetup addFailedHostsItem(String failedHostsItem) {
    if (this.failedHosts == null) {
      this.failedHosts = new ArrayList<String>();
    }
    this.failedHosts.add(failedHostsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property fleet_endpoint of obj type dockerucpsetup field type str  type string.
   * @return fleetEndpoint
   */
  public String getFleetEndpoint() {
    return fleetEndpoint;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property fleet_endpoint of obj type dockerucpsetup field type str  type string.
   * @param fleetEndpoint set the fleetEndpoint.
   */
  public void setFleetEndpoint(String  fleetEndpoint) {
    this.fleetEndpoint = fleetEndpoint;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property hosts of obj type dockerucpsetup field type str  type array.
   * @return hosts
   */
  public List<String> getHosts() {
    return hosts;
  }

  /**
   * This is the setter method. this will set the hosts
   * Placeholder for description of property hosts of obj type dockerucpsetup field type str  type array.
   * @return hosts
   */
  public void setHosts(List<String>  hosts) {
    this.hosts = hosts;
  }

  /**
   * This is the setter method this will set the hosts
   * Placeholder for description of property hosts of obj type dockerucpsetup field type str  type array.
   * @return hosts
   */
  public DockerUCPSetup addHostsItem(String hostsItem) {
    if (this.hosts == null) {
      this.hosts = new ArrayList<String>();
    }
    this.hosts.add(hostsItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property missing_hosts of obj type dockerucpsetup field type str  type array.
   * @return missingHosts
   */
  public List<String> getMissingHosts() {
    return missingHosts;
  }

  /**
   * This is the setter method. this will set the missingHosts
   * Placeholder for description of property missing_hosts of obj type dockerucpsetup field type str  type array.
   * @return missingHosts
   */
  public void setMissingHosts(List<String>  missingHosts) {
    this.missingHosts = missingHosts;
  }

  /**
   * This is the setter method this will set the missingHosts
   * Placeholder for description of property missing_hosts of obj type dockerucpsetup field type str  type array.
   * @return missingHosts
   */
  public DockerUCPSetup addMissingHostsItem(String missingHostsItem) {
    if (this.missingHosts == null) {
      this.missingHosts = new ArrayList<String>();
    }
    this.missingHosts.add(missingHostsItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property new_hosts of obj type dockerucpsetup field type str  type array.
   * @return newHosts
   */
  public List<String> getNewHosts() {
    return newHosts;
  }

  /**
   * This is the setter method. this will set the newHosts
   * Placeholder for description of property new_hosts of obj type dockerucpsetup field type str  type array.
   * @return newHosts
   */
  public void setNewHosts(List<String>  newHosts) {
    this.newHosts = newHosts;
  }

  /**
   * This is the setter method this will set the newHosts
   * Placeholder for description of property new_hosts of obj type dockerucpsetup field type str  type array.
   * @return newHosts
   */
  public DockerUCPSetup addNewHostsItem(String newHostsItem) {
    if (this.newHosts == null) {
      this.newHosts = new ArrayList<String>();
    }
    this.newHosts.add(newHostsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property reason of obj type dockerucpsetup field type str  type string.
   * @return reason
   */
  public String getReason() {
    return reason;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property reason of obj type dockerucpsetup field type str  type string.
   * @param reason set the reason.
   */
  public void setReason(String  reason) {
    this.reason = reason;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_deploy_method_access of obj type dockerucpsetup field type str  type boolean.
   * @return seDeployMethodAccess
   */
  public Boolean getSeDeployMethodAccess() {
    return seDeployMethodAccess;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_deploy_method_access of obj type dockerucpsetup field type str  type boolean.
   * @param seDeployMethodAccess set the seDeployMethodAccess.
   */
  public void setSeDeployMethodAccess(Boolean  seDeployMethodAccess) {
    this.seDeployMethodAccess = seDeployMethodAccess;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_name of obj type dockerucpsetup field type str  type string.
   * @return seName
   */
  public String getSeName() {
    return seName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_name of obj type dockerucpsetup field type str  type string.
   * @param seName set the seName.
   */
  public void setSeName(String  seName) {
    this.seName = seName;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ucp_nodes of obj type dockerucpsetup field type str  type array.
   * @return ucpNodes
   */
  public List<String> getUcpNodes() {
    return ucpNodes;
  }

  /**
   * This is the setter method. this will set the ucpNodes
   * Placeholder for description of property ucp_nodes of obj type dockerucpsetup field type str  type array.
   * @return ucpNodes
   */
  public void setUcpNodes(List<String>  ucpNodes) {
    this.ucpNodes = ucpNodes;
  }

  /**
   * This is the setter method this will set the ucpNodes
   * Placeholder for description of property ucp_nodes of obj type dockerucpsetup field type str  type array.
   * @return ucpNodes
   */
  public DockerUCPSetup addUcpNodesItem(String ucpNodesItem) {
    if (this.ucpNodes == null) {
      this.ucpNodes = new ArrayList<String>();
    }
    this.ucpNodes.add(ucpNodesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property version of obj type dockerucpsetup field type str  type string.
   * @return version
   */
  public String getVersion() {
    return version;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property version of obj type dockerucpsetup field type str  type string.
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
  DockerUCPSetup objDockerUCPSetup = (DockerUCPSetup) o;
  return   Objects.equals(this.missingHosts, objDockerUCPSetup.missingHosts)&&
  Objects.equals(this.failedHosts, objDockerUCPSetup.failedHosts)&&
  Objects.equals(this.seDeployMethodAccess, objDockerUCPSetup.seDeployMethodAccess)&&
  Objects.equals(this.reason, objDockerUCPSetup.reason)&&
  Objects.equals(this.version, objDockerUCPSetup.version)&&
  Objects.equals(this.hosts, objDockerUCPSetup.hosts)&&
  Objects.equals(this.fleetEndpoint, objDockerUCPSetup.fleetEndpoint)&&
  Objects.equals(this.newHosts, objDockerUCPSetup.newHosts)&&
  Objects.equals(this.seName, objDockerUCPSetup.seName)&&
  Objects.equals(this.ccId, objDockerUCPSetup.ccId)&&
  Objects.equals(this.ucpNodes, objDockerUCPSetup.ucpNodes)&&
  Objects.equals(this.dockerUcpAccess, objDockerUCPSetup.dockerUcpAccess);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DockerUCPSetup {\n");
      sb.append("    ccId: ").append(toIndentedString(ccId)).append("\n");
        sb.append("    dockerUcpAccess: ").append(toIndentedString(dockerUcpAccess)).append("\n");
        sb.append("    failedHosts: ").append(toIndentedString(failedHosts)).append("\n");
        sb.append("    fleetEndpoint: ").append(toIndentedString(fleetEndpoint)).append("\n");
        sb.append("    hosts: ").append(toIndentedString(hosts)).append("\n");
        sb.append("    missingHosts: ").append(toIndentedString(missingHosts)).append("\n");
        sb.append("    newHosts: ").append(toIndentedString(newHosts)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    seDeployMethodAccess: ").append(toIndentedString(seDeployMethodAccess)).append("\n");
        sb.append("    seName: ").append(toIndentedString(seName)).append("\n");
        sb.append("    ucpNodes: ").append(toIndentedString(ucpNodes)).append("\n");
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

