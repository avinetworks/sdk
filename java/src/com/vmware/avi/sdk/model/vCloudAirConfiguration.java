package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The vCloudAirConfiguration is a POJO class extends AviRestResource that used for creating
 * vCloudAirConfiguration.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class vCloudAirConfiguration  {
    @JsonProperty("privilege")
    private String privilege = "WRITE_ACCESS";

    @JsonProperty("vca_host")
    private String vcaHost = null;

    @JsonProperty("vca_instance")
    private String vcaInstance = null;

    @JsonProperty("vca_mgmt_network")
    private String vcaMgmtNetwork = null;

    @JsonProperty("vca_orgnization")
    private String vcaOrgnization = null;

    @JsonProperty("vca_password")
    private String vcaPassword = null;

    @JsonProperty("vca_username")
    private String vcaUsername = null;

    @JsonProperty("vca_vdc")
    private String vcaVdc = null;



  /**
   * This is the getter method this will return the attribute value.
   * Vcloudair access mode.
   * Enum options - NO_ACCESS, READ_ACCESS, WRITE_ACCESS.
   * Default value when not specified in API or module is interpreted by Avi Controller as WRITE_ACCESS.
   * @return privilege
   */
  public String getPrivilege() {
    return privilege;
  }

  /**
   * This is the setter method to the attribute.
   * Vcloudair access mode.
   * Enum options - NO_ACCESS, READ_ACCESS, WRITE_ACCESS.
   * Default value when not specified in API or module is interpreted by Avi Controller as WRITE_ACCESS.
   * @param privilege set the privilege.
   */
  public void setPrivilege(String  privilege) {
    this.privilege = privilege;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Vcloudair host address.
   * @return vcaHost
   */
  public String getVcaHost() {
    return vcaHost;
  }

  /**
   * This is the setter method to the attribute.
   * Vcloudair host address.
   * @param vcaHost set the vcaHost.
   */
  public void setVcaHost(String  vcaHost) {
    this.vcaHost = vcaHost;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Vcloudair instance id.
   * @return vcaInstance
   */
  public String getVcaInstance() {
    return vcaInstance;
  }

  /**
   * This is the setter method to the attribute.
   * Vcloudair instance id.
   * @param vcaInstance set the vcaInstance.
   */
  public void setVcaInstance(String  vcaInstance) {
    this.vcaInstance = vcaInstance;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Vcloudair management network.
   * @return vcaMgmtNetwork
   */
  public String getVcaMgmtNetwork() {
    return vcaMgmtNetwork;
  }

  /**
   * This is the setter method to the attribute.
   * Vcloudair management network.
   * @param vcaMgmtNetwork set the vcaMgmtNetwork.
   */
  public void setVcaMgmtNetwork(String  vcaMgmtNetwork) {
    this.vcaMgmtNetwork = vcaMgmtNetwork;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Vcloudair orgnization id.
   * @return vcaOrgnization
   */
  public String getVcaOrgnization() {
    return vcaOrgnization;
  }

  /**
   * This is the setter method to the attribute.
   * Vcloudair orgnization id.
   * @param vcaOrgnization set the vcaOrgnization.
   */
  public void setVcaOrgnization(String  vcaOrgnization) {
    this.vcaOrgnization = vcaOrgnization;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Vcloudair password.
   * @return vcaPassword
   */
  public String getVcaPassword() {
    return vcaPassword;
  }

  /**
   * This is the setter method to the attribute.
   * Vcloudair password.
   * @param vcaPassword set the vcaPassword.
   */
  public void setVcaPassword(String  vcaPassword) {
    this.vcaPassword = vcaPassword;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Vcloudair username.
   * @return vcaUsername
   */
  public String getVcaUsername() {
    return vcaUsername;
  }

  /**
   * This is the setter method to the attribute.
   * Vcloudair username.
   * @param vcaUsername set the vcaUsername.
   */
  public void setVcaUsername(String  vcaUsername) {
    this.vcaUsername = vcaUsername;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Vcloudair virtual data center name.
   * @return vcaVdc
   */
  public String getVcaVdc() {
    return vcaVdc;
  }

  /**
   * This is the setter method to the attribute.
   * Vcloudair virtual data center name.
   * @param vcaVdc set the vcaVdc.
   */
  public void setVcaVdc(String  vcaVdc) {
    this.vcaVdc = vcaVdc;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  vCloudAirConfiguration objvCloudAirConfiguration = (vCloudAirConfiguration) o;
  return   Objects.equals(this.vcaOrgnization, objvCloudAirConfiguration.vcaOrgnization)&&
  Objects.equals(this.vcaUsername, objvCloudAirConfiguration.vcaUsername)&&
  Objects.equals(this.vcaMgmtNetwork, objvCloudAirConfiguration.vcaMgmtNetwork)&&
  Objects.equals(this.vcaPassword, objvCloudAirConfiguration.vcaPassword)&&
  Objects.equals(this.vcaInstance, objvCloudAirConfiguration.vcaInstance)&&
  Objects.equals(this.privilege, objvCloudAirConfiguration.privilege)&&
  Objects.equals(this.vcaVdc, objvCloudAirConfiguration.vcaVdc)&&
  Objects.equals(this.vcaHost, objvCloudAirConfiguration.vcaHost);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class vCloudAirConfiguration {\n");
      sb.append("    privilege: ").append(toIndentedString(privilege)).append("\n");
        sb.append("    vcaHost: ").append(toIndentedString(vcaHost)).append("\n");
        sb.append("    vcaInstance: ").append(toIndentedString(vcaInstance)).append("\n");
        sb.append("    vcaMgmtNetwork: ").append(toIndentedString(vcaMgmtNetwork)).append("\n");
        sb.append("    vcaOrgnization: ").append(toIndentedString(vcaOrgnization)).append("\n");
        sb.append("    vcaPassword: ").append(toIndentedString(vcaPassword)).append("\n");
        sb.append("    vcaUsername: ").append(toIndentedString(vcaUsername)).append("\n");
        sb.append("    vcaVdc: ").append(toIndentedString(vcaVdc)).append("\n");
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

