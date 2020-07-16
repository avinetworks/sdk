package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The LicenseLedgerDetails is a POJO class extends AviRestResource that used for creating
 * LicenseLedgerDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LicenseLedgerDetails extends AviRestResource  {
    @JsonProperty("escrow_infos")
    private List<LicenseInfo> escrowInfos = null;

    @JsonProperty("se_infos")
    private List<LicenseInfo> seInfos = null;

    @JsonProperty("tier_usages")
    private List<LicenseTierUsage> tierUsages = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;


  /**
   * This is the getter method this will return the attribute value.
   * Maintain information about reservation against cookie.
   * Field introduced in 20.1.1.
   * @return escrowInfos
   */
  public List<LicenseInfo> getEscrowInfos() {
    return escrowInfos;
  }

  /**
   * This is the setter method. this will set the escrowInfos
   * Maintain information about reservation against cookie.
   * Field introduced in 20.1.1.
   * @return escrowInfos
   */
  public void setEscrowInfos(List<LicenseInfo>  escrowInfos) {
    this.escrowInfos = escrowInfos;
  }

  /**
   * This is the setter method this will set the escrowInfos
   * Maintain information about reservation against cookie.
   * Field introduced in 20.1.1.
   * @return escrowInfos
   */
  public LicenseLedgerDetails addEscrowInfosItem(LicenseInfo escrowInfosItem) {
    if (this.escrowInfos == null) {
      this.escrowInfos = new ArrayList<LicenseInfo>();
    }
    this.escrowInfos.add(escrowInfosItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Maintain information about consumed licenses against se_uuid.
   * Field introduced in 20.1.1.
   * @return seInfos
   */
  public List<LicenseInfo> getSeInfos() {
    return seInfos;
  }

  /**
   * This is the setter method. this will set the seInfos
   * Maintain information about consumed licenses against se_uuid.
   * Field introduced in 20.1.1.
   * @return seInfos
   */
  public void setSeInfos(List<LicenseInfo>  seInfos) {
    this.seInfos = seInfos;
  }

  /**
   * This is the setter method this will set the seInfos
   * Maintain information about consumed licenses against se_uuid.
   * Field introduced in 20.1.1.
   * @return seInfos
   */
  public LicenseLedgerDetails addSeInfosItem(LicenseInfo seInfosItem) {
    if (this.seInfos == null) {
      this.seInfos = new ArrayList<LicenseInfo>();
    }
    this.seInfos.add(seInfosItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * License usage per tier.
   * Field introduced in 20.1.1.
   * @return tierUsages
   */
  public List<LicenseTierUsage> getTierUsages() {
    return tierUsages;
  }

  /**
   * This is the setter method. this will set the tierUsages
   * License usage per tier.
   * Field introduced in 20.1.1.
   * @return tierUsages
   */
  public void setTierUsages(List<LicenseTierUsage>  tierUsages) {
    this.tierUsages = tierUsages;
  }

  /**
   * This is the setter method this will set the tierUsages
   * License usage per tier.
   * Field introduced in 20.1.1.
   * @return tierUsages
   */
  public LicenseLedgerDetails addTierUsagesItem(LicenseTierUsage tierUsagesItem) {
    if (this.tierUsages == null) {
      this.tierUsages = new ArrayList<LicenseTierUsage>();
    }
    this.tierUsages.add(tierUsagesItem);
    return this;
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
   * Uuid for reference.
   * Field introduced in 20.1.1.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid for reference.
   * Field introduced in 20.1.1.
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
  LicenseLedgerDetails objLicenseLedgerDetails = (LicenseLedgerDetails) o;
  return   Objects.equals(this.seInfos, objLicenseLedgerDetails.seInfos)&&
  Objects.equals(this.tierUsages, objLicenseLedgerDetails.tierUsages)&&
  Objects.equals(this.uuid, objLicenseLedgerDetails.uuid)&&
  Objects.equals(this.escrowInfos, objLicenseLedgerDetails.escrowInfos);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class LicenseLedgerDetails {\n");
      sb.append("    escrowInfos: ").append(toIndentedString(escrowInfos)).append("\n");
        sb.append("    seInfos: ").append(toIndentedString(seInfos)).append("\n");
        sb.append("    tierUsages: ").append(toIndentedString(tierUsages)).append("\n");
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

