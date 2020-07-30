package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The CompressionProfile is a POJO class extends AviRestResource that used for creating
 * CompressionProfile.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompressionProfile  {
    @JsonProperty("compressible_content_ref")
    private String compressibleContentRef = null;

    @JsonProperty("compression")
    private Boolean compression = false;

    @JsonProperty("filter")
    private List<CompressionFilter> filter = null;

    @JsonProperty("remove_accept_encoding_header")
    private Boolean removeAcceptEncodingHeader = true;

    @JsonProperty("type")
    private String type = "AUTO_COMPRESSION";



  /**
   * This is the getter method this will return the attribute value.
   * Compress only content types listed in this string group.
   * Content types not present in this list are not compressed.
   * It is a reference to an object of type stringgroup.
   * @return compressibleContentRef
   */
  public String getCompressibleContentRef() {
    return compressibleContentRef;
  }

  /**
   * This is the setter method to the attribute.
   * Compress only content types listed in this string group.
   * Content types not present in this list are not compressed.
   * It is a reference to an object of type stringgroup.
   * @param compressibleContentRef set the compressibleContentRef.
   */
  public void setCompressibleContentRef(String  compressibleContentRef) {
    this.compressibleContentRef = compressibleContentRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Compress http response content if it wasn't already compressed.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return compression
   */
  public Boolean getCompression() {
    return compression;
  }

  /**
   * This is the setter method to the attribute.
   * Compress http response content if it wasn't already compressed.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param compression set the compression.
   */
  public void setCompression(Boolean  compression) {
    this.compression = compression;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Custom filters used when auto compression is not selected.
   * @return filter
   */
  public List<CompressionFilter> getFilter() {
    return filter;
  }

  /**
   * This is the setter method. this will set the filter
   * Custom filters used when auto compression is not selected.
   * @return filter
   */
  public void setFilter(List<CompressionFilter>  filter) {
    this.filter = filter;
  }

  /**
   * This is the setter method this will set the filter
   * Custom filters used when auto compression is not selected.
   * @return filter
   */
  public CompressionProfile addFilterItem(CompressionFilter filterItem) {
    if (this.filter == null) {
      this.filter = new ArrayList<CompressionFilter>();
    }
    this.filter.add(filterItem);
    return this;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Offload compression from the servers to avi.
   * Saves compute cycles on the servers.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return removeAcceptEncodingHeader
   */
  public Boolean getRemoveAcceptEncodingHeader() {
    return removeAcceptEncodingHeader;
  }

  /**
   * This is the setter method to the attribute.
   * Offload compression from the servers to avi.
   * Saves compute cycles on the servers.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param removeAcceptEncodingHeader set the removeAcceptEncodingHeader.
   */
  public void setRemoveAcceptEncodingHeader(Boolean  removeAcceptEncodingHeader) {
    this.removeAcceptEncodingHeader = removeAcceptEncodingHeader;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Compress content automatically or add custom filters to define compressible content and compression levels.
   * Enum options - AUTO_COMPRESSION, CUSTOM_COMPRESSION.
   * Default value when not specified in API or module is interpreted by Avi Controller as AUTO_COMPRESSION.
   * @return type
   */
  public String getType() {
    return type;
  }

  /**
   * This is the setter method to the attribute.
   * Compress content automatically or add custom filters to define compressible content and compression levels.
   * Enum options - AUTO_COMPRESSION, CUSTOM_COMPRESSION.
   * Default value when not specified in API or module is interpreted by Avi Controller as AUTO_COMPRESSION.
   * @param type set the type.
   */
  public void setType(String  type) {
    this.type = type;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  CompressionProfile objCompressionProfile = (CompressionProfile) o;
  return   Objects.equals(this.compression, objCompressionProfile.compression)&&
  Objects.equals(this.removeAcceptEncodingHeader, objCompressionProfile.removeAcceptEncodingHeader)&&
  Objects.equals(this.compressibleContentRef, objCompressionProfile.compressibleContentRef)&&
  Objects.equals(this.type, objCompressionProfile.type)&&
  Objects.equals(this.filter, objCompressionProfile.filter);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class CompressionProfile {\n");
      sb.append("    compressibleContentRef: ").append(toIndentedString(compressibleContentRef)).append("\n");
        sb.append("    compression: ").append(toIndentedString(compression)).append("\n");
        sb.append("    filter: ").append(toIndentedString(filter)).append("\n");
        sb.append("    removeAcceptEncodingHeader: ").append(toIndentedString(removeAcceptEncodingHeader)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

