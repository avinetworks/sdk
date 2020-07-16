package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Cif is a POJO class extends AviRestResource that used for creating
 * Cif.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cif  {
    @JsonProperty("adapter")
    private String adapter = null;

    @JsonProperty("cif")
    private String cif = null;

    @JsonProperty("mac_address")
    private String macAddress = null;

    @JsonProperty("resources")
    private List<String> resources = null;

    @JsonProperty("se_uuid")
    private String seUuid = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property adapter of obj type cif field type str  type string.
   * @return adapter
   */
  public String getAdapter() {
    return adapter;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property adapter of obj type cif field type str  type string.
   * @param adapter set the adapter.
   */
  public void setAdapter(String  adapter) {
    this.adapter = adapter;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property cif of obj type cif field type str  type string.
   * @return cif
   */
  public String getCif() {
    return cif;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property cif of obj type cif field type str  type string.
   * @param cif set the cif.
   */
  public void setCif(String  cif) {
    this.cif = cif;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property mac_address of obj type cif field type str  type string.
   * @return macAddress
   */
  public String getMacAddress() {
    return macAddress;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property mac_address of obj type cif field type str  type string.
   * @param macAddress set the macAddress.
   */
  public void setMacAddress(String  macAddress) {
    this.macAddress = macAddress;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property resources of obj type cif field type str  type array.
   * @return resources
   */
  public List<String> getResources() {
    return resources;
  }

  /**
   * This is the setter method. this will set the resources
   * Placeholder for description of property resources of obj type cif field type str  type array.
   * @return resources
   */
  public void setResources(List<String>  resources) {
    this.resources = resources;
  }

  /**
   * This is the setter method this will set the resources
   * Placeholder for description of property resources of obj type cif field type str  type array.
   * @return resources
   */
  public Cif addResourcesItem(String resourcesItem) {
    if (this.resources == null) {
      this.resources = new ArrayList<String>();
    }
    this.resources.add(resourcesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Unique object identifier of se.
   * @return seUuid
   */
  public String getSeUuid() {
    return seUuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of se.
   * @param seUuid set the seUuid.
   */
  public void setSeUuid(String  seUuid) {
    this.seUuid = seUuid;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  Cif objCif = (Cif) o;
  return   Objects.equals(this.adapter, objCif.adapter)&&
  Objects.equals(this.macAddress, objCif.macAddress)&&
  Objects.equals(this.cif, objCif.cif)&&
  Objects.equals(this.resources, objCif.resources)&&
  Objects.equals(this.seUuid, objCif.seUuid);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class Cif {\n");
      sb.append("    adapter: ").append(toIndentedString(adapter)).append("\n");
        sb.append("    cif: ").append(toIndentedString(cif)).append("\n");
        sb.append("    macAddress: ").append(toIndentedString(macAddress)).append("\n");
        sb.append("    resources: ").append(toIndentedString(resources)).append("\n");
        sb.append("    seUuid: ").append(toIndentedString(seUuid)).append("\n");
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

