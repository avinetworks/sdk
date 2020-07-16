package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SnmpConfiguration is a POJO class extends AviRestResource that used for creating
 * SnmpConfiguration.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SnmpConfiguration  {
    @JsonProperty("community")
    private String community = null;

    @JsonProperty("large_trap_payload")
    private Boolean largeTrapPayload = false;

    @JsonProperty("snmp_v3_config")
    private SnmpV3Configuration snmpV3Config = null;

    @JsonProperty("sys_contact")
    private String sysContact = "support@avinetworks.com";

    @JsonProperty("sys_location")
    private String sysLocation = null;

    @JsonProperty("version")
    private String version = "SNMP_VER2";



  /**
   * This is the getter method this will return the attribute value.
   * Community string for snmp v2c.
   * @return community
   */
  public String getCommunity() {
    return community;
  }

  /**
   * This is the setter method to the attribute.
   * Community string for snmp v2c.
   * @param community set the community.
   */
  public void setCommunity(String  community) {
    this.community = community;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Support for 4096 bytes trap payload.
   * Field introduced in 17.2.13,18.1.4,18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return largeTrapPayload
   */
  public Boolean getLargeTrapPayload() {
    return largeTrapPayload;
  }

  /**
   * This is the setter method to the attribute.
   * Support for 4096 bytes trap payload.
   * Field introduced in 17.2.13,18.1.4,18.2.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param largeTrapPayload set the largeTrapPayload.
   */
  public void setLargeTrapPayload(Boolean  largeTrapPayload) {
    this.largeTrapPayload = largeTrapPayload;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Snmp version 3 configuration.
   * Field introduced in 17.2.3.
   * @return snmpV3Config
   */
  public SnmpV3Configuration getSnmpV3Config() {
    return snmpV3Config;
  }

  /**
   * This is the setter method to the attribute.
   * Snmp version 3 configuration.
   * Field introduced in 17.2.3.
   * @param snmpV3Config set the snmpV3Config.
   */
  public void setSnmpV3Config(SnmpV3Configuration snmpV3Config) {
    this.snmpV3Config = snmpV3Config;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Sets the syscontact in system mib.
   * Default value when not specified in API or module is interpreted by Avi Controller as support@avinetworks.com.
   * @return sysContact
   */
  public String getSysContact() {
    return sysContact;
  }

  /**
   * This is the setter method to the attribute.
   * Sets the syscontact in system mib.
   * Default value when not specified in API or module is interpreted by Avi Controller as support@avinetworks.com.
   * @param sysContact set the sysContact.
   */
  public void setSysContact(String  sysContact) {
    this.sysContact = sysContact;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Sets the syslocation in system mib.
   * @return sysLocation
   */
  public String getSysLocation() {
    return sysLocation;
  }

  /**
   * This is the setter method to the attribute.
   * Sets the syslocation in system mib.
   * @param sysLocation set the sysLocation.
   */
  public void setSysLocation(String  sysLocation) {
    this.sysLocation = sysLocation;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Snmp version support.
   * V2 or v3.
   * Enum options - SNMP_VER2, SNMP_VER3.
   * Field introduced in 17.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as SNMP_VER2.
   * @return version
   */
  public String getVersion() {
    return version;
  }

  /**
   * This is the setter method to the attribute.
   * Snmp version support.
   * V2 or v3.
   * Enum options - SNMP_VER2, SNMP_VER3.
   * Field introduced in 17.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as SNMP_VER2.
   * @param version set the version.
   */
  public void setVersion(String  version) {
    this.version = version;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SnmpConfiguration objSnmpConfiguration = (SnmpConfiguration) o;
  return   Objects.equals(this.sysLocation, objSnmpConfiguration.sysLocation)&&
  Objects.equals(this.community, objSnmpConfiguration.community)&&
  Objects.equals(this.version, objSnmpConfiguration.version)&&
  Objects.equals(this.largeTrapPayload, objSnmpConfiguration.largeTrapPayload)&&
  Objects.equals(this.snmpV3Config, objSnmpConfiguration.snmpV3Config)&&
  Objects.equals(this.sysContact, objSnmpConfiguration.sysContact);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SnmpConfiguration {\n");
      sb.append("    community: ").append(toIndentedString(community)).append("\n");
        sb.append("    largeTrapPayload: ").append(toIndentedString(largeTrapPayload)).append("\n");
        sb.append("    snmpV3Config: ").append(toIndentedString(snmpV3Config)).append("\n");
        sb.append("    sysContact: ").append(toIndentedString(sysContact)).append("\n");
        sb.append("    sysLocation: ").append(toIndentedString(sysLocation)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
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

