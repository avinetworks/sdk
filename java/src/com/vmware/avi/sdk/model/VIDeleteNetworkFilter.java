package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VIDeleteNetworkFilter is a POJO class extends AviRestResource that used for creating
 * VIDeleteNetworkFilter.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VIDeleteNetworkFilter  {
    @JsonProperty("cloud_uuid")
    private String cloudUuid = null;

    @JsonProperty("datacenter")
    private String datacenter = null;

    @JsonProperty("network_uuid")
    private String networkUuid = null;

    @JsonProperty("vcenter_url")
    private String vcenterUrl = null;



  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.1.3.
   * @return cloudUuid
   */
  public String getCloudUuid() {
    return cloudUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.1.3.
   * @param cloudUuid set the cloudUuid.
   */
  public void setCloudUuid(String  cloudUuid) {
    this.cloudUuid = cloudUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.1.3.
   * @return datacenter
   */
  public String getDatacenter() {
    return datacenter;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.1.3.
   * @param datacenter set the datacenter.
   */
  public void setDatacenter(String  datacenter) {
    this.datacenter = datacenter;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.1.3.
   * @return networkUuid
   */
  public String getNetworkUuid() {
    return networkUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.1.3.
   * @param networkUuid set the networkUuid.
   */
  public void setNetworkUuid(String  networkUuid) {
    this.networkUuid = networkUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.1.3.
   * @return vcenterUrl
   */
  public String getVcenterUrl() {
    return vcenterUrl;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.1.3.
   * @param vcenterUrl set the vcenterUrl.
   */
  public void setVcenterUrl(String  vcenterUrl) {
    this.vcenterUrl = vcenterUrl;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VIDeleteNetworkFilter objVIDeleteNetworkFilter = (VIDeleteNetworkFilter) o;
  return   Objects.equals(this.vcenterUrl, objVIDeleteNetworkFilter.vcenterUrl)&&
  Objects.equals(this.datacenter, objVIDeleteNetworkFilter.datacenter)&&
  Objects.equals(this.networkUuid, objVIDeleteNetworkFilter.networkUuid)&&
  Objects.equals(this.cloudUuid, objVIDeleteNetworkFilter.cloudUuid);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VIDeleteNetworkFilter {\n");
      sb.append("    cloudUuid: ").append(toIndentedString(cloudUuid)).append("\n");
        sb.append("    datacenter: ").append(toIndentedString(datacenter)).append("\n");
        sb.append("    networkUuid: ").append(toIndentedString(networkUuid)).append("\n");
        sb.append("    vcenterUrl: ").append(toIndentedString(vcenterUrl)).append("\n");
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

