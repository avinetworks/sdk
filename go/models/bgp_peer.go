package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// BgpPeer bgp peer
// swagger:model BgpPeer
type BgpPeer struct {

	// Advertise SNAT IP to this Peer.
	AdvertiseSnatIP bool `json:"advertise_snat_ip,omitempty"`

	// Advertise VIP to this Peer.
	AdvertiseVip bool `json:"advertise_vip,omitempty"`

	// Advertisement interval for this Peer. Allowed values are 1-60.
	AdvertisementInterval int32 `json:"advertisement_interval,omitempty"`

	// Enable Bi-Directional Forward Detection. Only async mode supported.
	Bfd bool `json:"bfd,omitempty"`

	// Connect timer for this Peer. Allowed values are 1-120.
	ConnectTimer int32 `json:"connect_timer,omitempty"`

	// Hold time for this Peer. Allowed values are 3-7200.
	HoldTime int32 `json:"hold_time,omitempty"`

	// Keepalive interval for this Peer. Allowed values are 0-3600.
	KeepaliveInterval int32 `json:"keepalive_interval,omitempty"`

	// Peer Autonomous System Md5 Digest Secret Key.
	Md5Secret string `json:"md5_secret,omitempty"`

	// Network providing reachability for Peer. It is a reference to an object of type Network.
	NetworkRef string `json:"network_ref,omitempty"`

	// IP Address of the BGP Peer.
	// Required: true
	PeerIP *IPAddr `json:"peer_ip"`

	// Peer Autonomous System ID. Allowed values are 1-4294967295.
	RemoteAs int32 `json:"remote_as,omitempty"`

	// Subnet providing reachability for Peer.
	// Required: true
	Subnet *IPAddrPrefix `json:"subnet"`
}
