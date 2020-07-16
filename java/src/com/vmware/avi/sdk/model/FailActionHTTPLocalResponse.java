package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The FailActionHTTPLocalResponse is a POJO class extends AviRestResource that used for creating
 * FailActionHTTPLocalResponse.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FailActionHTTPLocalResponse  {
    @JsonProperty("file")
    private HTTPLocalFile file = null;

    @JsonProperty("status_code")
    private String statusCode = "FAIL_HTTP_STATUS_CODE_503";



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property file of obj type failactionhttplocalresponse field type str  type ref.
   * @return file
   */
  public HTTPLocalFile getFile() {
    return file;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property file of obj type failactionhttplocalresponse field type str  type ref.
   * @param file set the file.
   */
  public void setFile(HTTPLocalFile file) {
    this.file = file;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Enum options - FAIL_HTTP_STATUS_CODE_200, FAIL_HTTP_STATUS_CODE_503.
   * Default value when not specified in API or module is interpreted by Avi Controller as FAIL_HTTP_STATUS_CODE_503.
   * @return statusCode
   */
  public String getStatusCode() {
    return statusCode;
  }

  /**
   * This is the setter method to the attribute.
   * Enum options - FAIL_HTTP_STATUS_CODE_200, FAIL_HTTP_STATUS_CODE_503.
   * Default value when not specified in API or module is interpreted by Avi Controller as FAIL_HTTP_STATUS_CODE_503.
   * @param statusCode set the statusCode.
   */
  public void setStatusCode(String  statusCode) {
    this.statusCode = statusCode;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  FailActionHTTPLocalResponse objFailActionHTTPLocalResponse = (FailActionHTTPLocalResponse) o;
  return   Objects.equals(this.statusCode, objFailActionHTTPLocalResponse.statusCode)&&
  Objects.equals(this.file, objFailActionHTTPLocalResponse.file);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class FailActionHTTPLocalResponse {\n");
      sb.append("    file: ").append(toIndentedString(file)).append("\n");
        sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
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

