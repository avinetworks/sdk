package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The RmSeIpFailEventDetails is a POJO class extends AviRestResource that used for creating
 * RmSeIpFailEventDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RmSeIpFailEventDetails  {
    @JsonProperty("host_name")
    private String hostName = null;

    @JsonProperty("networks")
    private List<RmAddVnic> networks = null;

    @JsonProperty("reason")
    private String reason = null;

    @JsonProperty("se_name")
    private String seName = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property host_name of obj type rmseipfaileventdetails field type str  type string.
   * @return hostName
   */
  public String getHostName() {
    return hostName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property host_name of obj type rmseipfaileventdetails field type str  type string.
   * @param hostName set the hostName.
   */
  public void setHostName(String  hostName) {
    this.hostName = hostName;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property networks of obj type rmseipfaileventdetails field type str  type array.
   * @return networks
   */
  public List<RmAddVnic> getNetworks() {
    return networks;
  }

  /**
   * This is the setter method. this will set the networks
   * Placeholder for description of property networks of obj type rmseipfaileventdetails field type str  type array.
   * @return networks
   */
  public void setNetworks(List<RmAddVnic>  networks) {
    this.networks = networks;
  }

  /**
   * This is the setter method this will set the networks
   * Placeholder for description of property networks of obj type rmseipfaileventdetails field type str  type array.
   * @return networks
   */
  public RmSeIpFailEventDetails addNetworksItem(RmAddVnic networksItem) {
    if (this.networks == null) {
      this.networks = new ArrayList<RmAddVnic>();
    }
    this.networks.add(networksItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property reason of obj type rmseipfaileventdetails field type str  type string.
   * @return reason
   */
  public String getReason() {
    return reason;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property reason of obj type rmseipfaileventdetails field type str  type string.
   * @param reason set the reason.
   */
  public void setReason(String  reason) {
    this.reason = reason;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_name of obj type rmseipfaileventdetails field type str  type string.
   * @return seName
   */
  public String getSeName() {
    return seName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_name of obj type rmseipfaileventdetails field type str  type string.
   * @param seName set the seName.
   */
  public void setSeName(String  seName) {
    this.seName = seName;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  RmSeIpFailEventDetails objRmSeIpFailEventDetails = (RmSeIpFailEventDetails) o;
  return   Objects.equals(this.reason, objRmSeIpFailEventDetails.reason)&&
  Objects.equals(this.seName, objRmSeIpFailEventDetails.seName)&&
  Objects.equals(this.hostName, objRmSeIpFailEventDetails.hostName)&&
  Objects.equals(this.networks, objRmSeIpFailEventDetails.networks);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class RmSeIpFailEventDetails {\n");
      sb.append("    hostName: ").append(toIndentedString(hostName)).append("\n");
        sb.append("    networks: ").append(toIndentedString(networks)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    seName: ").append(toIndentedString(seName)).append("\n");
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

