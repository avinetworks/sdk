package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The HttpCookiePersistenceKey is a POJO class extends AviRestResource that used for creating
 * HttpCookiePersistenceKey.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HttpCookiePersistenceKey  {
    @JsonProperty("aes_key")
    private String aesKey = null;

    @JsonProperty("hmac_key")
    private String hmacKey = null;

    @JsonProperty("name")
    private String name = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property aes_key of obj type httpcookiepersistencekey field type str  type string.
   * @return aesKey
   */
  public String getAesKey() {
    return aesKey;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property aes_key of obj type httpcookiepersistencekey field type str  type string.
   * @param aesKey set the aesKey.
   */
  public void setAesKey(String  aesKey) {
    this.aesKey = aesKey;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property hmac_key of obj type httpcookiepersistencekey field type str  type string.
   * @return hmacKey
   */
  public String getHmacKey() {
    return hmacKey;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property hmac_key of obj type httpcookiepersistencekey field type str  type string.
   * @param hmacKey set the hmacKey.
   */
  public void setHmacKey(String  hmacKey) {
    this.hmacKey = hmacKey;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name to use for cookie encryption.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name to use for cookie encryption.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  HttpCookiePersistenceKey objHttpCookiePersistenceKey = (HttpCookiePersistenceKey) o;
  return   Objects.equals(this.hmacKey, objHttpCookiePersistenceKey.hmacKey)&&
  Objects.equals(this.name, objHttpCookiePersistenceKey.name)&&
  Objects.equals(this.aesKey, objHttpCookiePersistenceKey.aesKey);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class HttpCookiePersistenceKey {\n");
      sb.append("    aesKey: ").append(toIndentedString(aesKey)).append("\n");
        sb.append("    hmacKey: ").append(toIndentedString(hmacKey)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

