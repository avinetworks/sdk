package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Backup is a POJO class extends AviRestResource that used for creating
 * Backup.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Backup extends AviRestResource  {
    @JsonProperty("backup_config_ref")
    private String backupConfigRef = null;

    @JsonProperty("file_name")
    private String fileName = null;

    @JsonProperty("local_file_url")
    private String localFileUrl = null;

    @JsonProperty("remote_file_url")
    private String remoteFileUrl = null;

    @JsonProperty("scheduler_ref")
    private String schedulerRef = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("timestamp")
    private String timestamp = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Backupconfiguration information.
   * It is a reference to an object of type backupconfiguration.
   * @return backupConfigRef
   */
  public String getBackupConfigRef() {
    return backupConfigRef;
  }

  /**
   * This is the setter method to the attribute.
   * Backupconfiguration information.
   * It is a reference to an object of type backupconfiguration.
   * @param backupConfigRef set the backupConfigRef.
   */
  public void setBackupConfigRef(String  backupConfigRef) {
    this.backupConfigRef = backupConfigRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The file name of backup.
   * @return fileName
   */
  public String getFileName() {
    return fileName;
  }

  /**
   * This is the setter method to the attribute.
   * The file name of backup.
   * @param fileName set the fileName.
   */
  public void setFileName(String  fileName) {
    this.fileName = fileName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Url to download the backup file.
   * @return localFileUrl
   */
  public String getLocalFileUrl() {
    return localFileUrl;
  }

  /**
   * This is the setter method to the attribute.
   * Url to download the backup file.
   * @param localFileUrl set the localFileUrl.
   */
  public void setLocalFileUrl(String  localFileUrl) {
    this.localFileUrl = localFileUrl;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Url to download the backup file.
   * @return remoteFileUrl
   */
  public String getRemoteFileUrl() {
    return remoteFileUrl;
  }

  /**
   * This is the setter method to the attribute.
   * Url to download the backup file.
   * @param remoteFileUrl set the remoteFileUrl.
   */
  public void setRemoteFileUrl(String  remoteFileUrl) {
    this.remoteFileUrl = remoteFileUrl;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Scheduler information.
   * It is a reference to an object of type scheduler.
   * @return schedulerRef
   */
  public String getSchedulerRef() {
    return schedulerRef;
  }

  /**
   * This is the setter method to the attribute.
   * Scheduler information.
   * It is a reference to an object of type scheduler.
   * @param schedulerRef set the schedulerRef.
   */
  public void setSchedulerRef(String  schedulerRef) {
    this.schedulerRef = schedulerRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type tenant.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type tenant.
   * @param tenantRef set the tenantRef.
   */
  public void setTenantRef(String  tenantRef) {
    this.tenantRef = tenantRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unix timestamp of when the backup file is created.
   * @return timestamp
   */
  public String getTimestamp() {
    return timestamp;
  }

  /**
   * This is the setter method to the attribute.
   * Unix timestamp of when the backup file is created.
   * @param timestamp set the timestamp.
   */
  public void setTimestamp(String  timestamp) {
    this.timestamp = timestamp;
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
  Backup objBackup = (Backup) o;
  return   Objects.equals(this.uuid, objBackup.uuid)&&
  Objects.equals(this.localFileUrl, objBackup.localFileUrl)&&
  Objects.equals(this.fileName, objBackup.fileName)&&
  Objects.equals(this.remoteFileUrl, objBackup.remoteFileUrl)&&
  Objects.equals(this.schedulerRef, objBackup.schedulerRef)&&
  Objects.equals(this.timestamp, objBackup.timestamp)&&
  Objects.equals(this.tenantRef, objBackup.tenantRef)&&
  Objects.equals(this.backupConfigRef, objBackup.backupConfigRef);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class Backup {\n");
      sb.append("    backupConfigRef: ").append(toIndentedString(backupConfigRef)).append("\n");
        sb.append("    fileName: ").append(toIndentedString(fileName)).append("\n");
        sb.append("    localFileUrl: ").append(toIndentedString(localFileUrl)).append("\n");
        sb.append("    remoteFileUrl: ").append(toIndentedString(remoteFileUrl)).append("\n");
        sb.append("    schedulerRef: ").append(toIndentedString(schedulerRef)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
        sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
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

