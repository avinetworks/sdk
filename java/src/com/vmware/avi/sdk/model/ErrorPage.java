package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ErrorPage is a POJO class extends AviRestResource that used for creating
 * ErrorPage.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorPage  {
    @JsonProperty("enable")
    private Boolean enable = true;

    @JsonProperty("error_page_body_ref")
    private String errorPageBodyRef = null;

    @JsonProperty("error_redirect")
    private String errorRedirect = null;

    @JsonProperty("index")
    private Integer index = null;

    @JsonProperty("match")
    private HTTPStatusMatch match = null;



  /**
   * This is the getter method this will return the attribute value.
   * Enable or disable the error page.
   * Field introduced in 17.2.4.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @return enable
   */
  public Boolean getEnable() {
    return enable;
  }

  /**
   * This is the setter method to the attribute.
   * Enable or disable the error page.
   * Field introduced in 17.2.4.
   * Default value when not specified in API or module is interpreted by Avi Controller as true.
   * @param enable set the enable.
   */
  public void setEnable(Boolean  enable) {
    this.enable = enable;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Custom error page body used to sent to the client.
   * It is a reference to an object of type errorpagebody.
   * Field introduced in 17.2.4.
   * @return errorPageBodyRef
   */
  public String getErrorPageBodyRef() {
    return errorPageBodyRef;
  }

  /**
   * This is the setter method to the attribute.
   * Custom error page body used to sent to the client.
   * It is a reference to an object of type errorpagebody.
   * Field introduced in 17.2.4.
   * @param errorPageBodyRef set the errorPageBodyRef.
   */
  public void setErrorPageBodyRef(String  errorPageBodyRef) {
    this.errorPageBodyRef = errorPageBodyRef;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Redirect sent to client when match.
   * Field introduced in 17.2.4.
   * @return errorRedirect
   */
  public String getErrorRedirect() {
    return errorRedirect;
  }

  /**
   * This is the setter method to the attribute.
   * Redirect sent to client when match.
   * Field introduced in 17.2.4.
   * @param errorRedirect set the errorRedirect.
   */
  public void setErrorRedirect(String  errorRedirect) {
    this.errorRedirect = errorRedirect;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Index of the error page.
   * Field introduced in 17.2.4.
   * @return index
   */
  public Integer getIndex() {
    return index;
  }

  /**
   * This is the setter method to the attribute.
   * Index of the error page.
   * Field introduced in 17.2.4.
   * @param index set the index.
   */
  public void setIndex(Integer  index) {
    this.index = index;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Add match criteria for http status codes to the error page.
   * Field introduced in 17.2.4.
   * @return match
   */
  public HTTPStatusMatch getMatch() {
    return match;
  }

  /**
   * This is the setter method to the attribute.
   * Add match criteria for http status codes to the error page.
   * Field introduced in 17.2.4.
   * @param match set the match.
   */
  public void setMatch(HTTPStatusMatch match) {
    this.match = match;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ErrorPage objErrorPage = (ErrorPage) o;
  return   Objects.equals(this.index, objErrorPage.index)&&
  Objects.equals(this.enable, objErrorPage.enable)&&
  Objects.equals(this.errorRedirect, objErrorPage.errorRedirect)&&
  Objects.equals(this.match, objErrorPage.match)&&
  Objects.equals(this.errorPageBodyRef, objErrorPage.errorPageBodyRef);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ErrorPage {\n");
      sb.append("    enable: ").append(toIndentedString(enable)).append("\n");
        sb.append("    errorPageBodyRef: ").append(toIndentedString(errorPageBodyRef)).append("\n");
        sb.append("    errorRedirect: ").append(toIndentedString(errorRedirect)).append("\n");
        sb.append("    index: ").append(toIndentedString(index)).append("\n");
        sb.append("    match: ").append(toIndentedString(match)).append("\n");
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

