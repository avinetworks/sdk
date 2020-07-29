package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The CustomIpamDnsProfile is a POJO class extends AviRestResource that used for creating
 * CustomIpamDnsProfile.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomIpamDnsProfile extends AviRestResource  {
    @JsonProperty("name")
    private String name = null;

    @JsonProperty("script_params")
    private List<CustomParams> scriptParams = null;

    @JsonProperty("script_uri")
    private String scriptUri = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Name of the custom ipam dns profile.
   * Field introduced in 17.1.1.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the custom ipam dns profile.
   * Field introduced in 17.1.1.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Parameters that are always passed to the ipam/dns script.
   * Field introduced in 17.1.1.
   * @return scriptParams
   */
  public List<CustomParams> getScriptParams() {
    return scriptParams;
  }

  /**
   * This is the setter method. this will set the scriptParams
   * Parameters that are always passed to the ipam/dns script.
   * Field introduced in 17.1.1.
   * @return scriptParams
   */
  public void setScriptParams(List<CustomParams>  scriptParams) {
    this.scriptParams = scriptParams;
  }

  /**
   * This is the setter method this will set the scriptParams
   * Parameters that are always passed to the ipam/dns script.
   * Field introduced in 17.1.1.
   * @return scriptParams
   */
  public CustomIpamDnsProfile addScriptParamsItem(CustomParams scriptParamsItem) {
    if (this.scriptParams == null) {
      this.scriptParams = new ArrayList<CustomParams>();
    }
    this.scriptParams.add(scriptParamsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Script uri of form controller //ipamdnsscripts/<file-name>.
   * Field introduced in 17.1.1.
   * @return scriptUri
   */
  public String getScriptUri() {
    return scriptUri;
  }

  /**
   * This is the setter method to the attribute.
   * Script uri of form controller //ipamdnsscripts/<file-name>.
   * Field introduced in 17.1.1.
   * @param scriptUri set the scriptUri.
   */
  public void setScriptUri(String  scriptUri) {
    this.scriptUri = scriptUri;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type tenant.
   * Field introduced in 17.1.1.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type tenant.
   * Field introduced in 17.1.1.
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
   * Field introduced in 17.1.1.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.1.1.
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
  CustomIpamDnsProfile objCustomIpamDnsProfile = (CustomIpamDnsProfile) o;
  return   Objects.equals(this.uuid, objCustomIpamDnsProfile.uuid)&&
  Objects.equals(this.name, objCustomIpamDnsProfile.name)&&
  Objects.equals(this.scriptUri, objCustomIpamDnsProfile.scriptUri)&&
  Objects.equals(this.scriptParams, objCustomIpamDnsProfile.scriptParams)&&
  Objects.equals(this.tenantRef, objCustomIpamDnsProfile.tenantRef);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class CustomIpamDnsProfile {\n");
      sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    scriptParams: ").append(toIndentedString(scriptParams)).append("\n");
        sb.append("    scriptUri: ").append(toIndentedString(scriptUri)).append("\n");
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

