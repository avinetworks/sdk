package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The GslbSiteRuntimeInfo is a POJO class extends AviRestResource that used for creating
 * GslbSiteRuntimeInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GslbSiteRuntimeInfo  {
    @JsonProperty("cluster_leader")
    private String clusterLeader = null;

    @JsonProperty("cluster_uuid")
    private String clusterUuid = null;

    @JsonProperty("dns_info")
    private GslbDnsInfo dnsInfo = null;

    @JsonProperty("enabled")
    private Boolean enabled = null;

    @JsonProperty("event_cache")
    private EventCache eventCache = null;

    @JsonProperty("hs_state")
    private Boolean hsState = null;

    @JsonProperty("last_changed_time")
    private TimeStamp lastChangedTime = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("num_of_retries")
    private Integer numOfRetries = 0;

    @JsonProperty("oper_status")
    private OperationalStatus operStatus = null;

    @JsonProperty("role")
    private String role = "GSLB_NOT_A_MEMBER";

    @JsonProperty("rrtoken")
    private List<String> rrtoken = null;

    @JsonProperty("site_type")
    private String siteType = null;

    @JsonProperty("state")
    private String state = "SITE_STATE_NULL";

    @JsonProperty("state_reason")
    private String stateReason = null;

    @JsonProperty("sw_version")
    private String swVersion = "not-initialized";



  /**
   * This is the getter method this will return the attribute value.
   * The leader-ip/vip/fqdn of the site-cluster.
   * @return clusterLeader
   */
  public String getClusterLeader() {
    return clusterLeader;
  }

  /**
   * This is the setter method to the attribute.
   * The leader-ip/vip/fqdn of the site-cluster.
   * @param clusterLeader set the clusterLeader.
   */
  public void setClusterLeader(String  clusterLeader) {
    this.clusterLeader = clusterLeader;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of cluster.
   * @return clusterUuid
   */
  public String getClusterUuid() {
    return clusterUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of cluster.
   * @param clusterUuid set the clusterUuid.
   */
  public void setClusterUuid(String  clusterUuid) {
    this.clusterUuid = clusterUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Operational dns state at the site.
   * @return dnsInfo
   */
  public GslbDnsInfo getDnsInfo() {
    return dnsInfo;
  }

  /**
   * This is the setter method to the attribute.
   * Operational dns state at the site.
   * @param dnsInfo set the dnsInfo.
   */
  public void setDnsInfo(GslbDnsInfo dnsInfo) {
    this.dnsInfo = dnsInfo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable/disable state retrieved from the cfg .
   * @return enabled
   */
  public Boolean getEnabled() {
    return enabled;
  }

  /**
   * This is the setter method to the attribute.
   * Enable/disable state retrieved from the cfg .
   * @param enabled set the enabled.
   */
  public void setEnabled(Boolean  enabled) {
    this.enabled = enabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Event-cache used for event throttling.
   * @return eventCache
   */
  public EventCache getEventCache() {
    return eventCache;
  }

  /**
   * This is the setter method to the attribute.
   * Event-cache used for event throttling.
   * @param eventCache set the eventCache.
   */
  public void setEventCache(EventCache eventCache) {
    this.eventCache = eventCache;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Health-status monitoring enable or disable.
   * @return hsState
   */
  public Boolean getHsState() {
    return hsState;
  }

  /**
   * This is the setter method to the attribute.
   * Health-status monitoring enable or disable.
   * @param hsState set the hsState.
   */
  public void setHsState(Boolean  hsState) {
    this.hsState = hsState;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property last_changed_time of obj type gslbsiteruntimeinfo field type str  type ref.
   * @return lastChangedTime
   */
  public TimeStamp getLastChangedTime() {
    return lastChangedTime;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property last_changed_time of obj type gslbsiteruntimeinfo field type str  type ref.
   * @param lastChangedTime set the lastChangedTime.
   */
  public void setLastChangedTime(TimeStamp lastChangedTime) {
    this.lastChangedTime = lastChangedTime;
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
   * Number of retry attempts to reach the remote site.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return numOfRetries
   */
  public Integer getNumOfRetries() {
    return numOfRetries;
  }

  /**
   * This is the setter method to the attribute.
   * Number of retry attempts to reach the remote site.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param numOfRetries set the numOfRetries.
   */
  public void setNumOfRetries(Integer  numOfRetries) {
    this.numOfRetries = numOfRetries;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property oper_status of obj type gslbsiteruntimeinfo field type str  type ref.
   * @return operStatus
   */
  public OperationalStatus getOperStatus() {
    return operStatus;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property oper_status of obj type gslbsiteruntimeinfo field type str  type ref.
   * @param operStatus set the operStatus.
   */
  public void setOperStatus(OperationalStatus operStatus) {
    this.operStatus = operStatus;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Site role  leader or follower.
   * Enum options - GSLB_LEADER, GSLB_MEMBER, GSLB_NOT_A_MEMBER.
   * Default value when not specified in API or module is interpreted by Avi Controller as GSLB_NOT_A_MEMBER.
   * @return role
   */
  public String getRole() {
    return role;
  }

  /**
   * This is the setter method to the attribute.
   * Site role  leader or follower.
   * Enum options - GSLB_LEADER, GSLB_MEMBER, GSLB_NOT_A_MEMBER.
   * Default value when not specified in API or module is interpreted by Avi Controller as GSLB_NOT_A_MEMBER.
   * @param role set the role.
   */
  public void setRole(String  role) {
    this.role = role;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Current outstanding request-response token of the message to this site.
   * @return rrtoken
   */
  public List<String> getRrtoken() {
    return rrtoken;
  }

  /**
   * This is the setter method. this will set the rrtoken
   * Current outstanding request-response token of the message to this site.
   * @return rrtoken
   */
  public void setRrtoken(List<String>  rrtoken) {
    this.rrtoken = rrtoken;
  }

  /**
   * This is the setter method this will set the rrtoken
   * Current outstanding request-response token of the message to this site.
   * @return rrtoken
   */
  public GslbSiteRuntimeInfo addRrtokenItem(String rrtokenItem) {
    if (this.rrtoken == null) {
      this.rrtoken = new ArrayList<String>();
    }
    this.rrtoken.add(rrtokenItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Indicates if it is avi site or third-party.
   * Enum options - GSLB_AVI_SITE, GSLB_THIRD_PARTY_SITE.
   * Field introduced in 17.1.1.
   * @return siteType
   */
  public String getSiteType() {
    return siteType;
  }

  /**
   * This is the setter method to the attribute.
   * Indicates if it is avi site or third-party.
   * Enum options - GSLB_AVI_SITE, GSLB_THIRD_PARTY_SITE.
   * Field introduced in 17.1.1.
   * @param siteType set the siteType.
   */
  public void setSiteType(String  siteType) {
    this.siteType = siteType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - SITE_STATE_NULL, SITE_STATE_JOIN_IN_PROGRESS, SITE_STATE_LEAVE_IN_PROGRESS, SITE_STATE_INIT, SITE_STATE_UNREACHABLE,
   * SITE_STATE_MMODE, SITE_STATE_DISABLE_IN_PROGRESS, SITE_STATE_DISABLED.
   * Default value when not specified in API or module is interpreted by Avi Controller as SITE_STATE_NULL.
   * @return state
   */
  public String getState() {
    return state;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - SITE_STATE_NULL, SITE_STATE_JOIN_IN_PROGRESS, SITE_STATE_LEAVE_IN_PROGRESS, SITE_STATE_INIT, SITE_STATE_UNREACHABLE,
   * SITE_STATE_MMODE, SITE_STATE_DISABLE_IN_PROGRESS, SITE_STATE_DISABLED.
   * Default value when not specified in API or module is interpreted by Avi Controller as SITE_STATE_NULL.
   * @param state set the state.
   */
  public void setState(String  state) {
    this.state = state;
  }

  /**
   * This is the getter method this will return the attribute value.
   * State - reason.
   * @return stateReason
   */
  public String getStateReason() {
    return stateReason;
  }

  /**
   * This is the setter method to the attribute.
   * State - reason.
   * @param stateReason set the stateReason.
   */
  public void setStateReason(String  stateReason) {
    this.stateReason = stateReason;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Current software version of the site.
   * Default value when not specified in API or module is interpreted by Avi Controller as not-initialized.
   * @return swVersion
   */
  public String getSwVersion() {
    return swVersion;
  }

  /**
   * This is the setter method to the attribute.
   * Current software version of the site.
   * Default value when not specified in API or module is interpreted by Avi Controller as not-initialized.
   * @param swVersion set the swVersion.
   */
  public void setSwVersion(String  swVersion) {
    this.swVersion = swVersion;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  GslbSiteRuntimeInfo objGslbSiteRuntimeInfo = (GslbSiteRuntimeInfo) o;
  return   Objects.equals(this.swVersion, objGslbSiteRuntimeInfo.swVersion)&&
  Objects.equals(this.stateReason, objGslbSiteRuntimeInfo.stateReason)&&
  Objects.equals(this.name, objGslbSiteRuntimeInfo.name)&&
  Objects.equals(this.clusterLeader, objGslbSiteRuntimeInfo.clusterLeader)&&
  Objects.equals(this.dnsInfo, objGslbSiteRuntimeInfo.dnsInfo)&&
  Objects.equals(this.enabled, objGslbSiteRuntimeInfo.enabled)&&
  Objects.equals(this.state, objGslbSiteRuntimeInfo.state)&&
  Objects.equals(this.numOfRetries, objGslbSiteRuntimeInfo.numOfRetries)&&
  Objects.equals(this.operStatus, objGslbSiteRuntimeInfo.operStatus)&&
  Objects.equals(this.role, objGslbSiteRuntimeInfo.role)&&
  Objects.equals(this.lastChangedTime, objGslbSiteRuntimeInfo.lastChangedTime)&&
  Objects.equals(this.clusterUuid, objGslbSiteRuntimeInfo.clusterUuid)&&
  Objects.equals(this.rrtoken, objGslbSiteRuntimeInfo.rrtoken)&&
  Objects.equals(this.eventCache, objGslbSiteRuntimeInfo.eventCache)&&
  Objects.equals(this.hsState, objGslbSiteRuntimeInfo.hsState)&&
  Objects.equals(this.siteType, objGslbSiteRuntimeInfo.siteType);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class GslbSiteRuntimeInfo {\n");
      sb.append("    clusterLeader: ").append(toIndentedString(clusterLeader)).append("\n");
        sb.append("    clusterUuid: ").append(toIndentedString(clusterUuid)).append("\n");
        sb.append("    dnsInfo: ").append(toIndentedString(dnsInfo)).append("\n");
        sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
        sb.append("    eventCache: ").append(toIndentedString(eventCache)).append("\n");
        sb.append("    hsState: ").append(toIndentedString(hsState)).append("\n");
        sb.append("    lastChangedTime: ").append(toIndentedString(lastChangedTime)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    numOfRetries: ").append(toIndentedString(numOfRetries)).append("\n");
        sb.append("    operStatus: ").append(toIndentedString(operStatus)).append("\n");
        sb.append("    role: ").append(toIndentedString(role)).append("\n");
        sb.append("    rrtoken: ").append(toIndentedString(rrtoken)).append("\n");
        sb.append("    siteType: ").append(toIndentedString(siteType)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    stateReason: ").append(toIndentedString(stateReason)).append("\n");
        sb.append("    swVersion: ").append(toIndentedString(swVersion)).append("\n");
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

