package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The AlertSyslogServer is a POJO class extends AviRestResource that used for creating
 * AlertSyslogServer.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlertSyslogServer  {
    @JsonProperty("anon_auth")
    private Boolean anonAuth = false;

    @JsonProperty("format")
    private String format = "SYSLOG_LEGACY";

    @JsonProperty("pkiprofile_ref")
    private String pkiprofileRef = null;

    @JsonProperty("ssl_key_and_certificate_ref")
    private String sslKeyAndCertificateRef = null;

    @JsonProperty("syslog_server")
    private String syslogServer = null;

    @JsonProperty("syslog_server_port")
    private Integer syslogServerPort = 514;

    @JsonProperty("tls_enable")
    private Boolean tlsEnable = false;

    @JsonProperty("udp")
    private Boolean udp = true;



  /**
   * This is the getter method this will return the attribute value.
   * Enable anonymous authentication of syslog serverwhich will disable server certificate authentication.
   * Field introduced in 17.2.17, 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return anonAuth
   */
  public Boolean getAnonAuth() {
    return anonAuth;
  }

  /**
   * This is the setter method to the attribute.
   * Enable anonymous authentication of syslog serverwhich will disable server certificate authentication.
   * Field introduced in 17.2.17, 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param anonAuth set the anonAuth.
   */
  public void setAnonAuth(Boolean  anonAuth) {
    this.anonAuth = anonAuth;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Syslog output format - legacy, rfc 5424, json.
   * Enum options - SYSLOG_LEGACY, SYSLOG_RFC5424, SYSLOG_JSON.
   * Field introduced in 17.2.8.
   * Default value when not specified in API or module is interpreted by Avi Controller as SYSLOG_LEGACY.
   * @return format
   */
  public String getFormat() {
    return format;
  }

  /**
   * This is the setter method to the attribute.
   * Syslog output format - legacy, rfc 5424, json.
   * Enum options - SYSLOG_LEGACY, SYSLOG_RFC5424, SYSLOG_JSON.
   * Field introduced in 17.2.8.
   * Default value when not specified in API or module is interpreted by Avi Controller as SYSLOG_LEGACY.
   * @param format set the format.
   */
  public void setFormat(String  format) {
    this.format = format;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Select the pkiprofile containing a ca or list of ca chainswhich will validate the certificate of the syslog server.
   * It is a reference to an object of type pkiprofile.
   * Field introduced in 17.2.17, 18.2.5.
   * @return pkiprofileRef
   */
  public String getPkiprofileRef() {
    return pkiprofileRef;
  }

  /**
   * This is the setter method to the attribute.
   * Select the pkiprofile containing a ca or list of ca chainswhich will validate the certificate of the syslog server.
   * It is a reference to an object of type pkiprofile.
   * Field introduced in 17.2.17, 18.2.5.
   * @param pkiprofileRef set the pkiprofileRef.
   */
  public void setPkiprofileRef(String  pkiprofileRef) {
    this.pkiprofileRef = pkiprofileRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Select a certificate and key which will be used to authenticate to the syslog server.
   * It is a reference to an object of type sslkeyandcertificate.
   * Field introduced in 17.2.17, 18.2.5.
   * @return sslKeyAndCertificateRef
   */
  public String getSslKeyAndCertificateRef() {
    return sslKeyAndCertificateRef;
  }

  /**
   * This is the setter method to the attribute.
   * Select a certificate and key which will be used to authenticate to the syslog server.
   * It is a reference to an object of type sslkeyandcertificate.
   * Field introduced in 17.2.17, 18.2.5.
   * @param sslKeyAndCertificateRef set the sslKeyAndCertificateRef.
   */
  public void setSslKeyAndCertificateRef(String  sslKeyAndCertificateRef) {
    this.sslKeyAndCertificateRef = sslKeyAndCertificateRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The destination syslog server ip address or hostname.
   * @return syslogServer
   */
  public String getSyslogServer() {
    return syslogServer;
  }

  /**
   * This is the setter method to the attribute.
   * The destination syslog server ip address or hostname.
   * @param syslogServer set the syslogServer.
   */
  public void setSyslogServer(String  syslogServer) {
    this.syslogServer = syslogServer;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The destination syslog server's service port.
   * Default value when not specified in API or module is interpreted by Avi Controller as 514.
   * @return syslogServerPort
   */
  public Integer getSyslogServerPort() {
    return syslogServerPort;
  }

  /**
   * This is the setter method to the attribute.
   * The destination syslog server's service port.
   * Default value when not specified in API or module is interpreted by Avi Controller as 514.
   * @param syslogServerPort set the syslogServerPort.
   */
  public void setSyslogServerPort(Integer  syslogServerPort) {
    this.syslogServerPort = syslogServerPort;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable tls to the syslog server.
   * Field introduced in 17.2.16, 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return tlsEnable
   */
  public Boolean getTlsEnable() {
    return tlsEnable;
  }

  /**
   * This is the setter method to the attribute.
   * Enable tls to the syslog server.
   * Field introduced in 17.2.16, 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param tlsEnable set the tlsEnable.
   */
  public void setTlsEnable(Boolean  tlsEnable) {
    this.tlsEnable = tlsEnable;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Network protocol to establish syslog session.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return udp
   */
  public Boolean getUdp() {
    return udp;
  }

  /**
   * This is the setter method to the attribute.
   * Network protocol to establish syslog session.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param udp set the udp.
   */
  public void setUdp(Boolean  udp) {
    this.udp = udp;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  AlertSyslogServer objAlertSyslogServer = (AlertSyslogServer) o;
  return   Objects.equals(this.tlsEnable, objAlertSyslogServer.tlsEnable)&&
  Objects.equals(this.udp, objAlertSyslogServer.udp)&&
  Objects.equals(this.format, objAlertSyslogServer.format)&&
  Objects.equals(this.sslKeyAndCertificateRef, objAlertSyslogServer.sslKeyAndCertificateRef)&&
  Objects.equals(this.pkiprofileRef, objAlertSyslogServer.pkiprofileRef)&&
  Objects.equals(this.anonAuth, objAlertSyslogServer.anonAuth)&&
  Objects.equals(this.syslogServerPort, objAlertSyslogServer.syslogServerPort)&&
  Objects.equals(this.syslogServer, objAlertSyslogServer.syslogServer);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class AlertSyslogServer {\n");
      sb.append("    anonAuth: ").append(toIndentedString(anonAuth)).append("\n");
        sb.append("    format: ").append(toIndentedString(format)).append("\n");
        sb.append("    pkiprofileRef: ").append(toIndentedString(pkiprofileRef)).append("\n");
        sb.append("    sslKeyAndCertificateRef: ").append(toIndentedString(sslKeyAndCertificateRef)).append("\n");
        sb.append("    syslogServer: ").append(toIndentedString(syslogServer)).append("\n");
        sb.append("    syslogServerPort: ").append(toIndentedString(syslogServerPort)).append("\n");
        sb.append("    tlsEnable: ").append(toIndentedString(tlsEnable)).append("\n");
        sb.append("    udp: ").append(toIndentedString(udp)).append("\n");
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

