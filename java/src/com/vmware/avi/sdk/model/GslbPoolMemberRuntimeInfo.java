package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The GslbPoolMemberRuntimeInfo is a POJO class extends AviRestResource that used for creating
 * GslbPoolMemberRuntimeInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GslbPoolMemberRuntimeInfo  {
    @JsonProperty("app_type")
    private String appType = null;

    @JsonProperty("cluster_uuid")
    private String clusterUuid = null;

    @JsonProperty("controller_status")
    private OperationalStatus controllerStatus = null;

    @JsonProperty("datapath_status")
    private List<GslbPoolMemberDatapathStatus> datapathStatus = null;

    @JsonProperty("fqdn")
    private String fqdn = null;

    @JsonProperty("gs_name")
    private String gsName = null;

    @JsonProperty("gs_uuid")
    private String gsUuid = null;

    @JsonProperty("ip")
    private IpAddr ip = null;

    @JsonProperty("ip_value_to_se")
    private Integer ipValueToSe = null;

    @JsonProperty("ipv6_value_to_se")
    private List<Integer> ipv6ValueToSe = null;

    @JsonProperty("oper_ips")
    private List<IpAddr> operIps = null;

    @JsonProperty("oper_status")
    private OperationalStatus operStatus = null;

    @JsonProperty("services")
    private List<Service> services = null;

    @JsonProperty("site_name")
    private String siteName = null;

    @JsonProperty("sp_pools")
    private List<GslbServiceSitePersistencePool> spPools = null;

    @JsonProperty("vip_type")
    private String vipType = null;

    @JsonProperty("vs_name")
    private String vsName = null;

    @JsonProperty("vs_uuid")
    private String vsUuid = null;

    @JsonProperty("vserver_l4_metrics")
    private VserverL4MetricsObj vserverL4Metrics = null;

    @JsonProperty("vserver_l7_metrics")
    private VserverL7MetricsObj vserverL7Metrics = null;



  /**
   * This is the getter method this will return the attribute value.
   * Application type of the vs.
   * Enum options - APPLICATION_PROFILE_TYPE_L4, APPLICATION_PROFILE_TYPE_HTTP, APPLICATION_PROFILE_TYPE_SYSLOG, APPLICATION_PROFILE_TYPE_DNS,
   * APPLICATION_PROFILE_TYPE_SSL, APPLICATION_PROFILE_TYPE_SIP.
   * Field introduced in 17.2.2.
   * @return appType
   */
  public String getAppType() {
    return appType;
  }

  /**
   * This is the setter method to the attribute.
   * Application type of the vs.
   * Enum options - APPLICATION_PROFILE_TYPE_L4, APPLICATION_PROFILE_TYPE_HTTP, APPLICATION_PROFILE_TYPE_SYSLOG, APPLICATION_PROFILE_TYPE_DNS,
   * APPLICATION_PROFILE_TYPE_SSL, APPLICATION_PROFILE_TYPE_SIP.
   * Field introduced in 17.2.2.
   * @param appType set the appType.
   */
  public void setAppType(String  appType) {
    this.appType = appType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The site controller cluster uuid to which this member belongs.
   * @return clusterUuid
   */
  public String getClusterUuid() {
    return clusterUuid;
  }

  /**
   * This is the setter method to the attribute.
   * The site controller cluster uuid to which this member belongs.
   * @param clusterUuid set the clusterUuid.
   */
  public void setClusterUuid(String  clusterUuid) {
    this.clusterUuid = clusterUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Controller retrieved member status at the site.
   * @return controllerStatus
   */
  public OperationalStatus getControllerStatus() {
    return controllerStatus;
  }

  /**
   * This is the setter method to the attribute.
   * Controller retrieved member status at the site.
   * @param controllerStatus set the controllerStatus.
   */
  public void setControllerStatus(OperationalStatus controllerStatus) {
    this.controllerStatus = controllerStatus;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Dns computed member status from different sites.
   * @return datapathStatus
   */
  public List<GslbPoolMemberDatapathStatus> getDatapathStatus() {
    return datapathStatus;
  }

  /**
   * This is the setter method. this will set the datapathStatus
   * Dns computed member status from different sites.
   * @return datapathStatus
   */
  public void setDatapathStatus(List<GslbPoolMemberDatapathStatus>  datapathStatus) {
    this.datapathStatus = datapathStatus;
  }

  /**
   * This is the setter method this will set the datapathStatus
   * Dns computed member status from different sites.
   * @return datapathStatus
   */
  public GslbPoolMemberRuntimeInfo addDatapathStatusItem(GslbPoolMemberDatapathStatus datapathStatusItem) {
    if (this.datapathStatus == null) {
      this.datapathStatus = new ArrayList<GslbPoolMemberDatapathStatus>();
    }
    this.datapathStatus.add(datapathStatusItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Fqdn address of the member.
   * @return fqdn
   */
  public String getFqdn() {
    return fqdn;
  }

  /**
   * This is the setter method to the attribute.
   * Fqdn address of the member.
   * @param fqdn set the fqdn.
   */
  public void setFqdn(String  fqdn) {
    this.fqdn = fqdn;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property gs_name of obj type gslbpoolmemberruntimeinfo field type str  type string.
   * @return gsName
   */
  public String getGsName() {
    return gsName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property gs_name of obj type gslbpoolmemberruntimeinfo field type str  type string.
   * @param gsName set the gsName.
   */
  public void setGsName(String  gsName) {
    this.gsName = gsName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The gslb service to which this member belongs.
   * @return gsUuid
   */
  public String getGsUuid() {
    return gsUuid;
  }

  /**
   * This is the setter method to the attribute.
   * The gslb service to which this member belongs.
   * @param gsUuid set the gsUuid.
   */
  public void setGsUuid(String  gsUuid) {
    this.gsUuid = gsUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Gslb pool member's configured vip.
   * @return ip
   */
  public IpAddr getIp() {
    return ip;
  }

  /**
   * This is the setter method to the attribute.
   * Gslb pool member's configured vip.
   * @param ip set the ip.
   */
  public void setIp(IpAddr ip) {
    this.ip = ip;
  }

  /**
   * This is the getter method this will return the attribute value.
   * This is an internal field that conveys the ip address from the controller to service engine in binary format.
   * @return ipValueToSe
   */
  public Integer getIpValueToSe() {
    return ipValueToSe;
  }

  /**
   * This is the setter method to the attribute.
   * This is an internal field that conveys the ip address from the controller to service engine in binary format.
   * @param ipValueToSe set the ipValueToSe.
   */
  public void setIpValueToSe(Integer  ipValueToSe) {
    this.ipValueToSe = ipValueToSe;
  }
  /**
   * This is the getter method this will return the attribute value.
   * This is an internal field that conveys the ipv6 address from the controller to service engine in binary format.
   * Field introduced in 18.2.8, 20.1.1.
   * @return ipv6ValueToSe
   */
  public List<Integer> getIpv6ValueToSe() {
    return ipv6ValueToSe;
  }

  /**
   * This is the setter method. this will set the ipv6ValueToSe
   * This is an internal field that conveys the ipv6 address from the controller to service engine in binary format.
   * Field introduced in 18.2.8, 20.1.1.
   * @return ipv6ValueToSe
   */
  public void setIpv6ValueToSe(List<Integer>  ipv6ValueToSe) {
    this.ipv6ValueToSe = ipv6ValueToSe;
  }

  /**
   * This is the setter method this will set the ipv6ValueToSe
   * This is an internal field that conveys the ipv6 address from the controller to service engine in binary format.
   * Field introduced in 18.2.8, 20.1.1.
   * @return ipv6ValueToSe
   */
  public GslbPoolMemberRuntimeInfo addIpv6ValueToSeItem(Integer ipv6ValueToSeItem) {
    if (this.ipv6ValueToSe == null) {
      this.ipv6ValueToSe = new ArrayList<Integer>();
    }
    this.ipv6ValueToSe.add(ipv6ValueToSeItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Operational vips of the member  that can map to multiple vs ip addresses such as private, public and floating addresses.
   * @return operIps
   */
  public List<IpAddr> getOperIps() {
    return operIps;
  }

  /**
   * This is the setter method. this will set the operIps
   * Operational vips of the member  that can map to multiple vs ip addresses such as private, public and floating addresses.
   * @return operIps
   */
  public void setOperIps(List<IpAddr>  operIps) {
    this.operIps = operIps;
  }

  /**
   * This is the setter method this will set the operIps
   * Operational vips of the member  that can map to multiple vs ip addresses such as private, public and floating addresses.
   * @return operIps
   */
  public GslbPoolMemberRuntimeInfo addOperIpsItem(IpAddr operIpsItem) {
    if (this.operIps == null) {
      this.operIps = new ArrayList<IpAddr>();
    }
    this.operIps.add(operIpsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Gslb pool member's consolidated operational status .
   * @return operStatus
   */
  public OperationalStatus getOperStatus() {
    return operStatus;
  }

  /**
   * This is the setter method to the attribute.
   * Gslb pool member's consolidated operational status .
   * @param operStatus set the operStatus.
   */
  public void setOperStatus(OperationalStatus operStatus) {
    this.operStatus = operStatus;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Services configured on the virtual service.
   * @return services
   */
  public List<Service> getServices() {
    return services;
  }

  /**
   * This is the setter method. this will set the services
   * Services configured on the virtual service.
   * @return services
   */
  public void setServices(List<Service>  services) {
    this.services = services;
  }

  /**
   * This is the setter method this will set the services
   * Services configured on the virtual service.
   * @return services
   */
  public GslbPoolMemberRuntimeInfo addServicesItem(Service servicesItem) {
    if (this.services == null) {
      this.services = new ArrayList<Service>();
    }
    this.services.add(servicesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The site 's name is required for event-generation etc.
   * @return siteName
   */
  public String getSiteName() {
    return siteName;
  }

  /**
   * This is the setter method to the attribute.
   * The site 's name is required for event-generation etc.
   * @param siteName set the siteName.
   */
  public void setSiteName(String  siteName) {
    this.siteName = siteName;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Site persistence pools associated with the vs.
   * Field introduced in 17.2.2.
   * @return spPools
   */
  public List<GslbServiceSitePersistencePool> getSpPools() {
    return spPools;
  }

  /**
   * This is the setter method. this will set the spPools
   * Site persistence pools associated with the vs.
   * Field introduced in 17.2.2.
   * @return spPools
   */
  public void setSpPools(List<GslbServiceSitePersistencePool>  spPools) {
    this.spPools = spPools;
  }

  /**
   * This is the setter method this will set the spPools
   * Site persistence pools associated with the vs.
   * Field introduced in 17.2.2.
   * @return spPools
   */
  public GslbPoolMemberRuntimeInfo addSpPoolsItem(GslbServiceSitePersistencePool spPoolsItem) {
    if (this.spPools == null) {
      this.spPools = new ArrayList<GslbServiceSitePersistencePool>();
    }
    this.spPools.add(spPoolsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Describes the vip type  avi or third-party.
   * Enum options - NON_AVI_VIP, AVI_VIP.
   * @return vipType
   */
  public String getVipType() {
    return vipType;
  }

  /**
   * This is the setter method to the attribute.
   * Describes the vip type  avi or third-party.
   * Enum options - NON_AVI_VIP, AVI_VIP.
   * @param vipType set the vipType.
   */
  public void setVipType(String  vipType) {
    this.vipType = vipType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Vs name belonging to this gslb service.
   * @return vsName
   */
  public String getVsName() {
    return vsName;
  }

  /**
   * This is the setter method to the attribute.
   * Vs name belonging to this gslb service.
   * @param vsName set the vsName.
   */
  public void setVsName(String  vsName) {
    this.vsName = vsName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Vs uuid belonging to this gslb service.
   * @return vsUuid
   */
  public String getVsUuid() {
    return vsUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Vs uuid belonging to this gslb service.
   * @param vsUuid set the vsUuid.
   */
  public void setVsUuid(String  vsUuid) {
    this.vsUuid = vsUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Front end l4 metrics of the virtual service.
   * @return vserverL4Metrics
   */
  public VserverL4MetricsObj getVserverL4Metrics() {
    return vserverL4Metrics;
  }

  /**
   * This is the setter method to the attribute.
   * Front end l4 metrics of the virtual service.
   * @param vserverL4Metrics set the vserverL4Metrics.
   */
  public void setVserverL4Metrics(VserverL4MetricsObj vserverL4Metrics) {
    this.vserverL4Metrics = vserverL4Metrics;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Front end l7 metrics of the virtual service.
   * @return vserverL7Metrics
   */
  public VserverL7MetricsObj getVserverL7Metrics() {
    return vserverL7Metrics;
  }

  /**
   * This is the setter method to the attribute.
   * Front end l7 metrics of the virtual service.
   * @param vserverL7Metrics set the vserverL7Metrics.
   */
  public void setVserverL7Metrics(VserverL7MetricsObj vserverL7Metrics) {
    this.vserverL7Metrics = vserverL7Metrics;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  GslbPoolMemberRuntimeInfo objGslbPoolMemberRuntimeInfo = (GslbPoolMemberRuntimeInfo) o;
  return   Objects.equals(this.operStatus, objGslbPoolMemberRuntimeInfo.operStatus)&&
  Objects.equals(this.vserverL7Metrics, objGslbPoolMemberRuntimeInfo.vserverL7Metrics)&&
  Objects.equals(this.ipv6ValueToSe, objGslbPoolMemberRuntimeInfo.ipv6ValueToSe)&&
  Objects.equals(this.gsUuid, objGslbPoolMemberRuntimeInfo.gsUuid)&&
  Objects.equals(this.siteName, objGslbPoolMemberRuntimeInfo.siteName)&&
  Objects.equals(this.vserverL4Metrics, objGslbPoolMemberRuntimeInfo.vserverL4Metrics)&&
  Objects.equals(this.controllerStatus, objGslbPoolMemberRuntimeInfo.controllerStatus)&&
  Objects.equals(this.ip, objGslbPoolMemberRuntimeInfo.ip)&&
  Objects.equals(this.gsName, objGslbPoolMemberRuntimeInfo.gsName)&&
  Objects.equals(this.vipType, objGslbPoolMemberRuntimeInfo.vipType)&&
  Objects.equals(this.vsUuid, objGslbPoolMemberRuntimeInfo.vsUuid)&&
  Objects.equals(this.fqdn, objGslbPoolMemberRuntimeInfo.fqdn)&&
  Objects.equals(this.services, objGslbPoolMemberRuntimeInfo.services)&&
  Objects.equals(this.vsName, objGslbPoolMemberRuntimeInfo.vsName)&&
  Objects.equals(this.ipValueToSe, objGslbPoolMemberRuntimeInfo.ipValueToSe)&&
  Objects.equals(this.spPools, objGslbPoolMemberRuntimeInfo.spPools)&&
  Objects.equals(this.clusterUuid, objGslbPoolMemberRuntimeInfo.clusterUuid)&&
  Objects.equals(this.appType, objGslbPoolMemberRuntimeInfo.appType)&&
  Objects.equals(this.datapathStatus, objGslbPoolMemberRuntimeInfo.datapathStatus)&&
  Objects.equals(this.operIps, objGslbPoolMemberRuntimeInfo.operIps);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class GslbPoolMemberRuntimeInfo {\n");
      sb.append("    appType: ").append(toIndentedString(appType)).append("\n");
        sb.append("    clusterUuid: ").append(toIndentedString(clusterUuid)).append("\n");
        sb.append("    controllerStatus: ").append(toIndentedString(controllerStatus)).append("\n");
        sb.append("    datapathStatus: ").append(toIndentedString(datapathStatus)).append("\n");
        sb.append("    fqdn: ").append(toIndentedString(fqdn)).append("\n");
        sb.append("    gsName: ").append(toIndentedString(gsName)).append("\n");
        sb.append("    gsUuid: ").append(toIndentedString(gsUuid)).append("\n");
        sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
        sb.append("    ipValueToSe: ").append(toIndentedString(ipValueToSe)).append("\n");
        sb.append("    ipv6ValueToSe: ").append(toIndentedString(ipv6ValueToSe)).append("\n");
        sb.append("    operIps: ").append(toIndentedString(operIps)).append("\n");
        sb.append("    operStatus: ").append(toIndentedString(operStatus)).append("\n");
        sb.append("    services: ").append(toIndentedString(services)).append("\n");
        sb.append("    siteName: ").append(toIndentedString(siteName)).append("\n");
        sb.append("    spPools: ").append(toIndentedString(spPools)).append("\n");
        sb.append("    vipType: ").append(toIndentedString(vipType)).append("\n");
        sb.append("    vsName: ").append(toIndentedString(vsName)).append("\n");
        sb.append("    vsUuid: ").append(toIndentedString(vsUuid)).append("\n");
        sb.append("    vserverL4Metrics: ").append(toIndentedString(vserverL4Metrics)).append("\n");
        sb.append("    vserverL7Metrics: ").append(toIndentedString(vserverL7Metrics)).append("\n");
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

