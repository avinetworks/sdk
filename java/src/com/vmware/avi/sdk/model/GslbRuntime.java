package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The GslbRuntime is a POJO class extends AviRestResource that used for creating
 * GslbRuntime.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GslbRuntime extends AviRestResource  {
    @JsonProperty("checksum")
    private String checksum = null;

    @JsonProperty("delete_in_progress")
    private Boolean deleteInProgress = null;

    @JsonProperty("dns_enabled")
    private Boolean dnsEnabled = null;

    @JsonProperty("event_cache")
    private EventCache eventCache = null;

    @JsonProperty("flr_state")
    private List<CfgState> flrState = null;

    @JsonProperty("ldr_state")
    private CfgState ldrState = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("site")
    private List<GslbSiteRuntime> site = null;

    @JsonProperty("tenant_name")
    private String tenantName = null;

    @JsonProperty("third_party_sites")
    private List<GslbThirdPartySiteRuntime> thirdPartySites = null;

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.1.3.
   * @return checksum
   */
  public String getChecksum() {
    return checksum;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.1.3.
   * @param checksum set the checksum.
   */
  public void setChecksum(String  checksum) {
    this.checksum = checksum;
  }

  /**
   * This is the getter method this will return the attribute value.
   * This field indicates delete is in progress for this gslb instance.
   * Field introduced in 17.2.5.
   * @return deleteInProgress
   */
  public Boolean getDeleteInProgress() {
    return deleteInProgress;
  }

  /**
   * This is the setter method to the attribute.
   * This field indicates delete is in progress for this gslb instance.
   * Field introduced in 17.2.5.
   * @param deleteInProgress set the deleteInProgress.
   */
  public void setDeleteInProgress(Boolean  deleteInProgress) {
    this.deleteInProgress = deleteInProgress;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property dns_enabled of obj type gslbruntime field type str  type boolean.
   * @return dnsEnabled
   */
  public Boolean getDnsEnabled() {
    return dnsEnabled;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property dns_enabled of obj type gslbruntime field type str  type boolean.
   * @param dnsEnabled set the dnsEnabled.
   */
  public void setDnsEnabled(Boolean  dnsEnabled) {
    this.dnsEnabled = dnsEnabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property event_cache of obj type gslbruntime field type str  type ref.
   * @return eventCache
   */
  public EventCache getEventCache() {
    return eventCache;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property event_cache of obj type gslbruntime field type str  type ref.
   * @param eventCache set the eventCache.
   */
  public void setEventCache(EventCache eventCache) {
    this.eventCache = eventCache;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property flr_state of obj type gslbruntime field type str  type array.
   * @return flrState
   */
  public List<CfgState> getFlrState() {
    return flrState;
  }

  /**
   * This is the setter method. this will set the flrState
   * Placeholder for description of property flr_state of obj type gslbruntime field type str  type array.
   * @return flrState
   */
  public void setFlrState(List<CfgState>  flrState) {
    this.flrState = flrState;
  }

  /**
   * This is the setter method this will set the flrState
   * Placeholder for description of property flr_state of obj type gslbruntime field type str  type array.
   * @return flrState
   */
  public GslbRuntime addFlrStateItem(CfgState flrStateItem) {
    if (this.flrState == null) {
      this.flrState = new ArrayList<CfgState>();
    }
    this.flrState.add(flrStateItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ldr_state of obj type gslbruntime field type str  type ref.
   * @return ldrState
   */
  public CfgState getLdrState() {
    return ldrState;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ldr_state of obj type gslbruntime field type str  type ref.
   * @param ldrState set the ldrState.
   */
  public void setLdrState(CfgState ldrState) {
    this.ldrState = ldrState;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the object.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the object.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property site of obj type gslbruntime field type str  type array.
   * @return site
   */
  public List<GslbSiteRuntime> getSite() {
    return site;
  }

  /**
   * This is the setter method. this will set the site
   * Placeholder for description of property site of obj type gslbruntime field type str  type array.
   * @return site
   */
  public void setSite(List<GslbSiteRuntime>  site) {
    this.site = site;
  }

  /**
   * This is the setter method this will set the site
   * Placeholder for description of property site of obj type gslbruntime field type str  type array.
   * @return site
   */
  public GslbRuntime addSiteItem(GslbSiteRuntime siteItem) {
    if (this.site == null) {
      this.site = new ArrayList<GslbSiteRuntime>();
    }
    this.site.add(siteItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Remap the tenant_uuid to its tenant-name so that we can use the tenant_name directly in remote-site ops.
   * Field introduced in 17.2.3.
   * @return tenantName
   */
  public String getTenantName() {
    return tenantName;
  }

  /**
   * This is the setter method to the attribute.
   * Remap the tenant_uuid to its tenant-name so that we can use the tenant_name directly in remote-site ops.
   * Field introduced in 17.2.3.
   * @param tenantName set the tenantName.
   */
  public void setTenantName(String  tenantName) {
    this.tenantName = tenantName;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.1.1.
   * @return thirdPartySites
   */
  public List<GslbThirdPartySiteRuntime> getThirdPartySites() {
    return thirdPartySites;
  }

  /**
   * This is the setter method. this will set the thirdPartySites
   * Field introduced in 17.1.1.
   * @return thirdPartySites
   */
  public void setThirdPartySites(List<GslbThirdPartySiteRuntime>  thirdPartySites) {
    this.thirdPartySites = thirdPartySites;
  }

  /**
   * This is the setter method this will set the thirdPartySites
   * Field introduced in 17.1.1.
   * @return thirdPartySites
   */
  public GslbRuntime addThirdPartySitesItem(GslbThirdPartySiteRuntime thirdPartySitesItem) {
    if (this.thirdPartySites == null) {
      this.thirdPartySites = new ArrayList<GslbThirdPartySiteRuntime>();
    }
    this.thirdPartySites.add(thirdPartySitesItem);
    return this;
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
  GslbRuntime objGslbRuntime = (GslbRuntime) o;
  return   Objects.equals(this.uuid, objGslbRuntime.uuid)&&
  Objects.equals(this.name, objGslbRuntime.name)&&
  Objects.equals(this.ldrState, objGslbRuntime.ldrState)&&
  Objects.equals(this.flrState, objGslbRuntime.flrState)&&
  Objects.equals(this.dnsEnabled, objGslbRuntime.dnsEnabled)&&
  Objects.equals(this.site, objGslbRuntime.site)&&
  Objects.equals(this.eventCache, objGslbRuntime.eventCache)&&
  Objects.equals(this.thirdPartySites, objGslbRuntime.thirdPartySites)&&
  Objects.equals(this.checksum, objGslbRuntime.checksum)&&
  Objects.equals(this.deleteInProgress, objGslbRuntime.deleteInProgress)&&
  Objects.equals(this.tenantName, objGslbRuntime.tenantName);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class GslbRuntime {\n");
      sb.append("    checksum: ").append(toIndentedString(checksum)).append("\n");
        sb.append("    deleteInProgress: ").append(toIndentedString(deleteInProgress)).append("\n");
        sb.append("    dnsEnabled: ").append(toIndentedString(dnsEnabled)).append("\n");
        sb.append("    eventCache: ").append(toIndentedString(eventCache)).append("\n");
        sb.append("    flrState: ").append(toIndentedString(flrState)).append("\n");
        sb.append("    ldrState: ").append(toIndentedString(ldrState)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    site: ").append(toIndentedString(site)).append("\n");
        sb.append("    tenantName: ").append(toIndentedString(tenantName)).append("\n");
        sb.append("    thirdPartySites: ").append(toIndentedString(thirdPartySites)).append("\n");
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

