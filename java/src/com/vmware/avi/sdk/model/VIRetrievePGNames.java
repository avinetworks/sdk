package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VIRetrievePGNames is a POJO class extends AviRestResource that used for creating
 * VIRetrievePGNames.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VIRetrievePGNames  {
    @JsonProperty("cloud_uuid")
    private String cloudUuid = null;

    @JsonProperty("datacenter")
    private String datacenter = null;

    @JsonProperty("password")
    private String password = "vmware";

    @JsonProperty("username")
    private String username = "root";

    @JsonProperty("vcenter_url")
    private String vcenterUrl = null;



  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of cloud.
   * @return cloudUuid
   */
  public String getCloudUuid() {
    return cloudUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of cloud.
   * @param cloudUuid set the cloudUuid.
   */
  public void setCloudUuid(String  cloudUuid) {
    this.cloudUuid = cloudUuid;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property datacenter of obj type viretrievepgnames field type str  type string.
   * @return datacenter
   */
  public String getDatacenter() {
    return datacenter;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property datacenter of obj type viretrievepgnames field type str  type string.
   * @param datacenter set the datacenter.
   */
  public void setDatacenter(String  datacenter) {
    this.datacenter = datacenter;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property password of obj type viretrievepgnames field type str  type string.
   * Default value when not specified in API or module is interpreted by Avi Controller as vmware.
   * @return password
   */
  public String getPassword() {
    return password;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property password of obj type viretrievepgnames field type str  type string.
   * Default value when not specified in API or module is interpreted by Avi Controller as vmware.
   * @param password set the password.
   */
  public void setPassword(String  password) {
    this.password = password;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property username of obj type viretrievepgnames field type str  type string.
   * Default value when not specified in API or module is interpreted by Avi Controller as root.
   * @return username
   */
  public String getUsername() {
    return username;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property username of obj type viretrievepgnames field type str  type string.
   * Default value when not specified in API or module is interpreted by Avi Controller as root.
   * @param username set the username.
   */
  public void setUsername(String  username) {
    this.username = username;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property vcenter_url of obj type viretrievepgnames field type str  type string.
   * @return vcenterUrl
   */
  public String getVcenterUrl() {
    return vcenterUrl;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property vcenter_url of obj type viretrievepgnames field type str  type string.
   * @param vcenterUrl set the vcenterUrl.
   */
  public void setVcenterUrl(String  vcenterUrl) {
    this.vcenterUrl = vcenterUrl;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VIRetrievePGNames objVIRetrievePGNames = (VIRetrievePGNames) o;
  return   Objects.equals(this.vcenterUrl, objVIRetrievePGNames.vcenterUrl)&&
  Objects.equals(this.username, objVIRetrievePGNames.username)&&
  Objects.equals(this.password, objVIRetrievePGNames.password)&&
  Objects.equals(this.cloudUuid, objVIRetrievePGNames.cloudUuid)&&
  Objects.equals(this.datacenter, objVIRetrievePGNames.datacenter);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VIRetrievePGNames {\n");
      sb.append("    cloudUuid: ").append(toIndentedString(cloudUuid)).append("\n");
        sb.append("    datacenter: ").append(toIndentedString(datacenter)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
        sb.append("    username: ").append(toIndentedString(username)).append("\n");
        sb.append("    vcenterUrl: ").append(toIndentedString(vcenterUrl)).append("\n");
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

