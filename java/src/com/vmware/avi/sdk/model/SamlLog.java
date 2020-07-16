package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SamlLog is a POJO class extends AviRestResource that used for creating
 * SamlLog.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SamlLog  {
    @JsonProperty("is_saml_authentication_used")
    private Boolean isSamlAuthenticationUsed = null;

    @JsonProperty("saml_attribute_lists")
    private List<SamlAttribute> samlAttributeLists = null;

    @JsonProperty("saml_auth_status")
    private String samlAuthStatus = null;

    @JsonProperty("saml_authn_rule_match")
    private SamlAuthnRuleMatch samlAuthnRuleMatch = null;

    @JsonProperty("saml_authz_rule_match")
    private SamlAuthzRuleMatch samlAuthzRuleMatch = null;

    @JsonProperty("saml_session_cookie_expired")
    private Boolean samlSessionCookieExpired = null;

    @JsonProperty("userid")
    private String userid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Set to true if saml authentication is used.
   * Field introduced in 20.1.1.
   * @return isSamlAuthenticationUsed
   */
  public Boolean getIsSamlAuthenticationUsed() {
    return isSamlAuthenticationUsed;
  }

  /**
   * This is the setter method to the attribute.
   * Set to true if saml authentication is used.
   * Field introduced in 20.1.1.
   * @param isSamlAuthenticationUsed set the isSamlAuthenticationUsed.
   */
  public void setIsSamlAuthenticationUsed(Boolean  isSamlAuthenticationUsed) {
    this.isSamlAuthenticationUsed = isSamlAuthenticationUsed;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Saml attribute list.
   * Field introduced in 20.1.1.
   * @return samlAttributeLists
   */
  public List<SamlAttribute> getSamlAttributeLists() {
    return samlAttributeLists;
  }

  /**
   * This is the setter method. this will set the samlAttributeLists
   * Saml attribute list.
   * Field introduced in 20.1.1.
   * @return samlAttributeLists
   */
  public void setSamlAttributeLists(List<SamlAttribute>  samlAttributeLists) {
    this.samlAttributeLists = samlAttributeLists;
  }

  /**
   * This is the setter method this will set the samlAttributeLists
   * Saml attribute list.
   * Field introduced in 20.1.1.
   * @return samlAttributeLists
   */
  public SamlLog addSamlAttributeListsItem(SamlAttribute samlAttributeListsItem) {
    if (this.samlAttributeLists == null) {
      this.samlAttributeLists = new ArrayList<SamlAttribute>();
    }
    this.samlAttributeLists.add(samlAttributeListsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Saml authentication status.
   * Enum options - SAML_AUTH_STATUS_UNAVAILABLE, SAML_AUTH_STATUS_UNAUTH_GET_REQUEST, SAML_AUTH_STATUS_UNAUTH_REQ_UNSUPPORTED_METHOD,
   * SAML_AUTH_STATUS_AUTH_REQUEST_GENERATED, SAML_AUTH_STATUS_AUTH_RESPONSE_RECEIVED, SAML_AUTH_STATUS_AUTHENTICATED_REQUEST,
   * SAML_AUTH_STATUS_AUTHORIZATION_FAILED.
   * Field introduced in 20.1.1.
   * @return samlAuthStatus
   */
  public String getSamlAuthStatus() {
    return samlAuthStatus;
  }

  /**
   * This is the setter method to the attribute.
   * Saml authentication status.
   * Enum options - SAML_AUTH_STATUS_UNAVAILABLE, SAML_AUTH_STATUS_UNAUTH_GET_REQUEST, SAML_AUTH_STATUS_UNAUTH_REQ_UNSUPPORTED_METHOD,
   * SAML_AUTH_STATUS_AUTH_REQUEST_GENERATED, SAML_AUTH_STATUS_AUTH_RESPONSE_RECEIVED, SAML_AUTH_STATUS_AUTHENTICATED_REQUEST,
   * SAML_AUTH_STATUS_AUTHORIZATION_FAILED.
   * Field introduced in 20.1.1.
   * @param samlAuthStatus set the samlAuthStatus.
   */
  public void setSamlAuthStatus(String  samlAuthStatus) {
    this.samlAuthStatus = samlAuthStatus;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Saml authentication rule match.
   * Field introduced in 20.1.1.
   * @return samlAuthnRuleMatch
   */
  public SamlAuthnRuleMatch getSamlAuthnRuleMatch() {
    return samlAuthnRuleMatch;
  }

  /**
   * This is the setter method to the attribute.
   * Saml authentication rule match.
   * Field introduced in 20.1.1.
   * @param samlAuthnRuleMatch set the samlAuthnRuleMatch.
   */
  public void setSamlAuthnRuleMatch(SamlAuthnRuleMatch samlAuthnRuleMatch) {
    this.samlAuthnRuleMatch = samlAuthnRuleMatch;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Saml authorization rule match.
   * Field introduced in 20.1.1.
   * @return samlAuthzRuleMatch
   */
  public SamlAuthzRuleMatch getSamlAuthzRuleMatch() {
    return samlAuthzRuleMatch;
  }

  /**
   * This is the setter method to the attribute.
   * Saml authorization rule match.
   * Field introduced in 20.1.1.
   * @param samlAuthzRuleMatch set the samlAuthzRuleMatch.
   */
  public void setSamlAuthzRuleMatch(SamlAuthzRuleMatch samlAuthzRuleMatch) {
    this.samlAuthzRuleMatch = samlAuthzRuleMatch;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Is set when saml session cookie is expired.
   * Field introduced in 20.1.1.
   * @return samlSessionCookieExpired
   */
  public Boolean getSamlSessionCookieExpired() {
    return samlSessionCookieExpired;
  }

  /**
   * This is the setter method to the attribute.
   * Is set when saml session cookie is expired.
   * Field introduced in 20.1.1.
   * @param samlSessionCookieExpired set the samlSessionCookieExpired.
   */
  public void setSamlSessionCookieExpired(Boolean  samlSessionCookieExpired) {
    this.samlSessionCookieExpired = samlSessionCookieExpired;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Saml userid.
   * Field introduced in 20.1.1.
   * @return userid
   */
  public String getUserid() {
    return userid;
  }

  /**
   * This is the setter method to the attribute.
   * Saml userid.
   * Field introduced in 20.1.1.
   * @param userid set the userid.
   */
  public void setUserid(String  userid) {
    this.userid = userid;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SamlLog objSamlLog = (SamlLog) o;
  return   Objects.equals(this.samlAuthnRuleMatch, objSamlLog.samlAuthnRuleMatch)&&
  Objects.equals(this.samlAttributeLists, objSamlLog.samlAttributeLists)&&
  Objects.equals(this.isSamlAuthenticationUsed, objSamlLog.isSamlAuthenticationUsed)&&
  Objects.equals(this.userid, objSamlLog.userid)&&
  Objects.equals(this.samlAuthStatus, objSamlLog.samlAuthStatus)&&
  Objects.equals(this.samlAuthzRuleMatch, objSamlLog.samlAuthzRuleMatch)&&
  Objects.equals(this.samlSessionCookieExpired, objSamlLog.samlSessionCookieExpired);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SamlLog {\n");
      sb.append("    isSamlAuthenticationUsed: ").append(toIndentedString(isSamlAuthenticationUsed)).append("\n");
        sb.append("    samlAttributeLists: ").append(toIndentedString(samlAttributeLists)).append("\n");
        sb.append("    samlAuthStatus: ").append(toIndentedString(samlAuthStatus)).append("\n");
        sb.append("    samlAuthnRuleMatch: ").append(toIndentedString(samlAuthnRuleMatch)).append("\n");
        sb.append("    samlAuthzRuleMatch: ").append(toIndentedString(samlAuthzRuleMatch)).append("\n");
        sb.append("    samlSessionCookieExpired: ").append(toIndentedString(samlSessionCookieExpired)).append("\n");
        sb.append("    userid: ").append(toIndentedString(userid)).append("\n");
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

