package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DockerRegistry is a POJO class extends AviRestResource that used for creating
 * DockerRegistry.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DockerRegistry  {
    @JsonProperty("oshift_registry")
    private OshiftDockerRegistryMetaData oshiftRegistry = null;

    @JsonProperty("password")
    private String password = null;

    @JsonProperty("private")
    private Boolean privates = false;

    @JsonProperty("registry")
    private String registry = "avinetworks/se";

    @JsonProperty("se_repository_push")
    private Boolean seRepositoryPush = null;

    @JsonProperty("username")
    private String username = null;



  /**
   * This is the getter method this will return the attribute value.
   * Openshift integrated registry config.
   * @return oshiftRegistry
   */
  public OshiftDockerRegistryMetaData getOshiftRegistry() {
    return oshiftRegistry;
  }

  /**
   * This is the setter method to the attribute.
   * Openshift integrated registry config.
   * @param oshiftRegistry set the oshiftRegistry.
   */
  public void setOshiftRegistry(OshiftDockerRegistryMetaData oshiftRegistry) {
    this.oshiftRegistry = oshiftRegistry;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Password for docker registry.
   * Authorized 'regular user' password if registry is openshift integrated registry.
   * @return password
   */
  public String getPassword() {
    return password;
  }

  /**
   * This is the setter method to the attribute.
   * Password for docker registry.
   * Authorized 'regular user' password if registry is openshift integrated registry.
   * @param password set the password.
   */
  public void setPassword(String  password) {
    this.password = password;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Set if docker registry is private.
   * Avi controller will not attempt to push se image to the registry, unless se_repository_push is set.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return privates
   */
  public Boolean getPrivate() {
    return privates;
  }

  /**
   * This is the setter method to the attribute.
   * Set if docker registry is private.
   * Avi controller will not attempt to push se image to the registry, unless se_repository_push is set.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param privates set the privates.
   */
  public void setPrivate(Boolean  privates) {
    this.privates = privates;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Avi serviceengine repository name.
   * For private registry, it's registry port/repository, for public registry, it's registry/repository, for openshift registry, it's registry
   * port/namespace/repo.
   * Default value when not specified in API or module is interpreted by Avi Controller as avinetworks/se.
   * @return registry
   */
  public String getRegistry() {
    return registry;
  }

  /**
   * This is the setter method to the attribute.
   * Avi serviceengine repository name.
   * For private registry, it's registry port/repository, for public registry, it's registry/repository, for openshift registry, it's registry
   * port/namespace/repo.
   * Default value when not specified in API or module is interpreted by Avi Controller as avinetworks/se.
   * @param registry set the registry.
   */
  public void setRegistry(String  registry) {
    this.registry = registry;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Avi controller will push serviceengine image to docker repository.
   * Field deprecated in 18.2.6.
   * @return seRepositoryPush
   */
  public Boolean getSeRepositoryPush() {
    return seRepositoryPush;
  }

  /**
   * This is the setter method to the attribute.
   * Avi controller will push serviceengine image to docker repository.
   * Field deprecated in 18.2.6.
   * @param seRepositoryPush set the seRepositoryPush.
   */
  public void setSeRepositoryPush(Boolean  seRepositoryPush) {
    this.seRepositoryPush = seRepositoryPush;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Username for docker registry.
   * Authorized 'regular user' if registry is openshift integrated registry.
   * @return username
   */
  public String getUsername() {
    return username;
  }

  /**
   * This is the setter method to the attribute.
   * Username for docker registry.
   * Authorized 'regular user' if registry is openshift integrated registry.
   * @param username set the username.
   */
  public void setUsername(String  username) {
    this.username = username;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  DockerRegistry objDockerRegistry = (DockerRegistry) o;
  return   Objects.equals(this.username, objDockerRegistry.username)&&
  Objects.equals(this.oshiftRegistry, objDockerRegistry.oshiftRegistry)&&
  Objects.equals(this.privates, objDockerRegistry.privates)&&
  Objects.equals(this.registry, objDockerRegistry.registry)&&
  Objects.equals(this.password, objDockerRegistry.password)&&
  Objects.equals(this.seRepositoryPush, objDockerRegistry.seRepositoryPush);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DockerRegistry {\n");
      sb.append("    oshiftRegistry: ").append(toIndentedString(oshiftRegistry)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
        sb.append("    privates: ").append(toIndentedString(privates)).append("\n");
        sb.append("    registry: ").append(toIndentedString(registry)).append("\n");
        sb.append("    seRepositoryPush: ").append(toIndentedString(seRepositoryPush)).append("\n");
        sb.append("    username: ").append(toIndentedString(username)).append("\n");
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

