package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VSDataScripts is a POJO class extends AviRestResource that used for creating
 * VSDataScripts.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VSDataScripts  {
    @JsonProperty("index")
    private Integer index = null;

    @JsonProperty("vs_datascript_set_ref")
    private String vsDatascriptSetRef = null;



  /**
   * This is the getter method this will return the attribute value.
   * Index of the virtual service datascript collection.
   * @return index
   */
  public Integer getIndex() {
    return index;
  }

  /**
   * This is the setter method to the attribute.
   * Index of the virtual service datascript collection.
   * @param index set the index.
   */
  public void setIndex(Integer  index) {
    this.index = index;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Uuid of the virtual service datascript collection.
   * It is a reference to an object of type vsdatascriptset.
   * @return vsDatascriptSetRef
   */
  public String getVsDatascriptSetRef() {
    return vsDatascriptSetRef;
  }

  /**
   * This is the setter method to the attribute.
   * Uuid of the virtual service datascript collection.
   * It is a reference to an object of type vsdatascriptset.
   * @param vsDatascriptSetRef set the vsDatascriptSetRef.
   */
  public void setVsDatascriptSetRef(String  vsDatascriptSetRef) {
    this.vsDatascriptSetRef = vsDatascriptSetRef;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VSDataScripts objVSDataScripts = (VSDataScripts) o;
  return   Objects.equals(this.index, objVSDataScripts.index)&&
  Objects.equals(this.vsDatascriptSetRef, objVSDataScripts.vsDatascriptSetRef);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VSDataScripts {\n");
      sb.append("    index: ").append(toIndentedString(index)).append("\n");
        sb.append("    vsDatascriptSetRef: ").append(toIndentedString(vsDatascriptSetRef)).append("\n");
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

