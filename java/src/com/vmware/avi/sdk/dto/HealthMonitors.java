package com.vmware.avi.sdk.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "count", "results" })
public class HealthMonitors implements Serializable {

	@JsonProperty("count")
	private Integer count;
	@JsonProperty("results")
	@Valid
	private List<HealthMonitor> results = null;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 1718964133309428196L;

	@JsonProperty("count")
	public Integer getCount() {
		return count;
	}

	@JsonProperty("count")
	public void setCount(Integer count) {
		this.count = count;
	}

	public HealthMonitors withCount(Integer count) {
		this.count = count;
		return this;
	}

	@JsonProperty("results")
	public List<HealthMonitor> getResults() {
		return results;
	}

	@JsonProperty("results")
	public void setResults(List<HealthMonitor> results) {
		this.results = results;
	}

	public HealthMonitors withResults(List<HealthMonitor> results) {
		this.results = results;
		return this;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public HealthMonitors withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("count", count).append("results", results)
				.append("additionalProperties", additionalProperties).toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(count).append(additionalProperties).append(results).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof HealthMonitors) == false) {
			return false;
		}
		HealthMonitors rhs = ((HealthMonitors) other);
		return new EqualsBuilder().append(count, rhs.count).append(additionalProperties, rhs.additionalProperties)
				.append(results, rhs.results).isEquals();
	}

}