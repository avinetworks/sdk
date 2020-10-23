package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The SeIpAddedEventDetails is a POJO class extends AviRestResource that used for creating
 * SeIpAddedEventDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeIpAddedEventDetails  {
    @JsonProperty("if_name")
    private String ifName = null;

    @JsonProperty("ip")
    private String ip = null;

    @JsonProperty("linux_name")
    private String linuxName = null;

    @JsonProperty("mac")
    private String mac = null;

    @JsonProperty("mask")
    private Integer mask = null;

    @JsonProperty("mode")
    private String mode = null;

    @JsonProperty("network_uuid")
    private String networkUuid = null;

    @JsonProperty("ns")
    private String ns = null;

    @JsonProperty("se_ref")
    private String seRef = null;



    /**
     * This is the getter method this will return the attribute value.
     * Vnic name.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return ifName
     */
    public String getIfName() {
        return ifName;
    }

    /**
     * This is the setter method to the attribute.
     * Vnic name.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param ifName set the ifName.
     */
    public void setIfName(String  ifName) {
        this.ifName = ifName;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Ip added.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * This is the setter method to the attribute.
     * Ip added.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param ip set the ip.
     */
    public void setIp(String  ip) {
        this.ip = ip;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Vnic linux name.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return linuxName
     */
    public String getLinuxName() {
        return linuxName;
    }

    /**
     * This is the setter method to the attribute.
     * Vnic linux name.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param linuxName set the linuxName.
     */
    public void setLinuxName(String  linuxName) {
        this.linuxName = linuxName;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Mac address.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return mac
     */
    public String getMac() {
        return mac;
    }

    /**
     * This is the setter method to the attribute.
     * Mac address.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param mac set the mac.
     */
    public void setMac(String  mac) {
        this.mac = mac;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Mask .
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return mask
     */
    public Integer getMask() {
        return mask;
    }

    /**
     * This is the setter method to the attribute.
     * Mask .
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param mask set the mask.
     */
    public void setMask(Integer  mask) {
        this.mask = mask;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Dchp or static.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return mode
     */
    public String getMode() {
        return mode;
    }

    /**
     * This is the setter method to the attribute.
     * Dchp or static.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param mode set the mode.
     */
    public void setMode(String  mode) {
        this.mode = mode;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Network uuid.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return networkUuid
     */
    public String getNetworkUuid() {
        return networkUuid;
    }

    /**
     * This is the setter method to the attribute.
     * Network uuid.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param networkUuid set the networkUuid.
     */
    public void setNetworkUuid(String  networkUuid) {
        this.networkUuid = networkUuid;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Namespace.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return ns
     */
    public String getNs() {
        return ns;
    }

    /**
     * This is the setter method to the attribute.
     * Namespace.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param ns set the ns.
     */
    public void setNs(String  ns) {
        this.ns = ns;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Uuid of the se responsible for this event.
     * It is a reference to an object of type serviceengine.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return seRef
     */
    public String getSeRef() {
        return seRef;
    }

    /**
     * This is the setter method to the attribute.
     * Uuid of the se responsible for this event.
     * It is a reference to an object of type serviceengine.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param seRef set the seRef.
     */
    public void setSeRef(String  seRef) {
        this.seRef = seRef;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      SeIpAddedEventDetails objSeIpAddedEventDetails = (SeIpAddedEventDetails) o;
      return   Objects.equals(this.seRef, objSeIpAddedEventDetails.seRef)&&
  Objects.equals(this.ifName, objSeIpAddedEventDetails.ifName)&&
  Objects.equals(this.linuxName, objSeIpAddedEventDetails.linuxName)&&
  Objects.equals(this.ip, objSeIpAddedEventDetails.ip)&&
  Objects.equals(this.mask, objSeIpAddedEventDetails.mask)&&
  Objects.equals(this.mode, objSeIpAddedEventDetails.mode)&&
  Objects.equals(this.ns, objSeIpAddedEventDetails.ns)&&
  Objects.equals(this.networkUuid, objSeIpAddedEventDetails.networkUuid)&&
  Objects.equals(this.mac, objSeIpAddedEventDetails.mac);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class SeIpAddedEventDetails {\n");
                  sb.append("    ifName: ").append(toIndentedString(ifName)).append("\n");
                        sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
                        sb.append("    linuxName: ").append(toIndentedString(linuxName)).append("\n");
                        sb.append("    mac: ").append(toIndentedString(mac)).append("\n");
                        sb.append("    mask: ").append(toIndentedString(mask)).append("\n");
                        sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
                        sb.append("    networkUuid: ").append(toIndentedString(networkUuid)).append("\n");
                        sb.append("    ns: ").append(toIndentedString(ns)).append("\n");
                        sb.append("    seRef: ").append(toIndentedString(seRef)).append("\n");
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
