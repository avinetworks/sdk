package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SecureChannelToken is a POJO class extends AviRestResource that used for creating
 * SecureChannelToken.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SecureChannelToken extends AviRestResource  {
    @JsonProperty("expiry_time")
    private Float expiryTime = null;

    @JsonProperty("metadata")
    private List<SecureChannelMetadata> metadata = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("node_uuid")
    private String nodeUuid = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Expiry time for secure channel.
   * @return expiryTime
   */
  public Float getExpiryTime() {
    return expiryTime;
  }

  /**
   * This is the setter method to the attribute.
   * Expiry time for secure channel.
   * @param expiryTime set the expiryTime.
   */
  public void setExpiryTime(Float  expiryTime) {
    this.expiryTime = expiryTime;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property metadata of obj type securechanneltoken field type str  type array.
   * @return metadata
   */
  public List<SecureChannelMetadata> getMetadata() {
    return metadata;
  }

  /**
   * This is the setter method. this will set the metadata
   * Placeholder for description of property metadata of obj type securechanneltoken field type str  type array.
   * @return metadata
   */
  public void setMetadata(List<SecureChannelMetadata>  metadata) {
    this.metadata = metadata;
  }

  /**
   * This is the setter method this will set the metadata
   * Placeholder for description of property metadata of obj type securechanneltoken field type str  type array.
   * @return metadata
   */
  public SecureChannelToken addMetadataItem(SecureChannelMetadata metadataItem) {
    if (this.metadata == null) {
      this.metadata = new ArrayList<SecureChannelMetadata>();
    }
    this.metadata.add(metadataItem);
    return this;
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
   * Unique object identifier of node.
   * @return nodeUuid
   */
  public String getNodeUuid() {
    return nodeUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of node.
   * @param nodeUuid set the nodeUuid.
   */
  public void setNodeUuid(String  nodeUuid) {
    this.nodeUuid = nodeUuid;
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
  SecureChannelToken objSecureChannelToken = (SecureChannelToken) o;
  return   Objects.equals(this.nodeUuid, objSecureChannelToken.nodeUuid)&&
  Objects.equals(this.expiryTime, objSecureChannelToken.expiryTime)&&
  Objects.equals(this.uuid, objSecureChannelToken.uuid)&&
  Objects.equals(this.name, objSecureChannelToken.name)&&
  Objects.equals(this.metadata, objSecureChannelToken.metadata);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SecureChannelToken {\n");
      sb.append("    expiryTime: ").append(toIndentedString(expiryTime)).append("\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    nodeUuid: ").append(toIndentedString(nodeUuid)).append("\n");
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

