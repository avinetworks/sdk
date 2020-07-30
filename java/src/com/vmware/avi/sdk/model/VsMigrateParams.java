package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VsMigrateParams is a POJO class extends AviRestResource that used for creating
 * VsMigrateParams.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VsMigrateParams extends AviRestResource  {
    @JsonProperty("from_se_ref")
    private String fromSeRef = null;

    @JsonProperty("new_vcpus")
    private Integer newVcpus = null;

    @JsonProperty("to_host_ref")
    private String toHostRef = null;

    @JsonProperty("to_new_se")
    private Boolean toNewSe = false;

    @JsonProperty("to_se_ref")
    private String toSeRef = null;

    @JsonProperty("uuid")
    private String uuid = null;

    @JsonProperty("vip_id")
    private String vipId = null;



  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type serviceengine.
   * @return fromSeRef
   */
  public String getFromSeRef() {
    return fromSeRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type serviceengine.
   * @param fromSeRef set the fromSeRef.
   */
  public void setFromSeRef(String  fromSeRef) {
    this.fromSeRef = fromSeRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property new_vcpus of obj type vsmigrateparams field type str  type integer.
   * @return newVcpus
   */
  public Integer getNewVcpus() {
    return newVcpus;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property new_vcpus of obj type vsmigrateparams field type str  type integer.
   * @param newVcpus set the newVcpus.
   */
  public void setNewVcpus(Integer  newVcpus) {
    this.newVcpus = newVcpus;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type vimgrhostruntime.
   * @return toHostRef
   */
  public String getToHostRef() {
    return toHostRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type vimgrhostruntime.
   * @param toHostRef set the toHostRef.
   */
  public void setToHostRef(String  toHostRef) {
    this.toHostRef = toHostRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property to_new_se of obj type vsmigrateparams field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return toNewSe
   */
  public Boolean getToNewSe() {
    return toNewSe;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property to_new_se of obj type vsmigrateparams field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param toNewSe set the toNewSe.
   */
  public void setToNewSe(Boolean  toNewSe) {
    this.toNewSe = toNewSe;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type serviceengine.
   * @return toSeRef
   */
  public String getToSeRef() {
    return toSeRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type serviceengine.
   * @param toSeRef set the toSeRef.
   */
  public void setToSeRef(String  toSeRef) {
    this.toSeRef = toSeRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of the object.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of the object.
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


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VsMigrateParams objVsMigrateParams = (VsMigrateParams) o;
  return   Objects.equals(this.uuid, objVsMigrateParams.uuid)&&
  Objects.equals(this.fromSeRef, objVsMigrateParams.fromSeRef)&&
  Objects.equals(this.toSeRef, objVsMigrateParams.toSeRef)&&
  Objects.equals(this.toNewSe, objVsMigrateParams.toNewSe)&&
  Objects.equals(this.toHostRef, objVsMigrateParams.toHostRef)&&
  Objects.equals(this.newVcpus, objVsMigrateParams.newVcpus)&&
  Objects.equals(this.vipId, objVsMigrateParams.vipId);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VsMigrateParams {\n");
      sb.append("    fromSeRef: ").append(toIndentedString(fromSeRef)).append("\n");
        sb.append("    newVcpus: ").append(toIndentedString(newVcpus)).append("\n");
        sb.append("    toHostRef: ").append(toIndentedString(toHostRef)).append("\n");
        sb.append("    toNewSe: ").append(toIndentedString(toNewSe)).append("\n");
        sb.append("    toSeRef: ").append(toIndentedString(toSeRef)).append("\n");
        sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
        sb.append("    vipId: ").append(toIndentedString(vipId)).append("\n");
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

