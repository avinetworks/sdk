package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SipMessage is a POJO class extends AviRestResource that used for creating
 * SipMessage.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SipMessage  {
    @JsonProperty("content")
    private String content = null;

    @JsonProperty("from_client")
    private Boolean fromClient = null;

    @JsonProperty("method")
    private String method = null;

    @JsonProperty("rcv_timestamp")
    private Integer rcvTimestamp = null;

    @JsonProperty("rx_bytes")
    private Integer rxBytes = null;

    @JsonProperty("status")
    private String status = null;

    @JsonProperty("status_code")
    private Integer statusCode = null;

    @JsonProperty("tx_bytes")
    private Integer txBytes = null;



  /**
   * This is the getter method this will return the attribute value.
   * Contents up to first 128 bytes of a sip message for which could not be parsed.
   * Field introduced in 17.2.12, 18.1.3, 18.2.1.
   * @return content
   */
  public String getContent() {
    return content;
  }

  /**
   * This is the setter method to the attribute.
   * Contents up to first 128 bytes of a sip message for which could not be parsed.
   * Field introduced in 17.2.12, 18.1.3, 18.2.1.
   * @param content set the content.
   */
  public void setContent(String  content) {
    this.content = content;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Indicates if sip message is received from a client.
   * Field introduced in 17.2.12, 18.1.3, 18.2.1.
   * @return fromClient
   */
  public Boolean getFromClient() {
    return fromClient;
  }

  /**
   * This is the setter method to the attribute.
   * Indicates if sip message is received from a client.
   * Field introduced in 17.2.12, 18.1.3, 18.2.1.
   * @param fromClient set the fromClient.
   */
  public void setFromClient(Boolean  fromClient) {
    this.fromClient = fromClient;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Sip request method string.
   * Field introduced in 17.2.12, 18.1.3, 18.2.1.
   * @return method
   */
  public String getMethod() {
    return method;
  }

  /**
   * This is the setter method to the attribute.
   * Sip request method string.
   * Field introduced in 17.2.12, 18.1.3, 18.2.1.
   * @param method set the method.
   */
  public void setMethod(String  method) {
    this.method = method;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Sip message receive time stamp.
   * Field introduced in 17.2.12, 18.1.3, 18.2.1.
   * @return rcvTimestamp
   */
  public Integer getRcvTimestamp() {
    return rcvTimestamp;
  }

  /**
   * This is the setter method to the attribute.
   * Sip message receive time stamp.
   * Field introduced in 17.2.12, 18.1.3, 18.2.1.
   * @param rcvTimestamp set the rcvTimestamp.
   */
  public void setRcvTimestamp(Integer  rcvTimestamp) {
    this.rcvTimestamp = rcvTimestamp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Sip message size before modifications.
   * Field introduced in 17.2.12, 18.1.3, 18.2.1.
   * @return rxBytes
   */
  public Integer getRxBytes() {
    return rxBytes;
  }

  /**
   * This is the setter method to the attribute.
   * Sip message size before modifications.
   * Field introduced in 17.2.12, 18.1.3, 18.2.1.
   * @param rxBytes set the rxBytes.
   */
  public void setRxBytes(Integer  rxBytes) {
    this.rxBytes = rxBytes;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Sip response status string.
   * Field introduced in 17.2.12, 18.1.3, 18.2.1.
   * @return status
   */
  public String getStatus() {
    return status;
  }

  /**
   * This is the setter method to the attribute.
   * Sip response status string.
   * Field introduced in 17.2.12, 18.1.3, 18.2.1.
   * @param status set the status.
   */
  public void setStatus(String  status) {
    this.status = status;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Sip response status code, 2xx response means success.
   * Field introduced in 17.2.12, 18.1.3, 18.2.1.
   * @return statusCode
   */
  public Integer getStatusCode() {
    return statusCode;
  }

  /**
   * This is the setter method to the attribute.
   * Sip response status code, 2xx response means success.
   * Field introduced in 17.2.12, 18.1.3, 18.2.1.
   * @param statusCode set the statusCode.
   */
  public void setStatusCode(Integer  statusCode) {
    this.statusCode = statusCode;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Sip message size post modifications.
   * Field introduced in 17.2.12, 18.1.3, 18.2.1.
   * @return txBytes
   */
  public Integer getTxBytes() {
    return txBytes;
  }

  /**
   * This is the setter method to the attribute.
   * Sip message size post modifications.
   * Field introduced in 17.2.12, 18.1.3, 18.2.1.
   * @param txBytes set the txBytes.
   */
  public void setTxBytes(Integer  txBytes) {
    this.txBytes = txBytes;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SipMessage objSipMessage = (SipMessage) o;
  return   Objects.equals(this.status, objSipMessage.status)&&
  Objects.equals(this.rxBytes, objSipMessage.rxBytes)&&
  Objects.equals(this.statusCode, objSipMessage.statusCode)&&
  Objects.equals(this.content, objSipMessage.content)&&
  Objects.equals(this.fromClient, objSipMessage.fromClient)&&
  Objects.equals(this.txBytes, objSipMessage.txBytes)&&
  Objects.equals(this.rcvTimestamp, objSipMessage.rcvTimestamp)&&
  Objects.equals(this.method, objSipMessage.method);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SipMessage {\n");
      sb.append("    content: ").append(toIndentedString(content)).append("\n");
        sb.append("    fromClient: ").append(toIndentedString(fromClient)).append("\n");
        sb.append("    method: ").append(toIndentedString(method)).append("\n");
        sb.append("    rcvTimestamp: ").append(toIndentedString(rcvTimestamp)).append("\n");
        sb.append("    rxBytes: ").append(toIndentedString(rxBytes)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
        sb.append("    txBytes: ").append(toIndentedString(txBytes)).append("\n");
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

