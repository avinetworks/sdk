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
 * PoolGroupDeploymentPolicyApiResponse
 */
public class PoolGroupDeploymentPolicyApiResponse {
  @JsonProperty("count")
  private Integer count = null;

  @JsonProperty("results")
  private List<PoolGroupDeploymentPolicy> results = new ArrayList<PoolGroupDeploymentPolicy>();

  public PoolGroupDeploymentPolicyApiResponse count(Integer count) {
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

  public PoolGroupDeploymentPolicyApiResponse results(List<PoolGroupDeploymentPolicy> results) {
    this.results = results;
    return this;
  }

  public PoolGroupDeploymentPolicyApiResponse addResultsItem(PoolGroupDeploymentPolicy resultsItem) {
    this.results.add(resultsItem);
    return this;
  }

  /**
   * Get results
   * @return results
  **/
  @Schema(required = true, description = "")
  public List<PoolGroupDeploymentPolicy> getResults() {
    return results;
  }

  public void setResults(List<PoolGroupDeploymentPolicy> results) {
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
    PoolGroupDeploymentPolicyApiResponse poolGroupDeploymentPolicyApiResponse = (PoolGroupDeploymentPolicyApiResponse) o;
    return Objects.equals(this.count, poolGroupDeploymentPolicyApiResponse.count) &&
        Objects.equals(this.results, poolGroupDeploymentPolicyApiResponse.results);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, results);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PoolGroupDeploymentPolicyApiResponse {\n");
    
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
