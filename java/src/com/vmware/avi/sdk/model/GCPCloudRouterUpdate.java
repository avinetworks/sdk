package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The GCPCloudRouterUpdate is a POJO class extends AviRestResource that used for creating
 * GCPCloudRouterUpdate.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GCPCloudRouterUpdate  {
    @JsonProperty("action")
    private String action = null;

    @JsonProperty("cc_id")
    private String ccId = null;

    @JsonProperty("error_string")
    private String errorString = null;

    @JsonProperty("fip")
    private IpAddr fip = null;

    @JsonProperty("router_url")
    private String routerUrl = null;

    @JsonProperty("vip")
    private IpAddr vip = null;

    @JsonProperty("vs_uuid")
    private String vsUuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Action performed  action can be either route added or route removed from router.
   * Field introduced in 18.2.5.
   * @return action
   */
  public String getAction() {
    return action;
  }

  /**
   * This is the setter method to the attribute.
   * Action performed  action can be either route added or route removed from router.
   * Field introduced in 18.2.5.
   * @param action set the action.
   */
  public void setAction(String  action) {
    this.action = action;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Cloud uuid.
   * Field introduced in 18.2.5.
   * @return ccId
   */
  public String getCcId() {
    return ccId;
  }

  /**
   * This is the setter method to the attribute.
   * Cloud uuid.
   * Field introduced in 18.2.5.
   * @param ccId set the ccId.
   */
  public void setCcId(String  ccId) {
    this.ccId = ccId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Reason for the failure.
   * Field introduced in 18.2.5.
   * @return errorString
   */
  public String getErrorString() {
    return errorString;
  }

  /**
   * This is the setter method to the attribute.
   * Reason for the failure.
   * Field introduced in 18.2.5.
   * @param errorString set the errorString.
   */
  public void setErrorString(String  errorString) {
    this.errorString = errorString;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Virtual service floating ip.
   * Field introduced in 18.2.5.
   * @return fip
   */
  public IpAddr getFip() {
    return fip;
  }

  /**
   * This is the setter method to the attribute.
   * Virtual service floating ip.
   * Field introduced in 18.2.5.
   * @param fip set the fip.
   */
  public void setFip(IpAddr fip) {
    this.fip = fip;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Gcp cloud router url.
   * Field introduced in 18.2.5.
   * @return routerUrl
   */
  public String getRouterUrl() {
    return routerUrl;
  }

  /**
   * This is the setter method to the attribute.
   * Gcp cloud router url.
   * Field introduced in 18.2.5.
   * @param routerUrl set the routerUrl.
   */
  public void setRouterUrl(String  routerUrl) {
    this.routerUrl = routerUrl;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Virtual service ip.
   * Field introduced in 18.2.5.
   * @return vip
   */
  public IpAddr getVip() {
    return vip;
  }

  /**
   * This is the setter method to the attribute.
   * Virtual service ip.
   * Field introduced in 18.2.5.
   * @param vip set the vip.
   */
  public void setVip(IpAddr vip) {
    this.vip = vip;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Virtual service uuid.
   * Field introduced in 18.2.5.
   * @return vsUuid
   */
  public String getVsUuid() {
    return vsUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Virtual service uuid.
   * Field introduced in 18.2.5.
   * @param vsUuid set the vsUuid.
   */
  public void setVsUuid(String  vsUuid) {
    this.vsUuid = vsUuid;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  GCPCloudRouterUpdate objGCPCloudRouterUpdate = (GCPCloudRouterUpdate) o;
  return   Objects.equals(this.fip, objGCPCloudRouterUpdate.fip)&&
  Objects.equals(this.errorString, objGCPCloudRouterUpdate.errorString)&&
  Objects.equals(this.routerUrl, objGCPCloudRouterUpdate.routerUrl)&&
  Objects.equals(this.vip, objGCPCloudRouterUpdate.vip)&&
  Objects.equals(this.vsUuid, objGCPCloudRouterUpdate.vsUuid)&&
  Objects.equals(this.action, objGCPCloudRouterUpdate.action)&&
  Objects.equals(this.ccId, objGCPCloudRouterUpdate.ccId);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class GCPCloudRouterUpdate {\n");
      sb.append("    action: ").append(toIndentedString(action)).append("\n");
        sb.append("    ccId: ").append(toIndentedString(ccId)).append("\n");
        sb.append("    errorString: ").append(toIndentedString(errorString)).append("\n");
        sb.append("    fip: ").append(toIndentedString(fip)).append("\n");
        sb.append("    routerUrl: ").append(toIndentedString(routerUrl)).append("\n");
        sb.append("    vip: ").append(toIndentedString(vip)).append("\n");
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

