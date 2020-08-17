package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VcenterDatastore is a POJO class extends AviRestResource that used for creating
 * VcenterDatastore.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VcenterDatastore  {
    @JsonProperty("datastore_name")
    private String datastoreName = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property datastore_name of obj type vcenterdatastore field type str  type string.
   * @return datastoreName
   */
  public String getDatastoreName() {
    return datastoreName;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property datastore_name of obj type vcenterdatastore field type str  type string.
   * @param datastoreName set the datastoreName.
   */
  public void setDatastoreName(String  datastoreName) {
    this.datastoreName = datastoreName;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VcenterDatastore objVcenterDatastore = (VcenterDatastore) o;
  return   Objects.equals(this.datastoreName, objVcenterDatastore.datastoreName);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VcenterDatastore {\n");
      sb.append("    datastoreName: ").append(toIndentedString(datastoreName)).append("\n");
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

