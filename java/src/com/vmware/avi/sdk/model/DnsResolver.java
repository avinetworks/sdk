package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The DnsResolver is a POJO class extends AviRestResource that used for creating
 * DnsResolver.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DnsResolver  {
    @JsonProperty("fixed_ttl")
    private Integer fixedTtl = null;

    @JsonProperty("min_ttl")
    private Integer minTtl = 5;

    @JsonProperty("nameserver_ips")
    private List<IpAddr> nameserverIps = null;

    @JsonProperty("resolver_name")
    private String resolverName = null;

    @JsonProperty("use_mgmt")
    private Boolean useMgmt = false;



    /**
     * This is the getter method this will return the attribute value.
     * If configured, this value used for refreshing the dns entries.overrides both received_ttl and min_ttl.
     * The entries are refreshed only on fixed_ttleven when received_ttl is less than fixed_ttl.
     * Allowed values are 5-2147483647.
     * Field introduced in 20.1.5.
     * Unit is sec.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return fixedTtl
     */
    public Integer getFixedTtl() {
        return fixedTtl;
    }

    /**
     * This is the setter method to the attribute.
     * If configured, this value used for refreshing the dns entries.overrides both received_ttl and min_ttl.
     * The entries are refreshed only on fixed_ttleven when received_ttl is less than fixed_ttl.
     * Allowed values are 5-2147483647.
     * Field introduced in 20.1.5.
     * Unit is sec.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param fixedTtl set the fixedTtl.
     */
    public void setFixedTtl(Integer  fixedTtl) {
        this.fixedTtl = fixedTtl;
    }

    /**
     * This is the getter method this will return the attribute value.
     * If configured, this ttl overrides the ttl from responses if ttl < min_ttl.effectively ttl = max(recieved_ttl, min_ttl).
     * Allowed values are 5-2147483647.
     * Field introduced in 20.1.5.
     * Unit is sec.
     * Default value when not specified in API or module is interpreted by Avi Controller as 5.
     * @return minTtl
     */
    public Integer getMinTtl() {
        return minTtl;
    }

    /**
     * This is the setter method to the attribute.
     * If configured, this ttl overrides the ttl from responses if ttl < min_ttl.effectively ttl = max(recieved_ttl, min_ttl).
     * Allowed values are 5-2147483647.
     * Field introduced in 20.1.5.
     * Unit is sec.
     * Default value when not specified in API or module is interpreted by Avi Controller as 5.
     * @param minTtl set the minTtl.
     */
    public void setMinTtl(Integer  minTtl) {
        this.minTtl = minTtl;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Name server ipv4 addresses.
     * Field introduced in 20.1.5.
     * Minimum of 1 items required.
     * Maximum of 10 items allowed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return nameserverIps
     */
    public List<IpAddr> getNameserverIps() {
        return nameserverIps;
    }

    /**
     * This is the setter method. this will set the nameserverIps
     * Name server ipv4 addresses.
     * Field introduced in 20.1.5.
     * Minimum of 1 items required.
     * Maximum of 10 items allowed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return nameserverIps
     */
    public void setNameserverIps(List<IpAddr>  nameserverIps) {
        this.nameserverIps = nameserverIps;
    }

    /**
     * This is the setter method this will set the nameserverIps
     * Name server ipv4 addresses.
     * Field introduced in 20.1.5.
     * Minimum of 1 items required.
     * Maximum of 10 items allowed.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return nameserverIps
     */
    public DnsResolver addNameserverIpsItem(IpAddr nameserverIpsItem) {
      if (this.nameserverIps == null) {
        this.nameserverIps = new ArrayList<IpAddr>();
      }
      this.nameserverIps.add(nameserverIpsItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Unique name for resolver config.
     * Field introduced in 20.1.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return resolverName
     */
    public String getResolverName() {
        return resolverName;
    }

    /**
     * This is the setter method to the attribute.
     * Unique name for resolver config.
     * Field introduced in 20.1.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param resolverName set the resolverName.
     */
    public void setResolverName(String  resolverName) {
        this.resolverName = resolverName;
    }

    /**
     * This is the getter method this will return the attribute value.
     * If enabled, dns resolution is performed via management network.
     * Field introduced in 20.1.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @return useMgmt
     */
    public Boolean getUseMgmt() {
        return useMgmt;
    }

    /**
     * This is the setter method to the attribute.
     * If enabled, dns resolution is performed via management network.
     * Field introduced in 20.1.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @param useMgmt set the useMgmt.
     */
    public void setUseMgmt(Boolean  useMgmt) {
        this.useMgmt = useMgmt;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      DnsResolver objDnsResolver = (DnsResolver) o;
      return   Objects.equals(this.resolverName, objDnsResolver.resolverName)&&
  Objects.equals(this.nameserverIps, objDnsResolver.nameserverIps)&&
  Objects.equals(this.fixedTtl, objDnsResolver.fixedTtl)&&
  Objects.equals(this.minTtl, objDnsResolver.minTtl)&&
  Objects.equals(this.useMgmt, objDnsResolver.useMgmt);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class DnsResolver {\n");
                  sb.append("    fixedTtl: ").append(toIndentedString(fixedTtl)).append("\n");
                        sb.append("    minTtl: ").append(toIndentedString(minTtl)).append("\n");
                        sb.append("    nameserverIps: ").append(toIndentedString(nameserverIps)).append("\n");
                        sb.append("    resolverName: ").append(toIndentedString(resolverName)).append("\n");
                        sb.append("    useMgmt: ").append(toIndentedString(useMgmt)).append("\n");
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
