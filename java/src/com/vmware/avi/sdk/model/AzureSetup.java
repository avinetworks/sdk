package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The AzureSetup is a POJO class extends AviRestResource that used for creating
 * AzureSetup.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AzureSetup  {
    @JsonProperty("alb_id")
    private String albId = null;

    @JsonProperty("cc_id")
    private String ccId = null;

    @JsonProperty("nic_id")
    private String nicId = null;

    @JsonProperty("reason")
    private String reason = null;

    @JsonProperty("resource_group")
    private String resourceGroup = null;

    @JsonProperty("status")
    private String status = null;

    @JsonProperty("subscription_id")
    private String subscriptionId = null;

    @JsonProperty("vips")
    private List<IpAddr> vips = null;

    @JsonProperty("vnet_id")
    private String vnetId = null;

    @JsonProperty("vs_uuids")
    private List<String> vsUuids = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property alb_id of obj type azuresetup field type str  type string.
   * @return albId
   */
  public String getAlbId() {
    return albId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property alb_id of obj type azuresetup field type str  type string.
   * @param albId set the albId.
   */
  public void setAlbId(String  albId) {
    this.albId = albId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cc_id of obj type azuresetup field type str  type string.
   * @return ccId
   */
  public String getCcId() {
    return ccId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cc_id of obj type azuresetup field type str  type string.
   * @param ccId set the ccId.
   */
  public void setCcId(String  ccId) {
    this.ccId = ccId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property nic_id of obj type azuresetup field type str  type string.
   * @return nicId
   */
  public String getNicId() {
    return nicId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property nic_id of obj type azuresetup field type str  type string.
   * @param nicId set the nicId.
   */
  public void setNicId(String  nicId) {
    this.nicId = nicId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property reason of obj type azuresetup field type str  type string.
   * @return reason
   */
  public String getReason() {
    return reason;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property reason of obj type azuresetup field type str  type string.
   * @param reason set the reason.
   */
  public void setReason(String  reason) {
    this.reason = reason;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property resource_group of obj type azuresetup field type str  type string.
   * @return resourceGroup
   */
  public String getResourceGroup() {
    return resourceGroup;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property resource_group of obj type azuresetup field type str  type string.
   * @param resourceGroup set the resourceGroup.
   */
  public void setResourceGroup(String  resourceGroup) {
    this.resourceGroup = resourceGroup;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property status of obj type azuresetup field type str  type string.
   * @return status
   */
  public String getStatus() {
    return status;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property status of obj type azuresetup field type str  type string.
   * @param status set the status.
   */
  public void setStatus(String  status) {
    this.status = status;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property subscription_id of obj type azuresetup field type str  type string.
   * @return subscriptionId
   */
  public String getSubscriptionId() {
    return subscriptionId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property subscription_id of obj type azuresetup field type str  type string.
   * @param subscriptionId set the subscriptionId.
   */
  public void setSubscriptionId(String  subscriptionId) {
    this.subscriptionId = subscriptionId;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vips of obj type azuresetup field type str  type array.
   * @return vips
   */
  public List<IpAddr> getVips() {
    return vips;
  }

  /**
   * This is the setter method. this will set the vips
   * Placeholder for description of property vips of obj type azuresetup field type str  type array.
   * @return vips
   */
  public void setVips(List<IpAddr>  vips) {
    this.vips = vips;
  }

  /**
   * This is the setter method this will set the vips
   * Placeholder for description of property vips of obj type azuresetup field type str  type array.
   * @return vips
   */
  public AzureSetup addVipsItem(IpAddr vipsItem) {
    if (this.vips == null) {
      this.vips = new ArrayList<IpAddr>();
    }
    this.vips.add(vipsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vnet_id of obj type azuresetup field type str  type string.
   * @return vnetId
   */
  public String getVnetId() {
    return vnetId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vnet_id of obj type azuresetup field type str  type string.
   * @param vnetId set the vnetId.
   */
  public void setVnetId(String  vnetId) {
    this.vnetId = vnetId;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifiers of vss.
   * @return vsUuids
   */
  public List<String> getVsUuids() {
    return vsUuids;
  }

  /**
   * This is the setter method. this will set the vsUuids
   * Unique object identifiers of vss.
   * @return vsUuids
   */
  public void setVsUuids(List<String>  vsUuids) {
    this.vsUuids = vsUuids;
  }

  /**
   * This is the setter method this will set the vsUuids
   * Unique object identifiers of vss.
   * @return vsUuids
   */
  public AzureSetup addVsUuidsItem(String vsUuidsItem) {
    if (this.vsUuids == null) {
      this.vsUuids = new ArrayList<String>();
    }
    this.vsUuids.add(vsUuidsItem);
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
  AzureSetup objAzureSetup = (AzureSetup) o;
  return   Objects.equals(this.status, objAzureSetup.status)&&
  Objects.equals(this.vips, objAzureSetup.vips)&&
  Objects.equals(this.resourceGroup, objAzureSetup.resourceGroup)&&
  Objects.equals(this.reason, objAzureSetup.reason)&&
  Objects.equals(this.vnetId, objAzureSetup.vnetId)&&
  Objects.equals(this.vsUuids, objAzureSetup.vsUuids)&&
  Objects.equals(this.subscriptionId, objAzureSetup.subscriptionId)&&
  Objects.equals(this.ccId, objAzureSetup.ccId)&&
  Objects.equals(this.nicId, objAzureSetup.nicId)&&
  Objects.equals(this.albId, objAzureSetup.albId);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class AzureSetup {\n");
      sb.append("    albId: ").append(toIndentedString(albId)).append("\n");
        sb.append("    ccId: ").append(toIndentedString(ccId)).append("\n");
        sb.append("    nicId: ").append(toIndentedString(nicId)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    resourceGroup: ").append(toIndentedString(resourceGroup)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    subscriptionId: ").append(toIndentedString(subscriptionId)).append("\n");
        sb.append("    vips: ").append(toIndentedString(vips)).append("\n");
        sb.append("    vnetId: ").append(toIndentedString(vnetId)).append("\n");
        sb.append("    vsUuids: ").append(toIndentedString(vsUuids)).append("\n");
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

