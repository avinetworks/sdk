package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The HSMThalesNetHsm is a POJO class extends AviRestResource that used for creating
 * HSMThalesNetHsm.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HSMThalesNetHsm  {
    @JsonProperty("esn")
    private String esn = null;

    @JsonProperty("keyhash")
    private String keyhash = null;

    @JsonProperty("module_id")
    private Integer moduleId = 0;

    @JsonProperty("priority")
    private Integer priority = 100;

    @JsonProperty("remote_ip")
    private IpAddr remoteIp = null;

    @JsonProperty("remote_port")
    private Integer remotePort = 9004;



  /**
   * This is the getter method this will return the attribute value.
   * Electronic serial number of the nethsm device.
   * Use thales anonkneti utility to find the nethsm esn.
   * @return esn
   */
  public String getEsn() {
    return esn;
  }

  /**
   * This is the setter method to the attribute.
   * Electronic serial number of the nethsm device.
   * Use thales anonkneti utility to find the nethsm esn.
   * @param esn set the esn.
   */
  public void setEsn(String  esn) {
    this.esn = esn;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Hash of the key that nethsm device uses to authenticate itself.
   * Use thales anonkneti utility to find the nethsm keyhash.
   * @return keyhash
   */
  public String getKeyhash() {
    return keyhash;
  }

  /**
   * This is the setter method to the attribute.
   * Hash of the key that nethsm device uses to authenticate itself.
   * Use thales anonkneti utility to find the nethsm keyhash.
   * @param keyhash set the keyhash.
   */
  public void setKeyhash(String  keyhash) {
    this.keyhash = keyhash;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Local module id of the nethsm device.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @return moduleId
   */
  public Integer getModuleId() {
    return moduleId;
  }

  /**
   * This is the setter method to the attribute.
   * Local module id of the nethsm device.
   * Default value when not specified in API or module is interpreted by Avi Controller as 0.
   * @param moduleId set the moduleId.
   */
  public void setModuleId(Integer  moduleId) {
    this.moduleId = moduleId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Priority class of the nethsm in an high availability setup.
   * 1 is the highest priority and 100 is the lowest priority.
   * Allowed values are 1-100.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100.
   * @return priority
   */
  public Integer getPriority() {
    return priority;
  }

  /**
   * This is the setter method to the attribute.
   * Priority class of the nethsm in an high availability setup.
   * 1 is the highest priority and 100 is the lowest priority.
   * Allowed values are 1-100.
   * Default value when not specified in API or module is interpreted by Avi Controller as 100.
   * @param priority set the priority.
   */
  public void setPriority(Integer  priority) {
    this.priority = priority;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ip address of the nethsm device.
   * @return remoteIp
   */
  public IpAddr getRemoteIp() {
    return remoteIp;
  }

  /**
   * This is the setter method to the attribute.
   * Ip address of the nethsm device.
   * @param remoteIp set the remoteIp.
   */
  public void setRemoteIp(IpAddr remoteIp) {
    this.remoteIp = remoteIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Port at which the nethsm device accepts the connection.
   * Allowed values are 1-65535.
   * Default value when not specified in API or module is interpreted by Avi Controller as 9004.
   * @return remotePort
   */
  public Integer getRemotePort() {
    return remotePort;
  }

  /**
   * This is the setter method to the attribute.
   * Port at which the nethsm device accepts the connection.
   * Allowed values are 1-65535.
   * Default value when not specified in API or module is interpreted by Avi Controller as 9004.
   * @param remotePort set the remotePort.
   */
  public void setRemotePort(Integer  remotePort) {
    this.remotePort = remotePort;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  HSMThalesNetHsm objHSMThalesNetHsm = (HSMThalesNetHsm) o;
  return   Objects.equals(this.remoteIp, objHSMThalesNetHsm.remoteIp)&&
  Objects.equals(this.remotePort, objHSMThalesNetHsm.remotePort)&&
  Objects.equals(this.esn, objHSMThalesNetHsm.esn)&&
  Objects.equals(this.moduleId, objHSMThalesNetHsm.moduleId)&&
  Objects.equals(this.keyhash, objHSMThalesNetHsm.keyhash)&&
  Objects.equals(this.priority, objHSMThalesNetHsm.priority);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class HSMThalesNetHsm {\n");
      sb.append("    esn: ").append(toIndentedString(esn)).append("\n");
        sb.append("    keyhash: ").append(toIndentedString(keyhash)).append("\n");
        sb.append("    moduleId: ").append(toIndentedString(moduleId)).append("\n");
        sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
        sb.append("    remoteIp: ").append(toIndentedString(remoteIp)).append("\n");
        sb.append("    remotePort: ").append(toIndentedString(remotePort)).append("\n");
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

