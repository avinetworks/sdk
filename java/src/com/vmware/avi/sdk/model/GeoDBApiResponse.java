package com.vmware.avi.sdk.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

/**
 * GeoDBApiResponse
 */
public class GeoDBApiResponse {
  @JsonProperty("count")
  private Integer count = null;

  @JsonProperty("results")
  private List<GeoDB> results = new ArrayList<GeoDB>();

  public GeoDBApiResponse count(Integer count) {
    this.count = count;
    return this;
  }

  /**
   * Get count
   * @return count
  **/
  @Schema(required = true, description = "")
  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public GeoDBApiResponse results(List<GeoDB> results) {
    this.results = results;
    return this;
  }

  public GeoDBApiResponse addResultsItem(GeoDB resultsItem) {
    this.results.add(resultsItem);
    return this;
  }

  /**
   * Get results
   * @return results
  **/
  @Schema(required = true, description = "")
  public List<GeoDB> getResults() {
    return results;
  }

  public void setResults(List<GeoDB> results) {
    this.results = results;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeoDBApiResponse geoDBApiResponse = (GeoDBApiResponse) o;
    return Objects.equals(this.count, geoDBApiResponse.count) &&
        Objects.equals(this.results, geoDBApiResponse.results);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, results);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeoDBApiResponse {\n");
    
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    results: ").append(toIndentedString(results)).append("\n");
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


