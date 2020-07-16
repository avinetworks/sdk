package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DNSConfiguration is a POJO class extends AviRestResource that used for creating
 * DNSConfiguration.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DNSConfiguration  {
    @JsonProperty("search_domain")
    private String searchDomain = null;

    @JsonProperty("server_list")
    private List<IpAddr> serverList = null;



  /**
   * This is the getter method this will return the attribute value.
   * Search domain to use in dns lookup.
   * @return searchDomain
   */
  public String getSearchDomain() {
    return searchDomain;
  }

  /**
   * This is the setter method to the attribute.
   * Search domain to use in dns lookup.
   * @param searchDomain set the searchDomain.
   */
  public void setSearchDomain(String  searchDomain) {
    this.searchDomain = searchDomain;
  }
  /**
   * This is the getter method this will return the attribute value.
   * List of dns server ip addresses.
   * @return serverList
   */
  public List<IpAddr> getServerList() {
    return serverList;
  }

  /**
   * This is the setter method. this will set the serverList
   * List of dns server ip addresses.
   * @return serverList
   */
  public void setServerList(List<IpAddr>  serverList) {
    this.serverList = serverList;
  }

  /**
   * This is the setter method this will set the serverList
   * List of dns server ip addresses.
   * @return serverList
   */
  public DNSConfiguration addServerListItem(IpAddr serverListItem) {
    if (this.serverList == null) {
      this.serverList = new ArrayList<IpAddr>();
    }
    this.serverList.add(serverListItem);
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
  DNSConfiguration objDNSConfiguration = (DNSConfiguration) o;
  return   Objects.equals(this.searchDomain, objDNSConfiguration.searchDomain)&&
  Objects.equals(this.serverList, objDNSConfiguration.serverList);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DNSConfiguration {\n");
      sb.append("    searchDomain: ").append(toIndentedString(searchDomain)).append("\n");
        sb.append("    serverList: ").append(toIndentedString(serverList)).append("\n");
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

