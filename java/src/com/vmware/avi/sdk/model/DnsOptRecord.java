package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DnsOptRecord is a POJO class extends AviRestResource that used for creating
 * DnsOptRecord.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DnsOptRecord  {
    @JsonProperty("dnssec_ok")
    private Boolean dnssecOk = null;

    @JsonProperty("options")
    private List<DnsEdnsOption> options = null;

    @JsonProperty("udp_payload_size")
    private Integer udpPayloadSize = null;

    @JsonProperty("version")
    private Integer version = null;



  /**
   * This is the getter method this will return the attribute value.
   * Flag indicating client is dnssec aware.
   * Field introduced in 17.1.1.
   * @return dnssecOk
   */
  public Boolean getDnssecOk() {
    return dnssecOk;
  }

  /**
   * This is the setter method to the attribute.
   * Flag indicating client is dnssec aware.
   * Field introduced in 17.1.1.
   * @param dnssecOk set the dnssecOk.
   */
  public void setDnssecOk(Boolean  dnssecOk) {
    this.dnssecOk = dnssecOk;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Edns options.
   * Field introduced in 17.1.1.
   * @return options
   */
  public List<DnsEdnsOption> getOptions() {
    return options;
  }

  /**
   * This is the setter method. this will set the options
   * Edns options.
   * Field introduced in 17.1.1.
   * @return options
   */
  public void setOptions(List<DnsEdnsOption>  options) {
    this.options = options;
  }

  /**
   * This is the setter method this will set the options
   * Edns options.
   * Field introduced in 17.1.1.
   * @return options
   */
  public DnsOptRecord addOptionsItem(DnsEdnsOption optionsItem) {
    if (this.options == null) {
      this.options = new ArrayList<DnsEdnsOption>();
    }
    this.options.add(optionsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Client requestor's udp payload size.
   * Field introduced in 17.1.1.
   * @return udpPayloadSize
   */
  public Integer getUdpPayloadSize() {
    return udpPayloadSize;
  }

  /**
   * This is the setter method to the attribute.
   * Client requestor's udp payload size.
   * Field introduced in 17.1.1.
   * @param udpPayloadSize set the udpPayloadSize.
   */
  public void setUdpPayloadSize(Integer  udpPayloadSize) {
    this.udpPayloadSize = udpPayloadSize;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Edns version.
   * Field introduced in 17.1.1.
   * @return version
   */
  public Integer getVersion() {
    return version;
  }

  /**
   * This is the setter method to the attribute.
   * Edns version.
   * Field introduced in 17.1.1.
   * @param version set the version.
   */
  public void setVersion(Integer  version) {
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
  DnsOptRecord objDnsOptRecord = (DnsOptRecord) o;
  return   Objects.equals(this.version, objDnsOptRecord.version)&&
  Objects.equals(this.udpPayloadSize, objDnsOptRecord.udpPayloadSize)&&
  Objects.equals(this.dnssecOk, objDnsOptRecord.dnssecOk)&&
  Objects.equals(this.options, objDnsOptRecord.options);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DnsOptRecord {\n");
      sb.append("    dnssecOk: ").append(toIndentedString(dnssecOk)).append("\n");
        sb.append("    options: ").append(toIndentedString(options)).append("\n");
        sb.append("    udpPayloadSize: ").append(toIndentedString(udpPayloadSize)).append("\n");
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

