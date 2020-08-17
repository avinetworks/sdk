package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SecureChannelMapping is a POJO class extends AviRestResource that used for creating
 * SecureChannelMapping.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SecureChannelMapping extends AviRestResource  {
    @JsonProperty("ip")
    private String ip = null;

    @JsonProperty("is_controller")
    private Boolean isController = false;

    @JsonProperty("local_ip")
    private String localIp = null;

    @JsonProperty("marked_for_delete")
    private Boolean markedForDelete = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("pub_key")
    private String pubKey = null;

    @JsonProperty("pub_key_pem")
    private String pubKeyPem = null;

    @JsonProperty("status")
    private String status = "SECURE_CHANNEL_NONE";

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property ip of obj type securechannelmapping field type str  type string.
   * @return ip
   */
  public String getIp() {
    return ip;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property ip of obj type securechannelmapping field type str  type string.
   * @param ip set the ip.
   */
  public void setIp(String  ip) {
    this.ip = ip;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property is_controller of obj type securechannelmapping field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return isController
   */
  public Boolean getIsController() {
    return isController;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property is_controller of obj type securechannelmapping field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param isController set the isController.
   */
  public void setIsController(Boolean  isController) {
    this.isController = isController;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property local_ip of obj type securechannelmapping field type str  type string.
   * @return localIp
   */
  public String getLocalIp() {
    return localIp;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property local_ip of obj type securechannelmapping field type str  type string.
   * @param localIp set the localIp.
   */
  public void setLocalIp(String  localIp) {
    this.localIp = localIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property marked_for_delete of obj type securechannelmapping field type str  type boolean.
   * @return markedForDelete
   */
  public Boolean getMarkedForDelete() {
    return markedForDelete;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property marked_for_delete of obj type securechannelmapping field type str  type boolean.
   * @param markedForDelete set the markedForDelete.
   */
  public void setMarkedForDelete(Boolean  markedForDelete) {
    this.markedForDelete = markedForDelete;
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
   * Placeholder for description of property pub_key of obj type securechannelmapping field type str  type string.
   * @return pubKey
   */
  public String getPubKey() {
    return pubKey;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property pub_key of obj type securechannelmapping field type str  type string.
   * @param pubKey set the pubKey.
   */
  public void setPubKey(String  pubKey) {
    this.pubKey = pubKey;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property pub_key_pem of obj type securechannelmapping field type str  type string.
   * @return pubKeyPem
   */
  public String getPubKeyPem() {
    return pubKeyPem;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property pub_key_pem of obj type securechannelmapping field type str  type string.
   * @param pubKeyPem set the pubKeyPem.
   */
  public void setPubKeyPem(String  pubKeyPem) {
    this.pubKeyPem = pubKeyPem;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - SECURE_CHANNEL_NONE, SECURE_CHANNEL_CONNECTED, SECURE_CHANNEL_AUTH_SSH_SUCCESS, SECURE_CHANNEL_AUTH_SSH_FAILED,
   * SECURE_CHANNEL_AUTH_TOKEN_SUCCESS, SECURE_CHANNEL_AUTH_TOKEN_FAILED, SECURE_CHANNEL_AUTH_ERRORS, SECURE_CHANNEL_AUTH_IGNORED.
   * Default value when not specified in API or module is interpreted by Avi Controller as SECURE_CHANNEL_NONE.
   * @return status
   */
  public String getStatus() {
    return status;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - SECURE_CHANNEL_NONE, SECURE_CHANNEL_CONNECTED, SECURE_CHANNEL_AUTH_SSH_SUCCESS, SECURE_CHANNEL_AUTH_SSH_FAILED,
   * SECURE_CHANNEL_AUTH_TOKEN_SUCCESS, SECURE_CHANNEL_AUTH_TOKEN_FAILED, SECURE_CHANNEL_AUTH_ERRORS, SECURE_CHANNEL_AUTH_IGNORED.
   * Default value when not specified in API or module is interpreted by Avi Controller as SECURE_CHANNEL_NONE.
   * @param status set the status.
   */
  public void setStatus(String  status) {
    this.status = status;
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
  SecureChannelMapping objSecureChannelMapping = (SecureChannelMapping) o;
  return   Objects.equals(this.uuid, objSecureChannelMapping.uuid)&&
  Objects.equals(this.name, objSecureChannelMapping.name)&&
  Objects.equals(this.localIp, objSecureChannelMapping.localIp)&&
  Objects.equals(this.ip, objSecureChannelMapping.ip)&&
  Objects.equals(this.status, objSecureChannelMapping.status)&&
  Objects.equals(this.markedForDelete, objSecureChannelMapping.markedForDelete)&&
  Objects.equals(this.isController, objSecureChannelMapping.isController)&&
  Objects.equals(this.pubKey, objSecureChannelMapping.pubKey)&&
  Objects.equals(this.pubKeyPem, objSecureChannelMapping.pubKeyPem);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SecureChannelMapping {\n");
      sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
        sb.append("    isController: ").append(toIndentedString(isController)).append("\n");
        sb.append("    localIp: ").append(toIndentedString(localIp)).append("\n");
        sb.append("    markedForDelete: ").append(toIndentedString(markedForDelete)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    pubKey: ").append(toIndentedString(pubKey)).append("\n");
        sb.append("    pubKeyPem: ").append(toIndentedString(pubKeyPem)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

