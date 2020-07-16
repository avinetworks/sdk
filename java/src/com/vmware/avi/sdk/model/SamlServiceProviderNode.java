package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SamlServiceProviderNode is a POJO class extends AviRestResource that used for creating
 * SamlServiceProviderNode.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SamlServiceProviderNode  {
    @JsonProperty("entity_id")
    private String entityId = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("signing_cert")
    private String signingCert = null;

    @JsonProperty("signing_key")
    private String signingKey = null;

    @JsonProperty("signing_ssl_key_and_certificate_ref")
    private String signingSslKeyAndCertificateRef = null;

    @JsonProperty("single_signon_url")
    private String singleSignonUrl = null;



  /**
   * This is the getter method this will return the attribute value.
   * Globally unique entityid for this node.
   * Entity id on the idp should match this.
   * Field introduced in 17.2.3.
   * @return entityId
   */
  public String getEntityId() {
    return entityId;
  }

  /**
   * This is the setter method to the attribute.
   * Globally unique entityid for this node.
   * Entity id on the idp should match this.
   * Field introduced in 17.2.3.
   * @param entityId set the entityId.
   */
  public void setEntityId(String  entityId) {
    this.entityId = entityId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Refers to the cluster name identifier (virtual ip or fqdn).
   * Field introduced in 17.2.3.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Refers to the cluster name identifier (virtual ip or fqdn).
   * Field introduced in 17.2.3.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Service provider signing certificate for metadata.
   * Field deprecated in 18.2.1.
   * Field introduced in 17.2.3.
   * @return signingCert
   */
  public String getSigningCert() {
    return signingCert;
  }

  /**
   * This is the setter method to the attribute.
   * Service provider signing certificate for metadata.
   * Field deprecated in 18.2.1.
   * Field introduced in 17.2.3.
   * @param signingCert set the signingCert.
   */
  public void setSigningCert(String  signingCert) {
    this.signingCert = signingCert;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Service provider signing key for metadata.
   * Field deprecated in 18.2.1.
   * Field introduced in 17.2.3.
   * @return signingKey
   */
  public String getSigningKey() {
    return signingKey;
  }

  /**
   * This is the setter method to the attribute.
   * Service provider signing key for metadata.
   * Field deprecated in 18.2.1.
   * Field introduced in 17.2.3.
   * @param signingKey set the signingKey.
   */
  public void setSigningKey(String  signingKey) {
    this.signingKey = signingKey;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Service engines will use this ssl certificate to sign assertions going to the idp.
   * It is a reference to an object of type sslkeyandcertificate.
   * Field introduced in 18.2.1.
   * @return signingSslKeyAndCertificateRef
   */
  public String getSigningSslKeyAndCertificateRef() {
    return signingSslKeyAndCertificateRef;
  }

  /**
   * This is the setter method to the attribute.
   * Service engines will use this ssl certificate to sign assertions going to the idp.
   * It is a reference to an object of type sslkeyandcertificate.
   * Field introduced in 18.2.1.
   * @param signingSslKeyAndCertificateRef set the signingSslKeyAndCertificateRef.
   */
  public void setSigningSslKeyAndCertificateRef(String  signingSslKeyAndCertificateRef) {
    this.signingSslKeyAndCertificateRef = signingSslKeyAndCertificateRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Single signon url to be programmed on the idp.
   * Field introduced in 17.2.3.
   * @return singleSignonUrl
   */
  public String getSingleSignonUrl() {
    return singleSignonUrl;
  }

  /**
   * This is the setter method to the attribute.
   * Single signon url to be programmed on the idp.
   * Field introduced in 17.2.3.
   * @param singleSignonUrl set the singleSignonUrl.
   */
  public void setSingleSignonUrl(String  singleSignonUrl) {
    this.singleSignonUrl = singleSignonUrl;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SamlServiceProviderNode objSamlServiceProviderNode = (SamlServiceProviderNode) o;
  return   Objects.equals(this.entityId, objSamlServiceProviderNode.entityId)&&
  Objects.equals(this.name, objSamlServiceProviderNode.name)&&
  Objects.equals(this.signingCert, objSamlServiceProviderNode.signingCert)&&
  Objects.equals(this.signingSslKeyAndCertificateRef, objSamlServiceProviderNode.signingSslKeyAndCertificateRef)&&
  Objects.equals(this.signingKey, objSamlServiceProviderNode.signingKey)&&
  Objects.equals(this.singleSignonUrl, objSamlServiceProviderNode.singleSignonUrl);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SamlServiceProviderNode {\n");
      sb.append("    entityId: ").append(toIndentedString(entityId)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    signingCert: ").append(toIndentedString(signingCert)).append("\n");
        sb.append("    signingKey: ").append(toIndentedString(signingKey)).append("\n");
        sb.append("    signingSslKeyAndCertificateRef: ").append(toIndentedString(signingSslKeyAndCertificateRef)).append("\n");
        sb.append("    singleSignonUrl: ").append(toIndentedString(singleSignonUrl)).append("\n");
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

