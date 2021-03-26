package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The UserAgentCacheConfig is a POJO class extends AviRestResource that used for creating
 * UserAgentCacheConfig.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserAgentCacheConfig  {
    @JsonProperty("batch_size")
    private Integer batchSize = 100;

    @JsonProperty("controller_cache_size")
    private Integer controllerCacheSize = 300000;

    @JsonProperty("max_wait_time")
    private Integer maxWaitTime = 60;

    @JsonProperty("num_entries_upstream_update")
    private Integer numEntriesUpstreamUpdate = 100;

    @JsonProperty("percent_reserved_for_bad_bots")
    private Integer percentReservedForBadBots = 20;

    @JsonProperty("percent_reserved_for_browsers")
    private Integer percentReservedForBrowsers = 50;

    @JsonProperty("percent_reserved_for_good_bots")
    private Integer percentReservedForGoodBots = 20;

    @JsonProperty("percent_reserved_for_outstanding")
    private Integer percentReservedForOutstanding = 10;

    @JsonProperty("se_cache_size")
    private Integer seCacheSize = 20000;

    @JsonProperty("upstream_update_interval")
    private Integer upstreamUpdateInterval = 3600;



    /**
     * This is the getter method this will return the attribute value.
     * How many unknown user-agents to batch up before querying controller - unless max_wait_time is reached first.
     * Allowed values are 1-500.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as 100.
     * @return batchSize
     */
    public Integer getBatchSize() {
        return batchSize;
    }

    /**
     * This is the setter method to the attribute.
     * How many unknown user-agents to batch up before querying controller - unless max_wait_time is reached first.
     * Allowed values are 1-500.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as 100.
     * @param batchSize set the batchSize.
     */
    public void setBatchSize(Integer  batchSize) {
        this.batchSize = batchSize;
    }

    /**
     * This is the getter method this will return the attribute value.
     * The number of user-agent entries to cache on the controller.
     * Allowed values are 500-10000000.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as 300000.
     * @return controllerCacheSize
     */
    public Integer getControllerCacheSize() {
        return controllerCacheSize;
    }

    /**
     * This is the setter method to the attribute.
     * The number of user-agent entries to cache on the controller.
     * Allowed values are 500-10000000.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as 300000.
     * @param controllerCacheSize set the controllerCacheSize.
     */
    public void setControllerCacheSize(Integer  controllerCacheSize) {
        this.controllerCacheSize = controllerCacheSize;
    }

    /**
     * This is the getter method this will return the attribute value.
     * The time interval in seconds after which to make a request to the controller, even if the 'batch_size' hasn't been reached yet.
     * Field introduced in 21.1.1.
     * Unit is sec.
     * Default value when not specified in API or module is interpreted by Avi Controller as 60.
     * @return maxWaitTime
     */
    public Integer getMaxWaitTime() {
        return maxWaitTime;
    }

    /**
     * This is the setter method to the attribute.
     * The time interval in seconds after which to make a request to the controller, even if the 'batch_size' hasn't been reached yet.
     * Field introduced in 21.1.1.
     * Unit is sec.
     * Default value when not specified in API or module is interpreted by Avi Controller as 60.
     * @param maxWaitTime set the maxWaitTime.
     */
    public void setMaxWaitTime(Integer  maxWaitTime) {
        this.maxWaitTime = maxWaitTime;
    }

    /**
     * This is the getter method this will return the attribute value.
     * How many botuacacheresult elements to include in an upstream update message.
     * Allowed values are 1-10000.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as 100.
     * @return numEntriesUpstreamUpdate
     */
    public Integer getNumEntriesUpstreamUpdate() {
        return numEntriesUpstreamUpdate;
    }

    /**
     * This is the setter method to the attribute.
     * How many botuacacheresult elements to include in an upstream update message.
     * Allowed values are 1-10000.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as 100.
     * @param numEntriesUpstreamUpdate set the numEntriesUpstreamUpdate.
     */
    public void setNumEntriesUpstreamUpdate(Integer  numEntriesUpstreamUpdate) {
        this.numEntriesUpstreamUpdate = numEntriesUpstreamUpdate;
    }

    /**
     * This is the getter method this will return the attribute value.
     * How much space to reserve in percent for known bad bots.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as 20.
     * @return percentReservedForBadBots
     */
    public Integer getPercentReservedForBadBots() {
        return percentReservedForBadBots;
    }

    /**
     * This is the setter method to the attribute.
     * How much space to reserve in percent for known bad bots.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as 20.
     * @param percentReservedForBadBots set the percentReservedForBadBots.
     */
    public void setPercentReservedForBadBots(Integer  percentReservedForBadBots) {
        this.percentReservedForBadBots = percentReservedForBadBots;
    }

    /**
     * This is the getter method this will return the attribute value.
     * How much space to reserve in percent for browsers.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as 50.
     * @return percentReservedForBrowsers
     */
    public Integer getPercentReservedForBrowsers() {
        return percentReservedForBrowsers;
    }

    /**
     * This is the setter method to the attribute.
     * How much space to reserve in percent for browsers.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as 50.
     * @param percentReservedForBrowsers set the percentReservedForBrowsers.
     */
    public void setPercentReservedForBrowsers(Integer  percentReservedForBrowsers) {
        this.percentReservedForBrowsers = percentReservedForBrowsers;
    }

    /**
     * This is the getter method this will return the attribute value.
     * How much space to reserve in percent for known good bots.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as 20.
     * @return percentReservedForGoodBots
     */
    public Integer getPercentReservedForGoodBots() {
        return percentReservedForGoodBots;
    }

    /**
     * This is the setter method to the attribute.
     * How much space to reserve in percent for known good bots.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as 20.
     * @param percentReservedForGoodBots set the percentReservedForGoodBots.
     */
    public void setPercentReservedForGoodBots(Integer  percentReservedForGoodBots) {
        this.percentReservedForGoodBots = percentReservedForGoodBots;
    }

    /**
     * This is the getter method this will return the attribute value.
     * How much space to reserve in percent for outstanding upstream requests.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as 10.
     * @return percentReservedForOutstanding
     */
    public Integer getPercentReservedForOutstanding() {
        return percentReservedForOutstanding;
    }

    /**
     * This is the setter method to the attribute.
     * How much space to reserve in percent for outstanding upstream requests.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as 10.
     * @param percentReservedForOutstanding set the percentReservedForOutstanding.
     */
    public void setPercentReservedForOutstanding(Integer  percentReservedForOutstanding) {
        this.percentReservedForOutstanding = percentReservedForOutstanding;
    }

    /**
     * This is the getter method this will return the attribute value.
     * The number of user-agent entries to cache on each service engine.
     * Allowed values are 500-10000000.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as 20000.
     * @return seCacheSize
     */
    public Integer getSeCacheSize() {
        return seCacheSize;
    }

    /**
     * This is the setter method to the attribute.
     * The number of user-agent entries to cache on each service engine.
     * Allowed values are 500-10000000.
     * Field introduced in 21.1.1.
     * Default value when not specified in API or module is interpreted by Avi Controller as 20000.
     * @param seCacheSize set the seCacheSize.
     */
    public void setSeCacheSize(Integer  seCacheSize) {
        this.seCacheSize = seCacheSize;
    }

    /**
     * This is the getter method this will return the attribute value.
     * How often in seconds to send updates about user-agent cache entries to the next upstream cache.
     * Field introduced in 21.1.1.
     * Unit is sec.
     * Default value when not specified in API or module is interpreted by Avi Controller as 3600.
     * @return upstreamUpdateInterval
     */
    public Integer getUpstreamUpdateInterval() {
        return upstreamUpdateInterval;
    }

    /**
     * This is the setter method to the attribute.
     * How often in seconds to send updates about user-agent cache entries to the next upstream cache.
     * Field introduced in 21.1.1.
     * Unit is sec.
     * Default value when not specified in API or module is interpreted by Avi Controller as 3600.
     * @param upstreamUpdateInterval set the upstreamUpdateInterval.
     */
    public void setUpstreamUpdateInterval(Integer  upstreamUpdateInterval) {
        this.upstreamUpdateInterval = upstreamUpdateInterval;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      UserAgentCacheConfig objUserAgentCacheConfig = (UserAgentCacheConfig) o;
      return   Objects.equals(this.seCacheSize, objUserAgentCacheConfig.seCacheSize)&&
  Objects.equals(this.controllerCacheSize, objUserAgentCacheConfig.controllerCacheSize)&&
  Objects.equals(this.percentReservedForOutstanding, objUserAgentCacheConfig.percentReservedForOutstanding)&&
  Objects.equals(this.percentReservedForBrowsers, objUserAgentCacheConfig.percentReservedForBrowsers)&&
  Objects.equals(this.percentReservedForGoodBots, objUserAgentCacheConfig.percentReservedForGoodBots)&&
  Objects.equals(this.percentReservedForBadBots, objUserAgentCacheConfig.percentReservedForBadBots)&&
  Objects.equals(this.batchSize, objUserAgentCacheConfig.batchSize)&&
  Objects.equals(this.maxWaitTime, objUserAgentCacheConfig.maxWaitTime)&&
  Objects.equals(this.upstreamUpdateInterval, objUserAgentCacheConfig.upstreamUpdateInterval)&&
  Objects.equals(this.numEntriesUpstreamUpdate, objUserAgentCacheConfig.numEntriesUpstreamUpdate);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class UserAgentCacheConfig {\n");
                  sb.append("    batchSize: ").append(toIndentedString(batchSize)).append("\n");
                        sb.append("    controllerCacheSize: ").append(toIndentedString(controllerCacheSize)).append("\n");
                        sb.append("    maxWaitTime: ").append(toIndentedString(maxWaitTime)).append("\n");
                        sb.append("    numEntriesUpstreamUpdate: ").append(toIndentedString(numEntriesUpstreamUpdate)).append("\n");
                        sb.append("    percentReservedForBadBots: ").append(toIndentedString(percentReservedForBadBots)).append("\n");
                        sb.append("    percentReservedForBrowsers: ").append(toIndentedString(percentReservedForBrowsers)).append("\n");
                        sb.append("    percentReservedForGoodBots: ").append(toIndentedString(percentReservedForGoodBots)).append("\n");
                        sb.append("    percentReservedForOutstanding: ").append(toIndentedString(percentReservedForOutstanding)).append("\n");
                        sb.append("    seCacheSize: ").append(toIndentedString(seCacheSize)).append("\n");
                        sb.append("    upstreamUpdateInterval: ").append(toIndentedString(upstreamUpdateInterval)).append("\n");
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
