package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SnmpV3UserParams is a POJO class extends AviRestResource that used for creating
 * SnmpV3UserParams.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SnmpV3UserParams  {
    @JsonProperty("auth_passphrase")
    private String authPassphrase = "avinetworks";

    @JsonProperty("auth_type")
    private String authType = "SNMP_V3_AUTH_MD5";

    @JsonProperty("priv_passphrase")
    private String privPassphrase = "avinetworks";

    @JsonProperty("priv_type")
    private String privType = "SNMP_V3_PRIV_DES";

    @JsonProperty("username")
    private String username = null;



  /**
   * This is the getter method this will return the attribute value.
   * Snmp v3 authentication passphrase.
   * Field introduced in 17.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as avinetworks.
   * @return authPassphrase
   */
  public String getAuthPassphrase() {
    return authPassphrase;
  }

  /**
   * This is the setter method to the attribute.
   * Snmp v3 authentication passphrase.
   * Field introduced in 17.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as avinetworks.
   * @param authPassphrase set the authPassphrase.
   */
  public void setAuthPassphrase(String  authPassphrase) {
    this.authPassphrase = authPassphrase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Snmp v3 user authentication type.
   * Enum options - SNMP_V3_AUTH_MD5, SNMP_V3_AUTH_SHA, SNMP_V3_AUTH_SHA_224, SNMP_V3_AUTH_SHA_256, SNMP_V3_AUTH_SHA_384, SNMP_V3_AUTH_SHA_512.
   * Field introduced in 17.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as SNMP_V3_AUTH_MD5.
   * @return authType
   */
  public String getAuthType() {
    return authType;
  }

  /**
   * This is the setter method to the attribute.
   * Snmp v3 user authentication type.
   * Enum options - SNMP_V3_AUTH_MD5, SNMP_V3_AUTH_SHA, SNMP_V3_AUTH_SHA_224, SNMP_V3_AUTH_SHA_256, SNMP_V3_AUTH_SHA_384, SNMP_V3_AUTH_SHA_512.
   * Field introduced in 17.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as SNMP_V3_AUTH_MD5.
   * @param authType set the authType.
   */
  public void setAuthType(String  authType) {
    this.authType = authType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Snmp v3 privacy passphrase.
   * Field introduced in 17.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as avinetworks.
   * @return privPassphrase
   */
  public String getPrivPassphrase() {
    return privPassphrase;
  }

  /**
   * This is the setter method to the attribute.
   * Snmp v3 privacy passphrase.
   * Field introduced in 17.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as avinetworks.
   * @param privPassphrase set the privPassphrase.
   */
  public void setPrivPassphrase(String  privPassphrase) {
    this.privPassphrase = privPassphrase;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Snmp v3 privacy setting.
   * Enum options - SNMP_V3_PRIV_DES, SNMP_V3_PRIV_AES.
   * Field introduced in 17.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as SNMP_V3_PRIV_DES.
   * @return privType
   */
  public String getPrivType() {
    return privType;
  }

  /**
   * This is the setter method to the attribute.
   * Snmp v3 privacy setting.
   * Enum options - SNMP_V3_PRIV_DES, SNMP_V3_PRIV_AES.
   * Field introduced in 17.2.3.
   * Default value when not specified in API or module is interpreted by Avi Controller as SNMP_V3_PRIV_DES.
   * @param privType set the privType.
   */
  public void setPrivType(String  privType) {
    this.privType = privType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Snmp username to be used by snmp clients for performing snmp walk.
   * Field introduced in 17.2.3.
   * @return username
   */
  public String getUsername() {
    return username;
  }

  /**
   * This is the setter method to the attribute.
   * Snmp username to be used by snmp clients for performing snmp walk.
   * Field introduced in 17.2.3.
   * @param username set the username.
   */
  public void setUsername(String  username) {
    this.username = username;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SnmpV3UserParams objSnmpV3UserParams = (SnmpV3UserParams) o;
  return   Objects.equals(this.username, objSnmpV3UserParams.username)&&
  Objects.equals(this.authType, objSnmpV3UserParams.authType)&&
  Objects.equals(this.privPassphrase, objSnmpV3UserParams.privPassphrase)&&
  Objects.equals(this.authPassphrase, objSnmpV3UserParams.authPassphrase)&&
  Objects.equals(this.privType, objSnmpV3UserParams.privType);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SnmpV3UserParams {\n");
      sb.append("    authPassphrase: ").append(toIndentedString(authPassphrase)).append("\n");
        sb.append("    authType: ").append(toIndentedString(authType)).append("\n");
        sb.append("    privPassphrase: ").append(toIndentedString(privPassphrase)).append("\n");
        sb.append("    privType: ").append(toIndentedString(privType)).append("\n");
        sb.append("    username: ").append(toIndentedString(username)).append("\n");
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

