package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ALBServicesFileUpload is a POJO class extends AviRestResource that used for creating
 * ALBServicesFileUpload.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ALBServicesFileUpload extends AviRestResource  {
    @JsonProperty("case_id")
    private String caseId = null;

    @JsonProperty("error")
    private String error = null;

    @JsonProperty("file_path")
    private String filePath = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("s3_directory")
    private String s3Directory = null;

    @JsonProperty("status")
    private String status = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Salesforce alphanumeric caseid to attach uploaded file to.
   * Field introduced in 18.2.6.
   * @return caseId
   */
  public String getCaseId() {
    return caseId;
  }

  /**
   * This is the setter method to the attribute.
   * Salesforce alphanumeric caseid to attach uploaded file to.
   * Field introduced in 18.2.6.
   * @param caseId set the caseId.
   */
  public void setCaseId(String  caseId) {
    this.caseId = caseId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Error reported during file upload.
   * Field introduced in 18.2.6.
   * @return error
   */
  public String getError() {
    return error;
  }

  /**
   * This is the setter method to the attribute.
   * Error reported during file upload.
   * Field introduced in 18.2.6.
   * @param error set the error.
   */
  public void setError(String  error) {
    this.error = error;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Stores output file path, for upload to aws s3.
   * Field introduced in 18.2.6.
   * @return filePath
   */
  public String getFilePath() {
    return filePath;
  }

  /**
   * This is the setter method to the attribute.
   * Stores output file path, for upload to aws s3.
   * Field introduced in 18.2.6.
   * @param filePath set the filePath.
   */
  public void setFilePath(String  filePath) {
    this.filePath = filePath;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 18.2.6.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 18.2.6.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Custom aws s3 directory path to upload file.
   * Field introduced in 18.2.6.
   * @return s3Directory
   */
  public String getS3Directory() {
    return s3Directory;
  }

  /**
   * This is the setter method to the attribute.
   * Custom aws s3 directory path to upload file.
   * Field introduced in 18.2.6.
   * @param s3Directory set the s3Directory.
   */
  public void setS3Directory(String  s3Directory) {
    this.s3Directory = s3Directory;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Captures status for file upload.
   * Enum options - SYSERR_SUCCESS, SYSERR_FAILURE, SYSERR_OUT_OF_MEMORY, SYSERR_NO_ENT, SYSERR_INVAL, SYSERR_ACCESS, SYSERR_FAULT, SYSERR_IO,
   * SYSERR_TIMEOUT, SYSERR_NOT_SUPPORTED, SYSERR_NOT_READY, SYSERR_UPGRADE_IN_PROGRESS, SYSERR_WARM_START_IN_PROGRESS, SYSERR_TRY_AGAIN,
   * SYSERR_NOT_UPGRADING, SYSERR_PENDING, SYSERR_EVENT_GEN_FAILURE, SYSERR_CONFIG_PARAM_MISSING, SYSERR_BAD_REQUEST, SYSERR_TEST1...
   * Field introduced in 18.2.6.
   * @return status
   */
  public String getStatus() {
    return status;
  }

  /**
   * This is the setter method to the attribute.
   * Captures status for file upload.
   * Enum options - SYSERR_SUCCESS, SYSERR_FAILURE, SYSERR_OUT_OF_MEMORY, SYSERR_NO_ENT, SYSERR_INVAL, SYSERR_ACCESS, SYSERR_FAULT, SYSERR_IO,
   * SYSERR_TIMEOUT, SYSERR_NOT_SUPPORTED, SYSERR_NOT_READY, SYSERR_UPGRADE_IN_PROGRESS, SYSERR_WARM_START_IN_PROGRESS, SYSERR_TRY_AGAIN,
   * SYSERR_NOT_UPGRADING, SYSERR_PENDING, SYSERR_EVENT_GEN_FAILURE, SYSERR_CONFIG_PARAM_MISSING, SYSERR_BAD_REQUEST, SYSERR_TEST1...
   * Field introduced in 18.2.6.
   * @param status set the status.
   */
  public void setStatus(String  status) {
    this.status = status;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type tenant.
   * Field introduced in 18.2.6.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type tenant.
   * Field introduced in 18.2.6.
   * @param tenantRef set the tenantRef.
   */
  public void setTenantRef(String  tenantRef) {
    this.tenantRef = tenantRef;
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
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of the object.
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
  ALBServicesFileUpload objALBServicesFileUpload = (ALBServicesFileUpload) o;
  return   Objects.equals(this.status, objALBServicesFileUpload.status)&&
  Objects.equals(this.uuid, objALBServicesFileUpload.uuid)&&
  Objects.equals(this.filePath, objALBServicesFileUpload.filePath)&&
  Objects.equals(this.caseId, objALBServicesFileUpload.caseId)&&
  Objects.equals(this.error, objALBServicesFileUpload.error)&&
  Objects.equals(this.s3Directory, objALBServicesFileUpload.s3Directory)&&
  Objects.equals(this.tenantRef, objALBServicesFileUpload.tenantRef)&&
  Objects.equals(this.name, objALBServicesFileUpload.name);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ALBServicesFileUpload {\n");
      sb.append("    caseId: ").append(toIndentedString(caseId)).append("\n");
        sb.append("    error: ").append(toIndentedString(error)).append("\n");
        sb.append("    filePath: ").append(toIndentedString(filePath)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    s3Directory: ").append(toIndentedString(s3Directory)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
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

