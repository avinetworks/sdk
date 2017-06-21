package clients

import (
	"github.com/avinetworks/sdk/go/session"
)

type AviClient struct {
	ActionGroupConfig                 *ActionGroupConfigClient
	Alert                             *AlertClient
	AlertConfig                       *AlertConfigClient
	AlertEmailConfig                  *AlertEmailConfigClient
	AlertObjectList                   *AlertObjectListClient
	AlertScriptConfig                 *AlertScriptConfigClient
	AlertSyslogConfig                 *AlertSyslogConfigClient
	AnalyticsProfile                  *AnalyticsProfileClient
	APICLifsRuntime                   *APICLifsRuntimeClient
	Application                       *ApplicationClient
	ApplicationPersistenceProfile     *ApplicationPersistenceProfileClient
	ApplicationProfile                *ApplicationProfileClient
	AuthProfile                       *AuthProfileClient
	AutoScaleLaunchConfig             *AutoScaleLaunchConfigClient
	Backup                            *BackupClient
	BackupConfiguration               *BackupConfigurationClient
	CertificateManagementProfile      *CertificateManagementProfileClient
	Cloud                             *CloudClient
	CloudConnectorUser                *CloudConnectorUserClient
	CloudProperties                   *CloudPropertiesClient
	CloudRuntime                      *CloudRuntimeClient
	Cluster                           *ClusterClient
	ControllerLicense                 *ControllerLicenseClient
	ControllerProperties              *ControllerPropertiesClient
	DebugController                   *DebugControllerClient
	DebugServiceEngine                *DebugServiceEngineClient
	DebugVirtualService               *DebugVirtualServiceClient
	DNSPolicy                         *DNSPolicyClient
	GslbApplicationPersistenceProfile *GslbApplicationPersistenceProfileClient
	Gslb                              *GslbClient
	GslbGeoDbProfile                  *GslbGeoDbProfileClient
	GslbHealthMonitor                 *GslbHealthMonitorClient
	GslbService                       *GslbServiceClient
	HardwareSecurityModuleGroup       *HardwareSecurityModuleGroupClient
	HealthMonitor                     *HealthMonitorClient
	HTTPPolicySet                     *HTTPPolicySetClient
	IPAddrGroup                       *IPAddrGroupClient
	IPAMDNSProviderProfile            *IPAMDNSProviderProfileClient
	JobEntry                          *JobEntryClient
	LogControllerMapping              *LogControllerMappingClient
	MicroService                      *MicroServiceClient
	MicroServiceGroup                 *MicroServiceGroupClient
	Network                           *NetworkClient
	NetworkProfile                    *NetworkProfileClient
	NetworkRuntime                    *NetworkRuntimeClient
	NetworkSecurityPolicy             *NetworkSecurityPolicyClient
	PKIprofile                        *PKIprofileClient
	Pool                              *PoolClient
	PoolGroup                         *PoolGroupClient
	PoolGroupDeploymentPolicy         *PoolGroupDeploymentPolicyClient
	PriorityLabels                    *PriorityLabelsClient
	Role                              *RoleClient
	Scheduler                         *SchedulerClient
	SCPoolServerStateInfo             *SCPoolServerStateInfoClient
	SCVsStateInfo                     *SCVsStateInfoClient
	SecureChannelAvailableLocalIps    *SecureChannelAvailableLocalIpsClient
	SecureChannelMapping              *SecureChannelMappingClient
	SecureChannelToken                *SecureChannelTokenClient
	SeProperties                      *SePropertiesClient
	ServerAutoScalePolicy             *ServerAutoScalePolicyClient
	ServiceEngine                     *ServiceEngineClient
	ServiceEngineGroup                *ServiceEngineGroupClient
	SnmpTrapProfile                   *SnmpTrapProfileClient
	SSLKeyAndCertificate              *SSLKeyAndCertificateClient
	SSLProfile                        *SSLProfileClient
	StringGroup                       *StringGroupClient
	SystemConfiguration               *SystemConfigurationClient
	Tenant                            *TenantClient
	TrafficCloneProfile               *TrafficCloneProfileClient
	UserAccountProfile                *UserAccountProfileClient
	UserActivity                      *UserActivityClient
	VIDCInfo                          *VIDCInfoClient
	VIMgrClusterRuntime               *VIMgrClusterRuntimeClient
	VIMgrControllerRuntime            *VIMgrControllerRuntimeClient
	VIMgrDCRuntime                    *VIMgrDCRuntimeClient
	VIMgrHostRuntime                  *VIMgrHostRuntimeClient
	VIMgrNWRuntime                    *VIMgrNWRuntimeClient
	VIMgrSEVMRuntime                  *VIMgrSEVMRuntimeClient
	VIMgrVcenterRuntime               *VIMgrVcenterRuntimeClient
	VIMgrVMRuntime                    *VIMgrVMRuntimeClient
	VIPGNameInfo                      *VIPGNameInfoClient
	VirtualService                    *VirtualServiceClient
	VrfContext                        *VrfContextClient
	VSDataScriptSet                   *VSDataScriptSetClient
	VsVip                             *VsVipClient
	Webhook                           *WebhookClient
}

func NewAviClient(avi_sess *session.AviSession) *AviClient{
	avi_client := AviClient{}
	avi_client.ActionGroupConfig = NewActionGroupConfigClient(avi_sess)
	avi_client.Alert = NewAlertClient(avi_sess)
	avi_client.AlertConfig = NewAlertConfigClient(avi_sess)
	avi_client.AlertEmailConfig = NewAlertEmailConfigClient(avi_sess)
	avi_client.AlertObjectList = NewAlertObjectListClient(avi_sess)
	avi_client.AlertScriptConfig = NewAlertScriptConfigClient(avi_sess)
	avi_client.AlertSyslogConfig = NewAlertSyslogConfigClient(avi_sess)
	avi_client.AnalyticsProfile = NewAnalyticsProfileClient(avi_sess)
	avi_client.APICLifsRuntime = NewAPICLifsRuntimeClient(avi_sess)
	avi_client.Application = NewApplicationClient(avi_sess)
	avi_client.ApplicationPersistenceProfile = NewApplicationPersistenceProfileClient(avi_sess)
	avi_client.ApplicationProfile = NewApplicationProfileClient(avi_sess)
	avi_client.AuthProfile = NewAuthProfileClient(avi_sess)
	avi_client.AutoScaleLaunchConfig = NewAutoScaleLaunchConfigClient(avi_sess)
	avi_client.Backup = NewBackupClient(avi_sess)
	avi_client.BackupConfiguration = NewBackupConfigurationClient(avi_sess)
	avi_client.CertificateManagementProfile = NewCertificateManagementProfileClient(avi_sess)
	avi_client.Cloud = NewCloudClient(avi_sess)
	avi_client.CloudConnectorUser = NewCloudConnectorUserClient(avi_sess)
	avi_client.CloudProperties = NewCloudPropertiesClient(avi_sess)
	avi_client.CloudRuntime = NewCloudRuntimeClient(avi_sess)
	avi_client.Cluster = NewClusterClient(avi_sess)
	avi_client.ControllerLicense = NewControllerLicenseClient(avi_sess)
	avi_client.ControllerProperties = NewControllerPropertiesClient(avi_sess)
	avi_client.DebugController = NewDebugControllerClient(avi_sess)
	avi_client.DebugServiceEngine = NewDebugServiceEngineClient(avi_sess)
	avi_client.DebugVirtualService = NewDebugVirtualServiceClient(avi_sess)
	avi_client.DNSPolicy = NewDNSPolicyClient(avi_sess)
	avi_client.GslbApplicationPersistenceProfile = NewGslbApplicationPersistenceProfileClient(avi_sess)
	avi_client.Gslb = NewGslbClient(avi_sess)
	avi_client.GslbGeoDbProfile = NewGslbGeoDbProfileClient(avi_sess)
	avi_client.GslbHealthMonitor = NewGslbHealthMonitorClient(avi_sess)
	avi_client.GslbService = NewGslbServiceClient(avi_sess)
	avi_client.HardwareSecurityModuleGroup = NewHardwareSecurityModuleGroupClient(avi_sess)
	avi_client.HealthMonitor = NewHealthMonitorClient(avi_sess)
	avi_client.HTTPPolicySet = NewHTTPPolicySetClient(avi_sess)
	avi_client.IPAddrGroup = NewIPAddrGroupClient(avi_sess)
	avi_client.IPAMDNSProviderProfile = NewIPAMDNSProviderProfileClient(avi_sess)
	avi_client.JobEntry = NewJobEntryClient(avi_sess)
	avi_client.LogControllerMapping = NewLogControllerMappingClient(avi_sess)
	avi_client.MicroService = NewMicroServiceClient(avi_sess)
	avi_client.MicroServiceGroup = NewMicroServiceGroupClient(avi_sess)
	avi_client.Network = NewNetworkClient(avi_sess)
	avi_client.NetworkProfile = NewNetworkProfileClient(avi_sess)
	avi_client.NetworkRuntime = NewNetworkRuntimeClient(avi_sess)
	avi_client.NetworkSecurityPolicy = NewNetworkSecurityPolicyClient(avi_sess)
	avi_client.PKIprofile = NewPKIprofileClient(avi_sess)
	avi_client.Pool = NewPoolClient(avi_sess)
	avi_client.PoolGroup = NewPoolGroupClient(avi_sess)
	avi_client.PoolGroupDeploymentPolicy = NewPoolGroupDeploymentPolicyClient(avi_sess)
	avi_client.PriorityLabels = NewPriorityLabelsClient(avi_sess)
	avi_client.Role = NewRoleClient(avi_sess)
	avi_client.Scheduler = NewSchedulerClient(avi_sess)
	avi_client.SCPoolServerStateInfo = NewSCPoolServerStateInfoClient(avi_sess)
	avi_client.SCVsStateInfo = NewSCVsStateInfoClient(avi_sess)
	avi_client.SecureChannelAvailableLocalIps = NewSecureChannelAvailableLocalIpsClient(avi_sess)
	avi_client.SecureChannelMapping = NewSecureChannelMappingClient(avi_sess)
	avi_client.SecureChannelToken = NewSecureChannelTokenClient(avi_sess)
	avi_client.SeProperties = NewSePropertiesClient(avi_sess)
	avi_client.ServerAutoScalePolicy = NewServerAutoScalePolicyClient(avi_sess)
	avi_client.ServiceEngine = NewServiceEngineClient(avi_sess)
	avi_client.ServiceEngineGroup = NewServiceEngineGroupClient(avi_sess)
	avi_client.SnmpTrapProfile = NewSnmpTrapProfileClient(avi_sess)
	avi_client.SSLKeyAndCertificate = NewSSLKeyAndCertificateClient(avi_sess)
	avi_client.SSLProfile = NewSSLProfileClient(avi_sess)
	avi_client.StringGroup = NewStringGroupClient(avi_sess)
	avi_client.SystemConfiguration = NewSystemConfigurationClient(avi_sess)
	avi_client.Tenant = NewTenantClient(avi_sess)
	avi_client.TrafficCloneProfile = NewTrafficCloneProfileClient(avi_sess)
	avi_client.UserAccountProfile = NewUserAccountProfileClient(avi_sess)
	avi_client.UserActivity = NewUserActivityClient(avi_sess)
	avi_client.VIDCInfo = NewVIDCInfoClient(avi_sess)
	avi_client.VIMgrClusterRuntime = NewVIMgrClusterRuntimeClient(avi_sess)
	avi_client.VIMgrControllerRuntime = NewVIMgrControllerRuntimeClient(avi_sess)
	avi_client.VIMgrDCRuntime = NewVIMgrDCRuntimeClient(avi_sess)
	avi_client.VIMgrHostRuntime = NewVIMgrHostRuntimeClient(avi_sess)
	avi_client.VIMgrNWRuntime = NewVIMgrNWRuntimeClient(avi_sess)
	avi_client.VIMgrSEVMRuntime = NewVIMgrSEVMRuntimeClient(avi_sess)
	avi_client.VIMgrVcenterRuntime = NewVIMgrVcenterRuntimeClient(avi_sess)
	avi_client.VIMgrVMRuntime = NewVIMgrVMRuntimeClient(avi_sess)
	avi_client.VIPGNameInfo = NewVIPGNameInfoClient(avi_sess)
	avi_client.VirtualService = NewVirtualServiceClient(avi_sess)
	avi_client.VrfContext = NewVrfContextClient(avi_sess)
	avi_client.VSDataScriptSet = NewVSDataScriptSetClient(avi_sess)
	avi_client.VsVip = NewVsVipClient(avi_sess)
	avi_client.Webhook = NewWebhookClient(avi_sess)

	return &avi_client
}