package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The CRSDetails is a POJO class extends AviRestResource that used for creating
 * CRSDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CRSDetails  {
    @JsonProperty("name")
    private String name = null;

    @JsonProperty("release_date")
    private String releaseDate = null;

    @JsonProperty("url")
    private String url = "url";

    @JsonProperty("version")
    private String version = null;



  /**
   * This is the getter method this will return the attribute value.
   * Name of the crs release.
   * Field introduced in 18.2.6.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the crs release.
   * Field introduced in 18.2.6.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Crs release date.
   * Field introduced in 18.2.6.
   * @return releaseDate
   */
  public String getReleaseDate() {
    return releaseDate;
  }

  /**
   * This is the setter method to the attribute.
   * Crs release date.
   * Field introduced in 18.2.6.
   * @param releaseDate set the releaseDate.
   */
  public void setReleaseDate(String  releaseDate) {
    this.releaseDate = releaseDate;
  }
/**
   * This is the getter method this will return the attribute value.
   * Download link of the crs release.
   * Field introduced in 18.2.6.
   * @return url
   */
  public String getUrl() {
    return url;
  }

  /**
   * This is the setter method. this will set the url
   * Download link of the crs release.
   * Field introduced in 18.2.6.
   * @return url
   */
  public void setUrl(String  url) {
    this.url = url;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Version of the crs release.
   * Field introduced in 18.2.6.
   * @return version
   */
  public String getVersion() {
    return version;
  }

  /**
   * This is the setter method to the attribute.
   * Version of the crs release.
   * Field introduced in 18.2.6.
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
  CRSDetails objCRSDetails = (CRSDetails) o;
  return   Objects.equals(this.releaseDate, objCRSDetails.releaseDate)&&
  Objects.equals(this.version, objCRSDetails.version)&&
  Objects.equals(this.name, objCRSDetails.name);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class CRSDetails {\n");
      sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    releaseDate: ").append(toIndentedString(releaseDate)).append("\n");
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

