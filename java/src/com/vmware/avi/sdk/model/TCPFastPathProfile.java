package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The TCPFastPathProfile is a POJO class extends AviRestResource that used for creating
 * TCPFastPathProfile.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TCPFastPathProfile  {
    @JsonProperty("dsr_profile")
    private DsrProfile dsrProfile = null;

    @JsonProperty("enable_syn_protection")
    private Boolean enableSynProtection = false;

    @JsonProperty("session_idle_timeout")
    private Integer sessionIdleTimeout = 300;



  /**
   * This is the getter method this will return the attribute value.
   * Dsr profile information.
   * Field introduced in 18.2.3.
   * @return dsrProfile
   */
  public DsrProfile getDsrProfile() {
    return dsrProfile;
  }

  /**
   * This is the setter method to the attribute.
   * Dsr profile information.
   * Field introduced in 18.2.3.
   * @param dsrProfile set the dsrProfile.
   */
  public void setDsrProfile(DsrProfile dsrProfile) {
    this.dsrProfile = dsrProfile;
  }

  /**
   * This is the getter method this will return the attribute value.
   * When enabled, avi will complete the 3-way handshake with the client before forwarding any packets to the server.
   * This will protect the server from syn flood and half open syn connections.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return enableSynProtection
   */
  public Boolean getEnableSynProtection() {
    return enableSynProtection;
  }

  /**
   * This is the setter method to the attribute.
   * When enabled, avi will complete the 3-way handshake with the client before forwarding any packets to the server.
   * This will protect the server from syn flood and half open syn connections.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param enableSynProtection set the enableSynProtection.
   */
  public void setEnableSynProtection(Boolean  enableSynProtection) {
    this.enableSynProtection = enableSynProtection;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The amount of time (in sec) for which a connection needs to be idle before it is eligible to be deleted.
   * Allowed values are 5-14400.
   * Special values are 0 - 'infinite'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 300.
   * @return sessionIdleTimeout
   */
  public Integer getSessionIdleTimeout() {
    return sessionIdleTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * The amount of time (in sec) for which a connection needs to be idle before it is eligible to be deleted.
   * Allowed values are 5-14400.
   * Special values are 0 - 'infinite'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 300.
   * @param sessionIdleTimeout set the sessionIdleTimeout.
   */
  public void setSessionIdleTimeout(Integer  sessionIdleTimeout) {
    this.sessionIdleTimeout = sessionIdleTimeout;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  TCPFastPathProfile objTCPFastPathProfile = (TCPFastPathProfile) o;
  return   Objects.equals(this.sessionIdleTimeout, objTCPFastPathProfile.sessionIdleTimeout)&&
  Objects.equals(this.enableSynProtection, objTCPFastPathProfile.enableSynProtection)&&
  Objects.equals(this.dsrProfile, objTCPFastPathProfile.dsrProfile);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class TCPFastPathProfile {\n");
      sb.append("    dsrProfile: ").append(toIndentedString(dsrProfile)).append("\n");
        sb.append("    enableSynProtection: ").append(toIndentedString(enableSynProtection)).append("\n");
        sb.append("    sessionIdleTimeout: ").append(toIndentedString(sessionIdleTimeout)).append("\n");
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

