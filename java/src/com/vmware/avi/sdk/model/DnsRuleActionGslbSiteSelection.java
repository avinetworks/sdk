package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DnsRuleActionGslbSiteSelection is a POJO class extends AviRestResource that used for creating
 * DnsRuleActionGslbSiteSelection.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DnsRuleActionGslbSiteSelection  {
    @JsonProperty("fallback_site_names")
    private List<String> fallbackSiteNames = null;

    @JsonProperty("is_site_preferred")
    private Boolean isSitePreferred = true;

    @JsonProperty("site_name")
    private String siteName = null;


  /**
   * This is the getter method this will return the attribute value.
   * Gslb fallback sites to use in case the desired site is down.
   * Field introduced in 17.2.5.
   * @return fallbackSiteNames
   */
  public List<String> getFallbackSiteNames() {
    return fallbackSiteNames;
  }

  /**
   * This is the setter method. this will set the fallbackSiteNames
   * Gslb fallback sites to use in case the desired site is down.
   * Field introduced in 17.2.5.
   * @return fallbackSiteNames
   */
  public void setFallbackSiteNames(List<String>  fallbackSiteNames) {
    this.fallbackSiteNames = fallbackSiteNames;
  }

  /**
   * This is the setter method this will set the fallbackSiteNames
   * Gslb fallback sites to use in case the desired site is down.
   * Field introduced in 17.2.5.
   * @return fallbackSiteNames
   */
  public DnsRuleActionGslbSiteSelection addFallbackSiteNamesItem(String fallbackSiteNamesItem) {
    if (this.fallbackSiteNames == null) {
      this.fallbackSiteNames = new ArrayList<String>();
    }
    this.fallbackSiteNames.add(fallbackSiteNamesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * When set to true, gslb site is a preferred site.
   * This setting comes into play when the site is down, as well as no configured fallback site is available (all fallback sites are also down), then
   * any one available site is selected based on the default algorithm for gslb pool member selection.
   * Field introduced in 17.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return isSitePreferred
   */
  public Boolean getIsSitePreferred() {
    return isSitePreferred;
  }

  /**
   * This is the setter method to the attribute.
   * When set to true, gslb site is a preferred site.
   * This setting comes into play when the site is down, as well as no configured fallback site is available (all fallback sites are also down), then
   * any one available site is selected based on the default algorithm for gslb pool member selection.
   * Field introduced in 17.2.5.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param isSitePreferred set the isSitePreferred.
   */
  public void setIsSitePreferred(Boolean  isSitePreferred) {
    this.isSitePreferred = isSitePreferred;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Gslb site name.
   * Field introduced in 17.1.5.
   * @return siteName
   */
  public String getSiteName() {
    return siteName;
  }

  /**
   * This is the setter method to the attribute.
   * Gslb site name.
   * Field introduced in 17.1.5.
   * @param siteName set the siteName.
   */
  public void setSiteName(String  siteName) {
    this.siteName = siteName;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  DnsRuleActionGslbSiteSelection objDnsRuleActionGslbSiteSelection = (DnsRuleActionGslbSiteSelection) o;
  return   Objects.equals(this.isSitePreferred, objDnsRuleActionGslbSiteSelection.isSitePreferred)&&
  Objects.equals(this.siteName, objDnsRuleActionGslbSiteSelection.siteName)&&
  Objects.equals(this.fallbackSiteNames, objDnsRuleActionGslbSiteSelection.fallbackSiteNames);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DnsRuleActionGslbSiteSelection {\n");
      sb.append("    fallbackSiteNames: ").append(toIndentedString(fallbackSiteNames)).append("\n");
        sb.append("    isSitePreferred: ").append(toIndentedString(isSitePreferred)).append("\n");
        sb.append("    siteName: ").append(toIndentedString(siteName)).append("\n");
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

