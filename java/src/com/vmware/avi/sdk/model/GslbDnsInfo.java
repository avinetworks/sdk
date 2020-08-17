package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The GslbDnsInfo is a POJO class extends AviRestResource that used for creating
 * GslbDnsInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GslbDnsInfo  {
    @JsonProperty("dns_active")
    private Boolean dnsActive = null;

    @JsonProperty("dns_vs_states")
    private List<GslbPerDnsState> dnsVsStates = null;

    @JsonProperty("gs_status")
    private GslbDnsGsStatus gsStatus = null;

    @JsonProperty("retry_count")
    private Integer retryCount = null;

    @JsonProperty("se_table")
    private List<GslbDnsSeInfo> seTable = null;



  /**
   * This is the getter method this will return the attribute value.
   * This field indicates that atleast one dns is active at the site.
   * @return dnsActive
   */
  public Boolean getDnsActive() {
    return dnsActive;
  }

  /**
   * This is the setter method to the attribute.
   * This field indicates that atleast one dns is active at the site.
   * @param dnsActive set the dnsActive.
   */
  public void setDnsActive(Boolean  dnsActive) {
    this.dnsActive = dnsActive;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property dns_vs_states of obj type gslbdnsinfo field type str  type array.
   * @return dnsVsStates
   */
  public List<GslbPerDnsState> getDnsVsStates() {
    return dnsVsStates;
  }

  /**
   * This is the setter method. this will set the dnsVsStates
   * Placeholder for description of property dns_vs_states of obj type gslbdnsinfo field type str  type array.
   * @return dnsVsStates
   */
  public void setDnsVsStates(List<GslbPerDnsState>  dnsVsStates) {
    this.dnsVsStates = dnsVsStates;
  }

  /**
   * This is the setter method this will set the dnsVsStates
   * Placeholder for description of property dns_vs_states of obj type gslbdnsinfo field type str  type array.
   * @return dnsVsStates
   */
  public GslbDnsInfo addDnsVsStatesItem(GslbPerDnsState dnsVsStatesItem) {
    if (this.dnsVsStates == null) {
      this.dnsVsStates = new ArrayList<GslbPerDnsState>();
    }
    this.dnsVsStates.add(dnsVsStatesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * This field encapsulates the gs-status edge-triggered framework.
   * Field introduced in 17.1.1.
   * @return gsStatus
   */
  public GslbDnsGsStatus getGsStatus() {
    return gsStatus;
  }

  /**
   * This is the setter method to the attribute.
   * This field encapsulates the gs-status edge-triggered framework.
   * Field introduced in 17.1.1.
   * @param gsStatus set the gsStatus.
   */
  public void setGsStatus(GslbDnsGsStatus gsStatus) {
    this.gsStatus = gsStatus;
  }

  /**
   * This is the getter method this will return the attribute value.
   * This field is used to track the retry attempts for se download errors.
   * Field introduced in 17.1.1.
   * @return retryCount
   */
  public Integer getRetryCount() {
    return retryCount;
  }

  /**
   * This is the setter method to the attribute.
   * This field is used to track the retry attempts for se download errors.
   * Field introduced in 17.1.1.
   * @param retryCount set the retryCount.
   */
  public void setRetryCount(Integer  retryCount) {
    this.retryCount = retryCount;
  }
  /**
   * This is the getter method this will return the attribute value.
   * This tables holds all the se-related info across all dns-vs(es).
   * Field deprecated in 18.2.3.
   * Field introduced in 17.1.1.
   * @return seTable
   */
  public List<GslbDnsSeInfo> getSeTable() {
    return seTable;
  }

  /**
   * This is the setter method. this will set the seTable
   * This tables holds all the se-related info across all dns-vs(es).
   * Field deprecated in 18.2.3.
   * Field introduced in 17.1.1.
   * @return seTable
   */
  public void setSeTable(List<GslbDnsSeInfo>  seTable) {
    this.seTable = seTable;
  }

  /**
   * This is the setter method this will set the seTable
   * This tables holds all the se-related info across all dns-vs(es).
   * Field deprecated in 18.2.3.
   * Field introduced in 17.1.1.
   * @return seTable
   */
  public GslbDnsInfo addSeTableItem(GslbDnsSeInfo seTableItem) {
    if (this.seTable == null) {
      this.seTable = new ArrayList<GslbDnsSeInfo>();
    }
    this.seTable.add(seTableItem);
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
  GslbDnsInfo objGslbDnsInfo = (GslbDnsInfo) o;
  return   Objects.equals(this.dnsActive, objGslbDnsInfo.dnsActive)&&
  Objects.equals(this.dnsVsStates, objGslbDnsInfo.dnsVsStates)&&
  Objects.equals(this.seTable, objGslbDnsInfo.seTable)&&
  Objects.equals(this.gsStatus, objGslbDnsInfo.gsStatus)&&
  Objects.equals(this.retryCount, objGslbDnsInfo.retryCount);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class GslbDnsInfo {\n");
      sb.append("    dnsActive: ").append(toIndentedString(dnsActive)).append("\n");
        sb.append("    dnsVsStates: ").append(toIndentedString(dnsVsStates)).append("\n");
        sb.append("    gsStatus: ").append(toIndentedString(gsStatus)).append("\n");
        sb.append("    retryCount: ").append(toIndentedString(retryCount)).append("\n");
        sb.append("    seTable: ").append(toIndentedString(seTable)).append("\n");
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

