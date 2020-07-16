package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The HSMAwsCloudHsm is a POJO class extends AviRestResource that used for creating
 * HSMAwsCloudHsm.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HSMAwsCloudHsm  {
    @JsonProperty("client_config")
    private String clientConfig = null;

    @JsonProperty("cluster_cert")
    private String clusterCert = null;

    @JsonProperty("crypto_user_name")
    private String cryptoUserName = null;

    @JsonProperty("crypto_user_password")
    private String cryptoUserPassword = null;

    @JsonProperty("hsm_ip")
    private List<String> hsmIp = null;

    @JsonProperty("mgmt_config")
    private String mgmtConfig = null;



  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.2.7.
   * @return clientConfig
   */
  public String getClientConfig() {
    return clientConfig;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.2.7.
   * @param clientConfig set the clientConfig.
   */
  public void setClientConfig(String  clientConfig) {
    this.clientConfig = clientConfig;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Aws cloudhsm cluster certificate.
   * Field introduced in 17.2.7.
   * @return clusterCert
   */
  public String getClusterCert() {
    return clusterCert;
  }

  /**
   * This is the setter method to the attribute.
   * Aws cloudhsm cluster certificate.
   * Field introduced in 17.2.7.
   * @param clusterCert set the clusterCert.
   */
  public void setClusterCert(String  clusterCert) {
    this.clusterCert = clusterCert;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Username of the crypto user.
   * This will be used to access the keys on the hsm.
   * Field introduced in 17.2.7.
   * @return cryptoUserName
   */
  public String getCryptoUserName() {
    return cryptoUserName;
  }

  /**
   * This is the setter method to the attribute.
   * Username of the crypto user.
   * This will be used to access the keys on the hsm.
   * Field introduced in 17.2.7.
   * @param cryptoUserName set the cryptoUserName.
   */
  public void setCryptoUserName(String  cryptoUserName) {
    this.cryptoUserName = cryptoUserName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Password of the crypto user.
   * This will be used to access the keys on the hsm.
   * Field introduced in 17.2.7.
   * @return cryptoUserPassword
   */
  public String getCryptoUserPassword() {
    return cryptoUserPassword;
  }

  /**
   * This is the setter method to the attribute.
   * Password of the crypto user.
   * This will be used to access the keys on the hsm.
   * Field introduced in 17.2.7.
   * @param cryptoUserPassword set the cryptoUserPassword.
   */
  public void setCryptoUserPassword(String  cryptoUserPassword) {
    this.cryptoUserPassword = cryptoUserPassword;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Ip address of the hsm in the cluster.
   * If there are more than one hsms, only one is sufficient.
   * Field introduced in 17.2.7.
   * @return hsmIp
   */
  public List<String> getHsmIp() {
    return hsmIp;
  }

  /**
   * This is the setter method. this will set the hsmIp
   * Ip address of the hsm in the cluster.
   * If there are more than one hsms, only one is sufficient.
   * Field introduced in 17.2.7.
   * @return hsmIp
   */
  public void setHsmIp(List<String>  hsmIp) {
    this.hsmIp = hsmIp;
  }

  /**
   * This is the setter method this will set the hsmIp
   * Ip address of the hsm in the cluster.
   * If there are more than one hsms, only one is sufficient.
   * Field introduced in 17.2.7.
   * @return hsmIp
   */
  public HSMAwsCloudHsm addHsmIpItem(String hsmIpItem) {
    if (this.hsmIp == null) {
      this.hsmIp = new ArrayList<String>();
    }
    this.hsmIp.add(hsmIpItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.2.7.
   * @return mgmtConfig
   */
  public String getMgmtConfig() {
    return mgmtConfig;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.2.7.
   * @param mgmtConfig set the mgmtConfig.
   */
  public void setMgmtConfig(String  mgmtConfig) {
    this.mgmtConfig = mgmtConfig;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  HSMAwsCloudHsm objHSMAwsCloudHsm = (HSMAwsCloudHsm) o;
  return   Objects.equals(this.clientConfig, objHSMAwsCloudHsm.clientConfig)&&
  Objects.equals(this.clusterCert, objHSMAwsCloudHsm.clusterCert)&&
  Objects.equals(this.cryptoUserName, objHSMAwsCloudHsm.cryptoUserName)&&
  Objects.equals(this.cryptoUserPassword, objHSMAwsCloudHsm.cryptoUserPassword)&&
  Objects.equals(this.hsmIp, objHSMAwsCloudHsm.hsmIp)&&
  Objects.equals(this.mgmtConfig, objHSMAwsCloudHsm.mgmtConfig);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class HSMAwsCloudHsm {\n");
      sb.append("    clientConfig: ").append(toIndentedString(clientConfig)).append("\n");
        sb.append("    clusterCert: ").append(toIndentedString(clusterCert)).append("\n");
        sb.append("    cryptoUserName: ").append(toIndentedString(cryptoUserName)).append("\n");
        sb.append("    cryptoUserPassword: ").append(toIndentedString(cryptoUserPassword)).append("\n");
        sb.append("    hsmIp: ").append(toIndentedString(hsmIp)).append("\n");
        sb.append("    mgmtConfig: ").append(toIndentedString(mgmtConfig)).append("\n");
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

