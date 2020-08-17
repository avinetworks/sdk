package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The CloudInfo is a POJO class extends AviRestResource that used for creating
 * CloudInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CloudInfo  {
    @JsonProperty("cca_props")
    private CC_AgentProperties ccaProps = null;

    @JsonProperty("controller_props")
    private ControllerProperties controllerProps = null;

    @JsonProperty("flavor_props")
    private List<CloudFlavor> flavorProps = null;

    @JsonProperty("flavor_regex_filter")
    private String flavorRegexFilter = null;

    @JsonProperty("htypes")
    private List<String> htypes = null;

    @JsonProperty("vtype")
    private String vtype = null;



  /**
   * This is the getter method this will return the attribute value.
   * Cloudconnectoragent properties specific to this cloud type.
   * @return ccaProps
   */
  public CC_AgentProperties getCcaProps() {
    return ccaProps;
  }

  /**
   * This is the setter method to the attribute.
   * Cloudconnectoragent properties specific to this cloud type.
   * @param ccaProps set the ccaProps.
   */
  public void setCcaProps(CC_AgentProperties ccaProps) {
    this.ccaProps = ccaProps;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Controller properties specific to this cloud type.
   * @return controllerProps
   */
  public ControllerProperties getControllerProps() {
    return controllerProps;
  }

  /**
   * This is the setter method to the attribute.
   * Controller properties specific to this cloud type.
   * @param controllerProps set the controllerProps.
   */
  public void setControllerProps(ControllerProperties controllerProps) {
    this.controllerProps = controllerProps;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Flavor properties specific to this cloud type.
   * @return flavorProps
   */
  public List<CloudFlavor> getFlavorProps() {
    return flavorProps;
  }

  /**
   * This is the setter method. this will set the flavorProps
   * Flavor properties specific to this cloud type.
   * @return flavorProps
   */
  public void setFlavorProps(List<CloudFlavor>  flavorProps) {
    this.flavorProps = flavorProps;
  }

  /**
   * This is the setter method this will set the flavorProps
   * Flavor properties specific to this cloud type.
   * @return flavorProps
   */
  public CloudInfo addFlavorPropsItem(CloudFlavor flavorPropsItem) {
    if (this.flavorProps == null) {
      this.flavorProps = new ArrayList<CloudFlavor>();
    }
    this.flavorProps.add(flavorPropsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property flavor_regex_filter of obj type cloudinfo field type str  type string.
   * @return flavorRegexFilter
   */
  public String getFlavorRegexFilter() {
    return flavorRegexFilter;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property flavor_regex_filter of obj type cloudinfo field type str  type string.
   * @param flavorRegexFilter set the flavorRegexFilter.
   */
  public void setFlavorRegexFilter(String  flavorRegexFilter) {
    this.flavorRegexFilter = flavorRegexFilter;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Supported hypervisors.
   * Enum options - DEFAULT, VMWARE_ESX, KVM, VMWARE_VSAN, XEN.
   * @return htypes
   */
  public List<String> getHtypes() {
    return htypes;
  }

  /**
   * This is the setter method. this will set the htypes
   * Supported hypervisors.
   * Enum options - DEFAULT, VMWARE_ESX, KVM, VMWARE_VSAN, XEN.
   * @return htypes
   */
  public void setHtypes(List<String>  htypes) {
    this.htypes = htypes;
  }

  /**
   * This is the setter method this will set the htypes
   * Supported hypervisors.
   * Enum options - DEFAULT, VMWARE_ESX, KVM, VMWARE_VSAN, XEN.
   * @return htypes
   */
  public CloudInfo addHtypesItem(String htypesItem) {
    if (this.htypes == null) {
      this.htypes = new ArrayList<String>();
    }
    this.htypes.add(htypesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Cloud type.
   * Enum options - CLOUD_NONE, CLOUD_VCENTER, CLOUD_OPENSTACK, CLOUD_AWS, CLOUD_VCA, CLOUD_APIC, CLOUD_MESOS, CLOUD_LINUXSERVER, CLOUD_DOCKER_UCP,
   * CLOUD_RANCHER, CLOUD_OSHIFT_K8S, CLOUD_AZURE, CLOUD_GCP, CLOUD_NSXT.
   * @return vtype
   */
  public String getVtype() {
    return vtype;
  }

  /**
   * This is the setter method to the attribute.
   * Cloud type.
   * Enum options - CLOUD_NONE, CLOUD_VCENTER, CLOUD_OPENSTACK, CLOUD_AWS, CLOUD_VCA, CLOUD_APIC, CLOUD_MESOS, CLOUD_LINUXSERVER, CLOUD_DOCKER_UCP,
   * CLOUD_RANCHER, CLOUD_OSHIFT_K8S, CLOUD_AZURE, CLOUD_GCP, CLOUD_NSXT.
   * @param vtype set the vtype.
   */
  public void setVtype(String  vtype) {
    this.vtype = vtype;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  CloudInfo objCloudInfo = (CloudInfo) o;
  return   Objects.equals(this.vtype, objCloudInfo.vtype)&&
  Objects.equals(this.htypes, objCloudInfo.htypes)&&
  Objects.equals(this.flavorRegexFilter, objCloudInfo.flavorRegexFilter)&&
  Objects.equals(this.flavorProps, objCloudInfo.flavorProps)&&
  Objects.equals(this.ccaProps, objCloudInfo.ccaProps)&&
  Objects.equals(this.controllerProps, objCloudInfo.controllerProps);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class CloudInfo {\n");
      sb.append("    ccaProps: ").append(toIndentedString(ccaProps)).append("\n");
        sb.append("    controllerProps: ").append(toIndentedString(controllerProps)).append("\n");
        sb.append("    flavorProps: ").append(toIndentedString(flavorProps)).append("\n");
        sb.append("    flavorRegexFilter: ").append(toIndentedString(flavorRegexFilter)).append("\n");
        sb.append("    htypes: ").append(toIndentedString(htypes)).append("\n");
        sb.append("    vtype: ").append(toIndentedString(vtype)).append("\n");
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

