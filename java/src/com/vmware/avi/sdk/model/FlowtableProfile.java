package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The FlowtableProfile is a POJO class extends AviRestResource that used for creating
 * FlowtableProfile.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FlowtableProfile  {
    @JsonProperty("tcp_closed_timeout")
    private Integer tcpClosedTimeout = 5;

    @JsonProperty("tcp_connection_setup_timeout")
    private Integer tcpConnectionSetupTimeout = 10;

    @JsonProperty("tcp_half_closed_timeout")
    private Integer tcpHalfClosedTimeout = 30;

    @JsonProperty("tcp_idle_timeout")
    private Integer tcpIdleTimeout = 300;

    @JsonProperty("tcp_reset_timeout")
    private Integer tcpResetTimeout = 1;

    @JsonProperty("udp_idle_timeout")
    private Integer udpIdleTimeout = 10;



  /**
   * This is the getter method this will return the attribute value.
   * Idle timeout in seconds for tcp flows in closed state.
   * Allowed values are 1-36000.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5.
   * @return tcpClosedTimeout
   */
  public Integer getTcpClosedTimeout() {
    return tcpClosedTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * Idle timeout in seconds for tcp flows in closed state.
   * Allowed values are 1-36000.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5.
   * @param tcpClosedTimeout set the tcpClosedTimeout.
   */
  public void setTcpClosedTimeout(Integer  tcpClosedTimeout) {
    this.tcpClosedTimeout = tcpClosedTimeout;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Idle timeout in seconds for nat tcp flows in connection setup state.
   * Allowed values are 1-36000.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.
   * @return tcpConnectionSetupTimeout
   */
  public Integer getTcpConnectionSetupTimeout() {
    return tcpConnectionSetupTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * Idle timeout in seconds for nat tcp flows in connection setup state.
   * Allowed values are 1-36000.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.
   * @param tcpConnectionSetupTimeout set the tcpConnectionSetupTimeout.
   */
  public void setTcpConnectionSetupTimeout(Integer  tcpConnectionSetupTimeout) {
    this.tcpConnectionSetupTimeout = tcpConnectionSetupTimeout;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Idle timeout in seconds for tcp flows in half closed state.
   * Allowed values are 1-36000.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 30.
   * @return tcpHalfClosedTimeout
   */
  public Integer getTcpHalfClosedTimeout() {
    return tcpHalfClosedTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * Idle timeout in seconds for tcp flows in half closed state.
   * Allowed values are 1-36000.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 30.
   * @param tcpHalfClosedTimeout set the tcpHalfClosedTimeout.
   */
  public void setTcpHalfClosedTimeout(Integer  tcpHalfClosedTimeout) {
    this.tcpHalfClosedTimeout = tcpHalfClosedTimeout;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Idle timeout in seconds for tcp flows.
   * Allowed values are 1-36000.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 300.
   * @return tcpIdleTimeout
   */
  public Integer getTcpIdleTimeout() {
    return tcpIdleTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * Idle timeout in seconds for tcp flows.
   * Allowed values are 1-36000.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 300.
   * @param tcpIdleTimeout set the tcpIdleTimeout.
   */
  public void setTcpIdleTimeout(Integer  tcpIdleTimeout) {
    this.tcpIdleTimeout = tcpIdleTimeout;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Timeout in seconds for tcp flows after rst is seen.within this timeout, if any non-syn packet is seenfrom the endpoint from which rst is
   * received,nat-flow moves to established state.
   * Otherwise nat-flowis cleaned up.
   * This state helps to mitigate the impactof rst attacks.
   * Allowed values are 1-36000.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.
   * @return tcpResetTimeout
   */
  public Integer getTcpResetTimeout() {
    return tcpResetTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * Timeout in seconds for tcp flows after rst is seen.within this timeout, if any non-syn packet is seenfrom the endpoint from which rst is
   * received,nat-flow moves to established state.
   * Otherwise nat-flowis cleaned up.
   * This state helps to mitigate the impactof rst attacks.
   * Allowed values are 1-36000.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1.
   * @param tcpResetTimeout set the tcpResetTimeout.
   */
  public void setTcpResetTimeout(Integer  tcpResetTimeout) {
    this.tcpResetTimeout = tcpResetTimeout;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Idle timeout in seconds for udp flows.
   * Allowed values are 1-36000.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.
   * @return udpIdleTimeout
   */
  public Integer getUdpIdleTimeout() {
    return udpIdleTimeout;
  }

  /**
   * This is the setter method to the attribute.
   * Idle timeout in seconds for udp flows.
   * Allowed values are 1-36000.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as 10.
   * @param udpIdleTimeout set the udpIdleTimeout.
   */
  public void setUdpIdleTimeout(Integer  udpIdleTimeout) {
    this.udpIdleTimeout = udpIdleTimeout;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  FlowtableProfile objFlowtableProfile = (FlowtableProfile) o;
  return   Objects.equals(this.udpIdleTimeout, objFlowtableProfile.udpIdleTimeout)&&
  Objects.equals(this.tcpConnectionSetupTimeout, objFlowtableProfile.tcpConnectionSetupTimeout)&&
  Objects.equals(this.tcpIdleTimeout, objFlowtableProfile.tcpIdleTimeout)&&
  Objects.equals(this.tcpHalfClosedTimeout, objFlowtableProfile.tcpHalfClosedTimeout)&&
  Objects.equals(this.tcpClosedTimeout, objFlowtableProfile.tcpClosedTimeout)&&
  Objects.equals(this.tcpResetTimeout, objFlowtableProfile.tcpResetTimeout);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class FlowtableProfile {\n");
      sb.append("    tcpClosedTimeout: ").append(toIndentedString(tcpClosedTimeout)).append("\n");
        sb.append("    tcpConnectionSetupTimeout: ").append(toIndentedString(tcpConnectionSetupTimeout)).append("\n");
        sb.append("    tcpHalfClosedTimeout: ").append(toIndentedString(tcpHalfClosedTimeout)).append("\n");
        sb.append("    tcpIdleTimeout: ").append(toIndentedString(tcpIdleTimeout)).append("\n");
        sb.append("    tcpResetTimeout: ").append(toIndentedString(tcpResetTimeout)).append("\n");
        sb.append("    udpIdleTimeout: ").append(toIndentedString(udpIdleTimeout)).append("\n");
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

