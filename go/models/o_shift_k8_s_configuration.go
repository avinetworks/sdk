package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// OShiftK8SConfiguration o shift k8 s configuration
// swagger:model OShiftK8SConfiguration
type OShiftK8SConfiguration struct {

	// Sync frequency in seconds with frameworks.
	AppSyncFrequency int32 `json:"app_sync_frequency,omitempty"`

	// Auto assign FQDN to a virtual service if a valid FQDN is not configured. Field introduced in 17.2.8.
	AutoAssignFqdn bool `json:"auto_assign_fqdn,omitempty"`

	// Avi Linux bridge subnet on OpenShift/K8s nodes.
	AviBridgeSubnet *IPAddrPrefix `json:"avi_bridge_subnet,omitempty"`

	// UUID of the UCP CA TLS cert and key. It is a reference to an object of type SSLKeyAndCertificate.
	CaTLSKeyAndCertificateRef string `json:"ca_tls_key_and_certificate_ref,omitempty"`

	// UUID of the client TLS cert and key instead of service account token. One of client certificate or token is required. It is a reference to an object of type SSLKeyAndCertificate.
	ClientTLSKeyAndCertificateRef string `json:"client_tls_key_and_certificate_ref,omitempty"`

	// Openshift/K8S Cluster ID used to uniquely map same named namespaces as tenants in Avi. Warn  All virtual services will be disrupted if this field is modified. Field introduced in 17.2.5.
	ClusterTag string `json:"cluster_tag,omitempty"`

	// Perform container port matching to create a HTTP Virtualservice instead of a TCP/UDP VirtualService. Set either service_port_match_http_service or container_port_match_http_service.
	ContainerPortMatchHTTPService bool `json:"container_port_match_http_service,omitempty"`

	// Directory to mount to check for core dumps on Service Engines. This will be mapped read only to /var/crash on any new Service Engines. This is a disruptive change.
	CoredumpDirectory string `json:"coredump_directory,omitempty"`

	// If there is no explicit east_west_placement field in virtualservice configuration, treat service as a East-West service; default services such a OpenShift API server do not have virtualservice configuration.
	DefaultServiceAsEastWestService bool `json:"default_service_as_east_west_service,omitempty"`

	// Deprecated. Field deprecated in 17.1.9. Field introduced in 17.1.1.
	DefaultSharedVirtualservice *OshiftSharedVirtualService `json:"default_shared_virtualservice,omitempty"`

	// Disable auto service sync for back end services.
	DisableAutoBackendServiceSync bool `json:"disable_auto_backend_service_sync,omitempty"`

	// Disable auto service sync for front end services.
	DisableAutoFrontendServiceSync bool `json:"disable_auto_frontend_service_sync,omitempty"`

	// Disable auto sync for GSLB services. Field introduced in 17.1.3.
	DisableAutoGsSync bool `json:"disable_auto_gs_sync,omitempty"`

	// Disable SE creation.
	DisableAutoSeCreation bool `json:"disable_auto_se_creation,omitempty"`

	// Docker registry for ServiceEngine image.
	DockerRegistrySe *DockerRegistry `json:"docker_registry_se,omitempty"`

	// Match against this prefix when placing east-west VSs on SEs .
	EastWestPlacementSubnet *IPAddrPrefix `json:"east_west_placement_subnet,omitempty"`

	// Enable Kubernetes event subscription.
	EnableEventSubscription bool `json:"enable_event_subscription,omitempty"`

	// Enable proxy ARP from Host interface for Front End  proxies.
	FeproxyVipsEnableProxyArp bool `json:"feproxy_vips_enable_proxy_arp,omitempty"`

	// Optional fleet remote endpoint if fleet is used for SE deployment.
	FleetEndpoint string `json:"fleet_endpoint,omitempty"`

	// List of container ports that create a HTTP Virtualservice instead of a TCP/UDP VirtualService. Defaults to 80.
	HTTPContainerPorts []int64 `json:"http_container_ports,omitempty,omitempty"`

	// Perform Layer4 (TCP/UDP) health monitoring even for Layer7 (HTTP) Pools.
	L4HealthMonitoring bool `json:"l4_health_monitoring,omitempty"`

	// List of OpenShift/Kubernetes master nodes; In case of a load balanced OpenShift/K8S cluster, use Virtual IP of the cluster. Each node is of the form node 8443 or http //node 8080. If scheme is not provided, https is assumed.
	MasterNodes []string `json:"master_nodes,omitempty"`

	// OpenShift/K8S Node label to be used as OpenShift/K8S Node's availability zone in a dual availability zone deployment. ServiceEngines belonging to the availability zone will be rebooted during a manual DR failover.
	NodeAvailabilityZoneLabel string `json:"node_availability_zone_label,omitempty"`

	// Syncing of applications is disabled only for namespaces/projects that have these exclude attributes configured. If there are apps synced already for these namespaces, they will be removed from Avi. Field introduced in 17.1.9,17.2.3.
	NsExcludeAttributes []*MesosAttribute `json:"ns_exclude_attributes,omitempty"`

	// Sync applications only for namespaces/projects that have these include attributes configured. Field introduced in 17.1.9,17.2.3.
	NsIncludeAttributes []*MesosAttribute `json:"ns_include_attributes,omitempty"`

	// Nuage Overlay SDN Controller information.
	NuageController *NuageSDNController `json:"nuage_controller,omitempty"`

	// Deprecated. Field deprecated in 17.1.9. Field introduced in 17.1.1.
	RoutesShareVirtualservice bool `json:"routes_share_virtualservice,omitempty"`

	// Cluster uses overlay based SDN. Enable this flag if cluster uses a overlay based SDN for OpenShift, Flannel, Weave, Nuage. Disable for routed mode.
	SdnOverlay bool `json:"sdn_overlay,omitempty"`

	// Use SSH/Pod for SE deployment. Enum options - SE_CREATE_FLEET, SE_CREATE_SSH, SE_CREATE_POD.
	SeDeploymentMethod string `json:"se_deployment_method,omitempty"`

	// Exclude hosts with attributes for SE creation.
	SeExcludeAttributes []*MesosAttribute `json:"se_exclude_attributes,omitempty"`

	// Create SEs just on hosts with include attributes.
	SeIncludeAttributes []*MesosAttribute `json:"se_include_attributes,omitempty"`

	// New SE spawn rate per minute.
	SeSpawnRate int32 `json:"se_spawn_rate,omitempty"`

	// Host volume to be used as a disk for Avi SE, This is a disruptive change.
	SeVolume string `json:"se_volume,omitempty"`

	// Allow Avi Vantage to create SecurityContextConstraints and ServiceAccounts which allow Egress Pods to run in privileged mode in an Openshift environment. Enabling this would exclude egress services from 'disable_auto_backend_service_sync' (if set) behaviour. Note  Access credentials must have cluster-admin role privileges. Field introduced in 17.1.1.
	SecureEgressMode bool `json:"secure_egress_mode,omitempty"`

	// Authorization token for service account instead of client certificate. One of client certificate or token is required.
	ServiceAccountToken string `json:"service_account_token,omitempty"`

	// Perform service port matching to create a HTTP Virtualservice instead of a TCP/UDP VirtualService. Set either service_port_match_http_service or container_port_match_http_service.
	ServicePortMatchHTTPService bool `json:"service_port_match_http_service,omitempty"`

	// Projects/Namespaces use a shared virtualservice for http/https Routes and Ingress objects unless overriden by the avi_virtualservice  dedicated|shared annotation. Field introduced in 17.1.9,17.2.3.
	SharedVirtualserviceNamespace bool `json:"shared_virtualservice_namespace,omitempty"`

	// Parameters for SSH SE deployment. Field deprecated in 17.1.1.
	SSHSeDeployment *SSHSeDeployment `json:"ssh_se_deployment,omitempty"`

	// Cloud connector user uuid for SSH to hosts. It is a reference to an object of type CloudConnectorUser. Field introduced in 17.1.1.
	SSHUserRef string `json:"ssh_user_ref,omitempty"`

	// If true, use controller generated SE docker image via fileservice, else use docker repository image as defined by docker_registry_se.
	UseControllerImage bool `json:"use_controller_image,omitempty"`

	// Enable VirtualService placement on Service Engines on nodes with scheduling disabled. When false, Service Engines are disabled on nodes where scheduling is disabled.
	UseSchedulingDisabledNodes bool `json:"use_scheduling_disabled_nodes,omitempty"`

	// Use Cluster IP of service as VIP for East-West services; This option requires that kube proxy is disabled on all nodes.
	UseServiceClusterIPAsEwVip bool `json:"use_service_cluster_ip_as_ew_vip,omitempty"`
}
