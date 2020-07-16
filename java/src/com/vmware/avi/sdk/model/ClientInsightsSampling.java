package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ClientInsightsSampling is a POJO class extends AviRestResource that used for creating
 * ClientInsightsSampling.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientInsightsSampling  {
    @JsonProperty("client_ip")
    private IpAddrMatch clientIp = null;

    @JsonProperty("sample_uris")
    private StringMatch sampleUris = null;

    @JsonProperty("skip_uris")
    private StringMatch skipUris = null;



  /**
   * This is the getter method this will return the attribute value.
   * Client ip addresses to check when inserting rum script.
   * @return clientIp
   */
  public IpAddrMatch getClientIp() {
    return clientIp;
  }

  /**
   * This is the setter method to the attribute.
   * Client ip addresses to check when inserting rum script.
   * @param clientIp set the clientIp.
   */
  public void setClientIp(IpAddrMatch clientIp) {
    this.clientIp = clientIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Url patterns to check when inserting rum script.
   * @return sampleUris
   */
  public StringMatch getSampleUris() {
    return sampleUris;
  }

  /**
   * This is the setter method to the attribute.
   * Url patterns to check when inserting rum script.
   * @param sampleUris set the sampleUris.
   */
  public void setSampleUris(StringMatch sampleUris) {
    this.sampleUris = sampleUris;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Url patterns to avoid when inserting rum script.
   * @return skipUris
   */
  public StringMatch getSkipUris() {
    return skipUris;
  }

  /**
   * This is the setter method to the attribute.
   * Url patterns to avoid when inserting rum script.
   * @param skipUris set the skipUris.
   */
  public void setSkipUris(StringMatch skipUris) {
    this.skipUris = skipUris;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ClientInsightsSampling objClientInsightsSampling = (ClientInsightsSampling) o;
  return   Objects.equals(this.skipUris, objClientInsightsSampling.skipUris)&&
  Objects.equals(this.clientIp, objClientInsightsSampling.clientIp)&&
  Objects.equals(this.sampleUris, objClientInsightsSampling.sampleUris);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ClientInsightsSampling {\n");
      sb.append("    clientIp: ").append(toIndentedString(clientIp)).append("\n");
        sb.append("    sampleUris: ").append(toIndentedString(sampleUris)).append("\n");
        sb.append("    skipUris: ").append(toIndentedString(skipUris)).append("\n");
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

