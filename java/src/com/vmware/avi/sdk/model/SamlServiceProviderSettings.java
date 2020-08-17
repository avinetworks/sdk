package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SamlServiceProviderSettings is a POJO class extends AviRestResource that used for creating
 * SamlServiceProviderSettings.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SamlServiceProviderSettings  {
    @JsonProperty("fqdn")
    private String fqdn = null;

    @JsonProperty("org_display_name")
    private String orgDisplayName = null;

    @JsonProperty("org_name")
    private String orgName = null;

    @JsonProperty("org_url")
    private String orgUrl = null;

    @JsonProperty("saml_entity_type")
    private String samlEntityType = null;

    @JsonProperty("sp_nodes")
    private List<SamlServiceProviderNode> spNodes = null;

    @JsonProperty("tech_contact_email")
    private String techContactEmail = null;

    @JsonProperty("tech_contact_name")
    private String techContactName = null;



  /**
   * This is the getter method this will return the attribute value.
   * Fqdn if entity type is dns_fqdn.
   * Field introduced in 17.2.3.
   * @return fqdn
   */
  public String getFqdn() {
    return fqdn;
  }

  /**
   * This is the setter method to the attribute.
   * Fqdn if entity type is dns_fqdn.
   * Field introduced in 17.2.3.
   * @param fqdn set the fqdn.
   */
  public void setFqdn(String  fqdn) {
    this.fqdn = fqdn;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Service provider organization display name.
   * Field introduced in 17.2.3.
   * @return orgDisplayName
   */
  public String getOrgDisplayName() {
    return orgDisplayName;
  }

  /**
   * This is the setter method to the attribute.
   * Service provider organization display name.
   * Field introduced in 17.2.3.
   * @param orgDisplayName set the orgDisplayName.
   */
  public void setOrgDisplayName(String  orgDisplayName) {
    this.orgDisplayName = orgDisplayName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Service provider organization name.
   * Field introduced in 17.2.3.
   * @return orgName
   */
  public String getOrgName() {
    return orgName;
  }

  /**
   * This is the setter method to the attribute.
   * Service provider organization name.
   * Field introduced in 17.2.3.
   * @param orgName set the orgName.
   */
  public void setOrgName(String  orgName) {
    this.orgName = orgName;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Service provider organization url.
   * Field introduced in 17.2.3.
   * @return orgUrl
   */
  public String getOrgUrl() {
    return orgUrl;
  }

  /**
   * This is the setter method to the attribute.
   * Service provider organization url.
   * Field introduced in 17.2.3.
   * @param orgUrl set the orgUrl.
   */
  public void setOrgUrl(String  orgUrl) {
    this.orgUrl = orgUrl;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Type of saml endpoint.
   * Enum options - AUTH_SAML_CLUSTER_VIP, AUTH_SAML_DNS_FQDN, AUTH_SAML_APP_VS.
   * Field introduced in 17.2.3.
   * @return samlEntityType
   */
  public String getSamlEntityType() {
    return samlEntityType;
  }

  /**
   * This is the setter method to the attribute.
   * Type of saml endpoint.
   * Enum options - AUTH_SAML_CLUSTER_VIP, AUTH_SAML_DNS_FQDN, AUTH_SAML_APP_VS.
   * Field introduced in 17.2.3.
   * @param samlEntityType set the samlEntityType.
   */
  public void setSamlEntityType(String  samlEntityType) {
    this.samlEntityType = samlEntityType;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Service provider node information.
   * Field introduced in 17.2.3.
   * @return spNodes
   */
  public List<SamlServiceProviderNode> getSpNodes() {
    return spNodes;
  }

  /**
   * This is the setter method. this will set the spNodes
   * Service provider node information.
   * Field introduced in 17.2.3.
   * @return spNodes
   */
  public void setSpNodes(List<SamlServiceProviderNode>  spNodes) {
    this.spNodes = spNodes;
  }

  /**
   * This is the setter method this will set the spNodes
   * Service provider node information.
   * Field introduced in 17.2.3.
   * @return spNodes
   */
  public SamlServiceProviderSettings addSpNodesItem(SamlServiceProviderNode spNodesItem) {
    if (this.spNodes == null) {
      this.spNodes = new ArrayList<SamlServiceProviderNode>();
    }
    this.spNodes.add(spNodesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Service provider technical contact email.
   * Field introduced in 17.2.3.
   * @return techContactEmail
   */
  public String getTechContactEmail() {
    return techContactEmail;
  }

  /**
   * This is the setter method to the attribute.
   * Service provider technical contact email.
   * Field introduced in 17.2.3.
   * @param techContactEmail set the techContactEmail.
   */
  public void setTechContactEmail(String  techContactEmail) {
    this.techContactEmail = techContactEmail;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Service provider technical contact name.
   * Field introduced in 17.2.3.
   * @return techContactName
   */
  public String getTechContactName() {
    return techContactName;
  }

  /**
   * This is the setter method to the attribute.
   * Service provider technical contact name.
   * Field introduced in 17.2.3.
   * @param techContactName set the techContactName.
   */
  public void setTechContactName(String  techContactName) {
    this.techContactName = techContactName;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  SamlServiceProviderSettings objSamlServiceProviderSettings = (SamlServiceProviderSettings) o;
  return   Objects.equals(this.samlEntityType, objSamlServiceProviderSettings.samlEntityType)&&
  Objects.equals(this.fqdn, objSamlServiceProviderSettings.fqdn)&&
  Objects.equals(this.spNodes, objSamlServiceProviderSettings.spNodes)&&
  Objects.equals(this.orgName, objSamlServiceProviderSettings.orgName)&&
  Objects.equals(this.orgDisplayName, objSamlServiceProviderSettings.orgDisplayName)&&
  Objects.equals(this.orgUrl, objSamlServiceProviderSettings.orgUrl)&&
  Objects.equals(this.techContactName, objSamlServiceProviderSettings.techContactName)&&
  Objects.equals(this.techContactEmail, objSamlServiceProviderSettings.techContactEmail);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SamlServiceProviderSettings {\n");
      sb.append("    fqdn: ").append(toIndentedString(fqdn)).append("\n");
        sb.append("    orgDisplayName: ").append(toIndentedString(orgDisplayName)).append("\n");
        sb.append("    orgName: ").append(toIndentedString(orgName)).append("\n");
        sb.append("    orgUrl: ").append(toIndentedString(orgUrl)).append("\n");
        sb.append("    samlEntityType: ").append(toIndentedString(samlEntityType)).append("\n");
        sb.append("    spNodes: ").append(toIndentedString(spNodes)).append("\n");
        sb.append("    techContactEmail: ").append(toIndentedString(techContactEmail)).append("\n");
        sb.append("    techContactName: ").append(toIndentedString(techContactName)).append("\n");
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

