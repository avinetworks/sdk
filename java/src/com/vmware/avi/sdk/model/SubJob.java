package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SubJob is a POJO class extends AviRestResource that used for creating
 * SubJob.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubJob  {
    @JsonProperty("expires_at")
    private String expiresAt = null;

    @JsonProperty("metadata")
    private String metadata = null;

    @JsonProperty("type")
    private String type = null;



  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 18.1.1.
   * @return expiresAt
   */
  public String getExpiresAt() {
    return expiresAt;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 18.1.1.
   * @param expiresAt set the expiresAt.
   */
  public void setExpiresAt(String  expiresAt) {
    this.expiresAt = expiresAt;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 18.1.1.
   * @return metadata
   */
  public String getMetadata() {
    return metadata;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 18.1.1.
   * @param metadata set the metadata.
   */
  public void setMetadata(String  metadata) {
    this.metadata = metadata;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - JOB_TYPE_VS_FULL_LOGS, JOB_TYPE_VS_UDF, JOB_TYPE_VS_METRICS_RT, JOB_TYPE_SSL_CERT, JOB_TYPE_DEBUGVS_PKT_CAPTURE,
   * JOB_TYPE_CONSISTENCY_CHECK, JOB_TYPE_TECHSUPPORT, JOB_TYPE_PKI_PROFILE, JOB_TYPE_NSP_RULE, JOB_TYPE_SEGROUP_METRICS_RT, JOB_TYPE_POSTGRES_STATUS,
   * JOB_TYPE_VS_ROTATE_KEYS, JOB_TYPE_POOL_DNS, JOB_TYPE_GSLB_SERVICE, JOB_TYPE_APP_PERSISTENCE, JOB_TYPE_PROCESS_LOCKED_USER_ACCOUNTS,
   * JOB_TYPE_SESSION, JOB_TYPE_AUTHTOKEN, JOB_TYPE_CLUSTER, JOB_TYPE_SE_SECURE_CHANNEL_CLEANUP...
   * Field introduced in 18.1.1.
   * @return type
   */
  public String getType() {
    return type;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - JOB_TYPE_VS_FULL_LOGS, JOB_TYPE_VS_UDF, JOB_TYPE_VS_METRICS_RT, JOB_TYPE_SSL_CERT, JOB_TYPE_DEBUGVS_PKT_CAPTURE,
   * JOB_TYPE_CONSISTENCY_CHECK, JOB_TYPE_TECHSUPPORT, JOB_TYPE_PKI_PROFILE, JOB_TYPE_NSP_RULE, JOB_TYPE_SEGROUP_METRICS_RT, JOB_TYPE_POSTGRES_STATUS,
   * JOB_TYPE_VS_ROTATE_KEYS, JOB_TYPE_POOL_DNS, JOB_TYPE_GSLB_SERVICE, JOB_TYPE_APP_PERSISTENCE, JOB_TYPE_PROCESS_LOCKED_USER_ACCOUNTS,
   * JOB_TYPE_SESSION, JOB_TYPE_AUTHTOKEN, JOB_TYPE_CLUSTER, JOB_TYPE_SE_SECURE_CHANNEL_CLEANUP...
   * Field introduced in 18.1.1.
   * @param type set the type.
   */
  public void setType(String  type) {
    this.type = type;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SubJob objSubJob = (SubJob) o;
  return   Objects.equals(this.type, objSubJob.type)&&
  Objects.equals(this.expiresAt, objSubJob.expiresAt)&&
  Objects.equals(this.metadata, objSubJob.metadata);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SubJob {\n");
      sb.append("    expiresAt: ").append(toIndentedString(expiresAt)).append("\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

