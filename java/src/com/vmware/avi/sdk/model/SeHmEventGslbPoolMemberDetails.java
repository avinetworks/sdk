package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SeHmEventGslbPoolMemberDetails is a POJO class extends AviRestResource that used for creating
 * SeHmEventGslbPoolMemberDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeHmEventGslbPoolMemberDetails  {
    @JsonProperty("app_info")
    private List<AppInfo> appInfo = null;

    @JsonProperty("domain")
    private String domain = null;

    @JsonProperty("failure_code")
    private String failureCode = null;

    @JsonProperty("ip")
    private IpAddr ip = null;

    @JsonProperty("shm")
    private List<SeHmEventShmDetails> shm = null;

    @JsonProperty("ssl_error_code")
    private String sslErrorCode = null;


  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property app_info of obj type sehmeventgslbpoolmemberdetails field type str  type array.
   * @return appInfo
   */
  public List<AppInfo> getAppInfo() {
    return appInfo;
  }

  /**
   * This is the setter method. this will set the appInfo
   * Placeholder for description of property app_info of obj type sehmeventgslbpoolmemberdetails field type str  type array.
   * @return appInfo
   */
  public void setAppInfo(List<AppInfo>  appInfo) {
    this.appInfo = appInfo;
  }

  /**
   * This is the setter method this will set the appInfo
   * Placeholder for description of property app_info of obj type sehmeventgslbpoolmemberdetails field type str  type array.
   * @return appInfo
   */
  public SeHmEventGslbPoolMemberDetails addAppInfoItem(AppInfo appInfoItem) {
    if (this.appInfo == null) {
      this.appInfo = new ArrayList<AppInfo>();
    }
    this.appInfo.add(appInfoItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Domain name used to health monitor this member.
   * @return domain
   */
  public String getDomain() {
    return domain;
  }

  /**
   * This is the setter method to the attribute.
   * Domain name used to health monitor this member.
   * @param domain set the domain.
   */
  public void setDomain(String  domain) {
    this.domain = domain;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Gslb health monitor failure code.
   * Enum options - ARP_UNRESOLVED, CONNECTION_REFUSED, CONNECTION_TIMEOUT, RESPONSE_CODE_MISMATCH, PAYLOAD_CONTENT_MISMATCH, SERVER_UNREACHABLE,
   * CONNECTION_RESET, CONNECTION_ERROR, HOST_ERROR, ADDRESS_ERROR, NO_PORT, PAYLOAD_TIMEOUT, NO_RESPONSE, NO_RESOURCES, SSL_ERROR, SSL_CERT_ERROR,
   * PORT_UNREACHABLE, SCRIPT_ERROR, OTHER_ERROR, SERVER_DISABLED...
   * @return failureCode
   */
  public String getFailureCode() {
    return failureCode;
  }

  /**
   * This is the setter method to the attribute.
   * Gslb health monitor failure code.
   * Enum options - ARP_UNRESOLVED, CONNECTION_REFUSED, CONNECTION_TIMEOUT, RESPONSE_CODE_MISMATCH, PAYLOAD_CONTENT_MISMATCH, SERVER_UNREACHABLE,
   * CONNECTION_RESET, CONNECTION_ERROR, HOST_ERROR, ADDRESS_ERROR, NO_PORT, PAYLOAD_TIMEOUT, NO_RESPONSE, NO_RESOURCES, SSL_ERROR, SSL_CERT_ERROR,
   * PORT_UNREACHABLE, SCRIPT_ERROR, OTHER_ERROR, SERVER_DISABLED...
   * @param failureCode set the failureCode.
   */
  public void setFailureCode(String  failureCode) {
    this.failureCode = failureCode;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ip address of gslbservice member.
   * @return ip
   */
  public IpAddr getIp() {
    return ip;
  }

  /**
   * This is the setter method to the attribute.
   * Ip address of gslbservice member.
   * @param ip set the ip.
   */
  public void setIp(IpAddr ip) {
    this.ip = ip;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property shm of obj type sehmeventgslbpoolmemberdetails field type str  type array.
   * @return shm
   */
  public List<SeHmEventShmDetails> getShm() {
    return shm;
  }

  /**
   * This is the setter method. this will set the shm
   * Placeholder for description of property shm of obj type sehmeventgslbpoolmemberdetails field type str  type array.
   * @return shm
   */
  public void setShm(List<SeHmEventShmDetails>  shm) {
    this.shm = shm;
  }

  /**
   * This is the setter method this will set the shm
   * Placeholder for description of property shm of obj type sehmeventgslbpoolmemberdetails field type str  type array.
   * @return shm
   */
  public SeHmEventGslbPoolMemberDetails addShmItem(SeHmEventShmDetails shmItem) {
    if (this.shm == null) {
      this.shm = new ArrayList<SeHmEventShmDetails>();
    }
    this.shm.add(shmItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - ADF_CLIENT_CONN_SETUP_REFUSED, ADF_SERVER_CONN_SETUP_REFUSED, ADF_CLIENT_CONN_SETUP_TIMEDOUT, ADF_SERVER_CONN_SETUP_TIMEDOUT,
   * ADF_CLIENT_CONN_SETUP_FAILED_INTERNAL, ADF_SERVER_CONN_SETUP_FAILED_INTERNAL, ADF_CLIENT_CONN_SETUP_FAILED_BAD_PACKET,
   * ADF_UDP_CONN_SETUP_FAILED_INTERNAL, ADF_UDP_SERVER_CONN_SETUP_FAILED_INTERNAL, ADF_CLIENT_SENT_RESET, ADF_SERVER_SENT_RESET,
   * ADF_CLIENT_CONN_TIMEDOUT, ADF_SERVER_CONN_TIMEDOUT, ADF_USER_DELETE_OPERATION, ADF_CLIENT_REQUEST_TIMEOUT, ADF_CLIENT_CONN_ABORTED,
   * ADF_CLIENT_SSL_HANDSHAKE_FAILURE, ADF_CLIENT_CONN_FAILED, ADF_SERVER_CERTIFICATE_VERIFICATION_FAILED, ADF_SERVER_SIDE_SSL_HANDSHAKE_FAILED...
   * @return sslErrorCode
   */
  public String getSslErrorCode() {
    return sslErrorCode;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - ADF_CLIENT_CONN_SETUP_REFUSED, ADF_SERVER_CONN_SETUP_REFUSED, ADF_CLIENT_CONN_SETUP_TIMEDOUT, ADF_SERVER_CONN_SETUP_TIMEDOUT,
   * ADF_CLIENT_CONN_SETUP_FAILED_INTERNAL, ADF_SERVER_CONN_SETUP_FAILED_INTERNAL, ADF_CLIENT_CONN_SETUP_FAILED_BAD_PACKET,
   * ADF_UDP_CONN_SETUP_FAILED_INTERNAL, ADF_UDP_SERVER_CONN_SETUP_FAILED_INTERNAL, ADF_CLIENT_SENT_RESET, ADF_SERVER_SENT_RESET,
   * ADF_CLIENT_CONN_TIMEDOUT, ADF_SERVER_CONN_TIMEDOUT, ADF_USER_DELETE_OPERATION, ADF_CLIENT_REQUEST_TIMEOUT, ADF_CLIENT_CONN_ABORTED,
   * ADF_CLIENT_SSL_HANDSHAKE_FAILURE, ADF_CLIENT_CONN_FAILED, ADF_SERVER_CERTIFICATE_VERIFICATION_FAILED, ADF_SERVER_SIDE_SSL_HANDSHAKE_FAILED...
   * @param sslErrorCode set the sslErrorCode.
   */
  public void setSslErrorCode(String  sslErrorCode) {
    this.sslErrorCode = sslErrorCode;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SeHmEventGslbPoolMemberDetails objSeHmEventGslbPoolMemberDetails = (SeHmEventGslbPoolMemberDetails) o;
  return   Objects.equals(this.domain, objSeHmEventGslbPoolMemberDetails.domain)&&
  Objects.equals(this.sslErrorCode, objSeHmEventGslbPoolMemberDetails.sslErrorCode)&&
  Objects.equals(this.appInfo, objSeHmEventGslbPoolMemberDetails.appInfo)&&
  Objects.equals(this.ip, objSeHmEventGslbPoolMemberDetails.ip)&&
  Objects.equals(this.shm, objSeHmEventGslbPoolMemberDetails.shm)&&
  Objects.equals(this.failureCode, objSeHmEventGslbPoolMemberDetails.failureCode);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SeHmEventGslbPoolMemberDetails {\n");
      sb.append("    appInfo: ").append(toIndentedString(appInfo)).append("\n");
        sb.append("    domain: ").append(toIndentedString(domain)).append("\n");
        sb.append("    failureCode: ").append(toIndentedString(failureCode)).append("\n");
        sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
        sb.append("    shm: ").append(toIndentedString(shm)).append("\n");
        sb.append("    sslErrorCode: ").append(toIndentedString(sslErrorCode)).append("\n");
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

