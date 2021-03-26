package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The JWTProfile is a POJO class extends AviRestResource that used for creating
 * JWTProfile.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JWTProfile extends AviRestResource  {
    @JsonProperty("is_federated")
    private Boolean isFederated = false;

    @JsonProperty("jwks_keys")
    private List<JWSKey> jwksKeys = null;

    @JsonProperty("jwt_auth_type")
    private String jwtAuthType = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



    /**
     * This is the getter method this will return the attribute value.
     * This field describes the object's replication scope.
     * If the field is set to false, then the object is visible within the controller-cluster.
     * If the field is set to true, then the object is replicated across the federation.
     * Field introduced in 20.1.5.
     * Allowed in basic(allowed values- false) edition, essentials(allowed values- false) edition, enterprise edition.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @return isFederated
     */
    public Boolean getIsFederated() {
        return isFederated;
    }

    /**
     * This is the setter method to the attribute.
     * This field describes the object's replication scope.
     * If the field is set to false, then the object is visible within the controller-cluster.
     * If the field is set to true, then the object is replicated across the federation.
     * Field introduced in 20.1.5.
     * Allowed in basic(allowed values- false) edition, essentials(allowed values- false) edition, enterprise edition.
     * Default value when not specified in API or module is interpreted by Avi Controller as false.
     * @param isFederated set the isFederated.
     */
    public void setIsFederated(Boolean  isFederated) {
        this.isFederated = isFederated;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Jwk keys used for signing/validating the jwt.
     * Field introduced in 20.1.5.
     * Minimum of 1 items required.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return jwksKeys
     */
    public List<JWSKey> getJwksKeys() {
        return jwksKeys;
    }

    /**
     * This is the setter method. this will set the jwksKeys
     * Jwk keys used for signing/validating the jwt.
     * Field introduced in 20.1.5.
     * Minimum of 1 items required.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return jwksKeys
     */
    public void setJwksKeys(List<JWSKey>  jwksKeys) {
        this.jwksKeys = jwksKeys;
    }

    /**
     * This is the setter method this will set the jwksKeys
     * Jwk keys used for signing/validating the jwt.
     * Field introduced in 20.1.5.
     * Minimum of 1 items required.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return jwksKeys
     */
    public JWTProfile addJwksKeysItem(JWSKey jwksKeysItem) {
      if (this.jwksKeys == null) {
        this.jwksKeys = new ArrayList<JWSKey>();
      }
      this.jwksKeys.add(jwksKeysItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Jwt auth type for jwt validation.
     * Enum options - JWT_TYPE_JWS.
     * Field introduced in 20.1.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return jwtAuthType
     */
    public String getJwtAuthType() {
        return jwtAuthType;
    }

    /**
     * This is the setter method to the attribute.
     * Jwt auth type for jwt validation.
     * Enum options - JWT_TYPE_JWS.
     * Field introduced in 20.1.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param jwtAuthType set the jwtAuthType.
     */
    public void setJwtAuthType(String  jwtAuthType) {
        this.jwtAuthType = jwtAuthType;
    }

    /**
     * This is the getter method this will return the attribute value.
     * A user friendly name for this jwt profile.
     * Field introduced in 20.1.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This is the setter method to the attribute.
     * A user friendly name for this jwt profile.
     * Field introduced in 20.1.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param name set the name.
     */
    public void setName(String  name) {
        this.name = name;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Uuid of the tenant.
     * It is a reference to an object of type tenant.
     * Field introduced in 20.1.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return tenantRef
     */
    public String getTenantRef() {
        return tenantRef;
    }

    /**
     * This is the setter method to the attribute.
     * Uuid of the tenant.
     * It is a reference to an object of type tenant.
     * Field introduced in 20.1.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param tenantRef set the tenantRef.
     */
    public void setTenantRef(String  tenantRef) {
        this.tenantRef = tenantRef;
    }
    /**
     * This is the getter method this will return the attribute value.
     * Avi controller URL of the object.
     * @return url
     */
    public String getUrl() {
        return url;
    }

   /**
    * This is the setter method. this will set the url
    * Avi controller URL of the object.
    * @return url
    */
   public void setUrl(String  url) {
     this.url = url;
   }

    /**
     * This is the getter method this will return the attribute value.
     * Uuid of the jwt profile.
     * Field introduced in 20.1.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This is the setter method to the attribute.
     * Uuid of the jwt profile.
     * Field introduced in 20.1.5.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param uuid set the uuid.
     */
    public void setUuid(String  uuid) {
        this.uuid = uuid;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      JWTProfile objJWTProfile = (JWTProfile) o;
      return   Objects.equals(this.uuid, objJWTProfile.uuid)&&
  Objects.equals(this.name, objJWTProfile.name)&&
  Objects.equals(this.isFederated, objJWTProfile.isFederated)&&
  Objects.equals(this.tenantRef, objJWTProfile.tenantRef)&&
  Objects.equals(this.jwksKeys, objJWTProfile.jwksKeys)&&
  Objects.equals(this.jwtAuthType, objJWTProfile.jwtAuthType);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class JWTProfile {\n");
                  sb.append("    isFederated: ").append(toIndentedString(isFederated)).append("\n");
                        sb.append("    jwksKeys: ").append(toIndentedString(jwksKeys)).append("\n");
                        sb.append("    jwtAuthType: ").append(toIndentedString(jwtAuthType)).append("\n");
                        sb.append("    name: ").append(toIndentedString(name)).append("\n");
                        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
                                    sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
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
