package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The GslbDnsUpdate is a POJO class extends AviRestResource that used for creating
 * GslbDnsUpdate.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GslbDnsUpdate extends AviRestResource  {
    @JsonProperty("clear_on_max_retries")
    private Integer clearOnMaxRetries = null;

    @JsonProperty("gslb_geo_db_profile_uuids")
    private List<String> gslbGeoDbProfileUuids = null;

    @JsonProperty("gslb_service_uuids")
    private List<String> gslbServiceUuids = null;

    @JsonProperty("gslb_uuids")
    private List<String> gslbUuids = null;

    @JsonProperty("obj_info")
    private List<GslbObjectInfo> objInfo = null;

    @JsonProperty("send_interval")
    private Integer sendInterval = null;

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property clear_on_max_retries of obj type gslbdnsupdate field type str  type integer.
   * @return clearOnMaxRetries
   */
  public Integer getClearOnMaxRetries() {
    return clearOnMaxRetries;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property clear_on_max_retries of obj type gslbdnsupdate field type str  type integer.
   * @param clearOnMaxRetries set the clearOnMaxRetries.
   */
  public void setClearOnMaxRetries(Integer  clearOnMaxRetries) {
    this.clearOnMaxRetries = clearOnMaxRetries;
  }
  /**
   * This is the getter method this will return the attribute value.
   * List of geo db profiles associated with this dns vs.
   * Field introduced in 18.2.3.
   * @return gslbGeoDbProfileUuids
   */
  public List<String> getGslbGeoDbProfileUuids() {
    return gslbGeoDbProfileUuids;
  }

  /**
   * This is the setter method. this will set the gslbGeoDbProfileUuids
   * List of geo db profiles associated with this dns vs.
   * Field introduced in 18.2.3.
   * @return gslbGeoDbProfileUuids
   */
  public void setGslbGeoDbProfileUuids(List<String>  gslbGeoDbProfileUuids) {
    this.gslbGeoDbProfileUuids = gslbGeoDbProfileUuids;
  }

  /**
   * This is the setter method this will set the gslbGeoDbProfileUuids
   * List of geo db profiles associated with this dns vs.
   * Field introduced in 18.2.3.
   * @return gslbGeoDbProfileUuids
   */
  public GslbDnsUpdate addGslbGeoDbProfileUuidsItem(String gslbGeoDbProfileUuidsItem) {
    if (this.gslbGeoDbProfileUuids == null) {
      this.gslbGeoDbProfileUuids = new ArrayList<String>();
    }
    this.gslbGeoDbProfileUuids.add(gslbGeoDbProfileUuidsItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * List of gslb services associated with the dns vs.
   * Field introduced in 18.2.3.
   * @return gslbServiceUuids
   */
  public List<String> getGslbServiceUuids() {
    return gslbServiceUuids;
  }

  /**
   * This is the setter method. this will set the gslbServiceUuids
   * List of gslb services associated with the dns vs.
   * Field introduced in 18.2.3.
   * @return gslbServiceUuids
   */
  public void setGslbServiceUuids(List<String>  gslbServiceUuids) {
    this.gslbServiceUuids = gslbServiceUuids;
  }

  /**
   * This is the setter method this will set the gslbServiceUuids
   * List of gslb services associated with the dns vs.
   * Field introduced in 18.2.3.
   * @return gslbServiceUuids
   */
  public GslbDnsUpdate addGslbServiceUuidsItem(String gslbServiceUuidsItem) {
    if (this.gslbServiceUuids == null) {
      this.gslbServiceUuids = new ArrayList<String>();
    }
    this.gslbServiceUuids.add(gslbServiceUuidsItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Gslb object associated with the dns vs.
   * Field introduced in 18.2.3.
   * @return gslbUuids
   */
  public List<String> getGslbUuids() {
    return gslbUuids;
  }

  /**
   * This is the setter method. this will set the gslbUuids
   * Gslb object associated with the dns vs.
   * Field introduced in 18.2.3.
   * @return gslbUuids
   */
  public void setGslbUuids(List<String>  gslbUuids) {
    this.gslbUuids = gslbUuids;
  }

  /**
   * This is the setter method this will set the gslbUuids
   * Gslb object associated with the dns vs.
   * Field introduced in 18.2.3.
   * @return gslbUuids
   */
  public GslbDnsUpdate addGslbUuidsItem(String gslbUuidsItem) {
    if (this.gslbUuids == null) {
      this.gslbUuids = new ArrayList<String>();
    }
    this.gslbUuids.add(gslbUuidsItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Gslb, gslbservice objects that is pushed on a per dns basis.
   * Field introduced in 17.1.1.
   * @return objInfo
   */
  public List<GslbObjectInfo> getObjInfo() {
    return objInfo;
  }

  /**
   * This is the setter method. this will set the objInfo
   * Gslb, gslbservice objects that is pushed on a per dns basis.
   * Field introduced in 17.1.1.
   * @return objInfo
   */
  public void setObjInfo(List<GslbObjectInfo>  objInfo) {
    this.objInfo = objInfo;
  }

  /**
   * This is the setter method this will set the objInfo
   * Gslb, gslbservice objects that is pushed on a per dns basis.
   * Field introduced in 17.1.1.
   * @return objInfo
   */
  public GslbDnsUpdate addObjInfoItem(GslbObjectInfo objInfoItem) {
    if (this.objInfo == null) {
      this.objInfo = new ArrayList<GslbObjectInfo>();
    }
    this.objInfo.add(objInfoItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property send_interval of obj type gslbdnsupdate field type str  type integer.
   * @return sendInterval
   */
  public Integer getSendInterval() {
    return sendInterval;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property send_interval of obj type gslbdnsupdate field type str  type integer.
   * @param sendInterval set the sendInterval.
   */
  public void setSendInterval(Integer  sendInterval) {
    this.sendInterval = sendInterval;
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


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  GslbDnsUpdate objGslbDnsUpdate = (GslbDnsUpdate) o;
  return   Objects.equals(this.uuid, objGslbDnsUpdate.uuid)&&
  Objects.equals(this.gslbServiceUuids, objGslbDnsUpdate.gslbServiceUuids)&&
  Objects.equals(this.gslbGeoDbProfileUuids, objGslbDnsUpdate.gslbGeoDbProfileUuids)&&
  Objects.equals(this.objInfo, objGslbDnsUpdate.objInfo)&&
  Objects.equals(this.sendInterval, objGslbDnsUpdate.sendInterval)&&
  Objects.equals(this.gslbUuids, objGslbDnsUpdate.gslbUuids)&&
  Objects.equals(this.clearOnMaxRetries, objGslbDnsUpdate.clearOnMaxRetries);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class GslbDnsUpdate {\n");
      sb.append("    clearOnMaxRetries: ").append(toIndentedString(clearOnMaxRetries)).append("\n");
        sb.append("    gslbGeoDbProfileUuids: ").append(toIndentedString(gslbGeoDbProfileUuids)).append("\n");
        sb.append("    gslbServiceUuids: ").append(toIndentedString(gslbServiceUuids)).append("\n");
        sb.append("    gslbUuids: ").append(toIndentedString(gslbUuids)).append("\n");
        sb.append("    objInfo: ").append(toIndentedString(objInfo)).append("\n");
        sb.append("    sendInterval: ").append(toIndentedString(sendInterval)).append("\n");
        sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
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

