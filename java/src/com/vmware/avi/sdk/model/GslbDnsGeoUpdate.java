package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The GslbDnsGeoUpdate is a POJO class extends AviRestResource that used for creating
 * GslbDnsGeoUpdate.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GslbDnsGeoUpdate  {
    @JsonProperty("obj_info")
    private List<GslbObjectInfo> objInfo = null;

    @JsonProperty("ops")
    private String ops = null;

    @JsonProperty("se_list")
    private List<String> seList = null;


  /**
   * This is the getter method this will return the attribute value.
   * Gslbgeodbprofile object that is pushed on on a per dns basis.
   * Field deprecated in 18.1.5, 18.2.1.
   * Field introduced in 17.1.1.
   * @return objInfo
   */
  public List<GslbObjectInfo> getObjInfo() {
    return objInfo;
  }

  /**
   * This is the setter method. this will set the objInfo
   * Gslbgeodbprofile object that is pushed on on a per dns basis.
   * Field deprecated in 18.1.5, 18.2.1.
   * Field introduced in 17.1.1.
   * @return objInfo
   */
  public void setObjInfo(List<GslbObjectInfo>  objInfo) {
    this.objInfo = objInfo;
  }

  /**
   * This is the setter method this will set the objInfo
   * Gslbgeodbprofile object that is pushed on on a per dns basis.
   * Field deprecated in 18.1.5, 18.2.1.
   * Field introduced in 17.1.1.
   * @return objInfo
   */
  public GslbDnsGeoUpdate addObjInfoItem(GslbObjectInfo objInfoItem) {
    if (this.objInfo == null) {
      this.objInfo = new ArrayList<GslbObjectInfo>();
    }
    this.objInfo.add(objInfoItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - GSLB_NONE, GSLB_CREATE, GSLB_UPDATE, GSLB_DELETE, GSLB_PURGE, GSLB_DECL.
   * Field deprecated in 18.1.5, 18.2.1.
   * Field introduced in 17.1.1.
   * @return ops
   */
  public String getOps() {
    return ops;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - GSLB_NONE, GSLB_CREATE, GSLB_UPDATE, GSLB_DELETE, GSLB_PURGE, GSLB_DECL.
   * Field deprecated in 18.1.5, 18.2.1.
   * Field introduced in 17.1.1.
   * @param ops set the ops.
   */
  public void setOps(String  ops) {
    this.ops = ops;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Field deprecated in 18.1.5, 18.2.1.
   * Field introduced in 17.1.1.
   * @return seList
   */
  public List<String> getSeList() {
    return seList;
  }

  /**
   * This is the setter method. this will set the seList
   * Field deprecated in 18.1.5, 18.2.1.
   * Field introduced in 17.1.1.
   * @return seList
   */
  public void setSeList(List<String>  seList) {
    this.seList = seList;
  }

  /**
   * This is the setter method this will set the seList
   * Field deprecated in 18.1.5, 18.2.1.
   * Field introduced in 17.1.1.
   * @return seList
   */
  public GslbDnsGeoUpdate addSeListItem(String seListItem) {
    if (this.seList == null) {
      this.seList = new ArrayList<String>();
    }
    this.seList.add(seListItem);
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
  GslbDnsGeoUpdate objGslbDnsGeoUpdate = (GslbDnsGeoUpdate) o;
  return   Objects.equals(this.ops, objGslbDnsGeoUpdate.ops)&&
  Objects.equals(this.seList, objGslbDnsGeoUpdate.seList)&&
  Objects.equals(this.objInfo, objGslbDnsGeoUpdate.objInfo);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class GslbDnsGeoUpdate {\n");
      sb.append("    objInfo: ").append(toIndentedString(objInfo)).append("\n");
        sb.append("    ops: ").append(toIndentedString(ops)).append("\n");
        sb.append("    seList: ").append(toIndentedString(seList)).append("\n");
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

