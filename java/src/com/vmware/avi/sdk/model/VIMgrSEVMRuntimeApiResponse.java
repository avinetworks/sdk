package com.vmware.avi.sdk.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

/**
 * VIMgrSEVMRuntimeApiResponse
 */
public class VIMgrSEVMRuntimeApiResponse {
  @JsonProperty("count")
  private Integer count = null;

  @JsonProperty("results")
  private List<VIMgrSEVMRuntime> results = new ArrayList<VIMgrSEVMRuntime>();

  public VIMgrSEVMRuntimeApiResponse count(Integer count) {
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

  public VIMgrSEVMRuntimeApiResponse results(List<VIMgrSEVMRuntime> results) {
    this.results = results;
    return this;
  }

  public VIMgrSEVMRuntimeApiResponse addResultsItem(VIMgrSEVMRuntime resultsItem) {
    this.results.add(resultsItem);
    return this;
  }

  /**
   * Get results
   * @return results
  **/
  @Schema(required = true, description = "")
  public List<VIMgrSEVMRuntime> getResults() {
    return results;
  }

  public void setResults(List<VIMgrSEVMRuntime> results) {
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
    VIMgrSEVMRuntimeApiResponse vIMgrSEVMRuntimeApiResponse = (VIMgrSEVMRuntimeApiResponse) o;
    return Objects.equals(this.count, vIMgrSEVMRuntimeApiResponse.count) &&
        Objects.equals(this.results, vIMgrSEVMRuntimeApiResponse.results);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, results);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VIMgrSEVMRuntimeApiResponse {\n");
    
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


