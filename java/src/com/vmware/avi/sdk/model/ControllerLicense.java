package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The ControllerLicense is a POJO class extends AviRestResource that used for creating
 * ControllerLicense.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ControllerLicense extends AviRestResource  {
    @JsonProperty("active_burst_resources")
    private List<BurstResource> activeBurstResources = null;

    @JsonProperty("burst_cores")
    private Integer burstCores = null;

    @JsonProperty("cores")
    private Integer cores = null;

    @JsonProperty("customer_name")
    private String customerName = null;

    @JsonProperty("disable_enforcement")
    private Boolean disableEnforcement = null;

    @JsonProperty("expired_burst_resources")
    private List<BurstResource> expiredBurstResources = null;

    @JsonProperty("initialized")
    private Boolean initialized = null;

    @JsonProperty("license_id")
    private String licenseId = null;

    @JsonProperty("license_tier")
    private List<String> licenseTier = null;

    @JsonProperty("license_tiers")
    private List<CumulativeLicense> licenseTiers = null;

    @JsonProperty("licenses")
    private List<SingleLicense> licenses = null;

    @JsonProperty("max_ses")
    private Integer maxSes = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("se_bandwidth_limits")
    private List<SEBandwidthLimit> seBandwidthLimits = null;

    @JsonProperty("service_cores")
    private Float serviceCores = null;

    @JsonProperty("sockets")
    private Integer sockets = null;

    @JsonProperty("start_on")
    private String startOn = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;

    @JsonProperty("valid_until")
    private String validUntil = null;


    /**
     * This is the getter method this will return the attribute value.
     * List of active burst core license in use.
     * Field introduced in 17.2.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return activeBurstResources
     */
    public List<BurstResource> getActiveBurstResources() {
        return activeBurstResources;
    }

    /**
     * This is the setter method. this will set the activeBurstResources
     * List of active burst core license in use.
     * Field introduced in 17.2.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return activeBurstResources
     */
    public void setActiveBurstResources(List<BurstResource>  activeBurstResources) {
        this.activeBurstResources = activeBurstResources;
    }

    /**
     * This is the setter method this will set the activeBurstResources
     * List of active burst core license in use.
     * Field introduced in 17.2.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return activeBurstResources
     */
    public ControllerLicense addActiveBurstResourcesItem(BurstResource activeBurstResourcesItem) {
      if (this.activeBurstResources == null) {
        this.activeBurstResources = new ArrayList<BurstResource>();
      }
      this.activeBurstResources.add(activeBurstResourcesItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Total number of service engine cores for burst core based licenses.
     * Field introduced in 17.2.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return burstCores
     */
    public Integer getBurstCores() {
        return burstCores;
    }

    /**
     * This is the setter method to the attribute.
     * Total number of service engine cores for burst core based licenses.
     * Field introduced in 17.2.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param burstCores set the burstCores.
     */
    public void setBurstCores(Integer  burstCores) {
        this.burstCores = burstCores;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Number of service engine cores in non-container clouds.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return cores
     */
    public Integer getCores() {
        return cores;
    }

    /**
     * This is the setter method to the attribute.
     * Number of service engine cores in non-container clouds.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param cores set the cores.
     */
    public void setCores(Integer  cores) {
        this.cores = cores;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property customer_name of obj type controllerlicense field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property customer_name of obj type controllerlicense field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param customerName set the customerName.
     */
    public void setCustomerName(String  customerName) {
        this.customerName = customerName;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Field introduced in 17.2.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return disableEnforcement
     */
    public Boolean getDisableEnforcement() {
        return disableEnforcement;
    }

    /**
     * This is the setter method to the attribute.
     * Field introduced in 17.2.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param disableEnforcement set the disableEnforcement.
     */
    public void setDisableEnforcement(Boolean  disableEnforcement) {
        this.disableEnforcement = disableEnforcement;
    }
    /**
     * This is the getter method this will return the attribute value.
     * List of used or expired burst core licenses.
     * Field introduced in 17.2.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return expiredBurstResources
     */
    public List<BurstResource> getExpiredBurstResources() {
        return expiredBurstResources;
    }

    /**
     * This is the setter method. this will set the expiredBurstResources
     * List of used or expired burst core licenses.
     * Field introduced in 17.2.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return expiredBurstResources
     */
    public void setExpiredBurstResources(List<BurstResource>  expiredBurstResources) {
        this.expiredBurstResources = expiredBurstResources;
    }

    /**
     * This is the setter method this will set the expiredBurstResources
     * List of used or expired burst core licenses.
     * Field introduced in 17.2.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return expiredBurstResources
     */
    public ControllerLicense addExpiredBurstResourcesItem(BurstResource expiredBurstResourcesItem) {
      if (this.expiredBurstResources == null) {
        this.expiredBurstResources = new ArrayList<BurstResource>();
      }
      this.expiredBurstResources.add(expiredBurstResourcesItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Flag used to track initialization.
     * Field introduced in 20.1.2.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return initialized
     */
    public Boolean getInitialized() {
        return initialized;
    }

    /**
     * This is the setter method to the attribute.
     * Flag used to track initialization.
     * Field introduced in 20.1.2.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param initialized set the initialized.
     */
    public void setInitialized(Boolean  initialized) {
        this.initialized = initialized;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Field introduced in 17.2.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return licenseId
     */
    public String getLicenseId() {
        return licenseId;
    }

    /**
     * This is the setter method to the attribute.
     * Field introduced in 17.2.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param licenseId set the licenseId.
     */
    public void setLicenseId(String  licenseId) {
        this.licenseId = licenseId;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property license_tier of obj type controllerlicense field type str  type array.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return licenseTier
     */
    public List<String> getLicenseTier() {
        return licenseTier;
    }

    /**
     * This is the setter method. this will set the licenseTier
     * Placeholder for description of property license_tier of obj type controllerlicense field type str  type array.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return licenseTier
     */
    public void setLicenseTier(List<String>  licenseTier) {
        this.licenseTier = licenseTier;
    }

    /**
     * This is the setter method this will set the licenseTier
     * Placeholder for description of property license_tier of obj type controllerlicense field type str  type array.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return licenseTier
     */
    public ControllerLicense addLicenseTierItem(String licenseTierItem) {
      if (this.licenseTier == null) {
        this.licenseTier = new ArrayList<String>();
      }
      this.licenseTier.add(licenseTierItem);
      return this;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Field introduced in 17.2.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return licenseTiers
     */
    public List<CumulativeLicense> getLicenseTiers() {
        return licenseTiers;
    }

    /**
     * This is the setter method. this will set the licenseTiers
     * Field introduced in 17.2.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return licenseTiers
     */
    public void setLicenseTiers(List<CumulativeLicense>  licenseTiers) {
        this.licenseTiers = licenseTiers;
    }

    /**
     * This is the setter method this will set the licenseTiers
     * Field introduced in 17.2.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return licenseTiers
     */
    public ControllerLicense addLicenseTiersItem(CumulativeLicense licenseTiersItem) {
      if (this.licenseTiers == null) {
        this.licenseTiers = new ArrayList<CumulativeLicense>();
      }
      this.licenseTiers.add(licenseTiersItem);
      return this;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property licenses of obj type controllerlicense field type str  type array.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return licenses
     */
    public List<SingleLicense> getLicenses() {
        return licenses;
    }

    /**
     * This is the setter method. this will set the licenses
     * Placeholder for description of property licenses of obj type controllerlicense field type str  type array.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return licenses
     */
    public void setLicenses(List<SingleLicense>  licenses) {
        this.licenses = licenses;
    }

    /**
     * This is the setter method this will set the licenses
     * Placeholder for description of property licenses of obj type controllerlicense field type str  type array.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return licenses
     */
    public ControllerLicense addLicensesItem(SingleLicense licensesItem) {
      if (this.licenses == null) {
        this.licenses = new ArrayList<SingleLicense>();
      }
      this.licenses.add(licensesItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Number of service engines hosts in container clouds.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return maxSes
     */
    public Integer getMaxSes() {
        return maxSes;
    }

    /**
     * This is the setter method to the attribute.
     * Number of service engines hosts in container clouds.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param maxSes set the maxSes.
     */
    public void setMaxSes(Integer  maxSes) {
        this.maxSes = maxSes;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Name of the object.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This is the setter method to the attribute.
     * Name of the object.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param name set the name.
     */
    public void setName(String  name) {
        this.name = name;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Service engine bandwidth limits for bandwidth based licenses.
     * Field introduced in 17.2.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return seBandwidthLimits
     */
    public List<SEBandwidthLimit> getSeBandwidthLimits() {
        return seBandwidthLimits;
    }

    /**
     * This is the setter method. this will set the seBandwidthLimits
     * Service engine bandwidth limits for bandwidth based licenses.
     * Field introduced in 17.2.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return seBandwidthLimits
     */
    public void setSeBandwidthLimits(List<SEBandwidthLimit>  seBandwidthLimits) {
        this.seBandwidthLimits = seBandwidthLimits;
    }

    /**
     * This is the setter method this will set the seBandwidthLimits
     * Service engine bandwidth limits for bandwidth based licenses.
     * Field introduced in 17.2.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return seBandwidthLimits
     */
    public ControllerLicense addSeBandwidthLimitsItem(SEBandwidthLimit seBandwidthLimitsItem) {
      if (this.seBandwidthLimits == null) {
        this.seBandwidthLimits = new ArrayList<SEBandwidthLimit>();
      }
      this.seBandwidthLimits.add(seBandwidthLimitsItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Number of vmware service cores after aggregating all other license types.
     * Field introduced in 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return serviceCores
     */
    public Float getServiceCores() {
        return serviceCores;
    }

    /**
     * This is the setter method to the attribute.
     * Number of vmware service cores after aggregating all other license types.
     * Field introduced in 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param serviceCores set the serviceCores.
     */
    public void setServiceCores(Float  serviceCores) {
        this.serviceCores = serviceCores;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Number of physical cpu sockets across service engines in no access and linux server clouds.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return sockets
     */
    public Integer getSockets() {
        return sockets;
    }

    /**
     * This is the setter method to the attribute.
     * Number of physical cpu sockets across service engines in no access and linux server clouds.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param sockets set the sockets.
     */
    public void setSockets(Integer  sockets) {
        this.sockets = sockets;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property start_on of obj type controllerlicense field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return startOn
     */
    public String getStartOn() {
        return startOn;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property start_on of obj type controllerlicense field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param startOn set the startOn.
     */
    public void setStartOn(String  startOn) {
        this.startOn = startOn;
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
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This is the setter method to the attribute.
     * Unique object identifier of the object.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param uuid set the uuid.
     */
    public void setUuid(String  uuid) {
        this.uuid = uuid;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property valid_until of obj type controllerlicense field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return validUntil
     */
    public String getValidUntil() {
        return validUntil;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property valid_until of obj type controllerlicense field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param validUntil set the validUntil.
     */
    public void setValidUntil(String  validUntil) {
        this.validUntil = validUntil;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      ControllerLicense objControllerLicense = (ControllerLicense) o;
      return   Objects.equals(this.uuid, objControllerLicense.uuid)&&
  Objects.equals(this.name, objControllerLicense.name)&&
  Objects.equals(this.startOn, objControllerLicense.startOn)&&
  Objects.equals(this.validUntil, objControllerLicense.validUntil)&&
  Objects.equals(this.customerName, objControllerLicense.customerName)&&
  Objects.equals(this.cores, objControllerLicense.cores)&&
  Objects.equals(this.licenseTier, objControllerLicense.licenseTier)&&
  Objects.equals(this.maxSes, objControllerLicense.maxSes)&&
  Objects.equals(this.sockets, objControllerLicense.sockets)&&
  Objects.equals(this.licenses, objControllerLicense.licenses)&&
  Objects.equals(this.seBandwidthLimits, objControllerLicense.seBandwidthLimits)&&
  Objects.equals(this.licenseTiers, objControllerLicense.licenseTiers)&&
  Objects.equals(this.burstCores, objControllerLicense.burstCores)&&
  Objects.equals(this.activeBurstResources, objControllerLicense.activeBurstResources)&&
  Objects.equals(this.expiredBurstResources, objControllerLicense.expiredBurstResources)&&
  Objects.equals(this.licenseId, objControllerLicense.licenseId)&&
  Objects.equals(this.disableEnforcement, objControllerLicense.disableEnforcement)&&
  Objects.equals(this.serviceCores, objControllerLicense.serviceCores)&&
  Objects.equals(this.initialized, objControllerLicense.initialized);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ControllerLicense {\n");
                  sb.append("    activeBurstResources: ").append(toIndentedString(activeBurstResources)).append("\n");
                        sb.append("    burstCores: ").append(toIndentedString(burstCores)).append("\n");
                        sb.append("    cores: ").append(toIndentedString(cores)).append("\n");
                        sb.append("    customerName: ").append(toIndentedString(customerName)).append("\n");
                        sb.append("    disableEnforcement: ").append(toIndentedString(disableEnforcement)).append("\n");
                        sb.append("    expiredBurstResources: ").append(toIndentedString(expiredBurstResources)).append("\n");
                        sb.append("    initialized: ").append(toIndentedString(initialized)).append("\n");
                        sb.append("    licenseId: ").append(toIndentedString(licenseId)).append("\n");
                        sb.append("    licenseTier: ").append(toIndentedString(licenseTier)).append("\n");
                        sb.append("    licenseTiers: ").append(toIndentedString(licenseTiers)).append("\n");
                        sb.append("    licenses: ").append(toIndentedString(licenses)).append("\n");
                        sb.append("    maxSes: ").append(toIndentedString(maxSes)).append("\n");
                        sb.append("    name: ").append(toIndentedString(name)).append("\n");
                        sb.append("    seBandwidthLimits: ").append(toIndentedString(seBandwidthLimits)).append("\n");
                        sb.append("    serviceCores: ").append(toIndentedString(serviceCores)).append("\n");
                        sb.append("    sockets: ").append(toIndentedString(sockets)).append("\n");
                        sb.append("    startOn: ").append(toIndentedString(startOn)).append("\n");
                                    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
                        sb.append("    validUntil: ").append(toIndentedString(validUntil)).append("\n");
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
