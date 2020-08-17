package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The HTTP2ApplicationProfile is a POJO class extends AviRestResource that used for creating
 * HTTP2ApplicationProfile.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HTTP2ApplicationProfile  {
    @JsonProperty("http2_initial_window_size")
    private Integer http2InitialWindowSize = 64;

    @JsonProperty("max_http2_concurrent_streams_per_connection")
    private Integer maxHttp2ConcurrentStreamsPerConnection = 128;

    @JsonProperty("max_http2_control_frames_per_connection")
    private Integer maxHttp2ControlFramesPerConnection = 1000;

    @JsonProperty("max_http2_empty_data_frames_per_connection")
    private Integer maxHttp2EmptyDataFramesPerConnection = 1000;

    @JsonProperty("max_http2_header_field_size")
    private Integer maxHttp2HeaderFieldSize = 4096;

    @JsonProperty("max_http2_queued_frames_to_client_per_connection")
    private Integer maxHttp2QueuedFramesToClientPerConnection = 1000;

    @JsonProperty("max_http2_requests_per_connection")
    private Integer maxHttp2RequestsPerConnection = 1000;



  /**
   * This is the getter method this will return the attribute value.
   * The initial flow control window size in kb for http/2 streams.
   * Allowed values are 64-32768.
   * Field introduced in 18.2.10, 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 64.
   * @return http2InitialWindowSize
   */
  public Integer getHttp2InitialWindowSize() {
    return http2InitialWindowSize;
  }

  /**
   * This is the setter method to the attribute.
   * The initial flow control window size in kb for http/2 streams.
   * Allowed values are 64-32768.
   * Field introduced in 18.2.10, 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 64.
   * @param http2InitialWindowSize set the http2InitialWindowSize.
   */
  public void setHttp2InitialWindowSize(Integer  http2InitialWindowSize) {
    this.http2InitialWindowSize = http2InitialWindowSize;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The max number of concurrent streams over a client side http/2 connection.
   * Allowed values are 1-256.
   * Field introduced in 18.2.10, 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 128.
   * @return maxHttp2ConcurrentStreamsPerConnection
   */
  public Integer getMaxHttp2ConcurrentStreamsPerConnection() {
    return maxHttp2ConcurrentStreamsPerConnection;
  }

  /**
   * This is the setter method to the attribute.
   * The max number of concurrent streams over a client side http/2 connection.
   * Allowed values are 1-256.
   * Field introduced in 18.2.10, 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 128.
   * @param maxHttp2ConcurrentStreamsPerConnection set the maxHttp2ConcurrentStreamsPerConnection.
   */
  public void setMaxHttp2ConcurrentStreamsPerConnection(Integer  maxHttp2ConcurrentStreamsPerConnection) {
    this.maxHttp2ConcurrentStreamsPerConnection = maxHttp2ConcurrentStreamsPerConnection;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The max number of control frames that client can send over an http/2 connection.
   * '0' means unlimited.
   * Allowed values are 0-10000.
   * Special values are 0- 'unlimited control frames on a client side http/2 connection'.
   * Field introduced in 18.2.10, 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1000.
   * @return maxHttp2ControlFramesPerConnection
   */
  public Integer getMaxHttp2ControlFramesPerConnection() {
    return maxHttp2ControlFramesPerConnection;
  }

  /**
   * This is the setter method to the attribute.
   * The max number of control frames that client can send over an http/2 connection.
   * '0' means unlimited.
   * Allowed values are 0-10000.
   * Special values are 0- 'unlimited control frames on a client side http/2 connection'.
   * Field introduced in 18.2.10, 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1000.
   * @param maxHttp2ControlFramesPerConnection set the maxHttp2ControlFramesPerConnection.
   */
  public void setMaxHttp2ControlFramesPerConnection(Integer  maxHttp2ControlFramesPerConnection) {
    this.maxHttp2ControlFramesPerConnection = maxHttp2ControlFramesPerConnection;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The max number of empty data frames that client can send over an http/2 connection.
   * '0' means unlimited.
   * Allowed values are 0-10000.
   * Special values are 0- 'unlimited empty data frames over a client side http/2 connection'.
   * Field introduced in 18.2.10, 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1000.
   * @return maxHttp2EmptyDataFramesPerConnection
   */
  public Integer getMaxHttp2EmptyDataFramesPerConnection() {
    return maxHttp2EmptyDataFramesPerConnection;
  }

  /**
   * This is the setter method to the attribute.
   * The max number of empty data frames that client can send over an http/2 connection.
   * '0' means unlimited.
   * Allowed values are 0-10000.
   * Special values are 0- 'unlimited empty data frames over a client side http/2 connection'.
   * Field introduced in 18.2.10, 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1000.
   * @param maxHttp2EmptyDataFramesPerConnection set the maxHttp2EmptyDataFramesPerConnection.
   */
  public void setMaxHttp2EmptyDataFramesPerConnection(Integer  maxHttp2EmptyDataFramesPerConnection) {
    this.maxHttp2EmptyDataFramesPerConnection = maxHttp2EmptyDataFramesPerConnection;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The maximum size in bytes of the compressed request header field.
   * The limit applies equally to both name and value.
   * Allowed values are 1-8192.
   * Field introduced in 18.2.10, 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4096.
   * @return maxHttp2HeaderFieldSize
   */
  public Integer getMaxHttp2HeaderFieldSize() {
    return maxHttp2HeaderFieldSize;
  }

  /**
   * This is the setter method to the attribute.
   * The maximum size in bytes of the compressed request header field.
   * The limit applies equally to both name and value.
   * Allowed values are 1-8192.
   * Field introduced in 18.2.10, 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4096.
   * @param maxHttp2HeaderFieldSize set the maxHttp2HeaderFieldSize.
   */
  public void setMaxHttp2HeaderFieldSize(Integer  maxHttp2HeaderFieldSize) {
    this.maxHttp2HeaderFieldSize = maxHttp2HeaderFieldSize;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The max number of frames that can be queued waiting to be sent over a client side http/2 connection at any given time.
   * '0' means unlimited.
   * Allowed values are 0-10000.
   * Special values are 0- 'unlimited frames can be queued on a client side http/2 connection'.
   * Field introduced in 18.2.10, 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1000.
   * @return maxHttp2QueuedFramesToClientPerConnection
   */
  public Integer getMaxHttp2QueuedFramesToClientPerConnection() {
    return maxHttp2QueuedFramesToClientPerConnection;
  }

  /**
   * This is the setter method to the attribute.
   * The max number of frames that can be queued waiting to be sent over a client side http/2 connection at any given time.
   * '0' means unlimited.
   * Allowed values are 0-10000.
   * Special values are 0- 'unlimited frames can be queued on a client side http/2 connection'.
   * Field introduced in 18.2.10, 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1000.
   * @param maxHttp2QueuedFramesToClientPerConnection set the maxHttp2QueuedFramesToClientPerConnection.
   */
  public void setMaxHttp2QueuedFramesToClientPerConnection(Integer  maxHttp2QueuedFramesToClientPerConnection) {
    this.maxHttp2QueuedFramesToClientPerConnection = maxHttp2QueuedFramesToClientPerConnection;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The maximum number of requests over a client side http/2 connection.
   * Allowed values are 0-10000.
   * Special values are 0- 'unlimited requests on a client side http/2 connection'.
   * Field introduced in 18.2.10, 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1000.
   * @return maxHttp2RequestsPerConnection
   */
  public Integer getMaxHttp2RequestsPerConnection() {
    return maxHttp2RequestsPerConnection;
  }

  /**
   * This is the setter method to the attribute.
   * The maximum number of requests over a client side http/2 connection.
   * Allowed values are 0-10000.
   * Special values are 0- 'unlimited requests on a client side http/2 connection'.
   * Field introduced in 18.2.10, 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 1000.
   * @param maxHttp2RequestsPerConnection set the maxHttp2RequestsPerConnection.
   */
  public void setMaxHttp2RequestsPerConnection(Integer  maxHttp2RequestsPerConnection) {
    this.maxHttp2RequestsPerConnection = maxHttp2RequestsPerConnection;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  HTTP2ApplicationProfile objHTTP2ApplicationProfile = (HTTP2ApplicationProfile) o;
  return   Objects.equals(this.maxHttp2ControlFramesPerConnection, objHTTP2ApplicationProfile.maxHttp2ControlFramesPerConnection)&&
  Objects.equals(this.maxHttp2QueuedFramesToClientPerConnection, objHTTP2ApplicationProfile.maxHttp2QueuedFramesToClientPerConnection)&&
  Objects.equals(this.maxHttp2EmptyDataFramesPerConnection, objHTTP2ApplicationProfile.maxHttp2EmptyDataFramesPerConnection)&&
  Objects.equals(this.maxHttp2ConcurrentStreamsPerConnection, objHTTP2ApplicationProfile.maxHttp2ConcurrentStreamsPerConnection)&&
  Objects.equals(this.maxHttp2RequestsPerConnection, objHTTP2ApplicationProfile.maxHttp2RequestsPerConnection)&&
  Objects.equals(this.maxHttp2HeaderFieldSize, objHTTP2ApplicationProfile.maxHttp2HeaderFieldSize)&&
  Objects.equals(this.http2InitialWindowSize, objHTTP2ApplicationProfile.http2InitialWindowSize);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class HTTP2ApplicationProfile {\n");
      sb.append("    http2InitialWindowSize: ").append(toIndentedString(http2InitialWindowSize)).append("\n");
        sb.append("    maxHttp2ConcurrentStreamsPerConnection: ").append(toIndentedString(maxHttp2ConcurrentStreamsPerConnection)).append("\n");
        sb.append("    maxHttp2ControlFramesPerConnection: ").append(toIndentedString(maxHttp2ControlFramesPerConnection)).append("\n");
        sb.append("    maxHttp2EmptyDataFramesPerConnection: ").append(toIndentedString(maxHttp2EmptyDataFramesPerConnection)).append("\n");
        sb.append("    maxHttp2HeaderFieldSize: ").append(toIndentedString(maxHttp2HeaderFieldSize)).append("\n");
        sb.append("    maxHttp2QueuedFramesToClientPerConnection: ").append(toIndentedString(maxHttp2QueuedFramesToClientPerConnection)).append("\n");
        sb.append("    maxHttp2RequestsPerConnection: ").append(toIndentedString(maxHttp2RequestsPerConnection)).append("\n");
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

