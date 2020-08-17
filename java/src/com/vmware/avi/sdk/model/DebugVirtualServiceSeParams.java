package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The DebugVirtualServiceSeParams is a POJO class extends AviRestResource that used for creating
 * DebugVirtualServiceSeParams.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DebugVirtualServiceSeParams  {
    @JsonProperty("se_refs")
    private List<String> seRefs = null;


  /**
   * This is the getter method this will return the attribute value.
   * It is a reference to an object of type serviceengine.
   * @return seRefs
   */
  public List<String> getSeRefs() {
    return seRefs;
  }

  /**
   * This is the setter method. this will set the seRefs
   * It is a reference to an object of type serviceengine.
   * @return seRefs
   */
  public void setSeRefs(List<String>  seRefs) {
    this.seRefs = seRefs;
  }

  /**
   * This is the setter method this will set the seRefs
   * It is a reference to an object of type serviceengine.
   * @return seRefs
   */
  public DebugVirtualServiceSeParams addSeRefsItem(String seRefsItem) {
    if (this.seRefs == null) {
      this.seRefs = new ArrayList<String>();
    }
    this.seRefs.add(seRefsItem);
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
  DebugVirtualServiceSeParams objDebugVirtualServiceSeParams = (DebugVirtualServiceSeParams) o;
  return   Objects.equals(this.seRefs, objDebugVirtualServiceSeParams.seRefs);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class DebugVirtualServiceSeParams {\n");
      sb.append("    seRefs: ").append(toIndentedString(seRefs)).append("\n");
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

