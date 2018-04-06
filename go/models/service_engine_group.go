package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// ServiceEngineGroup service engine group
// swagger:model ServiceEngineGroup
type ServiceEngineGroup struct {

	// Service Engines in active/standby mode for HA failover.
	ActiveStandby bool `json:"active_standby,omitempty"`

	// Advertise reach-ability of backend server networks via ADC through BGP for default gateway feature.
	AdvertiseBackendNetworks bool `json:"advertise_backend_networks,omitempty"`

	// Enable aggressive failover configuration for ha.
	AggressiveFailureDetection bool `json:"aggressive_failure_detection,omitempty"`

	// In compact placement, Virtual Services are placed on existing SEs until max_vs_per_se limit is reached. Enum options - PLACEMENT_ALGO_PACKED, PLACEMENT_ALGO_DISTRIBUTED.
	Algo string `json:"algo,omitempty"`

	// Allow SEs to be created using burst license. Field introduced in 17.2.5.
	AllowBurst bool `json:"allow_burst,omitempty"`

	// Amount of SE memory in GB until which shared memory is collected in core archive. Field introduced in 17.1.3. Units(GB).
	ArchiveShmLimit int32 `json:"archive_shm_limit,omitempty"`

	// SSL handshakes will be handled by dedicated SSL Threads.
	AsyncSsl bool `json:"async_ssl,omitempty"`

	// Number of Async SSL threads per se_dp. Allowed values are 1-16.
	AsyncSslThreads int32 `json:"async_ssl_threads,omitempty"`

	// If set, Virtual Services will be automatically migrated when load on an SE is less than minimum or more than maximum thresholds. Only Alerts are generated when the auto_rebalance is not set.
	AutoRebalance bool `json:"auto_rebalance,omitempty"`

	// Capacities of SE for auto rebalance for each criteria. Field introduced in 17.2.4.
	AutoRebalanceCapacityPerSe []int64 `json:"auto_rebalance_capacity_per_se,omitempty,omitempty"`

	// Set of criteria for SE Auto Rebalance. Enum options - SE_AUTO_REBALANCE_CPU, SE_AUTO_REBALANCE_PPS, SE_AUTO_REBALANCE_MBPS, SE_AUTO_REBALANCE_OPEN_CONNS, SE_AUTO_REBALANCE_CPS. Field introduced in 17.2.3.
	AutoRebalanceCriteria []string `json:"auto_rebalance_criteria,omitempty"`

	// Frequency of rebalance, if 'Auto rebalance' is enabled. Units(SEC).
	AutoRebalanceInterval int32 `json:"auto_rebalance_interval,omitempty"`

	// Redistribution of virtual services from the takeover SE to the replacement SE can cause momentary traffic loss. If the auto-redistribute load option is left in its default off state, any desired rebalancing requires calls to REST API.
	AutoRedistributeActiveStandbyLoad bool `json:"auto_redistribute_active_standby_load,omitempty"`

	// Excess Service Engine capacity provisioned for HA failover.
	BufferSe int32 `json:"buffer_se,omitempty"`

	//  It is a reference to an object of type Cloud.
	CloudRef string `json:"cloud_ref,omitempty"`

	// Percentage of memory for connection state. This will come at the expense of memory used for HTTP in-memory cache. Allowed values are 10-90. Units(PERCENT).
	ConnectionMemoryPercentage int32 `json:"connection_memory_percentage,omitempty"`

	// Placeholder for description of property cpu_reserve of obj type ServiceEngineGroup field type str  type boolean
	CPUReserve bool `json:"cpu_reserve,omitempty"`

	// Allocate all the CPU cores for the Service Engine Virtual Machines  on the same CPU socket. Applicable only for vCenter Cloud.
	CPUSocketAffinity bool `json:"cpu_socket_affinity,omitempty"`

	// Custom Security Groups to be associated with data vNics for SE instances in OpenStack and AWS Clouds. Field introduced in 17.1.3.
	CustomSecuritygroupsData []string `json:"custom_securitygroups_data,omitempty"`

	// Custom Security Groups to be associated with management vNic for SE instances in OpenStack and AWS Clouds. Field introduced in 17.1.3.
	CustomSecuritygroupsMgmt []string `json:"custom_securitygroups_mgmt,omitempty"`

	// Custom tag will be used to create the tags for SE instance in AWS. Note this is not the same as the prefix for SE name.
	CustomTag []*CustomTag `json:"custom_tag,omitempty"`

	// Dedicate the core that handles packet receive/transmit from the network to just the dispatching function. Don't use it for TCP/IP and SSL functions.
	DedicatedDispatcherCore bool `json:"dedicated_dispatcher_core,omitempty"`

	// User defined description for the object.
	Description string `json:"description,omitempty"`

	// Stop using TCP/UDP and IP checksum offload features of NICs. Field introduced in 17.1.14, 17.2.5.
	DisableCsumOffloads bool `json:"disable_csum_offloads,omitempty"`

	// Disable Generic Receive Offload (GRO) in DPDK poll-mode driver packet receive path.  GRO is on by default on NICs that do not support LRO (Large Receive Offload) or do not gain performance boost from LRO. Field introduced in 17.2.5.
	DisableGro bool `json:"disable_gro,omitempty"`

	// Disable TCP Segmentation Offload (TSO) in DPDK poll-mode driver packet transmit path.  TSO is on by default on NICs that support it. Field introduced in 17.2.5.
	DisableTso bool `json:"disable_tso,omitempty"`

	// Amount of disk space for each of the Service Engine virtual machines. Units(GB).
	DiskPerSe int32 `json:"disk_per_se,omitempty"`

	// Use both the active and standby Service Engines for Virtual Service placement in the legacy active standby HA mode.
	DistributeLoadActiveStandby bool `json:"distribute_load_active_standby,omitempty"`

	// Distributes queue ownership among cores so multiple cores handle dispatcher duties. Field introduced in 17.2.8.
	DistributeQueues bool `json:"distribute_queues,omitempty"`

	// (This is a beta feature). Enable HSM key priming. If enabled, key handles on the hsm will be synced to SE before processing client connections. Field introduced in 17.2.7.
	EnableHsmPriming bool `json:"enable_hsm_priming,omitempty"`

	// Enable routing for this ServiceEngineGroup .
	EnableRouting bool `json:"enable_routing,omitempty"`

	// Enable VIP on all interfaces of SE. Field introduced in 17.1.1.
	EnableVipOnAllInterfaces bool `json:"enable_vip_on_all_interfaces,omitempty"`

	// Use Virtual MAC address for interfaces on which floating interface IPs are placed.
	EnableVMAC bool `json:"enable_vmac,omitempty"`

	// Multiplier for extra config to support large VS/Pool config.
	ExtraConfigMultiplier float64 `json:"extra_config_multiplier,omitempty"`

	// Extra config memory to support large Geo DB configuration. Field introduced in 17.1.1. Units(MB).
	ExtraSharedConfigMemory int32 `json:"extra_shared_config_memory,omitempty"`

	// If ServiceEngineGroup is configured for Legacy 1+1 Active Standby HA Mode, Floating IP's will be advertised only by the Active SE in the Pair. Virtual Services in this group must be disabled/enabled for any changes to the Floating IP's to take effect. Only active SE hosting VS tagged with Active Standby SE 1 Tag will advertise this floating IP when manual load distribution is enabled.
	FloatingIntfIP []*IPAddr `json:"floating_intf_ip,omitempty"`

	// If ServiceEngineGroup is configured for Legacy 1+1 Active Standby HA Mode, Floating IP's will be advertised only by the Active SE in the Pair. Virtual Services in this group must be disabled/enabled for any changes to the Floating IP's to take effect. Only active SE hosting VS tagged with Active Standby SE 2 Tag will advertise this floating IP when manual load distribution is enabled.
	FloatingIntfIPSe2 []*IPAddr `json:"floating_intf_ip_se_2,omitempty"`

	// Maximum number of flow table entries that have not completed TCP three-way handshake yet. Field introduced in 17.2.5.
	FlowTableNewSynMaxEntries int32 `json:"flow_table_new_syn_max_entries,omitempty"`

	// High Availability mode for all the Virtual Services using this Service Engine group. Enum options - HA_MODE_SHARED_PAIR, HA_MODE_SHARED, HA_MODE_LEGACY_ACTIVE_STANDBY.
	HaMode string `json:"ha_mode,omitempty"`

	//  It is a reference to an object of type HardwareSecurityModuleGroup.
	HardwaresecuritymodulegroupRef string `json:"hardwaresecuritymodulegroup_ref,omitempty"`

	// Enable active health monitoring from the standby SE for all placed virtual services.
	HmOnStandby bool `json:"hm_on_standby,omitempty"`

	// Key of a (Key, Value) pair identifying a label for a set of Nodes usually in Container Clouds. Needs to be specified together with host_attribute_value. SEs can be configured differently including HA modes across different SE Groups. May also be used for isolation between different classes of VirtualServices. VirtualServices' SE Group may be specified via annotations/labels. A OpenShift/Kubernetes namespace maybe annotated with a matching SE Group label as openshift.io/node-selector  apptype=prod. When multiple SE Groups are used in a Cloud with host attributes specified,just a single SE Group can exist as a match-all SE Group without a host_attribute_key.
	HostAttributeKey string `json:"host_attribute_key,omitempty"`

	// Value of a (Key, Value) pair identifying a label for a set of Nodes usually in Container Clouds. Needs to be specified together with host_attribute_key.
	HostAttributeValue string `json:"host_attribute_value,omitempty"`

	// Enable the host gateway monitor when service engine is deployed as docker container. Disabled by default. Field introduced in 17.2.4.
	HostGatewayMonitor bool `json:"host_gateway_monitor,omitempty"`

	// Override default hypervisor. Enum options - DEFAULT, VMWARE_ESX, KVM, VMWARE_VSAN, XEN.
	Hypervisor string `json:"hypervisor,omitempty"`

	// Ignore RTT samples if it is above threshold. Field introduced in 17.1.6,17.2.2. Units(MILLISECONDS).
	IgnoreRttThreshold int32 `json:"ignore_rtt_threshold,omitempty"`

	// Program SE security group ingress rules to allow VIP data access from remote CIDR type. Enum options - SG_INGRESS_ACCESS_NONE, SG_INGRESS_ACCESS_ALL, SG_INGRESS_ACCESS_VPC. Field introduced in 17.1.5.
	IngressAccessData string `json:"ingress_access_data,omitempty"`

	// Program SE security group ingress rules to allow SSH/ICMP management access from remote CIDR type. Enum options - SG_INGRESS_ACCESS_NONE, SG_INGRESS_ACCESS_ALL, SG_INGRESS_ACCESS_VPC. Field introduced in 17.1.5.
	IngressAccessMgmt string `json:"ingress_access_mgmt,omitempty"`

	// Instance/Flavor type for SE instance.
	InstanceFlavor string `json:"instance_flavor,omitempty"`

	// Iptable Rules.
	Iptables []*IptableRuleSet `json:"iptables,omitempty"`

	// Select core with least load for new flow.
	LeastLoadCoreSelection bool `json:"least_load_core_selection,omitempty"`

	// Specifies the license tier which would be used. This field by default inherits the value from cloud. Enum options - ENTERPRISE_16, ENTERPRISE_18. Field introduced in 17.2.5.
	LicenseTier string `json:"license_tier,omitempty"`

	// If no license type is specified then default license enforcement for the cloud type is chosen. Enum options - LIC_BACKEND_SERVERS, LIC_SOCKETS, LIC_CORES, LIC_HOSTS, LIC_SE_BANDWIDTH. Field introduced in 17.2.5.
	LicenseType string `json:"license_type,omitempty"`

	// Maximum disk capacity (in MB) to be allocated to an SE. This is exclusively used for debug and log data. Units(MB).
	LogDisksz int32 `json:"log_disksz,omitempty"`

	// When CPU usage on an SE exceeds this threshold, Virtual Services hosted on this SE may be rebalanced to other SEs to reduce load. A new SE may be created as part of this process. Allowed values are 40-90. Units(PERCENT).
	MaxCPUUsage int32 `json:"max_cpu_usage,omitempty"`

	// Maximum number of active Service Engines for the Virtual Service. Allowed values are 1-64.
	MaxScaleoutPerVs int32 `json:"max_scaleout_per_vs,omitempty"`

	// Maximum number of Services Engines in this group. Allowed values are 0-1000.
	MaxSe int32 `json:"max_se,omitempty"`

	// Maximum number of Virtual Services that can be placed on a single Service Engine. East West Virtual Services are excluded from this limit. Allowed values are 1-1000.
	MaxVsPerSe int32 `json:"max_vs_per_se,omitempty"`

	// Placeholder for description of property mem_reserve of obj type ServiceEngineGroup field type str  type boolean
	MemReserve bool `json:"mem_reserve,omitempty"`

	// Amount of memory for each of the Service Engine virtual machines.
	MemoryPerSe int32 `json:"memory_per_se,omitempty"`

	// Management network to use for Avi Service Engines. It is a reference to an object of type Network.
	MgmtNetworkRef string `json:"mgmt_network_ref,omitempty"`

	// Management subnet to use for Avi Service Engines.
	MgmtSubnet *IPAddrPrefix `json:"mgmt_subnet,omitempty"`

	// When CPU usage on an SE falls below the minimum threshold, Virtual Services hosted on the SE may be consolidated onto other underutilized SEs. After consolidation, unused Service Engines may then be eligible for deletion. . Allowed values are 20-60. Units(PERCENT).
	MinCPUUsage int32 `json:"min_cpu_usage,omitempty"`

	// Minimum number of active Service Engines for the Virtual Service. Allowed values are 1-64.
	MinScaleoutPerVs int32 `json:"min_scaleout_per_vs,omitempty"`

	// Name of the object.
	// Required: true
	Name string `json:"name"`

	// This setting limits the number of non-significant logs generated per second per core on this SE. Default is 100 logs per second. Set it to zero (0) to disable throttling. Field introduced in 17.1.3. Units(PER_SECOND).
	NonSignificantLogThrottle int32 `json:"non_significant_log_throttle,omitempty"`

	// Number of changes in num flow cores sum to ignore.
	NumFlowCoresSumChangesToIgnore int32 `json:"num_flow_cores_sum_changes_to_ignore,omitempty"`

	//  Field deprecated in 17.1.1.
	OpenstackAvailabilityZone string `json:"openstack_availability_zone,omitempty"`

	//  Field introduced in 17.1.1.
	OpenstackAvailabilityZones []string `json:"openstack_availability_zones,omitempty"`

	// Avi Management network name.
	OpenstackMgmtNetworkName string `json:"openstack_mgmt_network_name,omitempty"`

	// Management network UUID.
	OpenstackMgmtNetworkUUID string `json:"openstack_mgmt_network_uuid,omitempty"`

	// Amount of extra memory to be reserved for use by the Operating System on a Service Engine.
	OsReservedMemory int32 `json:"os_reserved_memory,omitempty"`

	// Per-app SE mode is designed for deploying dedicated load balancers per app (VS). In this mode, each SE is limited to a max of 2 VSs. vCPUs in per-app SEs count towards licensing usage at 25% rate.
	PerApp bool `json:"per_app,omitempty"`

	// If placement mode is 'Auto', Virtual Services are automatically placed on Service Engines. Enum options - PLACEMENT_MODE_AUTO.
	PlacementMode string `json:"placement_mode,omitempty"`

	// Enable or disable real time SE metrics.
	RealtimeSeMetrics *MetricsRealTimeUpdate `json:"realtime_se_metrics,omitempty"`

	// Select the SE bandwidth for the bandwidth license. Enum options - SE_BANDWIDTH_UNLIMITED, SE_BANDWIDTH_25M, SE_BANDWIDTH_200M, SE_BANDWIDTH_1000M, SE_BANDWIDTH_10000M. Field introduced in 17.2.5.
	SeBandwidthType string `json:"se_bandwidth_type,omitempty"`

	// Duration to preserve unused Service Engine virtual machines before deleting them. If traffic to a Virtual Service were to spike up abruptly, this SE would still be available to be utilized again rather than creating a new SE. If this value is set to 0, Controller will never delete any SEs and administrator has to manually cleanup unused SEs. Allowed values are 0-525600. Units(MIN).
	SeDeprovisionDelay int32 `json:"se_deprovision_delay,omitempty"`

	// Placeholder for description of property se_dos_profile of obj type ServiceEngineGroup field type str  type object
	SeDosProfile *DosThresholdProfile `json:"se_dos_profile,omitempty"`

	// UDP Port for SE_DP IPC in Docker bridge mode. Field introduced in 17.1.2.
	SeIpcUDPPort int32 `json:"se_ipc_udp_port,omitempty"`

	// Prefix to use for virtual machine name of Service Engines.
	SeNamePrefix string `json:"se_name_prefix,omitempty"`

	// TCP port on SE where echo service will be run. Field introduced in 17.2.2.
	SeProbePort int32 `json:"se_probe_port,omitempty"`

	// UDP Port for punted packets in Docker bridge mode. Field introduced in 17.1.2.
	SeRemotePuntUDPPort int32 `json:"se_remote_punt_udp_port,omitempty"`

	// Sideband traffic will be handled by a dedicated core. Field introduced in 16.5.2, 17.1.9, 17.2.3.
	SeSbDedicatedCore bool `json:"se_sb_dedicated_core,omitempty"`

	// Number of Sideband threads per SE. Allowed values are 1-128. Field introduced in 16.5.2, 17.1.9, 17.2.3.
	SeSbThreads int32 `json:"se_sb_threads,omitempty"`

	// Multiplier for SE threads based on vCPU. Allowed values are 1-10.
	SeThreadMultiplier int32 `json:"se_thread_multiplier,omitempty"`

	// Traceroute port range. Field introduced in 17.2.8.
	SeTracertPortRange *PortRange `json:"se_tracert_port_range,omitempty"`

	// Determines if DSR from secondary SE is active or not  0  Automatically determine based on hypervisor type. 1  Disable DSR unconditionally. ~[0,1]  Enable DSR unconditionally. . Field introduced in 17.1.1.
	SeTunnelMode int32 `json:"se_tunnel_mode,omitempty"`

	// UDP Port for tunneled packets from secondary to primary SE in Docker bridge mode. Field introduced in 17.1.3.
	SeTunnelUDPPort int32 `json:"se_tunnel_udp_port,omitempty"`

	// Determines if SE-SE IPC messages are encapsulated in an UDP header  0  Automatically determine based on hypervisor type. 1  Use UDP encap unconditionally. ~[0,1]  Don't use UDP encap. Field introduced in 17.1.2.
	SeUDPEncapIpc int32 `json:"se_udp_encap_ipc,omitempty"`

	// Maximum number of aggregated vs heartbeat packets to send in a batch. Allowed values are 1-256. Field introduced in 17.1.1.
	SeVsHbMaxPktsInBatch int32 `json:"se_vs_hb_max_pkts_in_batch,omitempty"`

	// Maximum number of virtualservices for which heartbeat messages are aggregated in one packet. Allowed values are 1-1024. Field introduced in 17.1.1.
	SeVsHbMaxVsInPkt int32 `json:"se_vs_hb_max_vs_in_pkt,omitempty"`

	// Subnets assigned to the SE group. Required for VS group placement. Field introduced in 17.1.1.
	ServiceIPSubnets []*IPAddrPrefix `json:"service_ip_subnets,omitempty"`

	// This setting limits the number of significant logs generated per second per core on this SE. Default is 100 logs per second. Set it to zero (0) to disable throttling. Field introduced in 17.1.3. Units(PER_SECOND).
	SignificantLogThrottle int32 `json:"significant_log_throttle,omitempty"`

	//  It is a reference to an object of type Tenant.
	TenantRef string `json:"tenant_ref,omitempty"`

	// This setting limits the number of UDF logs generated per second per core on this SE. UDF logs are generated due to the configured client log filters or the rules with logging enabled. Default is 100 logs per second. Set it to zero (0) to disable throttling. Field introduced in 17.1.3. Units(PER_SECOND).
	UdfLogThrottle int32 `json:"udf_log_throttle,omitempty"`

	// url
	// Read Only: true
	URL string `json:"url,omitempty"`

	// Unique object identifier of the object.
	UUID string `json:"uuid,omitempty"`

	// Placeholder for description of property vcenter_clusters of obj type ServiceEngineGroup field type str  type object
	VcenterClusters *VcenterClusters `json:"vcenter_clusters,omitempty"`

	//  Enum options - VCENTER_DATASTORE_ANY, VCENTER_DATASTORE_LOCAL, VCENTER_DATASTORE_SHARED.
	VcenterDatastoreMode string `json:"vcenter_datastore_mode,omitempty"`

	// Placeholder for description of property vcenter_datastores of obj type ServiceEngineGroup field type str  type object
	VcenterDatastores []*VcenterDatastore `json:"vcenter_datastores,omitempty"`

	// Placeholder for description of property vcenter_datastores_include of obj type ServiceEngineGroup field type str  type boolean
	VcenterDatastoresInclude bool `json:"vcenter_datastores_include,omitempty"`

	// Folder to place all the Service Engine virtual machines in vCenter.
	VcenterFolder string `json:"vcenter_folder,omitempty"`

	// Placeholder for description of property vcenter_hosts of obj type ServiceEngineGroup field type str  type object
	VcenterHosts *VcenterHosts `json:"vcenter_hosts,omitempty"`

	// Number of vcpus for each of the Service Engine virtual machines.
	VcpusPerSe int32 `json:"vcpus_per_se,omitempty"`

	// Ensure primary and secondary Service Engines are deployed on different physical hosts.
	VsHostRedundancy bool `json:"vs_host_redundancy,omitempty"`

	// Time to wait for the scaled in SE to drain existing flows before marking the scalein done. Units(SEC).
	VsScaleinTimeout int32 `json:"vs_scalein_timeout,omitempty"`

	// During SE upgrade, Time to wait for the scaled-in SE to drain existing flows before marking the scalein done. Units(SEC).
	VsScaleinTimeoutForUpgrade int32 `json:"vs_scalein_timeout_for_upgrade,omitempty"`

	// Time to wait for the scaled out SE to become ready before marking the scaleout done. Units(SEC).
	VsScaleoutTimeout int32 `json:"vs_scaleout_timeout,omitempty"`

	// If set, Virtual Services will be placed on only a subset of the cores of an SE. Field introduced in 17.2.5.
	VssPlacement *VssPlacement `json:"vss_placement,omitempty"`

	// Enable memory pool for WAF. Field introduced in 17.2.3.
	WafMempool bool `json:"waf_mempool,omitempty"`

	// Memory pool size used for WAF. Field introduced in 17.2.3. Units(KB).
	WafMempoolSize int32 `json:"waf_mempool_size,omitempty"`
}
