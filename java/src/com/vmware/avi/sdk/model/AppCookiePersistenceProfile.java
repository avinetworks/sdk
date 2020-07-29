package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The AppCookiePersistenceProfile is a POJO class extends AviRestResource that used for creating
 * AppCookiePersistenceProfile.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppCookiePersistenceProfile  {
    @JsonProperty("encryption_key")
    private String encryptionKey = null;

    @JsonProperty("prst_hdr_name")
    private String prstHdrName = null;

    @JsonProperty("timeout")
    private Integer timeout = 20;



  /**
   * This is the getter method this will return the attribute value.
   * Key to use for cookie encryption.
   * @return encryptionKey
   */
  public String getEncryptionKey() {
    return encryptionKey;
  }

  /**
   * This is the setter method to the attribute.
   * Key to use for cookie encryption.
   * @param encryptionKey set the encryptionKey.
   */
  public void setEncryptionKey(String  encryptionKey) {
    this.encryptionKey = encryptionKey;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Header or cookie name for application cookie persistence.
   * @return prstHdrName
   */
  public String getPrstHdrName() {
    return prstHdrName;
  }

  /**
   * This is the setter method to the attribute.
   * Header or cookie name for application cookie persistence.
   * @param prstHdrName set the prstHdrName.
   */
  public void setPrstHdrName(String  prstHdrName) {
    this.prstHdrName = prstHdrName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The length of time after a client's connections have closed before expiring the client's persistence to a server.
   * Allowed values are 1-720.
   * Default value when not specified in API or module is interpreted by Avi Controller as 20.
   * @return timeout
   */
  public Integer getTimeout() {
    return timeout;
  }

  /**
   * This is the setter method to the attribute.
   * The length of time after a client's connections have closed before expiring the client's persistence to a server.
   * Allowed values are 1-720.
   * Default value when not specified in API or module is interpreted by Avi Controller as 20.
   * @param timeout set the timeout.
   */
  public void setTimeout(Integer  timeout) {
    this.timeout = timeout;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  AppCookiePersistenceProfile objAppCookiePersistenceProfile = (AppCookiePersistenceProfile) o;
  return   Objects.equals(this.prstHdrName, objAppCookiePersistenceProfile.prstHdrName)&&
  Objects.equals(this.timeout, objAppCookiePersistenceProfile.timeout)&&
  Objects.equals(this.encryptionKey, objAppCookiePersistenceProfile.encryptionKey);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class AppCookiePersistenceProfile {\n");
      sb.append("    encryptionKey: ").append(toIndentedString(encryptionKey)).append("\n");
        sb.append("    prstHdrName: ").append(toIndentedString(prstHdrName)).append("\n");
        sb.append("    timeout: ").append(toIndentedString(timeout)).append("\n");
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

