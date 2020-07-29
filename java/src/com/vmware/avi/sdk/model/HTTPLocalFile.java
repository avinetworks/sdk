package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The HTTPLocalFile is a POJO class extends AviRestResource that used for creating
 * HTTPLocalFile.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HTTPLocalFile  {
    @JsonProperty("content_type")
    private String contentType = null;

    @JsonProperty("file_content")
    private String fileContent = null;



  /**
   * This is the getter method this will return the attribute value.
   * Mime-type of the content in the file.
   * @return contentType
   */
  public String getContentType() {
    return contentType;
  }

  /**
   * This is the setter method to the attribute.
   * Mime-type of the content in the file.
   * @param contentType set the contentType.
   */
  public void setContentType(String  contentType) {
    this.contentType = contentType;
  }

  /**
   * This is the getter method this will return the attribute value.
   * File content to used in the local http response body.
   * @return fileContent
   */
  public String getFileContent() {
    return fileContent;
  }

  /**
   * This is the setter method to the attribute.
   * File content to used in the local http response body.
   * @param fileContent set the fileContent.
   */
  public void setFileContent(String  fileContent) {
    this.fileContent = fileContent;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  HTTPLocalFile objHTTPLocalFile = (HTTPLocalFile) o;
  return   Objects.equals(this.contentType, objHTTPLocalFile.contentType)&&
  Objects.equals(this.fileContent, objHTTPLocalFile.fileContent);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class HTTPLocalFile {\n");
      sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
        sb.append("    fileContent: ").append(toIndentedString(fileContent)).append("\n");
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

