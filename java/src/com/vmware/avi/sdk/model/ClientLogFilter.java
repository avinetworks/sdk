package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The ClientLogFilter is a POJO class extends AviRestResource that used for creating
 * ClientLogFilter.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientLogFilter  {
    @JsonProperty("all_headers")
    private Boolean allHeaders = false;

    @JsonProperty("client_ip")
    private IpAddrMatch clientIp = null;

    @JsonProperty("duration")
    private Integer duration = 30;

    @JsonProperty("enabled")
    private Boolean enabled = false;

    @JsonProperty("index")
    private Integer index = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("uri")
    private StringMatch uri = null;



  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property all_headers of obj type clientlogfilter field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return allHeaders
   */
  public Boolean getAllHeaders() {
    return allHeaders;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property all_headers of obj type clientlogfilter field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param allHeaders set the allHeaders.
   */
  public void setAllHeaders(Boolean  allHeaders) {
    this.allHeaders = allHeaders;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property client_ip of obj type clientlogfilter field type str  type ref.
   * @return clientIp
   */
  public IpAddrMatch getClientIp() {
    return clientIp;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property client_ip of obj type clientlogfilter field type str  type ref.
   * @param clientIp set the clientIp.
   */
  public void setClientIp(IpAddrMatch clientIp) {
    this.clientIp = clientIp;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Special values are 0 - 'infinite'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 30.
   * @return duration
   */
  public Integer getDuration() {
    return duration;
  }

  /**
   * This is the setter method to the attribute.
   * Special values are 0 - 'infinite'.
   * Default value when not specified in API or module is interpreted by Avi Controller as 30.
   * @param duration set the duration.
   */
  public void setDuration(Integer  duration) {
    this.duration = duration;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property enabled of obj type clientlogfilter field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @return enabled
   */
  public Boolean getEnabled() {
    return enabled;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property enabled of obj type clientlogfilter field type str  type boolean.
   * Default value when not specified in API or module is interpreted by Avi Controller as false.
   * @param enabled set the enabled.
   */
  public void setEnabled(Boolean  enabled) {
    this.enabled = enabled;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property index of obj type clientlogfilter field type str  type integer.
   * @return index
   */
  public Integer getIndex() {
    return index;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property index of obj type clientlogfilter field type str  type integer.
   * @param index set the index.
   */
  public void setIndex(Integer  index) {
    this.index = index;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Name of the object.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * This is the setter method to the attribute.
   * Name of the object.
   * @param name set the name.
   */
  public void setName(String  name) {
    this.name = name;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Placeholder for description of property uri of obj type clientlogfilter field type str  type ref.
   * @return uri
   */
  public StringMatch getUri() {
    return uri;
  }

  /**
   * This is the setter method to the attribute.
   * Placeholder for description of property uri of obj type clientlogfilter field type str  type ref.
   * @param uri set the uri.
   */
  public void setUri(StringMatch uri) {
    this.uri = uri;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  ClientLogFilter objClientLogFilter = (ClientLogFilter) o;
  return   Objects.equals(this.index, objClientLogFilter.index)&&
  Objects.equals(this.clientIp, objClientLogFilter.clientIp)&&
  Objects.equals(this.name, objClientLogFilter.name)&&
  Objects.equals(this.enabled, objClientLogFilter.enabled)&&
  Objects.equals(this.uri, objClientLogFilter.uri)&&
  Objects.equals(this.duration, objClientLogFilter.duration)&&
  Objects.equals(this.allHeaders, objClientLogFilter.allHeaders);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class ClientLogFilter {\n");
      sb.append("    allHeaders: ").append(toIndentedString(allHeaders)).append("\n");
        sb.append("    clientIp: ").append(toIndentedString(clientIp)).append("\n");
        sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
        sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
        sb.append("    index: ").append(toIndentedString(index)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
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

