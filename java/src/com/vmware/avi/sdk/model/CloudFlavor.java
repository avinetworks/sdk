package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The CloudFlavor is a POJO class extends AviRestResource that used for creating
 * CloudFlavor.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CloudFlavor  {
    @JsonProperty("cost")
    private String cost = null;

    @JsonProperty("disk_gb")
    private Integer diskGb = null;

    @JsonProperty("enhanced_nw")
    private Boolean enhancedNw = null;

    @JsonProperty("id")
    private String id = null;

    @JsonProperty("is_recommended")
    private Boolean isRecommended = null;

    @JsonProperty("max_ip6s_per_nic")
    private Integer maxIp6SPerNic = null;

    @JsonProperty("max_ips_per_nic")
    private Integer maxIpsPerNic = null;

    @JsonProperty("max_nics")
    private Integer maxNics = null;

    @JsonProperty("meta")
    private List<CloudMeta> meta = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("public")
    private Boolean publics = true;

    @JsonProperty("ram_mb")
    private Integer ramMb = null;

    @JsonProperty("vcpus")
    private Integer vcpus = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cost of obj type cloudflavor field type str  type string.
   * @return cost
   */
  public String getCost() {
    return cost;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cost of obj type cloudflavor field type str  type string.
   * @param cost set the cost.
   */
  public void setCost(String  cost) {
    this.cost = cost;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property disk_gb of obj type cloudflavor field type str  type integer.
   * @return diskGb
   */
  public Integer getDiskGb() {
    return diskGb;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property disk_gb of obj type cloudflavor field type str  type integer.
   * @param diskGb set the diskGb.
   */
  public void setDiskGb(Integer  diskGb) {
    this.diskGb = diskGb;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property enhanced_nw of obj type cloudflavor field type str  type boolean.
   * @return enhancedNw
   */
  public Boolean getEnhancedNw() {
    return enhancedNw;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property enhanced_nw of obj type cloudflavor field type str  type boolean.
   * @param enhancedNw set the enhancedNw.
   */
  public void setEnhancedNw(Boolean  enhancedNw) {
    this.enhancedNw = enhancedNw;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property id of obj type cloudflavor field type str  type string.
   * @return id
   */
  public String getId() {
    return id;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property id of obj type cloudflavor field type str  type string.
   * @param id set the id.
   */
  public void setId(String  id) {
    this.id = id;
  }

  /**
   * This is the getter method this will return the attribute value.
   * If a vm flavor is recommended for requested se_usage_type.set to true if the chosen vm flavor is recommended for requested se_usage_type.else set
   * to false.
   * Field introduced in 18.1.4, 18.2.1.
   * @return isRecommended
   */
  public Boolean getIsRecommended() {
    return isRecommended;
  }

  /**
   * This is the setter method to the attribute.
   * If a vm flavor is recommended for requested se_usage_type.set to true if the chosen vm flavor is recommended for requested se_usage_type.else set
   * to false.
   * Field introduced in 18.1.4, 18.2.1.
   * @param isRecommended set the isRecommended.
   */
  public void setIsRecommended(Boolean  isRecommended) {
    this.isRecommended = isRecommended;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of ipv6 addresses that can be configured per nic.
   * Field introduced in 18.1.1.
   * @return maxIp6SPerNic
   */
  public Integer getMaxIp6SPerNic() {
    return maxIp6SPerNic;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of ipv6 addresses that can be configured per nic.
   * Field introduced in 18.1.1.
   * @param maxIp6SPerNic set the maxIp6SPerNic.
   */
  public void setMaxIp6SPerNic(Integer  maxIp6SPerNic) {
    this.maxIp6SPerNic = maxIp6SPerNic;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property max_ips_per_nic of obj type cloudflavor field type str  type integer.
   * @return maxIpsPerNic
   */
  public Integer getMaxIpsPerNic() {
    return maxIpsPerNic;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property max_ips_per_nic of obj type cloudflavor field type str  type integer.
   * @param maxIpsPerNic set the maxIpsPerNic.
   */
  public void setMaxIpsPerNic(Integer  maxIpsPerNic) {
    this.maxIpsPerNic = maxIpsPerNic;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property max_nics of obj type cloudflavor field type str  type integer.
   * @return maxNics
   */
  public Integer getMaxNics() {
    return maxNics;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property max_nics of obj type cloudflavor field type str  type integer.
   * @param maxNics set the maxNics.
   */
  public void setMaxNics(Integer  maxNics) {
    this.maxNics = maxNics;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property meta of obj type cloudflavor field type str  type array.
   * @return meta
   */
  public List<CloudMeta> getMeta() {
    return meta;
  }

  /**
   * This is the setter method. this will set the meta
   * Placeholder for description of property meta of obj type cloudflavor field type str  type array.
   * @return meta
   */
  public void setMeta(List<CloudMeta>  meta) {
    this.meta = meta;
  }

  /**
   * This is the setter method this will set the meta
   * Placeholder for description of property meta of obj type cloudflavor field type str  type array.
   * @return meta
   */
  public CloudFlavor addMetaItem(CloudMeta metaItem) {
    if (this.meta == null) {
      this.meta = new ArrayList<CloudMeta>();
    }
    this.meta.add(metaItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the object.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the object.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property public of obj type cloudflavor field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return publics
   */
  public Boolean getPublic() {
    return publics;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property public of obj type cloudflavor field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param publics set the publics.
   */
  public void setPublic(Boolean  publics) {
    this.publics = publics;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ram_mb of obj type cloudflavor field type str  type integer.
   * @return ramMb
   */
  public Integer getRamMb() {
    return ramMb;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ram_mb of obj type cloudflavor field type str  type integer.
   * @param ramMb set the ramMb.
   */
  public void setRamMb(Integer  ramMb) {
    this.ramMb = ramMb;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vcpus of obj type cloudflavor field type str  type integer.
   * @return vcpus
   */
  public Integer getVcpus() {
    return vcpus;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vcpus of obj type cloudflavor field type str  type integer.
   * @param vcpus set the vcpus.
   */
  public void setVcpus(Integer  vcpus) {
    this.vcpus = vcpus;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  CloudFlavor objCloudFlavor = (CloudFlavor) o;
  return   Objects.equals(this.maxNics, objCloudFlavor.maxNics)&&
  Objects.equals(this.maxIp6SPerNic, objCloudFlavor.maxIp6SPerNic)&&
  Objects.equals(this.cost, objCloudFlavor.cost)&&
  Objects.equals(this.name, objCloudFlavor.name)&&
  Objects.equals(this.diskGb, objCloudFlavor.diskGb)&&
  Objects.equals(this.maxIpsPerNic, objCloudFlavor.maxIpsPerNic)&&
  Objects.equals(this.ramMb, objCloudFlavor.ramMb)&&
  Objects.equals(this.id, objCloudFlavor.id)&&
  Objects.equals(this.vcpus, objCloudFlavor.vcpus)&&
  Objects.equals(this.meta, objCloudFlavor.meta)&&
  Objects.equals(this.isRecommended, objCloudFlavor.isRecommended)&&
  Objects.equals(this.publics, objCloudFlavor.publics)&&
  Objects.equals(this.enhancedNw, objCloudFlavor.enhancedNw);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class CloudFlavor {\n");
      sb.append("    cost: ").append(toIndentedString(cost)).append("\n");
        sb.append("    diskGb: ").append(toIndentedString(diskGb)).append("\n");
        sb.append("    enhancedNw: ").append(toIndentedString(enhancedNw)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    isRecommended: ").append(toIndentedString(isRecommended)).append("\n");
        sb.append("    maxIp6SPerNic: ").append(toIndentedString(maxIp6SPerNic)).append("\n");
        sb.append("    maxIpsPerNic: ").append(toIndentedString(maxIpsPerNic)).append("\n");
        sb.append("    maxNics: ").append(toIndentedString(maxNics)).append("\n");
        sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    publics: ").append(toIndentedString(publics)).append("\n");
        sb.append("    ramMb: ").append(toIndentedString(ramMb)).append("\n");
        sb.append("    vcpus: ").append(toIndentedString(vcpus)).append("\n");
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

