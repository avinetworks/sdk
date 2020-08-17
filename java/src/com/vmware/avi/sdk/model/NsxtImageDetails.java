package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The NsxtImageDetails is a POJO class extends AviRestResource that used for creating
 * NsxtImageDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NsxtImageDetails  {
    @JsonProperty("cc_id")
    private String ccId = null;

    @JsonProperty("error_string")
    private String errorString = null;

    @JsonProperty("image_version")
    private String imageVersion = null;

    @JsonProperty("vc_url")
    private String vcUrl = null;



  /**
   * This is the getter method this will return the attribute value.
   * Cloud id.
   * Field introduced in 20.1.1.
   * @return ccId
   */
  public String getCcId() {
    return ccId;
  }

  /**
   * This is the setter method to the attribute.
   * Cloud id.
   * Field introduced in 20.1.1.
   * @param ccId set the ccId.
   */
  public void setCcId(String  ccId) {
    this.ccId = ccId;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Error message.
   * Field introduced in 20.1.1.
   * @return errorString
   */
  public String getErrorString() {
    return errorString;
  }

  /**
   * This is the setter method to the attribute.
   * Error message.
   * Field introduced in 20.1.1.
   * @param errorString set the errorString.
   */
  public void setErrorString(String  errorString) {
    this.errorString = errorString;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Image version.
   * Field introduced in 20.1.1.
   * @return imageVersion
   */
  public String getImageVersion() {
    return imageVersion;
  }

  /**
   * This is the setter method to the attribute.
   * Image version.
   * Field introduced in 20.1.1.
   * @param imageVersion set the imageVersion.
   */
  public void setImageVersion(String  imageVersion) {
    this.imageVersion = imageVersion;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Vc url.
   * Field introduced in 20.1.1.
   * @return vcUrl
   */
  public String getVcUrl() {
    return vcUrl;
  }

  /**
   * This is the setter method to the attribute.
   * Vc url.
   * Field introduced in 20.1.1.
   * @param vcUrl set the vcUrl.
   */
  public void setVcUrl(String  vcUrl) {
    this.vcUrl = vcUrl;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  NsxtImageDetails objNsxtImageDetails = (NsxtImageDetails) o;
  return   Objects.equals(this.vcUrl, objNsxtImageDetails.vcUrl)&&
  Objects.equals(this.imageVersion, objNsxtImageDetails.imageVersion)&&
  Objects.equals(this.ccId, objNsxtImageDetails.ccId)&&
  Objects.equals(this.errorString, objNsxtImageDetails.errorString);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class NsxtImageDetails {\n");
      sb.append("    ccId: ").append(toIndentedString(ccId)).append("\n");
        sb.append("    errorString: ").append(toIndentedString(errorString)).append("\n");
        sb.append("    imageVersion: ").append(toIndentedString(imageVersion)).append("\n");
        sb.append("    vcUrl: ").append(toIndentedString(vcUrl)).append("\n");
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

