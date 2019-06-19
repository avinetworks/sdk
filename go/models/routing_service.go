package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// RoutingService routing service
// swagger:model RoutingService
type RoutingService struct {

	// Advertise reachability of backend server networks via ADC through BGP for default gateway feature. Field introduced in 18.2.5.
	AdvertiseBackendNetworks *bool `json:"advertise_backend_networks,omitempty"`

	// Service Engine acts as Default Gateway for this service. Field introduced in 18.2.5.
	EnableRouting *bool `json:"enable_routing,omitempty"`

	// Enable VIP on all interfaces of this service. Field introduced in 18.2.5.
	EnableVipOnAllInterfaces *bool `json:"enable_vip_on_all_interfaces,omitempty"`

	// Floating Interface IPs for the RoutingService. Field introduced in 18.2.5.
	FloatingIntfIP []*IPAddr `json:"floating_intf_ip,omitempty"`

	// Routing Service related Flow profile information. Field introduced in 18.2.5.
	FlowtableProfile *FlowtableProfile `json:"flowtable_profile,omitempty"`

	// NAT policy for outbound NAT functionality. This is done in post-routing. It is a reference to an object of type NatPolicy. Field introduced in 18.2.5.
	NatPolicyRef *string `json:"nat_policy_ref,omitempty"`

	// For IP Routing feature, enabling this knob will fallback to routing through Linux, by default routing is done via Service Engine data-path. Field introduced in 18.2.5.
	RoutingByLinuxIpstack *bool `json:"routing_by_linux_ipstack,omitempty"`
}
