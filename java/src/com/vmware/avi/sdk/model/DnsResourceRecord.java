package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DnsResourceRecord is a POJO class extends AviRestResource that used for creating
 * DnsResourceRecord.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DnsResourceRecord  {
    @JsonProperty("addr6_ip_str")
    private String addr6IpStr = null;

    @JsonProperty("addr_ip")
    private Integer addrIp = null;

    @JsonProperty("cname")
    private String cname = null;

    @JsonProperty("dclass")
    private Integer dclass = null;

    @JsonProperty("location")
    private GeoLocation location = null;

    @JsonProperty("mail_server")
    private String mailServer = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("nsname")
    private String nsname = null;

    @JsonProperty("port")
    private Integer port = null;

    @JsonProperty("priority")
    private Integer priority = null;

    @JsonProperty("site_name")
    private String siteName = null;

    @JsonProperty("text_rdata")
    private String textRdata = null;

    @JsonProperty("ttl")
    private Integer ttl = null;

    @JsonProperty("type")
    private String type = null;

    @JsonProperty("vs_name")
    private String vsName = null;



  /**
   * This is the getter method this will return the attribute value.
   * Ipv6 address of the requested fqdn.
   * Field introduced in 18.1.1.
   * @return addr6IpStr
   */
  public String getAddr6IpStr() {
    return addr6IpStr;
  }

  /**
   * This is the setter method to the attribute.
   * Ipv6 address of the requested fqdn.
   * Field introduced in 18.1.1.
   * @param addr6IpStr set the addr6IpStr.
   */
  public void setAddr6IpStr(String  addr6IpStr) {
    this.addr6IpStr = addr6IpStr;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ipv4 address of the requested fqdn.
   * @return addrIp
   */
  public Integer getAddrIp() {
    return addrIp;
  }

  /**
   * This is the setter method to the attribute.
   * Ipv4 address of the requested fqdn.
   * @param addrIp set the addrIp.
   */
  public void setAddrIp(Integer  addrIp) {
    this.addrIp = addrIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Canonical (real) name of the requested fqdn.
   * @return cname
   */
  public String getCname() {
    return cname;
  }

  /**
   * This is the setter method to the attribute.
   * Canonical (real) name of the requested fqdn.
   * @param cname set the cname.
   */
  public void setCname(String  cname) {
    this.cname = cname;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Class of the data in the resource record.
   * @return dclass
   */
  public Integer getDclass() {
    return dclass;
  }

  /**
   * This is the setter method to the attribute.
   * Class of the data in the resource record.
   * @param dclass set the dclass.
   */
  public void setDclass(Integer  dclass) {
    this.dclass = dclass;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Geo location of member.
   * Field introduced in 17.1.1.
   * @return location
   */
  public GeoLocation getLocation() {
    return location;
  }

  /**
   * This is the setter method to the attribute.
   * Geo location of member.
   * Field introduced in 17.1.1.
   * @param location set the location.
   */
  public void setLocation(GeoLocation location) {
    this.location = location;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Fully qualified domain name of a mail server in the mx record.
   * Field introduced in 18.2.9, 20.1.1.
   * @return mailServer
   */
  public String getMailServer() {
    return mailServer;
  }

  /**
   * This is the setter method to the attribute.
   * Fully qualified domain name of a mail server in the mx record.
   * Field introduced in 18.2.9, 20.1.1.
   * @param mailServer set the mailServer.
   */
  public void setMailServer(String  mailServer) {
    this.mailServer = mailServer;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Domain name of the resource record.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Domain name of the resource record.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Domain name of the name server that is authoritative for the requested fqdn.
   * @return nsname
   */
  public String getNsname() {
    return nsname;
  }

  /**
   * This is the setter method to the attribute.
   * Domain name of the name server that is authoritative for the requested fqdn.
   * @param nsname set the nsname.
   */
  public void setNsname(String  nsname) {
    this.nsname = nsname;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Service port.
   * @return port
   */
  public Integer getPort() {
    return port;
  }

  /**
   * This is the setter method to the attribute.
   * Service port.
   * @param port set the port.
   */
  public void setPort(Integer  port) {
    this.port = port;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The priority field identifies which mail server should be preferred.
   * Field introduced in 18.2.9, 20.1.1.
   * @return priority
   */
  public Integer getPriority() {
    return priority;
  }

  /**
   * This is the setter method to the attribute.
   * The priority field identifies which mail server should be preferred.
   * Field introduced in 18.2.9, 20.1.1.
   * @param priority set the priority.
   */
  public void setPriority(Integer  priority) {
    this.priority = priority;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Site controller cluster name - applicable only for avi vs gslb member.
   * @return siteName
   */
  public String getSiteName() {
    return siteName;
  }

  /**
   * This is the setter method to the attribute.
   * Site controller cluster name - applicable only for avi vs gslb member.
   * @param siteName set the siteName.
   */
  public void setSiteName(String  siteName) {
    this.siteName = siteName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Text resource record.
   * Field introduced in 18.2.9, 20.1.1.
   * @return textRdata
   */
  public String getTextRdata() {
    return textRdata;
  }

  /**
   * This is the setter method to the attribute.
   * Text resource record.
   * Field introduced in 18.2.9, 20.1.1.
   * @param textRdata set the textRdata.
   */
  public void setTextRdata(String  textRdata) {
    this.textRdata = textRdata;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Number of seconds the resource record can be cached.
   * @return ttl
   */
  public Integer getTtl() {
    return ttl;
  }

  /**
   * This is the setter method to the attribute.
   * Number of seconds the resource record can be cached.
   * @param ttl set the ttl.
   */
  public void setTtl(Integer  ttl) {
    this.ttl = ttl;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Type of resource record.
   * Enum options - DNS_RECORD_OTHER, DNS_RECORD_A, DNS_RECORD_NS, DNS_RECORD_CNAME, DNS_RECORD_SOA, DNS_RECORD_PTR, DNS_RECORD_HINFO, DNS_RECORD_MX,
   * DNS_RECORD_TXT, DNS_RECORD_RP, DNS_RECORD_DNSKEY, DNS_RECORD_AAAA, DNS_RECORD_SRV, DNS_RECORD_OPT, DNS_RECORD_RRSIG, DNS_RECORD_AXFR,
   * DNS_RECORD_ANY.
   * @return type
   */
  public String getType() {
    return type;
  }

  /**
   * This is the setter method to the attribute.
   * Type of resource record.
   * Enum options - DNS_RECORD_OTHER, DNS_RECORD_A, DNS_RECORD_NS, DNS_RECORD_CNAME, DNS_RECORD_SOA, DNS_RECORD_PTR, DNS_RECORD_HINFO, DNS_RECORD_MX,
   * DNS_RECORD_TXT, DNS_RECORD_RP, DNS_RECORD_DNSKEY, DNS_RECORD_AAAA, DNS_RECORD_SRV, DNS_RECORD_OPT, DNS_RECORD_RRSIG, DNS_RECORD_AXFR,
   * DNS_RECORD_ANY.
   * @param type set the type.
   */
  public void setType(String  type) {
    this.type = type;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Virtual service name - applicable only for avi vs gslb member.
   * @return vsName
   */
  public String getVsName() {
    return vsName;
  }

  /**
   * This is the setter method to the attribute.
   * Virtual service name - applicable only for avi vs gslb member.
   * @param vsName set the vsName.
   */
  public void setVsName(String  vsName) {
    this.vsName = vsName;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  DnsResourceRecord objDnsResourceRecord = (DnsResourceRecord) o;
  return   Objects.equals(this.addrIp, objDnsResourceRecord.addrIp)&&
  Objects.equals(this.textRdata, objDnsResourceRecord.textRdata)&&
  Objects.equals(this.siteName, objDnsResourceRecord.siteName)&&
  Objects.equals(this.name, objDnsResourceRecord.name)&&
  Objects.equals(this.dclass, objDnsResourceRecord.dclass)&&
  Objects.equals(this.addr6IpStr, objDnsResourceRecord.addr6IpStr)&&
  Objects.equals(this.priority, objDnsResourceRecord.priority)&&
  Objects.equals(this.vsName, objDnsResourceRecord.vsName)&&
  Objects.equals(this.cname, objDnsResourceRecord.cname)&&
  Objects.equals(this.location, objDnsResourceRecord.location)&&
  Objects.equals(this.nsname, objDnsResourceRecord.nsname)&&
  Objects.equals(this.ttl, objDnsResourceRecord.ttl)&&
  Objects.equals(this.mailServer, objDnsResourceRecord.mailServer)&&
  Objects.equals(this.type, objDnsResourceRecord.type)&&
  Objects.equals(this.port, objDnsResourceRecord.port);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DnsResourceRecord {\n");
      sb.append("    addr6IpStr: ").append(toIndentedString(addr6IpStr)).append("\n");
        sb.append("    addrIp: ").append(toIndentedString(addrIp)).append("\n");
        sb.append("    cname: ").append(toIndentedString(cname)).append("\n");
        sb.append("    dclass: ").append(toIndentedString(dclass)).append("\n");
        sb.append("    location: ").append(toIndentedString(location)).append("\n");
        sb.append("    mailServer: ").append(toIndentedString(mailServer)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    nsname: ").append(toIndentedString(nsname)).append("\n");
        sb.append("    port: ").append(toIndentedString(port)).append("\n");
        sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
        sb.append("    siteName: ").append(toIndentedString(siteName)).append("\n");
        sb.append("    textRdata: ").append(toIndentedString(textRdata)).append("\n");
        sb.append("    ttl: ").append(toIndentedString(ttl)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    vsName: ").append(toIndentedString(vsName)).append("\n");
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

