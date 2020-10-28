package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The BurstResource is a POJO class extends AviRestResource that used for creating
 * BurstResource.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BurstResource  {
    @JsonProperty("accounted_license_id")
    private String accountedLicenseId = null;

    @JsonProperty("last_alert_time")
    private String lastAlertTime = null;

    @JsonProperty("license_tier")
    private String licenseTier = null;

    @JsonProperty("se_cookie")
    private String seCookie = null;

    @JsonProperty("se_uuid")
    private String seUuid = null;

    @JsonProperty("start_time")
    private String startTime = null;



    /**
     * This is the getter method this will return the attribute value.
     * License id against which this burst has been accounted.
     * Field introduced in 17.2.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return accountedLicenseId
     */
    public String getAccountedLicenseId() {
        return accountedLicenseId;
    }

    /**
     * This is the setter method to the attribute.
     * License id against which this burst has been accounted.
     * Field introduced in 17.2.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param accountedLicenseId set the accountedLicenseId.
     */
    public void setAccountedLicenseId(String  accountedLicenseId) {
        this.accountedLicenseId = accountedLicenseId;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Time utc of the last alert created for this burst resource.
     * Field introduced in 17.2.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return lastAlertTime
     */
    public String getLastAlertTime() {
        return lastAlertTime;
    }

    /**
     * This is the setter method to the attribute.
     * Time utc of the last alert created for this burst resource.
     * Field introduced in 17.2.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param lastAlertTime set the lastAlertTime.
     */
    public void setLastAlertTime(String  lastAlertTime) {
        this.lastAlertTime = lastAlertTime;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Enum options - ENTERPRISE_16, ENTERPRISE, ENTERPRISE_18, BASIC, ESSENTIALS.
     * Field introduced in 17.2.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return licenseTier
     */
    public String getLicenseTier() {
        return licenseTier;
    }

    /**
     * This is the setter method to the attribute.
     * Enum options - ENTERPRISE_16, ENTERPRISE, ENTERPRISE_18, BASIC, ESSENTIALS.
     * Field introduced in 17.2.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param licenseTier set the licenseTier.
     */
    public void setLicenseTier(String  licenseTier) {
        this.licenseTier = licenseTier;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Field introduced in 17.2.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return seCookie
     */
    public String getSeCookie() {
        return seCookie;
    }

    /**
     * This is the setter method to the attribute.
     * Field introduced in 17.2.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param seCookie set the seCookie.
     */
    public void setSeCookie(String  seCookie) {
        this.seCookie = seCookie;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Service engine which triggered the burst license usage.
     * Field introduced in 17.2.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return seUuid
     */
    public String getSeUuid() {
        return seUuid;
    }

    /**
     * This is the setter method to the attribute.
     * Service engine which triggered the burst license usage.
     * Field introduced in 17.2.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param seUuid set the seUuid.
     */
    public void setSeUuid(String  seUuid) {
        this.seUuid = seUuid;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Time utc when the burst license was put in use.
     * Field introduced in 17.2.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * This is the setter method to the attribute.
     * Time utc when the burst license was put in use.
     * Field introduced in 17.2.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param startTime set the startTime.
     */
    public void setStartTime(String  startTime) {
        this.startTime = startTime;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      BurstResource objBurstResource = (BurstResource) o;
      return   Objects.equals(this.seCookie, objBurstResource.seCookie)&&
  Objects.equals(this.seUuid, objBurstResource.seUuid)&&
  Objects.equals(this.startTime, objBurstResource.startTime)&&
  Objects.equals(this.accountedLicenseId, objBurstResource.accountedLicenseId)&&
  Objects.equals(this.lastAlertTime, objBurstResource.lastAlertTime)&&
  Objects.equals(this.licenseTier, objBurstResource.licenseTier);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class BurstResource {\n");
                  sb.append("    accountedLicenseId: ").append(toIndentedString(accountedLicenseId)).append("\n");
                        sb.append("    lastAlertTime: ").append(toIndentedString(lastAlertTime)).append("\n");
                        sb.append("    licenseTier: ").append(toIndentedString(licenseTier)).append("\n");
                        sb.append("    seCookie: ").append(toIndentedString(seCookie)).append("\n");
                        sb.append("    seUuid: ").append(toIndentedString(seUuid)).append("\n");
                        sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
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
