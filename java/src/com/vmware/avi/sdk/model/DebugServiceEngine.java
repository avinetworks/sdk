package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The DebugServiceEngine is a POJO class extends AviRestResource that used for creating
 * DebugServiceEngine.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DebugServiceEngine extends AviRestResource  {
    @JsonProperty("benchmark_action")
    private String benchmarkAction = "SE_BENCHMARK_MODE_DROP";

    @JsonProperty("benchmark_layer")
    private String benchmarkLayer = "SE_BENCHMARK_LAYER_NONE";

    @JsonProperty("benchmark_option")
    private String benchmarkOption = "SE_BENCHMARK_REFLECT_SWAP_L4";

    @JsonProperty("benchmark_rss_hash")
    private String benchmarkRssHash = "SE_BENCHMARK_DISABLE_HASH";

    @JsonProperty("capture")
    private Boolean capture = null;

    @JsonProperty("capture_filters")
    private CaptureFilters captureFilters = null;

    @JsonProperty("capture_params")
    private DebugVirtualServiceCapture captureParams = null;

    @JsonProperty("cpu_shares")
    private List<DebugSeCpuShares> cpuShares = null;

    @JsonProperty("debug_ip")
    private DebugIpAddr debugIp = null;

    @JsonProperty("enable_kdump")
    private Boolean enableKdump = false;

    @JsonProperty("fault")
    private DebugSeFault fault = null;

    @JsonProperty("flags")
    private List<DebugSeDataplane> flags = null;

    @JsonProperty("name")
    private String name = "VM name unknown";

    @JsonProperty("seagent_debug")
    private List<DebugSeAgent> seagentDebug = null;

    @JsonProperty("selogagent_debug")
    private DebugSeAgent selogagentDebug = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



    /**
     * This is the getter method this will return the attribute value.
     * Action to be invoked at configured layer.
     * Enum options - SE_BENCHMARK_MODE_DROP, SE_BENCHMARK_MODE_REFLECT.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as "SE_BENCHMARK_MODE_DROP".
     * @return benchmarkAction
     */
    public String getBenchmarkAction() {
        return benchmarkAction;
    }

    /**
     * This is the setter method to the attribute.
     * Action to be invoked at configured layer.
     * Enum options - SE_BENCHMARK_MODE_DROP, SE_BENCHMARK_MODE_REFLECT.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as "SE_BENCHMARK_MODE_DROP".
     * @param benchmarkAction set the benchmarkAction.
     */
    public void setBenchmarkAction(String  benchmarkAction) {
        this.benchmarkAction = benchmarkAction;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Toggle and configure the layer to benchmark performance.
     * This can be done at a specific point in the se packet processing pipeline.
     * Enum options - SE_BENCHMARK_LAYER_NONE, SE_BENCHMARK_LAYER_POST_VNIC_RX, SE_BENCHMARK_LAYER_POST_FT_LOOKUP, SE_BENCHMARK_LAYER_NSP_LOOKUP,
     * SE_BENCHMARK_LAYER_PRE_PROXY_PUNT, SE_BENCHMARK_LAYER_POST_PROXY_PUNT, SE_BENCHMARK_LAYER_ETHER_INPUT, SE_BENCHMARK_LAYER_IP_INPUT,
     * SE_BENCHMARK_LAYER_UDP_INPUT.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as "SE_BENCHMARK_LAYER_NONE".
     * @return benchmarkLayer
     */
    public String getBenchmarkLayer() {
        return benchmarkLayer;
    }

    /**
     * This is the setter method to the attribute.
     * Toggle and configure the layer to benchmark performance.
     * This can be done at a specific point in the se packet processing pipeline.
     * Enum options - SE_BENCHMARK_LAYER_NONE, SE_BENCHMARK_LAYER_POST_VNIC_RX, SE_BENCHMARK_LAYER_POST_FT_LOOKUP, SE_BENCHMARK_LAYER_NSP_LOOKUP,
     * SE_BENCHMARK_LAYER_PRE_PROXY_PUNT, SE_BENCHMARK_LAYER_POST_PROXY_PUNT, SE_BENCHMARK_LAYER_ETHER_INPUT, SE_BENCHMARK_LAYER_IP_INPUT,
     * SE_BENCHMARK_LAYER_UDP_INPUT.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as "SE_BENCHMARK_LAYER_NONE".
     * @param benchmarkLayer set the benchmarkLayer.
     */
    public void setBenchmarkLayer(String  benchmarkLayer) {
        this.benchmarkLayer = benchmarkLayer;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Configure different reflect modes.
     * Enum options - SE_BENCHMARK_REFLECT_SWAP_L4, SE_BENCHMARK_REFLECT_SWAP_L2, SE_BENCHMARK_REFLECT_SWAP_L3.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as "SE_BENCHMARK_REFLECT_SWAP_L4".
     * @return benchmarkOption
     */
    public String getBenchmarkOption() {
        return benchmarkOption;
    }

    /**
     * This is the setter method to the attribute.
     * Configure different reflect modes.
     * Enum options - SE_BENCHMARK_REFLECT_SWAP_L4, SE_BENCHMARK_REFLECT_SWAP_L2, SE_BENCHMARK_REFLECT_SWAP_L3.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as "SE_BENCHMARK_REFLECT_SWAP_L4".
     * @param benchmarkOption set the benchmarkOption.
     */
    public void setBenchmarkOption(String  benchmarkOption) {
        this.benchmarkOption = benchmarkOption;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Rss hash function to be used for packet reflect in tx path.
     * Enum options - SE_BENCHMARK_DISABLE_HASH, SE_BENCHMARK_RTE_SOFT_HASH.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as "SE_BENCHMARK_DISABLE_HASH".
     * @return benchmarkRssHash
     */
    public String getBenchmarkRssHash() {
        return benchmarkRssHash;
    }

    /**
     * This is the setter method to the attribute.
     * Rss hash function to be used for packet reflect in tx path.
     * Enum options - SE_BENCHMARK_DISABLE_HASH, SE_BENCHMARK_RTE_SOFT_HASH.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as "SE_BENCHMARK_DISABLE_HASH".
     * @param benchmarkRssHash set the benchmarkRssHash.
     */
    public void setBenchmarkRssHash(String  benchmarkRssHash) {
        this.benchmarkRssHash = benchmarkRssHash;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Enable/disable packet capture.
     * Field introduced in 18.2.2.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return capture
     */
    public Boolean getCapture() {
        return capture;
    }

    /**
     * This is the setter method to the attribute.
     * Enable/disable packet capture.
     * Field introduced in 18.2.2.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param capture set the capture.
     */
    public void setCapture(Boolean  capture) {
        this.capture = capture;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Per packet capture filters for debug service engine.
     * Not applicable for dos pcap capture.
     * Field introduced in 18.2.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return captureFilters
     */
    public CaptureFilters getCaptureFilters() {
        return captureFilters;
    }

    /**
     * This is the setter method to the attribute.
     * Per packet capture filters for debug service engine.
     * Not applicable for dos pcap capture.
     * Field introduced in 18.2.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param captureFilters set the captureFilters.
     */
    public void setCaptureFilters(CaptureFilters captureFilters) {
        this.captureFilters = captureFilters;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Params for se pcap.
     * Field introduced in 17.2.14,18.1.5,18.2.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return captureParams
     */
    public DebugVirtualServiceCapture getCaptureParams() {
        return captureParams;
    }

    /**
     * This is the setter method to the attribute.
     * Params for se pcap.
     * Field introduced in 17.2.14,18.1.5,18.2.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param captureParams set the captureParams.
     */
    public void setCaptureParams(DebugVirtualServiceCapture captureParams) {
        this.captureParams = captureParams;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property cpu_shares of obj type debugserviceengine field type str  type array.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return cpuShares
     */
    public List<DebugSeCpuShares> getCpuShares() {
        return cpuShares;
    }

    /**
     * This is the setter method. this will set the cpuShares
     * Placeholder for description of property cpu_shares of obj type debugserviceengine field type str  type array.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return cpuShares
     */
    public void setCpuShares(List<DebugSeCpuShares>  cpuShares) {
        this.cpuShares = cpuShares;
    }

    /**
     * This is the setter method this will set the cpuShares
     * Placeholder for description of property cpu_shares of obj type debugserviceengine field type str  type array.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return cpuShares
     */
    public DebugServiceEngine addCpuSharesItem(DebugSeCpuShares cpuSharesItem) {
      if (this.cpuShares == null) {
        this.cpuShares = new ArrayList<DebugSeCpuShares>();
      }
      this.cpuShares.add(cpuSharesItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Per packet ip filter for service engine pcap.
     * Matches with source and destination address.
     * Field introduced in 17.2.14,18.1.5,18.2.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return debugIp
     */
    public DebugIpAddr getDebugIp() {
        return debugIp;
    }

    /**
     * This is the setter method to the attribute.
     * Per packet ip filter for service engine pcap.
     * Matches with source and destination address.
     * Field introduced in 17.2.14,18.1.5,18.2.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param debugIp set the debugIp.
     */
    public void setDebugIp(DebugIpAddr debugIp) {
        this.debugIp = debugIp;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Enables the use of kdump on se.
     * Requires se reboot.
     * Applicable only in case of vm based deployments.
     * Field introduced in 18.2.10, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @return enableKdump
     */
    public Boolean getEnableKdump() {
        return enableKdump;
    }

    /**
     * This is the setter method to the attribute.
     * Enables the use of kdump on se.
     * Requires se reboot.
     * Applicable only in case of vm based deployments.
     * Field introduced in 18.2.10, 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @param enableKdump set the enableKdump.
     */
    public void setEnableKdump(Boolean  enableKdump) {
        this.enableKdump = enableKdump;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Params for se fault injection.
     * Field introduced in 18.1.2.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return fault
     */
    public DebugSeFault getFault() {
        return fault;
    }

    /**
     * This is the setter method to the attribute.
     * Params for se fault injection.
     * Field introduced in 18.1.2.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param fault set the fault.
     */
    public void setFault(DebugSeFault fault) {
        this.fault = fault;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property flags of obj type debugserviceengine field type str  type array.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return flags
     */
    public List<DebugSeDataplane> getFlags() {
        return flags;
    }

    /**
     * This is the setter method. this will set the flags
     * Placeholder for description of property flags of obj type debugserviceengine field type str  type array.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return flags
     */
    public void setFlags(List<DebugSeDataplane>  flags) {
        this.flags = flags;
    }

    /**
     * This is the setter method this will set the flags
     * Placeholder for description of property flags of obj type debugserviceengine field type str  type array.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return flags
     */
    public DebugServiceEngine addFlagsItem(DebugSeDataplane flagsItem) {
      if (this.flags == null) {
        this.flags = new ArrayList<DebugSeDataplane>();
      }
      this.flags.add(flagsItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Name of the object.
     * Default value when not specified in API or module is interpreted by Avi Controller as "VM name unknown".
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This is the setter method to the attribute.
     * Name of the object.
     * Default value when not specified in API or module is interpreted by Avi Controller as "VM name unknown".
     * @param name set the name.
     */
    public void setName(String  name) {
        this.name = name;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property seagent_debug of obj type debugserviceengine field type str  type array.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return seagentDebug
     */
    public List<DebugSeAgent> getSeagentDebug() {
        return seagentDebug;
    }

    /**
     * This is the setter method. this will set the seagentDebug
     * Placeholder for description of property seagent_debug of obj type debugserviceengine field type str  type array.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return seagentDebug
     */
    public void setSeagentDebug(List<DebugSeAgent>  seagentDebug) {
        this.seagentDebug = seagentDebug;
    }

    /**
     * This is the setter method this will set the seagentDebug
     * Placeholder for description of property seagent_debug of obj type debugserviceengine field type str  type array.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return seagentDebug
     */
    public DebugServiceEngine addSeagentDebugItem(DebugSeAgent seagentDebugItem) {
      if (this.seagentDebug == null) {
        this.seagentDebug = new ArrayList<DebugSeAgent>();
      }
      this.seagentDebug.add(seagentDebugItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Debug knob for se_log_agent process.
     * Field introduced in 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return selogagentDebug
     */
    public DebugSeAgent getSelogagentDebug() {
        return selogagentDebug;
    }

    /**
     * This is the setter method to the attribute.
     * Debug knob for se_log_agent process.
     * Field introduced in 20.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param selogagentDebug set the selogagentDebug.
     */
    public void setSelogagentDebug(DebugSeAgent selogagentDebug) {
        this.selogagentDebug = selogagentDebug;
    }

    /**
     * This is the getter method this will return the attribute value.
     * It is a reference to an object of type tenant.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return tenantRef
     */
    public String getTenantRef() {
        return tenantRef;
    }

    /**
     * This is the setter method to the attribute.
     * It is a reference to an object of type tenant.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
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
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This is the setter method to the attribute.
     * Unique object identifier of the object.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
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
      DebugServiceEngine objDebugServiceEngine = (DebugServiceEngine) o;
      return   Objects.equals(this.uuid, objDebugServiceEngine.uuid)&&
  Objects.equals(this.name, objDebugServiceEngine.name)&&
  Objects.equals(this.seagentDebug, objDebugServiceEngine.seagentDebug)&&
  Objects.equals(this.flags, objDebugServiceEngine.flags)&&
  Objects.equals(this.cpuShares, objDebugServiceEngine.cpuShares)&&
  Objects.equals(this.fault, objDebugServiceEngine.fault)&&
  Objects.equals(this.debugIp, objDebugServiceEngine.debugIp)&&
  Objects.equals(this.captureParams, objDebugServiceEngine.captureParams)&&
  Objects.equals(this.capture, objDebugServiceEngine.capture)&&
  Objects.equals(this.captureFilters, objDebugServiceEngine.captureFilters)&&
  Objects.equals(this.selogagentDebug, objDebugServiceEngine.selogagentDebug)&&
  Objects.equals(this.enableKdump, objDebugServiceEngine.enableKdump)&&
  Objects.equals(this.benchmarkLayer, objDebugServiceEngine.benchmarkLayer)&&
  Objects.equals(this.benchmarkAction, objDebugServiceEngine.benchmarkAction)&&
  Objects.equals(this.benchmarkOption, objDebugServiceEngine.benchmarkOption)&&
  Objects.equals(this.benchmarkRssHash, objDebugServiceEngine.benchmarkRssHash)&&
  Objects.equals(this.tenantRef, objDebugServiceEngine.tenantRef);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class DebugServiceEngine {\n");
                  sb.append("    benchmarkAction: ").append(toIndentedString(benchmarkAction)).append("\n");
                        sb.append("    benchmarkLayer: ").append(toIndentedString(benchmarkLayer)).append("\n");
                        sb.append("    benchmarkOption: ").append(toIndentedString(benchmarkOption)).append("\n");
                        sb.append("    benchmarkRssHash: ").append(toIndentedString(benchmarkRssHash)).append("\n");
                        sb.append("    capture: ").append(toIndentedString(capture)).append("\n");
                        sb.append("    captureFilters: ").append(toIndentedString(captureFilters)).append("\n");
                        sb.append("    captureParams: ").append(toIndentedString(captureParams)).append("\n");
                        sb.append("    cpuShares: ").append(toIndentedString(cpuShares)).append("\n");
                        sb.append("    debugIp: ").append(toIndentedString(debugIp)).append("\n");
                        sb.append("    enableKdump: ").append(toIndentedString(enableKdump)).append("\n");
                        sb.append("    fault: ").append(toIndentedString(fault)).append("\n");
                        sb.append("    flags: ").append(toIndentedString(flags)).append("\n");
                        sb.append("    name: ").append(toIndentedString(name)).append("\n");
                        sb.append("    seagentDebug: ").append(toIndentedString(seagentDebug)).append("\n");
                        sb.append("    selogagentDebug: ").append(toIndentedString(selogagentDebug)).append("\n");
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
