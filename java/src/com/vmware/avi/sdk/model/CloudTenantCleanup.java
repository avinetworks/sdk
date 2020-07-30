package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The CloudTenantCleanup is a POJO class extends AviRestResource that used for creating
 * CloudTenantCleanup.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CloudTenantCleanup  {
    @JsonProperty("id")
    private String id = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("num_ports")
    private Integer numPorts = null;

    @JsonProperty("num_se")
    private Integer numSe = null;

    @JsonProperty("num_secgrp")
    private Integer numSecgrp = null;

    @JsonProperty("num_svrgrp")
    private Integer numSvrgrp = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property id of obj type cloudtenantcleanup field type str  type string.
   * @return id
   */
  public String getId() {
    return id;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property id of obj type cloudtenantcleanup field type str  type string.
   * @param id set the id.
   */
  public void setId(String  id) {
    this.id = id;
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
   * Placeholder for description of property num_ports of obj type cloudtenantcleanup field type str  type integer.
   * @return numPorts
   */
  public Integer getNumPorts() {
    return numPorts;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property num_ports of obj type cloudtenantcleanup field type str  type integer.
   * @param numPorts set the numPorts.
   */
  public void setNumPorts(Integer  numPorts) {
    this.numPorts = numPorts;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property num_se of obj type cloudtenantcleanup field type str  type integer.
   * @return numSe
   */
  public Integer getNumSe() {
    return numSe;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property num_se of obj type cloudtenantcleanup field type str  type integer.
   * @param numSe set the numSe.
   */
  public void setNumSe(Integer  numSe) {
    this.numSe = numSe;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property num_secgrp of obj type cloudtenantcleanup field type str  type integer.
   * @return numSecgrp
   */
  public Integer getNumSecgrp() {
    return numSecgrp;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property num_secgrp of obj type cloudtenantcleanup field type str  type integer.
   * @param numSecgrp set the numSecgrp.
   */
  public void setNumSecgrp(Integer  numSecgrp) {
    this.numSecgrp = numSecgrp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property num_svrgrp of obj type cloudtenantcleanup field type str  type integer.
   * @return numSvrgrp
   */
  public Integer getNumSvrgrp() {
    return numSvrgrp;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property num_svrgrp of obj type cloudtenantcleanup field type str  type integer.
   * @param numSvrgrp set the numSvrgrp.
   */
  public void setNumSvrgrp(Integer  numSvrgrp) {
    this.numSvrgrp = numSvrgrp;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  CloudTenantCleanup objCloudTenantCleanup = (CloudTenantCleanup) o;
  return   Objects.equals(this.id, objCloudTenantCleanup.id)&&
  Objects.equals(this.name, objCloudTenantCleanup.name)&&
  Objects.equals(this.numSe, objCloudTenantCleanup.numSe)&&
  Objects.equals(this.numSvrgrp, objCloudTenantCleanup.numSvrgrp)&&
  Objects.equals(this.numSecgrp, objCloudTenantCleanup.numSecgrp)&&
  Objects.equals(this.numPorts, objCloudTenantCleanup.numPorts);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class CloudTenantCleanup {\n");
      sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    numPorts: ").append(toIndentedString(numPorts)).append("\n");
        sb.append("    numSe: ").append(toIndentedString(numSe)).append("\n");
        sb.append("    numSecgrp: ").append(toIndentedString(numSecgrp)).append("\n");
        sb.append("    numSvrgrp: ").append(toIndentedString(numSvrgrp)).append("\n");
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

