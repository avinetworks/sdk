package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SSLClientCertificateAction is a POJO class extends AviRestResource that used for creating
 * SSLClientCertificateAction.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SSLClientCertificateAction  {
    @JsonProperty("close_connection")
    private Boolean closeConnection = false;

    @JsonProperty("headers")
    private List<SSLClientRequestHeader> headers = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property close_connection of obj type sslclientcertificateaction field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return closeConnection
   */
  public Boolean getCloseConnection() {
    return closeConnection;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property close_connection of obj type sslclientcertificateaction field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param closeConnection set the closeConnection.
   */
  public void setCloseConnection(Boolean  closeConnection) {
    this.closeConnection = closeConnection;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property headers of obj type sslclientcertificateaction field type str  type array.
   * @return headers
   */
  public List<SSLClientRequestHeader> getHeaders() {
    return headers;
  }

  /**
   * This is the setter method. this will set the headers
   * Placeholder for description of property headers of obj type sslclientcertificateaction field type str  type array.
   * @return headers
   */
  public void setHeaders(List<SSLClientRequestHeader>  headers) {
    this.headers = headers;
  }

  /**
   * This is the setter method this will set the headers
   * Placeholder for description of property headers of obj type sslclientcertificateaction field type str  type array.
   * @return headers
   */
  public SSLClientCertificateAction addHeadersItem(SSLClientRequestHeader headersItem) {
    if (this.headers == null) {
      this.headers = new ArrayList<SSLClientRequestHeader>();
    }
    this.headers.add(headersItem);
    return this;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SSLClientCertificateAction objSSLClientCertificateAction = (SSLClientCertificateAction) o;
  return   Objects.equals(this.headers, objSSLClientCertificateAction.headers)&&
  Objects.equals(this.closeConnection, objSSLClientCertificateAction.closeConnection);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SSLClientCertificateAction {\n");
      sb.append("    closeConnection: ").append(toIndentedString(closeConnection)).append("\n");
        sb.append("    headers: ").append(toIndentedString(headers)).append("\n");
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

