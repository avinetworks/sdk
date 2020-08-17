package com.vmware.avi.sdk.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.vmware.avi.sdk.model.VirtualService;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

/**
 * TestSeDatastoreLevel3ApiResponse
 */
public class TestSeDatastoreLevel3ApiResponse {
  @JsonProperty("count")
  private Integer count = null;

  @JsonProperty("results")
  private List<TestSeDatastoreLevel3> results = new ArrayList<TestSeDatastoreLevel3>();

  public TestSeDatastoreLevel3ApiResponse count(Integer count) {
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

  public TestSeDatastoreLevel3ApiResponse results(List<TestSeDatastoreLevel3> results) {
    this.results = results;
    return this;
  }

  public TestSeDatastoreLevel3ApiResponse addResultsItem(TestSeDatastoreLevel3 resultsItem) {
    this.results.add(resultsItem);
    return this;
  }

  /**
   * Get results
   * @return results
  **/
  @Schema(required = true, description = "")
  public List<TestSeDatastoreLevel3> getResults() {
    return results;
  }

  public void setResults(List<TestSeDatastoreLevel3> results) {
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
    TestSeDatastoreLevel3ApiResponse testSeDatastoreLevel3ApiResponse = (TestSeDatastoreLevel3ApiResponse) o;
    return Objects.equals(this.count, testSeDatastoreLevel3ApiResponse.count) &&
        Objects.equals(this.results, testSeDatastoreLevel3ApiResponse.results);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, results);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TestSeDatastoreLevel3ApiResponse {\n");
    
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
