package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The JWSKey is a POJO class extends AviRestResource that used for creating
 * JWSKey.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JWSKey  {
    @JsonProperty("alg")
    private String alg = "HS256";

    @JsonProperty("key")
    private String key = null;

    @JsonProperty("kid")
    private String kid = null;

    @JsonProperty("kty")
    private String kty = "oct";



    /**
     * This is the getter method this will return the attribute value.
     * Algorithm that need to be used while signing/validation.
     * Field introduced in 20.1.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as "HS256".
     * @return alg
     */
    public String getAlg() {
        return alg;
    }

    /**
     * This is the setter method to the attribute.
     * Algorithm that need to be used while signing/validation.
     * Field introduced in 20.1.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as "HS256".
     * @param alg set the alg.
     */
    public void setAlg(String  alg) {
        this.alg = alg;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Secret jwk for signing.
     * Field introduced in 20.1.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return key
     */
    public String getKey() {
        return key;
    }

    /**
     * This is the setter method to the attribute.
     * Secret jwk for signing.
     * Field introduced in 20.1.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param key set the key.
     */
    public void setKey(String  key) {
        this.key = key;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Unique key id for the key.
     * Field introduced in 20.1.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return kid
     */
    public String getKid() {
        return kid;
    }

    /**
     * This is the setter method to the attribute.
     * Unique key id for the key.
     * Field introduced in 20.1.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param kid set the kid.
     */
    public void setKid(String  kid) {
        this.kid = kid;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Secret key type/format.
     * Field introduced in 20.1.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as "oct".
     * @return kty
     */
    public String getKty() {
        return kty;
    }

    /**
     * This is the setter method to the attribute.
     * Secret key type/format.
     * Field introduced in 20.1.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as "oct".
     * @param kty set the kty.
     */
    public void setKty(String  kty) {
        this.kty = kty;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      JWSKey objJWSKey = (JWSKey) o;
      return   Objects.equals(this.alg, objJWSKey.alg)&&
  Objects.equals(this.kty, objJWSKey.kty)&&
  Objects.equals(this.kid, objJWSKey.kid)&&
  Objects.equals(this.key, objJWSKey.key);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class JWSKey {\n");
                  sb.append("    alg: ").append(toIndentedString(alg)).append("\n");
                        sb.append("    key: ").append(toIndentedString(key)).append("\n");
                        sb.append("    kid: ").append(toIndentedString(kid)).append("\n");
                        sb.append("    kty: ").append(toIndentedString(kty)).append("\n");
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
