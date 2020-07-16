package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The GCPVIPILB is a POJO class extends AviRestResource that used for creating
 * GCPVIPILB.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GCPVIPILB  {
    @JsonProperty("cloud_router_names")
    private List<String> cloudRouterNames = null;


  /**
   * This is the getter method this will return the attribute value.
   * Google cloud router names to advertise byoip.
   * Field introduced in 20.1.1.
   * @return cloudRouterNames
   */
  public List<String> getCloudRouterNames() {
    return cloudRouterNames;
  }

  /**
   * This is the setter method. this will set the cloudRouterNames
   * Google cloud router names to advertise byoip.
   * Field introduced in 20.1.1.
   * @return cloudRouterNames
   */
  public void setCloudRouterNames(List<String>  cloudRouterNames) {
    this.cloudRouterNames = cloudRouterNames;
  }

  /**
   * This is the setter method this will set the cloudRouterNames
   * Google cloud router names to advertise byoip.
   * Field introduced in 20.1.1.
   * @return cloudRouterNames
   */
  public GCPVIPILB addCloudRouterNamesItem(String cloudRouterNamesItem) {
    if (this.cloudRouterNames == null) {
      this.cloudRouterNames = new ArrayList<String>();
    }
    this.cloudRouterNames.add(cloudRouterNamesItem);
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
  GCPVIPILB objGCPVIPILB = (GCPVIPILB) o;
  return   Objects.equals(this.cloudRouterNames, objGCPVIPILB.cloudRouterNames);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class GCPVIPILB {\n");
      sb.append("    cloudRouterNames: ").append(toIndentedString(cloudRouterNames)).append("\n");
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

