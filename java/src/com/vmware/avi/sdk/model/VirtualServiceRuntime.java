package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VirtualServiceRuntime is a POJO class extends AviRestResource that used for creating
 * VirtualServiceRuntime.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VirtualServiceRuntime extends AviRestResource  {
    @JsonProperty("apic_extension")
    private VsApicExtension apicExtension = null;

    @JsonProperty("controller_ip")
    private String controllerIp = null;

    @JsonProperty("datapath_debug")
    private DebugVirtualService datapathDebug = null;

    @JsonProperty("east_west")
    private Boolean eastWest = false;

    @JsonProperty("gslb_dns_geo_update")
    private GslbDnsGeoUpdate gslbDnsGeoUpdate = null;

    @JsonProperty("gslb_dns_update")
    private GslbDnsUpdate gslbDnsUpdate = null;

    @JsonProperty("ipam_dns_records")
    private List<DnsRecord> ipamDnsRecords = null;

    @JsonProperty("is_dns_vs")
    private Boolean isDnsVs = false;

    @JsonProperty("key_rotation_count")
    private Integer keyRotationCount = null;

    @JsonProperty("last_changed_time")
    private TimeStamp lastChangedTime = null;

    @JsonProperty("last_key_rotation_time")
    private TimeStamp lastKeyRotationTime = null;

    @JsonProperty("lif")
    private List<String> lif = null;

    @JsonProperty("manual_placement")
    private Boolean manualPlacement = false;

    @JsonProperty("marked_for_delete")
    private Boolean markedForDelete = false;

    @JsonProperty("metrics_mgr_port")
    private String metricsMgrPort = null;

    @JsonProperty("num_additional_se")
    private Integer numAdditionalSe = 0;

    @JsonProperty("one_plus_one_ha")
    private Boolean onePlusOneHa = false;

    @JsonProperty("prev_controller_ip")
    private String prevControllerIp = null;

    @JsonProperty("prev_metrics_mgr_port")
    private String prevMetricsMgrPort = null;

    @JsonProperty("redis_db")
    private Integer redisDb = null;

    @JsonProperty("redis_ip")
    private String redisIp = null;

    @JsonProperty("redis_port")
    private Integer redisPort = null;

    @JsonProperty("rules_configured")
    private Boolean rulesConfigured = true;

    @JsonProperty("sec_mgr_info")
    private SecurityMgrRuntime secMgrInfo = null;

    @JsonProperty("self_se_election")
    private Boolean selfSeElection = false;

    @JsonProperty("servers_configured")
    private Boolean serversConfigured = true;

    @JsonProperty("tls_ticket_key")
    private List<TLSTicket> tlsTicketKey = null;

    @JsonProperty("type")
    private String type = "VS_TYPE_NORMAL";

    @JsonProperty("uuid")
    private String uuid = null;

    @JsonProperty("version")
    private Integer version = 0;

    @JsonProperty("vh_child_vs_ref")
    private List<String> vhChildVsRef = null;

    @JsonProperty("vip_runtime")
    private List<VipRuntime> vipRuntime = null;

    @JsonProperty("vs_update_pending")
    private VirtualService vsUpdatePending = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property apic_extension of obj type virtualserviceruntime field type str  type ref.
   * @return apicExtension
   */
  public VsApicExtension getApicExtension() {
    return apicExtension;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property apic_extension of obj type virtualserviceruntime field type str  type ref.
   * @param apicExtension set the apicExtension.
   */
  public void setApicExtension(VsApicExtension apicExtension) {
    this.apicExtension = apicExtension;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property controller_ip of obj type virtualserviceruntime field type str  type string.
   * @return controllerIp
   */
  public String getControllerIp() {
    return controllerIp;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property controller_ip of obj type virtualserviceruntime field type str  type string.
   * @param controllerIp set the controllerIp.
   */
  public void setControllerIp(String  controllerIp) {
    this.controllerIp = controllerIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property datapath_debug of obj type virtualserviceruntime field type str  type ref.
   * @return datapathDebug
   */
  public DebugVirtualService getDatapathDebug() {
    return datapathDebug;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property datapath_debug of obj type virtualserviceruntime field type str  type ref.
   * @param datapathDebug set the datapathDebug.
   */
  public void setDatapathDebug(DebugVirtualService datapathDebug) {
    this.datapathDebug = datapathDebug;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property east_west of obj type virtualserviceruntime field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return eastWest
   */
  public Boolean getEastWest() {
    return eastWest;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property east_west of obj type virtualserviceruntime field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param eastWest set the eastWest.
   */
  public void setEastWest(Boolean  eastWest) {
    this.eastWest = eastWest;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Deprecated, handled by se datastore.
   * Field deprecated in 18.1.5, 18.2.1.
   * Field introduced in 17.1.1.
   * @return gslbDnsGeoUpdate
   */
  public GslbDnsGeoUpdate getGslbDnsGeoUpdate() {
    return gslbDnsGeoUpdate;
  }

  /**
   * This is the setter method to the attribute.
   * Deprecated, handled by se datastore.
   * Field deprecated in 18.1.5, 18.2.1.
   * Field introduced in 17.1.1.
   * @param gslbDnsGeoUpdate set the gslbDnsGeoUpdate.
   */
  public void setGslbDnsGeoUpdate(GslbDnsGeoUpdate gslbDnsGeoUpdate) {
    this.gslbDnsGeoUpdate = gslbDnsGeoUpdate;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property gslb_dns_update of obj type virtualserviceruntime field type str  type ref.
   * @return gslbDnsUpdate
   */
  public GslbDnsUpdate getGslbDnsUpdate() {
    return gslbDnsUpdate;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property gslb_dns_update of obj type virtualserviceruntime field type str  type ref.
   * @param gslbDnsUpdate set the gslbDnsUpdate.
   */
  public void setGslbDnsUpdate(GslbDnsUpdate gslbDnsUpdate) {
    this.gslbDnsUpdate = gslbDnsUpdate;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ipam_dns_records of obj type virtualserviceruntime field type str  type array.
   * @return ipamDnsRecords
   */
  public List<DnsRecord> getIpamDnsRecords() {
    return ipamDnsRecords;
  }

  /**
   * This is the setter method. this will set the ipamDnsRecords
   * Placeholder for description of property ipam_dns_records of obj type virtualserviceruntime field type str  type array.
   * @return ipamDnsRecords
   */
  public void setIpamDnsRecords(List<DnsRecord>  ipamDnsRecords) {
    this.ipamDnsRecords = ipamDnsRecords;
  }

  /**
   * This is the setter method this will set the ipamDnsRecords
   * Placeholder for description of property ipam_dns_records of obj type virtualserviceruntime field type str  type array.
   * @return ipamDnsRecords
   */
  public VirtualServiceRuntime addIpamDnsRecordsItem(DnsRecord ipamDnsRecordsItem) {
    if (this.ipamDnsRecords == null) {
      this.ipamDnsRecords = new ArrayList<DnsRecord>();
    }
    this.ipamDnsRecords.add(ipamDnsRecordsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property is_dns_vs of obj type virtualserviceruntime field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return isDnsVs
   */
  public Boolean getIsDnsVs() {
    return isDnsVs;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property is_dns_vs of obj type virtualserviceruntime field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param isDnsVs set the isDnsVs.
   */
  public void setIsDnsVs(Boolean  isDnsVs) {
    this.isDnsVs = isDnsVs;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Number of times keys have been rotated.
   * Field introduced in 18.2.2.
   * @return keyRotationCount
   */
  public Integer getKeyRotationCount() {
    return keyRotationCount;
  }

  /**
   * This is the setter method to the attribute.
   * Number of times keys have been rotated.
   * Field introduced in 18.2.2.
   * @param keyRotationCount set the keyRotationCount.
   */
  public void setKeyRotationCount(Integer  keyRotationCount) {
    this.keyRotationCount = keyRotationCount;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property last_changed_time of obj type virtualserviceruntime field type str  type ref.
   * @return lastChangedTime
   */
  public TimeStamp getLastChangedTime() {
    return lastChangedTime;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property last_changed_time of obj type virtualserviceruntime field type str  type ref.
   * @param lastChangedTime set the lastChangedTime.
   */
  public void setLastChangedTime(TimeStamp lastChangedTime) {
    this.lastChangedTime = lastChangedTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Timestamp of the last key rotation.
   * Field introduced in 18.2.2.
   * @return lastKeyRotationTime
   */
  public TimeStamp getLastKeyRotationTime() {
    return lastKeyRotationTime;
  }

  /**
   * This is the setter method to the attribute.
   * Timestamp of the last key rotation.
   * Field introduced in 18.2.2.
   * @param lastKeyRotationTime set the lastKeyRotationTime.
   */
  public void setLastKeyRotationTime(TimeStamp lastKeyRotationTime) {
    this.lastKeyRotationTime = lastKeyRotationTime;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property lif of obj type virtualserviceruntime field type str  type array.
   * @return lif
   */
  public List<String> getLif() {
    return lif;
  }

  /**
   * This is the setter method. this will set the lif
   * Placeholder for description of property lif of obj type virtualserviceruntime field type str  type array.
   * @return lif
   */
  public void setLif(List<String>  lif) {
    this.lif = lif;
  }

  /**
   * This is the setter method this will set the lif
   * Placeholder for description of property lif of obj type virtualserviceruntime field type str  type array.
   * @return lif
   */
  public VirtualServiceRuntime addLifItem(String lifItem) {
    if (this.lif == null) {
      this.lif = new ArrayList<String>();
    }
    this.lif.add(lifItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property manual_placement of obj type virtualserviceruntime field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return manualPlacement
   */
  public Boolean getManualPlacement() {
    return manualPlacement;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property manual_placement of obj type virtualserviceruntime field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param manualPlacement set the manualPlacement.
   */
  public void setManualPlacement(Boolean  manualPlacement) {
    this.manualPlacement = manualPlacement;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property marked_for_delete of obj type virtualserviceruntime field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return markedForDelete
   */
  public Boolean getMarkedForDelete() {
    return markedForDelete;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property marked_for_delete of obj type virtualserviceruntime field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param markedForDelete set the markedForDelete.
   */
  public void setMarkedForDelete(Boolean  markedForDelete) {
    this.markedForDelete = markedForDelete;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - METRICS_MGR_PORT_0, METRICS_MGR_PORT_1, METRICS_MGR_PORT_2, METRICS_MGR_PORT_3.
   * @return metricsMgrPort
   */
  public String getMetricsMgrPort() {
    return metricsMgrPort;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - METRICS_MGR_PORT_0, METRICS_MGR_PORT_1, METRICS_MGR_PORT_2, METRICS_MGR_PORT_3.
   * @param metricsMgrPort set the metricsMgrPort.
   */
  public void setMetricsMgrPort(String  metricsMgrPort) {
    this.metricsMgrPort = metricsMgrPort;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property num_additional_se of obj type virtualserviceruntime field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return numAdditionalSe
   */
  public Integer getNumAdditionalSe() {
    return numAdditionalSe;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property num_additional_se of obj type virtualserviceruntime field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param numAdditionalSe set the numAdditionalSe.
   */
  public void setNumAdditionalSe(Integer  numAdditionalSe) {
    this.numAdditionalSe = numAdditionalSe;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property one_plus_one_ha of obj type virtualserviceruntime field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return onePlusOneHa
   */
  public Boolean getOnePlusOneHa() {
    return onePlusOneHa;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property one_plus_one_ha of obj type virtualserviceruntime field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param onePlusOneHa set the onePlusOneHa.
   */
  public void setOnePlusOneHa(Boolean  onePlusOneHa) {
    this.onePlusOneHa = onePlusOneHa;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property prev_controller_ip of obj type virtualserviceruntime field type str  type string.
   * @return prevControllerIp
   */
  public String getPrevControllerIp() {
    return prevControllerIp;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property prev_controller_ip of obj type virtualserviceruntime field type str  type string.
   * @param prevControllerIp set the prevControllerIp.
   */
  public void setPrevControllerIp(String  prevControllerIp) {
    this.prevControllerIp = prevControllerIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - METRICS_MGR_PORT_0, METRICS_MGR_PORT_1, METRICS_MGR_PORT_2, METRICS_MGR_PORT_3.
   * @return prevMetricsMgrPort
   */
  public String getPrevMetricsMgrPort() {
    return prevMetricsMgrPort;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - METRICS_MGR_PORT_0, METRICS_MGR_PORT_1, METRICS_MGR_PORT_2, METRICS_MGR_PORT_3.
   * @param prevMetricsMgrPort set the prevMetricsMgrPort.
   */
  public void setPrevMetricsMgrPort(String  prevMetricsMgrPort) {
    this.prevMetricsMgrPort = prevMetricsMgrPort;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property redis_db of obj type virtualserviceruntime field type str  type integer.
   * @return redisDb
   */
  public Integer getRedisDb() {
    return redisDb;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property redis_db of obj type virtualserviceruntime field type str  type integer.
   * @param redisDb set the redisDb.
   */
  public void setRedisDb(Integer  redisDb) {
    this.redisDb = redisDb;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field deprecated in 18.1.5, 18.2.1.
   * @return redisIp
   */
  public String getRedisIp() {
    return redisIp;
  }

  /**
   * This is the setter method to the attribute.
   * Field deprecated in 18.1.5, 18.2.1.
   * @param redisIp set the redisIp.
   */
  public void setRedisIp(String  redisIp) {
    this.redisIp = redisIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property redis_port of obj type virtualserviceruntime field type str  type integer.
   * @return redisPort
   */
  public Integer getRedisPort() {
    return redisPort;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property redis_port of obj type virtualserviceruntime field type str  type integer.
   * @param redisPort set the redisPort.
   */
  public void setRedisPort(Integer  redisPort) {
    this.redisPort = redisPort;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field deprecated in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return rulesConfigured
   */
  public Boolean getRulesConfigured() {
    return rulesConfigured;
  }

  /**
   * This is the setter method to the attribute.
   * Field deprecated in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param rulesConfigured set the rulesConfigured.
   */
  public void setRulesConfigured(Boolean  rulesConfigured) {
    this.rulesConfigured = rulesConfigured;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Runtime info from security_manager.
   * Field introduced in 18.2.5.
   * @return secMgrInfo
   */
  public SecurityMgrRuntime getSecMgrInfo() {
    return secMgrInfo;
  }

  /**
   * This is the setter method to the attribute.
   * Runtime info from security_manager.
   * Field introduced in 18.2.5.
   * @param secMgrInfo set the secMgrInfo.
   */
  public void setSecMgrInfo(SecurityMgrRuntime secMgrInfo) {
    this.secMgrInfo = secMgrInfo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable service engines to elect a primary amongst themselves in the absence of connectivity to controller.
   * Field introduced in 18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return selfSeElection
   */
  public Boolean getSelfSeElection() {
    return selfSeElection;
  }

  /**
   * This is the setter method to the attribute.
   * Enable service engines to elect a primary amongst themselves in the absence of connectivity to controller.
   * Field introduced in 18.1.2.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param selfSeElection set the selfSeElection.
   */
  public void setSelfSeElection(Boolean  selfSeElection) {
    this.selfSeElection = selfSeElection;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field deprecated in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return serversConfigured
   */
  public Boolean getServersConfigured() {
    return serversConfigured;
  }

  /**
   * This is the setter method to the attribute.
   * Field deprecated in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param serversConfigured set the serversConfigured.
   */
  public void setServersConfigured(Boolean  serversConfigured) {
    this.serversConfigured = serversConfigured;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property tls_ticket_key of obj type virtualserviceruntime field type str  type array.
   * @return tlsTicketKey
   */
  public List<TLSTicket> getTlsTicketKey() {
    return tlsTicketKey;
  }

  /**
   * This is the setter method. this will set the tlsTicketKey
   * Placeholder for description of property tls_ticket_key of obj type virtualserviceruntime field type str  type array.
   * @return tlsTicketKey
   */
  public void setTlsTicketKey(List<TLSTicket>  tlsTicketKey) {
    this.tlsTicketKey = tlsTicketKey;
  }

  /**
   * This is the setter method this will set the tlsTicketKey
   * Placeholder for description of property tls_ticket_key of obj type virtualserviceruntime field type str  type array.
   * @return tlsTicketKey
   */
  public VirtualServiceRuntime addTlsTicketKeyItem(TLSTicket tlsTicketKeyItem) {
    if (this.tlsTicketKey == null) {
      this.tlsTicketKey = new ArrayList<TLSTicket>();
    }
    this.tlsTicketKey.add(tlsTicketKeyItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - VS_TYPE_NORMAL, VS_TYPE_VH_PARENT, VS_TYPE_VH_CHILD.
   * Default value when not specified in API or module is interpreted by Avi Controller as VS_TYPE_NORMAL.
   * @return type
   */
  public String getType() {
    return type;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - VS_TYPE_NORMAL, VS_TYPE_VH_PARENT, VS_TYPE_VH_CHILD.
   * Default value when not specified in API or module is interpreted by Avi Controller as VS_TYPE_NORMAL.
   * @param type set the type.
   */
  public void setType(String  type) {
    this.type = type;
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

  /**
   * This is the getter method this will return the attribute value.
   * Version number of the se list update.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return version
   */
  public Integer getVersion() {
    return version;
  }

  /**
   * This is the setter method to the attribute.
   * Version number of the se list update.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param version set the version.
   */
  public void setVersion(Integer  version) {
    this.version = version;
  }
  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type virtualservice.
   * @return vhChildVsRef
   */
  public List<String> getVhChildVsRef() {
    return vhChildVsRef;
  }

  /**
   * This is the setter method. this will set the vhChildVsRef
   * It is a reference to an object of type virtualservice.
   * @return vhChildVsRef
   */
  public void setVhChildVsRef(List<String>  vhChildVsRef) {
    this.vhChildVsRef = vhChildVsRef;
  }

  /**
   * This is the setter method this will set the vhChildVsRef
   * It is a reference to an object of type virtualservice.
   * @return vhChildVsRef
   */
  public VirtualServiceRuntime addVhChildVsRefItem(String vhChildVsRefItem) {
    if (this.vhChildVsRef == null) {
      this.vhChildVsRef = new ArrayList<String>();
    }
    this.vhChildVsRef.add(vhChildVsRefItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vip_runtime of obj type virtualserviceruntime field type str  type array.
   * @return vipRuntime
   */
  public List<VipRuntime> getVipRuntime() {
    return vipRuntime;
  }

  /**
   * This is the setter method. this will set the vipRuntime
   * Placeholder for description of property vip_runtime of obj type virtualserviceruntime field type str  type array.
   * @return vipRuntime
   */
  public void setVipRuntime(List<VipRuntime>  vipRuntime) {
    this.vipRuntime = vipRuntime;
  }

  /**
   * This is the setter method this will set the vipRuntime
   * Placeholder for description of property vip_runtime of obj type virtualserviceruntime field type str  type array.
   * @return vipRuntime
   */
  public VirtualServiceRuntime addVipRuntimeItem(VipRuntime vipRuntimeItem) {
    if (this.vipRuntime == null) {
      this.vipRuntime = new ArrayList<VipRuntime>();
    }
    this.vipRuntime.add(vipRuntimeItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Vs update request received before warmstart finished.
   * Field introduced in 18.1.4, 18.2.1.
   * @return vsUpdatePending
   */
  public VirtualService getVsUpdatePending() {
    return vsUpdatePending;
  }

  /**
   * This is the setter method to the attribute.
   * Vs update request received before warmstart finished.
   * Field introduced in 18.1.4, 18.2.1.
   * @param vsUpdatePending set the vsUpdatePending.
   */
  public void setVsUpdatePending(VirtualService vsUpdatePending) {
    this.vsUpdatePending = vsUpdatePending;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VirtualServiceRuntime objVirtualServiceRuntime = (VirtualServiceRuntime) o;
  return   Objects.equals(this.uuid, objVirtualServiceRuntime.uuid)&&
  Objects.equals(this.datapathDebug, objVirtualServiceRuntime.datapathDebug)&&
  Objects.equals(this.serversConfigured, objVirtualServiceRuntime.serversConfigured)&&
  Objects.equals(this.rulesConfigured, objVirtualServiceRuntime.rulesConfigured)&&
  Objects.equals(this.onePlusOneHa, objVirtualServiceRuntime.onePlusOneHa)&&
  Objects.equals(this.apicExtension, objVirtualServiceRuntime.apicExtension)&&
  Objects.equals(this.lastChangedTime, objVirtualServiceRuntime.lastChangedTime)&&
  Objects.equals(this.controllerIp, objVirtualServiceRuntime.controllerIp)&&
  Objects.equals(this.prevControllerIp, objVirtualServiceRuntime.prevControllerIp)&&
  Objects.equals(this.markedForDelete, objVirtualServiceRuntime.markedForDelete)&&
  Objects.equals(this.metricsMgrPort, objVirtualServiceRuntime.metricsMgrPort)&&
  Objects.equals(this.prevMetricsMgrPort, objVirtualServiceRuntime.prevMetricsMgrPort)&&
  Objects.equals(this.manualPlacement, objVirtualServiceRuntime.manualPlacement)&&
  Objects.equals(this.vhChildVsRef, objVirtualServiceRuntime.vhChildVsRef)&&
  Objects.equals(this.redisIp, objVirtualServiceRuntime.redisIp)&&
  Objects.equals(this.redisPort, objVirtualServiceRuntime.redisPort)&&
  Objects.equals(this.redisDb, objVirtualServiceRuntime.redisDb)&&
  Objects.equals(this.tlsTicketKey, objVirtualServiceRuntime.tlsTicketKey)&&
  Objects.equals(this.lif, objVirtualServiceRuntime.lif)&&
  Objects.equals(this.type, objVirtualServiceRuntime.type)&&
  Objects.equals(this.eastWest, objVirtualServiceRuntime.eastWest)&&
  Objects.equals(this.numAdditionalSe, objVirtualServiceRuntime.numAdditionalSe)&&
  Objects.equals(this.gslbDnsUpdate, objVirtualServiceRuntime.gslbDnsUpdate)&&
  Objects.equals(this.isDnsVs, objVirtualServiceRuntime.isDnsVs)&&
  Objects.equals(this.ipamDnsRecords, objVirtualServiceRuntime.ipamDnsRecords)&&
  Objects.equals(this.version, objVirtualServiceRuntime.version)&&
  Objects.equals(this.vipRuntime, objVirtualServiceRuntime.vipRuntime)&&
  Objects.equals(this.gslbDnsGeoUpdate, objVirtualServiceRuntime.gslbDnsGeoUpdate)&&
  Objects.equals(this.selfSeElection, objVirtualServiceRuntime.selfSeElection)&&
  Objects.equals(this.vsUpdatePending, objVirtualServiceRuntime.vsUpdatePending)&&
  Objects.equals(this.keyRotationCount, objVirtualServiceRuntime.keyRotationCount)&&
  Objects.equals(this.lastKeyRotationTime, objVirtualServiceRuntime.lastKeyRotationTime)&&
  Objects.equals(this.secMgrInfo, objVirtualServiceRuntime.secMgrInfo);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VirtualServiceRuntime {\n");
      sb.append("    apicExtension: ").append(toIndentedString(apicExtension)).append("\n");
        sb.append("    controllerIp: ").append(toIndentedString(controllerIp)).append("\n");
        sb.append("    datapathDebug: ").append(toIndentedString(datapathDebug)).append("\n");
        sb.append("    eastWest: ").append(toIndentedString(eastWest)).append("\n");
        sb.append("    gslbDnsGeoUpdate: ").append(toIndentedString(gslbDnsGeoUpdate)).append("\n");
        sb.append("    gslbDnsUpdate: ").append(toIndentedString(gslbDnsUpdate)).append("\n");
        sb.append("    ipamDnsRecords: ").append(toIndentedString(ipamDnsRecords)).append("\n");
        sb.append("    isDnsVs: ").append(toIndentedString(isDnsVs)).append("\n");
        sb.append("    keyRotationCount: ").append(toIndentedString(keyRotationCount)).append("\n");
        sb.append("    lastChangedTime: ").append(toIndentedString(lastChangedTime)).append("\n");
        sb.append("    lastKeyRotationTime: ").append(toIndentedString(lastKeyRotationTime)).append("\n");
        sb.append("    lif: ").append(toIndentedString(lif)).append("\n");
        sb.append("    manualPlacement: ").append(toIndentedString(manualPlacement)).append("\n");
        sb.append("    markedForDelete: ").append(toIndentedString(markedForDelete)).append("\n");
        sb.append("    metricsMgrPort: ").append(toIndentedString(metricsMgrPort)).append("\n");
        sb.append("    numAdditionalSe: ").append(toIndentedString(numAdditionalSe)).append("\n");
        sb.append("    onePlusOneHa: ").append(toIndentedString(onePlusOneHa)).append("\n");
        sb.append("    prevControllerIp: ").append(toIndentedString(prevControllerIp)).append("\n");
        sb.append("    prevMetricsMgrPort: ").append(toIndentedString(prevMetricsMgrPort)).append("\n");
        sb.append("    redisDb: ").append(toIndentedString(redisDb)).append("\n");
        sb.append("    redisIp: ").append(toIndentedString(redisIp)).append("\n");
        sb.append("    redisPort: ").append(toIndentedString(redisPort)).append("\n");
        sb.append("    rulesConfigured: ").append(toIndentedString(rulesConfigured)).append("\n");
        sb.append("    secMgrInfo: ").append(toIndentedString(secMgrInfo)).append("\n");
        sb.append("    selfSeElection: ").append(toIndentedString(selfSeElection)).append("\n");
        sb.append("    serversConfigured: ").append(toIndentedString(serversConfigured)).append("\n");
        sb.append("    tlsTicketKey: ").append(toIndentedString(tlsTicketKey)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
        sb.append("    vhChildVsRef: ").append(toIndentedString(vhChildVsRef)).append("\n");
        sb.append("    vipRuntime: ").append(toIndentedString(vipRuntime)).append("\n");
        sb.append("    vsUpdatePending: ").append(toIndentedString(vsUpdatePending)).append("\n");
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

