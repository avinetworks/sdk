package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The HttpCookiePersistenceProfile is a POJO class extends AviRestResource that used for creating
 * HttpCookiePersistenceProfile.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HttpCookiePersistenceProfile  {
    @JsonProperty("always_send_cookie")
    private Boolean alwaysSendCookie = false;

    @JsonProperty("cookie_name")
    private String cookieName = null;

    @JsonProperty("encryption_key")
    private String encryptionKey = null;

    @JsonProperty("http_only")
    private Boolean httpOnly = false;

    @JsonProperty("key")
    private List<HttpCookiePersistenceKey> key = null;

    @JsonProperty("timeout")
    private Integer timeout = null;



    /**
     * This is the getter method this will return the attribute value.
     * If no persistence cookie was received from the client, always send it.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @return alwaysSendCookie
     */
    public Boolean getAlwaysSendCookie() {
        return alwaysSendCookie;
    }

    /**
     * This is the setter method to the attribute.
     * If no persistence cookie was received from the client, always send it.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @param alwaysSendCookie set the alwaysSendCookie.
     */
    public void setAlwaysSendCookie(Boolean  alwaysSendCookie) {
        this.alwaysSendCookie = alwaysSendCookie;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Http cookie name for cookie persistence.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return cookieName
     */
    public String getCookieName() {
        return cookieName;
    }

    /**
     * This is the setter method to the attribute.
     * Http cookie name for cookie persistence.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param cookieName set the cookieName.
     */
    public void setCookieName(String  cookieName) {
        this.cookieName = cookieName;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Key name to use for cookie encryption.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return encryptionKey
     */
    public String getEncryptionKey() {
        return encryptionKey;
    }

    /**
     * This is the setter method to the attribute.
     * Key name to use for cookie encryption.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param encryptionKey set the encryptionKey.
     */
    public void setEncryptionKey(String  encryptionKey) {
        this.encryptionKey = encryptionKey;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Sets the httponly attribute in the cookie.
     * Setting this helps to prevent the client side scripts from accessing this cookie, if supported by browser.
     * Field introduced in 20.1.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @return httpOnly
     */
    public Boolean getHttpOnly() {
        return httpOnly;
    }

    /**
     * This is the setter method to the attribute.
     * Sets the httponly attribute in the cookie.
     * Setting this helps to prevent the client side scripts from accessing this cookie, if supported by browser.
     * Field introduced in 20.1.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @param httpOnly set the httpOnly.
     */
    public void setHttpOnly(Boolean  httpOnly) {
        this.httpOnly = httpOnly;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Placeholder for description of property key of obj type httpcookiepersistenceprofile field type str  type array.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return key
     */
    public List<HttpCookiePersistenceKey> getKey() {
        return key;
    }

    /**
     * This is the setter method. this will set the key
     * Placeholder for description of property key of obj type httpcookiepersistenceprofile field type str  type array.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return key
     */
    public void setKey(List<HttpCookiePersistenceKey>  key) {
        this.key = key;
    }

    /**
     * This is the setter method this will set the key
     * Placeholder for description of property key of obj type httpcookiepersistenceprofile field type str  type array.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return key
     */
    public HttpCookiePersistenceProfile addKeyItem(HttpCookiePersistenceKey keyItem) {
      if (this.key == null) {
        this.key = new ArrayList<HttpCookiePersistenceKey>();
      }
      this.key.add(keyItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * The maximum lifetime of any session cookie.
     * No value or 'zero' indicates no timeout.
     * Allowed values are 1-14400.
     * Special values are 0- 'no timeout'.
     * Unit is min.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return timeout
     */
    public Integer getTimeout() {
        return timeout;
    }

    /**
     * This is the setter method to the attribute.
     * The maximum lifetime of any session cookie.
     * No value or 'zero' indicates no timeout.
     * Allowed values are 1-14400.
     * Special values are 0- 'no timeout'.
     * Unit is min.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
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
      HttpCookiePersistenceProfile objHttpCookiePersistenceProfile = (HttpCookiePersistenceProfile) o;
      return   Objects.equals(this.encryptionKey, objHttpCookiePersistenceProfile.encryptionKey)&&
  Objects.equals(this.cookieName, objHttpCookiePersistenceProfile.cookieName)&&
  Objects.equals(this.key, objHttpCookiePersistenceProfile.key)&&
  Objects.equals(this.timeout, objHttpCookiePersistenceProfile.timeout)&&
  Objects.equals(this.alwaysSendCookie, objHttpCookiePersistenceProfile.alwaysSendCookie)&&
  Objects.equals(this.httpOnly, objHttpCookiePersistenceProfile.httpOnly);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class HttpCookiePersistenceProfile {\n");
                  sb.append("    alwaysSendCookie: ").append(toIndentedString(alwaysSendCookie)).append("\n");
                        sb.append("    cookieName: ").append(toIndentedString(cookieName)).append("\n");
                        sb.append("    encryptionKey: ").append(toIndentedString(encryptionKey)).append("\n");
                        sb.append("    httpOnly: ").append(toIndentedString(httpOnly)).append("\n");
                        sb.append("    key: ").append(toIndentedString(key)).append("\n");
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
