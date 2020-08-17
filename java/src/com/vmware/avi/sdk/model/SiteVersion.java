package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SiteVersion is a POJO class extends AviRestResource that used for creating
 * SiteVersion.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SiteVersion extends AviRestResource  {
    @JsonProperty("datetime")
    private String datetime = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("prev_target_version")
    private Integer prevTargetVersion = null;

    @JsonProperty("replication_state")
    private String replicationState = null;

    @JsonProperty("site_id")
    private String siteId = null;

    @JsonProperty("target_timeline")
    private String targetTimeline = null;

    @JsonProperty("target_version")
    private Integer targetVersion = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("timeline")
    private String timeline = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;

    @JsonProperty("version")
    private Integer version = null;

    @JsonProperty("version_type")
    private String versionType = null;



  /**
   * This is the getter method this will return the attribute value.
   * This field represents the creation time of the federateddiff.
   * Field introduced in 20.1.1.
   * @return datetime
   */
  public String getDatetime() {
    return datetime;
  }

  /**
   * This is the setter method to the attribute.
   * This field represents the creation time of the federateddiff.
   * Field introduced in 20.1.1.
   * @param datetime set the datetime.
   */
  public void setDatetime(String  datetime) {
    this.datetime = datetime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the site.
   * Field introduced in 20.1.1.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the site.
   * Field introduced in 20.1.1.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Previous targer version for a site.
   * Field introduced in 20.1.1.
   * @return prevTargetVersion
   */
  public Integer getPrevTargetVersion() {
    return prevTargetVersion;
  }

  /**
   * This is the setter method to the attribute.
   * Previous targer version for a site.
   * Field introduced in 20.1.1.
   * @param prevTargetVersion set the prevTargetVersion.
   */
  public void setPrevTargetVersion(Integer  prevTargetVersion) {
    this.prevTargetVersion = prevTargetVersion;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Replication state for a site.
   * Enum options - REPLICATION_STATE_FASTFORWARD, REPLICATION_STATE_FORCESYNC, REPLICATION_STATE_STREAMING, REPLICATION_STATE_SUSPENDED,
   * REPLICATION_STATE_INIT, REPLICATION_STATE_WAIT, REPLICATION_STATE_NOT_APPLICABLE.
   * Field introduced in 20.1.1.
   * @return replicationState
   */
  public String getReplicationState() {
    return replicationState;
  }

  /**
   * This is the setter method to the attribute.
   * Replication state for a site.
   * Enum options - REPLICATION_STATE_FASTFORWARD, REPLICATION_STATE_FORCESYNC, REPLICATION_STATE_STREAMING, REPLICATION_STATE_SUSPENDED,
   * REPLICATION_STATE_INIT, REPLICATION_STATE_WAIT, REPLICATION_STATE_NOT_APPLICABLE.
   * Field introduced in 20.1.1.
   * @param replicationState set the replicationState.
   */
  public void setReplicationState(String  replicationState) {
    this.replicationState = replicationState;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Cluster uuid of the site.
   * Field introduced in 20.1.1.
   * @return siteId
   */
  public String getSiteId() {
    return siteId;
  }

  /**
   * This is the setter method to the attribute.
   * Cluster uuid of the site.
   * Field introduced in 20.1.1.
   * @param siteId set the siteId.
   */
  public void setSiteId(String  siteId) {
    this.siteId = siteId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Target timeline of the site.
   * Field introduced in 20.1.1.
   * @return targetTimeline
   */
  public String getTargetTimeline() {
    return targetTimeline;
  }

  /**
   * This is the setter method to the attribute.
   * Target timeline of the site.
   * Field introduced in 20.1.1.
   * @param targetTimeline set the targetTimeline.
   */
  public void setTargetTimeline(String  targetTimeline) {
    this.targetTimeline = targetTimeline;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Target version of the site.
   * Field introduced in 20.1.1.
   * @return targetVersion
   */
  public Integer getTargetVersion() {
    return targetVersion;
  }

  /**
   * This is the setter method to the attribute.
   * Target version of the site.
   * Field introduced in 20.1.1.
   * @param targetVersion set the targetVersion.
   */
  public void setTargetVersion(Integer  targetVersion) {
    this.targetVersion = targetVersion;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Tenant that this object belongs to.
   * It is a reference to an object of type tenant.
   * Field introduced in 20.1.1.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
   * Tenant that this object belongs to.
   * It is a reference to an object of type tenant.
   * Field introduced in 20.1.1.
   * @param tenantRef set the tenantRef.
   */
  public void setTenantRef(String  tenantRef) {
    this.tenantRef = tenantRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Timeline of the site.
   * Field introduced in 20.1.1.
   * @return timeline
   */
  public String getTimeline() {
    return timeline;
  }

  /**
   * This is the setter method to the attribute.
   * Timeline of the site.
   * Field introduced in 20.1.1.
   * @param timeline set the timeline.
   */
  public void setTimeline(String  timeline) {
    this.timeline = timeline;
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
   * Uuid of the siteversion object.
   * Field introduced in 20.1.1.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the siteversion object.
   * Field introduced in 20.1.1.
   * @param uuid set the uuid.
   */
  public void setUuid(String  uuid) {
    this.uuid = uuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Version of the site.
   * Field introduced in 20.1.1.
   * @return version
   */
  public Integer getVersion() {
    return version;
  }

  /**
   * This is the setter method to the attribute.
   * Version of the site.
   * Field introduced in 20.1.1.
   * @param version set the version.
   */
  public void setVersion(Integer  version) {
    this.version = version;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Type of message for which version is maintained.
   * Enum options - CONFIG_VERSION, HEALTH_STATUS_VERSION.
   * Field introduced in 20.1.1.
   * @return versionType
   */
  public String getVersionType() {
    return versionType;
  }

  /**
   * This is the setter method to the attribute.
   * Type of message for which version is maintained.
   * Enum options - CONFIG_VERSION, HEALTH_STATUS_VERSION.
   * Field introduced in 20.1.1.
   * @param versionType set the versionType.
   */
  public void setVersionType(String  versionType) {
    this.versionType = versionType;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SiteVersion objSiteVersion = (SiteVersion) o;
  return   Objects.equals(this.uuid, objSiteVersion.uuid)&&
  Objects.equals(this.name, objSiteVersion.name)&&
  Objects.equals(this.datetime, objSiteVersion.datetime)&&
  Objects.equals(this.siteId, objSiteVersion.siteId)&&
  Objects.equals(this.versionType, objSiteVersion.versionType)&&
  Objects.equals(this.version, objSiteVersion.version)&&
  Objects.equals(this.targetVersion, objSiteVersion.targetVersion)&&
  Objects.equals(this.prevTargetVersion, objSiteVersion.prevTargetVersion)&&
  Objects.equals(this.replicationState, objSiteVersion.replicationState)&&
  Objects.equals(this.timeline, objSiteVersion.timeline)&&
  Objects.equals(this.targetTimeline, objSiteVersion.targetTimeline)&&
  Objects.equals(this.tenantRef, objSiteVersion.tenantRef);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SiteVersion {\n");
      sb.append("    datetime: ").append(toIndentedString(datetime)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    prevTargetVersion: ").append(toIndentedString(prevTargetVersion)).append("\n");
        sb.append("    replicationState: ").append(toIndentedString(replicationState)).append("\n");
        sb.append("    siteId: ").append(toIndentedString(siteId)).append("\n");
        sb.append("    targetTimeline: ").append(toIndentedString(targetTimeline)).append("\n");
        sb.append("    targetVersion: ").append(toIndentedString(targetVersion)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
        sb.append("    timeline: ").append(toIndentedString(timeline)).append("\n");
            sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
        sb.append("    versionType: ").append(toIndentedString(versionType)).append("\n");
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

