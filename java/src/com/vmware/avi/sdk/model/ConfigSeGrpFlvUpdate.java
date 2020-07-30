package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ConfigSeGrpFlvUpdate is a POJO class extends AviRestResource that used for creating
 * ConfigSeGrpFlvUpdate.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConfigSeGrpFlvUpdate  {
    @JsonProperty("new_flv")
    private String newFlv = null;

    @JsonProperty("old_flv")
    private String oldFlv = null;

    @JsonProperty("se_group_name")
    private String seGroupName = null;

    @JsonProperty("se_group_uuid")
    private String seGroupUuid = null;

    @JsonProperty("tenant_name")
    private String tenantName = null;

    @JsonProperty("tenant_uuid")
    private String tenantUuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * New flavor name.
   * @return newFlv
   */
  public String getNewFlv() {
    return newFlv;
  }

  /**
   * This is the setter method to the attribute.
   * New flavor name.
   * @param newFlv set the newFlv.
   */
  public void setNewFlv(String  newFlv) {
    this.newFlv = newFlv;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Old flavor name.
   * @return oldFlv
   */
  public String getOldFlv() {
    return oldFlv;
  }

  /**
   * This is the setter method to the attribute.
   * Old flavor name.
   * @param oldFlv set the oldFlv.
   */
  public void setOldFlv(String  oldFlv) {
    this.oldFlv = oldFlv;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Se group name.
   * @return seGroupName
   */
  public String getSeGroupName() {
    return seGroupName;
  }

  /**
   * This is the setter method to the attribute.
   * Se group name.
   * @param seGroupName set the seGroupName.
   */
  public void setSeGroupName(String  seGroupName) {
    this.seGroupName = seGroupName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Se group uuid.
   * @return seGroupUuid
   */
  public String getSeGroupUuid() {
    return seGroupUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Se group uuid.
   * @param seGroupUuid set the seGroupUuid.
   */
  public void setSeGroupUuid(String  seGroupUuid) {
    this.seGroupUuid = seGroupUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Tenant name.
   * @return tenantName
   */
  public String getTenantName() {
    return tenantName;
  }

  /**
   * This is the setter method to the attribute.
   * Tenant name.
   * @param tenantName set the tenantName.
   */
  public void setTenantName(String  tenantName) {
    this.tenantName = tenantName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Tenant uuid.
   * @return tenantUuid
   */
  public String getTenantUuid() {
    return tenantUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Tenant uuid.
   * @param tenantUuid set the tenantUuid.
   */
  public void setTenantUuid(String  tenantUuid) {
    this.tenantUuid = tenantUuid;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ConfigSeGrpFlvUpdate objConfigSeGrpFlvUpdate = (ConfigSeGrpFlvUpdate) o;
  return   Objects.equals(this.seGroupUuid, objConfigSeGrpFlvUpdate.seGroupUuid)&&
  Objects.equals(this.seGroupName, objConfigSeGrpFlvUpdate.seGroupName)&&
  Objects.equals(this.oldFlv, objConfigSeGrpFlvUpdate.oldFlv)&&
  Objects.equals(this.newFlv, objConfigSeGrpFlvUpdate.newFlv)&&
  Objects.equals(this.tenantUuid, objConfigSeGrpFlvUpdate.tenantUuid)&&
  Objects.equals(this.tenantName, objConfigSeGrpFlvUpdate.tenantName);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ConfigSeGrpFlvUpdate {\n");
      sb.append("    newFlv: ").append(toIndentedString(newFlv)).append("\n");
        sb.append("    oldFlv: ").append(toIndentedString(oldFlv)).append("\n");
        sb.append("    seGroupName: ").append(toIndentedString(seGroupName)).append("\n");
        sb.append("    seGroupUuid: ").append(toIndentedString(seGroupUuid)).append("\n");
        sb.append("    tenantName: ").append(toIndentedString(tenantName)).append("\n");
        sb.append("    tenantUuid: ").append(toIndentedString(tenantUuid)).append("\n");
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

