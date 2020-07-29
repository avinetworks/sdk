package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The VsEvStatus is a POJO class extends AviRestResource that used for creating
 * VsEvStatus.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VsEvStatus  {
    @JsonProperty("notes")
    private List<String> notes = null;

    @JsonProperty("request")
    private String request = null;

    @JsonProperty("result")
    private String result = null;


  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property notes of obj type vsevstatus field type str  type array.
   * @return notes
   */
  public List<String> getNotes() {
    return notes;
  }

  /**
   * This is the setter method. this will set the notes
   * Placeholder for description of property notes of obj type vsevstatus field type str  type array.
   * @return notes
   */
  public void setNotes(List<String>  notes) {
    this.notes = notes;
  }

  /**
   * This is the setter method this will set the notes
   * Placeholder for description of property notes of obj type vsevstatus field type str  type array.
   * @return notes
   */
  public VsEvStatus addNotesItem(String notesItem) {
    if (this.notes == null) {
      this.notes = new ArrayList<String>();
    }
    this.notes.add(notesItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property request of obj type vsevstatus field type str  type string.
   * @return request
   */
  public String getRequest() {
    return request;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property request of obj type vsevstatus field type str  type string.
   * @param request set the request.
   */
  public void setRequest(String  request) {
    this.request = request;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property result of obj type vsevstatus field type str  type string.
   * @return result
   */
  public String getResult() {
    return result;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property result of obj type vsevstatus field type str  type string.
   * @param result set the result.
   */
  public void setResult(String  result) {
    this.result = result;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  VsEvStatus objVsEvStatus = (VsEvStatus) o;
  return   Objects.equals(this.request, objVsEvStatus.request)&&
  Objects.equals(this.result, objVsEvStatus.result)&&
  Objects.equals(this.notes, objVsEvStatus.notes);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class VsEvStatus {\n");
      sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
        sb.append("    request: ").append(toIndentedString(request)).append("\n");
        sb.append("    result: ").append(toIndentedString(result)).append("\n");
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

