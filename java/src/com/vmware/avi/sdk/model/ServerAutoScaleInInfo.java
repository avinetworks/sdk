package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The ServerAutoScaleInInfo is a POJO class extends AviRestResource that used for creating
 * ServerAutoScaleInInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServerAutoScaleInInfo  {
    @JsonProperty("alertconfig_name")
    private String alertconfigName = null;

    @JsonProperty("alertconfig_ref")
    private String alertconfigRef = null;

    @JsonProperty("available_capacity")
    private Float availableCapacity = null;

    @JsonProperty("load")
    private Float load = null;

    @JsonProperty("num_scalein_servers")
    private Integer numScaleinServers = null;

    @JsonProperty("num_servers_up")
    private Integer numServersUp = null;

    @JsonProperty("pool_ref")
    private String poolRef = null;

    @JsonProperty("reason")
    private String reason = null;

    @JsonProperty("reason_code")
    private String reasonCode = "SYSERR_SUCCESS";

    @JsonProperty("scalein_server_candidates")
    private List<ServerId> scaleinServerCandidates = null;



    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property alertconfig_name of obj type serverautoscaleininfo field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return alertconfigName
     */
    public String getAlertconfigName() {
        return alertconfigName;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property alertconfig_name of obj type serverautoscaleininfo field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param alertconfigName set the alertconfigName.
     */
    public void setAlertconfigName(String  alertconfigName) {
        this.alertconfigName = alertconfigName;
    }

    /**
     * This is the getter method this will return the attribute value.
     * It is a reference to an object of type alertconfig.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return alertconfigRef
     */
    public String getAlertconfigRef() {
        return alertconfigRef;
    }

    /**
     * This is the setter method to the attribute.
     * It is a reference to an object of type alertconfig.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param alertconfigRef set the alertconfigRef.
     */
    public void setAlertconfigRef(String  alertconfigRef) {
        this.alertconfigRef = alertconfigRef;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property available_capacity of obj type serverautoscaleininfo field type str  type float.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return availableCapacity
     */
    public Float getAvailableCapacity() {
        return availableCapacity;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property available_capacity of obj type serverautoscaleininfo field type str  type float.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param availableCapacity set the availableCapacity.
     */
    public void setAvailableCapacity(Float  availableCapacity) {
        this.availableCapacity = availableCapacity;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property load of obj type serverautoscaleininfo field type str  type float.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return load
     */
    public Float getLoad() {
        return load;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property load of obj type serverautoscaleininfo field type str  type float.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param load set the load.
     */
    public void setLoad(Float  load) {
        this.load = load;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property num_scalein_servers of obj type serverautoscaleininfo field type str  type integer.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return numScaleinServers
     */
    public Integer getNumScaleinServers() {
        return numScaleinServers;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property num_scalein_servers of obj type serverautoscaleininfo field type str  type integer.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param numScaleinServers set the numScaleinServers.
     */
    public void setNumScaleinServers(Integer  numScaleinServers) {
        this.numScaleinServers = numScaleinServers;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property num_servers_up of obj type serverautoscaleininfo field type str  type integer.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return numServersUp
     */
    public Integer getNumServersUp() {
        return numServersUp;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property num_servers_up of obj type serverautoscaleininfo field type str  type integer.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param numServersUp set the numServersUp.
     */
    public void setNumServersUp(Integer  numServersUp) {
        this.numServersUp = numServersUp;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Uuid of the pool.
     * It is a reference to an object of type pool.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return poolRef
     */
    public String getPoolRef() {
        return poolRef;
    }

    /**
     * This is the setter method to the attribute.
     * Uuid of the pool.
     * It is a reference to an object of type pool.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param poolRef set the poolRef.
     */
    public void setPoolRef(String  poolRef) {
        this.poolRef = poolRef;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property reason of obj type serverautoscaleininfo field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property reason of obj type serverautoscaleininfo field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param reason set the reason.
     */
    public void setReason(String  reason) {
        this.reason = reason;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Enum options - SYSERR_SUCCESS, SYSERR_FAILURE, SYSERR_OUT_OF_MEMORY, SYSERR_NO_ENT, SYSERR_INVAL, SYSERR_ACCESS, SYSERR_FAULT, SYSERR_IO,
     * SYSERR_TIMEOUT, SYSERR_NOT_SUPPORTED, SYSERR_NOT_READY, SYSERR_UPGRADE_IN_PROGRESS, SYSERR_WARM_START_IN_PROGRESS, SYSERR_TRY_AGAIN,
     * SYSERR_NOT_UPGRADING, SYSERR_PENDING, SYSERR_EVENT_GEN_FAILURE, SYSERR_CONFIG_PARAM_MISSING, SYSERR_RANGE, SYSERR_BAD_REQUEST...
     * Default value when not specified in API or module is interpreted by Avi Controller as "SYSERR_SUCCESS".
     * @return reasonCode
     */
    public String getReasonCode() {
        return reasonCode;
    }

    /**
     * This is the setter method to the attribute.
     * Enum options - SYSERR_SUCCESS, SYSERR_FAILURE, SYSERR_OUT_OF_MEMORY, SYSERR_NO_ENT, SYSERR_INVAL, SYSERR_ACCESS, SYSERR_FAULT, SYSERR_IO,
     * SYSERR_TIMEOUT, SYSERR_NOT_SUPPORTED, SYSERR_NOT_READY, SYSERR_UPGRADE_IN_PROGRESS, SYSERR_WARM_START_IN_PROGRESS, SYSERR_TRY_AGAIN,
     * SYSERR_NOT_UPGRADING, SYSERR_PENDING, SYSERR_EVENT_GEN_FAILURE, SYSERR_CONFIG_PARAM_MISSING, SYSERR_RANGE, SYSERR_BAD_REQUEST...
     * Default value when not specified in API or module is interpreted by Avi Controller as "SYSERR_SUCCESS".
     * @param reasonCode set the reasonCode.
     */
    public void setReasonCode(String  reasonCode) {
        this.reasonCode = reasonCode;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property scalein_server_candidates of obj type serverautoscaleininfo field type str  type array.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return scaleinServerCandidates
     */
    public List<ServerId> getScaleinServerCandidates() {
        return scaleinServerCandidates;
    }

    /**
     * This is the setter method. this will set the scaleinServerCandidates
     * Placeholder for description of property scalein_server_candidates of obj type serverautoscaleininfo field type str  type array.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return scaleinServerCandidates
     */
    public void setScaleinServerCandidates(List<ServerId>  scaleinServerCandidates) {
        this.scaleinServerCandidates = scaleinServerCandidates;
    }

    /**
     * This is the setter method this will set the scaleinServerCandidates
     * Placeholder for description of property scalein_server_candidates of obj type serverautoscaleininfo field type str  type array.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return scaleinServerCandidates
     */
    public ServerAutoScaleInInfo addScaleinServerCandidatesItem(ServerId scaleinServerCandidatesItem) {
      if (this.scaleinServerCandidates == null) {
        this.scaleinServerCandidates = new ArrayList<ServerId>();
      }
      this.scaleinServerCandidates.add(scaleinServerCandidatesItem);
      return this;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      ServerAutoScaleInInfo objServerAutoScaleInInfo = (ServerAutoScaleInInfo) o;
      return   Objects.equals(this.poolRef, objServerAutoScaleInInfo.poolRef)&&
  Objects.equals(this.numScaleinServers, objServerAutoScaleInInfo.numScaleinServers)&&
  Objects.equals(this.numServersUp, objServerAutoScaleInInfo.numServersUp)&&
  Objects.equals(this.reason, objServerAutoScaleInInfo.reason)&&
  Objects.equals(this.reasonCode, objServerAutoScaleInInfo.reasonCode)&&
  Objects.equals(this.load, objServerAutoScaleInInfo.load)&&
  Objects.equals(this.availableCapacity, objServerAutoScaleInInfo.availableCapacity)&&
  Objects.equals(this.scaleinServerCandidates, objServerAutoScaleInInfo.scaleinServerCandidates)&&
  Objects.equals(this.alertconfigRef, objServerAutoScaleInInfo.alertconfigRef)&&
  Objects.equals(this.alertconfigName, objServerAutoScaleInInfo.alertconfigName);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class ServerAutoScaleInInfo {\n");
                  sb.append("    alertconfigName: ").append(toIndentedString(alertconfigName)).append("\n");
                        sb.append("    alertconfigRef: ").append(toIndentedString(alertconfigRef)).append("\n");
                        sb.append("    availableCapacity: ").append(toIndentedString(availableCapacity)).append("\n");
                        sb.append("    load: ").append(toIndentedString(load)).append("\n");
                        sb.append("    numScaleinServers: ").append(toIndentedString(numScaleinServers)).append("\n");
                        sb.append("    numServersUp: ").append(toIndentedString(numServersUp)).append("\n");
                        sb.append("    poolRef: ").append(toIndentedString(poolRef)).append("\n");
                        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
                        sb.append("    reasonCode: ").append(toIndentedString(reasonCode)).append("\n");
                        sb.append("    scaleinServerCandidates: ").append(toIndentedString(scaleinServerCandidates)).append("\n");
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
