package com.vmware.avi.sdk.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The HTTPStatusMatch is a POJO class extends AviRestResource that used for creating
 * HTTPStatusMatch.
 *
 * @version 1.0
 * @since 
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HTTPStatusMatch  {
    @JsonProperty("match_criteria")
    private String matchCriteria = null;

    @JsonProperty("ranges")
    private List<HTTPStatusRange> ranges = null;

    @JsonProperty("status_codes")
    private List<Integer> statusCodes = null;



  /**
   * This is the getter method this will return the attribute value.
   * Criterion to use for matching the http response status code(s).
   * Enum options - IS_IN, IS_NOT_IN.
   * @return matchCriteria
   */
  public String getMatchCriteria() {
    return matchCriteria;
  }

  /**
   * This is the setter method to the attribute.
   * Criterion to use for matching the http response status code(s).
   * Enum options - IS_IN, IS_NOT_IN.
   * @param matchCriteria set the matchCriteria.
   */
  public void setMatchCriteria(String  matchCriteria) {
    this.matchCriteria = matchCriteria;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Http response status code range(s).
   * @return ranges
   */
  public List<HTTPStatusRange> getRanges() {
    return ranges;
  }

  /**
   * This is the setter method. this will set the ranges
   * Http response status code range(s).
   * @return ranges
   */
  public void setRanges(List<HTTPStatusRange>  ranges) {
    this.ranges = ranges;
  }

  /**
   * This is the setter method this will set the ranges
   * Http response status code range(s).
   * @return ranges
   */
  public HTTPStatusMatch addRangesItem(HTTPStatusRange rangesItem) {
    if (this.ranges == null) {
      this.ranges = new ArrayList<HTTPStatusRange>();
    }
    this.ranges.add(rangesItem);
    return this;
  }
  /**
   * This is the getter method this will return the attribute value.
   * Http response status code(s).
   * @return statusCodes
   */
  public List<Integer> getStatusCodes() {
    return statusCodes;
  }

  /**
   * This is the setter method. this will set the statusCodes
   * Http response status code(s).
   * @return statusCodes
   */
  public void setStatusCodes(List<Integer>  statusCodes) {
    this.statusCodes = statusCodes;
  }

  /**
   * This is the setter method this will set the statusCodes
   * Http response status code(s).
   * @return statusCodes
   */
  public HTTPStatusMatch addStatusCodesItem(Integer statusCodesItem) {
    if (this.statusCodes == null) {
      this.statusCodes = new ArrayList<Integer>();
    }
    this.statusCodes.add(statusCodesItem);
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
  HTTPStatusMatch objHTTPStatusMatch = (HTTPStatusMatch) o;
  return   Objects.equals(this.ranges, objHTTPStatusMatch.ranges)&&
  Objects.equals(this.statusCodes, objHTTPStatusMatch.statusCodes)&&
  Objects.equals(this.matchCriteria, objHTTPStatusMatch.matchCriteria);
}

@Override
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("class HTTPStatusMatch {\n");
      sb.append("    matchCriteria: ").append(toIndentedString(matchCriteria)).append("\n");
        sb.append("    ranges: ").append(toIndentedString(ranges)).append("\n");
        sb.append("    statusCodes: ").append(toIndentedString(statusCodes)).append("\n");
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

