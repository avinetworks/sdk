package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The AppSignatureEventData is a POJO class extends AviRestResource that used for creating
 * AppSignatureEventData.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppSignatureEventData  {
    @JsonProperty("last_successful_updated_time")
    private String lastSuccessfulUpdatedTime = null;

    @JsonProperty("reason")
    private String reason = null;

    @JsonProperty("status")
    private String status = null;



    /**
     * This is the getter method this will return the attribute value.
     * Last successful updated time of the appsignature.
     * Field introduced in 20.1.4.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return lastSuccessfulUpdatedTime
     */
    public String getLastSuccessfulUpdatedTime() {
        return lastSuccessfulUpdatedTime;
    }

    /**
     * This is the setter method to the attribute.
     * Last successful updated time of the appsignature.
     * Field introduced in 20.1.4.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param lastSuccessfulUpdatedTime set the lastSuccessfulUpdatedTime.
     */
    public void setLastSuccessfulUpdatedTime(String  lastSuccessfulUpdatedTime) {
        this.lastSuccessfulUpdatedTime = lastSuccessfulUpdatedTime;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Reason for appsignature transaction failure.
     * Field introduced in 20.1.4.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * This is the setter method to the attribute.
     * Reason for appsignature transaction failure.
     * Field introduced in 20.1.4.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param reason set the reason.
     */
    public void setReason(String  reason) {
        this.reason = reason;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Status of appsignature transaction.
     * Field introduced in 20.1.4.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * This is the setter method to the attribute.
     * Status of appsignature transaction.
     * Field introduced in 20.1.4.
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
      AppSignatureEventData objAppSignatureEventData = (AppSignatureEventData) o;
      return   Objects.equals(this.status, objAppSignatureEventData.status)&&
  Objects.equals(this.reason, objAppSignatureEventData.reason)&&
  Objects.equals(this.lastSuccessfulUpdatedTime, objAppSignatureEventData.lastSuccessfulUpdatedTime);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class AppSignatureEventData {\n");
                  sb.append("    lastSuccessfulUpdatedTime: ").append(toIndentedString(lastSuccessfulUpdatedTime)).append("\n");
                        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
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
