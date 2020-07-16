package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DosAttackEventDetails is a POJO class extends AviRestResource that used for creating
 * DosAttackEventDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DosAttackEventDetails  {
    @JsonProperty("attack")
    private String attack = null;

    @JsonProperty("attack_count")
    private Float attackCount = null;

    @JsonProperty("ipgroup_uuids")
    private List<String> ipgroupUuids = null;

    @JsonProperty("meta_data")
    private List<AttackMetaData> metaData = null;

    @JsonProperty("src_ips")
    private List<String> srcIps = null;

    @JsonProperty("urls")
    private List<String> urls = null;



  /**
   * This is the getter method this will return the attribute value.
   * Enum options - LAND, SMURF, ICMP_PING_FLOOD, UNKOWN_PROTOCOL, TEARDROP, IP_FRAG_OVERRUN, IP_FRAG_TOOSMALL, IP_FRAG_FULL, IP_FRAG_INCOMPLETE,
   * PORT_SCAN, TCP_NON_SYN_FLOOD_OLD, SYN_FLOOD, BAD_RST_FLOOD, MALFORMED_FLOOD, FAKE_SESSION, ZERO_WINDOW_STRESS, SMALL_WINDOW_STRESS,
   * DOS_HTTP_TIMEOUT, DOS_HTTP_ERROR, DOS_HTTP_ABORT...
   * @return attack
   */
  public String getAttack() {
    return attack;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - LAND, SMURF, ICMP_PING_FLOOD, UNKOWN_PROTOCOL, TEARDROP, IP_FRAG_OVERRUN, IP_FRAG_TOOSMALL, IP_FRAG_FULL, IP_FRAG_INCOMPLETE,
   * PORT_SCAN, TCP_NON_SYN_FLOOD_OLD, SYN_FLOOD, BAD_RST_FLOOD, MALFORMED_FLOOD, FAKE_SESSION, ZERO_WINDOW_STRESS, SMALL_WINDOW_STRESS,
   * DOS_HTTP_TIMEOUT, DOS_HTTP_ERROR, DOS_HTTP_ABORT...
   * @param attack set the attack.
   */
  public void setAttack(String  attack) {
    this.attack = attack;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property attack_count of obj type dosattackeventdetails field type str  type float.
   * @return attackCount
   */
  public Float getAttackCount() {
    return attackCount;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property attack_count of obj type dosattackeventdetails field type str  type float.
   * @param attackCount set the attackCount.
   */
  public void setAttackCount(Float  attackCount) {
    this.attackCount = attackCount;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifiers of ipgroups.
   * @return ipgroupUuids
   */
  public List<String> getIpgroupUuids() {
    return ipgroupUuids;
  }

  /**
   * This is the setter method. this will set the ipgroupUuids
   * Unique object identifiers of ipgroups.
   * @return ipgroupUuids
   */
  public void setIpgroupUuids(List<String>  ipgroupUuids) {
    this.ipgroupUuids = ipgroupUuids;
  }

  /**
   * This is the setter method this will set the ipgroupUuids
   * Unique object identifiers of ipgroups.
   * @return ipgroupUuids
   */
  public DosAttackEventDetails addIpgroupUuidsItem(String ipgroupUuidsItem) {
    if (this.ipgroupUuids == null) {
      this.ipgroupUuids = new ArrayList<String>();
    }
    this.ipgroupUuids.add(ipgroupUuidsItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property meta_data of obj type dosattackeventdetails field type str  type array.
   * @return metaData
   */
  public List<AttackMetaData> getMetaData() {
    return metaData;
  }

  /**
   * This is the setter method. this will set the metaData
   * Placeholder for description of property meta_data of obj type dosattackeventdetails field type str  type array.
   * @return metaData
   */
  public void setMetaData(List<AttackMetaData>  metaData) {
    this.metaData = metaData;
  }

  /**
   * This is the setter method this will set the metaData
   * Placeholder for description of property meta_data of obj type dosattackeventdetails field type str  type array.
   * @return metaData
   */
  public DosAttackEventDetails addMetaDataItem(AttackMetaData metaDataItem) {
    if (this.metaData == null) {
      this.metaData = new ArrayList<AttackMetaData>();
    }
    this.metaData.add(metaDataItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property src_ips of obj type dosattackeventdetails field type str  type array.
   * @return srcIps
   */
  public List<String> getSrcIps() {
    return srcIps;
  }

  /**
   * This is the setter method. this will set the srcIps
   * Placeholder for description of property src_ips of obj type dosattackeventdetails field type str  type array.
   * @return srcIps
   */
  public void setSrcIps(List<String>  srcIps) {
    this.srcIps = srcIps;
  }

  /**
   * This is the setter method this will set the srcIps
   * Placeholder for description of property src_ips of obj type dosattackeventdetails field type str  type array.
   * @return srcIps
   */
  public DosAttackEventDetails addSrcIpsItem(String srcIpsItem) {
    if (this.srcIps == null) {
      this.srcIps = new ArrayList<String>();
    }
    this.srcIps.add(srcIpsItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property urls of obj type dosattackeventdetails field type str  type array.
   * @return urls
   */
  public List<String> getUrls() {
    return urls;
  }

  /**
   * This is the setter method. this will set the urls
   * Placeholder for description of property urls of obj type dosattackeventdetails field type str  type array.
   * @return urls
   */
  public void setUrls(List<String>  urls) {
    this.urls = urls;
  }

  /**
   * This is the setter method this will set the urls
   * Placeholder for description of property urls of obj type dosattackeventdetails field type str  type array.
   * @return urls
   */
  public DosAttackEventDetails addUrlsItem(String urlsItem) {
    if (this.urls == null) {
      this.urls = new ArrayList<String>();
    }
    this.urls.add(urlsItem);
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
  DosAttackEventDetails objDosAttackEventDetails = (DosAttackEventDetails) o;
  return   Objects.equals(this.srcIps, objDosAttackEventDetails.srcIps)&&
  Objects.equals(this.attackCount, objDosAttackEventDetails.attackCount)&&
  Objects.equals(this.attack, objDosAttackEventDetails.attack)&&
  Objects.equals(this.metaData, objDosAttackEventDetails.metaData)&&
  Objects.equals(this.urls, objDosAttackEventDetails.urls)&&
  Objects.equals(this.ipgroupUuids, objDosAttackEventDetails.ipgroupUuids);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DosAttackEventDetails {\n");
      sb.append("    attack: ").append(toIndentedString(attack)).append("\n");
        sb.append("    attackCount: ").append(toIndentedString(attackCount)).append("\n");
        sb.append("    ipgroupUuids: ").append(toIndentedString(ipgroupUuids)).append("\n");
        sb.append("    metaData: ").append(toIndentedString(metaData)).append("\n");
        sb.append("    srcIps: ").append(toIndentedString(srcIps)).append("\n");
        sb.append("    urls: ").append(toIndentedString(urls)).append("\n");
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

