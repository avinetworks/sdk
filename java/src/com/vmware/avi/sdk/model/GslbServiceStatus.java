package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The GslbServiceStatus is a POJO class extends AviRestResource that used for creating
 * GslbServiceStatus.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GslbServiceStatus extends AviRestResource  {
    @JsonProperty("details")
    private List<String> details = null;

    @JsonProperty("gs_runtime")
    private GslbServiceRuntime gsRuntime = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("uuid")
    private String uuid = null;


  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property details of obj type gslbservicestatus field type str  type array.
   * @return details
   */
  public List<String> getDetails() {
    return details;
  }

  /**
   * This is the setter method. this will set the details
   * Placeholder for description of property details of obj type gslbservicestatus field type str  type array.
   * @return details
   */
  public void setDetails(List<String>  details) {
    this.details = details;
  }

  /**
   * This is the setter method this will set the details
   * Placeholder for description of property details of obj type gslbservicestatus field type str  type array.
   * @return details
   */
  public GslbServiceStatus addDetailsItem(String detailsItem) {
    if (this.details == null) {
      this.details = new ArrayList<String>();
    }
    this.details.add(detailsItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property gs_runtime of obj type gslbservicestatus field type str  type ref.
   * @return gsRuntime
   */
  public GslbServiceRuntime getGsRuntime() {
    return gsRuntime;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property gs_runtime of obj type gslbservicestatus field type str  type ref.
   * @param gsRuntime set the gsRuntime.
   */
  public void setGsRuntime(GslbServiceRuntime gsRuntime) {
    this.gsRuntime = gsRuntime;
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
   * Unique object identifier of the object.
   * @return uuid
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * This is the setter method to the attribute.
   * Unique object identifier of the object.
   * @param uuid set the uuid.
   */
  public void setUuid(String  uuid) {
    this.uuid = uuid;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  GslbServiceStatus objGslbServiceStatus = (GslbServiceStatus) o;
  return   Objects.equals(this.details, objGslbServiceStatus.details)&&
  Objects.equals(this.gsRuntime, objGslbServiceStatus.gsRuntime)&&
  Objects.equals(this.uuid, objGslbServiceStatus.uuid)&&
  Objects.equals(this.name, objGslbServiceStatus.name);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class GslbServiceStatus {\n");
      sb.append("    details: ").append(toIndentedString(details)).append("\n");
        sb.append("    gsRuntime: ").append(toIndentedString(gsRuntime)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
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

