package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// HSMSafenetLunaServer h s m safenet luna server
// swagger:model HSMSafenetLunaServer
type HSMSafenetLunaServer struct {

	// Password of the partition assigned to this client.
	PartitionPasswd string `json:"partition_passwd,omitempty"`

	// IP address of the Safenet/Gemalto HSM device.
	// Required: true
	RemoteIP string `json:"remote_ip"`

	// CA certificate of the server.
	// Required: true
	ServerCert string `json:"server_cert"`
}
