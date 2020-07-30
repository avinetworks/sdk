package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The MgmtIpAccessControl is a POJO class extends AviRestResource that used for creating
 * MgmtIpAccessControl.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MgmtIpAccessControl  {
    @JsonProperty("api_access")
    private IpAddrMatch apiAccess = null;

    @JsonProperty("shell_server_access")
    private IpAddrMatch shellServerAccess = null;

    @JsonProperty("snmp_access")
    private IpAddrMatch snmpAccess = null;

    @JsonProperty("ssh_access")
    private IpAddrMatch sshAccess = null;

    @JsonProperty("sysint_access")
    private IpAddrMatch sysintAccess = null;



  /**
   * This is the getter method this will return the attribute value.
   * Configure ip addresses to access controller using api.
   * @return apiAccess
   */
  public IpAddrMatch getApiAccess() {
    return apiAccess;
  }

  /**
   * This is the setter method to the attribute.
   * Configure ip addresses to access controller using api.
   * @param apiAccess set the apiAccess.
   */
  public void setApiAccess(IpAddrMatch apiAccess) {
    this.apiAccess = apiAccess;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Configure ip addresses to access controller using cli shell.
   * @return shellServerAccess
   */
  public IpAddrMatch getShellServerAccess() {
    return shellServerAccess;
  }

  /**
   * This is the setter method to the attribute.
   * Configure ip addresses to access controller using cli shell.
   * @param shellServerAccess set the shellServerAccess.
   */
  public void setShellServerAccess(IpAddrMatch shellServerAccess) {
    this.shellServerAccess = shellServerAccess;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Configure ip addresses to access controller using snmp.
   * @return snmpAccess
   */
  public IpAddrMatch getSnmpAccess() {
    return snmpAccess;
  }

  /**
   * This is the setter method to the attribute.
   * Configure ip addresses to access controller using snmp.
   * @param snmpAccess set the snmpAccess.
   */
  public void setSnmpAccess(IpAddrMatch snmpAccess) {
    this.snmpAccess = snmpAccess;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Configure ip addresses to access controller using ssh.
   * @return sshAccess
   */
  public IpAddrMatch getSshAccess() {
    return sshAccess;
  }

  /**
   * This is the setter method to the attribute.
   * Configure ip addresses to access controller using ssh.
   * @param sshAccess set the sshAccess.
   */
  public void setSshAccess(IpAddrMatch sshAccess) {
    this.sshAccess = sshAccess;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Configure ip addresses to access controller using sysint access.
   * Field introduced in 18.1.3, 18.2.1.
   * @return sysintAccess
   */
  public IpAddrMatch getSysintAccess() {
    return sysintAccess;
  }

  /**
   * This is the setter method to the attribute.
   * Configure ip addresses to access controller using sysint access.
   * Field introduced in 18.1.3, 18.2.1.
   * @param sysintAccess set the sysintAccess.
   */
  public void setSysintAccess(IpAddrMatch sysintAccess) {
    this.sysintAccess = sysintAccess;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  MgmtIpAccessControl objMgmtIpAccessControl = (MgmtIpAccessControl) o;
  return   Objects.equals(this.sshAccess, objMgmtIpAccessControl.sshAccess)&&
  Objects.equals(this.apiAccess, objMgmtIpAccessControl.apiAccess)&&
  Objects.equals(this.shellServerAccess, objMgmtIpAccessControl.shellServerAccess)&&
  Objects.equals(this.snmpAccess, objMgmtIpAccessControl.snmpAccess)&&
  Objects.equals(this.sysintAccess, objMgmtIpAccessControl.sysintAccess);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class MgmtIpAccessControl {\n");
      sb.append("    apiAccess: ").append(toIndentedString(apiAccess)).append("\n");
        sb.append("    shellServerAccess: ").append(toIndentedString(shellServerAccess)).append("\n");
        sb.append("    snmpAccess: ").append(toIndentedString(snmpAccess)).append("\n");
        sb.append("    sshAccess: ").append(toIndentedString(sshAccess)).append("\n");
        sb.append("    sysintAccess: ").append(toIndentedString(sysintAccess)).append("\n");
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

