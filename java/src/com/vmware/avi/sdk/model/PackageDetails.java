package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The PackageDetails is a POJO class extends AviRestResource that used for creating
 * PackageDetails.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PackageDetails  {
    @JsonProperty("build")
    private BuildInfo build = null;

    @JsonProperty("hash")
    private String hash = null;

    @JsonProperty("patch")
    private PatchInfo patch = null;

    @JsonProperty("path")
    private String path = null;



  /**
   * This is the getter method this will return the attribute value.
   * This contains build related information.
   * Field introduced in 18.2.6.
   * @return build
   */
  public BuildInfo getBuild() {
    return build;
  }

  /**
   * This is the setter method to the attribute.
   * This contains build related information.
   * Field introduced in 18.2.6.
   * @param build set the build.
   */
  public void setBuild(BuildInfo build) {
    this.build = build;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Md5 checksum over the entire package.
   * Field introduced in 18.2.6.
   * @return hash
   */
  public String getHash() {
    return hash;
  }

  /**
   * This is the setter method to the attribute.
   * Md5 checksum over the entire package.
   * Field introduced in 18.2.6.
   * @param hash set the hash.
   */
  public void setHash(String  hash) {
    this.hash = hash;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Patch related necessary information.
   * Field introduced in 18.2.6.
   * @return patch
   */
  public PatchInfo getPatch() {
    return patch;
  }

  /**
   * This is the setter method to the attribute.
   * Patch related necessary information.
   * Field introduced in 18.2.6.
   * @param patch set the patch.
   */
  public void setPatch(PatchInfo patch) {
    this.patch = patch;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Path of the package in the repository.
   * Field introduced in 18.2.6.
   * @return path
   */
  public String getPath() {
    return path;
  }

  /**
   * This is the setter method to the attribute.
   * Path of the package in the repository.
   * Field introduced in 18.2.6.
   * @param path set the path.
   */
  public void setPath(String  path) {
    this.path = path;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  PackageDetails objPackageDetails = (PackageDetails) o;
  return   Objects.equals(this.path, objPackageDetails.path)&&
  Objects.equals(this.hash, objPackageDetails.hash)&&
  Objects.equals(this.build, objPackageDetails.build)&&
  Objects.equals(this.patch, objPackageDetails.patch);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class PackageDetails {\n");
      sb.append("    build: ").append(toIndentedString(build)).append("\n");
        sb.append("    hash: ").append(toIndentedString(hash)).append("\n");
        sb.append("    patch: ").append(toIndentedString(patch)).append("\n");
        sb.append("    path: ").append(toIndentedString(path)).append("\n");
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

