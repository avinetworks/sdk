package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The CloudStackSetup is a POJO class extends AviRestResource that used for creating
 * CloudStackSetup.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CloudStackSetup  {
    @JsonProperty("access_key_id")
    private String accessKeyId = null;

    @JsonProperty("api_url")
    private String apiUrl = null;

    @JsonProperty("cc_id")
    private String ccId = null;

    @JsonProperty("error_string")
    private String errorString = null;

    @JsonProperty("privilege")
    private String privilege = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property access_key_id of obj type cloudstacksetup field type str  type string.
   * @return accessKeyId
   */
  public String getAccessKeyId() {
    return accessKeyId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property access_key_id of obj type cloudstacksetup field type str  type string.
   * @param accessKeyId set the accessKeyId.
   */
  public void setAccessKeyId(String  accessKeyId) {
    this.accessKeyId = accessKeyId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property api_url of obj type cloudstacksetup field type str  type string.
   * @return apiUrl
   */
  public String getApiUrl() {
    return apiUrl;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property api_url of obj type cloudstacksetup field type str  type string.
   * @param apiUrl set the apiUrl.
   */
  public void setApiUrl(String  apiUrl) {
    this.apiUrl = apiUrl;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cc_id of obj type cloudstacksetup field type str  type string.
   * @return ccId
   */
  public String getCcId() {
    return ccId;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cc_id of obj type cloudstacksetup field type str  type string.
   * @param ccId set the ccId.
   */
  public void setCcId(String  ccId) {
    this.ccId = ccId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property error_string of obj type cloudstacksetup field type str  type string.
   * @return errorString
   */
  public String getErrorString() {
    return errorString;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property error_string of obj type cloudstacksetup field type str  type string.
   * @param errorString set the errorString.
   */
  public void setErrorString(String  errorString) {
    this.errorString = errorString;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - NO_ACCESS, READ_ACCESS, WRITE_ACCESS.
   * @return privilege
   */
  public String getPrivilege() {
    return privilege;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - NO_ACCESS, READ_ACCESS, WRITE_ACCESS.
   * @param privilege set the privilege.
   */
  public void setPrivilege(String  privilege) {
    this.privilege = privilege;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  CloudStackSetup objCloudStackSetup = (CloudStackSetup) o;
  return   Objects.equals(this.privilege, objCloudStackSetup.privilege)&&
  Objects.equals(this.ccId, objCloudStackSetup.ccId)&&
  Objects.equals(this.apiUrl, objCloudStackSetup.apiUrl)&&
  Objects.equals(this.errorString, objCloudStackSetup.errorString)&&
  Objects.equals(this.accessKeyId, objCloudStackSetup.accessKeyId);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class CloudStackSetup {\n");
      sb.append("    accessKeyId: ").append(toIndentedString(accessKeyId)).append("\n");
        sb.append("    apiUrl: ").append(toIndentedString(apiUrl)).append("\n");
        sb.append("    ccId: ").append(toIndentedString(ccId)).append("\n");
        sb.append("    errorString: ").append(toIndentedString(errorString)).append("\n");
        sb.append("    privilege: ").append(toIndentedString(privilege)).append("\n");
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

