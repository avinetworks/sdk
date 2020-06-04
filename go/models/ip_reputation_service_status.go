package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// IPReputationServiceStatus IP reputation service status
// swagger:model IPReputationServiceStatus
type IPReputationServiceStatus struct {

	// If the last attempted update failed, this contained the timestamp if this attempt. Field introduced in 20.1.1.
	LastFailedUpdateCheck *TimeStamp `json:"last_failed_update_check,omitempty"`

	// The time when we last successfull attemped to update this object. This may be different from the last update, if no new data was available. Field introduced in 20.1.1.
	LastSuccessfulUpdateCheck *TimeStamp `json:"last_successful_update_check,omitempty"`

	// If the last attempted update failed, this is a more detailed error message. Field introduced in 20.1.1.
	LastUpdateCheckError *string `json:"last_update_check_error,omitempty"`

	// Indicates the status of the last attempted update to the reputation db. Enum options - SYSERR_SUCCESS, SYSERR_FAILURE, SYSERR_OUT_OF_MEMORY, SYSERR_NO_ENT, SYSERR_INVAL, SYSERR_ACCESS, SYSERR_FAULT, SYSERR_IO, SYSERR_TIMEOUT, SYSERR_NOT_SUPPORTED, SYSERR_NOT_READY, SYSERR_UPGRADE_IN_PROGRESS, SYSERR_WARM_START_IN_PROGRESS, SYSERR_TRY_AGAIN, SYSERR_NOT_UPGRADING, SYSERR_PENDING, SYSERR_EVENT_GEN_FAILURE, SYSERR_CONFIG_PARAM_MISSING, SYSERR_BAD_REQUEST, SYSERR_TEST1.... Field introduced in 20.1.1.
	LastUpdateCheckStatus *string `json:"last_update_check_status,omitempty"`
}
