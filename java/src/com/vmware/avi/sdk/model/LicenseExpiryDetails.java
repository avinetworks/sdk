package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The LicenseExpiryDetails is a POJO class extends AviRestResource that used for creating
 * LicenseExpiryDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LicenseExpiryDetails  {
    @JsonProperty("backend_servers")
    private Integer backendServers = null;

    @JsonProperty("burst_cores")
    private Integer burstCores = null;

    @JsonProperty("cores")
    private Integer cores = null;

    @JsonProperty("expiry_at")
    private String expiryAt = null;

    @JsonProperty("license_id")
    private String licenseId = null;

    @JsonProperty("license_tier")
    private List<String> licenseTier = null;

    @JsonProperty("license_type")
    private String licenseType = null;

    @JsonProperty("max_apps")
    private Integer maxApps = null;

    @JsonProperty("max_ses")
    private Integer maxSes = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("sockets")
    private Integer sockets = null;

    @JsonProperty("throughput")
    private Integer throughput = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property backend_servers of obj type licenseexpirydetails field type str  type integer.
   * @return backendServers
   */
  public Integer getBackendServers() {
    return backendServers;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property backend_servers of obj type licenseexpirydetails field type str  type integer.
   * @param backendServers set the backendServers.
   */
  public void setBackendServers(Integer  backendServers) {
    this.backendServers = backendServers;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property burst_cores of obj type licenseexpirydetails field type str  type integer.
   * @return burstCores
   */
  public Integer getBurstCores() {
    return burstCores;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property burst_cores of obj type licenseexpirydetails field type str  type integer.
   * @param burstCores set the burstCores.
   */
  public void setBurstCores(Integer  burstCores) {
    this.burstCores = burstCores;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cores of obj type licenseexpirydetails field type str  type integer.
   * @return cores
   */
  public Integer getCores() {
    return cores;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cores of obj type licenseexpirydetails field type str  type integer.
   * @param cores set the cores.
   */
  public void setCores(Integer  cores) {
    this.cores = cores;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property expiry_at of obj type licenseexpirydetails field type str  type string.
   * @return expiryAt
   */
  public String getExpiryAt() {
    return expiryAt;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property expiry_at of obj type licenseexpirydetails field type str  type string.
   * @param expiryAt set the expiryAt.
   */
  public void setExpiryAt(String  expiryAt) {
    this.expiryAt = expiryAt;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property license_id of obj type licenseexpirydetails field type str  type string.
   * @return licenseId
   */
  public String getLicenseId() {
    return licenseId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property license_id of obj type licenseexpirydetails field type str  type string.
   * @param licenseId set the licenseId.
   */
  public void setLicenseId(String  licenseId) {
    this.licenseId = licenseId;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property license_tier of obj type licenseexpirydetails field type str  type array.
   * @return licenseTier
   */
  public List<String> getLicenseTier() {
    return licenseTier;
  }

  /**
   * This is the setter method. this will set the licenseTier
   * Placeholder for description of property license_tier of obj type licenseexpirydetails field type str  type array.
   * @return licenseTier
   */
  public void setLicenseTier(List<String>  licenseTier) {
    this.licenseTier = licenseTier;
  }

  /**
   * This is the setter method this will set the licenseTier
   * Placeholder for description of property license_tier of obj type licenseexpirydetails field type str  type array.
   * @return licenseTier
   */
  public LicenseExpiryDetails addLicenseTierItem(String licenseTierItem) {
    if (this.licenseTier == null) {
      this.licenseTier = new ArrayList<String>();
    }
    this.licenseTier.add(licenseTierItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property license_type of obj type licenseexpirydetails field type str  type string.
   * @return licenseType
   */
  public String getLicenseType() {
    return licenseType;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property license_type of obj type licenseexpirydetails field type str  type string.
   * @param licenseType set the licenseType.
   */
  public void setLicenseType(String  licenseType) {
    this.licenseType = licenseType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property max_apps of obj type licenseexpirydetails field type str  type integer.
   * @return maxApps
   */
  public Integer getMaxApps() {
    return maxApps;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property max_apps of obj type licenseexpirydetails field type str  type integer.
   * @param maxApps set the maxApps.
   */
  public void setMaxApps(Integer  maxApps) {
    this.maxApps = maxApps;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property max_ses of obj type licenseexpirydetails field type str  type integer.
   * @return maxSes
   */
  public Integer getMaxSes() {
    return maxSes;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property max_ses of obj type licenseexpirydetails field type str  type integer.
   * @param maxSes set the maxSes.
   */
  public void setMaxSes(Integer  maxSes) {
    this.maxSes = maxSes;
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
   * Placeholder for description of property sockets of obj type licenseexpirydetails field type str  type integer.
   * @return sockets
   */
  public Integer getSockets() {
    return sockets;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property sockets of obj type licenseexpirydetails field type str  type integer.
   * @param sockets set the sockets.
   */
  public void setSockets(Integer  sockets) {
    this.sockets = sockets;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property throughput of obj type licenseexpirydetails field type str  type integer.
   * @return throughput
   */
  public Integer getThroughput() {
    return throughput;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property throughput of obj type licenseexpirydetails field type str  type integer.
   * @param throughput set the throughput.
   */
  public void setThroughput(Integer  throughput) {
    this.throughput = throughput;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  LicenseExpiryDetails objLicenseExpiryDetails = (LicenseExpiryDetails) o;
  return   Objects.equals(this.licenseTier, objLicenseExpiryDetails.licenseTier)&&
  Objects.equals(this.name, objLicenseExpiryDetails.name)&&
  Objects.equals(this.maxSes, objLicenseExpiryDetails.maxSes)&&
  Objects.equals(this.maxApps, objLicenseExpiryDetails.maxApps)&&
  Objects.equals(this.burstCores, objLicenseExpiryDetails.burstCores)&&
  Objects.equals(this.throughput, objLicenseExpiryDetails.throughput)&&
  Objects.equals(this.licenseId, objLicenseExpiryDetails.licenseId)&&
  Objects.equals(this.licenseType, objLicenseExpiryDetails.licenseType)&&
  Objects.equals(this.cores, objLicenseExpiryDetails.cores)&&
  Objects.equals(this.expiryAt, objLicenseExpiryDetails.expiryAt)&&
  Objects.equals(this.sockets, objLicenseExpiryDetails.sockets)&&
  Objects.equals(this.backendServers, objLicenseExpiryDetails.backendServers);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class LicenseExpiryDetails {\n");
      sb.append("    backendServers: ").append(toIndentedString(backendServers)).append("\n");
        sb.append("    burstCores: ").append(toIndentedString(burstCores)).append("\n");
        sb.append("    cores: ").append(toIndentedString(cores)).append("\n");
        sb.append("    expiryAt: ").append(toIndentedString(expiryAt)).append("\n");
        sb.append("    licenseId: ").append(toIndentedString(licenseId)).append("\n");
        sb.append("    licenseTier: ").append(toIndentedString(licenseTier)).append("\n");
        sb.append("    licenseType: ").append(toIndentedString(licenseType)).append("\n");
        sb.append("    maxApps: ").append(toIndentedString(maxApps)).append("\n");
        sb.append("    maxSes: ").append(toIndentedString(maxSes)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    sockets: ").append(toIndentedString(sockets)).append("\n");
        sb.append("    throughput: ").append(toIndentedString(throughput)).append("\n");
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

