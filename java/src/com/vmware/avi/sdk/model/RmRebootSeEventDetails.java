package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The RmRebootSeEventDetails is a POJO class extends AviRestResource that used for creating
 * RmRebootSeEventDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RmRebootSeEventDetails  {
    @JsonProperty("reason")
    private String reason = null;

    @JsonProperty("se_name")
    private String seName = null;



    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property reason of obj type rmrebootseeventdetails field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property reason of obj type rmrebootseeventdetails field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param reason set the reason.
     */
    public void setReason(String  reason) {
        this.reason = reason;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property se_name of obj type rmrebootseeventdetails field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return seName
     */
    public String getSeName() {
        return seName;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property se_name of obj type rmrebootseeventdetails field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param seName set the seName.
     */
    public void setSeName(String  seName) {
        this.seName = seName;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      RmRebootSeEventDetails objRmRebootSeEventDetails = (RmRebootSeEventDetails) o;
      return   Objects.equals(this.reason, objRmRebootSeEventDetails.reason)&&
  Objects.equals(this.seName, objRmRebootSeEventDetails.seName);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class RmRebootSeEventDetails {\n");
                  sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
                        sb.append("    seName: ").append(toIndentedString(seName)).append("\n");
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
