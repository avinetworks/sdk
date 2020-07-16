package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The WafExcludeListEntry is a POJO class extends AviRestResource that used for creating
 * WafExcludeListEntry.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WafExcludeListEntry  {
    @JsonProperty("client_subnet")
    private IpAddrPrefix clientSubnet = null;

    @JsonProperty("description")
    private String description = null;

    @JsonProperty("match_element")
    private String matchElement = null;

    @JsonProperty("match_element_criteria")
    private WafExclusionType matchElementCriteria = null;

    @JsonProperty("uri_match_criteria")
    private WafExclusionType uriMatchCriteria = null;

    @JsonProperty("uri_path")
    private String uriPath = null;



  /**
   * This is the getter method this will return the attribute value.
   * Client ip subnet to exclude for waf rules.
   * Field introduced in 17.2.1.
   * @return clientSubnet
   */
  public IpAddrPrefix getClientSubnet() {
    return clientSubnet;
  }

  /**
   * This is the setter method to the attribute.
   * Client ip subnet to exclude for waf rules.
   * Field introduced in 17.2.1.
   * @param clientSubnet set the clientSubnet.
   */
  public void setClientSubnet(IpAddrPrefix clientSubnet) {
    this.clientSubnet = clientSubnet;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Free-text comment about this exclusion.
   * Field introduced in 18.2.6.
   * @return description
   */
  public String getDescription() {
    return description;
  }

  /**
   * This is the setter method to the attribute.
   * Free-text comment about this exclusion.
   * Field introduced in 18.2.6.
   * @param description set the description.
   */
  public void setDescription(String  description) {
    this.description = description;
  }

  /**
   * This is the getter method this will return the attribute value.
   * The match_element can be 'args xxx', 'args_get xxx', 'args_post xxx', 'args_names xxx', 'files xxx', 'query_string', 'request_basename',
   * 'request_body', 'request_uri', 'request_uri_raw', 'request_cookies xxx', 'request_headers xxx' or 'response_headers xxx'.
   * These match_elements in the http transaction (if present) will be excluded when executing waf rules.
   * Field introduced in 17.2.1.
   * @return matchElement
   */
  public String getMatchElement() {
    return matchElement;
  }

  /**
   * This is the setter method to the attribute.
   * The match_element can be 'args xxx', 'args_get xxx', 'args_post xxx', 'args_names xxx', 'files xxx', 'query_string', 'request_basename',
   * 'request_body', 'request_uri', 'request_uri_raw', 'request_cookies xxx', 'request_headers xxx' or 'response_headers xxx'.
   * These match_elements in the http transaction (if present) will be excluded when executing waf rules.
   * Field introduced in 17.2.1.
   * @param matchElement set the matchElement.
   */
  public void setMatchElement(String  matchElement) {
    this.matchElement = matchElement;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Criteria for match_element matching.
   * Field introduced in 18.2.2.
   * @return matchElementCriteria
   */
  public WafExclusionType getMatchElementCriteria() {
    return matchElementCriteria;
  }

  /**
   * This is the setter method to the attribute.
   * Criteria for match_element matching.
   * Field introduced in 18.2.2.
   * @param matchElementCriteria set the matchElementCriteria.
   */
  public void setMatchElementCriteria(WafExclusionType matchElementCriteria) {
    this.matchElementCriteria = matchElementCriteria;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Criteria for uri matching.
   * Field introduced in 17.2.8.
   * @return uriMatchCriteria
   */
  public WafExclusionType getUriMatchCriteria() {
    return uriMatchCriteria;
  }

  /**
   * This is the setter method to the attribute.
   * Criteria for uri matching.
   * Field introduced in 17.2.8.
   * @param uriMatchCriteria set the uriMatchCriteria.
   */
  public void setUriMatchCriteria(WafExclusionType uriMatchCriteria) {
    this.uriMatchCriteria = uriMatchCriteria;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Uri path to exclude for waf rules.
   * Field introduced in 17.2.1.
   * @return uriPath
   */
  public String getUriPath() {
    return uriPath;
  }

  /**
   * This is the setter method to the attribute.
   * Uri path to exclude for waf rules.
   * Field introduced in 17.2.1.
   * @param uriPath set the uriPath.
   */
  public void setUriPath(String  uriPath) {
    this.uriPath = uriPath;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  WafExcludeListEntry objWafExcludeListEntry = (WafExcludeListEntry) o;
  return   Objects.equals(this.description, objWafExcludeListEntry.description)&&
  Objects.equals(this.matchElementCriteria, objWafExcludeListEntry.matchElementCriteria)&&
  Objects.equals(this.clientSubnet, objWafExcludeListEntry.clientSubnet)&&
  Objects.equals(this.matchElement, objWafExcludeListEntry.matchElement)&&
  Objects.equals(this.uriPath, objWafExcludeListEntry.uriPath)&&
  Objects.equals(this.uriMatchCriteria, objWafExcludeListEntry.uriMatchCriteria);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class WafExcludeListEntry {\n");
      sb.append("    clientSubnet: ").append(toIndentedString(clientSubnet)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    matchElement: ").append(toIndentedString(matchElement)).append("\n");
        sb.append("    matchElementCriteria: ").append(toIndentedString(matchElementCriteria)).append("\n");
        sb.append("    uriMatchCriteria: ").append(toIndentedString(uriMatchCriteria)).append("\n");
        sb.append("    uriPath: ").append(toIndentedString(uriPath)).append("\n");
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

