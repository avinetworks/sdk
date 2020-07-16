package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SCVsStateInfo is a POJO class extends AviRestResource that used for creating
 * SCVsStateInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SCVsStateInfo extends AviRestResource  {
    @JsonProperty("oper_status")
    private OperationalStatus operStatus = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;

    @JsonProperty("vip_id")
    private String vipId = null;

    @JsonProperty("vs_id")
    private String vsId = null;



  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.1.1.
   * @return operStatus
   */
  public OperationalStatus getOperStatus() {
    return operStatus;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.1.1.
   * @param operStatus set the operStatus.
   */
  public void setOperStatus(OperationalStatus operStatus) {
    this.operStatus = operStatus;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type tenant.
   * Field introduced in 17.1.1.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type tenant.
   * Field introduced in 17.1.1.
   * @param tenantRef set the tenantRef.
   */
  public void setTenantRef(String  tenantRef) {
    this.tenantRef = tenantRef;
  }
/**
   * This is the getter method this will return the attribute value.
   * Avi controller URL of the object.
   * @return url
   */
  public String getUrl() {
    return url;
  }

  /**
   * This is the setter method. this will set the url
   * Avi controller URL of the object.
   * @return url
   */
  public void setUrl(String  url) {
    this.url = url;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.1.1.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.1.1.
   * @param uuid set the uuid.
   */
  public void setUuid(String  uuid) {
    this.uuid = uuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.1.1.
   * @return vipId
   */
  public String getVipId() {
    return vipId;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.1.1.
   * @param vipId set the vipId.
   */
  public void setVipId(String  vipId) {
    this.vipId = vipId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.1.1.
   * @return vsId
   */
  public String getVsId() {
    return vsId;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.1.1.
   * @param vsId set the vsId.
   */
  public void setVsId(String  vsId) {
    this.vsId = vsId;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SCVsStateInfo objSCVsStateInfo = (SCVsStateInfo) o;
  return   Objects.equals(this.uuid, objSCVsStateInfo.uuid)&&
  Objects.equals(this.vsId, objSCVsStateInfo.vsId)&&
  Objects.equals(this.operStatus, objSCVsStateInfo.operStatus)&&
  Objects.equals(this.tenantRef, objSCVsStateInfo.tenantRef)&&
  Objects.equals(this.vipId, objSCVsStateInfo.vipId);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SCVsStateInfo {\n");
      sb.append("    operStatus: ").append(toIndentedString(operStatus)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
            sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
        sb.append("    vipId: ").append(toIndentedString(vipId)).append("\n");
        sb.append("    vsId: ").append(toIndentedString(vsId)).append("\n");
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

