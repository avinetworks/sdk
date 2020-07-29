package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The SecureChannelAvailableLocalIPs is a POJO class extends AviRestResource that used for creating
 * SecureChannelAvailableLocalIPs.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SecureChannelAvailableLocalIPs extends AviRestResource  {
    @JsonProperty("end")
    private Integer end = null;

    @JsonProperty("free_controller_ips")
    private List<String> freeControllerIps = null;

    @JsonProperty("free_ips")
    private List<String> freeIps = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("start")
    private Integer start = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("uuid")
    private String uuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property end of obj type securechannelavailablelocalips field type str  type integer.
   * @return end
   */
  public Integer getEnd() {
    return end;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property end of obj type securechannelavailablelocalips field type str  type integer.
   * @param end set the end.
   */
  public void setEnd(Integer  end) {
    this.end = end;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property free_controller_ips of obj type securechannelavailablelocalips field type str  type array.
   * @return freeControllerIps
   */
  public List<String> getFreeControllerIps() {
    return freeControllerIps;
  }

  /**
   * This is the setter method. this will set the freeControllerIps
   * Placeholder for description of property free_controller_ips of obj type securechannelavailablelocalips field type str  type array.
   * @return freeControllerIps
   */
  public void setFreeControllerIps(List<String>  freeControllerIps) {
    this.freeControllerIps = freeControllerIps;
  }

  /**
   * This is the setter method this will set the freeControllerIps
   * Placeholder for description of property free_controller_ips of obj type securechannelavailablelocalips field type str  type array.
   * @return freeControllerIps
   */
  public SecureChannelAvailableLocalIPs addFreeControllerIpsItem(String freeControllerIpsItem) {
    if (this.freeControllerIps == null) {
      this.freeControllerIps = new ArrayList<String>();
    }
    this.freeControllerIps.add(freeControllerIpsItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property free_ips of obj type securechannelavailablelocalips field type str  type array.
   * @return freeIps
   */
  public List<String> getFreeIps() {
    return freeIps;
  }

  /**
   * This is the setter method. this will set the freeIps
   * Placeholder for description of property free_ips of obj type securechannelavailablelocalips field type str  type array.
   * @return freeIps
   */
  public void setFreeIps(List<String>  freeIps) {
    this.freeIps = freeIps;
  }

  /**
   * This is the setter method this will set the freeIps
   * Placeholder for description of property free_ips of obj type securechannelavailablelocalips field type str  type array.
   * @return freeIps
   */
  public SecureChannelAvailableLocalIPs addFreeIpsItem(String freeIpsItem) {
    if (this.freeIps == null) {
      this.freeIps = new ArrayList<String>();
    }
    this.freeIps.add(freeIpsItem);
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
   * Placeholder for description of property start of obj type securechannelavailablelocalips field type str  type integer.
   * @return start
   */
  public Integer getStart() {
    return start;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property start of obj type securechannelavailablelocalips field type str  type integer.
   * @param start set the start.
   */
  public void setStart(Integer  start) {
    this.start = start;
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
  SecureChannelAvailableLocalIPs objSecureChannelAvailableLocalIPs = (SecureChannelAvailableLocalIPs) o;
  return   Objects.equals(this.uuid, objSecureChannelAvailableLocalIPs.uuid)&&
  Objects.equals(this.name, objSecureChannelAvailableLocalIPs.name)&&
  Objects.equals(this.freeIps, objSecureChannelAvailableLocalIPs.freeIps)&&
  Objects.equals(this.start, objSecureChannelAvailableLocalIPs.start)&&
  Objects.equals(this.end, objSecureChannelAvailableLocalIPs.end)&&
  Objects.equals(this.freeControllerIps, objSecureChannelAvailableLocalIPs.freeControllerIps);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class SecureChannelAvailableLocalIPs {\n");
      sb.append("    end: ").append(toIndentedString(end)).append("\n");
        sb.append("    freeControllerIps: ").append(toIndentedString(freeControllerIps)).append("\n");
        sb.append("    freeIps: ").append(toIndentedString(freeIps)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    start: ").append(toIndentedString(start)).append("\n");
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

