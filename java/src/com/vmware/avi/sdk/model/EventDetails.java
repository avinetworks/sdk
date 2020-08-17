package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The EventDetails is a POJO class extends AviRestResource that used for creating
 * EventDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventDetails  {
    @JsonProperty("add_networks_details")
    private RmAddNetworksEventDetails addNetworksDetails = null;

    @JsonProperty("albservices_case_details")
    private ALBServicesCase albservicesCaseDetails = null;

    @JsonProperty("albservices_file_upload_details")
    private ALBServicesFileUpload albservicesFileUploadDetails = null;

    @JsonProperty("albservices_status_details")
    private ALBServicesStatusDetails albservicesStatusDetails = null;

    @JsonProperty("all_seupgrade_event_details")
    private AllSeUpgradeEventDetails allSeupgradeEventDetails = null;

    @JsonProperty("anomaly_details")
    private AnomalyEventDetails anomalyDetails = null;

    @JsonProperty("apic_agent_bd_vrf_details")
    private ApicAgentBridgeDomainVrfChange apicAgentBdVrfDetails = null;

    @JsonProperty("apic_agent_generic_details")
    private ApicAgentGenericEventDetails apicAgentGenericDetails = null;

    @JsonProperty("apic_agent_vs_network_error")
    private ApicAgentVsNetworkError apicAgentVsNetworkError = null;

    @JsonProperty("avg_uptime_change_details")
    private AvgUptimeChangeDetails avgUptimeChangeDetails = null;

    @JsonProperty("aws_asg_deletion_details")
    private AWSASGDelete awsAsgDeletionDetails = null;

    @JsonProperty("aws_asg_notif_details")
    private AWSASGNotifDetails awsAsgNotifDetails = null;

    @JsonProperty("aws_infra_details")
    private AWSSetup awsInfraDetails = null;

    @JsonProperty("azure_info")
    private AzureSetup azureInfo = null;

    @JsonProperty("azure_mp_info")
    private AzureMarketplace azureMpInfo = null;

    @JsonProperty("bind_vs_se_details")
    private RmBindVsSeEventDetails bindVsSeDetails = null;

    @JsonProperty("bm_infra_details")
    private BMSetup bmInfraDetails = null;

    @JsonProperty("bootup_fail_details")
    private RmSeBootupFailEventDetails bootupFailDetails = null;

    @JsonProperty("burst_checkout_details")
    private BurstLicenseDetails burstCheckoutDetails = null;

    @JsonProperty("cc_cluster_vip_details")
    private CloudClusterVip ccClusterVipDetails = null;

    @JsonProperty("cc_dns_update_details")
    private CloudDnsUpdate ccDnsUpdateDetails = null;

    @JsonProperty("cc_health_details")
    private CloudHealth ccHealthDetails = null;

    @JsonProperty("cc_infra_details")
    private CloudGeneric ccInfraDetails = null;

    @JsonProperty("cc_ip_details")
    private CloudIpChange ccIpDetails = null;

    @JsonProperty("cc_parkintf_details")
    private CloudVipParkingIntf ccParkintfDetails = null;

    @JsonProperty("cc_scaleset_notif_details")
    private CCScaleSetNotifDetails ccScalesetNotifDetails = null;

    @JsonProperty("cc_se_vm_details")
    private CloudSeVmChange ccSeVmDetails = null;

    @JsonProperty("cc_sync_services_details")
    private CloudSyncServices ccSyncServicesDetails = null;

    @JsonProperty("cc_tenant_del_details")
    private CloudTenantsDeleted ccTenantDelDetails = null;

    @JsonProperty("cc_vip_update_details")
    private CloudVipUpdate ccVipUpdateDetails = null;

    @JsonProperty("cc_vnic_details")
    private CloudVnicChange ccVnicDetails = null;

    @JsonProperty("cloud_asg_notif_details")
    private CloudASGNotifDetails cloudAsgNotifDetails = null;

    @JsonProperty("cloud_autoscaling_config_failure_details")
    private CloudAutoscalingConfigFailureDetails cloudAutoscalingConfigFailureDetails = null;

    @JsonProperty("cluster_config_failed_details")
    private ClusterConfigFailedEvent clusterConfigFailedDetails = null;

    @JsonProperty("cluster_leader_failover_details")
    private ClusterLeaderFailoverEvent clusterLeaderFailoverDetails = null;

    @JsonProperty("cluster_node_add_details")
    private ClusterNodeAddEvent clusterNodeAddDetails = null;

    @JsonProperty("cluster_node_db_failed_details")
    private ClusterNodeDbFailedEvent clusterNodeDbFailedDetails = null;

    @JsonProperty("cluster_node_remove_details")
    private ClusterNodeRemoveEvent clusterNodeRemoveDetails = null;

    @JsonProperty("cluster_node_shutdown_details")
    private ClusterNodeShutdownEvent clusterNodeShutdownDetails = null;

    @JsonProperty("cluster_node_started_details")
    private ClusterNodeStartedEvent clusterNodeStartedDetails = null;

    @JsonProperty("cluster_service_critical_failure_details")
    private ClusterServiceCriticalFailureEvent clusterServiceCriticalFailureDetails = null;

    @JsonProperty("cluster_service_failed_details")
    private ClusterServiceFailedEvent clusterServiceFailedDetails = null;

    @JsonProperty("cluster_service_restored_details")
    private ClusterServiceRestoredEvent clusterServiceRestoredDetails = null;

    @JsonProperty("cntlr_host_list_details")
    private VinfraCntlrHostUnreachableList cntlrHostListDetails = null;

    @JsonProperty("config_action_details")
    private ConfigActionDetails configActionDetails = null;

    @JsonProperty("config_create_details")
    private ConfigCreateDetails configCreateDetails = null;

    @JsonProperty("config_delete_details")
    private ConfigDeleteDetails configDeleteDetails = null;

    @JsonProperty("config_password_change_request_details")
    private ConfigUserPasswordChangeRequest configPasswordChangeRequestDetails = null;

    @JsonProperty("config_se_grp_flv_update_details")
    private ConfigSeGrpFlvUpdate configSeGrpFlvUpdateDetails = null;

    @JsonProperty("config_update_details")
    private ConfigUpdateDetails configUpdateDetails = null;

    @JsonProperty("config_user_authrz_rule_details")
    private ConfigUserAuthrzByRule configUserAuthrzRuleDetails = null;

    @JsonProperty("config_user_login_details")
    private ConfigUserLogin configUserLoginDetails = null;

    @JsonProperty("config_user_logout_details")
    private ConfigUserLogout configUserLogoutDetails = null;

    @JsonProperty("config_user_not_authrz_rule_details")
    private ConfigUserNotAuthrzByRule configUserNotAuthrzRuleDetails = null;

    @JsonProperty("container_cloud_batch_setup")
    private ContainerCloudBatchSetup containerCloudBatchSetup = null;

    @JsonProperty("container_cloud_setup")
    private ContainerCloudSetup containerCloudSetup = null;

    @JsonProperty("container_cloud_sevice")
    private ContainerCloudService containerCloudSevice = null;

    @JsonProperty("controller_license_reconcile_details")
    private ControllerLicenseReconcileDetails controllerLicenseReconcileDetails = null;

    @JsonProperty("crs_deployment_failure")
    private CRSDeploymentFailure crsDeploymentFailure = null;

    @JsonProperty("crs_deployment_success")
    private CRSDeploymentSuccess crsDeploymentSuccess = null;

    @JsonProperty("crs_details")
    private CRSDetails crsDetails = null;

    @JsonProperty("crs_update_details")
    private CRSUpdateDetails crsUpdateDetails = null;

    @JsonProperty("cs_infra_details")
    private CloudStackSetup csInfraDetails = null;

    @JsonProperty("delete_se_details")
    private RmDeleteSeEventDetails deleteSeDetails = null;

    @JsonProperty("disable_se_migrate_details")
    private DisableSeMigrateEventDetails disableSeMigrateDetails = null;

    @JsonProperty("disc_summary")
    private VinfraDiscSummaryDetails discSummary = null;

    @JsonProperty("dns_sync_info")
    private DNSVsSyncInfo dnsSyncInfo = null;

    @JsonProperty("docker_ucp_details")
    private DockerUCPSetup dockerUcpDetails = null;

    @JsonProperty("dos_attack_event_details")
    private DosAttackEventDetails dosAttackEventDetails = null;

    @JsonProperty("gcp_cloud_router_info")
    private GCPCloudRouterUpdate gcpCloudRouterInfo = null;

    @JsonProperty("gcp_info")
    private GCPSetup gcpInfo = null;

    @JsonProperty("glb_info")
    private GslbStatus glbInfo = null;

    @JsonProperty("gs_info")
    private GslbServiceStatus gsInfo = null;

    @JsonProperty("host_unavail_details")
    private HostUnavailEventDetails hostUnavailDetails = null;

    @JsonProperty("hs_details")
    private HealthScoreDetails hsDetails = null;

    @JsonProperty("ip_fail_details")
    private RmSeIpFailEventDetails ipFailDetails = null;

    @JsonProperty("ip_threat_db_event_data")
    private IPThreatDBEventData ipThreatDbEventData = null;

    @JsonProperty("license_details")
    private LicenseDetails licenseDetails = null;

    @JsonProperty("license_expiry_details")
    private LicenseExpiryDetails licenseExpiryDetails = null;

    @JsonProperty("license_transaction_details")
    private LicenseTransactionDetails licenseTransactionDetails = null;

    @JsonProperty("marathon_service_port_conflict_details")
    private MarathonServicePortConflict marathonServicePortConflictDetails = null;

    @JsonProperty("memory_balancer_info")
    private MemoryBalancerInfo memoryBalancerInfo = null;

    @JsonProperty("mesos_infra_details")
    private MesosSetup mesosInfraDetails = null;

    @JsonProperty("metric_threshold_up_details")
    private MetricThresoldUpDetails metricThresholdUpDetails = null;

    @JsonProperty("metrics_db_disk_details")
    private MetricsDbDiskEventDetails metricsDbDiskDetails = null;

    @JsonProperty("metrics_db_queue_full_details")
    private MetricsDbQueueFullEventDetails metricsDbQueueFullDetails = null;

    @JsonProperty("metrics_db_queue_healthy_details")
    private MetricsDbQueueHealthyEventDetails metricsDbQueueHealthyDetails = null;

    @JsonProperty("mgmt_nw_change_details")
    private VinfraMgmtNwChangeDetails mgmtNwChangeDetails = null;

    @JsonProperty("modify_networks_details")
    private RmModifyNetworksEventDetails modifyNetworksDetails = null;

    @JsonProperty("network_subnet_details")
    private NetworkSubnetInfo networkSubnetDetails = null;

    @JsonProperty("nsxt_img_details")
    private NsxtImageDetails nsxtImgDetails = null;

    @JsonProperty("nsxt_info")
    private NsxtSetup nsxtInfo = null;

    @JsonProperty("nw_subnet_clash_details")
    private NetworkSubnetClash nwSubnetClashDetails = null;

    @JsonProperty("nw_summarized_details")
    private SummarizedInfo nwSummarizedDetails = null;

    @JsonProperty("oci_info")
    private OCISetup ociInfo = null;

    @JsonProperty("os_api_ver_check_failure")
    private OpenStackApiVersionCheckFailure osApiVerCheckFailure = null;

    @JsonProperty("os_infra_details")
    private OpenStackClusterSetup osInfraDetails = null;

    @JsonProperty("os_ip_details")
    private OpenStackIpChange osIpDetails = null;

    @JsonProperty("os_lbaudit_details")
    private OpenStackLbProvAuditCheck osLbauditDetails = null;

    @JsonProperty("os_lbplugin_op_details")
    private OpenStackLbPluginOp osLbpluginOpDetails = null;

    @JsonProperty("os_se_vm_details")
    private OpenStackSeVmChange osSeVmDetails = null;

    @JsonProperty("os_sync_services_details")
    private OpenStackSyncServices osSyncServicesDetails = null;

    @JsonProperty("os_vnic_details")
    private OpenStackVnicChange osVnicDetails = null;

    @JsonProperty("pool_deployment_failure_info")
    private PoolDeploymentFailureInfo poolDeploymentFailureInfo = null;

    @JsonProperty("pool_deployment_success_info")
    private PoolDeploymentSuccessInfo poolDeploymentSuccessInfo = null;

    @JsonProperty("pool_deployment_update_info")
    private PoolDeploymentUpdateInfo poolDeploymentUpdateInfo = null;

    @JsonProperty("pool_server_delete_details")
    private VinfraPoolServerDeleteDetails poolServerDeleteDetails = null;

    @JsonProperty("psm_program_details")
    private PsmProgramDetails psmProgramDetails = null;

    @JsonProperty("rate_limiter_event_details")
    private RateLimiterEventDetails rateLimiterEventDetails = null;

    @JsonProperty("rebalance_migrate_details")
    private RebalanceMigrateEventDetails rebalanceMigrateDetails = null;

    @JsonProperty("rebalance_scalein_details")
    private RebalanceScaleinEventDetails rebalanceScaleinDetails = null;

    @JsonProperty("rebalance_scaleout_details")
    private RebalanceScaleoutEventDetails rebalanceScaleoutDetails = null;

    @JsonProperty("reboot_se_details")
    private RmRebootSeEventDetails rebootSeDetails = null;

    @JsonProperty("scheduler_action_info")
    private SchedulerActionDetails schedulerActionInfo = null;

    @JsonProperty("se_bgp_peer_down_details")
    private SeBgpPeerDownDetails seBgpPeerDownDetails = null;

    @JsonProperty("se_bgp_peer_state_change_details")
    private SeBgpPeerStateChangeDetails seBgpPeerStateChangeDetails = null;

    @JsonProperty("se_details")
    private SeMgrEventDetails seDetails = null;

    @JsonProperty("se_dupip_event_details")
    private SeDupipEventDetails seDupipEventDetails = null;

    @JsonProperty("se_gateway_heartbeat_failed_details")
    private SeGatewayHeartbeatFailedDetails seGatewayHeartbeatFailedDetails = null;

    @JsonProperty("se_gateway_heartbeat_success_details")
    private SeGatewayHeartbeatSuccessDetails seGatewayHeartbeatSuccessDetails = null;

    @JsonProperty("se_geo_db_details")
    private SeGeoDbDetails seGeoDbDetails = null;

    @JsonProperty("se_hb_event_details")
    private SeHBEventDetails seHbEventDetails = null;

    @JsonProperty("se_hb_recovered_event_details")
    private SeHbRecoveredEventDetails seHbRecoveredEventDetails = null;

    @JsonProperty("se_hm_gs_details")
    private SeHmEventGSDetails seHmGsDetails = null;

    @JsonProperty("se_hm_gsgroup_details")
    private SeHmEventGslbPoolDetails seHmGsgroupDetails = null;

    @JsonProperty("se_hm_pool_details")
    private SeHmEventPoolDetails seHmPoolDetails = null;

    @JsonProperty("se_hm_vs_details")
    private SeHmEventVsDetails seHmVsDetails = null;

    @JsonProperty("se_ip6_dad_failed_event_details")
    private SeIP6DadFailedEventDetails seIp6DadFailedEventDetails = null;

    @JsonProperty("se_ip_added_event_details")
    private SeIpAddedEventDetails seIpAddedEventDetails = null;

    @JsonProperty("se_ip_removed_event_details")
    private SeIpRemovedEventDetails seIpRemovedEventDetails = null;

    @JsonProperty("se_ipfailure_event_details")
    private SeIpfailureEventDetails seIpfailureEventDetails = null;

    @JsonProperty("se_licensed_bandwdith_exceeded_event_details")
    private SeLicensedBandwdithExceededEventDetails seLicensedBandwdithExceededEventDetails = null;

    @JsonProperty("se_memory_limit_event_details")
    private SeMemoryLimitEventDetails seMemoryLimitEventDetails = null;

    @JsonProperty("se_persistence_details")
    private SePersistenceEventDetails sePersistenceDetails = null;

    @JsonProperty("se_pool_lb_details")
    private SePoolLbEventDetails sePoolLbDetails = null;

    @JsonProperty("se_reconcile_details")
    private SeReconcileDetails seReconcileDetails = null;

    @JsonProperty("se_thresh_event_details")
    private SeThreshEventDetails seThreshEventDetails = null;

    @JsonProperty("se_version_check_details")
    private SeVersionCheckFailedEvent seVersionCheckDetails = null;

    @JsonProperty("se_vnic_down_event_details")
    private SeVnicDownEventDetails seVnicDownEventDetails = null;

    @JsonProperty("se_vnic_tx_queue_stall_event_details")
    private SeVnicTxQueueStallEventDetails seVnicTxQueueStallEventDetails = null;

    @JsonProperty("se_vnic_up_event_details")
    private SeVnicUpEventDetails seVnicUpEventDetails = null;

    @JsonProperty("se_vs_fault_event_details")
    private SeVsFaultEventDetails seVsFaultEventDetails = null;

    @JsonProperty("sec_mgr_data_event")
    private SecMgrDataEvent secMgrDataEvent = null;

    @JsonProperty("semigrate_event_details")
    private SeMigrateEventDetails semigrateEventDetails = null;

    @JsonProperty("server_autoscale_failed_info")
    private ServerAutoScaleFailedInfo serverAutoscaleFailedInfo = null;

    @JsonProperty("server_autoscalein_complete_info")
    private ServerAutoScaleInCompleteInfo serverAutoscaleinCompleteInfo = null;

    @JsonProperty("server_autoscalein_info")
    private ServerAutoScaleInInfo serverAutoscaleinInfo = null;

    @JsonProperty("server_autoscaleout_complete_info")
    private ServerAutoScaleOutCompleteInfo serverAutoscaleoutCompleteInfo = null;

    @JsonProperty("server_autoscaleout_info")
    private ServerAutoScaleOutInfo serverAutoscaleoutInfo = null;

    @JsonProperty("seupgrade_disrupted_details")
    private SeUpgradeVsDisruptedEventDetails seupgradeDisruptedDetails = null;

    @JsonProperty("seupgrade_event_details")
    private SeUpgradeEventDetails seupgradeEventDetails = null;

    @JsonProperty("seupgrade_migrate_details")
    private SeUpgradeMigrateEventDetails seupgradeMigrateDetails = null;

    @JsonProperty("seupgrade_scalein_details")
    private SeUpgradeScaleinEventDetails seupgradeScaleinDetails = null;

    @JsonProperty("seupgrade_scaleout_details")
    private SeUpgradeScaleoutEventDetails seupgradeScaleoutDetails = null;

    @JsonProperty("spawn_se_details")
    private RmSpawnSeEventDetails spawnSeDetails = null;

    @JsonProperty("ssl_expire_details")
    private SSLExpireDetails sslExpireDetails = null;

    @JsonProperty("ssl_export_details")
    private SSLExportDetails sslExportDetails = null;

    @JsonProperty("ssl_ignored_details")
    private SSLIgnoredDetails sslIgnoredDetails = null;

    @JsonProperty("ssl_renew_details")
    private SSLRenewDetails sslRenewDetails = null;

    @JsonProperty("ssl_renew_failed_details")
    private SSLRenewFailedDetails sslRenewFailedDetails = null;

    @JsonProperty("ssl_revoked_details")
    private SSLRevokedDetails sslRevokedDetails = null;

    @JsonProperty("switchover_details")
    private SwitchoverEventDetails switchoverDetails = null;

    @JsonProperty("switchover_fail_details")
    private SwitchoverFailEventDetails switchoverFailDetails = null;

    @JsonProperty("sync_services_info")
    private CloudSyncServices syncServicesInfo = null;

    @JsonProperty("system_upgrade_details")
    private SystemUpgradeDetails systemUpgradeDetails = null;

    @JsonProperty("tencent_info")
    private TencentSetup tencentInfo = null;

    @JsonProperty("unbind_vs_se_details")
    private RmUnbindVsSeEventDetails unbindVsSeDetails = null;

    @JsonProperty("upgrade_entry")
    private UpgradeOpsEntry upgradeEntry = null;

    @JsonProperty("upgrade_status_info")
    private UpgradeStatusInfo upgradeStatusInfo = null;

    @JsonProperty("vca_infra_details")
    private VCASetup vcaInfraDetails = null;

    @JsonProperty("vcenter_connectivity_status")
    private VinfraVcenterConnectivityStatus vcenterConnectivityStatus = null;

    @JsonProperty("vcenter_details")
    private VinfraVcenterBadCredentials vcenterDetails = null;

    @JsonProperty("vcenter_disc_failure")
    private VinfraVcenterDiscoveryFailure vcenterDiscFailure = null;

    @JsonProperty("vcenter_network_limit")
    private VinfraVcenterNetworkLimit vcenterNetworkLimit = null;

    @JsonProperty("vcenter_obj_delete_details")
    private VinfraVcenterObjDeleteDetails vcenterObjDeleteDetails = null;

    @JsonProperty("vip_autoscale")
    private VipScaleDetails vipAutoscale = null;

    @JsonProperty("vip_dns_info")
    private DNSRegisterInfo vipDnsInfo = null;

    @JsonProperty("vm_details")
    private VinfraVmDetails vmDetails = null;

    @JsonProperty("vs_awaitingse_details")
    private VsAwaitingSeEventDetails vsAwaitingseDetails = null;

    @JsonProperty("vs_error_details")
    private VsErrorEventDetails vsErrorDetails = null;

    @JsonProperty("vs_fsm_details")
    private VsFsmEventDetails vsFsmDetails = null;

    @JsonProperty("vs_initialplacement_details")
    private VsInitialPlacementEventDetails vsInitialplacementDetails = null;

    @JsonProperty("vs_migrate_details")
    private VsMigrateEventDetails vsMigrateDetails = null;

    @JsonProperty("vs_pool_nw_fltr_details")
    private VsPoolNwFilterEventDetails vsPoolNwFltrDetails = null;

    @JsonProperty("vs_scalein_details")
    private VsScaleInEventDetails vsScaleinDetails = null;

    @JsonProperty("vs_scaleout_details")
    private VsScaleOutEventDetails vsScaleoutDetails = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property add_networks_details of obj type eventdetails field type str  type ref.
   * @return addNetworksDetails
   */
  public RmAddNetworksEventDetails getAddNetworksDetails() {
    return addNetworksDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property add_networks_details of obj type eventdetails field type str  type ref.
   * @param addNetworksDetails set the addNetworksDetails.
   */
  public void setAddNetworksDetails(RmAddNetworksEventDetails addNetworksDetails) {
    this.addNetworksDetails = addNetworksDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property albservices_case_details of obj type eventdetails field type str  type ref.
   * @return albservicesCaseDetails
   */
  public ALBServicesCase getAlbservicesCaseDetails() {
    return albservicesCaseDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property albservices_case_details of obj type eventdetails field type str  type ref.
   * @param albservicesCaseDetails set the albservicesCaseDetails.
   */
  public void setAlbservicesCaseDetails(ALBServicesCase albservicesCaseDetails) {
    this.albservicesCaseDetails = albservicesCaseDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property albservices_file_upload_details of obj type eventdetails field type str  type ref.
   * @return albservicesFileUploadDetails
   */
  public ALBServicesFileUpload getAlbservicesFileUploadDetails() {
    return albservicesFileUploadDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property albservices_file_upload_details of obj type eventdetails field type str  type ref.
   * @param albservicesFileUploadDetails set the albservicesFileUploadDetails.
   */
  public void setAlbservicesFileUploadDetails(ALBServicesFileUpload albservicesFileUploadDetails) {
    this.albservicesFileUploadDetails = albservicesFileUploadDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property albservices_status_details of obj type eventdetails field type str  type ref.
   * @return albservicesStatusDetails
   */
  public ALBServicesStatusDetails getAlbservicesStatusDetails() {
    return albservicesStatusDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property albservices_status_details of obj type eventdetails field type str  type ref.
   * @param albservicesStatusDetails set the albservicesStatusDetails.
   */
  public void setAlbservicesStatusDetails(ALBServicesStatusDetails albservicesStatusDetails) {
    this.albservicesStatusDetails = albservicesStatusDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property all_seupgrade_event_details of obj type eventdetails field type str  type ref.
   * @return allSeupgradeEventDetails
   */
  public AllSeUpgradeEventDetails getAllSeupgradeEventDetails() {
    return allSeupgradeEventDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property all_seupgrade_event_details of obj type eventdetails field type str  type ref.
   * @param allSeupgradeEventDetails set the allSeupgradeEventDetails.
   */
  public void setAllSeupgradeEventDetails(AllSeUpgradeEventDetails allSeupgradeEventDetails) {
    this.allSeupgradeEventDetails = allSeupgradeEventDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property anomaly_details of obj type eventdetails field type str  type ref.
   * @return anomalyDetails
   */
  public AnomalyEventDetails getAnomalyDetails() {
    return anomalyDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property anomaly_details of obj type eventdetails field type str  type ref.
   * @param anomalyDetails set the anomalyDetails.
   */
  public void setAnomalyDetails(AnomalyEventDetails anomalyDetails) {
    this.anomalyDetails = anomalyDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property apic_agent_bd_vrf_details of obj type eventdetails field type str  type ref.
   * @return apicAgentBdVrfDetails
   */
  public ApicAgentBridgeDomainVrfChange getApicAgentBdVrfDetails() {
    return apicAgentBdVrfDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property apic_agent_bd_vrf_details of obj type eventdetails field type str  type ref.
   * @param apicAgentBdVrfDetails set the apicAgentBdVrfDetails.
   */
  public void setApicAgentBdVrfDetails(ApicAgentBridgeDomainVrfChange apicAgentBdVrfDetails) {
    this.apicAgentBdVrfDetails = apicAgentBdVrfDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property apic_agent_generic_details of obj type eventdetails field type str  type ref.
   * @return apicAgentGenericDetails
   */
  public ApicAgentGenericEventDetails getApicAgentGenericDetails() {
    return apicAgentGenericDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property apic_agent_generic_details of obj type eventdetails field type str  type ref.
   * @param apicAgentGenericDetails set the apicAgentGenericDetails.
   */
  public void setApicAgentGenericDetails(ApicAgentGenericEventDetails apicAgentGenericDetails) {
    this.apicAgentGenericDetails = apicAgentGenericDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property apic_agent_vs_network_error of obj type eventdetails field type str  type ref.
   * @return apicAgentVsNetworkError
   */
  public ApicAgentVsNetworkError getApicAgentVsNetworkError() {
    return apicAgentVsNetworkError;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property apic_agent_vs_network_error of obj type eventdetails field type str  type ref.
   * @param apicAgentVsNetworkError set the apicAgentVsNetworkError.
   */
  public void setApicAgentVsNetworkError(ApicAgentVsNetworkError apicAgentVsNetworkError) {
    this.apicAgentVsNetworkError = apicAgentVsNetworkError;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property avg_uptime_change_details of obj type eventdetails field type str  type ref.
   * @return avgUptimeChangeDetails
   */
  public AvgUptimeChangeDetails getAvgUptimeChangeDetails() {
    return avgUptimeChangeDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property avg_uptime_change_details of obj type eventdetails field type str  type ref.
   * @param avgUptimeChangeDetails set the avgUptimeChangeDetails.
   */
  public void setAvgUptimeChangeDetails(AvgUptimeChangeDetails avgUptimeChangeDetails) {
    this.avgUptimeChangeDetails = avgUptimeChangeDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.2.10,18.1.2.
   * @return awsAsgDeletionDetails
   */
  public AWSASGDelete getAwsAsgDeletionDetails() {
    return awsAsgDeletionDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.2.10,18.1.2.
   * @param awsAsgDeletionDetails set the awsAsgDeletionDetails.
   */
  public void setAwsAsgDeletionDetails(AWSASGDelete awsAsgDeletionDetails) {
    this.awsAsgDeletionDetails = awsAsgDeletionDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property aws_asg_notif_details of obj type eventdetails field type str  type ref.
   * @return awsAsgNotifDetails
   */
  public AWSASGNotifDetails getAwsAsgNotifDetails() {
    return awsAsgNotifDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property aws_asg_notif_details of obj type eventdetails field type str  type ref.
   * @param awsAsgNotifDetails set the awsAsgNotifDetails.
   */
  public void setAwsAsgNotifDetails(AWSASGNotifDetails awsAsgNotifDetails) {
    this.awsAsgNotifDetails = awsAsgNotifDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property aws_infra_details of obj type eventdetails field type str  type ref.
   * @return awsInfraDetails
   */
  public AWSSetup getAwsInfraDetails() {
    return awsInfraDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property aws_infra_details of obj type eventdetails field type str  type ref.
   * @param awsInfraDetails set the awsInfraDetails.
   */
  public void setAwsInfraDetails(AWSSetup awsInfraDetails) {
    this.awsInfraDetails = awsInfraDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property azure_info of obj type eventdetails field type str  type ref.
   * @return azureInfo
   */
  public AzureSetup getAzureInfo() {
    return azureInfo;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property azure_info of obj type eventdetails field type str  type ref.
   * @param azureInfo set the azureInfo.
   */
  public void setAzureInfo(AzureSetup azureInfo) {
    this.azureInfo = azureInfo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Azure marketplace license term acceptance event.
   * Field introduced in 18.2.2.
   * @return azureMpInfo
   */
  public AzureMarketplace getAzureMpInfo() {
    return azureMpInfo;
  }

  /**
   * This is the setter method to the attribute.
   * Azure marketplace license term acceptance event.
   * Field introduced in 18.2.2.
   * @param azureMpInfo set the azureMpInfo.
   */
  public void setAzureMpInfo(AzureMarketplace azureMpInfo) {
    this.azureMpInfo = azureMpInfo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property bind_vs_se_details of obj type eventdetails field type str  type ref.
   * @return bindVsSeDetails
   */
  public RmBindVsSeEventDetails getBindVsSeDetails() {
    return bindVsSeDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property bind_vs_se_details of obj type eventdetails field type str  type ref.
   * @param bindVsSeDetails set the bindVsSeDetails.
   */
  public void setBindVsSeDetails(RmBindVsSeEventDetails bindVsSeDetails) {
    this.bindVsSeDetails = bindVsSeDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property bm_infra_details of obj type eventdetails field type str  type ref.
   * @return bmInfraDetails
   */
  public BMSetup getBmInfraDetails() {
    return bmInfraDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property bm_infra_details of obj type eventdetails field type str  type ref.
   * @param bmInfraDetails set the bmInfraDetails.
   */
  public void setBmInfraDetails(BMSetup bmInfraDetails) {
    this.bmInfraDetails = bmInfraDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property bootup_fail_details of obj type eventdetails field type str  type ref.
   * @return bootupFailDetails
   */
  public RmSeBootupFailEventDetails getBootupFailDetails() {
    return bootupFailDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property bootup_fail_details of obj type eventdetails field type str  type ref.
   * @param bootupFailDetails set the bootupFailDetails.
   */
  public void setBootupFailDetails(RmSeBootupFailEventDetails bootupFailDetails) {
    this.bootupFailDetails = bootupFailDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property burst_checkout_details of obj type eventdetails field type str  type ref.
   * @return burstCheckoutDetails
   */
  public BurstLicenseDetails getBurstCheckoutDetails() {
    return burstCheckoutDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property burst_checkout_details of obj type eventdetails field type str  type ref.
   * @param burstCheckoutDetails set the burstCheckoutDetails.
   */
  public void setBurstCheckoutDetails(BurstLicenseDetails burstCheckoutDetails) {
    this.burstCheckoutDetails = burstCheckoutDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cc_cluster_vip_details of obj type eventdetails field type str  type ref.
   * @return ccClusterVipDetails
   */
  public CloudClusterVip getCcClusterVipDetails() {
    return ccClusterVipDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cc_cluster_vip_details of obj type eventdetails field type str  type ref.
   * @param ccClusterVipDetails set the ccClusterVipDetails.
   */
  public void setCcClusterVipDetails(CloudClusterVip ccClusterVipDetails) {
    this.ccClusterVipDetails = ccClusterVipDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cc_dns_update_details of obj type eventdetails field type str  type ref.
   * @return ccDnsUpdateDetails
   */
  public CloudDnsUpdate getCcDnsUpdateDetails() {
    return ccDnsUpdateDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cc_dns_update_details of obj type eventdetails field type str  type ref.
   * @param ccDnsUpdateDetails set the ccDnsUpdateDetails.
   */
  public void setCcDnsUpdateDetails(CloudDnsUpdate ccDnsUpdateDetails) {
    this.ccDnsUpdateDetails = ccDnsUpdateDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cc_health_details of obj type eventdetails field type str  type ref.
   * @return ccHealthDetails
   */
  public CloudHealth getCcHealthDetails() {
    return ccHealthDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cc_health_details of obj type eventdetails field type str  type ref.
   * @param ccHealthDetails set the ccHealthDetails.
   */
  public void setCcHealthDetails(CloudHealth ccHealthDetails) {
    this.ccHealthDetails = ccHealthDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cc_infra_details of obj type eventdetails field type str  type ref.
   * @return ccInfraDetails
   */
  public CloudGeneric getCcInfraDetails() {
    return ccInfraDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cc_infra_details of obj type eventdetails field type str  type ref.
   * @param ccInfraDetails set the ccInfraDetails.
   */
  public void setCcInfraDetails(CloudGeneric ccInfraDetails) {
    this.ccInfraDetails = ccInfraDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cc_ip_details of obj type eventdetails field type str  type ref.
   * @return ccIpDetails
   */
  public CloudIpChange getCcIpDetails() {
    return ccIpDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cc_ip_details of obj type eventdetails field type str  type ref.
   * @param ccIpDetails set the ccIpDetails.
   */
  public void setCcIpDetails(CloudIpChange ccIpDetails) {
    this.ccIpDetails = ccIpDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cc_parkintf_details of obj type eventdetails field type str  type ref.
   * @return ccParkintfDetails
   */
  public CloudVipParkingIntf getCcParkintfDetails() {
    return ccParkintfDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cc_parkintf_details of obj type eventdetails field type str  type ref.
   * @param ccParkintfDetails set the ccParkintfDetails.
   */
  public void setCcParkintfDetails(CloudVipParkingIntf ccParkintfDetails) {
    this.ccParkintfDetails = ccParkintfDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 18.2.5.
   * @return ccScalesetNotifDetails
   */
  public CCScaleSetNotifDetails getCcScalesetNotifDetails() {
    return ccScalesetNotifDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 18.2.5.
   * @param ccScalesetNotifDetails set the ccScalesetNotifDetails.
   */
  public void setCcScalesetNotifDetails(CCScaleSetNotifDetails ccScalesetNotifDetails) {
    this.ccScalesetNotifDetails = ccScalesetNotifDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cc_se_vm_details of obj type eventdetails field type str  type ref.
   * @return ccSeVmDetails
   */
  public CloudSeVmChange getCcSeVmDetails() {
    return ccSeVmDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cc_se_vm_details of obj type eventdetails field type str  type ref.
   * @param ccSeVmDetails set the ccSeVmDetails.
   */
  public void setCcSeVmDetails(CloudSeVmChange ccSeVmDetails) {
    this.ccSeVmDetails = ccSeVmDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cc_sync_services_details of obj type eventdetails field type str  type ref.
   * @return ccSyncServicesDetails
   */
  public CloudSyncServices getCcSyncServicesDetails() {
    return ccSyncServicesDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cc_sync_services_details of obj type eventdetails field type str  type ref.
   * @param ccSyncServicesDetails set the ccSyncServicesDetails.
   */
  public void setCcSyncServicesDetails(CloudSyncServices ccSyncServicesDetails) {
    this.ccSyncServicesDetails = ccSyncServicesDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cc_tenant_del_details of obj type eventdetails field type str  type ref.
   * @return ccTenantDelDetails
   */
  public CloudTenantsDeleted getCcTenantDelDetails() {
    return ccTenantDelDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cc_tenant_del_details of obj type eventdetails field type str  type ref.
   * @param ccTenantDelDetails set the ccTenantDelDetails.
   */
  public void setCcTenantDelDetails(CloudTenantsDeleted ccTenantDelDetails) {
    this.ccTenantDelDetails = ccTenantDelDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cc_vip_update_details of obj type eventdetails field type str  type ref.
   * @return ccVipUpdateDetails
   */
  public CloudVipUpdate getCcVipUpdateDetails() {
    return ccVipUpdateDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cc_vip_update_details of obj type eventdetails field type str  type ref.
   * @param ccVipUpdateDetails set the ccVipUpdateDetails.
   */
  public void setCcVipUpdateDetails(CloudVipUpdate ccVipUpdateDetails) {
    this.ccVipUpdateDetails = ccVipUpdateDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cc_vnic_details of obj type eventdetails field type str  type ref.
   * @return ccVnicDetails
   */
  public CloudVnicChange getCcVnicDetails() {
    return ccVnicDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cc_vnic_details of obj type eventdetails field type str  type ref.
   * @param ccVnicDetails set the ccVnicDetails.
   */
  public void setCcVnicDetails(CloudVnicChange ccVnicDetails) {
    this.ccVnicDetails = ccVnicDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cloud_asg_notif_details of obj type eventdetails field type str  type ref.
   * @return cloudAsgNotifDetails
   */
  public CloudASGNotifDetails getCloudAsgNotifDetails() {
    return cloudAsgNotifDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cloud_asg_notif_details of obj type eventdetails field type str  type ref.
   * @param cloudAsgNotifDetails set the cloudAsgNotifDetails.
   */
  public void setCloudAsgNotifDetails(CloudASGNotifDetails cloudAsgNotifDetails) {
    this.cloudAsgNotifDetails = cloudAsgNotifDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cloud_autoscaling_config_failure_details of obj type eventdetails field type str  type ref.
   * @return cloudAutoscalingConfigFailureDetails
   */
  public CloudAutoscalingConfigFailureDetails getCloudAutoscalingConfigFailureDetails() {
    return cloudAutoscalingConfigFailureDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cloud_autoscaling_config_failure_details of obj type eventdetails field type str  type ref.
   * @param cloudAutoscalingConfigFailureDetails set the cloudAutoscalingConfigFailureDetails.
   */
  public void setCloudAutoscalingConfigFailureDetails(CloudAutoscalingConfigFailureDetails cloudAutoscalingConfigFailureDetails) {
    this.cloudAutoscalingConfigFailureDetails = cloudAutoscalingConfigFailureDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cluster_config_failed_details of obj type eventdetails field type str  type ref.
   * @return clusterConfigFailedDetails
   */
  public ClusterConfigFailedEvent getClusterConfigFailedDetails() {
    return clusterConfigFailedDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cluster_config_failed_details of obj type eventdetails field type str  type ref.
   * @param clusterConfigFailedDetails set the clusterConfigFailedDetails.
   */
  public void setClusterConfigFailedDetails(ClusterConfigFailedEvent clusterConfigFailedDetails) {
    this.clusterConfigFailedDetails = clusterConfigFailedDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cluster_leader_failover_details of obj type eventdetails field type str  type ref.
   * @return clusterLeaderFailoverDetails
   */
  public ClusterLeaderFailoverEvent getClusterLeaderFailoverDetails() {
    return clusterLeaderFailoverDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cluster_leader_failover_details of obj type eventdetails field type str  type ref.
   * @param clusterLeaderFailoverDetails set the clusterLeaderFailoverDetails.
   */
  public void setClusterLeaderFailoverDetails(ClusterLeaderFailoverEvent clusterLeaderFailoverDetails) {
    this.clusterLeaderFailoverDetails = clusterLeaderFailoverDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cluster_node_add_details of obj type eventdetails field type str  type ref.
   * @return clusterNodeAddDetails
   */
  public ClusterNodeAddEvent getClusterNodeAddDetails() {
    return clusterNodeAddDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cluster_node_add_details of obj type eventdetails field type str  type ref.
   * @param clusterNodeAddDetails set the clusterNodeAddDetails.
   */
  public void setClusterNodeAddDetails(ClusterNodeAddEvent clusterNodeAddDetails) {
    this.clusterNodeAddDetails = clusterNodeAddDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cluster_node_db_failed_details of obj type eventdetails field type str  type ref.
   * @return clusterNodeDbFailedDetails
   */
  public ClusterNodeDbFailedEvent getClusterNodeDbFailedDetails() {
    return clusterNodeDbFailedDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cluster_node_db_failed_details of obj type eventdetails field type str  type ref.
   * @param clusterNodeDbFailedDetails set the clusterNodeDbFailedDetails.
   */
  public void setClusterNodeDbFailedDetails(ClusterNodeDbFailedEvent clusterNodeDbFailedDetails) {
    this.clusterNodeDbFailedDetails = clusterNodeDbFailedDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cluster_node_remove_details of obj type eventdetails field type str  type ref.
   * @return clusterNodeRemoveDetails
   */
  public ClusterNodeRemoveEvent getClusterNodeRemoveDetails() {
    return clusterNodeRemoveDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cluster_node_remove_details of obj type eventdetails field type str  type ref.
   * @param clusterNodeRemoveDetails set the clusterNodeRemoveDetails.
   */
  public void setClusterNodeRemoveDetails(ClusterNodeRemoveEvent clusterNodeRemoveDetails) {
    this.clusterNodeRemoveDetails = clusterNodeRemoveDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cluster_node_shutdown_details of obj type eventdetails field type str  type ref.
   * @return clusterNodeShutdownDetails
   */
  public ClusterNodeShutdownEvent getClusterNodeShutdownDetails() {
    return clusterNodeShutdownDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cluster_node_shutdown_details of obj type eventdetails field type str  type ref.
   * @param clusterNodeShutdownDetails set the clusterNodeShutdownDetails.
   */
  public void setClusterNodeShutdownDetails(ClusterNodeShutdownEvent clusterNodeShutdownDetails) {
    this.clusterNodeShutdownDetails = clusterNodeShutdownDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cluster_node_started_details of obj type eventdetails field type str  type ref.
   * @return clusterNodeStartedDetails
   */
  public ClusterNodeStartedEvent getClusterNodeStartedDetails() {
    return clusterNodeStartedDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cluster_node_started_details of obj type eventdetails field type str  type ref.
   * @param clusterNodeStartedDetails set the clusterNodeStartedDetails.
   */
  public void setClusterNodeStartedDetails(ClusterNodeStartedEvent clusterNodeStartedDetails) {
    this.clusterNodeStartedDetails = clusterNodeStartedDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cluster_service_critical_failure_details of obj type eventdetails field type str  type ref.
   * @return clusterServiceCriticalFailureDetails
   */
  public ClusterServiceCriticalFailureEvent getClusterServiceCriticalFailureDetails() {
    return clusterServiceCriticalFailureDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cluster_service_critical_failure_details of obj type eventdetails field type str  type ref.
   * @param clusterServiceCriticalFailureDetails set the clusterServiceCriticalFailureDetails.
   */
  public void setClusterServiceCriticalFailureDetails(ClusterServiceCriticalFailureEvent clusterServiceCriticalFailureDetails) {
    this.clusterServiceCriticalFailureDetails = clusterServiceCriticalFailureDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cluster_service_failed_details of obj type eventdetails field type str  type ref.
   * @return clusterServiceFailedDetails
   */
  public ClusterServiceFailedEvent getClusterServiceFailedDetails() {
    return clusterServiceFailedDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cluster_service_failed_details of obj type eventdetails field type str  type ref.
   * @param clusterServiceFailedDetails set the clusterServiceFailedDetails.
   */
  public void setClusterServiceFailedDetails(ClusterServiceFailedEvent clusterServiceFailedDetails) {
    this.clusterServiceFailedDetails = clusterServiceFailedDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cluster_service_restored_details of obj type eventdetails field type str  type ref.
   * @return clusterServiceRestoredDetails
   */
  public ClusterServiceRestoredEvent getClusterServiceRestoredDetails() {
    return clusterServiceRestoredDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cluster_service_restored_details of obj type eventdetails field type str  type ref.
   * @param clusterServiceRestoredDetails set the clusterServiceRestoredDetails.
   */
  public void setClusterServiceRestoredDetails(ClusterServiceRestoredEvent clusterServiceRestoredDetails) {
    this.clusterServiceRestoredDetails = clusterServiceRestoredDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cntlr_host_list_details of obj type eventdetails field type str  type ref.
   * @return cntlrHostListDetails
   */
  public VinfraCntlrHostUnreachableList getCntlrHostListDetails() {
    return cntlrHostListDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cntlr_host_list_details of obj type eventdetails field type str  type ref.
   * @param cntlrHostListDetails set the cntlrHostListDetails.
   */
  public void setCntlrHostListDetails(VinfraCntlrHostUnreachableList cntlrHostListDetails) {
    this.cntlrHostListDetails = cntlrHostListDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property config_action_details of obj type eventdetails field type str  type ref.
   * @return configActionDetails
   */
  public ConfigActionDetails getConfigActionDetails() {
    return configActionDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property config_action_details of obj type eventdetails field type str  type ref.
   * @param configActionDetails set the configActionDetails.
   */
  public void setConfigActionDetails(ConfigActionDetails configActionDetails) {
    this.configActionDetails = configActionDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property config_create_details of obj type eventdetails field type str  type ref.
   * @return configCreateDetails
   */
  public ConfigCreateDetails getConfigCreateDetails() {
    return configCreateDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property config_create_details of obj type eventdetails field type str  type ref.
   * @param configCreateDetails set the configCreateDetails.
   */
  public void setConfigCreateDetails(ConfigCreateDetails configCreateDetails) {
    this.configCreateDetails = configCreateDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property config_delete_details of obj type eventdetails field type str  type ref.
   * @return configDeleteDetails
   */
  public ConfigDeleteDetails getConfigDeleteDetails() {
    return configDeleteDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property config_delete_details of obj type eventdetails field type str  type ref.
   * @param configDeleteDetails set the configDeleteDetails.
   */
  public void setConfigDeleteDetails(ConfigDeleteDetails configDeleteDetails) {
    this.configDeleteDetails = configDeleteDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property config_password_change_request_details of obj type eventdetails field type str  type ref.
   * @return configPasswordChangeRequestDetails
   */
  public ConfigUserPasswordChangeRequest getConfigPasswordChangeRequestDetails() {
    return configPasswordChangeRequestDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property config_password_change_request_details of obj type eventdetails field type str  type ref.
   * @param configPasswordChangeRequestDetails set the configPasswordChangeRequestDetails.
   */
  public void setConfigPasswordChangeRequestDetails(ConfigUserPasswordChangeRequest configPasswordChangeRequestDetails) {
    this.configPasswordChangeRequestDetails = configPasswordChangeRequestDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property config_se_grp_flv_update_details of obj type eventdetails field type str  type ref.
   * @return configSeGrpFlvUpdateDetails
   */
  public ConfigSeGrpFlvUpdate getConfigSeGrpFlvUpdateDetails() {
    return configSeGrpFlvUpdateDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property config_se_grp_flv_update_details of obj type eventdetails field type str  type ref.
   * @param configSeGrpFlvUpdateDetails set the configSeGrpFlvUpdateDetails.
   */
  public void setConfigSeGrpFlvUpdateDetails(ConfigSeGrpFlvUpdate configSeGrpFlvUpdateDetails) {
    this.configSeGrpFlvUpdateDetails = configSeGrpFlvUpdateDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property config_update_details of obj type eventdetails field type str  type ref.
   * @return configUpdateDetails
   */
  public ConfigUpdateDetails getConfigUpdateDetails() {
    return configUpdateDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property config_update_details of obj type eventdetails field type str  type ref.
   * @param configUpdateDetails set the configUpdateDetails.
   */
  public void setConfigUpdateDetails(ConfigUpdateDetails configUpdateDetails) {
    this.configUpdateDetails = configUpdateDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property config_user_authrz_rule_details of obj type eventdetails field type str  type ref.
   * @return configUserAuthrzRuleDetails
   */
  public ConfigUserAuthrzByRule getConfigUserAuthrzRuleDetails() {
    return configUserAuthrzRuleDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property config_user_authrz_rule_details of obj type eventdetails field type str  type ref.
   * @param configUserAuthrzRuleDetails set the configUserAuthrzRuleDetails.
   */
  public void setConfigUserAuthrzRuleDetails(ConfigUserAuthrzByRule configUserAuthrzRuleDetails) {
    this.configUserAuthrzRuleDetails = configUserAuthrzRuleDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property config_user_login_details of obj type eventdetails field type str  type ref.
   * @return configUserLoginDetails
   */
  public ConfigUserLogin getConfigUserLoginDetails() {
    return configUserLoginDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property config_user_login_details of obj type eventdetails field type str  type ref.
   * @param configUserLoginDetails set the configUserLoginDetails.
   */
  public void setConfigUserLoginDetails(ConfigUserLogin configUserLoginDetails) {
    this.configUserLoginDetails = configUserLoginDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property config_user_logout_details of obj type eventdetails field type str  type ref.
   * @return configUserLogoutDetails
   */
  public ConfigUserLogout getConfigUserLogoutDetails() {
    return configUserLogoutDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property config_user_logout_details of obj type eventdetails field type str  type ref.
   * @param configUserLogoutDetails set the configUserLogoutDetails.
   */
  public void setConfigUserLogoutDetails(ConfigUserLogout configUserLogoutDetails) {
    this.configUserLogoutDetails = configUserLogoutDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property config_user_not_authrz_rule_details of obj type eventdetails field type str  type ref.
   * @return configUserNotAuthrzRuleDetails
   */
  public ConfigUserNotAuthrzByRule getConfigUserNotAuthrzRuleDetails() {
    return configUserNotAuthrzRuleDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property config_user_not_authrz_rule_details of obj type eventdetails field type str  type ref.
   * @param configUserNotAuthrzRuleDetails set the configUserNotAuthrzRuleDetails.
   */
  public void setConfigUserNotAuthrzRuleDetails(ConfigUserNotAuthrzByRule configUserNotAuthrzRuleDetails) {
    this.configUserNotAuthrzRuleDetails = configUserNotAuthrzRuleDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property container_cloud_batch_setup of obj type eventdetails field type str  type ref.
   * @return containerCloudBatchSetup
   */
  public ContainerCloudBatchSetup getContainerCloudBatchSetup() {
    return containerCloudBatchSetup;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property container_cloud_batch_setup of obj type eventdetails field type str  type ref.
   * @param containerCloudBatchSetup set the containerCloudBatchSetup.
   */
  public void setContainerCloudBatchSetup(ContainerCloudBatchSetup containerCloudBatchSetup) {
    this.containerCloudBatchSetup = containerCloudBatchSetup;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property container_cloud_setup of obj type eventdetails field type str  type ref.
   * @return containerCloudSetup
   */
  public ContainerCloudSetup getContainerCloudSetup() {
    return containerCloudSetup;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property container_cloud_setup of obj type eventdetails field type str  type ref.
   * @param containerCloudSetup set the containerCloudSetup.
   */
  public void setContainerCloudSetup(ContainerCloudSetup containerCloudSetup) {
    this.containerCloudSetup = containerCloudSetup;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property container_cloud_sevice of obj type eventdetails field type str  type ref.
   * @return containerCloudSevice
   */
  public ContainerCloudService getContainerCloudSevice() {
    return containerCloudSevice;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property container_cloud_sevice of obj type eventdetails field type str  type ref.
   * @param containerCloudSevice set the containerCloudSevice.
   */
  public void setContainerCloudSevice(ContainerCloudService containerCloudSevice) {
    this.containerCloudSevice = containerCloudSevice;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property controller_license_reconcile_details of obj type eventdetails field type str  type ref.
   * @return controllerLicenseReconcileDetails
   */
  public ControllerLicenseReconcileDetails getControllerLicenseReconcileDetails() {
    return controllerLicenseReconcileDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property controller_license_reconcile_details of obj type eventdetails field type str  type ref.
   * @param controllerLicenseReconcileDetails set the controllerLicenseReconcileDetails.
   */
  public void setControllerLicenseReconcileDetails(ControllerLicenseReconcileDetails controllerLicenseReconcileDetails) {
    this.controllerLicenseReconcileDetails = controllerLicenseReconcileDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property crs_deployment_failure of obj type eventdetails field type str  type ref.
   * @return crsDeploymentFailure
   */
  public CRSDeploymentFailure getCrsDeploymentFailure() {
    return crsDeploymentFailure;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property crs_deployment_failure of obj type eventdetails field type str  type ref.
   * @param crsDeploymentFailure set the crsDeploymentFailure.
   */
  public void setCrsDeploymentFailure(CRSDeploymentFailure crsDeploymentFailure) {
    this.crsDeploymentFailure = crsDeploymentFailure;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property crs_deployment_success of obj type eventdetails field type str  type ref.
   * @return crsDeploymentSuccess
   */
  public CRSDeploymentSuccess getCrsDeploymentSuccess() {
    return crsDeploymentSuccess;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property crs_deployment_success of obj type eventdetails field type str  type ref.
   * @param crsDeploymentSuccess set the crsDeploymentSuccess.
   */
  public void setCrsDeploymentSuccess(CRSDeploymentSuccess crsDeploymentSuccess) {
    this.crsDeploymentSuccess = crsDeploymentSuccess;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property crs_details of obj type eventdetails field type str  type ref.
   * @return crsDetails
   */
  public CRSDetails getCrsDetails() {
    return crsDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property crs_details of obj type eventdetails field type str  type ref.
   * @param crsDetails set the crsDetails.
   */
  public void setCrsDetails(CRSDetails crsDetails) {
    this.crsDetails = crsDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property crs_update_details of obj type eventdetails field type str  type ref.
   * @return crsUpdateDetails
   */
  public CRSUpdateDetails getCrsUpdateDetails() {
    return crsUpdateDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property crs_update_details of obj type eventdetails field type str  type ref.
   * @param crsUpdateDetails set the crsUpdateDetails.
   */
  public void setCrsUpdateDetails(CRSUpdateDetails crsUpdateDetails) {
    this.crsUpdateDetails = crsUpdateDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cs_infra_details of obj type eventdetails field type str  type ref.
   * @return csInfraDetails
   */
  public CloudStackSetup getCsInfraDetails() {
    return csInfraDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cs_infra_details of obj type eventdetails field type str  type ref.
   * @param csInfraDetails set the csInfraDetails.
   */
  public void setCsInfraDetails(CloudStackSetup csInfraDetails) {
    this.csInfraDetails = csInfraDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property delete_se_details of obj type eventdetails field type str  type ref.
   * @return deleteSeDetails
   */
  public RmDeleteSeEventDetails getDeleteSeDetails() {
    return deleteSeDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property delete_se_details of obj type eventdetails field type str  type ref.
   * @param deleteSeDetails set the deleteSeDetails.
   */
  public void setDeleteSeDetails(RmDeleteSeEventDetails deleteSeDetails) {
    this.deleteSeDetails = deleteSeDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property disable_se_migrate_details of obj type eventdetails field type str  type ref.
   * @return disableSeMigrateDetails
   */
  public DisableSeMigrateEventDetails getDisableSeMigrateDetails() {
    return disableSeMigrateDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property disable_se_migrate_details of obj type eventdetails field type str  type ref.
   * @param disableSeMigrateDetails set the disableSeMigrateDetails.
   */
  public void setDisableSeMigrateDetails(DisableSeMigrateEventDetails disableSeMigrateDetails) {
    this.disableSeMigrateDetails = disableSeMigrateDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property disc_summary of obj type eventdetails field type str  type ref.
   * @return discSummary
   */
  public VinfraDiscSummaryDetails getDiscSummary() {
    return discSummary;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property disc_summary of obj type eventdetails field type str  type ref.
   * @param discSummary set the discSummary.
   */
  public void setDiscSummary(VinfraDiscSummaryDetails discSummary) {
    this.discSummary = discSummary;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property dns_sync_info of obj type eventdetails field type str  type ref.
   * @return dnsSyncInfo
   */
  public DNSVsSyncInfo getDnsSyncInfo() {
    return dnsSyncInfo;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property dns_sync_info of obj type eventdetails field type str  type ref.
   * @param dnsSyncInfo set the dnsSyncInfo.
   */
  public void setDnsSyncInfo(DNSVsSyncInfo dnsSyncInfo) {
    this.dnsSyncInfo = dnsSyncInfo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property docker_ucp_details of obj type eventdetails field type str  type ref.
   * @return dockerUcpDetails
   */
  public DockerUCPSetup getDockerUcpDetails() {
    return dockerUcpDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property docker_ucp_details of obj type eventdetails field type str  type ref.
   * @param dockerUcpDetails set the dockerUcpDetails.
   */
  public void setDockerUcpDetails(DockerUCPSetup dockerUcpDetails) {
    this.dockerUcpDetails = dockerUcpDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property dos_attack_event_details of obj type eventdetails field type str  type ref.
   * @return dosAttackEventDetails
   */
  public DosAttackEventDetails getDosAttackEventDetails() {
    return dosAttackEventDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property dos_attack_event_details of obj type eventdetails field type str  type ref.
   * @param dosAttackEventDetails set the dosAttackEventDetails.
   */
  public void setDosAttackEventDetails(DosAttackEventDetails dosAttackEventDetails) {
    this.dosAttackEventDetails = dosAttackEventDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property gcp_cloud_router_info of obj type eventdetails field type str  type ref.
   * @return gcpCloudRouterInfo
   */
  public GCPCloudRouterUpdate getGcpCloudRouterInfo() {
    return gcpCloudRouterInfo;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property gcp_cloud_router_info of obj type eventdetails field type str  type ref.
   * @param gcpCloudRouterInfo set the gcpCloudRouterInfo.
   */
  public void setGcpCloudRouterInfo(GCPCloudRouterUpdate gcpCloudRouterInfo) {
    this.gcpCloudRouterInfo = gcpCloudRouterInfo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property gcp_info of obj type eventdetails field type str  type ref.
   * @return gcpInfo
   */
  public GCPSetup getGcpInfo() {
    return gcpInfo;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property gcp_info of obj type eventdetails field type str  type ref.
   * @param gcpInfo set the gcpInfo.
   */
  public void setGcpInfo(GCPSetup gcpInfo) {
    this.gcpInfo = gcpInfo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property glb_info of obj type eventdetails field type str  type ref.
   * @return glbInfo
   */
  public GslbStatus getGlbInfo() {
    return glbInfo;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property glb_info of obj type eventdetails field type str  type ref.
   * @param glbInfo set the glbInfo.
   */
  public void setGlbInfo(GslbStatus glbInfo) {
    this.glbInfo = glbInfo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property gs_info of obj type eventdetails field type str  type ref.
   * @return gsInfo
   */
  public GslbServiceStatus getGsInfo() {
    return gsInfo;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property gs_info of obj type eventdetails field type str  type ref.
   * @param gsInfo set the gsInfo.
   */
  public void setGsInfo(GslbServiceStatus gsInfo) {
    this.gsInfo = gsInfo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property host_unavail_details of obj type eventdetails field type str  type ref.
   * @return hostUnavailDetails
   */
  public HostUnavailEventDetails getHostUnavailDetails() {
    return hostUnavailDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property host_unavail_details of obj type eventdetails field type str  type ref.
   * @param hostUnavailDetails set the hostUnavailDetails.
   */
  public void setHostUnavailDetails(HostUnavailEventDetails hostUnavailDetails) {
    this.hostUnavailDetails = hostUnavailDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property hs_details of obj type eventdetails field type str  type ref.
   * @return hsDetails
   */
  public HealthScoreDetails getHsDetails() {
    return hsDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property hs_details of obj type eventdetails field type str  type ref.
   * @param hsDetails set the hsDetails.
   */
  public void setHsDetails(HealthScoreDetails hsDetails) {
    this.hsDetails = hsDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ip_fail_details of obj type eventdetails field type str  type ref.
   * @return ipFailDetails
   */
  public RmSeIpFailEventDetails getIpFailDetails() {
    return ipFailDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ip_fail_details of obj type eventdetails field type str  type ref.
   * @param ipFailDetails set the ipFailDetails.
   */
  public void setIpFailDetails(RmSeIpFailEventDetails ipFailDetails) {
    this.ipFailDetails = ipFailDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ip_threat_db_event_data of obj type eventdetails field type str  type ref.
   * @return ipThreatDbEventData
   */
  public IPThreatDBEventData getIpThreatDbEventData() {
    return ipThreatDbEventData;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ip_threat_db_event_data of obj type eventdetails field type str  type ref.
   * @param ipThreatDbEventData set the ipThreatDbEventData.
   */
  public void setIpThreatDbEventData(IPThreatDBEventData ipThreatDbEventData) {
    this.ipThreatDbEventData = ipThreatDbEventData;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property license_details of obj type eventdetails field type str  type ref.
   * @return licenseDetails
   */
  public LicenseDetails getLicenseDetails() {
    return licenseDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property license_details of obj type eventdetails field type str  type ref.
   * @param licenseDetails set the licenseDetails.
   */
  public void setLicenseDetails(LicenseDetails licenseDetails) {
    this.licenseDetails = licenseDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property license_expiry_details of obj type eventdetails field type str  type ref.
   * @return licenseExpiryDetails
   */
  public LicenseExpiryDetails getLicenseExpiryDetails() {
    return licenseExpiryDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property license_expiry_details of obj type eventdetails field type str  type ref.
   * @param licenseExpiryDetails set the licenseExpiryDetails.
   */
  public void setLicenseExpiryDetails(LicenseExpiryDetails licenseExpiryDetails) {
    this.licenseExpiryDetails = licenseExpiryDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property license_transaction_details of obj type eventdetails field type str  type ref.
   * @return licenseTransactionDetails
   */
  public LicenseTransactionDetails getLicenseTransactionDetails() {
    return licenseTransactionDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property license_transaction_details of obj type eventdetails field type str  type ref.
   * @param licenseTransactionDetails set the licenseTransactionDetails.
   */
  public void setLicenseTransactionDetails(LicenseTransactionDetails licenseTransactionDetails) {
    this.licenseTransactionDetails = licenseTransactionDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property marathon_service_port_conflict_details of obj type eventdetails field type str  type ref.
   * @return marathonServicePortConflictDetails
   */
  public MarathonServicePortConflict getMarathonServicePortConflictDetails() {
    return marathonServicePortConflictDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property marathon_service_port_conflict_details of obj type eventdetails field type str  type ref.
   * @param marathonServicePortConflictDetails set the marathonServicePortConflictDetails.
   */
  public void setMarathonServicePortConflictDetails(MarathonServicePortConflict marathonServicePortConflictDetails) {
    this.marathonServicePortConflictDetails = marathonServicePortConflictDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property memory_balancer_info of obj type eventdetails field type str  type ref.
   * @return memoryBalancerInfo
   */
  public MemoryBalancerInfo getMemoryBalancerInfo() {
    return memoryBalancerInfo;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property memory_balancer_info of obj type eventdetails field type str  type ref.
   * @param memoryBalancerInfo set the memoryBalancerInfo.
   */
  public void setMemoryBalancerInfo(MemoryBalancerInfo memoryBalancerInfo) {
    this.memoryBalancerInfo = memoryBalancerInfo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property mesos_infra_details of obj type eventdetails field type str  type ref.
   * @return mesosInfraDetails
   */
  public MesosSetup getMesosInfraDetails() {
    return mesosInfraDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property mesos_infra_details of obj type eventdetails field type str  type ref.
   * @param mesosInfraDetails set the mesosInfraDetails.
   */
  public void setMesosInfraDetails(MesosSetup mesosInfraDetails) {
    this.mesosInfraDetails = mesosInfraDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property metric_threshold_up_details of obj type eventdetails field type str  type ref.
   * @return metricThresholdUpDetails
   */
  public MetricThresoldUpDetails getMetricThresholdUpDetails() {
    return metricThresholdUpDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property metric_threshold_up_details of obj type eventdetails field type str  type ref.
   * @param metricThresholdUpDetails set the metricThresholdUpDetails.
   */
  public void setMetricThresholdUpDetails(MetricThresoldUpDetails metricThresholdUpDetails) {
    this.metricThresholdUpDetails = metricThresholdUpDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property metrics_db_disk_details of obj type eventdetails field type str  type ref.
   * @return metricsDbDiskDetails
   */
  public MetricsDbDiskEventDetails getMetricsDbDiskDetails() {
    return metricsDbDiskDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property metrics_db_disk_details of obj type eventdetails field type str  type ref.
   * @param metricsDbDiskDetails set the metricsDbDiskDetails.
   */
  public void setMetricsDbDiskDetails(MetricsDbDiskEventDetails metricsDbDiskDetails) {
    this.metricsDbDiskDetails = metricsDbDiskDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property metrics_db_queue_full_details of obj type eventdetails field type str  type ref.
   * @return metricsDbQueueFullDetails
   */
  public MetricsDbQueueFullEventDetails getMetricsDbQueueFullDetails() {
    return metricsDbQueueFullDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property metrics_db_queue_full_details of obj type eventdetails field type str  type ref.
   * @param metricsDbQueueFullDetails set the metricsDbQueueFullDetails.
   */
  public void setMetricsDbQueueFullDetails(MetricsDbQueueFullEventDetails metricsDbQueueFullDetails) {
    this.metricsDbQueueFullDetails = metricsDbQueueFullDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property metrics_db_queue_healthy_details of obj type eventdetails field type str  type ref.
   * @return metricsDbQueueHealthyDetails
   */
  public MetricsDbQueueHealthyEventDetails getMetricsDbQueueHealthyDetails() {
    return metricsDbQueueHealthyDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property metrics_db_queue_healthy_details of obj type eventdetails field type str  type ref.
   * @param metricsDbQueueHealthyDetails set the metricsDbQueueHealthyDetails.
   */
  public void setMetricsDbQueueHealthyDetails(MetricsDbQueueHealthyEventDetails metricsDbQueueHealthyDetails) {
    this.metricsDbQueueHealthyDetails = metricsDbQueueHealthyDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property mgmt_nw_change_details of obj type eventdetails field type str  type ref.
   * @return mgmtNwChangeDetails
   */
  public VinfraMgmtNwChangeDetails getMgmtNwChangeDetails() {
    return mgmtNwChangeDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property mgmt_nw_change_details of obj type eventdetails field type str  type ref.
   * @param mgmtNwChangeDetails set the mgmtNwChangeDetails.
   */
  public void setMgmtNwChangeDetails(VinfraMgmtNwChangeDetails mgmtNwChangeDetails) {
    this.mgmtNwChangeDetails = mgmtNwChangeDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property modify_networks_details of obj type eventdetails field type str  type ref.
   * @return modifyNetworksDetails
   */
  public RmModifyNetworksEventDetails getModifyNetworksDetails() {
    return modifyNetworksDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property modify_networks_details of obj type eventdetails field type str  type ref.
   * @param modifyNetworksDetails set the modifyNetworksDetails.
   */
  public void setModifyNetworksDetails(RmModifyNetworksEventDetails modifyNetworksDetails) {
    this.modifyNetworksDetails = modifyNetworksDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property network_subnet_details of obj type eventdetails field type str  type ref.
   * @return networkSubnetDetails
   */
  public NetworkSubnetInfo getNetworkSubnetDetails() {
    return networkSubnetDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property network_subnet_details of obj type eventdetails field type str  type ref.
   * @param networkSubnetDetails set the networkSubnetDetails.
   */
  public void setNetworkSubnetDetails(NetworkSubnetInfo networkSubnetDetails) {
    this.networkSubnetDetails = networkSubnetDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Nsxt image event.
   * Field introduced in 20.1.1.
   * @return nsxtImgDetails
   */
  public NsxtImageDetails getNsxtImgDetails() {
    return nsxtImgDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Nsxt image event.
   * Field introduced in 20.1.1.
   * @param nsxtImgDetails set the nsxtImgDetails.
   */
  public void setNsxtImgDetails(NsxtImageDetails nsxtImgDetails) {
    this.nsxtImgDetails = nsxtImgDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Nsxt cloud event.
   * Field introduced in 20.1.1.
   * @return nsxtInfo
   */
  public NsxtSetup getNsxtInfo() {
    return nsxtInfo;
  }

  /**
   * This is the setter method to the attribute.
   * Nsxt cloud event.
   * Field introduced in 20.1.1.
   * @param nsxtInfo set the nsxtInfo.
   */
  public void setNsxtInfo(NsxtSetup nsxtInfo) {
    this.nsxtInfo = nsxtInfo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property nw_subnet_clash_details of obj type eventdetails field type str  type ref.
   * @return nwSubnetClashDetails
   */
  public NetworkSubnetClash getNwSubnetClashDetails() {
    return nwSubnetClashDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property nw_subnet_clash_details of obj type eventdetails field type str  type ref.
   * @param nwSubnetClashDetails set the nwSubnetClashDetails.
   */
  public void setNwSubnetClashDetails(NetworkSubnetClash nwSubnetClashDetails) {
    this.nwSubnetClashDetails = nwSubnetClashDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property nw_summarized_details of obj type eventdetails field type str  type ref.
   * @return nwSummarizedDetails
   */
  public SummarizedInfo getNwSummarizedDetails() {
    return nwSummarizedDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property nw_summarized_details of obj type eventdetails field type str  type ref.
   * @param nwSummarizedDetails set the nwSummarizedDetails.
   */
  public void setNwSummarizedDetails(SummarizedInfo nwSummarizedDetails) {
    this.nwSummarizedDetails = nwSummarizedDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property oci_info of obj type eventdetails field type str  type ref.
   * @return ociInfo
   */
  public OCISetup getOciInfo() {
    return ociInfo;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property oci_info of obj type eventdetails field type str  type ref.
   * @param ociInfo set the ociInfo.
   */
  public void setOciInfo(OCISetup ociInfo) {
    this.ociInfo = ociInfo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 20.1.1.
   * @return osApiVerCheckFailure
   */
  public OpenStackApiVersionCheckFailure getOsApiVerCheckFailure() {
    return osApiVerCheckFailure;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 20.1.1.
   * @param osApiVerCheckFailure set the osApiVerCheckFailure.
   */
  public void setOsApiVerCheckFailure(OpenStackApiVersionCheckFailure osApiVerCheckFailure) {
    this.osApiVerCheckFailure = osApiVerCheckFailure;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property os_infra_details of obj type eventdetails field type str  type ref.
   * @return osInfraDetails
   */
  public OpenStackClusterSetup getOsInfraDetails() {
    return osInfraDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property os_infra_details of obj type eventdetails field type str  type ref.
   * @param osInfraDetails set the osInfraDetails.
   */
  public void setOsInfraDetails(OpenStackClusterSetup osInfraDetails) {
    this.osInfraDetails = osInfraDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property os_ip_details of obj type eventdetails field type str  type ref.
   * @return osIpDetails
   */
  public OpenStackIpChange getOsIpDetails() {
    return osIpDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property os_ip_details of obj type eventdetails field type str  type ref.
   * @param osIpDetails set the osIpDetails.
   */
  public void setOsIpDetails(OpenStackIpChange osIpDetails) {
    this.osIpDetails = osIpDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property os_lbaudit_details of obj type eventdetails field type str  type ref.
   * @return osLbauditDetails
   */
  public OpenStackLbProvAuditCheck getOsLbauditDetails() {
    return osLbauditDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property os_lbaudit_details of obj type eventdetails field type str  type ref.
   * @param osLbauditDetails set the osLbauditDetails.
   */
  public void setOsLbauditDetails(OpenStackLbProvAuditCheck osLbauditDetails) {
    this.osLbauditDetails = osLbauditDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property os_lbplugin_op_details of obj type eventdetails field type str  type ref.
   * @return osLbpluginOpDetails
   */
  public OpenStackLbPluginOp getOsLbpluginOpDetails() {
    return osLbpluginOpDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property os_lbplugin_op_details of obj type eventdetails field type str  type ref.
   * @param osLbpluginOpDetails set the osLbpluginOpDetails.
   */
  public void setOsLbpluginOpDetails(OpenStackLbPluginOp osLbpluginOpDetails) {
    this.osLbpluginOpDetails = osLbpluginOpDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property os_se_vm_details of obj type eventdetails field type str  type ref.
   * @return osSeVmDetails
   */
  public OpenStackSeVmChange getOsSeVmDetails() {
    return osSeVmDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property os_se_vm_details of obj type eventdetails field type str  type ref.
   * @param osSeVmDetails set the osSeVmDetails.
   */
  public void setOsSeVmDetails(OpenStackSeVmChange osSeVmDetails) {
    this.osSeVmDetails = osSeVmDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property os_sync_services_details of obj type eventdetails field type str  type ref.
   * @return osSyncServicesDetails
   */
  public OpenStackSyncServices getOsSyncServicesDetails() {
    return osSyncServicesDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property os_sync_services_details of obj type eventdetails field type str  type ref.
   * @param osSyncServicesDetails set the osSyncServicesDetails.
   */
  public void setOsSyncServicesDetails(OpenStackSyncServices osSyncServicesDetails) {
    this.osSyncServicesDetails = osSyncServicesDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property os_vnic_details of obj type eventdetails field type str  type ref.
   * @return osVnicDetails
   */
  public OpenStackVnicChange getOsVnicDetails() {
    return osVnicDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property os_vnic_details of obj type eventdetails field type str  type ref.
   * @param osVnicDetails set the osVnicDetails.
   */
  public void setOsVnicDetails(OpenStackVnicChange osVnicDetails) {
    this.osVnicDetails = osVnicDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property pool_deployment_failure_info of obj type eventdetails field type str  type ref.
   * @return poolDeploymentFailureInfo
   */
  public PoolDeploymentFailureInfo getPoolDeploymentFailureInfo() {
    return poolDeploymentFailureInfo;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property pool_deployment_failure_info of obj type eventdetails field type str  type ref.
   * @param poolDeploymentFailureInfo set the poolDeploymentFailureInfo.
   */
  public void setPoolDeploymentFailureInfo(PoolDeploymentFailureInfo poolDeploymentFailureInfo) {
    this.poolDeploymentFailureInfo = poolDeploymentFailureInfo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property pool_deployment_success_info of obj type eventdetails field type str  type ref.
   * @return poolDeploymentSuccessInfo
   */
  public PoolDeploymentSuccessInfo getPoolDeploymentSuccessInfo() {
    return poolDeploymentSuccessInfo;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property pool_deployment_success_info of obj type eventdetails field type str  type ref.
   * @param poolDeploymentSuccessInfo set the poolDeploymentSuccessInfo.
   */
  public void setPoolDeploymentSuccessInfo(PoolDeploymentSuccessInfo poolDeploymentSuccessInfo) {
    this.poolDeploymentSuccessInfo = poolDeploymentSuccessInfo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property pool_deployment_update_info of obj type eventdetails field type str  type ref.
   * @return poolDeploymentUpdateInfo
   */
  public PoolDeploymentUpdateInfo getPoolDeploymentUpdateInfo() {
    return poolDeploymentUpdateInfo;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property pool_deployment_update_info of obj type eventdetails field type str  type ref.
   * @param poolDeploymentUpdateInfo set the poolDeploymentUpdateInfo.
   */
  public void setPoolDeploymentUpdateInfo(PoolDeploymentUpdateInfo poolDeploymentUpdateInfo) {
    this.poolDeploymentUpdateInfo = poolDeploymentUpdateInfo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property pool_server_delete_details of obj type eventdetails field type str  type ref.
   * @return poolServerDeleteDetails
   */
  public VinfraPoolServerDeleteDetails getPoolServerDeleteDetails() {
    return poolServerDeleteDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property pool_server_delete_details of obj type eventdetails field type str  type ref.
   * @param poolServerDeleteDetails set the poolServerDeleteDetails.
   */
  public void setPoolServerDeleteDetails(VinfraPoolServerDeleteDetails poolServerDeleteDetails) {
    this.poolServerDeleteDetails = poolServerDeleteDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property psm_program_details of obj type eventdetails field type str  type ref.
   * @return psmProgramDetails
   */
  public PsmProgramDetails getPsmProgramDetails() {
    return psmProgramDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property psm_program_details of obj type eventdetails field type str  type ref.
   * @param psmProgramDetails set the psmProgramDetails.
   */
  public void setPsmProgramDetails(PsmProgramDetails psmProgramDetails) {
    this.psmProgramDetails = psmProgramDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 20.1.1.
   * @return rateLimiterEventDetails
   */
  public RateLimiterEventDetails getRateLimiterEventDetails() {
    return rateLimiterEventDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 20.1.1.
   * @param rateLimiterEventDetails set the rateLimiterEventDetails.
   */
  public void setRateLimiterEventDetails(RateLimiterEventDetails rateLimiterEventDetails) {
    this.rateLimiterEventDetails = rateLimiterEventDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property rebalance_migrate_details of obj type eventdetails field type str  type ref.
   * @return rebalanceMigrateDetails
   */
  public RebalanceMigrateEventDetails getRebalanceMigrateDetails() {
    return rebalanceMigrateDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property rebalance_migrate_details of obj type eventdetails field type str  type ref.
   * @param rebalanceMigrateDetails set the rebalanceMigrateDetails.
   */
  public void setRebalanceMigrateDetails(RebalanceMigrateEventDetails rebalanceMigrateDetails) {
    this.rebalanceMigrateDetails = rebalanceMigrateDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property rebalance_scalein_details of obj type eventdetails field type str  type ref.
   * @return rebalanceScaleinDetails
   */
  public RebalanceScaleinEventDetails getRebalanceScaleinDetails() {
    return rebalanceScaleinDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property rebalance_scalein_details of obj type eventdetails field type str  type ref.
   * @param rebalanceScaleinDetails set the rebalanceScaleinDetails.
   */
  public void setRebalanceScaleinDetails(RebalanceScaleinEventDetails rebalanceScaleinDetails) {
    this.rebalanceScaleinDetails = rebalanceScaleinDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property rebalance_scaleout_details of obj type eventdetails field type str  type ref.
   * @return rebalanceScaleoutDetails
   */
  public RebalanceScaleoutEventDetails getRebalanceScaleoutDetails() {
    return rebalanceScaleoutDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property rebalance_scaleout_details of obj type eventdetails field type str  type ref.
   * @param rebalanceScaleoutDetails set the rebalanceScaleoutDetails.
   */
  public void setRebalanceScaleoutDetails(RebalanceScaleoutEventDetails rebalanceScaleoutDetails) {
    this.rebalanceScaleoutDetails = rebalanceScaleoutDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property reboot_se_details of obj type eventdetails field type str  type ref.
   * @return rebootSeDetails
   */
  public RmRebootSeEventDetails getRebootSeDetails() {
    return rebootSeDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property reboot_se_details of obj type eventdetails field type str  type ref.
   * @param rebootSeDetails set the rebootSeDetails.
   */
  public void setRebootSeDetails(RmRebootSeEventDetails rebootSeDetails) {
    this.rebootSeDetails = rebootSeDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property scheduler_action_info of obj type eventdetails field type str  type ref.
   * @return schedulerActionInfo
   */
  public SchedulerActionDetails getSchedulerActionInfo() {
    return schedulerActionInfo;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property scheduler_action_info of obj type eventdetails field type str  type ref.
   * @param schedulerActionInfo set the schedulerActionInfo.
   */
  public void setSchedulerActionInfo(SchedulerActionDetails schedulerActionInfo) {
    this.schedulerActionInfo = schedulerActionInfo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 20.1.1.
   * @return seBgpPeerDownDetails
   */
  public SeBgpPeerDownDetails getSeBgpPeerDownDetails() {
    return seBgpPeerDownDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 20.1.1.
   * @param seBgpPeerDownDetails set the seBgpPeerDownDetails.
   */
  public void setSeBgpPeerDownDetails(SeBgpPeerDownDetails seBgpPeerDownDetails) {
    this.seBgpPeerDownDetails = seBgpPeerDownDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_bgp_peer_state_change_details of obj type eventdetails field type str  type ref.
   * @return seBgpPeerStateChangeDetails
   */
  public SeBgpPeerStateChangeDetails getSeBgpPeerStateChangeDetails() {
    return seBgpPeerStateChangeDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_bgp_peer_state_change_details of obj type eventdetails field type str  type ref.
   * @param seBgpPeerStateChangeDetails set the seBgpPeerStateChangeDetails.
   */
  public void setSeBgpPeerStateChangeDetails(SeBgpPeerStateChangeDetails seBgpPeerStateChangeDetails) {
    this.seBgpPeerStateChangeDetails = seBgpPeerStateChangeDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_details of obj type eventdetails field type str  type ref.
   * @return seDetails
   */
  public SeMgrEventDetails getSeDetails() {
    return seDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_details of obj type eventdetails field type str  type ref.
   * @param seDetails set the seDetails.
   */
  public void setSeDetails(SeMgrEventDetails seDetails) {
    this.seDetails = seDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_dupip_event_details of obj type eventdetails field type str  type ref.
   * @return seDupipEventDetails
   */
  public SeDupipEventDetails getSeDupipEventDetails() {
    return seDupipEventDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_dupip_event_details of obj type eventdetails field type str  type ref.
   * @param seDupipEventDetails set the seDupipEventDetails.
   */
  public void setSeDupipEventDetails(SeDupipEventDetails seDupipEventDetails) {
    this.seDupipEventDetails = seDupipEventDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_gateway_heartbeat_failed_details of obj type eventdetails field type str  type ref.
   * @return seGatewayHeartbeatFailedDetails
   */
  public SeGatewayHeartbeatFailedDetails getSeGatewayHeartbeatFailedDetails() {
    return seGatewayHeartbeatFailedDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_gateway_heartbeat_failed_details of obj type eventdetails field type str  type ref.
   * @param seGatewayHeartbeatFailedDetails set the seGatewayHeartbeatFailedDetails.
   */
  public void setSeGatewayHeartbeatFailedDetails(SeGatewayHeartbeatFailedDetails seGatewayHeartbeatFailedDetails) {
    this.seGatewayHeartbeatFailedDetails = seGatewayHeartbeatFailedDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_gateway_heartbeat_success_details of obj type eventdetails field type str  type ref.
   * @return seGatewayHeartbeatSuccessDetails
   */
  public SeGatewayHeartbeatSuccessDetails getSeGatewayHeartbeatSuccessDetails() {
    return seGatewayHeartbeatSuccessDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_gateway_heartbeat_success_details of obj type eventdetails field type str  type ref.
   * @param seGatewayHeartbeatSuccessDetails set the seGatewayHeartbeatSuccessDetails.
   */
  public void setSeGatewayHeartbeatSuccessDetails(SeGatewayHeartbeatSuccessDetails seGatewayHeartbeatSuccessDetails) {
    this.seGatewayHeartbeatSuccessDetails = seGatewayHeartbeatSuccessDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_geo_db_details of obj type eventdetails field type str  type ref.
   * @return seGeoDbDetails
   */
  public SeGeoDbDetails getSeGeoDbDetails() {
    return seGeoDbDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_geo_db_details of obj type eventdetails field type str  type ref.
   * @param seGeoDbDetails set the seGeoDbDetails.
   */
  public void setSeGeoDbDetails(SeGeoDbDetails seGeoDbDetails) {
    this.seGeoDbDetails = seGeoDbDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_hb_event_details of obj type eventdetails field type str  type ref.
   * @return seHbEventDetails
   */
  public SeHBEventDetails getSeHbEventDetails() {
    return seHbEventDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_hb_event_details of obj type eventdetails field type str  type ref.
   * @param seHbEventDetails set the seHbEventDetails.
   */
  public void setSeHbEventDetails(SeHBEventDetails seHbEventDetails) {
    this.seHbEventDetails = seHbEventDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Inter-se datapath heartbeat recovered.
   * One event is generated when heartbeat recovers.
   * Field introduced in 20.1.1.
   * @return seHbRecoveredEventDetails
   */
  public SeHbRecoveredEventDetails getSeHbRecoveredEventDetails() {
    return seHbRecoveredEventDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Inter-se datapath heartbeat recovered.
   * One event is generated when heartbeat recovers.
   * Field introduced in 20.1.1.
   * @param seHbRecoveredEventDetails set the seHbRecoveredEventDetails.
   */
  public void setSeHbRecoveredEventDetails(SeHbRecoveredEventDetails seHbRecoveredEventDetails) {
    this.seHbRecoveredEventDetails = seHbRecoveredEventDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_hm_gs_details of obj type eventdetails field type str  type ref.
   * @return seHmGsDetails
   */
  public SeHmEventGSDetails getSeHmGsDetails() {
    return seHmGsDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_hm_gs_details of obj type eventdetails field type str  type ref.
   * @param seHmGsDetails set the seHmGsDetails.
   */
  public void setSeHmGsDetails(SeHmEventGSDetails seHmGsDetails) {
    this.seHmGsDetails = seHmGsDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_hm_gsgroup_details of obj type eventdetails field type str  type ref.
   * @return seHmGsgroupDetails
   */
  public SeHmEventGslbPoolDetails getSeHmGsgroupDetails() {
    return seHmGsgroupDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_hm_gsgroup_details of obj type eventdetails field type str  type ref.
   * @param seHmGsgroupDetails set the seHmGsgroupDetails.
   */
  public void setSeHmGsgroupDetails(SeHmEventGslbPoolDetails seHmGsgroupDetails) {
    this.seHmGsgroupDetails = seHmGsgroupDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_hm_pool_details of obj type eventdetails field type str  type ref.
   * @return seHmPoolDetails
   */
  public SeHmEventPoolDetails getSeHmPoolDetails() {
    return seHmPoolDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_hm_pool_details of obj type eventdetails field type str  type ref.
   * @param seHmPoolDetails set the seHmPoolDetails.
   */
  public void setSeHmPoolDetails(SeHmEventPoolDetails seHmPoolDetails) {
    this.seHmPoolDetails = seHmPoolDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_hm_vs_details of obj type eventdetails field type str  type ref.
   * @return seHmVsDetails
   */
  public SeHmEventVsDetails getSeHmVsDetails() {
    return seHmVsDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_hm_vs_details of obj type eventdetails field type str  type ref.
   * @param seHmVsDetails set the seHmVsDetails.
   */
  public void setSeHmVsDetails(SeHmEventVsDetails seHmVsDetails) {
    this.seHmVsDetails = seHmVsDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_ip6_dad_failed_event_details of obj type eventdetails field type str  type ref.
   * @return seIp6DadFailedEventDetails
   */
  public SeIP6DadFailedEventDetails getSeIp6DadFailedEventDetails() {
    return seIp6DadFailedEventDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_ip6_dad_failed_event_details of obj type eventdetails field type str  type ref.
   * @param seIp6DadFailedEventDetails set the seIp6DadFailedEventDetails.
   */
  public void setSeIp6DadFailedEventDetails(SeIP6DadFailedEventDetails seIp6DadFailedEventDetails) {
    this.seIp6DadFailedEventDetails = seIp6DadFailedEventDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_ip_added_event_details of obj type eventdetails field type str  type ref.
   * @return seIpAddedEventDetails
   */
  public SeIpAddedEventDetails getSeIpAddedEventDetails() {
    return seIpAddedEventDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_ip_added_event_details of obj type eventdetails field type str  type ref.
   * @param seIpAddedEventDetails set the seIpAddedEventDetails.
   */
  public void setSeIpAddedEventDetails(SeIpAddedEventDetails seIpAddedEventDetails) {
    this.seIpAddedEventDetails = seIpAddedEventDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_ip_removed_event_details of obj type eventdetails field type str  type ref.
   * @return seIpRemovedEventDetails
   */
  public SeIpRemovedEventDetails getSeIpRemovedEventDetails() {
    return seIpRemovedEventDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_ip_removed_event_details of obj type eventdetails field type str  type ref.
   * @param seIpRemovedEventDetails set the seIpRemovedEventDetails.
   */
  public void setSeIpRemovedEventDetails(SeIpRemovedEventDetails seIpRemovedEventDetails) {
    this.seIpRemovedEventDetails = seIpRemovedEventDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_ipfailure_event_details of obj type eventdetails field type str  type ref.
   * @return seIpfailureEventDetails
   */
  public SeIpfailureEventDetails getSeIpfailureEventDetails() {
    return seIpfailureEventDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_ipfailure_event_details of obj type eventdetails field type str  type ref.
   * @param seIpfailureEventDetails set the seIpfailureEventDetails.
   */
  public void setSeIpfailureEventDetails(SeIpfailureEventDetails seIpfailureEventDetails) {
    this.seIpfailureEventDetails = seIpfailureEventDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_licensed_bandwdith_exceeded_event_details of obj type eventdetails field type str  type ref.
   * @return seLicensedBandwdithExceededEventDetails
   */
  public SeLicensedBandwdithExceededEventDetails getSeLicensedBandwdithExceededEventDetails() {
    return seLicensedBandwdithExceededEventDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_licensed_bandwdith_exceeded_event_details of obj type eventdetails field type str  type ref.
   * @param seLicensedBandwdithExceededEventDetails set the seLicensedBandwdithExceededEventDetails.
   */
  public void setSeLicensedBandwdithExceededEventDetails(SeLicensedBandwdithExceededEventDetails seLicensedBandwdithExceededEventDetails) {
    this.seLicensedBandwdithExceededEventDetails = seLicensedBandwdithExceededEventDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 18.2.2.
   * @return seMemoryLimitEventDetails
   */
  public SeMemoryLimitEventDetails getSeMemoryLimitEventDetails() {
    return seMemoryLimitEventDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 18.2.2.
   * @param seMemoryLimitEventDetails set the seMemoryLimitEventDetails.
   */
  public void setSeMemoryLimitEventDetails(SeMemoryLimitEventDetails seMemoryLimitEventDetails) {
    this.seMemoryLimitEventDetails = seMemoryLimitEventDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_persistence_details of obj type eventdetails field type str  type ref.
   * @return sePersistenceDetails
   */
  public SePersistenceEventDetails getSePersistenceDetails() {
    return sePersistenceDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_persistence_details of obj type eventdetails field type str  type ref.
   * @param sePersistenceDetails set the sePersistenceDetails.
   */
  public void setSePersistenceDetails(SePersistenceEventDetails sePersistenceDetails) {
    this.sePersistenceDetails = sePersistenceDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_pool_lb_details of obj type eventdetails field type str  type ref.
   * @return sePoolLbDetails
   */
  public SePoolLbEventDetails getSePoolLbDetails() {
    return sePoolLbDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_pool_lb_details of obj type eventdetails field type str  type ref.
   * @param sePoolLbDetails set the sePoolLbDetails.
   */
  public void setSePoolLbDetails(SePoolLbEventDetails sePoolLbDetails) {
    this.sePoolLbDetails = sePoolLbDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_reconcile_details of obj type eventdetails field type str  type ref.
   * @return seReconcileDetails
   */
  public SeReconcileDetails getSeReconcileDetails() {
    return seReconcileDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_reconcile_details of obj type eventdetails field type str  type ref.
   * @param seReconcileDetails set the seReconcileDetails.
   */
  public void setSeReconcileDetails(SeReconcileDetails seReconcileDetails) {
    this.seReconcileDetails = seReconcileDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_thresh_event_details of obj type eventdetails field type str  type ref.
   * @return seThreshEventDetails
   */
  public SeThreshEventDetails getSeThreshEventDetails() {
    return seThreshEventDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_thresh_event_details of obj type eventdetails field type str  type ref.
   * @param seThreshEventDetails set the seThreshEventDetails.
   */
  public void setSeThreshEventDetails(SeThreshEventDetails seThreshEventDetails) {
    this.seThreshEventDetails = seThreshEventDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_version_check_details of obj type eventdetails field type str  type ref.
   * @return seVersionCheckDetails
   */
  public SeVersionCheckFailedEvent getSeVersionCheckDetails() {
    return seVersionCheckDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_version_check_details of obj type eventdetails field type str  type ref.
   * @param seVersionCheckDetails set the seVersionCheckDetails.
   */
  public void setSeVersionCheckDetails(SeVersionCheckFailedEvent seVersionCheckDetails) {
    this.seVersionCheckDetails = seVersionCheckDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_vnic_down_event_details of obj type eventdetails field type str  type ref.
   * @return seVnicDownEventDetails
   */
  public SeVnicDownEventDetails getSeVnicDownEventDetails() {
    return seVnicDownEventDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_vnic_down_event_details of obj type eventdetails field type str  type ref.
   * @param seVnicDownEventDetails set the seVnicDownEventDetails.
   */
  public void setSeVnicDownEventDetails(SeVnicDownEventDetails seVnicDownEventDetails) {
    this.seVnicDownEventDetails = seVnicDownEventDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_vnic_tx_queue_stall_event_details of obj type eventdetails field type str  type ref.
   * @return seVnicTxQueueStallEventDetails
   */
  public SeVnicTxQueueStallEventDetails getSeVnicTxQueueStallEventDetails() {
    return seVnicTxQueueStallEventDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_vnic_tx_queue_stall_event_details of obj type eventdetails field type str  type ref.
   * @param seVnicTxQueueStallEventDetails set the seVnicTxQueueStallEventDetails.
   */
  public void setSeVnicTxQueueStallEventDetails(SeVnicTxQueueStallEventDetails seVnicTxQueueStallEventDetails) {
    this.seVnicTxQueueStallEventDetails = seVnicTxQueueStallEventDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_vnic_up_event_details of obj type eventdetails field type str  type ref.
   * @return seVnicUpEventDetails
   */
  public SeVnicUpEventDetails getSeVnicUpEventDetails() {
    return seVnicUpEventDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_vnic_up_event_details of obj type eventdetails field type str  type ref.
   * @param seVnicUpEventDetails set the seVnicUpEventDetails.
   */
  public void setSeVnicUpEventDetails(SeVnicUpEventDetails seVnicUpEventDetails) {
    this.seVnicUpEventDetails = seVnicUpEventDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_vs_fault_event_details of obj type eventdetails field type str  type ref.
   * @return seVsFaultEventDetails
   */
  public SeVsFaultEventDetails getSeVsFaultEventDetails() {
    return seVsFaultEventDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_vs_fault_event_details of obj type eventdetails field type str  type ref.
   * @param seVsFaultEventDetails set the seVsFaultEventDetails.
   */
  public void setSeVsFaultEventDetails(SeVsFaultEventDetails seVsFaultEventDetails) {
    this.seVsFaultEventDetails = seVsFaultEventDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property sec_mgr_data_event of obj type eventdetails field type str  type ref.
   * @return secMgrDataEvent
   */
  public SecMgrDataEvent getSecMgrDataEvent() {
    return secMgrDataEvent;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property sec_mgr_data_event of obj type eventdetails field type str  type ref.
   * @param secMgrDataEvent set the secMgrDataEvent.
   */
  public void setSecMgrDataEvent(SecMgrDataEvent secMgrDataEvent) {
    this.secMgrDataEvent = secMgrDataEvent;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property semigrate_event_details of obj type eventdetails field type str  type ref.
   * @return semigrateEventDetails
   */
  public SeMigrateEventDetails getSemigrateEventDetails() {
    return semigrateEventDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property semigrate_event_details of obj type eventdetails field type str  type ref.
   * @param semigrateEventDetails set the semigrateEventDetails.
   */
  public void setSemigrateEventDetails(SeMigrateEventDetails semigrateEventDetails) {
    this.semigrateEventDetails = semigrateEventDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property server_autoscale_failed_info of obj type eventdetails field type str  type ref.
   * @return serverAutoscaleFailedInfo
   */
  public ServerAutoScaleFailedInfo getServerAutoscaleFailedInfo() {
    return serverAutoscaleFailedInfo;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property server_autoscale_failed_info of obj type eventdetails field type str  type ref.
   * @param serverAutoscaleFailedInfo set the serverAutoscaleFailedInfo.
   */
  public void setServerAutoscaleFailedInfo(ServerAutoScaleFailedInfo serverAutoscaleFailedInfo) {
    this.serverAutoscaleFailedInfo = serverAutoscaleFailedInfo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property server_autoscalein_complete_info of obj type eventdetails field type str  type ref.
   * @return serverAutoscaleinCompleteInfo
   */
  public ServerAutoScaleInCompleteInfo getServerAutoscaleinCompleteInfo() {
    return serverAutoscaleinCompleteInfo;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property server_autoscalein_complete_info of obj type eventdetails field type str  type ref.
   * @param serverAutoscaleinCompleteInfo set the serverAutoscaleinCompleteInfo.
   */
  public void setServerAutoscaleinCompleteInfo(ServerAutoScaleInCompleteInfo serverAutoscaleinCompleteInfo) {
    this.serverAutoscaleinCompleteInfo = serverAutoscaleinCompleteInfo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property server_autoscalein_info of obj type eventdetails field type str  type ref.
   * @return serverAutoscaleinInfo
   */
  public ServerAutoScaleInInfo getServerAutoscaleinInfo() {
    return serverAutoscaleinInfo;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property server_autoscalein_info of obj type eventdetails field type str  type ref.
   * @param serverAutoscaleinInfo set the serverAutoscaleinInfo.
   */
  public void setServerAutoscaleinInfo(ServerAutoScaleInInfo serverAutoscaleinInfo) {
    this.serverAutoscaleinInfo = serverAutoscaleinInfo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property server_autoscaleout_complete_info of obj type eventdetails field type str  type ref.
   * @return serverAutoscaleoutCompleteInfo
   */
  public ServerAutoScaleOutCompleteInfo getServerAutoscaleoutCompleteInfo() {
    return serverAutoscaleoutCompleteInfo;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property server_autoscaleout_complete_info of obj type eventdetails field type str  type ref.
   * @param serverAutoscaleoutCompleteInfo set the serverAutoscaleoutCompleteInfo.
   */
  public void setServerAutoscaleoutCompleteInfo(ServerAutoScaleOutCompleteInfo serverAutoscaleoutCompleteInfo) {
    this.serverAutoscaleoutCompleteInfo = serverAutoscaleoutCompleteInfo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property server_autoscaleout_info of obj type eventdetails field type str  type ref.
   * @return serverAutoscaleoutInfo
   */
  public ServerAutoScaleOutInfo getServerAutoscaleoutInfo() {
    return serverAutoscaleoutInfo;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property server_autoscaleout_info of obj type eventdetails field type str  type ref.
   * @param serverAutoscaleoutInfo set the serverAutoscaleoutInfo.
   */
  public void setServerAutoscaleoutInfo(ServerAutoScaleOutInfo serverAutoscaleoutInfo) {
    this.serverAutoscaleoutInfo = serverAutoscaleoutInfo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property seupgrade_disrupted_details of obj type eventdetails field type str  type ref.
   * @return seupgradeDisruptedDetails
   */
  public SeUpgradeVsDisruptedEventDetails getSeupgradeDisruptedDetails() {
    return seupgradeDisruptedDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property seupgrade_disrupted_details of obj type eventdetails field type str  type ref.
   * @param seupgradeDisruptedDetails set the seupgradeDisruptedDetails.
   */
  public void setSeupgradeDisruptedDetails(SeUpgradeVsDisruptedEventDetails seupgradeDisruptedDetails) {
    this.seupgradeDisruptedDetails = seupgradeDisruptedDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property seupgrade_event_details of obj type eventdetails field type str  type ref.
   * @return seupgradeEventDetails
   */
  public SeUpgradeEventDetails getSeupgradeEventDetails() {
    return seupgradeEventDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property seupgrade_event_details of obj type eventdetails field type str  type ref.
   * @param seupgradeEventDetails set the seupgradeEventDetails.
   */
  public void setSeupgradeEventDetails(SeUpgradeEventDetails seupgradeEventDetails) {
    this.seupgradeEventDetails = seupgradeEventDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property seupgrade_migrate_details of obj type eventdetails field type str  type ref.
   * @return seupgradeMigrateDetails
   */
  public SeUpgradeMigrateEventDetails getSeupgradeMigrateDetails() {
    return seupgradeMigrateDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property seupgrade_migrate_details of obj type eventdetails field type str  type ref.
   * @param seupgradeMigrateDetails set the seupgradeMigrateDetails.
   */
  public void setSeupgradeMigrateDetails(SeUpgradeMigrateEventDetails seupgradeMigrateDetails) {
    this.seupgradeMigrateDetails = seupgradeMigrateDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property seupgrade_scalein_details of obj type eventdetails field type str  type ref.
   * @return seupgradeScaleinDetails
   */
  public SeUpgradeScaleinEventDetails getSeupgradeScaleinDetails() {
    return seupgradeScaleinDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property seupgrade_scalein_details of obj type eventdetails field type str  type ref.
   * @param seupgradeScaleinDetails set the seupgradeScaleinDetails.
   */
  public void setSeupgradeScaleinDetails(SeUpgradeScaleinEventDetails seupgradeScaleinDetails) {
    this.seupgradeScaleinDetails = seupgradeScaleinDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property seupgrade_scaleout_details of obj type eventdetails field type str  type ref.
   * @return seupgradeScaleoutDetails
   */
  public SeUpgradeScaleoutEventDetails getSeupgradeScaleoutDetails() {
    return seupgradeScaleoutDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property seupgrade_scaleout_details of obj type eventdetails field type str  type ref.
   * @param seupgradeScaleoutDetails set the seupgradeScaleoutDetails.
   */
  public void setSeupgradeScaleoutDetails(SeUpgradeScaleoutEventDetails seupgradeScaleoutDetails) {
    this.seupgradeScaleoutDetails = seupgradeScaleoutDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property spawn_se_details of obj type eventdetails field type str  type ref.
   * @return spawnSeDetails
   */
  public RmSpawnSeEventDetails getSpawnSeDetails() {
    return spawnSeDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property spawn_se_details of obj type eventdetails field type str  type ref.
   * @param spawnSeDetails set the spawnSeDetails.
   */
  public void setSpawnSeDetails(RmSpawnSeEventDetails spawnSeDetails) {
    this.spawnSeDetails = spawnSeDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ssl_expire_details of obj type eventdetails field type str  type ref.
   * @return sslExpireDetails
   */
  public SSLExpireDetails getSslExpireDetails() {
    return sslExpireDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ssl_expire_details of obj type eventdetails field type str  type ref.
   * @param sslExpireDetails set the sslExpireDetails.
   */
  public void setSslExpireDetails(SSLExpireDetails sslExpireDetails) {
    this.sslExpireDetails = sslExpireDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ssl_export_details of obj type eventdetails field type str  type ref.
   * @return sslExportDetails
   */
  public SSLExportDetails getSslExportDetails() {
    return sslExportDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ssl_export_details of obj type eventdetails field type str  type ref.
   * @param sslExportDetails set the sslExportDetails.
   */
  public void setSslExportDetails(SSLExportDetails sslExportDetails) {
    this.sslExportDetails = sslExportDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ssl_ignored_details of obj type eventdetails field type str  type ref.
   * @return sslIgnoredDetails
   */
  public SSLIgnoredDetails getSslIgnoredDetails() {
    return sslIgnoredDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ssl_ignored_details of obj type eventdetails field type str  type ref.
   * @param sslIgnoredDetails set the sslIgnoredDetails.
   */
  public void setSslIgnoredDetails(SSLIgnoredDetails sslIgnoredDetails) {
    this.sslIgnoredDetails = sslIgnoredDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ssl_renew_details of obj type eventdetails field type str  type ref.
   * @return sslRenewDetails
   */
  public SSLRenewDetails getSslRenewDetails() {
    return sslRenewDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ssl_renew_details of obj type eventdetails field type str  type ref.
   * @param sslRenewDetails set the sslRenewDetails.
   */
  public void setSslRenewDetails(SSLRenewDetails sslRenewDetails) {
    this.sslRenewDetails = sslRenewDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ssl_renew_failed_details of obj type eventdetails field type str  type ref.
   * @return sslRenewFailedDetails
   */
  public SSLRenewFailedDetails getSslRenewFailedDetails() {
    return sslRenewFailedDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ssl_renew_failed_details of obj type eventdetails field type str  type ref.
   * @param sslRenewFailedDetails set the sslRenewFailedDetails.
   */
  public void setSslRenewFailedDetails(SSLRenewFailedDetails sslRenewFailedDetails) {
    this.sslRenewFailedDetails = sslRenewFailedDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ssl_revoked_details of obj type eventdetails field type str  type ref.
   * @return sslRevokedDetails
   */
  public SSLRevokedDetails getSslRevokedDetails() {
    return sslRevokedDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ssl_revoked_details of obj type eventdetails field type str  type ref.
   * @param sslRevokedDetails set the sslRevokedDetails.
   */
  public void setSslRevokedDetails(SSLRevokedDetails sslRevokedDetails) {
    this.sslRevokedDetails = sslRevokedDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property switchover_details of obj type eventdetails field type str  type ref.
   * @return switchoverDetails
   */
  public SwitchoverEventDetails getSwitchoverDetails() {
    return switchoverDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property switchover_details of obj type eventdetails field type str  type ref.
   * @param switchoverDetails set the switchoverDetails.
   */
  public void setSwitchoverDetails(SwitchoverEventDetails switchoverDetails) {
    this.switchoverDetails = switchoverDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property switchover_fail_details of obj type eventdetails field type str  type ref.
   * @return switchoverFailDetails
   */
  public SwitchoverFailEventDetails getSwitchoverFailDetails() {
    return switchoverFailDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property switchover_fail_details of obj type eventdetails field type str  type ref.
   * @param switchoverFailDetails set the switchoverFailDetails.
   */
  public void setSwitchoverFailDetails(SwitchoverFailEventDetails switchoverFailDetails) {
    this.switchoverFailDetails = switchoverFailDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Azure cloud sync services event details.
   * Field introduced in 18.2.3.
   * @return syncServicesInfo
   */
  public CloudSyncServices getSyncServicesInfo() {
    return syncServicesInfo;
  }

  /**
   * This is the setter method to the attribute.
   * Azure cloud sync services event details.
   * Field introduced in 18.2.3.
   * @param syncServicesInfo set the syncServicesInfo.
   */
  public void setSyncServicesInfo(CloudSyncServices syncServicesInfo) {
    this.syncServicesInfo = syncServicesInfo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property system_upgrade_details of obj type eventdetails field type str  type ref.
   * @return systemUpgradeDetails
   */
  public SystemUpgradeDetails getSystemUpgradeDetails() {
    return systemUpgradeDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property system_upgrade_details of obj type eventdetails field type str  type ref.
   * @param systemUpgradeDetails set the systemUpgradeDetails.
   */
  public void setSystemUpgradeDetails(SystemUpgradeDetails systemUpgradeDetails) {
    this.systemUpgradeDetails = systemUpgradeDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property tencent_info of obj type eventdetails field type str  type ref.
   * @return tencentInfo
   */
  public TencentSetup getTencentInfo() {
    return tencentInfo;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property tencent_info of obj type eventdetails field type str  type ref.
   * @param tencentInfo set the tencentInfo.
   */
  public void setTencentInfo(TencentSetup tencentInfo) {
    this.tencentInfo = tencentInfo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property unbind_vs_se_details of obj type eventdetails field type str  type ref.
   * @return unbindVsSeDetails
   */
  public RmUnbindVsSeEventDetails getUnbindVsSeDetails() {
    return unbindVsSeDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property unbind_vs_se_details of obj type eventdetails field type str  type ref.
   * @param unbindVsSeDetails set the unbindVsSeDetails.
   */
  public void setUnbindVsSeDetails(RmUnbindVsSeEventDetails unbindVsSeDetails) {
    this.unbindVsSeDetails = unbindVsSeDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 18.2.6.
   * @return upgradeEntry
   */
  public UpgradeOpsEntry getUpgradeEntry() {
    return upgradeEntry;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 18.2.6.
   * @param upgradeEntry set the upgradeEntry.
   */
  public void setUpgradeEntry(UpgradeOpsEntry upgradeEntry) {
    this.upgradeEntry = upgradeEntry;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 18.2.6.
   * @return upgradeStatusInfo
   */
  public UpgradeStatusInfo getUpgradeStatusInfo() {
    return upgradeStatusInfo;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 18.2.6.
   * @param upgradeStatusInfo set the upgradeStatusInfo.
   */
  public void setUpgradeStatusInfo(UpgradeStatusInfo upgradeStatusInfo) {
    this.upgradeStatusInfo = upgradeStatusInfo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vca_infra_details of obj type eventdetails field type str  type ref.
   * @return vcaInfraDetails
   */
  public VCASetup getVcaInfraDetails() {
    return vcaInfraDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vca_infra_details of obj type eventdetails field type str  type ref.
   * @param vcaInfraDetails set the vcaInfraDetails.
   */
  public void setVcaInfraDetails(VCASetup vcaInfraDetails) {
    this.vcaInfraDetails = vcaInfraDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vcenter_connectivity_status of obj type eventdetails field type str  type ref.
   * @return vcenterConnectivityStatus
   */
  public VinfraVcenterConnectivityStatus getVcenterConnectivityStatus() {
    return vcenterConnectivityStatus;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vcenter_connectivity_status of obj type eventdetails field type str  type ref.
   * @param vcenterConnectivityStatus set the vcenterConnectivityStatus.
   */
  public void setVcenterConnectivityStatus(VinfraVcenterConnectivityStatus vcenterConnectivityStatus) {
    this.vcenterConnectivityStatus = vcenterConnectivityStatus;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vcenter_details of obj type eventdetails field type str  type ref.
   * @return vcenterDetails
   */
  public VinfraVcenterBadCredentials getVcenterDetails() {
    return vcenterDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vcenter_details of obj type eventdetails field type str  type ref.
   * @param vcenterDetails set the vcenterDetails.
   */
  public void setVcenterDetails(VinfraVcenterBadCredentials vcenterDetails) {
    this.vcenterDetails = vcenterDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vcenter_disc_failure of obj type eventdetails field type str  type ref.
   * @return vcenterDiscFailure
   */
  public VinfraVcenterDiscoveryFailure getVcenterDiscFailure() {
    return vcenterDiscFailure;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vcenter_disc_failure of obj type eventdetails field type str  type ref.
   * @param vcenterDiscFailure set the vcenterDiscFailure.
   */
  public void setVcenterDiscFailure(VinfraVcenterDiscoveryFailure vcenterDiscFailure) {
    this.vcenterDiscFailure = vcenterDiscFailure;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vcenter_network_limit of obj type eventdetails field type str  type ref.
   * @return vcenterNetworkLimit
   */
  public VinfraVcenterNetworkLimit getVcenterNetworkLimit() {
    return vcenterNetworkLimit;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vcenter_network_limit of obj type eventdetails field type str  type ref.
   * @param vcenterNetworkLimit set the vcenterNetworkLimit.
   */
  public void setVcenterNetworkLimit(VinfraVcenterNetworkLimit vcenterNetworkLimit) {
    this.vcenterNetworkLimit = vcenterNetworkLimit;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vcenter_obj_delete_details of obj type eventdetails field type str  type ref.
   * @return vcenterObjDeleteDetails
   */
  public VinfraVcenterObjDeleteDetails getVcenterObjDeleteDetails() {
    return vcenterObjDeleteDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vcenter_obj_delete_details of obj type eventdetails field type str  type ref.
   * @param vcenterObjDeleteDetails set the vcenterObjDeleteDetails.
   */
  public void setVcenterObjDeleteDetails(VinfraVcenterObjDeleteDetails vcenterObjDeleteDetails) {
    this.vcenterObjDeleteDetails = vcenterObjDeleteDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vip_autoscale of obj type eventdetails field type str  type ref.
   * @return vipAutoscale
   */
  public VipScaleDetails getVipAutoscale() {
    return vipAutoscale;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vip_autoscale of obj type eventdetails field type str  type ref.
   * @param vipAutoscale set the vipAutoscale.
   */
  public void setVipAutoscale(VipScaleDetails vipAutoscale) {
    this.vipAutoscale = vipAutoscale;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vip_dns_info of obj type eventdetails field type str  type ref.
   * @return vipDnsInfo
   */
  public DNSRegisterInfo getVipDnsInfo() {
    return vipDnsInfo;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vip_dns_info of obj type eventdetails field type str  type ref.
   * @param vipDnsInfo set the vipDnsInfo.
   */
  public void setVipDnsInfo(DNSRegisterInfo vipDnsInfo) {
    this.vipDnsInfo = vipDnsInfo;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vm_details of obj type eventdetails field type str  type ref.
   * @return vmDetails
   */
  public VinfraVmDetails getVmDetails() {
    return vmDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vm_details of obj type eventdetails field type str  type ref.
   * @param vmDetails set the vmDetails.
   */
  public void setVmDetails(VinfraVmDetails vmDetails) {
    this.vmDetails = vmDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vs_awaitingse_details of obj type eventdetails field type str  type ref.
   * @return vsAwaitingseDetails
   */
  public VsAwaitingSeEventDetails getVsAwaitingseDetails() {
    return vsAwaitingseDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vs_awaitingse_details of obj type eventdetails field type str  type ref.
   * @param vsAwaitingseDetails set the vsAwaitingseDetails.
   */
  public void setVsAwaitingseDetails(VsAwaitingSeEventDetails vsAwaitingseDetails) {
    this.vsAwaitingseDetails = vsAwaitingseDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vs_error_details of obj type eventdetails field type str  type ref.
   * @return vsErrorDetails
   */
  public VsErrorEventDetails getVsErrorDetails() {
    return vsErrorDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vs_error_details of obj type eventdetails field type str  type ref.
   * @param vsErrorDetails set the vsErrorDetails.
   */
  public void setVsErrorDetails(VsErrorEventDetails vsErrorDetails) {
    this.vsErrorDetails = vsErrorDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vs_fsm_details of obj type eventdetails field type str  type ref.
   * @return vsFsmDetails
   */
  public VsFsmEventDetails getVsFsmDetails() {
    return vsFsmDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vs_fsm_details of obj type eventdetails field type str  type ref.
   * @param vsFsmDetails set the vsFsmDetails.
   */
  public void setVsFsmDetails(VsFsmEventDetails vsFsmDetails) {
    this.vsFsmDetails = vsFsmDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vs_initialplacement_details of obj type eventdetails field type str  type ref.
   * @return vsInitialplacementDetails
   */
  public VsInitialPlacementEventDetails getVsInitialplacementDetails() {
    return vsInitialplacementDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vs_initialplacement_details of obj type eventdetails field type str  type ref.
   * @param vsInitialplacementDetails set the vsInitialplacementDetails.
   */
  public void setVsInitialplacementDetails(VsInitialPlacementEventDetails vsInitialplacementDetails) {
    this.vsInitialplacementDetails = vsInitialplacementDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vs_migrate_details of obj type eventdetails field type str  type ref.
   * @return vsMigrateDetails
   */
  public VsMigrateEventDetails getVsMigrateDetails() {
    return vsMigrateDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vs_migrate_details of obj type eventdetails field type str  type ref.
   * @param vsMigrateDetails set the vsMigrateDetails.
   */
  public void setVsMigrateDetails(VsMigrateEventDetails vsMigrateDetails) {
    this.vsMigrateDetails = vsMigrateDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vs_pool_nw_fltr_details of obj type eventdetails field type str  type ref.
   * @return vsPoolNwFltrDetails
   */
  public VsPoolNwFilterEventDetails getVsPoolNwFltrDetails() {
    return vsPoolNwFltrDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vs_pool_nw_fltr_details of obj type eventdetails field type str  type ref.
   * @param vsPoolNwFltrDetails set the vsPoolNwFltrDetails.
   */
  public void setVsPoolNwFltrDetails(VsPoolNwFilterEventDetails vsPoolNwFltrDetails) {
    this.vsPoolNwFltrDetails = vsPoolNwFltrDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vs_scalein_details of obj type eventdetails field type str  type ref.
   * @return vsScaleinDetails
   */
  public VsScaleInEventDetails getVsScaleinDetails() {
    return vsScaleinDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vs_scalein_details of obj type eventdetails field type str  type ref.
   * @param vsScaleinDetails set the vsScaleinDetails.
   */
  public void setVsScaleinDetails(VsScaleInEventDetails vsScaleinDetails) {
    this.vsScaleinDetails = vsScaleinDetails;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vs_scaleout_details of obj type eventdetails field type str  type ref.
   * @return vsScaleoutDetails
   */
  public VsScaleOutEventDetails getVsScaleoutDetails() {
    return vsScaleoutDetails;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vs_scaleout_details of obj type eventdetails field type str  type ref.
   * @param vsScaleoutDetails set the vsScaleoutDetails.
   */
  public void setVsScaleoutDetails(VsScaleOutEventDetails vsScaleoutDetails) {
    this.vsScaleoutDetails = vsScaleoutDetails;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  EventDetails objEventDetails = (EventDetails) o;
  return   Objects.equals(this.discSummary, objEventDetails.discSummary)&&
  Objects.equals(this.vcenterDetails, objEventDetails.vcenterDetails)&&
  Objects.equals(this.cntlrHostListDetails, objEventDetails.cntlrHostListDetails)&&
  Objects.equals(this.poolServerDeleteDetails, objEventDetails.poolServerDeleteDetails)&&
  Objects.equals(this.vmDetails, objEventDetails.vmDetails)&&
  Objects.equals(this.mgmtNwChangeDetails, objEventDetails.mgmtNwChangeDetails)&&
  Objects.equals(this.vcenterObjDeleteDetails, objEventDetails.vcenterObjDeleteDetails)&&
  Objects.equals(this.vcenterDiscFailure, objEventDetails.vcenterDiscFailure)&&
  Objects.equals(this.vcenterConnectivityStatus, objEventDetails.vcenterConnectivityStatus)&&
  Objects.equals(this.vcenterNetworkLimit, objEventDetails.vcenterNetworkLimit)&&
  Objects.equals(this.seDetails, objEventDetails.seDetails)&&
  Objects.equals(this.spawnSeDetails, objEventDetails.spawnSeDetails)&&
  Objects.equals(this.modifyNetworksDetails, objEventDetails.modifyNetworksDetails)&&
  Objects.equals(this.bindVsSeDetails, objEventDetails.bindVsSeDetails)&&
  Objects.equals(this.unbindVsSeDetails, objEventDetails.unbindVsSeDetails)&&
  Objects.equals(this.rebootSeDetails, objEventDetails.rebootSeDetails)&&
  Objects.equals(this.addNetworksDetails, objEventDetails.addNetworksDetails)&&
  Objects.equals(this.bootupFailDetails, objEventDetails.bootupFailDetails)&&
  Objects.equals(this.ipFailDetails, objEventDetails.ipFailDetails)&&
  Objects.equals(this.deleteSeDetails, objEventDetails.deleteSeDetails)&&
  Objects.equals(this.hostUnavailDetails, objEventDetails.hostUnavailDetails)&&
  Objects.equals(this.switchoverDetails, objEventDetails.switchoverDetails)&&
  Objects.equals(this.switchoverFailDetails, objEventDetails.switchoverFailDetails)&&
  Objects.equals(this.vsFsmDetails, objEventDetails.vsFsmDetails)&&
  Objects.equals(this.vsPoolNwFltrDetails, objEventDetails.vsPoolNwFltrDetails)&&
  Objects.equals(this.vsScaleoutDetails, objEventDetails.vsScaleoutDetails)&&
  Objects.equals(this.vsScaleinDetails, objEventDetails.vsScaleinDetails)&&
  Objects.equals(this.vsMigrateDetails, objEventDetails.vsMigrateDetails)&&
  Objects.equals(this.vsErrorDetails, objEventDetails.vsErrorDetails)&&
  Objects.equals(this.vsAwaitingseDetails, objEventDetails.vsAwaitingseDetails)&&
  Objects.equals(this.vsInitialplacementDetails, objEventDetails.vsInitialplacementDetails)&&
  Objects.equals(this.upgradeStatusInfo, objEventDetails.upgradeStatusInfo)&&
  Objects.equals(this.allSeupgradeEventDetails, objEventDetails.allSeupgradeEventDetails)&&
  Objects.equals(this.seupgradeEventDetails, objEventDetails.seupgradeEventDetails)&&
  Objects.equals(this.seupgradeScaleoutDetails, objEventDetails.seupgradeScaleoutDetails)&&
  Objects.equals(this.seupgradeScaleinDetails, objEventDetails.seupgradeScaleinDetails)&&
  Objects.equals(this.seupgradeMigrateDetails, objEventDetails.seupgradeMigrateDetails)&&
  Objects.equals(this.seupgradeDisruptedDetails, objEventDetails.seupgradeDisruptedDetails)&&
  Objects.equals(this.rebalanceScaleoutDetails, objEventDetails.rebalanceScaleoutDetails)&&
  Objects.equals(this.rebalanceScaleinDetails, objEventDetails.rebalanceScaleinDetails)&&
  Objects.equals(this.rebalanceMigrateDetails, objEventDetails.rebalanceMigrateDetails)&&
  Objects.equals(this.semigrateEventDetails, objEventDetails.semigrateEventDetails)&&
  Objects.equals(this.disableSeMigrateDetails, objEventDetails.disableSeMigrateDetails)&&
  Objects.equals(this.vipAutoscale, objEventDetails.vipAutoscale)&&
  Objects.equals(this.upgradeEntry, objEventDetails.upgradeEntry)&&
  Objects.equals(this.seThreshEventDetails, objEventDetails.seThreshEventDetails)&&
  Objects.equals(this.seHbEventDetails, objEventDetails.seHbEventDetails)&&
  Objects.equals(this.seVersionCheckDetails, objEventDetails.seVersionCheckDetails)&&
  Objects.equals(this.seIpfailureEventDetails, objEventDetails.seIpfailureEventDetails)&&
  Objects.equals(this.seDupipEventDetails, objEventDetails.seDupipEventDetails)&&
  Objects.equals(this.seIpAddedEventDetails, objEventDetails.seIpAddedEventDetails)&&
  Objects.equals(this.seIpRemovedEventDetails, objEventDetails.seIpRemovedEventDetails)&&
  Objects.equals(this.seGatewayHeartbeatFailedDetails, objEventDetails.seGatewayHeartbeatFailedDetails)&&
  Objects.equals(this.seGatewayHeartbeatSuccessDetails, objEventDetails.seGatewayHeartbeatSuccessDetails)&&
  Objects.equals(this.seVnicDownEventDetails, objEventDetails.seVnicDownEventDetails)&&
  Objects.equals(this.seVnicTxQueueStallEventDetails, objEventDetails.seVnicTxQueueStallEventDetails)&&
  Objects.equals(this.seBgpPeerStateChangeDetails, objEventDetails.seBgpPeerStateChangeDetails)&&
  Objects.equals(this.seLicensedBandwdithExceededEventDetails, objEventDetails.seLicensedBandwdithExceededEventDetails)&&
  Objects.equals(this.seVnicUpEventDetails, objEventDetails.seVnicUpEventDetails)&&
  Objects.equals(this.seVsFaultEventDetails, objEventDetails.seVsFaultEventDetails)&&
  Objects.equals(this.seIp6DadFailedEventDetails, objEventDetails.seIp6DadFailedEventDetails)&&
  Objects.equals(this.seMemoryLimitEventDetails, objEventDetails.seMemoryLimitEventDetails)&&
  Objects.equals(this.rateLimiterEventDetails, objEventDetails.rateLimiterEventDetails)&&
  Objects.equals(this.seHbRecoveredEventDetails, objEventDetails.seHbRecoveredEventDetails)&&
  Objects.equals(this.seBgpPeerDownDetails, objEventDetails.seBgpPeerDownDetails)&&
  Objects.equals(this.seHmPoolDetails, objEventDetails.seHmPoolDetails)&&
  Objects.equals(this.seHmVsDetails, objEventDetails.seHmVsDetails)&&
  Objects.equals(this.sePersistenceDetails, objEventDetails.sePersistenceDetails)&&
  Objects.equals(this.sePoolLbDetails, objEventDetails.sePoolLbDetails)&&
  Objects.equals(this.seHmGsgroupDetails, objEventDetails.seHmGsgroupDetails)&&
  Objects.equals(this.seHmGsDetails, objEventDetails.seHmGsDetails)&&
  Objects.equals(this.seGeoDbDetails, objEventDetails.seGeoDbDetails)&&
  Objects.equals(this.configCreateDetails, objEventDetails.configCreateDetails)&&
  Objects.equals(this.configUpdateDetails, objEventDetails.configUpdateDetails)&&
  Objects.equals(this.configDeleteDetails, objEventDetails.configDeleteDetails)&&
  Objects.equals(this.configUserLoginDetails, objEventDetails.configUserLoginDetails)&&
  Objects.equals(this.configUserLogoutDetails, objEventDetails.configUserLogoutDetails)&&
  Objects.equals(this.configActionDetails, objEventDetails.configActionDetails)&&
  Objects.equals(this.configPasswordChangeRequestDetails, objEventDetails.configPasswordChangeRequestDetails)&&
  Objects.equals(this.configUserAuthrzRuleDetails, objEventDetails.configUserAuthrzRuleDetails)&&
  Objects.equals(this.configUserNotAuthrzRuleDetails, objEventDetails.configUserNotAuthrzRuleDetails)&&
  Objects.equals(this.configSeGrpFlvUpdateDetails, objEventDetails.configSeGrpFlvUpdateDetails)&&
  Objects.equals(this.sslExpireDetails, objEventDetails.sslExpireDetails)&&
  Objects.equals(this.sslExportDetails, objEventDetails.sslExportDetails)&&
  Objects.equals(this.sslRenewDetails, objEventDetails.sslRenewDetails)&&
  Objects.equals(this.sslRenewFailedDetails, objEventDetails.sslRenewFailedDetails)&&
  Objects.equals(this.sslIgnoredDetails, objEventDetails.sslIgnoredDetails)&&
  Objects.equals(this.sslRevokedDetails, objEventDetails.sslRevokedDetails)&&
  Objects.equals(this.clusterNodeAddDetails, objEventDetails.clusterNodeAddDetails)&&
  Objects.equals(this.clusterNodeRemoveDetails, objEventDetails.clusterNodeRemoveDetails)&&
  Objects.equals(this.clusterServiceFailedDetails, objEventDetails.clusterServiceFailedDetails)&&
  Objects.equals(this.clusterLeaderFailoverDetails, objEventDetails.clusterLeaderFailoverDetails)&&
  Objects.equals(this.clusterServiceRestoredDetails, objEventDetails.clusterServiceRestoredDetails)&&
  Objects.equals(this.clusterServiceCriticalFailureDetails, objEventDetails.clusterServiceCriticalFailureDetails)&&
  Objects.equals(this.clusterNodeShutdownDetails, objEventDetails.clusterNodeShutdownDetails)&&
  Objects.equals(this.clusterNodeStartedDetails, objEventDetails.clusterNodeStartedDetails)&&
  Objects.equals(this.clusterConfigFailedDetails, objEventDetails.clusterConfigFailedDetails)&&
  Objects.equals(this.clusterNodeDbFailedDetails, objEventDetails.clusterNodeDbFailedDetails)&&
  Objects.equals(this.systemUpgradeDetails, objEventDetails.systemUpgradeDetails)&&
  Objects.equals(this.memoryBalancerInfo, objEventDetails.memoryBalancerInfo)&&
  Objects.equals(this.metricThresholdUpDetails, objEventDetails.metricThresholdUpDetails)&&
  Objects.equals(this.licenseExpiryDetails, objEventDetails.licenseExpiryDetails)&&
  Objects.equals(this.anomalyDetails, objEventDetails.anomalyDetails)&&
  Objects.equals(this.licenseDetails, objEventDetails.licenseDetails)&&
  Objects.equals(this.metricsDbDiskDetails, objEventDetails.metricsDbDiskDetails)&&
  Objects.equals(this.burstCheckoutDetails, objEventDetails.burstCheckoutDetails)&&
  Objects.equals(this.metricsDbQueueFullDetails, objEventDetails.metricsDbQueueFullDetails)&&
  Objects.equals(this.metricsDbQueueHealthyDetails, objEventDetails.metricsDbQueueHealthyDetails)&&
  Objects.equals(this.osInfraDetails, objEventDetails.osInfraDetails)&&
  Objects.equals(this.osSeVmDetails, objEventDetails.osSeVmDetails)&&
  Objects.equals(this.osVnicDetails, objEventDetails.osVnicDetails)&&
  Objects.equals(this.osIpDetails, objEventDetails.osIpDetails)&&
  Objects.equals(this.osLbauditDetails, objEventDetails.osLbauditDetails)&&
  Objects.equals(this.osLbpluginOpDetails, objEventDetails.osLbpluginOpDetails)&&
  Objects.equals(this.osSyncServicesDetails, objEventDetails.osSyncServicesDetails)&&
  Objects.equals(this.osApiVerCheckFailure, objEventDetails.osApiVerCheckFailure)&&
  Objects.equals(this.awsInfraDetails, objEventDetails.awsInfraDetails)&&
  Objects.equals(this.ccSeVmDetails, objEventDetails.ccSeVmDetails)&&
  Objects.equals(this.ccVnicDetails, objEventDetails.ccVnicDetails)&&
  Objects.equals(this.ccIpDetails, objEventDetails.ccIpDetails)&&
  Objects.equals(this.ccSyncServicesDetails, objEventDetails.ccSyncServicesDetails)&&
  Objects.equals(this.ccVipUpdateDetails, objEventDetails.ccVipUpdateDetails)&&
  Objects.equals(this.ccInfraDetails, objEventDetails.ccInfraDetails)&&
  Objects.equals(this.ccTenantDelDetails, objEventDetails.ccTenantDelDetails)&&
  Objects.equals(this.ccClusterVipDetails, objEventDetails.ccClusterVipDetails)&&
  Objects.equals(this.ccDnsUpdateDetails, objEventDetails.ccDnsUpdateDetails)&&
  Objects.equals(this.ccHealthDetails, objEventDetails.ccHealthDetails)&&
  Objects.equals(this.ccParkintfDetails, objEventDetails.ccParkintfDetails)&&
  Objects.equals(this.awsAsgNotifDetails, objEventDetails.awsAsgNotifDetails)&&
  Objects.equals(this.awsAsgDeletionDetails, objEventDetails.awsAsgDeletionDetails)&&
  Objects.equals(this.ccScalesetNotifDetails, objEventDetails.ccScalesetNotifDetails)&&
  Objects.equals(this.csInfraDetails, objEventDetails.csInfraDetails)&&
  Objects.equals(this.bmInfraDetails, objEventDetails.bmInfraDetails)&&
  Objects.equals(this.vcaInfraDetails, objEventDetails.vcaInfraDetails)&&
  Objects.equals(this.marathonServicePortConflictDetails, objEventDetails.marathonServicePortConflictDetails)&&
  Objects.equals(this.mesosInfraDetails, objEventDetails.mesosInfraDetails)&&
  Objects.equals(this.dockerUcpDetails, objEventDetails.dockerUcpDetails)&&
  Objects.equals(this.containerCloudSetup, objEventDetails.containerCloudSetup)&&
  Objects.equals(this.containerCloudSevice, objEventDetails.containerCloudSevice)&&
  Objects.equals(this.containerCloudBatchSetup, objEventDetails.containerCloudBatchSetup)&&
  Objects.equals(this.hsDetails, objEventDetails.hsDetails)&&
  Objects.equals(this.nwSubnetClashDetails, objEventDetails.nwSubnetClashDetails)&&
  Objects.equals(this.nwSummarizedDetails, objEventDetails.nwSummarizedDetails)&&
  Objects.equals(this.networkSubnetDetails, objEventDetails.networkSubnetDetails)&&
  Objects.equals(this.avgUptimeChangeDetails, objEventDetails.avgUptimeChangeDetails)&&
  Objects.equals(this.apicAgentGenericDetails, objEventDetails.apicAgentGenericDetails)&&
  Objects.equals(this.apicAgentBdVrfDetails, objEventDetails.apicAgentBdVrfDetails)&&
  Objects.equals(this.apicAgentVsNetworkError, objEventDetails.apicAgentVsNetworkError)&&
  Objects.equals(this.dosAttackEventDetails, objEventDetails.dosAttackEventDetails)&&
  Objects.equals(this.serverAutoscaleoutInfo, objEventDetails.serverAutoscaleoutInfo)&&
  Objects.equals(this.serverAutoscaleinInfo, objEventDetails.serverAutoscaleinInfo)&&
  Objects.equals(this.serverAutoscaleoutCompleteInfo, objEventDetails.serverAutoscaleoutCompleteInfo)&&
  Objects.equals(this.serverAutoscaleinCompleteInfo, objEventDetails.serverAutoscaleinCompleteInfo)&&
  Objects.equals(this.serverAutoscaleFailedInfo, objEventDetails.serverAutoscaleFailedInfo)&&
  Objects.equals(this.poolDeploymentSuccessInfo, objEventDetails.poolDeploymentSuccessInfo)&&
  Objects.equals(this.poolDeploymentFailureInfo, objEventDetails.poolDeploymentFailureInfo)&&
  Objects.equals(this.poolDeploymentUpdateInfo, objEventDetails.poolDeploymentUpdateInfo)&&
  Objects.equals(this.glbInfo, objEventDetails.glbInfo)&&
  Objects.equals(this.gsInfo, objEventDetails.gsInfo)&&
  Objects.equals(this.schedulerActionInfo, objEventDetails.schedulerActionInfo)&&
  Objects.equals(this.gcpInfo, objEventDetails.gcpInfo)&&
  Objects.equals(this.gcpCloudRouterInfo, objEventDetails.gcpCloudRouterInfo)&&
  Objects.equals(this.vipDnsInfo, objEventDetails.vipDnsInfo)&&
  Objects.equals(this.dnsSyncInfo, objEventDetails.dnsSyncInfo)&&
  Objects.equals(this.azureInfo, objEventDetails.azureInfo)&&
  Objects.equals(this.azureMpInfo, objEventDetails.azureMpInfo)&&
  Objects.equals(this.syncServicesInfo, objEventDetails.syncServicesInfo)&&
  Objects.equals(this.ociInfo, objEventDetails.ociInfo)&&
  Objects.equals(this.tencentInfo, objEventDetails.tencentInfo)&&
  Objects.equals(this.albservicesStatusDetails, objEventDetails.albservicesStatusDetails)&&
  Objects.equals(this.crsDetails, objEventDetails.crsDetails)&&
  Objects.equals(this.crsDeploymentSuccess, objEventDetails.crsDeploymentSuccess)&&
  Objects.equals(this.crsDeploymentFailure, objEventDetails.crsDeploymentFailure)&&
  Objects.equals(this.albservicesCaseDetails, objEventDetails.albservicesCaseDetails)&&
  Objects.equals(this.albservicesFileUploadDetails, objEventDetails.albservicesFileUploadDetails)&&
  Objects.equals(this.crsUpdateDetails, objEventDetails.crsUpdateDetails)&&
  Objects.equals(this.ipThreatDbEventData, objEventDetails.ipThreatDbEventData)&&
  Objects.equals(this.nsxtInfo, objEventDetails.nsxtInfo)&&
  Objects.equals(this.nsxtImgDetails, objEventDetails.nsxtImgDetails)&&
  Objects.equals(this.psmProgramDetails, objEventDetails.psmProgramDetails)&&
  Objects.equals(this.secMgrDataEvent, objEventDetails.secMgrDataEvent)&&
  Objects.equals(this.cloudAsgNotifDetails, objEventDetails.cloudAsgNotifDetails)&&
  Objects.equals(this.cloudAutoscalingConfigFailureDetails, objEventDetails.cloudAutoscalingConfigFailureDetails)&&
  Objects.equals(this.licenseTransactionDetails, objEventDetails.licenseTransactionDetails)&&
  Objects.equals(this.seReconcileDetails, objEventDetails.seReconcileDetails)&&
  Objects.equals(this.controllerLicenseReconcileDetails, objEventDetails.controllerLicenseReconcileDetails);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class EventDetails {\n");
      sb.append("    addNetworksDetails: ").append(toIndentedString(addNetworksDetails)).append("\n");
        sb.append("    albservicesCaseDetails: ").append(toIndentedString(albservicesCaseDetails)).append("\n");
        sb.append("    albservicesFileUploadDetails: ").append(toIndentedString(albservicesFileUploadDetails)).append("\n");
        sb.append("    albservicesStatusDetails: ").append(toIndentedString(albservicesStatusDetails)).append("\n");
        sb.append("    allSeupgradeEventDetails: ").append(toIndentedString(allSeupgradeEventDetails)).append("\n");
        sb.append("    anomalyDetails: ").append(toIndentedString(anomalyDetails)).append("\n");
        sb.append("    apicAgentBdVrfDetails: ").append(toIndentedString(apicAgentBdVrfDetails)).append("\n");
        sb.append("    apicAgentGenericDetails: ").append(toIndentedString(apicAgentGenericDetails)).append("\n");
        sb.append("    apicAgentVsNetworkError: ").append(toIndentedString(apicAgentVsNetworkError)).append("\n");
        sb.append("    avgUptimeChangeDetails: ").append(toIndentedString(avgUptimeChangeDetails)).append("\n");
        sb.append("    awsAsgDeletionDetails: ").append(toIndentedString(awsAsgDeletionDetails)).append("\n");
        sb.append("    awsAsgNotifDetails: ").append(toIndentedString(awsAsgNotifDetails)).append("\n");
        sb.append("    awsInfraDetails: ").append(toIndentedString(awsInfraDetails)).append("\n");
        sb.append("    azureInfo: ").append(toIndentedString(azureInfo)).append("\n");
        sb.append("    azureMpInfo: ").append(toIndentedString(azureMpInfo)).append("\n");
        sb.append("    bindVsSeDetails: ").append(toIndentedString(bindVsSeDetails)).append("\n");
        sb.append("    bmInfraDetails: ").append(toIndentedString(bmInfraDetails)).append("\n");
        sb.append("    bootupFailDetails: ").append(toIndentedString(bootupFailDetails)).append("\n");
        sb.append("    burstCheckoutDetails: ").append(toIndentedString(burstCheckoutDetails)).append("\n");
        sb.append("    ccClusterVipDetails: ").append(toIndentedString(ccClusterVipDetails)).append("\n");
        sb.append("    ccDnsUpdateDetails: ").append(toIndentedString(ccDnsUpdateDetails)).append("\n");
        sb.append("    ccHealthDetails: ").append(toIndentedString(ccHealthDetails)).append("\n");
        sb.append("    ccInfraDetails: ").append(toIndentedString(ccInfraDetails)).append("\n");
        sb.append("    ccIpDetails: ").append(toIndentedString(ccIpDetails)).append("\n");
        sb.append("    ccParkintfDetails: ").append(toIndentedString(ccParkintfDetails)).append("\n");
        sb.append("    ccScalesetNotifDetails: ").append(toIndentedString(ccScalesetNotifDetails)).append("\n");
        sb.append("    ccSeVmDetails: ").append(toIndentedString(ccSeVmDetails)).append("\n");
        sb.append("    ccSyncServicesDetails: ").append(toIndentedString(ccSyncServicesDetails)).append("\n");
        sb.append("    ccTenantDelDetails: ").append(toIndentedString(ccTenantDelDetails)).append("\n");
        sb.append("    ccVipUpdateDetails: ").append(toIndentedString(ccVipUpdateDetails)).append("\n");
        sb.append("    ccVnicDetails: ").append(toIndentedString(ccVnicDetails)).append("\n");
        sb.append("    cloudAsgNotifDetails: ").append(toIndentedString(cloudAsgNotifDetails)).append("\n");
        sb.append("    cloudAutoscalingConfigFailureDetails: ").append(toIndentedString(cloudAutoscalingConfigFailureDetails)).append("\n");
        sb.append("    clusterConfigFailedDetails: ").append(toIndentedString(clusterConfigFailedDetails)).append("\n");
        sb.append("    clusterLeaderFailoverDetails: ").append(toIndentedString(clusterLeaderFailoverDetails)).append("\n");
        sb.append("    clusterNodeAddDetails: ").append(toIndentedString(clusterNodeAddDetails)).append("\n");
        sb.append("    clusterNodeDbFailedDetails: ").append(toIndentedString(clusterNodeDbFailedDetails)).append("\n");
        sb.append("    clusterNodeRemoveDetails: ").append(toIndentedString(clusterNodeRemoveDetails)).append("\n");
        sb.append("    clusterNodeShutdownDetails: ").append(toIndentedString(clusterNodeShutdownDetails)).append("\n");
        sb.append("    clusterNodeStartedDetails: ").append(toIndentedString(clusterNodeStartedDetails)).append("\n");
        sb.append("    clusterServiceCriticalFailureDetails: ").append(toIndentedString(clusterServiceCriticalFailureDetails)).append("\n");
        sb.append("    clusterServiceFailedDetails: ").append(toIndentedString(clusterServiceFailedDetails)).append("\n");
        sb.append("    clusterServiceRestoredDetails: ").append(toIndentedString(clusterServiceRestoredDetails)).append("\n");
        sb.append("    cntlrHostListDetails: ").append(toIndentedString(cntlrHostListDetails)).append("\n");
        sb.append("    configActionDetails: ").append(toIndentedString(configActionDetails)).append("\n");
        sb.append("    configCreateDetails: ").append(toIndentedString(configCreateDetails)).append("\n");
        sb.append("    configDeleteDetails: ").append(toIndentedString(configDeleteDetails)).append("\n");
        sb.append("    configPasswordChangeRequestDetails: ").append(toIndentedString(configPasswordChangeRequestDetails)).append("\n");
        sb.append("    configSeGrpFlvUpdateDetails: ").append(toIndentedString(configSeGrpFlvUpdateDetails)).append("\n");
        sb.append("    configUpdateDetails: ").append(toIndentedString(configUpdateDetails)).append("\n");
        sb.append("    configUserAuthrzRuleDetails: ").append(toIndentedString(configUserAuthrzRuleDetails)).append("\n");
        sb.append("    configUserLoginDetails: ").append(toIndentedString(configUserLoginDetails)).append("\n");
        sb.append("    configUserLogoutDetails: ").append(toIndentedString(configUserLogoutDetails)).append("\n");
        sb.append("    configUserNotAuthrzRuleDetails: ").append(toIndentedString(configUserNotAuthrzRuleDetails)).append("\n");
        sb.append("    containerCloudBatchSetup: ").append(toIndentedString(containerCloudBatchSetup)).append("\n");
        sb.append("    containerCloudSetup: ").append(toIndentedString(containerCloudSetup)).append("\n");
        sb.append("    containerCloudSevice: ").append(toIndentedString(containerCloudSevice)).append("\n");
        sb.append("    controllerLicenseReconcileDetails: ").append(toIndentedString(controllerLicenseReconcileDetails)).append("\n");
        sb.append("    crsDeploymentFailure: ").append(toIndentedString(crsDeploymentFailure)).append("\n");
        sb.append("    crsDeploymentSuccess: ").append(toIndentedString(crsDeploymentSuccess)).append("\n");
        sb.append("    crsDetails: ").append(toIndentedString(crsDetails)).append("\n");
        sb.append("    crsUpdateDetails: ").append(toIndentedString(crsUpdateDetails)).append("\n");
        sb.append("    csInfraDetails: ").append(toIndentedString(csInfraDetails)).append("\n");
        sb.append("    deleteSeDetails: ").append(toIndentedString(deleteSeDetails)).append("\n");
        sb.append("    disableSeMigrateDetails: ").append(toIndentedString(disableSeMigrateDetails)).append("\n");
        sb.append("    discSummary: ").append(toIndentedString(discSummary)).append("\n");
        sb.append("    dnsSyncInfo: ").append(toIndentedString(dnsSyncInfo)).append("\n");
        sb.append("    dockerUcpDetails: ").append(toIndentedString(dockerUcpDetails)).append("\n");
        sb.append("    dosAttackEventDetails: ").append(toIndentedString(dosAttackEventDetails)).append("\n");
        sb.append("    gcpCloudRouterInfo: ").append(toIndentedString(gcpCloudRouterInfo)).append("\n");
        sb.append("    gcpInfo: ").append(toIndentedString(gcpInfo)).append("\n");
        sb.append("    glbInfo: ").append(toIndentedString(glbInfo)).append("\n");
        sb.append("    gsInfo: ").append(toIndentedString(gsInfo)).append("\n");
        sb.append("    hostUnavailDetails: ").append(toIndentedString(hostUnavailDetails)).append("\n");
        sb.append("    hsDetails: ").append(toIndentedString(hsDetails)).append("\n");
        sb.append("    ipFailDetails: ").append(toIndentedString(ipFailDetails)).append("\n");
        sb.append("    ipThreatDbEventData: ").append(toIndentedString(ipThreatDbEventData)).append("\n");
        sb.append("    licenseDetails: ").append(toIndentedString(licenseDetails)).append("\n");
        sb.append("    licenseExpiryDetails: ").append(toIndentedString(licenseExpiryDetails)).append("\n");
        sb.append("    licenseTransactionDetails: ").append(toIndentedString(licenseTransactionDetails)).append("\n");
        sb.append("    marathonServicePortConflictDetails: ").append(toIndentedString(marathonServicePortConflictDetails)).append("\n");
        sb.append("    memoryBalancerInfo: ").append(toIndentedString(memoryBalancerInfo)).append("\n");
        sb.append("    mesosInfraDetails: ").append(toIndentedString(mesosInfraDetails)).append("\n");
        sb.append("    metricThresholdUpDetails: ").append(toIndentedString(metricThresholdUpDetails)).append("\n");
        sb.append("    metricsDbDiskDetails: ").append(toIndentedString(metricsDbDiskDetails)).append("\n");
        sb.append("    metricsDbQueueFullDetails: ").append(toIndentedString(metricsDbQueueFullDetails)).append("\n");
        sb.append("    metricsDbQueueHealthyDetails: ").append(toIndentedString(metricsDbQueueHealthyDetails)).append("\n");
        sb.append("    mgmtNwChangeDetails: ").append(toIndentedString(mgmtNwChangeDetails)).append("\n");
        sb.append("    modifyNetworksDetails: ").append(toIndentedString(modifyNetworksDetails)).append("\n");
        sb.append("    networkSubnetDetails: ").append(toIndentedString(networkSubnetDetails)).append("\n");
        sb.append("    nsxtImgDetails: ").append(toIndentedString(nsxtImgDetails)).append("\n");
        sb.append("    nsxtInfo: ").append(toIndentedString(nsxtInfo)).append("\n");
        sb.append("    nwSubnetClashDetails: ").append(toIndentedString(nwSubnetClashDetails)).append("\n");
        sb.append("    nwSummarizedDetails: ").append(toIndentedString(nwSummarizedDetails)).append("\n");
        sb.append("    ociInfo: ").append(toIndentedString(ociInfo)).append("\n");
        sb.append("    osApiVerCheckFailure: ").append(toIndentedString(osApiVerCheckFailure)).append("\n");
        sb.append("    osInfraDetails: ").append(toIndentedString(osInfraDetails)).append("\n");
        sb.append("    osIpDetails: ").append(toIndentedString(osIpDetails)).append("\n");
        sb.append("    osLbauditDetails: ").append(toIndentedString(osLbauditDetails)).append("\n");
        sb.append("    osLbpluginOpDetails: ").append(toIndentedString(osLbpluginOpDetails)).append("\n");
        sb.append("    osSeVmDetails: ").append(toIndentedString(osSeVmDetails)).append("\n");
        sb.append("    osSyncServicesDetails: ").append(toIndentedString(osSyncServicesDetails)).append("\n");
        sb.append("    osVnicDetails: ").append(toIndentedString(osVnicDetails)).append("\n");
        sb.append("    poolDeploymentFailureInfo: ").append(toIndentedString(poolDeploymentFailureInfo)).append("\n");
        sb.append("    poolDeploymentSuccessInfo: ").append(toIndentedString(poolDeploymentSuccessInfo)).append("\n");
        sb.append("    poolDeploymentUpdateInfo: ").append(toIndentedString(poolDeploymentUpdateInfo)).append("\n");
        sb.append("    poolServerDeleteDetails: ").append(toIndentedString(poolServerDeleteDetails)).append("\n");
        sb.append("    psmProgramDetails: ").append(toIndentedString(psmProgramDetails)).append("\n");
        sb.append("    rateLimiterEventDetails: ").append(toIndentedString(rateLimiterEventDetails)).append("\n");
        sb.append("    rebalanceMigrateDetails: ").append(toIndentedString(rebalanceMigrateDetails)).append("\n");
        sb.append("    rebalanceScaleinDetails: ").append(toIndentedString(rebalanceScaleinDetails)).append("\n");
        sb.append("    rebalanceScaleoutDetails: ").append(toIndentedString(rebalanceScaleoutDetails)).append("\n");
        sb.append("    rebootSeDetails: ").append(toIndentedString(rebootSeDetails)).append("\n");
        sb.append("    schedulerActionInfo: ").append(toIndentedString(schedulerActionInfo)).append("\n");
        sb.append("    seBgpPeerDownDetails: ").append(toIndentedString(seBgpPeerDownDetails)).append("\n");
        sb.append("    seBgpPeerStateChangeDetails: ").append(toIndentedString(seBgpPeerStateChangeDetails)).append("\n");
        sb.append("    seDetails: ").append(toIndentedString(seDetails)).append("\n");
        sb.append("    seDupipEventDetails: ").append(toIndentedString(seDupipEventDetails)).append("\n");
        sb.append("    seGatewayHeartbeatFailedDetails: ").append(toIndentedString(seGatewayHeartbeatFailedDetails)).append("\n");
        sb.append("    seGatewayHeartbeatSuccessDetails: ").append(toIndentedString(seGatewayHeartbeatSuccessDetails)).append("\n");
        sb.append("    seGeoDbDetails: ").append(toIndentedString(seGeoDbDetails)).append("\n");
        sb.append("    seHbEventDetails: ").append(toIndentedString(seHbEventDetails)).append("\n");
        sb.append("    seHbRecoveredEventDetails: ").append(toIndentedString(seHbRecoveredEventDetails)).append("\n");
        sb.append("    seHmGsDetails: ").append(toIndentedString(seHmGsDetails)).append("\n");
        sb.append("    seHmGsgroupDetails: ").append(toIndentedString(seHmGsgroupDetails)).append("\n");
        sb.append("    seHmPoolDetails: ").append(toIndentedString(seHmPoolDetails)).append("\n");
        sb.append("    seHmVsDetails: ").append(toIndentedString(seHmVsDetails)).append("\n");
        sb.append("    seIp6DadFailedEventDetails: ").append(toIndentedString(seIp6DadFailedEventDetails)).append("\n");
        sb.append("    seIpAddedEventDetails: ").append(toIndentedString(seIpAddedEventDetails)).append("\n");
        sb.append("    seIpRemovedEventDetails: ").append(toIndentedString(seIpRemovedEventDetails)).append("\n");
        sb.append("    seIpfailureEventDetails: ").append(toIndentedString(seIpfailureEventDetails)).append("\n");
        sb.append("    seLicensedBandwdithExceededEventDetails: ").append(toIndentedString(seLicensedBandwdithExceededEventDetails)).append("\n");
        sb.append("    seMemoryLimitEventDetails: ").append(toIndentedString(seMemoryLimitEventDetails)).append("\n");
        sb.append("    sePersistenceDetails: ").append(toIndentedString(sePersistenceDetails)).append("\n");
        sb.append("    sePoolLbDetails: ").append(toIndentedString(sePoolLbDetails)).append("\n");
        sb.append("    seReconcileDetails: ").append(toIndentedString(seReconcileDetails)).append("\n");
        sb.append("    seThreshEventDetails: ").append(toIndentedString(seThreshEventDetails)).append("\n");
        sb.append("    seVersionCheckDetails: ").append(toIndentedString(seVersionCheckDetails)).append("\n");
        sb.append("    seVnicDownEventDetails: ").append(toIndentedString(seVnicDownEventDetails)).append("\n");
        sb.append("    seVnicTxQueueStallEventDetails: ").append(toIndentedString(seVnicTxQueueStallEventDetails)).append("\n");
        sb.append("    seVnicUpEventDetails: ").append(toIndentedString(seVnicUpEventDetails)).append("\n");
        sb.append("    seVsFaultEventDetails: ").append(toIndentedString(seVsFaultEventDetails)).append("\n");
        sb.append("    secMgrDataEvent: ").append(toIndentedString(secMgrDataEvent)).append("\n");
        sb.append("    semigrateEventDetails: ").append(toIndentedString(semigrateEventDetails)).append("\n");
        sb.append("    serverAutoscaleFailedInfo: ").append(toIndentedString(serverAutoscaleFailedInfo)).append("\n");
        sb.append("    serverAutoscaleinCompleteInfo: ").append(toIndentedString(serverAutoscaleinCompleteInfo)).append("\n");
        sb.append("    serverAutoscaleinInfo: ").append(toIndentedString(serverAutoscaleinInfo)).append("\n");
        sb.append("    serverAutoscaleoutCompleteInfo: ").append(toIndentedString(serverAutoscaleoutCompleteInfo)).append("\n");
        sb.append("    serverAutoscaleoutInfo: ").append(toIndentedString(serverAutoscaleoutInfo)).append("\n");
        sb.append("    seupgradeDisruptedDetails: ").append(toIndentedString(seupgradeDisruptedDetails)).append("\n");
        sb.append("    seupgradeEventDetails: ").append(toIndentedString(seupgradeEventDetails)).append("\n");
        sb.append("    seupgradeMigrateDetails: ").append(toIndentedString(seupgradeMigrateDetails)).append("\n");
        sb.append("    seupgradeScaleinDetails: ").append(toIndentedString(seupgradeScaleinDetails)).append("\n");
        sb.append("    seupgradeScaleoutDetails: ").append(toIndentedString(seupgradeScaleoutDetails)).append("\n");
        sb.append("    spawnSeDetails: ").append(toIndentedString(spawnSeDetails)).append("\n");
        sb.append("    sslExpireDetails: ").append(toIndentedString(sslExpireDetails)).append("\n");
        sb.append("    sslExportDetails: ").append(toIndentedString(sslExportDetails)).append("\n");
        sb.append("    sslIgnoredDetails: ").append(toIndentedString(sslIgnoredDetails)).append("\n");
        sb.append("    sslRenewDetails: ").append(toIndentedString(sslRenewDetails)).append("\n");
        sb.append("    sslRenewFailedDetails: ").append(toIndentedString(sslRenewFailedDetails)).append("\n");
        sb.append("    sslRevokedDetails: ").append(toIndentedString(sslRevokedDetails)).append("\n");
        sb.append("    switchoverDetails: ").append(toIndentedString(switchoverDetails)).append("\n");
        sb.append("    switchoverFailDetails: ").append(toIndentedString(switchoverFailDetails)).append("\n");
        sb.append("    syncServicesInfo: ").append(toIndentedString(syncServicesInfo)).append("\n");
        sb.append("    systemUpgradeDetails: ").append(toIndentedString(systemUpgradeDetails)).append("\n");
        sb.append("    tencentInfo: ").append(toIndentedString(tencentInfo)).append("\n");
        sb.append("    unbindVsSeDetails: ").append(toIndentedString(unbindVsSeDetails)).append("\n");
        sb.append("    upgradeEntry: ").append(toIndentedString(upgradeEntry)).append("\n");
        sb.append("    upgradeStatusInfo: ").append(toIndentedString(upgradeStatusInfo)).append("\n");
        sb.append("    vcaInfraDetails: ").append(toIndentedString(vcaInfraDetails)).append("\n");
        sb.append("    vcenterConnectivityStatus: ").append(toIndentedString(vcenterConnectivityStatus)).append("\n");
        sb.append("    vcenterDetails: ").append(toIndentedString(vcenterDetails)).append("\n");
        sb.append("    vcenterDiscFailure: ").append(toIndentedString(vcenterDiscFailure)).append("\n");
        sb.append("    vcenterNetworkLimit: ").append(toIndentedString(vcenterNetworkLimit)).append("\n");
        sb.append("    vcenterObjDeleteDetails: ").append(toIndentedString(vcenterObjDeleteDetails)).append("\n");
        sb.append("    vipAutoscale: ").append(toIndentedString(vipAutoscale)).append("\n");
        sb.append("    vipDnsInfo: ").append(toIndentedString(vipDnsInfo)).append("\n");
        sb.append("    vmDetails: ").append(toIndentedString(vmDetails)).append("\n");
        sb.append("    vsAwaitingseDetails: ").append(toIndentedString(vsAwaitingseDetails)).append("\n");
        sb.append("    vsErrorDetails: ").append(toIndentedString(vsErrorDetails)).append("\n");
        sb.append("    vsFsmDetails: ").append(toIndentedString(vsFsmDetails)).append("\n");
        sb.append("    vsInitialplacementDetails: ").append(toIndentedString(vsInitialplacementDetails)).append("\n");
        sb.append("    vsMigrateDetails: ").append(toIndentedString(vsMigrateDetails)).append("\n");
        sb.append("    vsPoolNwFltrDetails: ").append(toIndentedString(vsPoolNwFltrDetails)).append("\n");
        sb.append("    vsScaleinDetails: ").append(toIndentedString(vsScaleinDetails)).append("\n");
        sb.append("    vsScaleoutDetails: ").append(toIndentedString(vsScaleoutDetails)).append("\n");
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

