package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The GslbThirdPartySiteRuntime is a POJO class extends AviRestResource that used for creating
 * GslbThirdPartySiteRuntime.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GslbThirdPartySiteRuntime  {
    @JsonProperty("site_info")
    private GslbSiteRuntimeInfo siteInfo = null;



  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.1.1.
   * @return siteInfo
   */
  public GslbSiteRuntimeInfo getSiteInfo() {
    return siteInfo;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.1.1.
   * @param siteInfo set the siteInfo.
   */
  public void setSiteInfo(GslbSiteRuntimeInfo siteInfo) {
    this.siteInfo = siteInfo;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  GslbThirdPartySiteRuntime objGslbThirdPartySiteRuntime = (GslbThirdPartySiteRuntime) o;
  return   Objects.equals(this.siteInfo, objGslbThirdPartySiteRuntime.siteInfo);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class GslbThirdPartySiteRuntime {\n");
      sb.append("    siteInfo: ").append(toIndentedString(siteInfo)).append("\n");
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

