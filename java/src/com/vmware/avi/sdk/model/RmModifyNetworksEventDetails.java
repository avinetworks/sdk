package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The RmModifyNetworksEventDetails is a POJO class extends AviRestResource that used for creating
 * RmModifyNetworksEventDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RmModifyNetworksEventDetails  {
    @JsonProperty("networks")
    private List<RmModifyVnic> networks = null;

    @JsonProperty("reason")
    private String reason = null;

    @JsonProperty("se_name")
    private String seName = null;

    @JsonProperty("se_uuid")
    private String seUuid = null;

    @JsonProperty("vs_name")
    private List<String> vsName = null;

    @JsonProperty("vs_uuid")
    private List<String> vsUuid = null;


  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property networks of obj type rmmodifynetworkseventdetails field type str  type array.
   * @return networks
   */
  public List<RmModifyVnic> getNetworks() {
    return networks;
  }

  /**
   * This is the setter method. this will set the networks
   * Placeholder for description of property networks of obj type rmmodifynetworkseventdetails field type str  type array.
   * @return networks
   */
  public void setNetworks(List<RmModifyVnic>  networks) {
    this.networks = networks;
  }

  /**
   * This is the setter method this will set the networks
   * Placeholder for description of property networks of obj type rmmodifynetworkseventdetails field type str  type array.
   * @return networks
   */
  public RmModifyNetworksEventDetails addNetworksItem(RmModifyVnic networksItem) {
    if (this.networks == null) {
      this.networks = new ArrayList<RmModifyVnic>();
    }
    this.networks.add(networksItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property reason of obj type rmmodifynetworkseventdetails field type str  type string.
   * @return reason
   */
  public String getReason() {
    return reason;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property reason of obj type rmmodifynetworkseventdetails field type str  type string.
   * @param reason set the reason.
   */
  public void setReason(String  reason) {
    this.reason = reason;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_name of obj type rmmodifynetworkseventdetails field type str  type string.
   * @return seName
   */
  public String getSeName() {
    return seName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_name of obj type rmmodifynetworkseventdetails field type str  type string.
   * @param seName set the seName.
   */
  public void setSeName(String  seName) {
    this.seName = seName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of se.
   * @return seUuid
   */
  public String getSeUuid() {
    return seUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of se.
   * @param seUuid set the seUuid.
   */
  public void setSeUuid(String  seUuid) {
    this.seUuid = seUuid;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vs_name of obj type rmmodifynetworkseventdetails field type str  type array.
   * @return vsName
   */
  public List<String> getVsName() {
    return vsName;
  }

  /**
   * This is the setter method. this will set the vsName
   * Placeholder for description of property vs_name of obj type rmmodifynetworkseventdetails field type str  type array.
   * @return vsName
   */
  public void setVsName(List<String>  vsName) {
    this.vsName = vsName;
  }

  /**
   * This is the setter method this will set the vsName
   * Placeholder for description of property vs_name of obj type rmmodifynetworkseventdetails field type str  type array.
   * @return vsName
   */
  public RmModifyNetworksEventDetails addVsNameItem(String vsNameItem) {
    if (this.vsName == null) {
      this.vsName = new ArrayList<String>();
    }
    this.vsName.add(vsNameItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of vs.
   * @return vsUuid
   */
  public List<String> getVsUuid() {
    return vsUuid;
  }

  /**
   * This is the setter method. this will set the vsUuid
   * Unique object identifier of vs.
   * @return vsUuid
   */
  public void setVsUuid(List<String>  vsUuid) {
    this.vsUuid = vsUuid;
  }

  /**
   * This is the setter method this will set the vsUuid
   * Unique object identifier of vs.
   * @return vsUuid
   */
  public RmModifyNetworksEventDetails addVsUuidItem(String vsUuidItem) {
    if (this.vsUuid == null) {
      this.vsUuid = new ArrayList<String>();
    }
    this.vsUuid.add(vsUuidItem);
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
  RmModifyNetworksEventDetails objRmModifyNetworksEventDetails = (RmModifyNetworksEventDetails) o;
  return   Objects.equals(this.vsName, objRmModifyNetworksEventDetails.vsName)&&
  Objects.equals(this.vsUuid, objRmModifyNetworksEventDetails.vsUuid)&&
  Objects.equals(this.reason, objRmModifyNetworksEventDetails.reason)&&
  Objects.equals(this.seUuid, objRmModifyNetworksEventDetails.seUuid)&&
  Objects.equals(this.seName, objRmModifyNetworksEventDetails.seName)&&
  Objects.equals(this.networks, objRmModifyNetworksEventDetails.networks);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class RmModifyNetworksEventDetails {\n");
      sb.append("    networks: ").append(toIndentedString(networks)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    seName: ").append(toIndentedString(seName)).append("\n");
        sb.append("    seUuid: ").append(toIndentedString(seUuid)).append("\n");
        sb.append("    vsName: ").append(toIndentedString(vsName)).append("\n");
        sb.append("    vsUuid: ").append(toIndentedString(vsUuid)).append("\n");
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

