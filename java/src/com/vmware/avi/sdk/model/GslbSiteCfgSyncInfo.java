package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The GslbSiteCfgSyncInfo is a POJO class extends AviRestResource that used for creating
 * GslbSiteCfgSyncInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GslbSiteCfgSyncInfo  {
    @JsonProperty("errored_objects")
    private List<VersionInfo> erroredObjects = null;

    @JsonProperty("last_changed_time")
    private TimeStamp lastChangedTime = null;

    @JsonProperty("sync_state")
    private String syncState = null;


  /**
   * This is the getter method this will return the attribute value.
   * Objects that could not be synced to the site .
   * @return erroredObjects
   */
  public List<VersionInfo> getErroredObjects() {
    return erroredObjects;
  }

  /**
   * This is the setter method. this will set the erroredObjects
   * Objects that could not be synced to the site .
   * @return erroredObjects
   */
  public void setErroredObjects(List<VersionInfo>  erroredObjects) {
    this.erroredObjects = erroredObjects;
  }

  /**
   * This is the setter method this will set the erroredObjects
   * Objects that could not be synced to the site .
   * @return erroredObjects
   */
  public GslbSiteCfgSyncInfo addErroredObjectsItem(VersionInfo erroredObjectsItem) {
    if (this.erroredObjects == null) {
      this.erroredObjects = new ArrayList<VersionInfo>();
    }
    this.erroredObjects.add(erroredObjectsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property last_changed_time of obj type gslbsitecfgsyncinfo field type str  type ref.
   * @return lastChangedTime
   */
  public TimeStamp getLastChangedTime() {
    return lastChangedTime;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property last_changed_time of obj type gslbsitecfgsyncinfo field type str  type ref.
   * @param lastChangedTime set the lastChangedTime.
   */
  public void setLastChangedTime(TimeStamp lastChangedTime) {
    this.lastChangedTime = lastChangedTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Configuration sync-state of the site.
   * Enum options - GSLB_SITE_CFG_IN_SYNC, GSLB_SITE_CFG_OUT_OF_SYNC, GSLB_SITE_CFG_SYNC_DISABLED, GSLB_SITE_CFG_SYNC_IN_PROGRESS,
   * GSLB_SITE_CFG_SYNC_NOT_APPLICABLE, GSLB_SITE_CFG_SYNCED_TILL_CHECKPOINT, GSLB_SITE_CFG_SYNC_SUSPENDED.
   * @return syncState
   */
  public String getSyncState() {
    return syncState;
  }

  /**
   * This is the setter method to the attribute.
   * Configuration sync-state of the site.
   * Enum options - GSLB_SITE_CFG_IN_SYNC, GSLB_SITE_CFG_OUT_OF_SYNC, GSLB_SITE_CFG_SYNC_DISABLED, GSLB_SITE_CFG_SYNC_IN_PROGRESS,
   * GSLB_SITE_CFG_SYNC_NOT_APPLICABLE, GSLB_SITE_CFG_SYNCED_TILL_CHECKPOINT, GSLB_SITE_CFG_SYNC_SUSPENDED.
   * @param syncState set the syncState.
   */
  public void setSyncState(String  syncState) {
    this.syncState = syncState;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  GslbSiteCfgSyncInfo objGslbSiteCfgSyncInfo = (GslbSiteCfgSyncInfo) o;
  return   Objects.equals(this.syncState, objGslbSiteCfgSyncInfo.syncState)&&
  Objects.equals(this.lastChangedTime, objGslbSiteCfgSyncInfo.lastChangedTime)&&
  Objects.equals(this.erroredObjects, objGslbSiteCfgSyncInfo.erroredObjects);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class GslbSiteCfgSyncInfo {\n");
      sb.append("    erroredObjects: ").append(toIndentedString(erroredObjects)).append("\n");
        sb.append("    lastChangedTime: ").append(toIndentedString(lastChangedTime)).append("\n");
        sb.append("    syncState: ").append(toIndentedString(syncState)).append("\n");
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

