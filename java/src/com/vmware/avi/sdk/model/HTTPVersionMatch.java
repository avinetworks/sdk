package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The HTTPVersionMatch is a POJO class extends AviRestResource that used for creating
 * HTTPVersionMatch.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HTTPVersionMatch  {
    @JsonProperty("match_criteria")
    private String matchCriteria = null;

    @JsonProperty("versions")
    private List<String> versions = null;



  /**
   * This is the getter method this will return the attribute value.
   * Criterion to use for http version matching the version used in the http request.
   * Enum options - IS_IN, IS_NOT_IN.
   * @return matchCriteria
   */
  public String getMatchCriteria() {
    return matchCriteria;
  }

  /**
   * This is the setter method to the attribute.
   * Criterion to use for http version matching the version used in the http request.
   * Enum options - IS_IN, IS_NOT_IN.
   * @param matchCriteria set the matchCriteria.
   */
  public void setMatchCriteria(String  matchCriteria) {
    this.matchCriteria = matchCriteria;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Http protocol version.
   * Enum options - ZERO_NINE, ONE_ZERO, ONE_ONE, TWO_ZERO.
   * @return versions
   */
  public List<String> getVersions() {
    return versions;
  }

  /**
   * This is the setter method. this will set the versions
   * Http protocol version.
   * Enum options - ZERO_NINE, ONE_ZERO, ONE_ONE, TWO_ZERO.
   * @return versions
   */
  public void setVersions(List<String>  versions) {
    this.versions = versions;
  }

  /**
   * This is the setter method this will set the versions
   * Http protocol version.
   * Enum options - ZERO_NINE, ONE_ZERO, ONE_ONE, TWO_ZERO.
   * @return versions
   */
  public HTTPVersionMatch addVersionsItem(String versionsItem) {
    if (this.versions == null) {
      this.versions = new ArrayList<String>();
    }
    this.versions.add(versionsItem);
    return this;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  HTTPVersionMatch objHTTPVersionMatch = (HTTPVersionMatch) o;
  return   Objects.equals(this.versions, objHTTPVersionMatch.versions)&&
  Objects.equals(this.matchCriteria, objHTTPVersionMatch.matchCriteria);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class HTTPVersionMatch {\n");
      sb.append("    matchCriteria: ").append(toIndentedString(matchCriteria)).append("\n");
        sb.append("    versions: ").append(toIndentedString(versions)).append("\n");
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

