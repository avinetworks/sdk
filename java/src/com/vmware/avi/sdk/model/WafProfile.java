package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The WafProfile is a POJO class extends AviRestResource that used for creating
 * WafProfile.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WafProfile extends AviRestResource  {
    @JsonProperty("config")
    private WafConfig config = null;

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("files")
    private List<WafDataFile> files = null;

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
   * Config params for waf.
   * Field introduced in 17.2.1.
   * @return config
   */
  public WafConfig getConfig() {
    return config;
  }

  /**
   * This is the setter method to the attribute.
   * Config params for waf.
   * Field introduced in 17.2.1.
   * @param config set the config.
   */
  public void setConfig(WafConfig config) {
    this.config = config;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.2.1.
   * @return description
   */
  public String getDescription() {
    return description;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.2.1.
   * @param description set the description.
   */
  public void setDescription(String  description) {
    this.description = description;
  }
  /**
   * This is the getter method this will return the attribute value.
   * List of data files used for waf rules.
   * Field introduced in 17.2.1.
   * @return files
   */
  public List<WafDataFile> getFiles() {
    return files;
  }

  /**
   * This is the setter method. this will set the files
   * List of data files used for waf rules.
   * Field introduced in 17.2.1.
   * @return files
   */
  public void setFiles(List<WafDataFile>  files) {
    this.files = files;
  }

  /**
   * This is the setter method this will set the files
   * List of data files used for waf rules.
   * Field introduced in 17.2.1.
   * @return files
   */
  public WafProfile addFilesItem(WafDataFile filesItem) {
    if (this.files == null) {
      this.files = new ArrayList<WafDataFile>();
    }
    this.files.add(filesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Field introduced in 17.2.1.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.2.1.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type tenant.
   * Field introduced in 17.2.1.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
   * It is a reference to an object of type tenant.
   * Field introduced in 17.2.1.
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
   * Field introduced in 17.2.1.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Field introduced in 17.2.1.
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
  WafProfile objWafProfile = (WafProfile) o;
  return   Objects.equals(this.uuid, objWafProfile.uuid)&&
  Objects.equals(this.name, objWafProfile.name)&&
  Objects.equals(this.description, objWafProfile.description)&&
  Objects.equals(this.tenantRef, objWafProfile.tenantRef)&&
  Objects.equals(this.config, objWafProfile.config)&&
  Objects.equals(this.files, objWafProfile.files);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class WafProfile {\n");
      sb.append("    config: ").append(toIndentedString(config)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    files: ").append(toIndentedString(files)).append("\n");
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

