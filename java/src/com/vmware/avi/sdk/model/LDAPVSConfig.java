package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The LDAPVSConfig is a POJO class extends AviRestResource that used for creating
 * LDAPVSConfig.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LDAPVSConfig  {
    @JsonProperty("realm")
    private String realm = null;

    @JsonProperty("se_auth_ldap_bind_timeout")
    private Integer seAuthLdapBindTimeout = 5000;

    @JsonProperty("se_auth_ldap_cache_size")
    private Integer seAuthLdapCacheSize = 100000;

    @JsonProperty("se_auth_ldap_connect_timeout")
    private Integer seAuthLdapConnectTimeout = 10000;

    @JsonProperty("se_auth_ldap_conns_per_server")
    private Integer seAuthLdapConnsPerServer = 1;

    @JsonProperty("se_auth_ldap_reconnect_timeout")
    private Integer seAuthLdapReconnectTimeout = 10000;

    @JsonProperty("se_auth_ldap_request_timeout")
    private Integer seAuthLdapRequestTimeout = 10000;

    @JsonProperty("se_auth_ldap_servers_failover_only")
    private Boolean seAuthLdapServersFailoverOnly = false;



    /**
     * This is the getter method this will return the attribute value.
     * Basic authentication realm to present to a user along with the prompt for credentials.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return realm
     */
    public String getRealm() {
        return realm;
    }

    /**
     * This is the setter method to the attribute.
     * Basic authentication realm to present to a user along with the prompt for credentials.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param realm set the realm.
     */
    public void setRealm(String  realm) {
        this.realm = realm;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Default bind timeout enforced on connections to ldap server.
     * Field introduced in 21.1.1.
     * Unit is milliseconds.
     * Default value when not specified in API or module is interpreted by Avi Controller as 5000.
     * @return seAuthLdapBindTimeout
     */
    public Integer getSeAuthLdapBindTimeout() {
        return seAuthLdapBindTimeout;
    }

    /**
     * This is the setter method to the attribute.
     * Default bind timeout enforced on connections to ldap server.
     * Field introduced in 21.1.1.
     * Unit is milliseconds.
     * Default value when not specified in API or module is interpreted by Avi Controller as 5000.
     * @param seAuthLdapBindTimeout set the seAuthLdapBindTimeout.
     */
    public void setSeAuthLdapBindTimeout(Integer  seAuthLdapBindTimeout) {
        this.seAuthLdapBindTimeout = seAuthLdapBindTimeout;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Size of ldap auth credentials cache used on the dataplane.
     * Field introduced in 21.1.1.
     * Unit is bytes.
     * Default value when not specified in API or module is interpreted by Avi Controller as 100000.
     * @return seAuthLdapCacheSize
     */
    public Integer getSeAuthLdapCacheSize() {
        return seAuthLdapCacheSize;
    }

    /**
     * This is the setter method to the attribute.
     * Size of ldap auth credentials cache used on the dataplane.
     * Field introduced in 21.1.1.
     * Unit is bytes.
     * Default value when not specified in API or module is interpreted by Avi Controller as 100000.
     * @param seAuthLdapCacheSize set the seAuthLdapCacheSize.
     */
    public void setSeAuthLdapCacheSize(Integer  seAuthLdapCacheSize) {
        this.seAuthLdapCacheSize = seAuthLdapCacheSize;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Default connection timeout enforced on connections to ldap server.
     * Field introduced in 21.1.1.
     * Unit is milliseconds.
     * Default value when not specified in API or module is interpreted by Avi Controller as 10000.
     * @return seAuthLdapConnectTimeout
     */
    public Integer getSeAuthLdapConnectTimeout() {
        return seAuthLdapConnectTimeout;
    }

    /**
     * This is the setter method to the attribute.
     * Default connection timeout enforced on connections to ldap server.
     * Field introduced in 21.1.1.
     * Unit is milliseconds.
     * Default value when not specified in API or module is interpreted by Avi Controller as 10000.
     * @param seAuthLdapConnectTimeout set the seAuthLdapConnectTimeout.
     */
    public void setSeAuthLdapConnectTimeout(Integer  seAuthLdapConnectTimeout) {
        this.seAuthLdapConnectTimeout = seAuthLdapConnectTimeout;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Number of concurrent connections to ldap server by a single basic auth ldap process.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as 1.
     * @return seAuthLdapConnsPerServer
     */
    public Integer getSeAuthLdapConnsPerServer() {
        return seAuthLdapConnsPerServer;
    }

    /**
     * This is the setter method to the attribute.
     * Number of concurrent connections to ldap server by a single basic auth ldap process.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as 1.
     * @param seAuthLdapConnsPerServer set the seAuthLdapConnsPerServer.
     */
    public void setSeAuthLdapConnsPerServer(Integer  seAuthLdapConnsPerServer) {
        this.seAuthLdapConnsPerServer = seAuthLdapConnsPerServer;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Default reconnect timeout enforced on connections to ldap server.
     * Field introduced in 21.1.1.
     * Unit is milliseconds.
     * Default value when not specified in API or module is interpreted by Avi Controller as 10000.
     * @return seAuthLdapReconnectTimeout
     */
    public Integer getSeAuthLdapReconnectTimeout() {
        return seAuthLdapReconnectTimeout;
    }

    /**
     * This is the setter method to the attribute.
     * Default reconnect timeout enforced on connections to ldap server.
     * Field introduced in 21.1.1.
     * Unit is milliseconds.
     * Default value when not specified in API or module is interpreted by Avi Controller as 10000.
     * @param seAuthLdapReconnectTimeout set the seAuthLdapReconnectTimeout.
     */
    public void setSeAuthLdapReconnectTimeout(Integer  seAuthLdapReconnectTimeout) {
        this.seAuthLdapReconnectTimeout = seAuthLdapReconnectTimeout;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Default login or group search request timeout enforced on connections to ldap server.
     * Field introduced in 21.1.1.
     * Unit is milliseconds.
     * Default value when not specified in API or module is interpreted by Avi Controller as 10000.
     * @return seAuthLdapRequestTimeout
     */
    public Integer getSeAuthLdapRequestTimeout() {
        return seAuthLdapRequestTimeout;
    }

    /**
     * This is the setter method to the attribute.
     * Default login or group search request timeout enforced on connections to ldap server.
     * Field introduced in 21.1.1.
     * Unit is milliseconds.
     * Default value when not specified in API or module is interpreted by Avi Controller as 10000.
     * @param seAuthLdapRequestTimeout set the seAuthLdapRequestTimeout.
     */
    public void setSeAuthLdapRequestTimeout(Integer  seAuthLdapRequestTimeout) {
        this.seAuthLdapRequestTimeout = seAuthLdapRequestTimeout;
    }

    /**
     * This is the getter method this will return the attribute value.
     * If enabled, connections are always made to the first available ldap server in the list and will failover to subsequent servers.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @return seAuthLdapServersFailoverOnly
     */
    public Boolean getSeAuthLdapServersFailoverOnly() {
        return seAuthLdapServersFailoverOnly;
    }

    /**
     * This is the setter method to the attribute.
     * If enabled, connections are always made to the first available ldap server in the list and will failover to subsequent servers.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @param seAuthLdapServersFailoverOnly set the seAuthLdapServersFailoverOnly.
     */
    public void setSeAuthLdapServersFailoverOnly(Boolean  seAuthLdapServersFailoverOnly) {
        this.seAuthLdapServersFailoverOnly = seAuthLdapServersFailoverOnly;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      LDAPVSConfig objLDAPVSConfig = (LDAPVSConfig) o;
      return   Objects.equals(this.realm, objLDAPVSConfig.realm)&&
  Objects.equals(this.seAuthLdapCacheSize, objLDAPVSConfig.seAuthLdapCacheSize)&&
  Objects.equals(this.seAuthLdapConnsPerServer, objLDAPVSConfig.seAuthLdapConnsPerServer)&&
  Objects.equals(this.seAuthLdapConnectTimeout, objLDAPVSConfig.seAuthLdapConnectTimeout)&&
  Objects.equals(this.seAuthLdapReconnectTimeout, objLDAPVSConfig.seAuthLdapReconnectTimeout)&&
  Objects.equals(this.seAuthLdapBindTimeout, objLDAPVSConfig.seAuthLdapBindTimeout)&&
  Objects.equals(this.seAuthLdapRequestTimeout, objLDAPVSConfig.seAuthLdapRequestTimeout)&&
  Objects.equals(this.seAuthLdapServersFailoverOnly, objLDAPVSConfig.seAuthLdapServersFailoverOnly);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class LDAPVSConfig {\n");
                  sb.append("    realm: ").append(toIndentedString(realm)).append("\n");
                        sb.append("    seAuthLdapBindTimeout: ").append(toIndentedString(seAuthLdapBindTimeout)).append("\n");
                        sb.append("    seAuthLdapCacheSize: ").append(toIndentedString(seAuthLdapCacheSize)).append("\n");
                        sb.append("    seAuthLdapConnectTimeout: ").append(toIndentedString(seAuthLdapConnectTimeout)).append("\n");
                        sb.append("    seAuthLdapConnsPerServer: ").append(toIndentedString(seAuthLdapConnsPerServer)).append("\n");
                        sb.append("    seAuthLdapReconnectTimeout: ").append(toIndentedString(seAuthLdapReconnectTimeout)).append("\n");
                        sb.append("    seAuthLdapRequestTimeout: ").append(toIndentedString(seAuthLdapRequestTimeout)).append("\n");
                        sb.append("    seAuthLdapServersFailoverOnly: ").append(toIndentedString(seAuthLdapServersFailoverOnly)).append("\n");
                  sb.append("}");
      return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
      if (o == null) {
          return "null";
      }
      return o.toString().replace("\n", "\n    ");
    }
}
