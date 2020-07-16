package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SSLCipherList is a POJO class extends AviRestResource that used for creating
 * SSLCipherList.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SSLCipherList  {
    @JsonProperty("identified_ciphers")
    private List<String> identifiedCiphers = null;

    @JsonProperty("unidentified_ciphers")
    private List<String> unidentifiedCiphers = null;


  /**
   * This is the getter method this will return the attribute value.
   * List of ciphers from the client's ssl cipher list that could be identified.
   * The ciphers are represented by their rfc name.
   * Enum options - AVI_TLS_NULL_WITH_NULL_NULL, AVI_TLS_RSA_WITH_NULL_MD5, AVI_TLS_RSA_WITH_NULL_SHA, AVI_TLS_RSA_EXPORT_WITH_RC4_40_MD5,
   * AVI_TLS_RSA_WITH_RC4_128_MD5, AVI_TLS_RSA_WITH_RC4_128_SHA, AVI_TLS_RSA_EXPORT_WITH_RC2_CBC_40_MD5, AVI_TLS_RSA_WITH_IDEA_CBC_SHA,
   * AVI_TLS_RSA_EXPORT_WITH_DES40_CBC_SHA, AVI_TLS_RSA_WITH_DES_CBC_SHA, AVI_TLS_RSA_WITH_3DES_EDE_CBC_SHA, AVI_TLS_DH_DSS_EXPORT_WITH_DES40_CBC_SHA,
   * AVI_TLS_DH_DSS_WITH_DES_CBC_SHA, AVI_TLS_DH_DSS_WITH_3DES_EDE_CBC_SHA, AVI_TLS_DH_RSA_EXPORT_WITH_DES40_CBC_SHA, AVI_TLS_DH_RSA_WITH_DES_CBC_SHA,
   * AVI_TLS_DH_RSA_WITH_3DES_EDE_CBC_SHA, AVI_TLS_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA, AVI_TLS_DHE_DSS_WITH_DES_CBC_SHA,
   * AVI_TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA...
   * Field introduced in 18.1.4, 18.2.1.
   * @return identifiedCiphers
   */
  public List<String> getIdentifiedCiphers() {
    return identifiedCiphers;
  }

  /**
   * This is the setter method. this will set the identifiedCiphers
   * List of ciphers from the client's ssl cipher list that could be identified.
   * The ciphers are represented by their rfc name.
   * Enum options - AVI_TLS_NULL_WITH_NULL_NULL, AVI_TLS_RSA_WITH_NULL_MD5, AVI_TLS_RSA_WITH_NULL_SHA, AVI_TLS_RSA_EXPORT_WITH_RC4_40_MD5,
   * AVI_TLS_RSA_WITH_RC4_128_MD5, AVI_TLS_RSA_WITH_RC4_128_SHA, AVI_TLS_RSA_EXPORT_WITH_RC2_CBC_40_MD5, AVI_TLS_RSA_WITH_IDEA_CBC_SHA,
   * AVI_TLS_RSA_EXPORT_WITH_DES40_CBC_SHA, AVI_TLS_RSA_WITH_DES_CBC_SHA, AVI_TLS_RSA_WITH_3DES_EDE_CBC_SHA, AVI_TLS_DH_DSS_EXPORT_WITH_DES40_CBC_SHA,
   * AVI_TLS_DH_DSS_WITH_DES_CBC_SHA, AVI_TLS_DH_DSS_WITH_3DES_EDE_CBC_SHA, AVI_TLS_DH_RSA_EXPORT_WITH_DES40_CBC_SHA, AVI_TLS_DH_RSA_WITH_DES_CBC_SHA,
   * AVI_TLS_DH_RSA_WITH_3DES_EDE_CBC_SHA, AVI_TLS_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA, AVI_TLS_DHE_DSS_WITH_DES_CBC_SHA,
   * AVI_TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA...
   * Field introduced in 18.1.4, 18.2.1.
   * @return identifiedCiphers
   */
  public void setIdentifiedCiphers(List<String>  identifiedCiphers) {
    this.identifiedCiphers = identifiedCiphers;
  }

  /**
   * This is the setter method this will set the identifiedCiphers
   * List of ciphers from the client's ssl cipher list that could be identified.
   * The ciphers are represented by their rfc name.
   * Enum options - AVI_TLS_NULL_WITH_NULL_NULL, AVI_TLS_RSA_WITH_NULL_MD5, AVI_TLS_RSA_WITH_NULL_SHA, AVI_TLS_RSA_EXPORT_WITH_RC4_40_MD5,
   * AVI_TLS_RSA_WITH_RC4_128_MD5, AVI_TLS_RSA_WITH_RC4_128_SHA, AVI_TLS_RSA_EXPORT_WITH_RC2_CBC_40_MD5, AVI_TLS_RSA_WITH_IDEA_CBC_SHA,
   * AVI_TLS_RSA_EXPORT_WITH_DES40_CBC_SHA, AVI_TLS_RSA_WITH_DES_CBC_SHA, AVI_TLS_RSA_WITH_3DES_EDE_CBC_SHA, AVI_TLS_DH_DSS_EXPORT_WITH_DES40_CBC_SHA,
   * AVI_TLS_DH_DSS_WITH_DES_CBC_SHA, AVI_TLS_DH_DSS_WITH_3DES_EDE_CBC_SHA, AVI_TLS_DH_RSA_EXPORT_WITH_DES40_CBC_SHA, AVI_TLS_DH_RSA_WITH_DES_CBC_SHA,
   * AVI_TLS_DH_RSA_WITH_3DES_EDE_CBC_SHA, AVI_TLS_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA, AVI_TLS_DHE_DSS_WITH_DES_CBC_SHA,
   * AVI_TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA...
   * Field introduced in 18.1.4, 18.2.1.
   * @return identifiedCiphers
   */
  public SSLCipherList addIdentifiedCiphersItem(String identifiedCiphersItem) {
    if (this.identifiedCiphers == null) {
      this.identifiedCiphers = new ArrayList<String>();
    }
    this.identifiedCiphers.add(identifiedCiphersItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * List of ciphers from the client's ssl cipher list, that could not be identified.
   * The ciphers are represented by their rfc 2 byte hex value.
   * Field introduced in 18.1.4, 18.2.1.
   * @return unidentifiedCiphers
   */
  public List<String> getUnidentifiedCiphers() {
    return unidentifiedCiphers;
  }

  /**
   * This is the setter method. this will set the unidentifiedCiphers
   * List of ciphers from the client's ssl cipher list, that could not be identified.
   * The ciphers are represented by their rfc 2 byte hex value.
   * Field introduced in 18.1.4, 18.2.1.
   * @return unidentifiedCiphers
   */
  public void setUnidentifiedCiphers(List<String>  unidentifiedCiphers) {
    this.unidentifiedCiphers = unidentifiedCiphers;
  }

  /**
   * This is the setter method this will set the unidentifiedCiphers
   * List of ciphers from the client's ssl cipher list, that could not be identified.
   * The ciphers are represented by their rfc 2 byte hex value.
   * Field introduced in 18.1.4, 18.2.1.
   * @return unidentifiedCiphers
   */
  public SSLCipherList addUnidentifiedCiphersItem(String unidentifiedCiphersItem) {
    if (this.unidentifiedCiphers == null) {
      this.unidentifiedCiphers = new ArrayList<String>();
    }
    this.unidentifiedCiphers.add(unidentifiedCiphersItem);
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
  SSLCipherList objSSLCipherList = (SSLCipherList) o;
  return   Objects.equals(this.unidentifiedCiphers, objSSLCipherList.unidentifiedCiphers)&&
  Objects.equals(this.identifiedCiphers, objSSLCipherList.identifiedCiphers);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SSLCipherList {\n");
      sb.append("    identifiedCiphers: ").append(toIndentedString(identifiedCiphers)).append("\n");
        sb.append("    unidentifiedCiphers: ").append(toIndentedString(unidentifiedCiphers)).append("\n");
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

