package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The CompressionFilter is a POJO class extends AviRestResource that used for creating
 * CompressionFilter.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompressionFilter  {
    @JsonProperty("devices_ref")
    private String devicesRef = null;

    @JsonProperty("index")
    private Integer index = null;

    @JsonProperty("ip_addr_prefixes")
    private List<IpAddrPrefix> ipAddrPrefixes = null;

    @JsonProperty("ip_addr_ranges")
    private List<IpAddrRange> ipAddrRanges = null;

    @JsonProperty("ip_addrs")
    private List<IpAddr> ipAddrs = null;

    @JsonProperty("ip_addrs_ref")
    private String ipAddrsRef = null;

    @JsonProperty("level")
    private String level = "NORMAL_COMPRESSION";

    @JsonProperty("match")
    private String match = "IS_IN";

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("user_agent")
    private List<String> userAgent = null;



  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type stringgroup.
   * @return devicesRef
   */
  public String getDevicesRef() {
    return devicesRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type stringgroup.
   * @param devicesRef set the devicesRef.
   */
  public void setDevicesRef(String  devicesRef) {
    this.devicesRef = devicesRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property index of obj type compressionfilter field type str  type integer.
   * @return index
   */
  public Integer getIndex() {
    return index;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property index of obj type compressionfilter field type str  type integer.
   * @param index set the index.
   */
  public void setIndex(Integer  index) {
    this.index = index;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ip_addr_prefixes of obj type compressionfilter field type str  type array.
   * @return ipAddrPrefixes
   */
  public List<IpAddrPrefix> getIpAddrPrefixes() {
    return ipAddrPrefixes;
  }

  /**
   * This is the setter method. this will set the ipAddrPrefixes
   * Placeholder for description of property ip_addr_prefixes of obj type compressionfilter field type str  type array.
   * @return ipAddrPrefixes
   */
  public void setIpAddrPrefixes(List<IpAddrPrefix>  ipAddrPrefixes) {
    this.ipAddrPrefixes = ipAddrPrefixes;
  }

  /**
   * This is the setter method this will set the ipAddrPrefixes
   * Placeholder for description of property ip_addr_prefixes of obj type compressionfilter field type str  type array.
   * @return ipAddrPrefixes
   */
  public CompressionFilter addIpAddrPrefixesItem(IpAddrPrefix ipAddrPrefixesItem) {
    if (this.ipAddrPrefixes == null) {
      this.ipAddrPrefixes = new ArrayList<IpAddrPrefix>();
    }
    this.ipAddrPrefixes.add(ipAddrPrefixesItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ip_addr_ranges of obj type compressionfilter field type str  type array.
   * @return ipAddrRanges
   */
  public List<IpAddrRange> getIpAddrRanges() {
    return ipAddrRanges;
  }

  /**
   * This is the setter method. this will set the ipAddrRanges
   * Placeholder for description of property ip_addr_ranges of obj type compressionfilter field type str  type array.
   * @return ipAddrRanges
   */
  public void setIpAddrRanges(List<IpAddrRange>  ipAddrRanges) {
    this.ipAddrRanges = ipAddrRanges;
  }

  /**
   * This is the setter method this will set the ipAddrRanges
   * Placeholder for description of property ip_addr_ranges of obj type compressionfilter field type str  type array.
   * @return ipAddrRanges
   */
  public CompressionFilter addIpAddrRangesItem(IpAddrRange ipAddrRangesItem) {
    if (this.ipAddrRanges == null) {
      this.ipAddrRanges = new ArrayList<IpAddrRange>();
    }
    this.ipAddrRanges.add(ipAddrRangesItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ip_addrs of obj type compressionfilter field type str  type array.
   * @return ipAddrs
   */
  public List<IpAddr> getIpAddrs() {
    return ipAddrs;
  }

  /**
   * This is the setter method. this will set the ipAddrs
   * Placeholder for description of property ip_addrs of obj type compressionfilter field type str  type array.
   * @return ipAddrs
   */
  public void setIpAddrs(List<IpAddr>  ipAddrs) {
    this.ipAddrs = ipAddrs;
  }

  /**
   * This is the setter method this will set the ipAddrs
   * Placeholder for description of property ip_addrs of obj type compressionfilter field type str  type array.
   * @return ipAddrs
   */
  public CompressionFilter addIpAddrsItem(IpAddr ipAddrsItem) {
    if (this.ipAddrs == null) {
      this.ipAddrs = new ArrayList<IpAddr>();
    }
    this.ipAddrs.add(ipAddrsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type ipaddrgroup.
   * @return ipAddrsRef
   */
  public String getIpAddrsRef() {
    return ipAddrsRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type ipaddrgroup.
   * @param ipAddrsRef set the ipAddrsRef.
   */
  public void setIpAddrsRef(String  ipAddrsRef) {
    this.ipAddrsRef = ipAddrsRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - AGGRESSIVE_COMPRESSION, NORMAL_COMPRESSION, NO_COMPRESSION.
   * Default value when not specified in API or module is interpreted by Avi Controller as NORMAL_COMPRESSION.
   * @return level
   */
  public String getLevel() {
    return level;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - AGGRESSIVE_COMPRESSION, NORMAL_COMPRESSION, NO_COMPRESSION.
   * Default value when not specified in API or module is interpreted by Avi Controller as NORMAL_COMPRESSION.
   * @param level set the level.
   */
  public void setLevel(String  level) {
    this.level = level;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Whether to apply filter when group criteria is matched or not.
   * Enum options - IS_IN, IS_NOT_IN.
   * Default value when not specified in API or module is interpreted by Avi Controller as IS_IN.
   * @return match
   */
  public String getMatch() {
    return match;
  }

  /**
   * This is the setter method to the attribute.
   * Whether to apply filter when group criteria is matched or not.
   * Enum options - IS_IN, IS_NOT_IN.
   * Default value when not specified in API or module is interpreted by Avi Controller as IS_IN.
   * @param match set the match.
   */
  public void setMatch(String  match) {
    this.match = match;
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
   * Placeholder for description of property user_agent of obj type compressionfilter field type str  type array.
   * @return userAgent
   */
  public List<String> getUserAgent() {
    return userAgent;
  }

  /**
   * This is the setter method. this will set the userAgent
   * Placeholder for description of property user_agent of obj type compressionfilter field type str  type array.
   * @return userAgent
   */
  public void setUserAgent(List<String>  userAgent) {
    this.userAgent = userAgent;
  }

  /**
   * This is the setter method this will set the userAgent
   * Placeholder for description of property user_agent of obj type compressionfilter field type str  type array.
   * @return userAgent
   */
  public CompressionFilter addUserAgentItem(String userAgentItem) {
    if (this.userAgent == null) {
      this.userAgent = new ArrayList<String>();
    }
    this.userAgent.add(userAgentItem);
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
  CompressionFilter objCompressionFilter = (CompressionFilter) o;
  return   Objects.equals(this.index, objCompressionFilter.index)&&
  Objects.equals(this.ipAddrRanges, objCompressionFilter.ipAddrRanges)&&
  Objects.equals(this.name, objCompressionFilter.name)&&
  Objects.equals(this.level, objCompressionFilter.level)&&
  Objects.equals(this.ipAddrPrefixes, objCompressionFilter.ipAddrPrefixes)&&
  Objects.equals(this.devicesRef, objCompressionFilter.devicesRef)&&
  Objects.equals(this.ipAddrs, objCompressionFilter.ipAddrs)&&
  Objects.equals(this.userAgent, objCompressionFilter.userAgent)&&
  Objects.equals(this.ipAddrsRef, objCompressionFilter.ipAddrsRef)&&
  Objects.equals(this.match, objCompressionFilter.match);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class CompressionFilter {\n");
      sb.append("    devicesRef: ").append(toIndentedString(devicesRef)).append("\n");
        sb.append("    index: ").append(toIndentedString(index)).append("\n");
        sb.append("    ipAddrPrefixes: ").append(toIndentedString(ipAddrPrefixes)).append("\n");
        sb.append("    ipAddrRanges: ").append(toIndentedString(ipAddrRanges)).append("\n");
        sb.append("    ipAddrs: ").append(toIndentedString(ipAddrs)).append("\n");
        sb.append("    ipAddrsRef: ").append(toIndentedString(ipAddrsRef)).append("\n");
        sb.append("    level: ").append(toIndentedString(level)).append("\n");
        sb.append("    match: ").append(toIndentedString(match)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    userAgent: ").append(toIndentedString(userAgent)).append("\n");
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

