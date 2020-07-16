package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SSLKeyParams is a POJO class extends AviRestResource that used for creating
 * SSLKeyParams.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SSLKeyParams  {
    @JsonProperty("algorithm")
    private String algorithm = "SSL_KEY_ALGORITHM_RSA";

    @JsonProperty("ec_params")
    private SSLKeyECParams ecParams = null;

    @JsonProperty("rsa_params")
    private SSLKeyRSAParams rsaParams = null;



  /**
   * This is the getter method this will return the attribute value.
   * Enum options - SSL_KEY_ALGORITHM_RSA, SSL_KEY_ALGORITHM_EC.
   * Default value when not specified in API or module is interpreted by Avi Controller as SSL_KEY_ALGORITHM_RSA.
   * @return algorithm
   */
  public String getAlgorithm() {
    return algorithm;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - SSL_KEY_ALGORITHM_RSA, SSL_KEY_ALGORITHM_EC.
   * Default value when not specified in API or module is interpreted by Avi Controller as SSL_KEY_ALGORITHM_RSA.
   * @param algorithm set the algorithm.
   */
  public void setAlgorithm(String  algorithm) {
    this.algorithm = algorithm;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ec_params of obj type sslkeyparams field type str  type ref.
   * @return ecParams
   */
  public SSLKeyECParams getEcParams() {
    return ecParams;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ec_params of obj type sslkeyparams field type str  type ref.
   * @param ecParams set the ecParams.
   */
  public void setEcParams(SSLKeyECParams ecParams) {
    this.ecParams = ecParams;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property rsa_params of obj type sslkeyparams field type str  type ref.
   * @return rsaParams
   */
  public SSLKeyRSAParams getRsaParams() {
    return rsaParams;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property rsa_params of obj type sslkeyparams field type str  type ref.
   * @param rsaParams set the rsaParams.
   */
  public void setRsaParams(SSLKeyRSAParams rsaParams) {
    this.rsaParams = rsaParams;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SSLKeyParams objSSLKeyParams = (SSLKeyParams) o;
  return   Objects.equals(this.ecParams, objSSLKeyParams.ecParams)&&
  Objects.equals(this.rsaParams, objSSLKeyParams.rsaParams)&&
  Objects.equals(this.algorithm, objSSLKeyParams.algorithm);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SSLKeyParams {\n");
      sb.append("    algorithm: ").append(toIndentedString(algorithm)).append("\n");
        sb.append("    ecParams: ").append(toIndentedString(ecParams)).append("\n");
        sb.append("    rsaParams: ").append(toIndentedString(rsaParams)).append("\n");
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

