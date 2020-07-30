package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The NTPAuthenticationKey is a POJO class extends AviRestResource that used for creating
 * NTPAuthenticationKey.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NTPAuthenticationKey  {
    @JsonProperty("algorithm")
    private String algorithm = "NTP_AUTH_ALGORITHM_MD5";

    @JsonProperty("key")
    private String key = null;

    @JsonProperty("key_number")
    private Integer keyNumber = null;



  /**
   * This is the getter method this will return the attribute value.
   * Message digest algorithm used for ntp authentication.
   * Default is ntp_auth_algorithm_md5.
   * Enum options - NTP_AUTH_ALGORITHM_MD5, NTP_AUTH_ALGORITHM_SHA1.
   * Default value when not specified in API or module is interpreted by Avi Controller as NTP_AUTH_ALGORITHM_MD5.
   * @return algorithm
   */
  public String getAlgorithm() {
    return algorithm;
  }

  /**
   * This is the setter method to the attribute.
   * Message digest algorithm used for ntp authentication.
   * Default is ntp_auth_algorithm_md5.
   * Enum options - NTP_AUTH_ALGORITHM_MD5, NTP_AUTH_ALGORITHM_SHA1.
   * Default value when not specified in API or module is interpreted by Avi Controller as NTP_AUTH_ALGORITHM_MD5.
   * @param algorithm set the algorithm.
   */
  public void setAlgorithm(String  algorithm) {
    this.algorithm = algorithm;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Ntp authentication key.
   * @return key
   */
  public String getKey() {
    return key;
  }

  /**
   * This is the setter method to the attribute.
   * Ntp authentication key.
   * @param key set the key.
   */
  public void setKey(String  key) {
    this.key = key;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Key number to be assigned to the authentication-key.
   * Allowed values are 1-65534.
   * @return keyNumber
   */
  public Integer getKeyNumber() {
    return keyNumber;
  }

  /**
   * This is the setter method to the attribute.
   * Key number to be assigned to the authentication-key.
   * Allowed values are 1-65534.
   * @param keyNumber set the keyNumber.
   */
  public void setKeyNumber(Integer  keyNumber) {
    this.keyNumber = keyNumber;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  NTPAuthenticationKey objNTPAuthenticationKey = (NTPAuthenticationKey) o;
  return   Objects.equals(this.keyNumber, objNTPAuthenticationKey.keyNumber)&&
  Objects.equals(this.algorithm, objNTPAuthenticationKey.algorithm)&&
  Objects.equals(this.key, objNTPAuthenticationKey.key);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class NTPAuthenticationKey {\n");
      sb.append("    algorithm: ").append(toIndentedString(algorithm)).append("\n");
        sb.append("    key: ").append(toIndentedString(key)).append("\n");
        sb.append("    keyNumber: ").append(toIndentedString(keyNumber)).append("\n");
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

