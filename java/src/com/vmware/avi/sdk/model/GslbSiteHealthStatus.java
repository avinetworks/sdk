package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The GslbSiteHealthStatus is a POJO class extends AviRestResource that used for creating
 * GslbSiteHealthStatus.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GslbSiteHealthStatus  {
    @JsonProperty("controller_gsinfo")
    private List<GslbPoolMemberRuntimeInfo> controllerGsinfo = null;

    @JsonProperty("datapath_gsinfo")
    private List<GslbPoolMemberRuntimeInfo> datapathGsinfo = null;

    @JsonProperty("dns_info")
    private GslbDnsInfo dnsInfo = null;

    @JsonProperty("gap_table")
    private List<CfgState> gapTable = null;

    @JsonProperty("geo_table")
    private List<CfgState> geoTable = null;

    @JsonProperty("ghm_table")
    private List<CfgState> ghmTable = null;

    @JsonProperty("glb_table")
    private List<CfgState> glbTable = null;

    @JsonProperty("gs_table")
    private List<CfgState> gsTable = null;

    @JsonProperty("sw_version")
    private String swVersion = null;

    @JsonProperty("timestamp")
    private Float timestamp = null;


  /**
   * This is the getter method this will return the attribute value.
   * Controller retrieved gslb service operational info based of virtual service state.
   * @return controllerGsinfo
   */
  public List<GslbPoolMemberRuntimeInfo> getControllerGsinfo() {
    return controllerGsinfo;
  }

  /**
   * This is the setter method. this will set the controllerGsinfo
   * Controller retrieved gslb service operational info based of virtual service state.
   * @return controllerGsinfo
   */
  public void setControllerGsinfo(List<GslbPoolMemberRuntimeInfo>  controllerGsinfo) {
    this.controllerGsinfo = controllerGsinfo;
  }

  /**
   * This is the setter method this will set the controllerGsinfo
   * Controller retrieved gslb service operational info based of virtual service state.
   * @return controllerGsinfo
   */
  public GslbSiteHealthStatus addControllerGsinfoItem(GslbPoolMemberRuntimeInfo controllerGsinfoItem) {
    if (this.controllerGsinfo == null) {
      this.controllerGsinfo = new ArrayList<GslbPoolMemberRuntimeInfo>();
    }
    this.controllerGsinfo.add(controllerGsinfoItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Controller retrieved gslb service operational info based of dns datapath resolution.
   * This information is generated only on those sites that have dns-vs participating in gslb.
   * @return datapathGsinfo
   */
  public List<GslbPoolMemberRuntimeInfo> getDatapathGsinfo() {
    return datapathGsinfo;
  }

  /**
   * This is the setter method. this will set the datapathGsinfo
   * Controller retrieved gslb service operational info based of dns datapath resolution.
   * This information is generated only on those sites that have dns-vs participating in gslb.
   * @return datapathGsinfo
   */
  public void setDatapathGsinfo(List<GslbPoolMemberRuntimeInfo>  datapathGsinfo) {
    this.datapathGsinfo = datapathGsinfo;
  }

  /**
   * This is the setter method this will set the datapathGsinfo
   * Controller retrieved gslb service operational info based of dns datapath resolution.
   * This information is generated only on those sites that have dns-vs participating in gslb.
   * @return datapathGsinfo
   */
  public GslbSiteHealthStatus addDatapathGsinfoItem(GslbPoolMemberRuntimeInfo datapathGsinfoItem) {
    if (this.datapathGsinfo == null) {
      this.datapathGsinfo = new ArrayList<GslbPoolMemberRuntimeInfo>();
    }
    this.datapathGsinfo.add(datapathGsinfoItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dns info at the site.
   * @return dnsInfo
   */
  public GslbDnsInfo getDnsInfo() {
    return dnsInfo;
  }

  /**
   * This is the setter method to the attribute.
   * Dns info at the site.
   * @param dnsInfo set the dnsInfo.
   */
  public void setDnsInfo(GslbDnsInfo dnsInfo) {
    this.dnsInfo = dnsInfo;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Gslb application persistence profile state at member.
   * Field introduced in 17.1.1.
   * @return gapTable
   */
  public List<CfgState> getGapTable() {
    return gapTable;
  }

  /**
   * This is the setter method. this will set the gapTable
   * Gslb application persistence profile state at member.
   * Field introduced in 17.1.1.
   * @return gapTable
   */
  public void setGapTable(List<CfgState>  gapTable) {
    this.gapTable = gapTable;
  }

  /**
   * This is the setter method this will set the gapTable
   * Gslb application persistence profile state at member.
   * Field introduced in 17.1.1.
   * @return gapTable
   */
  public GslbSiteHealthStatus addGapTableItem(CfgState gapTableItem) {
    if (this.gapTable == null) {
      this.gapTable = new ArrayList<CfgState>();
    }
    this.gapTable.add(gapTableItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Gslb geo db profile state at member.
   * Field introduced in 17.1.1.
   * @return geoTable
   */
  public List<CfgState> getGeoTable() {
    return geoTable;
  }

  /**
   * This is the setter method. this will set the geoTable
   * Gslb geo db profile state at member.
   * Field introduced in 17.1.1.
   * @return geoTable
   */
  public void setGeoTable(List<CfgState>  geoTable) {
    this.geoTable = geoTable;
  }

  /**
   * This is the setter method this will set the geoTable
   * Gslb geo db profile state at member.
   * Field introduced in 17.1.1.
   * @return geoTable
   */
  public GslbSiteHealthStatus addGeoTableItem(CfgState geoTableItem) {
    if (this.geoTable == null) {
      this.geoTable = new ArrayList<CfgState>();
    }
    this.geoTable.add(geoTableItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Gslb health monitor state at member.
   * @return ghmTable
   */
  public List<CfgState> getGhmTable() {
    return ghmTable;
  }

  /**
   * This is the setter method. this will set the ghmTable
   * Gslb health monitor state at member.
   * @return ghmTable
   */
  public void setGhmTable(List<CfgState>  ghmTable) {
    this.ghmTable = ghmTable;
  }

  /**
   * This is the setter method this will set the ghmTable
   * Gslb health monitor state at member.
   * @return ghmTable
   */
  public GslbSiteHealthStatus addGhmTableItem(CfgState ghmTableItem) {
    if (this.ghmTable == null) {
      this.ghmTable = new ArrayList<CfgState>();
    }
    this.ghmTable.add(ghmTableItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Gslb state at member.
   * @return glbTable
   */
  public List<CfgState> getGlbTable() {
    return glbTable;
  }

  /**
   * This is the setter method. this will set the glbTable
   * Gslb state at member.
   * @return glbTable
   */
  public void setGlbTable(List<CfgState>  glbTable) {
    this.glbTable = glbTable;
  }

  /**
   * This is the setter method this will set the glbTable
   * Gslb state at member.
   * @return glbTable
   */
  public GslbSiteHealthStatus addGlbTableItem(CfgState glbTableItem) {
    if (this.glbTable == null) {
      this.glbTable = new ArrayList<CfgState>();
    }
    this.glbTable.add(glbTableItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Gslb service state at member.
   * @return gsTable
   */
  public List<CfgState> getGsTable() {
    return gsTable;
  }

  /**
   * This is the setter method. this will set the gsTable
   * Gslb service state at member.
   * @return gsTable
   */
  public void setGsTable(List<CfgState>  gsTable) {
    this.gsTable = gsTable;
  }

  /**
   * This is the setter method this will set the gsTable
   * Gslb service state at member.
   * @return gsTable
   */
  public GslbSiteHealthStatus addGsTableItem(CfgState gsTableItem) {
    if (this.gsTable == null) {
      this.gsTable = new ArrayList<CfgState>();
    }
    this.gsTable.add(gsTableItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Current software version of the site.
   * @return swVersion
   */
  public String getSwVersion() {
    return swVersion;
  }

  /**
   * This is the setter method to the attribute.
   * Current software version of the site.
   * @param swVersion set the swVersion.
   */
  public void setSwVersion(String  swVersion) {
    this.swVersion = swVersion;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Timestamp of health-status generation.
   * @return timestamp
   */
  public Float getTimestamp() {
    return timestamp;
  }

  /**
   * This is the setter method to the attribute.
   * Timestamp of health-status generation.
   * @param timestamp set the timestamp.
   */
  public void setTimestamp(Float  timestamp) {
    this.timestamp = timestamp;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  GslbSiteHealthStatus objGslbSiteHealthStatus = (GslbSiteHealthStatus) o;
  return   Objects.equals(this.datapathGsinfo, objGslbSiteHealthStatus.datapathGsinfo)&&
  Objects.equals(this.swVersion, objGslbSiteHealthStatus.swVersion)&&
  Objects.equals(this.timestamp, objGslbSiteHealthStatus.timestamp)&&
  Objects.equals(this.geoTable, objGslbSiteHealthStatus.geoTable)&&
  Objects.equals(this.dnsInfo, objGslbSiteHealthStatus.dnsInfo)&&
  Objects.equals(this.ghmTable, objGslbSiteHealthStatus.ghmTable)&&
  Objects.equals(this.gapTable, objGslbSiteHealthStatus.gapTable)&&
  Objects.equals(this.controllerGsinfo, objGslbSiteHealthStatus.controllerGsinfo)&&
  Objects.equals(this.glbTable, objGslbSiteHealthStatus.glbTable)&&
  Objects.equals(this.gsTable, objGslbSiteHealthStatus.gsTable);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class GslbSiteHealthStatus {\n");
      sb.append("    controllerGsinfo: ").append(toIndentedString(controllerGsinfo)).append("\n");
        sb.append("    datapathGsinfo: ").append(toIndentedString(datapathGsinfo)).append("\n");
        sb.append("    dnsInfo: ").append(toIndentedString(dnsInfo)).append("\n");
        sb.append("    gapTable: ").append(toIndentedString(gapTable)).append("\n");
        sb.append("    geoTable: ").append(toIndentedString(geoTable)).append("\n");
        sb.append("    ghmTable: ").append(toIndentedString(ghmTable)).append("\n");
        sb.append("    glbTable: ").append(toIndentedString(glbTable)).append("\n");
        sb.append("    gsTable: ").append(toIndentedString(gsTable)).append("\n");
        sb.append("    swVersion: ").append(toIndentedString(swVersion)).append("\n");
        sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
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

