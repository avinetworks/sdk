package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The CloudConnectorUser is a POJO class extends AviRestResource that used for creating
 * CloudConnectorUser.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CloudConnectorUser extends AviRestResource  {
    @JsonProperty("azure_serviceprincipal")
    private AzureServicePrincipalCredentials azureServiceprincipal = null;

    @JsonProperty("azure_userpass")
    private AzureUserPassCredentials azureUserpass = null;

    @JsonProperty("gcp_credentials")
    private GCPCredentials gcpCredentials = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("nsxt_credentials")
    private NsxtCredentials nsxtCredentials = null;

    @JsonProperty("oci_credentials")
    private OCICredentials ociCredentials = null;

    @JsonProperty("password")
    private String password = null;

    @JsonProperty("private_key")
    private String privateKey = null;

    @JsonProperty("public_key")
    private String publicKey = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("tencent_credentials")
    private TencentCredentials tencentCredentials = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;

    @JsonProperty("vcenter_credentials")
    private VCenterCredentials vcenterCredentials = null;



  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.2.1.
   * @return azureServiceprincipal
   */
  public AzureServicePrincipalCredentials getAzureServiceprincipal() {
    return azureServiceprincipal;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.2.1.
   * @param azureServiceprincipal set the azureServiceprincipal.
   */
  public void setAzureServiceprincipal(AzureServicePrincipalCredentials azureServiceprincipal) {
    this.azureServiceprincipal = azureServiceprincipal;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.2.1.
   * @return azureUserpass
   */
  public AzureUserPassCredentials getAzureUserpass() {
    return azureUserpass;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.2.1.
   * @param azureUserpass set the azureUserpass.
   */
  public void setAzureUserpass(AzureUserPassCredentials azureUserpass) {
    this.azureUserpass = azureUserpass;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Credentials for google cloud platform.
   * Field introduced in 18.2.1.
   * @return gcpCredentials
   */
  public GCPCredentials getGcpCredentials() {
    return gcpCredentials;
  }

  /**
   * This is the setter method to the attribute.
   * Credentials for google cloud platform.
   * Field introduced in 18.2.1.
   * @param gcpCredentials set the gcpCredentials.
   */
  public void setGcpCredentials(GCPCredentials gcpCredentials) {
    this.gcpCredentials = gcpCredentials;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the object.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the object.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Credentials to talk to nsx-t manager.
   * Field introduced in 20.1.1.
   * @return nsxtCredentials
   */
  public NsxtCredentials getNsxtCredentials() {
    return nsxtCredentials;
  }

  /**
   * This is the setter method to the attribute.
   * Credentials to talk to nsx-t manager.
   * Field introduced in 20.1.1.
   * @param nsxtCredentials set the nsxtCredentials.
   */
  public void setNsxtCredentials(NsxtCredentials nsxtCredentials) {
    this.nsxtCredentials = nsxtCredentials;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Credentials for oracle cloud infrastructure.
   * Field introduced in 18.2.1,18.1.3.
   * @return ociCredentials
   */
  public OCICredentials getOciCredentials() {
    return ociCredentials;
  }

  /**
   * This is the setter method to the attribute.
   * Credentials for oracle cloud infrastructure.
   * Field introduced in 18.2.1,18.1.3.
   * @param ociCredentials set the ociCredentials.
   */
  public void setOciCredentials(OCICredentials ociCredentials) {
    this.ociCredentials = ociCredentials;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property password of obj type cloudconnectoruser field type str  type string.
   * @return password
   */
  public String getPassword() {
    return password;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property password of obj type cloudconnectoruser field type str  type string.
   * @param password set the password.
   */
  public void setPassword(String  password) {
    this.password = password;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property private_key of obj type cloudconnectoruser field type str  type string.
   * @return privateKey
   */
  public String getPrivateKey() {
    return privateKey;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property private_key of obj type cloudconnectoruser field type str  type string.
   * @param privateKey set the privateKey.
   */
  public void setPrivateKey(String  privateKey) {
    this.privateKey = privateKey;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property public_key of obj type cloudconnectoruser field type str  type string.
   * @return publicKey
   */
  public String getPublicKey() {
    return publicKey;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property public_key of obj type cloudconnectoruser field type str  type string.
   * @param publicKey set the publicKey.
   */
  public void setPublicKey(String  publicKey) {
    this.publicKey = publicKey;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type tenant.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type tenant.
   * @param tenantRef set the tenantRef.
   */
  public void setTenantRef(String  tenantRef) {
    this.tenantRef = tenantRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Credentials for tencent cloud.
   * Field introduced in 18.2.3.
   * @return tencentCredentials
   */
  public TencentCredentials getTencentCredentials() {
    return tencentCredentials;
  }

  /**
   * This is the setter method to the attribute.
   * Credentials for tencent cloud.
   * Field introduced in 18.2.3.
   * @param tencentCredentials set the tencentCredentials.
   */
  public void setTencentCredentials(TencentCredentials tencentCredentials) {
    this.tencentCredentials = tencentCredentials;
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
   * Unique object identifier of the object.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of the object.
   * @param uuid set the uuid.
   */
  public void setUuid(String  uuid) {
    this.uuid = uuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Credentials to talk to vcenter.
   * Field introduced in 20.1.1.
   * @return vcenterCredentials
   */
  public VCenterCredentials getVcenterCredentials() {
    return vcenterCredentials;
  }

  /**
   * This is the setter method to the attribute.
   * Credentials to talk to vcenter.
   * Field introduced in 20.1.1.
   * @param vcenterCredentials set the vcenterCredentials.
   */
  public void setVcenterCredentials(VCenterCredentials vcenterCredentials) {
    this.vcenterCredentials = vcenterCredentials;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  CloudConnectorUser objCloudConnectorUser = (CloudConnectorUser) o;
  return   Objects.equals(this.publicKey, objCloudConnectorUser.publicKey)&&
  Objects.equals(this.privateKey, objCloudConnectorUser.privateKey)&&
  Objects.equals(this.ociCredentials, objCloudConnectorUser.ociCredentials)&&
  Objects.equals(this.uuid, objCloudConnectorUser.uuid)&&
  Objects.equals(this.vcenterCredentials, objCloudConnectorUser.vcenterCredentials)&&
  Objects.equals(this.tencentCredentials, objCloudConnectorUser.tencentCredentials)&&
  Objects.equals(this.gcpCredentials, objCloudConnectorUser.gcpCredentials)&&
  Objects.equals(this.azureServiceprincipal, objCloudConnectorUser.azureServiceprincipal)&&
  Objects.equals(this.azureUserpass, objCloudConnectorUser.azureUserpass)&&
  Objects.equals(this.nsxtCredentials, objCloudConnectorUser.nsxtCredentials)&&
  Objects.equals(this.password, objCloudConnectorUser.password)&&
  Objects.equals(this.tenantRef, objCloudConnectorUser.tenantRef)&&
  Objects.equals(this.name, objCloudConnectorUser.name);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class CloudConnectorUser {\n");
      sb.append("    azureServiceprincipal: ").append(toIndentedString(azureServiceprincipal)).append("\n");
        sb.append("    azureUserpass: ").append(toIndentedString(azureUserpass)).append("\n");
        sb.append("    gcpCredentials: ").append(toIndentedString(gcpCredentials)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    nsxtCredentials: ").append(toIndentedString(nsxtCredentials)).append("\n");
        sb.append("    ociCredentials: ").append(toIndentedString(ociCredentials)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
        sb.append("    privateKey: ").append(toIndentedString(privateKey)).append("\n");
        sb.append("    publicKey: ").append(toIndentedString(publicKey)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
        sb.append("    tencentCredentials: ").append(toIndentedString(tencentCredentials)).append("\n");
            sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
        sb.append("    vcenterCredentials: ").append(toIndentedString(vcenterCredentials)).append("\n");
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

