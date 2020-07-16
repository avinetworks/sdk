package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The MesosSetup is a POJO class extends AviRestResource that used for creating
 * MesosSetup.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MesosSetup  {
    @JsonProperty("cc_id")
    private String ccId = null;

    @JsonProperty("failed_hosts")
    private List<String> failedHosts = null;

    @JsonProperty("fleet_endpoint")
    private String fleetEndpoint = null;

    @JsonProperty("hosts")
    private List<String> hosts = null;

    @JsonProperty("mesos_access")
    private Boolean mesosAccess = null;

    @JsonProperty("mesos_url")
    private String mesosUrl = null;

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
   * Placeholder for description of property cc_id of obj type mesossetup field type str  type string.
   * @return ccId
   */
  public String getCcId() {
    return ccId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cc_id of obj type mesossetup field type str  type string.
   * @param ccId set the ccId.
   */
  public void setCcId(String  ccId) {
    this.ccId = ccId;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property failed_hosts of obj type mesossetup field type str  type array.
   * @return failedHosts
   */
  public List<String> getFailedHosts() {
    return failedHosts;
  }

  /**
   * This is the setter method. this will set the failedHosts
   * Placeholder for description of property failed_hosts of obj type mesossetup field type str  type array.
   * @return failedHosts
   */
  public void setFailedHosts(List<String>  failedHosts) {
    this.failedHosts = failedHosts;
  }

  /**
   * This is the setter method this will set the failedHosts
   * Placeholder for description of property failed_hosts of obj type mesossetup field type str  type array.
   * @return failedHosts
   */
  public MesosSetup addFailedHostsItem(String failedHostsItem) {
    if (this.failedHosts == null) {
      this.failedHosts = new ArrayList<String>();
    }
    this.failedHosts.add(failedHostsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property fleet_endpoint of obj type mesossetup field type str  type string.
   * @return fleetEndpoint
   */
  public String getFleetEndpoint() {
    return fleetEndpoint;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property fleet_endpoint of obj type mesossetup field type str  type string.
   * @param fleetEndpoint set the fleetEndpoint.
   */
  public void setFleetEndpoint(String  fleetEndpoint) {
    this.fleetEndpoint = fleetEndpoint;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property hosts of obj type mesossetup field type str  type array.
   * @return hosts
   */
  public List<String> getHosts() {
    return hosts;
  }

  /**
   * This is the setter method. this will set the hosts
   * Placeholder for description of property hosts of obj type mesossetup field type str  type array.
   * @return hosts
   */
  public void setHosts(List<String>  hosts) {
    this.hosts = hosts;
  }

  /**
   * This is the setter method this will set the hosts
   * Placeholder for description of property hosts of obj type mesossetup field type str  type array.
   * @return hosts
   */
  public MesosSetup addHostsItem(String hostsItem) {
    if (this.hosts == null) {
      this.hosts = new ArrayList<String>();
    }
    this.hosts.add(hostsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property mesos_access of obj type mesossetup field type str  type boolean.
   * @return mesosAccess
   */
  public Boolean getMesosAccess() {
    return mesosAccess;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property mesos_access of obj type mesossetup field type str  type boolean.
   * @param mesosAccess set the mesosAccess.
   */
  public void setMesosAccess(Boolean  mesosAccess) {
    this.mesosAccess = mesosAccess;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property mesos_url of obj type mesossetup field type str  type string.
   * @return mesosUrl
   */
  public String getMesosUrl() {
    return mesosUrl;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property mesos_url of obj type mesossetup field type str  type string.
   * @param mesosUrl set the mesosUrl.
   */
  public void setMesosUrl(String  mesosUrl) {
    this.mesosUrl = mesosUrl;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property missing_hosts of obj type mesossetup field type str  type array.
   * @return missingHosts
   */
  public List<String> getMissingHosts() {
    return missingHosts;
  }

  /**
   * This is the setter method. this will set the missingHosts
   * Placeholder for description of property missing_hosts of obj type mesossetup field type str  type array.
   * @return missingHosts
   */
  public void setMissingHosts(List<String>  missingHosts) {
    this.missingHosts = missingHosts;
  }

  /**
   * This is the setter method this will set the missingHosts
   * Placeholder for description of property missing_hosts of obj type mesossetup field type str  type array.
   * @return missingHosts
   */
  public MesosSetup addMissingHostsItem(String missingHostsItem) {
    if (this.missingHosts == null) {
      this.missingHosts = new ArrayList<String>();
    }
    this.missingHosts.add(missingHostsItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property new_hosts of obj type mesossetup field type str  type array.
   * @return newHosts
   */
  public List<String> getNewHosts() {
    return newHosts;
  }

  /**
   * This is the setter method. this will set the newHosts
   * Placeholder for description of property new_hosts of obj type mesossetup field type str  type array.
   * @return newHosts
   */
  public void setNewHosts(List<String>  newHosts) {
    this.newHosts = newHosts;
  }

  /**
   * This is the setter method this will set the newHosts
   * Placeholder for description of property new_hosts of obj type mesossetup field type str  type array.
   * @return newHosts
   */
  public MesosSetup addNewHostsItem(String newHostsItem) {
    if (this.newHosts == null) {
      this.newHosts = new ArrayList<String>();
    }
    this.newHosts.add(newHostsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property reason of obj type mesossetup field type str  type string.
   * @return reason
   */
  public String getReason() {
    return reason;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property reason of obj type mesossetup field type str  type string.
   * @param reason set the reason.
   */
  public void setReason(String  reason) {
    this.reason = reason;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_deploy_method_access of obj type mesossetup field type str  type boolean.
   * @return seDeployMethodAccess
   */
  public Boolean getSeDeployMethodAccess() {
    return seDeployMethodAccess;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_deploy_method_access of obj type mesossetup field type str  type boolean.
   * @param seDeployMethodAccess set the seDeployMethodAccess.
   */
  public void setSeDeployMethodAccess(Boolean  seDeployMethodAccess) {
    this.seDeployMethodAccess = seDeployMethodAccess;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_name of obj type mesossetup field type str  type string.
   * @return seName
   */
  public String getSeName() {
    return seName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_name of obj type mesossetup field type str  type string.
   * @param seName set the seName.
   */
  public void setSeName(String  seName) {
    this.seName = seName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property version of obj type mesossetup field type str  type string.
   * @return version
   */
  public String getVersion() {
    return version;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property version of obj type mesossetup field type str  type string.
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
  MesosSetup objMesosSetup = (MesosSetup) o;
  return   Objects.equals(this.mesosUrl, objMesosSetup.mesosUrl)&&
  Objects.equals(this.missingHosts, objMesosSetup.missingHosts)&&
  Objects.equals(this.failedHosts, objMesosSetup.failedHosts)&&
  Objects.equals(this.seDeployMethodAccess, objMesosSetup.seDeployMethodAccess)&&
  Objects.equals(this.mesosAccess, objMesosSetup.mesosAccess)&&
  Objects.equals(this.reason, objMesosSetup.reason)&&
  Objects.equals(this.version, objMesosSetup.version)&&
  Objects.equals(this.hosts, objMesosSetup.hosts)&&
  Objects.equals(this.fleetEndpoint, objMesosSetup.fleetEndpoint)&&
  Objects.equals(this.newHosts, objMesosSetup.newHosts)&&
  Objects.equals(this.seName, objMesosSetup.seName)&&
  Objects.equals(this.ccId, objMesosSetup.ccId);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class MesosSetup {\n");
      sb.append("    ccId: ").append(toIndentedString(ccId)).append("\n");
        sb.append("    failedHosts: ").append(toIndentedString(failedHosts)).append("\n");
        sb.append("    fleetEndpoint: ").append(toIndentedString(fleetEndpoint)).append("\n");
        sb.append("    hosts: ").append(toIndentedString(hosts)).append("\n");
        sb.append("    mesosAccess: ").append(toIndentedString(mesosAccess)).append("\n");
        sb.append("    mesosUrl: ").append(toIndentedString(mesosUrl)).append("\n");
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

