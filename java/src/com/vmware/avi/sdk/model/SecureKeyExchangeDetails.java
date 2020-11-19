package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The SecureKeyExchangeDetails is a POJO class extends AviRestResource that used for creating
 * SecureKeyExchangeDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SecureKeyExchangeDetails extends AviRestResource  {
    @JsonProperty("ctlr_mgmt_ip")
    private String ctlrMgmtIp = null;

    @JsonProperty("ctlr_public_ip")
    private String ctlrPublicIp = null;

    @JsonProperty("error")
    private String error = null;

    @JsonProperty("follower_ip")
    private String followerIp = null;

    @JsonProperty("leader_ip")
    private String leaderIp = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("se_ip")
    private String seIp = null;

    @JsonProperty("source_ip")
    private String sourceIp = null;

    @JsonProperty("status")
    private String status = null;

    @JsonProperty("uuid")
    private String uuid = null;



    /**
     * This is the getter method this will return the attribute value.
     * Controller managememt ip for secure key exchange between controller and se.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return ctlrMgmtIp
     */
    public String getCtlrMgmtIp() {
        return ctlrMgmtIp;
    }

    /**
     * This is the setter method to the attribute.
     * Controller managememt ip for secure key exchange between controller and se.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param ctlrMgmtIp set the ctlrMgmtIp.
     */
    public void setCtlrMgmtIp(String  ctlrMgmtIp) {
        this.ctlrMgmtIp = ctlrMgmtIp;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Controller public ip for secure key exchange between controller and se.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return ctlrPublicIp
     */
    public String getCtlrPublicIp() {
        return ctlrPublicIp;
    }

    /**
     * This is the setter method to the attribute.
     * Controller public ip for secure key exchange between controller and se.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param ctlrPublicIp set the ctlrPublicIp.
     */
    public void setCtlrPublicIp(String  ctlrPublicIp) {
        this.ctlrPublicIp = ctlrPublicIp;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Error message if secure key exchange failed.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return error
     */
    public String getError() {
        return error;
    }

    /**
     * This is the setter method to the attribute.
     * Error message if secure key exchange failed.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param error set the error.
     */
    public void setError(String  error) {
        this.error = error;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Follower ip for secure key exchange between controller and controller.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return followerIp
     */
    public String getFollowerIp() {
        return followerIp;
    }

    /**
     * This is the setter method to the attribute.
     * Follower ip for secure key exchange between controller and controller.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param followerIp set the followerIp.
     */
    public void setFollowerIp(String  followerIp) {
        this.followerIp = followerIp;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Leader ip for secure key exchange between controller and controller.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return leaderIp
     */
    public String getLeaderIp() {
        return leaderIp;
    }

    /**
     * This is the setter method to the attribute.
     * Leader ip for secure key exchange between controller and controller.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param leaderIp set the leaderIp.
     */
    public void setLeaderIp(String  leaderIp) {
        this.leaderIp = leaderIp;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Name of se/controller who initiates the secure key exchange.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This is the setter method to the attribute.
     * Name of se/controller who initiates the secure key exchange.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param name set the name.
     */
    public void setName(String  name) {
        this.name = name;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Se ip for secure key exchange between controller and se.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return seIp
     */
    public String getSeIp() {
        return seIp;
    }

    /**
     * This is the setter method to the attribute.
     * Se ip for secure key exchange between controller and se.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param seIp set the seIp.
     */
    public void setSeIp(String  seIp) {
        this.seIp = seIp;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Ip address of the client.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return sourceIp
     */
    public String getSourceIp() {
        return sourceIp;
    }

    /**
     * This is the setter method to the attribute.
     * Ip address of the client.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param sourceIp set the sourceIp.
     */
    public void setSourceIp(String  sourceIp) {
        this.sourceIp = sourceIp;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Status.
     * Enum options - SYSERR_SUCCESS, SYSERR_FAILURE, SYSERR_OUT_OF_MEMORY, SYSERR_NO_ENT, SYSERR_INVAL, SYSERR_ACCESS, SYSERR_FAULT, SYSERR_IO,
     * SYSERR_TIMEOUT, SYSERR_NOT_SUPPORTED, SYSERR_NOT_READY, SYSERR_UPGRADE_IN_PROGRESS, SYSERR_WARM_START_IN_PROGRESS, SYSERR_TRY_AGAIN,
     * SYSERR_NOT_UPGRADING, SYSERR_PENDING, SYSERR_EVENT_GEN_FAILURE, SYSERR_CONFIG_PARAM_MISSING, SYSERR_RANGE, SYSERR_BAD_REQUEST...
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * This is the setter method to the attribute.
     * Status.
     * Enum options - SYSERR_SUCCESS, SYSERR_FAILURE, SYSERR_OUT_OF_MEMORY, SYSERR_NO_ENT, SYSERR_INVAL, SYSERR_ACCESS, SYSERR_FAULT, SYSERR_IO,
     * SYSERR_TIMEOUT, SYSERR_NOT_SUPPORTED, SYSERR_NOT_READY, SYSERR_UPGRADE_IN_PROGRESS, SYSERR_WARM_START_IN_PROGRESS, SYSERR_TRY_AGAIN,
     * SYSERR_NOT_UPGRADING, SYSERR_PENDING, SYSERR_EVENT_GEN_FAILURE, SYSERR_CONFIG_PARAM_MISSING, SYSERR_RANGE, SYSERR_BAD_REQUEST...
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param status set the status.
     */
    public void setStatus(String  status) {
        this.status = status;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Uuid of se/controller who initiates the secure key exchange.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This is the setter method to the attribute.
     * Uuid of se/controller who initiates the secure key exchange.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param uuid set the uuid.
     */
    public void setUuid(String  uuid) {
        this.uuid = uuid;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      SecureKeyExchangeDetails objSecureKeyExchangeDetails = (SecureKeyExchangeDetails) o;
      return   Objects.equals(this.uuid, objSecureKeyExchangeDetails.uuid)&&
  Objects.equals(this.name, objSecureKeyExchangeDetails.name)&&
  Objects.equals(this.ctlrMgmtIp, objSecureKeyExchangeDetails.ctlrMgmtIp)&&
  Objects.equals(this.ctlrPublicIp, objSecureKeyExchangeDetails.ctlrPublicIp)&&
  Objects.equals(this.seIp, objSecureKeyExchangeDetails.seIp)&&
  Objects.equals(this.leaderIp, objSecureKeyExchangeDetails.leaderIp)&&
  Objects.equals(this.followerIp, objSecureKeyExchangeDetails.followerIp)&&
  Objects.equals(this.sourceIp, objSecureKeyExchangeDetails.sourceIp)&&
  Objects.equals(this.status, objSecureKeyExchangeDetails.status)&&
  Objects.equals(this.error, objSecureKeyExchangeDetails.error);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class SecureKeyExchangeDetails {\n");
                  sb.append("    ctlrMgmtIp: ").append(toIndentedString(ctlrMgmtIp)).append("\n");
                        sb.append("    ctlrPublicIp: ").append(toIndentedString(ctlrPublicIp)).append("\n");
                        sb.append("    error: ").append(toIndentedString(error)).append("\n");
                        sb.append("    followerIp: ").append(toIndentedString(followerIp)).append("\n");
                        sb.append("    leaderIp: ").append(toIndentedString(leaderIp)).append("\n");
                        sb.append("    name: ").append(toIndentedString(name)).append("\n");
                        sb.append("    seIp: ").append(toIndentedString(seIp)).append("\n");
                        sb.append("    sourceIp: ").append(toIndentedString(sourceIp)).append("\n");
                        sb.append("    status: ").append(toIndentedString(status)).append("\n");
                        sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
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
