package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The AzureMarketplace is a POJO class extends AviRestResource that used for creating
 * AzureMarketplace.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AzureMarketplace  {
    @JsonProperty("cc_id")
    private String ccId = null;

    @JsonProperty("offer")
    private String offer = null;

    @JsonProperty("publisher")
    private String publisher = null;

    @JsonProperty("reason")
    private String reason = null;

    @JsonProperty("resource_group")
    private String resourceGroup = null;

    @JsonProperty("skus")
    private List<String> skus = null;

    @JsonProperty("status")
    private String status = null;

    @JsonProperty("subscription_id")
    private String subscriptionId = null;

    @JsonProperty("vnet_id")
    private String vnetId = null;



  /**
   * This is the getter method this will return the attribute value.
   * Azure cloud id.
   * Field introduced in 18.2.2.
   * @return ccId
   */
  public String getCcId() {
    return ccId;
  }

  /**
   * This is the setter method to the attribute.
   * Azure cloud id.
   * Field introduced in 18.2.2.
   * @param ccId set the ccId.
   */
  public void setCcId(String  ccId) {
    this.ccId = ccId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Avi azure marketplace offer name.
   * Field introduced in 18.2.2.
   * @return offer
   */
  public String getOffer() {
    return offer;
  }

  /**
   * This is the setter method to the attribute.
   * Avi azure marketplace offer name.
   * Field introduced in 18.2.2.
   * @param offer set the offer.
   */
  public void setOffer(String  offer) {
    this.offer = offer;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Avi azure marketplace publisher name.
   * Field introduced in 18.2.2.
   * @return publisher
   */
  public String getPublisher() {
    return publisher;
  }

  /**
   * This is the setter method to the attribute.
   * Avi azure marketplace publisher name.
   * Field introduced in 18.2.2.
   * @param publisher set the publisher.
   */
  public void setPublisher(String  publisher) {
    this.publisher = publisher;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Azure marketplace license term failure status.
   * Field introduced in 18.2.2.
   * @return reason
   */
  public String getReason() {
    return reason;
  }

  /**
   * This is the setter method to the attribute.
   * Azure marketplace license term failure status.
   * Field introduced in 18.2.2.
   * @param reason set the reason.
   */
  public void setReason(String  reason) {
    this.reason = reason;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Azure resource group name.
   * Field introduced in 18.2.2.
   * @return resourceGroup
   */
  public String getResourceGroup() {
    return resourceGroup;
  }

  /**
   * This is the setter method to the attribute.
   * Azure resource group name.
   * Field introduced in 18.2.2.
   * @param resourceGroup set the resourceGroup.
   */
  public void setResourceGroup(String  resourceGroup) {
    this.resourceGroup = resourceGroup;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Avi azure marketplace skus list.
   * Field introduced in 18.2.2.
   * @return skus
   */
  public List<String> getSkus() {
    return skus;
  }

  /**
   * This is the setter method. this will set the skus
   * Avi azure marketplace skus list.
   * Field introduced in 18.2.2.
   * @return skus
   */
  public void setSkus(List<String>  skus) {
    this.skus = skus;
  }

  /**
   * This is the setter method this will set the skus
   * Avi azure marketplace skus list.
   * Field introduced in 18.2.2.
   * @return skus
   */
  public AzureMarketplace addSkusItem(String skusItem) {
    if (this.skus == null) {
      this.skus = new ArrayList<String>();
    }
    this.skus.add(skusItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Azure marketplace license term acceptance status.
   * Field introduced in 18.2.2.
   * @return status
   */
  public String getStatus() {
    return status;
  }

  /**
   * This is the setter method to the attribute.
   * Azure marketplace license term acceptance status.
   * Field introduced in 18.2.2.
   * @param status set the status.
   */
  public void setStatus(String  status) {
    this.status = status;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Azure subscription id.
   * Field introduced in 18.2.2.
   * @return subscriptionId
   */
  public String getSubscriptionId() {
    return subscriptionId;
  }

  /**
   * This is the setter method to the attribute.
   * Azure subscription id.
   * Field introduced in 18.2.2.
   * @param subscriptionId set the subscriptionId.
   */
  public void setSubscriptionId(String  subscriptionId) {
    this.subscriptionId = subscriptionId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Azure vnet id.
   * Field introduced in 18.2.2.
   * @return vnetId
   */
  public String getVnetId() {
    return vnetId;
  }

  /**
   * This is the setter method to the attribute.
   * Azure vnet id.
   * Field introduced in 18.2.2.
   * @param vnetId set the vnetId.
   */
  public void setVnetId(String  vnetId) {
    this.vnetId = vnetId;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  AzureMarketplace objAzureMarketplace = (AzureMarketplace) o;
  return   Objects.equals(this.status, objAzureMarketplace.status)&&
  Objects.equals(this.publisher, objAzureMarketplace.publisher)&&
  Objects.equals(this.resourceGroup, objAzureMarketplace.resourceGroup)&&
  Objects.equals(this.offer, objAzureMarketplace.offer)&&
  Objects.equals(this.reason, objAzureMarketplace.reason)&&
  Objects.equals(this.vnetId, objAzureMarketplace.vnetId)&&
  Objects.equals(this.subscriptionId, objAzureMarketplace.subscriptionId)&&
  Objects.equals(this.skus, objAzureMarketplace.skus)&&
  Objects.equals(this.ccId, objAzureMarketplace.ccId);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class AzureMarketplace {\n");
      sb.append("    ccId: ").append(toIndentedString(ccId)).append("\n");
        sb.append("    offer: ").append(toIndentedString(offer)).append("\n");
        sb.append("    publisher: ").append(toIndentedString(publisher)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    resourceGroup: ").append(toIndentedString(resourceGroup)).append("\n");
        sb.append("    skus: ").append(toIndentedString(skus)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    subscriptionId: ").append(toIndentedString(subscriptionId)).append("\n");
        sb.append("    vnetId: ").append(toIndentedString(vnetId)).append("\n");
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

