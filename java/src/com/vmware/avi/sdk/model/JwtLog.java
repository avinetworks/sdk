package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The JwtLog is a POJO class extends AviRestResource that used for creating
 * JwtLog.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JwtLog  {
    @JsonProperty("authn_rule_match")
    private AuthnRuleMatch authnRuleMatch = null;

    @JsonProperty("authz_rule_match")
    private AuthzRuleMatch authzRuleMatch = null;

    @JsonProperty("is_jwt_verified")
    private Boolean isJwtVerified = null;

    @JsonProperty("token_payload")
    private String tokenPayload = null;



    /**
     * This is the getter method this will return the attribute value.
     * Authentication policy rule match.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return authnRuleMatch
     */
    public AuthnRuleMatch getAuthnRuleMatch() {
        return authnRuleMatch;
    }

    /**
     * This is the setter method to the attribute.
     * Authentication policy rule match.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param authnRuleMatch set the authnRuleMatch.
     */
    public void setAuthnRuleMatch(AuthnRuleMatch authnRuleMatch) {
        this.authnRuleMatch = authnRuleMatch;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Authorization policy rule match.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return authzRuleMatch
     */
    public AuthzRuleMatch getAuthzRuleMatch() {
        return authzRuleMatch;
    }

    /**
     * This is the setter method to the attribute.
     * Authorization policy rule match.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param authzRuleMatch set the authzRuleMatch.
     */
    public void setAuthzRuleMatch(AuthzRuleMatch authzRuleMatch) {
        this.authzRuleMatch = authzRuleMatch;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Set to true, if jwt validation is successful.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return isJwtVerified
     */
    public Boolean getIsJwtVerified() {
        return isJwtVerified;
    }

    /**
     * This is the setter method to the attribute.
     * Set to true, if jwt validation is successful.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param isJwtVerified set the isJwtVerified.
     */
    public void setIsJwtVerified(Boolean  isJwtVerified) {
        this.isJwtVerified = isJwtVerified;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Jwt token payload.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return tokenPayload
     */
    public String getTokenPayload() {
        return tokenPayload;
    }

    /**
     * This is the setter method to the attribute.
     * Jwt token payload.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param tokenPayload set the tokenPayload.
     */
    public void setTokenPayload(String  tokenPayload) {
        this.tokenPayload = tokenPayload;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      JwtLog objJwtLog = (JwtLog) o;
      return   Objects.equals(this.isJwtVerified, objJwtLog.isJwtVerified)&&
  Objects.equals(this.authnRuleMatch, objJwtLog.authnRuleMatch)&&
  Objects.equals(this.authzRuleMatch, objJwtLog.authzRuleMatch)&&
  Objects.equals(this.tokenPayload, objJwtLog.tokenPayload);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class JwtLog {\n");
                  sb.append("    authnRuleMatch: ").append(toIndentedString(authnRuleMatch)).append("\n");
                        sb.append("    authzRuleMatch: ").append(toIndentedString(authzRuleMatch)).append("\n");
                        sb.append("    isJwtVerified: ").append(toIndentedString(isJwtVerified)).append("\n");
                        sb.append("    tokenPayload: ").append(toIndentedString(tokenPayload)).append("\n");
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
