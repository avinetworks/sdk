package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The LicenseTierSwitchDetiails is a POJO class extends AviRestResource that used for creating
 * LicenseTierSwitchDetiails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LicenseTierSwitchDetiails  {
    @JsonProperty("destination_tier")
    private String destinationTier = null;

    @JsonProperty("reason")
    private String reason = null;

    @JsonProperty("source_tier")
    private String sourceTier = null;

    @JsonProperty("status")
    private String status = null;



    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property destination_tier of obj type licensetierswitchdetiails field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return destinationTier
     */
    public String getDestinationTier() {
        return destinationTier;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property destination_tier of obj type licensetierswitchdetiails field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param destinationTier set the destinationTier.
     */
    public void setDestinationTier(String  destinationTier) {
        this.destinationTier = destinationTier;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property reason of obj type licensetierswitchdetiails field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property reason of obj type licensetierswitchdetiails field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param reason set the reason.
     */
    public void setReason(String  reason) {
        this.reason = reason;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property source_tier of obj type licensetierswitchdetiails field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return sourceTier
     */
    public String getSourceTier() {
        return sourceTier;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property source_tier of obj type licensetierswitchdetiails field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param sourceTier set the sourceTier.
     */
    public void setSourceTier(String  sourceTier) {
        this.sourceTier = sourceTier;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property status of obj type licensetierswitchdetiails field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property status of obj type licensetierswitchdetiails field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param status set the status.
     */
    public void setStatus(String  status) {
        this.status = status;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      LicenseTierSwitchDetiails objLicenseTierSwitchDetiails = (LicenseTierSwitchDetiails) o;
      return   Objects.equals(this.sourceTier, objLicenseTierSwitchDetiails.sourceTier)&&
  Objects.equals(this.destinationTier, objLicenseTierSwitchDetiails.destinationTier)&&
  Objects.equals(this.status, objLicenseTierSwitchDetiails.status)&&
  Objects.equals(this.reason, objLicenseTierSwitchDetiails.reason);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class LicenseTierSwitchDetiails {\n");
                  sb.append("    destinationTier: ").append(toIndentedString(destinationTier)).append("\n");
                        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
                        sb.append("    sourceTier: ").append(toIndentedString(sourceTier)).append("\n");
                        sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
