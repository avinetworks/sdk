package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The FileObject is a POJO class extends AviRestResource that used for creating
 * FileObject.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FileObject extends AviRestResource  {
    @JsonProperty("checksum")
    private String checksum = null;

    @JsonProperty("compressed")
    private Boolean compressed = false;

    @JsonProperty("created")
    private String created = null;

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("expires_at")
    private String expiresAt = null;

    @JsonProperty("is_federated")
    private Boolean isFederated = false;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("path")
    private String path = null;

    @JsonProperty("read_only")
    private Boolean readOnly = null;

    @JsonProperty("restrict_download")
    private Boolean restrictDownload = null;

    @JsonProperty("size")
    private Integer size = null;

    @JsonProperty("tenant_ref")
    private String tenantRef = null;

    @JsonProperty("type")
    private String type = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;

    @JsonProperty("version")
    private String version = null;



  /**
   * This is the getter method this will return the attribute value.
   * Sha1 checksum of the file.
   * Field introduced in 20.1.1.
   * @return checksum
   */
  public String getChecksum() {
    return checksum;
  }

  /**
   * This is the setter method to the attribute.
   * Sha1 checksum of the file.
   * Field introduced in 20.1.1.
   * @param checksum set the checksum.
   */
  public void setChecksum(String  checksum) {
    this.checksum = checksum;
  }

  /**
   * This is the getter method this will return the attribute value.
   * This field indicates whether the file is gzip-compressed.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return compressed
   */
  public Boolean getCompressed() {
    return compressed;
  }

  /**
   * This is the setter method to the attribute.
   * This field indicates whether the file is gzip-compressed.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param compressed set the compressed.
   */
  public void setCompressed(Boolean  compressed) {
    this.compressed = compressed;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Timestamp of creation for the file.
   * Field introduced in 20.1.1.
   * @return created
   */
  public String getCreated() {
    return created;
  }

  /**
   * This is the setter method to the attribute.
   * Timestamp of creation for the file.
   * Field introduced in 20.1.1.
   * @param created set the created.
   */
  public void setCreated(String  created) {
    this.created = created;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Description of the file.
   * Field introduced in 20.1.1.
   * @return description
   */
  public String getDescription() {
    return description;
  }

  /**
   * This is the setter method to the attribute.
   * Description of the file.
   * Field introduced in 20.1.1.
   * @param description set the description.
   */
  public void setDescription(String  description) {
    this.description = description;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Timestamp when the file will be no longer needed and can be removed by the system.
   * If this is set, a garbage collector process will try to remove the file after this time.
   * Field introduced in 20.1.1.
   * @return expiresAt
   */
  public String getExpiresAt() {
    return expiresAt;
  }

  /**
   * This is the setter method to the attribute.
   * Timestamp when the file will be no longer needed and can be removed by the system.
   * If this is set, a garbage collector process will try to remove the file after this time.
   * Field introduced in 20.1.1.
   * @param expiresAt set the expiresAt.
   */
  public void setExpiresAt(String  expiresAt) {
    this.expiresAt = expiresAt;
  }

  /**
   * This is the getter method this will return the attribute value.
   * This field describes the object's replication scope.
   * If the field is set to false, then the object is visible within the controller-cluster and its associated service-engines.
   * If the field is set to true, then the object is replicated across the federation.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return isFederated
   */
  public Boolean getIsFederated() {
    return isFederated;
  }

  /**
   * This is the setter method to the attribute.
   * This field describes the object's replication scope.
   * If the field is set to false, then the object is visible within the controller-cluster and its associated service-engines.
   * If the field is set to true, then the object is replicated across the federation.
   * Field introduced in 20.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param isFederated set the isFederated.
   */
  public void setIsFederated(Boolean  isFederated) {
    this.isFederated = isFederated;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the file object.
   * Field introduced in 20.1.1.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the file object.
   * Field introduced in 20.1.1.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Path to the file.
   * Field introduced in 20.1.1.
   * @return path
   */
  public String getPath() {
    return path;
  }

  /**
   * This is the setter method to the attribute.
   * Path to the file.
   * Field introduced in 20.1.1.
   * @param path set the path.
   */
  public void setPath(String  path) {
    this.path = path;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enforce read-only on the file.
   * Field introduced in 20.1.1.
   * @return readOnly
   */
  public Boolean getReadOnly() {
    return readOnly;
  }

  /**
   * This is the setter method to the attribute.
   * Enforce read-only on the file.
   * Field introduced in 20.1.1.
   * @param readOnly set the readOnly.
   */
  public void setReadOnly(Boolean  readOnly) {
    this.readOnly = readOnly;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Flag to allow/restrict download of the file.
   * Field introduced in 20.1.1.
   * @return restrictDownload
   */
  public Boolean getRestrictDownload() {
    return restrictDownload;
  }

  /**
   * This is the setter method to the attribute.
   * Flag to allow/restrict download of the file.
   * Field introduced in 20.1.1.
   * @param restrictDownload set the restrictDownload.
   */
  public void setRestrictDownload(Boolean  restrictDownload) {
    this.restrictDownload = restrictDownload;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Size of the file.
   * Field introduced in 20.1.1.
   * @return size
   */
  public Integer getSize() {
    return size;
  }

  /**
   * This is the setter method to the attribute.
   * Size of the file.
   * Field introduced in 20.1.1.
   * @param size set the size.
   */
  public void setSize(Integer  size) {
    this.size = size;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Tenant that this object belongs to.
   * It is a reference to an object of type tenant.
   * Field introduced in 20.1.1.
   * @return tenantRef
   */
  public String getTenantRef() {
    return tenantRef;
  }

  /**
   * This is the setter method to the attribute.
   * Tenant that this object belongs to.
   * It is a reference to an object of type tenant.
   * Field introduced in 20.1.1.
   * @param tenantRef set the tenantRef.
   */
  public void setTenantRef(String  tenantRef) {
    this.tenantRef = tenantRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Type of the file.
   * Enum options - OTHER_FILE_TYPES, IP_REPUTATION, GEO_DB, TECH_SUPPORT, HSMPACKAGES, IPAMDNSSCRIPTS, CONTROLLER_IMAGE.
   * Field introduced in 20.1.1.
   * @return type
   */
  public String getType() {
    return type;
  }

  /**
   * This is the setter method to the attribute.
   * Type of the file.
   * Enum options - OTHER_FILE_TYPES, IP_REPUTATION, GEO_DB, TECH_SUPPORT, HSMPACKAGES, IPAMDNSSCRIPTS, CONTROLLER_IMAGE.
   * Field introduced in 20.1.1.
   * @param type set the type.
   */
  public void setType(String  type) {
    this.type = type;
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
   * Uuid of the file.
   * Field introduced in 20.1.1.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the file.
   * Field introduced in 20.1.1.
   * @param uuid set the uuid.
   */
  public void setUuid(String  uuid) {
    this.uuid = uuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Version of the file.
   * Field introduced in 20.1.1.
   * @return version
   */
  public String getVersion() {
    return version;
  }

  /**
   * This is the setter method to the attribute.
   * Version of the file.
   * Field introduced in 20.1.1.
   * @param version set the version.
   */
  public void setVersion(String  version) {
    this.version = version;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  FileObject objFileObject = (FileObject) o;
  return   Objects.equals(this.readOnly, objFileObject.readOnly)&&
  Objects.equals(this.restrictDownload, objFileObject.restrictDownload)&&
  Objects.equals(this.uuid, objFileObject.uuid)&&
  Objects.equals(this.created, objFileObject.created)&&
  Objects.equals(this.checksum, objFileObject.checksum)&&
  Objects.equals(this.description, objFileObject.description)&&
  Objects.equals(this.isFederated, objFileObject.isFederated)&&
  Objects.equals(this.expiresAt, objFileObject.expiresAt)&&
  Objects.equals(this.name, objFileObject.name)&&
  Objects.equals(this.version, objFileObject.version)&&
  Objects.equals(this.compressed, objFileObject.compressed)&&
  Objects.equals(this.path, objFileObject.path)&&
  Objects.equals(this.type, objFileObject.type)&&
  Objects.equals(this.tenantRef, objFileObject.tenantRef)&&
  Objects.equals(this.size, objFileObject.size);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class FileObject {\n");
      sb.append("    checksum: ").append(toIndentedString(checksum)).append("\n");
        sb.append("    compressed: ").append(toIndentedString(compressed)).append("\n");
        sb.append("    created: ").append(toIndentedString(created)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    expiresAt: ").append(toIndentedString(expiresAt)).append("\n");
        sb.append("    isFederated: ").append(toIndentedString(isFederated)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    path: ").append(toIndentedString(path)).append("\n");
        sb.append("    readOnly: ").append(toIndentedString(readOnly)).append("\n");
        sb.append("    restrictDownload: ").append(toIndentedString(restrictDownload)).append("\n");
        sb.append("    size: ").append(toIndentedString(size)).append("\n");
        sb.append("    tenantRef: ").append(toIndentedString(tenantRef)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
            sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
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

