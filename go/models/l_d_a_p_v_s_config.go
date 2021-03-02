package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// LDAPVSConfig l d a p v s config
// swagger:model LDAPVSConfig
type LDAPVSConfig struct {

	// Basic authentication realm to present to a user along with the prompt for credentials. Field introduced in 21.1.1.
	Realm *string `json:"realm,omitempty"`

	// Default bind timeout enforced on connections to LDAP server. Field introduced in 21.1.1. Unit is MILLISECONDS.
	SeAuthLdapBindTimeout *int32 `json:"se_auth_ldap_bind_timeout,omitempty"`

	// Size of LDAP auth credentials cache used on the dataplane. Field introduced in 21.1.1. Unit is BYTES.
	SeAuthLdapCacheSize *int32 `json:"se_auth_ldap_cache_size,omitempty"`

	// Default connection timeout enforced on connections to LDAP server. Field introduced in 21.1.1. Unit is MILLISECONDS.
	SeAuthLdapConnectTimeout *int32 `json:"se_auth_ldap_connect_timeout,omitempty"`

	// Number of concurrent connections to LDAP server by a single basic auth LDAP process. Field introduced in 21.1.1.
	SeAuthLdapConnsPerServer *int32 `json:"se_auth_ldap_conns_per_server,omitempty"`

	// Default reconnect timeout enforced on connections to LDAP server. Field introduced in 21.1.1. Unit is MILLISECONDS.
	SeAuthLdapReconnectTimeout *int32 `json:"se_auth_ldap_reconnect_timeout,omitempty"`

	// Default login or group search request timeout enforced on connections to LDAP server. Field introduced in 21.1.1. Unit is MILLISECONDS.
	SeAuthLdapRequestTimeout *int32 `json:"se_auth_ldap_request_timeout,omitempty"`

	// If enabled, connections are always made to the first available LDAP server in the list and will failover to subsequent servers. Field introduced in 21.1.1.
	SeAuthLdapServersFailoverOnly *bool `json:"se_auth_ldap_servers_failover_only,omitempty"`
}
