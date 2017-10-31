package clients

import (
	"github.com/avinetworks/sdk/go/session"
)

// AviClient -- an API Client for Avi Controller
type AviClient struct {
<<<<<<< HEAD
	AviSession                     *session.AviSession
	APICLifsRuntime                *APICLifsRuntimeClient
	ActionGroupConfig              *ActionGroupConfigClient
	Alert                          *AlertClient
	AlertConfig                    *AlertConfigClient
	AlertEmailConfig               *AlertEmailConfigClient
	AlertObjectList                *AlertObjectListClient
	AlertScriptConfig              *AlertScriptConfigClient
	AlertSyslogConfig              *AlertSyslogConfigClient
	AnalyticsProfile               *AnalyticsProfileClient
	Application                    *ApplicationClient
	ApplicationPersistenceProfile  *ApplicationPersistenceProfileClient
	ApplicationProfile             *ApplicationProfileClient
	AuthProfile                    *AuthProfileClient
	AutoScaleLaunchConfig          *AutoScaleLaunchConfigClient
	Backup                         *BackupClient
	BackupConfiguration            *BackupConfigurationClient
	CertificateManagementProfile   *CertificateManagementProfileClient
	Cloud                          *CloudClient
	CloudConnectorUser             *CloudConnectorUserClient
	CloudProperties                *CloudPropertiesClient
	CloudRuntime                   *CloudRuntimeClient
	Cluster                        *ClusterClient
	ControllerLicense              *ControllerLicenseClient
	ControllerProperties           *ControllerPropertiesClient
	CustomIPAMDNSProfile           *CustomIPAMDNSProfileClient
	DNSPolicy                      *DNSPolicyClient
	DebugController                *DebugControllerClient
	DebugServiceEngine             *DebugServiceEngineClient
	DebugVirtualService            *DebugVirtualServiceClient
	Gslb                           *GslbClient
	GslbGeoDbProfile               *GslbGeoDbProfileClient
	GslbService                    *GslbServiceClient
	HTTPPolicySet                  *HTTPPolicySetClient
	HardwareSecurityModuleGroup    *HardwareSecurityModuleGroupClient
	HealthMonitor                  *HealthMonitorClient
	IPAMDNSProviderProfile         *IPAMDNSProviderProfileClient
	IPAddrGroup                    *IPAddrGroupClient
	JobEntry                       *JobEntryClient
	LogControllerMapping           *LogControllerMappingClient
	MicroService                   *MicroServiceClient
	MicroServiceGroup              *MicroServiceGroupClient
	Network                        *NetworkClient
	NetworkProfile                 *NetworkProfileClient
	NetworkRuntime                 *NetworkRuntimeClient
	NetworkSecurityPolicy          *NetworkSecurityPolicyClient
	PKIprofile                     *PKIprofileClient
	Pool                           *PoolClient
	PoolGroup                      *PoolGroupClient
	PoolGroupDeploymentPolicy      *PoolGroupDeploymentPolicyClient
	PriorityLabels                 *PriorityLabelsClient
	Role                           *RoleClient
	SCPoolServerStateInfo          *SCPoolServerStateInfoClient
	SCVsStateInfo                  *SCVsStateInfoClient
	SSLKeyAndCertificate           *SSLKeyAndCertificateClient
	SSLProfile                     *SSLProfileClient
	Scheduler                      *SchedulerClient
	SeProperties                   *SePropertiesClient
	SecureChannelAvailableLocalIps *SecureChannelAvailableLocalIpsClient
	SecureChannelMapping           *SecureChannelMappingClient
	SecureChannelToken             *SecureChannelTokenClient
	ServerAutoScalePolicy          *ServerAutoScalePolicyClient
	ServiceEngine                  *ServiceEngineClient
	ServiceEngineGroup             *ServiceEngineGroupClient
	SnmpTrapProfile                *SnmpTrapProfileClient
	StringGroup                    *StringGroupClient
	SystemConfiguration            *SystemConfigurationClient
	Tenant                         *TenantClient
	TrafficCloneProfile            *TrafficCloneProfileClient
	UserAccountProfile             *UserAccountProfileClient
	UserActivity                   *UserActivityClient
	VIDCInfo                       *VIDCInfoClient
	VIMgrClusterRuntime            *VIMgrClusterRuntimeClient
	VIMgrControllerRuntime         *VIMgrControllerRuntimeClient
	VIMgrDCRuntime                 *VIMgrDCRuntimeClient
	VIMgrHostRuntime               *VIMgrHostRuntimeClient
	VIMgrNWRuntime                 *VIMgrNWRuntimeClient
	VIMgrSEVMRuntime               *VIMgrSEVMRuntimeClient
	VIMgrVMRuntime                 *VIMgrVMRuntimeClient
	VIMgrVcenterRuntime            *VIMgrVcenterRuntimeClient
	VIPGNameInfo                   *VIPGNameInfoClient
	VSDataScriptSet                *VSDataScriptSetClient
	VirtualService                 *VirtualServiceClient
	VrfContext                     *VrfContextClient
	VsVip                          *VsVipClient
	WafPolicy                      *WafPolicyClient
	WafProfile                     *WafProfileClient
	Webhook                        *WebhookClient
=======
	AviSession                        *session.AviSession
	APICLifsRuntime                   *APICLifsRuntimeClient
	ActionGroupConfig                 *ActionGroupConfigClient
	Alert                             *AlertClient
	AlertConfig                       *AlertConfigClient
	AlertEmailConfig                  *AlertEmailConfigClient
	AlertObjectList                   *AlertObjectListClient
	AlertScriptConfig                 *AlertScriptConfigClient
	AlertSyslogConfig                 *AlertSyslogConfigClient
	AnalyticsProfile                  *AnalyticsProfileClient
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
	DNSPolicy                         *DNSPolicyClient
	DebugController                   *DebugControllerClient
	DebugServiceEngine                *DebugServiceEngineClient
	DebugVirtualService               *DebugVirtualServiceClient
	Gslb                              *GslbClient
	GslbApplicationPersistenceProfile *GslbApplicationPersistenceProfileClient
	GslbGeoDbProfile                  *GslbGeoDbProfileClient
	GslbHealthMonitor                 *GslbHealthMonitorClient
	GslbService                       *GslbServiceClient
	HTTPPolicySet                     *HTTPPolicySetClient
	HardwareSecurityModuleGroup       *HardwareSecurityModuleGroupClient
	HealthMonitor                     *HealthMonitorClient
	IPAMDNSProviderProfile            *IPAMDNSProviderProfileClient
	IPAddrGroup                       *IPAddrGroupClient
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
	SCPoolServerStateInfo             *SCPoolServerStateInfoClient
	SCVsStateInfo                     *SCVsStateInfoClient
	SSLKeyAndCertificate              *SSLKeyAndCertificateClient
	SSLProfile                        *SSLProfileClient
	Scheduler                         *SchedulerClient
	SeProperties                      *SePropertiesClient
	SecureChannelAvailableLocalIps    *SecureChannelAvailableLocalIpsClient
	SecureChannelMapping              *SecureChannelMappingClient
	SecureChannelToken                *SecureChannelTokenClient
	ServerAutoScalePolicy             *ServerAutoScalePolicyClient
	ServiceEngine                     *ServiceEngineClient
	ServiceEngineGroup                *ServiceEngineGroupClient
	SnmpTrapProfile                   *SnmpTrapProfileClient
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
	VIMgrVMRuntime                    *VIMgrVMRuntimeClient
	VIMgrVcenterRuntime               *VIMgrVcenterRuntimeClient
	VIPGNameInfo                      *VIPGNameInfoClient
	VSDataScriptSet                   *VSDataScriptSetClient
	VirtualService                    *VirtualServiceClient
	VrfContext                        *VrfContextClient
	VsVip                             *VsVipClient
	Webhook                           *WebhookClient
>>>>>>> 4750eaa314c3d9dad91a358827406d1b51720139
}

// NewAviClient initiates an AviSession and returns an AviClient wrapping that session
func NewAviClient(host string, username string, options ...func(*session.AviSession) error) (*AviClient, error) {
	aviClient := AviClient{}
	aviSession, err := session.NewAviSession(host, username, options...)
	if err != nil {
		return &aviClient, err
	}
	aviClient.AviSession = aviSession
	aviClient.APICLifsRuntime = NewAPICLifsRuntimeClient(aviSession)
	aviClient.ActionGroupConfig = NewActionGroupConfigClient(aviSession)
	aviClient.Alert = NewAlertClient(aviSession)
	aviClient.AlertConfig = NewAlertConfigClient(aviSession)
	aviClient.AlertEmailConfig = NewAlertEmailConfigClient(aviSession)
	aviClient.AlertObjectList = NewAlertObjectListClient(aviSession)
	aviClient.AlertScriptConfig = NewAlertScriptConfigClient(aviSession)
	aviClient.AlertSyslogConfig = NewAlertSyslogConfigClient(aviSession)
	aviClient.AnalyticsProfile = NewAnalyticsProfileClient(aviSession)
	aviClient.Application = NewApplicationClient(aviSession)
	aviClient.ApplicationPersistenceProfile = NewApplicationPersistenceProfileClient(aviSession)
	aviClient.ApplicationProfile = NewApplicationProfileClient(aviSession)
	aviClient.AuthProfile = NewAuthProfileClient(aviSession)
	aviClient.AutoScaleLaunchConfig = NewAutoScaleLaunchConfigClient(aviSession)
	aviClient.Backup = NewBackupClient(aviSession)
	aviClient.BackupConfiguration = NewBackupConfigurationClient(aviSession)
	aviClient.CertificateManagementProfile = NewCertificateManagementProfileClient(aviSession)
	aviClient.Cloud = NewCloudClient(aviSession)
	aviClient.CloudConnectorUser = NewCloudConnectorUserClient(aviSession)
	aviClient.CloudProperties = NewCloudPropertiesClient(aviSession)
	aviClient.CloudRuntime = NewCloudRuntimeClient(aviSession)
	aviClient.Cluster = NewClusterClient(aviSession)
	aviClient.ControllerLicense = NewControllerLicenseClient(aviSession)
	aviClient.ControllerProperties = NewControllerPropertiesClient(aviSession)
<<<<<<< HEAD
	aviClient.CustomIPAMDNSProfile = NewCustomIPAMDNSProfileClient(aviSession)
=======
>>>>>>> 4750eaa314c3d9dad91a358827406d1b51720139
	aviClient.DNSPolicy = NewDNSPolicyClient(aviSession)
	aviClient.DebugController = NewDebugControllerClient(aviSession)
	aviClient.DebugServiceEngine = NewDebugServiceEngineClient(aviSession)
	aviClient.DebugVirtualService = NewDebugVirtualServiceClient(aviSession)
	aviClient.Gslb = NewGslbClient(aviSession)
<<<<<<< HEAD
	aviClient.GslbGeoDbProfile = NewGslbGeoDbProfileClient(aviSession)
=======
	aviClient.GslbApplicationPersistenceProfile = NewGslbApplicationPersistenceProfileClient(aviSession)
	aviClient.GslbGeoDbProfile = NewGslbGeoDbProfileClient(aviSession)
	aviClient.GslbHealthMonitor = NewGslbHealthMonitorClient(aviSession)
>>>>>>> 4750eaa314c3d9dad91a358827406d1b51720139
	aviClient.GslbService = NewGslbServiceClient(aviSession)
	aviClient.HTTPPolicySet = NewHTTPPolicySetClient(aviSession)
	aviClient.HardwareSecurityModuleGroup = NewHardwareSecurityModuleGroupClient(aviSession)
	aviClient.HealthMonitor = NewHealthMonitorClient(aviSession)
	aviClient.IPAMDNSProviderProfile = NewIPAMDNSProviderProfileClient(aviSession)
	aviClient.IPAddrGroup = NewIPAddrGroupClient(aviSession)
	aviClient.JobEntry = NewJobEntryClient(aviSession)
	aviClient.LogControllerMapping = NewLogControllerMappingClient(aviSession)
	aviClient.MicroService = NewMicroServiceClient(aviSession)
	aviClient.MicroServiceGroup = NewMicroServiceGroupClient(aviSession)
	aviClient.Network = NewNetworkClient(aviSession)
	aviClient.NetworkProfile = NewNetworkProfileClient(aviSession)
	aviClient.NetworkRuntime = NewNetworkRuntimeClient(aviSession)
	aviClient.NetworkSecurityPolicy = NewNetworkSecurityPolicyClient(aviSession)
	aviClient.PKIprofile = NewPKIprofileClient(aviSession)
	aviClient.Pool = NewPoolClient(aviSession)
	aviClient.PoolGroup = NewPoolGroupClient(aviSession)
	aviClient.PoolGroupDeploymentPolicy = NewPoolGroupDeploymentPolicyClient(aviSession)
	aviClient.PriorityLabels = NewPriorityLabelsClient(aviSession)
	aviClient.Role = NewRoleClient(aviSession)
	aviClient.SCPoolServerStateInfo = NewSCPoolServerStateInfoClient(aviSession)
	aviClient.SCVsStateInfo = NewSCVsStateInfoClient(aviSession)
	aviClient.SSLKeyAndCertificate = NewSSLKeyAndCertificateClient(aviSession)
	aviClient.SSLProfile = NewSSLProfileClient(aviSession)
	aviClient.Scheduler = NewSchedulerClient(aviSession)
	aviClient.SeProperties = NewSePropertiesClient(aviSession)
	aviClient.SecureChannelAvailableLocalIps = NewSecureChannelAvailableLocalIpsClient(aviSession)
	aviClient.SecureChannelMapping = NewSecureChannelMappingClient(aviSession)
	aviClient.SecureChannelToken = NewSecureChannelTokenClient(aviSession)
	aviClient.ServerAutoScalePolicy = NewServerAutoScalePolicyClient(aviSession)
	aviClient.ServiceEngine = NewServiceEngineClient(aviSession)
	aviClient.ServiceEngineGroup = NewServiceEngineGroupClient(aviSession)
	aviClient.SnmpTrapProfile = NewSnmpTrapProfileClient(aviSession)
	aviClient.StringGroup = NewStringGroupClient(aviSession)
	aviClient.SystemConfiguration = NewSystemConfigurationClient(aviSession)
	aviClient.Tenant = NewTenantClient(aviSession)
	aviClient.TrafficCloneProfile = NewTrafficCloneProfileClient(aviSession)
	aviClient.UserAccountProfile = NewUserAccountProfileClient(aviSession)
	aviClient.UserActivity = NewUserActivityClient(aviSession)
	aviClient.VIDCInfo = NewVIDCInfoClient(aviSession)
	aviClient.VIMgrClusterRuntime = NewVIMgrClusterRuntimeClient(aviSession)
	aviClient.VIMgrControllerRuntime = NewVIMgrControllerRuntimeClient(aviSession)
	aviClient.VIMgrDCRuntime = NewVIMgrDCRuntimeClient(aviSession)
	aviClient.VIMgrHostRuntime = NewVIMgrHostRuntimeClient(aviSession)
	aviClient.VIMgrNWRuntime = NewVIMgrNWRuntimeClient(aviSession)
	aviClient.VIMgrSEVMRuntime = NewVIMgrSEVMRuntimeClient(aviSession)
	aviClient.VIMgrVMRuntime = NewVIMgrVMRuntimeClient(aviSession)
	aviClient.VIMgrVcenterRuntime = NewVIMgrVcenterRuntimeClient(aviSession)
	aviClient.VIPGNameInfo = NewVIPGNameInfoClient(aviSession)
	aviClient.VSDataScriptSet = NewVSDataScriptSetClient(aviSession)
	aviClient.VirtualService = NewVirtualServiceClient(aviSession)
	aviClient.VrfContext = NewVrfContextClient(aviSession)
	aviClient.VsVip = NewVsVipClient(aviSession)
<<<<<<< HEAD
	aviClient.WafPolicy = NewWafPolicyClient(aviSession)
	aviClient.WafProfile = NewWafProfileClient(aviSession)
=======
>>>>>>> 4750eaa314c3d9dad91a358827406d1b51720139
	aviClient.Webhook = NewWebhookClient(aviSession)
	return &aviClient, nil
}
