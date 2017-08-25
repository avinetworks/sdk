package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// LinuxConfiguration linux configuration
// swagger:model LinuxConfiguration
type LinuxConfiguration struct {

	// Banner displayed before login to ssh, and UI.
	Banner string `json:"banner,omitempty"`

	// Message of the day, shown to users on login via the command line interface, web interface, or ssh.
	Motd string `json:"motd,omitempty"`
}
