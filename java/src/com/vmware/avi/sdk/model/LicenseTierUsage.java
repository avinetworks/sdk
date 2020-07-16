package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The LicenseTierUsage is a POJO class extends AviRestResource that used for creating
 * LicenseTierUsage.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LicenseTierUsage  {
    @JsonProperty("tier")
    private String tier = null;

    @JsonProperty("usage")
    private LicenseUsage usage = null;



  /**
   * This is the getter method this will return the attribute value.
   * Specifies the license tier.
   * Enum options - ENTERPRISE_16, ENTERPRISE, ENTERPRISE_18, BASIC.
   * Field introduced in 20.1.1.
   * @return tier
   */
  public String getTier() {
    return tier;
  }

  /**
   * This is the setter method to the attribute.
   * Specifies the license tier.
   * Enum options - ENTERPRISE_16, ENTERPRISE, ENTERPRISE_18, BASIC.
   * Field introduced in 20.1.1.
   * @param tier set the tier.
   */
  public void setTier(String  tier) {
    this.tier = tier;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Usage stats of license tier.
   * Field introduced in 20.1.1.
   * @return usage
   */
  public LicenseUsage getUsage() {
    return usage;
  }

  /**
   * This is the setter method to the attribute.
   * Usage stats of license tier.
   * Field introduced in 20.1.1.
   * @param usage set the usage.
   */
  public void setUsage(LicenseUsage usage) {
    this.usage = usage;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  LicenseTierUsage objLicenseTierUsage = (LicenseTierUsage) o;
  return   Objects.equals(this.tier, objLicenseTierUsage.tier)&&
  Objects.equals(this.usage, objLicenseTierUsage.usage);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class LicenseTierUsage {\n");
      sb.append("    tier: ").append(toIndentedString(tier)).append("\n");
        sb.append("    usage: ").append(toIndentedString(usage)).append("\n");
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

