package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DebugVirtualServiceCapture is a POJO class extends AviRestResource that used for creating
 * DebugVirtualServiceCapture.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DebugVirtualServiceCapture  {
    @JsonProperty("capture_file_size")
    private CaptureFileSize captureFileSize = null;

    @JsonProperty("duration")
    private Integer duration = 0;

    @JsonProperty("enable_ssl_session_key_capture")
    private Boolean enableSslSessionKeyCapture = false;

    @JsonProperty("file_count")
    private Integer fileCount = 2;

    @JsonProperty("num_pkts")
    private Integer numPkts = null;

    @JsonProperty("pcap_ng")
    private Boolean pcapNg = true;

    @JsonProperty("pkt_size")
    private Integer pktSize = 128;



  /**
   * This is the getter method this will return the attribute value.
   * Maximum allowed size of pcap capture file per se.
   * Max(absolute_size, percentage_size) will be final value.
   * Set both to 0 for avi default size.
   * Dos, ipc and drop pcaps not applicaple.
   * Field introduced in 18.2.8.
   * @return captureFileSize
   */
  public CaptureFileSize getCaptureFileSize() {
    return captureFileSize;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum allowed size of pcap capture file per se.
   * Max(absolute_size, percentage_size) will be final value.
   * Set both to 0 for avi default size.
   * Dos, ipc and drop pcaps not applicaple.
   * Field introduced in 18.2.8.
   * @param captureFileSize set the captureFileSize.
   */
  public void setCaptureFileSize(CaptureFileSize captureFileSize) {
    this.captureFileSize = captureFileSize;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Number of minutes to capture packets.
   * Use 0 to capture until manually stopped.
   * Special values are 0 - 'infinite'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return duration
   */
  public Integer getDuration() {
    return duration;
  }

  /**
   * This is the setter method to the attribute.
   * Number of minutes to capture packets.
   * Use 0 to capture until manually stopped.
   * Special values are 0 - 'infinite'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param duration set the duration.
   */
  public void setDuration(Integer  duration) {
    this.duration = duration;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable ssl session key capture.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return enableSslSessionKeyCapture
   */
  public Boolean getEnableSslSessionKeyCapture() {
    return enableSslSessionKeyCapture;
  }

  /**
   * This is the setter method to the attribute.
   * Enable ssl session key capture.
   * Field introduced in 18.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param enableSslSessionKeyCapture set the enableSslSessionKeyCapture.
   */
  public void setEnableSslSessionKeyCapture(Boolean  enableSslSessionKeyCapture) {
    this.enableSslSessionKeyCapture = enableSslSessionKeyCapture;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Number of files to maintain for se pcap file rotation.file count set to 1 indicates no rotate.
   * Allowed values are 1-10.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 2.
   * @return fileCount
   */
  public Integer getFileCount() {
    return fileCount;
  }

  /**
   * This is the setter method to the attribute.
   * Number of files to maintain for se pcap file rotation.file count set to 1 indicates no rotate.
   * Allowed values are 1-10.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 2.
   * @param fileCount set the fileCount.
   */
  public void setFileCount(Integer  fileCount) {
    this.fileCount = fileCount;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Total number of packets to capture.
   * @return numPkts
   */
  public Integer getNumPkts() {
    return numPkts;
  }

  /**
   * This is the setter method to the attribute.
   * Total number of packets to capture.
   * @param numPkts set the numPkts.
   */
  public void setNumPkts(Integer  numPkts) {
    this.numPkts = numPkts;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enable pcapng for packet capture.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return pcapNg
   */
  public Boolean getPcapNg() {
    return pcapNg;
  }

  /**
   * This is the setter method to the attribute.
   * Enable pcapng for packet capture.
   * Field introduced in 18.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param pcapNg set the pcapNg.
   */
  public void setPcapNg(Boolean  pcapNg) {
    this.pcapNg = pcapNg;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Number of bytes of each packet to capture.
   * Use 0 to capture the entire packet.
   * Allowed values are 64-1514.
   * Special values are 0 - 'full capture'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 128.
   * @return pktSize
   */
  public Integer getPktSize() {
    return pktSize;
  }

  /**
   * This is the setter method to the attribute.
   * Number of bytes of each packet to capture.
   * Use 0 to capture the entire packet.
   * Allowed values are 64-1514.
   * Special values are 0 - 'full capture'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 128.
   * @param pktSize set the pktSize.
   */
  public void setPktSize(Integer  pktSize) {
    this.pktSize = pktSize;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  DebugVirtualServiceCapture objDebugVirtualServiceCapture = (DebugVirtualServiceCapture) o;
  return   Objects.equals(this.pcapNg, objDebugVirtualServiceCapture.pcapNg)&&
  Objects.equals(this.pktSize, objDebugVirtualServiceCapture.pktSize)&&
  Objects.equals(this.enableSslSessionKeyCapture, objDebugVirtualServiceCapture.enableSslSessionKeyCapture)&&
  Objects.equals(this.captureFileSize, objDebugVirtualServiceCapture.captureFileSize)&&
  Objects.equals(this.fileCount, objDebugVirtualServiceCapture.fileCount)&&
  Objects.equals(this.duration, objDebugVirtualServiceCapture.duration)&&
  Objects.equals(this.numPkts, objDebugVirtualServiceCapture.numPkts);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DebugVirtualServiceCapture {\n");
      sb.append("    captureFileSize: ").append(toIndentedString(captureFileSize)).append("\n");
        sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
        sb.append("    enableSslSessionKeyCapture: ").append(toIndentedString(enableSslSessionKeyCapture)).append("\n");
        sb.append("    fileCount: ").append(toIndentedString(fileCount)).append("\n");
        sb.append("    numPkts: ").append(toIndentedString(numPkts)).append("\n");
        sb.append("    pcapNg: ").append(toIndentedString(pcapNg)).append("\n");
        sb.append("    pktSize: ").append(toIndentedString(pktSize)).append("\n");
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

