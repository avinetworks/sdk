package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The MarathonSeDeployment is a POJO class extends AviRestResource that used for creating
 * MarathonSeDeployment.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MarathonSeDeployment  {
    @JsonProperty("docker_image")
    private String dockerImage = "fedora";

    @JsonProperty("host_os")
    private String hostOs = "COREOS";

    @JsonProperty("resource_roles")
    private List<String> resourceRoles = null;

    @JsonProperty("uris")
    private List<String> uris = null;



  /**
   * This is the getter method this will return the attribute value.
   * Docker image to be used for avi se installation e.g.
   * Fedora, ubuntu.
   * Default value when not specified in API or module is interpreted by Avi Controller as fedora.
   * @return dockerImage
   */
  public String getDockerImage() {
    return dockerImage;
  }

  /**
   * This is the setter method to the attribute.
   * Docker image to be used for avi se installation e.g.
   * Fedora, ubuntu.
   * Default value when not specified in API or module is interpreted by Avi Controller as fedora.
   * @param dockerImage set the dockerImage.
   */
  public void setDockerImage(String  dockerImage) {
    this.dockerImage = dockerImage;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Host os distribution e.g.
   * Coreos, ubuntu, redhat.
   * Default value when not specified in API or module is interpreted by Avi Controller as COREOS.
   * @return hostOs
   */
  public String getHostOs() {
    return hostOs;
  }

  /**
   * This is the setter method to the attribute.
   * Host os distribution e.g.
   * Coreos, ubuntu, redhat.
   * Default value when not specified in API or module is interpreted by Avi Controller as COREOS.
   * @param hostOs set the hostOs.
   */
  public void setHostOs(String  hostOs) {
    this.hostOs = hostOs;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Accepted resource roles for ses.
   * @return resourceRoles
   */
  public List<String> getResourceRoles() {
    return resourceRoles;
  }

  /**
   * This is the setter method. this will set the resourceRoles
   * Accepted resource roles for ses.
   * @return resourceRoles
   */
  public void setResourceRoles(List<String>  resourceRoles) {
    this.resourceRoles = resourceRoles;
  }

  /**
   * This is the setter method this will set the resourceRoles
   * Accepted resource roles for ses.
   * @return resourceRoles
   */
  public MarathonSeDeployment addResourceRolesItem(String resourceRolesItem) {
    if (this.resourceRoles == null) {
      this.resourceRoles = new ArrayList<String>();
    }
    this.resourceRoles.add(resourceRolesItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Uris to be resolved for starting the application.
   * @return uris
   */
  public List<String> getUris() {
    return uris;
  }

  /**
   * This is the setter method. this will set the uris
   * Uris to be resolved for starting the application.
   * @return uris
   */
  public void setUris(List<String>  uris) {
    this.uris = uris;
  }

  /**
   * This is the setter method this will set the uris
   * Uris to be resolved for starting the application.
   * @return uris
   */
  public MarathonSeDeployment addUrisItem(String urisItem) {
    if (this.uris == null) {
      this.uris = new ArrayList<String>();
    }
    this.uris.add(urisItem);
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
  MarathonSeDeployment objMarathonSeDeployment = (MarathonSeDeployment) o;
  return   Objects.equals(this.hostOs, objMarathonSeDeployment.hostOs)&&
  Objects.equals(this.dockerImage, objMarathonSeDeployment.dockerImage)&&
  Objects.equals(this.uris, objMarathonSeDeployment.uris)&&
  Objects.equals(this.resourceRoles, objMarathonSeDeployment.resourceRoles);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class MarathonSeDeployment {\n");
      sb.append("    dockerImage: ").append(toIndentedString(dockerImage)).append("\n");
        sb.append("    hostOs: ").append(toIndentedString(hostOs)).append("\n");
        sb.append("    resourceRoles: ").append(toIndentedString(resourceRoles)).append("\n");
        sb.append("    uris: ").append(toIndentedString(uris)).append("\n");
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

