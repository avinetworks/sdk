package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The GslbReplicationStats is a POJO class extends AviRestResource that used for creating
 * GslbReplicationStats.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GslbReplicationStats  {
    @JsonProperty("acknowledged_version")
    private Integer acknowledgedVersion = null;

    @JsonProperty("pending_object_count")
    private Integer pendingObjectCount = null;

    @JsonProperty("received_version")
    private Integer receivedVersion = null;



    /**
     * This is the getter method this will return the attribute value.
     * Last config version acknowledged.
     * Field introduced in 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return acknowledgedVersion
     */
    public Integer getAcknowledgedVersion() {
        return acknowledgedVersion;
    }

    /**
     * This is the setter method to the attribute.
     * Last config version acknowledged.
     * Field introduced in 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param acknowledgedVersion set the acknowledgedVersion.
     */
    public void setAcknowledgedVersion(Integer  acknowledgedVersion) {
        this.acknowledgedVersion = acknowledgedVersion;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Number of pending objects.
     * Field introduced in 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return pendingObjectCount
     */
    public Integer getPendingObjectCount() {
        return pendingObjectCount;
    }

    /**
     * This is the setter method to the attribute.
     * Number of pending objects.
     * Field introduced in 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param pendingObjectCount set the pendingObjectCount.
     */
    public void setPendingObjectCount(Integer  pendingObjectCount) {
        this.pendingObjectCount = pendingObjectCount;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Last config version received.
     * On leader, this represents the version received from federated datastore.
     * Field introduced in 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return receivedVersion
     */
    public Integer getReceivedVersion() {
        return receivedVersion;
    }

    /**
     * This is the setter method to the attribute.
     * Last config version received.
     * On leader, this represents the version received from federated datastore.
     * Field introduced in 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param receivedVersion set the receivedVersion.
     */
    public void setReceivedVersion(Integer  receivedVersion) {
        this.receivedVersion = receivedVersion;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      GslbReplicationStats objGslbReplicationStats = (GslbReplicationStats) o;
      return   Objects.equals(this.receivedVersion, objGslbReplicationStats.receivedVersion)&&
  Objects.equals(this.acknowledgedVersion, objGslbReplicationStats.acknowledgedVersion)&&
  Objects.equals(this.pendingObjectCount, objGslbReplicationStats.pendingObjectCount);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class GslbReplicationStats {\n");
                  sb.append("    acknowledgedVersion: ").append(toIndentedString(acknowledgedVersion)).append("\n");
                        sb.append("    pendingObjectCount: ").append(toIndentedString(pendingObjectCount)).append("\n");
                        sb.append("    receivedVersion: ").append(toIndentedString(receivedVersion)).append("\n");
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
