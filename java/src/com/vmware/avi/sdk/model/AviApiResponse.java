package com.vmware.avi.sdk.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AviApiResponse<T> {
	@JsonProperty("count")
	private String count = null;

	@JsonProperty("results")
	private List<T> results = null;

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}
}
