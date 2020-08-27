package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The NetworkSubnetInfo is a POJO class extends AviRestResource that used for creating
 * NetworkSubnetInfo.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NetworkSubnetInfo  {
    @JsonProperty("free")
    private Integer free = null;

    @JsonProperty("network_name")
    private String networkName = null;

    @JsonProperty("network_uuid")
    private String networkUuid = null;

    @JsonProperty("subnet")
    private IpAddrPrefix subnet = null;

    @JsonProperty("total")
    private Integer total = null;

    @JsonProperty("used")
    private Integer used = null;



    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property free of obj type networksubnetinfo field type str  type integer.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return free
     */
    public Integer getFree() {
        return free;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property free of obj type networksubnetinfo field type str  type integer.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param free set the free.
     */
    public void setFree(Integer  free) {
        this.free = free;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property network_name of obj type networksubnetinfo field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return networkName
     */
    public String getNetworkName() {
        return networkName;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property network_name of obj type networksubnetinfo field type str  type string.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param networkName set the networkName.
     */
    public void setNetworkName(String  networkName) {
        this.networkName = networkName;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Unique object identifier of network.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return networkUuid
     */
    public String getNetworkUuid() {
        return networkUuid;
    }

    /**
     * This is the setter method to the attribute.
     * Unique object identifier of network.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param networkUuid set the networkUuid.
     */
    public void setNetworkUuid(String  networkUuid) {
        this.networkUuid = networkUuid;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property subnet of obj type networksubnetinfo field type str  type ref.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return subnet
     */
    public IpAddrPrefix getSubnet() {
        return subnet;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property subnet of obj type networksubnetinfo field type str  type ref.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param subnet set the subnet.
     */
    public void setSubnet(IpAddrPrefix subnet) {
        this.subnet = subnet;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property total of obj type networksubnetinfo field type str  type integer.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return total
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property total of obj type networksubnetinfo field type str  type integer.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param total set the total.
     */
    public void setTotal(Integer  total) {
        this.total = total;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property used of obj type networksubnetinfo field type str  type integer.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return used
     */
    public Integer getUsed() {
        return used;
    }

    /**
     * This is the setter method to the attribute.
     * Placeholder for description of property used of obj type networksubnetinfo field type str  type integer.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param used set the used.
     */
    public void setUsed(Integer  used) {
        this.used = used;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      NetworkSubnetInfo objNetworkSubnetInfo = (NetworkSubnetInfo) o;
      return   Objects.equals(this.networkUuid, objNetworkSubnetInfo.networkUuid)&&
  Objects.equals(this.networkName, objNetworkSubnetInfo.networkName)&&
  Objects.equals(this.subnet, objNetworkSubnetInfo.subnet)&&
  Objects.equals(this.total, objNetworkSubnetInfo.total)&&
  Objects.equals(this.used, objNetworkSubnetInfo.used)&&
  Objects.equals(this.free, objNetworkSubnetInfo.free);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class NetworkSubnetInfo {\n");
                  sb.append("    free: ").append(toIndentedString(free)).append("\n");
                        sb.append("    networkName: ").append(toIndentedString(networkName)).append("\n");
                        sb.append("    networkUuid: ").append(toIndentedString(networkUuid)).append("\n");
                        sb.append("    subnet: ").append(toIndentedString(subnet)).append("\n");
                        sb.append("    total: ").append(toIndentedString(total)).append("\n");
                        sb.append("    used: ").append(toIndentedString(used)).append("\n");
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
