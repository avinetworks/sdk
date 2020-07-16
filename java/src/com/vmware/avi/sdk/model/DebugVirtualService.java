package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DebugVirtualService is a POJO class extends AviRestResource that used for creating
 * DebugVirtualService.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DebugVirtualService extends AviRestResource  {
    @JsonProperty("capture")
    private Boolean capture = null;

    @JsonProperty("capture_filters")
    private CaptureFilters captureFilters = null;

    @JsonProperty("capture_params")
    private DebugVirtualServiceCapture captureParams = null;

    @JsonProperty("cloud_ref")
    private String cloudRef = null;

    @JsonProperty("debug_hm")
    private String debugHm = "DEBUG_VS_HM_NONE";

    @JsonProperty("debug_ip")
    private DebugIpAddr debugIp = null;

    @JsonProperty("dns_options")
    private DebugDnsOptions dnsOptions = null;

    @JsonProperty("flags")
    private List<DebugVsDataplane> flags = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("resync_flows")
    private Boolean resyncFlows = false;

    @JsonProperty("se_params")
    private DebugVirtualServiceSeParams seParams = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property capture of obj type debugvirtualservice field type str  type boolean.
   * @return capture
   */
  public Boolean getCapture() {
    return capture;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property capture of obj type debugvirtualservice field type str  type boolean.
   * @param capture set the capture.
   */
  public void setCapture(Boolean  capture) {
    this.capture = capture;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Per packet capture filters for debug virtual service.
   * Applies to both frontend and backend packets.
   * Field introduced in 18.2.7.
   * @return captureFilters
   */
  public CaptureFilters getCaptureFilters() {
    return captureFilters;
  }

  /**
   * This is the setter method to the attribute.
   * Per packet capture filters for debug virtual service.
   * Applies to both frontend and backend packets.
   * Field introduced in 18.2.7.
   * @param captureFilters set the captureFilters.
   */
  public void setCaptureFilters(CaptureFilters captureFilters) {
    this.captureFilters = captureFilters;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property capture_params of obj type debugvirtualservice field type str  type ref.
   * @return captureParams
   */
  public DebugVirtualServiceCapture getCaptureParams() {
    return captureParams;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property capture_params of obj type debugvirtualservice field type str  type ref.
   * @param captureParams set the captureParams.
   */
  public void setCaptureParams(DebugVirtualServiceCapture captureParams) {
    this.captureParams = captureParams;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type cloud.
   * @return cloudRef
   */
  public String getCloudRef() {
    return cloudRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type cloud.
   * @param cloudRef set the cloudRef.
   */
  public void setCloudRef(String  cloudRef) {
    this.cloudRef = cloudRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * This option controls the capture of health monitor flows.
   * Enum options - DEBUG_VS_HM_NONE, DEBUG_VS_HM_ONLY, DEBUG_VS_HM_INCLUDE.
   * Default value when not specified in API or module is interpreted by Avi Controller as DEBUG_VS_HM_NONE.
   * @return debugHm
   */
  public String getDebugHm() {
    return debugHm;
  }

  /**
   * This is the setter method to the attribute.
   * This option controls the capture of health monitor flows.
   * Enum options - DEBUG_VS_HM_NONE, DEBUG_VS_HM_ONLY, DEBUG_VS_HM_INCLUDE.
   * Default value when not specified in API or module is interpreted by Avi Controller as DEBUG_VS_HM_NONE.
   * @param debugHm set the debugHm.
   */
  public void setDebugHm(String  debugHm) {
    this.debugHm = debugHm;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Filters all packets of a complete transaction (client and server side), based on client ip.
   * @return debugIp
   */
  public DebugIpAddr getDebugIp() {
    return debugIp;
  }

  /**
   * This is the setter method to the attribute.
   * Filters all packets of a complete transaction (client and server side), based on client ip.
   * @param debugIp set the debugIp.
   */
  public void setDebugIp(DebugIpAddr debugIp) {
    this.debugIp = debugIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Dns debug options.
   * Field introduced in 18.2.1.
   * @return dnsOptions
   */
  public DebugDnsOptions getDnsOptions() {
    return dnsOptions;
  }

  /**
   * This is the setter method to the attribute.
   * Dns debug options.
   * Field introduced in 18.2.1.
   * @param dnsOptions set the dnsOptions.
   */
  public void setDnsOptions(DebugDnsOptions dnsOptions) {
    this.dnsOptions = dnsOptions;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property flags of obj type debugvirtualservice field type str  type array.
   * @return flags
   */
  public List<DebugVsDataplane> getFlags() {
    return flags;
  }

  /**
   * This is the setter method. this will set the flags
   * Placeholder for description of property flags of obj type debugvirtualservice field type str  type array.
   * @return flags
   */
  public void setFlags(List<DebugVsDataplane>  flags) {
    this.flags = flags;
  }

  /**
   * This is the setter method this will set the flags
   * Placeholder for description of property flags of obj type debugvirtualservice field type str  type array.
   * @return flags
   */
  public DebugVirtualService addFlagsItem(DebugVsDataplane flagsItem) {
    if (this.flags == null) {
      this.flags = new ArrayList<DebugVsDataplane>();
    }
    this.flags.add(flagsItem);
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
   * This option re-synchronizes flows between active-standby service engines for all the virtual services placed on them.
   * It should be used with caution because as it can cause a flood between active-standby.
   * Field introduced in 18.1.3,18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return resyncFlows
   */
  public Boolean getResyncFlows() {
    return resyncFlows;
  }

  /**
   * This is the setter method to the attribute.
   * This option re-synchronizes flows between active-standby service engines for all the virtual services placed on them.
   * It should be used with caution because as it can cause a flood between active-standby.
   * Field introduced in 18.1.3,18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param resyncFlows set the resyncFlows.
   */
  public void setResyncFlows(Boolean  resyncFlows) {
    this.resyncFlows = resyncFlows;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property se_params of obj type debugvirtualservice field type str  type ref.
   * @return seParams
   */
  public DebugVirtualServiceSeParams getSeParams() {
    return seParams;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property se_params of obj type debugvirtualservice field type str  type ref.
   * @param seParams set the seParams.
   */
  public void setSeParams(DebugVirtualServiceSeParams seParams) {
    this.seParams = seParams;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type tenant.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type tenant.
   * @param tenantRef set the tenantRef.
   */
  public void setTenantRef(String  tenantRef) {
    this.tenantRef = tenantRef;
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
   * Unique object identifier of the object.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of the object.
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
  DebugVirtualService objDebugVirtualService = (DebugVirtualService) o;
  return   Objects.equals(this.capture, objDebugVirtualService.capture)&&
  Objects.equals(this.seParams, objDebugVirtualService.seParams)&&
  Objects.equals(this.uuid, objDebugVirtualService.uuid)&&
  Objects.equals(this.captureParams, objDebugVirtualService.captureParams)&&
  Objects.equals(this.debugIp, objDebugVirtualService.debugIp)&&
  Objects.equals(this.captureFilters, objDebugVirtualService.captureFilters)&&
  Objects.equals(this.cloudRef, objDebugVirtualService.cloudRef)&&
  Objects.equals(this.dnsOptions, objDebugVirtualService.dnsOptions)&&
  Objects.equals(this.flags, objDebugVirtualService.flags)&&
  Objects.equals(this.debugHm, objDebugVirtualService.debugHm)&&
  Objects.equals(this.resyncFlows, objDebugVirtualService.resyncFlows)&&
  Objects.equals(this.tenantRef, objDebugVirtualService.tenantRef)&&
  Objects.equals(this.name, objDebugVirtualService.name);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DebugVirtualService {\n");
      sb.append("    capture: ").append(toIndentedString(capture)).append("\n");
        sb.append("    captureFilters: ").append(toIndentedString(captureFilters)).append("\n");
        sb.append("    captureParams: ").append(toIndentedString(captureParams)).append("\n");
        sb.append("    cloudRef: ").append(toIndentedString(cloudRef)).append("\n");
        sb.append("    debugHm: ").append(toIndentedString(debugHm)).append("\n");
        sb.append("    debugIp: ").append(toIndentedString(debugIp)).append("\n");
        sb.append("    dnsOptions: ").append(toIndentedString(dnsOptions)).append("\n");
        sb.append("    flags: ").append(toIndentedString(flags)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    resyncFlows: ").append(toIndentedString(resyncFlows)).append("\n");
        sb.append("    seParams: ").append(toIndentedString(seParams)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
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

