package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ControllerLimits is a POJO class extends AviRestResource that used for creating
 * ControllerLimits.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ControllerLimits  {
    @JsonProperty("certificates_per_virtualservice")
    private Integer certificatesPerVirtualservice = null;

    @JsonProperty("controller_cloud_limits")
    private List<ControllerCloudLimits> controllerCloudLimits = null;

    @JsonProperty("controller_sizing_limits")
    private List<ControllerSizingLimits> controllerSizingLimits = null;

    @JsonProperty("default_routes_per_vrfcontext")
    private Integer defaultRoutesPerVrfcontext = null;

    @JsonProperty("ips_per_ipgroup")
    private Integer ipsPerIpgroup = null;

    @JsonProperty("poolgroups_per_virtualservice")
    private Integer poolgroupsPerVirtualservice = null;

    @JsonProperty("pools_per_poolgroup")
    private Integer poolsPerPoolgroup = null;

    @JsonProperty("pools_per_virtualservice")
    private Integer poolsPerVirtualservice = null;

    @JsonProperty("routes_per_vrfcontext")
    private Integer routesPerVrfcontext = null;

    @JsonProperty("rules_per_httppolicy")
    private Integer rulesPerHttppolicy = null;

    @JsonProperty("rules_per_networksecuritypolicy")
    private Integer rulesPerNetworksecuritypolicy = null;

    @JsonProperty("servers_per_pool")
    private Integer serversPerPool = null;

    @JsonProperty("sni_children_per_parent")
    private Integer sniChildrenPerParent = null;

    @JsonProperty("strings_per_stringgroup")
    private Integer stringsPerStringgroup = null;

    @JsonProperty("vs_bgp_scaleout")
    private Integer vsBgpScaleout = null;

    @JsonProperty("vs_l2_scaleout")
    private Integer vsL2Scaleout = null;



  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of certificates per virtualservice.
   * Field introduced in 20.1.1.
   * @return certificatesPerVirtualservice
   */
  public Integer getCertificatesPerVirtualservice() {
    return certificatesPerVirtualservice;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of certificates per virtualservice.
   * Field introduced in 20.1.1.
   * @param certificatesPerVirtualservice set the certificatesPerVirtualservice.
   */
  public void setCertificatesPerVirtualservice(Integer  certificatesPerVirtualservice) {
    this.certificatesPerVirtualservice = certificatesPerVirtualservice;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Controller system limits specific to cloud type for all controller sizes.
   * Field introduced in 20.1.1.
   * @return controllerCloudLimits
   */
  public List<ControllerCloudLimits> getControllerCloudLimits() {
    return controllerCloudLimits;
  }

  /**
   * This is the setter method. this will set the controllerCloudLimits
   * Controller system limits specific to cloud type for all controller sizes.
   * Field introduced in 20.1.1.
   * @return controllerCloudLimits
   */
  public void setControllerCloudLimits(List<ControllerCloudLimits>  controllerCloudLimits) {
    this.controllerCloudLimits = controllerCloudLimits;
  }

  /**
   * This is the setter method this will set the controllerCloudLimits
   * Controller system limits specific to cloud type for all controller sizes.
   * Field introduced in 20.1.1.
   * @return controllerCloudLimits
   */
  public ControllerLimits addControllerCloudLimitsItem(ControllerCloudLimits controllerCloudLimitsItem) {
    if (this.controllerCloudLimits == null) {
      this.controllerCloudLimits = new ArrayList<ControllerCloudLimits>();
    }
    this.controllerCloudLimits.add(controllerCloudLimitsItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Controller system limits specific to controller sizing.
   * Field introduced in 20.1.1.
   * @return controllerSizingLimits
   */
  public List<ControllerSizingLimits> getControllerSizingLimits() {
    return controllerSizingLimits;
  }

  /**
   * This is the setter method. this will set the controllerSizingLimits
   * Controller system limits specific to controller sizing.
   * Field introduced in 20.1.1.
   * @return controllerSizingLimits
   */
  public void setControllerSizingLimits(List<ControllerSizingLimits>  controllerSizingLimits) {
    this.controllerSizingLimits = controllerSizingLimits;
  }

  /**
   * This is the setter method this will set the controllerSizingLimits
   * Controller system limits specific to controller sizing.
   * Field introduced in 20.1.1.
   * @return controllerSizingLimits
   */
  public ControllerLimits addControllerSizingLimitsItem(ControllerSizingLimits controllerSizingLimitsItem) {
    if (this.controllerSizingLimits == null) {
      this.controllerSizingLimits = new ArrayList<ControllerSizingLimits>();
    }
    this.controllerSizingLimits.add(controllerSizingLimitsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of default routes per vrfcontext.
   * Field introduced in 20.1.1.
   * @return defaultRoutesPerVrfcontext
   */
  public Integer getDefaultRoutesPerVrfcontext() {
    return defaultRoutesPerVrfcontext;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of default routes per vrfcontext.
   * Field introduced in 20.1.1.
   * @param defaultRoutesPerVrfcontext set the defaultRoutesPerVrfcontext.
   */
  public void setDefaultRoutesPerVrfcontext(Integer  defaultRoutesPerVrfcontext) {
    this.defaultRoutesPerVrfcontext = defaultRoutesPerVrfcontext;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of ip's per ipaddrgroup.
   * Field introduced in 20.1.1.
   * @return ipsPerIpgroup
   */
  public Integer getIpsPerIpgroup() {
    return ipsPerIpgroup;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of ip's per ipaddrgroup.
   * Field introduced in 20.1.1.
   * @param ipsPerIpgroup set the ipsPerIpgroup.
   */
  public void setIpsPerIpgroup(Integer  ipsPerIpgroup) {
    this.ipsPerIpgroup = ipsPerIpgroup;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of poolgroups per virtualservice.
   * Field introduced in 20.1.1.
   * @return poolgroupsPerVirtualservice
   */
  public Integer getPoolgroupsPerVirtualservice() {
    return poolgroupsPerVirtualservice;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of poolgroups per virtualservice.
   * Field introduced in 20.1.1.
   * @param poolgroupsPerVirtualservice set the poolgroupsPerVirtualservice.
   */
  public void setPoolgroupsPerVirtualservice(Integer  poolgroupsPerVirtualservice) {
    this.poolgroupsPerVirtualservice = poolgroupsPerVirtualservice;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of pools per poolgroup.
   * Field introduced in 20.1.1.
   * @return poolsPerPoolgroup
   */
  public Integer getPoolsPerPoolgroup() {
    return poolsPerPoolgroup;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of pools per poolgroup.
   * Field introduced in 20.1.1.
   * @param poolsPerPoolgroup set the poolsPerPoolgroup.
   */
  public void setPoolsPerPoolgroup(Integer  poolsPerPoolgroup) {
    this.poolsPerPoolgroup = poolsPerPoolgroup;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of pools per virtualservice.
   * Field introduced in 20.1.1.
   * @return poolsPerVirtualservice
   */
  public Integer getPoolsPerVirtualservice() {
    return poolsPerVirtualservice;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of pools per virtualservice.
   * Field introduced in 20.1.1.
   * @param poolsPerVirtualservice set the poolsPerVirtualservice.
   */
  public void setPoolsPerVirtualservice(Integer  poolsPerVirtualservice) {
    this.poolsPerVirtualservice = poolsPerVirtualservice;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of routes per vrfcontext.
   * Field introduced in 20.1.1.
   * @return routesPerVrfcontext
   */
  public Integer getRoutesPerVrfcontext() {
    return routesPerVrfcontext;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of routes per vrfcontext.
   * Field introduced in 20.1.1.
   * @param routesPerVrfcontext set the routesPerVrfcontext.
   */
  public void setRoutesPerVrfcontext(Integer  routesPerVrfcontext) {
    this.routesPerVrfcontext = routesPerVrfcontext;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of rules per httppolicy.
   * Field introduced in 20.1.1.
   * @return rulesPerHttppolicy
   */
  public Integer getRulesPerHttppolicy() {
    return rulesPerHttppolicy;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of rules per httppolicy.
   * Field introduced in 20.1.1.
   * @param rulesPerHttppolicy set the rulesPerHttppolicy.
   */
  public void setRulesPerHttppolicy(Integer  rulesPerHttppolicy) {
    this.rulesPerHttppolicy = rulesPerHttppolicy;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of rules per networksecuritypolicy.
   * Field introduced in 20.1.1.
   * @return rulesPerNetworksecuritypolicy
   */
  public Integer getRulesPerNetworksecuritypolicy() {
    return rulesPerNetworksecuritypolicy;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of rules per networksecuritypolicy.
   * Field introduced in 20.1.1.
   * @param rulesPerNetworksecuritypolicy set the rulesPerNetworksecuritypolicy.
   */
  public void setRulesPerNetworksecuritypolicy(Integer  rulesPerNetworksecuritypolicy) {
    this.rulesPerNetworksecuritypolicy = rulesPerNetworksecuritypolicy;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of servers per pool.
   * Field introduced in 20.1.1.
   * @return serversPerPool
   */
  public Integer getServersPerPool() {
    return serversPerPool;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of servers per pool.
   * Field introduced in 20.1.1.
   * @param serversPerPool set the serversPerPool.
   */
  public void setServersPerPool(Integer  serversPerPool) {
    this.serversPerPool = serversPerPool;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of sni children virtualservices per sni parent virtualservice.
   * Field introduced in 20.1.1.
   * @return sniChildrenPerParent
   */
  public Integer getSniChildrenPerParent() {
    return sniChildrenPerParent;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of sni children virtualservices per sni parent virtualservice.
   * Field introduced in 20.1.1.
   * @param sniChildrenPerParent set the sniChildrenPerParent.
   */
  public void setSniChildrenPerParent(Integer  sniChildrenPerParent) {
    this.sniChildrenPerParent = sniChildrenPerParent;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of strings per stringgroup.
   * Field introduced in 20.1.1.
   * @return stringsPerStringgroup
   */
  public Integer getStringsPerStringgroup() {
    return stringsPerStringgroup;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of strings per stringgroup.
   * Field introduced in 20.1.1.
   * @param stringsPerStringgroup set the stringsPerStringgroup.
   */
  public void setStringsPerStringgroup(Integer  stringsPerStringgroup) {
    this.stringsPerStringgroup = stringsPerStringgroup;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of serviceengine per virtualservice in bgp scaleout mode.
   * Field introduced in 20.1.1.
   * @return vsBgpScaleout
   */
  public Integer getVsBgpScaleout() {
    return vsBgpScaleout;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of serviceengine per virtualservice in bgp scaleout mode.
   * Field introduced in 20.1.1.
   * @param vsBgpScaleout set the vsBgpScaleout.
   */
  public void setVsBgpScaleout(Integer  vsBgpScaleout) {
    this.vsBgpScaleout = vsBgpScaleout;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Maximum number of serviceengine per virtualservice in layer 2 scaleout mode.
   * Field introduced in 20.1.1.
   * @return vsL2Scaleout
   */
  public Integer getVsL2Scaleout() {
    return vsL2Scaleout;
  }

  /**
   * This is the setter method to the attribute.
   * Maximum number of serviceengine per virtualservice in layer 2 scaleout mode.
   * Field introduced in 20.1.1.
   * @param vsL2Scaleout set the vsL2Scaleout.
   */
  public void setVsL2Scaleout(Integer  vsL2Scaleout) {
    this.vsL2Scaleout = vsL2Scaleout;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ControllerLimits objControllerLimits = (ControllerLimits) o;
  return   Objects.equals(this.defaultRoutesPerVrfcontext, objControllerLimits.defaultRoutesPerVrfcontext)&&
  Objects.equals(this.poolsPerVirtualservice, objControllerLimits.poolsPerVirtualservice)&&
  Objects.equals(this.controllerCloudLimits, objControllerLimits.controllerCloudLimits)&&
  Objects.equals(this.poolgroupsPerVirtualservice, objControllerLimits.poolgroupsPerVirtualservice)&&
  Objects.equals(this.vsL2Scaleout, objControllerLimits.vsL2Scaleout)&&
  Objects.equals(this.poolsPerPoolgroup, objControllerLimits.poolsPerPoolgroup)&&
  Objects.equals(this.rulesPerHttppolicy, objControllerLimits.rulesPerHttppolicy)&&
  Objects.equals(this.vsBgpScaleout, objControllerLimits.vsBgpScaleout)&&
  Objects.equals(this.serversPerPool, objControllerLimits.serversPerPool)&&
  Objects.equals(this.stringsPerStringgroup, objControllerLimits.stringsPerStringgroup)&&
  Objects.equals(this.controllerSizingLimits, objControllerLimits.controllerSizingLimits)&&
  Objects.equals(this.rulesPerNetworksecuritypolicy, objControllerLimits.rulesPerNetworksecuritypolicy)&&
  Objects.equals(this.sniChildrenPerParent, objControllerLimits.sniChildrenPerParent)&&
  Objects.equals(this.routesPerVrfcontext, objControllerLimits.routesPerVrfcontext)&&
  Objects.equals(this.ipsPerIpgroup, objControllerLimits.ipsPerIpgroup)&&
  Objects.equals(this.certificatesPerVirtualservice, objControllerLimits.certificatesPerVirtualservice);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ControllerLimits {\n");
      sb.append("    certificatesPerVirtualservice: ").append(toIndentedString(certificatesPerVirtualservice)).append("\n");
        sb.append("    controllerCloudLimits: ").append(toIndentedString(controllerCloudLimits)).append("\n");
        sb.append("    controllerSizingLimits: ").append(toIndentedString(controllerSizingLimits)).append("\n");
        sb.append("    defaultRoutesPerVrfcontext: ").append(toIndentedString(defaultRoutesPerVrfcontext)).append("\n");
        sb.append("    ipsPerIpgroup: ").append(toIndentedString(ipsPerIpgroup)).append("\n");
        sb.append("    poolgroupsPerVirtualservice: ").append(toIndentedString(poolgroupsPerVirtualservice)).append("\n");
        sb.append("    poolsPerPoolgroup: ").append(toIndentedString(poolsPerPoolgroup)).append("\n");
        sb.append("    poolsPerVirtualservice: ").append(toIndentedString(poolsPerVirtualservice)).append("\n");
        sb.append("    routesPerVrfcontext: ").append(toIndentedString(routesPerVrfcontext)).append("\n");
        sb.append("    rulesPerHttppolicy: ").append(toIndentedString(rulesPerHttppolicy)).append("\n");
        sb.append("    rulesPerNetworksecuritypolicy: ").append(toIndentedString(rulesPerNetworksecuritypolicy)).append("\n");
        sb.append("    serversPerPool: ").append(toIndentedString(serversPerPool)).append("\n");
        sb.append("    sniChildrenPerParent: ").append(toIndentedString(sniChildrenPerParent)).append("\n");
        sb.append("    stringsPerStringgroup: ").append(toIndentedString(stringsPerStringgroup)).append("\n");
        sb.append("    vsBgpScaleout: ").append(toIndentedString(vsBgpScaleout)).append("\n");
        sb.append("    vsL2Scaleout: ").append(toIndentedString(vsL2Scaleout)).append("\n");
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

