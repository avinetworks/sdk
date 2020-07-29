package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The CertificateManagementProfile is a POJO class extends AviRestResource that used for creating
 * CertificateManagementProfile.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CertificateManagementProfile extends AviRestResource  {
    @JsonProperty("name")
    private String name = null;

    @JsonProperty("script_params")
    private List<CustomParams> scriptParams = null;

    @JsonProperty("script_path")
    private String scriptPath = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Name of the pki profile.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the pki profile.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property script_params of obj type certificatemanagementprofile field type str  type array.
   * @return scriptParams
   */
  public List<CustomParams> getScriptParams() {
    return scriptParams;
  }

  /**
   * This is the setter method. this will set the scriptParams
   * Placeholder for description of property script_params of obj type certificatemanagementprofile field type str  type array.
   * @return scriptParams
   */
  public void setScriptParams(List<CustomParams>  scriptParams) {
    this.scriptParams = scriptParams;
  }

  /**
   * This is the setter method this will set the scriptParams
   * Placeholder for description of property script_params of obj type certificatemanagementprofile field type str  type array.
   * @return scriptParams
   */
  public CertificateManagementProfile addScriptParamsItem(CustomParams scriptParamsItem) {
    if (this.scriptParams == null) {
      this.scriptParams = new ArrayList<CustomParams>();
    }
    this.scriptParams.add(scriptParamsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property script_path of obj type certificatemanagementprofile field type str  type string.
   * @return scriptPath
   */
  public String getScriptPath() {
    return scriptPath;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property script_path of obj type certificatemanagementprofile field type str  type string.
   * @param scriptPath set the scriptPath.
   */
  public void setScriptPath(String  scriptPath) {
    this.scriptPath = scriptPath;
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


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  CertificateManagementProfile objCertificateManagementProfile = (CertificateManagementProfile) o;
  return   Objects.equals(this.uuid, objCertificateManagementProfile.uuid)&&
  Objects.equals(this.name, objCertificateManagementProfile.name)&&
  Objects.equals(this.scriptParams, objCertificateManagementProfile.scriptParams)&&
  Objects.equals(this.scriptPath, objCertificateManagementProfile.scriptPath)&&
  Objects.equals(this.tenantRef, objCertificateManagementProfile.tenantRef);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class CertificateManagementProfile {\n");
      sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    scriptParams: ").append(toIndentedString(scriptParams)).append("\n");
        sb.append("    scriptPath: ").append(toIndentedString(scriptPath)).append("\n");
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

