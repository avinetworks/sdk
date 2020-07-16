package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The GslbPerDnsState is a POJO class extends AviRestResource that used for creating
 * GslbPerDnsState.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GslbPerDnsState extends AviRestResource  {
    @JsonProperty("geo_download")
    private GslbDownloadStatus geoDownload = null;

    @JsonProperty("gslb_download")
    private GslbDownloadStatus gslbDownload = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("oper_status")
    private OperationalStatus operStatus = null;

    @JsonProperty("placement_rules")
    private List<GslbSubDomainPlacementRuntime> placementRules = null;

    @JsonProperty("se_list")
    private List<String> seList = null;

    @JsonProperty("uuid")
    private String uuid = null;

    @JsonProperty("valid_dns_vs")
    private Boolean validDnsVs = false;



  /**
   * This is the getter method this will return the attribute value.
   * This field describes the geodbprofile download status to the dns-vs.
   * Field introduced in 17.1.1.
   * @return geoDownload
   */
  public GslbDownloadStatus getGeoDownload() {
    return geoDownload;
  }

  /**
   * This is the setter method to the attribute.
   * This field describes the geodbprofile download status to the dns-vs.
   * Field introduced in 17.1.1.
   * @param geoDownload set the geoDownload.
   */
  public void setGeoDownload(GslbDownloadStatus geoDownload) {
    this.geoDownload = geoDownload;
  }

  /**
   * This is the getter method this will return the attribute value.
   * This field describes the gslb, gslbservice, healthmonitor download status to the dns-vs.
   * Field introduced in 17.1.1.
   * @return gslbDownload
   */
  public GslbDownloadStatus getGslbDownload() {
    return gslbDownload;
  }

  /**
   * This is the setter method to the attribute.
   * This field describes the gslb, gslbservice, healthmonitor download status to the dns-vs.
   * Field introduced in 17.1.1.
   * @param gslbDownload set the gslbDownload.
   */
  public void setGslbDownload(GslbDownloadStatus gslbDownload) {
    this.gslbDownload = gslbDownload;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Configured dns-vs-name at the site.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Configured dns-vs-name at the site.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property oper_status of obj type gslbperdnsstate field type str  type ref.
   * @return operStatus
   */
  public OperationalStatus getOperStatus() {
    return operStatus;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property oper_status of obj type gslbperdnsstate field type str  type ref.
   * @param operStatus set the operStatus.
   */
  public void setOperStatus(OperationalStatus operStatus) {
    this.operStatus = operStatus;
  }
  /**
   * This is the getter method this will return the attribute value.
   * This field describes the subdomain placement rules for this dns-vs.
   * Field introduced in 17.2.3.
   * @return placementRules
   */
  public List<GslbSubDomainPlacementRuntime> getPlacementRules() {
    return placementRules;
  }

  /**
   * This is the setter method. this will set the placementRules
   * This field describes the subdomain placement rules for this dns-vs.
   * Field introduced in 17.2.3.
   * @return placementRules
   */
  public void setPlacementRules(List<GslbSubDomainPlacementRuntime>  placementRules) {
    this.placementRules = placementRules;
  }

  /**
   * This is the setter method this will set the placementRules
   * This field describes the subdomain placement rules for this dns-vs.
   * Field introduced in 17.2.3.
   * @return placementRules
   */
  public GslbPerDnsState addPlacementRulesItem(GslbSubDomainPlacementRuntime placementRulesItem) {
    if (this.placementRules == null) {
      this.placementRules = new ArrayList<GslbSubDomainPlacementRuntime>();
    }
    this.placementRules.add(placementRulesItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * The service engines associated with the dns-vs.
   * Field introduced in 17.1.1.
   * @return seList
   */
  public List<String> getSeList() {
    return seList;
  }

  /**
   * This is the setter method. this will set the seList
   * The service engines associated with the dns-vs.
   * Field introduced in 17.1.1.
   * @return seList
   */
  public void setSeList(List<String>  seList) {
    this.seList = seList;
  }

  /**
   * This is the setter method this will set the seList
   * The service engines associated with the dns-vs.
   * Field introduced in 17.1.1.
   * @return seList
   */
  public GslbPerDnsState addSeListItem(String seListItem) {
    if (this.seList == null) {
      this.seList = new ArrayList<String>();
    }
    this.seList.add(seListItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Configured dns-vs-uuid at the site.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Configured dns-vs-uuid at the site.
   * @param uuid set the uuid.
   */
  public void setUuid(String  uuid) {
    this.uuid = uuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * This field indicates that the local vs is configured to be a dns service.
   * The services, network profile and application profile are configured in virtual service for dns operations.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return validDnsVs
   */
  public Boolean getValidDnsVs() {
    return validDnsVs;
  }

  /**
   * This is the setter method to the attribute.
   * This field indicates that the local vs is configured to be a dns service.
   * The services, network profile and application profile are configured in virtual service for dns operations.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param validDnsVs set the validDnsVs.
   */
  public void setValidDnsVs(Boolean  validDnsVs) {
    this.validDnsVs = validDnsVs;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  GslbPerDnsState objGslbPerDnsState = (GslbPerDnsState) o;
  return   Objects.equals(this.uuid, objGslbPerDnsState.uuid)&&
  Objects.equals(this.placementRules, objGslbPerDnsState.placementRules)&&
  Objects.equals(this.operStatus, objGslbPerDnsState.operStatus)&&
  Objects.equals(this.geoDownload, objGslbPerDnsState.geoDownload)&&
  Objects.equals(this.seList, objGslbPerDnsState.seList)&&
  Objects.equals(this.validDnsVs, objGslbPerDnsState.validDnsVs)&&
  Objects.equals(this.gslbDownload, objGslbPerDnsState.gslbDownload)&&
  Objects.equals(this.name, objGslbPerDnsState.name);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class GslbPerDnsState {\n");
      sb.append("    geoDownload: ").append(toIndentedString(geoDownload)).append("\n");
        sb.append("    gslbDownload: ").append(toIndentedString(gslbDownload)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    operStatus: ").append(toIndentedString(operStatus)).append("\n");
        sb.append("    placementRules: ").append(toIndentedString(placementRules)).append("\n");
        sb.append("    seList: ").append(toIndentedString(seList)).append("\n");
        sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
        sb.append("    validDnsVs: ").append(toIndentedString(validDnsVs)).append("\n");
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

