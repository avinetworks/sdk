package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// IcapNSXDefenderLog icap n s x defender log
// swagger:model IcapNSXDefenderLog
type IcapNSXDefenderLog struct {

	// Score associated with the uploaded file, if known, value is in between 0 and 100. Field introduced in 21.1.1.
	Score *int32 `json:"score,omitempty"`

	// The NSX Defender task UUID associated with the analysis of the file. It is possible to use this UUID in order to access the analysis details from the NSX Defender Portal/Manager Web UI. URL to access this information is https //user.lastline.com/portal#/analyst/task/<uuid>/overview. Field introduced in 21.1.1.
	TaskUUID *string `json:"task_uuid,omitempty"`
}
