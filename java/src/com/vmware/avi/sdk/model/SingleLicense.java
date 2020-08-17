package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SingleLicense is a POJO class extends AviRestResource that used for creating
 * SingleLicense.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SingleLicense  {
    @JsonProperty("burst_cores")
    private Integer burstCores = null;

    @JsonProperty("cores")
    private Integer cores = null;

    @JsonProperty("cpu_cores")
    private float cpuCores = 0.0f;

    @JsonProperty("created_on")
    private String createdOn = null;

    @JsonProperty("customer_name")
    private String customerName = null;

    @JsonProperty("enforced_params")
    private List<String> enforcedParams = null;

    @JsonProperty("expired")
    private Boolean expired = false;

    @JsonProperty("last_update")
    private String lastUpdate = null;

    @JsonProperty("license_id")
    private String licenseId = null;

    @JsonProperty("license_name")
    private String licenseName = null;

    @JsonProperty("license_string")
    private String licenseString = null;

    @JsonProperty("license_tier")
    private List<String> licenseTier = null;

    @JsonProperty("license_type")
    private String licenseType = null;

    @JsonProperty("max_ses")
    private Integer maxSes = null;

    @JsonProperty("se_bandwidth_limits")
    private List<SEBandwidthLimit> seBandwidthLimits = null;

    @JsonProperty("serial_key")
    private String serialKey = null;

    @JsonProperty("service_cores")
    private float serviceCores = 0.0f;

    @JsonProperty("sockets")
    private Integer sockets = null;

    @JsonProperty("start_on")
    private String startOn = null;

    @JsonProperty("tier_type")
    private String tierType = null;

    @JsonProperty("valid_until")
    private String validUntil = null;

    @JsonProperty("version")
    private String version = null;



  /**
   * This is the getter method this will return the attribute value.
   * Total number of service engine burst cores for core based licenses.
   * Field introduced in 17.2.5.
   * @return burstCores
   */
  public Integer getBurstCores() {
    return burstCores;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of service engine burst cores for core based licenses.
   * Field introduced in 17.2.5.
   * @param burstCores set the burstCores.
   */
  public void setBurstCores(Integer  burstCores) {
    this.burstCores = burstCores;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Number of service engine cores in non-container clouds.
   * @return cores
   */
  public Integer getCores() {
    return cores;
  }

  /**
   * This is the setter method to the attribute.
   * Number of service engine cores in non-container clouds.
   * @param cores set the cores.
   */
  public void setCores(Integer  cores) {
    this.cores = cores;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of cpu cores.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.0.
   * @return cpuCores
   */
  public Float getCpuCores() {
    return cpuCores;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of cpu cores.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.0.
   * @param cpuCores set the cpuCores.
   */
  public void setCpuCores(Float  cpuCores) {
    this.cpuCores = cpuCores;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property created_on of obj type singlelicense field type str  type string.
   * @return createdOn
   */
  public String getCreatedOn() {
    return createdOn;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property created_on of obj type singlelicense field type str  type string.
   * @param createdOn set the createdOn.
   */
  public void setCreatedOn(String  createdOn) {
    this.createdOn = createdOn;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property customer_name of obj type singlelicense field type str  type string.
   * @return customerName
   */
  public String getCustomerName() {
    return customerName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property customer_name of obj type singlelicense field type str  type string.
   * @param customerName set the customerName.
   */
  public void setCustomerName(String  customerName) {
    this.customerName = customerName;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property enforced_params of obj type singlelicense field type str  type array.
   * @return enforcedParams
   */
  public List<String> getEnforcedParams() {
    return enforcedParams;
  }

  /**
   * This is the setter method. this will set the enforcedParams
   * Placeholder for description of property enforced_params of obj type singlelicense field type str  type array.
   * @return enforcedParams
   */
  public void setEnforcedParams(List<String>  enforcedParams) {
    this.enforcedParams = enforcedParams;
  }

  /**
   * This is the setter method this will set the enforcedParams
   * Placeholder for description of property enforced_params of obj type singlelicense field type str  type array.
   * @return enforcedParams
   */
  public SingleLicense addEnforcedParamsItem(String enforcedParamsItem) {
    if (this.enforcedParams == null) {
      this.enforcedParams = new ArrayList<String>();
    }
    this.enforcedParams.add(enforcedParamsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Flag to track license expiry.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return expired
   */
  public Boolean getExpired() {
    return expired;
  }

  /**
   * This is the setter method to the attribute.
   * Flag to track license expiry.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param expired set the expired.
   */
  public void setExpired(Boolean  expired) {
    this.expired = expired;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property last_update of obj type singlelicense field type str  type string.
   * @return lastUpdate
   */
  public String getLastUpdate() {
    return lastUpdate;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property last_update of obj type singlelicense field type str  type string.
   * @param lastUpdate set the lastUpdate.
   */
  public void setLastUpdate(String  lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property license_id of obj type singlelicense field type str  type string.
   * @return licenseId
   */
  public String getLicenseId() {
    return licenseId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property license_id of obj type singlelicense field type str  type string.
   * @param licenseId set the licenseId.
   */
  public void setLicenseId(String  licenseId) {
    this.licenseId = licenseId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property license_name of obj type singlelicense field type str  type string.
   * @return licenseName
   */
  public String getLicenseName() {
    return licenseName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property license_name of obj type singlelicense field type str  type string.
   * @param licenseName set the licenseName.
   */
  public void setLicenseName(String  licenseName) {
    this.licenseName = licenseName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property license_string of obj type singlelicense field type str  type string.
   * @return licenseString
   */
  public String getLicenseString() {
    return licenseString;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property license_string of obj type singlelicense field type str  type string.
   * @param licenseString set the licenseString.
   */
  public void setLicenseString(String  licenseString) {
    this.licenseString = licenseString;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property license_tier of obj type singlelicense field type str  type array.
   * @return licenseTier
   */
  public List<String> getLicenseTier() {
    return licenseTier;
  }

  /**
   * This is the setter method. this will set the licenseTier
   * Placeholder for description of property license_tier of obj type singlelicense field type str  type array.
   * @return licenseTier
   */
  public void setLicenseTier(List<String>  licenseTier) {
    this.licenseTier = licenseTier;
  }

  /**
   * This is the setter method this will set the licenseTier
   * Placeholder for description of property license_tier of obj type singlelicense field type str  type array.
   * @return licenseTier
   */
  public SingleLicense addLicenseTierItem(String licenseTierItem) {
    if (this.licenseTier == null) {
      this.licenseTier = new ArrayList<String>();
    }
    this.licenseTier.add(licenseTierItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property license_type of obj type singlelicense field type str  type string.
   * @return licenseType
   */
  public String getLicenseType() {
    return licenseType;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property license_type of obj type singlelicense field type str  type string.
   * @param licenseType set the licenseType.
   */
  public void setLicenseType(String  licenseType) {
    this.licenseType = licenseType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Number of service engines hosts in container clouds.
   * @return maxSes
   */
  public Integer getMaxSes() {
    return maxSes;
  }

  /**
   * This is the setter method to the attribute.
   * Number of service engines hosts in container clouds.
   * @param maxSes set the maxSes.
   */
  public void setMaxSes(Integer  maxSes) {
    this.maxSes = maxSes;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Service engine bandwidth limits for bandwidth based licenses.
   * Field introduced in 17.2.5.
   * @return seBandwidthLimits
   */
  public List<SEBandwidthLimit> getSeBandwidthLimits() {
    return seBandwidthLimits;
  }

  /**
   * This is the setter method. this will set the seBandwidthLimits
   * Service engine bandwidth limits for bandwidth based licenses.
   * Field introduced in 17.2.5.
   * @return seBandwidthLimits
   */
  public void setSeBandwidthLimits(List<SEBandwidthLimit>  seBandwidthLimits) {
    this.seBandwidthLimits = seBandwidthLimits;
  }

  /**
   * This is the setter method this will set the seBandwidthLimits
   * Service engine bandwidth limits for bandwidth based licenses.
   * Field introduced in 17.2.5.
   * @return seBandwidthLimits
   */
  public SingleLicense addSeBandwidthLimitsItem(SEBandwidthLimit seBandwidthLimitsItem) {
    if (this.seBandwidthLimits == null) {
      this.seBandwidthLimits = new ArrayList<SEBandwidthLimit>();
    }
    this.seBandwidthLimits.add(seBandwidthLimitsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Serial key (hyphen separated 25 char wide alphanumeric key ex  aa123-23bas-383as-383ud-fhsfg).
   * Field introduced in 20.1.1.
   * @return serialKey
   */
  public String getSerialKey() {
    return serialKey;
  }

  /**
   * This is the setter method to the attribute.
   * Serial key (hyphen separated 25 char wide alphanumeric key ex  aa123-23bas-383as-383ud-fhsfg).
   * Field introduced in 20.1.1.
   * @param serialKey set the serialKey.
   */
  public void setSerialKey(String  serialKey) {
    this.serialKey = serialKey;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of service cores equivalent to all the resoures available in the single license.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.0.
   * @return serviceCores
   */
  public Float getServiceCores() {
    return serviceCores;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of service cores equivalent to all the resoures available in the single license.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.0.
   * @param serviceCores set the serviceCores.
   */
  public void setServiceCores(Float  serviceCores) {
    this.serviceCores = serviceCores;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Number of physical cpu sockets across service engines in no access and linux server clouds.
   * @return sockets
   */
  public Integer getSockets() {
    return sockets;
  }

  /**
   * This is the setter method to the attribute.
   * Number of physical cpu sockets across service engines in no access and linux server clouds.
   * @param sockets set the sockets.
   */
  public void setSockets(Integer  sockets) {
    this.sockets = sockets;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property start_on of obj type singlelicense field type str  type string.
   * @return startOn
   */
  public String getStartOn() {
    return startOn;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property start_on of obj type singlelicense field type str  type string.
   * @param startOn set the startOn.
   */
  public void setStartOn(String  startOn) {
    this.startOn = startOn;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Specifies the licensed tier.
   * Enum options - ENTERPRISE_16, ENTERPRISE, ENTERPRISE_18, BASIC.
   * Field introduced in 17.2.5.
   * @return tierType
   */
  public String getTierType() {
    return tierType;
  }

  /**
   * This is the setter method to the attribute.
   * Specifies the licensed tier.
   * Enum options - ENTERPRISE_16, ENTERPRISE, ENTERPRISE_18, BASIC.
   * Field introduced in 17.2.5.
   * @param tierType set the tierType.
   */
  public void setTierType(String  tierType) {
    this.tierType = tierType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property valid_until of obj type singlelicense field type str  type string.
   * @return validUntil
   */
  public String getValidUntil() {
    return validUntil;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property valid_until of obj type singlelicense field type str  type string.
   * @param validUntil set the validUntil.
   */
  public void setValidUntil(String  validUntil) {
    this.validUntil = validUntil;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property version of obj type singlelicense field type str  type string.
   * @return version
   */
  public String getVersion() {
    return version;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property version of obj type singlelicense field type str  type string.
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
  SingleLicense objSingleLicense = (SingleLicense) o;
  return   Objects.equals(this.licenseName, objSingleLicense.licenseName)&&
  Objects.equals(this.startOn, objSingleLicense.startOn)&&
  Objects.equals(this.validUntil, objSingleLicense.validUntil)&&
  Objects.equals(this.customerName, objSingleLicense.customerName)&&
  Objects.equals(this.cores, objSingleLicense.cores)&&
  Objects.equals(this.maxSes, objSingleLicense.maxSes)&&
  Objects.equals(this.licenseTier, objSingleLicense.licenseTier)&&
  Objects.equals(this.licenseString, objSingleLicense.licenseString)&&
  Objects.equals(this.licenseId, objSingleLicense.licenseId)&&
  Objects.equals(this.version, objSingleLicense.version)&&
  Objects.equals(this.createdOn, objSingleLicense.createdOn)&&
  Objects.equals(this.lastUpdate, objSingleLicense.lastUpdate)&&
  Objects.equals(this.licenseType, objSingleLicense.licenseType)&&
  Objects.equals(this.enforcedParams, objSingleLicense.enforcedParams)&&
  Objects.equals(this.sockets, objSingleLicense.sockets)&&
  Objects.equals(this.seBandwidthLimits, objSingleLicense.seBandwidthLimits)&&
  Objects.equals(this.tierType, objSingleLicense.tierType)&&
  Objects.equals(this.burstCores, objSingleLicense.burstCores)&&
  Objects.equals(this.serialKey, objSingleLicense.serialKey)&&
  Objects.equals(this.serviceCores, objSingleLicense.serviceCores)&&
  Objects.equals(this.cpuCores, objSingleLicense.cpuCores)&&
  Objects.equals(this.expired, objSingleLicense.expired);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SingleLicense {\n");
      sb.append("    burstCores: ").append(toIndentedString(burstCores)).append("\n");
        sb.append("    cores: ").append(toIndentedString(cores)).append("\n");
        sb.append("    cpuCores: ").append(toIndentedString(cpuCores)).append("\n");
        sb.append("    createdOn: ").append(toIndentedString(createdOn)).append("\n");
        sb.append("    customerName: ").append(toIndentedString(customerName)).append("\n");
        sb.append("    enforcedParams: ").append(toIndentedString(enforcedParams)).append("\n");
        sb.append("    expired: ").append(toIndentedString(expired)).append("\n");
        sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
        sb.append("    licenseId: ").append(toIndentedString(licenseId)).append("\n");
        sb.append("    licenseName: ").append(toIndentedString(licenseName)).append("\n");
        sb.append("    licenseString: ").append(toIndentedString(licenseString)).append("\n");
        sb.append("    licenseTier: ").append(toIndentedString(licenseTier)).append("\n");
        sb.append("    licenseType: ").append(toIndentedString(licenseType)).append("\n");
        sb.append("    maxSes: ").append(toIndentedString(maxSes)).append("\n");
        sb.append("    seBandwidthLimits: ").append(toIndentedString(seBandwidthLimits)).append("\n");
        sb.append("    serialKey: ").append(toIndentedString(serialKey)).append("\n");
        sb.append("    serviceCores: ").append(toIndentedString(serviceCores)).append("\n");
        sb.append("    sockets: ").append(toIndentedString(sockets)).append("\n");
        sb.append("    startOn: ").append(toIndentedString(startOn)).append("\n");
        sb.append("    tierType: ").append(toIndentedString(tierType)).append("\n");
        sb.append("    validUntil: ").append(toIndentedString(validUntil)).append("\n");
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

