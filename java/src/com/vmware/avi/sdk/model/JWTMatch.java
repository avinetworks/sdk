package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The JWTMatch is a POJO class extends AviRestResource that used for creating
 * JWTMatch.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JWTMatch  {
    @JsonProperty("matches")
    private List<JWTClaimMatch> matches = null;

    @JsonProperty("token_name")
    private String tokenName = null;


    /**
     * This is the getter method this will return the attribute value.
     * Claims whose values need to be matched.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return matches
     */
    public List<JWTClaimMatch> getMatches() {
        return matches;
    }

    /**
     * This is the setter method. this will set the matches
     * Claims whose values need to be matched.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return matches
     */
    public void setMatches(List<JWTClaimMatch>  matches) {
        this.matches = matches;
    }

    /**
     * This is the setter method this will set the matches
     * Claims whose values need to be matched.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return matches
     */
    public JWTMatch addMatchesItem(JWTClaimMatch matchesItem) {
      if (this.matches == null) {
        this.matches = new ArrayList<JWTClaimMatch>();
      }
      this.matches.add(matchesItem);
      return this;
    }

    /**
     * This is the getter method this will return the attribute value.
     * Token for which the claims need to be validated.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @return tokenName
     */
    public String getTokenName() {
        return tokenName;
    }

    /**
     * This is the setter method to the attribute.
     * Token for which the claims need to be validated.
     * Field introduced in 20.1.3.
     * Default value when not specified in API or module is interpreted by Avi Controller as null.
     * @param tokenName set the tokenName.
     */
    public void setTokenName(String  tokenName) {
        this.tokenName = tokenName;
    }


    @Override
    public boolean equals(java.lang.Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
      JWTMatch objJWTMatch = (JWTMatch) o;
      return   Objects.equals(this.tokenName, objJWTMatch.tokenName)&&
  Objects.equals(this.matches, objJWTMatch.matches);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class JWTMatch {\n");
                  sb.append("    matches: ").append(toIndentedString(matches)).append("\n");
                        sb.append("    tokenName: ").append(toIndentedString(tokenName)).append("\n");
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
