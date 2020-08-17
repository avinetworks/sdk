package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The NTPConfiguration is a POJO class extends AviRestResource that used for creating
 * NTPConfiguration.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NTPConfiguration  {
    @JsonProperty("ntp_authentication_keys")
    private List<NTPAuthenticationKey> ntpAuthenticationKeys = null;

    @JsonProperty("ntp_server_list")
    private List<IpAddr> ntpServerList = null;

    @JsonProperty("ntp_servers")
    private List<NTPServer> ntpServers = null;


  /**
   * This is the getter method this will return the attribute value.
   * Ntp authentication keys.
   * @return ntpAuthenticationKeys
   */
  public List<NTPAuthenticationKey> getNtpAuthenticationKeys() {
    return ntpAuthenticationKeys;
  }

  /**
   * This is the setter method. this will set the ntpAuthenticationKeys
   * Ntp authentication keys.
   * @return ntpAuthenticationKeys
   */
  public void setNtpAuthenticationKeys(List<NTPAuthenticationKey>  ntpAuthenticationKeys) {
    this.ntpAuthenticationKeys = ntpAuthenticationKeys;
  }

  /**
   * This is the setter method this will set the ntpAuthenticationKeys
   * Ntp authentication keys.
   * @return ntpAuthenticationKeys
   */
  public NTPConfiguration addNtpAuthenticationKeysItem(NTPAuthenticationKey ntpAuthenticationKeysItem) {
    if (this.ntpAuthenticationKeys == null) {
      this.ntpAuthenticationKeys = new ArrayList<NTPAuthenticationKey>();
    }
    this.ntpAuthenticationKeys.add(ntpAuthenticationKeysItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * List of ntp server hostnames or ip addresses.
   * @return ntpServerList
   */
  public List<IpAddr> getNtpServerList() {
    return ntpServerList;
  }

  /**
   * This is the setter method. this will set the ntpServerList
   * List of ntp server hostnames or ip addresses.
   * @return ntpServerList
   */
  public void setNtpServerList(List<IpAddr>  ntpServerList) {
    this.ntpServerList = ntpServerList;
  }

  /**
   * This is the setter method this will set the ntpServerList
   * List of ntp server hostnames or ip addresses.
   * @return ntpServerList
   */
  public NTPConfiguration addNtpServerListItem(IpAddr ntpServerListItem) {
    if (this.ntpServerList == null) {
      this.ntpServerList = new ArrayList<IpAddr>();
    }
    this.ntpServerList.add(ntpServerListItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * List of ntp servers.
   * @return ntpServers
   */
  public List<NTPServer> getNtpServers() {
    return ntpServers;
  }

  /**
   * This is the setter method. this will set the ntpServers
   * List of ntp servers.
   * @return ntpServers
   */
  public void setNtpServers(List<NTPServer>  ntpServers) {
    this.ntpServers = ntpServers;
  }

  /**
   * This is the setter method this will set the ntpServers
   * List of ntp servers.
   * @return ntpServers
   */
  public NTPConfiguration addNtpServersItem(NTPServer ntpServersItem) {
    if (this.ntpServers == null) {
      this.ntpServers = new ArrayList<NTPServer>();
    }
    this.ntpServers.add(ntpServersItem);
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
  NTPConfiguration objNTPConfiguration = (NTPConfiguration) o;
  return   Objects.equals(this.ntpServerList, objNTPConfiguration.ntpServerList)&&
  Objects.equals(this.ntpAuthenticationKeys, objNTPConfiguration.ntpAuthenticationKeys)&&
  Objects.equals(this.ntpServers, objNTPConfiguration.ntpServers);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class NTPConfiguration {\n");
      sb.append("    ntpAuthenticationKeys: ").append(toIndentedString(ntpAuthenticationKeys)).append("\n");
        sb.append("    ntpServerList: ").append(toIndentedString(ntpServerList)).append("\n");
        sb.append("    ntpServers: ").append(toIndentedString(ntpServers)).append("\n");
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

