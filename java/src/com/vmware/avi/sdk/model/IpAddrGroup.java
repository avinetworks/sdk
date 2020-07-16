package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The IpAddrGroup is a POJO class extends AviRestResource that used for creating
 * IpAddrGroup.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IpAddrGroup extends AviRestResource  {
    @JsonProperty("addrs")
    private List<IpAddr> addrs = null;

    @JsonProperty("apic_epg_name")
    private String apicEpgName = null;

    @JsonProperty("country_codes")
    private List<String> countryCodes = null;

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("ip_ports")
    private List<IpAddrPort> ipPorts = null;

    @JsonProperty("marathon_app_name")
    private String marathonAppName = null;

    @JsonProperty("marathon_service_port")
    private Integer marathonServicePort = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("prefixes")
    private List<IpAddrPrefix> prefixes = null;

    @JsonProperty("ranges")
    private List<IpAddrRange> ranges = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;


  /**
   * This is the getter method this will return the attribute value.
   * Configure ip address(es).
   * @return addrs
   */
  public List<IpAddr> getAddrs() {
    return addrs;
  }

  /**
   * This is the setter method. this will set the addrs
   * Configure ip address(es).
   * @return addrs
   */
  public void setAddrs(List<IpAddr>  addrs) {
    this.addrs = addrs;
  }

  /**
   * This is the setter method this will set the addrs
   * Configure ip address(es).
   * @return addrs
   */
  public IpAddrGroup addAddrsItem(IpAddr addrsItem) {
    if (this.addrs == null) {
      this.addrs = new ArrayList<IpAddr>();
    }
    this.addrs.add(addrsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Populate ip addresses from members of this cisco apic epg.
   * @return apicEpgName
   */
  public String getApicEpgName() {
    return apicEpgName;
  }

  /**
   * This is the setter method to the attribute.
   * Populate ip addresses from members of this cisco apic epg.
   * @param apicEpgName set the apicEpgName.
   */
  public void setApicEpgName(String  apicEpgName) {
    this.apicEpgName = apicEpgName;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Populate the ip address ranges from the geo database for this country.
   * @return countryCodes
   */
  public List<String> getCountryCodes() {
    return countryCodes;
  }

  /**
   * This is the setter method. this will set the countryCodes
   * Populate the ip address ranges from the geo database for this country.
   * @return countryCodes
   */
  public void setCountryCodes(List<String>  countryCodes) {
    this.countryCodes = countryCodes;
  }

  /**
   * This is the setter method this will set the countryCodes
   * Populate the ip address ranges from the geo database for this country.
   * @return countryCodes
   */
  public IpAddrGroup addCountryCodesItem(String countryCodesItem) {
    if (this.countryCodes == null) {
      this.countryCodes = new ArrayList<String>();
    }
    this.countryCodes.add(countryCodesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * User defined description for the object.
   * @return description
   */
  public String getDescription() {
    return description;
  }

  /**
   * This is the setter method to the attribute.
   * User defined description for the object.
   * @param description set the description.
   */
  public void setDescription(String  description) {
    this.description = description;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Configure (ip address, port) tuple(s).
   * @return ipPorts
   */
  public List<IpAddrPort> getIpPorts() {
    return ipPorts;
  }

  /**
   * This is the setter method. this will set the ipPorts
   * Configure (ip address, port) tuple(s).
   * @return ipPorts
   */
  public void setIpPorts(List<IpAddrPort>  ipPorts) {
    this.ipPorts = ipPorts;
  }

  /**
   * This is the setter method this will set the ipPorts
   * Configure (ip address, port) tuple(s).
   * @return ipPorts
   */
  public IpAddrGroup addIpPortsItem(IpAddrPort ipPortsItem) {
    if (this.ipPorts == null) {
      this.ipPorts = new ArrayList<IpAddrPort>();
    }
    this.ipPorts.add(ipPortsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Populate ip addresses from tasks of this marathon app.
   * @return marathonAppName
   */
  public String getMarathonAppName() {
    return marathonAppName;
  }

  /**
   * This is the setter method to the attribute.
   * Populate ip addresses from tasks of this marathon app.
   * @param marathonAppName set the marathonAppName.
   */
  public void setMarathonAppName(String  marathonAppName) {
    this.marathonAppName = marathonAppName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Task port associated with marathon service port.
   * If marathon app has multiple service ports, this is required.
   * Else, the first task port is used.
   * @return marathonServicePort
   */
  public Integer getMarathonServicePort() {
    return marathonServicePort;
  }

  /**
   * This is the setter method to the attribute.
   * Task port associated with marathon service port.
   * If marathon app has multiple service ports, this is required.
   * Else, the first task port is used.
   * @param marathonServicePort set the marathonServicePort.
   */
  public void setMarathonServicePort(Integer  marathonServicePort) {
    this.marathonServicePort = marathonServicePort;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the ip address group.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the ip address group.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Configure ip address prefix(es).
   * @return prefixes
   */
  public List<IpAddrPrefix> getPrefixes() {
    return prefixes;
  }

  /**
   * This is the setter method. this will set the prefixes
   * Configure ip address prefix(es).
   * @return prefixes
   */
  public void setPrefixes(List<IpAddrPrefix>  prefixes) {
    this.prefixes = prefixes;
  }

  /**
   * This is the setter method this will set the prefixes
   * Configure ip address prefix(es).
   * @return prefixes
   */
  public IpAddrGroup addPrefixesItem(IpAddrPrefix prefixesItem) {
    if (this.prefixes == null) {
      this.prefixes = new ArrayList<IpAddrPrefix>();
    }
    this.prefixes.add(prefixesItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Configure ip address range(s).
   * @return ranges
   */
  public List<IpAddrRange> getRanges() {
    return ranges;
  }

  /**
   * This is the setter method. this will set the ranges
   * Configure ip address range(s).
   * @return ranges
   */
  public void setRanges(List<IpAddrRange>  ranges) {
    this.ranges = ranges;
  }

  /**
   * This is the setter method this will set the ranges
   * Configure ip address range(s).
   * @return ranges
   */
  public IpAddrGroup addRangesItem(IpAddrRange rangesItem) {
    if (this.ranges == null) {
      this.ranges = new ArrayList<IpAddrRange>();
    }
    this.ranges.add(rangesItem);
    return this;
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
   * Uuid of the ip address group.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the ip address group.
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
  IpAddrGroup objIpAddrGroup = (IpAddrGroup) o;
  return   Objects.equals(this.prefixes, objIpAddrGroup.prefixes)&&
  Objects.equals(this.uuid, objIpAddrGroup.uuid)&&
  Objects.equals(this.description, objIpAddrGroup.description)&&
  Objects.equals(this.tenantRef, objIpAddrGroup.tenantRef)&&
  Objects.equals(this.marathonServicePort, objIpAddrGroup.marathonServicePort)&&
  Objects.equals(this.apicEpgName, objIpAddrGroup.apicEpgName)&&
  Objects.equals(this.ranges, objIpAddrGroup.ranges)&&
  Objects.equals(this.addrs, objIpAddrGroup.addrs)&&
  Objects.equals(this.countryCodes, objIpAddrGroup.countryCodes)&&
  Objects.equals(this.marathonAppName, objIpAddrGroup.marathonAppName)&&
  Objects.equals(this.ipPorts, objIpAddrGroup.ipPorts)&&
  Objects.equals(this.name, objIpAddrGroup.name);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class IpAddrGroup {\n");
      sb.append("    addrs: ").append(toIndentedString(addrs)).append("\n");
        sb.append("    apicEpgName: ").append(toIndentedString(apicEpgName)).append("\n");
        sb.append("    countryCodes: ").append(toIndentedString(countryCodes)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    ipPorts: ").append(toIndentedString(ipPorts)).append("\n");
        sb.append("    marathonAppName: ").append(toIndentedString(marathonAppName)).append("\n");
        sb.append("    marathonServicePort: ").append(toIndentedString(marathonServicePort)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    prefixes: ").append(toIndentedString(prefixes)).append("\n");
        sb.append("    ranges: ").append(toIndentedString(ranges)).append("\n");
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

