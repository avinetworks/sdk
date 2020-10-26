package com.vmware.avi.sdk.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

/**
 * ControllerPortalRegistrationApiResponse
 */
public class ControllerPortalRegistrationApiResponse {
  @JsonProperty("count")
  private Integer count = null;

  @JsonProperty("results")
  private List<ControllerPortalRegistration> results = new ArrayList<ControllerPortalRegistration>();

  public ControllerPortalRegistrationApiResponse count(Integer count) {
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

  public ControllerPortalRegistrationApiResponse results(List<ControllerPortalRegistration> results) {
    this.results = results;
    return this;
  }

  public ControllerPortalRegistrationApiResponse addResultsItem(ControllerPortalRegistration resultsItem) {
    this.results.add(resultsItem);
    return this;
  }

  /**
   * Get results
   * @return results
  **/
  @Schema(required = true, description = "")
  public List<ControllerPortalRegistration> getResults() {
    return results;
  }

  public void setResults(List<ControllerPortalRegistration> results) {
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
    ControllerPortalRegistrationApiResponse controllerPortalRegistrationApiResponse = (ControllerPortalRegistrationApiResponse) o;
    return Objects.equals(this.count, controllerPortalRegistrationApiResponse.count) &&
        Objects.equals(this.results, controllerPortalRegistrationApiResponse.results);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, results);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ControllerPortalRegistrationApiResponse {\n");
    
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


