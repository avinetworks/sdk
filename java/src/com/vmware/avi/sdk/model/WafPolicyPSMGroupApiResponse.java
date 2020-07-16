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
 * WafPolicyPSMGroupApiResponse
 */
public class WafPolicyPSMGroupApiResponse {
  @JsonProperty("count")
  private Integer count = null;

  @JsonProperty("results")
  private List<WafPolicyPSMGroup> results = new ArrayList<WafPolicyPSMGroup>();

  public WafPolicyPSMGroupApiResponse count(Integer count) {
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

  public WafPolicyPSMGroupApiResponse results(List<WafPolicyPSMGroup> results) {
    this.results = results;
    return this;
  }

  public WafPolicyPSMGroupApiResponse addResultsItem(WafPolicyPSMGroup resultsItem) {
    this.results.add(resultsItem);
    return this;
  }

  /**
   * Get results
   * @return results
  **/
  @Schema(required = true, description = "")
  public List<WafPolicyPSMGroup> getResults() {
    return results;
  }

  public void setResults(List<WafPolicyPSMGroup> results) {
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
    WafPolicyPSMGroupApiResponse wafPolicyPSMGroupApiResponse = (WafPolicyPSMGroupApiResponse) o;
    return Objects.equals(this.count, wafPolicyPSMGroupApiResponse.count) &&
        Objects.equals(this.results, wafPolicyPSMGroupApiResponse.results);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, results);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WafPolicyPSMGroupApiResponse {\n");
    
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
