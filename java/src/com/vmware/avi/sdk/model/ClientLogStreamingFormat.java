package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ClientLogStreamingFormat is a POJO class extends AviRestResource that used for creating
 * ClientLogStreamingFormat.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientLogStreamingFormat  {
    @JsonProperty("format")
    private String format = null;

    @JsonProperty("included_fields")
    private List<String> includedFields = null;



  /**
   * This is the getter method this will return the attribute value.
   * Format for the streamed logs.
   * Enum options - LOG_STREAMING_FORMAT_JSON_FULL, LOG_STREAMING_FORMAT_JSON_SELECTED.
   * Field introduced in 18.2.5.
   * @return format
   */
  public String getFormat() {
    return format;
  }

  /**
   * This is the setter method to the attribute.
   * Format for the streamed logs.
   * Enum options - LOG_STREAMING_FORMAT_JSON_FULL, LOG_STREAMING_FORMAT_JSON_SELECTED.
   * Field introduced in 18.2.5.
   * @param format set the format.
   */
  public void setFormat(String  format) {
    this.format = format;
  }
  /**
   * This is the getter method this will return the attribute value.
   * List of log fields to be streamed, when selective fields (log_streaming_format_json_selected) option is chosen.
   * Only top-level fields in application or connection logs are supported.
   * Field introduced in 18.2.5.
   * @return includedFields
   */
  public List<String> getIncludedFields() {
    return includedFields;
  }

  /**
   * This is the setter method. this will set the includedFields
   * List of log fields to be streamed, when selective fields (log_streaming_format_json_selected) option is chosen.
   * Only top-level fields in application or connection logs are supported.
   * Field introduced in 18.2.5.
   * @return includedFields
   */
  public void setIncludedFields(List<String>  includedFields) {
    this.includedFields = includedFields;
  }

  /**
   * This is the setter method this will set the includedFields
   * List of log fields to be streamed, when selective fields (log_streaming_format_json_selected) option is chosen.
   * Only top-level fields in application or connection logs are supported.
   * Field introduced in 18.2.5.
   * @return includedFields
   */
  public ClientLogStreamingFormat addIncludedFieldsItem(String includedFieldsItem) {
    if (this.includedFields == null) {
      this.includedFields = new ArrayList<String>();
    }
    this.includedFields.add(includedFieldsItem);
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
  ClientLogStreamingFormat objClientLogStreamingFormat = (ClientLogStreamingFormat) o;
  return   Objects.equals(this.includedFields, objClientLogStreamingFormat.includedFields)&&
  Objects.equals(this.format, objClientLogStreamingFormat.format);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ClientLogStreamingFormat {\n");
      sb.append("    format: ").append(toIndentedString(format)).append("\n");
        sb.append("    includedFields: ").append(toIndentedString(includedFields)).append("\n");
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

