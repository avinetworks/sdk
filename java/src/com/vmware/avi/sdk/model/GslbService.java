package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The GslbService is a POJO class extends AviRestResource that used for creating
 * GslbService.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GslbService extends AviRestResource  {
    @JsonProperty("application_persistence_profile_ref")
    private String applicationPersistenceProfileRef = null;

    @JsonProperty("controller_health_status_enabled")
    private Boolean controllerHealthStatusEnabled = true;

    @JsonProperty("created_by")
    private String createdBy = null;

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("domain_names")
    private List<String> domainNames = null;

    @JsonProperty("down_response")
    private GslbServiceDownResponse downResponse = null;

    @JsonProperty("enabled")
    private Boolean enabled = true;

    @JsonProperty("groups")
    private List<GslbPool> groups = null;

    @JsonProperty("health_monitor_refs")
    private List<String> healthMonitorRefs = null;

    @JsonProperty("health_monitor_scope")
    private String healthMonitorScope = "GSLB_SERVICE_HEALTH_MONITOR_ALL_MEMBERS";

    @JsonProperty("hm_off")
    private Boolean hmOff = null;

    @JsonProperty("is_federated")
    private Boolean isFederated = true;

    @JsonProperty("min_members")
    private Integer minMembers = 0;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("num_dns_ip")
    private Integer numDnsIp = null;

    @JsonProperty("pool_algorithm")
    private String poolAlgorithm = "GSLB_SERVICE_ALGORITHM_PRIORITY";

    @JsonProperty("resolve_cname")
    private Boolean resolveCname = false;

    @JsonProperty("site_persistence_enabled")
    private Boolean sitePersistenceEnabled = false;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("ttl")
    private Integer ttl = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("use_edns_client_subnet")
    private Boolean useEdnsClientSubnet = true;

    @JsonProperty("uuid")
    private String uuid = null;

    @JsonProperty("wildcard_match")
    private Boolean wildcardMatch = false;



  /**
   * This is the getter method this will return the attribute value.
   * The federated application persistence associated with gslbservice site persistence functionality.
   * It is a reference to an object of type applicationpersistenceprofile.
   * Field introduced in 17.2.1.
   * @return applicationPersistenceProfileRef
   */
  public String getApplicationPersistenceProfileRef() {
    return applicationPersistenceProfileRef;
  }

  /**
   * This is the setter method to the attribute.
   * The federated application persistence associated with gslbservice site persistence functionality.
   * It is a reference to an object of type applicationpersistenceprofile.
   * Field introduced in 17.2.1.
   * @param applicationPersistenceProfileRef set the applicationPersistenceProfileRef.
   */
  public void setApplicationPersistenceProfileRef(String  applicationPersistenceProfileRef) {
    this.applicationPersistenceProfileRef = applicationPersistenceProfileRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Gs member's overall health status is derived based on a combination of controller and datapath health-status inputs.
   * Note that the datapath status is determined by the association of health monitor profiles.
   * Only the controller provided status is determined through this configuration.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return controllerHealthStatusEnabled
   */
  public Boolean getControllerHealthStatusEnabled() {
    return controllerHealthStatusEnabled;
  }

  /**
   * This is the setter method to the attribute.
   * Gs member's overall health status is derived based on a combination of controller and datapath health-status inputs.
   * Note that the datapath status is determined by the association of health monitor profiles.
   * Only the controller provided status is determined through this configuration.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param controllerHealthStatusEnabled set the controllerHealthStatusEnabled.
   */
  public void setControllerHealthStatusEnabled(Boolean  controllerHealthStatusEnabled) {
    this.controllerHealthStatusEnabled = controllerHealthStatusEnabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Creator name.
   * Field introduced in 17.1.2.
   * @return createdBy
   */
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * This is the setter method to the attribute.
   * Creator name.
   * Field introduced in 17.1.2.
   * @param createdBy set the createdBy.
   */
  public void setCreatedBy(String  createdBy) {
    this.createdBy = createdBy;
  }

  /**
   * This is the getter method this will return the attribute value.
   * User defined description for the object.
   * @return description
   */
  public String getDescription() {
    return description;
  }

  /**
   * This is the setter method to the attribute.
   * User defined description for the object.
   * @param description set the description.
   */
  public void setDescription(String  description) {
    this.description = description;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Fully qualified domain name of the gslb service.
   * @return domainNames
   */
  public List<String> getDomainNames() {
    return domainNames;
  }

  /**
   * This is the setter method. this will set the domainNames
   * Fully qualified domain name of the gslb service.
   * @return domainNames
   */
  public void setDomainNames(List<String>  domainNames) {
    this.domainNames = domainNames;
  }

  /**
   * This is the setter method this will set the domainNames
   * Fully qualified domain name of the gslb service.
   * @return domainNames
   */
  public GslbService addDomainNamesItem(String domainNamesItem) {
    if (this.domainNames == null) {
      this.domainNames = new ArrayList<String>();
    }
    this.domainNames.add(domainNamesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Response to the client query when the gslb service is down.
   * @return downResponse
   */
  public GslbServiceDownResponse getDownResponse() {
    return downResponse;
  }

  /**
   * This is the setter method to the attribute.
   * Response to the client query when the gslb service is down.
   * @param downResponse set the downResponse.
   */
  public void setDownResponse(GslbServiceDownResponse downResponse) {
    this.downResponse = downResponse;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable or disable the gslb service.
   * If the gslb service is enabled, then the vips are sent in the dns responses based on reachability and configured algorithm.
   * If the gslb service is disabled, then the vips are no longer available in the dns response.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return enabled
   */
  public Boolean getEnabled() {
    return enabled;
  }

  /**
   * This is the setter method to the attribute.
   * Enable or disable the gslb service.
   * If the gslb service is enabled, then the vips are sent in the dns responses based on reachability and configured algorithm.
   * If the gslb service is disabled, then the vips are no longer available in the dns response.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param enabled set the enabled.
   */
  public void setEnabled(Boolean  enabled) {
    this.enabled = enabled;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Select list of pools belonging to this gslb service.
   * @return groups
   */
  public List<GslbPool> getGroups() {
    return groups;
  }

  /**
   * This is the setter method. this will set the groups
   * Select list of pools belonging to this gslb service.
   * @return groups
   */
  public void setGroups(List<GslbPool>  groups) {
    this.groups = groups;
  }

  /**
   * This is the setter method this will set the groups
   * Select list of pools belonging to this gslb service.
   * @return groups
   */
  public GslbService addGroupsItem(GslbPool groupsItem) {
    if (this.groups == null) {
      this.groups = new ArrayList<GslbPool>();
    }
    this.groups.add(groupsItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Verify vs health by applying one or more health monitors.
   * Active monitors generate synthetic traffic from dns service engine and to mark a vs up or down based on the response.
   * It is a reference to an object of type healthmonitor.
   * @return healthMonitorRefs
   */
  public List<String> getHealthMonitorRefs() {
    return healthMonitorRefs;
  }

  /**
   * This is the setter method. this will set the healthMonitorRefs
   * Verify vs health by applying one or more health monitors.
   * Active monitors generate synthetic traffic from dns service engine and to mark a vs up or down based on the response.
   * It is a reference to an object of type healthmonitor.
   * @return healthMonitorRefs
   */
  public void setHealthMonitorRefs(List<String>  healthMonitorRefs) {
    this.healthMonitorRefs = healthMonitorRefs;
  }

  /**
   * This is the setter method this will set the healthMonitorRefs
   * Verify vs health by applying one or more health monitors.
   * Active monitors generate synthetic traffic from dns service engine and to mark a vs up or down based on the response.
   * It is a reference to an object of type healthmonitor.
   * @return healthMonitorRefs
   */
  public GslbService addHealthMonitorRefsItem(String healthMonitorRefsItem) {
    if (this.healthMonitorRefs == null) {
      this.healthMonitorRefs = new ArrayList<String>();
    }
    this.healthMonitorRefs.add(healthMonitorRefsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Health monitor probe can be executed for all the members or it can be executed only for third-party members.
   * This operational mode is useful to reduce the number of health monitor probes in case of a hybrid scenario.
   * In such a case, avi members can have controller derived status while non-avi members can be probed by via health monitor probes in dataplane.
   * Enum options - GSLB_SERVICE_HEALTH_MONITOR_ALL_MEMBERS, GSLB_SERVICE_HEALTH_MONITOR_ONLY_NON_AVI_MEMBERS.
   * Default value when not specified in API or module is interpreted by Avi Controller as GSLB_SERVICE_HEALTH_MONITOR_ALL_MEMBERS.
   * @return healthMonitorScope
   */
  public String getHealthMonitorScope() {
    return healthMonitorScope;
  }

  /**
   * This is the setter method to the attribute.
   * Health monitor probe can be executed for all the members or it can be executed only for third-party members.
   * This operational mode is useful to reduce the number of health monitor probes in case of a hybrid scenario.
   * In such a case, avi members can have controller derived status while non-avi members can be probed by via health monitor probes in dataplane.
   * Enum options - GSLB_SERVICE_HEALTH_MONITOR_ALL_MEMBERS, GSLB_SERVICE_HEALTH_MONITOR_ONLY_NON_AVI_MEMBERS.
   * Default value when not specified in API or module is interpreted by Avi Controller as GSLB_SERVICE_HEALTH_MONITOR_ALL_MEMBERS.
   * @param healthMonitorScope set the healthMonitorScope.
   */
  public void setHealthMonitorScope(String  healthMonitorScope) {
    this.healthMonitorScope = healthMonitorScope;
  }

  /**
   * This is the getter method this will return the attribute value.
   * This field is an internal field and is used in se.
   * Field introduced in 18.2.2.
   * @return hmOff
   */
  public Boolean getHmOff() {
    return hmOff;
  }

  /**
   * This is the setter method to the attribute.
   * This field is an internal field and is used in se.
   * Field introduced in 18.2.2.
   * @param hmOff set the hmOff.
   */
  public void setHmOff(Boolean  hmOff) {
    this.hmOff = hmOff;
  }

  /**
   * This is the getter method this will return the attribute value.
   * This field indicates that this object is replicated across gslb federation.
   * Field introduced in 17.1.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return isFederated
   */
  public Boolean getIsFederated() {
    return isFederated;
  }

  /**
   * This is the setter method to the attribute.
   * This field indicates that this object is replicated across gslb federation.
   * Field introduced in 17.1.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param isFederated set the isFederated.
   */
  public void setIsFederated(Boolean  isFederated) {
    this.isFederated = isFederated;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The minimum number of members to distribute traffic to.
   * Allowed values are 1-65535.
   * Special values are 0 - 'disable'.
   * Field introduced in 17.2.4.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return minMembers
   */
  public Integer getMinMembers() {
    return minMembers;
  }

  /**
   * This is the setter method to the attribute.
   * The minimum number of members to distribute traffic to.
   * Allowed values are 1-65535.
   * Special values are 0 - 'disable'.
   * Field introduced in 17.2.4.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param minMembers set the minMembers.
   */
  public void setMinMembers(Integer  minMembers) {
    this.minMembers = minMembers;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name for the gslb service.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name for the gslb service.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Number of ip addresses of this gslb service to be returned by the dns service.
   * Enter 0 to return all ip addresses.
   * Allowed values are 1-20.
   * Special values are 0- 'return all ip addresses'.
   * @return numDnsIp
   */
  public Integer getNumDnsIp() {
    return numDnsIp;
  }

  /**
   * This is the setter method to the attribute.
   * Number of ip addresses of this gslb service to be returned by the dns service.
   * Enter 0 to return all ip addresses.
   * Allowed values are 1-20.
   * Special values are 0- 'return all ip addresses'.
   * @param numDnsIp set the numDnsIp.
   */
  public void setNumDnsIp(Integer  numDnsIp) {
    this.numDnsIp = numDnsIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The load balancing algorithm will pick a gslb pool within the gslb service list of available pools.
   * Enum options - GSLB_SERVICE_ALGORITHM_PRIORITY, GSLB_SERVICE_ALGORITHM_GEO.
   * Field introduced in 17.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as GSLB_SERVICE_ALGORITHM_PRIORITY.
   * @return poolAlgorithm
   */
  public String getPoolAlgorithm() {
    return poolAlgorithm;
  }

  /**
   * This is the setter method to the attribute.
   * The load balancing algorithm will pick a gslb pool within the gslb service list of available pools.
   * Enum options - GSLB_SERVICE_ALGORITHM_PRIORITY, GSLB_SERVICE_ALGORITHM_GEO.
   * Field introduced in 17.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as GSLB_SERVICE_ALGORITHM_PRIORITY.
   * @param poolAlgorithm set the poolAlgorithm.
   */
  public void setPoolAlgorithm(String  poolAlgorithm) {
    this.poolAlgorithm = poolAlgorithm;
  }

  /**
   * This is the getter method this will return the attribute value.
   * This field indicates that for a cname query, respond with resolved cnames in the additional section with a records.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return resolveCname
   */
  public Boolean getResolveCname() {
    return resolveCname;
  }

  /**
   * This is the setter method to the attribute.
   * This field indicates that for a cname query, respond with resolved cnames in the additional section with a records.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param resolveCname set the resolveCname.
   */
  public void setResolveCname(Boolean  resolveCname) {
    this.resolveCname = resolveCname;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable site-persistence for the gslbservice.
   * Field introduced in 17.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return sitePersistenceEnabled
   */
  public Boolean getSitePersistenceEnabled() {
    return sitePersistenceEnabled;
  }

  /**
   * This is the setter method to the attribute.
   * Enable site-persistence for the gslbservice.
   * Field introduced in 17.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param sitePersistenceEnabled set the sitePersistenceEnabled.
   */
  public void setSitePersistenceEnabled(Boolean  sitePersistenceEnabled) {
    this.sitePersistenceEnabled = sitePersistenceEnabled;
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
   * Ttl value (in seconds) for records served for this gslb service by the dns service.
   * Allowed values are 0-86400.
   * @return ttl
   */
  public Integer getTtl() {
    return ttl;
  }

  /**
   * This is the setter method to the attribute.
   * Ttl value (in seconds) for records served for this gslb service by the dns service.
   * Allowed values are 0-86400.
   * @param ttl set the ttl.
   */
  public void setTtl(Integer  ttl) {
    this.ttl = ttl;
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
   * Use the client ip subnet from the edns option as source ipaddress for client geo-location and consistent hash algorithm.
   * Default is true.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return useEdnsClientSubnet
   */
  public Boolean getUseEdnsClientSubnet() {
    return useEdnsClientSubnet;
  }

  /**
   * This is the setter method to the attribute.
   * Use the client ip subnet from the edns option as source ipaddress for client geo-location and consistent hash algorithm.
   * Default is true.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param useEdnsClientSubnet set the useEdnsClientSubnet.
   */
  public void setUseEdnsClientSubnet(Boolean  useEdnsClientSubnet) {
    this.useEdnsClientSubnet = useEdnsClientSubnet;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Uuid of the gslb service.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the gslb service.
   * @param uuid set the uuid.
   */
  public void setUuid(String  uuid) {
    this.uuid = uuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable wild-card match of fqdn  if an exact match is not found in the dns table, the longest match is chosen by wild-carding the fqdn in the dns
   * request.
   * Default is false.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return wildcardMatch
   */
  public Boolean getWildcardMatch() {
    return wildcardMatch;
  }

  /**
   * This is the setter method to the attribute.
   * Enable wild-card match of fqdn  if an exact match is not found in the dns table, the longest match is chosen by wild-carding the fqdn in the dns
   * request.
   * Default is false.
   * Field introduced in 17.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param wildcardMatch set the wildcardMatch.
   */
  public void setWildcardMatch(Boolean  wildcardMatch) {
    this.wildcardMatch = wildcardMatch;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  GslbService objGslbService = (GslbService) o;
  return   Objects.equals(this.uuid, objGslbService.uuid)&&
  Objects.equals(this.name, objGslbService.name)&&
  Objects.equals(this.domainNames, objGslbService.domainNames)&&
  Objects.equals(this.groups, objGslbService.groups)&&
  Objects.equals(this.numDnsIp, objGslbService.numDnsIp)&&
  Objects.equals(this.ttl, objGslbService.ttl)&&
  Objects.equals(this.downResponse, objGslbService.downResponse)&&
  Objects.equals(this.healthMonitorRefs, objGslbService.healthMonitorRefs)&&
  Objects.equals(this.controllerHealthStatusEnabled, objGslbService.controllerHealthStatusEnabled)&&
  Objects.equals(this.healthMonitorScope, objGslbService.healthMonitorScope)&&
  Objects.equals(this.enabled, objGslbService.enabled)&&
  Objects.equals(this.useEdnsClientSubnet, objGslbService.useEdnsClientSubnet)&&
  Objects.equals(this.wildcardMatch, objGslbService.wildcardMatch)&&
  Objects.equals(this.sitePersistenceEnabled, objGslbService.sitePersistenceEnabled)&&
  Objects.equals(this.applicationPersistenceProfileRef, objGslbService.applicationPersistenceProfileRef)&&
  Objects.equals(this.poolAlgorithm, objGslbService.poolAlgorithm)&&
  Objects.equals(this.minMembers, objGslbService.minMembers)&&
  Objects.equals(this.hmOff, objGslbService.hmOff)&&
  Objects.equals(this.resolveCname, objGslbService.resolveCname)&&
  Objects.equals(this.isFederated, objGslbService.isFederated)&&
  Objects.equals(this.createdBy, objGslbService.createdBy)&&
  Objects.equals(this.description, objGslbService.description)&&
  Objects.equals(this.tenantRef, objGslbService.tenantRef);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class GslbService {\n");
      sb.append("    applicationPersistenceProfileRef: ").append(toIndentedString(applicationPersistenceProfileRef)).append("\n");
        sb.append("    controllerHealthStatusEnabled: ").append(toIndentedString(controllerHealthStatusEnabled)).append("\n");
        sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    domainNames: ").append(toIndentedString(domainNames)).append("\n");
        sb.append("    downResponse: ").append(toIndentedString(downResponse)).append("\n");
        sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
        sb.append("    groups: ").append(toIndentedString(groups)).append("\n");
        sb.append("    healthMonitorRefs: ").append(toIndentedString(healthMonitorRefs)).append("\n");
        sb.append("    healthMonitorScope: ").append(toIndentedString(healthMonitorScope)).append("\n");
        sb.append("    hmOff: ").append(toIndentedString(hmOff)).append("\n");
        sb.append("    isFederated: ").append(toIndentedString(isFederated)).append("\n");
        sb.append("    minMembers: ").append(toIndentedString(minMembers)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    numDnsIp: ").append(toIndentedString(numDnsIp)).append("\n");
        sb.append("    poolAlgorithm: ").append(toIndentedString(poolAlgorithm)).append("\n");
        sb.append("    resolveCname: ").append(toIndentedString(resolveCname)).append("\n");
        sb.append("    sitePersistenceEnabled: ").append(toIndentedString(sitePersistenceEnabled)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
        sb.append("    ttl: ").append(toIndentedString(ttl)).append("\n");
            sb.append("    useEdnsClientSubnet: ").append(toIndentedString(useEdnsClientSubnet)).append("\n");
        sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
        sb.append("    wildcardMatch: ").append(toIndentedString(wildcardMatch)).append("\n");
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

