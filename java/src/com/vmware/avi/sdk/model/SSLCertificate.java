package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SSLCertificate is a POJO class extends AviRestResource that used for creating
 * SSLCertificate.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SSLCertificate  {
    @JsonProperty("certificate")
    private String certificate = null;

    @JsonProperty("certificate_signing_request")
    private String certificateSigningRequest = null;

    @JsonProperty("chain_verified")
    private Boolean chainVerified = null;

    @JsonProperty("days_until_expire")
    private Integer daysUntilExpire = 365;

    @JsonProperty("expiry_status")
    private String expiryStatus = "SSL_CERTIFICATE_GOOD";

    @JsonProperty("fingerprint")
    private String fingerprint = null;

    @JsonProperty("issuer")
    private SSLCertificateDescription issuer = null;

    @JsonProperty("key_params")
    private SSLKeyParams keyParams = null;

    @JsonProperty("not_after")
    private String notAfter = null;

    @JsonProperty("not_before")
    private String notBefore = null;

    @JsonProperty("public_key")
    private String publicKey = null;

    @JsonProperty("self_signed")
    private Boolean selfSigned = null;

    @JsonProperty("serial_number")
    private String serialNumber = null;

    @JsonProperty("signature")
    private String signature = null;

    @JsonProperty("signature_algorithm")
    private String signatureAlgorithm = null;

    @JsonProperty("subject")
    private SSLCertificateDescription subject = null;

    @JsonProperty("subject_alt_names")
    private List<String> subjectAltNames = null;

    @JsonProperty("text")
    private String text = null;

    @JsonProperty("version")
    private String version = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property certificate of obj type sslcertificate field type str  type string.
   * @return certificate
   */
  public String getCertificate() {
    return certificate;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property certificate of obj type sslcertificate field type str  type string.
   * @param certificate set the certificate.
   */
  public void setCertificate(String  certificate) {
    this.certificate = certificate;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property certificate_signing_request of obj type sslcertificate field type str  type string.
   * @return certificateSigningRequest
   */
  public String getCertificateSigningRequest() {
    return certificateSigningRequest;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property certificate_signing_request of obj type sslcertificate field type str  type string.
   * @param certificateSigningRequest set the certificateSigningRequest.
   */
  public void setCertificateSigningRequest(String  certificateSigningRequest) {
    this.certificateSigningRequest = certificateSigningRequest;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property chain_verified of obj type sslcertificate field type str  type boolean.
   * @return chainVerified
   */
  public Boolean getChainVerified() {
    return chainVerified;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property chain_verified of obj type sslcertificate field type str  type boolean.
   * @param chainVerified set the chainVerified.
   */
  public void setChainVerified(Boolean  chainVerified) {
    this.chainVerified = chainVerified;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property days_until_expire of obj type sslcertificate field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 365.
   * @return daysUntilExpire
   */
  public Integer getDaysUntilExpire() {
    return daysUntilExpire;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property days_until_expire of obj type sslcertificate field type str  type integer.
   * Default value when not specified in API or module is interpreted by Avi Controller as 365.
   * @param daysUntilExpire set the daysUntilExpire.
   */
  public void setDaysUntilExpire(Integer  daysUntilExpire) {
    this.daysUntilExpire = daysUntilExpire;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - SSL_CERTIFICATE_GOOD, SSL_CERTIFICATE_EXPIRY_WARNING, SSL_CERTIFICATE_EXPIRED.
   * Default value when not specified in API or module is interpreted by Avi Controller as SSL_CERTIFICATE_GOOD.
   * @return expiryStatus
   */
  public String getExpiryStatus() {
    return expiryStatus;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - SSL_CERTIFICATE_GOOD, SSL_CERTIFICATE_EXPIRY_WARNING, SSL_CERTIFICATE_EXPIRED.
   * Default value when not specified in API or module is interpreted by Avi Controller as SSL_CERTIFICATE_GOOD.
   * @param expiryStatus set the expiryStatus.
   */
  public void setExpiryStatus(String  expiryStatus) {
    this.expiryStatus = expiryStatus;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property fingerprint of obj type sslcertificate field type str  type string.
   * @return fingerprint
   */
  public String getFingerprint() {
    return fingerprint;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property fingerprint of obj type sslcertificate field type str  type string.
   * @param fingerprint set the fingerprint.
   */
  public void setFingerprint(String  fingerprint) {
    this.fingerprint = fingerprint;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property issuer of obj type sslcertificate field type str  type ref.
   * @return issuer
   */
  public SSLCertificateDescription getIssuer() {
    return issuer;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property issuer of obj type sslcertificate field type str  type ref.
   * @param issuer set the issuer.
   */
  public void setIssuer(SSLCertificateDescription issuer) {
    this.issuer = issuer;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property key_params of obj type sslcertificate field type str  type ref.
   * @return keyParams
   */
  public SSLKeyParams getKeyParams() {
    return keyParams;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property key_params of obj type sslcertificate field type str  type ref.
   * @param keyParams set the keyParams.
   */
  public void setKeyParams(SSLKeyParams keyParams) {
    this.keyParams = keyParams;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property not_after of obj type sslcertificate field type str  type string.
   * @return notAfter
   */
  public String getNotAfter() {
    return notAfter;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property not_after of obj type sslcertificate field type str  type string.
   * @param notAfter set the notAfter.
   */
  public void setNotAfter(String  notAfter) {
    this.notAfter = notAfter;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property not_before of obj type sslcertificate field type str  type string.
   * @return notBefore
   */
  public String getNotBefore() {
    return notBefore;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property not_before of obj type sslcertificate field type str  type string.
   * @param notBefore set the notBefore.
   */
  public void setNotBefore(String  notBefore) {
    this.notBefore = notBefore;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property public_key of obj type sslcertificate field type str  type string.
   * @return publicKey
   */
  public String getPublicKey() {
    return publicKey;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property public_key of obj type sslcertificate field type str  type string.
   * @param publicKey set the publicKey.
   */
  public void setPublicKey(String  publicKey) {
    this.publicKey = publicKey;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property self_signed of obj type sslcertificate field type str  type boolean.
   * @return selfSigned
   */
  public Boolean getSelfSigned() {
    return selfSigned;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property self_signed of obj type sslcertificate field type str  type boolean.
   * @param selfSigned set the selfSigned.
   */
  public void setSelfSigned(Boolean  selfSigned) {
    this.selfSigned = selfSigned;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property serial_number of obj type sslcertificate field type str  type string.
   * @return serialNumber
   */
  public String getSerialNumber() {
    return serialNumber;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property serial_number of obj type sslcertificate field type str  type string.
   * @param serialNumber set the serialNumber.
   */
  public void setSerialNumber(String  serialNumber) {
    this.serialNumber = serialNumber;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property signature of obj type sslcertificate field type str  type string.
   * @return signature
   */
  public String getSignature() {
    return signature;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property signature of obj type sslcertificate field type str  type string.
   * @param signature set the signature.
   */
  public void setSignature(String  signature) {
    this.signature = signature;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property signature_algorithm of obj type sslcertificate field type str  type string.
   * @return signatureAlgorithm
   */
  public String getSignatureAlgorithm() {
    return signatureAlgorithm;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property signature_algorithm of obj type sslcertificate field type str  type string.
   * @param signatureAlgorithm set the signatureAlgorithm.
   */
  public void setSignatureAlgorithm(String  signatureAlgorithm) {
    this.signatureAlgorithm = signatureAlgorithm;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property subject of obj type sslcertificate field type str  type ref.
   * @return subject
   */
  public SSLCertificateDescription getSubject() {
    return subject;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property subject of obj type sslcertificate field type str  type ref.
   * @param subject set the subject.
   */
  public void setSubject(SSLCertificateDescription subject) {
    this.subject = subject;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Subjectaltname that provides additional subject identities.
   * @return subjectAltNames
   */
  public List<String> getSubjectAltNames() {
    return subjectAltNames;
  }

  /**
   * This is the setter method. this will set the subjectAltNames
   * Subjectaltname that provides additional subject identities.
   * @return subjectAltNames
   */
  public void setSubjectAltNames(List<String>  subjectAltNames) {
    this.subjectAltNames = subjectAltNames;
  }

  /**
   * This is the setter method this will set the subjectAltNames
   * Subjectaltname that provides additional subject identities.
   * @return subjectAltNames
   */
  public SSLCertificate addSubjectAltNamesItem(String subjectAltNamesItem) {
    if (this.subjectAltNames == null) {
      this.subjectAltNames = new ArrayList<String>();
    }
    this.subjectAltNames.add(subjectAltNamesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property text of obj type sslcertificate field type str  type string.
   * @return text
   */
  public String getText() {
    return text;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property text of obj type sslcertificate field type str  type string.
   * @param text set the text.
   */
  public void setText(String  text) {
    this.text = text;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property version of obj type sslcertificate field type str  type string.
   * @return version
   */
  public String getVersion() {
    return version;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property version of obj type sslcertificate field type str  type string.
   * @param version set the version.
   */
  public void setVersion(String  version) {
    this.version = version;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SSLCertificate objSSLCertificate = (SSLCertificate) o;
  return   Objects.equals(this.subjectAltNames, objSSLCertificate.subjectAltNames)&&
  Objects.equals(this.publicKey, objSSLCertificate.publicKey)&&
  Objects.equals(this.selfSigned, objSSLCertificate.selfSigned)&&
  Objects.equals(this.certificate, objSSLCertificate.certificate)&&
  Objects.equals(this.certificateSigningRequest, objSSLCertificate.certificateSigningRequest)&&
  Objects.equals(this.notAfter, objSSLCertificate.notAfter)&&
  Objects.equals(this.fingerprint, objSSLCertificate.fingerprint)&&
  Objects.equals(this.signature, objSSLCertificate.signature)&&
  Objects.equals(this.daysUntilExpire, objSSLCertificate.daysUntilExpire)&&
  Objects.equals(this.expiryStatus, objSSLCertificate.expiryStatus)&&
  Objects.equals(this.chainVerified, objSSLCertificate.chainVerified)&&
  Objects.equals(this.version, objSSLCertificate.version)&&
  Objects.equals(this.text, objSSLCertificate.text)&&
  Objects.equals(this.signatureAlgorithm, objSSLCertificate.signatureAlgorithm)&&
  Objects.equals(this.keyParams, objSSLCertificate.keyParams)&&
  Objects.equals(this.serialNumber, objSSLCertificate.serialNumber)&&
  Objects.equals(this.issuer, objSSLCertificate.issuer)&&
  Objects.equals(this.notBefore, objSSLCertificate.notBefore)&&
  Objects.equals(this.subject, objSSLCertificate.subject);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SSLCertificate {\n");
      sb.append("    certificate: ").append(toIndentedString(certificate)).append("\n");
        sb.append("    certificateSigningRequest: ").append(toIndentedString(certificateSigningRequest)).append("\n");
        sb.append("    chainVerified: ").append(toIndentedString(chainVerified)).append("\n");
        sb.append("    daysUntilExpire: ").append(toIndentedString(daysUntilExpire)).append("\n");
        sb.append("    expiryStatus: ").append(toIndentedString(expiryStatus)).append("\n");
        sb.append("    fingerprint: ").append(toIndentedString(fingerprint)).append("\n");
        sb.append("    issuer: ").append(toIndentedString(issuer)).append("\n");
        sb.append("    keyParams: ").append(toIndentedString(keyParams)).append("\n");
        sb.append("    notAfter: ").append(toIndentedString(notAfter)).append("\n");
        sb.append("    notBefore: ").append(toIndentedString(notBefore)).append("\n");
        sb.append("    publicKey: ").append(toIndentedString(publicKey)).append("\n");
        sb.append("    selfSigned: ").append(toIndentedString(selfSigned)).append("\n");
        sb.append("    serialNumber: ").append(toIndentedString(serialNumber)).append("\n");
        sb.append("    signature: ").append(toIndentedString(signature)).append("\n");
        sb.append("    signatureAlgorithm: ").append(toIndentedString(signatureAlgorithm)).append("\n");
        sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
        sb.append("    subjectAltNames: ").append(toIndentedString(subjectAltNames)).append("\n");
        sb.append("    text: ").append(toIndentedString(text)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
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

