package models

// This file is auto-generated.
// Please contact avi-sdk@avinetworks.com for any change requests.

// SSLCipherList s s l cipher list
// swagger:model SSLCipherList
type SSLCipherList struct {

	// List of ciphers from the client's SSL cipher list that could be identified. The ciphers are represented by their RFC name. Enum options - AVI_TLS_NULL_WITH_NULL_NULL, AVI_TLS_RSA_WITH_NULL_MD5, AVI_TLS_RSA_WITH_NULL_SHA, AVI_TLS_RSA_EXPORT_WITH_RC4_40_MD5, AVI_TLS_RSA_WITH_RC4_128_MD5, AVI_TLS_RSA_WITH_RC4_128_SHA, AVI_TLS_RSA_EXPORT_WITH_RC2_CBC_40_MD5, AVI_TLS_RSA_WITH_IDEA_CBC_SHA, AVI_TLS_RSA_EXPORT_WITH_DES40_CBC_SHA, AVI_TLS_RSA_WITH_DES_CBC_SHA, AVI_TLS_RSA_WITH_3DES_EDE_CBC_SHA, AVI_TLS_DH_DSS_EXPORT_WITH_DES40_CBC_SHA, AVI_TLS_DH_DSS_WITH_DES_CBC_SHA, AVI_TLS_DH_DSS_WITH_3DES_EDE_CBC_SHA, AVI_TLS_DH_RSA_EXPORT_WITH_DES40_CBC_SHA, AVI_TLS_DH_RSA_WITH_DES_CBC_SHA, AVI_TLS_DH_RSA_WITH_3DES_EDE_CBC_SHA, AVI_TLS_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA, AVI_TLS_DHE_DSS_WITH_DES_CBC_SHA, AVI_TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA, AVI_TLS_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA, AVI_TLS_DHE_RSA_WITH_DES_CBC_SHA, AVI_TLS_DHE_RSA_WITH_3DES_EDE_CBC_SHA, AVI_TLS_DH_anon_EXPORT_WITH_RC4_40_MD5, AVI_TLS_DH_anon_WITH_RC4_128_MD5, AVI_TLS_DH_anon_EXPORT_WITH_DES40_CBC_SHA, AVI_TLS_DH_anon_WITH_DES_CBC_SHA, AVI_TLS_DH_anon_WITH_3DES_EDE_CBC_SHA, AVI_TLS_KRB5_WITH_DES_CBC_SHA, AVI_TLS_KRB5_WITH_3DES_EDE_CBC_SHA, AVI_TLS_KRB5_WITH_RC4_128_SHA, AVI_TLS_KRB5_WITH_IDEA_CBC_SHA, AVI_TLS_KRB5_WITH_DES_CBC_MD5, AVI_TLS_KRB5_WITH_3DES_EDE_CBC_MD5, AVI_TLS_KRB5_WITH_RC4_128_MD5, AVI_TLS_KRB5_WITH_IDEA_CBC_MD5, AVI_TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA, AVI_TLS_KRB5_EXPORT_WITH_RC2_CBC_40_SHA, AVI_TLS_KRB5_EXPORT_WITH_RC4_40_SHA, AVI_TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5, AVI_TLS_KRB5_EXPORT_WITH_RC2_CBC_40_MD5, AVI_TLS_KRB5_EXPORT_WITH_RC4_40_MD5, AVI_TLS_PSK_WITH_NULL_SHA, AVI_TLS_DHE_PSK_WITH_NULL_SHA, AVI_TLS_RSA_PSK_WITH_NULL_SHA, AVI_TLS_RSA_WITH_AES_128_CBC_SHA, AVI_TLS_DH_DSS_WITH_AES_128_CBC_SHA, AVI_TLS_DH_RSA_WITH_AES_128_CBC_SHA, AVI_TLS_DHE_DSS_WITH_AES_128_CBC_SHA, AVI_TLS_DHE_RSA_WITH_AES_128_CBC_SHA, AVI_TLS_DH_anon_WITH_AES_128_CBC_SHA, AVI_TLS_RSA_WITH_AES_256_CBC_SHA, AVI_TLS_DH_DSS_WITH_AES_256_CBC_SHA, AVI_TLS_DH_RSA_WITH_AES_256_CBC_SHA, AVI_TLS_DHE_DSS_WITH_AES_256_CBC_SHA, AVI_TLS_DHE_RSA_WITH_AES_256_CBC_SHA, AVI_TLS_DH_anon_WITH_AES_256_CBC_SHA, AVI_TLS_RSA_WITH_NULL_SHA256, AVI_TLS_RSA_WITH_AES_128_CBC_SHA256, AVI_TLS_RSA_WITH_AES_256_CBC_SHA256, AVI_TLS_DH_DSS_WITH_AES_128_CBC_SHA256, AVI_TLS_DH_RSA_WITH_AES_128_CBC_SHA256, AVI_TLS_DHE_DSS_WITH_AES_128_CBC_SHA256, AVI_TLS_RSA_WITH_CAMELLIA_128_CBC_SHA, AVI_TLS_DH_DSS_WITH_CAMELLIA_128_CBC_SHA, AVI_TLS_DH_RSA_WITH_CAMELLIA_128_CBC_SHA, AVI_TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA, AVI_TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA, AVI_TLS_DH_anon_WITH_CAMELLIA_128_CBC_SHA, AVI_TLS_RSA_EXPORT1024_WITH_RC4_56_MD5, AVI_TLS_RSA_EXPORT1024_WITH_RC2_CBC_56_MD5, AVI_TLS_RSA_EXPORT1024_WITH_DES_CBC_SHA, AVI_TLS_DHE_DSS_EXPORT1024_WITH_DES_CBC_SHA, AVI_TLS_RSA_EXPORT1024_WITH_RC4_56_SHA, AVI_TLS_DHE_DSS_EXPORT1024_WITH_RC4_56_SHA, AVI_TLS_DHE_DSS_WITH_RC4_128_SHA, AVI_TLS_DHE_RSA_WITH_AES_128_CBC_SHA256, AVI_TLS_DH_DSS_WITH_AES_256_CBC_SHA256, AVI_TLS_DH_RSA_WITH_AES_256_CBC_SHA256, AVI_TLS_DHE_DSS_WITH_AES_256_CBC_SHA256, AVI_TLS_DHE_RSA_WITH_AES_256_CBC_SHA256, AVI_TLS_DH_anon_WITH_AES_128_CBC_SHA256, AVI_TLS_DH_anon_WITH_AES_256_CBC_SHA256, AVI_TLS_GOSTR341094_WITH_28147_CNT_IMIT, AVI_TLS_GOSTR341001_WITH_28147_CNT_IMIT, AVI_TLS_GOSTR341001_WITH_NULL_GOSTR3411, AVI_TLS_GOSTR341094_WITH_NULL_GOSTR3411, AVI_TLS_RSA_WITH_CAMELLIA_256_CBC_SHA, AVI_TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA, AVI_TLS_DH_RSA_WITH_CAMELLIA_256_CBC_SHA, AVI_TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA, AVI_TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA, AVI_TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA, AVI_TLS_PSK_WITH_RC4_128_SHA, AVI_TLS_PSK_WITH_3DES_EDE_CBC_SHA, AVI_TLS_PSK_WITH_AES_128_CBC_SHA, AVI_TLS_PSK_WITH_AES_256_CBC_SHA, AVI_TLS_RSA_WITH_SEED_CBC_SHA, AVI_TLS_DH_DSS_WITH_SEED_CBC_SHA, AVI_TLS_DH_RSA_WITH_SEED_CBC_SHA, AVI_TLS_DHE_DSS_WITH_SEED_CBC_SHA, AVI_TLS_DHE_RSA_WITH_SEED_CBC_SHA, AVI_TLS_DH_anon_WITH_SEED_CBC_SHA, AVI_TLS_RSA_WITH_AES_128_GCM_SHA256, AVI_TLS_RSA_WITH_AES_256_GCM_SHA384, AVI_TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, AVI_TLS_DHE_RSA_WITH_AES_256_GCM_SHA384, AVI_TLS_DH_RSA_WITH_AES_128_GCM_SHA256, AVI_TLS_DH_RSA_WITH_AES_256_GCM_SHA384, AVI_TLS_DHE_DSS_WITH_AES_128_GCM_SHA256, AVI_TLS_DHE_DSS_WITH_AES_256_GCM_SHA384, AVI_TLS_DH_DSS_WITH_AES_128_GCM_SHA256, AVI_TLS_DH_DSS_WITH_AES_256_GCM_SHA384, AVI_TLS_DH_anon_WITH_AES_128_GCM_SHA256, AVI_TLS_DH_anon_WITH_AES_256_GCM_SHA384, AVI_TLS_RSA_WITH_CAMELLIA_128_CBC_SHA256, AVI_TLS_DH_DSS_WITH_CAMELLIA_128_CBC_SHA256, AVI_TLS_DH_RSA_WITH_CAMELLIA_128_CBC_SHA256, AVI_TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA256, AVI_TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA256, AVI_TLS_DH_anon_WITH_CAMELLIA_128_CBC_SHA256, AVI_TLS_EMPTY_RENEGOTIATION_INFO_SCSV, AVI_TLS_ECDH_ECDSA_WITH_NULL_SHA, AVI_TLS_ECDH_ECDSA_WITH_RC4_128_SHA, AVI_TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA, AVI_TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA, AVI_TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA, AVI_TLS_ECDHE_ECDSA_WITH_NULL_SHA, AVI_TLS_ECDHE_ECDSA_WITH_RC4_128_SHA, AVI_TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA, AVI_TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, AVI_TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, AVI_TLS_ECDH_RSA_WITH_NULL_SHA, AVI_TLS_ECDH_RSA_WITH_RC4_128_SHA, AVI_TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA, AVI_TLS_ECDH_RSA_WITH_AES_128_CBC_SHA, AVI_TLS_ECDH_RSA_WITH_AES_256_CBC_SHA, AVI_TLS_ECDHE_RSA_WITH_NULL_SHA, AVI_TLS_ECDHE_RSA_WITH_RC4_128_SHA, AVI_TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA, AVI_TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, AVI_TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, AVI_TLS_ECDH_anon_WITH_NULL_SHA, AVI_TLS_ECDH_anon_WITH_RC4_128_SHA, AVI_TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA, AVI_TLS_ECDH_anon_WITH_AES_128_CBC_SHA, AVI_TLS_ECDH_anon_WITH_AES_256_CBC_SHA, AVI_TLS_SRP_SHA_WITH_3DES_EDE_CBC_SHA, AVI_TLS_SRP_SHA_RSA_WITH_3DES_EDE_CBC_SHA, AVI_TLS_SRP_SHA_DSS_WITH_3DES_EDE_CBC_SHA, AVI_TLS_SRP_SHA_WITH_AES_128_CBC_SHA, AVI_TLS_SRP_SHA_RSA_WITH_AES_128_CBC_SHA, AVI_TLS_SRP_SHA_DSS_WITH_AES_128_CBC_SHA, AVI_TLS_SRP_SHA_WITH_AES_256_CBC_SHA, AVI_TLS_SRP_SHA_RSA_WITH_AES_256_CBC_SHA, AVI_TLS_SRP_SHA_DSS_WITH_AES_256_CBC_SHA, AVI_TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256, AVI_TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384, AVI_TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256, AVI_TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384, AVI_TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256, AVI_TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384, AVI_TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256, AVI_TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384, AVI_TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, AVI_TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, AVI_TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256, AVI_TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384, AVI_TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, AVI_TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, AVI_TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256, AVI_TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384, AVI_TLS_ECDHE_PSK_WITH_RC4_128_SHA, AVI_TLS_ECDHE_PSK_WITH_3DES_EDE_CBC_SHA, AVI_TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA, AVI_TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA, AVI_TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA256, AVI_TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA384, AVI_TLS_ECDHE_PSK_WITH_NULL_SHA, AVI_TLS_ECDHE_PSK_WITH_NULL_SHA256, AVI_TLS_ECDHE_PSK_WITH_NULL_SHA384, AVI_TLS_ECDHE_ECDSA_WITH_CAMELLIA_128_CBC_SHA256, AVI_TLS_ECDHE_ECDSA_WITH_CAMELLIA_256_CBC_SHA384, AVI_TLS_ECDH_ECDSA_WITH_CAMELLIA_128_CBC_SHA256, AVI_TLS_ECDH_ECDSA_WITH_CAMELLIA_256_CBC_SHA384, AVI_TLS_ECDHE_RSA_WITH_CAMELLIA_128_CBC_SHA256, AVI_TLS_ECDHE_RSA_WITH_CAMELLIA_256_CBC_SHA384, AVI_TLS_ECDH_RSA_WITH_CAMELLIA_128_CBC_SHA256, AVI_TLS_ECDH_RSA_WITH_CAMELLIA_256_CBC_SHA384, AVI_TLS_PSK_WITH_CAMELLIA_128_CBC_SHA256, AVI_TLS_PSK_WITH_CAMELLIA_256_CBC_SHA384, AVI_TLS_DHE_PSK_WITH_CAMELLIA_128_CBC_SHA256, AVI_TLS_DHE_PSK_WITH_CAMELLIA_256_CBC_SHA384, AVI_TLS_RSA_PSK_WITH_CAMELLIA_128_CBC_SHA256, AVI_TLS_RSA_PSK_WITH_CAMELLIA_256_CBC_SHA384, AVI_TLS_ECDHE_PSK_WITH_CAMELLIA_128_CBC_SHA256, AVI_TLS_ECDHE_PSK_WITH_CAMELLIA_256_CBC_SHA384, AVI_TLS_RSA_WITH_AES_128_CCM, AVI_TLS_RSA_WITH_AES_256_CCM, AVI_TLS_DHE_RSA_WITH_AES_128_CCM, AVI_TLS_DHE_RSA_WITH_AES_256_CCM, AVI_TLS_RSA_WITH_AES_128_CCM_8, AVI_TLS_RSA_WITH_AES_256_CCM_8, AVI_TLS_DHE_RSA_WITH_AES_128_CCM_8, AVI_TLS_DHE_RSA_WITH_AES_256_CCM_8, AVI_TLS_PSK_WITH_AES_128_CCM, AVI_TLS_PSK_WITH_AES_256_CCM, AVI_TLS_DHE_PSK_WITH_AES_128_CCM, AVI_TLS_DHE_PSK_WITH_AES_256_CCM, AVI_TLS_PSK_WITH_AES_128_CCM_8, AVI_TLS_PSK_WITH_AES_256_CCM_8, AVI_TLS_PSK_DHE_WITH_AES_128_CCM_8, AVI_TLS_PSK_DHE_WITH_AES_256_CCM_8, AVI_TLS_ECDHE_ECDSA_WITH_AES_128_CCM, AVI_TLS_ECDHE_ECDSA_WITH_AES_256_CCM, AVI_TLS_ECDHE_ECDSA_WITH_AES_128_CCM_8, AVI_TLS_ECDHE_ECDSA_WITH_AES_256_CCM_8, AVI_TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256_OLD, AVI_TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256_OLD, AVI_TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256_OLD, AVI_TLS_GOSTR341094_RSA_WITH_28147_CNT_MD5, AVI_TLS_RSA_WITH_28147_CNT_GOST94. Field introduced in 18.1.4.
	IdentifiedCiphers []string `json:"identified_ciphers,omitempty"`

	// List of ciphers from the client's SSL cipher list, that could not be identified. The ciphers are represented by their RFC 2 byte hex value. Field introduced in 18.1.4.
	UnidentifiedCiphers []string `json:"unidentified_ciphers,omitempty"`
}
