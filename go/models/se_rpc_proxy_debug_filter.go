package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// SeRPCProxyDebugFilter se Rpc proxy debug filter
// swagger:model SeRpcProxyDebugFilter
type SeRPCProxyDebugFilter struct {

	// Method name of RPC. Field introduced in 18.1.5.
	MethodName *string `json:"method_name,omitempty"`

	// Queue name of RPC. Field introduced in 18.1.5.
	Queue *string `json:"queue,omitempty"`

	// SE UUID. Field introduced in 18.1.5.
	SeUUID *string `json:"se_uuid,omitempty"`
}
