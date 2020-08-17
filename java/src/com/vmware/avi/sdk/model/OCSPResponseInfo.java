package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The OCSPResponseInfo is a POJO class extends AviRestResource that used for creating
 * OCSPResponseInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OCSPResponseInfo  {
    @JsonProperty("cert_status")
    private String certStatus = null;

    @JsonProperty("next_update")
    private String nextUpdate = null;

    @JsonProperty("ocsp_resp_from_responder_url")
    private String ocspRespFromResponderUrl = null;

    @JsonProperty("ocsp_response")
    private String ocspResponse = null;

    @JsonProperty("revocation_reason")
    private String revocationReason = null;

    @JsonProperty("revocation_time")
    private String revocationTime = null;

    @JsonProperty("this_update")
    private String thisUpdate = null;



  /**
   * This is the getter method this will return the attribute value.
   * Revocation status of the certificate.
   * Enum options - OCSP_CERTSTATUS_GOOD, OCSP_CERTSTATUS_REVOKED, OCSP_CERTSTATUS_UNKNOWN.
   * Field introduced in 20.1.1.
   * @return certStatus
   */
  public String getCertStatus() {
    return certStatus;
  }

  /**
   * This is the setter method to the attribute.
   * Revocation status of the certificate.
   * Enum options - OCSP_CERTSTATUS_GOOD, OCSP_CERTSTATUS_REVOKED, OCSP_CERTSTATUS_UNKNOWN.
   * Field introduced in 20.1.1.
   * @param certStatus set the certStatus.
   */
  public void setCertStatus(String  certStatus) {
    this.certStatus = certStatus;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The time at or before which newer information will be available about the status of the certificate.
   * Field introduced in 20.1.1.
   * @return nextUpdate
   */
  public String getNextUpdate() {
    return nextUpdate;
  }

  /**
   * This is the setter method to the attribute.
   * The time at or before which newer information will be available about the status of the certificate.
   * Field introduced in 20.1.1.
   * @param nextUpdate set the nextUpdate.
   */
  public void setNextUpdate(String  nextUpdate) {
    this.nextUpdate = nextUpdate;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The ocsp responder url from which the response is received.
   * Field introduced in 20.1.1.
   * @return ocspRespFromResponderUrl
   */
  public String getOcspRespFromResponderUrl() {
    return ocspRespFromResponderUrl;
  }

  /**
   * This is the setter method to the attribute.
   * The ocsp responder url from which the response is received.
   * Field introduced in 20.1.1.
   * @param ocspRespFromResponderUrl set the ocspRespFromResponderUrl.
   */
  public void setOcspRespFromResponderUrl(String  ocspRespFromResponderUrl) {
    this.ocspRespFromResponderUrl = ocspRespFromResponderUrl;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Signed ocsp response received from the ca's ocsp responder.
   * Field introduced in 20.1.1.
   * @return ocspResponse
   */
  public String getOcspResponse() {
    return ocspResponse;
  }

  /**
   * This is the setter method to the attribute.
   * Signed ocsp response received from the ca's ocsp responder.
   * Field introduced in 20.1.1.
   * @param ocspResponse set the ocspResponse.
   */
  public void setOcspResponse(String  ocspResponse) {
    this.ocspResponse = ocspResponse;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The reason for the revocation of the certificate.
   * Enum options - OCSP_REVOCATION_REASON_UNSPECIFIED, OCSP_REVOCATION_REASON_KEY_COMPROMISE, OCSP_REVOCATION_REASON_CA_COMPROMISE,
   * OCSP_REVOCATION_REASON_AFFILIATION_CHANGED, OCSP_REVOCATION_REASON_SUPERSEDED, OCSP_REVOCATION_REASON_CESSATION_OF_OPERATION,
   * OCSP_REVOCATION_REASON_CERTIFICATE_HOLD, OCSP_REVOCATION_REASON_REMOVE_FROM_CRL, OCSP_REVOCATION_REASON_PRIVILEGE_WITHDRAWN,
   * OCSP_REVOCATION_REASON_AA_COMPROMISE.
   * Field introduced in 20.1.1.
   * @return revocationReason
   */
  public String getRevocationReason() {
    return revocationReason;
  }

  /**
   * This is the setter method to the attribute.
   * The reason for the revocation of the certificate.
   * Enum options - OCSP_REVOCATION_REASON_UNSPECIFIED, OCSP_REVOCATION_REASON_KEY_COMPROMISE, OCSP_REVOCATION_REASON_CA_COMPROMISE,
   * OCSP_REVOCATION_REASON_AFFILIATION_CHANGED, OCSP_REVOCATION_REASON_SUPERSEDED, OCSP_REVOCATION_REASON_CESSATION_OF_OPERATION,
   * OCSP_REVOCATION_REASON_CERTIFICATE_HOLD, OCSP_REVOCATION_REASON_REMOVE_FROM_CRL, OCSP_REVOCATION_REASON_PRIVILEGE_WITHDRAWN,
   * OCSP_REVOCATION_REASON_AA_COMPROMISE.
   * Field introduced in 20.1.1.
   * @param revocationReason set the revocationReason.
   */
  public void setRevocationReason(String  revocationReason) {
    this.revocationReason = revocationReason;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Iso 8601 compatible timestamp at which the certificate was revoked or placed on hold.
   * Field introduced in 20.1.1.
   * @return revocationTime
   */
  public String getRevocationTime() {
    return revocationTime;
  }

  /**
   * This is the setter method to the attribute.
   * Iso 8601 compatible timestamp at which the certificate was revoked or placed on hold.
   * Field introduced in 20.1.1.
   * @param revocationTime set the revocationTime.
   */
  public void setRevocationTime(String  revocationTime) {
    this.revocationTime = revocationTime;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The most recent time at which the status being indicated is known by the ocsp responder to have been correct.
   * Field introduced in 20.1.1.
   * @return thisUpdate
   */
  public String getThisUpdate() {
    return thisUpdate;
  }

  /**
   * This is the setter method to the attribute.
   * The most recent time at which the status being indicated is known by the ocsp responder to have been correct.
   * Field introduced in 20.1.1.
   * @param thisUpdate set the thisUpdate.
   */
  public void setThisUpdate(String  thisUpdate) {
    this.thisUpdate = thisUpdate;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  OCSPResponseInfo objOCSPResponseInfo = (OCSPResponseInfo) o;
  return   Objects.equals(this.ocspResponse, objOCSPResponseInfo.ocspResponse)&&
  Objects.equals(this.certStatus, objOCSPResponseInfo.certStatus)&&
  Objects.equals(this.thisUpdate, objOCSPResponseInfo.thisUpdate)&&
  Objects.equals(this.nextUpdate, objOCSPResponseInfo.nextUpdate)&&
  Objects.equals(this.revocationTime, objOCSPResponseInfo.revocationTime)&&
  Objects.equals(this.revocationReason, objOCSPResponseInfo.revocationReason)&&
  Objects.equals(this.ocspRespFromResponderUrl, objOCSPResponseInfo.ocspRespFromResponderUrl);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class OCSPResponseInfo {\n");
      sb.append("    certStatus: ").append(toIndentedString(certStatus)).append("\n");
        sb.append("    nextUpdate: ").append(toIndentedString(nextUpdate)).append("\n");
        sb.append("    ocspRespFromResponderUrl: ").append(toIndentedString(ocspRespFromResponderUrl)).append("\n");
        sb.append("    ocspResponse: ").append(toIndentedString(ocspResponse)).append("\n");
        sb.append("    revocationReason: ").append(toIndentedString(revocationReason)).append("\n");
        sb.append("    revocationTime: ").append(toIndentedString(revocationTime)).append("\n");
        sb.append("    thisUpdate: ").append(toIndentedString(thisUpdate)).append("\n");
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

