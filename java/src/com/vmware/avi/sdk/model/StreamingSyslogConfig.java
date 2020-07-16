package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The StreamingSyslogConfig is a POJO class extends AviRestResource that used for creating
 * StreamingSyslogConfig.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StreamingSyslogConfig  {
    @JsonProperty("facility")
    private Integer facility = 16;

    @JsonProperty("filtered_log_severity")
    private Integer filteredLogSeverity = 5;

    @JsonProperty("hostname")
    private String hostname = "avivantage";

    @JsonProperty("non_significant_log_severity")
    private Integer nonSignificantLogSeverity = 6;

    @JsonProperty("significant_log_severity")
    private Integer significantLogSeverity = 4;



  /**
   * This is the getter method this will return the attribute value.
   * Facility value, as defined in rfc5424, must be between 0 and 23 inclusive.
   * Allowed values are 0-23.
   * Field introduced in 18.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 16.
   * @return facility
   */
  public Integer getFacility() {
    return facility;
  }

  /**
   * This is the setter method to the attribute.
   * Facility value, as defined in rfc5424, must be between 0 and 23 inclusive.
   * Allowed values are 0-23.
   * Field introduced in 18.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 16.
   * @param facility set the facility.
   */
  public void setFacility(Integer  facility) {
    this.facility = facility;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Severity code, as defined in rfc5424, for filtered logs.
   * This must be between 0 and 7 inclusive.
   * Allowed values are 0-7.
   * Field introduced in 18.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5.
   * @return filteredLogSeverity
   */
  public Integer getFilteredLogSeverity() {
    return filteredLogSeverity;
  }

  /**
   * This is the setter method to the attribute.
   * Severity code, as defined in rfc5424, for filtered logs.
   * This must be between 0 and 7 inclusive.
   * Allowed values are 0-7.
   * Field introduced in 18.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 5.
   * @param filteredLogSeverity set the filteredLogSeverity.
   */
  public void setFilteredLogSeverity(Integer  filteredLogSeverity) {
    this.filteredLogSeverity = filteredLogSeverity;
  }

  /**
   * This is the getter method this will return the attribute value.
   * String to use as the hostname in the syslog messages.
   * This string can contain only printable ascii characters (hex 21 to hex 7e; no space allowed).
   * Field introduced in 18.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as avivantage.
   * @return hostname
   */
  public String getHostname() {
    return hostname;
  }

  /**
   * This is the setter method to the attribute.
   * String to use as the hostname in the syslog messages.
   * This string can contain only printable ascii characters (hex 21 to hex 7e; no space allowed).
   * Field introduced in 18.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as avivantage.
   * @param hostname set the hostname.
   */
  public void setHostname(String  hostname) {
    this.hostname = hostname;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Severity code, as defined in rfc5424, for non-significant logs.
   * This must be between 0 and 7 inclusive.
   * Allowed values are 0-7.
   * Field introduced in 18.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 6.
   * @return nonSignificantLogSeverity
   */
  public Integer getNonSignificantLogSeverity() {
    return nonSignificantLogSeverity;
  }

  /**
   * This is the setter method to the attribute.
   * Severity code, as defined in rfc5424, for non-significant logs.
   * This must be between 0 and 7 inclusive.
   * Allowed values are 0-7.
   * Field introduced in 18.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 6.
   * @param nonSignificantLogSeverity set the nonSignificantLogSeverity.
   */
  public void setNonSignificantLogSeverity(Integer  nonSignificantLogSeverity) {
    this.nonSignificantLogSeverity = nonSignificantLogSeverity;
  }

  /**
   * This is the getter method this will return the attribute value.
   * Severity code, as defined in rfc5424, for significant logs.
   * This must be between 0 and 7 inclusive.
   * Allowed values are 0-7.
   * Field introduced in 18.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4.
   * @return significantLogSeverity
   */
  public Integer getSignificantLogSeverity() {
    return significantLogSeverity;
  }

  /**
   * This is the setter method to the attribute.
   * Severity code, as defined in rfc5424, for significant logs.
   * This must be between 0 and 7 inclusive.
   * Allowed values are 0-7.
   * Field introduced in 18.1.1.
   * Default value when not specified in API or module is interpreted by Avi Controller as 4.
   * @param significantLogSeverity set the significantLogSeverity.
   */
  public void setSignificantLogSeverity(Integer  significantLogSeverity) {
    this.significantLogSeverity = significantLogSeverity;
  }


@Override
public boolean equals(java.lang.Object o) {
  if (this == o) {
    return true;
  }
  if (o == null || getClass() != o.getClass()) {
    return false;
  }
  StreamingSyslogConfig objStreamingSyslogConfig = (StreamingSyslogConfig) o;
  return   Objects.equals(this.significantLogSeverity, objStreamingSyslogConfig.significantLogSeverity)&&
  Objects.equals(this.filteredLogSeverity, objStreamingSyslogConfig.filteredLogSeverity)&&
  Objects.equals(this.hostname, objStreamingSyslogConfig.hostname)&&
  Objects.equals(this.nonSignificantLogSeverity, objStreamingSyslogConfig.nonSignificantLogSeverity)&&
  Objects.equals(this.facility, objStreamingSyslogConfig.facility);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class StreamingSyslogConfig {\n");
      sb.append("    facility: ").append(toIndentedString(facility)).append("\n");
        sb.append("    filteredLogSeverity: ").append(toIndentedString(filteredLogSeverity)).append("\n");
        sb.append("    hostname: ").append(toIndentedString(hostname)).append("\n");
        sb.append("    nonSignificantLogSeverity: ").append(toIndentedString(nonSignificantLogSeverity)).append("\n");
        sb.append("    significantLogSeverity: ").append(toIndentedString(significantLogSeverity)).append("\n");
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

