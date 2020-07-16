package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VsApicExtension is a POJO class extends AviRestResource that used for creating
 * VsApicExtension.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VsApicExtension extends AviRestResource  {
    @JsonProperty("se_uuid")
    private String seUuid = null;

    @JsonProperty("txn_uuid")
    private String txnUuid = null;

    @JsonProperty("uuid")
    private String uuid = null;

    @JsonProperty("vnic")
    private List<VsSeVnic> vnic = null;



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
   * Unique object identifier of txn.
   * @return txnUuid
   */
  public String getTxnUuid() {
    return txnUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of txn.
   * @param txnUuid set the txnUuid.
   */
  public void setTxnUuid(String  txnUuid) {
    this.txnUuid = txnUuid;
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
   * Placeholder for description of property vnic of obj type vsapicextension field type str  type array.
   * @return vnic
   */
  public List<VsSeVnic> getVnic() {
    return vnic;
  }

  /**
   * This is the setter method. this will set the vnic
   * Placeholder for description of property vnic of obj type vsapicextension field type str  type array.
   * @return vnic
   */
  public void setVnic(List<VsSeVnic>  vnic) {
    this.vnic = vnic;
  }

  /**
   * This is the setter method this will set the vnic
   * Placeholder for description of property vnic of obj type vsapicextension field type str  type array.
   * @return vnic
   */
  public VsApicExtension addVnicItem(VsSeVnic vnicItem) {
    if (this.vnic == null) {
      this.vnic = new ArrayList<VsSeVnic>();
    }
    this.vnic.add(vnicItem);
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
  VsApicExtension objVsApicExtension = (VsApicExtension) o;
  return   Objects.equals(this.txnUuid, objVsApicExtension.txnUuid)&&
  Objects.equals(this.vnic, objVsApicExtension.vnic)&&
  Objects.equals(this.uuid, objVsApicExtension.uuid)&&
  Objects.equals(this.seUuid, objVsApicExtension.seUuid);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VsApicExtension {\n");
      sb.append("    seUuid: ").append(toIndentedString(seUuid)).append("\n");
        sb.append("    txnUuid: ").append(toIndentedString(txnUuid)).append("\n");
        sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
        sb.append("    vnic: ").append(toIndentedString(vnic)).append("\n");
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

