package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SSLProfile is a POJO class extends AviRestResource that used for creating
 * SSLProfile.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SSLProfile extends AviRestResource  {
    @JsonProperty("accepted_ciphers")
    private String acceptedCiphers = "AES:3DES:RC4";

    @JsonProperty("accepted_versions")
    private List<SSLVersion> acceptedVersions = null;

    @JsonProperty("cipher_enums")
    private List<String> cipherEnums = null;

    @JsonProperty("ciphersuites")
    private String ciphersuites = "TLS_AES_256_GCM_SHA384:TLS_CHACHA20_POLY1305_SHA256:TLS_AES_128_GCM_SHA256";

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("dhparam")
    private String dhparam = null;

    @JsonProperty("enable_early_data")
    private Boolean enableEarlyData = false;

    @JsonProperty("enable_ssl_session_reuse")
    private Boolean enableSslSessionReuse = true;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("prefer_client_cipher_ordering")
    private Boolean preferClientCipherOrdering = false;

    @JsonProperty("send_close_notify")
    private Boolean sendCloseNotify = true;

    @JsonProperty("ssl_rating")
    private SSLRating sslRating = null;

    @JsonProperty("ssl_session_timeout")
    private Integer sslSessionTimeout = 86400;

    @JsonProperty("tags")
    private List<Tag> tags = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("type")
    private String type = "SSL_PROFILE_TYPE_APPLICATION";

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Ciphers suites represented as defined by U(http://www.openssl.org/docs/apps/ciphers.html).
   * Default value when not specified in API or module is interpreted by Avi Controller as AES:3DES:RC4.
   * @return acceptedCiphers
   */
  public String getAcceptedCiphers() {
    return acceptedCiphers;
  }

  /**
   * This is the setter method to the attribute.
   * Ciphers suites represented as defined by U(http://www.openssl.org/docs/apps/ciphers.html).
   * Default value when not specified in API or module is interpreted by Avi Controller as AES:3DES:RC4.
   * @param acceptedCiphers set the acceptedCiphers.
   */
  public void setAcceptedCiphers(String  acceptedCiphers) {
    this.acceptedCiphers = acceptedCiphers;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Set of versions accepted by the server.
   * @return acceptedVersions
   */
  public List<SSLVersion> getAcceptedVersions() {
    return acceptedVersions;
  }

  /**
   * This is the setter method. this will set the acceptedVersions
   * Set of versions accepted by the server.
   * @return acceptedVersions
   */
  public void setAcceptedVersions(List<SSLVersion>  acceptedVersions) {
    this.acceptedVersions = acceptedVersions;
  }

  /**
   * This is the setter method this will set the acceptedVersions
   * Set of versions accepted by the server.
   * @return acceptedVersions
   */
  public SSLProfile addAcceptedVersionsItem(SSLVersion acceptedVersionsItem) {
    if (this.acceptedVersions == null) {
      this.acceptedVersions = new ArrayList<SSLVersion>();
    }
    this.acceptedVersions.add(acceptedVersionsItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Enum options - TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,
   * TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256, TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384,
   * TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256, TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384, TLS_RSA_WITH_AES_128_GCM_SHA256, TLS_RSA_WITH_AES_256_GCM_SHA384,
   * TLS_RSA_WITH_AES_128_CBC_SHA256, TLS_RSA_WITH_AES_256_CBC_SHA256, TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA,
   * TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, TLS_RSA_WITH_AES_128_CBC_SHA, TLS_RSA_WITH_AES_256_CBC_SHA,
   * TLS_RSA_WITH_3DES_EDE_CBC_SHA, TLS_AES_256_GCM_SHA384...
   * @return cipherEnums
   */
  public List<String> getCipherEnums() {
    return cipherEnums;
  }

  /**
   * This is the setter method. this will set the cipherEnums
   * Enum options - TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,
   * TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256, TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384,
   * TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256, TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384, TLS_RSA_WITH_AES_128_GCM_SHA256, TLS_RSA_WITH_AES_256_GCM_SHA384,
   * TLS_RSA_WITH_AES_128_CBC_SHA256, TLS_RSA_WITH_AES_256_CBC_SHA256, TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA,
   * TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, TLS_RSA_WITH_AES_128_CBC_SHA, TLS_RSA_WITH_AES_256_CBC_SHA,
   * TLS_RSA_WITH_3DES_EDE_CBC_SHA, TLS_AES_256_GCM_SHA384...
   * @return cipherEnums
   */
  public void setCipherEnums(List<String>  cipherEnums) {
    this.cipherEnums = cipherEnums;
  }

  /**
   * This is the setter method this will set the cipherEnums
   * Enum options - TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,
   * TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256, TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384,
   * TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256, TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384, TLS_RSA_WITH_AES_128_GCM_SHA256, TLS_RSA_WITH_AES_256_GCM_SHA384,
   * TLS_RSA_WITH_AES_128_CBC_SHA256, TLS_RSA_WITH_AES_256_CBC_SHA256, TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA,
   * TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, TLS_RSA_WITH_AES_128_CBC_SHA, TLS_RSA_WITH_AES_256_CBC_SHA,
   * TLS_RSA_WITH_3DES_EDE_CBC_SHA, TLS_AES_256_GCM_SHA384...
   * @return cipherEnums
   */
  public SSLProfile addCipherEnumsItem(String cipherEnumsItem) {
    if (this.cipherEnums == null) {
      this.cipherEnums = new ArrayList<String>();
    }
    this.cipherEnums.add(cipherEnumsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Tls 1.3 ciphers suites represented as defined by u(https //www.openssl.org/docs/manmaster/man1/ciphers.html).
   * Field introduced in 18.2.6.
   * Default value when not specified in API or module is interpreted by Avi Controller as
   * TLS_AES_256_GCM_SHA384:TLS_CHACHA20_POLY1305_SHA256:TLS_AES_128_GCM_SHA256.
   * @return ciphersuites
   */
  public String getCiphersuites() {
    return ciphersuites;
  }

  /**
   * This is the setter method to the attribute.
   * Tls 1.3 ciphers suites represented as defined by u(https //www.openssl.org/docs/manmaster/man1/ciphers.html).
   * Field introduced in 18.2.6.
   * Default value when not specified in API or module is interpreted by Avi Controller as
   * TLS_AES_256_GCM_SHA384:TLS_CHACHA20_POLY1305_SHA256:TLS_AES_128_GCM_SHA256.
   * @param ciphersuites set the ciphersuites.
   */
  public void setCiphersuites(String  ciphersuites) {
    this.ciphersuites = ciphersuites;
  }

  /**
   * This is the getter method this will return the attribute value.
   * User defined description for the object.
   * @return description
   */
  public String getDescription() {
    return description;
  }

  /**
   * This is the setter method to the attribute.
   * User defined description for the object.
   * @param description set the description.
   */
  public void setDescription(String  description) {
    this.description = description;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dh parameters used in ssl.
   * At this time, it is not configurable and is set to 2048 bits.
   * @return dhparam
   */
  public String getDhparam() {
    return dhparam;
  }

  /**
   * This is the setter method to the attribute.
   * Dh parameters used in ssl.
   * At this time, it is not configurable and is set to 2048 bits.
   * @param dhparam set the dhparam.
   */
  public void setDhparam(String  dhparam) {
    this.dhparam = dhparam;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable early data processing for tls1.3 connections.
   * Field introduced in 18.2.6.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return enableEarlyData
   */
  public Boolean getEnableEarlyData() {
    return enableEarlyData;
  }

  /**
   * This is the setter method to the attribute.
   * Enable early data processing for tls1.3 connections.
   * Field introduced in 18.2.6.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param enableEarlyData set the enableEarlyData.
   */
  public void setEnableEarlyData(Boolean  enableEarlyData) {
    this.enableEarlyData = enableEarlyData;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable ssl session re-use.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return enableSslSessionReuse
   */
  public Boolean getEnableSslSessionReuse() {
    return enableSslSessionReuse;
  }

  /**
   * This is the setter method to the attribute.
   * Enable ssl session re-use.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param enableSslSessionReuse set the enableSslSessionReuse.
   */
  public void setEnableSslSessionReuse(Boolean  enableSslSessionReuse) {
    this.enableSslSessionReuse = enableSslSessionReuse;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the object.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the object.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Prefer the ssl cipher ordering presented by the client during the ssl handshake over the one specified in the ssl profile.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return preferClientCipherOrdering
   */
  public Boolean getPreferClientCipherOrdering() {
    return preferClientCipherOrdering;
  }

  /**
   * This is the setter method to the attribute.
   * Prefer the ssl cipher ordering presented by the client during the ssl handshake over the one specified in the ssl profile.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param preferClientCipherOrdering set the preferClientCipherOrdering.
   */
  public void setPreferClientCipherOrdering(Boolean  preferClientCipherOrdering) {
    this.preferClientCipherOrdering = preferClientCipherOrdering;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Send 'close notify' alert message for a clean shutdown of the ssl connection.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return sendCloseNotify
   */
  public Boolean getSendCloseNotify() {
    return sendCloseNotify;
  }

  /**
   * This is the setter method to the attribute.
   * Send 'close notify' alert message for a clean shutdown of the ssl connection.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param sendCloseNotify set the sendCloseNotify.
   */
  public void setSendCloseNotify(Boolean  sendCloseNotify) {
    this.sendCloseNotify = sendCloseNotify;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ssl_rating of obj type sslprofile field type str  type ref.
   * @return sslRating
   */
  public SSLRating getSslRating() {
    return sslRating;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ssl_rating of obj type sslprofile field type str  type ref.
   * @param sslRating set the sslRating.
   */
  public void setSslRating(SSLRating sslRating) {
    this.sslRating = sslRating;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The amount of time in seconds before an ssl session expires.
   * Default value when not specified in API or module is interpreted by Avi Controller as 86400.
   * @return sslSessionTimeout
   */
  public Integer getSslSessionTimeout() {
    return sslSessionTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * The amount of time in seconds before an ssl session expires.
   * Default value when not specified in API or module is interpreted by Avi Controller as 86400.
   * @param sslSessionTimeout set the sslSessionTimeout.
   */
  public void setSslSessionTimeout(Integer  sslSessionTimeout) {
    this.sslSessionTimeout = sslSessionTimeout;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property tags of obj type sslprofile field type str  type array.
   * @return tags
   */
  public List<Tag> getTags() {
    return tags;
  }

  /**
   * This is the setter method. this will set the tags
   * Placeholder for description of property tags of obj type sslprofile field type str  type array.
   * @return tags
   */
  public void setTags(List<Tag>  tags) {
    this.tags = tags;
  }

  /**
   * This is the setter method this will set the tags
   * Placeholder for description of property tags of obj type sslprofile field type str  type array.
   * @return tags
   */
  public SSLProfile addTagsItem(Tag tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<Tag>();
    }
    this.tags.add(tagsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type tenant.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type tenant.
   * @param tenantRef set the tenantRef.
   */
  public void setTenantRef(String  tenantRef) {
    this.tenantRef = tenantRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ssl profile type.
   * Enum options - SSL_PROFILE_TYPE_APPLICATION, SSL_PROFILE_TYPE_SYSTEM.
   * Field introduced in 17.2.8.
   * Default value when not specified in API or module is interpreted by Avi Controller as SSL_PROFILE_TYPE_APPLICATION.
   * @return type
   */
  public String getType() {
    return type;
  }

  /**
   * This is the setter method to the attribute.
   * Ssl profile type.
   * Enum options - SSL_PROFILE_TYPE_APPLICATION, SSL_PROFILE_TYPE_SYSTEM.
   * Field introduced in 17.2.8.
   * Default value when not specified in API or module is interpreted by Avi Controller as SSL_PROFILE_TYPE_APPLICATION.
   * @param type set the type.
   */
  public void setType(String  type) {
    this.type = type;
  }
/**
   * This is the getter method this will return the attribute value.
   * Avi controller URL of the object.
   * @return url
   */
  public String getUrl() {
    return url;
  }

  /**
   * This is the setter method. this will set the url
   * Avi controller URL of the object.
   * @return url
   */
  public void setUrl(String  url) {
    this.url = url;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of the object.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of the object.
   * @param uuid set the uuid.
   */
  public void setUuid(String  uuid) {
    this.uuid = uuid;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SSLProfile objSSLProfile = (SSLProfile) o;
  return   Objects.equals(this.uuid, objSSLProfile.uuid)&&
  Objects.equals(this.name, objSSLProfile.name)&&
  Objects.equals(this.acceptedVersions, objSSLProfile.acceptedVersions)&&
  Objects.equals(this.acceptedCiphers, objSSLProfile.acceptedCiphers)&&
  Objects.equals(this.cipherEnums, objSSLProfile.cipherEnums)&&
  Objects.equals(this.tags, objSSLProfile.tags)&&
  Objects.equals(this.sslRating, objSSLProfile.sslRating)&&
  Objects.equals(this.sendCloseNotify, objSSLProfile.sendCloseNotify)&&
  Objects.equals(this.dhparam, objSSLProfile.dhparam)&&
  Objects.equals(this.preferClientCipherOrdering, objSSLProfile.preferClientCipherOrdering)&&
  Objects.equals(this.enableSslSessionReuse, objSSLProfile.enableSslSessionReuse)&&
  Objects.equals(this.sslSessionTimeout, objSSLProfile.sslSessionTimeout)&&
  Objects.equals(this.type, objSSLProfile.type)&&
  Objects.equals(this.ciphersuites, objSSLProfile.ciphersuites)&&
  Objects.equals(this.enableEarlyData, objSSLProfile.enableEarlyData)&&
  Objects.equals(this.description, objSSLProfile.description)&&
  Objects.equals(this.tenantRef, objSSLProfile.tenantRef);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SSLProfile {\n");
      sb.append("    acceptedCiphers: ").append(toIndentedString(acceptedCiphers)).append("\n");
        sb.append("    acceptedVersions: ").append(toIndentedString(acceptedVersions)).append("\n");
        sb.append("    cipherEnums: ").append(toIndentedString(cipherEnums)).append("\n");
        sb.append("    ciphersuites: ").append(toIndentedString(ciphersuites)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    dhparam: ").append(toIndentedString(dhparam)).append("\n");
        sb.append("    enableEarlyData: ").append(toIndentedString(enableEarlyData)).append("\n");
        sb.append("    enableSslSessionReuse: ").append(toIndentedString(enableSslSessionReuse)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    preferClientCipherOrdering: ").append(toIndentedString(preferClientCipherOrdering)).append("\n");
        sb.append("    sendCloseNotify: ").append(toIndentedString(sendCloseNotify)).append("\n");
        sb.append("    sslRating: ").append(toIndentedString(sslRating)).append("\n");
        sb.append("    sslSessionTimeout: ").append(toIndentedString(sslSessionTimeout)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
            sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
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

